package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private SearchPostModel bso = null;
    private int bsp = 0;
    private Context mContext;

    public e(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setRefreshing(int i) {
        this.bsp = i;
    }

    public int TU() {
        return this.bsp;
    }

    public boolean TV() {
        if (this.bso == null) {
            return false;
        }
        return this.bso.hasPre();
    }

    public boolean TW() {
        if (this.bso == null) {
            return false;
        }
        return this.bso.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.bso = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bso == null || this.bso.getData() == null) {
            return 0;
        }
        int size = this.bso.getData().size();
        if (TV()) {
            size++;
        }
        if (TW()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.bso == null || this.bso.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.bso.getData().size()) {
            return null;
        }
        return this.bso.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bso == null || this.bso.getData() == null) {
            return -1L;
        }
        if (TV()) {
            if (i <= this.bso.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.bso.getData().size()) {
            return i;
        } else {
            return -2L;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        g gVar;
        if (this.bso != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    gVar = new g(this, null);
                    view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.search_post_item, null);
                    gVar.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
                    gVar.Ta = view.findViewById(com.baidu.tieba.w.search_post_lv_search_forum_divider);
                    gVar.bst = (TextView) view.findViewById(com.baidu.tieba.w.content);
                    gVar.aQw = (TextView) view.findViewById(com.baidu.tieba.w.forum);
                    gVar.ayx = (TextView) view.findViewById(com.baidu.tieba.w.time);
                    gVar.bsu = (LinearLayout) view.findViewById(com.baidu.tieba.w.square_search_content_layout);
                    view.setTag(gVar);
                    fVar = null;
                } else {
                    f fVar2 = new f(this, null);
                    view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.page_item, null);
                    fVar2.bsq = (RelativeLayout) view.findViewById(com.baidu.tieba.w.page_container);
                    fVar2.bsr = (TextView) view.findViewById(com.baidu.tieba.w.page_text);
                    fVar2.Bp = (ProgressBar) view.findViewById(com.baidu.tieba.w.progress);
                    view.setTag(fVar2);
                    fVar = fVar2;
                    gVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                gVar = (g) view.getTag();
                fVar = null;
            } else {
                fVar = (f) view.getTag();
                gVar = null;
            }
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (getItemViewType(i) == 0) {
                h hVar = (h) getItem(i);
                if (hVar != null) {
                    gVar.aQw.setText(String.valueOf(hVar.TY()) + this.mContext.getString(com.baidu.tieba.z.bar));
                    gVar.ayx.setText(bf.n(hVar.getTime()));
                    if (hVar.getContent() == null || hVar.getContent().length() < 1) {
                        gVar.bsu.setVisibility(8);
                    } else {
                        gVar.bsu.setVisibility(0);
                        gVar.bst.setText(Html.fromHtml(bf.a(hVar.getContent(), (Color) null)));
                    }
                    gVar.mTitle.setText(Html.fromHtml(bf.a(hVar.getTitle(), (Color) null)));
                    bc.c(gVar.bst, skinType);
                    if (skinType == 0) {
                        gVar.aQw.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                        gVar.ayx.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                        gVar.bst.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_b));
                    } else {
                        gVar.aQw.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                        gVar.ayx.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                        gVar.bst.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_b_1));
                    }
                    bc.j(gVar.Ta, com.baidu.tieba.t.cp_bg_line_b);
                    bc.i(gVar.bsu, com.baidu.tieba.v.bg_search_tiezi);
                    bc.b(gVar.mTitle, com.baidu.tieba.t.cp_cont_c, 1);
                }
            } else {
                if (getItemId(i) == -1) {
                    if (this.bsp == 1) {
                        fVar.Bp.setVisibility(0);
                        fVar.bsr.setText(this.mContext.getString(com.baidu.tieba.z.loading));
                    } else {
                        fVar.Bp.setVisibility(8);
                        fVar.bsr.setText(this.mContext.getString(com.baidu.tieba.z.pre_page));
                    }
                    bc.c(fVar.bsr, skinType);
                } else {
                    if (this.bsp == 2) {
                        fVar.Bp.setVisibility(0);
                        fVar.bsr.setText(this.mContext.getString(com.baidu.tieba.z.loading));
                    } else {
                        fVar.Bp.setVisibility(8);
                        fVar.bsr.setText(this.mContext.getString(com.baidu.tieba.z.next_page));
                    }
                    bc.c(fVar.bsr, skinType);
                }
                bc.i(fVar.bsq, com.baidu.tieba.v.list_item_selector);
            }
        }
        return view;
    }
}
