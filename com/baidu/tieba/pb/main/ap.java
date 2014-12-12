package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class ap implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: WV */
    public View ed() {
        return new PlayVoiceBnt(this.bzj.getPageContext().getPageActivity(), PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: J */
    public void k(View view) {
        ((PlayVoiceBnt) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: K */
    public View l(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: L */
    public View m(View view) {
        ((PlayVoiceBnt) view).reset();
        return view;
    }
}
