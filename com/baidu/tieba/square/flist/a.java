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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    Context mActivity;
    private e nqk;
    private int nql = 0;
    C0868a nqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0868a {
        ImageView nqn;
        TextView nqo;

        C0868a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.nqk == null || this.nqk.nsy == null) {
            return 0;
        }
        return this.nqk.nsy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.nqk == null || this.nqk.nsy == null) {
            return null;
        }
        return this.nqk.nsy.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dLS();
        }
        if (this.nqk != null) {
            e eVar = this.nqk.nsy.get(i);
            this.nqm = (C0868a) view.getTag();
            if (eVar != null) {
                a(this.nqm, eVar, view, i);
            }
        }
        return view;
    }

    public void Jo(int i) {
        this.nql = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.nqk = eVar;
    }

    public e dLR() {
        return this.nqk;
    }

    private View dLS() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.nqm = new C0868a();
        this.nqm.nqn = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.nqm.nqo = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.nqm);
        return inflate;
    }

    private void a(C0868a c0868a, e eVar, View view, int i) {
        if (c0868a != null && eVar != null) {
            c0868a.nqo.setText("");
            if (i == 0) {
                c0868a.nqo.setText(this.mActivity.getString(R.string.all) + eVar.nqs);
            } else {
                c0868a.nqo.setText(eVar.nqs);
            }
            if (i != this.nql) {
                c0868a.nqn.setVisibility(4);
                ap.setViewTextColor(c0868a.nqo, R.color.common_color_10200, 1);
                return;
            }
            c0868a.nqn.setVisibility(0);
            ap.setViewTextColor(c0868a.nqo, R.color.common_color_10013, 1);
        }
    }
}
