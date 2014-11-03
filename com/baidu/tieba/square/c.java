package com.baidu.tieba.square;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bo;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private Activity aBP;
    private ArrayList<q> bMl;
    View.OnClickListener bMm = new d(this);

    public c(Activity activity, f fVar, boolean z) {
        this.aBP = activity;
        this.bMl = fVar.ado();
    }

    public ArrayList<q> ado() {
        return this.bMl;
    }

    public void J(ArrayList<q> arrayList) {
        this.bMl = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bMl == null) {
            return 0;
        }
        return (this.bMl.size() * 2) + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (view == null) {
            view = d(viewGroup, itemViewType);
            bo.n(view);
        }
        bo.m(view);
        if (itemViewType != 3) {
            int skinType = TbadkApplication.m251getInst().getSkinType();
            View findViewById = view.findViewById(com.baidu.tieba.v.container);
            bo.e(findViewById, 1, skinType);
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
            return com.baidu.adp.lib.g.b.ek().a(this.aBP, com.baidu.tieba.w.bar_home_list_line, viewGroup, false);
        }
        if (i == 2) {
            return com.baidu.adp.lib.g.b.ek().a(this.aBP, com.baidu.tieba.w.bar_folder_first_dir_bottom_item, viewGroup, false);
        }
        View a = com.baidu.adp.lib.g.b.ek().a(this.aBP, com.baidu.tieba.w.bar_folder_first_dir_item, viewGroup, false);
        a.setOnClickListener(this.bMm);
        e eVar = new e();
        eVar.bMo = (BarImageView) a.findViewById(com.baidu.tieba.v.portrait);
        eVar.UH = (TextView) a.findViewById(com.baidu.tieba.v.name);
        eVar.bMp = (BestStringsFitTextView) a.findViewById(com.baidu.tieba.v.description);
        a.setTag(eVar);
        return a;
    }

    private void a(ViewGroup viewGroup, e eVar, int i) {
        q qVar = this.bMl.get(i / 2);
        eVar.bMq = qVar;
        eVar.UH.setText(qVar.avi);
        if (qVar.bMJ != null) {
            eVar.bMp.setVisibility(0);
            String[] strArr = new String[qVar.bMJ.size()];
            for (int i2 = 0; i2 < qVar.bMJ.size(); i2++) {
                strArr[i2] = qVar.bMJ.get(i2).avi;
            }
            eVar.bMp.setTextArray(strArr);
        } else {
            eVar.bMp.setVisibility(8);
        }
        if (qVar.bMI != null) {
            int dip2px = com.baidu.adp.lib.util.m.dip2px(this.aBP, 45.0f);
            eVar.bMo.setTag(qVar.bMI);
            eVar.bMo.a(qVar.bMI, 10, dip2px, dip2px, false);
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
    public Activity adp() {
        return this.aBP;
    }
}
