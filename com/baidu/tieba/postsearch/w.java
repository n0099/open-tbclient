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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.postsearch.k;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private static final int dVE = TbadkCoreApplication.m11getInst().getListItemRule().wA();
    private TbPageContext<?> Do;
    private List<k.a> aIe = new ArrayList();

    public w(TbPageContext<?> tbPageContext) {
        this.Do = tbPageContext;
    }

    public int cf(List<k.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.aIe.size() + list.size();
        if (size <= dVE) {
            this.aIe.addAll(list);
            return 0;
        }
        int i = size - dVE;
        nX(i);
        this.aIe.addAll(list);
        return i;
    }

    public void clear() {
        this.aIe.clear();
    }

    private void nX(int i) {
        if (this.aIe.size() <= i) {
            this.aIe.clear();
        }
        int i2 = 0;
        Iterator<k.a> it = this.aIe.iterator();
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
        if (this.aIe == null) {
            return 0;
        }
        return this.aIe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIe == null || this.aIe.isEmpty() || i < 0 || i >= this.aIe.size()) {
            return null;
        }
        return this.aIe.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a(null);
            aVar.dVH = (TextView) view.findViewById(t.g.title_text);
            aVar.dVI = (TextView) view.findViewById(t.g.content_text);
            aVar.dVJ = (TextView) view.findViewById(t.g.label_text);
            aVar.cDv = (TextView) view.findViewById(t.g.user_name);
            aVar.dVK = (TextView) view.findViewById(t.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        k.a aVar3 = this.aIe.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            Spanned fromHtml = Html.fromHtml(ay.ae(aVar3.title, str));
            if (aVar3.thread_type == 33) {
                aVar2.dVH.setText(PhotoLiveCardData.getLiveIconTitle(fromHtml));
            } else {
                aVar2.dVH.setText(fromHtml);
            }
            aVar2.dVI.setText(Html.fromHtml(ay.ae(aVar3.content, str)));
            aVar2.cDv.setText(aVar3.name_show);
            aVar2.dVK.setText(ay.x(aVar3.time));
            aVar2.dVJ.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.dVJ.setText(t.j.floor_text);
            } else if (aVar3.dVf == 1) {
                aVar2.dVJ.setText(t.j.reply_post);
            } else {
                aVar2.dVJ.setVisibility(8);
            }
            view.setOnClickListener(new x(this, aVar3));
            com.baidu.tbadk.i.a.a(this.Do, view);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView cDv;
        TextView dVH;
        TextView dVI;
        TextView dVJ;
        TextView dVK;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
