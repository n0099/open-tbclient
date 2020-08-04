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
    private e lGu;
    private int lGv = 0;
    C0749a lGw;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0749a {
        ImageView lGx;
        TextView lGy;

        C0749a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lGu == null || this.lGu.lII == null) {
            return 0;
        }
        return this.lGu.lII.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lGu == null || this.lGu.lII == null) {
            return null;
        }
        return this.lGu.lII.get(i);
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
        if (this.lGu != null) {
            e eVar = this.lGu.lII.get(i);
            this.lGw = (C0749a) view.getTag();
            if (eVar != null) {
                a(this.lGw, eVar, view, i);
            }
        }
        return view;
    }

    public void Fd(int i) {
        this.lGv = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.lGu = eVar;
    }

    public e djz() {
        return this.lGu;
    }

    private View djA() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.lGw = new C0749a();
        this.lGw.lGx = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.lGw.lGy = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.lGw);
        return inflate;
    }

    private void a(C0749a c0749a, e eVar, View view, int i) {
        if (c0749a != null && eVar != null) {
            c0749a.lGy.setText("");
            if (i == 0) {
                c0749a.lGy.setText(this.mActivity.getString(R.string.all) + eVar.lGC);
            } else {
                c0749a.lGy.setText(eVar.lGC);
            }
            if (i != this.lGv) {
                c0749a.lGx.setVisibility(4);
                ao.setViewTextColor(c0749a.lGy, R.color.common_color_10200, 1);
                return;
            }
            c0749a.lGx.setVisibility(0);
            ao.setViewTextColor(c0749a.lGy, R.color.common_color_10013, 1);
        }
    }
}
