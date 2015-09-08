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
    private TbImageView aKT;
    private TextView aKU;
    private TextView aKV;
    private TextView aKW;
    private TextView amV;
    private a cCf;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKT = (TbImageView) view.findViewById(i.f.img);
        this.amV = (TextView) view.findViewById(i.f.title);
        View findViewById = view.findViewById(i.f.hot_thread_comment);
        this.aKU = (TextView) findViewById.findViewById(i.f.hot_thread_line_tag);
        this.aKV = (TextView) findViewById.findViewById(i.f.hot_thread_line_praise);
        this.aKW = (TextView) findViewById.findViewById(i.f.hot_thread_line_comment);
        this.cCf = new a(this, null);
        this.aKU.setOnClickListener(this.cCf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(com.baidu.tieba.recommendfrs.data.c cVar) {
        super.B(cVar);
        if (cVar != null && cVar.anJ() != null) {
            Hot_Thread anJ = cVar.anJ();
            String str = (anJ.pics == null || anJ.pics.size() <= 0) ? null : anJ.pics.get(0).small_pic;
            TbImageView tbImageView = this.aKT;
            if (!cVar.anV()) {
                str = null;
            }
            tbImageView.d(str, 10, false);
            this.amV.setText(anJ.title);
            if (StringUtils.isNull(anJ.forum_name)) {
                this.aKU.setVisibility(8);
            } else {
                this.aKU.setVisibility(0);
                String string = getContext().getString(i.h.chosen_pb_original_bar, UtilHelper.getFixedText(anJ.forum_name, 7, false));
                this.cCf.setForumName(string);
                this.aKU.setText(string);
            }
            if (anJ.zan_num != null) {
                this.aKV.setText(aq.o(anJ.zan_num.intValue()));
            }
            if (anJ.reply_num != null) {
                this.aKW.setText(aq.o(anJ.reply_num.intValue()));
            }
            com.baidu.tieba.tbadkCore.util.m readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.lj(String.valueOf(anJ.forum_id))) {
                al.b(this.amV, i.c.cp_cont_d, 1);
            } else {
                al.b(this.amV, i.c.cp_cont_b, 1);
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
            if (aq.aP(this.forumName)) {
                TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
            }
        }
    }
}
