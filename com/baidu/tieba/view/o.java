package com.baidu.tieba.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
/* loaded from: classes.dex */
final class o implements TextWatcher {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextView textView;
        Context context;
        textView = this.a.d;
        context = this.a.a;
        textView.setText(MessageFormat.format(context.getResources().getString(R.string.chat_custom_default_text), Integer.valueOf(editable.length())));
    }
}
