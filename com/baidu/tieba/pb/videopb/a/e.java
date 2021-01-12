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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.ag;
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
    private String bhj;
    private CustomMessageListener fVQ;
    private BaseFragment gUn;
    private f lFA;
    private an lTr;
    private int lTx;
    private View.OnClickListener mOnClickListener;
    private boolean mcG;
    private boolean mcH;
    private boolean mcI;
    private boolean mcJ;
    private boolean mcK;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bhj = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.Ws != null) {
                        int dti = ((VideoPbVideoInfoViewHolder) e.this.Ws).dti();
                        if (dti == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Ws).Gh(2);
                        } else if (dti == 2) {
                            ((VideoPbVideoInfoViewHolder) e.this.Ws).Gh(1);
                        }
                        if (e.this.lFA.djq() || dti == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Ws).mev.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) e.this.Ws).mey.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) e.this.Ws).mev.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) e.this.Ws).mey.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.bsB().b(e.this.gUn.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gUn.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new aq(CommonStatisticKey.USER_ICON_VISIT).an("obj_type", 2));
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
                            be.bsB().b(e.this.gUn.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gUn.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dW("fid", fid);
                        aqVar.dW("fname", fName);
                        aqVar.w("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dW("tid", tid);
                        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").an("obj_id", 2));
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dW("fid", fid);
                    aqVar2.dW("tid", tid);
                    aqVar2.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new aq("c11923").an("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (e.this.lFA != null && e.this.lFA.getForum() != null) {
                        str = e.this.lFA.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dW("uid", str3);
                    if (e.this.lFA != null) {
                        aqVar3.dW("fid", e.this.lFA.getForumId());
                        aqVar3.dW("tid", e.this.lFA.getThreadId());
                    }
                    aqVar3.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.fVQ = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.Ws != null && ((VideoPbVideoInfoViewHolder) e.this.Ws).meo != null) {
                    ((VideoPbVideoInfoViewHolder) e.this.Ws).meo.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gUn = baseFragment;
        this.gUn.registerListener(this.fVQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cK */
    public VideoPbVideoInfoViewHolder e(ViewGroup viewGroup) {
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gUn instanceof VideoPbFragment ? (VideoPbFragment) this.gUn : null);
        videoPbVideoInfoViewHolder.setOnClickListener(this.mOnClickListener);
        b(videoPbVideoInfoViewHolder);
        this.Ws = videoPbVideoInfoViewHolder;
        return videoPbVideoInfoViewHolder;
    }

    public void gy(String str) {
        this.bhj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lFA != null && this.lFA.diN() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gUn.getUniqueId(), this.lFA, postData, 1, 1);
            a(videoPbVideoInfoViewHolder);
            a(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.bnx() != null) {
            String userId = postData.bnx().getUserId();
            String forumId = this.lFA != null ? this.lFA.getForumId() : "";
            String forumName = this.lFA != null ? this.lFA.getForumName() : "";
            int dLm = postData.dLm();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dW("fid", forumId);
            aqVar.dW("fname", forumName);
            aqVar.dW("obj_param1", userId);
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dW("tid", id);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, dLm);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.lFA = fVar;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lFA != null && this.lFA.diN() != null && this.lFA.diN().bnx() != null && postData != null) {
            a(videoPbVideoInfoViewHolder, this.lFA.diN().bnx(), postData);
            a(videoPbVideoInfoViewHolder, this.lFA.diN().bnx());
            b(videoPbVideoInfoViewHolder, this.lFA.diN().bnx());
            a(videoPbVideoInfoViewHolder.jpt, this.lFA.diW());
            c(videoPbVideoInfoViewHolder, postData);
            c(videoPbVideoInfoViewHolder, this.lFA.diN().bnx());
            d(videoPbVideoInfoViewHolder, this.lFA.diN().bnx());
            b(videoPbVideoInfoViewHolder, this.lFA.diN().bnx(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lFA != null && this.lFA.djq()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnx() != null) {
                MetaData bnx = postData.bnx();
                if (this.bhj != null && !this.bhj.equals("0") && this.bhj.equals(bnx.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0302).od(R.string.J_X04).og(R.dimen.L_X01).of(R.color.CAM_X0302);
                } else if (bnx.getIs_bawu() == 1 && postData.dLe()) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (bnx.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (bnx.getIs_bawu() == 1 && "pri_content_assist".equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (bnx.getIs_bawu() == 1 && "pri_manage_assist".equals(bnx.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0101).od(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (this.lFA != null && this.lFA.diN() != null && postData != null) {
            videoPbVideoInfoViewHolder.a(this.mContext, this.lFA.diN().bnv(), this.lFA.diN().getTitle(), this.lFA.diN(), x(postData));
            if (this.lFA.diN().bnO() != null) {
                String numberUniformFormatExtra = at.numberUniformFormatExtra(this.lFA.diN().bnO().play_count.intValue());
                videoPbVideoInfoViewHolder.fRN.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                videoPbVideoInfoViewHolder.mez.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            videoPbVideoInfoViewHolder.meu.setText(formatTime + this.mContext.getString(R.string.send_post));
            videoPbVideoInfoViewHolder.meA.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dLp = postData.dLp();
            if (dLp != null && !TextUtils.isEmpty(dLp.getName()) && !TextUtils.isEmpty(dLp.getName().trim())) {
                videoPbVideoInfoViewHolder.mev.setText(dLp.getName());
                videoPbVideoInfoViewHolder.meB.setText(dLp.getName());
                videoPbVideoInfoViewHolder.mev.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mev.setVisibility(8);
            }
            if (dLp != null && !TextUtils.isEmpty(dLp.getDistance())) {
                videoPbVideoInfoViewHolder.mey.setText(dLp.getDistance());
                videoPbVideoInfoViewHolder.meC.setText(dLp.getDistance());
                videoPbVideoInfoViewHolder.mey.setVisibility(0);
                final int measureText = (int) videoPbVideoInfoViewHolder.mey.getPaint().measureText(dLp.getDistance(), 0, dLp.getDistance().length());
                videoPbVideoInfoViewHolder.mew.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mew.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.fRN.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.meu.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mey.setVisibility(8);
                            videoPbVideoInfoViewHolder.mev.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mev.setVisibility(8);
                        }
                    }
                });
                videoPbVideoInfoViewHolder.met.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.met.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.mez.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.meA.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.meC.setVisibility(8);
                            videoPbVideoInfoViewHolder.meB.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.meB.setVisibility(8);
                        }
                    }
                });
            } else {
                videoPbVideoInfoViewHolder.mey.setVisibility(8);
            }
            PollData bpG = this.lFA.diN().bpG();
            if (bpG != null && bpG.getOptions() != null && bpG.getOptions().size() > 0) {
                videoPbVideoInfoViewHolder.lVC.setPageContext(this.gUn.getPageContext());
                videoPbVideoInfoViewHolder.lVC.setDataForPb(bpG, this.lFA.getThreadId(), this.lFA.getForumId());
                videoPbVideoInfoViewHolder.lVC.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.lVC.setVisibility(8);
            }
            if (videoPbVideoInfoViewHolder.lHC != null) {
                videoPbVideoInfoViewHolder.lHC.removeAllViews();
            }
            if (this.lFA != null && this.lFA.diN() != null && !aK(this.lFA.diN()) && (!x.isEmpty(this.lFA.diN().bpH()) || !x.isEmpty(this.lFA.diN().bpI()))) {
                ae aeVar = new ae();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lFA, aeVar.p(this.lFA.diN().bpH(), this.lFA.diN().bpI()), this.lFA.getForumName(), (VideoPbFragment) this.gUn, aeVar.bFs());
                videoPbVideoInfoViewHolder.lHC.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.lHC.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.lHC.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.a(this.mContext, postData);
        }
    }

    private boolean aK(bz bzVar) {
        return (bzVar == null || bzVar.bpG() == null || bzVar.bpG().getOptions() == null || bzVar.bpG().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && x.getCount(postData.nnL) >= 2;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lFA != null) {
            this.mcG = this.lFA.lBp;
            if (this.lFA.diN() != null) {
                this.mcI = this.lFA.diN().bnt() == 1;
                this.mcH = this.lFA.diN().bns() == 1;
            }
            videoPbVideoInfoViewHolder.l(this.mcG, this.mcI, this.mcH);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lFA != null && metaData != null && postData != null) {
            videoPbVideoInfoViewHolder.meh.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.meh.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.meh.getHeadView().setTid(postData.getId());
            videoPbVideoInfoViewHolder.meh.getHeadView().setFid(this.lFA != null ? this.lFA.getForumId() : "");
            videoPbVideoInfoViewHolder.meh.getHeadView().setFName(this.lFA != null ? this.lFA.getForumName() : "");
            videoPbVideoInfoViewHolder.meh.a(metaData, 4);
            videoPbVideoInfoViewHolder.meh.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.tm(true);
                videoPbVideoInfoViewHolder.meh.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.meh.getHeadView().setAlaInfo(postData.bnx().getAlaInfo());
                k(postData);
                return;
            }
            videoPbVideoInfoViewHolder.tm(false);
            videoPbVideoInfoViewHolder.meh.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.meh.getHeadView().setAlaInfo(null);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.mcJ = true;
                videoPbVideoInfoViewHolder.mei.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eGI.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.mcJ = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eGI.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            videoPbVideoInfoViewHolder.mei.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            videoPbVideoInfoViewHolder.eGI.setText(metaData.getName_show());
            videoPbVideoInfoViewHolder.eGI.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.eGI.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mcK = metaData.isBigV();
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lFA != null && this.lFA.diN() != null) {
            this.lTx = 0;
            if (!this.lFA.diN().boX()) {
                if (postData != null && postData.bnx() != null) {
                    this.lTx = postData.bnx().getLevel_id();
                }
                if (!this.lFA.djq()) {
                    videoPbVideoInfoViewHolder.jpu.setVisibility(0);
                    videoPbVideoInfoViewHolder.zk(this.lTx);
                    return;
                }
                videoPbVideoInfoViewHolder.jpu.setVisibility(8);
                return;
            }
            videoPbVideoInfoViewHolder.jpu.setVisibility(8);
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lFA != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.mej.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.mej.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lFA != null && metaData != null) {
            videoPbVideoInfoViewHolder.mek.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mek.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.jpv.setText(metaData.getNewGodData().getFieldName() + ag.lx(metaData.getNewGodData().isVideoGod()));
            videoPbVideoInfoViewHolder.jpv.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            videoPbVideoInfoViewHolder.jpv.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            videoPbVideoInfoViewHolder.jpv.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mek.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.jpv.setText(metaData.getBaijiahaoInfo().auth_desc);
            videoPbVideoInfoViewHolder.jpv.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mek.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            videoPbVideoInfoViewHolder.jpv.setVisibility(8);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lFA != null && postData != null && postData.bnx() != null) {
            String threadId = this.lFA != null ? this.lFA.getThreadId() : "";
            int r = r(this.lFA);
            if (this.lTr == null) {
                this.lTr = new an(this.gUn.getPageContext(), videoPbVideoInfoViewHolder.mel, 4);
                this.lTr.l(this.gUn.getUniqueId());
            }
            postData.bnx().setIsLike(postData.bnx().hadConcerned());
            this.lTr.a(postData.bnx());
            this.lTr.setTid(threadId);
            this.lTr.setThreadData(this.lFA.diN());
            this.lTr.lPF = true;
            this.lTr.FH(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoPbVideoInfoViewHolder.mel.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoPbVideoInfoViewHolder.mel.setVisibility(8);
            }
            if (this.lFA.lBo) {
                videoPbVideoInfoViewHolder.mel.setVisibility(8);
            }
        }
    }

    public void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder != null) {
            videoPbVideoInfoViewHolder.zk(this.lTx);
            videoPbVideoInfoViewHolder.wh(this.mcJ || this.mcK);
            videoPbVideoInfoViewHolder.l(this.mcG, this.mcI, this.mcH);
            videoPbVideoInfoViewHolder.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.diN() == null) {
            return 0;
        }
        if (fVar.diN().boX()) {
            return (x.isEmpty(fVar.djk()) && (fVar.diM() == null || StringUtils.isNull(fVar.diM().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
