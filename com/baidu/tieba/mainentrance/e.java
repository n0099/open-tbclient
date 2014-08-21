package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public e(Context context) {
        this.b = null;
        this.b = context;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a() {
        if (this.d != null) {
            Iterator<ProgressBar> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    public boolean b() {
        if (this.a == null) {
            return false;
        }
        return this.a.hasPre();
    }

    public boolean c() {
        if (this.a == null) {
            return false;
        }
        return this.a.hasMore();
    }

    public void a(SearchPostModel searchPostModel) {
        this.a = searchPostModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a == null || this.a.getData() == null) {
            return 0;
        }
        int size = this.a.getData().size();
        if (b()) {
            size++;
        }
        if (c()) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId;
        if (this.a == null || this.a.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.a.getData().size()) {
            return null;
        }
        return this.a.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.a == null || this.a.getData() == null) {
            return -1L;
        }
        if (b()) {
            if (i <= this.a.getData().size()) {
                return i - 1;
            }
            return -2L;
        } else if (i < this.a.getData().size()) {
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
        if (this.a != null) {
            if (view == null) {
                if (getItemViewType(i) == 0) {
                    gVar = new g(this, null);
                    view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.search_post_item, null);
                    gVar.c = (TextView) view.findViewById(com.baidu.tieba.u.title);
                    gVar.f = view.findViewById(com.baidu.tieba.u.search_post_lv_search_forum_divider);
                    gVar.b = (TextView) view.findViewById(com.baidu.tieba.u.content);
                    gVar.d = (TextView) view.findViewById(com.baidu.tieba.u.forum);
                    gVar.a = (TextView) view.findViewById(com.baidu.tieba.u.time);
                    gVar.e = (LinearLayout) view.findViewById(com.baidu.tieba.u.square_search_content_layout);
                    view.setTag(gVar);
                    fVar = null;
                } else {
                    f fVar2 = new f(this, null);
                    view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.page_item, null);
                    fVar2.a = (TextView) view.findViewById(com.baidu.tieba.u.page_text);
                    fVar2.b = (ProgressBar) view.findViewById(com.baidu.tieba.u.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(fVar2.b);
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
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (getItemViewType(i) == 0) {
                at atVar = (at) getItem(i);
                if (atVar != null) {
                    gVar.d.setText(String.valueOf(atVar.d()) + this.b.getString(com.baidu.tieba.x.bar));
                    gVar.a.setText(ba.a(atVar.g()));
                    if (atVar.f() == null || atVar.f().length() < 1) {
                        gVar.e.setVisibility(8);
                    } else {
                        gVar.e.setVisibility(0);
                        gVar.b.setText(Html.fromHtml(ba.a(atVar.f(), (Color) null)));
                    }
                    gVar.c.setText(Html.fromHtml(ba.a(atVar.e(), (Color) null)));
                    ay.b(gVar.b, skinType);
                    if (skinType == 0) {
                        gVar.f.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line));
                        gVar.e.setBackgroundResource(com.baidu.tieba.t.bg_search_tiezi);
                        gVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.post_search_text_content));
                        gVar.a.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.post_search_text_content));
                        gVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.square_search_text_content));
                        gVar.c.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.search_text_title));
                    } else {
                        gVar.f.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.r.square_dividing_line_1));
                        gVar.e.setBackgroundResource(com.baidu.tieba.t.bg_search_tiezi_1);
                        gVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.post_search_text_content_night));
                        gVar.a.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.post_search_text_content_night));
                        gVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.square_search_text_content_night));
                        gVar.c.setTextColor(this.b.getResources().getColor(com.baidu.tieba.r.search_text_title_1));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    fVar.b.setVisibility(0);
                    fVar.a.setText(this.b.getString(com.baidu.tieba.x.loading));
                } else {
                    fVar.b.setVisibility(8);
                    fVar.a.setText(this.b.getString(com.baidu.tieba.x.pre_page));
                }
                ay.b(fVar.a, skinType);
            } else {
                if (this.c == 2) {
                    fVar.b.setVisibility(0);
                    fVar.a.setText(this.b.getString(com.baidu.tieba.x.loading));
                } else {
                    fVar.b.setVisibility(8);
                    fVar.a.setText(this.b.getString(com.baidu.tieba.x.next_page));
                }
                ay.b(fVar.a, skinType);
            }
        }
        return view;
    }
}
