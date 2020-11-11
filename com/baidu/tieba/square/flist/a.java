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
    private e mQb;
    private int mQc = 0;
    C0847a mQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C0847a {
        ImageView mQe;
        TextView mQf;

        C0847a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mQb == null || this.mQb.mSr == null) {
            return 0;
        }
        return this.mQb.mSr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mQb == null || this.mQb.mSr == null) {
            return null;
        }
        return this.mQb.mSr.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dIq();
        }
        if (this.mQb != null) {
            e eVar = this.mQb.mSr.get(i);
            this.mQd = (C0847a) view.getTag();
            if (eVar != null) {
                a(this.mQd, eVar, view, i);
            }
        }
        return view;
    }

    public void Jo(int i) {
        this.mQc = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.mQb = eVar;
    }

    public e dIp() {
        return this.mQb;
    }

    private View dIq() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.mQd = new C0847a();
        this.mQd.mQe = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.mQd.mQf = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.mQd);
        return inflate;
    }

    private void a(C0847a c0847a, e eVar, View view, int i) {
        if (c0847a != null && eVar != null) {
            c0847a.mQf.setText("");
            if (i == 0) {
                c0847a.mQf.setText(this.mActivity.getString(R.string.all) + eVar.mQj);
            } else {
                c0847a.mQf.setText(eVar.mQj);
            }
            if (i != this.mQc) {
                c0847a.mQe.setVisibility(4);
                ap.setViewTextColor(c0847a.mQf, R.color.common_color_10200, 1);
                return;
            }
            c0847a.mQe.setVisibility(0);
            ap.setViewTextColor(c0847a.mQf, R.color.common_color_10013, 1);
        }
    }
}
