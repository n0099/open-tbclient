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
    private TbPageContext efn;
    View.OnClickListener erD;
    public TextView kJA;
    public TextView kJB;
    public TbImageView kJC;
    public TextView kJD;
    public TextView kJE;
    public TextView kJF;
    public TextView kJG;
    public TbImageView kJH;
    public LinearLayout kJI;
    private com.baidu.tbadk.core.data.az kJJ;
    private a kJy;

    /* loaded from: classes16.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.az azVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.erD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ar.this.efn.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.kJJ != null && !StringUtils.isNull(ar.this.kJJ.dXK)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.efn.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.kJy != null) {
                        ar.this.kJy.a(ar.this.kJJ);
                    }
                    if (view2 == ar.this.kJG) {
                        String str = ar.this.kJJ.dXK;
                        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                        auVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.efn.getPageActivity());
                        auVar.dXK = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").ai("obj_source", 6).dD("obj_locate", "0").dD("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dD("obj_id", ar.this.kJJ.dXK).dD("obj_locate", "3"));
                    } else if (view2 == ar.this.kJI) {
                        ar.this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.efn.getPageActivity(), ar.this.kJJ.dXK)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dD("obj_id", ar.this.kJJ.dXK).dD("obj_locate", "1"));
                    } else if (view2 == ar.this.kJB && !StringUtils.isNull(ar.this.kJJ.dZu)) {
                        com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.efn.getPageActivity()), new String[]{ar.this.kJJ.dZu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dD("obj_id", ar.this.kJJ.dXK).dD("obj_locate", "2"));
                    }
                }
            }
        };
        this.efn = tbPageContext;
        this.kJy = aVar;
        this.kJA = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.kJB = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.kJC = (TbImageView) view.findViewById(R.id.novel_cover);
        this.kJD = (TextView) view.findViewById(R.id.novel_title);
        this.kJE = (TextView) view.findViewById(R.id.novel_author);
        this.kJF = (TextView) view.findViewById(R.id.novel_read_number);
        this.kJG = (TextView) view.findViewById(R.id.novel_read_btn);
        this.kJI = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.kJH = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.kJH.setDefaultResource(R.drawable.transparent_bg);
        this.kJH.setDefaultBgResource(R.drawable.transparent_bg);
        this.kJH.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.kJG.setOnClickListener(this.erD);
        this.kJI.setOnClickListener(this.erD);
        this.kJB.setOnClickListener(this.erD);
    }

    public void b(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null) {
            this.kJJ = azVar;
            this.kJA.setText(azVar.dZs);
            this.kJB.setText(azVar.dZt);
            this.kJH.startLoad(azVar.dZx, 10, false);
            this.kJC.startLoad(azVar.dXM, 10, false);
            this.kJG.setText(azVar.dZw);
            this.kJD.setText(azVar.dXL);
            List<String> list = azVar.dZv;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.kJE.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.kJE.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.kJF.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJA, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJB, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJD, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJE, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJF, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJG, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJG, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dD("obj_id", this.kJJ.dXK));
        }
    }
}
