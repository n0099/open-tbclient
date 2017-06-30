package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ca implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: ako */
    public View fK() {
        PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.ewh.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        playVoiceBntNew.setPlayTimeTextView(w.f.fontsize28);
        return playVoiceBntNew;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: am */
    public void o(View view) {
        ((PlayVoiceBntNew) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: an */
    public View p(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: ao */
    public View q(View view) {
        ((PlayVoiceBntNew) view).reset();
        return view;
    }
}
