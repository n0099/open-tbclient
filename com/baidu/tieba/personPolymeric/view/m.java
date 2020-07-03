package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes11.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c kRa;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rP() {
        this.kRa = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.agI);
        return this.kRa;
    }

    @Override // com.baidu.card.ar
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.card.ar
    public void onResume() {
        super.onResume();
    }
}
