package com.baidu.tieba.person;

import android.text.TextUtils;
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
public class dr extends BaseAdapter {
    boolean b;
    boolean c;
    private ArrayList<UserData> d;
    private PersonListActivity e;
    private int i;
    private View.OnClickListener j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private boolean f = false;
    private boolean g = false;
    boolean a = false;
    private ArrayList<ProgressBar> h = new ArrayList<>();

    public void a() {
        if (this.h != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.h.size()) {
                    try {
                        this.h.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        BdLog.e(String.valueOf(getClass().getName()) + "releaseProgressBar" + e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.h.clear();
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

    public boolean c() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public dr(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.d = null;
        this.e = null;
        this.b = false;
        this.c = true;
        this.i = 0;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.e = personListActivity;
        this.b = z;
        this.c = z2;
        this.i = i;
        this.j = onClickListener2;
        this.k = onClickListener3;
        this.l = onClickListener;
        this.m = onClickListener4;
        this.d = new ArrayList<>();
    }

    public void a(ArrayList<UserData> arrayList) {
        this.d.addAll(arrayList);
    }

    public void d() {
        this.d.clear();
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
        if (this.f) {
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
        ds dsVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                ds dsVar2 = new ds(this, null);
                if (getItemViewType(i) == 0) {
                    View a = com.baidu.adp.lib.e.b.a().a(this.e, com.baidu.tieba.v.person_list_item, null);
                    dsVar2.a = (ViewGroup) a.findViewById(com.baidu.tieba.u.item_view);
                    dsVar2.a.setOnClickListener(this.l);
                    dsVar2.b = (HeadImageView) a.findViewById(com.baidu.tieba.u.photo);
                    dsVar2.b.setIsRound(false);
                    dsVar2.b.setAutoChangeStyle(true);
                    dsVar2.g = (LinearLayout) a.findViewById(com.baidu.tieba.u.info);
                    dsVar2.c = (TextView) a.findViewById(com.baidu.tieba.u.name);
                    dsVar2.i = (TextView) a.findViewById(com.baidu.tieba.u.at_list_nodata);
                    dsVar2.d = (TextView) a.findViewById(com.baidu.tieba.u.intro);
                    dsVar2.e = (ImageView) a.findViewById(com.baidu.tieba.u.chat);
                    dsVar2.f = (TextView) a.findViewById(com.baidu.tieba.u.add);
                    dsVar2.e.setOnClickListener(this.j);
                    dsVar2.f.setOnClickListener(this.m);
                    view2 = a;
                } else {
                    View a2 = com.baidu.adp.lib.e.b.a().a(this.e, com.baidu.tieba.v.new_pb_list_more, null);
                    dsVar2.c = (TextView) a2.findViewById(com.baidu.tieba.u.pb_more_text);
                    a2.setOnClickListener(this.k);
                    dsVar2.h = (ProgressBar) a2.findViewById(com.baidu.tieba.u.progress);
                    this.h.add(dsVar2.h);
                    view2 = a2;
                }
                view2.setTag(dsVar2);
                dsVar = dsVar2;
                view = view2;
            } else {
                dsVar = (ds) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    dsVar.g.setVisibility(8);
                    dsVar.e.setVisibility(8);
                    dsVar.f.setVisibility(8);
                    dsVar.i.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            dsVar.i.setText(com.baidu.tieba.x.not_have_attention);
                        } else if (this.i == 2) {
                            dsVar.i.setText(com.baidu.tieba.x.her_no_attention_other);
                        } else if (this.i == 1) {
                            dsVar.i.setText(com.baidu.tieba.x.him_no_attention_other);
                        } else {
                            dsVar.i.setText(com.baidu.tieba.x.no_attention_other);
                        }
                    } else if (this.c) {
                        dsVar.i.setText(com.baidu.tieba.x.not_have_fans);
                    } else if (this.i == 2) {
                        dsVar.i.setText(com.baidu.tieba.x.her_no_fan_other);
                    } else if (this.i == 1) {
                        dsVar.i.setText(com.baidu.tieba.x.him_no_fan_other);
                    } else {
                        dsVar.i.setText(com.baidu.tieba.x.no_fan_other);
                    }
                } else {
                    dsVar.a.setTag(Integer.valueOf(i));
                    dsVar.e.setVisibility(0);
                    dsVar.f.setVisibility(0);
                    dsVar.g.setVisibility(0);
                    dsVar.i.setVisibility(8);
                    dsVar.b.a(this.d.get(i).getPortrait(), 12, false);
                    dsVar.c.setText(this.d.get(i).getName_show());
                    dsVar.d.setText(this.d.get(i).getIntro());
                    dsVar.e.setTag(Integer.valueOf(i));
                    dsVar.f.setTag(Integer.valueOf(i));
                    String userId = this.d.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkApplication.getCurrentAccount())) {
                        dsVar.e.setVisibility(8);
                        dsVar.f.setVisibility(8);
                    } else if (this.d.get(i).getIsFriend() == 1) {
                        dsVar.e.setVisibility(0);
                        dsVar.f.setVisibility(8);
                    } else {
                        dsVar.e.setVisibility(8);
                        dsVar.f.setVisibility(0);
                    }
                }
            } else {
                dsVar.c.setText(this.e.getString(com.baidu.tieba.x.loading));
                dsVar.h.setVisibility(0);
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
