package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class ag extends y.a {
    View.OnClickListener dFV;
    public View devider;
    private TbPageContext duG;
    private a jyD;
    public TextView jyF;
    public TextView jyG;
    public TbImageView jyH;
    public TextView jyI;
    public TextView jyJ;
    public TextView jyK;
    public TextView jyL;
    public TbImageView jyM;
    public LinearLayout jyN;
    private at jyO;

    /* loaded from: classes9.dex */
    public interface a {
        void a(at atVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dFV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.duG.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ag.this.jyO != null && !StringUtils.isNull(ag.this.jyO.dnG)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ag.this.duG.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ag.this.jyD != null) {
                        ag.this.jyD.a(ag.this.jyO);
                    }
                    if (view2 == ag.this.jyL) {
                        String str = ag.this.jyO.dnG;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.T(ag.this.duG.getPageActivity());
                        aoVar.dnG = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").af("obj_source", 6).cI("obj_locate", "0").cI("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cI("obj_id", ag.this.jyO.dnG).cI("obj_locate", "3"));
                    } else if (view2 == ag.this.jyN) {
                        ag.this.duG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ag.this.duG.getPageActivity(), ag.this.jyO.dnG)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cI("obj_id", ag.this.jyO.dnG).cI("obj_locate", "1"));
                    } else if (view2 == ag.this.jyG && !StringUtils.isNull(ag.this.jyO.dpr)) {
                        ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ag.this.duG.getPageActivity()), new String[]{ag.this.jyO.dpr});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cI("obj_id", ag.this.jyO.dnG).cI("obj_locate", "2"));
                    }
                }
            }
        };
        this.duG = tbPageContext;
        this.jyD = aVar;
        this.jyF = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.jyG = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.jyH = (TbImageView) view.findViewById(R.id.novel_cover);
        this.jyI = (TextView) view.findViewById(R.id.novel_title);
        this.jyJ = (TextView) view.findViewById(R.id.novel_author);
        this.jyK = (TextView) view.findViewById(R.id.novel_read_number);
        this.jyL = (TextView) view.findViewById(R.id.novel_read_btn);
        this.jyN = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.jyM = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.jyM.setDefaultResource(R.drawable.transparent_bg);
        this.jyM.setDefaultBgResource(R.drawable.transparent_bg);
        this.jyM.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.jyL.setOnClickListener(this.dFV);
        this.jyN.setOnClickListener(this.dFV);
        this.jyG.setOnClickListener(this.dFV);
    }

    public void b(at atVar) {
        if (atVar != null) {
            this.jyO = atVar;
            this.jyF.setText(atVar.dpp);
            this.jyG.setText(atVar.dpq);
            this.jyM.startLoad(atVar.dpu, 10, false);
            this.jyH.startLoad(atVar.dnI, 10, false);
            this.jyL.setText(atVar.dpt);
            this.jyI.setText(atVar.dnH);
            List<String> list = atVar.dps;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.jyJ.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.jyJ.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.jyK.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyF, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyG, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyI, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyJ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyK, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jyL, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyL, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cI("obj_id", this.jyO.dnG));
        }
    }
}
