package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.voice.PlayVoiceBnt;
/* loaded from: classes.dex */
class ao implements com.baidu.adp.lib.e.c<View> {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Wy */
    public View ee() {
        return new PlayVoiceBnt(this.bvu, PlayVoiceBnt.PLAY_TYPE.NORMAL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: S */
    public void i(View view) {
        ((PlayVoiceBnt) view).reset();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: T */
    public View j(View view) {
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: U */
    public View k(View view) {
        ((PlayVoiceBnt) view).reset();
        return view;
    }
}
