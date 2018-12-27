package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.e;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ao extends k<ForumData, a> implements View.OnClickListener {
    private ForumData gew;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: br */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.view_main_thread_forum_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ForumData forumData, a aVar) {
        if (forumData == null || aVar == null || StringUtils.isNull(forumData.getName())) {
            return null;
        }
        this.gew = forumData;
        aVar.geA.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.forum_number), com.baidu.tbadk.core.util.ao.X(forumData.getPost_num())));
        aVar.gez.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.attention_number), com.baidu.tbadk.core.util.ao.X(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.dst.setText(com.baidu.tbadk.core.util.ao.d(this.gew.getName(), 14, "...") + this.fXM.getString(e.j.forum));
        aVar.gey.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13006").aA(ImageViewerConfig.FORUM_ID, forumData.getId()).aA("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.al.h(aVar.dst, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(aVar.gez, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.h(aVar.geA, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.i(aVar.bSa, e.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.al.c(aVar.gex, e.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gew != null && this.fXM != null) {
            blf();
            this.fXM.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fXM).createNormalCfg(this.gew.getName(), FrsActivityConfig.FRS_FROM_PB).setCallFrom(2)));
        }
    }

    private void blf() {
        if (this.gew != null) {
            com.baidu.tbadk.core.util.am aA = new com.baidu.tbadk.core.util.am("c13007").aA(ImageViewerConfig.FORUM_ID, this.gew.getId()).aA("tid", this.mThreadId);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aA.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aA);
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends q.a {
        View bSa;
        TextView dst;
        TextView geA;
        ImageView gex;
        BarImageView gey;
        TextView gez;

        a(View view) {
            super(view);
            this.dst = (TextView) view.findViewById(e.g.pb_forum_name);
            this.gex = (ImageView) view.findViewById(e.g.pb_goto_forum);
            this.gey = (BarImageView) view.findViewById(e.g.pb_forum_image);
            this.gez = (TextView) view.findViewById(e.g.pb_forum_attention);
            this.geA = (TextView) view.findViewById(e.g.pb_forum_thread_num);
            this.bSa = view.findViewById(e.g.layout_root);
        }
    }
}
