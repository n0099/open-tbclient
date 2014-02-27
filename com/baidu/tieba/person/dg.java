package com.baidu.tieba.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class dg extends BaseAdapter {
    boolean b;
    boolean c;
    private PersonListActivity e;
    private com.baidu.tieba.util.i f;
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
                        com.baidu.adp.lib.util.e.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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

    public dg(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.e = personListActivity;
        this.f = new com.baidu.tieba.util.i(this.e);
        this.b = z;
        this.c = z2;
        this.j = i;
        this.k = onClickListener2;
        this.l = onClickListener3;
        this.m = onClickListener;
    }

    public final com.baidu.tieba.util.i c() {
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
        dh dhVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                dh dhVar2 = new dh(this, (byte) 0);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    dhVar2.a = (HeadImageView) inflate.findViewById(R.id.photo);
                    dhVar2.a.setIsRound(true);
                    dhVar2.a.setAutoChangeStyle(true);
                    dhVar2.e = (LinearLayout) inflate.findViewById(R.id.info);
                    dhVar2.e.setOnClickListener(this.m);
                    dhVar2.b = (TextView) inflate.findViewById(R.id.name);
                    dhVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    dhVar2.c = (TextView) inflate.findViewById(R.id.intro);
                    dhVar2.d = (ImageView) inflate.findViewById(R.id.chat);
                    dhVar2.d.setOnClickListener(this.k);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                    dhVar2.b = (TextView) inflate2.findViewById(R.id.pb_more_text);
                    inflate2.setOnClickListener(this.l);
                    dhVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(dhVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(dhVar2);
                dhVar = dhVar2;
                view = view2;
            } else {
                dhVar = (dh) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    dhVar.e.setVisibility(8);
                    dhVar.d.setVisibility(8);
                    dhVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            dhVar.g.setText(R.string.not_have_attention);
                        } else if (this.j == 2) {
                            dhVar.g.setText(R.string.her_no_attention_other);
                        } else if (this.j == 1) {
                            dhVar.g.setText(R.string.him_no_attention_other);
                        } else {
                            dhVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        dhVar.g.setText(R.string.not_have_fans);
                    } else if (this.j == 2) {
                        dhVar.g.setText(R.string.her_no_fan_other);
                    } else if (this.j == 1) {
                        dhVar.g.setText(R.string.him_no_fan_other);
                    } else {
                        dhVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    dhVar.d.setVisibility(0);
                    dhVar.e.setVisibility(0);
                    dhVar.e.setTag(Integer.valueOf(i));
                    dhVar.g.setVisibility(8);
                    String portrait = this.d.get(i).getPortrait();
                    com.baidu.tieba.util.i iVar = this.f;
                    com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(portrait);
                    if (b != null) {
                        dhVar.a.setTag(null);
                        b.a(dhVar.a);
                    } else {
                        dhVar.a.setTag(portrait);
                        dhVar.a.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                    }
                    dhVar.b.setText(this.d.get(i).getName_show());
                    dhVar.c.setText(this.d.get(i).getIntro());
                    dhVar.d.setTag(Integer.valueOf(i));
                }
            } else {
                dhVar.b.setText(this.e.getString(R.string.loading));
                dhVar.f.setVisibility(0);
            }
            this.e.getLayoutMode().a(TiebaApplication.g().ae() == 1);
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
