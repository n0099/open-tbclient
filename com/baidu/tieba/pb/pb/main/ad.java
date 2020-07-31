package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.ad;
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
public class ad extends ad.a implements View.OnClickListener {
    private int aho;
    private TextView iLJ;
    private TbImageView ixm;
    private View ixr;
    private TextView kqD;
    private NEGFeedBackView kqH;
    private PbActivity kqV;
    private ac kqW;
    private TextView kqX;
    private TextView kqY;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.aho = 3;
        this.kqV = pbActivity;
        this.ixr = view.findViewById(R.id.rootLayout);
        this.ixm = (TbImageView) view.findViewById(R.id.coverView);
        this.kqD = (TextView) view.findViewById(R.id.alaStateView);
        this.iLJ = (TextView) view.findViewById(R.id.descView);
        this.kqX = (TextView) view.findViewById(R.id.userInfoView);
        this.kqY = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.ixm.setConrers(15);
        this.ixm.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.ixm.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        xJ(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.kqW = acVar;
            this.ixr.setOnClickListener(this);
            this.ixm.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.kqD.setVisibility(0);
            } else {
                this.kqD.setVisibility(8);
            }
            this.iLJ.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kqY.getLayoutParams();
            if (!com.baidu.tbadk.core.util.as.isEmpty(acVar.userName)) {
                this.kqX.setText(acVar.userName);
                this.kqX.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kqX.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kqY.setLayoutParams(layoutParams);
            this.kqY.setText(String.format(this.kqV.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.as.numFormatOverWan(acVar.kqw)));
            c(acVar.kqz);
        }
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar) {
        if (this.kqV != null) {
            if (aqVar == null) {
                if (this.kqH != null) {
                    this.kqH.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kqH == null) {
                this.kqH = new NEGFeedBackView(this.kqV.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.kqV, R.dimen.tbds44);
                this.kqH.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.kqV, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.kqV, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.kqV, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.ixr).addView(this.kqH, layoutParams);
                this.kqH.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void b(com.baidu.tbadk.core.data.aq aqVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13858").ah("obj_type", 2));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void a(com.baidu.tbadk.core.data.aq aqVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void a(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.aq aqVar2) {
                    }
                });
            }
            this.kqH.setVisibility(0);
            this.kqH.setData(aqVar);
            this.kqH.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kqW != null && id == R.id.rootLayout) {
            b(this.kqW);
            c(this.kqW);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                dU(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kqV, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dU(String str, String str2) {
        com.baidu.tbadk.core.util.bd.baV().b(this.kqV.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13717").dn("fid", this.pbData.getForum().getId()).dn("fname", this.pbData.getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", this.pbData.getThreadId()).dn("obj_param1", acVar.dSF != null ? acVar.dSF.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kqW != null && !this.kqW.kqx) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13716").dn("fid", fVar.getForum().getId()).dn("fname", fVar.getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", fVar.getThreadId()).dn("obj_param1", this.kqW.dSF != null ? this.kqW.dSF.getUserId() : ""));
            this.kqW.kqx = true;
        }
    }

    private void xJ(int i) {
        if (this.aho != i) {
            com.baidu.tbadk.core.util.ao.b(this.ixr, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.iLJ, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kqX, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kqY, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kqD, R.color.cp_cont_a, 1, i);
            if (this.kqH != null) {
                this.kqH.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kqV, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).S(dimens).T(dimens).aX(this.kqD);
        }
        this.aho = i;
    }
}
