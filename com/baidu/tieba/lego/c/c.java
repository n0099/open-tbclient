package com.baidu.tieba.lego.c;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.Lego.DataRes;
/* loaded from: classes9.dex */
public class c implements a {
    private boolean hasMore;
    private String kXF;
    private String kXG;
    List<d> kXH;
    private final e lca;
    private String rank;
    private int scrollIndex;
    private String title;
    private List<ICardInfo> lcb = new ArrayList();
    private int pn = 1;
    private boolean lcc = false;
    private boolean lcd = false;
    private boolean lce = false;

    public c(e eVar) {
        this.lca = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> deA() {
        return this.lcb;
    }

    public void Fu(int i) {
        this.scrollIndex = i;
    }

    public int deB() {
        return this.scrollIndex;
    }

    public boolean deC() {
        return this.lcc;
    }

    public boolean deD() {
        return this.lcd;
    }

    public e deE() {
        return this.lca;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String deF() {
        return this.rank;
    }

    public void Oe(String str) {
        this.rank = str;
    }

    public String deG() {
        return this.kXF;
    }

    public String getTitle() {
        return this.title;
    }

    public String deH() {
        return this.kXG;
    }

    public List<d> deI() {
        return this.kXH;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.lcd = true;
        } else {
            this.lcc = true;
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
                        this.kXF = optJSONObject.optString("url");
                        this.kXG = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.kXH == null) {
                            this.kXH = new ArrayList();
                        } else {
                            this.kXH.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.kXH.add(dVar);
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
                    ICardInfo NV = com.baidu.tieba.lego.card.b.NV(dataRes.cards.get(i3));
                    if (NV != null && NV.isValid()) {
                        arrayList.add(NV);
                    }
                    if (i3 == dataRes.cards.size() - 1 && NV != null) {
                        Oe(NV.getFlipId());
                    }
                }
            }
            if (z2) {
                this.lcb.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.lcb = arrayList;
        }
    }

    public void Of(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.kXF = optJSONObject.optString("url");
                    this.kXG = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.kXH == null) {
                        this.kXH = new ArrayList();
                    } else {
                        this.kXH.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.kXH.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo NV = com.baidu.tieba.lego.card.b.NV(optJSONArray2.getString(i2));
                    if (NV != null && NV.isValid()) {
                        arrayList.add(NV);
                    }
                    if (i2 == optJSONArray2.length() - 1 && NV != null) {
                        Oe(NV.getFlipId());
                    }
                }
            }
            this.lcb = arrayList;
            if (hasData()) {
                this.lce = true;
            } else {
                this.lce = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.lcb != null && this.lcb.size() > 0;
    }

    public boolean deJ() {
        return this.lce;
    }
}
