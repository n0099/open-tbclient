package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dmN;
    private d iuf;
    BdTypeListView ius;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gBW = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (h.this.dmN != null) {
                    h.this.dmN.dettachView(h.this.mRootView);
                    h.this.dmN = null;
                }
                if (h.this.iuf != null) {
                    h.this.iuf.ccx();
                }
            }
        }
    };

    public BdTypeListView ccI() {
        return this.ius;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.ius = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d ccJ() {
        return this.iuf;
    }

    public void b(d dVar) {
        this.iuf = dVar;
    }

    public void aj(String str, boolean z) {
        f.a(this.dmN, this.gBW, this.mContext, this.mRootView, str, z);
        this.ius.setVisibility(8);
    }
}
