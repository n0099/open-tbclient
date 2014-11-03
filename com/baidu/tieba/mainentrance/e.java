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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.aq;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private SearchPostModel bmn = null;
    private int bmo = 0;
    private ArrayList<ProgressBar> bmp = null;
    private Context mContext;

    public e(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setRefreshing(int i) {
        this.bmo = i;
    }

    public int SA() {
        return this.bmo;
    }

    public void SB() {
        if (this.bmp != null) {
            Iterator<ProgressBar> it = this.bmp.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public boolean SC() {
        if (this.bmn == null) {
            return false;
        }
        return this.bmn.hasPre();
    }

    public boolean SD() {
        if (this.bmn == null) {
            return false;
        }
        return this.bmn.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.bmn = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bmn == null || this.bmn.getData() == null) {
            return 0;
        }
        int size = this.bmn.getData().size();
        if (SC()) {
            size++;
        }
        if (SD()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.bmn == null || this.bmn.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.bmn.getData().size()) {
            return null;
        }
        return this.bmn.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.bmn == null || this.bmn.getData() == null) {
            return -1L;
        }
        if (SC()) {
            if (i <= this.bmn.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.bmn.getData().size()) {
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
        if (this.bmn != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    gVar = new g(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.search_post_item, null);
                    gVar.JN = (TextView) view.findViewById(com.baidu.tieba.v.title);
                    gVar.ML = view.findViewById(com.baidu.tieba.v.search_post_lv_search_forum_divider);
                    gVar.bmt = (TextView) view.findViewById(com.baidu.tieba.v.content);
                    gVar.axz = (TextView) view.findViewById(com.baidu.tieba.v.forum);
                    gVar.auq = (TextView) view.findViewById(com.baidu.tieba.v.time);
                    gVar.bmu = (LinearLayout) view.findViewById(com.baidu.tieba.v.square_search_content_layout);
                    view.setTag(gVar);
                    fVar = null;
                } else {
                    f fVar2 = new f(this, null);
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.page_item, null);
                    fVar2.bmq = (RelativeLayout) view.findViewById(com.baidu.tieba.v.page_container);
                    fVar2.bmr = (TextView) view.findViewById(com.baidu.tieba.v.page_text);
                    fVar2.xM = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
                    if (this.bmp == null) {
                        this.bmp = new ArrayList<>();
                    }
                    this.bmp.add(fVar2.xM);
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
                    gVar.axz.setText(String.valueOf(aqVar.As()) + this.mContext.getString(com.baidu.tieba.y.bar));
                    gVar.auq.setText(az.j(aqVar.getTime()));
                    if (aqVar.getContent() == null || aqVar.getContent().length() < 1) {
                        gVar.bmu.setVisibility(8);
                    } else {
                        gVar.bmu.setVisibility(0);
                        gVar.bmt.setText(Html.fromHtml(az.a(aqVar.getContent(), (Color) null)));
                    }
                    gVar.JN.setText(Html.fromHtml(az.a(aqVar.getTitle(), (Color) null)));
                    aw.b(gVar.bmt, skinType);
                    if (skinType == 0) {
                        gVar.axz.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content));
                        gVar.auq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content));
                        gVar.bmt.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.square_search_text_content));
                    } else {
                        gVar.axz.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content_night));
                        gVar.auq.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.post_search_text_content_night));
                        gVar.bmt.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.square_search_text_content_night));
                    }
                    aw.i(gVar.ML, com.baidu.tieba.s.square_dividing_line);
                    aw.h(gVar.bmu, com.baidu.tieba.u.bg_search_tiezi);
                    aw.b(gVar.JN, com.baidu.tieba.s.search_text_title, 1);
                }
            } else {
                if (getItemId(i) == -1) {
                    if (this.bmo == 1) {
                        fVar.xM.setVisibility(0);
                        fVar.bmr.setText(this.mContext.getString(com.baidu.tieba.y.loading));
                    } else {
                        fVar.xM.setVisibility(8);
                        fVar.bmr.setText(this.mContext.getString(com.baidu.tieba.y.pre_page));
                    }
                    aw.b(fVar.bmr, skinType);
                } else {
                    if (this.bmo == 2) {
                        fVar.xM.setVisibility(0);
                        fVar.bmr.setText(this.mContext.getString(com.baidu.tieba.y.loading));
                    } else {
                        fVar.xM.setVisibility(8);
                        fVar.bmr.setText(this.mContext.getString(com.baidu.tieba.y.next_page));
                    }
                    aw.b(fVar.bmr, skinType);
                }
                aw.h(fVar.bmq, com.baidu.tieba.u.list_item_selector);
            }
        }
        return view;
    }
}
