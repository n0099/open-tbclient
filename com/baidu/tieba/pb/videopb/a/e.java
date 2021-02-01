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
    private String bkB;
    private CustomMessageListener fYg;
    private BaseFragment gWX;
    private f lOq;
    private View.OnClickListener mOnClickListener;
    private int mcB;
    private an mcv;
    private boolean mlI;
    private boolean mlJ;
    private boolean mlK;
    private boolean mlL;
    private boolean mlM;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bkB = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.Wo != null) {
                        int cMC = ((VideoPbVideoInfoViewHolder) e.this.Wo).cMC();
                        if (cMC == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).AX(2);
                        } else if (cMC == 2) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).AX(1);
                        }
                        if (e.this.lOq.dlC() || cMC == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnx.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnA.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnx.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnA.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bh.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bf.bsV().b(e.this.gWX.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gWX.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new ar(CommonStatisticKey.USER_ICON_VISIT).ap("obj_type", 2));
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
                            bf.bsV().b(e.this.gWX.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gWX.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        ar arVar = new ar("c13715");
                        arVar.dR("fid", fid);
                        arVar.dR("fname", fName);
                        arVar.v("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar.dR("tid", tid);
                        arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    TiebaStatic.log(new ar("c11923").ap("obj_id", 2));
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
                    TiebaStatic.log(new ar("c11923").ap("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (e.this.lOq != null && e.this.lOq.getForum() != null) {
                        str = e.this.lOq.getForum().getName();
                    }
                    ar arVar3 = new ar("c13267");
                    arVar3.dR("uid", str3);
                    if (e.this.lOq != null) {
                        arVar3.dR("fid", e.this.lOq.getForumId());
                        arVar3.dR("tid", e.this.lOq.getThreadId());
                    }
                    arVar3.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(arVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fYg = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.Wo != null && ((VideoPbVideoInfoViewHolder) e.this.Wo).mnq != null) {
                    ((VideoPbVideoInfoViewHolder) e.this.Wo).mnq.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gWX = baseFragment;
        this.gWX.registerListener(this.fYg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public VideoPbVideoInfoViewHolder e(ViewGroup viewGroup) {
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gWX instanceof VideoPbFragment ? (VideoPbFragment) this.gWX : null);
        videoPbVideoInfoViewHolder.setOnClickListener(this.mOnClickListener);
        b(videoPbVideoInfoViewHolder);
        this.Wo = videoPbVideoInfoViewHolder;
        return videoPbVideoInfoViewHolder;
    }

    public void gW(String str) {
        this.bkB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lOq != null && this.lOq.dkZ() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gWX.getUniqueId(), this.lOq, postData, 1, 1);
            a(videoPbVideoInfoViewHolder);
            a(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder, postData);
            d(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bnQ() != null) {
            String userId = postData.bnQ().getUserId();
            String forumId = this.lOq != null ? this.lOq.getForumId() : "";
            String forumName = this.lOq != null ? this.lOq.getForumName() : "";
            int dNx = postData.dNx();
            String id = postData.getId();
            ar arVar = new ar("c13714");
            arVar.dR("fid", forumId);
            arVar.dR("fname", forumName);
            arVar.dR("obj_param1", userId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", id);
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, dNx);
            TiebaStatic.log(arVar);
        }
    }

    public void setPbData(f fVar) {
        this.lOq = fVar;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lOq != null && this.lOq.dkZ() != null && this.lOq.dkZ().bnQ() != null && postData != null) {
            a(videoPbVideoInfoViewHolder, this.lOq.dkZ().bnQ(), postData);
            a(videoPbVideoInfoViewHolder, this.lOq.dkZ().bnQ());
            b(videoPbVideoInfoViewHolder, this.lOq.dkZ().bnQ());
            a(videoPbVideoInfoViewHolder.juZ, this.lOq.dli());
            c(videoPbVideoInfoViewHolder, postData);
            c(videoPbVideoInfoViewHolder, this.lOq.dkZ().bnQ());
            d(videoPbVideoInfoViewHolder, this.lOq.dkZ().bnQ());
            b(videoPbVideoInfoViewHolder, this.lOq.dkZ().bnQ(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lOq != null && this.lOq.dlC()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnQ() != null) {
                MetaData bnQ = postData.bnQ();
                if (this.bkB != null && !this.bkB.equals("0") && this.bkB.equals(bnQ.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0302).og(R.string.J_X04).ok(R.dimen.L_X01).oj(R.color.CAM_X0302);
                } else if (bnQ.getIs_bawu() == 1 && postData.dNp()) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnQ.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnQ.getIs_bawu() == 1 && "pri_content_assist".equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnQ.getIs_bawu() == 1 && "pri_manage_assist".equals(bnQ.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0101).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (this.lOq != null && this.lOq.dkZ() != null && postData != null) {
            videoPbVideoInfoViewHolder.a(this.mContext, this.lOq.dkZ().bnO(), this.lOq.dkZ().getTitle(), this.lOq.dkZ(), x(postData));
            if (this.lOq.dkZ().boh() != null) {
                String numberUniformFormatExtra = au.numberUniformFormatExtra(this.lOq.dkZ().boh().play_count.intValue());
                videoPbVideoInfoViewHolder.fUc.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                videoPbVideoInfoViewHolder.mnB.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = au.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = au.getFormatTime(postData.getTime());
            }
            videoPbVideoInfoViewHolder.mnw.setText(formatTime + this.mContext.getString(R.string.send_post));
            videoPbVideoInfoViewHolder.mnC.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dNA = postData.dNA();
            if (dNA != null && !TextUtils.isEmpty(dNA.getName()) && !TextUtils.isEmpty(dNA.getName().trim())) {
                videoPbVideoInfoViewHolder.mnx.setText(dNA.getName());
                videoPbVideoInfoViewHolder.mnD.setText(dNA.getName());
                videoPbVideoInfoViewHolder.mnx.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mnx.setVisibility(8);
            }
            if (dNA != null && !TextUtils.isEmpty(dNA.getDistance())) {
                videoPbVideoInfoViewHolder.mnA.setText(dNA.getDistance());
                videoPbVideoInfoViewHolder.mnE.setText(dNA.getDistance());
                videoPbVideoInfoViewHolder.mnA.setVisibility(0);
                final int measureText = (int) videoPbVideoInfoViewHolder.mnA.getPaint().measureText(dNA.getDistance(), 0, dNA.getDistance().length());
                videoPbVideoInfoViewHolder.mny.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mny.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.fUc.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mnw.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mnA.setVisibility(8);
                            videoPbVideoInfoViewHolder.mnx.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mnx.setVisibility(8);
                        }
                    }
                });
                videoPbVideoInfoViewHolder.mnv.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mnv.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.mnB.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mnC.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mnE.setVisibility(8);
                            videoPbVideoInfoViewHolder.mnD.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mnD.setVisibility(8);
                        }
                    }
                });
            } else {
                videoPbVideoInfoViewHolder.mnA.setVisibility(8);
            }
            PollData bpY = this.lOq.dkZ().bpY();
            if (bpY != null && bpY.getOptions() != null && bpY.getOptions().size() > 0) {
                videoPbVideoInfoViewHolder.meH.setPageContext(this.gWX.getPageContext());
                videoPbVideoInfoViewHolder.meH.setDataForPb(bpY, this.lOq.getThreadId(), this.lOq.getForumId());
                videoPbVideoInfoViewHolder.meH.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.meH.setVisibility(8);
            }
            if (videoPbVideoInfoViewHolder.lQw != null) {
                videoPbVideoInfoViewHolder.lQw.removeAllViews();
            }
            if (this.lOq != null && this.lOq.dkZ() != null && !aL(this.lOq.dkZ()) && (!y.isEmpty(this.lOq.dkZ().bpZ()) || !y.isEmpty(this.lOq.dkZ().bqa()))) {
                ah ahVar = new ah();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lOq, ahVar.o(this.lOq.dkZ().bpZ(), this.lOq.dkZ().bqa()), this.lOq.getForumName(), (VideoPbFragment) this.gWX, ahVar.bFM());
                videoPbVideoInfoViewHolder.lQw.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.lQw.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.lQw.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.a(this.mContext, postData);
        }
    }

    private boolean aL(cb cbVar) {
        return (cbVar == null || cbVar.bpY() == null || cbVar.bpY().getOptions() == null || cbVar.bpY().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && y.getCount(postData.nxw) >= 2;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lOq != null) {
            this.mlI = this.lOq.lKc;
            if (this.lOq.dkZ() != null) {
                this.mlK = this.lOq.dkZ().bnM() == 1;
                this.mlJ = this.lOq.dkZ().bnL() == 1;
            }
            videoPbVideoInfoViewHolder.l(this.mlI, this.mlK, this.mlJ);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lOq != null && metaData != null && postData != null) {
            videoPbVideoInfoViewHolder.mnk.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.mnk.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.mnk.getHeadView().setTid(postData.getId());
            videoPbVideoInfoViewHolder.mnk.getHeadView().setFid(this.lOq != null ? this.lOq.getForumId() : "");
            videoPbVideoInfoViewHolder.mnk.getHeadView().setFName(this.lOq != null ? this.lOq.getForumName() : "");
            videoPbVideoInfoViewHolder.mnk.a(metaData, 4);
            videoPbVideoInfoViewHolder.mnk.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.tz(true);
                videoPbVideoInfoViewHolder.mnk.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.mnk.getHeadView().setAlaInfo(postData.bnQ().getAlaInfo());
                k(postData);
                return;
            }
            videoPbVideoInfoViewHolder.tz(false);
            videoPbVideoInfoViewHolder.mnk.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.mnk.getHeadView().setAlaInfo(null);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.mlL = true;
                videoPbVideoInfoViewHolder.mnl.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eIO.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.mlL = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eIO.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            videoPbVideoInfoViewHolder.mnl.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            videoPbVideoInfoViewHolder.eIO.setText(metaData.getName_show());
            videoPbVideoInfoViewHolder.eIO.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.eIO.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mlM = metaData.isBigV();
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lOq != null && this.lOq.dkZ() != null) {
            this.mcB = 0;
            if (!this.lOq.dkZ().bpp()) {
                if (postData != null && postData.bnQ() != null) {
                    this.mcB = postData.bnQ().getLevel_id();
                }
                if (!this.lOq.dlC()) {
                    videoPbVideoInfoViewHolder.jva.setVisibility(0);
                    videoPbVideoInfoViewHolder.zu(this.mcB);
                    return;
                }
                videoPbVideoInfoViewHolder.jva.setVisibility(8);
                return;
            }
            videoPbVideoInfoViewHolder.jva.setVisibility(8);
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lOq != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.mnm.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.mnm.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lOq != null && metaData != null) {
            videoPbVideoInfoViewHolder.mnn.setText(au.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mnn.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.jvb.setText(metaData.getNewGodData().getFieldName() + aj.lA(metaData.getNewGodData().isVideoGod()));
            videoPbVideoInfoViewHolder.jvb.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            videoPbVideoInfoViewHolder.jvb.setText(au.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            videoPbVideoInfoViewHolder.jvb.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !au.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mnn.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.jvb.setText(metaData.getBaijiahaoInfo().auth_desc);
            videoPbVideoInfoViewHolder.jvb.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mnn.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            videoPbVideoInfoViewHolder.jvb.setVisibility(8);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lOq != null && postData != null && postData.bnQ() != null) {
            String threadId = this.lOq != null ? this.lOq.getThreadId() : "";
            int r = r(this.lOq);
            if (this.mcv == null) {
                this.mcv = new an(this.gWX.getPageContext(), videoPbVideoInfoViewHolder.mno, 4);
                this.mcv.l(this.gWX.getUniqueId());
            }
            postData.bnQ().setIsLike(postData.bnQ().hadConcerned());
            this.mcv.a(postData.bnQ());
            this.mcv.setTid(threadId);
            this.mcv.setThreadData(this.lOq.dkZ());
            this.mcv.lYB = true;
            this.mcv.Ga(r);
            if (au.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoPbVideoInfoViewHolder.mno.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoPbVideoInfoViewHolder.mno.setVisibility(8);
            }
            if (this.lOq.lKb) {
                videoPbVideoInfoViewHolder.mno.setVisibility(8);
            }
        }
    }

    public void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder != null) {
            videoPbVideoInfoViewHolder.zu(this.mcB);
            videoPbVideoInfoViewHolder.wy(this.mlL || this.mlM);
            videoPbVideoInfoViewHolder.l(this.mlI, this.mlK, this.mlJ);
            videoPbVideoInfoViewHolder.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dkZ() == null) {
            return 0;
        }
        if (fVar.dkZ().bpp()) {
            return (y.isEmpty(fVar.dlw()) && (fVar.dkY() == null || StringUtils.isNull(fVar.dkY().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        videoPbVideoInfoViewHolder.bS(8, null);
        if (this.lOq != null && this.lOq.dkZ() != null && postData != null) {
            if (postData.nxk) {
                videoPbVideoInfoViewHolder.bS(0, postData.getId());
            }
            if (this.gWX instanceof VideoPbFragment) {
                ((VideoPbFragment) this.gWX).wn(postData.nxk);
            }
        }
    }
}
