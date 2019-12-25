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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private e jVo;
    private int jVp = 0;
    C0594a jVq;
    Context mActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.square.flist.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0594a {
        ImageView jVr;
        TextView jVs;

        C0594a() {
        }
    }

    public a(Context context) {
        this.mActivity = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.jVo == null || this.jVo.jXz == null) {
            return 0;
        }
        return this.jVo.jXz.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.jVo == null || this.jVo.jXz == null) {
            return null;
        }
        return this.jVo.jXz.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = cGI();
        }
        if (this.jVo != null) {
            e eVar = this.jVo.jXz.get(i);
            this.jVq = (C0594a) view.getTag();
            if (eVar != null) {
                a(this.jVq, eVar, view, i);
            }
        }
        return view;
    }

    public void BX(int i) {
        this.jVp = i;
        notifyDataSetChanged();
    }

    public void a(e eVar) {
        this.jVo = eVar;
    }

    public e cGH() {
        return this.jVo;
    }

    private View cGI() {
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.forum_list_dir_menu_item, (ViewGroup) null);
        this.jVq = new C0594a();
        this.jVq.jVr = (ImageView) inflate.findViewById(R.id.menu_choose);
        this.jVq.jVs = (TextView) inflate.findViewById(R.id.menu_name);
        inflate.setTag(this.jVq);
        return inflate;
    }

    private void a(C0594a c0594a, e eVar, View view, int i) {
        if (c0594a != null && eVar != null) {
            c0594a.jVs.setText("");
            if (i == 0) {
                c0594a.jVs.setText(this.mActivity.getString(R.string.all) + eVar.jVw);
            } else {
                c0594a.jVs.setText(eVar.jVw);
            }
            if (i != this.jVp) {
                c0594a.jVr.setVisibility(4);
                am.setViewTextColor(c0594a.jVs, R.color.common_color_10200, 1);
                return;
            }
            c0594a.jVr.setVisibility(0);
            am.setViewTextColor(c0594a.jVs, R.color.common_color_10013, 1);
        }
    }
}
