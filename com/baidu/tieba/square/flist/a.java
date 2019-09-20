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
    private d jbR;
    private int jbS = 0;
    C0420a jbT;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0420a {
        ImageView jbU;
        TextView jbV;

        C0420a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbR == null || this.jbR.jem == null) {
            return 0;
        }
        return this.jbR.jem.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jbR == null || this.jbR.jem == null) {
            return null;
        }
        return this.jbR.jem.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = coL();
        }
        if (this.jbR != null) {
            d dVar = this.jbR.jem.get(i);
            this.jbT = (C0420a) view.getTag();
            if (dVar != null) {
                a(this.jbT, dVar, view, i);
            }
        }
        return view;
    }

    public void AU(int i) {
        this.jbS = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.jbR = dVar;
    }

    public d coK() {
        return this.jbR;
    }

    private View coL() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jbT = new C0420a();
        this.jbT.jbU = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jbT.jbV = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jbT);
        return inflate;
    }

    private void a(C0420a c0420a, d dVar, View view, int i) {
        if (c0420a != null && dVar != null) {
            c0420a.jbV.setText("");
            if (i == 0) {
                c0420a.jbV.setText(this.mActivity.getString(R.string.all) + dVar.jbZ);
            } else {
                c0420a.jbV.setText(dVar.jbZ);
            }
            if (i != this.jbS) {
                c0420a.jbU.setVisibility(4);
                am.f(c0420a.jbV, R.color.common_color_10200, 1);
                return;
            }
            c0420a.jbU.setVisibility(0);
            am.f(c0420a.jbV, R.color.common_color_10013, 1);
        }
    }
}
