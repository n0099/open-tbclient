package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx implements View.OnClickListener {
    final /* synthetic */ fw eBx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fx(fw fwVar) {
        this.eBx = fwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        List<TextLineView> list;
        if (com.baidu.adp.lib.util.i.hj()) {
            list = this.eBx.eBs;
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
        onClickListener = this.eBx.eBu;
        if (onClickListener != null) {
            onClickListener2 = this.eBx.eBu;
            onClickListener2.onClick(view);
        }
    }
}
