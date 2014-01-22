package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.view.KeyboardLayout;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ Handler a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ ImagePbActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
        this.c = imagePbActivity;
        this.a = handler;
        this.b = runnable;
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
        emotionTabHost = this.c.o;
        if (emotionTabHost.getVisibility() == 0) {
            editText2 = this.c.l;
            editText2.requestFocus();
            emotionTabHost2 = this.c.o;
            emotionTabHost2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.c;
            editText3 = this.c.l;
            com.baidu.adp.lib.g.g.b(imagePbActivity, editText3);
            button2 = this.c.n;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        keyboardLayout = this.c.s;
        keyboardLayout.setOnkbdStateListener(null);
        ImagePbActivity imagePbActivity2 = this.c;
        editText = this.c.l;
        com.baidu.adp.lib.g.g.a(imagePbActivity2, editText);
        this.a.postDelayed(this.b, 200L);
        button = this.c.n;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
