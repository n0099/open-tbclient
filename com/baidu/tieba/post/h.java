package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    BdTypeListView fSE;
    private com.baidu.tbadk.j.g fSl;
    private d fSr;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener dZW = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (com.baidu.adp.lib.util.j.gD()) {
                if (h.this.fSl != null) {
                    h.this.fSl.P(h.this.mRootView);
                    h.this.fSl = null;
                }
                if (h.this.fSr != null) {
                    h.this.fSr.bhp();
                }
            }
        }
    };

    public BdTypeListView bhB() {
        return this.fSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view2) {
        this.mContext = context;
        this.mRootView = view2;
        this.fSE = (BdTypeListView) view2.findViewById(d.g.list);
    }

    public d bhC() {
        return this.fSr;
    }

    public void b(d dVar) {
        this.fSr = dVar;
    }

    public void E(String str, boolean z) {
        f.a(this.fSl, this.dZW, this.mContext, this.mRootView, str, z);
        this.fSE.setVisibility(8);
    }
}
