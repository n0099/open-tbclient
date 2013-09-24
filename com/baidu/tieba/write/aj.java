package com.baidu.tieba.write;

import android.view.View;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2087a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.f2087a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        RecordVoiceBnt recordVoiceBnt;
        AudioIcon audioIcon;
        String str2;
        String str3;
        str = this.f2087a.Q;
        if (str != null) {
            str2 = this.f2087a.Q;
            if (str2.length() > 0) {
                WriteActivity writeActivity = this.f2087a;
                str3 = this.f2087a.Q;
                writeActivity.a(str3);
                return;
            }
        }
        recordVoiceBnt = this.f2087a.N;
        if (recordVoiceBnt.getVisibility() == 0) {
            this.f2087a.b(5);
        } else {
            this.f2087a.b(4);
        }
        audioIcon = this.f2087a.n;
        audioIcon.a();
    }
}
