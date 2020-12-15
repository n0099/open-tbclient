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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class aa extends af.a implements View.OnClickListener {
    private com.baidu.tbadk.core.view.userLike.c akZ;
    public int aku;
    private TextView eAz;
    private TbImageView jQE;
    private View jQJ;
    private BdUniqueId jQT;
    private TextView kfg;
    private z lKr;
    private View lKs;
    private DynamicUserLikeButton lKt;
    private TextView lKu;
    private TextView lKv;
    private View lKw;
    private View lKx;
    private NEGFeedBackView lKy;
    private TbPageContext pageContext;
    private com.baidu.tieba.pb.data.f pbData;

    public aa(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        this.aku = 3;
        this.pageContext = tbPageContext;
        this.jQT = bdUniqueId;
        if (view != null) {
            this.jQJ = view.findViewById(R.id.rootLayout);
            this.lKs = view.findViewById(R.id.top_divider_line);
            this.eAz = (TextView) view.findViewById(R.id.titleView);
            this.lKt = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
            this.lKu = (TextView) view.findViewById(R.id.alaStateView);
            this.jQE = (TbImageView) view.findViewById(R.id.coverView);
            this.kfg = (TextView) view.findViewById(R.id.descView);
            this.lKv = (TextView) view.findViewById(R.id.hotView);
            this.lKw = view.findViewById(R.id.hotPoint);
            this.lKx = view.findViewById(R.id.bottomSpaceView);
            this.lKt.setTextSize(R.dimen.tbds28);
            this.jQE.setPlaceHolder(2);
            this.jQE.setRadius(com.baidu.adp.lib.util.l.getDimens(view.getContext(), R.dimen.tbds10));
            this.jQE.setConrers(15);
        }
    }

    public void a(z zVar) {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (zVar != null) {
            this.lKr = zVar;
            this.jQJ.setOnClickListener(this);
            this.jQE.startLoad(zVar.cover, 10, false);
            if (zVar.liveStatus == 1 && zVar.liveId > 0) {
                this.lKu.setVisibility(0);
            } else {
                this.lKu.setVisibility(8);
            }
            this.kfg.setText(zVar.description);
            this.eAz.setText(String.format(this.eAz.getContext().getResources().getString(R.string.pb_ala_name), com.baidu.tbadk.core.util.au.getFixedText(zVar.userName, 7, true)));
            this.lKv.setText(String.format(this.lKv.getContext().getResources().getString(R.string.pb_ala_audience_count), com.baidu.tbadk.core.util.au.numFormatOverWan(zVar.lKn)));
            this.lKx.setVisibility(zVar.lKp ? 8 : 0);
            b(zVar.lKq);
            dqb();
        }
    }

    private void b(com.baidu.tbadk.core.data.at atVar) {
        if (this.pageContext != null) {
            if (atVar == null) {
                if (this.lKy != null) {
                    this.lKy.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.lKy == null) {
                int dimens = com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds44);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds130), com.baidu.adp.lib.util.l.getDimens(this.pageContext.getPageActivity(), R.dimen.tbds86));
                layoutParams.addRule(11);
                layoutParams.addRule(8, R.id.coverView);
                this.lKy = new NEGFeedBackView(this.pageContext);
                this.lKy.setPadding(dimens, dimens, dimens, 0);
                ((RelativeLayout) this.jQJ.findViewById(R.id.contentLayout)).addView(this.lKy, layoutParams);
                this.lKy.setEventCallback(new NEGFeedBackView.a() { // from class: com.baidu.tieba.pb.pb.main.aa.1
                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackWindowShow(com.baidu.tbadk.core.data.at atVar2) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13858").al("obj_type", 1));
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onCheckedChanged(com.baidu.tbadk.core.data.at atVar2, CompoundButton compoundButton, boolean z) {
                    }

                    @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                    public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, com.baidu.tbadk.core.data.at atVar2) {
                    }
                });
            }
            this.lKy.setVisibility(0);
            this.lKy.setData(atVar);
            this.lKy.onChangeSkinType();
        }
    }

    private void onChangeSkinType(int i) {
        if (this.aku != i) {
            com.baidu.tbadk.core.util.ap.c(this.jQJ, R.color.CAM_X0205, R.color.CAM_X0204, i);
            com.baidu.tbadk.core.util.ap.setBackgroundColor(this.lKs, R.color.CAM_X0204);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.kfg, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.eAz, R.color.CAM_X0105, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lKv, R.color.CAM_X0109, 1, i);
            com.baidu.tbadk.core.util.ap.setViewTextColor(this.lKu, R.color.CAM_X0101, 1, i);
            if (this.lKy != null) {
                this.lKy.onChangeSkinType();
            }
            this.lKw.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.aR(com.baidu.adp.lib.util.l.getDimens(this.lKw.getContext(), R.dimen.tbds32), com.baidu.tbadk.core.util.ap.getColor(R.color.CAM_X0309)));
            int dimens = com.baidu.adp.lib.util.l.getDimens(this.lKu.getContext(), R.dimen.tbds10);
            com.baidu.tbadk.core.util.e.a.buz().qf(0).b("TL_BR", R.color.CAM_X0308, R.color.CAM_X0301).ae(dimens).af(dimens).bq(this.lKu);
            this.lKt.onChangeSkinType(i);
        }
        this.aku = i;
    }

    private void dqb() {
        if (this.lKr == null || this.lKr.eKe == null) {
            this.lKt.setVisibility(8);
            return;
        }
        this.lKt.setVisibility(0);
        if (this.akZ == null) {
            this.akZ = new com.baidu.tbadk.core.view.userLike.c(this.pageContext, this.lKt);
            this.akZ.l(this.jQT);
        }
        this.akZ.a(this.lKr.eKe);
        this.lKt.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.pb.pb.main.aa.2
            @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
            public void cG(View view) {
                String str;
                if (aa.this.pbData != null && aa.this.pbData.getForum() != null && aa.this.lKr != null && aa.this.lKr.eKe != null) {
                    com.baidu.tbadk.core.util.ar dY = new com.baidu.tbadk.core.util.ar("c13718").dY("fid", aa.this.pbData.getForum().getId()).dY("fname", aa.this.pbData.getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", aa.this.pbData.getThreadId());
                    if (aa.this.lKr.eKe != null) {
                        str = aa.this.lKr.eKe.getUserId();
                    } else {
                        str = "";
                    }
                    TiebaStatic.log(dY.dY("friend_uid", str).al("obj_type", aa.this.lKr.eKe.getIsLike() ? 0 : 1));
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.lKr != null && id == R.id.rootLayout) {
            b(this.lKr);
            c(this.lKr);
        }
    }

    private void b(z zVar) {
        if (zVar != null && zVar.liveStatus == 1) {
            if (zVar.isChushou) {
                eH(zVar.thirdRoomId, zVar.thirdLiveType);
            } else if (zVar.liveId > 0) {
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.liveID = zVar.liveId;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jQJ.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_ARTICLE_PB_RECOMMEND, null, false, "")));
            }
        }
    }

    private void eH(String str, String str2) {
        bf.bua().b(this.pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    private void c(z zVar) {
        if (this.pbData != null && this.pbData.getForum() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13709").dY("fid", this.pbData.getForum().getId()).dY("fname", this.pbData.getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", this.pbData.getThreadId()).dY("obj_param1", zVar.eKe != null ? zVar.eKe.getUserId() : ""));
        }
    }

    public void i(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.getForum() != null && this.lKr != null && !this.lKr.lKo) {
            this.pbData = fVar;
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13708").dY("fid", fVar.getForum().getId()).dY("fname", fVar.getForum().getName()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("tid", fVar.getThreadId()).dY("obj_param1", this.lKr.eKe != null ? this.lKr.eKe.getUserId() : ""));
            this.lKr.lKo = true;
        }
    }
}
