package com.baidu.tieba.recommendfrs.personalize.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private com.baidu.tieba.recommendfrs.data.i dYt;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dYt == null || this.dYt.dWL == null) {
            return 0;
        }
        return this.dYt.dWL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oG */
    public com.baidu.tieba.recommendfrs.data.j getItem(int i) {
        if (this.dYt == null || this.dYt.dWL == null) {
            return null;
        }
        return this.dYt.dWL.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view instanceof TextView) {
            textView = (TextView) view;
        } else {
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds10);
            textView = new TextView(viewGroup.getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.fontsize28));
            textView.setLayoutParams(new AbsListView.LayoutParams(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds146), TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60)));
        }
        com.baidu.tieba.recommendfrs.data.j item = getItem(i);
        if (item != null) {
            textView.setText(item.dWN);
            if (item.dWO) {
                at.j((View) textView, t.d.cp_cont_g);
                at.k(textView, t.f.shape_semi_circle_all_selected);
            } else {
                at.j((View) textView, t.d.cp_cont_f);
                at.k(textView, t.f.shape_semi_circle_all_line);
            }
        }
        return textView;
    }

    public void a(com.baidu.tieba.recommendfrs.data.i iVar) {
        this.dYt = iVar;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.recommendfrs.data.i aMB() {
        return this.dYt;
    }
}
