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
    private BaseFragment gXl;
    private f lOF;
    private View.OnClickListener mOnClickListener;
    private an mcK;
    private int mcQ;
    private boolean mlX;
    private boolean mlY;
    private boolean mlZ;
    private boolean mma;
    private boolean mmb;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.bkB = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.Wo != null) {
                        int cMJ = ((VideoPbVideoInfoViewHolder) e.this.Wo).cMJ();
                        if (cMJ == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).AX(2);
                        } else if (cMJ == 2) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).AX(1);
                        }
                        if (e.this.lOF.dlJ() || cMJ == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnM.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnP.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnM.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) e.this.Wo).mnP.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bh.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bf.bsV().b(e.this.gXl.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gXl.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                            bf.bsV().b(e.this.gXl.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gXl.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
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
                    if (e.this.lOF != null && e.this.lOF.getForum() != null) {
                        str = e.this.lOF.getForum().getName();
                    }
                    ar arVar3 = new ar("c13267");
                    arVar3.dR("uid", str3);
                    if (e.this.lOF != null) {
                        arVar3.dR("fid", e.this.lOF.getForumId());
                        arVar3.dR("tid", e.this.lOF.getThreadId());
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
                if (e.this.Wo != null && ((VideoPbVideoInfoViewHolder) e.this.Wo).mnF != null) {
                    ((VideoPbVideoInfoViewHolder) e.this.Wo).mnF.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gXl = baseFragment;
        this.gXl.registerListener(this.fYg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cL */
    public VideoPbVideoInfoViewHolder e(ViewGroup viewGroup) {
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gXl instanceof VideoPbFragment ? (VideoPbFragment) this.gXl : null);
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
        if (this.lOF != null && this.lOF.dlg() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gXl.getUniqueId(), this.lOF, postData, 1, 1);
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
            String forumId = this.lOF != null ? this.lOF.getForumId() : "";
            String forumName = this.lOF != null ? this.lOF.getForumName() : "";
            int dNF = postData.dNF();
            String id = postData.getId();
            ar arVar = new ar("c13714");
            arVar.dR("fid", forumId);
            arVar.dR("fname", forumName);
            arVar.dR("obj_param1", userId);
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            arVar.dR("tid", id);
            arVar.ap(TiebaInitialize.Params.OBJ_PARAM2, dNF);
            TiebaStatic.log(arVar);
        }
    }

    public void setPbData(f fVar) {
        this.lOF = fVar;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lOF != null && this.lOF.dlg() != null && this.lOF.dlg().bnQ() != null && postData != null) {
            a(videoPbVideoInfoViewHolder, this.lOF.dlg().bnQ(), postData);
            a(videoPbVideoInfoViewHolder, this.lOF.dlg().bnQ());
            b(videoPbVideoInfoViewHolder, this.lOF.dlg().bnQ());
            a(videoPbVideoInfoViewHolder.jvn, this.lOF.dlp());
            c(videoPbVideoInfoViewHolder, postData);
            c(videoPbVideoInfoViewHolder, this.lOF.dlg().bnQ());
            d(videoPbVideoInfoViewHolder, this.lOF.dlg().bnQ());
            b(videoPbVideoInfoViewHolder, this.lOF.dlg().bnQ(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lOF != null && this.lOF.dlJ()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.bnQ() != null) {
                MetaData bnQ = postData.bnQ();
                if (this.bkB != null && !this.bkB.equals("0") && this.bkB.equals(bnQ.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0302).og(R.string.J_X04).ok(R.dimen.L_X01).oj(R.color.CAM_X0302);
                } else if (bnQ.getIs_bawu() == 1 && postData.dNx()) {
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
        if (this.lOF != null && this.lOF.dlg() != null && postData != null) {
            videoPbVideoInfoViewHolder.a(this.mContext, this.lOF.dlg().bnO(), this.lOF.dlg().getTitle(), this.lOF.dlg(), x(postData));
            if (this.lOF.dlg().boh() != null) {
                String numberUniformFormatExtra = au.numberUniformFormatExtra(this.lOF.dlg().boh().play_count.intValue());
                videoPbVideoInfoViewHolder.fUc.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                videoPbVideoInfoViewHolder.mnQ.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = au.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = au.getFormatTime(postData.getTime());
            }
            videoPbVideoInfoViewHolder.mnL.setText(formatTime + this.mContext.getString(R.string.send_post));
            videoPbVideoInfoViewHolder.mnR.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dNI = postData.dNI();
            if (dNI != null && !TextUtils.isEmpty(dNI.getName()) && !TextUtils.isEmpty(dNI.getName().trim())) {
                videoPbVideoInfoViewHolder.mnM.setText(dNI.getName());
                videoPbVideoInfoViewHolder.mnS.setText(dNI.getName());
                videoPbVideoInfoViewHolder.mnM.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mnM.setVisibility(8);
            }
            if (dNI != null && !TextUtils.isEmpty(dNI.getDistance())) {
                videoPbVideoInfoViewHolder.mnP.setText(dNI.getDistance());
                videoPbVideoInfoViewHolder.mnT.setText(dNI.getDistance());
                videoPbVideoInfoViewHolder.mnP.setVisibility(0);
                final int measureText = (int) videoPbVideoInfoViewHolder.mnP.getPaint().measureText(dNI.getDistance(), 0, dNI.getDistance().length());
                videoPbVideoInfoViewHolder.mnN.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mnN.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.fUc.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mnL.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mnP.setVisibility(8);
                            videoPbVideoInfoViewHolder.mnM.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mnM.setVisibility(8);
                        }
                    }
                });
                videoPbVideoInfoViewHolder.mnK.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mnK.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.mnQ.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mnR.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mnT.setVisibility(8);
                            videoPbVideoInfoViewHolder.mnS.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mnS.setVisibility(8);
                        }
                    }
                });
            } else {
                videoPbVideoInfoViewHolder.mnP.setVisibility(8);
            }
            PollData bpY = this.lOF.dlg().bpY();
            if (bpY != null && bpY.getOptions() != null && bpY.getOptions().size() > 0) {
                videoPbVideoInfoViewHolder.meW.setPageContext(this.gXl.getPageContext());
                videoPbVideoInfoViewHolder.meW.setDataForPb(bpY, this.lOF.getThreadId(), this.lOF.getForumId());
                videoPbVideoInfoViewHolder.meW.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.meW.setVisibility(8);
            }
            if (videoPbVideoInfoViewHolder.lQL != null) {
                videoPbVideoInfoViewHolder.lQL.removeAllViews();
            }
            if (this.lOF != null && this.lOF.dlg() != null && !aL(this.lOF.dlg()) && (!y.isEmpty(this.lOF.dlg().bpZ()) || !y.isEmpty(this.lOF.dlg().bqa()))) {
                ah ahVar = new ah();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lOF, ahVar.o(this.lOF.dlg().bpZ(), this.lOF.dlg().bqa()), this.lOF.getForumName(), (VideoPbFragment) this.gXl, ahVar.bFM());
                videoPbVideoInfoViewHolder.lQL.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.lQL.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.lQL.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.a(this.mContext, postData);
        }
    }

    private boolean aL(cb cbVar) {
        return (cbVar == null || cbVar.bpY() == null || cbVar.bpY().getOptions() == null || cbVar.bpY().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && y.getCount(postData.nxW) >= 2;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lOF != null) {
            this.mlX = this.lOF.lKq;
            if (this.lOF.dlg() != null) {
                this.mlZ = this.lOF.dlg().bnM() == 1;
                this.mlY = this.lOF.dlg().bnL() == 1;
            }
            videoPbVideoInfoViewHolder.l(this.mlX, this.mlZ, this.mlY);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lOF != null && metaData != null && postData != null) {
            videoPbVideoInfoViewHolder.mnz.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.mnz.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.mnz.getHeadView().setTid(postData.getId());
            videoPbVideoInfoViewHolder.mnz.getHeadView().setFid(this.lOF != null ? this.lOF.getForumId() : "");
            videoPbVideoInfoViewHolder.mnz.getHeadView().setFName(this.lOF != null ? this.lOF.getForumName() : "");
            videoPbVideoInfoViewHolder.mnz.a(metaData, 4);
            videoPbVideoInfoViewHolder.mnz.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.tz(true);
                videoPbVideoInfoViewHolder.mnz.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.mnz.getHeadView().setAlaInfo(postData.bnQ().getAlaInfo());
                k(postData);
                return;
            }
            videoPbVideoInfoViewHolder.tz(false);
            videoPbVideoInfoViewHolder.mnz.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.mnz.getHeadView().setAlaInfo(null);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.mma = true;
                videoPbVideoInfoViewHolder.mnA.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eIO.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.mma = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eIO.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            videoPbVideoInfoViewHolder.mnA.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            videoPbVideoInfoViewHolder.eIO.setText(metaData.getName_show());
            videoPbVideoInfoViewHolder.eIO.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.eIO.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mmb = metaData.isBigV();
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lOF != null && this.lOF.dlg() != null) {
            this.mcQ = 0;
            if (!this.lOF.dlg().bpp()) {
                if (postData != null && postData.bnQ() != null) {
                    this.mcQ = postData.bnQ().getLevel_id();
                }
                if (!this.lOF.dlJ()) {
                    videoPbVideoInfoViewHolder.jvo.setVisibility(0);
                    videoPbVideoInfoViewHolder.zu(this.mcQ);
                    return;
                }
                videoPbVideoInfoViewHolder.jvo.setVisibility(8);
                return;
            }
            videoPbVideoInfoViewHolder.jvo.setVisibility(8);
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lOF != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.mnB.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.mnB.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lOF != null && metaData != null) {
            videoPbVideoInfoViewHolder.mnC.setText(au.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mnC.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.jvp.setText(metaData.getNewGodData().getFieldName() + aj.lA(metaData.getNewGodData().isVideoGod()));
            videoPbVideoInfoViewHolder.jvp.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            videoPbVideoInfoViewHolder.jvp.setText(au.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            videoPbVideoInfoViewHolder.jvp.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !au.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mnC.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.jvp.setText(metaData.getBaijiahaoInfo().auth_desc);
            videoPbVideoInfoViewHolder.jvp.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.mnC.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            videoPbVideoInfoViewHolder.jvp.setVisibility(8);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lOF != null && postData != null && postData.bnQ() != null) {
            String threadId = this.lOF != null ? this.lOF.getThreadId() : "";
            int r = r(this.lOF);
            if (this.mcK == null) {
                this.mcK = new an(this.gXl.getPageContext(), videoPbVideoInfoViewHolder.mnD, 4);
                this.mcK.l(this.gXl.getUniqueId());
            }
            postData.bnQ().setIsLike(postData.bnQ().hadConcerned());
            this.mcK.a(postData.bnQ());
            this.mcK.setTid(threadId);
            this.mcK.setThreadData(this.lOF.dlg());
            this.mcK.lYQ = true;
            this.mcK.Ga(r);
            if (au.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoPbVideoInfoViewHolder.mnD.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoPbVideoInfoViewHolder.mnD.setVisibility(8);
            }
            if (this.lOF.lKp) {
                videoPbVideoInfoViewHolder.mnD.setVisibility(8);
            }
        }
    }

    public void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder != null) {
            videoPbVideoInfoViewHolder.zu(this.mcQ);
            videoPbVideoInfoViewHolder.wy(this.mma || this.mmb);
            videoPbVideoInfoViewHolder.l(this.mlX, this.mlZ, this.mlY);
            videoPbVideoInfoViewHolder.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dlg() == null) {
            return 0;
        }
        if (fVar.dlg().bpp()) {
            return (y.isEmpty(fVar.dlD()) && (fVar.dlf() == null || StringUtils.isNull(fVar.dlf().getForumName()))) ? 0 : 2;
        }
        return 1;
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        videoPbVideoInfoViewHolder.bS(8, null);
        if (this.lOF != null && this.lOF.dlg() != null && postData != null) {
            if (postData.nxK) {
                videoPbVideoInfoViewHolder.bS(0, postData.getId());
            }
            if (this.gXl instanceof VideoPbFragment) {
                ((VideoPbFragment) this.gXl).wn(postData.nxK);
            }
        }
    }
}
