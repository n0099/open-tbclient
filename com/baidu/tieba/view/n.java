package com.baidu.tieba.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class n implements TextWatcher {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.a = lVar;
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
        textView.setText(MessageFormat.format(context.getResources().getString(R.string.chat_custom_default_text), Integer.valueOf(editable.length())));
    }
}
