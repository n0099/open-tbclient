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
    private a ktR;
    public TextView ktT;
    public TextView ktU;
    public TbImageView ktV;
    public TextView ktW;
    public TextView ktX;
    public TextView ktY;
    public TextView ktZ;
    public TbImageView kua;
    public LinearLayout kub;
    private com.baidu.tbadk.core.data.ay kuc;

    /* loaded from: classes16.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.ay ayVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.ehM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bf.checkUpIsLogin(ar.this.dVN.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.kuc != null && !StringUtils.isNull(ar.this.kuc.dOr)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.dVN.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.ktR != null) {
                        ar.this.ktR.a(ar.this.kuc);
                    }
                    if (view2 == ar.this.ktZ) {
                        String str = ar.this.kuc.dOr;
                        com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
                        atVar.pageContext = (TbPageContext) com.baidu.adp.base.i.G(ar.this.dVN.getPageActivity());
                        atVar.dOr = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, atVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11387").ah("obj_source", 6).dn("obj_locate", "0").dn("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11442").dn("obj_id", ar.this.kuc.dOr).dn("obj_locate", "3"));
                    } else if (view2 == ar.this.kub) {
                        ar.this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.dVN.getPageActivity(), ar.this.kuc.dOr)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11442").dn("obj_id", ar.this.kuc.dOr).dn("obj_locate", "1"));
                    } else if (view2 == ar.this.ktU && !StringUtils.isNull(ar.this.kuc.dQb)) {
                        com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ar.this.dVN.getPageActivity()), new String[]{ar.this.kuc.dQb});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11442").dn("obj_id", ar.this.kuc.dOr).dn("obj_locate", "2"));
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.ktR = aVar;
        this.ktT = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.ktU = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.ktV = (TbImageView) view.findViewById(R.id.novel_cover);
        this.ktW = (TextView) view.findViewById(R.id.novel_title);
        this.ktX = (TextView) view.findViewById(R.id.novel_author);
        this.ktY = (TextView) view.findViewById(R.id.novel_read_number);
        this.ktZ = (TextView) view.findViewById(R.id.novel_read_btn);
        this.kub = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.kua = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.kua.setDefaultResource(R.drawable.transparent_bg);
        this.kua.setDefaultBgResource(R.drawable.transparent_bg);
        this.kua.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.ktZ.setOnClickListener(this.ehM);
        this.kub.setOnClickListener(this.ehM);
        this.ktU.setOnClickListener(this.ehM);
    }

    public void b(com.baidu.tbadk.core.data.ay ayVar) {
        if (ayVar != null) {
            this.kuc = ayVar;
            this.ktT.setText(ayVar.dPZ);
            this.ktU.setText(ayVar.dQa);
            this.kua.startLoad(ayVar.dQe, 10, false);
            this.ktV.startLoad(ayVar.dOt, 10, false);
            this.ktZ.setText(ayVar.dQd);
            this.ktW.setText(ayVar.dOs);
            List<String> list = ayVar.dQc;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.ktX.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.ktX.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.ktY.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktT, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktU, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktW, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktX, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktY, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktZ, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktZ, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11441").dn("obj_id", this.kuc.dOr));
        }
    }
}
