package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dxB;
    BdTypeListView iCF;
    private d iCs;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gIR = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.dxB != null) {
                    h.this.dxB.dettachView(h.this.mRootView);
                    h.this.dxB = null;
                }
                if (h.this.iCs != null) {
                    h.this.iCs.cdx();
                }
            }
        }
    };

    public BdTypeListView cdJ() {
        return this.iCF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iCF = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d cdK() {
        return this.iCs;
    }

    public void b(d dVar) {
        this.iCs = dVar;
    }

    public void aj(String str, boolean z) {
        f.a(this.dxB, this.gIR, this.mContext, this.mRootView, str, z);
        this.iCF.setVisibility(8);
    }
}
