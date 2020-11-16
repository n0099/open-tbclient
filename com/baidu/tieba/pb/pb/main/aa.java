package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class aa extends af.a implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c ajZ;
    public int ajv;
    private TextView etx;
    private TbImageView jDa;
    private View jDf;
    private BdUniqueId jDp;
    private TextView jRA;
    private z lwC;
    private View lwD;
    private DynamicUserLikeButton lwE;
    private TextView lwF;
    private TextView lwG;
    private View lwH;
    private View lwI;
    private NEGFeedBackView lwJ;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ajv = 3;
        this.pageContext = tbPageContext;
        this.jDp = bdUniqueId;
        if (view != null) {
            this.jDf = view.findViewById(R.id.rootLayout);
            this.lwD = view.findViewById(R.id.top_divider_line);
            this.etx = (TextView) view.findViewById(R.id.titleView);
            this.lwE = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lwF = (TextView) view.findViewById(R.id.alaStateView);
            this.jDa = (TbImageView) view.findViewById(R.id.coverView);
            this.jRA = (TextView) view.findViewById(R.id.descView);
            this.lwG = (TextView) view.findViewById(R.id.hotView);
            this.lwH = view.findViewById(R.id.hotPoint);
            this.lwI = view.findViewById(R.id.bottomSpaceView);
            this.lwE.setTextSize(R.dimen.tbds28);
            this.jDa.setPlaceHolder(2);
            this.jDa.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jDa.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.lwC = zVar;
            this.jDf.setOnClickListener(this);
            this.jDa.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.lwF.setVisibility(0);
            } else {
                this.lwF.setVisibility(8);
            }
            this.jRA.setText(zVar.description);
            this.etx.setText(String.format(this.etx.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.au.getFixedText(zVar.userName, 7, true)));
            this.lwG.setText(String.format(this.lwG.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(zVar.lwy)));
            this.lwI.setVisibility(zVar.lwA ? 8 : 0);
            b(zVar.lwB);
            dkL();
        }
    }

    private void b(com.baidu.tbadk.core.data.as asVar) {
        if (this.pageContext != null) {
            if (asVar == null) {
                if (this.lwJ != null) {
                    this.lwJ.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lwJ == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lwJ = new NEGFeedBackView(this.pageContext);
                this.lwJ.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.jDf.findViewById(R.id.contentLayout)).addView(this.lwJ, layoutParams);
                this.lwJ.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.as asVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").ak("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.as asVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.as asVar2) {
                    }
                });
            }
            this.lwJ.setVisibility(0);
            this.lwJ.setData(asVar);
            this.lwJ.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.ajv != i) {
            com.baidu.tbadk.core.util.ap.b(this.jDf, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lwD, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jRA, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.etx, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwG, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwF, R.color.CAM_X0101, 1, i);
            if (this.lwJ != null) {
                this.lwJ.onChangeSkinType();
            }
            this.lwH.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aP(com.baidu.adp.lib.util.l.getDimens(this.lwH.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lwF.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.brc().pF(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).ae(dimens).af(dimens).bn(this.lwF);
            this.lwE.onChangeSkinType(i);
        }
        this.ajv = i;
    }

    private void dkL() {
        if (this.lwC == null || this.lwC.eDc == null) {
            this.lwE.setVisibility(8);
            return;
        }
        this.lwE.setVisibility(0);
        if (this.ajZ == null) {
            this.ajZ = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lwE);
            this.ajZ.l(this.jDp);
        }
        this.ajZ.a(this.lwC.eDc);
        this.lwE.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cz(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.lwC != null && aa.this.lwC.eDc != null) {
                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13718").dR("fid", aa.this.pbData.getForum().getId()).dR("fname", aa.this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", aa.this.pbData.getThreadId());
                    if (aa.this.lwC.eDc != null) {
                        str = aa.this.lwC.eDc.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dR.dR("friend_uid", str).ak("obj_type", aa.this.lwC.eDc.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lwC != null && id == R.id.rootLayout) {
            b(this.lwC);
            c(this.lwC);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                eC(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jDf.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eC(String str, String str2) {
        bf.bqF().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13709").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", zVar.eDc != null ? zVar.eDc.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lwC != null && !this.lwC.lwz) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13708").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lwC.eDc != null ? this.lwC.eDc.getUserId() : ""));
            this.lwC.lwz = true;
        }
    }
}
