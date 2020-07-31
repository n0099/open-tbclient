package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes18.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c kZW;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.ar
    protected com.baidu.tieba.play.operableVideoView.a rR() {
        this.kZW = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.agz);
        return this.kZW;
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
