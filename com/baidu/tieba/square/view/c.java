package com.baidu.tieba.square.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView ahZ;
    private TextView aib;
    private TextView aic;
    private LikeModel exb;
    private TBSpecificationBtn hEp;
    private ad hEr;
    private boolean isLoading;
    private TextView ixO;
    private TextView ixP;
    private View mRootView;
    private String mcr;
    private String mcs;
    private com.baidu.tieba.square.data.b mct;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mcr = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mcs = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.ahZ = (BarImageView) view.findViewById(R.id.bar_image);
        this.aib = (TextView) view.findViewById(R.id.bar_name);
        this.aic = (TextView) view.findViewById(R.id.desc);
        this.ixO = (TextView) view.findViewById(R.id.member_text);
        this.ixP = (TextView) view.findViewById(R.id.post_text);
        this.hEp = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mct = bVar;
            this.ahZ.setShowOval(true);
            this.ahZ.setShowOuterBorder(false);
            this.ahZ.setShowInnerBorder(true);
            this.ahZ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ahZ.setStrokeColorResId(R.color.cp_border_a);
            this.ahZ.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aib.setText(forumName);
            this.ixO.setText(this.mcr + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.ixP.setText(this.mcs + " " + at.numberUniformFormatExtra(bVar.duX()));
            Qy(bVar.bcf());
            nK(this.mct.isLike());
            this.mRootView.setOnClickListener(this);
            this.hEp.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Qy(String str) {
        if (at.isEmpty(str)) {
            if (this.aic.getVisibility() != 8) {
                this.aic.setVisibility(8);
                if (this.aib.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.aib.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.aib.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aic.getVisibility() != 0) {
            this.aic.setVisibility(0);
            if (this.aib.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aib.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.aib.requestLayout();
            }
        }
        this.aic.setText(str);
    }

    public void nK(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pb(R.color.cp_link_tip_a);
            this.hEp.setConfig(bVar);
            this.hEp.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pd(R.color.cp_cont_d);
            this.hEp.setConfig(bVar2);
            this.hEp.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mct.setLike(z);
    }

    private void chu() {
        if (this.mct != null) {
            String forumName = this.mct.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void chv() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mct != null && !StringUtils.isNull(this.mct.getForumName()) && this.mct.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.exb == null) {
                    this.exb = new LikeModel(this.mTbPageContext);
                    this.exb.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.exb.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.exb.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.exb.getErrorString());
                                } else {
                                    c.this.nK(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.mct.getForumName())) {
                    this.isLoading = true;
                    this.exb.dwd();
                    this.exb.fR(this.mct.getForumName(), String.valueOf(this.mct.getForumId()));
                }
            }
        }
    }

    private void chw() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mct != null && !StringUtils.isNull(this.mct.getForumName()) && this.mct.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.hEr == null) {
                    this.hEr = new ad();
                    this.hEr.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void y(String str, long j) {
                            c.this.isLoading = false;
                            c.this.nK(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.hEr.K(this.mct.getForumName(), this.mct.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.aib, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.ixO, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.ixP, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.aic, (int) R.color.cp_cont_d);
        this.hEp.bkF();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.mct != null) {
            if (this.mRootView == view) {
                chu();
                if (this.hhl != null) {
                    this.hhl.a(view, this.mct);
                }
            } else if (this.hEp == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).duG().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dD("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.ai("obj_locate", 3);
                    }
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.u("fid", this.mct.forumId);
                    aqVar.ai(TiebaInitialize.Params.OBJ_TO, this.mct.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.mct.isLike()) {
                    chw();
                } else {
                    chv();
                }
            }
        }
    }
}
