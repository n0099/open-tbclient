package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
final class aw implements com.baidu.adp.lib.d.c<View> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ View a() {
        return new PlayVoiceBnt(this.a, PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(View view) {
        ((PlayVoiceBnt) view).b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* bridge */ /* synthetic */ View b(View view) {
        return view;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ View c(View view) {
        View view2 = view;
        ((PlayVoiceBnt) view2).b();
        return view2;
    }
}
