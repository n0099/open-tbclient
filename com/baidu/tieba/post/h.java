package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.j.g giE;
    private d giK;
    BdTypeListView giX;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eqj = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jr()) {
                if (h.this.giE != null) {
                    h.this.giE.Q(h.this.mRootView);
                    h.this.giE = null;
                }
                if (h.this.giK != null) {
                    h.this.giK.bmR();
                }
            }
        }
    };

    public BdTypeListView bnd() {
        return this.giX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.giX = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bne() {
        return this.giK;
    }

    public void b(d dVar) {
        this.giK = dVar;
    }

    public void F(String str, boolean z) {
        f.a(this.giE, this.eqj, this.mContext, this.mRootView, str, z);
        this.giX.setVisibility(8);
    }
}
