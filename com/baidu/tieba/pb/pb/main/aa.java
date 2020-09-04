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
/* loaded from: classes16.dex */
public class aa extends af.a implements View.OnClickListener {
    public int aiD;
    private com.baidu.tbadk.core.view.userLike.c aje;
    private TextView dSD;
    private TbImageView iMf;
    private View iMk;
    private BdUniqueId iMt;
    private TextView jaP;
    private z kGb;
    private View kGc;
    private DynamicUserLikeButton kGd;
    private TextView kGe;
    private TextView kGf;
    private View kGg;
    private View kGh;
    private NEGFeedBackView kGi;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.aiD = 3;
        this.pageContext = tbPageContext;
        this.iMt = bdUniqueId;
        if (view != null) {
            this.iMk = view.findViewById(R.id.rootLayout);
            this.kGc = view.findViewById(R.id.top_divider_line);
            this.dSD = (TextView) view.findViewById(R.id.titleView);
            this.kGd = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.kGe = (TextView) view.findViewById(R.id.alaStateView);
            this.iMf = (TbImageView) view.findViewById(R.id.coverView);
            this.jaP = (TextView) view.findViewById(R.id.descView);
            this.kGf = (TextView) view.findViewById(R.id.hotView);
            this.kGg = view.findViewById(R.id.hotPoint);
            this.kGh = view.findViewById(R.id.bottomSpaceView);
            this.kGd.setTextSize(R.dimen.tbds28);
            this.iMf.setPlaceHolder(2);
            this.iMf.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.iMf.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.kGb = zVar;
            this.iMk.setOnClickListener(this);
            this.iMf.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.kGe.setVisibility(0);
            } else {
                this.kGe.setVisibility(8);
            }
            this.jaP.setText(zVar.description);
            this.dSD.setText(String.format(this.dSD.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(zVar.userName, 7, true)));
            this.kGf.setText(String.format(this.kGf.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(zVar.kFX)));
            this.kGh.setVisibility(zVar.kFZ ? 8 : 0);
            b(zVar.kGa);
            cYt();
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.pageContext != null) {
            if (arVar == null) {
                if (this.kGi != null) {
                    this.kGi.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kGi == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.kGi = new NEGFeedBackView(this.pageContext);
                this.kGi.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.iMk.findViewById(R.id.contentLayout)).addView(this.kGi, layoutParams);
                this.kGi.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
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
            this.kGi.setVisibility(0);
            this.kGi.setData(arVar);
            this.kGi.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.aiD != i) {
            com.baidu.tbadk.core.util.ap.b(this.iMk, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kGc, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jaP, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.dSD, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGf, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kGe, R.color.cp_cont_a, 1, i);
            if (this.kGi != null) {
                this.kGi.onChangeSkinType();
            }
            this.kGg.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.kGg.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kGe.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).X(dimens).Y(dimens).aZ(this.kGe);
            this.kGd.onChangeSkinType(i);
        }
        this.aiD = i;
    }

    private void cYt() {
        if (this.kGb == null || this.kGb.ecf == null) {
            this.kGd.setVisibility(8);
            return;
        }
        this.kGd.setVisibility(0);
        if (this.aje == null) {
            this.aje = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.kGd);
            this.aje.m(this.iMt);
        }
        this.aje.a(this.kGb.ecf);
        this.kGd.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bZ(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.kGb != null && aa.this.kGb.ecf != null) {
                    com.baidu.tbadk.core.util.aq dD = new com.baidu.tbadk.core.util.aq("c13718").dD("fid", aa.this.pbData.getForum().getId()).dD("fname", aa.this.pbData.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", aa.this.pbData.getThreadId());
                    if (aa.this.kGb.ecf != null) {
                        str = aa.this.kGb.ecf.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dD.dD("friend_uid", str).ai("obj_type", aa.this.kGb.ecf.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kGb != null && id == R.id.rootLayout) {
            b(this.kGb);
            c(this.kGb);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                em(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iMk.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void em(String str, String str2) {
        com.baidu.tbadk.core.util.be.bju().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dD("fid", this.pbData.getForum().getId()).dD("fname", this.pbData.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", this.pbData.getThreadId()).dD("obj_param1", zVar.ecf != null ? zVar.ecf.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kGb != null && !this.kGb.kFY) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dD("fid", fVar.getForum().getId()).dD("fname", fVar.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", fVar.getThreadId()).dD("obj_param1", this.kGb.ecf != null ? this.kGb.ecf.getUserId() : ""));
            this.kGb.kFY = true;
        }
    }
}
