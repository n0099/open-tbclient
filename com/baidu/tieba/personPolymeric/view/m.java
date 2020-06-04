package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes11.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c kxd;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.am
    protected com.baidu.tieba.play.operableVideoView.a ry() {
        this.kxd = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.afX);
        return this.kxd;
    }

    @Override // com.baidu.card.am
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.card.am
    public void onResume() {
        super.onResume();
    }
}
