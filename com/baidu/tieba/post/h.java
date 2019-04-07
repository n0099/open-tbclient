package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dcj;
    private d ibA;
    BdTypeListView ibN;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gkI = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (h.this.dcj != null) {
                    h.this.dcj.dettachView(h.this.mRootView);
                    h.this.dcj = null;
                }
                if (h.this.ibA != null) {
                    h.this.ibA.bUw();
                }
            }
        }
    };

    public BdTypeListView bUI() {
        return this.ibN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.ibN = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bUJ() {
        return this.ibA;
    }

    public void b(d dVar) {
        this.ibA = dVar;
    }

    public void ah(String str, boolean z) {
        f.a(this.dcj, this.gkI, this.mContext, this.mRootView, str, z);
        this.ibN.setVisibility(8);
    }
}
