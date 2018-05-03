package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    BdTypeListView fSB;
    private com.baidu.tbadk.j.g fSi;
    private d fSo;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener dZT = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (com.baidu.adp.lib.util.j.gD()) {
                if (h.this.fSi != null) {
                    h.this.fSi.P(h.this.mRootView);
                    h.this.fSi = null;
                }
                if (h.this.fSo != null) {
                    h.this.fSo.bhp();
                }
            }
        }
    };

    public BdTypeListView bhB() {
        return this.fSB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view2) {
        this.mContext = context;
        this.mRootView = view2;
        this.fSB = (BdTypeListView) view2.findViewById(d.g.list);
    }

    public d bhC() {
        return this.fSo;
    }

    public void b(d dVar) {
        this.fSo = dVar;
    }

    public void E(String str, boolean z) {
        f.a(this.fSi, this.dZT, this.mContext, this.mRootView, str, z);
        this.fSB.setVisibility(8);
    }
}
