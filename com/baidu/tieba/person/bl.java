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
public class bl extends BaseAdapter {
    boolean b;
    boolean c;
    private Context e;
    private com.baidu.tieba.util.a f;
    private View.OnClickListener j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private ArrayList d = null;
    private boolean g = false;
    private boolean h = false;

    /* renamed from: a  reason: collision with root package name */
    boolean f1595a = false;
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
                        com.baidu.tieba.util.aj.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        this.f1595a = false;
        if (this.d != null && this.d.size() == 0) {
            this.f1595a = true;
        }
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public bl(Context context, boolean z, boolean z2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.j = null;
        this.k = null;
        this.l = null;
        this.e = context;
        this.f = new com.baidu.tieba.util.a(this.e);
        this.b = z;
        this.c = z2;
        this.j = onClickListener;
        this.k = onClickListener2;
        this.l = onClickListener3;
    }

    public com.baidu.tieba.util.a c() {
        return this.f;
    }

    public void a(ArrayList arrayList) {
        this.d = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1595a) {
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
        bm bmVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                bm bmVar2 = new bm(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    bmVar2.f1596a = (ImageView) inflate.findViewById(R.id.photo);
                    bmVar2.c = (TextView) inflate.findViewById(R.id.name);
                    bmVar2.b = (LinearLayout) inflate.findViewById(R.id.info);
                    bmVar2.b.setOnClickListener(this.j);
                    bmVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    bmVar2.d = (TextView) inflate.findViewById(R.id.intro);
                    bmVar2.e = (Button) inflate.findViewById(R.id.chat);
                    bmVar2.e.setOnClickListener(this.k);
                    if (TiebaApplication.f().au() == 1) {
                        bmVar2.c.setTextColor(-8682095);
                        bmVar2.d.setTextColor(-11446171);
                        com.baidu.tieba.util.ah.h(bmVar2.b, (int) R.drawable.person_list_item_info_selector_1);
                        com.baidu.tieba.util.ah.h((View) bmVar2.e, (int) R.drawable.person_list_item_chat_selector_1);
                        bmVar2.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat_1, 0, 0, 0);
                        view2 = inflate;
                    } else {
                        bmVar2.c.setTextColor(-14277082);
                        bmVar2.d.setTextColor(-6842215);
                        com.baidu.tieba.util.ah.h(bmVar2.b, (int) R.drawable.person_list_item_info_selector);
                        com.baidu.tieba.util.ah.h((View) bmVar2.e, (int) R.drawable.person_list_item_chat_selector);
                        bmVar2.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat, 0, 0, 0);
                        view2 = inflate;
                    }
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bmVar2.c = (TextView) inflate2.findViewById(R.id.page_text);
                    inflate2.setOnClickListener(this.l);
                    bmVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(bmVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(bmVar2);
                bmVar = bmVar2;
                view = view2;
            } else {
                bmVar = (bm) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.f1595a) {
                    bmVar.b.setVisibility(8);
                    bmVar.e.setVisibility(8);
                    bmVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            bmVar.g.setText(R.string.not_have_attention);
                        } else {
                            bmVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        bmVar.g.setText(R.string.not_have_fans);
                    } else {
                        bmVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    bmVar.b.setVisibility(0);
                    bmVar.e.setVisibility(0);
                    bmVar.b.setTag(Integer.valueOf(i));
                    bmVar.g.setVisibility(8);
                    String portrait = ((UserData) this.d.get(i)).getPortrait();
                    com.baidu.adp.widget.a.b c = this.f.c(portrait);
                    if (c != null) {
                        bmVar.f1596a.setTag(null);
                        c.b(bmVar.f1596a);
                    } else {
                        bmVar.f1596a.setTag(portrait);
                        bmVar.f1596a.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
                    }
                    bmVar.c.setText(((UserData) this.d.get(i)).getName_show());
                    bmVar.d.setText(((UserData) this.d.get(i)).getIntro());
                    bmVar.e.setTag(Integer.valueOf(i));
                }
            } else if (this.h) {
                bmVar.c.setText(this.e.getString(R.string.loading));
                bmVar.f.setVisibility(0);
            } else {
                bmVar.c.setText(this.e.getString(R.string.load_more));
                bmVar.f.setVisibility(8);
            }
            if (TiebaApplication.f().au() == 1) {
                int a2 = com.baidu.tieba.util.ah.a(1);
                bmVar.c.setTextColor(a2);
                if (bmVar.g != null) {
                    bmVar.g.setTextColor(a2);
                }
            } else {
                bmVar.c.setTextColor(-16777216);
                if (bmVar.g != null) {
                    bmVar.g.setTextColor(-4276546);
                }
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f1595a) {
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
        if (this.f1595a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
