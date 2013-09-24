package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2038a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RecordVoiceBnt recordVoiceBnt, String str) {
        this.f2038a = recordVoiceBnt;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.f2038a.u;
        textView.setVisibility(0);
        textView2 = this.f2038a.u;
        textView2.setText(this.b);
    }
}
