package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ab extends ad.a implements View.OnClickListener {
    private int ahx;
    private TextView iFF;
    private TbImageView iri;
    private View irn;
    private TextView khL;
    private PbActivity kia;
    private aa kib;
    private TextView kic;
    private TextView kie;
    private com.baidu.tieba.pb.data.e pbData;

    public ab(View view, PbActivity pbActivity) {
        super(view);
        this.ahx = 3;
        this.kia = pbActivity;
        this.irn = view.findViewById(R.id.rootLayout);
        this.iri = (TbImageView) view.findViewById(R.id.coverView);
        this.khL = (TextView) view.findViewById(R.id.alaStateView);
        this.iFF = (TextView) view.findViewById(R.id.descView);
        this.kic = (TextView) view.findViewById(R.id.userInfoView);
        this.kie = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.iri.setConrers(15);
        this.iri.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.iri.setPlaceHolder(2);
    }

    public void a(aa aaVar) {
        xr(TbadkCoreApplication.getInst().getSkinType());
        if (aaVar != null) {
            this.kib = aaVar;
            this.irn.setOnClickListener(this);
            this.iri.startLoad(aaVar.cover, 10, false);
            if (aaVar.liveStatus == 1 && aaVar.liveId > 0) {
                this.khL.setVisibility(0);
            } else {
                this.khL.setVisibility(8);
            }
            this.iFF.setText(aaVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kie.getLayoutParams();
            if (!com.baidu.tbadk.core.util.ar.isEmpty(aaVar.userName)) {
                this.kic.setText(aaVar.userName);
                this.kic.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.kic.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.kie.setLayoutParams(layoutParams);
            this.kie.setText(String.format(this.kia.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.ar.numFormatOverWan(aaVar.khG)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kib != null && id == R.id.rootLayout) {
            b(this.kib);
            c(this.kib);
        }
    }

    private void b(aa aaVar) {
        if (aaVar != null && aaVar.liveStatus == 1) {
            if (aaVar.isChushou) {
                dS(aaVar.thirdRoomId, aaVar.thirdLiveType);
            } else if (aaVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = aaVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.kia, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dS(String str, String str2) {
        bc.aWU().b(this.kia.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(aa aaVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13717").dk("fid", this.pbData.getForum().getId()).dk("fname", this.pbData.getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", this.pbData.getThreadId()).dk("obj_param1", aaVar.dMu != null ? aaVar.dMu.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.getForum() != null && this.kib != null && !this.kib.khH) {
            this.pbData = eVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c13716").dk("fid", eVar.getForum().getId()).dk("fname", eVar.getForum().getName()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("tid", eVar.getThreadId()).dk("obj_param1", this.kib.dMu != null ? this.kib.dMu.getUserId() : ""));
            this.kib.khH = true;
        }
    }

    private void xr(int i) {
        if (this.ahx != i) {
            com.baidu.tbadk.core.util.an.b(this.irn, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.iFF, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kic, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.kie, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.an.setViewTextColor(this.khL, R.color.cp_cont_a, 1, i);
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kia, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.aXq().lG(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).S(dimens).T(dimens).aR(this.khL);
        }
        this.ahx = i;
    }
}
