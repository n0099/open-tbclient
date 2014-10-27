package com.baidu.tieba.im.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tieba.y;
import java.text.MessageFormat;
/* loaded from: classes.dex */
class e implements TextWatcher {
    final /* synthetic */ ChatterboxEditDialog bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatterboxEditDialog chatterboxEditDialog) {
        this.bji = chatterboxEditDialog;
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
        textView = this.bji.mSizeTip;
        context = this.bji.mContextt;
        textView.setText(MessageFormat.format(context.getResources().getString(y.chat_custom_default_text), Integer.valueOf(editable.length())));
    }
}
