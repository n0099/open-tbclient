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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<n, a> {
    private com.baidu.tieba.likedForum.a biR;
    private ArrayList<HotTopicBussinessData> biS;
    private a.InterfaceC0073a bjn;
    private List<TransmitForumData> gdv;
    private x ghO;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cN(long j) {
        if (this.gdv == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.gdv) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, 25005, this.biS);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData tN(int i) {
        if (z.t(this.biS)) {
            return null;
        }
        return this.biS.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, List<TransmitForumData> list) {
        super(context, bdUniqueId, bdUniqueId2);
        this.ghO = new l(this);
        this.bjn = new m(this);
        setOnAdapterItemClickListener(this.ghO);
        this.gdv = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bE */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(w.j.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, n nVar, a aVar) {
        as.i(aVar.ghQ, w.e.cp_link_tip_a);
        as.c(aVar.ghR, w.g.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends z.a {
        public TextView ghQ;
        public ImageView ghR;

        public a(View view) {
            super(view);
            this.ghQ = (TextView) view.findViewById(w.h.select_by_self);
            this.ghR = (ImageView) view.findViewById(w.h.add_icon);
        }
    }

    public void destroy() {
        if (this.biR != null) {
            this.biR.destroy();
        }
    }
}
