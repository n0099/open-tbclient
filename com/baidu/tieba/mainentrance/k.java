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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SearchPostModel;
import com.baidu.tieba.data.au;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private Context b;
    private SearchPostModel a = null;
    private int c = 0;
    private ArrayList<ProgressBar> d = null;

    public k(Context context) {
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
        l lVar;
        m mVar;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                if (getItemViewType(i) == 0) {
                    mVar = new m(this, null);
                    view = from.inflate(R.layout.search_post_item, (ViewGroup) null);
                    mVar.c = (TextView) view.findViewById(R.id.title);
                    mVar.b = (TextView) view.findViewById(R.id.content);
                    mVar.d = (TextView) view.findViewById(R.id.forum);
                    mVar.a = (TextView) view.findViewById(R.id.time);
                    mVar.e = (LinearLayout) view.findViewById(R.id.content_layout);
                    view.setTag(mVar);
                    lVar = null;
                } else {
                    l lVar2 = new l(this, null);
                    view = from.inflate(R.layout.page_item, (ViewGroup) null);
                    lVar2.a = (TextView) view.findViewById(R.id.page_text);
                    lVar2.b = (ProgressBar) view.findViewById(R.id.progress);
                    if (this.d == null) {
                        this.d = new ArrayList<>();
                    }
                    this.d.add(lVar2.b);
                    view.setTag(lVar2);
                    lVar = lVar2;
                    mVar = null;
                }
            } else if (getItemViewType(i) == 0) {
                mVar = (m) view.getTag();
                lVar = null;
            } else {
                lVar = (l) view.getTag();
                mVar = null;
            }
            int al = TiebaApplication.g().al();
            if (getItemViewType(i) == 0) {
                au auVar = (au) getItem(i);
                if (auVar != null) {
                    mVar.d.setText(String.valueOf(auVar.d()) + this.b.getString(R.string.bar));
                    mVar.a.setText(bs.a(auVar.g()));
                    if (auVar.f() == null || auVar.f().length() < 1) {
                        mVar.e.setVisibility(8);
                    } else {
                        mVar.e.setVisibility(0);
                        mVar.b.setText(Html.fromHtml(bs.a(auVar.f(), (Color) null)));
                    }
                    mVar.c.setText(Html.fromHtml(bs.a(auVar.e(), (Color) null)));
                    bq.b(mVar.b, al);
                    if (al == 0) {
                        bq.e(mVar.e, (int) R.drawable.search_replay_back);
                        mVar.d.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        mVar.a.setTextColor(this.b.getResources().getColor(R.color.search_text_forum));
                        mVar.b.setTextColor(this.b.getResources().getColor(R.color.search_text_content));
                    } else {
                        bq.e(mVar.e, (int) R.drawable.search_replay_back_1);
                        mVar.d.setTextColor(bq.c(al));
                        mVar.a.setTextColor(bq.c(al));
                        mVar.b.setTextColor(bq.a(al));
                        mVar.c.setTextColor(bq.b(al));
                    }
                }
            } else if (getItemId(i) == -1) {
                if (this.c == 1) {
                    lVar.b.setVisibility(0);
                    lVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    lVar.b.setVisibility(8);
                    lVar.a.setText(this.b.getString(R.string.pre_page));
                }
                bq.b(lVar.a, al);
            } else {
                if (this.c == 2) {
                    lVar.b.setVisibility(0);
                    lVar.a.setText(this.b.getString(R.string.loading));
                } else {
                    lVar.b.setVisibility(8);
                    lVar.a.setText(this.b.getString(R.string.next_page));
                }
                bq.b(lVar.a, al);
            }
        }
        return view;
    }
}
