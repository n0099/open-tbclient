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
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.ax;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes22.dex */
public class e extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private String bkt;
    private CustomMessageListener fQU;
    private BaseFragment gNh;
    private f lEN;
    private ax lSI;
    private int lSO;
    private View.OnClickListener mOnClickListener;
    private boolean mbY;
    private boolean mbZ;
    private boolean mca;
    private boolean mcb;
    private boolean mcc;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bkt = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.Wx != null) {
                        int dxj = ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).dxj();
                        if (dxj == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).HU(2);
                        } else if (dxj == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).HU(1);
                        }
                        if (e.this.lEN.dnx() || dxj == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdM.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdP.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdM.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdP.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bh.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bf.bua().b(e.this.gNh.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gNh.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).al("obj_type", 2));
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
                            bf.bua().b(e.this.gNh.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gNh.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        ar arVar = new ar("c13715");
                        arVar.dY("fid", fid);
                        arVar.dY("fname", fName);
                        arVar.w("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.dY("tid", tid);
                        arVar.al(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    TiebaStatic.log(new ar("c11923").al("obj_id", 2));
                    ar arVar2 = new ar("c13267");
                    arVar2.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dY("fid", fid);
                    arVar2.dY("tid", tid);
                    arVar2.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new ar("c11923").al("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (e.this.lEN != null && e.this.lEN.getForum() != null) {
                        str = e.this.lEN.getForum().getName();
                    }
                    ar arVar3 = new ar("c13267");
                    arVar3.dY("uid", str3);
                    if (e.this.lEN != null) {
                        arVar3.dY("fid", e.this.lEN.getForumId());
                        arVar3.dY("tid", e.this.lEN.getThreadId());
                    }
                    arVar3.dY("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fQU = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.Wx != null && ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdF != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdF.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gNh = baseFragment;
        this.gNh.registerListener(this.fQU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cy */
    public com.baidu.tieba.pb.videopb.e.b c(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gNh instanceof VideoPbFragment ? (VideoPbFragment) this.gNh : null);
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Wx = bVar;
        return bVar;
    }

    public void hY(String str) {
        this.bkt = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lEN != null && this.lEN.dmT() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gNh.getUniqueId(), this.lEN, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.boP() != null) {
            String userId = postData.boP().getUserId();
            String forumId = this.lEN != null ? this.lEN.getForumId() : "";
            String forumName = this.lEN != null ? this.lEN.getForumName() : "";
            int dPg = postData.dPg();
            String id = postData.getId();
            ar arVar = new ar("c13714");
            arVar.dY("fid", forumId);
            arVar.dY("fname", forumName);
            arVar.dY("obj_param1", userId);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("tid", id);
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, dPg);
            TiebaStatic.log(arVar);
        }
    }

    public void setPbData(f fVar) {
        this.lEN = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lEN != null && this.lEN.dmT() != null && this.lEN.dmT().boP() != null && postData != null) {
            a(bVar, this.lEN.dmT().boP(), postData);
            a(bVar, this.lEN.dmT().boP());
            b(bVar, this.lEN.dmT().boP());
            a(bVar.jhx, this.lEN.dnc());
            c(bVar, postData);
            c(bVar, this.lEN.dmT().boP());
            d(bVar, this.lEN.dmT().boP());
            b(bVar, this.lEN.dmT().boP(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lEN != null && this.lEN.dnx()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.boP() != null) {
                MetaData boP = postData.boP();
                if (this.bkt != null && !this.bkt.equals("0") && this.bkt.equals(boP.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0302).pA(R.string.J_X04).pD(R.dimen.L_X01).pC(R.color.CAM_X0302);
                } else if (boP.getIs_bawu() == 1 && postData.dOY()) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (boP.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (boP.getIs_bawu() == 1 && "pri_content_assist".equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (boP.getIs_bawu() == 1 && "pri_manage_assist".equals(boP.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0101).pA(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (this.lEN != null && this.lEN.dmT() != null && postData != null) {
            bVar.a(this.mContext, this.lEN.dmT().boN(), this.lEN.dmT().getTitle(), this.lEN.dmT(), x(postData));
            if (this.lEN.dmT().bph() != null) {
                String numberUniformFormatExtra = au.numberUniformFormatExtra(this.lEN.dmT().bph().play_count.intValue());
                bVar.fMQ.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.mdQ.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = au.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = au.getFormatTime(postData.getTime());
            }
            bVar.mdL.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.mdR.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dPj = postData.dPj();
            if (dPj != null && !TextUtils.isEmpty(dPj.getName()) && !TextUtils.isEmpty(dPj.getName().trim())) {
                bVar.mdM.setText(dPj.getName());
                bVar.mdS.setText(dPj.getName());
                bVar.mdM.setVisibility(0);
            } else {
                bVar.mdM.setVisibility(8);
            }
            if (dPj != null && !TextUtils.isEmpty(dPj.getDistance())) {
                bVar.mdP.setText(dPj.getDistance());
                bVar.mdT.setText(dPj.getDistance());
                bVar.mdP.setVisibility(0);
                final int measureText = (int) bVar.mdP.getPaint().measureText(dPj.getDistance(), 0, dPj.getDistance().length());
                bVar.mdN.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.mdN.getMeasuredWidth();
                        int measuredWidth2 = bVar.fMQ.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.mdL.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.mdP.setVisibility(8);
                            bVar.mdM.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.mdM.setVisibility(8);
                        }
                    }
                });
                bVar.mdK.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.mdK.getMeasuredWidth();
                        int measuredWidth2 = bVar.mdQ.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.mdR.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.mdT.setVisibility(8);
                            bVar.mdS.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.mdS.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.mdP.setVisibility(8);
            }
            PollData bqX = this.lEN.dmT().bqX();
            if (bqX != null && bqX.getOptions() != null && bqX.getOptions().size() > 0) {
                bVar.lUT.setPageContext(this.gNh.getPageContext());
                bVar.lUT.setDataForPb(bqX, this.lEN.getThreadId(), this.lEN.getForumId());
                bVar.lUT.setVisibility(0);
            } else {
                bVar.lUT.setVisibility(8);
            }
            if (bVar.lGQ != null) {
                bVar.lGQ.removeAllViews();
            }
            if (this.lEN != null && this.lEN.dmT() != null && !aJ(this.lEN.dmT()) && (!y.isEmpty(this.lEN.dmT().bqY()) || !y.isEmpty(this.lEN.dmT().bqZ()))) {
                af afVar = new af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lEN, afVar.n(this.lEN.dmT().bqY(), this.lEN.dmT().bqZ()), this.lEN.getForumName(), (VideoPbFragment) this.gNh, afVar.bGQ());
                bVar.lGQ.addView(pbLinkGoodsRootView);
                bVar.lGQ.setVisibility(0);
            } else {
                bVar.lGQ.setVisibility(8);
            }
            bVar.a(this.mContext, postData);
        }
    }

    private boolean aJ(by byVar) {
        return (byVar == null || byVar.bqX() == null || byVar.bqX().getOptions() == null || byVar.bqX().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && y.getCount(postData.nmF) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lEN != null) {
            this.mbY = this.lEN.lAN;
            if (this.lEN.dmT() != null) {
                this.mca = this.lEN.dmT().boL() == 1;
                this.mbZ = this.lEN.dmT().boK() == 1;
            }
            bVar.k(this.mbY, this.mca, this.mbZ);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lEN != null && metaData != null && postData != null) {
            bVar.mdz.getHeadView().setUserId(metaData.getUserId());
            bVar.mdz.getHeadView().setUserName(metaData.getUserName());
            bVar.mdz.getHeadView().setTid(postData.getId());
            bVar.mdz.getHeadView().setFid(this.lEN != null ? this.lEN.getForumId() : "");
            bVar.mdz.getHeadView().setFName(this.lEN != null ? this.lEN.getForumName() : "");
            bVar.mdz.a(metaData, 4);
            bVar.mdz.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.tp(true);
                bVar.mdz.getHeadView().setLiveStatus(1);
                bVar.mdz.getHeadView().setAlaInfo(postData.boP().getAlaInfo());
                k(postData);
                return;
            }
            bVar.tp(false);
            bVar.mdz.getHeadView().setLiveStatus(0);
            bVar.mdz.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.mcb = true;
                bVar.mdA.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.eBQ.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.mcb = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.eBQ.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.mdA.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.eBQ.setText(metaData.getName_show());
            bVar.eBQ.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.eBQ.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mcc = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lEN != null && this.lEN.dmT() != null) {
            this.lSO = 0;
            if (!this.lEN.dmT().bqo()) {
                if (postData != null && postData.boP() != null) {
                    this.lSO = postData.boP().getLevel_id();
                }
                if (!this.lEN.dnx()) {
                    bVar.jhy.setVisibility(0);
                    bVar.AE(this.lSO);
                    return;
                }
                bVar.jhy.setVisibility(8);
                return;
            }
            bVar.jhy.setVisibility(8);
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lEN != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.mdB.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.mdB.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lEN != null && metaData != null) {
            bVar.mdC.setText(au.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.mdC.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jhz.setText(metaData.getNewGodData().getFieldName() + ah.lf(metaData.getNewGodData().isVideoGod()));
            bVar.jhz.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.jhz.setText(au.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.jhz.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !au.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.mdC.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.jhz.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jhz.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.mdC.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.jhz.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lEN != null && postData != null && postData.boP() != null) {
            String threadId = this.lEN != null ? this.lEN.getThreadId() : "";
            int r = r(this.lEN);
            if (this.lSI == null) {
                this.lSI = new ax(this.gNh.getPageContext(), bVar.mdD, 4);
                this.lSI.l(this.gNh.getUniqueId());
            }
            postData.boP().setIsLike(postData.boP().hadConcerned());
            this.lSI.a(postData.boP());
            this.lSI.setTid(threadId);
            this.lSI.setThreadData(this.lEN.dmT());
            this.lSI.lOW = true;
            this.lSI.Hu(r);
            if (au.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.mdD.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.mdD.setVisibility(8);
            }
            if (this.lEN.lAM) {
                bVar.mdD.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            bVar.AE(this.lSO);
            bVar.wk(this.mcb || this.mcc);
            bVar.k(this.mbY, this.mca, this.mbZ);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dmT() == null) {
            return 0;
        }
        if (fVar.dmT().bqo()) {
            return (y.isEmpty(fVar.dnq()) && (fVar.dmS() == null || StringUtils.isNull(fVar.dmS().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
