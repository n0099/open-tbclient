package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import d.b.i0.a;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class BaseLegoCardInfo implements ICardInfo {
    public final boolean bCeiling;
    public final int cardType;
    public final String flipId;
    public final String itemId;
    public BdUniqueId mBdUniqueId;
    public ClientParams mClientParams;
    public String mGroupId;
    public int page;
    public final String sExtras;
    public String scheme;
    public final boolean showCover;
    public final String showExtra;
    public final String showKey;
    public int showLine;
    public final int statTab;
    public final String statistics;
    public final String title;
    public int showSpace = 0;
    public boolean mHasShown = false;

    /* loaded from: classes4.dex */
    public static class ClientParams implements Serializable {
        public ClientParams(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            a.e().s(jSONObject);
        }
    }

    public BaseLegoCardInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.cardType = 0;
            this.itemId = "";
            this.flipId = "";
            this.scheme = "";
            this.title = "";
            this.statistics = "";
            this.sExtras = "";
            this.showKey = "";
            this.showExtra = "";
            this.bCeiling = false;
            this.statTab = 0;
            this.showLine = -1;
            this.showCover = false;
            this.mClientParams = null;
            return;
        }
        this.cardType = jSONObject.optInt("card_type");
        this.itemId = jSONObject.optString(LegoListActivityConfig.ITEM_ID);
        this.flipId = jSONObject.optString("flip_id");
        this.scheme = jSONObject.optString("scheme");
        this.title = jSONObject.optString("title");
        this.statistics = jSONObject.optString("statistics");
        this.sExtras = jSONObject.optString("sExtras");
        this.showKey = jSONObject.optString("showKey");
        this.showExtra = jSONObject.optString("showExtra");
        this.bCeiling = jSONObject.optInt("bCeiling") == 1;
        this.statTab = jSONObject.optInt("statTab");
        this.showCover = jSONObject.optInt("showCover") == 1;
        this.showLine = jSONObject.optInt("showLine", -1);
        this.page = jSONObject.optInt("page", 0);
        this.mClientParams = new ClientParams(jSONObject.optJSONObject("client_params"));
    }

    private boolean equalsGroupId(BaseLegoCardInfo baseLegoCardInfo) {
        if (baseLegoCardInfo == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.mGroupId)) {
            return TextUtils.isEmpty(baseLegoCardInfo.mGroupId);
        }
        return this.mGroupId.equals(baseLegoCardInfo.mGroupId);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof BaseLegoCardInfo) && !TextUtils.isEmpty(this.itemId)) {
            BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) obj;
            return this.itemId.equals(baseLegoCardInfo.itemId) && equalsGroupId(baseLegoCardInfo);
        }
        return false;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public final int getAdapterCount() {
        return getViewCount();
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getAdapterType() {
        return getCardType();
    }

    public String getCardTitle() {
        return this.title;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.cardType;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public String getFlipId() {
        return this.flipId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public int getPage() {
        return this.page;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return 0.0d;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getShowExtra() {
        return this.showExtra;
    }

    public String getShowKey() {
        return this.showKey;
    }

    public int getShowLine() {
        return this.showLine;
    }

    public int getShowSpace() {
        return this.showSpace;
    }

    public int getStatTab() {
        return this.statTab;
    }

    public String getStatistics() {
        return this.statistics;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return this.mBdUniqueId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public BaseLegoCardInfo getUpdateCard() {
        return this;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        return 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public BaseLegoCardInfo getViewItem(int i, int i2) {
        return this;
    }

    public String getsExtras() {
        return this.sExtras;
    }

    public int hashCode() {
        return 0 + (!TextUtils.isEmpty(this.itemId) ? this.itemId.hashCode() : 0) + (!TextUtils.isEmpty(this.mGroupId) ? this.mGroupId.hashCode() : 0);
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        return getCardType() == iCardInfo.getCardType();
    }

    public boolean isShowCover() {
        return this.showCover;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return true;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public abstract boolean responseAttention(Object obj);

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setShowLine(int i) {
        this.showLine = i;
    }

    public void setShowSpace(int i) {
        this.showSpace = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public final BaseLegoCardInfo getAdapterItem(int i) {
        return getViewItem(i, 0);
    }
}
