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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aIQ;
    private TextView aIR;
    private TextView aIS;
    private TextView aIT;
    private TextView alz;
    private a cLb;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aIQ = (TbImageView) view.findViewById(i.f.img);
        this.alz = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aIR = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aIS = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aIT = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.cLb = new a(this, null);
        this.aIR.setOnClickListener(this.cLb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqJ() != null) {
            Hot_Thread aqJ = cVar.aqJ();
            String str = (aqJ.pics == null || aqJ.pics.size() <= 0) ? null : aqJ.pics.get(0).small_pic;
            TbImageView tbImageView = this.aIQ;
            if (!cVar.aqV()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.alz.setText(aqJ.title);
            if (StringUtils.isNull(aqJ.forum_name)) {
                this.aIR.setVisibility(8);
            } else {
                this.aIR.setVisibility(0);
                String string = getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqJ.forum_name, 7, false));
                this.cLb.setForumName(string);
                this.aIR.setText(string);
            }
            if (aqJ.zan_num != null) {
                this.aIS.setText(as.q(aqJ.zan_num.intValue()));
            }
            if (aqJ.reply_num != null) {
                this.aIT.setText(as.q(aqJ.reply_num.intValue()));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lR(String.valueOf(aqJ.forum_id))) {
                an.b(this.alz, i.c.cp_cont_d, 1);
            } else {
                an.b(this.alz, i.c.cp_cont_b, 1);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.h.a.a(tbPageContext, getRootView());
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
            if (as.aN(this.forumName)) {
                TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }
}
