package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.f.c<View> {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: alB */
    public View hc() {
        return new PlayVoiceBnt(this.cLc.getPageContext().getPageActivity(), PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aj */
    public void l(View view) {
        ((PlayVoiceBnt) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: ak */
    public View m(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: al */
    public View n(View view) {
        ((PlayVoiceBnt) view).reset();
        return view;
    }
}
