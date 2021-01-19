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
/* loaded from: classes8.dex */
public class c implements a {
    private boolean hasMore;
    private String kTa;
    private String kTb;
    List<d> kTc;
    private final e kXu;
    private String rank;
    private int scrollIndex;
    private String title;
    private List<ICardInfo> kXv = new ArrayList();
    private int pn = 1;
    private boolean kXw = false;
    private boolean kXx = false;
    private boolean kXy = false;

    public c(e eVar) {
        this.kXu = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> daI() {
        return this.kXv;
    }

    public void DO(int i) {
        this.scrollIndex = i;
    }

    public int daJ() {
        return this.scrollIndex;
    }

    public boolean daK() {
        return this.kXw;
    }

    public boolean daL() {
        return this.kXx;
    }

    public e daM() {
        return this.kXu;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String daN() {
        return this.rank;
    }

    public void MX(String str) {
        this.rank = str;
    }

    public String daO() {
        return this.kTa;
    }

    public String getTitle() {
        return this.title;
    }

    public String daP() {
        return this.kTb;
    }

    public List<d> daQ() {
        return this.kTc;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.kXx = true;
        } else {
            this.kXw = true;
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
                        this.kTa = optJSONObject.optString("url");
                        this.kTb = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.kTc == null) {
                            this.kTc = new ArrayList();
                        } else {
                            this.kTc.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.kTc.add(dVar);
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
                    ICardInfo MO = com.baidu.tieba.lego.card.b.MO(dataRes.cards.get(i3));
                    if (MO != null && MO.isValid()) {
                        arrayList.add(MO);
                    }
                    if (i3 == dataRes.cards.size() - 1 && MO != null) {
                        MX(MO.getFlipId());
                    }
                }
            }
            if (z2) {
                this.kXv.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.kXv = arrayList;
        }
    }

    public void MY(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.kTa = optJSONObject.optString("url");
                    this.kTb = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.kTc == null) {
                        this.kTc = new ArrayList();
                    } else {
                        this.kTc.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.kTc.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo MO = com.baidu.tieba.lego.card.b.MO(optJSONArray2.getString(i2));
                    if (MO != null && MO.isValid()) {
                        arrayList.add(MO);
                    }
                    if (i2 == optJSONArray2.length() - 1 && MO != null) {
                        MX(MO.getFlipId());
                    }
                }
            }
            this.kXv = arrayList;
            if (hasData()) {
                this.kXy = true;
            } else {
                this.kXy = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.kXv != null && this.kXv.size() > 0;
    }

    public boolean daR() {
        return this.kXy;
    }
}
