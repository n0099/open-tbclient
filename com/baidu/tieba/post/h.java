package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h {
    private com.baidu.tbadk.k.h eiA;
    private NavigationBarShadowView hMA;
    BdTypeListView jzA;
    private d jzl;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener hzH = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.eiA != null) {
                    h.this.eiA.dettachView(h.this.mRootView);
                    h.this.eiA = null;
                }
                if (h.this.jzl != null) {
                    h.this.jzl.cyx();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.hMA.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.hMA.hide();
            }
        }
    };

    public BdTypeListView cyH() {
        return this.jzA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.jzA = (BdTypeListView) view.findViewById(R.id.list);
        this.hMA = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.jzA.setOnScrollListener(this.mOnScrollListener);
    }

    public d cyI() {
        return this.jzl;
    }

    public void b(d dVar) {
        this.jzl = dVar;
    }

    public void an(String str, boolean z) {
        f.a(this.eiA, this.hzH, this.mContext, this.mRootView, str, z);
        this.jzA.setVisibility(8);
    }
}
