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
    private static final int iBG = TbadkCoreApplication.getInst().getListItemRule().amw();
    private TbPageContext<?> mContext;
    private int egx = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int dZ(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= iBG) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - iBG;
        zl(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void zl(int i) {
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.iBJ = (TextView) view.findViewById(R.id.title_text);
            aVar.iBK = (TextView) view.findViewById(R.id.content_text);
            aVar.iBL = (TextView) view.findViewById(R.id.label_text);
            aVar.egY = (TextView) view.findViewById(R.id.user_name);
            aVar.iBM = (TextView) view.findViewById(R.id.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.iBJ.setText(Html.fromHtml(aq.bU(aVar3.title, str)));
            aVar2.iBK.setText(Html.fromHtml(aq.bU(aVar3.content, str)));
            aVar2.egY.setText(aVar3.name_show);
            aVar2.iBM.setText(aq.aD(aVar3.time));
            aVar2.iBL.setVisibility(0);
            if (aVar3.iBg == 1) {
                aVar2.iBL.setText(R.string.floor_text);
            } else if (aVar3.iBh == 1) {
                aVar2.iBL.setText(R.string.reply_post);
            } else {
                aVar2.iBL.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.mContext != null) {
                        e.this.a(aVar3);
                        if (aVar3.iBg == 1) {
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
            am.l(view, R.color.cp_bg_line_d);
            com.baidu.tbadk.s.a.a(this.mContext, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.egx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        an bT = new an("c12405").bT(ImageViewerConfig.FORUM_NAME, aVar.fname).bT("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.egx > 0) {
            bT.P(MyBookrackActivityConfig.TAB_ID, this.egx);
        }
        if (aVar != null) {
            if (aVar.iBg == 1 || aVar.iBh == 1) {
                bT.l(Info.kBaiduPIDKey, aVar.pid);
            } else {
                bT.l("tid", aVar.tid);
            }
        }
        TiebaStatic.log(bT);
    }

    /* loaded from: classes6.dex */
    private static class a {
        TextView egY;
        TextView iBJ;
        TextView iBK;
        TextView iBL;
        TextView iBM;

        private a() {
        }
    }
}
