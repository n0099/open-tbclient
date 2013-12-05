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
public class bu extends BaseAdapter {
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

    /* renamed from: a  reason: collision with root package name */
    boolean f2344a = false;
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
                        com.baidu.tieba.util.bd.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        this.f2344a = false;
        if (this.d != null && this.d.size() == 0) {
            this.f2344a = true;
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public bu(Context context, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
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
        if (this.f2344a) {
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
        bw bwVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                bw bwVar2 = new bw(this);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    bwVar2.f2345a = (ImageView) inflate.findViewById(R.id.photo);
                    bwVar2.c = (TextView) inflate.findViewById(R.id.name);
                    bwVar2.b = (LinearLayout) inflate.findViewById(R.id.info);
                    bwVar2.b.setOnClickListener(this.k);
                    bwVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    bwVar2.d = (TextView) inflate.findViewById(R.id.intro);
                    bwVar2.e = (Button) inflate.findViewById(R.id.chat);
                    bwVar2.e.setOnClickListener(this.l);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bwVar2.c = (TextView) inflate2.findViewById(R.id.page_text);
                    inflate2.setOnClickListener(this.m);
                    bwVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(bwVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(bwVar2);
                bwVar = bwVar2;
                view = view2;
            } else {
                bwVar = (bw) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.f2344a) {
                    bwVar.b.setVisibility(8);
                    bwVar.e.setVisibility(8);
                    bwVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            bwVar.g.setText(R.string.not_have_attention);
                        } else if (this.j == 2) {
                            bwVar.g.setText(R.string.her_no_attention_other);
                        } else if (this.j == 1) {
                            bwVar.g.setText(R.string.him_no_attention_other);
                        } else {
                            bwVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        bwVar.g.setText(R.string.not_have_fans);
                    } else if (this.j == 2) {
                        bwVar.g.setText(R.string.her_no_fan_other);
                    } else if (this.j == 1) {
                        bwVar.g.setText(R.string.him_no_fan_other);
                    } else {
                        bwVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    bwVar.b.setVisibility(0);
                    bwVar.e.setVisibility(0);
                    bwVar.b.setTag(Integer.valueOf(i));
                    bwVar.g.setVisibility(8);
                    String portrait = this.d.get(i).getPortrait();
                    com.baidu.adp.widget.ImageView.e c = this.f.c(portrait);
                    if (c != null) {
                        bwVar.f2345a.setTag(null);
                        c.a(bwVar.f2345a);
                    } else {
                        bwVar.f2345a.setTag(portrait);
                        bwVar.f2345a.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
                    }
                    bwVar.c.setText(this.d.get(i).getName_show());
                    bwVar.d.setText(this.d.get(i).getIntro());
                    bwVar.e.setTag(Integer.valueOf(i));
                    if (TiebaApplication.h().an() == 1) {
                        bwVar.c.setTextColor(-8682095);
                        bwVar.d.setTextColor(-11446171);
                        com.baidu.tieba.util.ba.e(bwVar.b, (int) R.drawable.person_list_item_info_selector_1);
                        com.baidu.tieba.util.ba.e((View) bwVar.e, (int) R.drawable.person_list_item_chat_selector_1);
                        bwVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat_1, 0, 0, 0);
                    } else {
                        bwVar.c.setTextColor(-14277082);
                        bwVar.d.setTextColor(-6842215);
                        com.baidu.tieba.util.ba.e(bwVar.b, (int) R.drawable.person_list_item_info_selector);
                        com.baidu.tieba.util.ba.e((View) bwVar.e, (int) R.drawable.person_list_item_chat_selector);
                        bwVar.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat, 0, 0, 0);
                    }
                }
            } else if (this.h) {
                bwVar.c.setText(this.e.getString(R.string.loading));
                bwVar.f.setVisibility(0);
            } else {
                bwVar.c.setText(this.e.getString(R.string.load_more));
                bwVar.f.setVisibility(8);
            }
            if (TiebaApplication.h().an() == 1) {
                bwVar.c.setTextColor(com.baidu.tieba.util.ba.a(1));
                if (bwVar.g != null) {
                    bwVar.g.setTextColor(this.e.getResources().getColor(R.color.person_post_header_uname_1));
                }
            } else {
                bwVar.c.setTextColor(-16777216);
                if (bwVar.g != null) {
                    bwVar.g.setTextColor(this.e.getResources().getColor(R.color.person_post_header_uname));
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f2344a) {
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
        if (this.f2344a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
