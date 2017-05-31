package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements TextWatcher {
    final /* synthetic */ cs gce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cs csVar) {
        this.gce = csVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        View view;
        TextView textView;
        TextView textView2;
        View view2;
        TextView textView3;
        TextView textView4;
        if (charSequence == null || charSequence.length() <= 0) {
            view = this.gce.gca;
            view.setVisibility(8);
            textView = this.gce.gcb;
            com.baidu.tbadk.core.util.aq.i(textView, w.e.cp_cont_e);
            textView2 = this.gce.gcb;
            textView2.setEnabled(false);
            return;
        }
        view2 = this.gce.gca;
        view2.setVisibility(0);
        textView3 = this.gce.gcb;
        com.baidu.tbadk.core.util.aq.i(textView3, w.e.cp_link_tip_a);
        textView4 = this.gce.gcb;
        textView4.setEnabled(true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        WriteUrlActivity writeUrlActivity;
        TextView textView2;
        TextView textView3;
        textView = this.gce.gcd;
        CharSequence text = textView.getText();
        writeUrlActivity = this.gce.gbL;
        if (!text.equals(writeUrlActivity.getResources().getString(w.l.tip_url_post))) {
            textView2 = this.gce.gcd;
            textView2.setText(w.l.tip_url_post);
            textView3 = this.gce.gcd;
            com.baidu.tbadk.core.util.aq.i(textView3, w.e.cp_cont_d);
        }
    }
}
