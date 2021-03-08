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
    private TbPageContext eWx;
    View.OnClickListener fjv;
    private a lZU;
    public TextView lZW;
    public TextView lZX;
    public TbImageView lZY;
    public TextView lZZ;
    public TextView maa;
    public TextView mab;
    public TextView mad;
    public TbImageView mae;
    public LinearLayout maf;
    private bd mag;

    /* loaded from: classes2.dex */
    public interface a {
        void a(bd bdVar);
    }

    public PbRecommendNovelHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.fjv = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(PbRecommendNovelHolder.this.eWx.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk() && PbRecommendNovelHolder.this.mag != null && !StringUtils.isNull(PbRecommendNovelHolder.this.mag.eOB)) {
                    if (!TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        com.baidu.adp.lib.util.l.showToast(PbRecommendNovelHolder.this.eWx.getPageActivity(), R.string.book_plugin_not_install_tip);
                        return;
                    }
                    if (PbRecommendNovelHolder.this.lZU != null) {
                        PbRecommendNovelHolder.this.lZU.a(PbRecommendNovelHolder.this.mag);
                    }
                    if (view2 == PbRecommendNovelHolder.this.mad) {
                        String str = PbRecommendNovelHolder.this.mag.eOB;
                        ay ayVar = new ay();
                        ayVar.pageContext = (TbPageContext) com.baidu.adp.base.j.J(PbRecommendNovelHolder.this.eWx.getPageActivity());
                        ayVar.eOB = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ayVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11387").aq("obj_source", 6).dR("obj_locate", "0").dR("obj_param1", str));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.mag.eOB).dR("obj_locate", "3"));
                    } else if (view2 == PbRecommendNovelHolder.this.maf) {
                        PbRecommendNovelHolder.this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(PbRecommendNovelHolder.this.eWx.getPageActivity(), PbRecommendNovelHolder.this.mag.eOB)));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.mag.eOB).dR("obj_locate", "1"));
                    } else if (view2 == PbRecommendNovelHolder.this.lZX && !StringUtils.isNull(PbRecommendNovelHolder.this.mag.eQm)) {
                        bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(PbRecommendNovelHolder.this.eWx.getPageActivity()), new String[]{PbRecommendNovelHolder.this.mag.eQm});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11442").dR("obj_id", PbRecommendNovelHolder.this.mag.eOB).dR("obj_locate", "2"));
                    }
                }
            }
        };
        this.eWx = tbPageContext;
        this.lZU = aVar;
        this.lZW = (TextView) view.findViewById(R.id.textview_recommend_title);
        this.lZX = (TextView) view.findViewById(R.id.textview_recommend_option_btn);
        this.lZY = (TbImageView) view.findViewById(R.id.novel_cover);
        this.lZZ = (TextView) view.findViewById(R.id.novel_title);
        this.maa = (TextView) view.findViewById(R.id.novel_author);
        this.mab = (TextView) view.findViewById(R.id.novel_read_number);
        this.mad = (TextView) view.findViewById(R.id.novel_read_btn);
        this.maf = (LinearLayout) view.findViewById(R.id.novel_recommend_item_layout);
        this.mae = (TbImageView) view.findViewById(R.id.novel_subscription);
        this.mae.setDefaultResource(R.drawable.transparent_bg);
        this.mae.setDefaultBgResource(R.drawable.transparent_bg);
        this.devider = view.findViewById(R.id.recommend_devider);
        this.mad.setOnClickListener(this.fjv);
        this.maf.setOnClickListener(this.fjv);
        this.lZX.setOnClickListener(this.fjv);
    }

    public void b(bd bdVar) {
        if (bdVar != null) {
            this.mag = bdVar;
            this.lZW.setText(bdVar.eQk);
            this.lZX.setText(bdVar.eQl);
            this.mae.startLoad(bdVar.eQp, 10, false);
            this.lZY.startLoad(bdVar.eOD, 10, false);
            this.mad.setText(bdVar.eQo);
            this.lZZ.setText(bdVar.eOC);
            List<String> list = bdVar.eQn;
            if (list != null) {
                switch (list.size()) {
                    case 1:
                        if (list.get(0) != null) {
                            this.maa.setText(list.get(0));
                            break;
                        }
                        break;
                    case 2:
                        if (list.get(0) != null) {
                            this.maa.setText(list.get(0));
                        }
                        if (list.get(1) != null) {
                            this.mab.setText(list.get(1));
                            break;
                        }
                        break;
                }
            }
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZW, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZX, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZZ, R.color.CAM_X0105, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.maa, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mab, R.color.CAM_X0109, 1);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.mad, R.color.CAM_X0302, 1);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.devider, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(this.mad, R.drawable.btn_pb_novel_recommend_read);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11441").dR("obj_id", this.mag.eOB));
        }
    }
}
