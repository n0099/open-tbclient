package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dmO;
    private d iui;
    BdTypeListView iuv;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gBX = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (h.this.dmO != null) {
                    h.this.dmO.dettachView(h.this.mRootView);
                    h.this.dmO = null;
                }
                if (h.this.iui != null) {
                    h.this.iui.ccA();
                }
            }
        }
    };

    public BdTypeListView ccL() {
        return this.iuv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iuv = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d ccM() {
        return this.iui;
    }

    public void b(d dVar) {
        this.iui = dVar;
    }

    public void aj(String str, boolean z) {
        f.a(this.dmO, this.gBX, this.mContext, this.mRootView, str, z);
        this.iuv.setVisibility(8);
    }
}
