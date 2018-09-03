package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.k.g gje;
    private d gjk;
    BdTypeListView gjx;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener etY = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.js()) {
                if (h.this.gje != null) {
                    h.this.gje.Q(h.this.mRootView);
                    h.this.gje = null;
                }
                if (h.this.gjk != null) {
                    h.this.gjk.blh();
                }
            }
        }
    };

    public BdTypeListView blt() {
        return this.gjx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gjx = (BdTypeListView) view.findViewById(f.g.list);
    }

    public d blu() {
        return this.gjk;
    }

    public void b(d dVar) {
        this.gjk = dVar;
    }

    public void E(String str, boolean z) {
        f.a(this.gje, this.etY, this.mContext, this.mRootView, str, z);
        this.gjx.setVisibility(8);
    }
}
