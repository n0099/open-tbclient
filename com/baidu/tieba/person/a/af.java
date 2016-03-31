package com.baidu.tieba.person.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personInfo.bp;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class af extends BaseAdapter {
    private List<bp.a> dvA = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView dvB;
        public TextView dvC;
        public TextView dvD;
    }

    public af(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aw(List<bp.a> list) {
        this.dvA.clear();
        this.dvA.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dvA != null) {
            return this.dvA.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mD */
    public bp.a getItem(int i) {
        if (this.dvA == null || this.dvA.size() <= 0 || i < 0 || i >= this.dvA.size()) {
            return null;
        }
        return this.dvA.get(i);
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
            aVar2.dvB = (TbImageView) view.findViewById(t.g.item_icon);
            aVar2.dvC = (TextView) view.findViewById(t.g.item_text);
            aVar2.dvD = (TextView) view.findViewById(t.g.item_tip);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bp.a item = getItem(i);
        if (item != null) {
            aVar.dvB.c(TextUtils.isEmpty(item.getPic()) ? null : item.getPic(), 10, false);
            aVar.dvC.setText(item.getTitle());
            if (TextUtils.isEmpty(item.uy())) {
                aVar.dvD.setVisibility(8);
            } else {
                aVar.dvD.setVisibility(0);
                aVar.dvD.setText(item.uy());
            }
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
