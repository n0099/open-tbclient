package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    BdTypeListView fTH;
    private com.baidu.tbadk.j.g fTo;
    private d fTu;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eba = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (com.baidu.adp.lib.util.j.gD()) {
                if (h.this.fTo != null) {
                    h.this.fTo.P(h.this.mRootView);
                    h.this.fTo = null;
                }
                if (h.this.fTu != null) {
                    h.this.fTu.bhp();
                }
            }
        }
    };

    public BdTypeListView bhB() {
        return this.fTH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view2) {
        this.mContext = context;
        this.mRootView = view2;
        this.fTH = (BdTypeListView) view2.findViewById(d.g.list);
    }

    public d bhC() {
        return this.fTu;
    }

    public void b(d dVar) {
        this.fTu = dVar;
    }

    public void E(String str, boolean z) {
        f.a(this.fTo, this.eba, this.mContext, this.mRootView, str, z);
        this.fTH.setVisibility(8);
    }
}
