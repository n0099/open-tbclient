package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h doz;
    private d iAA;
    BdTypeListView iAN;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gIj = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (h.this.doz != null) {
                    h.this.doz.dettachView(h.this.mRootView);
                    h.this.doz = null;
                }
                if (h.this.iAA != null) {
                    h.this.iAA.cfr();
                }
            }
        }
    };

    public BdTypeListView cfD() {
        return this.iAN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iAN = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d cfE() {
        return this.iAA;
    }

    public void b(d dVar) {
        this.iAA = dVar;
    }

    public void an(String str, boolean z) {
        f.a(this.doz, this.gIj, this.mContext, this.mRootView, str, z);
        this.iAN.setVisibility(8);
    }
}
