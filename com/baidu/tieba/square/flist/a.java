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
    private e kLB;
    private int kLC = 0;
    C0648a kLD;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0648a {
        ImageView kLE;
        TextView kLF;

        C0648a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kLB == null || this.kLB.kNQ == null) {
            return 0;
        }
        return this.kLB.kNQ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kLB == null || this.kLB.kNQ == null) {
            return null;
        }
        return this.kLB.kNQ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cUK();
        }
        if (this.kLB != null) {
            e eVar = this.kLB.kNQ.get(i);
            this.kLD = (C0648a) view.getTag();
            if (eVar != null) {
                a(this.kLD, eVar, view, i);
            }
        }
        return view;
    }

    public void CT(int i) {
        this.kLC = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.kLB = eVar;
    }

    public e cUJ() {
        return this.kLB;
    }

    private View cUK() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.kLD = new C0648a();
        this.kLD.kLE = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.kLD.kLF = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.kLD);
        return inflate;
    }

    private void a(C0648a c0648a, e eVar, View view, int i) {
        if (c0648a != null && eVar != null) {
            c0648a.kLF.setText("");
            if (i == 0) {
                c0648a.kLF.setText(this.mActivity.getString(R.string.all) + eVar.kLJ);
            } else {
                c0648a.kLF.setText(eVar.kLJ);
            }
            if (i != this.kLC) {
                c0648a.kLE.setVisibility(4);
                am.setViewTextColor(c0648a.kLF, R.color.common_color_10200, 1);
                return;
            }
            c0648a.kLE.setVisibility(0);
            am.setViewTextColor(c0648a.kLF, R.color.common_color_10013, 1);
        }
    }
}
