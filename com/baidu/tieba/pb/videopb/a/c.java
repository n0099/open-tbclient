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
    private CustomMessageListener dPR;
    private BaseFragment eDK;
    private e iFn;
    private al iRs;
    private int iRx;
    private boolean iZZ;
    private String jaa;
    private boolean jab;
    private boolean jac;
    private boolean jad;
    private boolean jae;
    private boolean jaf;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.Ai != null) {
                        int cud = ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).cud();
                        if (cud == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zB(2);
                        } else if (cud == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zB(1);
                        }
                        if (c.this.iFn.ckT()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jbH.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jbH.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aGG().b(c.this.eDK.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.eDK.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                    if (c.this.iFn != null && c.this.iFn.getForum() != null) {
                        str = c.this.iFn.getForum().getName();
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
                    if (c.this.iFn != null && c.this.iFn.getForum() != null) {
                        str = c.this.iFn.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cy("uid", str3);
                    if (c.this.iFn != null) {
                        anVar2.cy("fid", c.this.iFn.getForumId());
                        anVar2.cy("tid", c.this.iFn.getThreadId());
                    }
                    anVar2.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.dPR = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Ai != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).gtY != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).gtY.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.eDK = baseFragment;
        this.eDK.registerListener(this.dPR);
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
        if (this.iFn != null && this.iFn.ckv() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.eDK.getUniqueId(), this.iFn, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(e eVar) {
        this.iFn = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iFn != null && this.iFn.ckv() != null && this.iFn.ckv().aCo() != null && postData != null) {
            a(bVar, this.iFn.ckv().aCo(), postData);
            a(bVar, this.iFn.ckv().aCo());
            b(bVar, this.iFn.ckv().aCo());
            c(bVar, this.iFn.ckv().aCo());
            c(bVar, postData);
            d(bVar, this.iFn.ckv().aCo());
            e(bVar, this.iFn.ckv().aCo());
            b(bVar, this.iFn.ckv().aCo(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.iFn != null && this.iFn.ckv() != null && postData != null) {
            bVar.m(this.iFn.ckv().getTitle());
            if (this.iFn.ckv().aCF() != null) {
                bVar.dMq.setText(aq.numberUniformFormatExtra(this.iFn.ckv().aCF().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.jbG.setText(formatTime + this.mContext.getString(R.string.send_post));
            f cLe = postData.cLe();
            if (cLe != null && !TextUtils.isEmpty(cLe.getName()) && !TextUtils.isEmpty(cLe.getName().trim())) {
                bVar.jbH.setText(cLe.getName());
                bVar.jbH.setVisibility(0);
                return;
            }
            bVar.jbH.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iFn != null) {
            this.jab = this.iFn.iBT;
            if (this.iFn.ckv() != null) {
                this.jad = this.iFn.ckv().aCk() == 1;
                this.jac = this.iFn.ckv().aCj() == 1;
            }
            bVar.i(this.jab, this.jad, this.jac);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iFn != null && metaData != null && postData != null) {
            bVar.jbv.getHeadView().setUserId(metaData.getUserId());
            bVar.jbv.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.jbv.getHeadView().setTid(postData.getId());
            }
            bVar.jbv.getHeadView().setFid(this.iFn != null ? this.iFn.getForumId() : "");
            bVar.jbv.a(metaData, 0);
            bVar.jbv.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.jae = true;
                bVar.jbw.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.cbL.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.jae = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.cbL.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.jbw.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.cbL.setText(metaData.getName_show());
            bVar.cbL.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.cbL.setTag(R.id.tag_user_name, metaData.getName_show());
            this.jaf = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iFn != null && metaData != null) {
            this.iZZ = metaData.getIs_bawu() == 1;
            this.jaa = metaData.getBawu_type();
            if (this.iFn.ckT()) {
                bVar.jbx.setVisibility(8);
            } else if (this.iZZ && Config.BAWU_TYPE_MANAGER.equals(this.jaa)) {
                bVar.jbx.setText(R.string.bawu_member_bazhu_tip);
                bVar.jbx.setVisibility(0);
                bVar.Gy(this.jaa);
            } else if (this.iZZ && Config.BAWU_TYPE_ASSIST.equals(this.jaa)) {
                bVar.jbx.setText(R.string.bawu_member_xbazhu_tip);
                bVar.jbx.setVisibility(0);
                bVar.Gy(this.jaa);
            } else {
                bVar.jbx.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iFn != null && this.iFn.ckv() != null) {
            this.iRx = 0;
            if (!this.iFn.ckv().aDG()) {
                if (postData != null && postData.aCo() != null) {
                    this.iRx = postData.aCo().getLevel_id();
                }
                if (!this.iFn.ckT()) {
                    bVar.jby.setVisibility(0);
                    bVar.zA(this.iRx);
                    return;
                }
                bVar.jby.setVisibility(8);
                return;
            }
            bVar.jby.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iFn != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.jbz.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.jbz.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iFn != null && metaData != null) {
            bVar.jbB.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.jbB.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jbA.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jbA.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.jbB.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.jbA.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iFn != null && postData != null && postData.aCo() != null) {
            String threadId = this.iFn != null ? this.iFn.getThreadId() : "";
            int A = A(this.iFn);
            if (this.iRs == null) {
                this.iRs = new al(this.eDK.getPageContext(), bVar.jbC, 4);
                this.iRs.j(this.eDK.getUniqueId());
                this.iRs.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.a.c.2
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fV(boolean z) {
                        if (c.this.eDK != null && z) {
                            l.showToast(c.this.eDK.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            postData.aCo().setIsLike(postData.aCo().hadConcerned());
            this.iRs.a(postData.aCo());
            this.iRs.setTid(threadId);
            this.iRs.iNQ = true;
            this.iRs.zc(A);
            if (3 != this.iFn.ckW()) {
                bVar.jbC.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.jbC.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCo().hadConcerned()) {
                bVar.jbC.setVisibility(8);
            }
            if (this.iFn.iBS || 3 == this.iFn.ckW()) {
                bVar.jbC.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.iZZ) {
                bVar.Gy(this.jaa);
            }
            bVar.zA(this.iRx);
            bVar.rb(this.jae || this.jaf);
            bVar.i(this.jab, this.jad, this.jac);
            bVar.onChangeSkinType();
        }
    }

    private int A(e eVar) {
        if (eVar == null || eVar.ckv() == null) {
            return 0;
        }
        if (eVar.ckv().aDG()) {
            return (v.isEmpty(eVar.ckO()) && (eVar.cku() == null || StringUtils.isNull(eVar.cku().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
