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
    private com.baidu.tbadk.k.h fFD;
    private NavigationBarShadowView jEi;
    private d lwY;
    BdTypeListView lxn;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener jrf = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.fFD != null) {
                    h.this.fFD.dettachView(h.this.mRootView);
                    h.this.fFD = null;
                }
                if (h.this.lwY != null) {
                    h.this.lwY.dkU();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.jEi.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.jEi.hide();
            }
        }
    };

    public BdTypeListView dlf() {
        return this.lxn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.lxn = (BdTypeListView) view.findViewById(R.id.list);
        this.jEi = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.lxn.setOnScrollListener(this.mOnScrollListener);
    }

    public d dlg() {
        return this.lwY;
    }

    public void b(d dVar) {
        this.lwY = dVar;
    }

    public void aK(String str, boolean z) {
        f.a(this.fFD, this.jrf, this.mContext, this.mRootView, str, z);
        this.lxn.setVisibility(8);
    }
}
