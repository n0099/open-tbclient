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
    private com.baidu.tieba.util.a f;
    private View.OnClickListener j;
    private View.OnClickListener k;
    private View.OnClickListener l;
    private ArrayList d = null;
    private boolean g = false;
    private boolean h = false;
    boolean a = false;
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
                        com.baidu.tieba.util.z.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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

    public bu(Context context, boolean z, boolean z2, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
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
        bv bvVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                bv bvVar2 = new bv(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.person_list_item, (ViewGroup) null);
                    bvVar2.a = (ImageView) inflate.findViewById(R.id.photo);
                    bvVar2.c = (TextView) inflate.findViewById(R.id.name);
                    bvVar2.b = (LinearLayout) inflate.findViewById(R.id.info);
                    bvVar2.b.setOnClickListener(this.j);
                    bvVar2.g = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    bvVar2.d = (TextView) inflate.findViewById(R.id.intro);
                    bvVar2.e = (Button) inflate.findViewById(R.id.chat);
                    bvVar2.e.setOnClickListener(this.k);
                    if (TiebaApplication.f().at() == 1) {
                        bvVar2.c.setTextColor(-8682095);
                        bvVar2.d.setTextColor(-11446171);
                        com.baidu.tieba.util.x.h(bvVar2.b, (int) R.drawable.person_list_item_info_selector_1);
                        com.baidu.tieba.util.x.h((View) bvVar2.e, (int) R.drawable.person_list_item_chat_selector_1);
                        bvVar2.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat_1, 0, 0, 0);
                        view2 = inflate;
                    } else {
                        bvVar2.c.setTextColor(-14277082);
                        bvVar2.d.setTextColor(-6842215);
                        com.baidu.tieba.util.x.h(bvVar2.b, (int) R.drawable.person_list_item_info_selector);
                        com.baidu.tieba.util.x.h((View) bvVar2.e, (int) R.drawable.person_list_item_chat_selector);
                        bvVar2.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_att_chat, 0, 0, 0);
                        view2 = inflate;
                    }
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    bvVar2.c = (TextView) inflate2.findViewById(R.id.page_text);
                    inflate2.setOnClickListener(this.l);
                    bvVar2.f = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(bvVar2.f);
                    view2 = inflate2;
                }
                view2.setTag(bvVar2);
                bvVar = bvVar2;
                view = view2;
            } else {
                bvVar = (bv) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.a) {
                    bvVar.b.setVisibility(8);
                    bvVar.e.setVisibility(8);
                    bvVar.g.setVisibility(0);
                    if (this.b) {
                        if (this.c) {
                            bvVar.g.setText(R.string.not_have_attention);
                        } else {
                            bvVar.g.setText(R.string.no_attention_other);
                        }
                    } else if (this.c) {
                        bvVar.g.setText(R.string.not_have_fans);
                    } else {
                        bvVar.g.setText(R.string.no_fan_other);
                    }
                } else {
                    bvVar.b.setVisibility(0);
                    bvVar.e.setVisibility(0);
                    bvVar.b.setTag(Integer.valueOf(i));
                    bvVar.g.setVisibility(8);
                    String portrait = ((UserData) this.d.get(i)).getPortrait();
                    com.baidu.adp.widget.a.b b = this.f.b(portrait);
                    if (b != null) {
                        bvVar.a.setTag(null);
                        b.b(bvVar.a);
                    } else {
                        bvVar.a.setTag(portrait);
                        bvVar.a.setImageBitmap(com.baidu.tieba.util.d.a((int) R.drawable.photo));
                    }
                    bvVar.c.setText(((UserData) this.d.get(i)).getName_show());
                    bvVar.d.setText(((UserData) this.d.get(i)).getIntro());
                    bvVar.e.setTag(Integer.valueOf(i));
                }
            } else if (this.h) {
                bvVar.c.setText(this.e.getString(R.string.loading));
                bvVar.f.setVisibility(0);
            } else {
                bvVar.c.setText(this.e.getString(R.string.load_more));
                bvVar.f.setVisibility(8);
            }
            if (TiebaApplication.f().at() == 1) {
                int a = com.baidu.tieba.util.x.a(1);
                bvVar.c.setTextColor(a);
                if (bvVar.g != null) {
                    bvVar.g.setTextColor(a);
                }
            } else {
                bvVar.c.setTextColor(-16777216);
                if (bvVar.g != null) {
                    bvVar.g.setTextColor(-4276546);
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
