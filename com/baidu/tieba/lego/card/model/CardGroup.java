package com.baidu.tieba.lego.card.model;

import com.baidu.tieba.lego.card.exception.CardParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class CardGroup extends BaseCardInfo {
    private final List<BaseCardInfo> mCards;
    private final int showSep;

    public CardGroup(JSONObject jSONObject) throws CardParseException {
        super(jSONObject);
        ICardInfo ey;
        this.showSep = jSONObject.optInt("showSep", 1);
        JSONArray optJSONArray = jSONObject.optJSONArray("cards");
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        this.mCards = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (ey = com.baidu.tieba.lego.card.b.ey(optJSONObject)) != null) {
                ey.setGroupId(this.itemId);
                this.mCards.add((BaseCardInfo) ey);
            }
        }
    }

    public boolean isEmpty() {
        return this.mCards.size() == 0;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getViewCount() {
        return this.mCards.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getViewItem(int i, int i2) {
        int size = this.mCards.size();
        if (i < size) {
            switch (this.showSep) {
                case 0:
                    this.mCards.get(i).setShowSpace(0);
                    break;
                case 1:
                    if (i == size - 1) {
                        this.mCards.get(i).setShowSpace(1);
                        break;
                    } else {
                        this.mCards.get(i).setShowSpace(0);
                        break;
                    }
                case 2:
                    if (i == 0) {
                        this.mCards.get(i).setShowSpace(2);
                        break;
                    } else {
                        this.mCards.get(i).setShowSpace(0);
                        break;
                    }
                case 3:
                    if (size == 1) {
                        this.mCards.get(i).setShowSpace(3);
                        break;
                    } else if (i == 0) {
                        this.mCards.get(i).setShowSpace(2);
                        break;
                    } else if (i == size - 1) {
                        this.mCards.get(i).setShowSpace(1);
                        break;
                    } else {
                        this.mCards.get(i).setShowSpace(0);
                        break;
                    }
            }
            if (this.mCards.get(i).getShowLine() == -1) {
                this.mCards.get(i).setShowLine(this.showLine);
            }
            return new GroupCardInfo(this.mCards.get(i));
        }
        return null;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public boolean isValid() {
        return !isEmpty() && super.isValid();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        boolean z2 = false;
        Iterator<BaseCardInfo> it = this.mCards.iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                z2 = it.next().responseAttentionUser(str, z) ? true : z3;
            } else {
                return z3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        boolean z2 = false;
        Iterator<BaseCardInfo> it = this.mCards.iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                z2 = it.next().responseAttentionForum(str, z) ? true : z3;
            } else {
                return z3;
            }
        }
    }
}
