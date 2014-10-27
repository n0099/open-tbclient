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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.aq;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private SearchPostModel blZ = null;
    private int bma = 0;
    private ArrayList<ProgressBar> bmb = null;
    private Context mContext;

    public e(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setRefreshing(int i) {
        this.bma = i;
    }

    public int Sx() {
        return this.bma;
    }

    public void Sy() {
        if (this.bmb != null) {
            Iterator<ProgressBar> it = this.bmb.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public boolean Sz() {
        if (this.blZ == null) {
            return false;
        }
        return this.blZ.hasPre();
    }

    public boolean SA() {
        if (this.blZ == null) {
            return false;
        }
        return this.blZ.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.blZ = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.blZ == null || this.blZ.getData() == null) {
            return 0;
        }
        int size = this.blZ.getData().size();
        if (Sz()) {
            size++;
        }
        if (SA()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.blZ == null || this.blZ.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.blZ.getData().size()) {
            return null;
        }
        return this.blZ.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.blZ == null || this.blZ.getData() == null) {
            return -1L;
        }
        if (Sz()) {
            if (i <= this.blZ.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.blZ.getData().size()) {
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
        if (this.blZ != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    gVar = new g(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.search_post_item, null);
                    gVar.JM = (TextView) view.findViewById(com.baidu.tieba.v.title);
                    gVar.MI = view.findViewById(com.baidu.tieba.v.search_post_lv_search_forum_divider);
                    gVar.bmf = (TextView) view.findViewById(com.baidu.tieba.v.content);
                    gVar.axq = (TextView) view.findViewById(com.baidu.tieba.v.forum);
                    gVar.auh = (TextView) view.findViewById(com.baidu.tieba.v.time);
                    gVar.bmg = (LinearLayout) view.findViewById(com.baidu.tieba.v.square_search_content_layout);
                    view.setTag(gVar);
                    fVar = null;
                } else {
                    f fVar2 = new f(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.page_item, null);
                    fVar2.bmc = (RelativeLayout) view.findViewById(com.baidu.tieba.v.page_container);
                    fVar2.bmd = (TextView) view.findViewById(com.baidu.tieba.v.page_text);
                    fVar2.xM = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
                    if (this.bmb == null) {
                        this.bmb = new ArrayList<>();
                    }
                    this.bmb.add(fVar2.xM);
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
            int skinType = TbadkApplication.m251getInst().getSkinType();
            if (getItemViewType(i) == 0) {
                aq aqVar = (aq) getItem(i);
                if (aqVar != null) {
                    gVar.axq.setText(String.valueOf(aqVar.Aq()) + this.mContext.getString(com.baidu.tieba.y.bar));
                    gVar.auh.setText(ay.j(aqVar.getTime()));
                    if (aqVar.getContent() == null || aqVar.getContent().length() < 1) {
                        gVar.bmg.setVisibility(8);
                    } else {
                        gVar.bmg.setVisibility(0);
                        gVar.bmf.setText(Html.fromHtml(ay.a(aqVar.getContent(), (Color) null)));
                    }
                    gVar.JM.setText(Html.fromHtml(ay.a(aqVar.getTitle(), (Color) null)));
                    aw.b(gVar.bmf, skinType);
                    if (skinType == 0) {
                        gVar.axq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content));
                        gVar.auh.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content));
                        gVar.bmf.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.square_search_text_content));
                    } else {
                        gVar.axq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content_night));
                        gVar.auh.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content_night));
                        gVar.bmf.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.square_search_text_content_night));
                    }
                    aw.i(gVar.MI, com.baidu.tieba.s.square_dividing_line);
                    aw.h(gVar.bmg, com.baidu.tieba.u.bg_search_tiezi);
                    aw.b(gVar.JM, com.baidu.tieba.s.search_text_title, 1);
                }
            } else {
                if (getItemId(i) == -1) {
                    if (this.bma == 1) {
                        fVar.xM.setVisibility(0);
                        fVar.bmd.setText(this.mContext.getString(com.baidu.tieba.y.loading));
                    } else {
                        fVar.xM.setVisibility(8);
                        fVar.bmd.setText(this.mContext.getString(com.baidu.tieba.y.pre_page));
                    }
                    aw.b(fVar.bmd, skinType);
                } else {
                    if (this.bma == 2) {
                        fVar.xM.setVisibility(0);
                        fVar.bmd.setText(this.mContext.getString(com.baidu.tieba.y.loading));
                    } else {
                        fVar.xM.setVisibility(8);
                        fVar.bmd.setText(this.mContext.getString(com.baidu.tieba.y.next_page));
                    }
                    aw.b(fVar.bmd, skinType);
                }
                aw.h(fVar.bmc, com.baidu.tieba.u.list_item_selector);
            }
        }
        return view;
    }
}
