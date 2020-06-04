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
    private View iJP;
    private TextView ioz;
    private TextView jNX;
    private TbImageView jNY;
    private PbActivity jOn;
    private aa jOo;
    private TextView jOp;
    private TextView jOq;
    private com.baidu.tieba.pb.data.e pbData;

    public ab(View view, PbActivity pbActivity) {
        super(view);
        this.agt = 3;
        this.jOn = pbActivity;
        this.iJP = view.findViewById(R.id.rootLayout);
        this.jNY = (TbImageView) view.findViewById(R.id.coverView);
        this.jNX = (TextView) view.findViewById(R.id.alaStateView);
        this.ioz = (TextView) view.findViewById(R.id.descView);
        this.jOp = (TextView) view.findViewById(R.id.userInfoView);
        this.jOq = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.jNY.setConrers(15);
        this.jNY.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.jNY.setPlaceHolder(2);
    }

    public void a(aa aaVar) {
        Al(TbadkCoreApplication.getInst().getSkinType());
        if (aaVar != null) {
            this.jOo = aaVar;
            this.iJP.setOnClickListener(this);
            this.jNY.startLoad(aaVar.cover, 10, false);
            if (aaVar.liveStatus == 1 && aaVar.liveId > 0) {
                this.jNX.setVisibility(0);
            } else {
                this.jNX.setVisibility(8);
            }
            this.ioz.setText(aaVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jOq.getLayoutParams();
            if (!com.baidu.tbadk.core.util.aq.isEmpty(aaVar.userName)) {
                this.jOp.setText(aaVar.userName);
                this.jOp.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.jOp.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.jOq.setLayoutParams(layoutParams);
            this.jOq.setText(String.format(this.jOn.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.aq.numFormatOverWan(aaVar.jNS)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.jOo != null && id == R.id.rootLayout) {
            b(this.jOo);
            c(this.jOo);
        }
    }

    private void b(aa aaVar) {
        if (aaVar != null && aaVar.liveStatus == 1) {
            if (aaVar.isChushou) {
                dN(aaVar.thirdRoomId, aaVar.thirdLiveType);
            } else if (aaVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = aaVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jOn, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dN(String str, String str2) {
        com.baidu.tbadk.core.util.ba.aVa().b(this.jOn.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(aa aaVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13717").dh("fid", this.pbData.getForum().getId()).dh("fname", this.pbData.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", this.pbData.getThreadId()).dh("obj_param1", aaVar.dFJ != null ? aaVar.dFJ.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.getForum() != null && this.jOo != null && !this.jOo.jNT) {
            this.pbData = eVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13716").dh("fid", eVar.getForum().getId()).dh("fname", eVar.getForum().getName()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("tid", eVar.getThreadId()).dh("obj_param1", this.jOo.dFJ != null ? this.jOo.dFJ.getUserId() : ""));
            this.jOo.jNT = true;
        }
    }

    private void Al(int i) {
        if (this.agt != i) {
            com.baidu.tbadk.core.util.am.b(this.iJP, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.ioz, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jOp, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jOq, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.am.setViewTextColor(this.jNX, R.color.cp_cont_a, 1, i);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.jOn, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.aVw().lp(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).Q(dimens).R(dimens).aR(this.jNX);
        }
        this.agt = i;
    }
}
