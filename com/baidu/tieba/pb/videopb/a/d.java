package com.baidu.tieba.pb.videopb.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.af;
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
    private String bgd;
    private CustomMessageListener fJi;
    private BaseFragment gEk;
    private ax lER;
    private int lEX;
    private boolean lNU;
    private boolean lNV;
    private boolean lNW;
    private boolean lNX;
    private boolean lNY;
    private f lre;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bgd = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (d.this.Vz != null) {
                        int drR = ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).drR();
                        if (drR == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).He(2);
                        } else if (drR == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).He(1);
                        }
                        if (d.this.lre.dik() || drR == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).lPL.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).lPO.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).lPL.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).lPO.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bh.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bf.bqF().b(d.this.gEk.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.gEk.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ak("obj_type", 2));
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
                            bf.bqF().b(d.this.gEk.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.gEk.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        ar arVar = new ar("c13715");
                        arVar.dR("fid", fid);
                        arVar.dR("fname", fName);
                        arVar.w("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.dR("tid", tid);
                        arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    TiebaStatic.log(new ar("c11923").ak("obj_id", 2));
                    ar arVar2 = new ar("c13267");
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dR("fid", fid);
                    arVar2.dR("tid", tid);
                    arVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new ar("c11923").ak("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.lre != null && d.this.lre.getForum() != null) {
                        str = d.this.lre.getForum().getName();
                    }
                    ar arVar3 = new ar("c13267");
                    arVar3.dR("uid", str3);
                    if (d.this.lre != null) {
                        arVar3.dR("fid", d.this.lre.getForumId());
                        arVar3.dR("tid", d.this.lre.getThreadId());
                    }
                    arVar3.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fJi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.Vz != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).lPE != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.Vz).lPE.setTextSize(TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.gEk = baseFragment;
        this.gEk.registerListener(this.fJi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cv */
    public com.baidu.tieba.pb.videopb.e.b c(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Vz = bVar;
        return bVar;
    }

    public void hy(String str) {
        this.bgd = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lre != null && this.lre.dhH() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gEk.getUniqueId(), this.lre, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.blC() != null) {
            String userId = postData.blC().getUserId();
            String forumId = this.lre != null ? this.lre.getForumId() : "";
            String forumName = this.lre != null ? this.lre.getForumName() : "";
            int dJQ = postData.dJQ();
            String id = postData.getId();
            ar arVar = new ar("c13714");
            arVar.dR("fid", forumId);
            arVar.dR("fname", forumName);
            arVar.dR("obj_param1", userId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", id);
            arVar.ak(TiebaInitialize.Params.OBJ_PARAM2, dJQ);
            TiebaStatic.log(arVar);
        }
    }

    public void setPbData(f fVar) {
        this.lre = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lre != null && this.lre.dhH() != null && this.lre.dhH().blC() != null && postData != null) {
            a(bVar, this.lre.dhH().blC(), postData);
            a(bVar, this.lre.dhH().blC());
            b(bVar, this.lre.dhH().blC());
            a(bVar.lPx, this.lre.dhQ());
            c(bVar, postData);
            c(bVar, this.lre.dhH().blC());
            d(bVar, this.lre.dhH().blC());
            b(bVar, this.lre.dhH().blC(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lre != null && this.lre.dik()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.blC() != null) {
                MetaData blC = postData.blC();
                if (this.bgd != null && !this.bgd.equals("0") && this.bgd.equals(blC.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0302).pb(R.string.J_X04).pd(R.dimen.L_X01).pc(R.color.CAM_X0302);
                } else if (blC.getIs_bawu() == 1 && postData.dJI()) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (blC.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (blC.getIs_bawu() == 1 && "pri_content_assist".equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (blC.getIs_bawu() == 1 && "pri_manage_assist".equals(blC.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bj(textView).oT(R.color.CAM_X0101).pb(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    private void b(final com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.lre != null && this.lre.dhH() != null && postData != null) {
            bVar.a(this.mContext, this.lre.dhH().blA(), this.lre.dhH().getTitle(), w(postData));
            if (this.lre.dhH().blU() != null) {
                String numberUniformFormatExtra = au.numberUniformFormatExtra(this.lre.dhH().blU().play_count.intValue());
                bVar.fFe.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.lPP.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = au.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = au.getFormatTime(postData.getTime());
            }
            bVar.lPK.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.lPQ.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dJT = postData.dJT();
            if (dJT != null && !TextUtils.isEmpty(dJT.getName()) && !TextUtils.isEmpty(dJT.getName().trim())) {
                bVar.lPL.setText(dJT.getName());
                bVar.lPR.setText(dJT.getName());
                bVar.lPL.setVisibility(0);
            } else {
                bVar.lPL.setVisibility(8);
            }
            if (dJT != null && !TextUtils.isEmpty(dJT.getDistance())) {
                bVar.lPO.setText(dJT.getDistance());
                bVar.lPS.setText(dJT.getDistance());
                bVar.lPO.setVisibility(0);
                final int measureText = (int) bVar.lPO.getPaint().measureText(dJT.getDistance(), 0, dJT.getDistance().length());
                bVar.lPM.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lPM.getMeasuredWidth();
                        int measuredWidth2 = bVar.fFe.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lPK.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lPO.setVisibility(8);
                            bVar.lPL.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lPL.setVisibility(8);
                        }
                    }
                });
                bVar.lPJ.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.lPJ.getMeasuredWidth();
                        int measuredWidth2 = bVar.lPP.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.lPQ.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.lPS.setVisibility(8);
                            bVar.lPR.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.lPR.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.lPO.setVisibility(8);
            }
            PollData bnJ = this.lre.dhH().bnJ();
            if (bnJ != null && bnJ.getOptions() != null && bnJ.getOptions().size() > 0) {
                bVar.lGY.setPageContext(this.gEk.getPageContext());
                bVar.lGY.setDataForPb(bnJ, this.lre.getThreadId(), this.lre.getForumId());
                bVar.lGY.setVisibility(0);
            } else {
                bVar.lGY.setVisibility(8);
            }
            if (bVar.lte != null) {
                bVar.lte.removeAllViews();
            }
            if (this.lre != null && this.lre.dhH() != null && !aJ(this.lre.dhH()) && (!y.isEmpty(this.lre.dhH().bnK()) || !y.isEmpty(this.lre.dhH().bnL()))) {
                af afVar = new af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lre, afVar.n(this.lre.dhH().bnK(), this.lre.dhH().bnL()), this.lre.getForumName(), (VideoPbFragment) this.gEk, afVar.bDp());
                bVar.lte.addView(pbLinkGoodsRootView);
                bVar.lte.setVisibility(0);
            } else {
                bVar.lte.setVisibility(8);
            }
            bVar.a(this.mContext, postData);
        }
    }

    private boolean aJ(bx bxVar) {
        return (bxVar == null || bxVar.bnJ() == null || bxVar.bnJ().getOptions() == null || bxVar.bnJ().getOptions().size() <= 0) ? false : true;
    }

    private boolean w(PostData postData) {
        return postData != null && y.getCount(postData.mYH) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lre != null) {
            this.lNU = this.lre.lno;
            if (this.lre.dhH() != null) {
                this.lNW = this.lre.dhH().bly() == 1;
                this.lNV = this.lre.dhH().blx() == 1;
            }
            bVar.k(this.lNU, this.lNW, this.lNV);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lre != null && metaData != null && postData != null) {
            bVar.lPv.getHeadView().setUserId(metaData.getUserId());
            bVar.lPv.getHeadView().setUserName(metaData.getUserName());
            bVar.lPv.getHeadView().setTid(postData.getId());
            bVar.lPv.getHeadView().setFid(this.lre != null ? this.lre.getForumId() : "");
            bVar.lPv.getHeadView().setFName(this.lre != null ? this.lre.getForumName() : "");
            bVar.lPv.a(metaData, 4);
            bVar.lPv.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.sN(true);
                bVar.lPv.getHeadView().setLiveStatus(1);
                bVar.lPv.getHeadView().setAlaInfo(postData.blC().getAlaInfo());
                k(postData);
                return;
            }
            bVar.sN(false);
            bVar.lPv.getHeadView().setLiveStatus(0);
            bVar.lPv.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.lNX = true;
                bVar.lPw.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.euO.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.lNX = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.euO.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.lPw.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.euO.setText(metaData.getName_show());
            bVar.euO.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.euO.setTag(R.id.tag_user_name, metaData.getName_show());
            this.lNY = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lre != null && this.lre.dhH() != null) {
            this.lEX = 0;
            if (!this.lre.dhH().bnb()) {
                if (postData != null && postData.blC() != null) {
                    this.lEX = postData.blC().getLevel_id();
                }
                if (!this.lre.dik()) {
                    bVar.lPy.setVisibility(0);
                    bVar.Hd(this.lEX);
                    return;
                }
                bVar.lPy.setVisibility(8);
                return;
            }
            bVar.lPy.setVisibility(8);
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lre != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.lPz.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.lPz.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lre != null && metaData != null) {
            bVar.lPB.setText(au.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.lPB.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.lPA.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.lPA.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.lPA.setText(au.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.lPA.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !au.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.lPB.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.lPA.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.lPA.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.lPB.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.lPA.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lre != null && postData != null && postData.blC() != null) {
            String threadId = this.lre != null ? this.lre.getThreadId() : "";
            int r = r(this.lre);
            if (this.lER == null) {
                this.lER = new ax(this.gEk.getPageContext(), bVar.lPC, 4);
                this.lER.l(this.gEk.getUniqueId());
            }
            postData.blC().setIsLike(postData.blC().hadConcerned());
            this.lER.a(postData.blC());
            this.lER.setTid(threadId);
            this.lER.setThreadData(this.lre.dhH());
            this.lER.lBj = true;
            this.lER.GE(r);
            if (au.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.lPC.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.lPC.setVisibility(8);
            }
            if (this.lre.lnn) {
                bVar.lPC.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            bVar.Hd(this.lEX);
            bVar.vG(this.lNX || this.lNY);
            bVar.k(this.lNU, this.lNW, this.lNV);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dhH() == null) {
            return 0;
        }
        if (fVar.dhH().bnb()) {
            return (y.isEmpty(fVar.die()) && (fVar.dhG() == null || StringUtils.isNull(fVar.dhG().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
