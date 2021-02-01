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
    public int ajU;
    private com.baidu.tbadk.core.view.userLike.c akz;
    private TextView eHx;
    private TbImageView kgQ;
    private View kgV;
    private BdUniqueId khF;
    private TextView kvU;
    private v lTX;
    private View lTY;
    private DynamicUserLikeButton lTZ;
    private TextView lUa;
    private TextView lUb;
    private View lUc;
    private View lUd;
    private NEGFeedBackView lUe;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ajU = 3;
        this.pageContext = tbPageContext;
        this.khF = bdUniqueId;
        if (view != null) {
            this.kgV = view.findViewById(R.id.rootLayout);
            this.lTY = view.findViewById(R.id.top_divider_line);
            this.eHx = (TextView) view.findViewById(R.id.titleView);
            this.lTZ = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lUa = (TextView) view.findViewById(R.id.alaStateView);
            this.kgQ = (TbImageView) view.findViewById(R.id.coverView);
            this.kvU = (TextView) view.findViewById(R.id.descView);
            this.lUb = (TextView) view.findViewById(R.id.hotView);
            this.lUc = view.findViewById(R.id.hotPoint);
            this.lUd = view.findViewById(R.id.bottomSpaceView);
            this.lTZ.setTextSize(R.dimen.tbds28);
            this.kgQ.setPlaceHolder(2);
            this.kgQ.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.kgQ.setConrers(15);
        }
    }

    public void a(v vVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (vVar != null) {
            this.lTX = vVar;
            this.kgV.setOnClickListener(this);
            this.kgQ.startLoad(vVar.cover, 10, false);
            if (vVar.liveStatus == 1 && vVar.liveId > 0) {
                this.lUa.setVisibility(0);
            } else {
                this.lUa.setVisibility(8);
            }
            this.kvU.setText(vVar.description);
            this.eHx.setText(String.format(this.eHx.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.au.getFixedText(vVar.userName, 7, true)));
            this.lUb.setText(String.format(this.lUb.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(vVar.lTT)));
            this.lUd.setVisibility(vVar.lTV ? 8 : 0);
            b(vVar.lTW);
            dok();
        }
    }

    private void b(av avVar) {
        if (this.pageContext != null) {
            if (avVar == null) {
                if (this.lUe != null) {
                    this.lUe.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lUe == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lUe = new NEGFeedBackView(this.pageContext);
                this.lUe.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.kgV.findViewById(R.id.contentLayout)).addView(this.lUe, layoutParams);
                this.lUe.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(av avVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").ap("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(av avVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar2) {
                    }
                });
            }
            this.lUe.setVisibility(0);
            this.lUe.setData(avVar);
            this.lUe.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.ajU != i) {
            com.baidu.tbadk.core.util.ap.c(this.kgV, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lTY, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kvU, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.eHx, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUb, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUa, R.color.CAM_X0101, 1, i);
            if (this.lUe != null) {
                this.lUe.onChangeSkinType();
            }
            this.lUc.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aL(com.baidu.adp.lib.util.l.getDimens(this.lUc.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lUa.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).ah(dimens).ai(dimens).bv(this.lUa);
            this.lTZ.onChangeSkinType(i);
        }
        this.ajU = i;
    }

    private void dok() {
        if (this.lTX == null || this.lTX.eRz == null) {
            this.lTZ.setVisibility(8);
            return;
        }
        this.lTZ.setVisibility(0);
        if (this.akz == null) {
            this.akz = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lTZ);
            this.akz.l(this.khF);
        }
        this.akz.a(this.lTX.eRz);
        this.lTZ.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cO(View view) {
                String str;
                if (PbImageAlaRecommendVH.this.pbData != null && PbImageAlaRecommendVH.this.pbData.getForum() != null && PbImageAlaRecommendVH.this.lTX != null && PbImageAlaRecommendVH.this.lTX.eRz != null) {
                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13718").dR("fid", PbImageAlaRecommendVH.this.pbData.getForum().getId()).dR("fname", PbImageAlaRecommendVH.this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", PbImageAlaRecommendVH.this.pbData.getThreadId());
                    if (PbImageAlaRecommendVH.this.lTX.eRz != null) {
                        str = PbImageAlaRecommendVH.this.lTX.eRz.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dR.dR("friend_uid", str).ap("obj_type", PbImageAlaRecommendVH.this.lTX.eRz.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lTX != null && id == R.id.rootLayout) {
            b(this.lTX);
            c(this.lTX);
        }
    }

    private void b(v vVar) {
        if (vVar != null && vVar.liveStatus == 1) {
            if (vVar.isChushou) {
                eI(vVar.thirdRoomId, vVar.thirdLiveType);
            } else if (vVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = vVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kgV.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eI(String str, String str2) {
        bf.bsV().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(v vVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13709").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", vVar.eRz != null ? vVar.eRz.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lTX != null && !this.lTX.lTU) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13708").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lTX.eRz != null ? this.lTX.eRz.getUserId() : ""));
            this.lTX.lTU = true;
        }
    }
}
