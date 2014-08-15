package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tieba.x;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class g implements TextWatcher {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.a = eVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        Context context;
        textView = this.a.d;
        context = this.a.a;
        textView.setText(MessageFormat.format(context.getResources().getString(x.chat_custom_default_text), Integer.valueOf(editable.length())));
    }
}
