package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements View.OnClickListener {
    final /* synthetic */ fe emz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(fe feVar) {
        this.emz = feVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        List<TextLineView> list;
        if (com.baidu.adp.lib.util.i.hk()) {
            list = this.emz.emu;
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
        onClickListener = this.emz.emw;
        if (onClickListener != null) {
            onClickListener2 = this.emz.emw;
            onClickListener2.onClick(view);
        }
    }
}
