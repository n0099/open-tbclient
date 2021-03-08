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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c alS;
    public int aln;
    private TextView eIY;
    private BdUniqueId kjW;
    private TbImageView kjh;
    private View kjm;
    private TextView kyk;
    private v lWo;
    private View lWp;
    private DynamicUserLikeButton lWq;
    private TextView lWr;
    private TextView lWs;
    private View lWt;
    private View lWu;
    private NEGFeedBackView lWv;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.aln = 3;
        this.pageContext = tbPageContext;
        this.kjW = bdUniqueId;
        if (view != null) {
            this.kjm = view.findViewById(R.id.rootLayout);
            this.lWp = view.findViewById(R.id.top_divider_line);
            this.eIY = (TextView) view.findViewById(R.id.titleView);
            this.lWq = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lWr = (TextView) view.findViewById(R.id.alaStateView);
            this.kjh = (TbImageView) view.findViewById(R.id.coverView);
            this.kyk = (TextView) view.findViewById(R.id.descView);
            this.lWs = (TextView) view.findViewById(R.id.hotView);
            this.lWt = view.findViewById(R.id.hotPoint);
            this.lWu = view.findViewById(R.id.bottomSpaceView);
            this.lWq.setTextSize(R.dimen.tbds28);
            this.kjh.setPlaceHolder(2);
            this.kjh.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.kjh.setConrers(15);
        }
    }

    public void a(v vVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (vVar != null) {
            this.lWo = vVar;
            this.kjm.setOnClickListener(this);
            this.kjh.startLoad(vVar.cover, 10, false);
            if (vVar.liveStatus == 1 && vVar.liveId > 0) {
                this.lWr.setVisibility(0);
            } else {
                this.lWr.setVisibility(8);
            }
            this.kyk.setText(vVar.description);
            this.eIY.setText(String.format(this.eIY.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.au.getFixedText(vVar.userName, 7, true)));
            this.lWs.setText(String.format(this.lWs.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(vVar.lWk)));
            this.lWu.setVisibility(vVar.lWm ? 8 : 0);
            b(vVar.lWn);
            doA();
        }
    }

    private void b(av avVar) {
        if (this.pageContext != null) {
            if (avVar == null) {
                if (this.lWv != null) {
                    this.lWv.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lWv == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lWv = new NEGFeedBackView(this.pageContext);
                this.lWv.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.kjm.findViewById(R.id.contentLayout)).addView(this.lWv, layoutParams);
                this.lWv.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(av avVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").aq("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(av avVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar2) {
                    }
                });
            }
            this.lWv.setVisibility(0);
            this.lWv.setData(avVar);
            this.lWv.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.aln != i) {
            com.baidu.tbadk.core.util.ap.c(this.kjm, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lWp, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kyk, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.eIY, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWs, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWr, R.color.CAM_X0101, 1, i);
            if (this.lWv != null) {
                this.lWv.onChangeSkinType();
            }
            this.lWt.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aL(com.baidu.adp.lib.util.l.getDimens(this.lWt.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lWr.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.f.a.bty().oP(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).al(dimens).am(dimens).bv(this.lWr);
            this.lWq.onChangeSkinType(i);
        }
        this.aln = i;
    }

    private void doA() {
        if (this.lWo == null || this.lWo.eTa == null) {
            this.lWq.setVisibility(8);
            return;
        }
        this.lWq.setVisibility(0);
        if (this.alS == null) {
            this.alS = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lWq);
            this.alS.l(this.kjW);
        }
        this.alS.a(this.lWo.eTa);
        this.lWq.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cO(View view) {
                String str;
                if (PbImageAlaRecommendVH.this.pbData != null && PbImageAlaRecommendVH.this.pbData.getForum() != null && PbImageAlaRecommendVH.this.lWo != null && PbImageAlaRecommendVH.this.lWo.eTa != null) {
                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13718").dR("fid", PbImageAlaRecommendVH.this.pbData.getForum().getId()).dR("fname", PbImageAlaRecommendVH.this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", PbImageAlaRecommendVH.this.pbData.getThreadId());
                    if (PbImageAlaRecommendVH.this.lWo.eTa != null) {
                        str = PbImageAlaRecommendVH.this.lWo.eTa.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dR.dR("friend_uid", str).aq("obj_type", PbImageAlaRecommendVH.this.lWo.eTa.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lWo != null && id == R.id.rootLayout) {
            b(this.lWo);
            c(this.lWo);
        }
    }

    private void b(v vVar) {
        if (vVar != null && vVar.liveStatus == 1) {
            if (vVar.isChushou) {
                eI(vVar.thirdRoomId, vVar.thirdLiveType);
            } else if (vVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = vVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kjm.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eI(String str, String str2) {
        bf.bsY().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(v vVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13709").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", vVar.eTa != null ? vVar.eTa.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lWo != null && !this.lWo.lWl) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13708").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lWo.eTa != null ? this.lWo.eTa.getUserId() : ""));
            this.lWo.lWl = true;
        }
    }
}
