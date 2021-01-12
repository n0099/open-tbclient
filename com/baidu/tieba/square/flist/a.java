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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e ngb;
    private int ngc = 0;
    C0863a ngd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0863a {
        ImageView nge;
        TextView ngf;

        C0863a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ngb == null || this.ngb.niq == null) {
            return 0;
        }
        return this.ngb.niq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ngb == null || this.ngb.niq == null) {
            return null;
        }
        return this.ngb.niq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dJz();
        }
        if (this.ngb != null) {
            e eVar = this.ngb.niq.get(i);
            this.ngd = (C0863a) view.getTag();
            if (eVar != null) {
                a(this.ngd, eVar, view, i);
            }
        }
        return view;
    }

    public void IU(int i) {
        this.ngc = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.ngb = eVar;
    }

    public e dJy() {
        return this.ngb;
    }

    private View dJz() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.ngd = new C0863a();
        this.ngd.nge = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.ngd.ngf = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.ngd);
        return inflate;
    }

    private void a(C0863a c0863a, e eVar, View view, int i) {
        if (c0863a != null && eVar != null) {
            c0863a.ngf.setText("");
            if (i == 0) {
                c0863a.ngf.setText(this.mActivity.getString(R.string.all) + eVar.ngj);
            } else {
                c0863a.ngf.setText(eVar.ngj);
            }
            if (i != this.ngc) {
                c0863a.nge.setVisibility(4);
                ao.setViewTextColor(c0863a.ngf, R.color.common_color_10200, 1);
                return;
            }
            c0863a.nge.setVisibility(0);
            ao.setViewTextColor(c0863a.ngf, R.color.common_color_10013, 1);
        }
    }
}
