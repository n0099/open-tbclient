package com.baidu.tieba.pb.pb.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.d;
import java.util.Locale;
/* loaded from: classes2.dex */
public class an extends k<ForumData, a> implements View.OnClickListener {
    private ForumData fzV;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.view_main_thread_forum_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ForumData forumData, a aVar) {
        if (forumData == null || aVar == null || StringUtils.isNull(forumData.getName())) {
            return null;
        }
        this.fzV = forumData;
        aVar.fzZ.setText(String.format(Locale.CHINA, this.mContext.getString(d.k.forum_number), com.baidu.tbadk.core.util.ao.E(forumData.getPost_num())));
        aVar.fzY.setText(String.format(Locale.CHINA, this.mContext.getString(d.k.attention_number), com.baidu.tbadk.core.util.ao.E(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.cTi.setText(com.baidu.tbadk.core.util.ao.e(this.fzV.getName(), 14, "...") + this.ftp.getString(d.k.forum));
        aVar.fzX.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13006").ah(ImageViewerConfig.FORUM_ID, forumData.getId()).ah("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.al.h(aVar.cTi, d.C0141d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h(aVar.fzY, d.C0141d.cp_cont_j);
            com.baidu.tbadk.core.util.al.h(aVar.fzZ, d.C0141d.cp_cont_j);
            com.baidu.tbadk.core.util.al.j(aVar.eKy, d.C0141d.cp_bg_line_e);
            com.baidu.tbadk.core.util.al.c(aVar.fzW, d.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fzV != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c13007").ah(ImageViewerConfig.FORUM_ID, this.fzV.getId()).ah("tid", this.mThreadId));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.ftp).createNormalCfg(this.fzV.getName(), FrsActivityConfig.FRS_FROM_PB)));
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends q.a {
        TextView cTi;
        RelativeLayout eKy;
        ImageView fzW;
        BarImageView fzX;
        TextView fzY;
        TextView fzZ;

        a(View view) {
            super(view);
            this.cTi = (TextView) view.findViewById(d.g.pb_forum_name);
            this.fzW = (ImageView) view.findViewById(d.g.pb_goto_forum);
            this.fzX = (BarImageView) view.findViewById(d.g.pb_forum_image);
            this.fzY = (TextView) view.findViewById(d.g.pb_forum_attention);
            this.fzZ = (TextView) view.findViewById(d.g.pb_forum_thread_num);
            this.eKy = (RelativeLayout) view.findViewById(d.g.pb_forum_root);
        }
    }
}
