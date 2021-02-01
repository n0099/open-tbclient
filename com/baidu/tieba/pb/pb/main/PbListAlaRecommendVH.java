package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private int ajU;
    private View fHj;
    private RelativeLayout kBO;
    private TbImageView kgQ;
    private View kgV;
    private TextView kvU;
    private PbActivity lUE;
    private x lUF;
    private TBLottieAnimationView lUG;
    private TextView lUH;
    private TextView lUI;
    private NEGFeedBackView lUe;
    private com.baidu.tieba.pb.data.f pbData;

    public PbListAlaRecommendVH(View view, PbActivity pbActivity) {
        super(view);
        this.ajU = 3;
        this.lUE = pbActivity;
        this.kgV = view.findViewById(R.id.rootLayout);
        this.kgQ = (TbImageView) view.findViewById(R.id.coverView);
        this.lUG = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lUG.loop(true);
        com.baidu.tbadk.core.util.ap.a(this.lUG, R.raw.ala_live2);
        this.lUG.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                PbListAlaRecommendVH.this.lUG.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                PbListAlaRecommendVH.this.lUG.cancelAnimation();
            }
        });
        this.kvU = (TextView) view.findViewById(R.id.descView);
        this.lUH = (TextView) view.findViewById(R.id.userInfoView);
        this.lUI = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.kBO = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fHj = view.findViewById(R.id.ala_item_cross_line);
        this.kgQ.setConrers(15);
        this.kgQ.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.kgQ.setPlaceHolder(2);
        this.lUG.playAnimation();
    }

    public void a(x xVar) {
        Cc(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.lUF = xVar;
            this.kgV.setOnClickListener(this);
            this.kgQ.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.lUG.setVisibility(0);
            } else {
                this.lUG.setVisibility(8);
            }
            this.kvU.setText(xVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lUI.getLayoutParams();
            if (!com.baidu.tbadk.core.util.au.isEmpty(xVar.userName)) {
                this.lUH.setText(xVar.userName);
                this.lUH.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lUH.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lUI.setLayoutParams(layoutParams);
            this.lUI.setText(String.format(this.lUE.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(xVar.lTT)));
            b(xVar.lTW);
        }
    }

    private void b(av avVar) {
        if (this.lUE != null) {
            if (avVar == null) {
                if (this.lUe != null) {
                    this.lUe.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lUe == null) {
                this.lUe = new NEGFeedBackView(this.lUE.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lUE, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lUE, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lUE, R.dimen.tbds12);
                this.kBO.addView(this.lUe, layoutParams);
                this.lUe.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.2
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(av avVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").ap("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(av avVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar2) {
                    }
                });
            }
            this.lUe.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lUe.setVisibility(0);
            this.lUe.setData(avVar);
            this.lUe.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lUF != null && id == R.id.rootLayout) {
            b(this.lUF);
            c(this.lUF);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                eI(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lUE, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eI(String str, String str2) {
        bf.bsV().b(this.lUE.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13717").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", xVar.eRz != null ? xVar.eRz.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lUF != null && !this.lUF.lTU) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13716").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lUF.eRz != null ? this.lUF.eRz.getUserId() : ""));
            this.lUF.lTU = true;
        }
    }

    private void Cc(int i) {
        if (this.ajU != i) {
            com.baidu.tbadk.core.util.ap.c(this.kgV, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kvU, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUH, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUI, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUG, R.color.CAM_X0101, 1, i);
            if (this.lUe != null) {
                this.lUe.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.lUG).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.fHj, R.color.CAM_X0203, i);
        }
        this.ajU = i;
    }
}
