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
    private SearchPostModel bsp = null;
    private int bsq = 0;
    private Context mContext;

    public e(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setRefreshing(int i) {
        this.bsq = i;
    }

    public int TZ() {
        return this.bsq;
    }

    public boolean Ua() {
        if (this.bsp == null) {
            return false;
        }
        return this.bsp.hasPre();
    }

    public boolean Ub() {
        if (this.bsp == null) {
            return false;
        }
        return this.bsp.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.bsp = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bsp == null || this.bsp.getData() == null) {
            return 0;
        }
        int size = this.bsp.getData().size();
        if (Ua()) {
            size++;
        }
        if (Ub()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.bsp == null || this.bsp.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.bsp.getData().size()) {
            return null;
        }
        return this.bsp.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bsp == null || this.bsp.getData() == null) {
            return -1L;
        }
        if (Ua()) {
            if (i <= this.bsp.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.bsp.getData().size()) {
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
        if (this.bsp != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    gVar = new g(this, null);
                    view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.search_post_item, null);
                    gVar.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
                    gVar.Td = view.findViewById(com.baidu.tieba.w.search_post_lv_search_forum_divider);
                    gVar.bsu = (TextView) view.findViewById(com.baidu.tieba.w.content);
                    gVar.aQx = (TextView) view.findViewById(com.baidu.tieba.w.forum);
                    gVar.ayA = (TextView) view.findViewById(com.baidu.tieba.w.time);
                    gVar.bsv = (LinearLayout) view.findViewById(com.baidu.tieba.w.square_search_content_layout);
                    view.setTag(gVar);
                    fVar = null;
                } else {
                    f fVar2 = new f(this, null);
                    view = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.page_item, null);
                    fVar2.bsr = (RelativeLayout) view.findViewById(com.baidu.tieba.w.page_container);
                    fVar2.bss = (TextView) view.findViewById(com.baidu.tieba.w.page_text);
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
                    gVar.aQx.setText(String.valueOf(hVar.Ud()) + this.mContext.getString(com.baidu.tieba.z.bar));
                    gVar.ayA.setText(bf.n(hVar.getTime()));
                    if (hVar.getContent() == null || hVar.getContent().length() < 1) {
                        gVar.bsv.setVisibility(8);
                    } else {
                        gVar.bsv.setVisibility(0);
                        gVar.bsu.setText(Html.fromHtml(bf.a(hVar.getContent(), (Color) null)));
                    }
                    gVar.mTitle.setText(Html.fromHtml(bf.a(hVar.getTitle(), (Color) null)));
                    bc.c(gVar.bsu, skinType);
                    if (skinType == 0) {
                        gVar.aQx.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                        gVar.ayA.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d));
                        gVar.bsu.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_b));
                    } else {
                        gVar.aQx.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                        gVar.ayA.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_d_1));
                        gVar.bsu.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.t.cp_cont_b_1));
                    }
                    bc.j(gVar.Td, com.baidu.tieba.t.cp_bg_line_b);
                    bc.i(gVar.bsv, com.baidu.tieba.v.bg_search_tiezi);
                    bc.b(gVar.mTitle, com.baidu.tieba.t.cp_cont_c, 1);
                }
            } else {
                if (getItemId(i) == -1) {
                    if (this.bsq == 1) {
                        fVar.Bs.setVisibility(0);
                        fVar.bss.setText(this.mContext.getString(com.baidu.tieba.z.loading));
                    } else {
                        fVar.Bs.setVisibility(8);
                        fVar.bss.setText(this.mContext.getString(com.baidu.tieba.z.pre_page));
                    }
                    bc.c(fVar.bss, skinType);
                } else {
                    if (this.bsq == 2) {
                        fVar.Bs.setVisibility(0);
                        fVar.bss.setText(this.mContext.getString(com.baidu.tieba.z.loading));
                    } else {
                        fVar.Bs.setVisibility(8);
                        fVar.bss.setText(this.mContext.getString(com.baidu.tieba.z.next_page));
                    }
                    bc.c(fVar.bss, skinType);
                }
                bc.i(fVar.bsr, com.baidu.tieba.v.list_item_selector);
            }
        }
        return view;
    }
}
