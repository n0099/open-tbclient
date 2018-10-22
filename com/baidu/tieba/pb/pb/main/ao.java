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
    private ForumData fTo;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
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
        this.fTo = forumData;
        aVar.fTs.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.forum_number), com.baidu.tbadk.core.util.ao.N(forumData.getPost_num())));
        aVar.fTr.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.attention_number), com.baidu.tbadk.core.util.ao.N(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.dhV.setText(com.baidu.tbadk.core.util.ao.d(this.fTo.getName(), 14, "...") + this.fMF.getString(e.j.forum));
        aVar.fTq.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13006").ax(ImageViewerConfig.FORUM_ID, forumData.getId()).ax("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.al.h(aVar.dhV, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(aVar.fTr, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.h(aVar.fTs, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.i(aVar.bNv, e.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.al.c(aVar.fTp, e.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fTo != null && this.fMF != null) {
            bjf();
            this.fMF.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fMF).createNormalCfg(this.fTo.getName(), FrsActivityConfig.FRS_FROM_PB).setCallFrom(2)));
        }
    }

    private void bjf() {
        if (this.fTo != null) {
            com.baidu.tbadk.core.util.am ax = new com.baidu.tbadk.core.util.am("c13007").ax(ImageViewerConfig.FORUM_ID, this.fTo.getId()).ax("tid", this.mThreadId);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ax.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(ax);
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends q.a {
        View bNv;
        TextView dhV;
        ImageView fTp;
        BarImageView fTq;
        TextView fTr;
        TextView fTs;

        a(View view) {
            super(view);
            this.dhV = (TextView) view.findViewById(e.g.pb_forum_name);
            this.fTp = (ImageView) view.findViewById(e.g.pb_goto_forum);
            this.fTq = (BarImageView) view.findViewById(e.g.pb_forum_image);
            this.fTr = (TextView) view.findViewById(e.g.pb_forum_attention);
            this.fTs = (TextView) view.findViewById(e.g.pb_forum_thread_num);
            this.bNv = view.findViewById(e.g.layout_root);
        }
    }
}
