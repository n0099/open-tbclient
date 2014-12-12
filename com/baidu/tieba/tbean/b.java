package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
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
    private int aVU;
    private j bZP;
    private List<IconInfo> mData;

    public b(j jVar) {
        this.bZP = jVar;
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
                view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), x.buy_tbean_item, null);
                c cVar2 = new c(null);
                cVar2.bZS = (LinearLayout) view.findViewById(w.item_parent_ll);
                cVar2.bZT = (LinearLayout) view.findViewById(w.item_child_ll);
                cVar2.bZU = (TextView) view.findViewById(w.tbean_num_tv);
                cVar2.bZV = (TextView) view.findViewById(w.price_tv);
                cVar2.bZX = (TextView) view.findViewById(w.name_tv);
                cVar2.bZW = (TbImageView) view.findViewById(w.thumb_tiv);
                cVar2.bZY = view.findViewById(w.left_empty_view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.bZY.setVisibility(i == 0 ? 0 : 8);
            cVar.bZX.setText(ba.h(iconInfo.name, 10));
            cVar.bZV.setText(String.valueOf(this.bZP.getString(z.yinji_price_tip)) + " " + this.bZP.ib(iconInfo.dubi.intValue()));
            cVar.bZU.setText(String.valueOf(this.bZP.getString(z.tbean_give_tip)) + " " + this.bZP.a(iconInfo) + this.bZP.getString(z.tbean_title));
            cVar.bZW.d(iconInfo.picUrl, 10, false);
            a(cVar, i);
            return view;
        }
        return null;
    }

    private void a(c cVar, int i) {
        ax.b(cVar.bZX, t.cp_cont_d, 1);
        ax.b(cVar.bZV, t.cp_cont_b, 1);
        ax.b(cVar.bZU, t.cp_cont_b, 1);
        ax.i(cVar.bZS, t.cp_bg_line_d);
        if (this.aVU == i) {
            ax.i(cVar.bZT, v.chx_box_gift_s);
        } else {
            ax.i(cVar.bZT, v.chx_box_gift_n);
        }
    }

    public void hY(int i) {
        if (this.aVU != i) {
            this.aVU = i;
        }
    }

    public void setData(List<IconInfo> list) {
        this.mData = list;
    }
}
