package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.j.g geD;
    private d geJ;
    BdTypeListView geW;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener emn = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jr()) {
                if (h.this.geD != null) {
                    h.this.geD.P(h.this.mRootView);
                    h.this.geD = null;
                }
                if (h.this.geJ != null) {
                    h.this.geJ.bmn();
                }
            }
        }
    };

    public BdTypeListView bmz() {
        return this.geW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.geW = (BdTypeListView) view.findViewById(d.g.list);
    }

    public d bmA() {
        return this.geJ;
    }

    public void b(d dVar) {
        this.geJ = dVar;
    }

    public void E(String str, boolean z) {
        f.a(this.geD, this.emn, this.mContext, this.mRootView, str, z);
        this.geW.setVisibility(8);
    }
}
