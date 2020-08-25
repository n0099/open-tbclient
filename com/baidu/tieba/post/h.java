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
    private com.baidu.tbadk.k.h fFz;
    private NavigationBarShadowView jEc;
    private d lwN;
    BdTypeListView lxc;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener jqZ = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.fFz != null) {
                    h.this.fFz.dettachView(h.this.mRootView);
                    h.this.fFz = null;
                }
                if (h.this.lwN != null) {
                    h.this.lwN.dkR();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.jEc.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.jEc.hide();
            }
        }
    };

    public BdTypeListView dlc() {
        return this.lxc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.lxc = (BdTypeListView) view.findViewById(R.id.list);
        this.jEc = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.lxc.setOnScrollListener(this.mOnScrollListener);
    }

    public d dld() {
        return this.lwN;
    }

    public void b(d dVar) {
        this.lwN = dVar;
    }

    public void aK(String str, boolean z) {
        f.a(this.fFz, this.jqZ, this.mContext, this.mRootView, str, z);
        this.lxc.setVisibility(8);
    }
}
