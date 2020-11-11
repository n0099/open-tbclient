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
    private TbImageView jCd;
    private View jCi;
    private TextView jQQ;
    private PbActivity lwV;
    private ac lwW;
    private TextView lwX;
    private TextView lwY;
    private TextView lwp;
    private NEGFeedBackView lwt;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.ajq = 3;
        this.lwV = pbActivity;
        this.jCi = view.findViewById(R.id.rootLayout);
        this.jCd = (TbImageView) view.findViewById(R.id.coverView);
        this.lwp = (TextView) view.findViewById(R.id.alaStateView);
        this.jQQ = (TextView) view.findViewById(R.id.descView);
        this.lwX = (TextView) view.findViewById(R.id.userInfoView);
        this.lwY = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.jCd.setConrers(15);
        this.jCd.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.jCd.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        BQ(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.lwW = acVar;
            this.jCi.setOnClickListener(this);
            this.jCd.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.lwp.setVisibility(0);
            } else {
                this.lwp.setVisibility(8);
            }
            this.jQQ.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lwY.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(acVar.userName)) {
                this.lwX.setText(acVar.userName);
                this.lwX.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.lwX.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lwY.setLayoutParams(layoutParams);
            this.lwY.setText(String.format(this.lwV.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(acVar.lwi)));
            b(acVar.lwl);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.lwV != null) {
            if (arVar == null) {
                if (this.lwt != null) {
                    this.lwt.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lwt == null) {
                this.lwt = new NEGFeedBackView(this.lwV.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.lwV, R.dimen.tbds44);
                this.lwt.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.lwV, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lwV, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.lwV, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.jCi).addView(this.lwt, layoutParams);
                this.lwt.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.ar arVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").al("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.ar arVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.ar arVar2) {
                    }
                });
            }
            this.lwt.setVisibility(0);
            this.lwt.setData(arVar);
            this.lwt.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lwW != null && id == R.id.rootLayout) {
            b(this.lwW);
            c(this.lwW);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                eC(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lwV, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void eC(String str, String str2) {
        com.baidu.tbadk.core.util.be.brr().b(this.lwV.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", acVar.eEK != null ? acVar.eEK.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lwW != null && !this.lwW.lwj) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lwW.eEK != null ? this.lwW.eEK.getUserId() : ""));
            this.lwW.lwj = true;
        }
    }

    private void BQ(int i) {
        if (this.ajq != i) {
            com.baidu.tbadk.core.util.ap.b(this.jCi, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jQQ, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwX, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwY, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwp, R.color.cp_cont_a, 1, i);
            if (this.lwt != null) {
                this.lwt.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lwV, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).ad(dimens).ae(dimens).bk(this.lwp);
        }
        this.ajq = i;
    }
}
