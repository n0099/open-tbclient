package com.baidu.tieba.person.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.g;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<g.a> eDP = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView eDQ;
        public TextView eDR;
        public TextView eDS;
        public ImageView eDT;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void L(List<g.a> list) {
        this.eDP.clear();
        this.eDP.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eDP != null) {
            return this.eDP.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oR */
    public g.a getItem(int i) {
        if (this.eDP == null || this.eDP.size() <= 0 || i < 0 || i >= this.eDP.size()) {
            return null;
        }
        return this.eDP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(r.h.wallet_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.eDQ = (TbImageView) view.findViewById(r.g.item_icon);
            aVar2.eDR = (TextView) view.findViewById(r.g.item_text);
            aVar2.eDS = (TextView) view.findViewById(r.g.item_tip);
            aVar2.eDT = (ImageView) view.findViewById(r.g.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        g.a item = getItem(i);
        if (item != null) {
            aVar.eDQ.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eDR.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.eDS.setVisibility(8);
            } else {
                aVar.eDS.setVisibility(0);
                aVar.eDS.setText(item.tip);
            }
            aVar.eDT.setVisibility(item.eDF ? 0 : 8);
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
