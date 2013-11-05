package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.write.AudioIcon;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(bt btVar) {
        this.f2098a = btVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        ImageButton imageButton;
        boolean al;
        ImageButton imageButton2;
        boolean al2;
        AudioIcon audioIcon;
        AudioIcon audioIcon2;
        NewPbActivity newPbActivity;
        NewPbActivity newPbActivity2;
        int i = R.drawable.new_pb_face_btn_1;
        if (motionEvent.getAction() == 1) {
            z = this.f2098a.at;
            if (!z && !this.f2098a.M()) {
                this.f2098a.N();
                this.f2098a.j();
                this.f2098a.ak();
                this.f2098a.f2081a.setSelection(this.f2098a.f2081a.getText().length());
                this.f2098a.f2081a.requestFocus();
                newPbActivity = this.f2098a.c;
                newPbActivity.a(this.f2098a.f2081a, 100);
                if (TiebaApplication.g().s()) {
                    newPbActivity2 = this.f2098a.c;
                    StatService.onEvent(newPbActivity2, "pb_reply", "pbclick", 1);
                }
            }
            imageButton = this.f2098a.p;
            al = this.f2098a.al();
            imageButton.setBackgroundResource(al ? R.drawable.new_pb_face_btn_1 : R.drawable.new_pb_face_btn);
            imageButton2 = this.f2098a.m;
            al2 = this.f2098a.al();
            if (!al2) {
                i = R.drawable.new_pb_face_btn;
            }
            imageButton2.setBackgroundResource(i);
            audioIcon = this.f2098a.n;
            audioIcon.f();
            audioIcon2 = this.f2098a.r;
            audioIcon2.f();
        }
        return false;
    }
}
