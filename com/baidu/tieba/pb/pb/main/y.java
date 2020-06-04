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
    private View iJP;
    private BdUniqueId icm;
    private TextView ioz;
    private x jNV;
    private DynamicUserLikeButton jNW;
    private TextView jNX;
    private TbImageView jNY;
    private TextView jNZ;
    private View jOa;
    private View jOb;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.e pbData;

    public y(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.agt = 3;
        this.pageContext = tbPageContext;
        this.icm = bdUniqueId;
        if (view != null) {
            this.iJP = view.findViewById(R.id.rootLayout);
            this.dyo = (TextView) view.findViewById(R.id.titleView);
            this.jNW = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.jNX = (TextView) view.findViewById(R.id.alaStateView);
            this.jNY = (TbImageView) view.findViewById(R.id.coverView);
            this.ioz = (TextView) view.findViewById(R.id.descView);
            this.jNZ = (TextView) view.findViewById(R.id.hotView);
            this.jOa = view.findViewById(R.id.hotPoint);
            this.jOb = view.findViewById(R.id.bottomSpaceView);
            this.jNW.setTextSize(R.dimen.tbds28);
            this.jNY.setPlaceHolder(2);
            this.jNY.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jNY.setConrers(15);
        }
    }

    public void a(x xVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.jNV = xVar;
            this.iJP.setOnClickListener(this);
            this.jNY.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.jNX.setVisibility(0);
            } else {
                this.jNX.setVisibility(8);
            }
            this.ioz.setText(xVar.description);
            this.dyo.setText(String.format(this.dyo.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.aq.getFixedText(xVar.userName, 7, true)));
            this.jNZ.setText(String.format(this.jNZ.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.aq.numFormatOverWan(xVar.jNS)));
            this.jOb.setVisibility(xVar.jNU ? 8 : 0);
            cFC();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.agt != i) {
            com.baidu.tbadk.core.util.am.b(this.iJP, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.ioz, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.dyo, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jNZ, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jNX, R.color.cp_cont_a, 1, i);
            this.jOa.setBackgroundDrawable(com.baidu.tbadk.core.util.am.aE(com.baidu.adp.lib.util.l.getDimens(this.jOa.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.am.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jNX.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).Q(dimens).R(dimens).aR(this.jNX);
            this.jNW.onChangeSkinType(i);
        }
        this.agt = i;
    }

    private void cFC() {
        if (this.jNV == null || this.jNV.dFJ == null) {
            this.jNW.setVisibility(8);
            return;
        }
        this.jNW.setVisibility(0);
        if (this.agS == null) {
            this.agS = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.jNW);
            this.agS.l(this.icm);
        }
        this.agS.a(this.jNV.dFJ);
        this.jNW.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bO(View view) {
                String str;
                if (y.this.pbData != null && y.this.pbData.getForum() != null && y.this.jNV != null && y.this.jNV.dFJ != null) {
                    com.baidu.tbadk.core.util.an dh = new com.baidu.tbadk.core.util.an("c13718").dh("fid", y.this.pbData.getForum().getId()).dh("fname", y.this.pbData.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", y.this.pbData.getThreadId());
                    if (y.this.jNV.dFJ != null) {
                        str = y.this.jNV.dFJ.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dh.dh("friend_uid", str).ag("obj_type", y.this.jNV.dFJ.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.jNV != null && id == R.id.rootLayout) {
            b(this.jNV);
            c(this.jNV);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                dN(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iJP.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void dN(String str, String str2) {
        com.baidu.tbadk.core.util.ba.aVa().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13709").dh("fid", this.pbData.getForum().getId()).dh("fname", this.pbData.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", this.pbData.getThreadId()).dh("obj_param1", xVar.dFJ != null ? xVar.dFJ.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.getForum() != null && this.jNV != null && !this.jNV.jNT) {
            this.pbData = eVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13708").dh("fid", eVar.getForum().getId()).dh("fname", eVar.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", eVar.getThreadId()).dh("obj_param1", this.jNV.dFJ != null ? this.jNV.dFJ.getUserId() : ""));
            this.jNV.jNT = true;
        }
    }
}
