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
    private String blY;
    private BaseFragment gYT;
    private CustomMessageListener gay;
    private f lKe;
    private an lXV;
    private int lYb;
    private View.OnClickListener mOnClickListener;
    private boolean mhl;
    private boolean mhm;
    private boolean mhn;
    private boolean mho;
    private boolean mhp;

    public e(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.blY = null;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item || view.getId() == R.id.video_title_area_video_info_item) {
                    if (e.this.Wu != null) {
                        int dxa = ((VideoPbVideoInfoViewHolder) e.this.Wu).dxa();
                        if (dxa == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wu).HN(2);
                        } else if (dxa == 2) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wu).HN(1);
                        }
                        if (e.this.lKe.dni() || dxa == 1) {
                            ((VideoPbVideoInfoViewHolder) e.this.Wu).mjb.setVisibility(8);
                            ((VideoPbVideoInfoViewHolder) e.this.Wu).mje.setVisibility(8);
                        } else {
                            ((VideoPbVideoInfoViewHolder) e.this.Wu).mjb.setVisibility(0);
                            ((VideoPbVideoInfoViewHolder) e.this.Wu).mje.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bg.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            be.bwv().b(e.this.gYT.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(e.this.gYT.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                            be.bwv().b(e.this.gYT.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(e.this.gYT.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        aq aqVar = new aq("c13715");
                        aqVar.dX("fid", fid);
                        aqVar.dX("fname", fName);
                        aqVar.w("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar.dX("tid", tid);
                        aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    TiebaStatic.log(new aq("c11923").an("obj_id", 2));
                    aq aqVar2 = new aq("c13267");
                    aqVar2.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar2.dX("fid", fid);
                    aqVar2.dX("tid", tid);
                    aqVar2.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new aq("c11923").an("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (e.this.lKe != null && e.this.lKe.getForum() != null) {
                        str = e.this.lKe.getForum().getName();
                    }
                    aq aqVar3 = new aq("c13267");
                    aqVar3.dX("uid", str3);
                    if (e.this.lKe != null) {
                        aqVar3.dX("fid", e.this.lKe.getForumId());
                        aqVar3.dX("tid", e.this.lKe.getThreadId());
                    }
                    aqVar3.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aqVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(e.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.gay = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (e.this.Wu != null && ((VideoPbVideoInfoViewHolder) e.this.Wu).miU != null) {
                    ((VideoPbVideoInfoViewHolder) e.this.Wu).miU.setTextSize(TbConfig.getContentSize());
                    e.this.notifyDataSetChanged();
                }
            }
        };
        this.gYT = baseFragment;
        this.gYT.registerListener(this.gay);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cK */
    public VideoPbVideoInfoViewHolder e(ViewGroup viewGroup) {
        VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false), this.gYT instanceof VideoPbFragment ? (VideoPbFragment) this.gYT : null);
        videoPbVideoInfoViewHolder.setOnClickListener(this.mOnClickListener);
        b(videoPbVideoInfoViewHolder);
        this.Wu = videoPbVideoInfoViewHolder;
        return videoPbVideoInfoViewHolder;
    }

    public void hJ(String str) {
        this.blY = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lKe != null && this.lKe.dmF() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.gYT.getUniqueId(), this.lKe, postData, 1, 1);
            a(videoPbVideoInfoViewHolder);
            a(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder, postData);
            b(videoPbVideoInfoViewHolder);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.brr() != null) {
            String userId = postData.brr().getUserId();
            String forumId = this.lKe != null ? this.lKe.getForumId() : "";
            String forumName = this.lKe != null ? this.lKe.getForumName() : "";
            int dPe = postData.dPe();
            String id = postData.getId();
            aq aqVar = new aq("c13714");
            aqVar.dX("fid", forumId);
            aqVar.dX("fname", forumName);
            aqVar.dX("obj_param1", userId);
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            aqVar.dX("tid", id);
            aqVar.an(TiebaInitialize.Params.OBJ_PARAM2, dPe);
            TiebaStatic.log(aqVar);
        }
    }

    public void setPbData(f fVar) {
        this.lKe = fVar;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lKe != null && this.lKe.dmF() != null && this.lKe.dmF().brr() != null && postData != null) {
            a(videoPbVideoInfoViewHolder, this.lKe.dmF().brr(), postData);
            a(videoPbVideoInfoViewHolder, this.lKe.dmF().brr());
            b(videoPbVideoInfoViewHolder, this.lKe.dmF().brr());
            a(videoPbVideoInfoViewHolder.jtZ, this.lKe.dmO());
            c(videoPbVideoInfoViewHolder, postData);
            c(videoPbVideoInfoViewHolder, this.lKe.dmF().brr());
            d(videoPbVideoInfoViewHolder, this.lKe.dmF().brr());
            b(videoPbVideoInfoViewHolder, this.lKe.dmF().brr(), postData);
        }
    }

    private void a(TextView textView, PostData postData) {
        if (textView != null || postData != null) {
            textView.setTag(postData);
            if (this.lKe != null && this.lKe.dni()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.brr() != null) {
                MetaData brr = postData.brr();
                if (this.blY != null && !this.blY.equals("0") && this.blY.equals(brr.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0302).pK(R.string.J_X04).pN(R.dimen.L_X01).pM(R.color.CAM_X0302);
                } else if (brr.getIs_bawu() == 1 && postData.dOW()) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_Official);
                } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_MANAGER.equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (brr.getIs_bawu() == 1 && Config.BAWU_TYPE_ASSIST.equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (brr.getIs_bawu() == 1 && "pri_content_assist".equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (brr.getIs_bawu() == 1 && "pri_manage_assist".equals(brr.getBawu_type())) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0101).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0302);
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
        if (this.lKe != null && this.lKe.dmF() != null && postData != null) {
            videoPbVideoInfoViewHolder.a(this.mContext, this.lKe.dmF().brp(), this.lKe.dmF().getTitle(), this.lKe.dmF(), x(postData));
            if (this.lKe.dmF().brI() != null) {
                String numberUniformFormatExtra = at.numberUniformFormatExtra(this.lKe.dmF().brI().play_count.intValue());
                videoPbVideoInfoViewHolder.fWu.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
                videoPbVideoInfoViewHolder.mjf.setText(numberUniformFormatExtra + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = at.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = at.getFormatTime(postData.getTime());
            }
            videoPbVideoInfoViewHolder.mja.setText(formatTime + this.mContext.getString(R.string.send_post));
            videoPbVideoInfoViewHolder.mjg.setText(formatTime + this.mContext.getString(R.string.send_post));
            g dPh = postData.dPh();
            if (dPh != null && !TextUtils.isEmpty(dPh.getName()) && !TextUtils.isEmpty(dPh.getName().trim())) {
                videoPbVideoInfoViewHolder.mjb.setText(dPh.getName());
                videoPbVideoInfoViewHolder.mjh.setText(dPh.getName());
                videoPbVideoInfoViewHolder.mjb.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mjb.setVisibility(8);
            }
            if (dPh != null && !TextUtils.isEmpty(dPh.getDistance())) {
                videoPbVideoInfoViewHolder.mje.setText(dPh.getDistance());
                videoPbVideoInfoViewHolder.mji.setText(dPh.getDistance());
                videoPbVideoInfoViewHolder.mje.setVisibility(0);
                final int measureText = (int) videoPbVideoInfoViewHolder.mje.getPaint().measureText(dPh.getDistance(), 0, dPh.getDistance().length());
                videoPbVideoInfoViewHolder.mjc.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.mjc.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.fWu.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mja.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mje.setVisibility(8);
                            videoPbVideoInfoViewHolder.mjb.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mjb.setVisibility(8);
                        }
                    }
                });
                videoPbVideoInfoViewHolder.miZ.post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.a.e.3
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                        int measuredWidth = videoPbVideoInfoViewHolder.miZ.getMeasuredWidth();
                        int measuredWidth2 = videoPbVideoInfoViewHolder.mjf.getMeasuredWidth();
                        int measuredWidth3 = dimenPixelSize + videoPbVideoInfoViewHolder.mjg.getMeasuredWidth() + dimenPixelSize2;
                        int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                        if ((measuredWidth - measuredWidth2) - measuredWidth3 < measureText) {
                            videoPbVideoInfoViewHolder.mji.setVisibility(8);
                            videoPbVideoInfoViewHolder.mjh.setVisibility(8);
                        } else if (((measuredWidth - measuredWidth2) - measuredWidth3) - measureText < dimenPixelSize3) {
                            videoPbVideoInfoViewHolder.mjh.setVisibility(8);
                        }
                    }
                });
            } else {
                videoPbVideoInfoViewHolder.mje.setVisibility(8);
            }
            PollData btA = this.lKe.dmF().btA();
            if (btA != null && btA.getOptions() != null && btA.getOptions().size() > 0) {
                videoPbVideoInfoViewHolder.mah.setPageContext(this.gYT.getPageContext());
                videoPbVideoInfoViewHolder.mah.setDataForPb(btA, this.lKe.getThreadId(), this.lKe.getForumId());
                videoPbVideoInfoViewHolder.mah.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.mah.setVisibility(8);
            }
            if (videoPbVideoInfoViewHolder.lMg != null) {
                videoPbVideoInfoViewHolder.lMg.removeAllViews();
            }
            if (this.lKe != null && this.lKe.dmF() != null && !aK(this.lKe.dmF()) && (!x.isEmpty(this.lKe.dmF().btB()) || !x.isEmpty(this.lKe.dmF().btC()))) {
                ae aeVar = new ae();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                pbLinkGoodsRootView.a(this.lKe, aeVar.p(this.lKe.dmF().btB(), this.lKe.dmF().btC()), this.lKe.getForumName(), (VideoPbFragment) this.gYT, aeVar.bJk());
                videoPbVideoInfoViewHolder.lMg.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.lMg.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.lMg.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.a(this.mContext, postData);
        }
    }

    private boolean aK(bz bzVar) {
        return (bzVar == null || bzVar.btA() == null || bzVar.btA().getOptions() == null || bzVar.btA().getOptions().size() <= 0) ? false : true;
    }

    private boolean x(PostData postData) {
        return postData != null && x.getCount(postData.nss) >= 2;
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (this.lKe != null) {
            this.mhl = this.lKe.lFU;
            if (this.lKe.dmF() != null) {
                this.mhn = this.lKe.dmF().brn() == 1;
                this.mhm = this.lKe.dmF().brm() == 1;
            }
            videoPbVideoInfoViewHolder.l(this.mhl, this.mhn, this.mhm);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lKe != null && metaData != null && postData != null) {
            videoPbVideoInfoViewHolder.miO.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.miO.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.miO.getHeadView().setTid(postData.getId());
            videoPbVideoInfoViewHolder.miO.getHeadView().setFid(this.lKe != null ? this.lKe.getForumId() : "");
            videoPbVideoInfoViewHolder.miO.getHeadView().setFName(this.lKe != null ? this.lKe.getForumName() : "");
            videoPbVideoInfoViewHolder.miO.a(metaData, 4);
            videoPbVideoInfoViewHolder.miO.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.tq(true);
                videoPbVideoInfoViewHolder.miO.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.miO.getHeadView().setAlaInfo(postData.brr().getAlaInfo());
                k(postData);
                return;
            }
            videoPbVideoInfoViewHolder.tq(false);
            videoPbVideoInfoViewHolder.miO.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.miO.getHeadView().setAlaInfo(null);
        }
    }

    private void a(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.mho = true;
                videoPbVideoInfoViewHolder.miP.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eLt.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.mho = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.eLt.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            videoPbVideoInfoViewHolder.miP.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (metaData != null) {
            videoPbVideoInfoViewHolder.eLt.setText(metaData.getName_show());
            videoPbVideoInfoViewHolder.eLt.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.eLt.setTag(R.id.tag_user_name, metaData.getName_show());
            this.mhp = metaData.isBigV();
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        if (this.lKe != null && this.lKe.dmF() != null) {
            this.lYb = 0;
            if (!this.lKe.dmF().bsR()) {
                if (postData != null && postData.brr() != null) {
                    this.lYb = postData.brr().getLevel_id();
                }
                if (!this.lKe.dni()) {
                    videoPbVideoInfoViewHolder.jua.setVisibility(0);
                    videoPbVideoInfoViewHolder.AQ(this.lYb);
                    return;
                }
                videoPbVideoInfoViewHolder.jua.setVisibility(8);
                return;
            }
            videoPbVideoInfoViewHolder.jua.setVisibility(8);
        }
    }

    private void c(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lKe != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.miQ.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.miQ.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void d(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        if (this.lKe != null && metaData != null) {
            videoPbVideoInfoViewHolder.miR.setText(at.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.miR.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            videoPbVideoInfoViewHolder.jub.setText(metaData.getNewGodData().getFieldName() + ag.lB(metaData.getNewGodData().isVideoGod()));
            videoPbVideoInfoViewHolder.jub.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            videoPbVideoInfoViewHolder.jub.setText(at.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            videoPbVideoInfoViewHolder.jub.setVisibility(0);
        } else if (metaData != null && metaData.getBaijiahaoInfo() != null && !at.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.miR.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.jub.setText(metaData.getBaijiahaoInfo().auth_desc);
            videoPbVideoInfoViewHolder.jub.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.miR.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            videoPbVideoInfoViewHolder.jub.setVisibility(8);
        }
    }

    private void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        if (this.lKe != null && postData != null && postData.brr() != null) {
            String threadId = this.lKe != null ? this.lKe.getThreadId() : "";
            int r = r(this.lKe);
            if (this.lXV == null) {
                this.lXV = new an(this.gYT.getPageContext(), videoPbVideoInfoViewHolder.miS, 4);
                this.lXV.l(this.gYT.getUniqueId());
            }
            postData.brr().setIsLike(postData.brr().hadConcerned());
            this.lXV.a(postData.brr());
            this.lXV.setTid(threadId);
            this.lXV.setThreadData(this.lKe.dmF());
            this.lXV.lUj = true;
            this.lXV.Hn(r);
            if (at.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoPbVideoInfoViewHolder.miS.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoPbVideoInfoViewHolder.miS.setVisibility(8);
            }
            if (this.lKe.lFT) {
                videoPbVideoInfoViewHolder.miS.setVisibility(8);
            }
        }
    }

    public void b(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        if (videoPbVideoInfoViewHolder != null) {
            videoPbVideoInfoViewHolder.AQ(this.lYb);
            videoPbVideoInfoViewHolder.wl(this.mho || this.mhp);
            videoPbVideoInfoViewHolder.l(this.mhl, this.mhn, this.mhm);
            videoPbVideoInfoViewHolder.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.dmF() == null) {
            return 0;
        }
        if (fVar.dmF().bsR()) {
            return (x.isEmpty(fVar.dnc()) && (fVar.dmE() == null || StringUtils.isNull(fVar.dmE().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
