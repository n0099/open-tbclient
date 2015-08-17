package com.baidu.tieba.recommendfrs.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aKG;
    private TextView aKH;
    private TextView aKI;
    private TextView aKJ;
    private TextView anH;
    private a ctN;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKG = (TbImageView) view.findViewById(i.f.img);
        this.anH = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKH = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKI = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKJ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.ctN = new a(this, null);
        this.aKH.setOnClickListener(this.ctN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.A(cVar);
        if (cVar != null && cVar.ajD() != null) {
            Hot_Thread ajD = cVar.ajD();
            String str = (ajD.pics == null || ajD.pics.size() <= 0) ? null : ajD.pics.get(0).small_pic;
            TbImageView tbImageView = this.aKG;
            if (!cVar.ajP()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.anH.setText(ajD.title);
            if (StringUtils.isNull(ajD.forum_name)) {
                this.aKH.setVisibility(8);
            } else {
                this.aKH.setVisibility(0);
                String string = getContext().getString(i.C0057i.chosen_pb_original_bar, UtilHelper.getFixedText(ajD.forum_name, 7, false));
                this.ctN.setForumName(string);
                this.aKH.setText(string);
            }
            if (ajD.zan_num != null) {
                this.aKI.setText(aq.o(ajD.zan_num.intValue()));
            }
            if (ajD.reply_num != null) {
                this.aKJ.setText(aq.o(ajD.reply_num.intValue()));
            }
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.kE(String.valueOf(ajD.forum_id))) {
                al.b(this.anH, i.c.cp_cont_d, 1);
            } else {
                al.b(this.anH, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.f.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private String forumName;

        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        public void setForumName(String str) {
            this.forumName = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aq.aP(this.forumName)) {
                TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }
}
