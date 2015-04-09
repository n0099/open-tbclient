package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class i extends BaseAdapter {
    private static final int byS = TbadkCoreApplication.m411getInst().getListItemRule().uF();
    private Context mContext;
    private List<k> mDatas = new ArrayList();

    public i(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public int aO(List<k> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mDatas.size() + list.size();
        if (size <= byS) {
            this.mDatas.addAll(list);
            return 0;
        }
        int i = size - byS;
        fk(i);
        this.mDatas.addAll(list);
        return i;
    }

    public void clear() {
        this.mDatas.clear();
    }

    private void fk(int i) {
        if (this.mDatas.size() <= i) {
            this.mDatas.clear();
        }
        int i2 = 0;
        Iterator<k> it = this.mDatas.iterator();
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
        if (this.mDatas == null) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mDatas != null && i < this.mDatas.size()) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        j jVar;
        if (this.mDatas != null) {
            if (view == null) {
                jVar = new j(this, null);
                view = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.search_post_item, null);
                jVar.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.title);
                jVar.adg = view.findViewById(com.baidu.tieba.v.search_post_lv_search_forum_divider);
                jVar.byT = (TextView) view.findViewById(com.baidu.tieba.v.content);
                jVar.aED = (TextView) view.findViewById(com.baidu.tieba.v.forum);
                jVar.aGS = (TextView) view.findViewById(com.baidu.tieba.v.time);
                jVar.byU = (LinearLayout) view.findViewById(com.baidu.tieba.v.square_search_content_layout);
                view.setTag(jVar);
            } else {
                jVar = (j) view.getTag();
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            k kVar = (k) getItem(i);
            if (kVar != null) {
                jVar.aED.setText(String.valueOf(kVar.WR()) + this.mContext.getString(com.baidu.tieba.y.bar));
                jVar.aGS.setText(bd.n(kVar.getTime()));
                if (kVar.getContent() == null || kVar.getContent().length() < 1) {
                    jVar.byU.setVisibility(8);
                } else {
                    jVar.byU.setVisibility(0);
                    jVar.byT.setText(Html.fromHtml(bd.a(kVar.getContent(), (Color) null)));
                }
                jVar.mTitle.setText(Html.fromHtml(bd.a(kVar.getTitle(), (Color) null)));
                ba.c(jVar.byT, skinType);
                if (skinType == 0) {
                    jVar.aED.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                    jVar.aGS.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                    jVar.byT.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_b));
                } else {
                    jVar.aED.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                    jVar.aGS.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_d_1));
                    jVar.byT.setTextColor(this.mContext.getResources().getColor(com.baidu.tieba.s.cp_cont_b_1));
                }
                ba.j(jVar.adg, com.baidu.tieba.s.cp_bg_line_b);
                ba.i(jVar.byU, com.baidu.tieba.u.bg_search_tiezi);
                ba.b(jVar.mTitle, com.baidu.tieba.s.cp_cont_c, 1);
            }
        }
        return view;
    }
}
