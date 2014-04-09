package com.baidu.tieba.pb.image;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tbadk.editortool.EmotionTabHost;
/* loaded from: classes.dex */
final class f implements View.OnTouchListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        EmotionTabHost emotionTabHost;
        EditText editText;
        EmotionTabHost emotionTabHost2;
        EditText editText2;
        Button button;
        emotionTabHost = this.a.n;
        if (emotionTabHost.getVisibility() == 0) {
            editText = this.a.k;
            editText.requestFocus();
            emotionTabHost2 = this.a.n;
            emotionTabHost2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText2 = this.a.k;
            com.baidu.adp.lib.util.i.b(imagePbActivity, editText2);
            button = this.a.m;
            button.setBackgroundResource(com.baidu.tieba.a.g.sub_pb_face);
            return true;
        }
        return false;
    }
}
