package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class h {
    private com.baidu.tbadk.k.h fug;
    private NavigationBarShadowView jpe;
    BdTypeListView lgJ;
    private d lgu;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener jbZ = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.fug != null) {
                    h.this.fug.dettachView(h.this.mRootView);
                    h.this.fug = null;
                }
                if (h.this.lgu != null) {
                    h.this.lgu.cZN();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.jpe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.jpe.hide();
            }
        }
    };

    public BdTypeListView cZY() {
        return this.lgJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.lgJ = (BdTypeListView) view.findViewById(R.id.list);
        this.jpe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.lgJ.setOnScrollListener(this.mOnScrollListener);
    }

    public d cZZ() {
        return this.lgu;
    }

    public void b(d dVar) {
        this.lgu = dVar;
    }

    public void aG(String str, boolean z) {
        f.a(this.fug, this.jbZ, this.mContext, this.mRootView, str, z);
        this.lgJ.setVisibility(8);
    }
}
