package com.baidu.tieba.postsearch;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends BaseAdapter {
    private static final int icG = TbadkCoreApplication.getInst().getListItemRule().ags();
    private TbPageContext<?> mContext;
    private int dRB = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int dN(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= icG) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - icG;
        xz(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void xz(int i) {
        if (this.mData.size() <= i) {
            this.mData.clear();
        }
        int i2 = 0;
        Iterator<b.a> it = this.mData.iterator();
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.icJ = (TextView) view.findViewById(d.g.title_text);
            aVar.icK = (TextView) view.findViewById(d.g.content_text);
            aVar.icL = (TextView) view.findViewById(d.g.label_text);
            aVar.dSc = (TextView) view.findViewById(d.g.user_name);
            aVar.icM = (TextView) view.findViewById(d.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.icJ.setText(Html.fromHtml(ap.bK(aVar3.title, str)));
            aVar2.icK.setText(Html.fromHtml(ap.bK(aVar3.content, str)));
            aVar2.dSc.setText(aVar3.name_show);
            aVar2.icM.setText(ap.ao(aVar3.time));
            aVar2.icL.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.icL.setText(d.j.floor_text);
            } else if (aVar3.ich == 1) {
                aVar2.icL.setText(d.j.reply_post);
            } else {
                aVar2.icL.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.mContext != null) {
                        e.this.a(aVar3);
                        if (aVar3.is_floor == 1) {
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.mContext.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            e.this.mContext.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                            return;
                        }
                        PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                        createNormalCfg.setStartFrom(8);
                        createNormalCfg.setSortType(0);
                        e.this.mContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    }
                }
            });
            al.l(view, d.C0277d.cp_bg_line_d);
            com.baidu.tbadk.r.a.a(this.mContext, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.dRB = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        am bJ = new am("c12405").bJ(ImageViewerConfig.FORUM_NAME, aVar.fname).bJ("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.dRB > 0) {
            bJ.T(MyBookrackActivityConfig.TAB_ID, this.dRB);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.ich == 1) {
                bJ.k(Info.kBaiduPIDKey, aVar.pid);
            } else {
                bJ.k("tid", aVar.tid);
            }
        }
        TiebaStatic.log(bJ);
    }

    /* loaded from: classes6.dex */
    private static class a {
        TextView dSc;
        TextView icJ;
        TextView icK;
        TextView icL;
        TextView icM;

        private a() {
        }
    }
}
