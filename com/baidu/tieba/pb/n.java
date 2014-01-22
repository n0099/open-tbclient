package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tieba.editortool.EmotionTabHost;
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
        EmotionTabHost emotionTabHost;
        EditText editText;
        EmotionTabHost emotionTabHost2;
        EditText editText2;
        Button button;
        emotionTabHost = this.a.o;
        if (emotionTabHost.getVisibility() == 0) {
            editText = this.a.l;
            editText.requestFocus();
            emotionTabHost2 = this.a.o;
            emotionTabHost2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText2 = this.a.l;
            com.baidu.adp.lib.g.g.b(imagePbActivity, editText2);
            button = this.a.n;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
