package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    BdTypeListView gKE;
    private com.baidu.tbadk.k.g gKl;
    private d gKr;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eUO = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (h.this.gKl != null) {
                    h.this.gKl.dettachView(h.this.mRootView);
                    h.this.gKl = null;
                }
                if (h.this.gKr != null) {
                    h.this.gKr.btL();
                }
            }
        }
    };

    public BdTypeListView btX() {
        return this.gKE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gKE = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d btY() {
        return this.gKr;
    }

    public void b(d dVar) {
        this.gKr = dVar;
    }

    public void N(String str, boolean z) {
        f.a(this.gKl, this.eUO, this.mContext, this.mRootView, str, z);
        this.gKE.setVisibility(8);
    }
}
