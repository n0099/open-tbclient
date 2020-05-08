package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes11.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c keg;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.al
    protected com.baidu.tieba.play.operableVideoView.a rr() {
        this.keg = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.afB);
        return this.keg;
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
