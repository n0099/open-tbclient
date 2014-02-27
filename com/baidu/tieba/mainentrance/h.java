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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.au;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class h extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public h(Context context) {
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
        i iVar;
        j jVar = null;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    j jVar2 = new j(this, (byte) 0);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    jVar2.c = (TextView) view.findViewById(R.id.title);
                    jVar2.b = (TextView) view.findViewById(R.id.content);
                    jVar2.d = (TextView) view.findViewById(R.id.forum);
                    jVar2.a = (TextView) view.findViewById(R.id.time);
                    jVar2.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(jVar2);
                    iVar = null;
                    jVar = jVar2;
                } else {
                    i iVar2 = new i(this, (byte) 0);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    iVar2.a = (TextView) view.findViewById(R.id.page_text);
                    iVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(iVar2.b);
                    view.setTag(iVar2);
                    iVar = iVar2;
                }
            } else if (getItemViewType(i) == 0) {
                jVar = (j) view.getTag();
                iVar = null;
            } else {
                iVar = (i) view.getTag();
            }
            int ae = TiebaApplication.g().ae();
            if (getItemViewType(i) == 0) {
                au auVar = (au) getItem(i);
                if (auVar != null) {
                    jVar.d.setText(String.valueOf(auVar.d()) + this.b.getString(R.string.bar));
                    jVar.a.setText(bs.a(auVar.g()));
                    if (auVar.f() == null || auVar.f().length() <= 0) {
                        jVar.e.setVisibility(8);
                    } else {
                        jVar.e.setVisibility(0);
                        jVar.b.setText(Html.fromHtml(bs.g(auVar.f())));
                    }
                    jVar.c.setText(Html.fromHtml(bs.g(auVar.e())));
                    bq.b(jVar.b, ae);
                    if (ae == 0) {
                        bq.e(jVar.e, (int) R.drawable.search_replay_back);
                        jVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        jVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        jVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        bq.e(jVar.e, (int) R.drawable.search_replay_back_1);
                        jVar.d.setTextColor(bq.c(ae));
                        jVar.a.setTextColor(bq.c(ae));
                        jVar.b.setTextColor(bq.a(ae));
                        jVar.c.setTextColor(bq.b(ae));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    iVar.b.setVisibility(0);
                    iVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    iVar.b.setVisibility(8);
                    iVar.a.setText(this.b.getString(R.string.pre_page));
                }
                bq.b(iVar.a, ae);
            } else {
                if (this.c == 2) {
                    iVar.b.setVisibility(0);
                    iVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    iVar.b.setVisibility(8);
                    iVar.a.setText(this.b.getString(R.string.next_page));
                }
                bq.b(iVar.a, ae);
            }
        }
        return view;
    }
}
