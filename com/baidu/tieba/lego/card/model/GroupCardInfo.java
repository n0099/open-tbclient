package com.baidu.tieba.lego.card.model;
/* loaded from: classes2.dex */
public class GroupCardInfo extends BaseCardInfo {
    private transient BaseCardInfo gGX;

    public GroupCardInfo(BaseCardInfo baseCardInfo) {
        super(null);
        this.gGX = baseCardInfo;
    }

    public BaseCardInfo getCard() {
        return this.gGX;
    }

    public void setCard(BaseCardInfo baseCardInfo) {
        this.gGX = baseCardInfo;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.gGX.getCardType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getUpdateCard() {
        return this.gGX;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo
    public String getScheme() {
        return this.gGX.getScheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return this.gGX == null ? super.shouldResponseAttention() : this.gGX.shouldResponseAttention();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        return this.gGX == null ? super.responseAttentionForum(str, z) : this.gGX.responseAttentionForum(str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        return this.gGX == null ? super.responseAttentionUser(str, z) : this.gGX.responseAttentionUser(str, z);
    }
}
