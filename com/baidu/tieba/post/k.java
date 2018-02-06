package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k {
    private d gxA;
    BdTypeListView gxN;
    private com.baidu.tbadk.j.g gxu;
    private Context mContext;
    private View mRootView;
    com.baidu.tbadk.core.view.h mNoDataView = null;
    private View.OnClickListener eFn = new View.OnClickListener() { // from class: com.baidu.tieba.post.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ox()) {
                if (k.this.gxu != null) {
                    k.this.gxu.bk(k.this.mRootView);
                    k.this.gxu = null;
                }
                if (k.this.gxA != null) {
                    k.this.gxA.bmj();
                }
            }
        }
    };

    public BdTypeListView bmv() {
        return this.gxN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gxN = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bmw() {
        return this.gxA;
    }

    public void b(d dVar) {
        this.gxA = dVar;
    }

    public void I(String str, boolean z) {
        g.a(this.gxu, this.eFn, this.mContext, this.mRootView, str, z);
        this.gxN.setVisibility(8);
    }
}
