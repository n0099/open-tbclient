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
public class cp implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(br brVar) {
        this.f1587a = brVar;
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
            z = this.f1587a.at;
            if (!z && !this.f1587a.M()) {
                this.f1587a.N();
                this.f1587a.j();
                this.f1587a.ak();
                this.f1587a.f1563a.setSelection(this.f1587a.f1563a.getText().length());
                this.f1587a.f1563a.requestFocus();
                newPbActivity = this.f1587a.c;
                newPbActivity.a(this.f1587a.f1563a, 100);
                if (TiebaApplication.g().s()) {
                    newPbActivity2 = this.f1587a.c;
                    StatService.onEvent(newPbActivity2, "pb_reply", "pbclick", 1);
                }
            }
            imageButton = this.f1587a.p;
            al = this.f1587a.al();
            imageButton.setBackgroundResource(al ? R.drawable.new_pb_face_btn_1 : R.drawable.new_pb_face_btn);
            imageButton2 = this.f1587a.m;
            al2 = this.f1587a.al();
            if (!al2) {
                i = R.drawable.new_pb_face_btn;
            }
            imageButton2.setBackgroundResource(i);
            audioIcon = this.f1587a.n;
            audioIcon.f();
            audioIcon2 = this.f1587a.r;
            audioIcon2.f();
        }
        return false;
    }
}
