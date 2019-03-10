package com.baidu.tieba.lego.card.model;
/* loaded from: classes2.dex */
public class GroupCardInfo extends BaseCardInfo {
    private transient BaseCardInfo gGY;

    public GroupCardInfo(BaseCardInfo baseCardInfo) {
        super(null);
        this.gGY = baseCardInfo;
    }

    public BaseCardInfo getCard() {
        return this.gGY;
    }

    public void setCard(BaseCardInfo baseCardInfo) {
        this.gGY = baseCardInfo;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public int getCardType() {
        return this.gGY.getCardType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo, com.baidu.tieba.lego.card.model.ICardInfo
    public BaseCardInfo getUpdateCard() {
        return this.gGY;
    }

    @Override // com.baidu.tieba.lego.card.model.BaseLegoCardInfo
    public String getScheme() {
        return this.gGY.getScheme();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean shouldResponseAttention() {
        return this.gGY == null ? super.shouldResponseAttention() : this.gGY.shouldResponseAttention();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionForum(String str, boolean z) {
        return this.gGY == null ? super.responseAttentionForum(str, z) : this.gGY.responseAttentionForum(str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.model.BaseCardInfo
    public boolean responseAttentionUser(String str, boolean z) {
        return this.gGY == null ? super.responseAttentionUser(str, z) : this.gGY.responseAttentionUser(str, z);
    }
}
