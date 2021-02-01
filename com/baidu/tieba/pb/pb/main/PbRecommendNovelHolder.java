package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class PbRecommendNovelHolder extends TypeAdapter.ViewHolder {
    public View devider;
    private TbPageContext eUY;
    View.OnClickListener fhT;
    private a lXD;
    public TextView lXF;
    public TextView lXG;
    public TbImageView lXH;
    public TextView lXI;
    public TextView lXJ;
    public TextView lXK;
    public TextView lXL;
    public TbImageView lXM;
    public LinearLayout lXN;
    private bd lXO;

    /* loaded from: classes2.dex */
    public interface a {
        void a(bd bdVar);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.fhT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(PbRecommendNovelHolder.this.eUY.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && PbRecommendNovelHolder.this.lXO != null && !StringUtils.isNull(PbRecommendNovelHolder.this.lXO.eNa)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(PbRecommendNovelHolder.this.eUY.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (PbRecommendNovelHolder.this.lXD != null) {
                        PbRecommendNovelHolder.this.lXD.a(PbRecommendNovelHolder.this.lXO);
                    }
                    if (view2 == PbRecommendNovelHolder.this.lXL) {
                        String str = PbRecommendNovelHolder.this.lXO.eNa;
                        ay ayVar = new ay();
                        ayVar.pageContext = (TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eUY.getPageActivity());
                        ayVar.eNa = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ayVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11387").ap("obj_source", 6).dR("obj_locate", "0").dR("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.lXO.eNa).dR("obj_locate", "3"));
                    } else if (view2 == PbRecommendNovelHolder.this.lXN) {
                        PbRecommendNovelHolder.this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(PbRecommendNovelHolder.this.eUY.getPageActivity(), PbRecommendNovelHolder.this.lXO.eNa)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.lXO.eNa).dR("obj_locate", "1"));
                    } else if (view2 == PbRecommendNovelHolder.this.lXG && !StringUtils.isNull(PbRecommendNovelHolder.this.lXO.eOL)) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eUY.getPageActivity()), new String[]{PbRecommendNovelHolder.this.lXO.eOL});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.lXO.eNa).dR("obj_locate", "2"));
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.lXD = aVar;
        this.lXF = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lXG = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lXH = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lXI = (TextView) view.findViewById(R.id.novel_title);
        this.lXJ = (TextView) view.findViewById(R.id.novel_author);
        this.lXK = (TextView) view.findViewById(R.id.novel_read_number);
        this.lXL = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lXN = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lXM = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lXM.setDefaultResource(R.drawable.transparent_bg);
        this.lXM.setDefaultBgResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lXL.setOnClickListener(this.fhT);
        this.lXN.setOnClickListener(this.fhT);
        this.lXG.setOnClickListener(this.fhT);
    }

    public void b(bd bdVar) {
        if (bdVar != null) {
            this.lXO = bdVar;
            this.lXF.setText(bdVar.eOJ);
            this.lXG.setText(bdVar.eOK);
            this.lXM.startLoad(bdVar.eOO, 10, false);
            this.lXH.startLoad(bdVar.eNc, 10, false);
            this.lXL.setText(bdVar.eON);
            this.lXI.setText(bdVar.eNb);
            List<String> list = bdVar.eOM;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lXJ.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lXJ.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lXK.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXF, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXG, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXI, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXJ, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXK, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXL, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXL, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11441").dR("obj_id", this.lXO.eNa));
        }
    }
}
