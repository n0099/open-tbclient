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
public class bw extends BaseAdapter {
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
                        com.baidu.tieba.util.be.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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

    public bw(Context context, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
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
        by byVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                by byVar2 = new by(this);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    byVar2.a = (ImageView) inflate.findViewById(R.id.photo);
                    byVar2.c = (TextView) inflate.findViewById(R.id.name);
                    byVar2.b = (LinearLayout) inflate.findViewById(R.id.info);
                    byVar2.b.setOnClickListener(this.k);
                    byVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    byVar2.d = (TextView) inflate.findViewById(R.id.intro);
                    byVar2.e = (Button) inflate.findViewById(R.id.chat);
                    byVar2.e.setOnClickListener(this.l);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    byVar2.c = (TextView) inflate2.findViewById(R.id.page_text);
                    inflate2.setOnClickListener(this.m);
                    byVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(byVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(byVar2);
                byVar = byVar2;
                view = view2;
            } else {
                byVar = (by) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    byVar.b.setVisibility(8);
                    byVar.e.setVisibility(8);
                    byVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            byVar.g.setText(R.string.not_have_attention);
                        } else if (this.j == 2) {
                            byVar.g.setText(R.string.her_no_attention_other);
                        } else if (this.j == 1) {
                            byVar.g.setText(R.string.him_no_attention_other);
                        } else {
                            byVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        byVar.g.setText(R.string.not_have_fans);
                    } else if (this.j == 2) {
                        byVar.g.setText(R.string.her_no_fan_other);
                    } else if (this.j == 1) {
                        byVar.g.setText(R.string.him_no_fan_other);
                    } else {
                        byVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    byVar.b.setVisibility(0);
                    byVar.e.setVisibility(0);
                    byVar.b.setTag(Integer.valueOf(i));
                    byVar.g.setVisibility(8);
                    String portrait = this.d.get(i).getPortrait();
                    com.baidu.adp.widget.ImageView.e c = this.f.c(portrait);
                    if (c != null) {
                        byVar.a.setTag(null);
                        c.a(byVar.a);
                    } else {
                        byVar.a.setTag(portrait);
                        byVar.a.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
                    }
                    byVar.c.setText(this.d.get(i).getName_show());
                    byVar.d.setText(this.d.get(i).getIntro());
                    byVar.e.setTag(Integer.valueOf(i));
                    if (TiebaApplication.h().an() == 1) {
                        byVar.c.setTextColor(-8682095);
                        byVar.d.setTextColor(-11446171);
                        com.baidu.tieba.util.bb.e(byVar.b, (int) R.drawable.person_list_item_info_selector_1);
                        com.baidu.tieba.util.bb.e((View) byVar.e, (int) R.drawable.person_list_item_chat_selector_1);
                        byVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat_1, 0, 0, 0);
                    } else {
                        byVar.c.setTextColor(-14277082);
                        byVar.d.setTextColor(-6842215);
                        com.baidu.tieba.util.bb.e(byVar.b, (int) R.drawable.person_list_item_info_selector);
                        com.baidu.tieba.util.bb.e((View) byVar.e, (int) R.drawable.person_list_item_chat_selector);
                        byVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat, 0, 0, 0);
                    }
                }
            } else if (this.h) {
                byVar.c.setText(this.e.getString(R.string.loading));
                byVar.f.setVisibility(0);
            } else {
                byVar.c.setText(this.e.getString(R.string.load_more));
                byVar.f.setVisibility(8);
            }
            if (TiebaApplication.h().an() == 1) {
                byVar.c.setTextColor(com.baidu.tieba.util.bb.a(1));
                if (byVar.g != null) {
                    byVar.g.setTextColor(this.e.getResources().getColor(R.color.person_post_header_uname_1));
                }
            } else {
                byVar.c.setTextColor(-16777216);
                if (byVar.g != null) {
                    byVar.g.setTextColor(this.e.getResources().getColor(R.color.person_post_header_uname));
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
