package com.baidu.tieba.sdk.g;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ab;
import com.baidu.live.data.ac;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.tieba.sdk.b.e;
/* loaded from: classes11.dex */
public class b implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        e dFK = com.baidu.tieba.sdk.d.a.dFB().dFK();
        if (dFK != null) {
            if (customMessage.getData() instanceof ac) {
                ac acVar = (ac) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(acVar.alaLiveShowData, shareEntity);
                f(shareEntity);
                if (au(acVar.activity)) {
                    dFK.a(acVar.activity, shareEntity);
                }
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                ShareEntity shareEntity2 = shareEntityWrapperData.shareEntity;
                if (shareEntity2.sharePanel()) {
                    if (au(shareEntityWrapperData.activity)) {
                        dFK.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
                    }
                } else {
                    try {
                        IShareChannel buildShareChannel = ShareSingleManager.getInstance().buildShareChannel();
                        if (buildShareChannel != null) {
                            if (shareEntity2.shareToQQ()) {
                                buildShareChannel.shareToQQ(shareEntity2, null);
                            } else if (shareEntity2.shareToSinaWeibo()) {
                                buildShareChannel.shareToSinaWeibo(shareEntity2, null);
                            } else if (shareEntity2.shareToWeixin()) {
                                buildShareChannel.shareToWeixin(shareEntity2, null);
                            } else if (shareEntity2.shareToWeixinCircle()) {
                                buildShareChannel.shareToWeixinCircle(shareEntity2, null);
                            }
                        }
                    } catch (Exception e) {
                        if (au(shareEntityWrapperData.activity)) {
                            dFK.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean au(Activity activity) {
        if (activity == null || com.baidu.tieba.sdk.d.a.dFB().dFK() == null || com.baidu.tieba.sdk.d.a.dFB().dFK().ddF() || UtilHelper.getRealScreenOrientation(activity) != 2) {
            return true;
        }
        BdUtilHelper.showToast(activity, "暂不支持分享");
        return false;
    }

    private void a(ab abVar, ShareEntity shareEntity) {
        if (abVar != null && shareEntity != null) {
            shareEntity.userId = abVar.aId.userId;
            shareEntity.userName = abVar.aId.userName;
            if (abVar.aIA != null && !TextUtils.isEmpty(abVar.aIA.aIy)) {
                shareEntity.title = abVar.aIA.aIy;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (abVar.aIA != null && !TextUtils.isEmpty(abVar.aIA.subTitle)) {
                shareEntity.content = abVar.aIA.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (abVar.aIA != null && !TextUtils.isEmpty(abVar.aIA.imgUrl)) {
                shareEntity.imageUrl = abVar.aIA.imgUrl;
            } else {
                shareEntity.imageUrl = abVar.mLiveInfo.cover;
            }
            shareEntity.linkUrl = abVar.mLiveInfo.share_url;
            shareEntity.liveId = abVar.mLiveInfo.live_id;
        }
    }

    private void f(ShareEntity shareEntity) {
        if (!TextUtils.isEmpty(shareEntity.imageUrl) && shareEntity.imageUrl.contains("@")) {
            try {
                shareEntity.imageUrl = shareEntity.imageUrl.substring(0, shareEntity.imageUrl.indexOf("@"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
