package com.baidu.tieba.lego.card.model;
/* loaded from: classes8.dex */
public class GroupCardInfo extends BaseCardInfo {
    private transient BaseCardInfo mCard;

    public GroupCardInfo(BaseCardInfo baseCardInfo) {
        super(null);
        this.mCard = baseCardInfo;
    }

    public BaseCardInfo getCard() {
        return this.mCard;
    }

    public void setCard(BaseCardInfo baseCardInfo) {
        this.mCard = baseCardInfo;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.mCard.getCardType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getUpdateCard() {
        return this.mCard;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo
    public String getScheme() {
        return this.mCard.getScheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return this.mCard == null ? super.shouldResponseAttention() : this.mCard.shouldResponseAttention();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        return this.mCard == null ? super.responseAttentionForum(str, z) : this.mCard.responseAttentionForum(str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        return this.mCard == null ? super.responseAttentionUser(str, z) : this.mCard.responseAttentionUser(str, z);
    }
}
