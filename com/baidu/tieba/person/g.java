package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public final class g extends BaseAdapter implements AbsListView.OnScrollListener {
    private com.baidu.tbadk.a a;
    private com.baidu.tieba.model.d b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;
    private com.baidu.tbadk.editortool.aa f;
    private boolean g;
    private volatile boolean h;
    private View.OnClickListener i;

    public g(com.baidu.tbadk.a aVar, com.baidu.tieba.model.d dVar, boolean z) {
        this.f = null;
        this.g = true;
        this.a = aVar;
        this.b = dVar;
        this.g = z;
        this.f = new com.baidu.tbadk.editortool.aa(aVar);
    }

    public final void a(boolean z) {
        this.c = z;
        notifyDataSetChanged();
    }

    public final boolean a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.e) {
            return 1;
        }
        if (this.b != null && this.b.b() != null) {
            return this.b.b().size();
        }
        return 0;
    }

    public final void b() {
        this.e = false;
        if (this.b != null) {
            if (this.b.b() == null || this.b.b().size() == 0) {
                this.e = true;
            }
        }
    }

    public final boolean c() {
        return this.e;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.b == null || this.b.b() == null || i < 0 || i >= this.b.b().size()) {
            return null;
        }
        return this.b.b().get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x030b  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        i iVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.a.i.edit_bar_item, (ViewGroup) null);
                try {
                    iVar = new i(this, (byte) 0);
                    iVar.a = (HeadImageView) view3.findViewById(com.baidu.tieba.a.h.forum_avatar);
                    iVar.a.setGifIconSupport(false);
                    iVar.b = (TextView) view3.findViewById(com.baidu.tieba.a.h.name);
                    iVar.c = new StringBuffer(10);
                    iVar.d = (TextView) view3.findViewById(com.baidu.tieba.a.h.degree);
                    iVar.e = (TextView) view3.findViewById(com.baidu.tieba.a.h.degree_text);
                    iVar.h = (TextView) view3.findViewById(com.baidu.tieba.a.h.experience);
                    iVar.i = (Button) view3.findViewById(com.baidu.tieba.a.h.item_delete);
                    iVar.f = (TextView) view3.findViewById(com.baidu.tieba.a.h.degree_text_ta);
                    iVar.g = (TextView) view3.findViewById(com.baidu.tieba.a.h.intro_ta);
                    iVar.j = (ImageView) view3.findViewById(com.baidu.tieba.a.h.item_talk);
                    view3.setTag(iVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "getView", exc.getMessage());
                    this.a.getLayoutMode().a(TbadkApplication.j().l() != 1);
                    this.a.getLayoutMode().a(view2);
                    return view2;
                }
            } else {
                iVar = (i) view.getTag();
                view3 = view;
            }
            if (this.e) {
                iVar.d.setVisibility(8);
                iVar.i.setVisibility(8);
                iVar.b.setVisibility(8);
                iVar.a.setVisibility(8);
                iVar.e.setVisibility(8);
                iVar.h.setVisibility(8);
                iVar.f.setVisibility(8);
                iVar.g.setVisibility(8);
            } else {
                iVar.b.setVisibility(0);
                iVar.a.setVisibility(0);
                if (this.g) {
                    iVar.d.setVisibility(8);
                    iVar.e.setVisibility(8);
                    iVar.h.setVisibility(0);
                    iVar.f.setVisibility(0);
                    iVar.g.setVisibility(8);
                } else {
                    iVar.d.setVisibility(8);
                    iVar.e.setVisibility(8);
                    iVar.h.setVisibility(8);
                    iVar.f.setVisibility(0);
                    iVar.g.setVisibility(0);
                }
            }
            if (this.b == null || this.b.b() == null || i < 0 || i >= this.b.b().size() || (forumData = this.b.b().get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                iVar.a.setTag(image_url);
                com.baidu.tbadk.editortool.aa aaVar = this.f;
                if (com.baidu.tbadk.imageManager.e.a().c(image_url) != null) {
                    iVar.a.invalidate();
                } else if (!this.h) {
                    this.f.f(image_url, new h(this, view3));
                }
                iVar.c.delete(0, iVar.c.length());
                iVar.c.append(forumData.getName());
                iVar.c.append(this.a.getString(com.baidu.tieba.a.k.bar));
                iVar.b.setText(iVar.c);
                if (this.g) {
                    iVar.f.setBackgroundResource(com.baidu.tbadk.core.util.g.b(forumData.getUser_level()));
                    iVar.f.setText(String.valueOf(forumData.getUser_level()));
                    iVar.h.setText(String.format(this.a.getString(com.baidu.tieba.a.k.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    iVar.i.setOnClickListener(this.d);
                    iVar.i.setTag(Integer.valueOf(i));
                    if (i < this.b.a()) {
                        if (TbadkApplication.j().l() == 1) {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.a.g.icon_v_1, 0);
                        } else {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.a.g.icon_v, 0);
                        }
                        iVar.j.setVisibility(0);
                        iVar.j.setTag(Integer.valueOf(i));
                    } else {
                        iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        iVar.j.setVisibility(8);
                    }
                    iVar.j.setOnClickListener(this.i);
                } else {
                    if (i < this.b.a()) {
                        if (TbadkApplication.j().l() == 1) {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.a.g.icon_v_1, 0);
                        } else {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.a.g.icon_v, 0);
                        }
                    } else {
                        iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    iVar.j.setVisibility(8);
                    iVar.f.setBackgroundResource(com.baidu.tbadk.core.util.g.b(forumData.getUser_level()));
                    iVar.f.setText(String.valueOf(forumData.getUser_level()));
                    iVar.g.setText(forumData.getSlogan());
                }
                if (this.c) {
                    iVar.i.setVisibility(0);
                    iVar.j.setVisibility(8);
                    view2 = view3;
                } else {
                    iVar.i.setVisibility(8);
                    if (i < this.b.a() && this.g) {
                        iVar.j.setVisibility(0);
                        view2 = view3;
                    } else {
                        iVar.j.setVisibility(8);
                        view2 = view3;
                    }
                }
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
        this.a.getLayoutMode().a(TbadkApplication.j().l() != 1);
        this.a.getLayoutMode().a(view2);
        return view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.h = false;
            notifyDataSetChanged();
            return;
        }
        this.h = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (this.e) {
            return false;
        }
        return super.isEnabled(i);
    }
}
