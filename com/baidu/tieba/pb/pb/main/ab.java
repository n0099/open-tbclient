package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ab extends aa.a implements View.OnClickListener {
    private int agt;
    private View iJc;
    private TextView inM;
    private TextView jMR;
    private TbImageView jMS;
    private PbActivity jNh;
    private aa jNi;
    private TextView jNj;
    private TextView jNk;
    private com.baidu.tieba.pb.data.e pbData;

    public ab(View view, PbActivity pbActivity) {
        super(view);
        this.agt = 3;
        this.jNh = pbActivity;
        this.iJc = view.findViewById(R.id.rootLayout);
        this.jMS = (TbImageView) view.findViewById(R.id.coverView);
        this.jMR = (TextView) view.findViewById(R.id.alaStateView);
        this.inM = (TextView) view.findViewById(R.id.descView);
        this.jNj = (TextView) view.findViewById(R.id.userInfoView);
        this.jNk = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.jMS.setConrers(15);
        this.jMS.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.jMS.setPlaceHolder(2);
    }

    public void a(aa aaVar) {
        Aj(TbadkCoreApplication.getInst().getSkinType());
        if (aaVar != null) {
            this.jNi = aaVar;
            this.iJc.setOnClickListener(this);
            this.jMS.startLoad(aaVar.cover, 10, false);
            if (aaVar.liveStatus == 1 && aaVar.liveId > 0) {
                this.jMR.setVisibility(0);
            } else {
                this.jMR.setVisibility(8);
            }
            this.inM.setText(aaVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jNk.getLayoutParams();
            if (!com.baidu.tbadk.core.util.aq.isEmpty(aaVar.userName)) {
                this.jNj.setText(aaVar.userName);
                this.jNj.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.jNj.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.jNk.setLayoutParams(layoutParams);
            this.jNk.setText(String.format(this.jNh.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.aq.numFormatOverWan(aaVar.jMM)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.jNi != null && id == R.id.rootLayout) {
            b(this.jNi);
            c(this.jNi);
        }
    }

    private void b(aa aaVar) {
        if (aaVar != null && aaVar.liveStatus == 1) {
            if (aaVar.isChushou) {
                dN(aaVar.thirdRoomId, aaVar.thirdLiveType);
            } else if (aaVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = aaVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jNh, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dN(String str, String str2) {
        com.baidu.tbadk.core.util.ba.aUZ().b(this.jNh.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(aa aaVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13717").dh("fid", this.pbData.getForum().getId()).dh("fname", this.pbData.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", this.pbData.getThreadId()).dh("obj_param1", aaVar.dFJ != null ? aaVar.dFJ.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.getForum() != null && this.jNi != null && !this.jNi.jMN) {
            this.pbData = eVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13716").dh("fid", eVar.getForum().getId()).dh("fname", eVar.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", eVar.getThreadId()).dh("obj_param1", this.jNi.dFJ != null ? this.jNi.dFJ.getUserId() : ""));
            this.jNi.jMN = true;
        }
    }

    private void Aj(int i) {
        if (this.agt != i) {
            com.baidu.tbadk.core.util.am.b(this.iJc, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.inM, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jNj, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jNk, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jMR, R.color.cp_cont_a, 1, i);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jNh, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.aVv().ln(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).Q(dimens).R(dimens).aR(this.jMR);
        }
        this.agt = i;
    }
}
