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
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private e lYa;
    private int lYb = 0;
    C0802a lYc;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0802a {
        ImageView lYd;
        TextView lYe;

        C0802a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lYa == null || this.lYa.maq == null) {
            return 0;
        }
        return this.lYa.maq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lYa == null || this.lYa.maq == null) {
            return null;
        }
        return this.lYa.maq.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = duX();
        }
        if (this.lYa != null) {
            e eVar = this.lYa.maq.get(i);
            this.lYc = (C0802a) view.getTag();
            if (eVar != null) {
                a(this.lYc, eVar, view, i);
            }
        }
        return view;
    }

    public void HA(int i) {
        this.lYb = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.lYa = eVar;
    }

    public e duW() {
        return this.lYa;
    }

    private View duX() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.lYc = new C0802a();
        this.lYc.lYd = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.lYc.lYe = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.lYc);
        return inflate;
    }

    private void a(C0802a c0802a, e eVar, View view, int i) {
        if (c0802a != null && eVar != null) {
            c0802a.lYe.setText("");
            if (i == 0) {
                c0802a.lYe.setText(this.mActivity.getString(R.string.all) + eVar.lYi);
            } else {
                c0802a.lYe.setText(eVar.lYi);
            }
            if (i != this.lYb) {
                c0802a.lYd.setVisibility(4);
                ap.setViewTextColor(c0802a.lYe, R.color.common_color_10200, 1);
                return;
            }
            c0802a.lYd.setVisibility(0);
            ap.setViewTextColor(c0802a.lYe, R.color.common_color_10013, 1);
        }
    }
}
