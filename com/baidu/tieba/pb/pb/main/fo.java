package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    final /* synthetic */ fn esm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(fn fnVar) {
        this.esm = fnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        List<TextLineView> list;
        if (com.baidu.adp.lib.util.i.hk()) {
            list = this.esm.esh;
            for (TextLineView textLineView : list) {
                if (textLineView != null) {
                    if (textLineView != view) {
                        textLineView.setSelected(false);
                    } else {
                        textLineView.setSelected(true);
                    }
                }
            }
        }
        onClickListener = this.esm.esj;
        if (onClickListener != null) {
            onClickListener2 = this.esm.esj;
            onClickListener2.onClick(view);
        }
    }
}
