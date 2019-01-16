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
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ao extends k<ForumData, a> implements View.OnClickListener {
    private com.baidu.tieba.pb.data.d gcj;
    private ForumData gfz;
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
        this.gfz = forumData;
        this.gfz.locate = i + 1;
        aVar.gfD.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.forum_number), com.baidu.tbadk.core.util.ao.X(forumData.getPost_num())));
        aVar.gfC.setText(String.format(Locale.CHINA, this.mContext.getString(e.j.attention_number), com.baidu.tbadk.core.util.ao.X(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.dtc.setText(com.baidu.tbadk.core.util.ao.d(this.gfz.getName(), 14, "...") + this.fYJ.getString(e.j.forum));
        aVar.gfB.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13006").aB(ImageViewerConfig.FORUM_ID, forumData.getId()).aB("tid", this.mThreadId));
        com.baidu.tieba.pb.c.a.a(this.fYJ.getUniqueId(), this.gcj, (PostData) null, this.gfz.getId(), "f_" + this.gfz.getId(), this.gfz.locate, 3);
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.al.h(aVar.dtc, e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(aVar.gfC, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.h(aVar.gfD, e.d.cp_cont_j);
            com.baidu.tbadk.core.util.al.i(aVar.bSL, e.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.al.c(aVar.gfA, e.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gfz != null && this.fYJ != null) {
            blN();
            this.fYJ.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fYJ).createNormalCfg(this.gfz.getName(), FrsActivityConfig.FRS_FROM_PB).setCallFrom(2)));
        }
    }

    private void blN() {
        if (this.gfz != null) {
            com.baidu.tbadk.core.util.am aB = new com.baidu.tbadk.core.util.am("c13007").aB(ImageViewerConfig.FORUM_ID, this.gfz.getId()).aB("tid", this.mThreadId);
            if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aB.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(aB);
            com.baidu.tieba.pb.c.a.a(this.gcj, (PostData) null, this.gfz.getId(), this.gfz.locate, 3);
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends q.a {
        View bSL;
        TextView dtc;
        ImageView gfA;
        BarImageView gfB;
        TextView gfC;
        TextView gfD;

        a(View view) {
            super(view);
            this.dtc = (TextView) view.findViewById(e.g.pb_forum_name);
            this.gfA = (ImageView) view.findViewById(e.g.pb_goto_forum);
            this.gfB = (BarImageView) view.findViewById(e.g.pb_forum_image);
            this.gfC = (TextView) view.findViewById(e.g.pb_forum_attention);
            this.gfD = (TextView) view.findViewById(e.g.pb_forum_thread_num);
            this.bSL = view.findViewById(e.g.layout_root);
        }
    }

    public void b(com.baidu.tieba.pb.data.d dVar) {
        this.gcj = dVar;
    }
}
