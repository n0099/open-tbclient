package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class an extends ad.a {
    private TbPageContext dPv;
    public View devider;
    View.OnClickListener ebA;
    private a kkS;
    public TextView kkU;
    public TextView kkV;
    public TbImageView kkW;
    public TextView kkX;
    public TextView kkY;
    public TextView kkZ;
    public TextView kla;
    public TbImageView klb;
    public LinearLayout klc;
    private com.baidu.tbadk.core.data.ax kld;

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ax axVar);
    }

    public an(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.ebA = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.an.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (be.checkUpIsLogin(an.this.dPv.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && an.this.kld != null && !StringUtils.isNull(an.this.kld.dIg)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(an.this.dPv.getPageActivity(), (int) R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (an.this.kkS != null) {
                        an.this.kkS.a(an.this.kld);
                    }
                    if (view2 == an.this.kla) {
                        String str = an.this.kld.dIg;
                        com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
                        asVar.pageContext = (TbPageContext) com.baidu.adp.base.i.G(an.this.dPv.getPageActivity());
                        asVar.dIg = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, asVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11387").ag("obj_source", 6).dk("obj_locate", "0").dk("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11442").dk("obj_id", an.this.kld.dIg).dk("obj_locate", "3"));
                    } else if (view2 == an.this.klc) {
                        an.this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(an.this.dPv.getPageActivity(), an.this.kld.dIg)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11442").dk("obj_id", an.this.kld.dIg).dk("obj_locate", "1"));
                    } else if (view2 == an.this.kkV && !StringUtils.isNull(an.this.kld.dJP)) {
                        bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(an.this.dPv.getPageActivity()), new String[]{an.this.kld.dJP});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11442").dk("obj_id", an.this.kld.dIg).dk("obj_locate", "2"));
                    }
                }
            }
        };
        this.dPv = tbPageContext;
        this.kkS = aVar;
        this.kkU = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.kkV = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.kkW = (TbImageView) view.findViewById(R.id.novel_cover);
        this.kkX = (TextView) view.findViewById(R.id.novel_title);
        this.kkY = (TextView) view.findViewById(R.id.novel_author);
        this.kkZ = (TextView) view.findViewById(R.id.novel_read_number);
        this.kla = (TextView) view.findViewById(R.id.novel_read_btn);
        this.klc = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.klb = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.klb.setDefaultResource(R.drawable.transparent_bg);
        this.klb.setDefaultBgResource(R.drawable.transparent_bg);
        this.klb.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.kla.setOnClickListener(this.ebA);
        this.klc.setOnClickListener(this.ebA);
        this.kkV.setOnClickListener(this.ebA);
    }

    public void b(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null) {
            this.kld = axVar;
            this.kkU.setText(axVar.dJN);
            this.kkV.setText(axVar.dJO);
            this.klb.startLoad(axVar.dJS, 10, false);
            this.kkW.startLoad(axVar.dIi, 10, false);
            this.kla.setText(axVar.dJR);
            this.kkX.setText(axVar.dIh);
            List<String> list = axVar.dJQ;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.kkY.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.kkY.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.kkZ.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kkU, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kkV, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kkX, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kkY, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kkZ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kla, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.an.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.an.setBackgroundResource(this.kla, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11441").dk("obj_id", this.kld.dIg));
        }
    }
}
