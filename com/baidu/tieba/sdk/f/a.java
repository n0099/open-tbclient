package com.baidu.tieba.sdk.f;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.sdk.a.f;
/* loaded from: classes2.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f cBH = com.baidu.tieba.sdk.c.a.cBC().cBH();
        if (cBH != null) {
            if (customMessage.getData() instanceof k) {
                ShareEntity shareEntity = new ShareEntity();
                a((k) customMessage.getData(), shareEntity);
                cBH.e(shareEntity);
            } else if (customMessage.getData() instanceof ShareEntity) {
                cBH.e((ShareEntity) customMessage.getData());
            }
        }
        return null;
    }

    private void a(k kVar, ShareEntity shareEntity) {
        if (kVar != null && shareEntity != null) {
            shareEntity.userId = kVar.VP.userId;
            shareEntity.userName = kVar.VP.userName;
            shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            String str = kVar.mLiveInfo.cover;
            if (str != null && !str.contains(".jpg")) {
                str = str + ".jpg";
            }
            shareEntity.imageUrl = str;
            shareEntity.linkUrl = kVar.mLiveInfo.share_url;
        }
    }
}
