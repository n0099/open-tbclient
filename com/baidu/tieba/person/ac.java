package com.baidu.tieba.person;

import android.view.LayoutInflater;
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
public class ac extends BaseAdapter {
    private PersonBarActivity a;
    private s b;
    private ArrayList<ForumData> c = null;
    private boolean d = false;
    private View.OnClickListener e = null;
    private boolean f = false;
    private boolean g;
    private View.OnClickListener h;

    public ac(PersonBarActivity personBarActivity, s sVar, boolean z) {
        this.b = null;
        this.g = true;
        this.a = personBarActivity;
        this.b = sVar;
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
        ad adVar;
        View view3;
        ForumData forumData;
        try {
            if (view == null) {
                view3 = LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.edit_bar_item, (ViewGroup) null);
                try {
                    adVar = new ad(this, null);
                    adVar.a = (BarImageView) view3.findViewById(com.baidu.tieba.u.forum_avatar);
                    adVar.a.setGifIconSupport(false);
                    adVar.b = (TextView) view3.findViewById(com.baidu.tieba.u.name);
                    adVar.c = new StringBuffer(10);
                    adVar.d = (TextView) view3.findViewById(com.baidu.tieba.u.degree);
                    adVar.e = (TextView) view3.findViewById(com.baidu.tieba.u.degree_text);
                    adVar.i = (TextView) view3.findViewById(com.baidu.tieba.u.experience);
                    adVar.g = (TextView) view3.findViewById(com.baidu.tieba.u.experience_title);
                    adVar.j = (Button) view3.findViewById(com.baidu.tieba.u.item_delete);
                    adVar.f = (TextView) view3.findViewById(com.baidu.tieba.u.degree_text_ta);
                    adVar.h = (TextView) view3.findViewById(com.baidu.tieba.u.intro_ta);
                    adVar.k = (ImageView) view3.findViewById(com.baidu.tieba.u.item_talk);
                    adVar.l = (ImageView) view3.findViewById(com.baidu.tieba.u.diver_buttom_px);
                    adVar.l.setVisibility(0);
                    view3.setTag(adVar);
                } catch (Exception e) {
                    view2 = view3;
                    exc = e;
                    BdLog.e(exc.getMessage());
                    a(view2);
                    return view2;
                }
            } else {
                adVar = (ad) view.getTag();
                view3 = view;
            }
            if (this.f) {
                adVar.d.setVisibility(8);
                adVar.j.setVisibility(8);
                adVar.b.setVisibility(8);
                adVar.a.setVisibility(8);
                adVar.e.setVisibility(8);
                adVar.i.setVisibility(8);
                adVar.g.setVisibility(8);
                adVar.f.setVisibility(8);
                adVar.h.setVisibility(8);
                adVar.k.setVisibility(8);
                adVar.l.setVisibility(8);
            } else {
                adVar.b.setVisibility(0);
                adVar.a.setVisibility(0);
                if (this.g) {
                    adVar.d.setVisibility(8);
                    adVar.e.setVisibility(8);
                    adVar.i.setVisibility(0);
                    adVar.g.setVisibility(0);
                    adVar.f.setVisibility(0);
                    adVar.h.setVisibility(8);
                    adVar.l.setVisibility(0);
                } else {
                    adVar.d.setVisibility(8);
                    adVar.e.setVisibility(8);
                    adVar.i.setVisibility(8);
                    adVar.g.setVisibility(8);
                    adVar.f.setVisibility(0);
                    adVar.h.setVisibility(0);
                    adVar.l.setVisibility(0);
                }
            }
            if (this.c == null || i < 0 || i >= this.c.size() || (forumData = this.c.get(i)) == null) {
                view2 = view3;
            } else {
                String image_url = forumData.getImage_url();
                adVar.a.setTag(image_url);
                adVar.a.setImageDrawable(null);
                adVar.a.a(image_url, 10, false);
                adVar.c.delete(0, adVar.c.length());
                adVar.c.append(forumData.getName());
                adVar.c.append(this.a.getString(com.baidu.tieba.x.bar));
                adVar.b.setText(adVar.c);
                if (this.g) {
                    adVar.f.setBackgroundResource(com.baidu.tbadk.core.util.d.b(forumData.getUser_level()));
                    adVar.f.setText(String.valueOf(forumData.getUser_level()));
                    adVar.i.setText(String.format(this.a.getString(com.baidu.tieba.x.sign_point_new), Integer.valueOf(forumData.getCurScore()), Integer.valueOf(forumData.getLevelupScore())));
                    adVar.j.setOnClickListener(this.e);
                    adVar.j.setTag(Integer.valueOf(i));
                    if (i < this.b.a()) {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            adVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v_1, 0);
                        } else {
                            adVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v, 0);
                        }
                        adVar.k.setVisibility(0);
                        adVar.k.setTag(Integer.valueOf(i));
                    } else {
                        adVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        adVar.k.setVisibility(8);
                    }
                    adVar.k.setOnClickListener(this.h);
                } else {
                    if ((this.a.q() == 0 && i < this.b.a()) || (this.a.q() == 1 && i < this.b.b())) {
                        if (TbadkApplication.m252getInst().getSkinType() == 1) {
                            adVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v_1, 0);
                        } else {
                            adVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.t.icon_v, 0);
                        }
                    } else {
                        adVar.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    adVar.k.setVisibility(8);
                    adVar.f.setBackgroundResource(com.baidu.tbadk.core.util.d.b(forumData.getUser_level()));
                    adVar.f.setText(String.valueOf(forumData.getUser_level()));
                    adVar.h.setText(forumData.getSlogan());
                }
                if (this.d) {
                    adVar.j.setVisibility(0);
                    adVar.k.setVisibility(8);
                    view2 = view3;
                } else {
                    adVar.j.setVisibility(8);
                    if (i < this.b.a() && this.g) {
                        adVar.k.setVisibility(0);
                        view2 = view3;
                    } else {
                        adVar.k.setVisibility(8);
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
