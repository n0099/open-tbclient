package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dcf;
    private d ibO;
    BdTypeListView icb;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gkV = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (h.this.dcf != null) {
                    h.this.dcf.dettachView(h.this.mRootView);
                    h.this.dcf = null;
                }
                if (h.this.ibO != null) {
                    h.this.ibO.bUA();
                }
            }
        }
    };

    public BdTypeListView bUM() {
        return this.icb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.icb = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bUN() {
        return this.ibO;
    }

    public void b(d dVar) {
        this.ibO = dVar;
    }

    public void ah(String str, boolean z) {
        f.a(this.dcf, this.gkV, this.mContext, this.mRootView, str, z);
        this.icb.setVisibility(8);
    }
}
