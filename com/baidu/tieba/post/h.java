package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h doG;
    private d iBE;
    BdTypeListView iBR;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gJb = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jQ()) {
                if (h.this.doG != null) {
                    h.this.doG.dettachView(h.this.mRootView);
                    h.this.doG = null;
                }
                if (h.this.iBE != null) {
                    h.this.iBE.cfJ();
                }
            }
        }
    };

    public BdTypeListView cfV() {
        return this.iBR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iBR = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d cfW() {
        return this.iBE;
    }

    public void b(d dVar) {
        this.iBE = dVar;
    }

    public void an(String str, boolean z) {
        f.a(this.doG, this.gJb, this.mContext, this.mRootView, str, z);
        this.iBR.setVisibility(8);
    }
}
