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
    private e nkG;
    private int nkH = 0;
    C0880a nkI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0880a {
        ImageView nkJ;
        TextView nkK;

        C0880a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nkG == null || this.nkG.nmU == null) {
            return 0;
        }
        return this.nkG.nmU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nkG == null || this.nkG.nmU == null) {
            return null;
        }
        return this.nkG.nmU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dNr();
        }
        if (this.nkG != null) {
            e eVar = this.nkG.nmU.get(i);
            this.nkI = (C0880a) view.getTag();
            if (eVar != null) {
                a(this.nkI, eVar, view, i);
            }
        }
        return view;
    }

    public void KB(int i) {
        this.nkH = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.nkG = eVar;
    }

    public e dNq() {
        return this.nkG;
    }

    private View dNr() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.nkI = new C0880a();
        this.nkI.nkJ = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.nkI.nkK = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.nkI);
        return inflate;
    }

    private void a(C0880a c0880a, e eVar, View view, int i) {
        if (c0880a != null && eVar != null) {
            c0880a.nkK.setText("");
            if (i == 0) {
                c0880a.nkK.setText(this.mActivity.getString(R.string.all) + eVar.nkO);
            } else {
                c0880a.nkK.setText(eVar.nkO);
            }
            if (i != this.nkH) {
                c0880a.nkJ.setVisibility(4);
                ao.setViewTextColor(c0880a.nkK, R.color.common_color_10200, 1);
                return;
            }
            c0880a.nkJ.setVisibility(0);
            ao.setViewTextColor(c0880a.nkK, R.color.common_color_10013, 1);
        }
    }
}
