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
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private CustomMessageListener dLw;
    private BaseFragment ezp;
    private f iDs;
    private ao iPJ;
    private int iPO;
    private boolean iYf;
    private String iYg;
    private boolean iYh;
    private boolean iYi;
    private boolean iYj;
    private boolean iYk;
    private boolean iYl;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.zP != null) {
                        int csD = ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).csD();
                        if (csD == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).zu(2);
                        } else if (csD == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).zu(1);
                        }
                        if (c.this.iDs.cjs()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).iZN.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).iZN.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aEt().b(c.this.ezp.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.ezp.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).Z("obj_type", 2));
                    }
                } else if (view.getId() == R.id.head_view_video_info_item) {
                    HeadImageView headView = ((HeadPendantClickableView) view).getHeadView();
                    TiebaStatic.log(new an("c11923").Z("obj_id", 2));
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    if (c.this.iDs != null && c.this.iDs.getForum() != null) {
                        str = c.this.iDs.getForum().getName();
                    }
                    an anVar = new an("c13267");
                    anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cp("fid", fid);
                    anVar.cp("tid", tid);
                    anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, userId, userName, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new an("c11923").Z("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (c.this.iDs != null && c.this.iDs.getForum() != null) {
                        str = c.this.iDs.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cp("uid", str3);
                    if (c.this.iDs != null) {
                        anVar2.cp("fid", c.this.iDs.getForumId());
                        anVar2.cp("tid", c.this.iDs.getThreadId());
                    }
                    anVar2.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.dLw = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.zP != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).grJ != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.zP).grJ.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.ezp = baseFragment;
        this.ezp.registerListener(this.dLw);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.zP = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iDs != null && this.iDs.ciS() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.ezp.getUniqueId(), this.iDs, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(f fVar) {
        this.iDs = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iDs != null && this.iDs.ciS() != null && this.iDs.ciS().azX() != null && postData != null) {
            a(bVar, this.iDs.ciS().azX(), postData);
            a(bVar, this.iDs.ciS().azX());
            b(bVar, this.iDs.ciS().azX());
            c(bVar, this.iDs.ciS().azX());
            c(bVar, postData);
            d(bVar, this.iDs.ciS().azX());
            e(bVar, this.iDs.ciS().azX());
            b(bVar, this.iDs.ciS().azX(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.iDs != null && this.iDs.ciS() != null && postData != null) {
            bVar.m(this.iDs.ciS().getTitle());
            if (this.iDs.ciS().aAo() != null) {
                bVar.dHX.setText(aq.numberUniformFormatExtra(this.iDs.ciS().aAo().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.iZM.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f cJA = postData.cJA();
            if (cJA != null && !TextUtils.isEmpty(cJA.getName()) && !TextUtils.isEmpty(cJA.getName().trim())) {
                bVar.iZN.setText(cJA.getName());
                bVar.iZN.setVisibility(0);
                return;
            }
            bVar.iZN.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.iDs != null) {
            this.iYh = this.iDs.izN;
            if (this.iDs.ciS() != null) {
                this.iYj = this.iDs.ciS().azT() == 1;
                this.iYi = this.iDs.ciS().azS() == 1;
            }
            bVar.i(this.iYh, this.iYj, this.iYi);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iDs != null && metaData != null && postData != null) {
            bVar.iZB.getHeadView().setUserId(metaData.getUserId());
            bVar.iZB.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.iZB.getHeadView().setTid(postData.getId());
            }
            bVar.iZB.getHeadView().setFid(this.iDs != null ? this.iDs.getForumId() : "");
            bVar.iZB.a(metaData, 0);
            bVar.iZB.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.iYk = true;
                bVar.iZC.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.bXF.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.iYk = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.bXF.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.iZC.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.bXF.setText(metaData.getName_show());
            bVar.bXF.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.bXF.setTag(R.id.tag_user_name, metaData.getName_show());
            this.iYl = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iDs != null && metaData != null) {
            this.iYf = metaData.getIs_bawu() == 1;
            this.iYg = metaData.getBawu_type();
            if (this.iDs.cjs()) {
                bVar.iZD.setVisibility(8);
            } else if (this.iYf && Config.BAWU_TYPE_MANAGER.equals(this.iYg)) {
                bVar.iZD.setText(R.string.bawu_member_bazhu_tip);
                bVar.iZD.setVisibility(0);
                bVar.Gi(this.iYg);
            } else if (this.iYf && Config.BAWU_TYPE_ASSIST.equals(this.iYg)) {
                bVar.iZD.setText(R.string.bawu_member_xbazhu_tip);
                bVar.iZD.setVisibility(0);
                bVar.Gi(this.iYg);
            } else {
                bVar.iZD.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.iDs != null && this.iDs.ciS() != null) {
            this.iPO = 0;
            if (!this.iDs.ciS().aBr()) {
                if (postData != null && postData.azX() != null) {
                    this.iPO = postData.azX().getLevel_id();
                }
                if (!this.iDs.cjs()) {
                    bVar.iZE.setVisibility(0);
                    bVar.zt(this.iPO);
                    return;
                }
                bVar.iZE.setVisibility(8);
                return;
            }
            bVar.iZE.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iDs != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.iZF.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.iZF.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.iDs != null && metaData != null) {
            bVar.iZH.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.iZH.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.iZG.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.iZG.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.iZH.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.iZG.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.iDs != null && postData != null && postData.azX() != null) {
            String threadId = this.iDs != null ? this.iDs.getThreadId() : "";
            int z = z(this.iDs);
            if (this.iPJ == null) {
                this.iPJ = new ao(this.ezp.getPageContext(), bVar.iZI, 4);
                this.iPJ.j(this.ezp.getUniqueId());
                this.iPJ.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.a.c.2
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fO(boolean z2) {
                        if (c.this.ezp != null && z2) {
                            l.showToast(c.this.ezp.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            postData.azX().setIsLike(postData.azX().hadConcerned());
            this.iPJ.a(postData.azX());
            this.iPJ.setTid(threadId);
            this.iPJ.iMi = true;
            this.iPJ.yW(z);
            if (3 != this.iDs.cjv()) {
                bVar.iZI.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.iZI.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.azX().hadConcerned()) {
                bVar.iZI.setVisibility(8);
            }
            if (this.iDs.izM || 3 == this.iDs.cjv()) {
                bVar.iZI.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.iYf) {
                bVar.Gi(this.iYg);
            }
            bVar.zt(this.iPO);
            bVar.qW(this.iYk || this.iYl);
            bVar.i(this.iYh, this.iYj, this.iYi);
            bVar.onChangeSkinType();
        }
    }

    private int z(f fVar) {
        if (fVar == null || fVar.ciS() == null) {
            return 0;
        }
        if (fVar.ciS().aBr()) {
            return (v.isEmpty(fVar.cjm()) && (fVar.ciR() == null || StringUtils.isNull(fVar.ciR().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
