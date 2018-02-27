package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k {
    BdTypeListView gxC;
    private com.baidu.tbadk.j.g gxj;
    private d gxp;
    private Context mContext;
    private View mRootView;
    com.baidu.tbadk.core.view.h mNoDataView = null;
    private View.OnClickListener eFb = new View.OnClickListener() { // from class: com.baidu.tieba.post.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ox()) {
                if (k.this.gxj != null) {
                    k.this.gxj.bk(k.this.mRootView);
                    k.this.gxj = null;
                }
                if (k.this.gxp != null) {
                    k.this.gxp.bmi();
                }
            }
        }
    };

    public BdTypeListView bmu() {
        return this.gxC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gxC = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bmv() {
        return this.gxp;
    }

    public void b(d dVar) {
        this.gxp = dVar;
    }

    public void H(String str, boolean z) {
        g.a(this.gxj, this.eFb, this.mContext, this.mRootView, str, z);
        this.gxC.setVisibility(8);
    }
}
