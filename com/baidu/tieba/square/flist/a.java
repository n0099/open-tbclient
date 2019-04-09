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
    private d izi;
    private int izj = 0;
    C0385a izk;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0385a {
        ImageView izl;
        TextView izm;

        C0385a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.izi == null || this.izi.iBD == null) {
            return 0;
        }
        return this.izi.iBD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.izi == null || this.izi.iBD == null) {
            return null;
        }
        return this.izi.iBD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ccH();
        }
        if (this.izi != null) {
            d dVar = this.izi.iBD.get(i);
            this.izk = (C0385a) view.getTag();
            if (dVar != null) {
                a(this.izk, dVar, view, i);
            }
        }
        return view;
    }

    public void zb(int i) {
        this.izj = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.izi = dVar;
    }

    public d ccG() {
        return this.izi;
    }

    private View ccH() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.forum_list_dir_menu_item, (ViewGroup) null);
        this.izk = new C0385a();
        this.izk.izl = (ImageView) inflate.findViewById(d.g.menu_choose);
        this.izk.izm = (TextView) inflate.findViewById(d.g.menu_name);
        inflate.setTag(this.izk);
        return inflate;
    }

    private void a(C0385a c0385a, com.baidu.tieba.square.square.d dVar, View view, int i) {
        if (c0385a != null && dVar != null) {
            c0385a.izm.setText("");
            if (i == 0) {
                c0385a.izm.setText(this.mActivity.getString(d.j.all) + dVar.izq);
            } else {
                c0385a.izm.setText(dVar.izq);
            }
            if (i != this.izj) {
                c0385a.izl.setVisibility(4);
                al.d(c0385a.izm, d.C0277d.common_color_10200, 1);
                return;
            }
            c0385a.izl.setVisibility(0);
            al.d(c0385a.izm, d.C0277d.common_color_10013, 1);
        }
    }
}
