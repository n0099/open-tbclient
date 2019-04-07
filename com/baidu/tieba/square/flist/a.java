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
    private d izh;
    private int izi = 0;
    C0385a izj;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0385a {
        ImageView izk;
        TextView izl;

        C0385a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.izh == null || this.izh.iBC == null) {
            return 0;
        }
        return this.izh.iBC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.izh == null || this.izh.iBC == null) {
            return null;
        }
        return this.izh.iBC.get(i);
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
        if (this.izh != null) {
            d dVar = this.izh.iBC.get(i);
            this.izj = (C0385a) view.getTag();
            if (dVar != null) {
                a(this.izj, dVar, view, i);
            }
        }
        return view;
    }

    public void zb(int i) {
        this.izi = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.izh = dVar;
    }

    public d ccG() {
        return this.izh;
    }

    private View ccH() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(d.h.forum_list_dir_menu_item, (ViewGroup) null);
        this.izj = new C0385a();
        this.izj.izk = (ImageView) inflate.findViewById(d.g.menu_choose);
        this.izj.izl = (TextView) inflate.findViewById(d.g.menu_name);
        inflate.setTag(this.izj);
        return inflate;
    }

    private void a(C0385a c0385a, com.baidu.tieba.square.square.d dVar, View view, int i) {
        if (c0385a != null && dVar != null) {
            c0385a.izl.setText("");
            if (i == 0) {
                c0385a.izl.setText(this.mActivity.getString(d.j.all) + dVar.izp);
            } else {
                c0385a.izl.setText(dVar.izp);
            }
            if (i != this.izi) {
                c0385a.izk.setVisibility(4);
                al.d(c0385a.izl, d.C0277d.common_color_10200, 1);
                return;
            }
            c0385a.izk.setVisibility(0);
            al.d(c0385a.izl, d.C0277d.common_color_10013, 1);
        }
    }
}
