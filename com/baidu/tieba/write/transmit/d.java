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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.likedForum.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
/* loaded from: classes3.dex */
public class d extends com.baidu.adp.widget.ListView.a<e, a> {
    private ArrayList<HotTopicBussinessData> mForumList;
    private List<TransmitForumData> nTw;
    private com.baidu.tieba.likedForum.a nYr;
    private ab nYs;
    private a.InterfaceC0796a nYt;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gc(long j) {
        if (this.nTw == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.nTw) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTg() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, RequestResponseCode.REQUEST_HOT_TOPIC_CHANGE_FOURM, this.mForumList);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData MQ(int i) {
        if (y.isEmpty(this.mForumList)) {
            return null;
        }
        return this.mForumList.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.nYs = new ab() { // from class: com.baidu.tieba.write.transmit.d.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId3, ViewGroup viewGroup, int i, long j) {
                if (!j.isNetWorkAvailable()) {
                    l.showToast(d.this.mContext, R.string.neterror);
                }
                TiebaStatic.log(new ar("c12053"));
                if (!y.isEmpty(d.this.mForumList)) {
                    d.this.dTg();
                    return;
                }
                d.this.nYr = new com.baidu.tieba.likedForum.a(d.this.mPageId);
                d.this.nYr.a(d.this.nYt);
                d.this.nYr.loadData();
            }
        };
        this.nYt = new a.InterfaceC0796a() { // from class: com.baidu.tieba.write.transmit.d.2
            @Override // com.baidu.tieba.likedForum.a.InterfaceC0796a
            public void a(boolean z, int i, String str, List<ForumInfo> list2) {
                ArrayList arrayList = new ArrayList();
                if (y.getCount(list2) > 0) {
                    int size = list2.size();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= size) {
                            break;
                        }
                        ForumInfo forumInfo = list2.get(i3);
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !d.this.gc(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                        i2 = i3 + 1;
                    }
                    if (d.this.mForumList == null) {
                        d.this.mForumList = arrayList;
                        d.this.dTg();
                    }
                }
            }
        };
        a(this.nYs);
        this.nTw = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cQ */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, e eVar, a aVar) {
        ap.setViewTextColor(aVar.nYv, R.color.CAM_X0302);
        ap.setImageResource(aVar.iLD, R.drawable.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends af.a {
        public ImageView iLD;
        public TextView nYv;

        public a(View view) {
            super(view);
            this.nYv = (TextView) view.findViewById(R.id.select_by_self);
            this.iLD = (ImageView) view.findViewById(R.id.add_icon);
        }
    }

    public void destroy() {
        if (this.nYr != null) {
            this.nYr.destroy();
        }
    }
}
