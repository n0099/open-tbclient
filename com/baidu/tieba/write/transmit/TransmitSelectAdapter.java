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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
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
/* loaded from: classes8.dex */
public class TransmitSelectAdapter extends com.baidu.adp.widget.ListView.a<c, TransmitSelectViewHolder> {
    private ArrayList<HotTopicBussinessData> mForumList;
    private List<TransmitForumData> ocS;
    private com.baidu.tieba.likedForum.a ohl;
    private w ohm;
    private a.InterfaceC0779a ohn;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gh(long j) {
        if (this.ocS == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.ocS) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRz() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, RequestResponseCode.REQUEST_HOT_TOPIC_CHANGE_FOURM, this.mForumList);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData Ls(int i) {
        if (y.isEmpty(this.mForumList)) {
            return null;
        }
        return this.mForumList.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitSelectAdapter(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.ohm = new w() { // from class: com.baidu.tieba.write.transmit.TransmitSelectAdapter.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId3, ViewGroup viewGroup, int i, long j) {
                if (!j.isNetWorkAvailable()) {
                    l.showToast(TransmitSelectAdapter.this.mContext, R.string.neterror);
                }
                TiebaStatic.log(new ar("c12053"));
                if (!y.isEmpty(TransmitSelectAdapter.this.mForumList)) {
                    TransmitSelectAdapter.this.dRz();
                    return;
                }
                TransmitSelectAdapter.this.ohl = new com.baidu.tieba.likedForum.a(TransmitSelectAdapter.this.mPageId);
                TransmitSelectAdapter.this.ohl.a(TransmitSelectAdapter.this.ohn);
                TransmitSelectAdapter.this.ohl.loadData();
            }
        };
        this.ohn = new a.InterfaceC0779a() { // from class: com.baidu.tieba.write.transmit.TransmitSelectAdapter.2
            @Override // com.baidu.tieba.likedForum.a.InterfaceC0779a
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
                        if (forumInfo != null && forumInfo.forum_id != null && !StringUtils.isNull(forumInfo.forum_name) && !TransmitSelectAdapter.this.gh(forumInfo.forum_id.longValue())) {
                            arrayList.add(new HotTopicBussinessData(forumInfo.forum_id.longValue(), forumInfo.forum_name, forumInfo.avatar, null, forumInfo.thread_count.longValue(), 0L, 0L, false, null, 0));
                        }
                        i2 = i3 + 1;
                    }
                    if (TransmitSelectAdapter.this.mForumList == null) {
                        TransmitSelectAdapter.this.mForumList = arrayList;
                        TransmitSelectAdapter.this.dRz();
                    }
                }
            }
        };
        a(this.ohm);
        this.ocS = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: de */
    public TransmitSelectViewHolder e(ViewGroup viewGroup) {
        return new TransmitSelectViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, c cVar, TransmitSelectViewHolder transmitSelectViewHolder) {
        ap.setViewTextColor(transmitSelectViewHolder.ohp, R.color.CAM_X0302);
        ap.setImageResource(transmitSelectViewHolder.iZc, R.drawable.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes8.dex */
    public static class TransmitSelectViewHolder extends TypeAdapter.ViewHolder {
        public ImageView iZc;
        public TextView ohp;

        public TransmitSelectViewHolder(View view) {
            super(view);
            this.ohp = (TextView) view.findViewById(R.id.select_by_self);
            this.iZc = (ImageView) view.findViewById(R.id.add_icon);
        }
    }

    public void destroy() {
        if (this.ohl != null) {
            this.ohl.destroy();
        }
    }
}
