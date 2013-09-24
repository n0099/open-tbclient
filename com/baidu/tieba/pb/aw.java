package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class aw implements com.baidu.adp.lib.b.c<View> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1542a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(NewPbActivity newPbActivity) {
        this.f1542a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    /* renamed from: b */
    public View a() {
        return new PlayVoiceBnt(this.f1542a, PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public void a(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view;
        playVoiceBnt.setVoiceModel(null);
        playVoiceBnt.setTag(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public View b(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public View c(View view) {
        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view;
        playVoiceBnt.setVoiceModel(null);
        playVoiceBnt.setTag(null);
        return view;
    }
}
