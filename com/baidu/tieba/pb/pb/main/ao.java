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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.f;
import java.util.Locale;
/* loaded from: classes2.dex */
public class ao extends k<ForumData, a> implements View.OnClickListener {
    private ForumData fEc;
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
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.view_main_thread_forum_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, ForumData forumData, a aVar) {
        if (forumData == null || aVar == null || StringUtils.isNull(forumData.getName())) {
            return null;
        }
        this.fEc = forumData;
        aVar.fEg.setText(String.format(Locale.CHINA, this.mContext.getString(f.j.forum_number), com.baidu.tbadk.core.util.ap.H(forumData.getPost_num())));
        aVar.fEf.setText(String.format(Locale.CHINA, this.mContext.getString(f.j.attention_number), com.baidu.tbadk.core.util.ap.H(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.cTP.setText(com.baidu.tbadk.core.util.ap.d(this.fEc.getName(), 14, "...") + this.fxm.getString(f.j.forum));
        aVar.fEe.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13006").ae(ImageViewerConfig.FORUM_ID, forumData.getId()).ae("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.am.h(aVar.cTP, f.d.cp_cont_b);
            com.baidu.tbadk.core.util.am.h(aVar.fEf, f.d.cp_cont_j);
            com.baidu.tbadk.core.util.am.h(aVar.fEg, f.d.cp_cont_j);
            com.baidu.tbadk.core.util.am.j(aVar.eSf, f.d.cp_bg_line_e);
            com.baidu.tbadk.core.util.am.c(aVar.fEd, f.C0146f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fEc != null) {
            com.baidu.tbadk.core.util.an ae = new com.baidu.tbadk.core.util.an("c13007").ae(ImageViewerConfig.FORUM_ID, this.fEc.getId()).ae("tid", this.mThreadId);
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                ae.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(ae);
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fxm).createNormalCfg(this.fEc.getName(), FrsActivityConfig.FRS_FROM_PB).setCallFrom(2)));
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends q.a {
        TextView cTP;
        RelativeLayout eSf;
        ImageView fEd;
        BarImageView fEe;
        TextView fEf;
        TextView fEg;

        a(View view) {
            super(view);
            this.cTP = (TextView) view.findViewById(f.g.pb_forum_name);
            this.fEd = (ImageView) view.findViewById(f.g.pb_goto_forum);
            this.fEe = (BarImageView) view.findViewById(f.g.pb_forum_image);
            this.fEf = (TextView) view.findViewById(f.g.pb_forum_attention);
            this.fEg = (TextView) view.findViewById(f.g.pb_forum_thread_num);
            this.eSf = (RelativeLayout) view.findViewById(f.g.pb_forum_root);
        }
    }
}
