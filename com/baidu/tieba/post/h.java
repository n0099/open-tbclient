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
    private com.baidu.tbadk.k.h gfk;
    private NavigationBarShadowView koh;
    private Context mContext;
    private View mRootView;
    private d mhC;
    BdTypeListView mhR;
    NoDataView mNoDataView = null;
    private View.OnClickListener kbd = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gfk != null) {
                    h.this.gfk.dettachView(h.this.mRootView);
                    h.this.gfk = null;
                }
                if (h.this.mhC != null) {
                    h.this.mhC.dvt();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.koh.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.koh.hide();
            }
        }
    };

    public BdTypeListView dvE() {
        return this.mhR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mhR = (BdTypeListView) view.findViewById(R.id.list);
        this.koh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mhR.setOnScrollListener(this.mOnScrollListener);
    }

    public d dvF() {
        return this.mhC;
    }

    public void b(d dVar) {
        this.mhC = dVar;
    }

    public void aQ(String str, boolean z) {
        f.a(this.gfk, this.kbd, this.mContext, this.mRootView, str, z);
        this.mhR.setVisibility(8);
    }
}
