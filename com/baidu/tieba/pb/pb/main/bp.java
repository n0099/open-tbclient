package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bp implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: agL */
    public View fF() {
        PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.elO.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
        playVoiceBntNew.setPlayTimeTextView(w.f.fontsize28);
        return playVoiceBntNew;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: ao */
    public void o(View view) {
        ((PlayVoiceBntNew) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: ap */
    public View p(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aq */
    public View q(View view) {
        ((PlayVoiceBntNew) view).reset();
        return view;
    }
}
