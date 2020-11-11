package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private CustomMessageListener fJF;
    private BaseFragment gED;
    private ax lEA;
    private int lEG;
    private boolean lNC;
    private String lND;
    private boolean lNE;
    private boolean lNF;
    private boolean lNG;
    private boolean lNH;
    private boolean lNI;
    private f lqP;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (d.this.Vy != null) {
                        int dsr = ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).dsr();
                        if (dsr == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).GG(2);
                        } else if (dsr == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).GG(1);
                        }
                        if (d.this.lqP.diN() || dsr == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lPv.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lPz.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lPv.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lPz.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.brr().b(d.this.gED.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.gED.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 2));
                    }
                } else if (view.getId() == R.id.head_view_video_info_item) {
                    HeadImageView headView = ((HeadPendantClickableView) view).getHeadView();
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    String fName = headView.getFName();
                    int floor = headView.getFloor();
                    AlaInfoData alaInfo = headView.getAlaInfo();
                    int liveStatus = headView.getLiveStatus();
                    if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                        if (alaInfo.isChushou) {
                            be.brr().b(d.this.gED.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.gED.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dR("fid", fid);
                        aqVar.dR("fname", fName);
                        aqVar.w("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dR("tid", tid);
                        aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").al("obj_id", 2));
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dR("fid", fid);
                    aqVar2.dR("tid", tid);
                    aqVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new aq("c11923").al("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.lqP != null && d.this.lqP.getForum() != null) {
                        str = d.this.lqP.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dR("uid", str3);
                    if (d.this.lqP != null) {
                        aqVar3.dR("fid", d.this.lqP.getForumId());
                        aqVar3.dR("tid", d.this.lqP.getThreadId());
                    }
                    aqVar3.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fJF = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.Vy != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lPo != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lPo.setTextSize(TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.gED = baseFragment;
        this.gED.registerListener(this.fJF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cz */
    public com.baidu.tieba.pb.videopb.e.b c(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Vy = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lqP != null && this.lqP.dik() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gED.getUniqueId(), this.lqP, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bmA() != null) {
            String userId = postData.bmA().getUserId();
            String forumId = this.lqP != null ? this.lqP.getForumId() : "";
            String forumName = this.lqP != null ? this.lqP.getForumName() : "";
            int dJZ = postData.dJZ();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dR("fid", forumId);
            aqVar.dR("fname", forumName);
            aqVar.dR("obj_param1", userId);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("tid", id);
            aqVar.al(TiebaInitialize.Params.OBJ_PARAM2, dJZ);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.lqP = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lqP != null && this.lqP.dik() != null && this.lqP.dik().bmA() != null && postData != null) {
            a(bVar, this.lqP.dik().bmA(), postData);
            a(bVar, this.lqP.dik().bmA());
            b(bVar, this.lqP.dik().bmA());
            c(bVar, this.lqP.dik().bmA());
            c(bVar, postData);
            d(bVar, this.lqP.dik().bmA());
            e(bVar, this.lqP.dik().bmA());
            b(bVar, this.lqP.dik().bmA(), postData);
        }
    }

    private void b(final com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.lqP != null && this.lqP.dik() != null && postData != null) {
            bVar.a(this.mContext, this.lqP.dik().bmy(), this.lqP.dik().getTitle(), N(this.lqP));
            if (this.lqP.dik().bmS() != null) {
                String numberUniformFormatExtra = at.numberUniformFormatExtra(this.lqP.dik().bmS().play_count.intValue());
                bVar.fFC.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.lPA.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            bVar.lPu.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.lPB.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dKc = postData.dKc();
            if (dKc != null && !TextUtils.isEmpty(dKc.getName()) && !TextUtils.isEmpty(dKc.getName().trim())) {
                bVar.lPv.setText(dKc.getName());
                bVar.lPC.setText(dKc.getName());
                bVar.lPv.setVisibility(0);
            } else {
                bVar.lPv.setVisibility(8);
            }
            if (dKc != null && !TextUtils.isEmpty(dKc.getDistance())) {
                bVar.lPz.setText(dKc.getDistance());
                bVar.lPD.setText(dKc.getDistance());
                bVar.lPz.setVisibility(0);
                final int measureText = (int) bVar.lPz.getPaint().measureText(dKc.getDistance(), 0, dKc.getDistance().length());
                bVar.lPw.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lPw.getMeasuredWidth();
                        int measuredWidth2 = bVar.fFC.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lPu.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lPz.setVisibility(8);
                            bVar.lPv.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lPv.setVisibility(8);
                        }
                    }
                });
                bVar.lPt.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lPt.getMeasuredWidth();
                        int measuredWidth2 = bVar.lPA.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lPB.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lPD.setVisibility(8);
                            bVar.lPC.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lPC.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.lPz.setVisibility(8);
            }
            PollData boF = this.lqP.dik().boF();
            if (boF != null && boF.getOptions() != null && boF.getOptions().size() > 0) {
                bVar.lPx.setPageContext(this.gED.getPageContext());
                bVar.lPx.setDataForPb(boF, this.lqP.getThreadId(), this.lqP.getForumId());
                bVar.lPx.setVisibility(0);
            } else {
                bVar.lPx.setVisibility(8);
            }
            if (bVar.lsO != null) {
                bVar.lsO.removeAllViews();
            }
            if (this.lqP != null && this.lqP.dik() != null && !aH(this.lqP.dik()) && (!y.isEmpty(this.lqP.dik().boG()) || !y.isEmpty(this.lqP.dik().boH()))) {
                ag agVar = new ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lqP, agVar.n(this.lqP.dik().boG(), this.lqP.dik().boH()), this.lqP.getForumName(), (VideoPbFragment) this.gED, agVar.bDW());
                bVar.lsO.addView(pbLinkGoodsRootView);
                bVar.lsO.setVisibility(0);
            } else {
                bVar.lsO.setVisibility(8);
            }
            bVar.a(this.mContext, this.lqP);
        }
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.boF() == null || bwVar.boF().getOptions() == null || bwVar.boF().getOptions().size() <= 0) ? false : true;
    }

    private boolean N(f fVar) {
        if (fVar == null || !fVar.isValid()) {
            return false;
        }
        PostData postData = fVar.dim().get(0);
        return postData != null && y.getCount(postData.mXP) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lqP != null) {
            this.lNE = this.lqP.lmX;
            if (this.lqP.dik() != null) {
                this.lNG = this.lqP.dik().bmw() == 1;
                this.lNF = this.lqP.dik().bmv() == 1;
            }
            bVar.k(this.lNE, this.lNG, this.lNF);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lqP != null && metaData != null && postData != null) {
            bVar.lPf.getHeadView().setUserId(metaData.getUserId());
            bVar.lPf.getHeadView().setUserName(metaData.getUserName());
            bVar.lPf.getHeadView().setTid(postData.getId());
            bVar.lPf.getHeadView().setFid(this.lqP != null ? this.lqP.getForumId() : "");
            bVar.lPf.getHeadView().setFName(this.lqP != null ? this.lqP.getForumName() : "");
            bVar.lPf.a(metaData, 4);
            bVar.lPf.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.sK(true);
                bVar.lPf.getHeadView().setLiveStatus(1);
                bVar.lPf.getHeadView().setAlaInfo(postData.bmA().getAlaInfo());
                k(postData);
                return;
            }
            bVar.sK(false);
            bVar.lPf.getHeadView().setLiveStatus(0);
            bVar.lPf.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.lNH = true;
                bVar.lPg.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.ewx.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.lNH = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.ewx.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.lPg.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.ewx.setText(metaData.getName_show());
            bVar.ewx.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.ewx.setTag(R.id.tag_user_name, metaData.getName_show());
            this.lNI = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lqP != null && metaData != null) {
            this.lNC = metaData.getIs_bawu() == 1;
            this.lND = metaData.getBawu_type();
            if (this.lqP.diN()) {
                bVar.lPh.setVisibility(8);
            } else if (this.lNC && Config.BAWU_TYPE_MANAGER.equals(this.lND)) {
                bVar.lPh.setText(R.string.bawu_member_bazhu_tip);
                bVar.lPh.setVisibility(0);
                bVar.Qk(this.lND);
            } else if (this.lNC && Config.BAWU_TYPE_ASSIST.equals(this.lND)) {
                bVar.lPh.setText(R.string.bawu_member_xbazhu_tip);
                bVar.lPh.setVisibility(0);
                bVar.Qk(this.lND);
            } else {
                bVar.lPh.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lqP != null && this.lqP.dik() != null) {
            this.lEG = 0;
            if (!this.lqP.dik().bnX()) {
                if (postData != null && postData.bmA() != null) {
                    this.lEG = postData.bmA().getLevel_id();
                }
                if (!this.lqP.diN()) {
                    bVar.lPi.setVisibility(0);
                    bVar.GF(this.lEG);
                    return;
                }
                bVar.lPi.setVisibility(8);
                return;
            }
            bVar.lPi.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lqP != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.lPj.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.lPj.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lqP != null && metaData != null) {
            bVar.lPl.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.lPl.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.lPk.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.lPk.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.lPk.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.lPk.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.lPl.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.lPk.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.lPk.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.lPl.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.lPk.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lqP != null && postData != null && postData.bmA() != null) {
            String threadId = this.lqP != null ? this.lqP.getThreadId() : "";
            int r = r(this.lqP);
            if (this.lEA == null) {
                this.lEA = new ax(this.gED.getPageContext(), bVar.lPm, 4);
                this.lEA.l(this.gED.getUniqueId());
            }
            postData.bmA().setIsLike(postData.bmA().hadConcerned());
            this.lEA.a(postData.bmA());
            this.lEA.setTid(threadId);
            this.lEA.setThreadData(this.lqP.dik());
            this.lEA.lAR = true;
            this.lEA.Gg(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.lPm.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.lPm.setVisibility(8);
            }
            if (this.lqP.lmW) {
                bVar.lPm.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.lNC) {
                bVar.Qk(this.lND);
            }
            bVar.GF(this.lEG);
            bVar.vD(this.lNH || this.lNI);
            bVar.k(this.lNE, this.lNG, this.lNF);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dik() == null) {
            return 0;
        }
        if (fVar.dik().bnX()) {
            return (y.isEmpty(fVar.diH()) && (fVar.dij() == null || StringUtils.isNull(fVar.dij().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
