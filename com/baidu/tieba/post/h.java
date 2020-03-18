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
    private com.baidu.tbadk.k.h eno;
    private NavigationBarShadowView hQm;
    private d jBT;
    BdTypeListView jCi;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener hDu = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.eno != null) {
                    h.this.eno.dettachView(h.this.mRootView);
                    h.this.eno = null;
                }
                if (h.this.jBT != null) {
                    h.this.jBT.cAr();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.hQm.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.hQm.hide();
            }
        }
    };

    public BdTypeListView cAB() {
        return this.jCi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.jCi = (BdTypeListView) view.findViewById(R.id.list);
        this.hQm = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.jCi.setOnScrollListener(this.mOnScrollListener);
    }

    public d cAC() {
        return this.jBT;
    }

    public void b(d dVar) {
        this.jBT = dVar;
    }

    public void an(String str, boolean z) {
        f.a(this.eno, this.hDu, this.mContext, this.mRootView, str, z);
        this.jCi.setVisibility(8);
    }
}
