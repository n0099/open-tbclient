package com.baidu.tieba.postsearch;

import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w extends BaseAdapter {
    private static final int bYq = TbadkCoreApplication.m411getInst().getListItemRule().vp();
    private TbPageContext<?> LH;
    private List<k> mData = new ArrayList();

    public w(TbPageContext<?> tbPageContext) {
        this.LH = tbPageContext;
    }

    public int aW(List<k> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= bYq) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - bYq;
        ib(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void ib(int i) {
        if (this.mData.size() <= i) {
            this.mData.clear();
        }
        int i2 = 0;
        Iterator<k> it = this.mData.iterator();
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
        if (this.mData == null) {
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
            view = com.baidu.adp.lib.g.b.hr().inflate(this.LH.getPageActivity(), com.baidu.tieba.r.post_search_list_item, null);
            y yVar = new y(null);
            yVar.bYt = (TextView) view.findViewById(com.baidu.tieba.q.title_text);
            yVar.bYu = (TextView) view.findViewById(com.baidu.tieba.q.content_text);
            yVar.bYv = (TextView) view.findViewById(com.baidu.tieba.q.label_text);
            yVar.bHU = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
            yVar.bYw = (TextView) view.findViewById(com.baidu.tieba.q.time_text);
            view.setTag(yVar);
        }
        y yVar2 = (y) view.getTag();
        k kVar = this.mData.get(i);
        if (kVar != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            yVar2.bYt.setText(Html.fromHtml(bb.ag(kVar.title, str)));
            yVar2.bYu.setText(Html.fromHtml(bb.ag(kVar.content, str)));
            yVar2.bHU.setText(kVar.name_show);
            yVar2.bYw.setText(bb.o(kVar.time));
            yVar2.bYv.setVisibility(0);
            if (kVar.is_floor == 1) {
                yVar2.bYv.setText(com.baidu.tieba.t.floor_text);
            } else if (kVar.bXS == 1) {
                yVar2.bYv.setText(com.baidu.tieba.t.reply_post);
            } else {
                yVar2.bYv.setVisibility(8);
            }
            view.setOnClickListener(new x(this, kVar));
            com.baidu.tbadk.f.a.a(this.LH, view);
        }
        return view;
    }
}
