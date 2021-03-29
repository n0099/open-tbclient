package com.baidu.tieba.lego.card.model;
/* loaded from: classes3.dex */
public class GroupCardInfo extends BaseCardInfo {
    public transient BaseCardInfo mCard;

    public GroupCardInfo(BaseCardInfo baseCardInfo) {
        super(null);
        this.mCard = baseCardInfo;
    }

    public BaseCardInfo getCard() {
        return this.mCard;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.mCard.getCardType();
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo
    public String getScheme() {
        return this.mCard.getScheme();
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        BaseCardInfo baseCardInfo = this.mCard;
        if (baseCardInfo == null) {
            return super.responseAttentionForum(str, z);
        }
        return baseCardInfo.responseAttentionForum(str, z);
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        BaseCardInfo baseCardInfo = this.mCard;
        if (baseCardInfo == null) {
            return super.responseAttentionUser(str, z);
        }
        return baseCardInfo.responseAttentionUser(str, z);
    }

    public void setCard(BaseCardInfo baseCardInfo) {
        this.mCard = baseCardInfo;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        BaseCardInfo baseCardInfo = this.mCard;
        if (baseCardInfo == null) {
            return super.shouldResponseAttention();
        }
        return baseCardInfo.shouldResponseAttention();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getUpdateCard() {
        return this.mCard;
    }
}
