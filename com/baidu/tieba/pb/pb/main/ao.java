package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: agc */
    public View ha() {
        return new PlayVoiceBnt(this.cjN.getPageContext().getPageActivity(), PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: X */
    public void l(View view) {
        ((PlayVoiceBnt) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Y */
    public View m(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Z */
    public View n(View view) {
        ((PlayVoiceBnt) view).reset();
        return view;
    }
}
