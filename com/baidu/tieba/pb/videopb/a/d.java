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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
    private CustomMessageListener eVA;
    private BaseFragment fNd;
    private boolean kHt;
    private String kHu;
    private boolean kHv;
    private boolean kHw;
    private boolean kHx;
    private boolean kHy;
    private boolean kHz;
    private f klg;
    private int kyE;
    private ax kyz;
    private View.OnClickListener mOnClickListener;

    public d(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (d.this.Uj != null) {
                        int cUw = ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).cUw();
                        if (cUw == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).Cz(2);
                        } else if (cUw == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).Cz(1);
                        }
                        if (d.this.klg.cLa()) {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).kJe.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).kJe.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bf.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bd.baV().b(d.this.fNd.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(d.this.fNd.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new ap(CommonStatisticKey.USER_ICON_VISIT).ah("obj_type", 2));
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
                            bd.baV().b(d.this.fNd.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(d.this.fNd.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        ap apVar = new ap("c13715");
                        apVar.dn("fid", fid);
                        apVar.dn("fname", fName);
                        apVar.t("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
                        apVar.dn("tid", tid);
                        apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(apVar);
                        return;
                    }
                    TiebaStatic.log(new ap("c11923").ah("obj_id", 2));
                    ap apVar2 = new ap("c13267");
                    apVar2.dn("uid", TbadkCoreApplication.getCurrentAccount());
                    apVar2.dn("fid", fid);
                    apVar2.dn("tid", tid);
                    apVar2.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(apVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new ap("c11923").ah("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (d.this.klg != null && d.this.klg.getForum() != null) {
                        str = d.this.klg.getForum().getName();
                    }
                    ap apVar3 = new ap("c13267");
                    apVar3.dn("uid", str3);
                    if (d.this.klg != null) {
                        apVar3.dn("fid", d.this.klg.getForumId());
                        apVar3.dn("tid", d.this.klg.getThreadId());
                    }
                    apVar3.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(apVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(d.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.eVA = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.Uj != null && ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).hLE != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) d.this.Uj).hLE.setTextSize(0, TbConfig.getContentSize());
                    d.this.notifyDataSetChanged();
                }
            }
        };
        this.fNd = baseFragment;
        this.fNd.registerListener(this.eVA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cx */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Uj = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.klg != null && this.klg.cKx() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.fNd.getUniqueId(), this.klg, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.aWl() != null) {
            String userId = postData.aWl().getUserId();
            String forumId = this.klg != null ? this.klg.getForumId() : "";
            String forumName = this.klg != null ? this.klg.getForumName() : "";
            int dlh = postData.dlh();
            String id = postData.getId();
            ap apVar = new ap("c13714");
            apVar.dn("fid", forumId);
            apVar.dn("fname", forumName);
            apVar.dn("obj_param1", userId);
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            apVar.dn("tid", id);
            apVar.ah(TiebaInitialize.Params.OBJ_PARAM2, dlh);
            TiebaStatic.log(apVar);
        }
    }

    public void setPbData(f fVar) {
        this.klg = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.klg != null && this.klg.cKx() != null && this.klg.cKx().aWl() != null && postData != null) {
            a(bVar, this.klg.cKx().aWl(), postData);
            a(bVar, this.klg.cKx().aWl());
            b(bVar, this.klg.cKx().aWl());
            c(bVar, this.klg.cKx().aWl());
            c(bVar, postData);
            d(bVar, this.klg.cKx().aWl());
            e(bVar, this.klg.cKx().aWl());
            b(bVar, this.klg.cKx().aWl(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.klg != null && this.klg.cKx() != null && postData != null) {
            bVar.s(this.klg.cKx().getTitle());
            if (this.klg.cKx().aWD() != null) {
                bVar.eRx.setText(as.numberUniformFormatExtra(this.klg.cKx().aWD().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = as.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = as.getFormatTime(postData.getTime());
            }
            bVar.kJd.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f dlk = postData.dlk();
            if (dlk != null && !TextUtils.isEmpty(dlk.getName()) && !TextUtils.isEmpty(dlk.getName().trim())) {
                bVar.kJe.setText(dlk.getName());
                bVar.kJe.setVisibility(0);
                return;
            }
            bVar.kJe.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.klg != null) {
            this.kHv = this.klg.khq;
            if (this.klg.cKx() != null) {
                this.kHx = this.klg.cKx().aWh() == 1;
                this.kHw = this.klg.cKx().aWg() == 1;
            }
            bVar.i(this.kHv, this.kHx, this.kHw);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.klg != null && metaData != null && postData != null) {
            bVar.kIS.getHeadView().setUserId(metaData.getUserId());
            bVar.kIS.getHeadView().setUserName(metaData.getUserName());
            bVar.kIS.getHeadView().setTid(postData.getId());
            bVar.kIS.getHeadView().setFid(this.klg != null ? this.klg.getForumId() : "");
            bVar.kIS.getHeadView().setFName(this.klg != null ? this.klg.getForumName() : "");
            bVar.kIS.a(metaData, 4);
            bVar.kIS.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.qN(true);
                bVar.kIS.getHeadView().setLiveStatus(1);
                bVar.kIS.getHeadView().setAlaInfo(postData.aWl().getAlaInfo());
                k(postData);
                return;
            }
            bVar.qN(false);
            bVar.kIS.getHeadView().setLiveStatus(0);
            bVar.kIS.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.kHy = true;
                bVar.kIT.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.dKI.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.kHy = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.dKI.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.kIT.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.dKI.setText(metaData.getName_show());
            bVar.dKI.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.dKI.setTag(R.id.tag_user_name, metaData.getName_show());
            this.kHz = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.klg != null && metaData != null) {
            this.kHt = metaData.getIs_bawu() == 1;
            this.kHu = metaData.getBawu_type();
            if (this.klg.cLa()) {
                bVar.kIU.setVisibility(8);
            } else if (this.kHt && Config.BAWU_TYPE_MANAGER.equals(this.kHu)) {
                bVar.kIU.setText(R.string.bawu_member_bazhu_tip);
                bVar.kIU.setVisibility(0);
                bVar.Ll(this.kHu);
            } else if (this.kHt && Config.BAWU_TYPE_ASSIST.equals(this.kHu)) {
                bVar.kIU.setText(R.string.bawu_member_xbazhu_tip);
                bVar.kIU.setVisibility(0);
                bVar.Ll(this.kHu);
            } else {
                bVar.kIU.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.klg != null && this.klg.cKx() != null) {
            this.kyE = 0;
            if (!this.klg.cKx().aXI()) {
                if (postData != null && postData.aWl() != null) {
                    this.kyE = postData.aWl().getLevel_id();
                }
                if (!this.klg.cLa()) {
                    bVar.kIV.setVisibility(0);
                    bVar.Cy(this.kyE);
                    return;
                }
                bVar.kIV.setVisibility(8);
                return;
            }
            bVar.kIV.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.klg != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.kIW.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.kIW.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.klg != null && metaData != null) {
            bVar.kIY.setText(as.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !as.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.kIY.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.kIX.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.kIX.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.kIX.setText(as.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.kIX.setVisibility(0);
        } else if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.kIY.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.kIX.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.kIX.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.kIY.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.kIX.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.klg != null && postData != null && postData.aWl() != null) {
            String threadId = this.klg != null ? this.klg.getThreadId() : "";
            int r = r(this.klg);
            if (this.kyz == null) {
                this.kyz = new ax(this.fNd.getPageContext(), bVar.kIZ, 4);
                this.kyz.m(this.fNd.getUniqueId());
            }
            postData.aWl().setIsLike(postData.aWl().hadConcerned());
            this.kyz.a(postData.aWl());
            this.kyz.setTid(threadId);
            this.kyz.setThreadData(this.klg.cKx());
            this.kyz.kuQ = true;
            this.kyz.BZ(r);
            if (as.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.kIZ.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.kIZ.setVisibility(8);
            }
            if (this.klg.khp) {
                bVar.kIZ.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.kHt) {
                bVar.Ll(this.kHu);
            }
            bVar.Cy(this.kyE);
            bVar.tD(this.kHy || this.kHz);
            bVar.i(this.kHv, this.kHx, this.kHw);
            bVar.onChangeSkinType();
        }
    }

    private int r(f fVar) {
        if (fVar == null || fVar.cKx() == null) {
            return 0;
        }
        if (fVar.cKx().aXI()) {
            return (x.isEmpty(fVar.cKU()) && (fVar.cKw() == null || StringUtils.isNull(fVar.cKw().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
