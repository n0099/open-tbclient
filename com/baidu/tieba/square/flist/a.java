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
    private d jbI;
    private int jbJ = 0;
    C0515a jbK;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0515a {
        ImageView jbL;
        TextView jbM;

        C0515a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jbI == null || this.jbI.jed == null) {
            return 0;
        }
        return this.jbI.jed.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jbI == null || this.jbI.jed == null) {
            return null;
        }
        return this.jbI.jed.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cmB();
        }
        if (this.jbI != null) {
            d dVar = this.jbI.jed.get(i);
            this.jbK = (C0515a) view.getTag();
            if (dVar != null) {
                a(this.jbK, dVar, view, i);
            }
        }
        return view;
    }

    public void zC(int i) {
        this.jbJ = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.jbI = dVar;
    }

    public d cmA() {
        return this.jbI;
    }

    private View cmB() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jbK = new C0515a();
        this.jbK.jbL = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jbK.jbM = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jbK);
        return inflate;
    }

    private void a(C0515a c0515a, d dVar, View view, int i) {
        if (c0515a != null && dVar != null) {
            c0515a.jbM.setText("");
            if (i == 0) {
                c0515a.jbM.setText(this.mActivity.getString(R.string.all) + dVar.jbQ);
            } else {
                c0515a.jbM.setText(dVar.jbQ);
            }
            if (i != this.jbJ) {
                c0515a.jbL.setVisibility(4);
                am.setViewTextColor(c0515a.jbM, R.color.common_color_10200, 1);
                return;
            }
            c0515a.jbL.setVisibility(0);
            am.setViewTextColor(c0515a.jbM, R.color.common_color_10013, 1);
        }
    }
}
