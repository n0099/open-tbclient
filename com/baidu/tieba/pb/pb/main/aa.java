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
    private TextView evg;
    private TbImageView jCd;
    private View jCi;
    private BdUniqueId jCr;
    private TextView jQQ;
    private z lwm;
    private View lwn;
    private DynamicUserLikeButton lwo;
    private TextView lwp;
    private TextView lwq;
    private View lwr;
    private View lws;
    private NEGFeedBackView lwt;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.ajq = 3;
        this.pageContext = tbPageContext;
        this.jCr = bdUniqueId;
        if (view != null) {
            this.jCi = view.findViewById(R.id.rootLayout);
            this.lwn = view.findViewById(R.id.top_divider_line);
            this.evg = (TextView) view.findViewById(R.id.titleView);
            this.lwo = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lwp = (TextView) view.findViewById(R.id.alaStateView);
            this.jCd = (TbImageView) view.findViewById(R.id.coverView);
            this.jQQ = (TextView) view.findViewById(R.id.descView);
            this.lwq = (TextView) view.findViewById(R.id.hotView);
            this.lwr = view.findViewById(R.id.hotPoint);
            this.lws = view.findViewById(R.id.bottomSpaceView);
            this.lwo.setTextSize(R.dimen.tbds28);
            this.jCd.setPlaceHolder(2);
            this.jCd.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jCd.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.lwm = zVar;
            this.jCi.setOnClickListener(this);
            this.jCd.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.lwp.setVisibility(0);
            } else {
                this.lwp.setVisibility(8);
            }
            this.jQQ.setText(zVar.description);
            this.evg.setText(String.format(this.evg.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.at.getFixedText(zVar.userName, 7, true)));
            this.lwq.setText(String.format(this.lwq.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.at.numFormatOverWan(zVar.lwi)));
            this.lws.setVisibility(zVar.lwk ? 8 : 0);
            b(zVar.lwl);
            dlo();
        }
    }

    private void b(com.baidu.tbadk.core.data.ar arVar) {
        if (this.pageContext != null) {
            if (arVar == null) {
                if (this.lwt != null) {
                    this.lwt.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lwt == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lwt = new NEGFeedBackView(this.pageContext);
                this.lwt.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.jCi.findViewById(R.id.contentLayout)).addView(this.lwt, layoutParams);
                this.lwt.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.ar arVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13858").al("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.ar arVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.ar arVar2) {
                    }
                });
            }
            this.lwt.setVisibility(0);
            this.lwt.setData(arVar);
            this.lwt.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.ajq != i) {
            com.baidu.tbadk.core.util.ap.b(this.jCi, R.color.cp_bg_line_e, R.color.cp_bg_line_c, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lwn, R.color.cp_bg_line_c);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.jQQ, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.evg, R.color.cp_cont_b, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwq, R.color.cp_cont_d, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lwp, R.color.cp_cont_a, 1, i);
            if (this.lwt != null) {
                this.lwt.onChangeSkinType();
            }
            this.lwr.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aO(com.baidu.adp.lib.util.l.getDimens(this.lwr.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.cp_other_c)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lwp.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.brO().pj(0).b("TL_BR", R.color.cp_other_b, R.color.cp_cont_h).ad(dimens).ae(dimens).bk(this.lwp);
            this.lwo.onChangeSkinType(i);
        }
        this.ajq = i;
    }

    private void dlo() {
        if (this.lwm == null || this.lwm.eEK == null) {
            this.lwo.setVisibility(8);
            return;
        }
        this.lwo.setVisibility(0);
        if (this.ajW == null) {
            this.ajW = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lwo);
            this.ajW.l(this.jCr);
        }
        this.ajW.a(this.lwm.eEK);
        this.lwo.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cv(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.lwm != null && aa.this.lwm.eEK != null) {
                    com.baidu.tbadk.core.util.aq dR = new com.baidu.tbadk.core.util.aq("c13718").dR("fid", aa.this.pbData.getForum().getId()).dR("fname", aa.this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", aa.this.pbData.getThreadId());
                    if (aa.this.lwm.eEK != null) {
                        str = aa.this.lwm.eEK.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dR.dR("friend_uid", str).al("obj_type", aa.this.lwm.eEK.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lwm != null && id == R.id.rootLayout) {
            b(this.lwm);
            c(this.lwm);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                eC(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jCi.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eC(String str, String str2) {
        com.baidu.tbadk.core.util.be.brr().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13709").dR("fid", this.pbData.getForum().getId()).dR("fname", this.pbData.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", this.pbData.getThreadId()).dR("obj_param1", zVar.eEK != null ? zVar.eEK.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lwm != null && !this.lwm.lwj) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13708").dR("fid", fVar.getForum().getId()).dR("fname", fVar.getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", fVar.getThreadId()).dR("obj_param1", this.lwm.eEK != null ? this.lwm.eEK.getUserId() : ""));
            this.lwm.lwj = true;
        }
    }
}
