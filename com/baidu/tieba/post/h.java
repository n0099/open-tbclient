package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dck;
    private d ibB;
    BdTypeListView ibO;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gkJ = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (h.this.dck != null) {
                    h.this.dck.dettachView(h.this.mRootView);
                    h.this.dck = null;
                }
                if (h.this.ibB != null) {
                    h.this.ibB.bUw();
                }
            }
        }
    };

    public BdTypeListView bUI() {
        return this.ibO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.ibO = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bUJ() {
        return this.ibB;
    }

    public void b(d dVar) {
        this.ibB = dVar;
    }

    public void ah(String str, boolean z) {
        f.a(this.dck, this.gkJ, this.mContext, this.mRootView, str, z);
        this.ibO.setVisibility(8);
    }
}
