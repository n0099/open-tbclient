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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes16.dex */
public class ar extends ad.a {
    private TbPageContext dVN;
    public View devider;
    View.OnClickListener ehM;
    private a ktT;
    public TextView ktV;
    public TextView ktW;
    public TbImageView ktX;
    public TextView ktY;
    public TextView ktZ;
    public TextView kua;
    public TextView kub;
    public TbImageView kuc;
    public LinearLayout kud;
    private com.baidu.tbadk.core.data.ay kue;

    /* loaded from: classes16.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ay ayVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bf.checkUpIsLogin(ar.this.dVN.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.kue != null && !StringUtils.isNull(ar.this.kue.dOr)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.dVN.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.ktT != null) {
                        ar.this.ktT.a(ar.this.kue);
                    }
                    if (view2 == ar.this.kub) {
                        String str = ar.this.kue.dOr;
                        com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
                        atVar.pageContext = (TbPageContext) com.baidu.adp.base.i.G(ar.this.dVN.getPageActivity());
                        atVar.dOr = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, atVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11387").ah("obj_source", 6).dn("obj_locate", "0").dn("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11442").dn("obj_id", ar.this.kue.dOr).dn("obj_locate", "3"));
                    } else if (view2 == ar.this.kud) {
                        ar.this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.dVN.getPageActivity(), ar.this.kue.dOr)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11442").dn("obj_id", ar.this.kue.dOr).dn("obj_locate", "1"));
                    } else if (view2 == ar.this.ktW && !StringUtils.isNull(ar.this.kue.dQb)) {
                        com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ar.this.dVN.getPageActivity()), new String[]{ar.this.kue.dQb});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11442").dn("obj_id", ar.this.kue.dOr).dn("obj_locate", "2"));
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.ktT = aVar;
        this.ktV = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.ktW = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.ktX = (TbImageView) view.findViewById(R.id.novel_cover);
        this.ktY = (TextView) view.findViewById(R.id.novel_title);
        this.ktZ = (TextView) view.findViewById(R.id.novel_author);
        this.kua = (TextView) view.findViewById(R.id.novel_read_number);
        this.kub = (TextView) view.findViewById(R.id.novel_read_btn);
        this.kud = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.kuc = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.kuc.setDefaultResource(R.drawable.transparent_bg);
        this.kuc.setDefaultBgResource(R.drawable.transparent_bg);
        this.kuc.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.kub.setOnClickListener(this.ehM);
        this.kud.setOnClickListener(this.ehM);
        this.ktW.setOnClickListener(this.ehM);
    }

    public void b(com.baidu.tbadk.core.data.ay ayVar) {
        if (ayVar != null) {
            this.kue = ayVar;
            this.ktV.setText(ayVar.dPZ);
            this.ktW.setText(ayVar.dQa);
            this.kuc.startLoad(ayVar.dQe, 10, false);
            this.ktX.startLoad(ayVar.dOt, 10, false);
            this.kub.setText(ayVar.dQd);
            this.ktY.setText(ayVar.dOs);
            List<String> list = ayVar.dQc;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.ktZ.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.ktZ.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.kua.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktV, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktW, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktY, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktZ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kua, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kub, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.kub, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11441").dn("obj_id", this.kue.dOr));
        }
    }
}
