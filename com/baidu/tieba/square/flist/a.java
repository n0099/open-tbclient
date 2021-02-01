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
    private e npK;
    private int npL = 0;
    C0866a npM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0866a {
        ImageView npN;
        TextView npO;

        C0866a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.npK == null || this.npK.nrY == null) {
            return 0;
        }
        return this.npK.nrY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.npK == null || this.npK.nrY == null) {
            return null;
        }
        return this.npK.nrY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = dLK();
        }
        if (this.npK != null) {
            e eVar = this.npK.nrY.get(i);
            this.npM = (C0866a) view.getTag();
            if (eVar != null) {
                a(this.npM, eVar, view, i);
            }
        }
        return view;
    }

    public void Jo(int i) {
        this.npL = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.npK = eVar;
    }

    public e dLJ() {
        return this.npK;
    }

    private View dLK() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.npM = new C0866a();
        this.npM.npN = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.npM.npO = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.npM);
        return inflate;
    }

    private void a(C0866a c0866a, e eVar, View view, int i) {
        if (c0866a != null && eVar != null) {
            c0866a.npO.setText("");
            if (i == 0) {
                c0866a.npO.setText(this.mActivity.getString(R.string.all) + eVar.npS);
            } else {
                c0866a.npO.setText(eVar.npS);
            }
            if (i != this.npL) {
                c0866a.npN.setVisibility(4);
                ap.setViewTextColor(c0866a.npO, R.color.common_color_10200, 1);
                return;
            }
            c0866a.npN.setVisibility(0);
            ap.setViewTextColor(c0866a.npO, R.color.common_color_10013, 1);
        }
    }
}
