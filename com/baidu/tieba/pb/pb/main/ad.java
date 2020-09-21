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
/* loaded from: classes21.dex */
public class ad extends af.a implements View.OnClickListener {
    private int aiX;
    private TbImageView iUL;
    private View iUQ;
    private TextView jjv;
    private TextView kOD;
    private NEGFeedBackView kOH;
    private PbActivity kPj;
    private ac kPk;
    private TextView kPl;
    private TextView kPm;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.aiX = 3;
        this.kPj = pbActivity;
        this.iUQ = view.findViewById(R.id.rootLayout);
        this.iUL = (TbImageView) view.findViewById(R.id.coverView);
        this.kOD = (TextView) view.findViewById(R.id.alaStateView);
        this.jjv = (TextView) view.findViewById(R.id.descView);
        this.kPl = (TextView) view.findViewById(R.id.userInfoView);
        this.kPm = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.iUL.setConrers(15);
        this.iUL.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.iUL.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        AE(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.kPk = acVar;
            this.iUQ.setOnClickListener(this);
            this.iUL.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.kOD.setVisibility(0);
            } else {
                this.kOD.setVisibility(8);
            }
            this.jjv.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kPm.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(acVar.userName)) {
                this.kPl.setText(acVar.userName);
                this.kPl.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kPl.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kPm.setLayoutParams(layoutParams);
            this.kPm.setText(String.format(this.kPj.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(acVar.kOw)));
            b(acVar.kOz);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.kPj != null) {
            if (arVar == null) {
                if (this.kOH != null) {
                    this.kOH.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kOH == null) {
                this.kOH = new NEGFeedBackView(this.kPj.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.kPj, R.dimen.tbds44);
                this.kOH.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.kPj, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.kPj, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.kPj, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.iUQ).addView(this.kOH, layoutParams);
                this.kOH.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
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
            this.kOH.setVisibility(0);
            this.kOH.setData(arVar);
            this.kOH.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kPk != null && id == R.id.rootLayout) {
            b(this.kPk);
            c(this.kPk);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                eq(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kPj, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eq(String str, String str2) {
        com.baidu.tbadk.core.util.be.bkp().b(this.kPj.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dF("fid", this.pbData.getForum().getId()).dF("fname", this.pbData.getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", this.pbData.getThreadId()).dF("obj_param1", acVar.eep != null ? acVar.eep.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kPk != null && !this.kPk.kOx) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dF("fid", fVar.getForum().getId()).dF("fname", fVar.getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", fVar.getThreadId()).dF("obj_param1", this.kPk.eep != null ? this.kPk.eep.getUserId() : ""));
            this.kPk.kOx = true;
        }
    }

    private void AE(int i) {
        if (this.aiX != i) {
            com.baidu.tbadk.core.util.ap.b(this.iUQ, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jjv, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kPl, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kPm, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kOD, R.color.cp_cont_a, 1, i);
            if (this.kOH != null) {
                this.kOH.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kPj, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).X(dimens).Y(dimens).bb(this.kOD);
        }
        this.aiX = i;
    }
}
