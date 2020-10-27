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
    private CustomMessageListener fDP;
    private BaseFragment gyP;
    private boolean lHG;
    private String lHH;
    private boolean lHI;
    private boolean lHJ;
    private boolean lHK;
    private boolean lHL;
    private boolean lHM;
    private f lkO;
    private ax lyE;
    private int lyK;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (d.this.Vy != null) {
                        int dpP = ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).dpP();
                        if (dpP == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).Gt(2);
                        } else if (dpP == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).Gt(1);
                        }
                        if (d.this.lkO.dgl() || dpP == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lJz.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lJD.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lJz.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lJD.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.boR().b(d.this.gyP.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.gyP.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).aj("obj_type", 2));
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
                            be.boR().b(d.this.gyP.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.gyP.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dR("fid", fid);
                        aqVar.dR("fname", fName);
                        aqVar.w("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dR("tid", tid);
                        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").aj("obj_id", 2));
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
                    TiebaStatic.log(new aq("c11923").aj("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.lkO != null && d.this.lkO.getForum() != null) {
                        str = d.this.lkO.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dR("uid", str3);
                    if (d.this.lkO != null) {
                        aqVar3.dR("fid", d.this.lkO.getForumId());
                        aqVar3.dR("tid", d.this.lkO.getThreadId());
                    }
                    aqVar3.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fDP = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.Vy != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lJs != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.Vy).lJs.setTextSize(TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.gyP = baseFragment;
        this.gyP.registerListener(this.fDP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cx */
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
        if (this.lkO != null && this.lkO.dfI() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gyP.getUniqueId(), this.lkO, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bka() != null) {
            String userId = postData.bka().getUserId();
            String forumId = this.lkO != null ? this.lkO.getForumId() : "";
            String forumName = this.lkO != null ? this.lkO.getForumName() : "";
            int dHx = postData.dHx();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dR("fid", forumId);
            aqVar.dR("fname", forumName);
            aqVar.dR("obj_param1", userId);
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dR("tid", id);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, dHx);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.lkO = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lkO != null && this.lkO.dfI() != null && this.lkO.dfI().bka() != null && postData != null) {
            a(bVar, this.lkO.dfI().bka(), postData);
            a(bVar, this.lkO.dfI().bka());
            b(bVar, this.lkO.dfI().bka());
            c(bVar, this.lkO.dfI().bka());
            c(bVar, postData);
            d(bVar, this.lkO.dfI().bka());
            e(bVar, this.lkO.dfI().bka());
            b(bVar, this.lkO.dfI().bka(), postData);
        }
    }

    private void b(final com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.lkO != null && this.lkO.dfI() != null && postData != null) {
            bVar.a(this.mContext, this.lkO.dfI().bjY(), this.lkO.dfI().getTitle(), N(this.lkO));
            if (this.lkO.dfI().bks() != null) {
                String numberUniformFormatExtra = at.numberUniformFormatExtra(this.lkO.dfI().bks().play_count.intValue());
                bVar.fzM.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.lJE.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            bVar.lJy.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.lJF.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dHA = postData.dHA();
            if (dHA != null && !TextUtils.isEmpty(dHA.getName()) && !TextUtils.isEmpty(dHA.getName().trim())) {
                bVar.lJz.setText(dHA.getName());
                bVar.lJG.setText(dHA.getName());
                bVar.lJz.setVisibility(0);
            } else {
                bVar.lJz.setVisibility(8);
            }
            if (dHA != null && !TextUtils.isEmpty(dHA.getDistance())) {
                bVar.lJD.setText(dHA.getDistance());
                bVar.lJH.setText(dHA.getDistance());
                bVar.lJD.setVisibility(0);
                final int measureText = (int) bVar.lJD.getPaint().measureText(dHA.getDistance(), 0, dHA.getDistance().length());
                bVar.lJA.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lJA.getMeasuredWidth();
                        int measuredWidth2 = bVar.fzM.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lJy.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lJD.setVisibility(8);
                            bVar.lJz.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lJz.setVisibility(8);
                        }
                    }
                });
                bVar.lJx.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lJx.getMeasuredWidth();
                        int measuredWidth2 = bVar.lJE.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lJF.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lJH.setVisibility(8);
                            bVar.lJG.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lJG.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.lJD.setVisibility(8);
            }
            PollData bmf = this.lkO.dfI().bmf();
            if (bmf != null && bmf.getOptions() != null && bmf.getOptions().size() > 0) {
                bVar.lJB.setPageContext(this.gyP.getPageContext());
                bVar.lJB.setDataForPb(bmf, this.lkO.getThreadId(), this.lkO.getForumId());
                bVar.lJB.setVisibility(0);
            } else {
                bVar.lJB.setVisibility(8);
            }
            if (bVar.lmN != null) {
                bVar.lmN.removeAllViews();
            }
            if (this.lkO != null && this.lkO.dfI() != null && !aH(this.lkO.dfI()) && (!y.isEmpty(this.lkO.dfI().bmg()) || !y.isEmpty(this.lkO.dfI().bmh()))) {
                ag agVar = new ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lkO, agVar.m(this.lkO.dfI().bmg(), this.lkO.dfI().bmh()), this.lkO.getForumName(), (VideoPbFragment) this.gyP, agVar.bBx());
                bVar.lmN.addView(pbLinkGoodsRootView);
                bVar.lmN.setVisibility(0);
            } else {
                bVar.lmN.setVisibility(8);
            }
            bVar.a(this.mContext, this.lkO);
        }
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.bmf() == null || bwVar.bmf().getOptions() == null || bwVar.bmf().getOptions().size() <= 0) ? false : true;
    }

    private boolean N(f fVar) {
        if (fVar == null || !fVar.isValid()) {
            return false;
        }
        PostData postData = fVar.dfK().get(0);
        return postData != null && y.getCount(postData.mRM) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lkO != null) {
            this.lHI = this.lkO.lhb;
            if (this.lkO.dfI() != null) {
                this.lHK = this.lkO.dfI().bjW() == 1;
                this.lHJ = this.lkO.dfI().bjV() == 1;
            }
            bVar.k(this.lHI, this.lHK, this.lHJ);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lkO != null && metaData != null && postData != null) {
            bVar.lJj.getHeadView().setUserId(metaData.getUserId());
            bVar.lJj.getHeadView().setUserName(metaData.getUserName());
            bVar.lJj.getHeadView().setTid(postData.getId());
            bVar.lJj.getHeadView().setFid(this.lkO != null ? this.lkO.getForumId() : "");
            bVar.lJj.getHeadView().setFName(this.lkO != null ? this.lkO.getForumName() : "");
            bVar.lJj.a(metaData, 4);
            bVar.lJj.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.sB(true);
                bVar.lJj.getHeadView().setLiveStatus(1);
                bVar.lJj.getHeadView().setAlaInfo(postData.bka().getAlaInfo());
                k(postData);
                return;
            }
            bVar.sB(false);
            bVar.lJj.getHeadView().setLiveStatus(0);
            bVar.lJj.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.lHL = true;
                bVar.lJk.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.eqE.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.lHL = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.eqE.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.lJk.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.eqE.setText(metaData.getName_show());
            bVar.eqE.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.eqE.setTag(R.id.tag_user_name, metaData.getName_show());
            this.lHM = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lkO != null && metaData != null) {
            this.lHG = metaData.getIs_bawu() == 1;
            this.lHH = metaData.getBawu_type();
            if (this.lkO.dgl()) {
                bVar.lJl.setVisibility(8);
            } else if (this.lHG && Config.BAWU_TYPE_MANAGER.equals(this.lHH)) {
                bVar.lJl.setText(R.string.bawu_member_bazhu_tip);
                bVar.lJl.setVisibility(0);
                bVar.PT(this.lHH);
            } else if (this.lHG && Config.BAWU_TYPE_ASSIST.equals(this.lHH)) {
                bVar.lJl.setText(R.string.bawu_member_xbazhu_tip);
                bVar.lJl.setVisibility(0);
                bVar.PT(this.lHH);
            } else {
                bVar.lJl.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lkO != null && this.lkO.dfI() != null) {
            this.lyK = 0;
            if (!this.lkO.dfI().blx()) {
                if (postData != null && postData.bka() != null) {
                    this.lyK = postData.bka().getLevel_id();
                }
                if (!this.lkO.dgl()) {
                    bVar.lJm.setVisibility(0);
                    bVar.Gs(this.lyK);
                    return;
                }
                bVar.lJm.setVisibility(8);
                return;
            }
            bVar.lJm.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lkO != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.lJn.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.lJn.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lkO != null && metaData != null) {
            bVar.lJp.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.lJp.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.lJo.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.lJo.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.lJo.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.lJo.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.lJp.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.lJo.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.lJo.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.lJp.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.lJo.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lkO != null && postData != null && postData.bka() != null) {
            String threadId = this.lkO != null ? this.lkO.getThreadId() : "";
            int r = r(this.lkO);
            if (this.lyE == null) {
                this.lyE = new ax(this.gyP.getPageContext(), bVar.lJq, 4);
                this.lyE.l(this.gyP.getUniqueId());
            }
            postData.bka().setIsLike(postData.bka().hadConcerned());
            this.lyE.a(postData.bka());
            this.lyE.setTid(threadId);
            this.lyE.setThreadData(this.lkO.dfI());
            this.lyE.luU = true;
            this.lyE.FT(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.lJq.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.lJq.setVisibility(8);
            }
            if (this.lkO.lha) {
                bVar.lJq.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.lHG) {
                bVar.PT(this.lHH);
            }
            bVar.Gs(this.lyK);
            bVar.vu(this.lHL || this.lHM);
            bVar.k(this.lHI, this.lHK, this.lHJ);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dfI() == null) {
            return 0;
        }
        if (fVar.dfI().blx()) {
            return (y.isEmpty(fVar.dgf()) && (fVar.dfH() == null || StringUtils.isNull(fVar.dfH().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
