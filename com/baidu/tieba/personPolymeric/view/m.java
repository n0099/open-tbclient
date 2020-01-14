package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes9.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c jre;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a mK() {
        this.jre = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.Mk);
        return this.jre;
    }

    @Override // com.baidu.card.al
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.card.al
    public void onResume() {
        super.onResume();
    }
}
