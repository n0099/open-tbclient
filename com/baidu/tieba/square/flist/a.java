package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.e;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e nkH;
    private int nkI = 0;
    C0847a nkJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0847a {
        ImageView nkK;
        TextView nkL;

        C0847a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nkH == null || this.nkH.nmV == null) {
            return 0;
        }
        return this.nkH.nmV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nkH == null || this.nkH.nmV == null) {
            return null;
        }
        return this.nkH.nmV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dNq();
        }
        if (this.nkH != null) {
            e eVar = this.nkH.nmV.get(i);
            this.nkJ = (C0847a) view.getTag();
            if (eVar != null) {
                a(this.nkJ, eVar, view, i);
            }
        }
        return view;
    }

    public void KB(int i) {
        this.nkI = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.nkH = eVar;
    }

    public e dNp() {
        return this.nkH;
    }

    private View dNq() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.nkJ = new C0847a();
        this.nkJ.nkK = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.nkJ.nkL = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.nkJ);
        return inflate;
    }

    private void a(C0847a c0847a, e eVar, View view, int i) {
        if (c0847a != null && eVar != null) {
            c0847a.nkL.setText("");
            if (i == 0) {
                c0847a.nkL.setText(this.mActivity.getString(R.string.all) + eVar.nkP);
            } else {
                c0847a.nkL.setText(eVar.nkP);
            }
            if (i != this.nkI) {
                c0847a.nkK.setVisibility(4);
                ao.setViewTextColor(c0847a.nkL, R.color.common_color_10200, 1);
                return;
            }
            c0847a.nkK.setVisibility(0);
            ao.setViewTextColor(c0847a.nkL, R.color.common_color_10013, 1);
        }
    }
}
