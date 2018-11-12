package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    private d gzF;
    BdTypeListView gzS;
    private com.baidu.tbadk.k.g gzz;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eKu = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kK()) {
                if (h.this.gzz != null) {
                    h.this.gzz.dettachView(h.this.mRootView);
                    h.this.gzz = null;
                }
                if (h.this.gzF != null) {
                    h.this.gzF.bqy();
                }
            }
        }
    };

    public BdTypeListView bqK() {
        return this.gzS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gzS = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d bqL() {
        return this.gzF;
    }

    public void b(d dVar) {
        this.gzF = dVar;
    }

    public void M(String str, boolean z) {
        f.a(this.gzz, this.eKu, this.mContext, this.mRootView, str, z);
        this.gzS.setVisibility(8);
    }
}
