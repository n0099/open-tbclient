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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak extends BaseAdapter {
    private List<f.a> eqX = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView eqY;
        public TextView eqZ;
        public TextView era;
        public ImageView erb;
    }

    public ak(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void U(List<f.a> list) {
        this.eqX.clear();
        this.eqX.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eqX != null) {
            return this.eqX.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: of */
    public f.a getItem(int i) {
        if (this.eqX == null || this.eqX.size() <= 0 || i < 0 || i >= this.eqX.size()) {
            return null;
        }
        return this.eqX.get(i);
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
            aVar2.eqY = (TbImageView) view.findViewById(u.g.item_icon);
            aVar2.eqZ = (TextView) view.findViewById(u.g.item_text);
            aVar2.era = (TextView) view.findViewById(u.g.item_tip);
            aVar2.erb = (ImageView) view.findViewById(u.g.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f.a item = getItem(i);
        if (item != null) {
            aVar.eqY.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.eqZ.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.era.setVisibility(8);
            } else {
                aVar.era.setVisibility(0);
                aVar.era.setText(item.tip);
            }
            aVar.erb.setVisibility(item.epy ? 0 : 8);
        }
        com.baidu.tbadk.j.a.a(this.mTbPageContext, view);
        return view;
    }
}
