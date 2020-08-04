package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.ad;
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
/* loaded from: classes16.dex */
public class aa extends ad.a implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c ahO;
    public int aho;
    private TextView dJr;
    private TextView iLL;
    private TbImageView ixo;
    private View ixt;
    private BdUniqueId ixz;
    private z kqC;
    private View kqD;
    private DynamicUserLikeButton kqE;
    private TextView kqF;
    private TextView kqG;
    private View kqH;
    private View kqI;
    private NEGFeedBackView kqJ;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.aho = 3;
        this.pageContext = tbPageContext;
        this.ixz = bdUniqueId;
        if (view != null) {
            this.ixt = view.findViewById(R.id.rootLayout);
            this.kqD = view.findViewById(R.id.top_divider_line);
            this.dJr = (TextView) view.findViewById(R.id.titleView);
            this.kqE = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.kqF = (TextView) view.findViewById(R.id.alaStateView);
            this.ixo = (TbImageView) view.findViewById(R.id.coverView);
            this.iLL = (TextView) view.findViewById(R.id.descView);
            this.kqG = (TextView) view.findViewById(R.id.hotView);
            this.kqH = view.findViewById(R.id.hotPoint);
            this.kqI = view.findViewById(R.id.bottomSpaceView);
            this.kqE.setTextSize(R.dimen.tbds28);
            this.ixo.setPlaceHolder(2);
            this.ixo.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.ixo.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.kqC = zVar;
            this.ixt.setOnClickListener(this);
            this.ixo.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.kqF.setVisibility(0);
            } else {
                this.kqF.setVisibility(8);
            }
            this.iLL.setText(zVar.description);
            this.dJr.setText(String.format(this.dJr.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.as.getFixedText(zVar.userName, 7, true)));
            this.kqG.setText(String.format(this.kqG.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.as.numFormatOverWan(zVar.kqy)));
            this.kqI.setVisibility(zVar.kqA ? 8 : 0);
            c(zVar.kqB);
            cND();
        }
    }

    private void c(com.baidu.tbadk.core.data.aq aqVar) {
        if (this.pageContext != null) {
            if (aqVar == null) {
                if (this.kqJ != null) {
                    this.kqJ.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kqJ == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.kqJ = new NEGFeedBackView(this.pageContext);
                this.kqJ.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.ixt.findViewById(R.id.contentLayout)).addView(this.kqJ, layoutParams);
                this.kqJ.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void b(com.baidu.tbadk.core.data.aq aqVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13858").ah("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void a(com.baidu.tbadk.core.data.aq aqVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void a(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.aq aqVar2) {
                    }
                });
            }
            this.kqJ.setVisibility(0);
            this.kqJ.setData(aqVar);
            this.kqJ.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.aho != i) {
            com.baidu.tbadk.core.util.ao.b(this.ixt, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ao.setBackgroundColor(this.kqD, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.iLL, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.dJr, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kqG, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ao.setViewTextColor(this.kqF, R.color.cp_cont_a, 1, i);
            if (this.kqJ != null) {
                this.kqJ.onChangeSkinType();
            }
            this.kqH.setBackgroundDrawable(com.baidu.tbadk.core.util.ao.aH(com.baidu.adp.lib.util.l.getDimens(this.kqH.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ao.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kqF.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bbr().ma(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).S(dimens).T(dimens).aX(this.kqF);
            this.kqE.onChangeSkinType(i);
        }
        this.aho = i;
    }

    private void cND() {
        if (this.kqC == null || this.kqC.dSF == null) {
            this.kqE.setVisibility(8);
            return;
        }
        this.kqE.setVisibility(0);
        if (this.ahO == null) {
            this.ahO = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.kqE);
            this.ahO.m(this.ixz);
        }
        this.ahO.a(this.kqC.dSF);
        this.kqE.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bX(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.kqC != null && aa.this.kqC.dSF != null) {
                    com.baidu.tbadk.core.util.ap dn = new com.baidu.tbadk.core.util.ap("c13718").dn("fid", aa.this.pbData.getForum().getId()).dn("fname", aa.this.pbData.getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", aa.this.pbData.getThreadId());
                    if (aa.this.kqC.dSF != null) {
                        str = aa.this.kqC.dSF.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dn.dn("friend_uid", str).ah("obj_type", aa.this.kqC.dSF.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kqC != null && id == R.id.rootLayout) {
            b(this.kqC);
            c(this.kqC);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                dU(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.ixt.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void dU(String str, String str2) {
        com.baidu.tbadk.core.util.bd.baV().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13709").dn("fid", this.pbData.getForum().getId()).dn("fname", this.pbData.getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", this.pbData.getThreadId()).dn("obj_param1", zVar.dSF != null ? zVar.dSF.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kqC != null && !this.kqC.kqz) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c13708").dn("fid", fVar.getForum().getId()).dn("fname", fVar.getForum().getName()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("tid", fVar.getThreadId()).dn("obj_param1", this.kqC.dSF != null ? this.kqC.dSF.getUserId() : ""));
            this.kqC.kqz = true;
        }
    }
}
