package com.baidu.tieba.sdk.f;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.l;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.tieba.sdk.a.f;
/* loaded from: classes2.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f cCM = com.baidu.tieba.sdk.c.a.cCH().cCM();
        if (cCM != null) {
            if (customMessage.getData() instanceof m) {
                m mVar = (m) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(mVar.WE, shareEntity);
                cCM.a(mVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                cCM.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
            }
        }
        return null;
    }

    private void a(l lVar, ShareEntity shareEntity) {
        if (lVar != null && shareEntity != null) {
            shareEntity.userId = lVar.Wf.userId;
            shareEntity.userName = lVar.Wf.userName;
            if (lVar.Wu != null && !TextUtils.isEmpty(lVar.Wu.Ws)) {
                shareEntity.title = lVar.Wu.Ws;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (lVar.Wu != null && !TextUtils.isEmpty(lVar.Wu.subTitle)) {
                shareEntity.content = lVar.Wu.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (lVar.Wu != null && !TextUtils.isEmpty(lVar.Wu.imgUrl)) {
                shareEntity.imageUrl = lVar.Wu.imgUrl;
            } else {
                String str = lVar.mLiveInfo.cover;
                if (str != null && !str.contains(".jpg")) {
                    str = str + ".jpg";
                }
                shareEntity.imageUrl = str;
            }
            shareEntity.linkUrl = lVar.mLiveInfo.share_url;
        }
    }
}
