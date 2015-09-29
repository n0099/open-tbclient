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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.p;
import tbclient.FineFrsPage.Hot_Thread;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<com.baidu.tieba.recommendfrs.data.c, com.baidu.tbadk.mvc.d.b> {
    private TbImageView aJL;
    private TextView aJM;
    private TextView aJN;
    private TextView aJO;
    private TextView alt;
    private a cJg;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJL = (TbImageView) view.findViewById(i.f.img);
        this.alt = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJM = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJN = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJO = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.cJg = new a(this, null);
        this.aJM.setOnClickListener(this.cJg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqb() != null) {
            Hot_Thread aqb = cVar.aqb();
            String str = (aqb.pics == null || aqb.pics.size() <= 0) ? null : aqb.pics.get(0).small_pic;
            TbImageView tbImageView = this.aJL;
            if (!cVar.aqn()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.alt.setText(aqb.title);
            if (StringUtils.isNull(aqb.forum_name)) {
                this.aJM.setVisibility(8);
            } else {
                this.aJM.setVisibility(0);
                String string = getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqb.forum_name, 7, false));
                this.cJg.setForumName(string);
                this.aJM.setText(string);
            }
            if (aqb.zan_num != null) {
                this.aJN.setText(ar.s(aqb.zan_num.intValue()));
            }
            if (aqb.reply_num != null) {
                this.aJO.setText(ar.s(aqb.reply_num.intValue()));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lI(String.valueOf(aqb.forum_id))) {
                am.b(this.alt, i.c.cp_cont_d, 1);
            } else {
                am.b(this.alt, i.c.cp_cont_b, 1);
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
            if (ar.aP(this.forumName)) {
                TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }
}
