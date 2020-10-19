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
    private com.baidu.tbadk.k.h fVg;
    private NavigationBarShadowView kbI;
    private d lVd;
    BdTypeListView lVs;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener jOE = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.fVg != null) {
                    h.this.fVg.dettachView(h.this.mRootView);
                    h.this.fVg = null;
                }
                if (h.this.lVd != null) {
                    h.this.lVd.dsm();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kbI.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kbI.hide();
            }
        }
    };

    public BdTypeListView dsx() {
        return this.lVs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.lVs = (BdTypeListView) view.findViewById(R.id.list);
        this.kbI = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.lVs.setOnScrollListener(this.mOnScrollListener);
    }

    public d dsy() {
        return this.lVd;
    }

    public void b(d dVar) {
        this.lVd = dVar;
    }

    public void aO(String str, boolean z) {
        f.a(this.fVg, this.jOE, this.mContext, this.mRootView, str, z);
        this.lVs.setVisibility(8);
    }
}
