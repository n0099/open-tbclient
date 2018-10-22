package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class h {
    private com.baidu.tbadk.k.g gxY;
    private d gye;
    BdTypeListView gyr;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener eJc = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.kM()) {
                if (h.this.gxY != null) {
                    h.this.gxY.ad(h.this.mRootView);
                    h.this.gxY = null;
                }
                if (h.this.gye != null) {
                    h.this.gye.brc();
                }
            }
        }
    };

    public BdTypeListView bro() {
        return this.gyr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.gyr = (BdTypeListView) view.findViewById(e.g.list);
    }

    public d brp() {
        return this.gye;
    }

    public void b(d dVar) {
        this.gye = dVar;
    }

    public void M(String str, boolean z) {
        f.a(this.gxY, this.eJc, this.mContext, this.mRootView, str, z);
        this.gyr.setVisibility(8);
    }
}
