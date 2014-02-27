package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.editortool.EmotionTabHost;
import com.baidu.tieba.view.KeyboardLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class o implements View.OnClickListener {
    final /* synthetic */ ImagePbActivity a;
    private final /* synthetic */ Handler b;
    private final /* synthetic */ Runnable c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ImagePbActivity imagePbActivity, Handler handler, Runnable runnable) {
        this.a = imagePbActivity;
        this.b = handler;
        this.c = runnable;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EmotionTabHost emotionTabHost;
        KeyboardLayout keyboardLayout;
        EditText editText;
        Button button;
        EditText editText2;
        EmotionTabHost emotionTabHost2;
        EditText editText3;
        Button button2;
        emotionTabHost = this.a.o;
        if (emotionTabHost.getVisibility() == 0) {
            editText2 = this.a.l;
            editText2.requestFocus();
            emotionTabHost2 = this.a.o;
            emotionTabHost2.setVisibility(8);
            ImagePbActivity imagePbActivity = this.a;
            editText3 = this.a.l;
            BdUtilHelper.b(imagePbActivity, editText3);
            button2 = this.a.n;
            button2.setBackgroundResource(R.drawable.sub_pb_face);
            return;
        }
        keyboardLayout = this.a.s;
        keyboardLayout.setOnkbdStateListener(null);
        ImagePbActivity imagePbActivity2 = this.a;
        editText = this.a.l;
        BdUtilHelper.a(imagePbActivity2, editText);
        this.b.postDelayed(this.c, 200L);
        button = this.a.n;
        button.setBackgroundResource(R.drawable.sub_pb_keyboard);
    }
}
