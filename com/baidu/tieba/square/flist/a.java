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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e lff;
    private int lfg = 0;
    C0723a lfh;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0723a {
        ImageView lfi;
        TextView lfj;

        C0723a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lff == null || this.lff.lhu == null) {
            return 0;
        }
        return this.lff.lhu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lff == null || this.lff.lhu == null) {
            return null;
        }
        return this.lff.lhu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dcb();
        }
        if (this.lff != null) {
            e eVar = this.lff.lhu.get(i);
            this.lfh = (C0723a) view.getTag();
            if (eVar != null) {
                a(this.lfh, eVar, view, i);
            }
        }
        return view;
    }

    public void DF(int i) {
        this.lfg = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.lff = eVar;
    }

    public e dca() {
        return this.lff;
    }

    private View dcb() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.lfh = new C0723a();
        this.lfh.lfi = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.lfh.lfj = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.lfh);
        return inflate;
    }

    private void a(C0723a c0723a, e eVar, View view, int i) {
        if (c0723a != null && eVar != null) {
            c0723a.lfj.setText("");
            if (i == 0) {
                c0723a.lfj.setText(this.mActivity.getString(R.string.all) + eVar.lfn);
            } else {
                c0723a.lfj.setText(eVar.lfn);
            }
            if (i != this.lfg) {
                c0723a.lfi.setVisibility(4);
                am.setViewTextColor(c0723a.lfj, R.color.common_color_10200, 1);
                return;
            }
            c0723a.lfi.setVisibility(0);
            am.setViewTextColor(c0723a.lfj, R.color.common_color_10013, 1);
        }
    }
}
