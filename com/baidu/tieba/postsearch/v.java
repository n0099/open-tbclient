package com.baidu.tieba.postsearch;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.i;
import com.baidu.tieba.postsearch.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class v extends BaseAdapter {
    private static final int cpk = TbadkCoreApplication.m411getInst().getListItemRule().ww();
    private TbPageContext<?> LS;
    private List<j.a> mData = new ArrayList();

    public v(TbPageContext<?> tbPageContext) {
        this.LS = tbPageContext;
    }

    public int ba(List<j.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= cpk) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - cpk;
        iV(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void iV(int i) {
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
            view = LayoutInflater.from(this.LS.getPageActivity()).inflate(i.g.post_search_list_item, (ViewGroup) null);
            a aVar = new a(null);
            aVar.cpn = (TextView) view.findViewById(i.f.title_text);
            aVar.cpo = (TextView) view.findViewById(i.f.content_text);
            aVar.cpp = (TextView) view.findViewById(i.f.label_text);
            aVar.bYb = (TextView) view.findViewById(i.f.user_name);
            aVar.cpq = (TextView) view.findViewById(i.f.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        j.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.cpn.setText(Html.fromHtml(aq.ag(aVar3.title, str)));
            aVar2.cpo.setText(Html.fromHtml(aq.ag(aVar3.content, str)));
            aVar2.bYb.setText(aVar3.name_show);
            aVar2.cpq.setText(aq.m(aVar3.time));
            aVar2.cpp.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.cpp.setText(i.C0057i.floor_text);
            } else if (aVar3.coM == 1) {
                aVar2.cpp.setText(i.C0057i.reply_post);
            } else {
                aVar2.cpp.setVisibility(8);
            }
            view.setOnClickListener(new w(this, aVar3));
            com.baidu.tbadk.f.a.a(this.LS, view);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView bYb;
        TextView cpn;
        TextView cpo;
        TextView cpp;
        TextView cpq;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
