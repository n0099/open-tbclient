package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class h {
    private com.baidu.tbadk.k.h foV;
    private NavigationBarShadowView jgG;
    private d kZb;
    BdTypeListView kZq;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener iTN = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.foV != null) {
                    h.this.foV.dettachView(h.this.mRootView);
                    h.this.foV = null;
                }
                if (h.this.kZb != null) {
                    h.this.kZb.cWG();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.jgG.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.jgG.hide();
            }
        }
    };

    public BdTypeListView cWR() {
        return this.kZq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.kZq = (BdTypeListView) view.findViewById(R.id.list);
        this.jgG = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.kZq.setOnScrollListener(this.mOnScrollListener);
    }

    public d cWS() {
        return this.kZb;
    }

    public void b(d dVar) {
        this.kZb = dVar;
    }

    public void aI(String str, boolean z) {
        f.a(this.foV, this.iTN, this.mContext, this.mRootView, str, z);
        this.kZq.setVisibility(8);
    }
}
