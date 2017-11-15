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
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.likedForum.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, a> {
    private a.InterfaceC0104a bsB;
    private com.baidu.tieba.likedForum.a bsy;
    private ArrayList<HotTopicBussinessData> bsz;
    private List<TransmitForumData> gQd;
    private h gUa;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cX(long j) {
        if (this.gQd == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.gQd) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCk() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, 25005, this.bsz);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData vt(int i) {
        if (v.v(this.bsz)) {
            return null;
        }
        return this.bsz.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.gUa = new h() { // from class: com.baidu.tieba.write.transmit.d.1
            @Override // com.baidu.adp.widget.ListView.h
            public void a(View view, f fVar, BdUniqueId bdUniqueId3, ViewGroup viewGroup, int i, long j) {
                if (!j.hh()) {
                    l.showToast(d.this.mContext, d.j.neterror);
                }
                TiebaStatic.log(new ak("c12053"));
                if (!v.v(d.this.bsz)) {
                    d.this.bCk();
                    return;
                }
                d.this.bsy = new com.baidu.tieba.likedForum.a(d.this.mPageId);
                d.this.bsy.a(d.this.bsB);
                d.this.bsy.Fr();
            }
        };
        this.bsB = new a.InterfaceC0104a() { // from class: com.baidu.tieba.write.transmit.d.2
            @Override // com.baidu.tieba.likedForum.a.InterfaceC0104a
            public void a(boolean z, int i, String str, List<ForumInfo> list2) {
                ArrayList arrayList = new ArrayList();
                if (v.u(list2) > 0) {
                    int size = list2.size();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= size) {
                            break;
                        }
                        ForumInfo forumInfo = list2.get(i3);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !d.this.cX(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                        i2 = i3 + 1;
                    }
                    if (d.this.bsz == null) {
                        d.this.bsz = arrayList;
                        d.this.bCk();
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.gUa);
        this.gQd = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bX */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        aj.i(aVar.gUc, d.C0080d.cp_link_tip_a);
        aj.c(aVar.ctf, d.f.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends j.a {
        public ImageView ctf;
        public TextView gUc;

        public a(View view) {
            super(view);
            this.gUc = (TextView) view.findViewById(d.g.select_by_self);
            this.ctf = (ImageView) view.findViewById(d.g.add_icon);
        }
    }

    public void destroy() {
        if (this.bsy != null) {
            this.bsy.destroy();
        }
    }
}
