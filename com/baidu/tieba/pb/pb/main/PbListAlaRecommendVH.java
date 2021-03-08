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
    private int aln;
    private View fII;
    private RelativeLayout kEe;
    private TbImageView kjh;
    private View kjm;
    private TextView kyk;
    private PbActivity lWV;
    private x lWW;
    private TBLottieAnimationView lWX;
    private TextView lWY;
    private TextView lWZ;
    private NEGFeedBackView lWv;
    private com.baidu.tieba.pb.data.f pbData;

    public PbListAlaRecommendVH(View view, PbActivity pbActivity) {
        super(view);
        this.aln = 3;
        this.lWV = pbActivity;
        this.kjm = view.findViewById(R.id.rootLayout);
        this.kjh = (TbImageView) view.findViewById(R.id.coverView);
        this.lWX = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lWX.loop(true);
        com.baidu.tbadk.core.util.ap.a(this.lWX, R.raw.ala_live2);
        this.lWX.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                PbListAlaRecommendVH.this.lWX.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                PbListAlaRecommendVH.this.lWX.cancelAnimation();
            }
        });
        this.kyk = (TextView) view.findViewById(R.id.descView);
        this.lWY = (TextView) view.findViewById(R.id.userInfoView);
        this.lWZ = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.kEe = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fII = view.findViewById(R.id.ala_item_cross_line);
        this.kjh.setConrers(15);
        this.kjh.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.kjh.setPlaceHolder(2);
        this.lWX.playAnimation();
    }

    public void a(x xVar) {
        Cf(TbadkCoreApplication.getInst().getSkinType());
        if (xVar != null) {
            this.lWW = xVar;
            this.kjm.setOnClickListener(this);
            this.kjh.startLoad(xVar.cover, 10, false);
            if (xVar.liveStatus == 1 && xVar.liveId > 0) {
                this.lWX.setVisibility(0);
            } else {
                this.lWX.setVisibility(8);
            }
            this.kyk.setText(xVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lWZ.getLayoutParams();
            if (!com.baidu.tbadk.core.util.au.isEmpty(xVar.userName)) {
                this.lWY.setText(xVar.userName);
                this.lWY.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lWY.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lWZ.setLayoutParams(layoutParams);
            this.lWZ.setText(String.format(this.lWV.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(xVar.lWk)));
            b(xVar.lWn);
        }
    }

    private void b(av avVar) {
        if (this.lWV != null) {
            if (avVar == null) {
                if (this.lWv != null) {
                    this.lWv.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lWv == null) {
                this.lWv = new NEGFeedBackView(this.lWV.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lWV, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lWV, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lWV, R.dimen.tbds12);
                this.kEe.addView(this.lWv, layoutParams);
                this.lWv.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH.2
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(av avVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").aq("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(av avVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar2) {
                    }
                });
            }
            this.lWv.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lWv.setVisibility(0);
            this.lWv.setData(avVar);
            this.lWv.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lWW != null && id == R.id.rootLayout) {
            b(this.lWW);
            c(this.lWW);
        }
    }

    private void b(x xVar) {
        if (xVar != null && xVar.liveStatus == 1) {
            if (xVar.isChushou) {
                eI(xVar.thirdRoomId, xVar.thirdLiveType);
            } else if (xVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = xVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lWV, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eI(String str, String str2) {
        bf.bsY().b(this.lWV.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(x xVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13717").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", xVar.eTa != null ? xVar.eTa.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lWW != null && !this.lWW.lWl) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13716").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lWW.eTa != null ? this.lWW.eTa.getUserId() : ""));
            this.lWW.lWl = true;
        }
    }

    private void Cf(int i) {
        if (this.aln != i) {
            com.baidu.tbadk.core.util.ap.c(this.kjm, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kyk, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWY, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWZ, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lWX, R.color.CAM_X0101, 1, i);
            if (this.lWv != null) {
                this.lWv.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.br(this.lWX).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.fII, R.color.CAM_X0203, i);
        }
        this.aln = i;
    }
}
