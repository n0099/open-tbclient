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
        f cPo = com.baidu.tieba.sdk.c.a.cPj().cPo();
        if (cPo != null) {
            if (customMessage.getData() instanceof o) {
                o oVar = (o) customMessage.getData();
                ShareEntity shareEntity = new ShareEntity();
                a(oVar.aqK, shareEntity);
                f(shareEntity);
                cPo.a(oVar.activity, shareEntity);
            } else if (customMessage.getData() instanceof ShareEntityWrapperData) {
                ShareEntityWrapperData shareEntityWrapperData = (ShareEntityWrapperData) customMessage.getData();
                f(shareEntityWrapperData.shareEntity);
                cPo.a(shareEntityWrapperData.activity, shareEntityWrapperData.shareEntity);
            }
        }
        return null;
    }

    private void a(n nVar, ShareEntity shareEntity) {
        if (nVar != null && shareEntity != null) {
            shareEntity.userId = nVar.aqe.userId;
            shareEntity.userName = nVar.aqe.userName;
            if (nVar.aqy != null && !TextUtils.isEmpty(nVar.aqy.aqw)) {
                shareEntity.title = nVar.aqy.aqw;
            } else {
                shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            }
            if (nVar.aqy != null && !TextUtils.isEmpty(nVar.aqy.subTitle)) {
                shareEntity.content = nVar.aqy.subTitle;
            } else {
                shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            }
            if (nVar.aqy != null && !TextUtils.isEmpty(nVar.aqy.imgUrl)) {
                shareEntity.imageUrl = nVar.aqy.imgUrl;
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
