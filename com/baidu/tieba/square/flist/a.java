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
    private e kLF;
    private int kLG = 0;
    C0669a kLH;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0669a {
        ImageView kLI;
        TextView kLJ;

        C0669a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kLF == null || this.kLF.kNU == null) {
            return 0;
        }
        return this.kLF.kNU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kLF == null || this.kLF.kNU == null) {
            return null;
        }
        return this.kLF.kNU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cUH();
        }
        if (this.kLF != null) {
            e eVar = this.kLF.kNU.get(i);
            this.kLH = (C0669a) view.getTag();
            if (eVar != null) {
                a(this.kLH, eVar, view, i);
            }
        }
        return view;
    }

    public void CT(int i) {
        this.kLG = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.kLF = eVar;
    }

    public e cUG() {
        return this.kLF;
    }

    private View cUH() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.kLH = new C0669a();
        this.kLH.kLI = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.kLH.kLJ = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.kLH);
        return inflate;
    }

    private void a(C0669a c0669a, e eVar, View view, int i) {
        if (c0669a != null && eVar != null) {
            c0669a.kLJ.setText("");
            if (i == 0) {
                c0669a.kLJ.setText(this.mActivity.getString(R.string.all) + eVar.kLN);
            } else {
                c0669a.kLJ.setText(eVar.kLN);
            }
            if (i != this.kLG) {
                c0669a.kLI.setVisibility(4);
                am.setViewTextColor(c0669a.kLJ, R.color.common_color_10200, 1);
                return;
            }
            c0669a.kLI.setVisibility(0);
            am.setViewTextColor(c0669a.kLJ, R.color.common_color_10013, 1);
        }
    }
}
