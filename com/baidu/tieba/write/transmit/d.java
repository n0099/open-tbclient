package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.likedForum.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, a> {
    private com.baidu.tieba.likedForum.a dCj;
    private a.InterfaceC0332a dCm;
    private List<TransmitForumData> jle;
    private s jql;
    private ArrayList<HotTopicBussinessData> mForumList;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ci(long j) {
        if (this.jle == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.jle) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cio() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, 25005, this.mForumList);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData Br(int i) {
        if (v.T(this.mForumList)) {
            return null;
        }
        return this.mForumList.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.jql = new s() { // from class: com.baidu.tieba.write.transmit.d.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId3, ViewGroup viewGroup, int i, long j) {
                if (!j.kY()) {
                    l.showToast(d.this.mContext, d.j.neterror);
                }
                TiebaStatic.log(new am("c12053"));
                if (!v.T(d.this.mForumList)) {
                    d.this.cio();
                    return;
                }
                d.this.dCj = new com.baidu.tieba.likedForum.a(d.this.mPageId);
                d.this.dCj.a(d.this.dCm);
                d.this.dCj.aou();
            }
        };
        this.dCm = new a.InterfaceC0332a() { // from class: com.baidu.tieba.write.transmit.d.2
            @Override // com.baidu.tieba.likedForum.a.InterfaceC0332a
            public void a(boolean z, int i, String str, List<ForumInfo> list2) {
                ArrayList arrayList = new ArrayList();
                if (v.S(list2) > 0) {
                    int size = list2.size();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= size) {
                            break;
                        }
                        ForumInfo forumInfo = list2.get(i3);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !d.this.ci(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                        i2 = i3 + 1;
                    }
                    if (d.this.mForumList == null) {
                        d.this.mForumList = arrayList;
                        d.this.cio();
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.jql);
        this.jle = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        al.j(aVar.jqn, d.C0277d.cp_link_tip_a);
        al.c(aVar.eOr, d.f.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public ImageView eOr;
        public TextView jqn;

        public a(View view) {
            super(view);
            this.jqn = (TextView) view.findViewById(d.g.select_by_self);
            this.eOr = (ImageView) view.findViewById(d.g.add_icon);
        }
    }

    public void destroy() {
        if (this.dCj != null) {
            this.dCj.destroy();
        }
    }
}
