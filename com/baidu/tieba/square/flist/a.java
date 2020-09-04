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
    private e lYp;
    private int lYq = 0;
    C0802a lYr;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0802a {
        ImageView lYs;
        TextView lYt;

        C0802a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lYp == null || this.lYp.maG == null) {
            return 0;
        }
        return this.lYp.maG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lYp == null || this.lYp.maG == null) {
            return null;
        }
        return this.lYp.maG.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dvc();
        }
        if (this.lYp != null) {
            e eVar = this.lYp.maG.get(i);
            this.lYr = (C0802a) view.getTag();
            if (eVar != null) {
                a(this.lYr, eVar, view, i);
            }
        }
        return view;
    }

    public void HA(int i) {
        this.lYq = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.lYp = eVar;
    }

    public e dvb() {
        return this.lYp;
    }

    private View dvc() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.lYr = new C0802a();
        this.lYr.lYs = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.lYr.lYt = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.lYr);
        return inflate;
    }

    private void a(C0802a c0802a, e eVar, View view, int i) {
        if (c0802a != null && eVar != null) {
            c0802a.lYt.setText("");
            if (i == 0) {
                c0802a.lYt.setText(this.mActivity.getString(R.string.all) + eVar.lYx);
            } else {
                c0802a.lYt.setText(eVar.lYx);
            }
            if (i != this.lYq) {
                c0802a.lYs.setVisibility(4);
                ap.setViewTextColor(c0802a.lYt, R.color.common_color_10200, 1);
                return;
            }
            c0802a.lYs.setVisibility(0);
            ap.setViewTextColor(c0802a.lYt, R.color.common_color_10013, 1);
        }
    }
}
