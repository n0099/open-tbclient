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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<g.a> eBM = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView eBN;
        public TextView eBO;
        public TextView eBP;
        public ImageView eBQ;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void L(List<g.a> list) {
        this.eBM.clear();
        this.eBM.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eBM != null) {
            return this.eBM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oH */
    public g.a getItem(int i) {
        if (this.eBM == null || this.eBM.size() <= 0 || i < 0 || i >= this.eBM.size()) {
            return null;
        }
        return this.eBM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(t.h.wallet_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.eBN = (TbImageView) view.findViewById(t.g.item_icon);
            aVar2.eBO = (TextView) view.findViewById(t.g.item_text);
            aVar2.eBP = (TextView) view.findViewById(t.g.item_tip);
            aVar2.eBQ = (ImageView) view.findViewById(t.g.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        g.a item = getItem(i);
        if (item != null) {
            aVar.eBN.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eBO.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.eBP.setVisibility(8);
            } else {
                aVar.eBP.setVisibility(0);
                aVar.eBP.setText(item.tip);
            }
            aVar.eBQ.setVisibility(item.eBC ? 0 : 8);
        }
        com.baidu.tbadk.j.a.a(this.mTbPageContext, view);
        return view;
    }
}
