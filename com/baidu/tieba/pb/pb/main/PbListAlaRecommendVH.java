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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    private int akW;
    private View fJE;
    private TbImageView kdS;
    private View kdX;
    private TextView kss;
    private RelativeLayout kym;
    private NEGFeedBackView lPM;
    private PbActivity lQm;
    private x lQn;
    private TBLottieAnimationView lQo;
    private TextView lQp;
    private TextView lQq;
    private com.baidu.tieba.pb.data.f pbData;

    public PbListAlaRecommendVH(View view, PbActivity pbActivity) {
        super(view);
        this.akW = 3;
        this.lQm = pbActivity;
        this.kdX = view.findViewById(R.id.rootLayout);
        this.kdS = (TbImageView) view.findViewById(R.id.coverView);
        this.lQo = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lQo.loop(true);
        com.baidu.tbadk.core.util.ao.a(this.lQo, R.raw.ala_live2);
        this.lQo.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                PbListAlaRecommendVH.this.lQo.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                PbListAlaRecommendVH.this.lQo.cancelAnimation();
            }
        });
        this.kss = (TextView) view.findViewById(R.id.descView);
        this.lQp = (TextView) view.findViewById(R.id.userInfoView);
        this.lQq = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.kym = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fJE = view.findViewById(R.id.ala_item_cross_line);
        this.kdS.setConrers(15);
        this.kdS.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.kdS.setPlaceHolder(2);
        this.lQo.playAnimation();
    }

    public void a(x xVar) {
        Dr(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.lQn = xVar;
            this.kdX.setOnClickListener(this);
            this.kdS.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.lQo.setVisibility(0);
            } else {
                this.lQo.setVisibility(8);
            }
            this.kss.setText(xVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lQq.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(xVar.userName)) {
                this.lQp.setText(xVar.userName);
                this.lQp.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lQp.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lQq.setLayoutParams(layoutParams);
            this.lQq.setText(String.format(this.lQm.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(xVar.lPB)));
            b(xVar.lPE);
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        if (this.lQm != null) {
            if (atVar == null) {
                if (this.lPM != null) {
                    this.lPM.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lPM == null) {
                this.lPM = new NEGFeedBackView(this.lQm.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lQm, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lQm, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lQm, R.dimen.tbds12);
                this.kym.addView(this.lPM, layoutParams);
                this.lPM.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.2
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.at atVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").an("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.at atVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.at atVar2) {
                    }
                });
            }
            this.lPM.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lPM.setVisibility(0);
            this.lPM.setData(atVar);
            this.lPM.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lQn != null && id == R.id.rootLayout) {
            b(this.lQn);
            c(this.lQn);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                eI(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lQm, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eI(String str, String str2) {
        be.bwv().b(this.lQm.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dX("fid", this.pbData.getForum().getId()).dX("fname", this.pbData.getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", this.pbData.getThreadId()).dX("obj_param1", xVar.eTY != null ? xVar.eTY.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lQn != null && !this.lQn.lPC) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dX("fid", fVar.getForum().getId()).dX("fname", fVar.getForum().getName()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("tid", fVar.getThreadId()).dX("obj_param1", this.lQn.eTY != null ? this.lQn.eTY.getUserId() : ""));
            this.lQn.lPC = true;
        }
    }

    private void Dr(int i) {
        if (this.akW != i) {
            com.baidu.tbadk.core.util.ao.c(this.kdX, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kss, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lQp, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lQq, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lQo, R.color.CAM_X0101, 1, i);
            if (this.lPM != null) {
                this.lPM.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.bv(this.lQo).pK(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.fJE, R.color.CAM_X0203, i);
        }
        this.akW = i;
    }
}
