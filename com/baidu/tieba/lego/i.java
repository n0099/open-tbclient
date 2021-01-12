package com.baidu.tieba.lego;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.m;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
/* loaded from: classes8.dex */
public class i implements e {
    final aq kRQ;

    private i(BaseLegoCardInfo baseLegoCardInfo) {
        this(baseLegoCardInfo.getStatistics(), baseLegoCardInfo.getStatTab(), baseLegoCardInfo.getCardType(), baseLegoCardInfo.getItemId());
    }

    private i(String str, int i, int i2, String str2) {
        this.kRQ = new aq(str);
        this.kRQ.an("obj_source", i);
        this.kRQ.an("obj_type", i2);
        if (!TextUtils.isEmpty(str2)) {
            this.kRQ.dW("obj_card", str2);
        }
    }

    @Override // com.baidu.tieba.lego.e
    public void a(ICardInfo iCardInfo) {
        b(iCardInfo);
        TiebaStatic.log(this.kRQ);
    }

    @Override // com.baidu.tieba.lego.e
    public e fF(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.kRQ.dW(str, str2);
        }
        return this;
    }

    @Override // com.baidu.tieba.lego.e
    public e bz(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.kRQ.an(str, i);
        }
        return this;
    }

    @Override // com.baidu.tieba.lego.e
    public e O(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.kRQ.dW(str, String.valueOf(j));
        }
        return this;
    }

    private void b(ICardInfo iCardInfo) {
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) iCardInfo;
        if (!TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) && !TextUtils.isEmpty(baseLegoCardInfo.getsExtras())) {
            List<Object> params = this.kRQ.getParams();
            for (String str : baseLegoCardInfo.getsExtras().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    String str2 = split[0];
                    String str3 = split[1];
                    boolean z = false;
                    for (int i = 0; i < params.size() && !z; i += 2) {
                        if (TextUtils.equals(str2, params.get(i).toString())) {
                            if (i + 1 < params.size()) {
                                params.set(i + 1, str3);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        this.kRQ.dW(str2, str3);
                    }
                }
            }
            fF(TiebaInitialize.Params.OBJ_PARAM3, m.cra());
        }
    }

    public static e a(BaseLegoCardInfo baseLegoCardInfo) {
        return baseLegoCardInfo != null && !TextUtils.isEmpty(baseLegoCardInfo.getStatistics()) ? new i(baseLegoCardInfo) : new a();
    }

    public static e d(String str, int i, int i2, String str2) {
        return !TextUtils.isEmpty(str) ? new i(str, i, i2, str2) : new a();
    }

    /* loaded from: classes8.dex */
    private static class a implements e {
        private a() {
        }

        @Override // com.baidu.tieba.lego.e
        public void a(ICardInfo iCardInfo) {
        }

        @Override // com.baidu.tieba.lego.e
        public e fF(String str, String str2) {
            return this;
        }

        @Override // com.baidu.tieba.lego.e
        public e bz(String str, int i) {
            return this;
        }

        @Override // com.baidu.tieba.lego.e
        public e O(String str, long j) {
            return this;
        }
    }
}
