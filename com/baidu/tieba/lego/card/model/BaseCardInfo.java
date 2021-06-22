package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.a.o0.k1.m.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BaseCardInfo extends BaseLegoCardInfo {
    public BaseCardInfo(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getFidFromPostUrl(String str) {
        return !TextUtils.isEmpty(str) ? b.C1469b.a(str).d("fid") : "";
    }

    public String getTouidFromPostUrl(String str) {
        return !TextUtils.isEmpty(str) ? b.C1469b.a(str).d("touid") : "";
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public final boolean responseAttention(Object obj) {
        if (shouldResponseAttention()) {
            if (obj instanceof UpdateAttentionMessage.a) {
                UpdateAttentionMessage.a aVar = (UpdateAttentionMessage.a) obj;
                return responseAttentionUser(aVar.f12720c, aVar.f12721d);
            } else if (obj instanceof d.a.o0.k1.p.b) {
                d.a.o0.k1.p.b bVar = (d.a.o0.k1.p.b) obj;
                return responseAttentionForum(bVar.f60553a, bVar.f60554b);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean responseAttentionForum(String str, boolean z) {
        return false;
    }

    public boolean responseAttentionUser(String str, boolean z) {
        return false;
    }

    public boolean shouldResponseAttention() {
        return false;
    }
}
