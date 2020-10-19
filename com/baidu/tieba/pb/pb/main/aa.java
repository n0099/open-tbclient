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
/* loaded from: classes22.dex */
public class aa extends af.a implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c ajV;
    public int ajp;
    private TextView egP;
    private TbImageView jjJ;
    private View jjO;
    private BdUniqueId jjX;
    private TextView jyt;
    private z ldM;
    private View ldN;
    private DynamicUserLikeButton ldO;
    private TextView ldP;
    private TextView ldQ;
    private View ldR;
    private View ldS;
    private NEGFeedBackView ldT;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ajp = 3;
        this.pageContext = tbPageContext;
        this.jjX = bdUniqueId;
        if (view != null) {
            this.jjO = view.findViewById(R.id.rootLayout);
            this.ldN = view.findViewById(R.id.top_divider_line);
            this.egP = (TextView) view.findViewById(R.id.titleView);
            this.ldO = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.ldP = (TextView) view.findViewById(R.id.alaStateView);
            this.jjJ = (TbImageView) view.findViewById(R.id.coverView);
            this.jyt = (TextView) view.findViewById(R.id.descView);
            this.ldQ = (TextView) view.findViewById(R.id.hotView);
            this.ldR = view.findViewById(R.id.hotPoint);
            this.ldS = view.findViewById(R.id.bottomSpaceView);
            this.ldO.setTextSize(R.dimen.tbds28);
            this.jjJ.setPlaceHolder(2);
            this.jjJ.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jjJ.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.ldM = zVar;
            this.jjO.setOnClickListener(this);
            this.jjJ.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.ldP.setVisibility(0);
            } else {
                this.ldP.setVisibility(8);
            }
            this.jyt.setText(zVar.description);
            this.egP.setText(String.format(this.egP.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(zVar.userName, 7, true)));
            this.ldQ.setText(String.format(this.ldQ.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(zVar.ldI)));
            this.ldS.setVisibility(zVar.ldK ? 8 : 0);
            b(zVar.ldL);
            dfF();
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.pageContext != null) {
            if (arVar == null) {
                if (this.ldT != null) {
                    this.ldT.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.ldT == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.ldT = new NEGFeedBackView(this.pageContext);
                this.ldT.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.jjO.findViewById(R.id.contentLayout)).addView(this.ldT, layoutParams);
                this.ldT.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.ar arVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").aj("obj_type", 1));
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

    private void onChangeSkinType(int i) {
        if (this.ajp != i) {
            com.baidu.tbadk.core.util.ap.b(this.jjO, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.ldN, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jyt, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.egP, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldQ, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.ldP, R.color.cp_cont_a, 1, i);
            if (this.ldT != null) {
                this.ldT.onChangeSkinType();
            }
            this.ldR.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aN(com.baidu.adp.lib.util.l.getDimens(this.ldR.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.ldP.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bnv().oO(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).Z(dimens).aa(dimens).bf(this.ldP);
            this.ldO.onChangeSkinType(i);
        }
        this.ajp = i;
    }

    private void dfF() {
        if (this.ldM == null || this.ldM.equ == null) {
            this.ldO.setVisibility(8);
            return;
        }
        this.ldO.setVisibility(0);
        if (this.ajV == null) {
            this.ajV = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.ldO);
            this.ajV.l(this.jjX);
        }
        this.ajV.a(this.ldM.equ);
        this.ldO.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cm(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.ldM != null && aa.this.ldM.equ != null) {
                    com.baidu.tbadk.core.util.aq dK = new com.baidu.tbadk.core.util.aq("c13718").dK("fid", aa.this.pbData.getForum().getId()).dK("fname", aa.this.pbData.getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", aa.this.pbData.getThreadId());
                    if (aa.this.ldM.equ != null) {
                        str = aa.this.ldM.equ.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dK.dK("friend_uid", str).aj("obj_type", aa.this.ldM.equ.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.ldM != null && id == R.id.rootLayout) {
            b(this.ldM);
            c(this.ldM);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                ex(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jjO.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void ex(String str, String str2) {
        com.baidu.tbadk.core.util.be.bmY().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dK("fid", this.pbData.getForum().getId()).dK("fname", this.pbData.getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", this.pbData.getThreadId()).dK("obj_param1", zVar.equ != null ? zVar.equ.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.ldM != null && !this.ldM.ldJ) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dK("fid", fVar.getForum().getId()).dK("fname", fVar.getForum().getName()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("tid", fVar.getThreadId()).dK("obj_param1", this.ldM.equ != null ? this.ldM.equ.getUserId() : ""));
            this.ldM.ldJ = true;
        }
    }
}
