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
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private Context a;
    private com.baidu.tieba.b.n b;
    private boolean c;
    private ArrayList d = new ArrayList();

    public b(Context context, com.baidu.tieba.b.n nVar) {
        this.a = context;
        this.b = nVar;
    }

    public void a() {
        if (this.d == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                this.d.clear();
                return;
            }
            try {
                ((ProgressBar) this.d.get(i2)).setVisibility(8);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "releaseProgressBar", e.getMessage());
            }
            i = i2 + 1;
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.a() == null) {
            return 0;
        }
        return this.b.a().g() != 0 ? 3 : 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
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
                this.d.add(cVar.c);
                view.setTag(cVar);
                view2 = view;
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            try {
                if (this.b != null) {
                    cVar.a.setTextColor(-1);
                    if (i == 0) {
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        if (PbActivity.a(this.b)) {
                            cVar.a.setTextColor(-7960954);
                        } else {
                            cVar.a.setTextColor(-1);
                        }
                        cVar.a.setText(this.a.getString(R.string.view_host));
                        if (this.b.d()) {
                            cVar.d.setVisibility(0);
                        } else {
                            cVar.d.setVisibility(8);
                        }
                    } else if (i == 1) {
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        cVar.a.setText(this.a.getString(R.string.view_reverse));
                        if (this.b.c()) {
                            cVar.d.setVisibility(8);
                        } else {
                            cVar.d.setVisibility(0);
                        }
                    } else if (i == 2) {
                        cVar.b.setVisibility(8);
                        cVar.c.setVisibility(8);
                        cVar.a.setText(this.a.getString(R.string.manage_mode));
                        if (this.b.i()) {
                            cVar.d.setVisibility(0);
                        } else {
                            cVar.d.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ae.b("DialogMoreAdapter", "getView", "error = " + e.getMessage());
                return view2;
            }
        } catch (Exception e3) {
            e = e3;
            view2 = view;
        }
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return (i == 0 && PbActivity.a(this.b)) ? false : true;
    }
}
