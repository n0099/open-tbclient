package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    BdTypeListView gKD;
    private com.baidu.tbadk.k.g gKk;
    private d gKq;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eUN = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (h.this.gKk != null) {
                    h.this.gKk.dettachView(h.this.mRootView);
                    h.this.gKk = null;
                }
                if (h.this.gKq != null) {
                    h.this.gKq.btL();
                }
            }
        }
    };

    public BdTypeListView btX() {
        return this.gKD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gKD = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d btY() {
        return this.gKq;
    }

    public void b(d dVar) {
        this.gKq = dVar;
    }

    public void N(String str, boolean z) {
        f.a(this.gKk, this.eUN, this.mContext, this.mRootView, str, z);
        this.gKD.setVisibility(8);
    }
}
