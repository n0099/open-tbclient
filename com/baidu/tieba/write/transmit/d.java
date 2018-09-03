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
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.likedForum.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, a> {
    private com.baidu.tieba.likedForum.a bTY;
    private a.InterfaceC0191a bUb;
    private List<TransmitForumData> hsq;
    private n hwu;
    private ArrayList<HotTopicBussinessData> mForumList;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bp(long j) {
        if (this.hsq == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.hsq) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzI() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, 25005, this.mForumList);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData vz(int i) {
        if (w.z(this.mForumList)) {
            return null;
        }
        return this.mForumList.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.hwu = new n() { // from class: com.baidu.tieba.write.transmit.d.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId3, ViewGroup viewGroup, int i, long j) {
                if (!j.jE()) {
                    l.showToast(d.this.mContext, f.j.neterror);
                }
                TiebaStatic.log(new an("c12053"));
                if (!w.z(d.this.mForumList)) {
                    d.this.bzI();
                    return;
                }
                d.this.bTY = new com.baidu.tieba.likedForum.a(d.this.mPageId);
                d.this.bTY.a(d.this.bUb);
                d.this.bTY.JV();
            }
        };
        this.bUb = new a.InterfaceC0191a() { // from class: com.baidu.tieba.write.transmit.d.2
            @Override // com.baidu.tieba.likedForum.a.InterfaceC0191a
            public void a(boolean z, int i, String str, List<ForumInfo> list2) {
                ArrayList arrayList = new ArrayList();
                if (w.y(list2) > 0) {
                    int size = list2.size();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= size) {
                            break;
                        }
                        ForumInfo forumInfo = list2.get(i3);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !d.this.bp(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                        i2 = i3 + 1;
                    }
                    if (d.this.mForumList == null) {
                        d.this.mForumList = arrayList;
                        d.this.bzI();
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hwu);
        this.hsq = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        am.h(aVar.hww, f.d.cp_link_tip_a);
        am.c(aVar.dcb, f.C0146f.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public ImageView dcb;
        public TextView hww;

        public a(View view) {
            super(view);
            this.hww = (TextView) view.findViewById(f.g.select_by_self);
            this.dcb = (ImageView) view.findViewById(f.g.add_icon);
        }
    }

    public void destroy() {
        if (this.bTY != null) {
            this.bTY.destroy();
        }
    }
}
