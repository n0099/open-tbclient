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
    private d iZw;
    private int iZx = 0;
    C0409a iZy;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0409a {
        TextView iZA;
        ImageView iZz;

        C0409a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iZw == null || this.iZw.jbR == null) {
            return 0;
        }
        return this.iZw.jbR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iZw == null || this.iZw.jbR == null) {
            return null;
        }
        return this.iZw.jbR.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cnY();
        }
        if (this.iZw != null) {
            d dVar = this.iZw.jbR.get(i);
            this.iZy = (C0409a) view.getTag();
            if (dVar != null) {
                a(this.iZy, dVar, view, i);
            }
        }
        return view;
    }

    public void AR(int i) {
        this.iZx = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.iZw = dVar;
    }

    public d cnX() {
        return this.iZw;
    }

    private View cnY() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.iZy = new C0409a();
        this.iZy.iZz = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.iZy.iZA = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.iZy);
        return inflate;
    }

    private void a(C0409a c0409a, d dVar, View view, int i) {
        if (c0409a != null && dVar != null) {
            c0409a.iZA.setText("");
            if (i == 0) {
                c0409a.iZA.setText(this.mActivity.getString(R.string.all) + dVar.iZE);
            } else {
                c0409a.iZA.setText(dVar.iZE);
            }
            if (i != this.iZx) {
                c0409a.iZz.setVisibility(4);
                am.f(c0409a.iZA, R.color.common_color_10200, 1);
                return;
            }
            c0409a.iZz.setVisibility(0);
            am.f(c0409a.iZA, R.color.common_color_10013, 1);
        }
    }
}
