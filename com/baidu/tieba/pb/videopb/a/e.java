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
import com.baidu.tbadk.core.data.cb;
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
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.an;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<PostData, VideoPbVideoInfoViewHolder> {
    private String bmb;
    private CustomMessageListener fZG;
    private BaseFragment gYU;
    private f lQH;
    private View.OnClickListener mOnClickListener;
    private an meN;
    private int meT;
    private boolean mnZ;
    private boolean moa;
    private boolean mob;
    private boolean moc;
    private boolean mod;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bmb = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.XI != null) {
                        int cMP = ((VideoPbVideoInfoViewHolder) e.this.XI).cMP();
                        if (cMP == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.XI).AY(2);
                        } else if (cMP == 2) {
                            ((VideoPbVideoInfoViewHolder) e.this.XI).AY(1);
                        }
                        if (e.this.lQH.dlS() || cMP == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.XI).mpP.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) e.this.XI).mpS.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) e.this.XI).mpP.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) e.this.XI).mpS.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bh.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bf.bsY().b(e.this.gYU.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gYU.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).aq("obj_type", 2));
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
                            bf.bsY().b(e.this.gYU.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gYU.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        ar arVar = new ar("c13715");
                        arVar.dR("fid", fid);
                        arVar.dR("fname", fName);
                        arVar.v("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.dR("tid", tid);
                        arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    TiebaStatic.log(new ar("c11923").aq("obj_id", 2));
                    ar arVar2 = new ar("c13267");
                    arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar2.dR("fid", fid);
                    arVar2.dR("tid", tid);
                    arVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new ar("c11923").aq("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (e.this.lQH != null && e.this.lQH.getForum() != null) {
                        str = e.this.lQH.getForum().getName();
                    }
                    ar arVar3 = new ar("c13267");
                    arVar3.dR("uid", str3);
                    if (e.this.lQH != null) {
                        arVar3.dR("fid", e.this.lQH.getForumId());
                        arVar3.dR("tid", e.this.lQH.getThreadId());
                    }
                    arVar3.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fZG = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.XI != null && ((VideoPbVideoInfoViewHolder) e.this.XI).mpI != null) {
                    ((VideoPbVideoInfoViewHolder) e.this.XI).mpI.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gYU = baseFragment;
        this.gYU.registerListener(this.fZG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cK */
    public VideoPbVideoInfoViewHolder e(ViewGroup viewGroup) {
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gYU instanceof VideoPbFragment ? (VideoPbFragment) this.gYU : null);
        videoPbVideoInfoViewHolder.setOnClickListener(this.mOnClickListener);
        b(videoPbVideoInfoViewHolder);
        this.XI = videoPbVideoInfoViewHolder;
        return videoPbVideoInfoViewHolder;
    }

    public void hc(String str) {
        this.bmb = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lQH != null && this.lQH.dlp() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gYU.getUniqueId(), this.lQH, postData, 1, 1);
            a(videoPbVideoInfoViewHolder);
            a(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder, postData);
            d(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bnS() != null) {
            String userId = postData.bnS().getUserId();
            String forumId = this.lQH != null ? this.lQH.getForumId() : "";
            String forumName = this.lQH != null ? this.lQH.getForumName() : "";
            int dNO = postData.dNO();
            String id = postData.getId();
            ar arVar = new ar("c13714");
            arVar.dR("fid", forumId);
            arVar.dR("fname", forumName);
            arVar.dR("obj_param1", userId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", id);
            arVar.aq(TiebaInitialize.Params.OBJ_PARAM2, dNO);
            TiebaStatic.log(arVar);
        }
    }

    public void setPbData(f fVar) {
        this.lQH = fVar;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lQH != null && this.lQH.dlp() != null && this.lQH.dlp().bnS() != null && postData != null) {
            a(videoPbVideoInfoViewHolder, this.lQH.dlp().bnS(), postData);
            a(videoPbVideoInfoViewHolder, this.lQH.dlp().bnS());
            b(videoPbVideoInfoViewHolder, this.lQH.dlp().bnS());
            a(videoPbVideoInfoViewHolder.jwW, this.lQH.dly());
            c(videoPbVideoInfoViewHolder, postData);
            c(videoPbVideoInfoViewHolder, this.lQH.dlp().bnS());
            d(videoPbVideoInfoViewHolder, this.lQH.dlp().bnS());
            b(videoPbVideoInfoViewHolder, this.lQH.dlp().bnS(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lQH != null && this.lQH.dlS()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnS() != null) {
                MetaData bnS = postData.bnS();
                if (this.bmb != null && !this.bmb.equals("0") && this.bmb.equals(bnS.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0302).oh(R.string.J_X04).ol(R.dimen.L_X01).ok(R.color.CAM_X0302);
                } else if (bnS.getIs_bawu() == 1 && postData.dNG()) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnS.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnS.getIs_bawu() == 1 && "pri_content_assist".equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnS.getIs_bawu() == 1 && "pri_manage_assist".equals(bnS.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0101).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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

    private void b(final VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        String formatTime;
        if (this.lQH != null && this.lQH.dlp() != null && postData != null) {
            videoPbVideoInfoViewHolder.a(this.mContext, this.lQH.dlp().bnQ(), this.lQH.dlp().getTitle(), this.lQH.dlp(), x(postData));
            if (this.lQH.dlp().boj() != null) {
                String numberUniformFormatExtra = au.numberUniformFormatExtra(this.lQH.dlp().boj().play_count.intValue());
                videoPbVideoInfoViewHolder.fVC.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                videoPbVideoInfoViewHolder.mpT.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = au.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = au.getFormatTime(postData.getTime());
            }
            videoPbVideoInfoViewHolder.mpO.setText(formatTime + this.mContext.getString(R.string.send_post));
            videoPbVideoInfoViewHolder.mpU.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dNR = postData.dNR();
            if (dNR != null && !TextUtils.isEmpty(dNR.getName()) && !TextUtils.isEmpty(dNR.getName().trim())) {
                videoPbVideoInfoViewHolder.mpP.setText(dNR.getName());
                videoPbVideoInfoViewHolder.mpV.setText(dNR.getName());
                videoPbVideoInfoViewHolder.mpP.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mpP.setVisibility(8);
            }
            if (dNR != null && !TextUtils.isEmpty(dNR.getDistance())) {
                videoPbVideoInfoViewHolder.mpS.setText(dNR.getDistance());
                videoPbVideoInfoViewHolder.mpW.setText(dNR.getDistance());
                videoPbVideoInfoViewHolder.mpS.setVisibility(0);
                final int measureText = (int) videoPbVideoInfoViewHolder.mpS.getPaint().measureText(dNR.getDistance(), 0, dNR.getDistance().length());
                videoPbVideoInfoViewHolder.mpQ.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mpQ.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.fVC.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mpO.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mpS.setVisibility(8);
                            videoPbVideoInfoViewHolder.mpP.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mpP.setVisibility(8);
                        }
                    }
                });
                videoPbVideoInfoViewHolder.mpN.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mpN.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.mpT.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mpU.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mpW.setVisibility(8);
                            videoPbVideoInfoViewHolder.mpV.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mpV.setVisibility(8);
                        }
                    }
                });
            } else {
                videoPbVideoInfoViewHolder.mpS.setVisibility(8);
            }
            PollData bqa = this.lQH.dlp().bqa();
            if (bqa != null && bqa.getOptions() != null && bqa.getOptions().size() > 0) {
                videoPbVideoInfoViewHolder.mgY.setPageContext(this.gYU.getPageContext());
                videoPbVideoInfoViewHolder.mgY.setDataForPb(bqa, this.lQH.getThreadId(), this.lQH.getForumId());
                videoPbVideoInfoViewHolder.mgY.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mgY.setVisibility(8);
            }
            if (videoPbVideoInfoViewHolder.lSN != null) {
                videoPbVideoInfoViewHolder.lSN.removeAllViews();
            }
            if (this.lQH != null && this.lQH.dlp() != null && !aL(this.lQH.dlp()) && (!y.isEmpty(this.lQH.dlp().bqb()) || !y.isEmpty(this.lQH.dlp().bqc()))) {
                ah ahVar = new ah();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lQH, ahVar.n(this.lQH.dlp().bqb(), this.lQH.dlp().bqc()), this.lQH.getForumName(), (VideoPbFragment) this.gYU, ahVar.bFQ());
                videoPbVideoInfoViewHolder.lSN.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.lSN.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.lSN.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.a(this.mContext, postData);
        }
    }

    private boolean aL(cb cbVar) {
        return (cbVar == null || cbVar.bqa() == null || cbVar.bqa().getOptions() == null || cbVar.bqa().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && y.getCount(postData.nAb) >= 2;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lQH != null) {
            this.mnZ = this.lQH.lMs;
            if (this.lQH.dlp() != null) {
                this.mob = this.lQH.dlp().bnO() == 1;
                this.moa = this.lQH.dlp().bnN() == 1;
            }
            videoPbVideoInfoViewHolder.l(this.mnZ, this.mob, this.moa);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lQH != null && metaData != null && postData != null) {
            videoPbVideoInfoViewHolder.mpC.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.mpC.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.mpC.getHeadView().setTid(postData.getId());
            videoPbVideoInfoViewHolder.mpC.getHeadView().setFid(this.lQH != null ? this.lQH.getForumId() : "");
            videoPbVideoInfoViewHolder.mpC.getHeadView().setFName(this.lQH != null ? this.lQH.getForumName() : "");
            videoPbVideoInfoViewHolder.mpC.a(metaData, 4);
            videoPbVideoInfoViewHolder.mpC.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.tz(true);
                videoPbVideoInfoViewHolder.mpC.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.mpC.getHeadView().setAlaInfo(postData.bnS().getAlaInfo());
                k(postData);
                return;
            }
            videoPbVideoInfoViewHolder.tz(false);
            videoPbVideoInfoViewHolder.mpC.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.mpC.getHeadView().setAlaInfo(null);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.moc = true;
                videoPbVideoInfoViewHolder.mpD.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eKp.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.moc = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eKp.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            videoPbVideoInfoViewHolder.mpD.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            videoPbVideoInfoViewHolder.eKp.setText(metaData.getName_show());
            videoPbVideoInfoViewHolder.eKp.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.eKp.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mod = metaData.isBigV();
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lQH != null && this.lQH.dlp() != null) {
            this.meT = 0;
            if (!this.lQH.dlp().bpr()) {
                if (postData != null && postData.bnS() != null) {
                    this.meT = postData.bnS().getLevel_id();
                }
                if (!this.lQH.dlS()) {
                    videoPbVideoInfoViewHolder.jwX.setVisibility(0);
                    videoPbVideoInfoViewHolder.zv(this.meT);
                    return;
                }
                videoPbVideoInfoViewHolder.jwX.setVisibility(8);
                return;
            }
            videoPbVideoInfoViewHolder.jwX.setVisibility(8);
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lQH != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.mpE.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.mpE.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lQH != null && metaData != null) {
            videoPbVideoInfoViewHolder.mpF.setText(au.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mpF.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.jwY.setText(metaData.getNewGodData().getFieldName() + aj.lA(metaData.getNewGodData().isVideoGod()));
            videoPbVideoInfoViewHolder.jwY.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            videoPbVideoInfoViewHolder.jwY.setText(au.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            videoPbVideoInfoViewHolder.jwY.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !au.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mpF.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.jwY.setText(metaData.getBaijiahaoInfo().auth_desc);
            videoPbVideoInfoViewHolder.jwY.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mpF.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            videoPbVideoInfoViewHolder.jwY.setVisibility(8);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lQH != null && postData != null && postData.bnS() != null) {
            String threadId = this.lQH != null ? this.lQH.getThreadId() : "";
            int r = r(this.lQH);
            if (this.meN == null) {
                this.meN = new an(this.gYU.getPageContext(), videoPbVideoInfoViewHolder.mpG, 4);
                this.meN.l(this.gYU.getUniqueId());
            }
            postData.bnS().setIsLike(postData.bnS().hadConcerned());
            this.meN.a(postData.bnS());
            this.meN.setTid(threadId);
            this.meN.setThreadData(this.lQH.dlp());
            this.meN.maV = true;
            this.meN.Gd(r);
            if (au.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoPbVideoInfoViewHolder.mpG.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoPbVideoInfoViewHolder.mpG.setVisibility(8);
            }
            if (this.lQH.lMr) {
                videoPbVideoInfoViewHolder.mpG.setVisibility(8);
            }
        }
    }

    public void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder != null) {
            videoPbVideoInfoViewHolder.zv(this.meT);
            videoPbVideoInfoViewHolder.wy(this.moc || this.mod);
            videoPbVideoInfoViewHolder.l(this.mnZ, this.mob, this.moa);
            videoPbVideoInfoViewHolder.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dlp() == null) {
            return 0;
        }
        if (fVar.dlp().bpr()) {
            return (y.isEmpty(fVar.dlM()) && (fVar.dlo() == null || StringUtils.isNull(fVar.dlo().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        videoPbVideoInfoViewHolder.bS(8, null);
        if (this.lQH != null && this.lQH.dlp() != null && postData != null) {
            if (postData.nzP) {
                videoPbVideoInfoViewHolder.bS(0, postData.getId());
            }
            if (this.gYU instanceof VideoPbFragment) {
                ((VideoPbFragment) this.gYU).wn(postData.nzP);
            }
        }
    }
}
