package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cj extends BaseAdapter {
    private PersonFriendActivity b;
    private boolean g;
    private int h;
    private View.OnClickListener i;
    private View.OnClickListener j;
    private ArrayList<UserData> a = null;
    private boolean c = false;
    private boolean d = false;
    private boolean f = false;
    private ArrayList<ProgressBar> e = new ArrayList<>();

    public void a() {
        if (this.e != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.e.size()) {
                    try {
                        this.e.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.e.clear();
                    return;
                }
            }
        }
    }

    public void b() {
        this.f = false;
        if (this.a != null && this.a.size() == 0) {
            this.f = true;
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public cj(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.b = null;
        this.g = true;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.b = personFriendActivity;
        this.g = z;
        this.h = i;
        this.i = onClickListener;
        this.j = onClickListener2;
    }

    public void a(ArrayList<UserData> arrayList) {
        this.a = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f) {
            return 1;
        }
        int i = 0;
        if (this.a != null) {
            i = this.a.size();
        }
        if (this.c) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.a == null || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.a == null || i >= this.a.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ck ckVar;
        View view2;
        if (this.a != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.b);
                ck ckVar2 = new ck(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(com.baidu.tieba.w.person_list_item, (ViewGroup) null);
                    ckVar2.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.photo);
                    ckVar2.a.setIsRound(false);
                    ckVar2.a.setAutoChangeStyle(true);
                    ckVar2.e = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.info);
                    ckVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.v.name);
                    ckVar2.g = (TextView) inflate.findViewById(com.baidu.tieba.v.at_list_nodata);
                    ckVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
                    ckVar2.d = (ImageView) inflate.findViewById(com.baidu.tieba.v.chat);
                    ckVar2.h = (ImageView) inflate.findViewById(com.baidu.tieba.v.diver_buttom_px);
                    ckVar2.d.setOnClickListener(this.i);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(com.baidu.tieba.w.new_pb_list_more, (ViewGroup) null);
                    ckVar2.b = (TextView) inflate2.findViewById(com.baidu.tieba.v.pb_more_text);
                    inflate2.setOnClickListener(this.j);
                    ckVar2.f = (ProgressBar) inflate2.findViewById(com.baidu.tieba.v.progress);
                    this.e.add(ckVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(ckVar2);
                ckVar = ckVar2;
                view = view2;
            } else {
                ckVar = (ck) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.f) {
                    ckVar.e.setVisibility(8);
                    ckVar.d.setVisibility(8);
                    ckVar.g.setVisibility(8);
                    ckVar.h.setVisibility(8);
                } else {
                    if (!this.g && this.h == 0) {
                        ckVar.d.setVisibility(8);
                    } else {
                        ckVar.d.setVisibility(0);
                    }
                    ckVar.e.setVisibility(0);
                    ckVar.e.setTag(Integer.valueOf(i));
                    ckVar.h.setVisibility(0);
                    ckVar.g.setVisibility(8);
                    String portrait = this.a.get(i).getPortrait();
                    ckVar.a.setImageBitmap(null);
                    ckVar.a.a(portrait, 12, false);
                    ckVar.a.setDefaultResource(com.baidu.tieba.u.photo);
                    ckVar.b.setText(this.a.get(i).getName_show());
                    ckVar.c.setText(this.a.get(i).getIntro());
                    ckVar.d.setTag(Integer.valueOf(i));
                }
            } else {
                ckVar.b.setText(this.b.getString(com.baidu.tieba.y.loading));
                ckVar.f.setVisibility(0);
            }
            a(view);
        }
        return view;
    }

    private void a(View view) {
        this.b.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.b.c().a(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f) {
            return 0;
        }
        return (this.a == null || i >= this.a.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.f) {
            return false;
        }
        return super.isEnabled(i);
    }
}
