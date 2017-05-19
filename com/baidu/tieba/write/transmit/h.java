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
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<k, a> {
    private com.baidu.tieba.likedForum.a beR;
    private ArrayList<HotTopicBussinessData> beS;
    private a.InterfaceC0070a bfj;
    private List<TransmitForumData> fOR;
    private w fOS;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ct(long j) {
        if (this.fOR == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.fOR) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oe() {
        HotTopicChangeActivityConfig hotTopicChangeActivityConfig = new HotTopicChangeActivityConfig(this.mContext, 25005, this.beS);
        hotTopicChangeActivityConfig.setUseOriginList(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotTopicChangeActivityConfig));
    }

    public HotTopicBussinessData sW(int i) {
        if (x.r(this.beS)) {
            return null;
        }
        return this.beS.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, BdUniqueId bdUniqueId, List<TransmitForumData> list) {
        super(context, bdUniqueId);
        this.fOS = new i(this);
        this.bfj = new j(this);
        setOnAdapterItemClickListener(this.fOS);
        this.fOR = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(w.j.transmit_select_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, a aVar) {
        aq.i(aVar.fOU, w.e.cp_link_tip_a);
        aq.c(aVar.fOV, w.g.icon_post_add_ba_n);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public TextView fOU;
        public ImageView fOV;

        public a(View view) {
            super(view);
            this.fOU = (TextView) view.findViewById(w.h.select_by_self);
            this.fOV = (ImageView) view.findViewById(w.h.add_icon);
        }
    }

    public void destroy() {
        if (this.beR != null) {
            this.beR.destroy();
        }
    }
}
