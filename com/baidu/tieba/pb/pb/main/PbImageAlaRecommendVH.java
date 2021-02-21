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
    private BdUniqueId khT;
    private TbImageView khe;
    private View khj;
    private TextView kwi;
    private v lUm;
    private View lUn;
    private DynamicUserLikeButton lUo;
    private TextView lUp;
    private TextView lUq;
    private View lUr;
    private View lUs;
    private NEGFeedBackView lUt;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ajU = 3;
        this.pageContext = tbPageContext;
        this.khT = bdUniqueId;
        if (view != null) {
            this.khj = view.findViewById(R.id.rootLayout);
            this.lUn = view.findViewById(R.id.top_divider_line);
            this.eHx = (TextView) view.findViewById(R.id.titleView);
            this.lUo = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lUp = (TextView) view.findViewById(R.id.alaStateView);
            this.khe = (TbImageView) view.findViewById(R.id.coverView);
            this.kwi = (TextView) view.findViewById(R.id.descView);
            this.lUq = (TextView) view.findViewById(R.id.hotView);
            this.lUr = view.findViewById(R.id.hotPoint);
            this.lUs = view.findViewById(R.id.bottomSpaceView);
            this.lUo.setTextSize(R.dimen.tbds28);
            this.khe.setPlaceHolder(2);
            this.khe.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.khe.setConrers(15);
        }
    }

    public void a(v vVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (vVar != null) {
            this.lUm = vVar;
            this.khj.setOnClickListener(this);
            this.khe.startLoad(vVar.cover, 10, false);
            if (vVar.liveStatus == 1 && vVar.liveId > 0) {
                this.lUp.setVisibility(0);
            } else {
                this.lUp.setVisibility(8);
            }
            this.kwi.setText(vVar.description);
            this.eHx.setText(String.format(this.eHx.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.au.getFixedText(vVar.userName, 7, true)));
            this.lUq.setText(String.format(this.lUq.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(vVar.lUi)));
            this.lUs.setVisibility(vVar.lUk ? 8 : 0);
            b(vVar.lUl);
            dor();
        }
    }

    private void b(av avVar) {
        if (this.pageContext != null) {
            if (avVar == null) {
                if (this.lUt != null) {
                    this.lUt.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lUt == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lUt = new NEGFeedBackView(this.pageContext);
                this.lUt.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.khj.findViewById(R.id.contentLayout)).addView(this.lUt, layoutParams);
                this.lUt.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.1
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
            this.lUt.setVisibility(0);
            this.lUt.setData(avVar);
            this.lUt.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.ajU != i) {
            com.baidu.tbadk.core.util.ap.c(this.khj, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lUn, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kwi, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.eHx, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUq, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUp, R.color.CAM_X0101, 1, i);
            if (this.lUt != null) {
                this.lUt.onChangeSkinType();
            }
            this.lUr.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aL(com.baidu.adp.lib.util.l.getDimens(this.lUr.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lUp.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.f.a.btv().oO(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).ah(dimens).ai(dimens).bv(this.lUp);
            this.lUo.onChangeSkinType(i);
        }
        this.ajU = i;
    }

    private void dor() {
        if (this.lUm == null || this.lUm.eRz == null) {
            this.lUo.setVisibility(8);
            return;
        }
        this.lUo.setVisibility(0);
        if (this.akz == null) {
            this.akz = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lUo);
            this.akz.l(this.khT);
        }
        this.akz.a(this.lUm.eRz);
        this.lUo.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cO(View view) {
                String str;
                if (PbImageAlaRecommendVH.this.pbData != null && PbImageAlaRecommendVH.this.pbData.getForum() != null && PbImageAlaRecommendVH.this.lUm != null && PbImageAlaRecommendVH.this.lUm.eRz != null) {
                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13718").dR("fid", PbImageAlaRecommendVH.this.pbData.getForum().getId()).dR("fname", PbImageAlaRecommendVH.this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", PbImageAlaRecommendVH.this.pbData.getThreadId());
                    if (PbImageAlaRecommendVH.this.lUm.eRz != null) {
                        str = PbImageAlaRecommendVH.this.lUm.eRz.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dR.dR("friend_uid", str).ap("obj_type", PbImageAlaRecommendVH.this.lUm.eRz.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lUm != null && id == R.id.rootLayout) {
            b(this.lUm);
            c(this.lUm);
        }
    }

    private void b(v vVar) {
        if (vVar != null && vVar.liveStatus == 1) {
            if (vVar.isChushou) {
                eI(vVar.thirdRoomId, vVar.thirdLiveType);
            } else if (vVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = vVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.khj.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
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
        if (fVar != null && fVar.getForum() != null && this.lUm != null && !this.lUm.lUj) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13708").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lUm.eRz != null ? this.lUm.eRz.getUserId() : ""));
            this.lUm.lUj = true;
        }
    }
}
