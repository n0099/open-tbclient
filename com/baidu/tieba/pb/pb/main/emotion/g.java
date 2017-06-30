package com.baidu.tieba.pb.pb.main.emotion;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ PbSearchEmotionActivity eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.eET = pbSearchEmotionActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        List list;
        l lVar;
        l lVar2;
        if (editable.toString().trim().length() == 0) {
            linearLayout2 = this.eET.eEK;
            linearLayout2.setVisibility(4);
            list = this.eET.eER;
            list.clear();
            lVar = this.eET.eEN;
            if (lVar != null) {
                lVar2 = this.eET.eEN;
                lVar2.notifyDataSetChanged();
            }
            this.eET.aRi();
            return;
        }
        linearLayout = this.eET.eEK;
        linearLayout.setVisibility(0);
    }
}
