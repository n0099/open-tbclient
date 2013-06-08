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
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    boolean b;
    boolean c;
    private Context e;
    private com.baidu.tieba.d.a f;
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
                        com.baidu.tieba.d.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
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
        this.f = new com.baidu.tieba.d.a(this.e);
        this.b = z;
        this.c = z2;
    }

    public com.baidu.tieba.d.a b() {
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
        l lVar;
        View view2;
        if (this.d != null) {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.e);
                l lVar2 = new l(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = from.inflate(R.layout.at_list_item, (ViewGroup) null);
                    lVar2.a = (ImageView) inflate.findViewById(R.id.photo);
                    lVar2.b = (TextView) inflate.findViewById(R.id.name);
                    lVar2.d = (TextView) inflate.findViewById(R.id.at_list_nodata);
                    view2 = inflate;
                } else {
                    View inflate2 = from.inflate(R.layout.page_item, (ViewGroup) null);
                    lVar2.b = (TextView) inflate2.findViewById(R.id.page_text);
                    lVar2.c = (ProgressBar) inflate2.findViewById(R.id.progress);
                    this.i.add(lVar2.c);
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
                    if (this.a) {
                        lVar.a.setVisibility(8);
                        lVar.b.setVisibility(8);
                        lVar.d.setVisibility(0);
                        if (this.b) {
                            if (this.c) {
                                lVar.d.setText(R.string.not_have_attention);
                            } else {
                                lVar.d.setText(R.string.no_attention_other);
                            }
                        } else if (this.c) {
                            lVar.d.setText(R.string.not_have_fans);
                        } else {
                            lVar.d.setText(R.string.no_fan_other);
                        }
                    } else {
                        lVar.a.setVisibility(0);
                        lVar.b.setVisibility(0);
                        lVar.d.setVisibility(8);
                        String e = ((com.baidu.tieba.a.ai) this.d.get(i)).e();
                        com.baidu.adp.widget.a.b b = this.f.b(e);
                        if (b != null) {
                            lVar.a.setTag(null);
                            b.b(lVar.a);
                        } else {
                            lVar.a.setTag(e);
                            lVar.a.setImageBitmap(com.baidu.tieba.d.d.a((int) R.drawable.photo));
                        }
                        lVar.b.setText(((com.baidu.tieba.a.ai) this.d.get(i)).d());
                    }
                } else if (this.h) {
                    lVar.b.setText(this.e.getString(R.string.loading));
                    lVar.c.setVisibility(0);
                } else {
                    lVar.b.setText(this.e.getString(R.string.load_more));
                    lVar.c.setVisibility(8);
                }
                if (TiebaApplication.d().ar() == 1) {
                    int a = com.baidu.tieba.d.ac.a(1);
                    lVar.b.setTextColor(a);
                    if (lVar.d != null) {
                        lVar.d.setTextColor(a);
                    }
                } else {
                    lVar.b.setTextColor(-16777216);
                    if (lVar.d != null) {
                        lVar.d.setTextColor(-4276546);
                    }
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.e.b.a(e2.getMessage());
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
