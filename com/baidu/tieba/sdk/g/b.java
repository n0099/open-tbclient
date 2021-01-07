package com.baidu.tieba.sdk.g;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.x;
import com.baidu.live.data.y;
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
        e dHl = com.baidu.tieba.sdk.d.a.dHc().dHl();
        if (dHl != null) {
            if (customMessage.getData() instanceof y) {
                y yVar = (y) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(yVar.alaLiveShowData, shareEntity);
                f(shareEntity);
                if (aB(yVar.activity)) {
                    dHl.a(yVar.activity, shareEntity);
                }
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                ShareEntity shareEntity2 = shareEntityWrapperData.shareEntity;
                if (shareEntity2.sharePanel()) {
                    if (aB(shareEntityWrapperData.activity)) {
                        dHl.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
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
                        if (aB(shareEntityWrapperData.activity)) {
                            dHl.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
                        }
                    }
                }
            }
        }
        return null;
    }

    private boolean aB(Activity activity) {
        if (activity == null || com.baidu.tieba.sdk.d.a.dHc().dHl() == null || com.baidu.tieba.sdk.d.a.dHc().dHl().dfs() || UtilHelper.getRealScreenOrientation(activity) != 2) {
            return true;
        }
        BdUtilHelper.showToast(activity, "暂不支持分享");
        return false;
    }

    private void a(x xVar, ShareEntity shareEntity) {
        if (xVar != null && shareEntity != null) {
            shareEntity.userId = xVar.aKu.userId;
            shareEntity.userName = xVar.aKu.userName;
            if (xVar.aKR != null && !TextUtils.isEmpty(xVar.aKR.aKP)) {
                shareEntity.title = xVar.aKR.aKP;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (xVar.aKR != null && !TextUtils.isEmpty(xVar.aKR.subTitle)) {
                shareEntity.content = xVar.aKR.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (xVar.aKR != null && !TextUtils.isEmpty(xVar.aKR.imgUrl)) {
                shareEntity.imageUrl = xVar.aKR.imgUrl;
            } else {
                shareEntity.imageUrl = xVar.mLiveInfo.cover;
            }
            shareEntity.linkUrl = xVar.mLiveInfo.share_url;
            shareEntity.liveId = xVar.mLiveInfo.live_id;
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
