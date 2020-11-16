package com.baidu.tieba.sdk.g;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.w;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.sdk.b.e;
/* loaded from: classes4.dex */
public class b implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        e dCi = com.baidu.tieba.sdk.d.a.dCa().dCi();
        if (dCi != null) {
            if (customMessage.getData() instanceof x) {
                x xVar = (x) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(xVar.alaLiveShowData, shareEntity);
                f(shareEntity);
                if (ax(xVar.activity)) {
                    dCi.a(xVar.activity, shareEntity);
                }
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                ShareEntity shareEntity2 = shareEntityWrapperData.shareEntity;
                if (shareEntity2.sharePanel()) {
                    if (ax(shareEntityWrapperData.activity)) {
                        dCi.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
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
                        if (ax(shareEntityWrapperData.activity)) {
                            dCi.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean ax(Activity activity) {
        if (activity == null || com.baidu.tieba.sdk.d.a.dCa().dCi() == null || com.baidu.tieba.sdk.d.a.dCa().dCi().das() || UtilHelper.getRealScreenOrientation(activity) != 2) {
            return true;
        }
        BdUtilHelper.showToast(activity, "暂不支持分享");
        return false;
    }

    private void a(w wVar, ShareEntity shareEntity) {
        if (wVar != null && shareEntity != null) {
            shareEntity.userId = wVar.aHk.userId;
            shareEntity.userName = wVar.aHk.userName;
            if (wVar.aHH != null && !TextUtils.isEmpty(wVar.aHH.aHF)) {
                shareEntity.title = wVar.aHH.aHF;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (wVar.aHH != null && !TextUtils.isEmpty(wVar.aHH.subTitle)) {
                shareEntity.content = wVar.aHH.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (wVar.aHH != null && !TextUtils.isEmpty(wVar.aHH.imgUrl)) {
                shareEntity.imageUrl = wVar.aHH.imgUrl;
            } else {
                shareEntity.imageUrl = wVar.mLiveInfo.cover;
            }
            shareEntity.linkUrl = wVar.mLiveInfo.share_url;
            shareEntity.liveId = wVar.mLiveInfo.live_id;
        }
    }

    private void f(ShareEntity shareEntity) {
        if (!TextUtils.isEmpty(shareEntity.imageUrl) && shareEntity.imageUrl.contains(UgcConstant.AT_RULE_TAG)) {
            try {
                shareEntity.imageUrl = shareEntity.imageUrl.substring(0, shareEntity.imageUrl.indexOf(UgcConstant.AT_RULE_TAG));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
