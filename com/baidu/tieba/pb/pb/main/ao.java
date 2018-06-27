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
public class ao extends k<ForumData, a> implements View.OnClickListener {
    private ForumData fDW;
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
        this.fDW = forumData;
        aVar.fEa.setText(String.format(Locale.CHINA, this.mContext.getString(d.k.forum_number), com.baidu.tbadk.core.util.ap.F(forumData.getPost_num())));
        aVar.fDZ.setText(String.format(Locale.CHINA, this.mContext.getString(d.k.attention_number), com.baidu.tbadk.core.util.ap.F(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.cRg.setText(com.baidu.tbadk.core.util.ap.e(this.fDW.getName(), 14, "...") + this.fxh.getString(d.k.forum));
        aVar.fDY.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13006").ah(ImageViewerConfig.FORUM_ID, forumData.getId()).ah("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.am.h(aVar.cRg, d.C0142d.cp_cont_b);
            com.baidu.tbadk.core.util.am.h(aVar.fDZ, d.C0142d.cp_cont_j);
            com.baidu.tbadk.core.util.am.h(aVar.fEa, d.C0142d.cp_cont_j);
            com.baidu.tbadk.core.util.am.j(aVar.eOo, d.C0142d.cp_bg_line_e);
            com.baidu.tbadk.core.util.am.c(aVar.fDX, d.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fDW != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13007").ah(ImageViewerConfig.FORUM_ID, this.fDW.getId()).ah("tid", this.mThreadId));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fxh).createNormalCfg(this.fDW.getName(), FrsActivityConfig.FRS_FROM_PB).setCallFrom(2)));
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends q.a {
        TextView cRg;
        RelativeLayout eOo;
        ImageView fDX;
        BarImageView fDY;
        TextView fDZ;
        TextView fEa;

        a(View view) {
            super(view);
            this.cRg = (TextView) view.findViewById(d.g.pb_forum_name);
            this.fDX = (ImageView) view.findViewById(d.g.pb_goto_forum);
            this.fDY = (BarImageView) view.findViewById(d.g.pb_forum_image);
            this.fDZ = (TextView) view.findViewById(d.g.pb_forum_attention);
            this.fEa = (TextView) view.findViewById(d.g.pb_forum_thread_num);
            this.eOo = (RelativeLayout) view.findViewById(d.g.pb_forum_root);
        }
    }
}
