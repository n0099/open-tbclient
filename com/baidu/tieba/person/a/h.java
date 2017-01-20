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
    private List<f.a> exY = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView exZ;
        public TextView eya;
        public TextView eyb;
        public ImageView eyc;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aK(List<f.a> list) {
        this.exY.clear();
        this.exY.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.exY != null) {
            return this.exY.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oY */
    public f.a getItem(int i) {
        if (this.exY == null || this.exY.size() <= 0 || i < 0 || i >= this.exY.size()) {
            return null;
        }
        return this.exY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(r.j.wallet_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.exZ = (TbImageView) view.findViewById(r.h.item_icon);
            aVar2.eya = (TextView) view.findViewById(r.h.item_text);
            aVar2.eyb = (TextView) view.findViewById(r.h.item_tip);
            aVar2.eyc = (ImageView) view.findViewById(r.h.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f.a item = getItem(i);
        if (item != null) {
            aVar.exZ.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eya.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.eyb.setVisibility(8);
            } else {
                aVar.eyb.setVisibility(0);
                aVar.eyb.setText(item.tip);
            }
            aVar.eyc.setVisibility(item.exP ? 0 : 8);
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
