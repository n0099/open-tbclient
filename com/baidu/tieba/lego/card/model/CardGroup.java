package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import d.a.k0.j1.o.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CardGroup extends BaseCardInfo {
    public final List<BaseCardInfo> mCards;
    public final int showSep;

    public CardGroup(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        ICardInfo j;
        this.showSep = jSONObject.optInt("showSep", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray("cards");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.mCards = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null && (j = b.j(optJSONObject)) != null) {
                j.setGroupId(this.itemId);
                this.mCards.add((BaseCardInfo) j);
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        return this.mCards.size();
    }

    public boolean isEmpty() {
        return this.mCards.size() == 0;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return !isEmpty() && super.isValid();
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        boolean z2 = false;
        for (BaseCardInfo baseCardInfo : this.mCards) {
            if (baseCardInfo.responseAttentionForum(str, z)) {
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        boolean z2 = false;
        for (BaseCardInfo baseCardInfo : this.mCards) {
            if (baseCardInfo.responseAttentionUser(str, z)) {
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getViewItem(int i2, int i3) {
        int size = this.mCards.size();
        if (i2 < size) {
            int i4 = this.showSep;
            if (i4 == 0) {
                this.mCards.get(i2).setShowSpace(0);
            } else if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        if (size == 1) {
                            this.mCards.get(i2).setShowSpace(3);
                        } else if (i2 == 0) {
                            this.mCards.get(i2).setShowSpace(2);
                        } else if (i2 == size - 1) {
                            this.mCards.get(i2).setShowSpace(1);
                        } else {
                            this.mCards.get(i2).setShowSpace(0);
                        }
                    }
                } else if (i2 == 0) {
                    this.mCards.get(i2).setShowSpace(2);
                } else {
                    this.mCards.get(i2).setShowSpace(0);
                }
            } else if (i2 == size - 1) {
                this.mCards.get(i2).setShowSpace(1);
            } else {
                this.mCards.get(i2).setShowSpace(0);
            }
            if (this.mCards.get(i2).getShowLine() == -1) {
                this.mCards.get(i2).setShowLine(this.showLine);
            }
            return new GroupCardInfo(this.mCards.get(i2));
        }
        return null;
    }
}
