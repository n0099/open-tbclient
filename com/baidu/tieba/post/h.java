package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class h {
    private com.baidu.tbadk.k.h gkZ;
    private NavigationBarShadowView kud;
    private Context mContext;
    private View mRootView;
    private d mnA;
    BdTypeListView mnP;
    NoDataView mNoDataView = null;
    private View.OnClickListener kha = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gkZ != null) {
                    h.this.gkZ.dettachView(h.this.mRootView);
                    h.this.gkZ = null;
                }
                if (h.this.mnA != null) {
                    h.this.mnA.dxV();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kud.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kud.hide();
            }
        }
    };

    public BdTypeListView dyg() {
        return this.mnP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mnP = (BdTypeListView) view.findViewById(R.id.list);
        this.kud = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mnP.setOnScrollListener(this.mOnScrollListener);
    }

    public d dyh() {
        return this.mnA;
    }

    public void b(d dVar) {
        this.mnA = dVar;
    }

    public void aQ(String str, boolean z) {
        f.a(this.gkZ, this.kha, this.mContext, this.mRootView, str, z);
        this.mnP.setVisibility(8);
    }
}
