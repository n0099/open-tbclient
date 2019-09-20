package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dqr;
    private d iDW;
    BdTypeListView iEj;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gKT = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (h.this.dqr != null) {
                    h.this.dqr.dettachView(h.this.mRootView);
                    h.this.dqr = null;
                }
                if (h.this.iDW != null) {
                    h.this.iDW.cgx();
                }
            }
        }
    };

    public BdTypeListView cgJ() {
        return this.iEj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iEj = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d cgK() {
        return this.iDW;
    }

    public void b(d dVar) {
        this.iDW = dVar;
    }

    public void an(String str, boolean z) {
        f.a(this.dqr, this.gKT, this.mContext, this.mRootView, str, z);
        this.iEj.setVisibility(8);
    }
}
