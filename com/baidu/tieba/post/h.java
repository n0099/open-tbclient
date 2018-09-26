package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    private d gqC;
    BdTypeListView gqP;
    private com.baidu.tbadk.k.g gqw;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eBr = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ky()) {
                if (h.this.gqw != null) {
                    h.this.gqw.ad(h.this.mRootView);
                    h.this.gqw = null;
                }
                if (h.this.gqC != null) {
                    h.this.gqC.bnN();
                }
            }
        }
    };

    public BdTypeListView bnZ() {
        return this.gqP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gqP = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d boa() {
        return this.gqC;
    }

    public void b(d dVar) {
        this.gqC = dVar;
    }

    public void F(String str, boolean z) {
        f.a(this.gqw, this.eBr, this.mContext, this.mRootView, str, z);
        this.gqP.setVisibility(8);
    }
}
