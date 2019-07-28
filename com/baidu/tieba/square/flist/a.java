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
    private d iYs;
    private int iYt = 0;
    C0409a iYu;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0409a {
        ImageView iYv;
        TextView iYw;

        C0409a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iYs == null || this.iYs.jaN == null) {
            return 0;
        }
        return this.iYs.jaN.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iYs == null || this.iYs.jaN == null) {
            return null;
        }
        return this.iYs.jaN.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cnG();
        }
        if (this.iYs != null) {
            d dVar = this.iYs.jaN.get(i);
            this.iYu = (C0409a) view.getTag();
            if (dVar != null) {
                a(this.iYu, dVar, view, i);
            }
        }
        return view;
    }

    public void AP(int i) {
        this.iYt = i;
        notifyDataSetChanged();
    }

    public void a(d dVar) {
        this.iYs = dVar;
    }

    public d cnF() {
        return this.iYs;
    }

    private View cnG() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.iYu = new C0409a();
        this.iYu.iYv = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.iYu.iYw = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.iYu);
        return inflate;
    }

    private void a(C0409a c0409a, d dVar, View view, int i) {
        if (c0409a != null && dVar != null) {
            c0409a.iYw.setText("");
            if (i == 0) {
                c0409a.iYw.setText(this.mActivity.getString(R.string.all) + dVar.iYA);
            } else {
                c0409a.iYw.setText(dVar.iYA);
            }
            if (i != this.iYt) {
                c0409a.iYv.setVisibility(4);
                am.f(c0409a.iYw, R.color.common_color_10200, 1);
                return;
            }
            c0409a.iYv.setVisibility(0);
            am.f(c0409a.iYw, R.color.common_color_10013, 1);
        }
    }
}
