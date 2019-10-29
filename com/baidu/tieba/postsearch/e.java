package com.baidu.tieba.postsearch;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends BaseAdapter {
    private static final int iDy = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private TbPageContext<?> cfl;
    private int evx = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.cfl = tbPageContext;
    }

    public int el(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= iDy) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - iDy;
        xV(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void xV(int i) {
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
            view = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.iDB = (TextView) view.findViewById(R.id.title_text);
            aVar.iDC = (TextView) view.findViewById(R.id.content_text);
            aVar.iDD = (TextView) view.findViewById(R.id.label_text);
            aVar.ewj = (TextView) view.findViewById(R.id.user_name);
            aVar.iDE = (TextView) view.findViewById(R.id.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.iDB.setText(Html.fromHtml(aq.getHighLightString(aVar3.title, str)));
            aVar2.iDC.setText(Html.fromHtml(aq.getHighLightString(aVar3.content, str)));
            aVar2.ewj.setText(aVar3.name_show);
            aVar2.iDE.setText(aq.getFormatTime(aVar3.time));
            aVar2.iDD.setVisibility(0);
            if (aVar3.iCY == 1) {
                aVar2.iDD.setText(R.string.floor_text);
            } else if (aVar3.iCZ == 1) {
                aVar2.iDD.setText(R.string.reply_post);
            } else {
                aVar2.iDD.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.cfl != null) {
                        e.this.a(aVar3);
                        if (aVar3.iCY == 1) {
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.cfl.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            e.this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                            return;
                        }
                        PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.cfl.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                        createNormalCfg.setStartFrom(8);
                        createNormalCfg.setSortType(0);
                        e.this.cfl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    }
                }
            });
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            com.baidu.tbadk.s.a.a(this.cfl, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.evx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        an bS = new an("c12405").bS("fname", aVar.fname).bS("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.evx > 0) {
            bS.O("tab_id", this.evx);
        }
        if (aVar != null) {
            if (aVar.iCY == 1 || aVar.iCZ == 1) {
                bS.p("pid", aVar.pid);
            } else {
                bS.p("tid", aVar.tid);
            }
        }
        TiebaStatic.log(bS);
    }

    /* loaded from: classes6.dex */
    private static class a {
        TextView ewj;
        TextView iDB;
        TextView iDC;
        TextView iDD;
        TextView iDE;

        private a() {
        }
    }
}
