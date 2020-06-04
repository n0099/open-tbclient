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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private CustomMessageListener eET;
    private BaseFragment fwy;
    private e jIU;
    private at jVL;
    private int jVQ;
    private boolean keF;
    private String keG;
    private boolean keH;
    private boolean keI;
    private boolean keJ;
    private boolean keK;
    private boolean keL;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.TM != null) {
                        int cMo = ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).cMo();
                        if (cMo == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).AX(2);
                        } else if (cMo == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).AX(1);
                        }
                        if (c.this.jIU.cCZ()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).kgo.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).kgo.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aVa().b(c.this.fwy.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.fwy.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 2));
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
                            ba.aVa().b(c.this.fwy.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(c.this.fwy.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        an anVar = new an("c13715");
                        anVar.dh("fid", fid);
                        anVar.dh("fname", fName);
                        anVar.s("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar.dh("tid", tid);
                        anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(anVar);
                        return;
                    }
                    TiebaStatic.log(new an("c11923").ag("obj_id", 2));
                    an anVar2 = new an("c13267");
                    anVar2.dh("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar2.dh("fid", fid);
                    anVar2.dh("tid", tid);
                    anVar2.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new an("c11923").ag("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (c.this.jIU != null && c.this.jIU.getForum() != null) {
                        str = c.this.jIU.getForum().getName();
                    }
                    an anVar3 = new an("c13267");
                    anVar3.dh("uid", str3);
                    if (c.this.jIU != null) {
                        anVar3.dh("fid", c.this.jIU.getForumId());
                        anVar3.dh("tid", c.this.jIU.getThreadId());
                    }
                    anVar3.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.eET = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.TM != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).hsS != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.TM).hsS.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.fwy = baseFragment;
        this.fwy.registerListener(this.eET);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.TM = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.jIU != null && this.jIU.cCy() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.fwy.getUniqueId(), this.jIU, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.aQx() != null) {
            String userId = postData.aQx().getUserId();
            String forumId = this.jIU != null ? this.jIU.getForumId() : "";
            String forumName = this.jIU != null ? this.jIU.getForumName() : "";
            int ddJ = postData.ddJ();
            String id = postData.getId();
            an anVar = new an("c13714");
            anVar.dh("fid", forumId);
            anVar.dh("fname", forumName);
            anVar.dh("obj_param1", userId);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            anVar.dh("tid", id);
            anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, ddJ);
            TiebaStatic.log(anVar);
        }
    }

    public void setPbData(e eVar) {
        this.jIU = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.jIU != null && this.jIU.cCy() != null && this.jIU.cCy().aQx() != null && postData != null) {
            a(bVar, this.jIU.cCy().aQx(), postData);
            a(bVar, this.jIU.cCy().aQx());
            b(bVar, this.jIU.cCy().aQx());
            c(bVar, this.jIU.cCy().aQx());
            c(bVar, postData);
            d(bVar, this.jIU.cCy().aQx());
            e(bVar, this.jIU.cCy().aQx());
            b(bVar, this.jIU.cCy().aQx(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.jIU != null && this.jIU.cCy() != null && postData != null) {
            bVar.o(this.jIU.cCy().getTitle());
            if (this.jIU.cCy().aQQ() != null) {
                bVar.eBs.setText(aq.numberUniformFormatExtra(this.jIU.cCy().aQQ().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.kgn.setText(formatTime + this.mContext.getString(R.string.send_post));
            f ddM = postData.ddM();
            if (ddM != null && !TextUtils.isEmpty(ddM.getName()) && !TextUtils.isEmpty(ddM.getName().trim())) {
                bVar.kgo.setText(ddM.getName());
                bVar.kgo.setVisibility(0);
                return;
            }
            bVar.kgo.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.jIU != null) {
            this.keH = this.jIU.jFf;
            if (this.jIU.cCy() != null) {
                this.keJ = this.jIU.cCy().aQt() == 1;
                this.keI = this.jIU.cCy().aQs() == 1;
            }
            bVar.i(this.keH, this.keJ, this.keI);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.jIU != null && metaData != null && postData != null) {
            bVar.kgc.getHeadView().setUserId(metaData.getUserId());
            bVar.kgc.getHeadView().setUserName(metaData.getUserName());
            bVar.kgc.getHeadView().setTid(postData.getId());
            bVar.kgc.getHeadView().setFid(this.jIU != null ? this.jIU.getForumId() : "");
            bVar.kgc.getHeadView().setFName(this.jIU != null ? this.jIU.getForumName() : "");
            bVar.kgc.a(metaData, 4);
            bVar.kgc.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.pW(true);
                bVar.kgc.getHeadView().setLiveStatus(1);
                bVar.kgc.getHeadView().setAlaInfo(postData.aQx().getAlaInfo());
                k(postData);
                return;
            }
            bVar.pW(false);
            bVar.kgc.getHeadView().setLiveStatus(0);
            bVar.kgc.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.keK = true;
                bVar.kgd.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.dXU.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.keK = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.dXU.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.kgd.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.dXU.setText(metaData.getName_show());
            bVar.dXU.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.dXU.setTag(R.id.tag_user_name, metaData.getName_show());
            this.keL = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jIU != null && metaData != null) {
            this.keF = metaData.getIs_bawu() == 1;
            this.keG = metaData.getBawu_type();
            if (this.jIU.cCZ()) {
                bVar.kge.setVisibility(8);
            } else if (this.keF && Config.BAWU_TYPE_MANAGER.equals(this.keG)) {
                bVar.kge.setText(R.string.bawu_member_bazhu_tip);
                bVar.kge.setVisibility(0);
                bVar.JV(this.keG);
            } else if (this.keF && Config.BAWU_TYPE_ASSIST.equals(this.keG)) {
                bVar.kge.setText(R.string.bawu_member_xbazhu_tip);
                bVar.kge.setVisibility(0);
                bVar.JV(this.keG);
            } else {
                bVar.kge.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.jIU != null && this.jIU.cCy() != null) {
            this.jVQ = 0;
            if (!this.jIU.cCy().aRV()) {
                if (postData != null && postData.aQx() != null) {
                    this.jVQ = postData.aQx().getLevel_id();
                }
                if (!this.jIU.cCZ()) {
                    bVar.kgf.setVisibility(0);
                    bVar.AW(this.jVQ);
                    return;
                }
                bVar.kgf.setVisibility(8);
                return;
            }
            bVar.kgf.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jIU != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.kgg.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.kgg.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jIU != null && metaData != null) {
            bVar.kgi.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.kgi.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.kgh.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.kgh.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.kgi.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.kgh.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.jIU != null && postData != null && postData.aQx() != null) {
            String threadId = this.jIU != null ? this.jIU.getThreadId() : "";
            int q = q(this.jIU);
            if (this.jVL == null) {
                this.jVL = new at(this.fwy.getPageContext(), bVar.kgj, 4);
                this.jVL.l(this.fwy.getUniqueId());
            }
            postData.aQx().setIsLike(postData.aQx().hadConcerned());
            this.jVL.a(postData.aQx());
            this.jVL.setTid(threadId);
            this.jVL.setThreadData(this.jIU.cCy());
            this.jVL.jSd = true;
            this.jVL.Ay(q);
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.kgj.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.kgj.setVisibility(8);
            }
            if (this.jIU.jFe) {
                bVar.kgj.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.keF) {
                bVar.JV(this.keG);
            }
            bVar.AW(this.jVQ);
            bVar.sJ(this.keK || this.keL);
            bVar.i(this.keH, this.keJ, this.keI);
            bVar.onChangeSkinType();
        }
    }

    private int q(e eVar) {
        if (eVar == null || eVar.cCy() == null) {
            return 0;
        }
        if (eVar.cCy().aRV()) {
            return (v.isEmpty(eVar.cCU()) && (eVar.cCx() == null || StringUtils.isNull(eVar.cCx().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
