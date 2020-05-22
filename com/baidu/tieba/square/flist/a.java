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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e ldV;
    private int ldW = 0;
    C0722a ldX;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0722a {
        ImageView ldY;
        TextView ldZ;

        C0722a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ldV == null || this.ldV.lgl == null) {
            return 0;
        }
        return this.ldV.lgl.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ldV == null || this.ldV.lgl == null) {
            return null;
        }
        return this.ldV.lgl.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dbM();
        }
        if (this.ldV != null) {
            e eVar = this.ldV.lgl.get(i);
            this.ldX = (C0722a) view.getTag();
            if (eVar != null) {
                a(this.ldX, eVar, view, i);
            }
        }
        return view;
    }

    public void DD(int i) {
        this.ldW = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.ldV = eVar;
    }

    public e dbL() {
        return this.ldV;
    }

    private View dbM() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.ldX = new C0722a();
        this.ldX.ldY = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.ldX.ldZ = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.ldX);
        return inflate;
    }

    private void a(C0722a c0722a, e eVar, View view, int i) {
        if (c0722a != null && eVar != null) {
            c0722a.ldZ.setText("");
            if (i == 0) {
                c0722a.ldZ.setText(this.mActivity.getString(R.string.all) + eVar.led);
            } else {
                c0722a.ldZ.setText(eVar.led);
            }
            if (i != this.ldW) {
                c0722a.ldY.setVisibility(4);
                am.setViewTextColor(c0722a.ldZ, R.color.common_color_10200, 1);
                return;
            }
            c0722a.ldY.setVisibility(0);
            am.setViewTextColor(c0722a.ldZ, R.color.common_color_10013, 1);
        }
    }
}
