package com.baidu.tieba.sdk.f;

import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.i;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.tieba.sdk.a.f;
/* loaded from: classes6.dex */
public class a implements CustomMessageTask.CustomRunnable {
    @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage customMessage) {
        f chG = com.baidu.tieba.sdk.c.a.chB().chG();
        if (chG != null) {
            if (customMessage.getData() instanceof i) {
                ShareEntity shareEntity = new ShareEntity();
                a((i) customMessage.getData(), shareEntity);
                chG.e(shareEntity);
            } else if (customMessage.getData() instanceof ShareEntity) {
                chG.e((ShareEntity) customMessage.getData());
            }
        }
        return null;
    }

    private void a(i iVar, ShareEntity shareEntity) {
        if (iVar != null && shareEntity != null) {
            shareEntity.userId = iVar.Ps.userId;
            shareEntity.userName = iVar.Ps.userName;
            shareEntity.title = StringUtils.isNull(shareEntity.userName) ? "" : shareEntity.userName + "的直播";
            shareEntity.content = "精彩直播正在进行，邀请你速来围观。";
            String str = iVar.mLiveInfo.cover;
            if (str != null && !str.contains(".jpg")) {
                str = str + ".jpg";
            }
            shareEntity.imageUrl = str;
            shareEntity.linkUrl = iVar.mLiveInfo.share_url;
        }
    }
}
