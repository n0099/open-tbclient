package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
/* loaded from: classes9.dex */
public class y extends aa.a implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c agS;
    public int agt;
    private TextView dyo;
    private View iJc;
    private BdUniqueId ibz;
    private TextView inM;
    private x jMP;
    private DynamicUserLikeButton jMQ;
    private TextView jMR;
    private TbImageView jMS;
    private TextView jMT;
    private View jMU;
    private View jMV;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.e pbData;

    public y(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.agt = 3;
        this.pageContext = tbPageContext;
        this.ibz = bdUniqueId;
        if (view != null) {
            this.iJc = view.findViewById(R.id.rootLayout);
            this.dyo = (TextView) view.findViewById(R.id.titleView);
            this.jMQ = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.jMR = (TextView) view.findViewById(R.id.alaStateView);
            this.jMS = (TbImageView) view.findViewById(R.id.coverView);
            this.inM = (TextView) view.findViewById(R.id.descView);
            this.jMT = (TextView) view.findViewById(R.id.hotView);
            this.jMU = view.findViewById(R.id.hotPoint);
            this.jMV = view.findViewById(R.id.bottomSpaceView);
            this.jMQ.setTextSize(R.dimen.tbds28);
            this.jMS.setPlaceHolder(2);
            this.jMS.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jMS.setConrers(15);
        }
    }

    public void a(x xVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.jMP = xVar;
            this.iJc.setOnClickListener(this);
            this.jMS.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.jMR.setVisibility(0);
            } else {
                this.jMR.setVisibility(8);
            }
            this.inM.setText(xVar.description);
            this.dyo.setText(String.format(this.dyo.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.aq.getFixedText(xVar.userName, 7, true)));
            this.jMT.setText(String.format(this.jMT.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.aq.numFormatOverWan(xVar.jMM)));
            this.jMV.setVisibility(xVar.jMO ? 8 : 0);
            cFm();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.agt != i) {
            com.baidu.tbadk.core.util.am.b(this.iJc, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.inM, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.dyo, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jMT, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jMR, R.color.cp_cont_a, 1, i);
            this.jMU.setBackgroundDrawable(com.baidu.tbadk.core.util.am.aE(com.baidu.adp.lib.util.l.getDimens(this.jMU.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.am.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jMR.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).Q(dimens).R(dimens).aR(this.jMR);
            this.jMQ.onChangeSkinType(i);
        }
        this.agt = i;
    }

    private void cFm() {
        if (this.jMP == null || this.jMP.dFJ == null) {
            this.jMQ.setVisibility(8);
            return;
        }
        this.jMQ.setVisibility(0);
        if (this.agS == null) {
            this.agS = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.jMQ);
            this.agS.l(this.ibz);
        }
        this.agS.a(this.jMP.dFJ);
        this.jMQ.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bO(View view) {
                String str;
                if (y.this.pbData != null && y.this.pbData.getForum() != null && y.this.jMP != null && y.this.jMP.dFJ != null) {
                    com.baidu.tbadk.core.util.an dh = new com.baidu.tbadk.core.util.an("c13718").dh("fid", y.this.pbData.getForum().getId()).dh("fname", y.this.pbData.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", y.this.pbData.getThreadId());
                    if (y.this.jMP.dFJ != null) {
                        str = y.this.jMP.dFJ.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dh.dh("friend_uid", str).ag("obj_type", y.this.jMP.dFJ.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.jMP != null && id == R.id.rootLayout) {
            b(this.jMP);
            c(this.jMP);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                dN(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iJc.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void dN(String str, String str2) {
        com.baidu.tbadk.core.util.ba.aUZ().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13709").dh("fid", this.pbData.getForum().getId()).dh("fname", this.pbData.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", this.pbData.getThreadId()).dh("obj_param1", xVar.dFJ != null ? xVar.dFJ.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.getForum() != null && this.jMP != null && !this.jMP.jMN) {
            this.pbData = eVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13708").dh("fid", eVar.getForum().getId()).dh("fname", eVar.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", eVar.getThreadId()).dh("obj_param1", this.jMP.dFJ != null ? this.jMP.dFJ.getUserId() : ""));
            this.jMP.jMN = true;
        }
    }
}
