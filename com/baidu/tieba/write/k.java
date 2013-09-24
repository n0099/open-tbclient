package com.baidu.tieba.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MetaData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    boolean b;
    boolean c;
    private Context e;
    private com.baidu.tieba.util.a f;
    private ArrayList<MetaData> d = null;
    private boolean g = false;
    private boolean h = false;

    /* renamed from: a  reason: collision with root package name */
    boolean f2118a = false;
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
                        com.baidu.tieba.util.av.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.i.clear();
                    return;
                }
            }
        }
    }

    public k(Context context, boolean z, boolean z2) {
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = true;
        this.e = context;
        this.f = new com.baidu.tieba.util.a(this.e);
        this.b = z;
        this.c = z2;
    }

    public com.baidu.tieba.util.a b() {
        return this.f;
    }

    public void a(ArrayList<MetaData> arrayList) {
        this.d = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f2118a) {
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
        l lVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                l lVar2 = new l(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.at_list_item, (ViewGroup) null);
                    lVar2.f2119a = (ImageView) inflate.findViewById(R.id.photo);
                    lVar2.b = (TextView) inflate.findViewById(R.id.name);
                    lVar2.e = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    lVar2.b = (TextView) inflate2.findViewById(R.id.page_text);
                    lVar2.d = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(lVar2.d);
                    view2 = inflate2;
                }
                view2.setTag(lVar2);
                lVar = lVar2;
                view = view2;
            } else {
                lVar = (l) view.getTag();
            }
            try {
                if (getItemViewType(i) == 0) {
                    if (this.f2118a) {
                        lVar.f2119a.setVisibility(8);
                        lVar.b.setVisibility(8);
                        lVar.e.setVisibility(0);
                        if (this.b) {
                            if (this.c) {
                                lVar.e.setText(R.string.not_have_attention);
                            } else {
                                lVar.e.setText(R.string.no_attention_other);
                            }
                        } else if (this.c) {
                            lVar.e.setText(R.string.not_have_fans);
                        } else {
                            lVar.e.setText(R.string.no_fan_other);
                        }
                    } else {
                        lVar.f2119a.setVisibility(0);
                        lVar.b.setVisibility(0);
                        lVar.e.setVisibility(8);
                        String portrait = this.d.get(i).getPortrait();
                        com.baidu.adp.widget.a.c c = this.f.c(portrait);
                        if (c != null) {
                            lVar.f2119a.setTag(null);
                            c.a(lVar.f2119a);
                        } else {
                            lVar.f2119a.setTag(portrait);
                            lVar.f2119a.setImageBitmap(com.baidu.tieba.util.e.a((int) R.drawable.photo));
                        }
                        lVar.b.setText(this.d.get(i).getName_show());
                    }
                } else if (this.h) {
                    lVar.b.setText(this.e.getString(R.string.loading));
                    lVar.d.setVisibility(0);
                } else {
                    lVar.b.setText(this.e.getString(R.string.load_more));
                    lVar.d.setVisibility(8);
                }
                int ap = TiebaApplication.g().ap();
                if (ap == 1) {
                    com.baidu.tieba.util.as.e(view, (int) R.drawable.list_selector_1);
                } else {
                    com.baidu.tieba.util.as.e(view, (int) R.drawable.list_selector_divider1);
                }
                if (ap == 1) {
                    lVar.b.setTextColor(-8682086);
                    lVar.c.setTextColor(-11446171);
                    if (lVar.e != null) {
                        lVar.e.setTextColor(-8682086);
                    }
                } else {
                    lVar.b.setTextColor(-14277082);
                    lVar.c.setTextColor(-10066330);
                    if (lVar.e != null) {
                        lVar.e.setTextColor(-8682086);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.f.d.a(e.getMessage());
            }
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.f2118a) {
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
        if (this.f2118a) {
            return false;
        }
        return super.isEnabled(i);
    }
}
