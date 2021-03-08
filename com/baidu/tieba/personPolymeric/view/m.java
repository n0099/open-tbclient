package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes7.dex */
public class m extends com.baidu.card.g {
    private com.baidu.tieba.play.operableVideoView.c mHG;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.g, com.baidu.card.as
    protected com.baidu.tieba.play.operableVideoView.a sU() {
        this.mHG = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.ahS);
        return this.mHG;
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
