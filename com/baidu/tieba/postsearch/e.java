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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class e extends BaseAdapter {
    private static final int MAX_SIZE = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private TbPageContext<?> eNx;
    private int hKL = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.eNx = tbPageContext;
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
            view = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.mDi = (TextView) view.findViewById(R.id.title_text);
            aVar.mDj = (TextView) view.findViewById(R.id.content_text);
            aVar.mDk = (TextView) view.findViewById(R.id.label_text);
            aVar.hLw = (TextView) view.findViewById(R.id.user_name);
            aVar.mDl = (TextView) view.findViewById(R.id.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.mDi.setText(Html.fromHtml(au.getHighLightString(aVar3.title, str)));
            aVar2.mDj.setText(Html.fromHtml(au.getHighLightString(aVar3.content, str)));
            aVar2.hLw.setText(aVar3.name_show);
            aVar2.mDl.setText(au.getFormatTime(aVar3.time));
            aVar2.mDk.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.mDk.setText(R.string.floor_text);
            } else if (aVar3.mCG == 1) {
                aVar2.mDk.setText(R.string.reply_post);
            } else {
                aVar2.mDk.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.eNx != null) {
                        e.this.a(aVar3);
                        if (aVar3.is_floor == 1) {
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(e.this.eNx.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            e.this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                            return;
                        }
                        PbActivityConfig createNormalCfg = new PbActivityConfig(e.this.eNx.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                        createNormalCfg.setStartFrom(8);
                        createNormalCfg.setSortType(0);
                        e.this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    }
                }
            });
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            com.baidu.tbadk.r.a.a(this.eNx, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.hKL = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        ar dY = new ar("c12405").dY("fname", aVar.fname).dY("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.hKL > 0) {
            dY.al("tab_id", this.hKL);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.mCG == 1) {
                dY.w("pid", aVar.pid);
            } else {
                dY.w("tid", aVar.tid);
            }
        }
        TiebaStatic.log(dY);
    }

    /* loaded from: classes24.dex */
    private static class a {
        TextView hLw;
        TextView mDi;
        TextView mDj;
        TextView mDk;
        TextView mDl;

        private a() {
        }
    }
}
