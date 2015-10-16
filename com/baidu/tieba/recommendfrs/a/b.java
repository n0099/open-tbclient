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
    private TbImageView aJW;
    private TextView aJX;
    private TextView aJY;
    private TextView aJZ;
    private TextView alu;
    private a cJF;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aJW = (TbImageView) view.findViewById(i.f.img);
        this.alu = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aJX = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aJY = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aJZ = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.cJF = new a(this, null);
        this.aJX.setOnClickListener(this.cJF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.aqh() != null) {
            Hot_Thread aqh = cVar.aqh();
            String str = (aqh.pics == null || aqh.pics.size() <= 0) ? null : aqh.pics.get(0).small_pic;
            TbImageView tbImageView = this.aJW;
            if (!cVar.aqt()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.alu.setText(aqh.title);
            if (StringUtils.isNull(aqh.forum_name)) {
                this.aJX.setVisibility(8);
            } else {
                this.aJX.setVisibility(0);
                String string = getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(aqh.forum_name, 7, false));
                this.cJF.setForumName(string);
                this.aJX.setText(string);
            }
            if (aqh.zan_num != null) {
                this.aJY.setText(as.s(aqh.zan_num.intValue()));
            }
            if (aqh.reply_num != null) {
                this.aJZ.setText(as.s(aqh.reply_num.intValue()));
            }
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lL(String.valueOf(aqh.forum_id))) {
                an.b(this.alu, i.c.cp_cont_d, 1);
            } else {
                an.b(this.alu, i.c.cp_cont_b, 1);
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
            if (as.aP(this.forumName)) {
                TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }
}
