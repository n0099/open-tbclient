package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private int beo;
    private j cuA;
    private List<IconInfo> mData;

    public b(j jVar) {
        this.cuA = jVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        IconInfo iconInfo;
        c cVar;
        if (this.mData != null && (iconInfo = this.mData.get(i)) != null) {
            if (view == null || !(view.getTag() instanceof c)) {
                view = com.baidu.adp.lib.g.b.hr().inflate(viewGroup.getContext(), r.buy_tbean_item, null);
                c cVar2 = new c(null);
                cVar2.cuD = (LinearLayout) view.findViewById(q.item_parent_ll);
                cVar2.cuE = (LinearLayout) view.findViewById(q.item_child_ll);
                cVar2.cuF = (TextView) view.findViewById(q.tbean_num_tv);
                cVar2.cuG = (TextView) view.findViewById(q.price_tv);
                cVar2.cuI = (TextView) view.findViewById(q.name_tv);
                cVar2.cuH = (TbImageView) view.findViewById(q.thumb_tiv);
                cVar2.cuJ = view.findViewById(q.left_empty_view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.cuJ.setVisibility(i == 0 ? 0 : 8);
            cVar.cuI.setText(bb.h(iconInfo.name, 10));
            cVar.cuG.setText(String.valueOf(this.cuA.getString(t.yinji_price_tip)) + " " + this.cuA.jb(iconInfo.dubi.intValue()));
            cVar.cuF.setText(String.valueOf(this.cuA.getString(t.tbean_give_tip)) + " " + this.cuA.a(iconInfo) + this.cuA.getString(t.tbean_title));
            cVar.cuH.c(iconInfo.picUrl, 10, false);
            a(cVar, i);
            return view;
        }
        return null;
    }

    private void a(c cVar, int i) {
        ay.b(cVar.cuI, com.baidu.tieba.n.cp_cont_d, 1);
        ay.b(cVar.cuG, com.baidu.tieba.n.cp_cont_b, 1);
        ay.b(cVar.cuF, com.baidu.tieba.n.cp_cont_b, 1);
        ay.i(cVar.cuD, com.baidu.tieba.n.cp_bg_line_d);
        if (this.beo == i) {
            ay.i(cVar.cuE, com.baidu.tieba.p.chx_box_gift_s);
        } else {
            ay.i(cVar.cuE, com.baidu.tieba.p.chx_box_gift_n);
        }
    }

    public void iZ(int i) {
        if (this.beo != i) {
            this.beo = i;
        }
    }

    public void setData(List<IconInfo> list) {
        this.mData = list;
    }
}
