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
public class ci extends BaseAdapter {
    boolean b;
    boolean c;
    private PersonListActivity e;
    private com.baidu.tbadk.editortool.ab f;
    private int j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private ArrayList<UserData> d = null;
    private boolean g = false;
    private boolean h = false;
    boolean a = false;
    private ArrayList<ProgressBar> i = new ArrayList<>();

    public void a() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        this.i.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    public void b() {
        this.a = false;
        if (this.d != null && this.d.size() == 0) {
            this.a = true;
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public ci(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.e = personListActivity;
        this.f = new com.baidu.tbadk.editortool.ab(this.e);
        this.b = z;
        this.c = z2;
        this.j = i;
        this.k = onClickListener2;
        this.l = onClickListener3;
        this.m = onClickListener;
    }

    public com.baidu.tbadk.editortool.ab c() {
        return this.f;
    }

    public void a(ArrayList<UserData> arrayList) {
        this.d = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
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
    public Object getItem(int i) {
        if (this.d == null || i >= this.d.size()) {
            return null;
        }
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.d == null || i >= this.d.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        cj cjVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                cj cjVar2 = new cj(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(com.baidu.tieba.s.person_list_item, (ViewGroup) null);
                    cjVar2.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.r.photo);
                    cjVar2.a.setIsRound(true);
                    cjVar2.a.setAutoChangeStyle(true);
                    cjVar2.e = (LinearLayout) inflate.findViewById(com.baidu.tieba.r.info);
                    cjVar2.e.setOnClickListener(this.m);
                    cjVar2.b = (TextView) inflate.findViewById(com.baidu.tieba.r.name);
                    cjVar2.g = (TextView) inflate.findViewById(com.baidu.tieba.r.at_list_nodata);
                    cjVar2.c = (TextView) inflate.findViewById(com.baidu.tieba.r.intro);
                    cjVar2.d = (ImageView) inflate.findViewById(com.baidu.tieba.r.chat);
                    cjVar2.d.setOnClickListener(this.k);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(com.baidu.tieba.s.new_pb_list_more, (ViewGroup) null);
                    cjVar2.b = (TextView) inflate2.findViewById(com.baidu.tieba.r.pb_more_text);
                    inflate2.setOnClickListener(this.l);
                    cjVar2.f = (ProgressBar) inflate2.findViewById(com.baidu.tieba.r.progress);
                    this.i.add(cjVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(cjVar2);
                cjVar = cjVar2;
                view = view2;
            } else {
                cjVar = (cj) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    cjVar.e.setVisibility(8);
                    cjVar.d.setVisibility(8);
                    cjVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            cjVar.g.setText(com.baidu.tieba.u.not_have_attention);
                        } else if (this.j == 2) {
                            cjVar.g.setText(com.baidu.tieba.u.her_no_attention_other);
                        } else if (this.j == 1) {
                            cjVar.g.setText(com.baidu.tieba.u.him_no_attention_other);
                        } else {
                            cjVar.g.setText(com.baidu.tieba.u.no_attention_other);
                        }
                    } else if (this.c) {
                        cjVar.g.setText(com.baidu.tieba.u.not_have_fans);
                    } else if (this.j == 2) {
                        cjVar.g.setText(com.baidu.tieba.u.her_no_fan_other);
                    } else if (this.j == 1) {
                        cjVar.g.setText(com.baidu.tieba.u.him_no_fan_other);
                    } else {
                        cjVar.g.setText(com.baidu.tieba.u.no_fan_other);
                    }
                } else {
                    cjVar.d.setVisibility(0);
                    cjVar.e.setVisibility(0);
                    cjVar.e.setTag(Integer.valueOf(i));
                    cjVar.g.setVisibility(8);
                    String portrait = this.d.get(i).getPortrait();
                    com.baidu.adp.widget.a.a c = this.f.c(portrait);
                    if (c != null) {
                        cjVar.a.setTag(null);
                        c.a(cjVar.a);
                    } else {
                        cjVar.a.setTag(portrait);
                        cjVar.a.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.photo));
                    }
                    cjVar.b.setText(this.d.get(i).getName_show());
                    cjVar.c.setText(this.d.get(i).getIntro());
                    cjVar.d.setTag(Integer.valueOf(i));
                }
            } else {
                cjVar.b.setText(this.e.getString(com.baidu.tieba.u.loading));
                cjVar.f.setVisibility(0);
            }
            a(view);
        }
        return view;
    }

    private void a(View view) {
        this.e.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.e.getLayoutMode().a(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.a) {
            return 0;
        }
        return (this.d == null || i >= this.d.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
