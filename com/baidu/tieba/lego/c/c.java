package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes2.dex */
public class c implements a {
    private String gGp;
    private String gGq;
    List<d> gGr;
    private final e gKP;
    private int gKR;
    private boolean hasMore;
    private String rank;
    private String title;
    private List<ICardInfo> gKQ = new ArrayList();
    private int pn = 1;
    private boolean gKS = false;
    private boolean gKT = false;
    private boolean gKU = false;

    public c(e eVar) {
        this.gKP = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> bAZ() {
        return this.gKQ;
    }

    public void vb(int i) {
        this.gKR = i;
    }

    public int bBa() {
        return this.gKR;
    }

    public boolean bBb() {
        return this.gKS;
    }

    public boolean bBc() {
        return this.gKT;
    }

    public e bBd() {
        return this.gKP;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String bBe() {
        return this.rank;
    }

    public void yh(String str) {
        this.rank = str;
    }

    public String bBf() {
        return this.gGp;
    }

    public String getTitle() {
        return this.title;
    }

    public String bBg() {
        return this.gGq;
    }

    public List<d> bBh() {
        return this.gGr;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.gKT = true;
        } else {
            this.gKS = true;
        }
        DataRes dataRes = (DataRes) message;
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (!TextUtils.isEmpty(dataRes.page_info)) {
                try {
                    JSONObject jSONObject = new JSONObject(dataRes.page_info);
                    JSONObject optJSONObject = jSONObject.optJSONObject("title");
                    if (optJSONObject != null) {
                        this.title = optJSONObject.optString("name");
                        this.gGp = optJSONObject.optString("url");
                        this.gGq = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.gGr == null) {
                            this.gGr = new ArrayList();
                        } else {
                            this.gGr.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.gGr.add(dVar);
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (dataRes.cards != null) {
                for (int i3 = 0; i3 < dataRes.cards.size(); i3++) {
                    ICardInfo xX = com.baidu.tieba.lego.card.b.xX(dataRes.cards.get(i3));
                    if (xX != null && xX.isValid()) {
                        arrayList.add(xX);
                    }
                    if (i3 == dataRes.cards.size() - 1 && xX != null) {
                        yh(xX.getFlipId());
                    }
                }
            }
            if (z2) {
                this.gKQ.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.gKQ = arrayList;
        }
    }

    public void yi(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.gGp = optJSONObject.optString("url");
                    this.gGq = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.gGr == null) {
                        this.gGr = new ArrayList();
                    } else {
                        this.gGr.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.gGr.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo xX = com.baidu.tieba.lego.card.b.xX(optJSONArray2.getString(i2));
                    if (xX != null && xX.isValid()) {
                        arrayList.add(xX);
                    }
                    if (i2 == optJSONArray2.length() - 1 && xX != null) {
                        yh(xX.getFlipId());
                    }
                }
            }
            this.gKQ = arrayList;
            if (hasData()) {
                this.gKU = true;
            } else {
                this.gKU = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.gKQ != null && this.gKQ.size() > 0;
    }

    public boolean bBi() {
        return this.gKU;
    }
}
