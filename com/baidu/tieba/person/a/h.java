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
    private List<f.a> ezE = new ArrayList();
    private TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public static class a {
        public TbImageView ezF;
        public TextView ezG;
        public TextView ezH;
        public ImageView ezI;
    }

    public h(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    public void aB(List<f.a> list) {
        this.ezE.clear();
        this.ezE.addAll(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ezE != null) {
            return this.ezE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oS */
    public f.a getItem(int i) {
        if (this.ezE == null || this.ezE.size() <= 0 || i < 0 || i >= this.ezE.size()) {
            return null;
        }
        return this.ezE.get(i);
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
            aVar2.ezF = (TbImageView) view.findViewById(w.h.item_icon);
            aVar2.ezG = (TextView) view.findViewById(w.h.item_text);
            aVar2.ezH = (TextView) view.findViewById(w.h.item_tip);
            aVar2.ezI = (ImageView) view.findViewById(w.h.item_new);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f.a item = getItem(i);
        if (item != null) {
            aVar.ezF.c(TextUtils.isEmpty(item.pic) ? null : item.pic, 10, false);
            aVar.ezG.setText(item.title);
            if (TextUtils.isEmpty(item.tip)) {
                aVar.ezH.setVisibility(8);
            } else {
                aVar.ezH.setVisibility(0);
                aVar.ezH.setText(item.tip);
            }
            aVar.ezI.setVisibility(item.ezv ? 0 : 8);
        }
        com.baidu.tbadk.m.a.a(this.mTbPageContext, view);
        return view;
    }
}
