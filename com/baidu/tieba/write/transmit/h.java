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
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<k, a> {
    private com.baidu.tieba.likedForum.a bfT;
    private ArrayList<HotTopicBussinessData> bfU;
    private a.InterfaceC0070a bgl;
    private List<TransmitForumData> fWN;
    private x fWO;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cy(long j) {
        if (this.fWN == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.fWN) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oo() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, 25005, this.bfU);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData tr(int i) {
        if (com.baidu.tbadk.core.util.x.r(this.bfU)) {
            return null;
        }
        return this.bfU.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, BdUniqueId bdUniqueId, List<TransmitForumData> list) {
        super(context, bdUniqueId);
        this.fWO = new i(this);
        this.bgl = new j(this);
        setOnAdapterItemClickListener(this.fWO);
        this.fWN = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bC */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(w.j.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        aq.i(aVar.fWQ, w.e.cp_link_tip_a);
        aq.c(aVar.fWR, w.g.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends z.a {
        public TextView fWQ;
        public ImageView fWR;

        public a(View view) {
            super(view);
            this.fWQ = (TextView) view.findViewById(w.h.select_by_self);
            this.fWR = (ImageView) view.findViewById(w.h.add_icon);
        }
    }

    public void destroy() {
        if (this.bfT != null) {
            this.bfT.destroy();
        }
    }
}
