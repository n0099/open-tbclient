package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.am;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class c extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public c(Context context) {
        this.b = null;
        this.b = context;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a() {
        if (this.d != null) {
            Iterator<ProgressBar> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
        }
    }

    private boolean b() {
        if (this.a == null) {
            return false;
        }
        return this.a.hasPre();
    }

    public final void a(SearchPostModel searchPostModel) {
        this.a = searchPostModel;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a == null || this.a.getData() == null) {
            return 0;
        }
        int size = this.a.getData().size();
        if (b()) {
            size++;
        }
        if (this.a != null ? this.a.hasMore() : false) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int itemId;
        if (this.a == null || this.a.getData() == null || (itemId = (int) getItemId(i)) < 0 || itemId >= this.a.getData().size()) {
            return null;
        }
        return this.a.getData().get(itemId);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : -1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
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
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        e eVar = null;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    e eVar2 = new e(this, (byte) 0);
                    view = from.inflate(com.baidu.tieba.a.i.search_post_item, (ViewGroup) null);
                    eVar2.c = (TextView) view.findViewById(com.baidu.tieba.a.h.title);
                    eVar2.f = view.findViewById(com.baidu.tieba.a.h.search_post_lv_search_forum_divider);
                    eVar2.b = (TextView) view.findViewById(com.baidu.tieba.a.h.content);
                    eVar2.d = (TextView) view.findViewById(com.baidu.tieba.a.h.forum);
                    eVar2.a = (TextView) view.findViewById(com.baidu.tieba.a.h.time);
                    eVar2.e = (LinearLayout) view.findViewById(com.baidu.tieba.a.h.square_search_content_layout);
                    view.setTag(eVar2);
                    dVar = null;
                    eVar = eVar2;
                } else {
                    d dVar2 = new d(this, (byte) 0);
                    view = from.inflate(com.baidu.tieba.a.i.page_item, (ViewGroup) null);
                    dVar2.a = (TextView) view.findViewById(com.baidu.tieba.a.h.page_text);
                    dVar2.b = (ProgressBar) view.findViewById(com.baidu.tieba.a.h.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(dVar2.b);
                    view.setTag(dVar2);
                    dVar = dVar2;
                }
            } else if (getItemViewType(i) == 0) {
                eVar = (e) view.getTag();
                dVar = null;
            } else {
                dVar = (d) view.getTag();
            }
            int l = TbadkApplication.j().l();
            if (getItemViewType(i) == 0) {
                am amVar = (am) getItem(i);
                if (amVar != null) {
                    eVar.d.setText(String.valueOf(amVar.d()) + this.b.getString(com.baidu.tieba.a.k.bar));
                    eVar.a.setText(bc.a(amVar.g()));
                    if (amVar.f() == null || amVar.f().length() <= 0) {
                        eVar.e.setVisibility(8);
                    } else {
                        eVar.e.setVisibility(0);
                        eVar.b.setText(Html.fromHtml(bc.g(amVar.f())));
                    }
                    eVar.c.setText(Html.fromHtml(bc.g(amVar.e())));
                    ba.b(eVar.b, l);
                    if (l == 0) {
                        eVar.f.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.square_dividing_line));
                        eVar.e.setBackgroundResource(com.baidu.tieba.a.g.bg_search_tiezi);
                        eVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.post_search_text_content));
                        eVar.a.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.post_search_text_content));
                        eVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.square_search_text_content));
                        eVar.c.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.search_text_title));
                    } else {
                        eVar.f.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.square_dividing_line_1));
                        eVar.e.setBackgroundResource(com.baidu.tieba.a.g.bg_search_tiezi_1);
                        eVar.d.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.post_search_text_content_night));
                        eVar.a.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.post_search_text_content_night));
                        eVar.b.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.square_search_text_content_night));
                        eVar.c.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.search_text_title_1));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    dVar.b.setVisibility(0);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.a.k.loading));
                } else {
                    dVar.b.setVisibility(8);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.a.k.pre_page));
                }
                ba.b(dVar.a, l);
            } else {
                if (this.c == 2) {
                    dVar.b.setVisibility(0);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.a.k.loading));
                } else {
                    dVar.b.setVisibility(8);
                    dVar.a.setText(this.b.getString(com.baidu.tieba.a.k.next_page));
                }
                ba.b(dVar.a, l);
            }
        }
        return view;
    }
}
