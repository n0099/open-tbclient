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
    private d iSb;
    private int iSc = 0;
    C0404a iSd;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0404a {
        ImageView iSe;
        TextView iSf;

        C0404a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iSb == null || this.iSb.iUx == null) {
            return 0;
        }
        return this.iSb.iUx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iSb == null || this.iSb.iUx == null) {
            return null;
        }
        return this.iSb.iUx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ckO();
        }
        if (this.iSb != null) {
            d dVar = this.iSb.iUx.get(i);
            this.iSd = (C0404a) view.getTag();
            if (dVar != null) {
                a(this.iSd, dVar, view, i);
            }
        }
        return view;
    }

    public void Aj(int i) {
        this.iSc = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.iSb = dVar;
    }

    public d ckN() {
        return this.iSb;
    }

    private View ckO() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.iSd = new C0404a();
        this.iSd.iSe = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.iSd.iSf = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.iSd);
        return inflate;
    }

    private void a(C0404a c0404a, d dVar, View view, int i) {
        if (c0404a != null && dVar != null) {
            c0404a.iSf.setText("");
            if (i == 0) {
                c0404a.iSf.setText(this.mActivity.getString(R.string.all) + dVar.iSj);
            } else {
                c0404a.iSf.setText(dVar.iSj);
            }
            if (i != this.iSc) {
                c0404a.iSe.setVisibility(4);
                al.f(c0404a.iSf, R.color.common_color_10200, 1);
                return;
            }
            c0404a.iSe.setVisibility(0);
            al.f(c0404a.iSf, R.color.common_color_10013, 1);
        }
    }
}
