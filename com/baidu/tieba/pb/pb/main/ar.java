package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class ar extends af.a {
    public View devider;
    private TbPageContext efr;
    View.OnClickListener erH;
    private a kJF;
    public TextView kJH;
    public TextView kJI;
    public TbImageView kJJ;
    public TextView kJK;
    public TextView kJL;
    public TextView kJM;
    public TextView kJN;
    public TbImageView kJO;
    public LinearLayout kJP;
    private com.baidu.tbadk.core.data.az kJQ;

    /* loaded from: classes16.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.az azVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.erH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ar.this.efr.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.kJQ != null && !StringUtils.isNull(ar.this.kJQ.dXO)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.efr.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.kJF != null) {
                        ar.this.kJF.a(ar.this.kJQ);
                    }
                    if (view2 == ar.this.kJN) {
                        String str = ar.this.kJQ.dXO;
                        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                        auVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.efr.getPageActivity());
                        auVar.dXO = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").ai("obj_source", 6).dD("obj_locate", "0").dD("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dD("obj_id", ar.this.kJQ.dXO).dD("obj_locate", "3"));
                    } else if (view2 == ar.this.kJP) {
                        ar.this.efr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.efr.getPageActivity(), ar.this.kJQ.dXO)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dD("obj_id", ar.this.kJQ.dXO).dD("obj_locate", "1"));
                    } else if (view2 == ar.this.kJI && !StringUtils.isNull(ar.this.kJQ.dZy)) {
                        com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.efr.getPageActivity()), new String[]{ar.this.kJQ.dZy});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dD("obj_id", ar.this.kJQ.dXO).dD("obj_locate", "2"));
                    }
                }
            }
        };
        this.efr = tbPageContext;
        this.kJF = aVar;
        this.kJH = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.kJI = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.kJJ = (TbImageView) view.findViewById(R.id.novel_cover);
        this.kJK = (TextView) view.findViewById(R.id.novel_title);
        this.kJL = (TextView) view.findViewById(R.id.novel_author);
        this.kJM = (TextView) view.findViewById(R.id.novel_read_number);
        this.kJN = (TextView) view.findViewById(R.id.novel_read_btn);
        this.kJP = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.kJO = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.kJO.setDefaultResource(R.drawable.transparent_bg);
        this.kJO.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJO.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.kJN.setOnClickListener(this.erH);
        this.kJP.setOnClickListener(this.erH);
        this.kJI.setOnClickListener(this.erH);
    }

    public void b(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null) {
            this.kJQ = azVar;
            this.kJH.setText(azVar.dZw);
            this.kJI.setText(azVar.dZx);
            this.kJO.startLoad(azVar.dZB, 10, false);
            this.kJJ.startLoad(azVar.dXQ, 10, false);
            this.kJN.setText(azVar.dZA);
            this.kJK.setText(azVar.dXP);
            List<String> list = azVar.dZz;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.kJL.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.kJL.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.kJM.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJH, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJI, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJK, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJL, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJM, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJN, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJN, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dD("obj_id", this.kJQ.dXO));
        }
    }
}
