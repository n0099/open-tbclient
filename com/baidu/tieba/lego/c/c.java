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
    private String lbd;
    private String lbe;
    List<d> lbf;
    private final e lfy;
    private String rank;
    private int scrollIndex;
    private String title;
    private List<ICardInfo> lfz = new ArrayList();
    private int pn = 1;
    private boolean lfA = false;
    private boolean lfB = false;
    private boolean lfC = false;

    public c(e eVar) {
        this.lfy = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> dcG() {
        return this.lfz;
    }

    public void Eg(int i) {
        this.scrollIndex = i;
    }

    public int dcH() {
        return this.scrollIndex;
    }

    public boolean dcI() {
        return this.lfA;
    }

    public boolean dcJ() {
        return this.lfB;
    }

    public e dcK() {
        return this.lfy;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String dcL() {
        return this.rank;
    }

    public void NL(String str) {
        this.rank = str;
    }

    public String dcM() {
        return this.lbd;
    }

    public String getTitle() {
        return this.title;
    }

    public String dcN() {
        return this.lbe;
    }

    public List<d> dcO() {
        return this.lbf;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.lfB = true;
        } else {
            this.lfA = true;
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
                        this.lbd = optJSONObject.optString("url");
                        this.lbe = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.lbf == null) {
                            this.lbf = new ArrayList();
                        } else {
                            this.lbf.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.lbf.add(dVar);
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
                    ICardInfo NC = com.baidu.tieba.lego.card.b.NC(dataRes.cards.get(i3));
                    if (NC != null && NC.isValid()) {
                        arrayList.add(NC);
                    }
                    if (i3 == dataRes.cards.size() - 1 && NC != null) {
                        NL(NC.getFlipId());
                    }
                }
            }
            if (z2) {
                this.lfz.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.lfz = arrayList;
        }
    }

    public void NM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.lbd = optJSONObject.optString("url");
                    this.lbe = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.lbf == null) {
                        this.lbf = new ArrayList();
                    } else {
                        this.lbf.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.lbf.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo NC = com.baidu.tieba.lego.card.b.NC(optJSONArray2.getString(i2));
                    if (NC != null && NC.isValid()) {
                        arrayList.add(NC);
                    }
                    if (i2 == optJSONArray2.length() - 1 && NC != null) {
                        NL(NC.getFlipId());
                    }
                }
            }
            this.lfz = arrayList;
            if (hasData()) {
                this.lfC = true;
            } else {
                this.lfC = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.lfz != null && this.lfz.size() > 0;
    }

    public boolean dcP() {
        return this.lfC;
    }
}
