package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.d;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private d iRX;
    private int iRY = 0;
    C0404a iRZ;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0404a {
        ImageView iSa;
        TextView iSb;

        C0404a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iRX == null || this.iRX.iUt == null) {
            return 0;
        }
        return this.iRX.iUt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iRX == null || this.iRX.iUt == null) {
            return null;
        }
        return this.iRX.iUt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ckN();
        }
        if (this.iRX != null) {
            d dVar = this.iRX.iUt.get(i);
            this.iRZ = (C0404a) view.getTag();
            if (dVar != null) {
                a(this.iRZ, dVar, view, i);
            }
        }
        return view;
    }

    public void Aj(int i) {
        this.iRY = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.iRX = dVar;
    }

    public d ckM() {
        return this.iRX;
    }

    private View ckN() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.iRZ = new C0404a();
        this.iRZ.iSa = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.iRZ.iSb = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.iRZ);
        return inflate;
    }

    private void a(C0404a c0404a, d dVar, View view, int i) {
        if (c0404a != null && dVar != null) {
            c0404a.iSb.setText("");
            if (i == 0) {
                c0404a.iSb.setText(this.mActivity.getString(R.string.all) + dVar.iSf);
            } else {
                c0404a.iSb.setText(dVar.iSf);
            }
            if (i != this.iRY) {
                c0404a.iSa.setVisibility(4);
                al.f(c0404a.iSb, R.color.common_color_10200, 1);
                return;
            }
            c0404a.iSa.setVisibility(0);
            al.f(c0404a.iSb, R.color.common_color_10013, 1);
        }
    }
}
