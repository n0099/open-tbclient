package com.baidu.tieba.pb.image;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.widget.KeyboardLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
        this.a = imagePbActivity;
        this.b = handler;
        this.c = runnable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionTabHost emotionTabHost;
        KeyboardLayout keyboardLayout;
        EditText editText;
        Button button;
        EditText editText2;
        EmotionTabHost emotionTabHost2;
        EditText editText3;
        Button button2;
        emotionTabHost = this.a.n;
        if (emotionTabHost.getVisibility() == 0) {
            editText2 = this.a.k;
            editText2.requestFocus();
            emotionTabHost2 = this.a.n;
            emotionTabHost2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText3 = this.a.k;
            com.baidu.adp.lib.util.j.b(imagePbActivity, editText3);
            button2 = this.a.m;
            button2.setBackgroundResource(com.baidu.tieba.u.sub_pb_face);
            return;
        }
        keyboardLayout = this.a.r;
        keyboardLayout.setOnkbdStateListener(null);
        ImagePbActivity imagePbActivity2 = this.a;
        editText = this.a.k;
        com.baidu.adp.lib.util.j.a(imagePbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.a.m;
        button.setBackgroundResource(com.baidu.tieba.u.sub_pb_keyboard);
    }
}
