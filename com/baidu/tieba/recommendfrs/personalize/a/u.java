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
    private com.baidu.tieba.recommendfrs.data.i ebA;

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ebA == null || this.ebA.dZV == null) {
            return 0;
        }
        return this.ebA.dZV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oz */
    public com.baidu.tieba.recommendfrs.data.j getItem(int i) {
        if (this.ebA == null || this.ebA.dZV == null) {
            return null;
        }
        return this.ebA.dZV.get(i);
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
            int dimensionPixelSize = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds10);
            textView = new TextView(viewGroup.getContext());
            textView.setSingleLine();
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            textView.setGravity(17);
            textView.setTextSize(0, TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.fontsize28));
            textView.setLayoutParams(new AbsListView.LayoutParams(TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds146), TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60)));
        }
        com.baidu.tieba.recommendfrs.data.j item = getItem(i);
        if (item != null) {
            textView.setText(item.dZX);
            if (item.dZY) {
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
        this.ebA = iVar;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.recommendfrs.data.i aMO() {
        return this.ebA;
    }
}
