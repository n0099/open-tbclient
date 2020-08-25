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
    public int aiB;
    private com.baidu.tbadk.core.view.userLike.c ajc;
    private TextView dSz;
    private TbImageView iLZ;
    private View iMe;
    private BdUniqueId iMn;
    private TextView jaJ;
    private z kFU;
    private View kFV;
    private DynamicUserLikeButton kFW;
    private TextView kFX;
    private TextView kFY;
    private View kFZ;
    private View kGa;
    private NEGFeedBackView kGb;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.aiB = 3;
        this.pageContext = tbPageContext;
        this.iMn = bdUniqueId;
        if (view != null) {
            this.iMe = view.findViewById(R.id.rootLayout);
            this.kFV = view.findViewById(R.id.top_divider_line);
            this.dSz = (TextView) view.findViewById(R.id.titleView);
            this.kFW = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.kFX = (TextView) view.findViewById(R.id.alaStateView);
            this.iLZ = (TbImageView) view.findViewById(R.id.coverView);
            this.jaJ = (TextView) view.findViewById(R.id.descView);
            this.kFY = (TextView) view.findViewById(R.id.hotView);
            this.kFZ = view.findViewById(R.id.hotPoint);
            this.kGa = view.findViewById(R.id.bottomSpaceView);
            this.kFW.setTextSize(R.dimen.tbds28);
            this.iLZ.setPlaceHolder(2);
            this.iLZ.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.iLZ.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.kFU = zVar;
            this.iMe.setOnClickListener(this);
            this.iLZ.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.kFX.setVisibility(0);
            } else {
                this.kFX.setVisibility(8);
            }
            this.jaJ.setText(zVar.description);
            this.dSz.setText(String.format(this.dSz.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(zVar.userName, 7, true)));
            this.kFY.setText(String.format(this.kFY.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(zVar.kFQ)));
            this.kGa.setVisibility(zVar.kFS ? 8 : 0);
            b(zVar.kFT);
            cYs();
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.pageContext != null) {
            if (arVar == null) {
                if (this.kGb != null) {
                    this.kGb.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.kGb == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.kGb = new NEGFeedBackView(this.pageContext);
                this.kGb.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.iMe.findViewById(R.id.contentLayout)).addView(this.kGb, layoutParams);
                this.kGb.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
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
            this.kGb.setVisibility(0);
            this.kGb.setData(arVar);
            this.kGb.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.aiB != i) {
            com.baidu.tbadk.core.util.ap.b(this.iMe, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.kFV, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jaJ, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.dSz, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFY, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kFX, R.color.cp_cont_a, 1, i);
            if (this.kGb != null) {
                this.kGb.onChangeSkinType();
            }
            this.kFZ.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.kFZ.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.kFX.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bjQ().oe(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).X(dimens).Y(dimens).aZ(this.kFX);
            this.kFW.onChangeSkinType(i);
        }
        this.aiB = i;
    }

    private void cYs() {
        if (this.kFU == null || this.kFU.ecb == null) {
            this.kFW.setVisibility(8);
            return;
        }
        this.kFW.setVisibility(0);
        if (this.ajc == null) {
            this.ajc = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.kFW);
            this.ajc.m(this.iMn);
        }
        this.ajc.a(this.kFU.ecb);
        this.kFW.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void bZ(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.kFU != null && aa.this.kFU.ecb != null) {
                    com.baidu.tbadk.core.util.aq dD = new com.baidu.tbadk.core.util.aq("c13718").dD("fid", aa.this.pbData.getForum().getId()).dD("fname", aa.this.pbData.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", aa.this.pbData.getThreadId());
                    if (aa.this.kFU.ecb != null) {
                        str = aa.this.kFU.ecb.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dD.dD("friend_uid", str).ai("obj_type", aa.this.kFU.ecb.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.kFU != null && id == R.id.rootLayout) {
            b(this.kFU);
            c(this.kFU);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                el(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.iMe.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void el(String str, String str2) {
        com.baidu.tbadk.core.util.be.bju().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dD("fid", this.pbData.getForum().getId()).dD("fname", this.pbData.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", this.pbData.getThreadId()).dD("obj_param1", zVar.ecb != null ? zVar.ecb.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.kFU != null && !this.kFU.kFR) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dD("fid", fVar.getForum().getId()).dD("fname", fVar.getForum().getName()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("tid", fVar.getThreadId()).dD("obj_param1", this.kFU.ecb != null ? this.kFU.ecb.getUserId() : ""));
            this.kFU.kFR = true;
        }
    }
}
