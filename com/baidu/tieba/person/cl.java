package com.baidu.tieba.person;

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
public class cl extends BaseAdapter {
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

    public cl(PersonFriendActivity personFriendActivity, boolean z, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
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
        cm cmVar;
        View view2;
        if (this.a != null) {
            if (view == null) {
                cm cmVar2 = new cm(this, null);
                if (getItemViewType(i) == 0) {
                    View a = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.person_list_item_friend, null);
                    cmVar2.a = (HeadImageView) a.findViewById(com.baidu.tieba.u.photo);
                    cmVar2.a.setIsRound(false);
                    cmVar2.a.setAutoChangeStyle(true);
                    cmVar2.e = (LinearLayout) a.findViewById(com.baidu.tieba.u.info);
                    cmVar2.b = (TextView) a.findViewById(com.baidu.tieba.u.name);
                    cmVar2.g = (TextView) a.findViewById(com.baidu.tieba.u.at_list_nodata);
                    cmVar2.c = (TextView) a.findViewById(com.baidu.tieba.u.intro);
                    cmVar2.d = (ImageView) a.findViewById(com.baidu.tieba.u.chat);
                    cmVar2.h = (ImageView) a.findViewById(com.baidu.tieba.u.diver_buttom_px);
                    cmVar2.d.setOnClickListener(this.i);
                    view2 = a;
                } else {
                    View a2 = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.new_pb_list_more, null);
                    cmVar2.b = (TextView) a2.findViewById(com.baidu.tieba.u.pb_more_text);
                    a2.setOnClickListener(this.j);
                    cmVar2.f = (ProgressBar) a2.findViewById(com.baidu.tieba.u.progress);
                    this.e.add(cmVar2.f);
                    view2 = a2;
                }
                view2.setTag(cmVar2);
                cmVar = cmVar2;
                view = view2;
            } else {
                cmVar = (cm) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.f) {
                    cmVar.e.setVisibility(8);
                    cmVar.d.setVisibility(8);
                    cmVar.g.setVisibility(8);
                    cmVar.h.setVisibility(8);
                } else {
                    if (!this.g && this.h == 0) {
                        cmVar.d.setVisibility(8);
                    } else {
                        cmVar.d.setVisibility(0);
                    }
                    cmVar.e.setVisibility(0);
                    cmVar.e.setTag(Integer.valueOf(i));
                    cmVar.h.setVisibility(0);
                    cmVar.g.setVisibility(8);
                    String portrait = this.a.get(i).getPortrait();
                    cmVar.a.setImageDrawable(null);
                    cmVar.a.a(portrait, 12, false);
                    cmVar.b.setText(this.a.get(i).getName_show());
                    cmVar.c.setText(this.a.get(i).getIntro());
                    cmVar.d.setTag(Integer.valueOf(i));
                }
            } else {
                cmVar.b.setText(this.b.getString(com.baidu.tieba.x.loading));
                cmVar.f.setVisibility(0);
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
