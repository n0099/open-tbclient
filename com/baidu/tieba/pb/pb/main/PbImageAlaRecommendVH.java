package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public int akW;
    private com.baidu.tbadk.core.view.userLike.c alC;
    private TextView eKc;
    private TbImageView kdS;
    private View kdX;
    private BdUniqueId ked;
    private TextView kss;
    private v lPG;
    private View lPH;
    private DynamicUserLikeButton lPI;
    private TextView lPJ;
    private TextView lPK;
    private View lPL;
    private View lPM;
    private NEGFeedBackView lPN;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.akW = 3;
        this.pageContext = tbPageContext;
        this.ked = bdUniqueId;
        if (view != null) {
            this.kdX = view.findViewById(R.id.rootLayout);
            this.lPH = view.findViewById(R.id.top_divider_line);
            this.eKc = (TextView) view.findViewById(R.id.titleView);
            this.lPI = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lPJ = (TextView) view.findViewById(R.id.alaStateView);
            this.kdS = (TbImageView) view.findViewById(R.id.coverView);
            this.kss = (TextView) view.findViewById(R.id.descView);
            this.lPK = (TextView) view.findViewById(R.id.hotView);
            this.lPL = view.findViewById(R.id.hotPoint);
            this.lPM = view.findViewById(R.id.bottomSpaceView);
            this.lPI.setTextSize(R.dimen.tbds28);
            this.kdS.setPlaceHolder(2);
            this.kdS.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.kdS.setConrers(15);
        }
    }

    public void a(v vVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (vVar != null) {
            this.lPG = vVar;
            this.kdX.setOnClickListener(this);
            this.kdS.startLoad(vVar.cover, 10, false);
            if (vVar.liveStatus == 1 && vVar.liveId > 0) {
                this.lPJ.setVisibility(0);
            } else {
                this.lPJ.setVisibility(8);
            }
            this.kss.setText(vVar.description);
            this.eKc.setText(String.format(this.eKc.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(vVar.userName, 7, true)));
            this.lPK.setText(String.format(this.lPK.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(vVar.lPC)));
            this.lPM.setVisibility(vVar.lPE ? 8 : 0);
            b(vVar.lPF);
            dpN();
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        if (this.pageContext != null) {
            if (atVar == null) {
                if (this.lPN != null) {
                    this.lPN.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lPN == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lPN = new NEGFeedBackView(this.pageContext);
                this.lPN.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.kdX.findViewById(R.id.contentLayout)).addView(this.lPN, layoutParams);
                this.lPN.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.at atVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").an("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.at atVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.at atVar2) {
                    }
                });
            }
            this.lPN.setVisibility(0);
            this.lPN.setData(atVar);
            this.lPN.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.akW != i) {
            com.baidu.tbadk.core.util.ao.c(this.kdX, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lPH, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kss, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.eKc, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPK, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lPJ, R.color.CAM_X0101, 1, i);
            if (this.lPN != null) {
                this.lPN.onChangeSkinType();
            }
            this.lPL.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aO(com.baidu.adp.lib.util.l.getDimens(this.lPL.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lPJ.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.f.a.bwU().qq(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).ag(dimens).ah(dimens).bz(this.lPJ);
            this.lPI.onChangeSkinType(i);
        }
        this.akW = i;
    }

    private void dpN() {
        if (this.lPG == null || this.lPG.eTY == null) {
            this.lPI.setVisibility(8);
            return;
        }
        this.lPI.setVisibility(0);
        if (this.alC == null) {
            this.alC = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lPI);
            this.alC.l(this.ked);
        }
        this.alC.a(this.lPG.eTY);
        this.lPI.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cQ(View view) {
                String str;
                if (PbImageAlaRecommendVH.this.pbData != null && PbImageAlaRecommendVH.this.pbData.getForum() != null && PbImageAlaRecommendVH.this.lPG != null && PbImageAlaRecommendVH.this.lPG.eTY != null) {
                    com.baidu.tbadk.core.util.aq dX = new com.baidu.tbadk.core.util.aq("c13718").dX("fid", PbImageAlaRecommendVH.this.pbData.getForum().getId()).dX("fname", PbImageAlaRecommendVH.this.pbData.getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", PbImageAlaRecommendVH.this.pbData.getThreadId());
                    if (PbImageAlaRecommendVH.this.lPG.eTY != null) {
                        str = PbImageAlaRecommendVH.this.lPG.eTY.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dX.dX("friend_uid", str).an("obj_type", PbImageAlaRecommendVH.this.lPG.eTY.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lPG != null && id == R.id.rootLayout) {
            b(this.lPG);
            c(this.lPG);
        }
    }

    private void b(v vVar) {
        if (vVar != null && vVar.liveStatus == 1) {
            if (vVar.isChushou) {
                eI(vVar.thirdRoomId, vVar.thirdLiveType);
            } else if (vVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = vVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kdX.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eI(String str, String str2) {
        be.bwu().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(v vVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dX("fid", this.pbData.getForum().getId()).dX("fname", this.pbData.getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", this.pbData.getThreadId()).dX("obj_param1", vVar.eTY != null ? vVar.eTY.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lPG != null && !this.lPG.lPD) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dX("fid", fVar.getForum().getId()).dX("fname", fVar.getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", fVar.getThreadId()).dX("obj_param1", this.lPG.eTY != null ? this.lPG.eTY.getUserId() : ""));
            this.lPG.lPD = true;
        }
    }
}
