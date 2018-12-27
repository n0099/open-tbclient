package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.k.g gJg;
    private d gJm;
    BdTypeListView gJz;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eUa = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (h.this.gJg != null) {
                    h.this.gJg.dettachView(h.this.mRootView);
                    h.this.gJg = null;
                }
                if (h.this.gJm != null) {
                    h.this.gJm.btc();
                }
            }
        }
    };

    public BdTypeListView bto() {
        return this.gJz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gJz = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d btp() {
        return this.gJm;
    }

    public void b(d dVar) {
        this.gJm = dVar;
    }

    public void O(String str, boolean z) {
        f.a(this.gJg, this.eUa, this.mContext, this.mRootView, str, z);
        this.gJz.setVisibility(8);
    }
}
