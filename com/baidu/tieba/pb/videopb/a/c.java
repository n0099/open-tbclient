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
/* loaded from: classes6.dex */
public class c extends com.baidu.adp.widget.ListView.a<PostData, com.baidu.tieba.pb.videopb.e.b> {
    private CustomMessageListener dLp;
    private BaseFragment eyc;
    private ao iMf;
    private int iMk;
    private boolean iUC;
    private String iUD;
    private boolean iUE;
    private boolean iUF;
    private boolean iUG;
    private boolean iUH;
    private boolean iUI;
    private f izO;
    private View.OnClickListener mOnClickListener;

    public c(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str = null;
                if (view.getId() == R.id.btn_wrapper_title_expand_video_info_item) {
                    if (c.this.zL != null) {
                        int crw = ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).crw();
                        if (crw == 1) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).zp(2);
                        } else if (crw == 2) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).zp(1);
                        }
                        if (c.this.izO.cik()) {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).iWk.setVisibility(8);
                        } else {
                            ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).iWk.setVisibility(0);
                        }
                        TiebaStatic.log("c13603");
                    }
                } else if (view.getId() == R.id.vip_icon_video_info_item) {
                    if (bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str2 = view.getTag() != null ? (String) view.getTag() : null;
                        if (str2 != null) {
                            ba.aEa().b(c.this.eyc.getPageContext(), new String[]{str2});
                        }
                        TiebaStatic.eventStat(c.this.eyc.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
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
                    if (c.this.izO != null && c.this.izO.getForum() != null) {
                        str = c.this.izO.getForum().getName();
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
                    if (c.this.izO != null && c.this.izO.getForum() != null) {
                        str = c.this.izO.getForum().getName();
                    }
                    an anVar2 = new an("c13267");
                    anVar2.cp("uid", str3);
                    if (c.this.izO != null) {
                        anVar2.cp("fid", c.this.izO.getForumId());
                        anVar2.cp("tid", c.this.izO.getThreadId());
                    }
                    anVar2.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(anVar2);
                    if (str3 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(c.this.mContext, str3, str4, str, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                }
            }
        };
        this.dLp = new CustomMessageListener(CmdConfigCustom.PB_RICHTEXT_CHANGE_CMD) { // from class: com.baidu.tieba.pb.videopb.a.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.zL != null && ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).goA != null) {
                    ((com.baidu.tieba.pb.videopb.e.b) c.this.zL).goA.setTextSize(0, TbConfig.getContentSize());
                    c.this.notifyDataSetChanged();
                }
            }
        };
        this.eyc = baseFragment;
        this.eyc.registerListener(this.dLp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public com.baidu.tieba.pb.videopb.e.b b(ViewGroup viewGroup) {
        com.baidu.tieba.pb.videopb.e.b bVar = new com.baidu.tieba.pb.videopb.e.b(this.mContext, LayoutInflater.from(this.mContext).inflate(R.layout.pb_list_video_info_item, viewGroup, false));
        bVar.setOnClickListener(this.mOnClickListener);
        b(bVar);
        this.zL = bVar;
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, PostData postData, com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.izO != null && this.izO.chK() != null && postData != null) {
            com.baidu.tieba.pb.c.a.a(this.eyc.getUniqueId(), this.izO, postData, 1, 1);
            a(bVar);
            a(bVar, postData);
            b(bVar, postData);
            b(bVar);
        }
        return view;
    }

    public void setPbData(f fVar) {
        this.izO = fVar;
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.izO != null && this.izO.chK() != null && this.izO.chK().azE() != null && postData != null) {
            a(bVar, this.izO.chK().azE(), postData);
            a(bVar, this.izO.chK().azE());
            b(bVar, this.izO.chK().azE());
            c(bVar, this.izO.chK().azE());
            c(bVar, postData);
            d(bVar, this.izO.chK().azE());
            e(bVar, this.izO.chK().azE());
            b(bVar, this.izO.chK().azE(), postData);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        String formatTime;
        if (this.izO != null && this.izO.chK() != null && postData != null) {
            bVar.m(this.izO.chK().getTitle());
            if (this.izO.chK().azV() != null) {
                bVar.dHO.setText(aq.numberUniformFormatExtra(this.izO.chK().azV().play_count.intValue()) + this.mContext.getString(R.string.play));
            }
            if (StringUtils.SimpleDateFormat(new Date(), DateTimeUtil.YEAR_FORMAT).equals(StringUtils.SimpleDateFormat(new Date(postData.getTime()), DateTimeUtil.YEAR_FORMAT))) {
                formatTime = aq.getFormatTimeShort(postData.getTime());
            } else {
                formatTime = aq.getFormatTime(postData.getTime());
            }
            bVar.iWj.setText(formatTime + this.mContext.getString(R.string.send_post));
            com.baidu.tbadk.data.f cIw = postData.cIw();
            if (cIw != null && !TextUtils.isEmpty(cIw.getName()) && !TextUtils.isEmpty(cIw.getName().trim())) {
                bVar.iWk.setText(cIw.getName());
                bVar.iWk.setVisibility(0);
                return;
            }
            bVar.iWk.setVisibility(8);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (this.izO != null) {
            this.iUE = this.izO.iwj;
            if (this.izO.chK() != null) {
                this.iUG = this.izO.chK().azA() == 1;
                this.iUF = this.izO.chK().azz() == 1;
            }
            bVar.i(this.iUE, this.iUG, this.iUF);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.izO != null && metaData != null && postData != null) {
            bVar.iVY.getHeadView().setUserId(metaData.getUserId());
            bVar.iVY.getHeadView().setUserName(metaData.getUserName());
            if (postData != null) {
                bVar.iVY.getHeadView().setTid(postData.getId());
            }
            bVar.iVY.getHeadView().setFid(this.izO != null ? this.izO.getForumId() : "");
            bVar.iVY.a(metaData, 0);
            bVar.iVY.a(metaData);
        }
    }

    private void a(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
            if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                this.iUH = true;
                bVar.iVZ.setTag(tShowInfoNew.get(0).getUrl());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.bXt.getLayoutParams();
                layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                this.iUH = false;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.bXt.getLayoutParams();
                layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            }
            bVar.iVZ.a(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        }
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (metaData != null) {
            bVar.bXt.setText(metaData.getName_show());
            bVar.bXt.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.bXt.setTag(R.id.tag_user_name, metaData.getName_show());
            this.iUI = metaData.isBigV();
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.izO != null && metaData != null) {
            this.iUC = metaData.getIs_bawu() == 1;
            this.iUD = metaData.getBawu_type();
            if (this.izO.cik()) {
                bVar.iWa.setVisibility(8);
            } else if (this.iUC && Config.BAWU_TYPE_MANAGER.equals(this.iUD)) {
                bVar.iWa.setText(R.string.bawu_member_bazhu_tip);
                bVar.iWa.setVisibility(0);
                bVar.FY(this.iUD);
            } else if (this.iUC && Config.BAWU_TYPE_ASSIST.equals(this.iUD)) {
                bVar.iWa.setText(R.string.bawu_member_xbazhu_tip);
                bVar.iWa.setVisibility(0);
                bVar.FY(this.iUD);
            } else {
                bVar.iWa.setVisibility(8);
            }
        }
    }

    private void c(com.baidu.tieba.pb.videopb.e.b bVar, PostData postData) {
        if (this.izO != null && this.izO.chK() != null) {
            this.iMk = 0;
            if (!this.izO.chK().aAY()) {
                if (postData != null && postData.azE() != null) {
                    this.iMk = postData.azE().getLevel_id();
                }
                if (!this.izO.cik()) {
                    bVar.iWb.setVisibility(0);
                    bVar.zo(this.iMk);
                    return;
                }
                bVar.iWb.setVisibility(8);
                return;
            }
            bVar.iWb.setVisibility(8);
        }
    }

    private void d(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.izO != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            bVar.iWc.setTag(R.id.tag_user_id, metaData.getUserId());
            bVar.iWc.a(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds42), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    private void e(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData) {
        if (this.izO != null && metaData != null) {
            bVar.iWe.setText(aq.numberUniformFormatExtra(metaData.getFansNum()) + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
        }
        if (metaData != null && metaData.getBaijiahaoInfo() != null && !aq.isEmpty(metaData.getBaijiahaoInfo().auth_desc)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.iWe.getLayoutParams();
            layoutParams.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.iWd.setText(metaData.getBaijiahaoInfo().auth_desc);
            bVar.iWd.setVisibility(0);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) bVar.iWe.getLayoutParams();
        layoutParams2.setMargins(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.iWd.setVisibility(8);
    }

    private void b(com.baidu.tieba.pb.videopb.e.b bVar, MetaData metaData, PostData postData) {
        if (this.izO != null && postData != null && postData.azE() != null) {
            String threadId = this.izO != null ? this.izO.getThreadId() : "";
            int z = z(this.izO);
            if (this.iMf == null) {
                this.iMf = new ao(this.eyc.getPageContext(), bVar.iWf, 4);
                this.iMf.j(this.eyc.getUniqueId());
                this.iMf.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.a.c.2
                    @Override // com.baidu.tbadk.core.view.userLike.c.a
                    public void fJ(boolean z2) {
                        if (c.this.eyc != null && z2) {
                            l.showToast(c.this.eyc.getBaseFragmentActivity(), (int) R.string.attention_success);
                        }
                    }
                });
            }
            postData.azE().setIsLike(postData.azE().hadConcerned());
            this.iMf.a(postData.azE());
            this.iMf.setTid(threadId);
            this.iMf.iIE = true;
            this.iMf.yR(z);
            if (3 != this.izO.cin()) {
                bVar.iWf.setVisibility(0);
            }
            if (aq.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                bVar.iWf.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn() || postData.azE().hadConcerned()) {
                bVar.iWf.setVisibility(8);
            }
            if (this.izO.iwi || 3 == this.izO.cin()) {
                bVar.iWf.setVisibility(8);
            }
        }
    }

    public void b(com.baidu.tieba.pb.videopb.e.b bVar) {
        if (bVar != null) {
            if (this.iUC) {
                bVar.FY(this.iUD);
            }
            bVar.zo(this.iMk);
            bVar.qJ(this.iUH || this.iUI);
            bVar.i(this.iUE, this.iUG, this.iUF);
            bVar.onChangeSkinType();
        }
    }

    private int z(f fVar) {
        if (fVar == null || fVar.chK() == null) {
            return 0;
        }
        if (fVar.chK().aAY()) {
            return (v.isEmpty(fVar.cie()) && (fVar.chJ() == null || StringUtils.isNull(fVar.chJ().getForumName()))) ? 0 : 2;
        }
        return 1;
    }
}
