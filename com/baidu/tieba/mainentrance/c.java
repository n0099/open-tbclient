package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.as;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public c(Context context) {
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
        d dVar;
        e eVar;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    eVar = new e(this, null);
                    view = from.inflate(com.baidu.tieba.w.search_post_item, (ViewGroup) null);
                    eVar.c = (TextView) view.findViewById(com.baidu.tieba.v.title);
                    eVar.f = view.findViewById(com.baidu.tieba.v.search_post_lv_search_forum_divider);
                    eVar.b = (TextView) view.findViewById(com.baidu.tieba.v.content);
                    eVar.d = (TextView) view.findViewById(com.baidu.tieba.v.forum);
                    eVar.a = (TextView) view.findViewById(com.baidu.tieba.v.time);
                    eVar.e = (LinearLayout) view.findViewById(com.baidu.tieba.v.square_search_content_layout);
                    view.setTag(eVar);
                    dVar = null;
                } else {
                    d dVar2 = new d(this, null);
                    view = from.inflate(com.baidu.tieba.w.page_item, (ViewGroup) null);
                    dVar2.a = (TextView) view.findViewById(com.baidu.tieba.v.page_text);
                    dVar2.b = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(dVar2.b);
                    view.setTag(dVar2);
                    dVar = dVar2;
                    eVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                eVar = (e) view.getTag();
                dVar = null;
            } else {
                dVar = (d) view.getTag();
                eVar = null;
            }
            int skinType = TbadkApplication.m252getInst().getSkinType();
            if (getItemViewType(i) == 0) {
                as asVar = (as) getItem(i);
                if (asVar != null) {
                    eVar.d.setText(String.valueOf(asVar.d()) + this.b.getString(com.baidu.tieba.y.bar));
                    eVar.a.setText(bm.a(asVar.g()));
                    if (asVar.f() == null || asVar.f().length() < 1) {
                        eVar.e.setVisibility(8);
                    } else {
                        eVar.e.setVisibility(0);
                        eVar.b.setText(Html.fromHtml(bm.a(asVar.f(), (Color) null)));
                    }
                    eVar.c.setText(Html.fromHtml(bm.a(asVar.e(), (Color) null)));
                    bk.b(eVar.b, skinType);
                    if (skinType == 0) {
                        eVar.f.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line));
                        eVar.e.setBackgroundResource(com.baidu.tieba.u.bg_search_tiezi);
                        eVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.post_search_text_content));
                        eVar.a.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.post_search_text_content));
                        eVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.square_search_text_content));
                        eVar.c.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.search_text_title));
                    } else {
                        eVar.f.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.square_dividing_line_1));
                        eVar.e.setBackgroundResource(com.baidu.tieba.u.bg_search_tiezi_1);
                        eVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.post_search_text_content_night));
                        eVar.a.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.post_search_text_content_night));
                        eVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.square_search_text_content_night));
                        eVar.c.setTextColor(this.b.getResources().getColor(com.baidu.tieba.s.search_text_title_1));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    dVar.b.setVisibility(0);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.y.loading));
                } else {
                    dVar.b.setVisibility(8);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.y.pre_page));
                }
                bk.b(dVar.a, skinType);
            } else {
                if (this.c == 2) {
                    dVar.b.setVisibility(0);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.y.loading));
                } else {
                    dVar.b.setVisibility(8);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.y.next_page));
                }
                bk.b(dVar.a, skinType);
            }
        }
        return view;
    }
}
