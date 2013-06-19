package com.baidu.tieba.more;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n extends BaseAdapter {
    private Context a;
    private View.OnClickListener d;
    private ArrayList c = null;
    private boolean b = false;

    public n(Context context, View.OnClickListener onClickListener) {
        this.a = context;
        this.d = onClickListener;
    }

    public void a(ArrayList arrayList) {
        this.c = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        if (this.c != null) {
            i = this.c.size();
        }
        return i + 1;
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bd: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x00bc */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Exception exc;
        View view2;
        View view3;
        o oVar;
        View view4;
        try {
            try {
                if (view == null) {
                    LayoutInflater from = LayoutInflater.from(this.a);
                    if (getItemViewType(i) == 0) {
                        view4 = from.inflate(R.layout.account_item, (ViewGroup) null);
                        oVar = new o(this, null);
                        oVar.a = (TextView) view4.findViewById(R.id.account);
                        oVar.c = (ImageView) view4.findViewById(R.id.active);
                        oVar.d = (Button) view4.findViewById(R.id.delete);
                        oVar.d.setOnClickListener(this.d);
                        view4.setTag(oVar);
                    } else {
                        view4 = from.inflate(R.layout.account_add_item, (ViewGroup) null);
                        oVar = new o(this, null);
                        oVar.b = (TextView) view4.findViewById(R.id.add_text);
                        view4.setTag(oVar);
                    }
                } else {
                    oVar = (o) view.getTag();
                    view4 = view;
                }
                if (getItemViewType(i) == 0) {
                    if (TiebaApplication.e().as() == 1) {
                        oVar.a.setTextColor(com.baidu.tieba.d.ac.a(1));
                    } else {
                        oVar.a.setTextColor(-12895429);
                    }
                    com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) getItem(i);
                    oVar.c.setVisibility(8);
                    oVar.d.setVisibility(8);
                    oVar.d.setTag(aVar);
                    if (aVar != null) {
                        oVar.a.setText(aVar.b());
                        if (aVar.e() == 1) {
                            oVar.c.setVisibility(0);
                        }
                        if (this.b) {
                            oVar.d.setVisibility(0);
                            return view4;
                        }
                    }
                    return view4;
                } else if (TiebaApplication.e().as() == 1) {
                    oVar.b.setTextColor(com.baidu.tieba.d.ac.a(1));
                    return view4;
                } else {
                    oVar.b.setTextColor(-12895429);
                    return view4;
                }
            } catch (Exception e) {
                view2 = view3;
                exc = e;
                com.baidu.tieba.d.ae.b(getClass().getName(), "getView", exc.getMessage());
                return view2;
            }
        } catch (Exception e2) {
            exc = e2;
            view2 = view;
            com.baidu.tieba.d.ae.b(getClass().getName(), "getView", exc.getMessage());
            return view2;
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (getItemId(i) >= 0) {
            return 0;
        }
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }
}
