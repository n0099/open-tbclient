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
    private String ldu;
    private String ldv;
    List<d> ldw;
    private final e lhO;
    private String rank;
    private int scrollIndex;
    private String title;
    private List<ICardInfo> lhP = new ArrayList();
    private int pn = 1;
    private boolean lhQ = false;
    private boolean lhR = false;
    private boolean lhS = false;

    public c(e eVar) {
        this.lhO = eVar;
    }

    @Override // com.baidu.tieba.lego.c.a
    public int getPn() {
        return this.pn;
    }

    @Override // com.baidu.tieba.lego.c.a
    public List<ICardInfo> dcW() {
        return this.lhP;
    }

    public void Ej(int i) {
        this.scrollIndex = i;
    }

    public int dcX() {
        return this.scrollIndex;
    }

    public boolean dcY() {
        return this.lhQ;
    }

    public boolean dcZ() {
        return this.lhR;
    }

    public e dda() {
        return this.lhO;
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasMore() {
        return this.hasMore;
    }

    public String ddb() {
        return this.rank;
    }

    public void NS(String str) {
        this.rank = str;
    }

    public String ddc() {
        return this.ldu;
    }

    public String getTitle() {
        return this.title;
    }

    public String ddd() {
        return this.ldv;
    }

    public List<d> dde() {
        return this.ldw;
    }

    @Override // com.baidu.tieba.lego.c.a
    public void a(boolean z, Message message, boolean z2, int i) {
        if (z) {
            this.lhR = true;
        } else {
            this.lhQ = true;
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
                        this.ldu = optJSONObject.optString("url");
                        this.ldv = optJSONObject.optString("urlNight");
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
                    if (optJSONArray != null) {
                        if (this.ldw == null) {
                            this.ldw = new ArrayList();
                        } else {
                            this.ldw.clear();
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                d dVar = new d();
                                dVar.parseFromJson(optJSONObject2);
                                if (dVar.isValid()) {
                                    this.ldw.add(dVar);
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
                    ICardInfo NJ = com.baidu.tieba.lego.card.b.NJ(dataRes.cards.get(i3));
                    if (NJ != null && NJ.isValid()) {
                        arrayList.add(NJ);
                    }
                    if (i3 == dataRes.cards.size() - 1 && NJ != null) {
                        NS(NJ.getFlipId());
                    }
                }
            }
            if (z2) {
                this.lhP.addAll(arrayList);
                this.pn = i;
                return;
            }
            this.pn = 1;
            this.lhP = arrayList;
        }
    }

    public void NT(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page_info");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_LOAD_DATA_SUCCESS, optString));
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONObject optJSONObject = jSONObject2.optJSONObject("title");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("name");
                    this.ldu = optJSONObject.optString("url");
                    this.ldv = optJSONObject.optString("urlNight");
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("buttons");
                if (optJSONArray != null) {
                    if (this.ldw == null) {
                        this.ldw = new ArrayList();
                    } else {
                        this.ldw.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            d dVar = new d();
                            dVar.parseFromJson(optJSONObject2);
                            if (dVar.isValid()) {
                                this.ldw.add(dVar);
                            }
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cards");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ICardInfo NJ = com.baidu.tieba.lego.card.b.NJ(optJSONArray2.getString(i2));
                    if (NJ != null && NJ.isValid()) {
                        arrayList.add(NJ);
                    }
                    if (i2 == optJSONArray2.length() - 1 && NJ != null) {
                        NS(NJ.getFlipId());
                    }
                }
            }
            this.lhP = arrayList;
            if (hasData()) {
                this.lhS = true;
            } else {
                this.lhS = false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.lego.c.a
    public boolean hasData() {
        return this.lhP != null && this.lhP.size() > 0;
    }

    public boolean ddf() {
        return this.lhS;
    }
}
