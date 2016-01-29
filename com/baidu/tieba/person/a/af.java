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
    private List<bp.a> daY = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView daZ;
        public TextView dba;
        public TextView dbb;
    }

    public af(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void as(List<bp.a> list) {
        this.daY.clear();
        this.daY.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.daY != null) {
            return this.daY.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lu */
    public bp.a getItem(int i) {
        if (this.daY == null || this.daY.size() <= 0 || i < 0 || i >= this.daY.size()) {
            return null;
        }
        return this.daY.get(i);
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
            aVar2.daZ = (TbImageView) view.findViewById(t.g.item_icon);
            aVar2.dba = (TextView) view.findViewById(t.g.item_text);
            aVar2.dbb = (TextView) view.findViewById(t.g.item_tip);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bp.a item = getItem(i);
        if (item != null) {
            aVar.daZ.d(TextUtils.isEmpty(item.getPic()) ? null : item.getPic(), 10, false);
            aVar.dba.setText(item.getTitle());
            if (TextUtils.isEmpty(item.ut())) {
                aVar.dbb.setVisibility(8);
            } else {
                aVar.dbb.setVisibility(0);
                aVar.dbb.setText(item.ut());
            }
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
