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
/* loaded from: classes21.dex */
public class ad extends af.a implements View.OnClickListener {
    private int ajv;
    private View fsk;
    private TbImageView jDa;
    private View jDf;
    private TextView jRA;
    private RelativeLayout jXZ;
    private NEGFeedBackView lwJ;
    private PbActivity lxl;
    private ac lxm;
    private TBLottieAnimationView lxn;
    private TextView lxo;
    private TextView lxp;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.ajv = 3;
        this.lxl = pbActivity;
        this.jDf = view.findViewById(R.id.rootLayout);
        this.jDa = (TbImageView) view.findViewById(R.id.coverView);
        this.lxn = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.lxn.loop(true);
        com.baidu.tbadk.core.util.ap.a(this.lxn, R.raw.ala_live2);
        this.lxn.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                ad.this.lxn.playAnimation();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                ad.this.lxn.cancelAnimation();
            }
        });
        this.jRA = (TextView) view.findViewById(R.id.descView);
        this.lxo = (TextView) view.findViewById(R.id.userInfoView);
        this.lxp = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.jXZ = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.fsk = view.findViewById(R.id.ala_item_cross_line);
        this.jDa.setConrers(15);
        this.jDa.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.jDa.setPlaceHolder(2);
        this.lxn.playAnimation();
    }

    public void a(ac acVar) {
        Co(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.lxm = acVar;
            this.jDf.setOnClickListener(this);
            this.jDa.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.lxn.setVisibility(0);
            } else {
                this.lxn.setVisibility(8);
            }
            this.jRA.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lxp.getLayoutParams();
            if (!com.baidu.tbadk.core.util.au.isEmpty(acVar.userName)) {
                this.lxo.setText(acVar.userName);
                this.lxo.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.lxo.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lxp.setLayoutParams(layoutParams);
            this.lxp.setText(String.format(this.lxl.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(acVar.lwy)));
            b(acVar.lwB);
        }
    }

    private void b(com.baidu.tbadk.core.data.as asVar) {
        if (this.lxl != null) {
            if (asVar == null) {
                if (this.lwJ != null) {
                    this.lwJ.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lwJ == null) {
                this.lwJ = new NEGFeedBackView(this.lxl.getPageContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lxl, R.dimen.tbds50), com.baidu.adp.lib.util.l.getDimens(this.lxl, R.dimen.tbds50));
                layoutParams.addRule(11);
                layoutParams.addRule(3, R.id.descView);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(this.lxl, R.dimen.tbds12);
                this.jXZ.addView(this.lwJ, layoutParams);
                this.lwJ.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.2
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.as asVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").ak("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.as asVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.as asVar2) {
                    }
                });
            }
            this.lwJ.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
            this.lwJ.setVisibility(0);
            this.lwJ.setData(asVar);
            this.lwJ.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lxm != null && id == R.id.rootLayout) {
            b(this.lxm);
            c(this.lxm);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                eC(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lxl, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eC(String str, String str2) {
        bf.bqF().b(this.lxl.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13717").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", acVar.eDc != null ? acVar.eDc.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lxm != null && !this.lxm.lwz) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13716").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lxm.eDc != null ? this.lxm.eDc.getUserId() : ""));
            this.lxm.lwz = true;
        }
    }

    private void Co(int i) {
        if (this.ajv != i) {
            com.baidu.tbadk.core.util.ap.b(this.jDf, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jRA, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lxo, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lxp, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lxn, R.color.CAM_X0101, 1, i);
            if (this.lwJ != null) {
                this.lwJ.onChangeSkinType();
            }
            com.baidu.tbadk.core.elementsMaven.c.bj(this.lxn).pb(R.string.J_X01).setBackGroundColor(R.color.CAM_X0310);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.fsk, R.color.CAM_X0203, i);
        }
        this.ajv = i;
    }
}
