package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tieba.editortool.FaceView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2276a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImagePbActivity imagePbActivity) {
        this.f2276a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FaceView faceView;
        EditText editText;
        FaceView faceView2;
        EditText editText2;
        Button button;
        faceView = this.f2276a.o;
        if (faceView.getVisibility() == 0) {
            editText = this.f2276a.l;
            editText.requestFocus();
            faceView2 = this.f2276a.o;
            faceView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.f2276a;
            editText2 = this.f2276a.l;
            com.baidu.adp.lib.h.g.b(imagePbActivity, editText2);
            button = this.f2276a.n;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
