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
    private static final int dSM = TbadkCoreApplication.m411getInst().getListItemRule().yG();
    private TbPageContext<?> MX;
    private List<k.a> aLU = new ArrayList();

    public w(TbPageContext<?> tbPageContext) {
        this.MX = tbPageContext;
    }

    public int cd(List<k.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.aLU.size() + list.size();
        if (size <= dSM) {
            this.aLU.addAll(list);
            return 0;
        }
        int i = size - dSM;
        oi(i);
        this.aLU.addAll(list);
        return i;
    }

    public void clear() {
        this.aLU.clear();
    }

    private void oi(int i) {
        if (this.aLU.size() <= i) {
            this.aLU.clear();
        }
        int i2 = 0;
        Iterator<k.a> it = this.aLU.iterator();
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
        if (this.aLU == null) {
            return 0;
        }
        return this.aLU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aLU == null || this.aLU.isEmpty() || i < 0 || i >= this.aLU.size()) {
            return null;
        }
        return this.aLU.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a(null);
            aVar.dSP = (TextView) view.findViewById(t.g.title_text);
            aVar.dSQ = (TextView) view.findViewById(t.g.content_text);
            aVar.dSR = (TextView) view.findViewById(t.g.label_text);
            aVar.cCv = (TextView) view.findViewById(t.g.user_name);
            aVar.dSS = (TextView) view.findViewById(t.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        k.a aVar3 = this.aLU.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            Spanned fromHtml = Html.fromHtml(ay.ae(aVar3.title, str));
            if (aVar3.thread_type == 33) {
                aVar2.dSP.setText(PhotoLiveCardData.getLiveIconTitle(fromHtml));
            } else {
                aVar2.dSP.setText(fromHtml);
            }
            aVar2.dSQ.setText(Html.fromHtml(ay.ae(aVar3.content, str)));
            aVar2.cCv.setText(aVar3.name_show);
            aVar2.dSS.setText(ay.w(aVar3.time));
            aVar2.dSR.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.dSR.setText(t.j.floor_text);
            } else if (aVar3.dSn == 1) {
                aVar2.dSR.setText(t.j.reply_post);
            } else {
                aVar2.dSR.setVisibility(8);
            }
            view.setOnClickListener(new x(this, aVar3));
            com.baidu.tbadk.i.a.a(this.MX, view);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView cCv;
        TextView dSP;
        TextView dSQ;
        TextView dSR;
        TextView dSS;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
