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
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FaceView faceView;
        EditText editText;
        FaceView faceView2;
        EditText editText2;
        Button button;
        faceView = this.a.o;
        if (faceView.getVisibility() == 0) {
            editText = this.a.l;
            editText.requestFocus();
            faceView2 = this.a.o;
            faceView2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText2 = this.a.l;
            com.baidu.adp.lib.h.g.b(imagePbActivity, editText2);
            button = this.a.n;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
