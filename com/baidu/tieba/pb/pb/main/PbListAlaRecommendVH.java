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
    private int akf;
    private View fEX;
    private TbImageView jZn;
    private View jZs;
    private TextView knN;
    private RelativeLayout ktH;
    private PbActivity lLI;
    private x lLJ;
    private TBLottieAnimationView lLK;
    private TextView lLL;
    private TextView lLM;
    private NEGFeedBackView lLi;
    private com.baidu.tieba.pb.data.f pbData;

    public PbListAlaRecommendVH(View view, PbActivity pbActivity) {
        super(view);
        this.akf = 3;
        this.lLI = pbActivity;
        this.jZs = view.findViewById(R.id.rootLayout);
        this.jZn = (TbImageView) view.findViewById(R.id.coverView);
        this.lLK = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lLK.loop(true);
        com.baidu.tbadk.core.util.ao.a(this.lLK, R.raw.ala_live2);
        this.lLK.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                PbListAlaRecommendVH.this.lLK.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                PbListAlaRecommendVH.this.lLK.cancelAnimation();
            }
        });
        this.knN = (TextView) view.findViewById(R.id.descView);
        this.lLL = (TextView) view.findViewById(R.id.userInfoView);
        this.lLM = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.ktH = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fEX = view.findViewById(R.id.ala_item_cross_line);
        this.jZn.setConrers(15);
        this.jZn.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.jZn.setPlaceHolder(2);
        this.lLK.playAnimation();
    }

    public void a(x xVar) {
        BK(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.lLJ = xVar;
            this.jZs.setOnClickListener(this);
            this.jZn.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.lLK.setVisibility(0);
            } else {
                this.lLK.setVisibility(8);
            }
            this.knN.setText(xVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lLM.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(xVar.userName)) {
                this.lLL.setText(xVar.userName);
                this.lLL.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lLL.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lLM.setLayoutParams(layoutParams);
            this.lLM.setText(String.format(this.lLI.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(xVar.lKX)));
            b(xVar.lLa);
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        if (this.lLI != null) {
            if (atVar == null) {
                if (this.lLi != null) {
                    this.lLi.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lLi == null) {
                this.lLi = new NEGFeedBackView(this.lLI.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lLI, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lLI, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lLI, R.dimen.tbds12);
                this.ktH.addView(this.lLi, layoutParams);
                this.lLi.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.2
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
            this.lLi.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lLi.setVisibility(0);
            this.lLi.setData(atVar);
            this.lLi.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lLJ != null && id == R.id.rootLayout) {
            b(this.lLJ);
            c(this.lLJ);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                eH(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lLI, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eH(String str, String str2) {
        be.bsB().b(this.lLI.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dW("fid", this.pbData.getForum().getId()).dW("fname", this.pbData.getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", this.pbData.getThreadId()).dW("obj_param1", xVar.ePn != null ? xVar.ePn.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lLJ != null && !this.lLJ.lKY) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dW("fid", fVar.getForum().getId()).dW("fname", fVar.getForum().getName()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("tid", fVar.getThreadId()).dW("obj_param1", this.lLJ.ePn != null ? this.lLJ.ePn.getUserId() : ""));
            this.lLJ.lKY = true;
        }
    }

    private void BK(int i) {
        if (this.akf != i) {
            com.baidu.tbadk.core.util.ao.c(this.jZs, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.knN, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lLL, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lLM, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.lLK, R.color.CAM_X0101, 1, i);
            if (this.lLi != null) {
                this.lLi.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.bv(this.lLK).od(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.fEX, R.color.CAM_X0203, i);
        }
        this.akf = i;
    }
}
