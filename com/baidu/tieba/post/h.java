package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.k.g gxX;
    private d gyd;
    BdTypeListView gyq;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eJb = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (h.this.gxX != null) {
                    h.this.gxX.ad(h.this.mRootView);
                    h.this.gxX = null;
                }
                if (h.this.gyd != null) {
                    h.this.gyd.brc();
                }
            }
        }
    };

    public BdTypeListView bro() {
        return this.gyq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gyq = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d brp() {
        return this.gyd;
    }

    public void b(d dVar) {
        this.gyd = dVar;
    }

    public void M(String str, boolean z) {
        f.a(this.gxX, this.eJb, this.mContext, this.mRootView, str, z);
        this.gyq.setVisibility(8);
    }
}
