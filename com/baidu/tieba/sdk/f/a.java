package com.baidu.tieba.sdk.f;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.tieba.sdk.a.f;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f cEM = com.baidu.tieba.sdk.c.a.cEH().cEM();
        if (cEM != null) {
            if (customMessage.getData() instanceof n) {
                n nVar = (n) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(nVar.YA, shareEntity);
                cEM.a(nVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                cEM.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
            }
        }
        return null;
    }

    private void a(m mVar, ShareEntity shareEntity) {
        if (mVar != null && shareEntity != null) {
            shareEntity.userId = mVar.Ya.userId;
            shareEntity.userName = mVar.Ya.userName;
            if (mVar.Yp != null && !TextUtils.isEmpty(mVar.Yp.Yn)) {
                shareEntity.title = mVar.Yp.Yn;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (mVar.Yp != null && !TextUtils.isEmpty(mVar.Yp.subTitle)) {
                shareEntity.content = mVar.Yp.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (mVar.Yp != null && !TextUtils.isEmpty(mVar.Yp.imgUrl)) {
                shareEntity.imageUrl = mVar.Yp.imgUrl;
            } else {
                String str = mVar.mLiveInfo.cover;
                if (str != null && !str.contains(".jpg")) {
                    str = str + ".jpg";
                }
                shareEntity.imageUrl = str;
            }
            shareEntity.linkUrl = mVar.mLiveInfo.share_url;
        }
    }
}
