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
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView aiu;
    private TextView aiw;
    private TextView aix;
    private LikeModel ezi;
    private TBSpecificationBtn hLr;
    private ad hLt;
    private TextView iFk;
    private TextView iFl;
    private boolean isLoading;
    private View mRootView;
    private String mlR;
    private String mlS;
    private com.baidu.tieba.square.data.b mlT;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mlR = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mlS = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.aiu = (BarImageView) view.findViewById(R.id.bar_image);
        this.aiw = (TextView) view.findViewById(R.id.bar_name);
        this.aix = (TextView) view.findViewById(R.id.desc);
        this.iFk = (TextView) view.findViewById(R.id.member_text);
        this.iFl = (TextView) view.findViewById(R.id.post_text);
        this.hLr = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mlT = bVar;
            this.aiu.setShowOval(true);
            this.aiu.setShowOuterBorder(false);
            this.aiu.setShowInnerBorder(true);
            this.aiu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiu.setStrokeColorResId(R.color.cp_border_a);
            this.aiu.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiw.setText(forumName);
            this.iFk.setText(this.mlR + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.iFl.setText(this.mlS + " " + at.numberUniformFormatExtra(bVar.dyQ()));
            QY(bVar.bcZ());
            nQ(this.mlT.isLike());
            this.mRootView.setOnClickListener(this);
            this.hLr.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void QY(String str) {
        if (at.isEmpty(str)) {
            if (this.aix.getVisibility() != 8) {
                this.aix.setVisibility(8);
                if (this.aiw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.aiw.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.aiw.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aix.getVisibility() != 0) {
            this.aix.setVisibility(0);
            if (this.aiw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiw.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.aiw.requestLayout();
            }
        }
        this.aix.setText(str);
    }

    public void nQ(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pp(R.color.cp_link_tip_a);
            this.hLr.setConfig(bVar);
            this.hLr.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pr(R.color.cp_cont_d);
            this.hLr.setConfig(bVar2);
            this.hLr.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mlT.setLike(z);
    }

    private void ckJ() {
        if (this.mlT != null) {
            String forumName = this.mlT.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void ckK() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mlT != null && !StringUtils.isNull(this.mlT.getForumName()) && this.mlT.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.ezi == null) {
                    this.ezi = new LikeModel(this.mTbPageContext);
                    this.ezi.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.ezi.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.ezi.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.ezi.getErrorString());
                                } else {
                                    c.this.nQ(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.mlT.getForumName())) {
                    this.isLoading = true;
                    this.ezi.dzW();
                    this.ezi.gd(this.mlT.getForumName(), String.valueOf(this.mlT.getForumId()));
                }
            }
        }
    }

    private void ckL() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mlT != null && !StringUtils.isNull(this.mlT.getForumName()) && this.mlT.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.hLt == null) {
                    this.hLt = new ad();
                    this.hLt.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                            c.this.nQ(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.hLt.L(this.mlT.getForumName(), this.mlT.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.aiw, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iFk, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.iFl, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.aix, (int) R.color.cp_cont_d);
        this.hLr.blA();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.mlT != null) {
            if (this.mRootView == view) {
                ckJ();
                if (this.hop != null) {
                    this.hop.a(view, this.mlT);
                }
            } else if (this.hLr == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dyz().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dF("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.ai("obj_locate", 3);
                    }
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.u("fid", this.mlT.forumId);
                    aqVar.ai(TiebaInitialize.Params.OBJ_TO, this.mlT.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.mlT.isLike()) {
                    ckL();
                } else {
                    ckK();
                }
            }
        }
    }
}
