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
/* loaded from: classes22.dex */
public class ar extends af.a {
    public View devider;
    private TbPageContext eIc;
    View.OnClickListener eUh;
    public TextView lAa;
    public TbImageView lAb;
    public LinearLayout lAc;
    private com.baidu.tbadk.core.data.az lAd;
    private a lzS;
    public TextView lzU;
    public TextView lzV;
    public TbImageView lzW;
    public TextView lzX;
    public TextView lzY;
    public TextView lzZ;

    /* loaded from: classes22.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.az azVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.eUh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ar.this.eIc.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.lAd != null && !StringUtils.isNull(ar.this.lAd.eAt)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.eIc.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.lzS != null) {
                        ar.this.lzS.a(ar.this.lAd);
                    }
                    if (view2 == ar.this.lAa) {
                        String str = ar.this.lAd.eAt;
                        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                        auVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.eIc.getPageActivity());
                        auVar.eAt = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").al("obj_source", 6).dR("obj_locate", "0").dR("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dR("obj_id", ar.this.lAd.eAt).dR("obj_locate", "3"));
                    } else if (view2 == ar.this.lAc) {
                        ar.this.eIc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.eIc.getPageActivity(), ar.this.lAd.eAt)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dR("obj_id", ar.this.lAd.eAt).dR("obj_locate", "1"));
                    } else if (view2 == ar.this.lzV && !StringUtils.isNull(ar.this.lAd.eCd)) {
                        com.baidu.tbadk.core.util.be.brr().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.eIc.getPageActivity()), new String[]{ar.this.lAd.eCd});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dR("obj_id", ar.this.lAd.eAt).dR("obj_locate", "2"));
                    }
                }
            }
        };
        this.eIc = tbPageContext;
        this.lzS = aVar;
        this.lzU = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lzV = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lzW = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lzX = (TextView) view.findViewById(R.id.novel_title);
        this.lzY = (TextView) view.findViewById(R.id.novel_author);
        this.lzZ = (TextView) view.findViewById(R.id.novel_read_number);
        this.lAa = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lAc = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lAb = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lAb.setDefaultResource(R.drawable.transparent_bg);
        this.lAb.setDefaultBgResource(R.drawable.transparent_bg);
        this.lAb.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lAa.setOnClickListener(this.eUh);
        this.lAc.setOnClickListener(this.eUh);
        this.lzV.setOnClickListener(this.eUh);
    }

    public void b(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null) {
            this.lAd = azVar;
            this.lzU.setText(azVar.eCb);
            this.lzV.setText(azVar.eCc);
            this.lAb.startLoad(azVar.eCg, 10, false);
            this.lzW.startLoad(azVar.eAv, 10, false);
            this.lAa.setText(azVar.eCf);
            this.lzX.setText(azVar.eAu);
            List<String> list = azVar.eCe;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lzY.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lzY.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lzZ.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzU, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzV, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzX, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzY, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzZ, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lAa, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lAa, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dR("obj_id", this.lAd.eAt));
        }
    }
}
