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
public class bt extends BaseAdapter {
    boolean b;
    boolean c;
    private Context e;
    private com.baidu.tieba.util.a f;
    private int j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private ArrayList d = null;
    private boolean g = false;
    private boolean h = false;

    /* renamed from: a  reason: collision with root package name */
    boolean f1639a = false;
    private ArrayList i = new ArrayList();

    public void a() {
        if (this.i != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.i.size()) {
                    try {
                        ((ProgressBar) this.i.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.util.aq.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        this.f1639a = false;
        if (this.d != null && this.d.size() == 0) {
            this.f1639a = true;
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public bt(Context context, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.j = 0;
        this.k = null;
        this.l = null;
        this.m = null;
        this.e = context;
        this.f = new com.baidu.tieba.util.a(this.e);
        this.b = z;
        this.c = z2;
        this.j = i;
        this.k = onClickListener;
        this.l = onClickListener2;
        this.m = onClickListener3;
    }

    public com.baidu.tieba.util.a c() {
        return this.f;
    }

    public void a(ArrayList arrayList) {
        this.d = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1639a) {
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
        bu buVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                bu buVar2 = new bu(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    buVar2.f1640a = (ImageView) inflate.findViewById(R.id.photo);
                    buVar2.c = (TextView) inflate.findViewById(R.id.name);
                    buVar2.b = (LinearLayout) inflate.findViewById(R.id.info);
                    buVar2.b.setOnClickListener(this.k);
                    buVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    buVar2.d = (TextView) inflate.findViewById(R.id.intro);
                    buVar2.e = (Button) inflate.findViewById(R.id.chat);
                    buVar2.e.setOnClickListener(this.l);
                    if (TiebaApplication.g().an() == 1) {
                        buVar2.c.setTextColor(-8682095);
                        buVar2.d.setTextColor(-11446171);
                        com.baidu.tieba.util.ao.g(buVar2.b, (int) R.drawable.person_list_item_info_selector_1);
                        com.baidu.tieba.util.ao.g((View) buVar2.e, (int) R.drawable.person_list_item_chat_selector_1);
                        buVar2.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat_1, 0, 0, 0);
                        view2 = inflate;
                    } else {
                        buVar2.c.setTextColor(-14277082);
                        buVar2.d.setTextColor(-6842215);
                        com.baidu.tieba.util.ao.g(buVar2.b, (int) R.drawable.person_list_item_info_selector);
                        com.baidu.tieba.util.ao.g((View) buVar2.e, (int) R.drawable.person_list_item_chat_selector);
                        buVar2.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat, 0, 0, 0);
                        view2 = inflate;
                    }
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    buVar2.c = (TextView) inflate2.findViewById(R.id.page_text);
                    inflate2.setOnClickListener(this.m);
                    buVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(buVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(buVar2);
                buVar = buVar2;
                view = view2;
            } else {
                buVar = (bu) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.f1639a) {
                    buVar.b.setVisibility(8);
                    buVar.e.setVisibility(8);
                    buVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            buVar.g.setText(R.string.not_have_attention);
                        } else if (this.j == 2) {
                            buVar.g.setText(R.string.her_no_attention_other);
                        } else if (this.j == 1) {
                            buVar.g.setText(R.string.him_no_attention_other);
                        } else {
                            buVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        buVar.g.setText(R.string.not_have_fans);
                    } else if (this.j == 2) {
                        buVar.g.setText(R.string.her_no_fan_other);
                    } else if (this.j == 1) {
                        buVar.g.setText(R.string.him_no_fan_other);
                    } else {
                        buVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    buVar.b.setVisibility(0);
                    buVar.e.setVisibility(0);
                    buVar.b.setTag(Integer.valueOf(i));
                    buVar.g.setVisibility(8);
                    String portrait = ((UserData) this.d.get(i)).getPortrait();
                    com.baidu.adp.widget.a.b c = this.f.c(portrait);
                    if (c != null) {
                        buVar.f1640a.setTag(null);
                        c.a(buVar.f1640a);
                    } else {
                        buVar.f1640a.setTag(portrait);
                        buVar.f1640a.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
                    }
                    buVar.c.setText(((UserData) this.d.get(i)).getName_show());
                    buVar.d.setText(((UserData) this.d.get(i)).getIntro());
                    buVar.e.setTag(Integer.valueOf(i));
                }
            } else if (this.h) {
                buVar.c.setText(this.e.getString(R.string.loading));
                buVar.f.setVisibility(0);
            } else {
                buVar.c.setText(this.e.getString(R.string.load_more));
                buVar.f.setVisibility(8);
            }
            if (TiebaApplication.g().an() == 1) {
                buVar.c.setTextColor(com.baidu.tieba.util.ao.a(1));
                if (buVar.g != null) {
                    buVar.g.setTextColor(com.baidu.tieba.util.ao.a(1));
                }
            } else {
                buVar.c.setTextColor(-16777216);
                if (buVar.g != null) {
                    buVar.g.setTextColor(-4276546);
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f1639a) {
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
        if (this.f1639a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
