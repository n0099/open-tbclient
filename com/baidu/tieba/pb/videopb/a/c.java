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
    private CustomMessageListener eqc;
    private BaseFragment fiB;
    private al jDc;
    private int jDh;
    private boolean jLH;
    private String jLI;
    private boolean jLJ;
    private boolean jLK;
    private boolean jLL;
    private boolean jLM;
    private boolean jLN;
    private e jqV;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.Tx != null) {
                        int cFc = ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).cFc();
                        if (cFc == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).Ak(2);
                        } else if (cFc == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).Ak(1);
                        }
                        if (c.this.jqV.cvS()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).jNo.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).jNo.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aOY().b(c.this.fiB.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.fiB.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                    if (c.this.jqV != null && c.this.jqV.getForum() != null) {
                        str = c.this.jqV.getForum().getName();
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
                    if (c.this.jqV != null && c.this.jqV.getForum() != null) {
                        str = c.this.jqV.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cI("uid", str3);
                    if (c.this.jqV != null) {
                        anVar2.cI("fid", c.this.jqV.getForumId());
                        anVar2.cI("tid", c.this.jqV.getThreadId());
                    }
                    anVar2.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.eqc = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.Tx != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).hdN != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.Tx).hdN.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.fiB = baseFragment;
        this.fiB.registerListener(this.eqc);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bV */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.Tx = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.jqV != null && this.jqV.cvu() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.fiB.getUniqueId(), this.jqV, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(e eVar) {
        this.jqV = eVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.jqV != null && this.jqV.cvu() != null && this.jqV.cvu().aKE() != null && postData != null) {
            a(bVar, this.jqV.cvu().aKE(), postData);
            a(bVar, this.jqV.cvu().aKE());
            b(bVar, this.jqV.cvu().aKE());
            c(bVar, this.jqV.cvu().aKE());
            c(bVar, postData);
            d(bVar, this.jqV.cvu().aKE());
            e(bVar, this.jqV.cvu().aKE());
            b(bVar, this.jqV.cvu().aKE(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.jqV != null && this.jqV.cvu() != null && postData != null) {
            bVar.n(this.jqV.cvu().getTitle());
            if (this.jqV.cvu().aKV() != null) {
                bVar.emx.setText(aq.numberUniformFormatExtra(this.jqV.cvu().aKV().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), "yyyy"))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.jNn.setText(formatTime + this.mContext.getString(R.string.send_post));
            f cWu = postData.cWu();
            if (cWu != null && !TextUtils.isEmpty(cWu.getName()) && !TextUtils.isEmpty(cWu.getName().trim())) {
                bVar.jNo.setText(cWu.getName());
                bVar.jNo.setVisibility(0);
                return;
            }
            bVar.jNo.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.jqV != null) {
            this.jLJ = this.jqV.jnz;
            if (this.jqV.cvu() != null) {
                this.jLL = this.jqV.cvu().aKA() == 1;
                this.jLK = this.jqV.cvu().aKz() == 1;
            }
            bVar.i(this.jLJ, this.jLL, this.jLK);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.jqV != null && metaData != null && postData != null) {
            bVar.jNc.getHeadView().setUserId(metaData.getUserId());
            bVar.jNc.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.jNc.getHeadView().setTid(postData.getId());
            }
            bVar.jNc.getHeadView().setFid(this.jqV != null ? this.jqV.getForumId() : "");
            bVar.jNc.a(metaData, 0);
            bVar.jNc.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.jLM = true;
                bVar.jNd.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.cAX.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.jLM = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.cAX.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.jNd.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.cAX.setText(metaData.getName_show());
            bVar.cAX.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.cAX.setTag(R.id.tag_user_name, metaData.getName_show());
            this.jLN = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jqV != null && metaData != null) {
            this.jLH = metaData.getIs_bawu() == 1;
            this.jLI = metaData.getBawu_type();
            if (this.jqV.cvS()) {
                bVar.jNe.setVisibility(8);
            } else if (this.jLH && Config.BAWU_TYPE_MANAGER.equals(this.jLI)) {
                bVar.jNe.setText(R.string.bawu_member_bazhu_tip);
                bVar.jNe.setVisibility(0);
                bVar.If(this.jLI);
            } else if (this.jLH && Config.BAWU_TYPE_ASSIST.equals(this.jLI)) {
                bVar.jNe.setText(R.string.bawu_member_xbazhu_tip);
                bVar.jNe.setVisibility(0);
                bVar.If(this.jLI);
            } else {
                bVar.jNe.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.jqV != null && this.jqV.cvu() != null) {
            this.jDh = 0;
            if (!this.jqV.cvu().aLY()) {
                if (postData != null && postData.aKE() != null) {
                    this.jDh = postData.aKE().getLevel_id();
                }
                if (!this.jqV.cvS()) {
                    bVar.jNf.setVisibility(0);
                    bVar.Aj(this.jDh);
                    return;
                }
                bVar.jNf.setVisibility(8);
                return;
            }
            bVar.jNf.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jqV != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.jNg.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.jNg.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.jqV != null && metaData != null) {
            bVar.jNi.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.jNi.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.jNh.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.jNh.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.jNi.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.jNh.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.jqV != null && postData != null && postData.aKE() != null) {
            String threadId = this.jqV != null ? this.jqV.getThreadId() : "";
            int A = A(this.jqV);
            if (this.jDc == null) {
                this.jDc = new al(this.fiB.getPageContext(), bVar.jNj, 4);
                this.jDc.j(this.fiB.getUniqueId());
            }
            postData.aKE().setIsLike(postData.aKE().hadConcerned());
            this.jDc.a(postData.aKE());
            this.jDc.setTid(threadId);
            this.jDc.jzA = true;
            this.jDc.zL(A);
            if (3 != this.jqV.cvV()) {
                bVar.jNj.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.jNj.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.aKE().hadConcerned()) {
                bVar.jNj.setVisibility(8);
            }
            if (this.jqV.jny || 3 == this.jqV.cvV()) {
                bVar.jNj.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.jLH) {
                bVar.If(this.jLI);
            }
            bVar.Aj(this.jDh);
            bVar.sl(this.jLM || this.jLN);
            bVar.i(this.jLJ, this.jLL, this.jLK);
            bVar.onChangeSkinType();
        }
    }

    private int A(e eVar) {
        if (eVar == null || eVar.cvu() == null) {
            return 0;
        }
        if (eVar.cvu().aLY()) {
            return (v.isEmpty(eVar.cvN()) && (eVar.cvt() == null || StringUtils.isNull(eVar.cvt().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
