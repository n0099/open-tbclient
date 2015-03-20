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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private PostSuggestModel byC = null;
    private int byD = 0;
    private Context mContext;

    public i(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setRefreshing(int i) {
        this.byD = i;
    }

    public int WD() {
        return this.byD;
    }

    public boolean WE() {
        if (this.byC == null) {
            return false;
        }
        return this.byC.hasPre();
    }

    public boolean WF() {
        if (this.byC == null) {
            return false;
        }
        return this.byC.hasMore();
    }

    public void a(PostSuggestModel postSuggestModel) {
        this.byC = postSuggestModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byC == null || this.byC.getData() == null) {
            return 0;
        }
        int size = this.byC.getData().size();
        if (WE()) {
            size++;
        }
        if (WF()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.byC == null || this.byC.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.byC.getData().size()) {
            return null;
        }
        return this.byC.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.byC == null || this.byC.getData() == null) {
            return -1L;
        }
        if (WE()) {
            if (i <= this.byC.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.byC.getData().size()) {
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
        j jVar;
        k kVar;
        if (this.byC != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    kVar = new k(this, null);
                    view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.search_post_item, null);
                    kVar.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.title);
                    kVar.acX = view.findViewById(com.baidu.tieba.v.search_post_lv_search_forum_divider);
                    kVar.byI = (TextView) view.findViewById(com.baidu.tieba.v.content);
                    kVar.aEv = (TextView) view.findViewById(com.baidu.tieba.v.forum);
                    kVar.aGK = (TextView) view.findViewById(com.baidu.tieba.v.time);
                    kVar.byJ = (LinearLayout) view.findViewById(com.baidu.tieba.v.square_search_content_layout);
                    view.setTag(kVar);
                    jVar = null;
                } else {
                    j jVar2 = new j(this, null);
                    view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.page_item, null);
                    jVar2.byE = (RelativeLayout) view.findViewById(com.baidu.tieba.v.page_container);
                    jVar2.byF = (TextView) view.findViewById(com.baidu.tieba.v.page_text);
                    jVar2.byG = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
                    view.setTag(jVar2);
                    jVar = jVar2;
                    kVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                kVar = (k) view.getTag();
                jVar = null;
            } else {
                jVar = (j) view.getTag();
                kVar = null;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (getItemViewType(i) == 0) {
                l lVar = (l) getItem(i);
                if (lVar != null) {
                    kVar.aEv.setText(String.valueOf(lVar.WH()) + this.mContext.getString(com.baidu.tieba.y.bar));
                    kVar.aGK.setText(bd.n(lVar.getTime()));
                    if (lVar.getContent() == null || lVar.getContent().length() < 1) {
                        kVar.byJ.setVisibility(8);
                    } else {
                        kVar.byJ.setVisibility(0);
                        kVar.byI.setText(Html.fromHtml(bd.a(lVar.getContent(), (Color) null)));
                    }
                    kVar.mTitle.setText(Html.fromHtml(bd.a(lVar.getTitle(), (Color) null)));
                    ba.c(kVar.byI, skinType);
                    if (skinType == 0) {
                        kVar.aEv.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                        kVar.aGK.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                        kVar.byI.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_b));
                    } else {
                        kVar.aEv.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                        kVar.aGK.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                        kVar.byI.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_b_1));
                    }
                    ba.j(kVar.acX, com.baidu.tieba.s.cp_bg_line_b);
                    ba.i(kVar.byJ, com.baidu.tieba.u.bg_search_tiezi);
                    ba.b(kVar.mTitle, com.baidu.tieba.s.cp_cont_c, 1);
                }
            } else {
                if (getItemId(i) == -1) {
                    if (this.byD == 1) {
                        jVar.byG.setVisibility(0);
                        jVar.byF.setText(this.mContext.getString(com.baidu.tieba.y.loading));
                    } else {
                        jVar.byG.setVisibility(8);
                        jVar.byF.setText(this.mContext.getString(com.baidu.tieba.y.pre_page));
                    }
                    ba.c(jVar.byF, skinType);
                } else {
                    if (this.byD == 2) {
                        jVar.byG.setVisibility(0);
                        jVar.byF.setText(this.mContext.getString(com.baidu.tieba.y.loading));
                    } else {
                        jVar.byG.setVisibility(8);
                        jVar.byF.setText(this.mContext.getString(com.baidu.tieba.y.next_page));
                    }
                    ba.c(jVar.byF, skinType);
                }
                ba.i(jVar.byE, com.baidu.tieba.u.list_item_selector);
            }
        }
        return view;
    }
}
