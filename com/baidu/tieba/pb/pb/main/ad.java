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
/* loaded from: classes22.dex */
public class ad extends af.a implements View.OnClickListener {
    private int ajq;
    private TextView jKS;
    private TbImageView jwg;
    private View jwl;
    private PbActivity lqY;
    private ac lqZ;
    private TextView lqs;
    private NEGFeedBackView lqw;
    private TextView lra;
    private TextView lrb;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.ajq = 3;
        this.lqY = pbActivity;
        this.jwl = view.findViewById(R.id.rootLayout);
        this.jwg = (TbImageView) view.findViewById(R.id.coverView);
        this.lqs = (TextView) view.findViewById(R.id.alaStateView);
        this.jKS = (TextView) view.findViewById(R.id.descView);
        this.lra = (TextView) view.findViewById(R.id.userInfoView);
        this.lrb = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.jwg.setConrers(15);
        this.jwg.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.jwg.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        BD(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.lqZ = acVar;
            this.jwl.setOnClickListener(this);
            this.jwg.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.lqs.setVisibility(0);
            } else {
                this.lqs.setVisibility(8);
            }
            this.jKS.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lrb.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(acVar.userName)) {
                this.lra.setText(acVar.userName);
                this.lra.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.lra.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lrb.setLayoutParams(layoutParams);
            this.lrb.setText(String.format(this.lqY.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(acVar.lql)));
            b(acVar.lqo);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.lqY != null) {
            if (arVar == null) {
                if (this.lqw != null) {
                    this.lqw.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lqw == null) {
                this.lqw = new NEGFeedBackView(this.lqY.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.lqY, R.dimen.tbds44);
                this.lqw.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.lqY, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lqY, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.lqY, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.jwl).addView(this.lqw, layoutParams);
                this.lqw.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.ar arVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").aj("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.ar arVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.ar arVar2) {
                    }
                });
            }
            this.lqw.setVisibility(0);
            this.lqw.setData(arVar);
            this.lqw.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lqZ != null && id == R.id.rootLayout) {
            b(this.lqZ);
            c(this.lqZ);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                eC(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lqY, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eC(String str, String str2) {
        com.baidu.tbadk.core.util.be.boR().b(this.lqY.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", acVar.eyV != null ? acVar.eyV.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lqZ != null && !this.lqZ.lqm) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lqZ.eyV != null ? this.lqZ.eyV.getUserId() : ""));
            this.lqZ.lqm = true;
        }
    }

    private void BD(int i) {
        if (this.ajq != i) {
            com.baidu.tbadk.core.util.ap.b(this.jwl, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jKS, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lra, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lrb, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lqs, R.color.cp_cont_a, 1, i);
            if (this.lqw != null) {
                this.lqw.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lqY, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).ab(dimens).ac(dimens).bg(this.lqs);
        }
        this.ajq = i;
    }
}
