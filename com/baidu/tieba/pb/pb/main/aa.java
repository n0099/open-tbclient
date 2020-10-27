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
    private com.baidu.tbadk.core.view.userLike.c ajW;
    public int ajq;
    private TextView epn;
    private TextView jKS;
    private TbImageView jwg;
    private View jwl;
    private BdUniqueId jwu;
    private z lqp;
    private View lqq;
    private DynamicUserLikeButton lqr;
    private TextView lqs;
    private TextView lqt;
    private View lqu;
    private View lqv;
    private NEGFeedBackView lqw;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ajq = 3;
        this.pageContext = tbPageContext;
        this.jwu = bdUniqueId;
        if (view != null) {
            this.jwl = view.findViewById(R.id.rootLayout);
            this.lqq = view.findViewById(R.id.top_divider_line);
            this.epn = (TextView) view.findViewById(R.id.titleView);
            this.lqr = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lqs = (TextView) view.findViewById(R.id.alaStateView);
            this.jwg = (TbImageView) view.findViewById(R.id.coverView);
            this.jKS = (TextView) view.findViewById(R.id.descView);
            this.lqt = (TextView) view.findViewById(R.id.hotView);
            this.lqu = view.findViewById(R.id.hotPoint);
            this.lqv = view.findViewById(R.id.bottomSpaceView);
            this.lqr.setTextSize(R.dimen.tbds28);
            this.jwg.setPlaceHolder(2);
            this.jwg.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jwg.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.lqp = zVar;
            this.jwl.setOnClickListener(this);
            this.jwg.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.lqs.setVisibility(0);
            } else {
                this.lqs.setVisibility(8);
            }
            this.jKS.setText(zVar.description);
            this.epn.setText(String.format(this.epn.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(zVar.userName, 7, true)));
            this.lqt.setText(String.format(this.lqt.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(zVar.lql)));
            this.lqv.setVisibility(zVar.lqn ? 8 : 0);
            b(zVar.lqo);
            diM();
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.pageContext != null) {
            if (arVar == null) {
                if (this.lqw != null) {
                    this.lqw.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lqw == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lqw = new NEGFeedBackView(this.pageContext);
                this.lqw.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.jwl.findViewById(R.id.contentLayout)).addView(this.lqw, layoutParams);
                this.lqw.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
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
            this.lqw.setVisibility(0);
            this.lqw.setData(arVar);
            this.lqw.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.ajq != i) {
            com.baidu.tbadk.core.util.ap.b(this.jwl, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lqq, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jKS, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.epn, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lqt, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lqs, R.color.cp_cont_a, 1, i);
            if (this.lqw != null) {
                this.lqw.onChangeSkinType();
            }
            this.lqu.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.lqu.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lqs.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.bpo().oZ(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).ab(dimens).ac(dimens).bg(this.lqs);
            this.lqr.onChangeSkinType(i);
        }
        this.ajq = i;
    }

    private void diM() {
        if (this.lqp == null || this.lqp.eyV == null) {
            this.lqr.setVisibility(8);
            return;
        }
        this.lqr.setVisibility(0);
        if (this.ajW == null) {
            this.ajW = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lqr);
            this.ajW.l(this.jwu);
        }
        this.ajW.a(this.lqp.eyV);
        this.lqr.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cq(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.lqp != null && aa.this.lqp.eyV != null) {
                    com.baidu.tbadk.core.util.aq dR = new com.baidu.tbadk.core.util.aq("c13718").dR("fid", aa.this.pbData.getForum().getId()).dR("fname", aa.this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", aa.this.pbData.getThreadId());
                    if (aa.this.lqp.eyV != null) {
                        str = aa.this.lqp.eyV.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dR.dR("friend_uid", str).aj("obj_type", aa.this.lqp.eyV.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lqp != null && id == R.id.rootLayout) {
            b(this.lqp);
            c(this.lqp);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                eC(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jwl.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eC(String str, String str2) {
        com.baidu.tbadk.core.util.be.boR().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", zVar.eyV != null ? zVar.eyV.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lqp != null && !this.lqp.lqm) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lqp.eyV != null ? this.lqp.eyV.getUserId() : ""));
            this.lqp.lqm = true;
        }
    }
}
