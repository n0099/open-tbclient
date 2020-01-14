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
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private static final int MAX_SIZE = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private TbPageContext<?> cRe;
    private int fpl = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.cRe = tbPageContext;
    }

    public int ed(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= MAX_SIZE) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - MAX_SIZE;
        Av(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void Av(int i) {
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
            view = LayoutInflater.from(this.cRe.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.jAz = (TextView) view.findViewById(R.id.title_text);
            aVar.jAA = (TextView) view.findViewById(R.id.content_text);
            aVar.jAB = (TextView) view.findViewById(R.id.label_text);
            aVar.fqb = (TextView) view.findViewById(R.id.user_name);
            aVar.jAC = (TextView) view.findViewById(R.id.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.jAz.setText(Html.fromHtml(aq.getHighLightString(aVar3.title, str)));
            aVar2.jAA.setText(Html.fromHtml(aq.getHighLightString(aVar3.content, str)));
            aVar2.fqb.setText(aVar3.name_show);
            aVar2.jAC.setText(aq.getFormatTime(aVar3.time));
            aVar2.jAB.setVisibility(0);
            if (aVar3.jzX == 1) {
                aVar2.jAB.setText(R.string.floor_text);
            } else if (aVar3.jzY == 1) {
                aVar2.jAB.setText(R.string.reply_post);
            } else {
                aVar2.jAB.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.cRe != null) {
                        e.this.a(aVar3);
                        if (aVar3.jzX == 1) {
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.cRe.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            e.this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                            return;
                        }
                        PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.cRe.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                        createNormalCfg.setStartFrom(8);
                        createNormalCfg.setSortType(0);
                        e.this.cRe.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    }
                }
            });
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            com.baidu.tbadk.q.a.a(this.cRe, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.fpl = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        an cp = new an("c12405").cp("fname", aVar.fname).cp("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.fpl > 0) {
            cp.Z("tab_id", this.fpl);
        }
        if (aVar != null) {
            if (aVar.jzX == 1 || aVar.jzY == 1) {
                cp.s("pid", aVar.pid);
            } else {
                cp.s("tid", aVar.tid);
            }
        }
        TiebaStatic.log(cp);
    }

    /* loaded from: classes9.dex */
    private static class a {
        TextView fqb;
        TextView jAA;
        TextView jAB;
        TextView jAC;
        TextView jAz;

        private a() {
        }
    }
}
