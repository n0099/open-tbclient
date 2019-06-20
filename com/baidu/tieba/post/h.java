package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class h {
    private com.baidu.tbadk.m.h dmO;
    private d iuj;
    BdTypeListView iuw;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener gBZ = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.jG()) {
                if (h.this.dmO != null) {
                    h.this.dmO.dettachView(h.this.mRootView);
                    h.this.dmO = null;
                }
                if (h.this.iuj != null) {
                    h.this.iuj.ccB();
                }
            }
        }
    };

    public BdTypeListView ccM() {
        return this.iuw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.iuw = (BdTypeListView) view.findViewById(R.id.list);
    }

    public d ccN() {
        return this.iuj;
    }

    public void b(d dVar) {
        this.iuj = dVar;
    }

    public void aj(String str, boolean z) {
        f.a(this.dmO, this.gBZ, this.mContext, this.mRootView, str, z);
        this.iuw.setVisibility(8);
    }
}
