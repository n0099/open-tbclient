package com.baidu.tieba.person;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ad extends BaseAdapter {
    private PersonBarActivity a;
    private t b;
    private ArrayList<ForumData> c = null;
    private boolean d = false;
    private View.OnClickListener e = null;
    private boolean f = false;
    private boolean g;
    private View.OnClickListener h;

    public ad(PersonBarActivity personBarActivity, t tVar, boolean z) {
        this.b = null;
        this.g = true;
        this.a = personBarActivity;
        this.b = tVar;
        this.g = z;
    }

    public void a(ArrayList<ForumData> arrayList) {
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.d = z;
        notifyDataSetChanged();
    }

    public boolean a() {
        return this.d;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f) {
            return 1;
        }
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    public void b() {
        this.f = false;
        if (this.c == null || this.c.size() == 0) {
            this.f = true;
        }
    }

    public boolean c() {
        return this.f;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        ae aeVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.edit_bar_item, null);
                try {
                    aeVar = new ae(this, null);
                    aeVar.a = (BarImageView) view3.findViewById(com.baidu.tieba.u.forum_avatar);
                    aeVar.a.setGifIconSupport(false);
                    aeVar.b = (TextView) view3.findViewById(com.baidu.tieba.u.name);
                    aeVar.c = new StringBuffer(10);
                    aeVar.d = (TextView) view3.findViewById(com.baidu.tieba.u.degree);
                    aeVar.e = (TextView) view3.findViewById(com.baidu.tieba.u.degree_text);
                    aeVar.i = (TextView) view3.findViewById(com.baidu.tieba.u.experience);
                    aeVar.g = (TextView) view3.findViewById(com.baidu.tieba.u.experience_title);
                    aeVar.j = (Button) view3.findViewById(com.baidu.tieba.u.item_delete);
                    aeVar.f = (TextView) view3.findViewById(com.baidu.tieba.u.degree_text_ta);
                    aeVar.h = (TextView) view3.findViewById(com.baidu.tieba.u.intro_ta);
                    aeVar.k = (ImageView) view3.findViewById(com.baidu.tieba.u.item_talk);
                    aeVar.l = (ImageView) view3.findViewById(com.baidu.tieba.u.diver_buttom_px);
                    aeVar.l.setVisibility(0);
                    view3.setTag(aeVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    a(view2);
                    return view2;
                }
            } else {
                aeVar = (ae) view.getTag();
                view3 = view;
            }
            if (this.f) {
                aeVar.d.setVisibility(8);
                aeVar.j.setVisibility(8);
                aeVar.b.setVisibility(8);
                aeVar.a.setVisibility(8);
                aeVar.e.setVisibility(8);
                aeVar.i.setVisibility(8);
                aeVar.g.setVisibility(8);
                aeVar.f.setVisibility(8);
                aeVar.h.setVisibility(8);
                aeVar.k.setVisibility(8);
                aeVar.l.setVisibility(8);
            } else {
                aeVar.b.setVisibility(0);
                aeVar.a.setVisibility(0);
                if (this.g) {
                    aeVar.d.setVisibility(8);
                    aeVar.e.setVisibility(8);
                    aeVar.i.setVisibility(0);
                    aeVar.g.setVisibility(0);
                    aeVar.f.setVisibility(0);
                    aeVar.h.setVisibility(8);
                    aeVar.l.setVisibility(0);
                } else {
                    aeVar.d.setVisibility(8);
                    aeVar.e.setVisibility(8);
                    aeVar.i.setVisibility(8);
                    aeVar.g.setVisibility(8);
                    aeVar.f.setVisibility(0);
                    aeVar.h.setVisibility(0);
                    aeVar.l.setVisibility(0);
                }
            }
            if (this.c == null || i < 0 || i >= this.c.size() || (forumData = this.c.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                aeVar.a.setTag(image_url);
                aeVar.a.setImageDrawable(null);
                aeVar.a.a(image_url, 10, false);
                aeVar.c.delete(0, aeVar.c.length());
                aeVar.c.append(forumData.getName());
                aeVar.c.append(this.a.getString(com.baidu.tieba.x.bar));
                aeVar.b.setText(aeVar.c);
                if (this.g) {
                    aeVar.f.setBackgroundResource(com.baidu.tbadk.core.util.d.b(forumData.getUser_level()));
                    aeVar.f.setText(String.valueOf(forumData.getUser_level()));
                    aeVar.i.setText(String.format(this.a.getString(com.baidu.tieba.x.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    aeVar.j.setOnClickListener(this.e);
                    aeVar.j.setTag(Integer.valueOf(i));
                    if (i < this.b.a()) {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            aeVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v_1, 0);
                        } else {
                            aeVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v, 0);
                        }
                        aeVar.k.setVisibility(0);
                        aeVar.k.setTag(Integer.valueOf(i));
                    } else {
                        aeVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        aeVar.k.setVisibility(8);
                    }
                    aeVar.k.setOnClickListener(this.h);
                } else {
                    if ((this.a.q() == 0 && i < this.b.a()) || (this.a.q() == 1 && i < this.b.b())) {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            aeVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v_1, 0);
                        } else {
                            aeVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v, 0);
                        }
                    } else {
                        aeVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    aeVar.k.setVisibility(8);
                    aeVar.f.setBackgroundResource(com.baidu.tbadk.core.util.d.b(forumData.getUser_level()));
                    aeVar.f.setText(String.valueOf(forumData.getUser_level()));
                    aeVar.h.setText(forumData.getSlogan());
                }
                if (this.d) {
                    aeVar.j.setVisibility(0);
                    aeVar.k.setVisibility(8);
                    view2 = view3;
                } else {
                    aeVar.j.setVisibility(8);
                    if (i < this.b.a() && this.g) {
                        aeVar.k.setVisibility(0);
                        view2 = view3;
                    } else {
                        aeVar.k.setVisibility(8);
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

    private void a(View view) {
        this.a.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.c().a(view);
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void b(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.f) {
            return false;
        }
        return super.isEnabled(i);
    }
}
