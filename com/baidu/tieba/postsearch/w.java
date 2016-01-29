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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.postsearch.k;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private static final int dyg = TbadkCoreApplication.m411getInst().getListItemRule().yf();
    private TbPageContext<?> MR;
    private List<k.a> aIY = new ArrayList();

    public w(TbPageContext<?> tbPageContext) {
        this.MR = tbPageContext;
    }

    public int bH(List<k.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.aIY.size() + list.size();
        if (size <= dyg) {
            this.aIY.addAll(list);
            return 0;
        }
        int i = size - dyg;
        mZ(i);
        this.aIY.addAll(list);
        return i;
    }

    public void clear() {
        this.aIY.clear();
    }

    private void mZ(int i) {
        if (this.aIY.size() <= i) {
            this.aIY.clear();
        }
        int i2 = 0;
        Iterator<k.a> it = this.aIY.iterator();
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
        if (this.aIY == null) {
            return 0;
        }
        return this.aIY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aIY == null || this.aIY.isEmpty() || i < 0 || i >= this.aIY.size()) {
            return null;
        }
        return this.aIY.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a(null);
            aVar.dyj = (TextView) view.findViewById(t.g.title_text);
            aVar.dyk = (TextView) view.findViewById(t.g.content_text);
            aVar.dyl = (TextView) view.findViewById(t.g.label_text);
            aVar.crV = (TextView) view.findViewById(t.g.user_name);
            aVar.dym = (TextView) view.findViewById(t.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        k.a aVar3 = this.aIY.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            Spanned fromHtml = Html.fromHtml(aw.ab(aVar3.title, str));
            if (aVar3.thread_type == 33) {
                aVar2.dyj.setText(PhotoLiveCardData.getLiveIconTitle(fromHtml));
            } else {
                aVar2.dyj.setText(fromHtml);
            }
            aVar2.dyk.setText(Html.fromHtml(aw.ab(aVar3.content, str)));
            aVar2.crV.setText(aVar3.name_show);
            aVar2.dym.setText(aw.t(aVar3.time));
            aVar2.dyl.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.dyl.setText(t.j.floor_text);
            } else if (aVar3.dxH == 1) {
                aVar2.dyl.setText(t.j.reply_post);
            } else {
                aVar2.dyl.setVisibility(8);
            }
            view.setOnClickListener(new x(this, aVar3));
            com.baidu.tbadk.i.a.a(this.MR, view);
        }
        return view;
    }

    /* loaded from: classes.dex */
    private static class a {
        TextView crV;
        TextView dyj;
        TextView dyk;
        TextView dyl;
        TextView dym;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }
}
