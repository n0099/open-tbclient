package com.baidu.tieba.more;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private Context a;
    private View.OnClickListener d;
    private ArrayList c = null;
    private boolean b = false;

    public m(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.d = onClickListener;
    }

    public void a(ArrayList arrayList) {
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.c != null ? this.c.size() : 0) + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.c == null || i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (getItem(i) != null) {
            return i;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        n nVar;
        View view3;
        try {
            if (view == null) {
                LayoutInflater from = LayoutInflater.from(this.a);
                if (getItemViewType(i) == 0) {
                    view3 = from.inflate(R.layout.account_item, (ViewGroup) null);
                    try {
                        nVar = new n(this, null);
                        nVar.a = (TextView) view3.findViewById(R.id.account);
                        nVar.b = (ImageView) view3.findViewById(R.id.active);
                        nVar.c = (Button) view3.findViewById(R.id.delete);
                        nVar.c.setOnClickListener(this.d);
                        view3.setTag(nVar);
                    } catch (Exception e) {
                        view2 = view3;
                        exc = e;
                        com.baidu.tieba.c.ae.b(getClass().getName(), "getView", exc.getMessage());
                        return view2;
                    }
                } else {
                    view3 = from.inflate(R.layout.account_add_item, (ViewGroup) null);
                    nVar = null;
                }
            } else {
                nVar = (n) view.getTag();
                view3 = view;
            }
            if (getItemViewType(i) == 0 && nVar != null) {
                com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) getItem(i);
                nVar.b.setVisibility(8);
                nVar.c.setVisibility(8);
                nVar.c.setTag(aVar);
                if (aVar != null) {
                    nVar.a.setText(aVar.b());
                    if (aVar.e() == 1) {
                        nVar.b.setVisibility(0);
                    }
                    if (this.b) {
                        nVar.c.setVisibility(0);
                        return view3;
                    }
                }
            }
            return view3;
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
