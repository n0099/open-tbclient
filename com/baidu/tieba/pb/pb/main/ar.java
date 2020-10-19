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
    View.OnClickListener eFW;
    private TbPageContext etO;
    public TextView lhA;
    public TbImageView lhB;
    public LinearLayout lhC;
    private com.baidu.tbadk.core.data.az lhD;
    private a lhs;
    public TextView lhu;
    public TextView lhv;
    public TbImageView lhw;
    public TextView lhx;
    public TextView lhy;
    public TextView lhz;

    /* loaded from: classes22.dex */
    public interface a {
        void a(com.baidu.tbadk.core.data.az azVar);
    }

    public ar(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.eFW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ar.this.etO.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && ar.this.lhD != null && !StringUtils.isNull(ar.this.lhD.ema)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(ar.this.etO.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (ar.this.lhs != null) {
                        ar.this.lhs.a(ar.this.lhD);
                    }
                    if (view2 == ar.this.lhA) {
                        String str = ar.this.lhD.ema;
                        com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                        auVar.pageContext = (TbPageContext) com.baidu.adp.base.i.I(ar.this.etO.getPageActivity());
                        auVar.ema = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, auVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11387").aj("obj_source", 6).dK("obj_locate", "0").dK("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dK("obj_id", ar.this.lhD.ema).dK("obj_locate", "3"));
                    } else if (view2 == ar.this.lhC) {
                        ar.this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(ar.this.etO.getPageActivity(), ar.this.lhD.ema)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dK("obj_id", ar.this.lhD.ema).dK("obj_locate", "1"));
                    } else if (view2 == ar.this.lhv && !StringUtils.isNull(ar.this.lhD.enM)) {
                        com.baidu.tbadk.core.util.be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ar.this.etO.getPageActivity()), new String[]{ar.this.lhD.enM});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11442").dK("obj_id", ar.this.lhD.ema).dK("obj_locate", "2"));
                    }
                }
            }
        };
        this.etO = tbPageContext;
        this.lhs = aVar;
        this.lhu = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lhv = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lhw = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lhx = (TextView) view.findViewById(R.id.novel_title);
        this.lhy = (TextView) view.findViewById(R.id.novel_author);
        this.lhz = (TextView) view.findViewById(R.id.novel_read_number);
        this.lhA = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lhC = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lhB = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lhB.setDefaultResource(R.drawable.transparent_bg);
        this.lhB.setDefaultBgResource(R.drawable.transparent_bg);
        this.lhB.setDefaultErrorResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lhA.setOnClickListener(this.eFW);
        this.lhC.setOnClickListener(this.eFW);
        this.lhv.setOnClickListener(this.eFW);
    }

    public void b(com.baidu.tbadk.core.data.az azVar) {
        if (azVar != null) {
            this.lhD = azVar;
            this.lhu.setText(azVar.enK);
            this.lhv.setText(azVar.enL);
            this.lhB.startLoad(azVar.enP, 10, false);
            this.lhw.startLoad(azVar.emc, 10, false);
            this.lhA.setText(azVar.enO);
            this.lhx.setText(azVar.emb);
            List<String> list = azVar.enN;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lhy.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lhy.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lhz.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhu, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhv, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhx, R.color.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhy, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhz, R.color.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhA, R.color.cp_link_tip_a, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lhA, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11441").dK("obj_id", this.lhD.ema));
        }
    }
}
