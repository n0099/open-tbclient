package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ad extends af.a implements View.OnClickListener {
    private int aku;
    private View fzY;
    private TbImageView jQC;
    private View jQH;
    private TextView kfe;
    private RelativeLayout klE;
    private PbActivity lKY;
    private ac lKZ;
    private NEGFeedBackView lKw;
    private TBLottieAnimationView lLa;
    private TextView lLb;
    private TextView lLc;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.aku = 3;
        this.lKY = pbActivity;
        this.jQH = view.findViewById(R.id.rootLayout);
        this.jQC = (TbImageView) view.findViewById(R.id.coverView);
        this.lLa = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lLa.loop(true);
        com.baidu.tbadk.core.util.ap.a(this.lLa, R.raw.ala_live2);
        this.lLa.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                ad.this.lLa.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                ad.this.lLa.cancelAnimation();
            }
        });
        this.kfe = (TextView) view.findViewById(R.id.descView);
        this.lLb = (TextView) view.findViewById(R.id.userInfoView);
        this.lLc = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.klE = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fzY = view.findViewById(R.id.ala_item_cross_line);
        this.jQC.setConrers(15);
        this.jQC.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.jQC.setPlaceHolder(2);
        this.lLa.playAnimation();
    }

    public void a(ac acVar) {
        Dd(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.lKZ = acVar;
            this.jQH.setOnClickListener(this);
            this.jQC.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.lLa.setVisibility(0);
            } else {
                this.lLa.setVisibility(8);
            }
            this.kfe.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lLc.getLayoutParams();
            if (!com.baidu.tbadk.core.util.au.isEmpty(acVar.userName)) {
                this.lLb.setText(acVar.userName);
                this.lLb.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lLb.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lLc.setLayoutParams(layoutParams);
            this.lLc.setText(String.format(this.lKY.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(acVar.lKl)));
            b(acVar.lKo);
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        if (this.lKY != null) {
            if (atVar == null) {
                if (this.lKw != null) {
                    this.lKw.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lKw == null) {
                this.lKw = new NEGFeedBackView(this.lKY.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lKY, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lKY, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lKY, R.dimen.tbds12);
                this.klE.addView(this.lKw, layoutParams);
                this.lKw.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.2
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.at atVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").al("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.at atVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.at atVar2) {
                    }
                });
            }
            this.lKw.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lKw.setVisibility(0);
            this.lKw.setData(atVar);
            this.lKw.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lKZ != null && id == R.id.rootLayout) {
            b(this.lKZ);
            c(this.lKZ);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                eH(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lKY, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eH(String str, String str2) {
        bf.bua().b(this.lKY.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13717").dY("fid", this.pbData.getForum().getId()).dY("fname", this.pbData.getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", this.pbData.getThreadId()).dY("obj_param1", acVar.eKe != null ? acVar.eKe.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lKZ != null && !this.lKZ.lKm) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13716").dY("fid", fVar.getForum().getId()).dY("fname", fVar.getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", fVar.getThreadId()).dY("obj_param1", this.lKZ.eKe != null ? this.lKZ.eKe.getUserId() : ""));
            this.lKZ.lKm = true;
        }
    }

    private void Dd(int i) {
        if (this.aku != i) {
            com.baidu.tbadk.core.util.ap.c(this.jQH, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kfe, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lLb, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lLc, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lLa, R.color.CAM_X0101, 1, i);
            if (this.lKw != null) {
                this.lKw.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.bm(this.lLa).pA(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.fzY, R.color.CAM_X0203, i);
        }
        this.aku = i;
    }
}
