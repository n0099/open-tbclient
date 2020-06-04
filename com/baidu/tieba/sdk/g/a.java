package com.baidu.tieba.sdk.g;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.sdk.b.f;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f cWF = com.baidu.tieba.sdk.d.a.cWz().cWF();
        if (cWF != null) {
            if (customMessage.getData() instanceof r) {
                r rVar = (r) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(rVar.avQ, shareEntity);
                f(shareEntity);
                cWF.a(rVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                cWF.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
            }
        }
        return null;
    }

    private void a(q qVar, ShareEntity shareEntity) {
        if (qVar != null && shareEntity != null) {
            shareEntity.userId = qVar.avj.userId;
            shareEntity.userName = qVar.avj.userName;
            if (qVar.avD != null && !TextUtils.isEmpty(qVar.avD.avB)) {
                shareEntity.title = qVar.avD.avB;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (qVar.avD != null && !TextUtils.isEmpty(qVar.avD.subTitle)) {
                shareEntity.content = qVar.avD.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (qVar.avD != null && !TextUtils.isEmpty(qVar.avD.imgUrl)) {
                shareEntity.imageUrl = qVar.avD.imgUrl;
            } else {
                String str = qVar.mLiveInfo.cover;
                if (str != null && !str.contains(".jpg")) {
                    str = str + ".jpg";
                }
                shareEntity.imageUrl = str;
            }
            shareEntity.linkUrl = qVar.mLiveInfo.share_url;
            shareEntity.liveId = qVar.mLiveInfo.live_id;
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
