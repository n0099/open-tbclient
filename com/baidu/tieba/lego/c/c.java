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
    private String lbr;
    private String lbs;
    List<d> lbt;
    private final e lfM;
    private String rank;
    private int scrollIndex;
    private String title;
    private List<ICardInfo> lfN = new ArrayList();
    private int pn = 1;
    private boolean lfO = false;
    private boolean lfP = false;
    private boolean lfQ = false;

    public c(e eVar) {
        this.lfM = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> dcN() {
        return this.lfN;
    }

    public void Eg(int i) {
        this.scrollIndex = i;
    }

    public int dcO() {
        return this.scrollIndex;
    }

    public boolean dcP() {
        return this.lfO;
    }

    public boolean dcQ() {
        return this.lfP;
    }

    public e dcR() {
        return this.lfM;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String dcS() {
        return this.rank;
    }

    public void NM(String str) {
        this.rank = str;
    }

    public String dcT() {
        return this.lbr;
    }

    public String getTitle() {
        return this.title;
    }

    public String dcU() {
        return this.lbs;
    }

    public List<d> dcV() {
        return this.lbt;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.lfP = true;
        } else {
            this.lfO = true;
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
                        this.lbr = optJSONObject.optString("url");
                        this.lbs = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.lbt == null) {
                            this.lbt = new ArrayList();
                        } else {
                            this.lbt.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.lbt.add(dVar);
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
                    ICardInfo ND = com.baidu.tieba.lego.card.b.ND(dataRes.cards.get(i3));
                    if (ND != null && ND.isValid()) {
                        arrayList.add(ND);
                    }
                    if (i3 == dataRes.cards.size() - 1 && ND != null) {
                        NM(ND.getFlipId());
                    }
                }
            }
            if (z2) {
                this.lfN.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.lfN = arrayList;
        }
    }

    public void NN(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.lbr = optJSONObject.optString("url");
                    this.lbs = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.lbt == null) {
                        this.lbt = new ArrayList();
                    } else {
                        this.lbt.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.lbt.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo ND = com.baidu.tieba.lego.card.b.ND(optJSONArray2.getString(i2));
                    if (ND != null && ND.isValid()) {
                        arrayList.add(ND);
                    }
                    if (i2 == optJSONArray2.length() - 1 && ND != null) {
                        NM(ND.getFlipId());
                    }
                }
            }
            this.lfN = arrayList;
            if (hasData()) {
                this.lfQ = true;
            } else {
                this.lfQ = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.lfN != null && this.lfN.size() > 0;
    }

    public boolean dcW() {
        return this.lfQ;
    }
}
