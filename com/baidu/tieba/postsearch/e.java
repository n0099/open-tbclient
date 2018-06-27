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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final int gjQ = TbadkCoreApplication.getInst().getListItemRule().Cv();
    private TbPageContext<?> mContext;
    private int chY = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int dn(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= gjQ) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - gjQ;
        rV(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void rV(int i) {
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.gjT = (TextView) view.findViewById(d.g.title_text);
            aVar.gjU = (TextView) view.findViewById(d.g.content_text);
            aVar.gjV = (TextView) view.findViewById(d.g.label_text);
            aVar.ciA = (TextView) view.findViewById(d.g.user_name);
            aVar.gjW = (TextView) view.findViewById(d.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.gjT.setText(Html.fromHtml(ap.ai(aVar3.title, str)));
            aVar2.gjU.setText(Html.fromHtml(ap.ai(aVar3.content, str)));
            aVar2.ciA.setText(aVar3.name_show);
            aVar2.gjW.setText(ap.w(aVar3.time));
            aVar2.gjV.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.gjV.setText(d.k.floor_text);
            } else if (aVar3.gjr == 1) {
                aVar2.gjV.setText(d.k.reply_post);
            } else {
                aVar2.gjV.setVisibility(8);
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
                        e.this.mContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    }
                }
            });
            com.baidu.tbadk.n.a.a(this.mContext, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.chY = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        an ah = new an("c12405").ah(ImageViewerConfig.FORUM_NAME, aVar.fname).ah("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.chY > 0) {
            ah.r(MyBookrackActivityConfig.TAB_ID, this.chY);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.gjr == 1) {
                ah.f(Info.kBaiduPIDKey, aVar.pid);
            } else {
                ah.f("tid", aVar.tid);
            }
        }
        TiebaStatic.log(ah);
    }

    /* loaded from: classes3.dex */
    private static class a {
        TextView ciA;
        TextView gjT;
        TextView gjU;
        TextView gjV;
        TextView gjW;

        private a() {
        }
    }
}
