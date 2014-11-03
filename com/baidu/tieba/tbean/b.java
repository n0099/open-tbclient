package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.List;
import tbclient.GetIconList.IconInfo;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private int aUv;
    private j bNF;
    private List<IconInfo> mData;

    public b(j jVar) {
        this.bNF = jVar;
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
                view = com.baidu.adp.lib.g.b.ek().inflate(viewGroup.getContext(), w.buy_tbean_item, null);
                c cVar2 = new c(null);
                cVar2.bNI = (LinearLayout) view.findViewById(v.item_parent_ll);
                cVar2.bNJ = (LinearLayout) view.findViewById(v.item_child_ll);
                cVar2.bNK = (TextView) view.findViewById(v.tbean_num_tv);
                cVar2.bNL = (TextView) view.findViewById(v.price_tv);
                cVar2.bNN = (TextView) view.findViewById(v.name_tv);
                cVar2.bNM = (TbImageView) view.findViewById(v.thumb_tiv);
                cVar2.bNO = view.findViewById(v.left_empty_view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.bNO.setVisibility(i == 0 ? 0 : 8);
            cVar.bNN.setText(az.h(iconInfo.name, 10));
            cVar.bNL.setText(String.valueOf(this.bNF.getString(y.yinji_price_tip)) + " " + this.bNF.hs(iconInfo.dubi.intValue()));
            cVar.bNK.setText(String.valueOf(this.bNF.getString(y.tbean_give_tip)) + " " + this.bNF.a(iconInfo) + this.bNF.getString(y.tbean_title));
            cVar.bNM.c(iconInfo.picUrl, 10, false);
            a(cVar, i);
            return view;
        }
        return null;
    }

    private void a(c cVar, int i) {
        aw.b(cVar.bNN, s.cp_cont_d, 1);
        aw.b(cVar.bNL, s.cp_cont_b, 1);
        aw.b(cVar.bNK, s.cp_cont_b, 1);
        aw.h(cVar.bNI, s.cp_bg_line_d);
        if (this.aUv == i) {
            aw.h(cVar.bNJ, u.chx_box_gift_s);
        } else {
            aw.h(cVar.bNJ, u.chx_box_gift_n);
        }
    }

    public void hp(int i) {
        if (this.aUv != i) {
            this.aUv = i;
        }
    }

    public void setData(List<IconInfo> list) {
        this.mData = list;
    }
}
