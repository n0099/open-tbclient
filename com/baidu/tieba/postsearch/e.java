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
import java.util.List;
/* loaded from: classes11.dex */
public class e extends BaseAdapter {
    private static final int MAX_SIZE = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private TbPageContext<?> duK;
    private int fXc = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.duK = tbPageContext;
    }

    public void setData(List<b.a> list) {
        this.mData = list;
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
            view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.knl = (TextView) view.findViewById(R.id.title_text);
            aVar.knm = (TextView) view.findViewById(R.id.content_text);
            aVar.knn = (TextView) view.findViewById(R.id.label_text);
            aVar.fXR = (TextView) view.findViewById(R.id.user_name);
            aVar.kno = (TextView) view.findViewById(R.id.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.knl.setText(Html.fromHtml(aq.getHighLightString(aVar3.title, str)));
            aVar2.knm.setText(Html.fromHtml(aq.getHighLightString(aVar3.content, str)));
            aVar2.fXR.setText(aVar3.name_show);
            aVar2.kno.setText(aq.getFormatTime(aVar3.time));
            aVar2.knn.setVisibility(0);
            if (aVar3.kmJ == 1) {
                aVar2.knn.setText(R.string.floor_text);
            } else if (aVar3.kmK == 1) {
                aVar2.knn.setText(R.string.reply_post);
            } else {
                aVar2.knn.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.duK != null) {
                        e.this.a(aVar3);
                        if (aVar3.kmJ == 1) {
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.duK.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            e.this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                            return;
                        }
                        PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.duK.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                        createNormalCfg.setStartFrom(8);
                        createNormalCfg.setSortType(0);
                        e.this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    }
                }
            });
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            com.baidu.tbadk.q.a.a(this.duK, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.fXc = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        an cI = new an("c12405").cI("fname", aVar.fname).cI("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.fXc > 0) {
            cI.af("tab_id", this.fXc);
        }
        if (aVar != null) {
            if (aVar.kmJ == 1 || aVar.kmK == 1) {
                cI.t("pid", aVar.pid);
            } else {
                cI.t("tid", aVar.tid);
            }
        }
        TiebaStatic.log(cI);
    }

    /* loaded from: classes11.dex */
    private static class a {
        TextView fXR;
        TextView knl;
        TextView knm;
        TextView knn;
        TextView kno;

        private a() {
        }
    }
}
