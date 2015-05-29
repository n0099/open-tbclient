package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class h implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: abf */
    public View hk() {
        return new PlayVoiceBnt(this.bPw.getPageContext().getPageActivity(), PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: L */
    public void k(View view) {
        ((PlayVoiceBnt) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: M */
    public View l(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: N */
    public View m(View view) {
        ((PlayVoiceBnt) view).reset();
        return view;
    }
}
