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
import com.baidu.tieba.square.square.e;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private e jYV;
    private int jYW = 0;
    C0599a jYX;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0599a {
        ImageView jYY;
        TextView jYZ;

        C0599a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jYV == null || this.jYV.kbh == null) {
            return 0;
        }
        return this.jYV.kbh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jYV == null || this.jYV.kbh == null) {
            return null;
        }
        return this.jYV.kbh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cHO();
        }
        if (this.jYV != null) {
            e eVar = this.jYV.kbh.get(i);
            this.jYX = (C0599a) view.getTag();
            if (eVar != null) {
                a(this.jYX, eVar, view, i);
            }
        }
        return view;
    }

    public void Cc(int i) {
        this.jYW = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.jYV = eVar;
    }

    public e cHN() {
        return this.jYV;
    }

    private View cHO() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jYX = new C0599a();
        this.jYX.jYY = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jYX.jYZ = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jYX);
        return inflate;
    }

    private void a(C0599a c0599a, e eVar, View view, int i) {
        if (c0599a != null && eVar != null) {
            c0599a.jYZ.setText("");
            if (i == 0) {
                c0599a.jYZ.setText(this.mActivity.getString(R.string.all) + eVar.jZd);
            } else {
                c0599a.jYZ.setText(eVar.jZd);
            }
            if (i != this.jYW) {
                c0599a.jYY.setVisibility(4);
                am.setViewTextColor(c0599a.jYZ, R.color.common_color_10200, 1);
                return;
            }
            c0599a.jYY.setVisibility(0);
            am.setViewTextColor(c0599a.jYZ, R.color.common_color_10013, 1);
        }
    }
}
