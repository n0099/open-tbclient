package com.baidu.tieba.lego.card.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class BaseLegoCardInfo implements ICardInfo {
    protected final boolean bCeiling;
    protected final int cardType;
    protected final String flipId;
    protected final String itemId;
    private BdUniqueId mBdUniqueId;
    protected String mGroupId;
    protected int page;
    protected final String sExtras;
    protected final String scheme;
    protected final boolean showCover;
    protected final String showExtra;
    protected final String showKey;
    protected int showLine;
    protected final int statTab;
    protected final String statistics;
    protected final String title;
    private int showSpace = 0;
    public boolean mHasShown = false;

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public abstract boolean responseAttention(Object obj);

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
            return;
        }
        this.cardType = jSONObject.optInt("card_type");
        this.itemId = jSONObject.optString(LegoListActivityConfig.ITEM_ID);
        this.flipId = jSONObject.optString("flip_id");
        this.scheme = jSONObject.optString("scheme");
        this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
        this.statistics = jSONObject.optString("statistics");
        this.sExtras = jSONObject.optString("sExtras");
        this.showKey = jSONObject.optString("showKey");
        this.showExtra = jSONObject.optString("showExtra");
        this.bCeiling = jSONObject.optInt("bCeiling") == 1;
        this.statTab = jSONObject.optInt("statTab");
        this.showCover = jSONObject.optInt("showCover") == 1;
        this.showLine = jSONObject.optInt("showLine", -1);
        this.page = jSONObject.optInt("page", 0);
    }

    public int getPage() {
        return this.page;
    }

    public int getShowLine() {
        return this.showLine;
    }

    public void setShowLine(int i) {
        this.showLine = i;
    }

    public int getShowSpace() {
        return this.showSpace;
    }

    public void setShowSpace(int i) {
        this.showSpace = i;
    }

    public boolean isShowCover() {
        return this.showCover;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.cardType;
    }

    public String getItemId() {
        return this.itemId;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public String getFlipId() {
        return this.flipId;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getCardTitle() {
        return this.title;
    }

    public String getStatistics() {
        return this.statistics;
    }

    public String getsExtras() {
        return this.sExtras;
    }

    public int getStatTab() {
        return this.statTab;
    }

    public String getShowKey() {
        return this.showKey;
    }

    public String getShowExtra() {
        return this.showExtra;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof BaseLegoCardInfo) && !TextUtils.isEmpty(this.itemId)) {
            BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) obj;
            return this.itemId.equals(baseLegoCardInfo.itemId) && b(baseLegoCardInfo);
        }
        return false;
    }

    private boolean b(BaseLegoCardInfo baseLegoCardInfo) {
        if (baseLegoCardInfo == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.mGroupId)) {
            return TextUtils.isEmpty(baseLegoCardInfo.mGroupId);
        }
        return this.mGroupId.equals(baseLegoCardInfo.mGroupId);
    }

    public int hashCode() {
        return (!TextUtils.isEmpty(this.itemId) ? this.itemId.hashCode() : 0) + 0 + (!TextUtils.isEmpty(this.mGroupId) ? this.mGroupId.hashCode() : 0);
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public final int getAdapterCount() {
        return getViewCount();
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        return 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public final BaseLegoCardInfo getAdapterItem(int i) {
        return getViewItem(i, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public BaseLegoCardInfo getViewItem(int i, int i2) {
        return this;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public int getAdapterType() {
        return getCardType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public BaseLegoCardInfo getUpdateCard() {
        return this;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return true;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return this.mBdUniqueId;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public double getRatio() {
        return 0.0d;
    }

    @Override // com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isReusable(ICardInfo iCardInfo) {
        return getCardType() == iCardInfo.getCardType();
    }
}
