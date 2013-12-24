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
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    boolean b;
    boolean c;
    private Context e;
    private com.baidu.tieba.util.i f;
    private ArrayList<MetaData> d = null;
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
                        be.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        this.f = new com.baidu.tieba.util.i(this.e);
        this.b = z;
        this.c = z2;
    }

    public com.baidu.tieba.util.i b() {
        return this.f;
    }

    public void a(ArrayList<MetaData> arrayList) {
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
        m mVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                m mVar2 = new m(this);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.at_list_item, (ViewGroup) null);
                    mVar2.a = (ImageView) inflate.findViewById(R.id.photo);
                    mVar2.b = (TextView) inflate.findViewById(R.id.name);
                    mVar2.e = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    mVar2.b = (TextView) inflate2.findViewById(R.id.page_text);
                    mVar2.d = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(mVar2.d);
                    view2 = inflate2;
                }
                view2.setTag(mVar2);
                mVar = mVar2;
                view = view2;
            } else {
                mVar = (m) view.getTag();
            }
            try {
                if (getItemViewType(i) == 0) {
                    if (this.a) {
                        mVar.a.setVisibility(8);
                        mVar.b.setVisibility(8);
                        mVar.e.setVisibility(0);
                        if (this.b) {
                            if (this.c) {
                                mVar.e.setText(R.string.not_have_attention);
                            } else {
                                mVar.e.setText(R.string.no_attention_other);
                            }
                        } else if (this.c) {
                            mVar.e.setText(R.string.not_have_fans);
                        } else {
                            mVar.e.setText(R.string.no_fan_other);
                        }
                    } else {
                        mVar.a.setVisibility(0);
                        mVar.b.setVisibility(0);
                        mVar.e.setVisibility(8);
                        String portrait = this.d.get(i).getPortrait();
                        com.baidu.adp.widget.ImageView.e c = this.f.c(portrait);
                        if (c != null) {
                            mVar.a.setTag(null);
                            c.a(mVar.a);
                        } else {
                            mVar.a.setTag(portrait);
                            mVar.a.setImageBitmap(com.baidu.tieba.util.m.a((int) R.drawable.photo));
                        }
                        mVar.b.setText(this.d.get(i).getName_show());
                    }
                } else if (this.h) {
                    mVar.b.setText(this.e.getString(R.string.loading));
                    mVar.d.setVisibility(0);
                } else {
                    mVar.b.setText(this.e.getString(R.string.load_more));
                    mVar.d.setVisibility(8);
                }
                int an = TiebaApplication.h().an();
                if (an == 1) {
                    com.baidu.tieba.util.bb.e(view, (int) R.drawable.list_selector_1);
                } else {
                    com.baidu.tieba.util.bb.e(view, (int) R.drawable.list_selector_divider1);
                }
                if (an == 1) {
                    mVar.b.setTextColor(-8153171);
                    mVar.c.setTextColor(-11446171);
                    if (mVar.e != null) {
                        mVar.e.setTextColor(-8682086);
                    }
                } else {
                    mVar.b.setTextColor(-14277082);
                    mVar.c.setTextColor(-10066330);
                    if (mVar.e != null) {
                        mVar.e.setTextColor(-8682086);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.a(e.getMessage());
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
