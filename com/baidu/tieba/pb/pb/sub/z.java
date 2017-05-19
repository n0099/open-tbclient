package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class z implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: afp */
    public View fL() {
        PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.eqU.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        playVoiceBntNew.setPlayTimeTextView(w.f.fontsize28);
        return playVoiceBntNew;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: ak */
    public void o(View view) {
        ((PlayVoiceBntNew) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: al */
    public View p(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: am */
    public View q(View view) {
        ((PlayVoiceBntNew) view).reset();
        return view;
    }
}
