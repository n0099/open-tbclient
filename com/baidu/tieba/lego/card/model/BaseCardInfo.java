package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import d.b.i0.i1.m.b;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BaseCardInfo extends BaseLegoCardInfo {
    public BaseCardInfo(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getFidFromPostUrl(String str) {
        return !TextUtils.isEmpty(str) ? b.C1301b.a(str).d("fid") : "";
    }

    public String getTouidFromPostUrl(String str) {
        return !TextUtils.isEmpty(str) ? b.C1301b.a(str).d("touid") : "";
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public final boolean responseAttention(Object obj) {
        if (shouldResponseAttention()) {
            if (obj instanceof UpdateAttentionMessage.a) {
                UpdateAttentionMessage.a aVar = (UpdateAttentionMessage.a) obj;
                return responseAttentionUser(aVar.f13695c, aVar.f13696d);
            } else if (obj instanceof d.b.i0.i1.p.b) {
                d.b.i0.i1.p.b bVar = (d.b.i0.i1.p.b) obj;
                return responseAttentionForum(bVar.f56013a, bVar.f56014b);
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
