package com.baidu.tieba.postsearch;

import android.text.Html;
import android.text.Spanned;
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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.postsearch.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private static final int gyL = TbadkCoreApplication.getInst().getListItemRule().FR();
    private TbPageContext<?> aRI;
    private int cGQ = -1;
    private List<b.a> mData = new ArrayList();

    public f(TbPageContext<?> tbPageContext) {
        this.aRI = tbPageContext;
    }

    public int dj(List<b.a> list) {
        if (list == null) {
            return 0;
        }
        int size = this.mData.size() + list.size();
        if (size <= gyL) {
            this.mData.addAll(list);
            return 0;
        }
        int i = size - gyL;
        ue(i);
        this.mData.addAll(list);
        return i;
    }

    public void clear() {
        this.mData.clear();
    }

    private void ue(int i) {
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
            view = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.post_search_list_item, (ViewGroup) null);
            a aVar = new a();
            aVar.gyO = (TextView) view.findViewById(d.g.title_text);
            aVar.gyP = (TextView) view.findViewById(d.g.content_text);
            aVar.gyQ = (TextView) view.findViewById(d.g.label_text);
            aVar.cHr = (TextView) view.findViewById(d.g.user_name);
            aVar.gyR = (TextView) view.findViewById(d.g.time_text);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        final b.a aVar3 = this.mData.get(i);
        if (aVar3 != null) {
            String str = "#e53917";
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                str = "#99260f";
            }
            Spanned fromHtml = Html.fromHtml(am.ac(aVar3.title, str));
            if (aVar3.thread_type == 33) {
                aVar2.gyO.setText(PhotoLiveCardData.getLiveIconTitle(fromHtml));
            } else {
                aVar2.gyO.setText(fromHtml);
            }
            aVar2.gyP.setText(Html.fromHtml(am.ac(aVar3.content, str)));
            aVar2.cHr.setText(aVar3.name_show);
            aVar2.gyR.setText(am.z(aVar3.time));
            aVar2.gyQ.setVisibility(0);
            if (aVar3.is_floor == 1) {
                aVar2.gyQ.setText(d.j.floor_text);
            } else if (aVar3.gym == 1) {
                aVar2.gyQ.setText(d.j.reply_post);
            } else {
                aVar2.gyQ.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.aRI != null) {
                        f.this.a(aVar3);
                        if (aVar3.is_floor == 1) {
                            if (aVar3.thread_type == 33) {
                                f.this.aRI.sendMessage(new CustomMessage(2002001, new PhotoLiveCommentActivityConfig(f.this.aRI.getPageActivity()).createPhotoLiveCommentActivityConfig(aVar3.tid + "", aVar3.pid + "", true)));
                                return;
                            }
                            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(f.this.aRI.getPageActivity()).createSubPbActivityConfig(aVar3.tid + "", aVar3.pid + "", "search_post", true);
                            createSubPbActivityConfig.setKeyPageStartFrom(8);
                            f.this.aRI.sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                        } else if (aVar3.thread_type == 33) {
                            TiebaStatic.log("c10256");
                            f.this.aRI.sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(f.this.aRI.getPageActivity(), String.valueOf(aVar3.tid)).cP(String.valueOf(aVar3.pid)).cQ("search_post").xD()));
                        } else {
                            PbActivityConfig createNormalCfg = new PbActivityConfig(f.this.aRI.getPageActivity()).createNormalCfg(aVar3.tid + "", aVar3.pid + "", "search_post");
                            createNormalCfg.setStartFrom(8);
                            f.this.aRI.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        }
                    }
                }
            });
            com.baidu.tbadk.n.a.a(this.aRI, view);
        }
        return view;
    }

    public void setTabType(int i) {
        this.cGQ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.a aVar) {
        ak ab = new ak("c12405").ab(ImageViewerConfig.FORUM_NAME, aVar.fname).ab("uid", TbadkCoreApplication.getCurrentAccount());
        if (this.cGQ > 0) {
            ab.s(MyBookrackActivityConfig.TAB_ID, this.cGQ);
        }
        if (aVar != null) {
            if (aVar.is_floor == 1 || aVar.gym == 1) {
                ab.f(Info.kBaiduPIDKey, aVar.pid);
            } else {
                ab.f("tid", aVar.tid);
            }
        }
        TiebaStatic.log(ab);
    }

    /* loaded from: classes3.dex */
    private static class a {
        TextView cHr;
        TextView gyO;
        TextView gyP;
        TextView gyQ;
        TextView gyR;

        private a() {
        }
    }
}
