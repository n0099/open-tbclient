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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private BaseFragment fZf;
    private CustomMessageListener fgm;
    private f kAH;
    private ax kOn;
    private int kOs;
    private boolean kXm;
    private String kXn;
    private boolean kXo;
    private boolean kXp;
    private boolean kXq;
    private boolean kXr;
    private boolean kXs;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (d.this.UO != null) {
                        int dfu = ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).dfu();
                        if (dfu == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).ET(2);
                        } else if (dfu == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).ET(1);
                        }
                        if (d.this.kAH.cVP()) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).kZa.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).kZa.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.bju().b(d.this.fZf.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.fZf.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                            be.bju().b(d.this.fZf.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.fZf.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dD("fid", fid);
                        aqVar.dD("fname", fName);
                        aqVar.u("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dD("tid", tid);
                        aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").ai("obj_id", 2));
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dD("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dD("fid", fid);
                    aqVar2.dD("tid", tid);
                    aqVar2.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new aq("c11923").ai("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.kAH != null && d.this.kAH.getForum() != null) {
                        str = d.this.kAH.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dD("uid", str3);
                    if (d.this.kAH != null) {
                        aqVar3.dD("fid", d.this.kAH.getForumId());
                        aqVar3.dD("tid", d.this.kAH.getThreadId());
                    }
                    aqVar3.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fgm = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.UO != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).hZR != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.UO).hZR.setTextSize(0, TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.fZf = baseFragment;
        this.fZf.registerListener(this.fgm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ct */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.UO = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kAH != null && this.kAH.cVm() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.fZf.getUniqueId(), this.kAH, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.beE() != null) {
            String userId = postData.beE().getUserId();
            String forumId = this.kAH != null ? this.kAH.getForumId() : "";
            String forumName = this.kAH != null ? this.kAH.getForumName() : "";
            int dwK = postData.dwK();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dD("fid", forumId);
            aqVar.dD("fname", forumName);
            aqVar.dD("obj_param1", userId);
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dD("tid", id);
            aqVar.ai(TiebaInitialize.Params.OBJ_PARAM2, dwK);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.kAH = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kAH != null && this.kAH.cVm() != null && this.kAH.cVm().beE() != null && postData != null) {
            a(bVar, this.kAH.cVm().beE(), postData);
            a(bVar, this.kAH.cVm().beE());
            b(bVar, this.kAH.cVm().beE());
            c(bVar, this.kAH.cVm().beE());
            c(bVar, postData);
            d(bVar, this.kAH.cVm().beE());
            e(bVar, this.kAH.cVm().beE());
            b(bVar, this.kAH.cVm().beE(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.kAH != null && this.kAH.cVm() != null && postData != null) {
            bVar.s(this.kAH.cVm().getTitle());
            if (this.kAH.cVm().beW() != null) {
                bVar.fch.setText(at.numberUniformFormatExtra(this.kAH.cVm().beW().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            bVar.kYZ.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dwN = postData.dwN();
            if (dwN != null && !TextUtils.isEmpty(dwN.getName()) && !TextUtils.isEmpty(dwN.getName().trim())) {
                bVar.kZa.setText(dwN.getName());
                bVar.kZa.setVisibility(0);
            } else {
                bVar.kZa.setVisibility(8);
            }
            PollData bgJ = this.kAH.cVm().bgJ();
            if (bgJ != null && bgJ.getOptions() != null && bgJ.getOptions().size() > 0) {
                bVar.kZb.setPageContext(this.fZf.getPageContext());
                bVar.kZb.setDataForPb(bgJ, this.kAH.getThreadId(), this.kAH.getForumId());
                bVar.kZb.setVisibility(0);
                return;
            }
            bVar.kZb.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kAH != null) {
            this.kXo = this.kAH.kwS;
            if (this.kAH.cVm() != null) {
                this.kXq = this.kAH.cVm().beA() == 1;
                this.kXp = this.kAH.cVm().bez() == 1;
            }
            bVar.j(this.kXo, this.kXq, this.kXp);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kAH != null && metaData != null && postData != null) {
            bVar.kYO.getHeadView().setUserId(metaData.getUserId());
            bVar.kYO.getHeadView().setUserName(metaData.getUserName());
            bVar.kYO.getHeadView().setTid(postData.getId());
            bVar.kYO.getHeadView().setFid(this.kAH != null ? this.kAH.getForumId() : "");
            bVar.kYO.getHeadView().setFName(this.kAH != null ? this.kAH.getForumName() : "");
            bVar.kYO.a(metaData, 4);
            bVar.kYO.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.rv(true);
                bVar.kYO.getHeadView().setLiveStatus(1);
                bVar.kYO.getHeadView().setAlaInfo(postData.beE().getAlaInfo());
                k(postData);
                return;
            }
            bVar.rv(false);
            bVar.kYO.getHeadView().setLiveStatus(0);
            bVar.kYO.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.kXr = true;
                bVar.kYP.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.dTU.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.kXr = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.dTU.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.kYP.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.dTU.setText(metaData.getName_show());
            bVar.dTU.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.dTU.setTag(R.id.tag_user_name, metaData.getName_show());
            this.kXs = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kAH != null && metaData != null) {
            this.kXm = metaData.getIs_bawu() == 1;
            this.kXn = metaData.getBawu_type();
            if (this.kAH.cVP()) {
                bVar.kYQ.setVisibility(8);
            } else if (this.kXm && Config.BAWU_TYPE_MANAGER.equals(this.kXn)) {
                bVar.kYQ.setText(R.string.bawu_member_bazhu_tip);
                bVar.kYQ.setVisibility(0);
                bVar.Of(this.kXn);
            } else if (this.kXm && Config.BAWU_TYPE_ASSIST.equals(this.kXn)) {
                bVar.kYQ.setText(R.string.bawu_member_xbazhu_tip);
                bVar.kYQ.setVisibility(0);
                bVar.Of(this.kXn);
            } else {
                bVar.kYQ.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kAH != null && this.kAH.cVm() != null) {
            this.kOs = 0;
            if (!this.kAH.cVm().bgb()) {
                if (postData != null && postData.beE() != null) {
                    this.kOs = postData.beE().getLevel_id();
                }
                if (!this.kAH.cVP()) {
                    bVar.kYR.setVisibility(0);
                    bVar.ES(this.kOs);
                    return;
                }
                bVar.kYR.setVisibility(8);
                return;
            }
            bVar.kYR.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kAH != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.kYS.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.kYS.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kAH != null && metaData != null) {
            bVar.kYU.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.kYU.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.kYT.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.kYT.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.kYT.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.kYT.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.kYU.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.kYT.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.kYT.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.kYU.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.kYT.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kAH != null && postData != null && postData.beE() != null) {
            String threadId = this.kAH != null ? this.kAH.getThreadId() : "";
            int r = r(this.kAH);
            if (this.kOn == null) {
                this.kOn = new ax(this.fZf.getPageContext(), bVar.kYV, 4);
                this.kOn.m(this.fZf.getUniqueId());
            }
            postData.beE().setIsLike(postData.beE().hadConcerned());
            this.kOn.a(postData.beE());
            this.kOn.setTid(threadId);
            this.kOn.setThreadData(this.kAH.cVm());
            this.kOn.kKE = true;
            this.kOn.Et(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.kYV.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.kYV.setVisibility(8);
            }
            if (this.kAH.kwR) {
                bVar.kYV.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.kXm) {
                bVar.Of(this.kXn);
            }
            bVar.ES(this.kOs);
            bVar.uo(this.kXr || this.kXs);
            bVar.j(this.kXo, this.kXq, this.kXp);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.cVm() == null) {
            return 0;
        }
        if (fVar.cVm().bgb()) {
            return (y.isEmpty(fVar.cVJ()) && (fVar.cVl() == null || StringUtils.isNull(fVar.cVl().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
