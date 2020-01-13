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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private e jYQ;
    private int jYR = 0;
    C0599a jYS;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0599a {
        ImageView jYT;
        TextView jYU;

        C0599a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jYQ == null || this.jYQ.kbc == null) {
            return 0;
        }
        return this.jYQ.kbc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jYQ == null || this.jYQ.kbc == null) {
            return null;
        }
        return this.jYQ.kbc.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cHM();
        }
        if (this.jYQ != null) {
            e eVar = this.jYQ.kbc.get(i);
            this.jYS = (C0599a) view.getTag();
            if (eVar != null) {
                a(this.jYS, eVar, view, i);
            }
        }
        return view;
    }

    public void Cc(int i) {
        this.jYR = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.jYQ = eVar;
    }

    public e cHL() {
        return this.jYQ;
    }

    private View cHM() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jYS = new C0599a();
        this.jYS.jYT = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jYS.jYU = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jYS);
        return inflate;
    }

    private void a(C0599a c0599a, e eVar, View view, int i) {
        if (c0599a != null && eVar != null) {
            c0599a.jYU.setText("");
            if (i == 0) {
                c0599a.jYU.setText(this.mActivity.getString(R.string.all) + eVar.jYY);
            } else {
                c0599a.jYU.setText(eVar.jYY);
            }
            if (i != this.jYR) {
                c0599a.jYT.setVisibility(4);
                am.setViewTextColor(c0599a.jYU, R.color.common_color_10200, 1);
                return;
            }
            c0599a.jYT.setVisibility(0);
            am.setViewTextColor(c0599a.jYU, R.color.common_color_10013, 1);
        }
    }
}
