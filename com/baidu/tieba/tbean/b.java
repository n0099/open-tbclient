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
    private int bbu;
    private j cqg;
    private List<IconInfo> mData;

    public b(j jVar) {
        this.cqg = jVar;
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
                cVar2.cqj = (LinearLayout) view.findViewById(v.item_parent_ll);
                cVar2.cqk = (LinearLayout) view.findViewById(v.item_child_ll);
                cVar2.cql = (TextView) view.findViewById(v.tbean_num_tv);
                cVar2.cqm = (TextView) view.findViewById(v.price_tv);
                cVar2.cqo = (TextView) view.findViewById(v.name_tv);
                cVar2.cqn = (TbImageView) view.findViewById(v.thumb_tiv);
                cVar2.cqp = view.findViewById(v.left_empty_view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            cVar.cqp.setVisibility(i == 0 ? 0 : 8);
            cVar.cqo.setText(bd.h(iconInfo.name, 10));
            cVar.cqm.setText(String.valueOf(this.cqg.getString(y.yinji_price_tip)) + " " + this.cqg.iC(iconInfo.dubi.intValue()));
            cVar.cql.setText(String.valueOf(this.cqg.getString(y.tbean_give_tip)) + " " + this.cqg.a(iconInfo) + this.cqg.getString(y.tbean_title));
            cVar.cqn.c(iconInfo.picUrl, 10, false);
            a(cVar, i);
            return view;
        }
        return null;
    }

    private void a(c cVar, int i) {
        ba.b(cVar.cqo, s.cp_cont_d, 1);
        ba.b(cVar.cqm, s.cp_cont_b, 1);
        ba.b(cVar.cql, s.cp_cont_b, 1);
        ba.i(cVar.cqj, s.cp_bg_line_d);
        if (this.bbu == i) {
            ba.i(cVar.cqk, u.chx_box_gift_s);
        } else {
            ba.i(cVar.cqk, u.chx_box_gift_n);
        }
    }

    public void iA(int i) {
        if (this.bbu != i) {
            this.bbu = i;
        }
    }

    public void setData(List<IconInfo> list) {
        this.mData = list;
    }
}
