package com.baidu.tieba.pb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.q b;
    private boolean c;
    private boolean d;
    private ArrayList e = new ArrayList();

    public b(Context context, com.baidu.tieba.b.q qVar, boolean z) {
        this.a = context;
        this.b = qVar;
        this.d = z;
    }

    public void a() {
        if (this.e != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.e.size()) {
                    try {
                        ((ProgressBar) this.e.get(i2)).setVisibility(8);
                    } catch (Exception e) {
                        com.baidu.tieba.c.ag.b(getClass().getName(), "releaseProgressBar", e.getMessage());
                    }
                    i = i2 + 1;
                } else {
                    this.e.clear();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.a() == null) {
            return 0;
        }
        int i = 1;
        if (this.b.a().j() != 0) {
            i = 2;
        }
        if (this.d) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getCount() == 1) {
            i = 1;
        } else if (getCount() != 3 && !this.d) {
            i++;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception e;
        View view2;
        c cVar;
        try {
            if (view == null) {
                view = LayoutInflater.from(this.a).inflate(R.layout.dialog_more_item, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.a = (TextView) view.findViewById(R.id.text);
                cVar.b = (TextView) view.findViewById(R.id.num);
                cVar.c = (ProgressBar) view.findViewById(R.id.progress);
                cVar.d = (ImageView) view.findViewById(R.id.image);
                this.e.add(cVar.c);
                view.setTag(cVar);
                view2 = view;
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            try {
                if (this.b != null) {
                    cVar.a.setTextColor(-1);
                    long itemId = getItemId(i);
                    if (itemId == 0) {
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        cVar.d.setVisibility(8);
                        cVar.a.setText(this.a.getString(R.string.skip_page));
                    } else if (itemId == 1) {
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        cVar.a.setText(this.a.getString(R.string.view_reverse));
                        if (this.b.c()) {
                            cVar.d.setVisibility(8);
                        } else {
                            cVar.d.setVisibility(0);
                        }
                    } else if (itemId == 2) {
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        cVar.a.setText(this.a.getString(R.string.manage_mode));
                        if (this.b.i()) {
                            cVar.d.setVisibility(0);
                        } else {
                            cVar.d.setVisibility(8);
                        }
                    }
                    if (TiebaApplication.b().ag() == 1) {
                        cVar.a.setTextColor(com.baidu.tieba.c.ae.a(1));
                        cVar.b.setTextColor(com.baidu.tieba.c.ae.b(1));
                    } else {
                        cVar.a.setTextColor(-1);
                        cVar.b.setTextColor(-1);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b("DialogMoreAdapter", "getView", "error = " + e.getMessage());
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        return view2;
    }

    public void a(boolean z) {
        this.c = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }
}
