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
    private CustomMessageListener dPE;
    private BaseFragment eDx;
    private e iFb;
    private al iRg;
    private int iRl;
    private boolean iZN;
    private String iZO;
    private boolean iZP;
    private boolean iZQ;
    private boolean iZR;
    private boolean iZS;
    private boolean iZT;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.Ai != null) {
                        int cuc = ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).cuc();
                        if (cuc == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zB(2);
                        } else if (cuc == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zB(1);
                        }
                        if (c.this.iFb.ckS()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jbv.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jbv.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aGG().b(c.this.eDx.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.eDx.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                    if (c.this.iFb != null && c.this.iFb.getForum() != null) {
                        str = c.this.iFb.getForum().getName();
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
                    if (c.this.iFb != null && c.this.iFb.getForum() != null) {
                        str = c.this.iFb.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cy("uid", str3);
                    if (c.this.iFb != null) {
                        anVar2.cy("fid", c.this.iFb.getForumId());
                        anVar2.cy("tid", c.this.iFb.getThreadId());
                    }
                    anVar2.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.dPE = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Ai != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).gtM != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).gtM.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.eDx = baseFragment;
        this.eDx.registerListener(this.dPE);
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
        if (this.iFb != null && this.iFb.cku() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.eDx.getUniqueId(), this.iFb, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(e eVar) {
        this.iFb = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iFb != null && this.iFb.cku() != null && this.iFb.cku().aCo() != null && postData != null) {
            a(bVar, this.iFb.cku().aCo(), postData);
            a(bVar, this.iFb.cku().aCo());
            b(bVar, this.iFb.cku().aCo());
            c(bVar, this.iFb.cku().aCo());
            c(bVar, postData);
            d(bVar, this.iFb.cku().aCo());
            e(bVar, this.iFb.cku().aCo());
            b(bVar, this.iFb.cku().aCo(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.iFb != null && this.iFb.cku() != null && postData != null) {
            bVar.m(this.iFb.cku().getTitle());
            if (this.iFb.cku().aCF() != null) {
                bVar.dMd.setText(aq.numberUniformFormatExtra(this.iFb.cku().aCF().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.jbu.setText(formatTime + this.mContext.getString(R.string.send_post));
            f cLd = postData.cLd();
            if (cLd != null && !TextUtils.isEmpty(cLd.getName()) && !TextUtils.isEmpty(cLd.getName().trim())) {
                bVar.jbv.setText(cLd.getName());
                bVar.jbv.setVisibility(0);
                return;
            }
            bVar.jbv.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iFb != null) {
            this.iZP = this.iFb.iBH;
            if (this.iFb.cku() != null) {
                this.iZR = this.iFb.cku().aCk() == 1;
                this.iZQ = this.iFb.cku().aCj() == 1;
            }
            bVar.i(this.iZP, this.iZR, this.iZQ);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iFb != null && metaData != null && postData != null) {
            bVar.jbj.getHeadView().setUserId(metaData.getUserId());
            bVar.jbj.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.jbj.getHeadView().setTid(postData.getId());
            }
            bVar.jbj.getHeadView().setFid(this.iFb != null ? this.iFb.getForumId() : "");
            bVar.jbj.a(metaData, 0);
            bVar.jbj.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.iZS = true;
                bVar.jbk.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.cbK.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.iZS = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.cbK.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.jbk.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.cbK.setText(metaData.getName_show());
            bVar.cbK.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.cbK.setTag(R.id.tag_user_name, metaData.getName_show());
            this.iZT = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iFb != null && metaData != null) {
            this.iZN = metaData.getIs_bawu() == 1;
            this.iZO = metaData.getBawu_type();
            if (this.iFb.ckS()) {
                bVar.jbl.setVisibility(8);
            } else if (this.iZN && Config.BAWU_TYPE_MANAGER.equals(this.iZO)) {
                bVar.jbl.setText(R.string.bawu_member_bazhu_tip);
                bVar.jbl.setVisibility(0);
                bVar.Gx(this.iZO);
            } else if (this.iZN && Config.BAWU_TYPE_ASSIST.equals(this.iZO)) {
                bVar.jbl.setText(R.string.bawu_member_xbazhu_tip);
                bVar.jbl.setVisibility(0);
                bVar.Gx(this.iZO);
            } else {
                bVar.jbl.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iFb != null && this.iFb.cku() != null) {
            this.iRl = 0;
            if (!this.iFb.cku().aDG()) {
                if (postData != null && postData.aCo() != null) {
                    this.iRl = postData.aCo().getLevel_id();
                }
                if (!this.iFb.ckS()) {
                    bVar.jbm.setVisibility(0);
                    bVar.zA(this.iRl);
                    return;
                }
                bVar.jbm.setVisibility(8);
                return;
            }
            bVar.jbm.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iFb != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.jbn.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.jbn.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iFb != null && metaData != null) {
            bVar.jbp.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.jbp.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jbo.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jbo.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.jbp.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.jbo.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iFb != null && postData != null && postData.aCo() != null) {
            String threadId = this.iFb != null ? this.iFb.getThreadId() : "";
            int A = A(this.iFb);
            if (this.iRg == null) {
                this.iRg = new al(this.eDx.getPageContext(), bVar.jbq, 4);
                this.iRg.j(this.eDx.getUniqueId());
                this.iRg.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.a.c.2
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fV(boolean z) {
                        if (c.this.eDx != null && z) {
                            l.showToast(c.this.eDx.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            postData.aCo().setIsLike(postData.aCo().hadConcerned());
            this.iRg.a(postData.aCo());
            this.iRg.setTid(threadId);
            this.iRg.iNE = true;
            this.iRg.zc(A);
            if (3 != this.iFb.ckV()) {
                bVar.jbq.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.jbq.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCo().hadConcerned()) {
                bVar.jbq.setVisibility(8);
            }
            if (this.iFb.iBG || 3 == this.iFb.ckV()) {
                bVar.jbq.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.iZN) {
                bVar.Gx(this.iZO);
            }
            bVar.zA(this.iRl);
            bVar.rb(this.iZS || this.iZT);
            bVar.i(this.iZP, this.iZR, this.iZQ);
            bVar.onChangeSkinType();
        }
    }

    private int A(e eVar) {
        if (eVar == null || eVar.cku() == null) {
            return 0;
        }
        if (eVar.cku().aDG()) {
            return (v.isEmpty(eVar.ckN()) && (eVar.ckt() == null || StringUtils.isNull(eVar.ckt().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
