package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
/* loaded from: classes9.dex */
public class y extends ad.a implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c ahX;
    public int ahx;
    private TextView dDu;
    private TextView iFF;
    private TbImageView iri;
    private View irn;
    private BdUniqueId irt;
    private x khJ;
    private DynamicUserLikeButton khK;
    private TextView khL;
    private TextView khM;
    private View khN;
    private View khO;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.e pbData;

    public y(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ahx = 3;
        this.pageContext = tbPageContext;
        this.irt = bdUniqueId;
        if (view != null) {
            this.irn = view.findViewById(R.id.rootLayout);
            this.dDu = (TextView) view.findViewById(R.id.titleView);
            this.khK = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.khL = (TextView) view.findViewById(R.id.alaStateView);
            this.iri = (TbImageView) view.findViewById(R.id.coverView);
            this.iFF = (TextView) view.findViewById(R.id.descView);
            this.khM = (TextView) view.findViewById(R.id.hotView);
            this.khN = view.findViewById(R.id.hotPoint);
            this.khO = view.findViewById(R.id.bottomSpaceView);
            this.khK.setTextSize(R.dimen.tbds28);
            this.iri.setPlaceHolder(2);
            this.iri.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.iri.setConrers(15);
        }
    }

    public void a(x xVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.khJ = xVar;
            this.irn.setOnClickListener(this);
            this.iri.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.khL.setVisibility(0);
            } else {
                this.khL.setVisibility(8);
            }
            this.iFF.setText(xVar.description);
            this.dDu.setText(String.format(this.dDu.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.ar.getFixedText(xVar.userName, 7, true)));
            this.khM.setText(String.format(this.khM.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.ar.numFormatOverWan(xVar.khG)));
            this.khO.setVisibility(xVar.khI ? 8 : 0);
            cJS();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.ahx != i) {
            com.baidu.tbadk.core.util.an.b(this.irn, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.iFF, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.dDu, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.khM, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.khL, R.color.cp_cont_a, 1, i);
            this.khN.setBackgroundDrawable(com.baidu.tbadk.core.util.an.aG(com.baidu.adp.lib.util.l.getDimens(this.khN.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.an.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.khL.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).S(dimens).T(dimens).aR(this.khL);
            this.khK.onChangeSkinType(i);
        }
        this.ahx = i;
    }

    private void cJS() {
        if (this.khJ == null || this.khJ.dMu == null) {
            this.khK.setVisibility(8);
            return;
        }
        this.khK.setVisibility(0);
        if (this.ahX == null) {
            this.ahX = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.khK);
            this.ahX.l(this.irt);
        }
        this.ahX.a(this.khJ.dMu);
        this.khK.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bR(View view) {
                String str;
                if (y.this.pbData != null && y.this.pbData.getForum() != null && y.this.khJ != null && y.this.khJ.dMu != null) {
                    com.baidu.tbadk.core.util.ao dk = new com.baidu.tbadk.core.util.ao("c13718").dk("fid", y.this.pbData.getForum().getId()).dk("fname", y.this.pbData.getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", y.this.pbData.getThreadId());
                    if (y.this.khJ.dMu != null) {
                        str = y.this.khJ.dMu.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dk.dk("friend_uid", str).ag("obj_type", y.this.khJ.dMu.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.khJ != null && id == R.id.rootLayout) {
            b(this.khJ);
            c(this.khJ);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                dS(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.irn.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void dS(String str, String str2) {
        bc.aWU().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13709").dk("fid", this.pbData.getForum().getId()).dk("fname", this.pbData.getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", this.pbData.getThreadId()).dk("obj_param1", xVar.dMu != null ? xVar.dMu.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.getForum() != null && this.khJ != null && !this.khJ.khH) {
            this.pbData = eVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13708").dk("fid", eVar.getForum().getId()).dk("fname", eVar.getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", eVar.getThreadId()).dk("obj_param1", this.khJ.dMu != null ? this.khJ.dMu.getUserId() : ""));
            this.khJ.khH = true;
        }
    }
}
