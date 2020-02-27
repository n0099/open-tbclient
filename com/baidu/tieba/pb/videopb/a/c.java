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
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.d;
import com.baidu.tbadk.data.f;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.al;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private CustomMessageListener dPD;
    private BaseFragment eDw;
    private e iEZ;
    private al iRe;
    private int iRj;
    private boolean iZL;
    private String iZM;
    private boolean iZN;
    private boolean iZO;
    private boolean iZP;
    private boolean iZQ;
    private boolean iZR;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.Ai != null) {
                        int cua = ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).cua();
                        if (cua == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zB(2);
                        } else if (cua == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zB(1);
                        }
                        if (c.this.iEZ.ckQ()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jbt.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jbt.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aGE().b(c.this.eDw.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.eDw.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).X("obj_type", 2));
                    }
                } else if (view.getId() == R.id.head_view_video_info_item) {
                    HeadImageView headView = ((HeadPendantClickableView) view).getHeadView();
                    TiebaStatic.log(new an("c11923").X("obj_id", 2));
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    if (c.this.iEZ != null && c.this.iEZ.getForum() != null) {
                        str = c.this.iEZ.getForum().getName();
                    }
                    an anVar = new an("c13267");
                    anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cy("fid", fid);
                    anVar.cy("tid", tid);
                    anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, userId, userName, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new an("c11923").X("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (c.this.iEZ != null && c.this.iEZ.getForum() != null) {
                        str = c.this.iEZ.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cy("uid", str3);
                    if (c.this.iEZ != null) {
                        anVar2.cy("fid", c.this.iEZ.getForumId());
                        anVar2.cy("tid", c.this.iEZ.getThreadId());
                    }
                    anVar2.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.dPD = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Ai != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).gtK != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).gtK.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.eDw = baseFragment;
        this.eDw.registerListener(this.dPD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Ai = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iEZ != null && this.iEZ.cks() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.eDw.getUniqueId(), this.iEZ, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(e eVar) {
        this.iEZ = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iEZ != null && this.iEZ.cks() != null && this.iEZ.cks().aCm() != null && postData != null) {
            a(bVar, this.iEZ.cks().aCm(), postData);
            a(bVar, this.iEZ.cks().aCm());
            b(bVar, this.iEZ.cks().aCm());
            c(bVar, this.iEZ.cks().aCm());
            c(bVar, postData);
            d(bVar, this.iEZ.cks().aCm());
            e(bVar, this.iEZ.cks().aCm());
            b(bVar, this.iEZ.cks().aCm(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.iEZ != null && this.iEZ.cks() != null && postData != null) {
            bVar.m(this.iEZ.cks().getTitle());
            if (this.iEZ.cks().aCD() != null) {
                bVar.dMc.setText(aq.numberUniformFormatExtra(this.iEZ.cks().aCD().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.jbs.setText(formatTime + this.mContext.getString(R.string.send_post));
            f cLb = postData.cLb();
            if (cLb != null && !TextUtils.isEmpty(cLb.getName()) && !TextUtils.isEmpty(cLb.getName().trim())) {
                bVar.jbt.setText(cLb.getName());
                bVar.jbt.setVisibility(0);
                return;
            }
            bVar.jbt.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iEZ != null) {
            this.iZN = this.iEZ.iBF;
            if (this.iEZ.cks() != null) {
                this.iZP = this.iEZ.cks().aCi() == 1;
                this.iZO = this.iEZ.cks().aCh() == 1;
            }
            bVar.i(this.iZN, this.iZP, this.iZO);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iEZ != null && metaData != null && postData != null) {
            bVar.jbh.getHeadView().setUserId(metaData.getUserId());
            bVar.jbh.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.jbh.getHeadView().setTid(postData.getId());
            }
            bVar.jbh.getHeadView().setFid(this.iEZ != null ? this.iEZ.getForumId() : "");
            bVar.jbh.a(metaData, 0);
            bVar.jbh.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.iZQ = true;
                bVar.jbi.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.cbJ.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.iZQ = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.cbJ.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.jbi.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.cbJ.setText(metaData.getName_show());
            bVar.cbJ.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.cbJ.setTag(R.id.tag_user_name, metaData.getName_show());
            this.iZR = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iEZ != null && metaData != null) {
            this.iZL = metaData.getIs_bawu() == 1;
            this.iZM = metaData.getBawu_type();
            if (this.iEZ.ckQ()) {
                bVar.jbj.setVisibility(8);
            } else if (this.iZL && Config.BAWU_TYPE_MANAGER.equals(this.iZM)) {
                bVar.jbj.setText(R.string.bawu_member_bazhu_tip);
                bVar.jbj.setVisibility(0);
                bVar.Gx(this.iZM);
            } else if (this.iZL && Config.BAWU_TYPE_ASSIST.equals(this.iZM)) {
                bVar.jbj.setText(R.string.bawu_member_xbazhu_tip);
                bVar.jbj.setVisibility(0);
                bVar.Gx(this.iZM);
            } else {
                bVar.jbj.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iEZ != null && this.iEZ.cks() != null) {
            this.iRj = 0;
            if (!this.iEZ.cks().aDE()) {
                if (postData != null && postData.aCm() != null) {
                    this.iRj = postData.aCm().getLevel_id();
                }
                if (!this.iEZ.ckQ()) {
                    bVar.jbk.setVisibility(0);
                    bVar.zA(this.iRj);
                    return;
                }
                bVar.jbk.setVisibility(8);
                return;
            }
            bVar.jbk.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iEZ != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.jbl.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.jbl.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iEZ != null && metaData != null) {
            bVar.jbn.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.jbn.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jbm.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jbm.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.jbn.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.jbm.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iEZ != null && postData != null && postData.aCm() != null) {
            String threadId = this.iEZ != null ? this.iEZ.getThreadId() : "";
            int A = A(this.iEZ);
            if (this.iRe == null) {
                this.iRe = new al(this.eDw.getPageContext(), bVar.jbo, 4);
                this.iRe.j(this.eDw.getUniqueId());
                this.iRe.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.a.c.2
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fV(boolean z) {
                        if (c.this.eDw != null && z) {
                            l.showToast(c.this.eDw.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            postData.aCm().setIsLike(postData.aCm().hadConcerned());
            this.iRe.a(postData.aCm());
            this.iRe.setTid(threadId);
            this.iRe.iNC = true;
            this.iRe.zc(A);
            if (3 != this.iEZ.ckT()) {
                bVar.jbo.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.jbo.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCm().hadConcerned()) {
                bVar.jbo.setVisibility(8);
            }
            if (this.iEZ.iBE || 3 == this.iEZ.ckT()) {
                bVar.jbo.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.iZL) {
                bVar.Gx(this.iZM);
            }
            bVar.zA(this.iRj);
            bVar.rb(this.iZQ || this.iZR);
            bVar.i(this.iZN, this.iZP, this.iZO);
            bVar.onChangeSkinType();
        }
    }

    private int A(e eVar) {
        if (eVar == null || eVar.cks() == null) {
            return 0;
        }
        if (eVar.cks().aDE()) {
            return (v.isEmpty(eVar.ckL()) && (eVar.ckr() == null || StringUtils.isNull(eVar.ckr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
