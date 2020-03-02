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
    private e jZW;
    private int jZX = 0;
    C0606a jZY;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0606a {
        ImageView jZZ;
        TextView kaa;

        C0606a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jZW == null || this.jZW.kci == null) {
            return 0;
        }
        return this.jZW.kci.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jZW == null || this.jZW.kci == null) {
            return null;
        }
        return this.jZW.kci.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cJu();
        }
        if (this.jZW != null) {
            e eVar = this.jZW.kci.get(i);
            this.jZY = (C0606a) view.getTag();
            if (eVar != null) {
                a(this.jZY, eVar, view, i);
            }
        }
        return view;
    }

    public void Cj(int i) {
        this.jZX = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.jZW = eVar;
    }

    public e cJt() {
        return this.jZW;
    }

    private View cJu() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jZY = new C0606a();
        this.jZY.jZZ = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jZY.kaa = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jZY);
        return inflate;
    }

    private void a(C0606a c0606a, e eVar, View view, int i) {
        if (c0606a != null && eVar != null) {
            c0606a.kaa.setText("");
            if (i == 0) {
                c0606a.kaa.setText(this.mActivity.getString(R.string.all) + eVar.kae);
            } else {
                c0606a.kaa.setText(eVar.kae);
            }
            if (i != this.jZX) {
                c0606a.jZZ.setVisibility(4);
                am.setViewTextColor(c0606a.kaa, R.color.common_color_10200, 1);
                return;
            }
            c0606a.jZZ.setVisibility(0);
            am.setViewTextColor(c0606a.kaa, R.color.common_color_10013, 1);
        }
    }
}
