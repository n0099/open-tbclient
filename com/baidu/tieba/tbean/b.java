package com.baidu.tieba.tbean;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
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
    private int bbK;
    private j cqw;
    private List<IconInfo> mData;

    public b(j jVar) {
        this.cqw = jVar;
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
                view = com.baidu.adp.lib.g.b.hH().inflate(viewGroup.getContext(), w.buy_tbean_item, null);
                c cVar2 = new c(null);
                cVar2.cqz = (LinearLayout) view.findViewById(v.item_parent_ll);
                cVar2.cqA = (LinearLayout) view.findViewById(v.item_child_ll);
                cVar2.cqB = (TextView) view.findViewById(v.tbean_num_tv);
                cVar2.cqC = (TextView) view.findViewById(v.price_tv);
                cVar2.cqE = (TextView) view.findViewById(v.name_tv);
                cVar2.cqD = (TbImageView) view.findViewById(v.thumb_tiv);
                cVar2.cqF = view.findViewById(v.left_empty_view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.cqF.setVisibility(i == 0 ? 0 : 8);
            cVar.cqE.setText(bd.h(iconInfo.name, 10));
            cVar.cqC.setText(String.valueOf(this.cqw.getString(y.yinji_price_tip)) + " " + this.cqw.iF(iconInfo.dubi.intValue()));
            cVar.cqB.setText(String.valueOf(this.cqw.getString(y.tbean_give_tip)) + " " + this.cqw.a(iconInfo) + this.cqw.getString(y.tbean_title));
            cVar.cqD.c(iconInfo.picUrl, 10, false);
            a(cVar, i);
            return view;
        }
        return null;
    }

    private void a(c cVar, int i) {
        ba.b(cVar.cqE, s.cp_cont_d, 1);
        ba.b(cVar.cqC, s.cp_cont_b, 1);
        ba.b(cVar.cqB, s.cp_cont_b, 1);
        ba.i(cVar.cqz, s.cp_bg_line_d);
        if (this.bbK == i) {
            ba.i(cVar.cqA, u.chx_box_gift_s);
        } else {
            ba.i(cVar.cqA, u.chx_box_gift_n);
        }
    }

    public void iD(int i) {
        if (this.bbK != i) {
            this.bbK = i;
        }
    }

    public void setData(List<IconInfo> list) {
        this.mData = list;
    }
}
