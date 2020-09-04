package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes18.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c lqy;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a tC() {
        this.lqy = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.ahJ);
        return this.lqy;
    }

    @Override // com.baidu.card.as
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.card.as
    public void onResume() {
        super.onResume();
    }
}
