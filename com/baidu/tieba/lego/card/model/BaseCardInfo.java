package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.lego.a.b;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BaseCardInfo extends BaseLegoCardInfo {
    public BaseCardInfo(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public final boolean responseAttention(Object obj) {
        if (shouldResponseAttention()) {
            if (obj instanceof UpdateAttentionMessage.a) {
                UpdateAttentionMessage.a aVar = (UpdateAttentionMessage.a) obj;
                return responseAttentionUser(aVar.toUid, aVar.isAttention);
            } else if (obj instanceof com.baidu.tieba.lego.c.b) {
                com.baidu.tieba.lego.c.b bVar = (com.baidu.tieba.lego.c.b) obj;
                return responseAttentionForum(bVar.fid, bVar.eNy);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldResponseAttention() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean responseAttentionUser(String str, boolean z) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean responseAttentionForum(String str, boolean z) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTouidFromPostUrl(String str) {
        return !TextUtils.isEmpty(str) ? b.a.ML(str).MK("touid") : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFidFromPostUrl(String str) {
        return !TextUtils.isEmpty(str) ? b.a.ML(str).MK("fid") : "";
    }
}
