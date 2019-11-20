package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dwK;
    private d iBB;
    BdTypeListView iBO;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gIa = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.dwK != null) {
                    h.this.dwK.dettachView(h.this.mRootView);
                    h.this.dwK = null;
                }
                if (h.this.iBB != null) {
                    h.this.iBB.cdv();
                }
            }
        }
    };

    public BdTypeListView cdH() {
        return this.iBO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iBO = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d cdI() {
        return this.iBB;
    }

    public void b(d dVar) {
        this.iBB = dVar;
    }

    public void aj(String str, boolean z) {
        f.a(this.dwK, this.gIa, this.mContext, this.mRootView, str, z);
        this.iBO.setVisibility(8);
    }
}
