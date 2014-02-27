package com.baidu.tieba.pb;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.editortool.EmotionTabHost;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class p implements View.OnTouchListener {
    final /* synthetic */ ImagePbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ImagePbActivity imagePbActivity) {
        this.a = imagePbActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
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
            BdUtilHelper.b(imagePbActivity, editText2);
            button = this.a.n;
            button.setBackgroundResource(R.drawable.sub_pb_face);
            return true;
        }
        return false;
    }
}
