package com.baidu.tieba.sdk.g;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.u;
import com.baidu.live.data.v;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.live.tbadk.share.single.ShareSingleManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannel;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.sdk.b.f;
/* loaded from: classes4.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f dtj = com.baidu.tieba.sdk.d.a.dtb().dtj();
        if (dtj != null) {
            if (customMessage.getData() instanceof v) {
                v vVar = (v) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(vVar.alaLiveShowData, shareEntity);
                f(shareEntity);
                dtj.a(vVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                ShareEntity shareEntity2 = shareEntityWrapperData.shareEntity;
                if (shareEntity2.sharePanel()) {
                    dtj.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
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
                        dtj.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
                    }
                }
            }
        }
        return null;
    }

    private void a(u uVar, ShareEntity shareEntity) {
        if (uVar != null && shareEntity != null) {
            shareEntity.userId = uVar.aEz.userId;
            shareEntity.userName = uVar.aEz.userName;
            if (uVar.aFc != null && !TextUtils.isEmpty(uVar.aFc.aFa)) {
                shareEntity.title = uVar.aFc.aFa;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (uVar.aFc != null && !TextUtils.isEmpty(uVar.aFc.subTitle)) {
                shareEntity.content = uVar.aFc.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (uVar.aFc != null && !TextUtils.isEmpty(uVar.aFc.imgUrl)) {
                shareEntity.imageUrl = uVar.aFc.imgUrl;
            } else {
                shareEntity.imageUrl = uVar.mLiveInfo.cover;
            }
            shareEntity.linkUrl = uVar.mLiveInfo.share_url;
            shareEntity.liveId = uVar.mLiveInfo.live_id;
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
