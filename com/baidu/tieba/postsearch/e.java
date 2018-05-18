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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final int fUB = TbadkCoreApplication.getInst().getListItemRule().yD();
    private TbPageContext<?> mContext;
    private int bXL = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int de(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= fUB) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - fUB;
        rA(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void rA(int i) {
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.fUE = (TextView) view2.findViewById(d.g.title_text);
            aVar.fUF = (TextView) view2.findViewById(d.g.content_text);
            aVar.fUG = (TextView) view2.findViewById(d.g.label_text);
            aVar.bYm = (TextView) view2.findViewById(d.g.user_name);
            aVar.fUH = (TextView) view2.findViewById(d.g.time_text);
            view2.setTag(aVar);
        }
        a aVar2 = (a) view2.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.fUE.setText(Html.fromHtml(an.ad(aVar3.title, str)));
            aVar2.fUF.setText(Html.fromHtml(an.ad(aVar3.content, str)));
            aVar2.bYm.setText(aVar3.name_show);
            aVar2.fUH.setText(an.s(aVar3.time));
            aVar2.fUG.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.fUG.setText(d.k.floor_text);
            } else if (aVar3.fUc == 1) {
                aVar2.fUG.setText(d.k.reply_post);
            } else {
                aVar2.fUG.setVisibility(8);
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
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
                        e.this.mContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    }
                }
            });
            com.baidu.tbadk.n.a.a(this.mContext, view2);
        }
        return view2;
    }

    public void setTabType(int i) {
        this.bXL = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        al ac = new al("c12405").ac(ImageViewerConfig.FORUM_NAME, aVar.fname).ac("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.bXL > 0) {
            ac.r(MyBookrackActivityConfig.TAB_ID, this.bXL);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.fUc == 1) {
                ac.f(Info.kBaiduPIDKey, aVar.pid);
            } else {
                ac.f("tid", aVar.tid);
            }
        }
        TiebaStatic.log(ac);
    }

    /* loaded from: classes3.dex */
    private static class a {
        TextView bYm;
        TextView fUE;
        TextView fUF;
        TextView fUG;
        TextView fUH;

        private a() {
        }
    }
}
