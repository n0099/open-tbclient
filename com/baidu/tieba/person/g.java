package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener {
    private BaseActivity a;
    private com.baidu.tieba.model.d b;
    private boolean c = false;
    private View.OnClickListener d = null;
    private boolean e = false;
    private com.baidu.tbadk.editortool.ab f;
    private boolean g;
    private volatile boolean h;
    private View.OnClickListener i;

    public g(BaseActivity baseActivity, com.baidu.tieba.model.d dVar, boolean z) {
        this.f = null;
        this.g = true;
        this.a = baseActivity;
        this.b = dVar;
        this.g = z;
        this.f = new com.baidu.tbadk.editortool.ab(baseActivity);
    }

    public void a(boolean z) {
        this.c = z;
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e) {
            return 1;
        }
        if (this.b != null && this.b.b() != null) {
            return this.b.b().size();
        }
        return 0;
    }

    public void b() {
        this.e = false;
        if (this.b != null) {
            if (this.b.b() == null || this.b.b().size() == 0) {
                this.e = true;
            }
        }
    }

    public boolean c() {
        return this.e;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.b() == null || i < 0 || i >= this.b.b().size()) {
            return null;
        }
        return this.b.b().get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        i iVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.edit_bar_item, (ViewGroup) null);
                try {
                    iVar = new i(this, null);
                    iVar.a = (HeadImageView) view3.findViewById(com.baidu.tieba.v.forum_avatar);
                    iVar.a.setGifIconSupport(false);
                    iVar.b = (TextView) view3.findViewById(com.baidu.tieba.v.name);
                    iVar.c = new StringBuffer(10);
                    iVar.d = (TextView) view3.findViewById(com.baidu.tieba.v.degree);
                    iVar.e = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text);
                    iVar.h = (TextView) view3.findViewById(com.baidu.tieba.v.experience);
                    iVar.i = (Button) view3.findViewById(com.baidu.tieba.v.item_delete);
                    iVar.f = (TextView) view3.findViewById(com.baidu.tieba.v.degree_text_ta);
                    iVar.g = (TextView) view3.findViewById(com.baidu.tieba.v.intro_ta);
                    iVar.j = (ImageView) view3.findViewById(com.baidu.tieba.v.item_talk);
                    view3.setTag(iVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(getClass().getName(), "getView", exc.getMessage());
                    a(view2);
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
                if (this.f.d(image_url) != null) {
                    iVar.a.invalidate();
                } else if (!this.h) {
                    this.f.e(image_url, new h(this, view3));
                }
                iVar.c.delete(0, iVar.c.length());
                iVar.c.append(forumData.getName());
                iVar.c.append(this.a.getString(com.baidu.tieba.y.bar));
                iVar.b.setText(iVar.c);
                if (this.g) {
                    iVar.f.setBackgroundResource(com.baidu.tbadk.core.util.g.b(forumData.getUser_level()));
                    iVar.f.setText(String.valueOf(forumData.getUser_level()));
                    iVar.h.setText(String.format(this.a.getString(com.baidu.tieba.y.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    iVar.i.setOnClickListener(this.d);
                    iVar.i.setTag(Integer.valueOf(i));
                    if (i < this.b.a()) {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_v_1, 0);
                        } else {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_v, 0);
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
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_v_1, 0);
                        } else {
                            iVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.u.icon_v, 0);
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
        this.a.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.getLayoutMode().a(view);
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.e) {
            return false;
        }
        return super.isEnabled(i);
    }
}
