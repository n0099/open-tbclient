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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
    private CustomMessageListener ePf;
    private BaseFragment fHI;
    private e kcE;
    private at kpB;
    private int kpG;
    private boolean kyt;
    private String kyu;
    private boolean kyv;
    private boolean kyw;
    private boolean kyx;
    private boolean kyy;
    private boolean kyz;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.Up != null) {
                        int cQF = ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).cQF();
                        if (cQF == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).BZ(2);
                        } else if (cQF == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).BZ(1);
                        }
                        if (c.this.kcE.cHp()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).kAc.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).kAc.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (be.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            bc.aWU().b(c.this.fHI.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.fHI.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new ao(CommonStatisticKey.USER_ICON_VISIT).ag("obj_type", 2));
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
                            bc.aWU().b(c.this.fHI.getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + alaInfo.thirdRoomId + "&livetype=" + alaInfo.thirdLiveType});
                        } else if (alaInfo.live_id > 0) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = alaInfo.live_id;
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(c.this.fHI.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_REPLY_PORTRAIT, null, false, "")));
                        }
                        ao aoVar = new ao("c13715");
                        aoVar.dk("fid", fid);
                        aoVar.dk("fname", fName);
                        aoVar.s("obj_param1", alaInfo.user_info != null ? alaInfo.user_info.user_id : 0L);
                        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
                        aoVar.dk("tid", tid);
                        aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, floor);
                        TiebaStatic.log(aoVar);
                        return;
                    }
                    TiebaStatic.log(new ao("c11923").ag("obj_id", 2));
                    ao aoVar2 = new ao("c13267");
                    aoVar2.dk("uid", TbadkCoreApplication.getCurrentAccount());
                    aoVar2.dk("fid", fid);
                    aoVar2.dk("tid", tid);
                    aoVar2.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aoVar2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new ao("c11923").ag("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (c.this.kcE != null && c.this.kcE.getForum() != null) {
                        str = c.this.kcE.getForum().getName();
                    }
                    ao aoVar3 = new ao("c13267");
                    aoVar3.dk("uid", str3);
                    if (c.this.kcE != null) {
                        aoVar3.dk("fid", c.this.kcE.getForumId());
                        aoVar3.dk("tid", c.this.kcE.getThreadId());
                    }
                    aoVar3.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(aoVar3);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.ePf = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Up != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).hFI != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.Up).hFI.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.fHI = baseFragment;
        this.fHI.registerListener(this.ePf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cu */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Up = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kcE != null && this.kcE.cGN() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.fHI.getUniqueId(), this.kcE, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    private void k(PostData postData) {
        if (postData != null && postData.aSp() != null) {
            String userId = postData.aSp().getUserId();
            String forumId = this.kcE != null ? this.kcE.getForumId() : "";
            String forumName = this.kcE != null ? this.kcE.getForumName() : "";
            int dhY = postData.dhY();
            String id = postData.getId();
            ao aoVar = new ao("c13714");
            aoVar.dk("fid", forumId);
            aoVar.dk("fname", forumName);
            aoVar.dk("obj_param1", userId);
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            aoVar.dk("tid", id);
            aoVar.ag(TiebaInitialize.Params.OBJ_PARAM2, dhY);
            TiebaStatic.log(aoVar);
        }
    }

    public void setPbData(e eVar) {
        this.kcE = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kcE != null && this.kcE.cGN() != null && this.kcE.cGN().aSp() != null && postData != null) {
            a(bVar, this.kcE.cGN().aSp(), postData);
            a(bVar, this.kcE.cGN().aSp());
            b(bVar, this.kcE.cGN().aSp());
            c(bVar, this.kcE.cGN().aSp());
            c(bVar, postData);
            d(bVar, this.kcE.cGN().aSp());
            e(bVar, this.kcE.cGN().aSp());
            b(bVar, this.kcE.cGN().aSp(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.kcE != null && this.kcE.cGN() != null && postData != null) {
            bVar.s(this.kcE.cGN().getTitle());
            if (this.kcE.cGN().aSH() != null) {
                bVar.eLb.setText(ar.numberUniformFormatExtra(this.kcE.cGN().aSH().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = ar.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = ar.getFormatTime(postData.getTime());
            }
            bVar.kAb.setText(formatTime + this.mContext.getString(R.string.send_post));
            f dib = postData.dib();
            if (dib != null && !TextUtils.isEmpty(dib.getName()) && !TextUtils.isEmpty(dib.getName().trim())) {
                bVar.kAc.setText(dib.getName());
                bVar.kAc.setVisibility(0);
                return;
            }
            bVar.kAc.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.kcE != null) {
            this.kyv = this.kcE.jYP;
            if (this.kcE.cGN() != null) {
                this.kyx = this.kcE.cGN().aSl() == 1;
                this.kyw = this.kcE.cGN().aSk() == 1;
            }
            bVar.i(this.kyv, this.kyx, this.kyw);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kcE != null && metaData != null && postData != null) {
            bVar.kzQ.getHeadView().setUserId(metaData.getUserId());
            bVar.kzQ.getHeadView().setUserName(metaData.getUserName());
            bVar.kzQ.getHeadView().setTid(postData.getId());
            bVar.kzQ.getHeadView().setFid(this.kcE != null ? this.kcE.getForumId() : "");
            bVar.kzQ.getHeadView().setFName(this.kcE != null ? this.kcE.getForumName() : "");
            bVar.kzQ.a(metaData, 4);
            bVar.kzQ.a(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                bVar.qg(true);
                bVar.kzQ.getHeadView().setLiveStatus(1);
                bVar.kzQ.getHeadView().setAlaInfo(postData.aSp().getAlaInfo());
                k(postData);
                return;
            }
            bVar.qg(false);
            bVar.kzQ.getHeadView().setLiveStatus(0);
            bVar.kzQ.getHeadView().setAlaInfo(null);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.kyy = true;
                bVar.kzR.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.dEL.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.kyy = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.dEL.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.kzR.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.dEL.setText(metaData.getName_show());
            bVar.dEL.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.dEL.setTag(R.id.tag_user_name, metaData.getName_show());
            this.kyz = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kcE != null && metaData != null) {
            this.kyt = metaData.getIs_bawu() == 1;
            this.kyu = metaData.getBawu_type();
            if (this.kcE.cHp()) {
                bVar.kzS.setVisibility(8);
            } else if (this.kyt && Config.BAWU_TYPE_MANAGER.equals(this.kyu)) {
                bVar.kzS.setText(R.string.bawu_member_bazhu_tip);
                bVar.kzS.setVisibility(0);
                bVar.Kx(this.kyu);
            } else if (this.kyt && Config.BAWU_TYPE_ASSIST.equals(this.kyu)) {
                bVar.kzS.setText(R.string.bawu_member_xbazhu_tip);
                bVar.kzS.setVisibility(0);
                bVar.Kx(this.kyu);
            } else {
                bVar.kzS.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.kcE != null && this.kcE.cGN() != null) {
            this.kpG = 0;
            if (!this.kcE.cGN().aTM()) {
                if (postData != null && postData.aSp() != null) {
                    this.kpG = postData.aSp().getLevel_id();
                }
                if (!this.kcE.cHp()) {
                    bVar.kzT.setVisibility(0);
                    bVar.BY(this.kpG);
                    return;
                }
                bVar.kzT.setVisibility(8);
                return;
            }
            bVar.kzT.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kcE != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.kzU.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.kzU.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.kcE != null && metaData != null) {
            bVar.kzW.setText(ar.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !ar.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.kzW.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.kzV.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.kzV.setVisibility(0);
        } else if (metaData != null && metaData.showBazhuGrade()) {
            bVar.kzV.setText(ar.cutChineseAndEnglishWithSuffix(metaData.getBazhuGradeData().getDesc(), 24, StringHelper.STRING_MORE));
            bVar.kzV.setVisibility(0);
        } else if (metaData != null && metaData.isNewGod()) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.kzW.getLayoutParams();
            layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            bVar.kzV.setText(metaData.getNewGodData().getFieldName() + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god));
            bVar.kzV.setVisibility(0);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) bVar.kzW.getLayoutParams();
            layoutParams3.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams3.topMargin, layoutParams3.rightMargin, layoutParams3.bottomMargin);
            bVar.kzV.setVisibility(8);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.kcE != null && postData != null && postData.aSp() != null) {
            String threadId = this.kcE != null ? this.kcE.getThreadId() : "";
            int r = r(this.kcE);
            if (this.kpB == null) {
                this.kpB = new at(this.fHI.getPageContext(), bVar.kzX, 4);
                this.kpB.l(this.fHI.getUniqueId());
            }
            postData.aSp().setIsLike(postData.aSp().hadConcerned());
            this.kpB.a(postData.aSp());
            this.kpB.setTid(threadId);
            this.kpB.setThreadData(this.kcE.cGN());
            this.kpB.klT = true;
            this.kpB.BA(r);
            if (ar.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.kzX.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                bVar.kzX.setVisibility(8);
            }
            if (this.kcE.jYO) {
                bVar.kzX.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.kyt) {
                bVar.Kx(this.kyu);
            }
            bVar.BY(this.kpG);
            bVar.sX(this.kyy || this.kyz);
            bVar.i(this.kyv, this.kyx, this.kyw);
            bVar.onChangeSkinType();
        }
    }

    private int r(e eVar) {
        if (eVar == null || eVar.cGN() == null) {
            return 0;
        }
        if (eVar.cGN().aTM()) {
            return (w.isEmpty(eVar.cHj()) && (eVar.cGM() == null || StringUtils.isNull(eVar.cGM().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
