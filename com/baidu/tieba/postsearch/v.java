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
import com.baidu.tieba.postsearch.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class v extends BaseAdapter {
    private static final int deF = TbadkCoreApplication.m411getInst().getListItemRule().xj();
    private TbPageContext<?> mContext;
    private List<j.a> mData = new ArrayList();

    public v(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int bz(List<j.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= deF) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - deF;
        lz(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void lz(int i) {
        if (this.mData.size() <= i) {
            this.mData.clear();
        }
        int i2 = 0;
        Iterator<j.a> it = this.mData.iterator();
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.post_search_list_item, (ViewGroup) null);
            a aVar = new a(null);
            aVar.deI = (TextView) view.findViewById(n.f.title_text);
            aVar.deJ = (TextView) view.findViewById(n.f.content_text);
            aVar.deK = (TextView) view.findViewById(n.f.label_text);
            aVar.cvv = (TextView) view.findViewById(n.f.user_name);
            aVar.deL = (TextView) view.findViewById(n.f.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        j.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            Spanned fromHtml = Html.fromHtml(ax.ac(aVar3.title, str));
            if (aVar3.thread_type == 33) {
                aVar2.deI.setText(PhotoLiveCardData.getLiveIconTitle(fromHtml));
            } else {
                aVar2.deI.setText(fromHtml);
            }
            aVar2.deJ.setText(Html.fromHtml(ax.ac(aVar3.content, str)));
            aVar2.cvv.setText(aVar3.name_show);
            aVar2.deL.setText(ax.s(aVar3.time));
            aVar2.deK.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.deK.setText(n.i.floor_text);
            } else if (aVar3.deh == 1) {
                aVar2.deK.setText(n.i.reply_post);
            } else {
                aVar2.deK.setVisibility(8);
            }
            view.setOnClickListener(new w(this, aVar3));
            com.baidu.tbadk.i.a.a(this.mContext, view);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView cvv;
        TextView deI;
        TextView deJ;
        TextView deK;
        TextView deL;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
