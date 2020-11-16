package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
/* loaded from: classes23.dex */
public class m extends com.baidu.card.h {
    private com.baidu.tieba.play.operableVideoView.c mhu;

    public m(Context context) {
        super(context);
    }

    @Override // com.baidu.card.h, com.baidu.card.at
    protected com.baidu.tieba.play.operableVideoView.a tH() {
        this.mhu = new com.baidu.tieba.play.operableVideoView.c(this.mContext, this.aiB);
        return this.mhu;
    }

    @Override // com.baidu.card.at
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.card.at
    public void onResume() {
        super.onResume();
    }
}
