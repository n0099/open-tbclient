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
/* loaded from: classes21.dex */
public class d extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private CustomMessageListener fjg;
    private BaseFragment gct;
    private f kJe;
    private ax kWN;
    private int kWT;
    private boolean lfR;
    private String lfS;
    private boolean lfT;
    private boolean lfU;
    private boolean lfV;
    private boolean lfW;
    private boolean lfX;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (d.this.Vh != null) {
                        int diY = ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).diY();
                        if (diY == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).Fu(2);
                        } else if (diY == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).Fu(1);
                        }
                        if (d.this.kJe.cZu() || diY == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).lhK.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).lhO.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).lhK.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).lhO.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.bkp().b(d.this.gct.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.gct.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).ai("obj_type", 2));
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
                            be.bkp().b(d.this.gct.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.gct.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dF("fid", fid);
                        aqVar.dF("fname", fName);
                        aqVar.u("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dF("tid", tid);
                        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").ai("obj_id", 2));
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dF("fid", fid);
                    aqVar2.dF("tid", tid);
                    aqVar2.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new aq("c11923").ai("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.kJe != null && d.this.kJe.getForum() != null) {
                        str = d.this.kJe.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dF("uid", str3);
                    if (d.this.kJe != null) {
                        aqVar3.dF("fid", d.this.kJe.getForumId());
                        aqVar3.dF("tid", d.this.kJe.getThreadId());
                    }
                    aqVar3.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fjg = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.Vh != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).lhD != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.Vh).lhD.setTextSize(TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.gct = baseFragment;
        this.gct.registerListener(this.fjg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cu */
    public com.baidu.tieba.pb.videopb.e.b c(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Vh = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kJe != null && this.kJe.cYR() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gct.getUniqueId(), this.kJe, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bfy() != null) {
            String userId = postData.bfy().getUserId();
            String forumId = this.kJe != null ? this.kJe.getForumId() : "";
            String forumName = this.kJe != null ? this.kJe.getForumName() : "";
            int dAD = postData.dAD();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dF("fid", forumId);
            aqVar.dF("fname", forumName);
            aqVar.dF("obj_param1", userId);
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dF("tid", id);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, dAD);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.kJe = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kJe != null && this.kJe.cYR() != null && this.kJe.cYR().bfy() != null && postData != null) {
            a(bVar, this.kJe.cYR().bfy(), postData);
            a(bVar, this.kJe.cYR().bfy());
            b(bVar, this.kJe.cYR().bfy());
            c(bVar, this.kJe.cYR().bfy());
            c(bVar, postData);
            d(bVar, this.kJe.cYR().bfy());
            e(bVar, this.kJe.cYR().bfy());
            b(bVar, this.kJe.cYR().bfy(), postData);
        }
    }

    private void b(final com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.kJe != null && this.kJe.cYR() != null && postData != null) {
            bVar.a(this.mContext, this.kJe.cYR().bfw(), this.kJe.cYR().getTitle(), N(this.kJe));
            if (this.kJe.cYR().bfQ() != null) {
                String numberUniformFormatExtra = at.numberUniformFormatExtra(this.kJe.cYR().bfQ().play_count.intValue());
                bVar.ffa.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.lhP.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            bVar.lhJ.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.lhQ.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dAG = postData.dAG();
            if (dAG != null && !TextUtils.isEmpty(dAG.getName()) && !TextUtils.isEmpty(dAG.getName().trim())) {
                bVar.lhK.setText(dAG.getName());
                bVar.lhR.setText(dAG.getName());
                bVar.lhK.setVisibility(0);
            } else {
                bVar.lhK.setVisibility(8);
            }
            if (dAG != null && !TextUtils.isEmpty(dAG.getDistance())) {
                bVar.lhO.setText(dAG.getDistance());
                bVar.lhS.setText(dAG.getDistance());
                bVar.lhO.setVisibility(0);
                final int measureText = (int) bVar.lhO.getPaint().measureText(dAG.getDistance(), 0, dAG.getDistance().length());
                bVar.lhL.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lhL.getMeasuredWidth();
                        int measuredWidth2 = bVar.ffa.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lhJ.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lhO.setVisibility(8);
                            bVar.lhK.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lhK.setVisibility(8);
                        }
                    }
                });
                bVar.lhI.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lhI.getMeasuredWidth();
                        int measuredWidth2 = bVar.lhP.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lhQ.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lhS.setVisibility(8);
                            bVar.lhR.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lhR.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.lhO.setVisibility(8);
            }
            PollData bhD = this.kJe.cYR().bhD();
            if (bhD != null && bhD.getOptions() != null && bhD.getOptions().size() > 0) {
                bVar.lhM.setPageContext(this.gct.getPageContext());
                bVar.lhM.setDataForPb(bhD, this.kJe.getThreadId(), this.kJe.getForumId());
                bVar.lhM.setVisibility(0);
            } else {
                bVar.lhM.setVisibility(8);
            }
            if (bVar.kLd != null) {
                bVar.kLd.removeAllViews();
            }
            if (this.kJe != null && this.kJe.cYR() != null && !aH(this.kJe.cYR()) && (!y.isEmpty(this.kJe.cYR().bhE()) || !y.isEmpty(this.kJe.cYR().bhF()))) {
                ag agVar = new ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.kJe, agVar.k(this.kJe.cYR().bhE(), this.kJe.cYR().bhF()), this.kJe.getForumName(), (VideoPbFragment) this.gct, agVar.bwU());
                bVar.kLd.addView(pbLinkGoodsRootView);
                bVar.kLd.setVisibility(0);
            } else {
                bVar.kLd.setVisibility(8);
            }
            bVar.a(this.mContext, this.kJe);
        }
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.bhD() == null || bwVar.bhD().getOptions() == null || bwVar.bhD().getOptions().size() <= 0) ? false : true;
    }

    private boolean N(f fVar) {
        if (fVar == null || !fVar.isValid()) {
            return false;
        }
        PostData postData = fVar.cYT().get(0);
        return postData != null && y.getCount(postData.mpz) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kJe != null) {
            this.lfT = this.kJe.kFr;
            if (this.kJe.cYR() != null) {
                this.lfV = this.kJe.cYR().bfu() == 1;
                this.lfU = this.kJe.cYR().bft() == 1;
            }
            bVar.k(this.lfT, this.lfV, this.lfU);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kJe != null && metaData != null && postData != null) {
            bVar.lhu.getHeadView().setUserId(metaData.getUserId());
            bVar.lhu.getHeadView().setUserName(metaData.getUserName());
            bVar.lhu.getHeadView().setTid(postData.getId());
            bVar.lhu.getHeadView().setFid(this.kJe != null ? this.kJe.getForumId() : "");
            bVar.lhu.getHeadView().setFName(this.kJe != null ? this.kJe.getForumName() : "");
            bVar.lhu.a(metaData, 4);
            bVar.lhu.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.rD(true);
                bVar.lhu.getHeadView().setLiveStatus(1);
                bVar.lhu.getHeadView().setAlaInfo(postData.bfy().getAlaInfo());
                k(postData);
                return;
            }
            bVar.rD(false);
            bVar.lhu.getHeadView().setLiveStatus(0);
            bVar.lhu.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.lfW = true;
                bVar.lhv.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.dWe.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.lfW = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.dWe.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.lhv.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.dWe.setText(metaData.getName_show());
            bVar.dWe.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.dWe.setTag(R.id.tag_user_name, metaData.getName_show());
            this.lfX = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kJe != null && metaData != null) {
            this.lfR = metaData.getIs_bawu() == 1;
            this.lfS = metaData.getBawu_type();
            if (this.kJe.cZu()) {
                bVar.lhw.setVisibility(8);
            } else if (this.lfR && Config.BAWU_TYPE_MANAGER.equals(this.lfS)) {
                bVar.lhw.setText(R.string.bawu_member_bazhu_tip);
                bVar.lhw.setVisibility(0);
                bVar.OG(this.lfS);
            } else if (this.lfR && Config.BAWU_TYPE_ASSIST.equals(this.lfS)) {
                bVar.lhw.setText(R.string.bawu_member_xbazhu_tip);
                bVar.lhw.setVisibility(0);
                bVar.OG(this.lfS);
            } else {
                bVar.lhw.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kJe != null && this.kJe.cYR() != null) {
            this.kWT = 0;
            if (!this.kJe.cYR().bgV()) {
                if (postData != null && postData.bfy() != null) {
                    this.kWT = postData.bfy().getLevel_id();
                }
                if (!this.kJe.cZu()) {
                    bVar.lhx.setVisibility(0);
                    bVar.Ft(this.kWT);
                    return;
                }
                bVar.lhx.setVisibility(8);
                return;
            }
            bVar.lhx.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kJe != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.lhy.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.lhy.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kJe != null && metaData != null) {
            bVar.lhA.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.lhA.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.lhz.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.lhz.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.lhz.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.lhz.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.lhA.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.lhz.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.lhz.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.lhA.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.lhz.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kJe != null && postData != null && postData.bfy() != null) {
            String threadId = this.kJe != null ? this.kJe.getThreadId() : "";
            int r = r(this.kJe);
            if (this.kWN == null) {
                this.kWN = new ax(this.gct.getPageContext(), bVar.lhB, 4);
                this.kWN.l(this.gct.getUniqueId());
            }
            postData.bfy().setIsLike(postData.bfy().hadConcerned());
            this.kWN.a(postData.bfy());
            this.kWN.setTid(threadId);
            this.kWN.setThreadData(this.kJe.cYR());
            this.kWN.kTe = true;
            this.kWN.EU(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.lhB.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.lhB.setVisibility(8);
            }
            if (this.kJe.kFq) {
                bVar.lhB.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.lfR) {
                bVar.OG(this.lfS);
            }
            bVar.Ft(this.kWT);
            bVar.uw(this.lfW || this.lfX);
            bVar.k(this.lfT, this.lfV, this.lfU);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.cYR() == null) {
            return 0;
        }
        if (fVar.cYR().bgV()) {
            return (y.isEmpty(fVar.cZo()) && (fVar.cYQ() == null || StringUtils.isNull(fVar.cYQ().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
