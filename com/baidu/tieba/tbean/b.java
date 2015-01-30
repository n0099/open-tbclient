package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.List;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private int aXn;
    private j cbI;
    private List<IconInfo> mData;

    public b(j jVar) {
        this.cbI = jVar;
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
                view = com.baidu.adp.lib.g.b.ei().inflate(viewGroup.getContext(), x.buy_tbean_item, null);
                c cVar2 = new c(null);
                cVar2.cbM = (LinearLayout) view.findViewById(w.item_parent_ll);
                cVar2.cbN = (LinearLayout) view.findViewById(w.item_child_ll);
                cVar2.cbO = (TextView) view.findViewById(w.tbean_num_tv);
                cVar2.cbP = (TextView) view.findViewById(w.price_tv);
                cVar2.cbR = (TextView) view.findViewById(w.name_tv);
                cVar2.cbQ = (TbImageView) view.findViewById(w.thumb_tiv);
                cVar2.cbS = view.findViewById(w.left_empty_view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.cbS.setVisibility(i == 0 ? 0 : 8);
            cVar.cbR.setText(bf.h(iconInfo.name, 10));
            cVar.cbP.setText(String.valueOf(this.cbI.getString(z.yinji_price_tip)) + " " + this.cbI.il(iconInfo.dubi.intValue()));
            cVar.cbO.setText(String.valueOf(this.cbI.getString(z.tbean_give_tip)) + " " + this.cbI.a(iconInfo) + this.cbI.getString(z.tbean_title));
            cVar.cbQ.d(iconInfo.picUrl, 10, false);
            a(cVar, i);
            return view;
        }
        return null;
    }

    private void a(c cVar, int i) {
        bc.b(cVar.cbR, t.cp_cont_d, 1);
        bc.b(cVar.cbP, t.cp_cont_b, 1);
        bc.b(cVar.cbO, t.cp_cont_b, 1);
        bc.i(cVar.cbM, t.cp_bg_line_d);
        if (this.aXn == i) {
            bc.i(cVar.cbN, v.chx_box_gift_s);
        } else {
            bc.i(cVar.cbN, v.chx_box_gift_n);
        }
    }

    public void ii(int i) {
        if (this.aXn != i) {
            this.aXn = i;
        }
    }

    public void setData(List<IconInfo> list) {
        this.mData = list;
    }
}
