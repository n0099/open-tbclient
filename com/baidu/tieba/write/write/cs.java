package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements TextWatcher {
    final /* synthetic */ cq gnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cq cqVar) {
        this.gnc = cqVar;
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
            view = this.gnc.gmY;
            view.setVisibility(8);
            textView = this.gnc.gmZ;
            com.baidu.tbadk.core.util.as.i(textView, w.e.cp_cont_e);
            textView2 = this.gnc.gmZ;
            textView2.setEnabled(false);
            return;
        }
        view2 = this.gnc.gmY;
        view2.setVisibility(0);
        textView3 = this.gnc.gmZ;
        com.baidu.tbadk.core.util.as.i(textView3, w.e.cp_link_tip_a);
        textView4 = this.gnc.gmZ;
        textView4.setEnabled(true);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        WriteUrlActivity writeUrlActivity;
        textView = this.gnc.gnb;
        CharSequence text = textView.getText();
        writeUrlActivity = this.gnc.gmJ;
        if (!text.equals(writeUrlActivity.getActivity().getString(w.l.tip_url_not_match))) {
            return;
        }
        this.gnc.buR();
    }
}
