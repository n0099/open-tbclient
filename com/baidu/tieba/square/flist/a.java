package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.d;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private d jaR;
    private int jaS = 0;
    C0515a jaT;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0515a {
        ImageView jaU;
        TextView jaV;

        C0515a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jaR == null || this.jaR.jdm == null) {
            return 0;
        }
        return this.jaR.jdm.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jaR == null || this.jaR.jdm == null) {
            return null;
        }
        return this.jaR.jdm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cmz();
        }
        if (this.jaR != null) {
            d dVar = this.jaR.jdm.get(i);
            this.jaT = (C0515a) view.getTag();
            if (dVar != null) {
                a(this.jaT, dVar, view, i);
            }
        }
        return view;
    }

    public void zB(int i) {
        this.jaS = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.jaR = dVar;
    }

    public d cmy() {
        return this.jaR;
    }

    private View cmz() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jaT = new C0515a();
        this.jaT.jaU = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jaT.jaV = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jaT);
        return inflate;
    }

    private void a(C0515a c0515a, d dVar, View view, int i) {
        if (c0515a != null && dVar != null) {
            c0515a.jaV.setText("");
            if (i == 0) {
                c0515a.jaV.setText(this.mActivity.getString(R.string.all) + dVar.jaZ);
            } else {
                c0515a.jaV.setText(dVar.jaZ);
            }
            if (i != this.jaS) {
                c0515a.jaU.setVisibility(4);
                am.setViewTextColor(c0515a.jaV, R.color.common_color_10200, 1);
                return;
            }
            c0515a.jaU.setVisibility(0);
            am.setViewTextColor(c0515a.jaV, R.color.common_color_10013, 1);
        }
    }
}
