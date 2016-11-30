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
    private List<g.a> eKo = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView eKp;
        public TextView eKq;
        public TextView eKr;
        public ImageView eKs;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void M(List<g.a> list) {
        this.eKo.clear();
        this.eKo.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eKo != null) {
            return this.eKo.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pe */
    public g.a getItem(int i) {
        if (this.eKo == null || this.eKo.size() <= 0 || i < 0 || i >= this.eKo.size()) {
            return null;
        }
        return this.eKo.get(i);
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
            aVar2.eKp = (TbImageView) view.findViewById(r.g.item_icon);
            aVar2.eKq = (TextView) view.findViewById(r.g.item_text);
            aVar2.eKr = (TextView) view.findViewById(r.g.item_tip);
            aVar2.eKs = (ImageView) view.findViewById(r.g.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        g.a item = getItem(i);
        if (item != null) {
            aVar.eKp.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eKq.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.eKr.setVisibility(8);
            } else {
                aVar.eKr.setVisibility(0);
                aVar.eKr.setText(item.tip);
            }
            aVar.eKs.setVisibility(item.eKe ? 0 : 8);
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
