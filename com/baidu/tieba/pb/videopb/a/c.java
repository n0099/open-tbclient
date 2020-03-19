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
    private CustomMessageListener dQi;
    private BaseFragment eEg;
    private e iGO;
    private al iST;
    private int iSY;
    private String jbA;
    private boolean jbB;
    private boolean jbC;
    private boolean jbD;
    private boolean jbE;
    private boolean jbF;
    private boolean jbz;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.Ai != null) {
                        int cuw = ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).cuw();
                        if (cuw == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zJ(2);
                        } else if (cuw == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).zJ(1);
                        }
                        if (c.this.iGO.cln()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jdg.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).jdg.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aGK().b(c.this.eEg.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.eEg.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                    if (c.this.iGO != null && c.this.iGO.getForum() != null) {
                        str = c.this.iGO.getForum().getName();
                    }
                    an anVar = new an("c13267");
                    anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cx("fid", fid);
                    anVar.cx("tid", tid);
                    anVar.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, userId, userName, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new an("c11923").X("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (c.this.iGO != null && c.this.iGO.getForum() != null) {
                        str = c.this.iGO.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cx("uid", str3);
                    if (c.this.iGO != null) {
                        anVar2.cx("fid", c.this.iGO.getForumId());
                        anVar2.cx("tid", c.this.iGO.getThreadId());
                    }
                    anVar2.cx("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.dQi = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Ai != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).guC != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.Ai).guC.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.eEg = baseFragment;
        this.eEg.registerListener(this.dQi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
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
        if (this.iGO != null && this.iGO.ckP() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.eEg.getUniqueId(), this.iGO, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(e eVar) {
        this.iGO = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iGO != null && this.iGO.ckP() != null && this.iGO.ckP().aCr() != null && postData != null) {
            a(bVar, this.iGO.ckP().aCr(), postData);
            a(bVar, this.iGO.ckP().aCr());
            b(bVar, this.iGO.ckP().aCr());
            c(bVar, this.iGO.ckP().aCr());
            c(bVar, postData);
            d(bVar, this.iGO.ckP().aCr());
            e(bVar, this.iGO.ckP().aCr());
            b(bVar, this.iGO.ckP().aCr(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.iGO != null && this.iGO.ckP() != null && postData != null) {
            bVar.m(this.iGO.ckP().getTitle());
            if (this.iGO.ckP().aCI() != null) {
                bVar.dMG.setText(aq.numberUniformFormatExtra(this.iGO.ckP().aCI().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.jdf.setText(formatTime + this.mContext.getString(R.string.send_post));
            f cLy = postData.cLy();
            if (cLy != null && !TextUtils.isEmpty(cLy.getName()) && !TextUtils.isEmpty(cLy.getName().trim())) {
                bVar.jdg.setText(cLy.getName());
                bVar.jdg.setVisibility(0);
                return;
            }
            bVar.jdg.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iGO != null) {
            this.jbB = this.iGO.iDt;
            if (this.iGO.ckP() != null) {
                this.jbD = this.iGO.ckP().aCn() == 1;
                this.jbC = this.iGO.ckP().aCm() == 1;
            }
            bVar.i(this.jbB, this.jbD, this.jbC);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iGO != null && metaData != null && postData != null) {
            bVar.jcU.getHeadView().setUserId(metaData.getUserId());
            bVar.jcU.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.jcU.getHeadView().setTid(postData.getId());
            }
            bVar.jcU.getHeadView().setFid(this.iGO != null ? this.iGO.getForumId() : "");
            bVar.jcU.a(metaData, 0);
            bVar.jcU.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.jbE = true;
                bVar.jcV.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.cbW.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.jbE = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.cbW.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.jcV.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.cbW.setText(metaData.getName_show());
            bVar.cbW.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.cbW.setTag(R.id.tag_user_name, metaData.getName_show());
            this.jbF = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iGO != null && metaData != null) {
            this.jbz = metaData.getIs_bawu() == 1;
            this.jbA = metaData.getBawu_type();
            if (this.iGO.cln()) {
                bVar.jcW.setVisibility(8);
            } else if (this.jbz && Config.BAWU_TYPE_MANAGER.equals(this.jbA)) {
                bVar.jcW.setText(R.string.bawu_member_bazhu_tip);
                bVar.jcW.setVisibility(0);
                bVar.Gy(this.jbA);
            } else if (this.jbz && Config.BAWU_TYPE_ASSIST.equals(this.jbA)) {
                bVar.jcW.setText(R.string.bawu_member_xbazhu_tip);
                bVar.jcW.setVisibility(0);
                bVar.Gy(this.jbA);
            } else {
                bVar.jcW.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iGO != null && this.iGO.ckP() != null) {
            this.iSY = 0;
            if (!this.iGO.ckP().aDK()) {
                if (postData != null && postData.aCr() != null) {
                    this.iSY = postData.aCr().getLevel_id();
                }
                if (!this.iGO.cln()) {
                    bVar.jcX.setVisibility(0);
                    bVar.zI(this.iSY);
                    return;
                }
                bVar.jcX.setVisibility(8);
                return;
            }
            bVar.jcX.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iGO != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.jcY.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.jcY.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iGO != null && metaData != null) {
            bVar.jda.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.jda.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jcZ.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jcZ.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.jda.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.jcZ.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iGO != null && postData != null && postData.aCr() != null) {
            String threadId = this.iGO != null ? this.iGO.getThreadId() : "";
            int A = A(this.iGO);
            if (this.iST == null) {
                this.iST = new al(this.eEg.getPageContext(), bVar.jdb, 4);
                this.iST.j(this.eEg.getUniqueId());
                this.iST.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.a.c.2
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fW(boolean z) {
                        if (c.this.eEg != null && z) {
                            l.showToast(c.this.eEg.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            postData.aCr().setIsLike(postData.aCr().hadConcerned());
            this.iST.a(postData.aCr());
            this.iST.setTid(threadId);
            this.iST.iPr = true;
            this.iST.zk(A);
            if (3 != this.iGO.clq()) {
                bVar.jdb.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.jdb.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aCr().hadConcerned()) {
                bVar.jdb.setVisibility(8);
            }
            if (this.iGO.iDs || 3 == this.iGO.clq()) {
                bVar.jdb.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.jbz) {
                bVar.Gy(this.jbA);
            }
            bVar.zI(this.iSY);
            bVar.rh(this.jbE || this.jbF);
            bVar.i(this.jbB, this.jbD, this.jbC);
            bVar.onChangeSkinType();
        }
    }

    private int A(e eVar) {
        if (eVar == null || eVar.ckP() == null) {
            return 0;
        }
        if (eVar.ckP().aDK()) {
            return (v.isEmpty(eVar.cli()) && (eVar.ckO() == null || StringUtils.isNull(eVar.ckO().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
