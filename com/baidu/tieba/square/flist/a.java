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
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private e lGs;
    private int lGt = 0;
    C0749a lGu;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0749a {
        ImageView lGv;
        TextView lGw;

        C0749a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lGs == null || this.lGs.lIG == null) {
            return 0;
        }
        return this.lGs.lIG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lGs == null || this.lGs.lIG == null) {
            return null;
        }
        return this.lGs.lIG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = djA();
        }
        if (this.lGs != null) {
            e eVar = this.lGs.lIG.get(i);
            this.lGu = (C0749a) view.getTag();
            if (eVar != null) {
                a(this.lGu, eVar, view, i);
            }
        }
        return view;
    }

    public void Fd(int i) {
        this.lGt = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.lGs = eVar;
    }

    public e djz() {
        return this.lGs;
    }

    private View djA() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.lGu = new C0749a();
        this.lGu.lGv = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.lGu.lGw = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.lGu);
        return inflate;
    }

    private void a(C0749a c0749a, e eVar, View view, int i) {
        if (c0749a != null && eVar != null) {
            c0749a.lGw.setText("");
            if (i == 0) {
                c0749a.lGw.setText(this.mActivity.getString(R.string.all) + eVar.lGA);
            } else {
                c0749a.lGw.setText(eVar.lGA);
            }
            if (i != this.lGt) {
                c0749a.lGv.setVisibility(4);
                ao.setViewTextColor(c0749a.lGw, R.color.common_color_10200, 1);
                return;
            }
            c0749a.lGv.setVisibility(0);
            ao.setViewTextColor(c0749a.lGw, R.color.common_color_10013, 1);
        }
    }
}
