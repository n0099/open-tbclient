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
/* loaded from: classes4.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f dec = com.baidu.tieba.sdk.d.a.ddW().dec();
        if (dec != null) {
            if (customMessage.getData() instanceof r) {
                r rVar = (r) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(rVar.azj, shareEntity);
                f(shareEntity);
                dec.a(rVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                dec.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
            }
        }
        return null;
    }

    private void a(q qVar, ShareEntity shareEntity) {
        if (qVar != null && shareEntity != null) {
            shareEntity.userId = qVar.ayC.userId;
            shareEntity.userName = qVar.ayC.userName;
            if (qVar.ayW != null && !TextUtils.isEmpty(qVar.ayW.ayU)) {
                shareEntity.title = qVar.ayW.ayU;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (qVar.ayW != null && !TextUtils.isEmpty(qVar.ayW.subTitle)) {
                shareEntity.content = qVar.ayW.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (qVar.ayW != null && !TextUtils.isEmpty(qVar.ayW.imgUrl)) {
                shareEntity.imageUrl = qVar.ayW.imgUrl;
            } else {
                shareEntity.imageUrl = qVar.mLiveInfo.cover;
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
