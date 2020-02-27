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
    private e jZU;
    private int jZV = 0;
    C0606a jZW;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0606a {
        ImageView jZX;
        TextView jZY;

        C0606a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jZU == null || this.jZU.kcg == null) {
            return 0;
        }
        return this.jZU.kcg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jZU == null || this.jZU.kcg == null) {
            return null;
        }
        return this.jZU.kcg.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cJs();
        }
        if (this.jZU != null) {
            e eVar = this.jZU.kcg.get(i);
            this.jZW = (C0606a) view.getTag();
            if (eVar != null) {
                a(this.jZW, eVar, view, i);
            }
        }
        return view;
    }

    public void Cj(int i) {
        this.jZV = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.jZU = eVar;
    }

    public e cJr() {
        return this.jZU;
    }

    private View cJs() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jZW = new C0606a();
        this.jZW.jZX = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jZW.jZY = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jZW);
        return inflate;
    }

    private void a(C0606a c0606a, e eVar, View view, int i) {
        if (c0606a != null && eVar != null) {
            c0606a.jZY.setText("");
            if (i == 0) {
                c0606a.jZY.setText(this.mActivity.getString(R.string.all) + eVar.kac);
            } else {
                c0606a.jZY.setText(eVar.kac);
            }
            if (i != this.jZV) {
                c0606a.jZX.setVisibility(4);
                am.setViewTextColor(c0606a.jZY, R.color.common_color_10200, 1);
                return;
            }
            c0606a.jZX.setVisibility(0);
            am.setViewTextColor(c0606a.jZY, R.color.common_color_10013, 1);
        }
    }
}
