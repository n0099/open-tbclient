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
    private e kbL;
    private int kbM = 0;
    C0607a kbN;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0607a {
        ImageView kbO;
        TextView kbP;

        C0607a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kbL == null || this.kbL.kdW == null) {
            return 0;
        }
        return this.kbL.kdW.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kbL == null || this.kbL.kdW == null) {
            return null;
        }
        return this.kbL.kdW.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cJP();
        }
        if (this.kbL != null) {
            e eVar = this.kbL.kdW.get(i);
            this.kbN = (C0607a) view.getTag();
            if (eVar != null) {
                a(this.kbN, eVar, view, i);
            }
        }
        return view;
    }

    public void Cr(int i) {
        this.kbM = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.kbL = eVar;
    }

    public e cJO() {
        return this.kbL;
    }

    private View cJP() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.kbN = new C0607a();
        this.kbN.kbO = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.kbN.kbP = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.kbN);
        return inflate;
    }

    private void a(C0607a c0607a, e eVar, View view, int i) {
        if (c0607a != null && eVar != null) {
            c0607a.kbP.setText("");
            if (i == 0) {
                c0607a.kbP.setText(this.mActivity.getString(R.string.all) + eVar.kbT);
            } else {
                c0607a.kbP.setText(eVar.kbT);
            }
            if (i != this.kbM) {
                c0607a.kbO.setVisibility(4);
                am.setViewTextColor(c0607a.kbP, R.color.common_color_10200, 1);
                return;
            }
            c0607a.kbO.setVisibility(0);
            am.setViewTextColor(c0607a.kbP, R.color.common_color_10013, 1);
        }
    }
}
