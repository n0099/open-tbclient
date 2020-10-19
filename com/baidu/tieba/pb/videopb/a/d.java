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
    private CustomMessageListener fvu;
    private BaseFragment goK;
    private f kYp;
    private ax lma;
    private int lmg;
    private boolean lvi;
    private String lvj;
    private boolean lvk;
    private boolean lvl;
    private boolean lvm;
    private boolean lvn;
    private boolean lvo;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (d.this.Vx != null) {
                        int dmH = ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).dmH();
                        if (dmH == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).Ga(2);
                        } else if (dmH == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).Ga(1);
                        }
                        if (d.this.kYp.ddd() || dmH == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).lxb.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).lxf.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).lxb.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).lxf.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.bmY().b(d.this.goK.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.goK.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                            be.bmY().b(d.this.goK.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.goK.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dK("fid", fid);
                        aqVar.dK("fname", fName);
                        aqVar.u("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dK("tid", tid);
                        aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").aj("obj_id", 2));
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dK("fid", fid);
                    aqVar2.dK("tid", tid);
                    aqVar2.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new aq("c11923").aj("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.kYp != null && d.this.kYp.getForum() != null) {
                        str = d.this.kYp.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dK("uid", str3);
                    if (d.this.kYp != null) {
                        aqVar3.dK("fid", d.this.kYp.getForumId());
                        aqVar3.dK("tid", d.this.kYp.getThreadId());
                    }
                    aqVar3.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fvu = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.Vx != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).lwU != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.Vx).lwU.setTextSize(TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.goK = baseFragment;
        this.goK.registerListener(this.fvu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cw */
    public com.baidu.tieba.pb.videopb.e.b c(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Vx = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kYp != null && this.kYp.dcA() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.goK.getUniqueId(), this.kYp, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bih() != null) {
            String userId = postData.bih().getUserId();
            String forumId = this.kYp != null ? this.kYp.getForumId() : "";
            String forumName = this.kYp != null ? this.kYp.getForumName() : "";
            int dEp = postData.dEp();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dK("fid", forumId);
            aqVar.dK("fname", forumName);
            aqVar.dK("obj_param1", userId);
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dK("tid", id);
            aqVar.aj(TiebaInitialize.Params.OBJ_PARAM2, dEp);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.kYp = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kYp != null && this.kYp.dcA() != null && this.kYp.dcA().bih() != null && postData != null) {
            a(bVar, this.kYp.dcA().bih(), postData);
            a(bVar, this.kYp.dcA().bih());
            b(bVar, this.kYp.dcA().bih());
            c(bVar, this.kYp.dcA().bih());
            c(bVar, postData);
            d(bVar, this.kYp.dcA().bih());
            e(bVar, this.kYp.dcA().bih());
            b(bVar, this.kYp.dcA().bih(), postData);
        }
    }

    private void b(final com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.kYp != null && this.kYp.dcA() != null && postData != null) {
            bVar.a(this.mContext, this.kYp.dcA().bif(), this.kYp.dcA().getTitle(), N(this.kYp));
            if (this.kYp.dcA().biz() != null) {
                String numberUniformFormatExtra = at.numberUniformFormatExtra(this.kYp.dcA().biz().play_count.intValue());
                bVar.fro.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.lxg.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            bVar.lxa.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.lxh.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dEs = postData.dEs();
            if (dEs != null && !TextUtils.isEmpty(dEs.getName()) && !TextUtils.isEmpty(dEs.getName().trim())) {
                bVar.lxb.setText(dEs.getName());
                bVar.lxi.setText(dEs.getName());
                bVar.lxb.setVisibility(0);
            } else {
                bVar.lxb.setVisibility(8);
            }
            if (dEs != null && !TextUtils.isEmpty(dEs.getDistance())) {
                bVar.lxf.setText(dEs.getDistance());
                bVar.lxj.setText(dEs.getDistance());
                bVar.lxf.setVisibility(0);
                final int measureText = (int) bVar.lxf.getPaint().measureText(dEs.getDistance(), 0, dEs.getDistance().length());
                bVar.lxc.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lxc.getMeasuredWidth();
                        int measuredWidth2 = bVar.fro.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lxa.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lxf.setVisibility(8);
                            bVar.lxb.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lxb.setVisibility(8);
                        }
                    }
                });
                bVar.lwZ.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lwZ.getMeasuredWidth();
                        int measuredWidth2 = bVar.lxg.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lxh.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lxj.setVisibility(8);
                            bVar.lxi.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lxi.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.lxf.setVisibility(8);
            }
            PollData bkm = this.kYp.dcA().bkm();
            if (bkm != null && bkm.getOptions() != null && bkm.getOptions().size() > 0) {
                bVar.lxd.setPageContext(this.goK.getPageContext());
                bVar.lxd.setDataForPb(bkm, this.kYp.getThreadId(), this.kYp.getForumId());
                bVar.lxd.setVisibility(0);
            } else {
                bVar.lxd.setVisibility(8);
            }
            if (bVar.lao != null) {
                bVar.lao.removeAllViews();
            }
            if (this.kYp != null && this.kYp.dcA() != null && !aH(this.kYp.dcA()) && (!y.isEmpty(this.kYp.dcA().bkn()) || !y.isEmpty(this.kYp.dcA().bko()))) {
                ag agVar = new ag();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.kYp, agVar.k(this.kYp.dcA().bkn(), this.kYp.dcA().bko()), this.kYp.getForumName(), (VideoPbFragment) this.goK, agVar.bzE());
                bVar.lao.addView(pbLinkGoodsRootView);
                bVar.lao.setVisibility(0);
            } else {
                bVar.lao.setVisibility(8);
            }
            bVar.a(this.mContext, this.kYp);
        }
    }

    private boolean aH(bw bwVar) {
        return (bwVar == null || bwVar.bkm() == null || bwVar.bkm().getOptions() == null || bwVar.bkm().getOptions().size() <= 0) ? false : true;
    }

    private boolean N(f fVar) {
        if (fVar == null || !fVar.isValid()) {
            return false;
        }
        PostData postData = fVar.dcC().get(0);
        return postData != null && y.getCount(postData.mFg) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kYp != null) {
            this.lvk = this.kYp.kUC;
            if (this.kYp.dcA() != null) {
                this.lvm = this.kYp.dcA().bid() == 1;
                this.lvl = this.kYp.dcA().bic() == 1;
            }
            bVar.k(this.lvk, this.lvm, this.lvl);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kYp != null && metaData != null && postData != null) {
            bVar.lwL.getHeadView().setUserId(metaData.getUserId());
            bVar.lwL.getHeadView().setUserName(metaData.getUserName());
            bVar.lwL.getHeadView().setTid(postData.getId());
            bVar.lwL.getHeadView().setFid(this.kYp != null ? this.kYp.getForumId() : "");
            bVar.lwL.getHeadView().setFName(this.kYp != null ? this.kYp.getForumName() : "");
            bVar.lwL.a(metaData, 4);
            bVar.lwL.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.sj(true);
                bVar.lwL.getHeadView().setLiveStatus(1);
                bVar.lwL.getHeadView().setAlaInfo(postData.bih().getAlaInfo());
                k(postData);
                return;
            }
            bVar.sj(false);
            bVar.lwL.getHeadView().setLiveStatus(0);
            bVar.lwL.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.lvn = true;
                bVar.lwM.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.eig.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.lvn = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.eig.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.lwM.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.eig.setText(metaData.getName_show());
            bVar.eig.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.eig.setTag(R.id.tag_user_name, metaData.getName_show());
            this.lvo = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kYp != null && metaData != null) {
            this.lvi = metaData.getIs_bawu() == 1;
            this.lvj = metaData.getBawu_type();
            if (this.kYp.ddd()) {
                bVar.lwN.setVisibility(8);
            } else if (this.lvi && Config.BAWU_TYPE_MANAGER.equals(this.lvj)) {
                bVar.lwN.setText(R.string.bawu_member_bazhu_tip);
                bVar.lwN.setVisibility(0);
                bVar.Pv(this.lvj);
            } else if (this.lvi && Config.BAWU_TYPE_ASSIST.equals(this.lvj)) {
                bVar.lwN.setText(R.string.bawu_member_xbazhu_tip);
                bVar.lwN.setVisibility(0);
                bVar.Pv(this.lvj);
            } else {
                bVar.lwN.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kYp != null && this.kYp.dcA() != null) {
            this.lmg = 0;
            if (!this.kYp.dcA().bjE()) {
                if (postData != null && postData.bih() != null) {
                    this.lmg = postData.bih().getLevel_id();
                }
                if (!this.kYp.ddd()) {
                    bVar.lwO.setVisibility(0);
                    bVar.FZ(this.lmg);
                    return;
                }
                bVar.lwO.setVisibility(8);
                return;
            }
            bVar.lwO.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kYp != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.lwP.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.lwP.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kYp != null && metaData != null) {
            bVar.lwR.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.lwR.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.lwQ.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.lwQ.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.lwQ.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.lwQ.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.lwR.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.lwQ.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.lwQ.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.lwR.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.lwQ.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kYp != null && postData != null && postData.bih() != null) {
            String threadId = this.kYp != null ? this.kYp.getThreadId() : "";
            int r = r(this.kYp);
            if (this.lma == null) {
                this.lma = new ax(this.goK.getPageContext(), bVar.lwS, 4);
                this.lma.l(this.goK.getUniqueId());
            }
            postData.bih().setIsLike(postData.bih().hadConcerned());
            this.lma.a(postData.bih());
            this.lma.setTid(threadId);
            this.lma.setThreadData(this.kYp.dcA());
            this.lma.lir = true;
            this.lma.FA(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.lwS.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.lwS.setVisibility(8);
            }
            if (this.kYp.kUB) {
                bVar.lwS.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.lvi) {
                bVar.Pv(this.lvj);
            }
            bVar.FZ(this.lmg);
            bVar.vd(this.lvn || this.lvo);
            bVar.k(this.lvk, this.lvm, this.lvl);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dcA() == null) {
            return 0;
        }
        if (fVar.dcA().bjE()) {
            return (y.isEmpty(fVar.dcX()) && (fVar.dcz() == null || StringUtils.isNull(fVar.dcz().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
