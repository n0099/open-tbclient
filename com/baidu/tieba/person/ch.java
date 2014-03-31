package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ch extends BaseAdapter {
    boolean b;
    boolean c;
    private PersonListActivity e;
    private com.baidu.tbadk.editortool.aa f;
    private int j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private ArrayList<UserData> d = null;
    private boolean g = false;
    private boolean h = false;
    boolean a = false;
    private ArrayList<ProgressBar> i = new ArrayList<>();

    public final void a() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        this.i.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.adp.lib.util.f.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    public final void b() {
        this.a = false;
        if (this.d != null && this.d.size() == 0) {
            this.a = true;
        }
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public ch(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.e = personListActivity;
        this.f = new com.baidu.tbadk.editortool.aa(this.e);
        this.b = z;
        this.c = z2;
        this.j = i;
        this.k = onClickListener2;
        this.l = onClickListener3;
        this.m = onClickListener;
    }

    public final com.baidu.tbadk.editortool.aa c() {
        return this.f;
    }

    public final void a(ArrayList<UserData> arrayList) {
        this.d = arrayList;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.a) {
            return 1;
        }
        int i = 0;
        if (this.d != null) {
            i = this.d.size();
        }
        if (this.g) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (this.d == null || i >= this.d.size()) {
            return null;
        }
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        if (this.d == null || i >= this.d.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        ci ciVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                ci ciVar2 = new ci(this, (byte) 0);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(com.baidu.tieba.a.i.person_list_item, (ViewGroup) null);
                    ciVar2.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.a.h.photo);
                    ciVar2.a.setIsRound(true);
                    ciVar2.a.setAutoChangeStyle(true);
                    ciVar2.e = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.info);
                    ciVar2.e.setOnClickListener(this.m);
                    ciVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.a.h.name);
                    ciVar2.g = (TextView) inflate.findViewById(com.baidu.tieba.a.h.at_list_nodata);
                    ciVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.a.h.intro);
                    ciVar2.d = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.chat);
                    ciVar2.d.setOnClickListener(this.k);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(com.baidu.tieba.a.i.new_pb_list_more, (ViewGroup) null);
                    ciVar2.b = (TextView) inflate2.findViewById(com.baidu.tieba.a.h.pb_more_text);
                    inflate2.setOnClickListener(this.l);
                    ciVar2.f = (ProgressBar) inflate2.findViewById(com.baidu.tieba.a.h.progress);
                    this.i.add(ciVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(ciVar2);
                ciVar = ciVar2;
                view = view2;
            } else {
                ciVar = (ci) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    ciVar.e.setVisibility(8);
                    ciVar.d.setVisibility(8);
                    ciVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            ciVar.g.setText(com.baidu.tieba.a.k.not_have_attention);
                        } else if (this.j == 2) {
                            ciVar.g.setText(com.baidu.tieba.a.k.her_no_attention_other);
                        } else if (this.j == 1) {
                            ciVar.g.setText(com.baidu.tieba.a.k.him_no_attention_other);
                        } else {
                            ciVar.g.setText(com.baidu.tieba.a.k.no_attention_other);
                        }
                    } else if (this.c) {
                        ciVar.g.setText(com.baidu.tieba.a.k.not_have_fans);
                    } else if (this.j == 2) {
                        ciVar.g.setText(com.baidu.tieba.a.k.her_no_fan_other);
                    } else if (this.j == 1) {
                        ciVar.g.setText(com.baidu.tieba.a.k.him_no_fan_other);
                    } else {
                        ciVar.g.setText(com.baidu.tieba.a.k.no_fan_other);
                    }
                } else {
                    ciVar.d.setVisibility(0);
                    ciVar.e.setVisibility(0);
                    ciVar.e.setTag(Integer.valueOf(i));
                    ciVar.g.setVisibility(8);
                    String portrait = this.d.get(i).getPortrait();
                    com.baidu.tbadk.editortool.aa aaVar = this.f;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        ciVar.a.setTag(null);
                        b.a(ciVar.a);
                    } else {
                        ciVar.a.setTag(portrait);
                        ciVar.a.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
                    }
                    ciVar.b.setText(this.d.get(i).getName_show());
                    ciVar.c.setText(this.d.get(i).getIntro());
                    ciVar.d.setTag(Integer.valueOf(i));
                }
            } else {
                ciVar.b.setText(this.e.getString(com.baidu.tieba.a.k.loading));
                ciVar.f.setVisibility(0);
            }
            this.e.getLayoutMode().a(TbadkApplication.j().l() == 1);
            this.e.getLayoutMode().a(view);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.a) {
            return 0;
        }
        return (this.d == null || i >= this.d.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (this.a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
