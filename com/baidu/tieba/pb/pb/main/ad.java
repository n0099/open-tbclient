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
    private int aiD;
    private TbImageView iMf;
    private View iMk;
    private TextView jaP;
    private PbActivity kGJ;
    private ac kGK;
    private TextView kGL;
    private TextView kGM;
    private TextView kGe;
    private NEGFeedBackView kGi;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.aiD = 3;
        this.kGJ = pbActivity;
        this.iMk = view.findViewById(R.id.rootLayout);
        this.iMf = (TbImageView) view.findViewById(R.id.coverView);
        this.kGe = (TextView) view.findViewById(R.id.alaStateView);
        this.jaP = (TextView) view.findViewById(R.id.descView);
        this.kGL = (TextView) view.findViewById(R.id.userInfoView);
        this.kGM = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.iMf.setConrers(15);
        this.iMf.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.iMf.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        Ad(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.kGK = acVar;
            this.iMk.setOnClickListener(this);
            this.iMf.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.kGe.setVisibility(0);
            } else {
                this.kGe.setVisibility(8);
            }
            this.jaP.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kGM.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(acVar.userName)) {
                this.kGL.setText(acVar.userName);
                this.kGL.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kGL.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kGM.setLayoutParams(layoutParams);
            this.kGM.setText(String.format(this.kGJ.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(acVar.kFX)));
            b(acVar.kGa);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.kGJ != null) {
            if (arVar == null) {
                if (this.kGi != null) {
                    this.kGi.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kGi == null) {
                this.kGi = new NEGFeedBackView(this.kGJ.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.kGJ, R.dimen.tbds44);
                this.kGi.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.kGJ, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.kGJ, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.kGJ, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.iMk).addView(this.kGi, layoutParams);
                this.kGi.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
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
            this.kGi.setVisibility(0);
            this.kGi.setData(arVar);
            this.kGi.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kGK != null && id == R.id.rootLayout) {
            b(this.kGK);
            c(this.kGK);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                em(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kGJ, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void em(String str, String str2) {
        com.baidu.tbadk.core.util.be.bju().b(this.kGJ.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dD("fid", this.pbData.getForum().getId()).dD("fname", this.pbData.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", this.pbData.getThreadId()).dD("obj_param1", acVar.ecf != null ? acVar.ecf.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kGK != null && !this.kGK.kFY) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dD("fid", fVar.getForum().getId()).dD("fname", fVar.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", fVar.getThreadId()).dD("obj_param1", this.kGK.ecf != null ? this.kGK.ecf.getUserId() : ""));
            this.kGK.kFY = true;
        }
    }

    private void Ad(int i) {
        if (this.aiD != i) {
            com.baidu.tbadk.core.util.ap.b(this.iMk, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jaP, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGL, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGM, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGe, R.color.cp_cont_a, 1, i);
            if (this.kGi != null) {
                this.kGi.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kGJ, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).X(dimens).Y(dimens).aZ(this.kGe);
        }
        this.aiD = i;
    }
}
