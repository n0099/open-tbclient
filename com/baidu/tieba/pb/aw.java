package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class aw implements com.baidu.adp.lib.d.c<View> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public View a() {
        return new PlayVoiceBnt(this.a, PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(View view) {
        ((PlayVoiceBnt) view).d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public View b(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public View c(View view) {
        ((PlayVoiceBnt) view).d();
        return view;
    }
}
