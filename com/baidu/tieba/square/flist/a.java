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
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e mKe;
    private int mKf = 0;
    C0832a mKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0832a {
        ImageView mKh;
        TextView mKi;

        C0832a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mKe == null || this.mKe.mMs == null) {
            return 0;
        }
        return this.mKe.mMs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mKe == null || this.mKe.mMs == null) {
            return null;
        }
        return this.mKe.mMs.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dFO();
        }
        if (this.mKe != null) {
            e eVar = this.mKe.mMs.get(i);
            this.mKg = (C0832a) view.getTag();
            if (eVar != null) {
                a(this.mKg, eVar, view, i);
            }
        }
        return view;
    }

    public void Jb(int i) {
        this.mKf = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.mKe = eVar;
    }

    public e dFN() {
        return this.mKe;
    }

    private View dFO() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.mKg = new C0832a();
        this.mKg.mKh = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.mKg.mKi = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.mKg);
        return inflate;
    }

    private void a(C0832a c0832a, e eVar, View view, int i) {
        if (c0832a != null && eVar != null) {
            c0832a.mKi.setText("");
            if (i == 0) {
                c0832a.mKi.setText(this.mActivity.getString(R.string.all) + eVar.mKm);
            } else {
                c0832a.mKi.setText(eVar.mKm);
            }
            if (i != this.mKf) {
                c0832a.mKh.setVisibility(4);
                ap.setViewTextColor(c0832a.mKi, R.color.common_color_10200, 1);
                return;
            }
            c0832a.mKh.setVisibility(0);
            ap.setViewTextColor(c0832a.mKi, R.color.common_color_10013, 1);
        }
    }
}
