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
    private RelativeLayout kCc;
    private TbImageView khe;
    private View khj;
    private TextView kwi;
    private PbActivity lUT;
    private x lUU;
    private TBLottieAnimationView lUV;
    private TextView lUW;
    private TextView lUX;
    private NEGFeedBackView lUt;
    private com.baidu.tieba.pb.data.f pbData;

    public PbListAlaRecommendVH(View view, PbActivity pbActivity) {
        super(view);
        this.ajU = 3;
        this.lUT = pbActivity;
        this.khj = view.findViewById(R.id.rootLayout);
        this.khe = (TbImageView) view.findViewById(R.id.coverView);
        this.lUV = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lUV.loop(true);
        com.baidu.tbadk.core.util.ap.a(this.lUV, R.raw.ala_live2);
        this.lUV.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                PbListAlaRecommendVH.this.lUV.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                PbListAlaRecommendVH.this.lUV.cancelAnimation();
            }
        });
        this.kwi = (TextView) view.findViewById(R.id.descView);
        this.lUW = (TextView) view.findViewById(R.id.userInfoView);
        this.lUX = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.kCc = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fHj = view.findViewById(R.id.ala_item_cross_line);
        this.khe.setConrers(15);
        this.khe.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.khe.setPlaceHolder(2);
        this.lUV.playAnimation();
    }

    public void a(x xVar) {
        Cc(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.lUU = xVar;
            this.khj.setOnClickListener(this);
            this.khe.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.lUV.setVisibility(0);
            } else {
                this.lUV.setVisibility(8);
            }
            this.kwi.setText(xVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lUX.getLayoutParams();
            if (!com.baidu.tbadk.core.util.au.isEmpty(xVar.userName)) {
                this.lUW.setText(xVar.userName);
                this.lUW.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lUW.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lUX.setLayoutParams(layoutParams);
            this.lUX.setText(String.format(this.lUT.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(xVar.lUi)));
            b(xVar.lUl);
        }
    }

    private void b(av avVar) {
        if (this.lUT != null) {
            if (avVar == null) {
                if (this.lUt != null) {
                    this.lUt.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lUt == null) {
                this.lUt = new NEGFeedBackView(this.lUT.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lUT, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lUT, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lUT, R.dimen.tbds12);
                this.kCc.addView(this.lUt, layoutParams);
                this.lUt.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.2
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
            this.lUt.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lUt.setVisibility(0);
            this.lUt.setData(avVar);
            this.lUt.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lUU != null && id == R.id.rootLayout) {
            b(this.lUU);
            c(this.lUU);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                eI(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lUT, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eI(String str, String str2) {
        bf.bsV().b(this.lUT.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13717").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", xVar.eRz != null ? xVar.eRz.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lUU != null && !this.lUU.lUj) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13716").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lUU.eRz != null ? this.lUU.eRz.getUserId() : ""));
            this.lUU.lUj = true;
        }
    }

    private void Cc(int i) {
        if (this.ajU != i) {
            com.baidu.tbadk.core.util.ap.c(this.khj, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kwi, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUW, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUX, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lUV, R.color.CAM_X0101, 1, i);
            if (this.lUt != null) {
                this.lUt.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.lUV).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.fHj, R.color.CAM_X0203, i);
        }
        this.ajU = i;
    }
}
