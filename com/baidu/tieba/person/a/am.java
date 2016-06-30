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
import com.baidu.tieba.person.bs;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am extends BaseAdapter {
    private List<bs.a> egY = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView egZ;
        public TextView eha;
        public TextView ehb;
        public ImageView ehc;
    }

    public am(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void U(List<bs.a> list) {
        this.egY.clear();
        this.egY.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.egY != null) {
            return this.egY.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nU */
    public bs.a getItem(int i) {
        if (this.egY == null || this.egY.size() <= 0 || i < 0 || i >= this.egY.size()) {
            return null;
        }
        return this.egY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(u.h.wallet_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.egZ = (TbImageView) view.findViewById(u.g.item_icon);
            aVar2.eha = (TextView) view.findViewById(u.g.item_text);
            aVar2.ehb = (TextView) view.findViewById(u.g.item_tip);
            aVar2.ehc = (ImageView) view.findViewById(u.g.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bs.a item = getItem(i);
        if (item != null) {
            aVar.egZ.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eha.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.ehb.setVisibility(8);
            } else {
                aVar.ehb.setVisibility(0);
                aVar.ehb.setText(item.tip);
            }
            aVar.ehc.setVisibility(item.efy ? 0 : 8);
        }
        com.baidu.tbadk.j.a.a(this.mTbPageContext, view);
        return view;
    }
}
