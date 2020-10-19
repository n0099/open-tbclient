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
    private int ajp;
    private TbImageView jjJ;
    private View jjO;
    private TextView jyt;
    private TextView ldP;
    private NEGFeedBackView ldT;
    private PbActivity lew;
    private ac lex;
    private TextView ley;
    private TextView lez;
    private com.baidu.tieba.pb.data.f pbData;

    public ad(View view, PbActivity pbActivity) {
        super(view);
        this.ajp = 3;
        this.lew = pbActivity;
        this.jjO = view.findViewById(R.id.rootLayout);
        this.jjJ = (TbImageView) view.findViewById(R.id.coverView);
        this.ldP = (TextView) view.findViewById(R.id.alaStateView);
        this.jyt = (TextView) view.findViewById(R.id.descView);
        this.ley = (TextView) view.findViewById(R.id.userInfoView);
        this.lez = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.jjJ.setConrers(15);
        this.jjJ.setRadius(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.jjJ.setPlaceHolder(2);
    }

    public void a(ac acVar) {
        Bk(TbadkCoreApplication.getInst().getSkinType());
        if (acVar != null) {
            this.lex = acVar;
            this.jjO.setOnClickListener(this);
            this.jjJ.startLoad(acVar.cover, 10, false);
            if (acVar.liveStatus == 1 && acVar.liveId > 0) {
                this.ldP.setVisibility(0);
            } else {
                this.ldP.setVisibility(8);
            }
            this.jyt.setText(acVar.description);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lez.getLayoutParams();
            if (!com.baidu.tbadk.core.util.at.isEmpty(acVar.userName)) {
                this.ley.setText(acVar.userName);
                this.ley.setVisibility(0);
                layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32);
            } else {
                this.ley.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.lez.setLayoutParams(layoutParams);
            this.lez.setText(String.format(this.lew.getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(acVar.ldI)));
            b(acVar.ldL);
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.lew != null) {
            if (arVar == null) {
                if (this.ldT != null) {
                    this.ldT.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.ldT == null) {
                this.ldT = new NEGFeedBackView(this.lew.getPageContext());
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.lew, R.dimen.tbds44);
                this.ldT.setPadding(dimens, dimens, dimens, com.baidu.adp.lib.util.l.getDimens(this.lew, R.dimen.tbds14));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.lew, R.dimen.tbds122), com.baidu.adp.lib.util.l.getDimens(this.lew, R.dimen.tbds92));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                ((ViewGroup) this.jjO).addView(this.ldT, layoutParams);
                this.ldT.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.ad.1
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
            this.ldT.setVisibility(0);
            this.ldT.setData(arVar);
            this.ldT.onChangeSkinType();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lex != null && id == R.id.rootLayout) {
            b(this.lex);
            c(this.lex);
        }
    }

    private void b(ac acVar) {
        if (acVar != null && acVar.liveStatus == 1) {
            if (acVar.isChushou) {
                ex(acVar.thirdRoomId, acVar.thirdLiveType);
            } else if (acVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = acVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.lew, alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_CROSS_RECOMMEND, null, false, "")));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ex(String str, String str2) {
        com.baidu.tbadk.core.util.be.bmY().b(this.lew.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(ac acVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13717").dK("fid", this.pbData.getForum().getId()).dK("fname", this.pbData.getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", this.pbData.getThreadId()).dK("obj_param1", acVar.equ != null ? acVar.equ.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lex != null && !this.lex.ldJ) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13716").dK("fid", fVar.getForum().getId()).dK("fname", fVar.getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", fVar.getThreadId()).dK("obj_param1", this.lex.equ != null ? this.lex.equ.getUserId() : ""));
            this.lex.ldJ = true;
        }
    }

    private void Bk(int i) {
        if (this.ajp != i) {
            com.baidu.tbadk.core.util.ap.b(this.jjO, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jyt, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ley, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lez, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldP, R.color.cp_cont_a, 1, i);
            if (this.ldT != null) {
                this.ldT.onChangeSkinType();
            }
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lew, R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).Z(dimens).aa(dimens).bf(this.ldP);
        }
        this.ajp = i;
    }
}
