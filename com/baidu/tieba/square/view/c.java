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
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView aiM;
    private TextView aiO;
    private TextView aiP;
    private LikeModel eLp;
    private TextView iUa;
    private TextView iUb;
    private TBSpecificationBtn iam;
    private ad iao;
    private boolean isLoading;
    private String mBt;
    private String mBu;
    private com.baidu.tieba.square.data.b mBv;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mBt = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mBu = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.aiM = (BarImageView) view.findViewById(R.id.bar_image);
        this.aiO = (TextView) view.findViewById(R.id.bar_name);
        this.aiP = (TextView) view.findViewById(R.id.desc);
        this.iUa = (TextView) view.findViewById(R.id.member_text);
        this.iUb = (TextView) view.findViewById(R.id.post_text);
        this.iam = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mBv = bVar;
            this.aiM.setShowOval(true);
            this.aiM.setShowOuterBorder(false);
            this.aiM.setShowInnerBorder(true);
            this.aiM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiM.setStrokeColorResId(R.color.cp_border_a);
            this.aiM.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiO.setText(forumName);
            this.iUa.setText(this.mBt + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.iUb.setText(this.mBu + " " + at.numberUniformFormatExtra(bVar.dCB()));
            RM(bVar.bfH());
            ov(this.mBv.isLike());
            this.mRootView.setOnClickListener(this);
            this.iam.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void RM(String str) {
        if (at.isEmpty(str)) {
            if (this.aiP.getVisibility() != 8) {
                this.aiP.setVisibility(8);
                if (this.aiO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.aiO.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.aiO.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aiP.getVisibility() != 0) {
            this.aiP.setVisibility(0);
            if (this.aiO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiO.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.aiO.requestLayout();
            }
        }
        this.aiP.setText(str);
    }

    public void ov(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pN(R.color.cp_link_tip_a);
            this.iam.setConfig(bVar);
            this.iam.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pP(R.color.cp_cont_d);
            this.iam.setConfig(bVar2);
            this.iam.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mBv.setLike(z);
    }

    private void cof() {
        if (this.mBv != null) {
            String forumName = this.mBv.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void cog() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mBv != null && !StringUtils.isNull(this.mBv.getForumName()) && this.mBv.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.eLp == null) {
                    this.eLp = new LikeModel(this.mTbPageContext);
                    this.eLp.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.eLp.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.eLp.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.eLp.getErrorString());
                                } else {
                                    c.this.ov(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.mBv.getForumName())) {
                    this.isLoading = true;
                    this.eLp.dDI();
                    this.eLp.gk(this.mBv.getForumName(), String.valueOf(this.mBv.getForumId()));
                }
            }
        }
    }

    private void coh() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mBv != null && !StringUtils.isNull(this.mBv.getForumName()) && this.mBv.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.iao == null) {
                    this.iao = new ad();
                    this.iao.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                            c.this.ov(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.iao.L(this.mBv.getForumName(), this.mBv.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.aiO, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUa, R.color.cp_cont_d);
        ap.setViewTextColor(this.iUb, R.color.cp_cont_d);
        ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
        this.iam.bok();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.mBv != null) {
            if (this.mRootView == view) {
                cof();
                if (this.hDj != null) {
                    this.hDj.a(view, this.mBv);
                }
            } else if (this.iam == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dCk().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dK("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.aj("obj_locate", 3);
                    }
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.u("fid", this.mBv.forumId);
                    aqVar.aj(TiebaInitialize.Params.OBJ_TO, this.mBv.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.mBv.isLike()) {
                    coh();
                } else {
                    cog();
                }
            }
        }
    }
}
