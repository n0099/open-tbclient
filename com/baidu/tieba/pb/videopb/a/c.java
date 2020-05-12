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
    private CustomMessageListener eqh;
    private BaseFragment fiG;
    private al jDg;
    private int jDl;
    private boolean jLL;
    private String jLM;
    private boolean jLN;
    private boolean jLO;
    private boolean jLP;
    private boolean jLQ;
    private boolean jLR;
    private e jqZ;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.TA != null) {
                        int cFa = ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).cFa();
                        if (cFa == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).Ak(2);
                        } else if (cFa == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).Ak(1);
                        }
                        if (c.this.jqZ.cvQ()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).jNs.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).jNs.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aOV().b(c.this.fiG.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.fiG.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view.getId() == R.id.user_yinji_video_info_item) {
                    if (view.getTag(R.id.tag_user_id) instanceof String) {
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), d.SERVER_ADDRESS_WEB_VIEW + Config.USER_ICON_WEBVIEW + "?user_id=" + ((String) view.getTag(R.id.tag_user_id)), true, true, true);
                        TiebaStatic.log(new an(CommonStatisticKey.USER_ICON_VISIT).af("obj_type", 2));
                    }
                } else if (view.getId() == R.id.head_view_video_info_item) {
                    HeadImageView headView = ((HeadPendantClickableView) view).getHeadView();
                    TiebaStatic.log(new an("c11923").af("obj_id", 2));
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    if (c.this.jqZ != null && c.this.jqZ.getForum() != null) {
                        str = c.this.jqZ.getForum().getName();
                    }
                    an anVar = new an("c13267");
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cI("fid", fid);
                    anVar.cI("tid", tid);
                    anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, userId, userName, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view.getId() == R.id.user_name_video_info_item) {
                    TiebaStatic.log(new an("c11923").af("obj_id", 2));
                    String str3 = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                    String str4 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                    if (c.this.jqZ != null && c.this.jqZ.getForum() != null) {
                        str = c.this.jqZ.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cI("uid", str3);
                    if (c.this.jqZ != null) {
                        anVar2.cI("fid", c.this.jqZ.getForumId());
                        anVar2.cI("tid", c.this.jqZ.getThreadId());
                    }
                    anVar2.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.eqh = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.TA != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).hdT != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.TA).hdT.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.fiG = baseFragment;
        this.fiG.registerListener(this.eqh);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.TA = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.jqZ != null && this.jqZ.cvs() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.fiG.getUniqueId(), this.jqZ, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(e eVar) {
        this.jqZ = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.jqZ != null && this.jqZ.cvs() != null && this.jqZ.cvs().aKC() != null && postData != null) {
            a(bVar, this.jqZ.cvs().aKC(), postData);
            a(bVar, this.jqZ.cvs().aKC());
            b(bVar, this.jqZ.cvs().aKC());
            c(bVar, this.jqZ.cvs().aKC());
            c(bVar, postData);
            d(bVar, this.jqZ.cvs().aKC());
            e(bVar, this.jqZ.cvs().aKC());
            b(bVar, this.jqZ.cvs().aKC(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.jqZ != null && this.jqZ.cvs() != null && postData != null) {
            bVar.n(this.jqZ.cvs().getTitle());
            if (this.jqZ.cvs().aKT() != null) {
                bVar.emC.setText(aq.numberUniformFormatExtra(this.jqZ.cvs().aKT().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.jNr.setText(formatTime + this.mContext.getString(R.string.send_post));
            f cWs = postData.cWs();
            if (cWs != null && !TextUtils.isEmpty(cWs.getName()) && !TextUtils.isEmpty(cWs.getName().trim())) {
                bVar.jNs.setText(cWs.getName());
                bVar.jNs.setVisibility(0);
                return;
            }
            bVar.jNs.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.jqZ != null) {
            this.jLN = this.jqZ.jnD;
            if (this.jqZ.cvs() != null) {
                this.jLP = this.jqZ.cvs().aKy() == 1;
                this.jLO = this.jqZ.cvs().aKx() == 1;
            }
            bVar.i(this.jLN, this.jLP, this.jLO);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.jqZ != null && metaData != null && postData != null) {
            bVar.jNg.getHeadView().setUserId(metaData.getUserId());
            bVar.jNg.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.jNg.getHeadView().setTid(postData.getId());
            }
            bVar.jNg.getHeadView().setFid(this.jqZ != null ? this.jqZ.getForumId() : "");
            bVar.jNg.a(metaData, 0);
            bVar.jNg.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.jLQ = true;
                bVar.jNh.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.cBd.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.jLQ = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.cBd.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.jNh.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.cBd.setText(metaData.getName_show());
            bVar.cBd.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.cBd.setTag(R.id.tag_user_name, metaData.getName_show());
            this.jLR = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jqZ != null && metaData != null) {
            this.jLL = metaData.getIs_bawu() == 1;
            this.jLM = metaData.getBawu_type();
            if (this.jqZ.cvQ()) {
                bVar.jNi.setVisibility(8);
            } else if (this.jLL && Config.BAWU_TYPE_MANAGER.equals(this.jLM)) {
                bVar.jNi.setText(R.string.bawu_member_bazhu_tip);
                bVar.jNi.setVisibility(0);
                bVar.Ii(this.jLM);
            } else if (this.jLL && Config.BAWU_TYPE_ASSIST.equals(this.jLM)) {
                bVar.jNi.setText(R.string.bawu_member_xbazhu_tip);
                bVar.jNi.setVisibility(0);
                bVar.Ii(this.jLM);
            } else {
                bVar.jNi.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.jqZ != null && this.jqZ.cvs() != null) {
            this.jDl = 0;
            if (!this.jqZ.cvs().aLW()) {
                if (postData != null && postData.aKC() != null) {
                    this.jDl = postData.aKC().getLevel_id();
                }
                if (!this.jqZ.cvQ()) {
                    bVar.jNj.setVisibility(0);
                    bVar.Aj(this.jDl);
                    return;
                }
                bVar.jNj.setVisibility(8);
                return;
            }
            bVar.jNj.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jqZ != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.jNk.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.jNk.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jqZ != null && metaData != null) {
            bVar.jNm.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.jNm.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jNl.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jNl.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.jNm.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.jNl.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.jqZ != null && postData != null && postData.aKC() != null) {
            String threadId = this.jqZ != null ? this.jqZ.getThreadId() : "";
            int A = A(this.jqZ);
            if (this.jDg == null) {
                this.jDg = new al(this.fiG.getPageContext(), bVar.jNn, 4);
                this.jDg.j(this.fiG.getUniqueId());
            }
            postData.aKC().setIsLike(postData.aKC().hadConcerned());
            this.jDg.a(postData.aKC());
            this.jDg.setTid(threadId);
            this.jDg.jzE = true;
            this.jDg.zL(A);
            if (3 != this.jqZ.cvT()) {
                bVar.jNn.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.jNn.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aKC().hadConcerned()) {
                bVar.jNn.setVisibility(8);
            }
            if (this.jqZ.jnC || 3 == this.jqZ.cvT()) {
                bVar.jNn.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.jLL) {
                bVar.Ii(this.jLM);
            }
            bVar.Aj(this.jDl);
            bVar.sl(this.jLQ || this.jLR);
            bVar.i(this.jLN, this.jLP, this.jLO);
            bVar.onChangeSkinType();
        }
    }

    private int A(e eVar) {
        if (eVar == null || eVar.cvs() == null) {
            return 0;
        }
        if (eVar.cvs().aLW()) {
            return (v.isEmpty(eVar.cvL()) && (eVar.cvr() == null || StringUtils.isNull(eVar.cvr().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
