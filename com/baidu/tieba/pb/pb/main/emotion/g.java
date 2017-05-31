package com.baidu.tieba.pb.pb.main.emotion;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TextWatcher {
    final /* synthetic */ PbSearchEmotionActivity evD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.evD = pbSearchEmotionActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ImageView imageView;
        ImageView imageView2;
        List list;
        l lVar;
        l lVar2;
        if (editable.toString().trim().length() == 0) {
            imageView2 = this.evD.evq;
            imageView2.setVisibility(4);
            list = this.evD.evB;
            list.clear();
            lVar = this.evD.evx;
            if (lVar != null) {
                lVar2 = this.evD.evx;
                lVar2.notifyDataSetChanged();
            }
            this.evD.aNj();
            return;
        }
        imageView = this.evD.evq;
        imageView.setVisibility(0);
    }
}
