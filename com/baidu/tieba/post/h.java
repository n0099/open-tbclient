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
    private com.baidu.tbadk.k.h eQS;
    private NavigationBarShadowView iAj;
    private d kmc;
    BdTypeListView kmr;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener inp = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.eQS != null) {
                    h.this.eQS.dettachView(h.this.mRootView);
                    h.this.eQS = null;
                }
                if (h.this.kmc != null) {
                    h.this.kmc.cKZ();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.iAj.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.iAj.hide();
            }
        }
    };

    public BdTypeListView cLk() {
        return this.kmr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.kmr = (BdTypeListView) view.findViewById(R.id.list);
        this.iAj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.kmr.setOnScrollListener(this.mOnScrollListener);
    }

    public d cLl() {
        return this.kmc;
    }

    public void b(d dVar) {
        this.kmc = dVar;
    }

    public void at(String str, boolean z) {
        f.a(this.eQS, this.inp, this.mContext, this.mRootView, str, z);
        this.kmr.setVisibility(8);
    }
}
