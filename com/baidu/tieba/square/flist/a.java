package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.square.square.d;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private d izx;
    private int izy = 0;
    C0385a izz;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0385a {
        ImageView izA;
        TextView izB;

        C0385a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.izx == null || this.izx.iBS == null) {
            return 0;
        }
        return this.izx.iBS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.izx == null || this.izx.iBS == null) {
            return null;
        }
        return this.izx.iBS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ccL();
        }
        if (this.izx != null) {
            d dVar = this.izx.iBS.get(i);
            this.izz = (C0385a) view.getTag();
            if (dVar != null) {
                a(this.izz, dVar, view, i);
            }
        }
        return view;
    }

    public void zf(int i) {
        this.izy = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.izx = dVar;
    }

    public d ccK() {
        return this.izx;
    }

    private View ccL() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.forum_list_dir_menu_item, (ViewGroup) null);
        this.izz = new C0385a();
        this.izz.izA = (ImageView) inflate.findViewById(d.g.menu_choose);
        this.izz.izB = (TextView) inflate.findViewById(d.g.menu_name);
        inflate.setTag(this.izz);
        return inflate;
    }

    private void a(C0385a c0385a, com.baidu.tieba.square.square.d dVar, View view, int i) {
        if (c0385a != null && dVar != null) {
            c0385a.izB.setText("");
            if (i == 0) {
                c0385a.izB.setText(this.mActivity.getString(d.j.all) + dVar.izF);
            } else {
                c0385a.izB.setText(dVar.izF);
            }
            if (i != this.izy) {
                c0385a.izA.setVisibility(4);
                al.d(c0385a.izB, d.C0277d.common_color_10200, 1);
                return;
            }
            c0385a.izA.setVisibility(0);
            al.d(c0385a.izB, d.C0277d.common_color_10013, 1);
        }
    }
}
