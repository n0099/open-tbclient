package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class ad extends af.a implements View.OnClickListener {
    private int aiB;
    private TbImageView iLZ;
    private View iMe;
    private TextView jaJ;
    private TextView kFX;
    private PbActivity kGC;
    private ac kGD;
    private TextView kGE;
    private TextView kGF;
    private NEGFeedBackView kGb;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.aiB = 3;
        this.kGC = pbActivity;
        this.iMe = view.findViewById(R.id.rootLayout);
        this.iLZ = (TbImageView) view.findViewById(R.id.coverView);
        this.kFX = (TextView) view.findViewById(R.id.alaStateView);
        this.jaJ = (TextView) view.findViewById(R.id.descView);
        this.kGE = (TextView) view.findViewById(R.id.userInfoView);
        this.kGF = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.iLZ.setConrers(15);
        this.iLZ.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.iLZ.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        Ad(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.kGD = acVar;
            this.iMe.setOnClickListener(this);
            this.iLZ.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.kFX.setVisibility(0);
            } else {
                this.kFX.setVisibility(8);
            }
            this.jaJ.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGF.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(acVar.userName)) {
                this.kGE.setText(acVar.userName);
                this.kGE.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kGE.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kGF.setLayoutParams(layoutParams);
            this.kGF.setText(String.format(this.kGC.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(acVar.kFQ)));
            b(acVar.kFT);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.kGC != null) {
            if (arVar == null) {
                if (this.kGb != null) {
                    this.kGb.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kGb == null) {
                this.kGb = new NEGFeedBackView(this.kGC.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.kGC, R.dimen.tbds44);
                this.kGb.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.kGC, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.kGC, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.kGC, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.iMe).addView(this.kGb, layoutParams);
                this.kGb.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.ar arVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").ai("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.ar arVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.ar arVar2) {
                    }
                });
            }
            this.kGb.setVisibility(0);
            this.kGb.setData(arVar);
            this.kGb.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kGD != null && id == R.id.rootLayout) {
            b(this.kGD);
            c(this.kGD);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                el(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kGC, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void el(String str, String str2) {
        com.baidu.tbadk.core.util.be.bju().b(this.kGC.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dD("fid", this.pbData.getForum().getId()).dD("fname", this.pbData.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", this.pbData.getThreadId()).dD("obj_param1", acVar.ecb != null ? acVar.ecb.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kGD != null && !this.kGD.kFR) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dD("fid", fVar.getForum().getId()).dD("fname", fVar.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", fVar.getThreadId()).dD("obj_param1", this.kGD.ecb != null ? this.kGD.ecb.getUserId() : ""));
            this.kGD.kFR = true;
        }
    }

    private void Ad(int i) {
        if (this.aiB != i) {
            com.baidu.tbadk.core.util.ap.b(this.iMe, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jaJ, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGE, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGF, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFX, R.color.cp_cont_a, 1, i);
            if (this.kGb != null) {
                this.kGb.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kGC, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).X(dimens).Y(dimens).aZ(this.kFX);
        }
        this.aiB = i;
    }
}
