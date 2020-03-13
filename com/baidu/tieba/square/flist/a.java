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
    private e kai;
    private int kaj = 0;
    C0606a kak;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0606a {
        ImageView kal;
        TextView kam;

        C0606a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kai == null || this.kai.kcu == null) {
            return 0;
        }
        return this.kai.kcu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kai == null || this.kai.kcu == null) {
            return null;
        }
        return this.kai.kcu.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cJv();
        }
        if (this.kai != null) {
            e eVar = this.kai.kcu.get(i);
            this.kak = (C0606a) view.getTag();
            if (eVar != null) {
                a(this.kak, eVar, view, i);
            }
        }
        return view;
    }

    public void Cj(int i) {
        this.kaj = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.kai = eVar;
    }

    public e cJu() {
        return this.kai;
    }

    private View cJv() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.kak = new C0606a();
        this.kak.kal = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.kak.kam = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.kak);
        return inflate;
    }

    private void a(C0606a c0606a, e eVar, View view, int i) {
        if (c0606a != null && eVar != null) {
            c0606a.kam.setText("");
            if (i == 0) {
                c0606a.kam.setText(this.mActivity.getString(R.string.all) + eVar.kaq);
            } else {
                c0606a.kam.setText(eVar.kaq);
            }
            if (i != this.kaj) {
                c0606a.kal.setVisibility(4);
                am.setViewTextColor(c0606a.kam, R.color.common_color_10200, 1);
                return;
            }
            c0606a.kal.setVisibility(0);
            am.setViewTextColor(c0606a.kam, R.color.common_color_10013, 1);
        }
    }
}
