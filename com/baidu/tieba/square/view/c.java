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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.square.data.b> {
    private TextView aDO;
    private TextView dHD;
    private LikeModel dKs;
    private TBSpecificationBtn gKx;
    private ac gKz;
    private BarImageView gzl;
    private TextView hAJ;
    private TextView hAK;
    private boolean isLoading;
    private String kPI;
    private String kPJ;
    private com.baidu.tieba.square.data.b kPK;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.kPI = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.kPJ = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.gzl = (BarImageView) view.findViewById(R.id.bar_image);
        this.dHD = (TextView) view.findViewById(R.id.bar_name);
        this.aDO = (TextView) view.findViewById(R.id.desc);
        this.hAJ = (TextView) view.findViewById(R.id.member_text);
        this.hAK = (TextView) view.findViewById(R.id.post_text);
        this.gKx = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.kPK = bVar;
            this.gzl.setShowOval(true);
            this.gzl.setShowOuterBorder(false);
            this.gzl.setShowInnerBorder(true);
            this.gzl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gzl.setStrokeColorResId(R.color.cp_border_a);
            this.gzl.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dHD.setText(forumName);
            this.hAJ.setText(this.kPI + " " + aq.numberUniformFormatExtra(bVar.getMemberCount()));
            this.hAK.setText(this.kPJ + " " + aq.numberUniformFormatExtra(bVar.cUC()));
            KA(bVar.aIv());
            lT(this.kPK.isLike());
            this.mRootView.setOnClickListener(this);
            this.gKx.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void KA(String str) {
        if (aq.isEmpty(str)) {
            if (this.aDO.getVisibility() != 8) {
                this.aDO.setVisibility(8);
                if (this.dHD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.dHD.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.dHD.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aDO.getVisibility() != 0) {
            this.aDO.setVisibility(0);
            if (this.dHD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dHD.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.dHD.requestLayout();
            }
        }
        this.aDO.setText(str);
    }

    public void lT(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.lG(R.color.cp_link_tip_a);
            this.gKx.setConfig(cVar);
            this.gKx.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.lI(R.color.cp_cont_d);
            this.gKx.setConfig(cVar2);
            this.gKx.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.kPK.setLike(z);
    }

    private void bKs() {
        if (this.kPK != null) {
            String forumName = this.kPK.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void bKt() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.kPK != null && !StringUtils.isNull(this.kPK.getForumName()) && this.kPK.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.dKs == null) {
                    this.dKs = new LikeModel(this.mTbPageContext);
                    this.dKs.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.dKs.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.dKs.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.dKs.getErrorString());
                                } else {
                                    c.this.lT(true);
                                }
                            }
                        }
                    });
                }
                if (aq.isForumName(this.kPK.getForumName())) {
                    this.isLoading = true;
                    this.dKs.cVI();
                    this.dKs.eP(this.kPK.getForumName(), String.valueOf(this.kPK.getForumId()));
                }
            }
        }
    }

    private void bKu() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.kPK != null && !StringUtils.isNull(this.kPK.getForumName()) && this.kPK.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.gKz == null) {
                    this.gKz = new ac();
                    this.gKz.a(new ac.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                            c.this.lT(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void B(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.gKz.L(this.kPK.getForumName(), this.kPK.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dHD, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hAJ, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hAK, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aDO, (int) R.color.cp_cont_d);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        if (this.kPK != null) {
            if (this.mRootView == view) {
                bKs();
                if (this.gmO != null) {
                    this.gmO.a(view, this.kPK);
                }
            } else if (this.gKx == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        anVar = new an("c13653");
                        anVar.cI("resource_id", className);
                    } else {
                        anVar = new an("c13644");
                        anVar.af("obj_locate", 3);
                    }
                    anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.t("fid", this.kPK.forumId);
                    anVar.af(TiebaInitialize.Params.OBJ_TO, this.kPK.isLike() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
                if (this.kPK.isLike()) {
                    bKu();
                } else {
                    bKt();
                }
            }
        }
    }
}
