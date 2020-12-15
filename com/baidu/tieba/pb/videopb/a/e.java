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
    private BaseFragment gNj;
    private f lEP;
    private ax lSK;
    private int lSQ;
    private View.OnClickListener mOnClickListener;
    private boolean mca;
    private boolean mcb;
    private boolean mcc;
    private boolean mcd;
    private boolean mce;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bkt = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.Wx != null) {
                        int dxk = ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).dxk();
                        if (dxk == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).HU(2);
                        } else if (dxk == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).HU(1);
                        }
                        if (e.this.lEP.dny() || dxk == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdO.setVisibility(8);
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdR.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdO.setVisibility(0);
                            ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdR.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bh.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bf.bua().b(e.this.gNj.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gNj.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                            bf.bua().b(e.this.gNj.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gNj.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
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
                    if (e.this.lEP != null && e.this.lEP.getForum() != null) {
                        str = e.this.lEP.getForum().getName();
                    }
                    ar arVar3 = new ar("c13267");
                    arVar3.dY("uid", str3);
                    if (e.this.lEP != null) {
                        arVar3.dY("fid", e.this.lEP.getForumId());
                        arVar3.dY("tid", e.this.lEP.getThreadId());
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
                if (e.this.Wx != null && ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdH != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) e.this.Wx).mdH.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gNj = baseFragment;
        this.gNj.registerListener(this.fQU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cy */
    public com.baidu.tieba.pb.videopb.e.b c(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gNj instanceof VideoPbFragment ? (VideoPbFragment) this.gNj : null);
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
        if (this.lEP != null && this.lEP.dmU() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gNj.getUniqueId(), this.lEP, postData, 1, 1);
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
            String forumId = this.lEP != null ? this.lEP.getForumId() : "";
            String forumName = this.lEP != null ? this.lEP.getForumName() : "";
            int dPh = postData.dPh();
            String id = postData.getId();
            ar arVar = new ar("c13714");
            arVar.dY("fid", forumId);
            arVar.dY("fname", forumName);
            arVar.dY("obj_param1", userId);
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dY("tid", id);
            arVar.al(TiebaInitialize.Params.OBJ_PARAM2, dPh);
            TiebaStatic.log(arVar);
        }
    }

    public void setPbData(f fVar) {
        this.lEP = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lEP != null && this.lEP.dmU() != null && this.lEP.dmU().boP() != null && postData != null) {
            a(bVar, this.lEP.dmU().boP(), postData);
            a(bVar, this.lEP.dmU().boP());
            b(bVar, this.lEP.dmU().boP());
            a(bVar.jhz, this.lEP.dnd());
            c(bVar, postData);
            c(bVar, this.lEP.dmU().boP());
            d(bVar, this.lEP.dmU().boP());
            b(bVar, this.lEP.dmU().boP(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lEP != null && this.lEP.dny()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.boP() != null) {
                MetaData boP = postData.boP();
                if (this.bkt != null && !this.bkt.equals("0") && this.bkt.equals(boP.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0302).pA(R.string.J_X04).pD(R.dimen.L_X01).pC(R.color.CAM_X0302);
                } else if (boP.getIs_bawu() == 1 && postData.dOZ()) {
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
        if (this.lEP != null && this.lEP.dmU() != null && postData != null) {
            bVar.a(this.mContext, this.lEP.dmU().boN(), this.lEP.dmU().getTitle(), this.lEP.dmU(), x(postData));
            if (this.lEP.dmU().bph() != null) {
                String numberUniformFormatExtra = au.numberUniformFormatExtra(this.lEP.dmU().bph().play_count.intValue());
                bVar.fMQ.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                bVar.mdS.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = au.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = au.getFormatTime(postData.getTime());
            }
            bVar.mdN.setText(formatTime + this.mContext.getString(R.string.send_post));
            bVar.mdT.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dPk = postData.dPk();
            if (dPk != null && !TextUtils.isEmpty(dPk.getName()) && !TextUtils.isEmpty(dPk.getName().trim())) {
                bVar.mdO.setText(dPk.getName());
                bVar.mdU.setText(dPk.getName());
                bVar.mdO.setVisibility(0);
            } else {
                bVar.mdO.setVisibility(8);
            }
            if (dPk != null && !TextUtils.isEmpty(dPk.getDistance())) {
                bVar.mdR.setText(dPk.getDistance());
                bVar.mdV.setText(dPk.getDistance());
                bVar.mdR.setVisibility(0);
                final int measureText = (int) bVar.mdR.getPaint().measureText(dPk.getDistance(), 0, dPk.getDistance().length());
                bVar.mdP.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.mdP.getMeasuredWidth();
                        int measuredWidth2 = bVar.fMQ.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.mdN.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.mdR.setVisibility(8);
                            bVar.mdO.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.mdO.setVisibility(8);
                        }
                    }
                });
                bVar.mdM.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = bVar.mdM.getMeasuredWidth();
                        int measuredWidth2 = bVar.mdS.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + bVar.mdT.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            bVar.mdV.setVisibility(8);
                            bVar.mdU.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            bVar.mdU.setVisibility(8);
                        }
                    }
                });
            } else {
                bVar.mdR.setVisibility(8);
            }
            PollData bqX = this.lEP.dmU().bqX();
            if (bqX != null && bqX.getOptions() != null && bqX.getOptions().size() > 0) {
                bVar.lUV.setPageContext(this.gNj.getPageContext());
                bVar.lUV.setDataForPb(bqX, this.lEP.getThreadId(), this.lEP.getForumId());
                bVar.lUV.setVisibility(0);
            } else {
                bVar.lUV.setVisibility(8);
            }
            if (bVar.lGS != null) {
                bVar.lGS.removeAllViews();
            }
            if (this.lEP != null && this.lEP.dmU() != null && !aJ(this.lEP.dmU()) && (!y.isEmpty(this.lEP.dmU().bqY()) || !y.isEmpty(this.lEP.dmU().bqZ()))) {
                af afVar = new af();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lEP, afVar.n(this.lEP.dmU().bqY(), this.lEP.dmU().bqZ()), this.lEP.getForumName(), (VideoPbFragment) this.gNj, afVar.bGQ());
                bVar.lGS.addView(pbLinkGoodsRootView);
                bVar.lGS.setVisibility(0);
            } else {
                bVar.lGS.setVisibility(8);
            }
            bVar.a(this.mContext, postData);
        }
    }

    private boolean aJ(by byVar) {
        return (byVar == null || byVar.bqX() == null || byVar.bqX().getOptions() == null || byVar.bqX().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && y.getCount(postData.nmH) >= 2;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.lEP != null) {
            this.mca = this.lEP.lAP;
            if (this.lEP.dmU() != null) {
                this.mcc = this.lEP.dmU().boL() == 1;
                this.mcb = this.lEP.dmU().boK() == 1;
            }
            bVar.k(this.mca, this.mcc, this.mcb);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lEP != null && metaData != null && postData != null) {
            bVar.mdB.getHeadView().setUserId(metaData.getUserId());
            bVar.mdB.getHeadView().setUserName(metaData.getUserName());
            bVar.mdB.getHeadView().setTid(postData.getId());
            bVar.mdB.getHeadView().setFid(this.lEP != null ? this.lEP.getForumId() : "");
            bVar.mdB.getHeadView().setFName(this.lEP != null ? this.lEP.getForumName() : "");
            bVar.mdB.a(metaData, 4);
            bVar.mdB.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.tp(true);
                bVar.mdB.getHeadView().setLiveStatus(1);
                bVar.mdB.getHeadView().setAlaInfo(postData.boP().getAlaInfo());
                k(postData);
                return;
            }
            bVar.tp(false);
            bVar.mdB.getHeadView().setLiveStatus(0);
            bVar.mdB.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.mcd = true;
                bVar.mdC.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.eBQ.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.mcd = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.eBQ.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.mdC.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.eBQ.setText(metaData.getName_show());
            bVar.eBQ.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.eBQ.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mce = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.lEP != null && this.lEP.dmU() != null) {
            this.lSQ = 0;
            if (!this.lEP.dmU().bqo()) {
                if (postData != null && postData.boP() != null) {
                    this.lSQ = postData.boP().getLevel_id();
                }
                if (!this.lEP.dny()) {
                    bVar.jhA.setVisibility(0);
                    bVar.AE(this.lSQ);
                    return;
                }
                bVar.jhA.setVisibility(8);
                return;
            }
            bVar.jhA.setVisibility(8);
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lEP != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.mdD.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.mdD.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.lEP != null && metaData != null) {
            bVar.mdE.setText(au.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.mdE.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jhB.setText(metaData.getNewGodData().getFieldName() + ah.lf(metaData.getNewGodData().isVideoGod()));
            bVar.jhB.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.jhB.setText(au.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.jhB.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !au.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.mdE.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.jhB.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jhB.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.mdE.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.jhB.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.lEP != null && postData != null && postData.boP() != null) {
            String threadId = this.lEP != null ? this.lEP.getThreadId() : "";
            int r = r(this.lEP);
            if (this.lSK == null) {
                this.lSK = new ax(this.gNj.getPageContext(), bVar.mdF, 4);
                this.lSK.l(this.gNj.getUniqueId());
            }
            postData.boP().setIsLike(postData.boP().hadConcerned());
            this.lSK.a(postData.boP());
            this.lSK.setTid(threadId);
            this.lSK.setThreadData(this.lEP.dmU());
            this.lSK.lOY = true;
            this.lSK.Hu(r);
            if (au.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.mdF.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.mdF.setVisibility(8);
            }
            if (this.lEP.lAO) {
                bVar.mdF.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            bVar.AE(this.lSQ);
            bVar.wk(this.mcd || this.mce);
            bVar.k(this.mca, this.mcc, this.mcb);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dmU() == null) {
            return 0;
        }
        if (fVar.dmU().bqo()) {
            return (y.isEmpty(fVar.dnr()) && (fVar.dmT() == null || StringUtils.isNull(fVar.dmT().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
