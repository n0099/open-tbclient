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
    private d iRV;
    private int iRW = 0;
    C0404a iRX;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0404a {
        ImageView iRY;
        TextView iRZ;

        C0404a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iRV == null || this.iRV.iUr == null) {
            return 0;
        }
        return this.iRV.iUr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iRV == null || this.iRV.iUr == null) {
            return null;
        }
        return this.iRV.iUr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ckL();
        }
        if (this.iRV != null) {
            d dVar = this.iRV.iUr.get(i);
            this.iRX = (C0404a) view.getTag();
            if (dVar != null) {
                a(this.iRX, dVar, view, i);
            }
        }
        return view;
    }

    public void Aj(int i) {
        this.iRW = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.iRV = dVar;
    }

    public d ckK() {
        return this.iRV;
    }

    private View ckL() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.iRX = new C0404a();
        this.iRX.iRY = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.iRX.iRZ = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.iRX);
        return inflate;
    }

    private void a(C0404a c0404a, d dVar, View view, int i) {
        if (c0404a != null && dVar != null) {
            c0404a.iRZ.setText("");
            if (i == 0) {
                c0404a.iRZ.setText(this.mActivity.getString(R.string.all) + dVar.iSd);
            } else {
                c0404a.iRZ.setText(dVar.iSd);
            }
            if (i != this.iRW) {
                c0404a.iRY.setVisibility(4);
                al.f(c0404a.iRZ, R.color.common_color_10200, 1);
                return;
            }
            c0404a.iRY.setVisibility(0);
            al.f(c0404a.iRZ, R.color.common_color_10013, 1);
        }
    }
}
