package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
/* loaded from: classes.dex */
class z implements com.baidu.adp.lib.f.c<View> {
    final /* synthetic */ NewSubPbActivity eis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(NewSubPbActivity newSubPbActivity) {
        this.eis = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: agt */
    public View ez() {
        PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.eis.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        playVoiceBntNew.setPlayTimeTextView(r.e.fontsize28);
        return playVoiceBntNew;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: al */
    public void o(View view) {
        ((PlayVoiceBntNew) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: am */
    public View p(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: an */
    public View q(View view) {
        ((PlayVoiceBntNew) view).reset();
        return view;
    }
}
