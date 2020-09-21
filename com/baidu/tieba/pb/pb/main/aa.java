package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class aa extends af.a implements View.OnClickListener {
    public int aiX;
    private com.baidu.tbadk.core.view.userLike.c ajD;
    private TextView dUN;
    private TbImageView iUL;
    private View iUQ;
    private BdUniqueId iUZ;
    private TextView jjv;
    private z kOA;
    private View kOB;
    private DynamicUserLikeButton kOC;
    private TextView kOD;
    private TextView kOE;
    private View kOF;
    private View kOG;
    private NEGFeedBackView kOH;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.aiX = 3;
        this.pageContext = tbPageContext;
        this.iUZ = bdUniqueId;
        if (view != null) {
            this.iUQ = view.findViewById(R.id.rootLayout);
            this.kOB = view.findViewById(R.id.top_divider_line);
            this.dUN = (TextView) view.findViewById(R.id.titleView);
            this.kOC = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.kOD = (TextView) view.findViewById(R.id.alaStateView);
            this.iUL = (TbImageView) view.findViewById(R.id.coverView);
            this.jjv = (TextView) view.findViewById(R.id.descView);
            this.kOE = (TextView) view.findViewById(R.id.hotView);
            this.kOF = view.findViewById(R.id.hotPoint);
            this.kOG = view.findViewById(R.id.bottomSpaceView);
            this.kOC.setTextSize(R.dimen.tbds28);
            this.iUL.setPlaceHolder(2);
            this.iUL.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.iUL.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.kOA = zVar;
            this.iUQ.setOnClickListener(this);
            this.iUL.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.kOD.setVisibility(0);
            } else {
                this.kOD.setVisibility(8);
            }
            this.jjv.setText(zVar.description);
            this.dUN.setText(String.format(this.dUN.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(zVar.userName, 7, true)));
            this.kOE.setText(String.format(this.kOE.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(zVar.kOw)));
            this.kOG.setVisibility(zVar.kOy ? 8 : 0);
            b(zVar.kOz);
            dbW();
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.pageContext != null) {
            if (arVar == null) {
                if (this.kOH != null) {
                    this.kOH.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kOH == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.kOH = new NEGFeedBackView(this.pageContext);
                this.kOH.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.iUQ.findViewById(R.id.contentLayout)).addView(this.kOH, layoutParams);
                this.kOH.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.ar arVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").ai("obj_type", 1));
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

    private void onChangeSkinType(int i) {
        if (this.aiX != i) {
            com.baidu.tbadk.core.util.ap.b(this.iUQ, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kOB, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jjv, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.dUN, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kOE, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kOD, R.color.cp_cont_a, 1, i);
            if (this.kOH != null) {
                this.kOH.onChangeSkinType();
            }
            this.kOF.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.kOF.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kOD.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bkL().oq(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).X(dimens).Y(dimens).bb(this.kOD);
            this.kOC.onChangeSkinType(i);
        }
        this.aiX = i;
    }

    private void dbW() {
        if (this.kOA == null || this.kOA.eep == null) {
            this.kOC.setVisibility(8);
            return;
        }
        this.kOC.setVisibility(0);
        if (this.ajD == null) {
            this.ajD = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.kOC);
            this.ajD.l(this.iUZ);
        }
        this.ajD.a(this.kOA.eep);
        this.kOC.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void ci(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.kOA != null && aa.this.kOA.eep != null) {
                    com.baidu.tbadk.core.util.aq dF = new com.baidu.tbadk.core.util.aq("c13718").dF("fid", aa.this.pbData.getForum().getId()).dF("fname", aa.this.pbData.getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", aa.this.pbData.getThreadId());
                    if (aa.this.kOA.eep != null) {
                        str = aa.this.kOA.eep.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dF.dF("friend_uid", str).ai("obj_type", aa.this.kOA.eep.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kOA != null && id == R.id.rootLayout) {
            b(this.kOA);
            c(this.kOA);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                eq(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iUQ.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eq(String str, String str2) {
        com.baidu.tbadk.core.util.be.bkp().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dF("fid", this.pbData.getForum().getId()).dF("fname", this.pbData.getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", this.pbData.getThreadId()).dF("obj_param1", zVar.eep != null ? zVar.eep.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kOA != null && !this.kOA.kOx) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dF("fid", fVar.getForum().getId()).dF("fname", fVar.getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", fVar.getThreadId()).dF("obj_param1", this.kOA.eep != null ? this.kOA.eep.getUserId() : ""));
            this.kOA.kOx = true;
        }
    }
}
