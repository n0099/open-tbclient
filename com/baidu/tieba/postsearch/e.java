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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends BaseAdapter {
    private static final int MAX_SIZE = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private TbPageContext<?> eXu;
    private int hWZ = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.eXu = tbPageContext;
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
            view = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.mIC = (TextView) view.findViewById(R.id.title_text);
            aVar.mIE = (TextView) view.findViewById(R.id.content_text);
            aVar.mIF = (TextView) view.findViewById(R.id.label_text);
            aVar.hXL = (TextView) view.findViewById(R.id.user_name);
            aVar.mIG = (TextView) view.findViewById(R.id.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.mIC.setText(Html.fromHtml(at.getHighLightString(aVar3.title, str)));
            aVar2.mIE.setText(Html.fromHtml(at.getHighLightString(aVar3.content, str)));
            aVar2.hXL.setText(aVar3.name_show);
            aVar2.mIG.setText(at.getFormatTime(aVar3.time));
            aVar2.mIF.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.mIF.setText(R.string.floor_text);
            } else if (aVar3.mHY == 1) {
                aVar2.mIF.setText(R.string.reply_post);
            } else {
                aVar2.mIF.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.eXu != null) {
                        e.this.a(aVar3);
                        if (aVar3.is_floor == 1) {
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.eXu.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            e.this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                            return;
                        }
                        PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.eXu.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                        createNormalCfg.setStartFrom(8);
                        createNormalCfg.setSortType(0);
                        e.this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    }
                }
            });
            ao.setBackgroundColor(view, R.color.CAM_X0201);
            com.baidu.tbadk.r.a.a(this.eXu, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.hWZ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        aq dX = new aq("c12405").dX("fname", aVar.fname).dX("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.hWZ > 0) {
            dX.an("tab_id", this.hWZ);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.mHY == 1) {
                dX.w("pid", aVar.pid);
            } else {
                dX.w("tid", aVar.tid);
            }
        }
        TiebaStatic.log(dX);
    }

    /* loaded from: classes8.dex */
    private static class a {
        TextView hXL;
        TextView mIC;
        TextView mIE;
        TextView mIF;
        TextView mIG;

        private a() {
        }
    }
}
