package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private Activity aBF;
    private ArrayList<q> bLW;
    View.OnClickListener bLX = new d(this);

    public c(Activity activity, f fVar, boolean z) {
        this.aBF = activity;
        this.bLW = fVar.adl();
    }

    public ArrayList<q> adl() {
        return this.bLW;
    }

    public void I(ArrayList<q> arrayList) {
        this.bLW = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bLW == null) {
            return 0;
        }
        return (this.bLW.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = d(viewGroup, itemViewType);
            bn.n(view);
        }
        bn.m(view);
        if (itemViewType != 3) {
            int skinType = TbadkApplication.m251getInst().getSkinType();
            View findViewById = view.findViewById(com.baidu.tieba.v.container);
            bn.e(findViewById, 1, skinType);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                a(viewGroup, (e) view.getTag(), i);
            }
        }
        return view;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (i == 3) {
            return com.baidu.adp.lib.g.b.ek().a(this.aBF, com.baidu.tieba.w.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return com.baidu.adp.lib.g.b.ek().a(this.aBF, com.baidu.tieba.w.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View a = com.baidu.adp.lib.g.b.ek().a(this.aBF, com.baidu.tieba.w.bar_folder_first_dir_item, viewGroup, false);
        a.setOnClickListener(this.bLX);
        e eVar = new e();
        eVar.bLZ = (BarImageView) a.findViewById(com.baidu.tieba.v.portrait);
        eVar.UD = (TextView) a.findViewById(com.baidu.tieba.v.name);
        eVar.bMa = (BestStringsFitTextView) a.findViewById(com.baidu.tieba.v.description);
        a.setTag(eVar);
        return a;
    }

    private void a(ViewGroup viewGroup, e eVar, int i) {
        q qVar = this.bLW.get(i / 2);
        eVar.bMb = qVar;
        eVar.UD.setText(qVar.auZ);
        if (qVar.bMu != null) {
            eVar.bMa.setVisibility(0);
            String[] strArr = new String[qVar.bMu.size()];
            for (int i2 = 0; i2 < qVar.bMu.size(); i2++) {
                strArr[i2] = qVar.bMu.get(i2).auZ;
            }
            eVar.bMa.setTextArray(strArr);
        } else {
            eVar.bMa.setVisibility(8);
        }
        if (qVar.bMt != null) {
            int dip2px = com.baidu.adp.lib.util.m.dip2px(this.aBF, 45.0f);
            eVar.bLZ.setTag(qVar.bMt);
            eVar.bLZ.a(qVar.bMt, 10, dip2px, dip2px, false);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == getCount() - 1) {
            return 2;
        }
        if (i < 0) {
            i *= -1;
        }
        return i % 2 == 1 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity adm() {
        return this.aBF;
    }
}
