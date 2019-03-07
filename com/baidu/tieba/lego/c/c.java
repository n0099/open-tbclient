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
    private String gGo;
    private String gGp;
    List<d> gGq;
    private final e gKO;
    private int gKQ;
    private boolean hasMore;
    private String rank;
    private String title;
    private List<ICardInfo> gKP = new ArrayList();
    private int pn = 1;
    private boolean gKR = false;
    private boolean gKS = false;
    private boolean gKT = false;

    public c(e eVar) {
        this.gKO = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> bAY() {
        return this.gKP;
    }

    public void vb(int i) {
        this.gKQ = i;
    }

    public int bAZ() {
        return this.gKQ;
    }

    public boolean bBa() {
        return this.gKR;
    }

    public boolean bBb() {
        return this.gKS;
    }

    public e bBc() {
        return this.gKO;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String bBd() {
        return this.rank;
    }

    public void yg(String str) {
        this.rank = str;
    }

    public String bBe() {
        return this.gGo;
    }

    public String getTitle() {
        return this.title;
    }

    public String bBf() {
        return this.gGp;
    }

    public List<d> bBg() {
        return this.gGq;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.gKS = true;
        } else {
            this.gKR = true;
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
                        this.gGo = optJSONObject.optString("url");
                        this.gGp = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.gGq == null) {
                            this.gGq = new ArrayList();
                        } else {
                            this.gGq.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.gGq.add(dVar);
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
                    ICardInfo xW = com.baidu.tieba.lego.card.b.xW(dataRes.cards.get(i3));
                    if (xW != null && xW.isValid()) {
                        arrayList.add(xW);
                    }
                    if (i3 == dataRes.cards.size() - 1 && xW != null) {
                        yg(xW.getFlipId());
                    }
                }
            }
            if (z2) {
                this.gKP.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.gKP = arrayList;
        }
    }

    public void yh(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.gGo = optJSONObject.optString("url");
                    this.gGp = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.gGq == null) {
                        this.gGq = new ArrayList();
                    } else {
                        this.gGq.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.gGq.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo xW = com.baidu.tieba.lego.card.b.xW(optJSONArray2.getString(i2));
                    if (xW != null && xW.isValid()) {
                        arrayList.add(xW);
                    }
                    if (i2 == optJSONArray2.length() - 1 && xW != null) {
                        yg(xW.getFlipId());
                    }
                }
            }
            this.gKP = arrayList;
            if (hasData()) {
                this.gKT = true;
            } else {
                this.gKT = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.gKP != null && this.gKP.size() > 0;
    }

    public boolean bBh() {
        return this.gKT;
    }
}
