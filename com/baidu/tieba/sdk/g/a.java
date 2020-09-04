package com.baidu.tieba.sdk.g;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.r;
import com.baidu.live.data.s;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.sdk.b.f;
/* loaded from: classes7.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f dpx = com.baidu.tieba.sdk.d.a.dpr().dpx();
        if (dpx != null) {
            if (customMessage.getData() instanceof s) {
                s sVar = (s) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(sVar.aEv, shareEntity);
                f(shareEntity);
                dpx.a(sVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                ShareEntity shareEntity2 = shareEntityWrapperData.shareEntity;
                if (shareEntity2.sharePanel()) {
                    dpx.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
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
                        dpx.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
                    }
                }
            }
        }
        return null;
    }

    private void a(r rVar, ShareEntity shareEntity) {
        if (rVar != null && shareEntity != null) {
            shareEntity.userId = rVar.aDG.userId;
            shareEntity.userName = rVar.aDG.userName;
            if (rVar.aEg != null && !TextUtils.isEmpty(rVar.aEg.aEe)) {
                shareEntity.title = rVar.aEg.aEe;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (rVar.aEg != null && !TextUtils.isEmpty(rVar.aEg.subTitle)) {
                shareEntity.content = rVar.aEg.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (rVar.aEg != null && !TextUtils.isEmpty(rVar.aEg.imgUrl)) {
                shareEntity.imageUrl = rVar.aEg.imgUrl;
            } else {
                shareEntity.imageUrl = rVar.mLiveInfo.cover;
            }
            shareEntity.linkUrl = rVar.mLiveInfo.share_url;
            shareEntity.liveId = rVar.mLiveInfo.live_id;
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
