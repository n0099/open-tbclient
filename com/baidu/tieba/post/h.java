package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.k.g gjf;
    private d gjl;
    BdTypeListView gjy;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener euc = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.js()) {
                if (h.this.gjf != null) {
                    h.this.gjf.Q(h.this.mRootView);
                    h.this.gjf = null;
                }
                if (h.this.gjl != null) {
                    h.this.gjl.blk();
                }
            }
        }
    };

    public BdTypeListView blw() {
        return this.gjy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gjy = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d blx() {
        return this.gjl;
    }

    public void b(d dVar) {
        this.gjl = dVar;
    }

    public void E(String str, boolean z) {
        f.a(this.gjf, this.euc, this.mContext, this.mRootView, str, z);
        this.gjy.setVisibility(8);
    }
}
