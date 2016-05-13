package com.baidu.tieba.person.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personInfo.bq;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am extends BaseAdapter {
    private List<bq.a> dyC = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView dyD;
        public TextView dyE;
        public TextView dyF;
    }

    public am(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void au(List<bq.a> list) {
        this.dyC.clear();
        this.dyC.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dyC != null) {
            return this.dyC.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mt */
    public bq.a getItem(int i) {
        if (this.dyC == null || this.dyC.size() <= 0 || i < 0 || i >= this.dyC.size()) {
            return null;
        }
        return this.dyC.get(i);
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
            aVar2.dyD = (TbImageView) view.findViewById(t.g.item_icon);
            aVar2.dyE = (TextView) view.findViewById(t.g.item_text);
            aVar2.dyF = (TextView) view.findViewById(t.g.item_tip);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        bq.a item = getItem(i);
        if (item != null) {
            aVar.dyD.c(TextUtils.isEmpty(item.getPic()) ? null : item.getPic(), 10, false);
            aVar.dyE.setText(item.getTitle());
            if (TextUtils.isEmpty(item.se())) {
                aVar.dyF.setVisibility(8);
            } else {
                aVar.dyF.setVisibility(0);
                aVar.dyF.setText(item.se());
            }
        }
        com.baidu.tbadk.i.a.a(this.mTbPageContext, view);
        return view;
    }
}
