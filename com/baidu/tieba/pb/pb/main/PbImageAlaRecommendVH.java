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
    private com.baidu.tbadk.core.view.userLike.c akK;
    public int akf;
    private TextView eFr;
    private TbImageView jZn;
    private View jZs;
    private BdUniqueId jZy;
    private TextView knN;
    private v lLb;
    private View lLc;
    private DynamicUserLikeButton lLd;
    private TextView lLe;
    private TextView lLf;
    private View lLg;
    private View lLh;
    private NEGFeedBackView lLi;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.akf = 3;
        this.pageContext = tbPageContext;
        this.jZy = bdUniqueId;
        if (view != null) {
            this.jZs = view.findViewById(R.id.rootLayout);
            this.lLc = view.findViewById(R.id.top_divider_line);
            this.eFr = (TextView) view.findViewById(R.id.titleView);
            this.lLd = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lLe = (TextView) view.findViewById(R.id.alaStateView);
            this.jZn = (TbImageView) view.findViewById(R.id.coverView);
            this.knN = (TextView) view.findViewById(R.id.descView);
            this.lLf = (TextView) view.findViewById(R.id.hotView);
            this.lLg = view.findViewById(R.id.hotPoint);
            this.lLh = view.findViewById(R.id.bottomSpaceView);
            this.lLd.setTextSize(R.dimen.tbds28);
            this.jZn.setPlaceHolder(2);
            this.jZn.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jZn.setConrers(15);
        }
    }

    public void a(v vVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (vVar != null) {
            this.lLb = vVar;
            this.jZs.setOnClickListener(this);
            this.jZn.startLoad(vVar.cover, 10, false);
            if (vVar.liveStatus == 1 && vVar.liveId > 0) {
                this.lLe.setVisibility(0);
            } else {
                this.lLe.setVisibility(8);
            }
            this.knN.setText(vVar.description);
            this.eFr.setText(String.format(this.eFr.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(vVar.userName, 7, true)));
            this.lLf.setText(String.format(this.lLf.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(vVar.lKX)));
            this.lLh.setVisibility(vVar.lKZ ? 8 : 0);
            b(vVar.lLa);
            dlV();
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        if (this.pageContext != null) {
            if (atVar == null) {
                if (this.lLi != null) {
                    this.lLi.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lLi == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lLi = new NEGFeedBackView(this.pageContext);
                this.lLi.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.jZs.findViewById(R.id.contentLayout)).addView(this.lLi, layoutParams);
                this.lLi.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.1
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
            this.lLi.setVisibility(0);
            this.lLi.setData(atVar);
            this.lLi.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.akf != i) {
            com.baidu.tbadk.core.util.ao.c(this.jZs, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.lLc, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.knN, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.eFr, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lLf, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lLe, R.color.CAM_X0101, 1, i);
            if (this.lLi != null) {
                this.lLi.onChangeSkinType();
            }
            this.lLg.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aO(com.baidu.adp.lib.util.l.getDimens(this.lLg.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ao.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lLe.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).ag(dimens).ah(dimens).bz(this.lLe);
            this.lLd.onChangeSkinType(i);
        }
        this.akf = i;
    }

    private void dlV() {
        if (this.lLb == null || this.lLb.ePn == null) {
            this.lLd.setVisibility(8);
            return;
        }
        this.lLd.setVisibility(0);
        if (this.akK == null) {
            this.akK = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lLd);
            this.akK.l(this.jZy);
        }
        this.akK.a(this.lLb.ePn);
        this.lLd.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cQ(View view) {
                String str;
                if (PbImageAlaRecommendVH.this.pbData != null && PbImageAlaRecommendVH.this.pbData.getForum() != null && PbImageAlaRecommendVH.this.lLb != null && PbImageAlaRecommendVH.this.lLb.ePn != null) {
                    com.baidu.tbadk.core.util.aq dW = new com.baidu.tbadk.core.util.aq("c13718").dW("fid", PbImageAlaRecommendVH.this.pbData.getForum().getId()).dW("fname", PbImageAlaRecommendVH.this.pbData.getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", PbImageAlaRecommendVH.this.pbData.getThreadId());
                    if (PbImageAlaRecommendVH.this.lLb.ePn != null) {
                        str = PbImageAlaRecommendVH.this.lLb.ePn.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dW.dW("friend_uid", str).an("obj_type", PbImageAlaRecommendVH.this.lLb.ePn.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lLb != null && id == R.id.rootLayout) {
            b(this.lLb);
            c(this.lLb);
        }
    }

    private void b(v vVar) {
        if (vVar != null && vVar.liveStatus == 1) {
            if (vVar.isChushou) {
                eH(vVar.thirdRoomId, vVar.thirdLiveType);
            } else if (vVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = vVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jZs.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eH(String str, String str2) {
        be.bsB().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(v vVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dW("fid", this.pbData.getForum().getId()).dW("fname", this.pbData.getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", this.pbData.getThreadId()).dW("obj_param1", vVar.ePn != null ? vVar.ePn.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lLb != null && !this.lLb.lKY) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dW("fid", fVar.getForum().getId()).dW("fname", fVar.getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", fVar.getThreadId()).dW("obj_param1", this.lLb.ePn != null ? this.lLb.ePn.getUserId() : ""));
            this.lLb.lKY = true;
        }
    }
}
