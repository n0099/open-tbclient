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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends BaseAdapter {
    private List<f.a> eoe = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView eog;
        public TextView eoh;
        public TextView eoi;
        public ImageView eoj;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void M(List<f.a> list) {
        this.eoe.clear();
        this.eoe.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eoe != null) {
            return this.eoe.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: og */
    public f.a getItem(int i) {
        if (this.eoe == null || this.eoe.size() <= 0 || i < 0 || i >= this.eoe.size()) {
            return null;
        }
        return this.eoe.get(i);
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
            aVar2.eog = (TbImageView) view.findViewById(r.g.item_icon);
            aVar2.eoh = (TextView) view.findViewById(r.g.item_text);
            aVar2.eoi = (TextView) view.findViewById(r.g.item_tip);
            aVar2.eoj = (ImageView) view.findViewById(r.g.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f.a item = getItem(i);
        if (item != null) {
            aVar.eog.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eoh.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.eoi.setVisibility(8);
            } else {
                aVar.eoi.setVisibility(0);
                aVar.eoi.setText(item.tip);
            }
            aVar.eoj.setVisibility(item.enV ? 0 : 8);
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
