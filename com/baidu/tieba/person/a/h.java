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
import com.baidu.tieba.person.f;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<f.a> eBU = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView eBV;
        public TextView eBW;
        public TextView eBX;
        public ImageView eBY;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aC(List<f.a> list) {
        this.eBU.clear();
        this.eBU.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eBU != null) {
            return this.eBU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oY */
    public f.a getItem(int i) {
        if (this.eBU == null || this.eBU.size() <= 0 || i < 0 || i >= this.eBU.size()) {
            return null;
        }
        return this.eBU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(w.j.wallet_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.eBV = (TbImageView) view.findViewById(w.h.item_icon);
            aVar2.eBW = (TextView) view.findViewById(w.h.item_text);
            aVar2.eBX = (TextView) view.findViewById(w.h.item_tip);
            aVar2.eBY = (ImageView) view.findViewById(w.h.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f.a item = getItem(i);
        if (item != null) {
            aVar.eBV.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eBW.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.eBX.setVisibility(8);
            } else {
                aVar.eBX.setVisibility(0);
                aVar.eBX.setText(item.tip);
            }
            aVar.eBY.setVisibility(item.eBL ? 0 : 8);
        }
        com.baidu.tbadk.m.a.a(this.mTbPageContext, view);
        return view;
    }
}
