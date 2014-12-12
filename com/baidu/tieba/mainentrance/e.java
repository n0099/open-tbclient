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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private SearchPostModel bqR = null;
    private int bqS = 0;
    private Context mContext;

    public e(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setRefreshing(int i) {
        this.bqS = i;
    }

    public int TD() {
        return this.bqS;
    }

    public boolean TE() {
        if (this.bqR == null) {
            return false;
        }
        return this.bqR.hasPre();
    }

    public boolean TF() {
        if (this.bqR == null) {
            return false;
        }
        return this.bqR.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.bqR = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bqR == null || this.bqR.getData() == null) {
            return 0;
        }
        int size = this.bqR.getData().size();
        if (TE()) {
            size++;
        }
        if (TF()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.bqR == null || this.bqR.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.bqR.getData().size()) {
            return null;
        }
        return this.bqR.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bqR == null || this.bqR.getData() == null) {
            return -1L;
        }
        if (TE()) {
            if (i <= this.bqR.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.bqR.getData().size()) {
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
        if (this.bqR != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    gVar = new g(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.search_post_item, null);
                    gVar.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
                    gVar.mLine = view.findViewById(com.baidu.tieba.w.search_post_lv_search_forum_divider);
                    gVar.bqW = (TextView) view.findViewById(com.baidu.tieba.w.content);
                    gVar.aPs = (TextView) view.findViewById(com.baidu.tieba.w.forum);
                    gVar.axA = (TextView) view.findViewById(com.baidu.tieba.w.time);
                    gVar.bqX = (LinearLayout) view.findViewById(com.baidu.tieba.w.square_search_content_layout);
                    view.setTag(gVar);
                    fVar = null;
                } else {
                    f fVar2 = new f(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.page_item, null);
                    fVar2.bqT = (RelativeLayout) view.findViewById(com.baidu.tieba.w.page_container);
                    fVar2.bqU = (TextView) view.findViewById(com.baidu.tieba.w.page_text);
                    fVar2.Bs = (ProgressBar) view.findViewById(com.baidu.tieba.w.progress);
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
                    gVar.aPs.setText(String.valueOf(hVar.TH()) + this.mContext.getString(com.baidu.tieba.z.bar));
                    gVar.axA.setText(ba.n(hVar.getTime()));
                    if (hVar.getContent() == null || hVar.getContent().length() < 1) {
                        gVar.bqX.setVisibility(8);
                    } else {
                        gVar.bqX.setVisibility(0);
                        gVar.bqW.setText(Html.fromHtml(ba.a(hVar.getContent(), (Color) null)));
                    }
                    gVar.mTitle.setText(Html.fromHtml(ba.a(hVar.getTitle(), (Color) null)));
                    ax.c(gVar.bqW, skinType);
                    if (skinType == 0) {
                        gVar.aPs.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                        gVar.axA.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                        gVar.bqW.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_b));
                    } else {
                        gVar.aPs.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                        gVar.axA.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                        gVar.bqW.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_b_1));
                    }
                    ax.j(gVar.mLine, com.baidu.tieba.t.cp_bg_line_b);
                    ax.i(gVar.bqX, com.baidu.tieba.v.bg_search_tiezi);
                    ax.b(gVar.mTitle, com.baidu.tieba.t.cp_cont_c, 1);
                }
            } else {
                if (getItemId(i) == -1) {
                    if (this.bqS == 1) {
                        fVar.Bs.setVisibility(0);
                        fVar.bqU.setText(this.mContext.getString(com.baidu.tieba.z.loading));
                    } else {
                        fVar.Bs.setVisibility(8);
                        fVar.bqU.setText(this.mContext.getString(com.baidu.tieba.z.pre_page));
                    }
                    ax.c(fVar.bqU, skinType);
                } else {
                    if (this.bqS == 2) {
                        fVar.Bs.setVisibility(0);
                        fVar.bqU.setText(this.mContext.getString(com.baidu.tieba.z.loading));
                    } else {
                        fVar.Bs.setVisibility(8);
                        fVar.bqU.setText(this.mContext.getString(com.baidu.tieba.z.next_page));
                    }
                    ax.c(fVar.bqU, skinType);
                }
                ax.i(fVar.bqT, com.baidu.tieba.v.list_item_selector);
            }
        }
        return view;
    }
}
