package com.baidu.tieba.sdk.f;

import android.text.TextUtils;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.n;
import com.baidu.live.data.o;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.sdk.a.f;
/* loaded from: classes3.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f cPl = com.baidu.tieba.sdk.c.a.cPg().cPl();
        if (cPl != null) {
            if (customMessage.getData() instanceof o) {
                o oVar = (o) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(oVar.aqQ, shareEntity);
                f(shareEntity);
                cPl.a(oVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                cPl.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
            }
        }
        return null;
    }

    private void a(n nVar, ShareEntity shareEntity) {
        if (nVar != null && shareEntity != null) {
            shareEntity.userId = nVar.aqk.userId;
            shareEntity.userName = nVar.aqk.userName;
            if (nVar.aqE != null && !TextUtils.isEmpty(nVar.aqE.aqC)) {
                shareEntity.title = nVar.aqE.aqC;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (nVar.aqE != null && !TextUtils.isEmpty(nVar.aqE.subTitle)) {
                shareEntity.content = nVar.aqE.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (nVar.aqE != null && !TextUtils.isEmpty(nVar.aqE.imgUrl)) {
                shareEntity.imageUrl = nVar.aqE.imgUrl;
            } else {
                String str = nVar.mLiveInfo.cover;
                if (str != null && !str.contains(".jpg")) {
                    str = str + ".jpg";
                }
                shareEntity.imageUrl = str;
            }
            shareEntity.linkUrl = nVar.mLiveInfo.share_url;
            shareEntity.liveId = nVar.mLiveInfo.live_id;
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
