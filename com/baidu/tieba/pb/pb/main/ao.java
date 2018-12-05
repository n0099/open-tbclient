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
    private ForumData gbD;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ao(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bq */
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
        this.gbD = forumData;
        aVar.gbH.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.forum_number), com.baidu.tbadk.core.util.ao.W(forumData.getPost_num())));
        aVar.gbG.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.attention_number), com.baidu.tbadk.core.util.ao.W(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.dpD.setText(com.baidu.tbadk.core.util.ao.d(this.gbD.getName(), 14, "...") + this.fUU.getString(e.j.forum));
        aVar.gbF.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13006").aA(ImageViewerConfig.FORUM_ID, forumData.getId()).aA("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.al.h(aVar.dpD, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(aVar.gbG, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.h(aVar.gbH, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.i(aVar.bRX, e.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.al.c(aVar.gbE, e.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gbD != null && this.fUU != null) {
            bku();
            this.fUU.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fUU).createNormalCfg(this.gbD.getName(), FrsActivityConfig.FRS_FROM_PB).setCallFrom(2)));
        }
    }

    private void bku() {
        if (this.gbD != null) {
            com.baidu.tbadk.core.util.am aA = new com.baidu.tbadk.core.util.am("c13007").aA(ImageViewerConfig.FORUM_ID, this.gbD.getId()).aA("tid", this.mThreadId);
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
        View bRX;
        TextView dpD;
        ImageView gbE;
        BarImageView gbF;
        TextView gbG;
        TextView gbH;

        a(View view) {
            super(view);
            this.dpD = (TextView) view.findViewById(e.g.pb_forum_name);
            this.gbE = (ImageView) view.findViewById(e.g.pb_goto_forum);
            this.gbF = (BarImageView) view.findViewById(e.g.pb_forum_image);
            this.gbG = (TextView) view.findViewById(e.g.pb_forum_attention);
            this.gbH = (TextView) view.findViewById(e.g.pb_forum_thread_num);
            this.bRX = view.findViewById(e.g.layout_root);
        }
    }
}
