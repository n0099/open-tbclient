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
    private a lXS;
    public TextView lXU;
    public TextView lXV;
    public TbImageView lXW;
    public TextView lXX;
    public TextView lXY;
    public TextView lXZ;
    public TextView lYa;
    public TbImageView lYb;
    public LinearLayout lYc;
    private bd lYd;

    /* loaded from: classes2.dex */
    public interface a {
        void a(bd bdVar);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.fhT = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(PbRecommendNovelHolder.this.eUY.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && PbRecommendNovelHolder.this.lYd != null && !StringUtils.isNull(PbRecommendNovelHolder.this.lYd.eNa)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(PbRecommendNovelHolder.this.eUY.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (PbRecommendNovelHolder.this.lXS != null) {
                        PbRecommendNovelHolder.this.lXS.a(PbRecommendNovelHolder.this.lYd);
                    }
                    if (view2 == PbRecommendNovelHolder.this.lYa) {
                        String str = PbRecommendNovelHolder.this.lYd.eNa;
                        ay ayVar = new ay();
                        ayVar.pageContext = (TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eUY.getPageActivity());
                        ayVar.eNa = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ayVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11387").ap("obj_source", 6).dR("obj_locate", "0").dR("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.lYd.eNa).dR("obj_locate", "3"));
                    } else if (view2 == PbRecommendNovelHolder.this.lYc) {
                        PbRecommendNovelHolder.this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(PbRecommendNovelHolder.this.eUY.getPageActivity(), PbRecommendNovelHolder.this.lYd.eNa)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.lYd.eNa).dR("obj_locate", "1"));
                    } else if (view2 == PbRecommendNovelHolder.this.lXV && !StringUtils.isNull(PbRecommendNovelHolder.this.lYd.eOL)) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbRecommendNovelHolder.this.eUY.getPageActivity()), new String[]{PbRecommendNovelHolder.this.lYd.eOL});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.lYd.eNa).dR("obj_locate", "2"));
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.lXS = aVar;
        this.lXU = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lXV = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lXW = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lXX = (TextView) view.findViewById(R.id.novel_title);
        this.lXY = (TextView) view.findViewById(R.id.novel_author);
        this.lXZ = (TextView) view.findViewById(R.id.novel_read_number);
        this.lYa = (TextView) view.findViewById(R.id.novel_read_btn);
        this.lYc = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.lYb = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.lYb.setDefaultResource(R.drawable.transparent_bg);
        this.lYb.setDefaultBgResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.lYa.setOnClickListener(this.fhT);
        this.lYc.setOnClickListener(this.fhT);
        this.lXV.setOnClickListener(this.fhT);
    }

    public void b(bd bdVar) {
        if (bdVar != null) {
            this.lYd = bdVar;
            this.lXU.setText(bdVar.eOJ);
            this.lXV.setText(bdVar.eOK);
            this.lYb.startLoad(bdVar.eOO, 10, false);
            this.lXW.startLoad(bdVar.eNc, 10, false);
            this.lYa.setText(bdVar.eON);
            this.lXX.setText(bdVar.eNb);
            List<String> list = bdVar.eOM;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.lXY.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.lXY.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.lXZ.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXU, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXV, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXX, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXY, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXZ, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lYa, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lYa, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11441").dR("obj_id", this.lYd.eNa));
        }
    }
}
