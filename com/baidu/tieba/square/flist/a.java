package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.e;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e mxu;
    private int mxv = 0;
    C0817a mxw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0817a {
        ImageView mxx;
        TextView mxy;

        C0817a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mxu == null || this.mxu.mzI == null) {
            return 0;
        }
        return this.mxu.mzI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mxu == null || this.mxu.mzI == null) {
            return null;
        }
        return this.mxu.mzI.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dCG();
        }
        if (this.mxu != null) {
            e eVar = this.mxu.mzI.get(i);
            this.mxw = (C0817a) view.getTag();
            if (eVar != null) {
                a(this.mxw, eVar, view, i);
            }
        }
        return view;
    }

    public void IJ(int i) {
        this.mxv = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.mxu = eVar;
    }

    public e dCF() {
        return this.mxu;
    }

    private View dCG() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.mxw = new C0817a();
        this.mxw.mxx = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.mxw.mxy = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.mxw);
        return inflate;
    }

    private void a(C0817a c0817a, e eVar, View view, int i) {
        if (c0817a != null && eVar != null) {
            c0817a.mxy.setText("");
            if (i == 0) {
                c0817a.mxy.setText(this.mActivity.getString(R.string.all) + eVar.mxC);
            } else {
                c0817a.mxy.setText(eVar.mxC);
            }
            if (i != this.mxv) {
                c0817a.mxx.setVisibility(4);
                ap.setViewTextColor(c0817a.mxy, R.color.common_color_10200, 1);
                return;
            }
            c0817a.mxx.setVisibility(0);
            ap.setViewTextColor(c0817a.mxy, R.color.common_color_10013, 1);
        }
    }
}
