package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    BdTypeListView gGI;
    private com.baidu.tbadk.k.g gGp;
    private d gGv;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eRj = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (h.this.gGp != null) {
                    h.this.gGp.dettachView(h.this.mRootView);
                    h.this.gGp = null;
                }
                if (h.this.gGv != null) {
                    h.this.gGv.bsr();
                }
            }
        }
    };

    public BdTypeListView bsD() {
        return this.gGI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gGI = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d bsE() {
        return this.gGv;
    }

    public void b(d dVar) {
        this.gGv = dVar;
    }

    public void O(String str, boolean z) {
        f.a(this.gGp, this.eRj, this.mContext, this.mRootView, str, z);
        this.gGI.setVisibility(8);
    }
}
