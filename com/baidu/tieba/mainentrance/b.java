package com.baidu.tieba.mainentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private BaseActivity<?> aSX;
    private List<c> bQm;

    public b(BaseActivity<?> baseActivity) {
        this.aSX = baseActivity;
    }

    public void aP(List<c> list) {
        this.bQm = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bQm == null) {
            return 0;
        }
        return this.bQm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hS */
    public c getItem(int i) {
        int count = getCount();
        if (i < 0 || i >= count) {
            return null;
        }
        return this.bQm.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.aSX.getPageContext().getPageActivity()).inflate(i.g.square_dialog_search_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bPq = (BarImageView) view.findViewById(i.f.forum_avatar);
            aVar2.bPq.setGifIconSupport(false);
            aVar2.aOv = (TextView) view.findViewById(i.f.name);
            aVar2.bPr = (TextView) view.findViewById(i.f.member_count);
            aVar2.bPs = (TextView) view.findViewById(i.f.thread_count);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        c item = getItem(i);
        if (item != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            String ZQ = item.ZQ();
            aVar.bPq.setTag(ZQ);
            aVar.bPq.d(ZQ, 10, false);
            aVar.aOv.setText(item.getForumName());
            aVar.bPr.setText(String.valueOf(this.aSX.getPageContext().getString(i.h.forum_list_attention_tv)) + as(item.ZR()));
            aVar.bPs.setText(String.valueOf(this.aSX.getPageContext().getString(i.h.forum_list_thread_tv)) + as(item.ZS()));
            if (i == getCount() - 1) {
                view.findViewById(i.f.square_lv_search_forum_divider).setVisibility(8);
            } else {
                view.findViewById(i.f.square_lv_search_forum_divider).setVisibility(0);
            }
            this.aSX.getLayoutMode().ad(skinType == 1);
            this.aSX.getLayoutMode().k(view);
        }
        return view;
    }

    public String as(long j) {
        if (j >= 100000) {
            return aq.q(j);
        }
        return String.valueOf(j);
    }

    /* loaded from: classes.dex */
    private class a {
        TextView aOv;
        BarImageView bPq;
        TextView bPr;
        TextView bPs;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }
    }
}
