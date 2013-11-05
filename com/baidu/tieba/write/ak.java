package com.baidu.tieba.write;

import android.view.View;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.f2632a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        RecordVoiceBnt recordVoiceBnt;
        AudioIcon audioIcon;
        String str2;
        String str3;
        str = this.f2632a.Q;
        if (str != null) {
            str2 = this.f2632a.Q;
            if (str2.length() > 0) {
                WriteActivity writeActivity = this.f2632a;
                str3 = this.f2632a.Q;
                writeActivity.a(str3);
                return;
            }
        }
        recordVoiceBnt = this.f2632a.N;
        if (recordVoiceBnt.getVisibility() == 0) {
            this.f2632a.d(5);
        } else {
            this.f2632a.d(4);
        }
        audioIcon = this.f2632a.n;
        audioIcon.a();
    }
}
