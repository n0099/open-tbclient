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
    private com.baidu.tbadk.k.h eQN;
    private NavigationBarShadowView iAd;
    private d klY;
    BdTypeListView kmn;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener inj = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.eQN != null) {
                    h.this.eQN.dettachView(h.this.mRootView);
                    h.this.eQN = null;
                }
                if (h.this.klY != null) {
                    h.this.klY.cLb();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.iAd.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.iAd.hide();
            }
        }
    };

    public BdTypeListView cLm() {
        return this.kmn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.kmn = (BdTypeListView) view.findViewById(R.id.list);
        this.iAd = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.kmn.setOnScrollListener(this.mOnScrollListener);
    }

    public d cLn() {
        return this.klY;
    }

    public void b(d dVar) {
        this.klY = dVar;
    }

    public void at(String str, boolean z) {
        f.a(this.eQN, this.inj, this.mContext, this.mRootView, str, z);
        this.kmn.setVisibility(8);
    }
}
