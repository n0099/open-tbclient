package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k {
    private d gxF;
    BdTypeListView gxS;
    private com.baidu.tbadk.j.g gxz;
    private Context mContext;
    private View mRootView;
    com.baidu.tbadk.core.view.h mNoDataView = null;
    private View.OnClickListener eFr = new View.OnClickListener() { // from class: com.baidu.tieba.post.k.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.ox()) {
                if (k.this.gxz != null) {
                    k.this.gxz.bk(k.this.mRootView);
                    k.this.gxz = null;
                }
                if (k.this.gxF != null) {
                    k.this.gxF.bmj();
                }
            }
        }
    };

    public BdTypeListView bmv() {
        return this.gxS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gxS = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bmw() {
        return this.gxF;
    }

    public void b(d dVar) {
        this.gxF = dVar;
    }

    public void H(String str, boolean z) {
        g.a(this.gxz, this.eFr, this.mContext, this.mRootView, str, z);
        this.gxS.setVisibility(8);
    }
}
