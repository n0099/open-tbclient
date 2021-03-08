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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e nso;
    private int nsp = 0;
    C0874a nsq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0874a {
        ImageView nsr;
        TextView nss;

        C0874a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nso == null || this.nso.nuD == null) {
            return 0;
        }
        return this.nso.nuD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nso == null || this.nso.nuD == null) {
            return null;
        }
        return this.nso.nuD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dMa();
        }
        if (this.nso != null) {
            e eVar = this.nso.nuD.get(i);
            this.nsq = (C0874a) view.getTag();
            if (eVar != null) {
                a(this.nsq, eVar, view, i);
            }
        }
        return view;
    }

    public void Js(int i) {
        this.nsp = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.nso = eVar;
    }

    public e dLZ() {
        return this.nso;
    }

    private View dMa() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.nsq = new C0874a();
        this.nsq.nsr = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.nsq.nss = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.nsq);
        return inflate;
    }

    private void a(C0874a c0874a, e eVar, View view, int i) {
        if (c0874a != null && eVar != null) {
            c0874a.nss.setText("");
            if (i == 0) {
                c0874a.nss.setText(this.mActivity.getString(R.string.all) + eVar.nsw);
            } else {
                c0874a.nss.setText(eVar.nsw);
            }
            if (i != this.nsp) {
                c0874a.nsr.setVisibility(4);
                ap.setViewTextColor(c0874a.nss, R.color.common_color_10200, 1);
                return;
            }
            c0874a.nsr.setVisibility(0);
            ap.setViewTextColor(c0874a.nss, R.color.common_color_10013, 1);
        }
    }
}
