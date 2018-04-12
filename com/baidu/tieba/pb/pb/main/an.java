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
    private ForumData fnx;
    private String mThreadId;

    /* JADX INFO: Access modifiers changed from: protected */
    public an(PbActivity pbActivity, BdUniqueId bdUniqueId) {
        super(pbActivity, bdUniqueId);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bs */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.view_main_thread_forum_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.main.k, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ForumData forumData, a aVar) {
        if (forumData == null || aVar == null || StringUtils.isNull(forumData.getName())) {
            return null;
        }
        this.fnx = forumData;
        aVar.fnB.setText(String.format(Locale.CHINA, this.mContext.getString(d.k.forum_number), com.baidu.tbadk.core.util.an.B(forumData.getPost_num())));
        aVar.fnA.setText(String.format(Locale.CHINA, this.mContext.getString(d.k.attention_number), com.baidu.tbadk.core.util.an.B(forumData.getMember_num())));
        aVar.getView().setOnClickListener(this);
        aVar.cIW.setText(com.baidu.tbadk.core.util.an.e(this.fnx.getName(), 14, "...") + this.fgM.getString(d.k.forum));
        aVar.fnz.startLoad(forumData.getImage_url(), 10, false);
        a(aVar);
        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c13006").ac(ImageViewerConfig.FORUM_ID, forumData.getId()).ac("tid", this.mThreadId));
        return aVar.getView();
    }

    private void a(a aVar) {
        if (aVar != null) {
            com.baidu.tbadk.core.util.ak.h(aVar.cIW, d.C0126d.cp_cont_b);
            com.baidu.tbadk.core.util.ak.h(aVar.fnA, d.C0126d.cp_cont_j);
            com.baidu.tbadk.core.util.ak.h(aVar.fnB, d.C0126d.cp_cont_j);
            com.baidu.tbadk.core.util.ak.j(aVar.exY, d.C0126d.cp_bg_line_e);
            com.baidu.tbadk.core.util.ak.c(aVar.fny, d.f.icon_arrow12_gray60_right);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fnx != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c13007").ac(ImageViewerConfig.FORUM_ID, this.fnx.getId()).ac("tid", this.mThreadId));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.fgM).createNormalCfg(this.fnx.getName(), FrsActivityConfig.FRS_FROM_PB)));
        }
    }

    public void setThreadId(String str) {
        this.mThreadId = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends q.a {
        TextView cIW;
        RelativeLayout exY;
        TextView fnA;
        TextView fnB;
        ImageView fny;
        BarImageView fnz;

        a(View view2) {
            super(view2);
            this.cIW = (TextView) view2.findViewById(d.g.pb_forum_name);
            this.fny = (ImageView) view2.findViewById(d.g.pb_goto_forum);
            this.fnz = (BarImageView) view2.findViewById(d.g.pb_forum_image);
            this.fnA = (TextView) view2.findViewById(d.g.pb_forum_attention);
            this.fnB = (TextView) view2.findViewById(d.g.pb_forum_thread_num);
            this.exY = (RelativeLayout) view2.findViewById(d.g.pb_forum_root);
        }
    }
}
