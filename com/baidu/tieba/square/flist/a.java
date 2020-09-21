package com.baidu.tieba.square.flist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.e;
/* loaded from: classes22.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e mhR;
    private int mhS = 0;
    C0799a mhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0799a {
        ImageView mhU;
        TextView mhV;

        C0799a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mhR == null || this.mhR.mkh == null) {
            return 0;
        }
        return this.mhR.mkh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mhR == null || this.mhR.mkh == null) {
            return null;
        }
        return this.mhR.mkh.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dyV();
        }
        if (this.mhR != null) {
            e eVar = this.mhR.mkh.get(i);
            this.mhT = (C0799a) view.getTag();
            if (eVar != null) {
                a(this.mhT, eVar, view, i);
            }
        }
        return view;
    }

    public void Id(int i) {
        this.mhS = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.mhR = eVar;
    }

    public e dyU() {
        return this.mhR;
    }

    private View dyV() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.mhT = new C0799a();
        this.mhT.mhU = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.mhT.mhV = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.mhT);
        return inflate;
    }

    private void a(C0799a c0799a, e eVar, View view, int i) {
        if (c0799a != null && eVar != null) {
            c0799a.mhV.setText("");
            if (i == 0) {
                c0799a.mhV.setText(this.mActivity.getString(R.string.all) + eVar.mhZ);
            } else {
                c0799a.mhV.setText(eVar.mhZ);
            }
            if (i != this.mhS) {
                c0799a.mhU.setVisibility(4);
                ap.setViewTextColor(c0799a.mhV, R.color.common_color_10200, 1);
                return;
            }
            c0799a.mhU.setVisibility(0);
            ap.setViewTextColor(c0799a.mhV, R.color.common_color_10013, 1);
        }
    }
}
