package com.baidu.tieba.person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cd extends BaseAdapter {
    boolean b;
    boolean c;
    private Context e;
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

    public void a() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        this.i.get(i2).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.adp.lib.g.e.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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

    public cd(Context context, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.e = context;
        this.f = new com.baidu.tieba.util.i(this.e);
        this.b = z;
        this.c = z2;
        this.j = i;
        this.k = onClickListener;
        this.l = onClickListener2;
        this.m = onClickListener3;
    }

    public com.baidu.tieba.util.i c() {
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
        cf cfVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                cf cfVar2 = new cf(this);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    cfVar2.a = (ImageView) inflate.findViewById(R.id.photo);
                    cfVar2.c = (TextView) inflate.findViewById(R.id.name);
                    cfVar2.b = (LinearLayout) inflate.findViewById(R.id.info);
                    cfVar2.b.setOnClickListener(this.k);
                    cfVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    cfVar2.d = (TextView) inflate.findViewById(R.id.intro);
                    cfVar2.e = (Button) inflate.findViewById(R.id.chat);
                    cfVar2.e.setOnClickListener(this.l);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    cfVar2.c = (TextView) inflate2.findViewById(R.id.page_text);
                    inflate2.setOnClickListener(this.m);
                    cfVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(cfVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(cfVar2);
                cfVar = cfVar2;
                view = view2;
            } else {
                cfVar = (cf) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    cfVar.b.setVisibility(8);
                    cfVar.e.setVisibility(8);
                    cfVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            cfVar.g.setText(R.string.not_have_attention);
                        } else if (this.j == 2) {
                            cfVar.g.setText(R.string.her_no_attention_other);
                        } else if (this.j == 1) {
                            cfVar.g.setText(R.string.him_no_attention_other);
                        } else {
                            cfVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        cfVar.g.setText(R.string.not_have_fans);
                    } else if (this.j == 2) {
                        cfVar.g.setText(R.string.her_no_fan_other);
                    } else if (this.j == 1) {
                        cfVar.g.setText(R.string.him_no_fan_other);
                    } else {
                        cfVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    cfVar.b.setVisibility(0);
                    cfVar.e.setVisibility(0);
                    cfVar.b.setTag(Integer.valueOf(i));
                    cfVar.g.setVisibility(8);
                    String portrait = this.d.get(i).getPortrait();
                    com.baidu.adp.widget.ImageView.d c = this.f.c(portrait);
                    if (c != null) {
                        cfVar.a.setTag(null);
                        c.a(cfVar.a);
                    } else {
                        cfVar.a.setTag(portrait);
                        cfVar.a.setImageBitmap(com.baidu.tieba.util.n.a((int) R.drawable.photo));
                    }
                    cfVar.c.setText(this.d.get(i).getName_show());
                    cfVar.d.setText(this.d.get(i).getIntro());
                    cfVar.e.setTag(Integer.valueOf(i));
                    if (TiebaApplication.h().al() == 1) {
                        cfVar.c.setTextColor(-8682095);
                        cfVar.d.setTextColor(-11446171);
                        com.baidu.tieba.util.bs.e(cfVar.b, (int) R.drawable.person_list_item_info_selector_1);
                        com.baidu.tieba.util.bs.e((View) cfVar.e, (int) R.drawable.person_list_item_chat_selector_1);
                        cfVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat_1, 0, 0, 0);
                    } else {
                        cfVar.c.setTextColor(-14277082);
                        cfVar.d.setTextColor(-6842215);
                        com.baidu.tieba.util.bs.e(cfVar.b, (int) R.drawable.person_list_item_info_selector);
                        com.baidu.tieba.util.bs.e((View) cfVar.e, (int) R.drawable.person_list_item_chat_selector);
                        cfVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat, 0, 0, 0);
                    }
                }
            } else if (this.h) {
                cfVar.c.setText(this.e.getString(R.string.loading));
                cfVar.f.setVisibility(0);
            } else {
                cfVar.c.setText(this.e.getString(R.string.load_more));
                cfVar.f.setVisibility(8);
            }
            if (TiebaApplication.h().al() == 1) {
                cfVar.c.setTextColor(com.baidu.tieba.util.bs.a(1));
                if (cfVar.g != null) {
                    cfVar.g.setTextColor(this.e.getResources().getColor(R.color.person_post_header_uname_1));
                }
            } else {
                cfVar.c.setTextColor(-16777216);
                if (cfVar.g != null) {
                    cfVar.g.setTextColor(this.e.getResources().getColor(R.color.person_post_header_uname));
                }
            }
        }
        return view;
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
