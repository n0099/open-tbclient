package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class l extends BaseAdapter implements AbsListView.OnScrollListener {
    private com.baidu.tieba.f a;
    private com.baidu.tieba.model.f b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;
    private com.baidu.tieba.util.i f;
    private boolean g;
    private volatile boolean h;

    public l(com.baidu.tieba.f fVar, com.baidu.tieba.model.f fVar2, boolean z) {
        this.f = null;
        this.g = true;
        this.a = fVar;
        this.b = fVar2;
        this.g = z;
        this.f = new com.baidu.tieba.util.i(fVar);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e) {
            return 1;
        }
        if (this.b != null && this.b.a() != null) {
            return this.b.a().size();
        }
        return 0;
    }

    public void b() {
        this.e = false;
        if (this.b != null) {
            if (this.b.a() == null || this.b.a().size() == 0) {
                this.e = true;
            }
        }
    }

    public boolean c() {
        return this.e;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.a() == null || i < 0 || i >= this.b.a().size()) {
            return null;
        }
        return this.b.a().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        n nVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(R.layout.edit_bar_item, (ViewGroup) null);
                try {
                    nVar = new n(this, null);
                    nVar.a = (HeadImageView) view3.findViewById(R.id.forum_avatar);
                    nVar.a.setGifIconSupport(false);
                    nVar.b = (TextView) view3.findViewById(R.id.name);
                    nVar.c = new StringBuffer(10);
                    nVar.d = (TextView) view3.findViewById(R.id.degree);
                    nVar.e = (TextView) view3.findViewById(R.id.degree_text);
                    nVar.h = (TextView) view3.findViewById(R.id.experience);
                    nVar.i = (Button) view3.findViewById(R.id.item_delete);
                    nVar.f = (TextView) view3.findViewById(R.id.degree_text_ta);
                    nVar.g = (TextView) view3.findViewById(R.id.intro_ta);
                    view3.setTag(nVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", exc.getMessage());
                    a(view2);
                    return view2;
                }
            } else {
                nVar = (n) view.getTag();
                view3 = view;
            }
            if (this.e) {
                nVar.d.setVisibility(8);
                nVar.i.setVisibility(8);
                nVar.b.setVisibility(8);
                nVar.a.setVisibility(8);
                nVar.e.setVisibility(8);
                nVar.h.setVisibility(8);
                nVar.f.setVisibility(8);
                nVar.g.setVisibility(8);
            } else {
                nVar.i.setVisibility(0);
                nVar.b.setVisibility(0);
                nVar.a.setVisibility(0);
                if (this.g) {
                    nVar.d.setVisibility(0);
                    nVar.e.setVisibility(0);
                    nVar.h.setVisibility(0);
                    nVar.f.setVisibility(8);
                    nVar.g.setVisibility(8);
                } else {
                    nVar.d.setVisibility(8);
                    nVar.e.setVisibility(8);
                    nVar.h.setVisibility(8);
                    nVar.f.setVisibility(0);
                    nVar.g.setVisibility(0);
                }
            }
            if (this.b == null || this.b.a() == null || i < 0 || i >= this.b.a().size() || (forumData = this.b.a().get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                nVar.a.setTag(image_url);
                if (this.f.d(image_url) != null) {
                    nVar.a.invalidate();
                } else if (!this.h) {
                    this.f.f(image_url, new m(this, view3));
                }
                nVar.c.delete(0, nVar.c.length());
                nVar.c.append(forumData.getName());
                nVar.c.append(this.a.getString(R.string.bar));
                nVar.b.setText(nVar.c);
                if (this.g) {
                    nVar.e.setBackgroundResource(com.baidu.tieba.util.n.b(forumData.getUser_level()));
                    nVar.e.setText(String.valueOf(forumData.getUser_level()));
                    nVar.d.setVisibility(0);
                    nVar.h.setText(String.format(this.a.getString(R.string.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    nVar.i.setOnClickListener(this.d);
                    nVar.i.setTag(Integer.valueOf(i));
                } else {
                    nVar.f.setBackgroundResource(com.baidu.tieba.util.n.b(forumData.getUser_level()));
                    nVar.f.setText(String.valueOf(forumData.getUser_level()));
                    nVar.g.setText(forumData.getSlogan());
                }
                if (this.c) {
                    nVar.i.setVisibility(0);
                    view2 = view3;
                } else {
                    nVar.i.setVisibility(8);
                    view2 = view3;
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        a(view2);
        return view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.h = false;
            notifyDataSetChanged();
            return;
        }
        this.h = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    private void a(View view) {
        this.a.getLayoutMode().a(TiebaApplication.g().al() == 1);
        this.a.getLayoutMode().a(view);
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.e) {
            return false;
        }
        return super.isEnabled(i);
    }
}
