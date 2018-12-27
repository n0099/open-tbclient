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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private static final int gKr = TbadkCoreApplication.getInst().getListItemRule().GP();
    private TbPageContext<?> mContext;
    private int cDZ = -1;
    private List<b.a> mData = new ArrayList();

    public e(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    public int dB(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= gKr) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - gKr;
        tM(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void tM(int i) {
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.gKu = (TextView) view.findViewById(e.g.title_text);
            aVar.gKv = (TextView) view.findViewById(e.g.content_text);
            aVar.gKw = (TextView) view.findViewById(e.g.label_text);
            aVar.cEA = (TextView) view.findViewById(e.g.user_name);
            aVar.gKx = (TextView) view.findViewById(e.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            aVar2.gKu.setText(Html.fromHtml(ao.aB(aVar3.title, str)));
            aVar2.gKv.setText(Html.fromHtml(ao.aB(aVar3.content, str)));
            aVar2.cEA.setText(aVar3.name_show);
            aVar2.gKx.setText(ao.M(aVar3.time));
            aVar2.gKw.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.gKw.setText(e.j.floor_text);
            } else if (aVar3.gJS == 1) {
                aVar2.gKw.setText(e.j.reply_post);
            } else {
                aVar2.gKw.setVisibility(8);
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
            com.baidu.tbadk.o.a.a(this.mContext, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.cDZ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        am aA = new am("c12405").aA(ImageViewerConfig.FORUM_NAME, aVar.fname).aA("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.cDZ > 0) {
            aA.x(MyBookrackActivityConfig.TAB_ID, this.cDZ);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.gJS == 1) {
                aA.i(Info.kBaiduPIDKey, aVar.pid);
            } else {
                aA.i("tid", aVar.tid);
            }
        }
        TiebaStatic.log(aA);
    }

    /* loaded from: classes3.dex */
    private static class a {
        TextView cEA;
        TextView gKu;
        TextView gKv;
        TextView gKw;
        TextView gKx;

        private a() {
        }
    }
}
