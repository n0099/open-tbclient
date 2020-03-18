package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
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
public class ag extends v.a {
    private TbPageContext cVv;
    public View devider;
    View.OnClickListener dgy;
    public TextView iOA;
    public TextView iOB;
    public TextView iOC;
    public TbImageView iOD;
    public LinearLayout iOE;
    private at iOF;
    private a iOu;
    public TextView iOw;
    public TextView iOx;
    public TbImageView iOy;
    public TextView iOz;

    /* loaded from: classes9.dex */
    public interface a {
        void a(at atVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.dgy = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.cVv.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ag.this.iOF != null && !StringUtils.isNull(ag.this.iOF.cOB)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ag.this.cVv.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ag.this.iOu != null) {
                        ag.this.iOu.a(ag.this.iOF);
                    }
                    if (view2 == ag.this.iOC) {
                        String str = ag.this.iOF.cOB;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVv.getPageActivity());
                        aoVar.cOB = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11387").X("obj_source", 6).cx("obj_locate", "0").cx("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cx("obj_id", ag.this.iOF.cOB).cx("obj_locate", "3"));
                    } else if (view2 == ag.this.iOE) {
                        ag.this.cVv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ag.this.cVv.getPageActivity(), ag.this.iOF.cOB)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cx("obj_id", ag.this.iOF.cOB).cx("obj_locate", "1"));
                    } else if (view2 == ag.this.iOx && !StringUtils.isNull(ag.this.iOF.cQl)) {
                        ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cVv.getPageActivity()), new String[]{ag.this.iOF.cQl});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11442").cx("obj_id", ag.this.iOF.cOB).cx("obj_locate", "2"));
                    }
                }
            }
        };
        this.cVv = tbPageContext;
        this.iOu = aVar;
        this.iOw = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.iOx = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.iOy = (TbImageView) view.findViewById(R.id.novel_cover);
        this.iOz = (TextView) view.findViewById(R.id.novel_title);
        this.iOA = (TextView) view.findViewById(R.id.novel_author);
        this.iOB = (TextView) view.findViewById(R.id.novel_read_number);
        this.iOC = (TextView) view.findViewById(R.id.novel_read_btn);
        this.iOE = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.iOD = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.iOD.setDefaultResource(R.drawable.transparent_bg);
        this.iOD.setDefaultBgResource(R.drawable.transparent_bg);
        this.iOD.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.iOC.setOnClickListener(this.dgy);
        this.iOE.setOnClickListener(this.dgy);
        this.iOx.setOnClickListener(this.dgy);
    }

    public void b(at atVar) {
        if (atVar != null) {
            this.iOF = atVar;
            this.iOw.setText(atVar.cQj);
            this.iOx.setText(atVar.cQk);
            this.iOD.startLoad(atVar.cQo, 10, false);
            this.iOy.startLoad(atVar.cOD, 10, false);
            this.iOC.setText(atVar.cQn);
            this.iOz.setText(atVar.cOC);
            List<String> list = atVar.cQm;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.iOA.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.iOA.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.iOB.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOw, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOx, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOz, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOA, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOB, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.iOC, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.am.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOC, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11441").cx("obj_id", this.iOF.cOB));
        }
    }
}
