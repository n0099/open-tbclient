package com.baidu.tieba.postsearch;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import com.baidu.tieba.postsearch.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private static final int dkl = TbadkCoreApplication.m411getInst().getListItemRule().wS();
    private TbPageContext<?> mContext;
    private List<k.a> mData = new ArrayList();

    public w(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int bx(List<k.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= dkl) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - dkl;
        lY(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void lY(int i) {
        if (this.mData.size() <= i) {
            this.mData.clear();
        }
        int i2 = 0;
        Iterator<k.a> it = this.mData.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            i2++;
            if (i2 >= i) {
                return;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || this.mData.isEmpty() || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a(null);
            aVar.dko = (TextView) view.findViewById(n.g.title_text);
            aVar.dkp = (TextView) view.findViewById(n.g.content_text);
            aVar.dkq = (TextView) view.findViewById(n.g.label_text);
            aVar.czv = (TextView) view.findViewById(n.g.user_name);
            aVar.dkr = (TextView) view.findViewById(n.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        k.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            Spanned fromHtml = Html.fromHtml(ax.ab(aVar3.title, str));
            if (aVar3.thread_type == 33) {
                aVar2.dko.setText(PhotoLiveCardData.getLiveIconTitle(fromHtml));
            } else {
                aVar2.dko.setText(fromHtml);
            }
            aVar2.dkp.setText(Html.fromHtml(ax.ab(aVar3.content, str)));
            aVar2.czv.setText(aVar3.name_show);
            aVar2.dkr.setText(ax.s(aVar3.time));
            aVar2.dkq.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.dkq.setText(n.j.floor_text);
            } else if (aVar3.djN == 1) {
                aVar2.dkq.setText(n.j.reply_post);
            } else {
                aVar2.dkq.setVisibility(8);
            }
            view.setOnClickListener(new x(this, aVar3));
            com.baidu.tbadk.i.a.a(this.mContext, view);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView czv;
        TextView dko;
        TextView dkp;
        TextView dkq;
        TextView dkr;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
