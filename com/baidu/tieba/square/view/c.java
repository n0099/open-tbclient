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
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private TextView aJn;
    private TextView dVS;
    private LikeModel dYI;
    private BarImageView gNV;
    private TBSpecificationBtn gZj;
    private ac gZl;
    private TextView hPw;
    private TextView hPx;
    private boolean isLoading;
    private String lhY;
    private String lhZ;
    private com.baidu.tieba.square.data.b lia;
    private View mRootView;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.lhY = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.lhZ = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.gNV = (BarImageView) view.findViewById(R.id.bar_image);
        this.dVS = (TextView) view.findViewById(R.id.bar_name);
        this.aJn = (TextView) view.findViewById(R.id.desc);
        this.hPw = (TextView) view.findViewById(R.id.member_text);
        this.hPx = (TextView) view.findViewById(R.id.post_text);
        this.gZj = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.lia = bVar;
            this.gNV.setShowOval(true);
            this.gNV.setShowOuterBorder(false);
            this.gNV.setShowInnerBorder(true);
            this.gNV.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.gNV.setStrokeColorResId(R.color.cp_border_a);
            this.gNV.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (aq.isEmpty(forumName)) {
                forumName = "";
            }
            this.dVS.setText(forumName);
            this.hPw.setText(this.lhY + " " + aq.numberUniformFormatExtra(bVar.getMemberCount()));
            this.hPx.setText(this.lhZ + " " + aq.numberUniformFormatExtra(bVar.dbH()));
            Mm(bVar.aOj());
            mo(this.lia.isLike());
            this.mRootView.setOnClickListener(this);
            this.gZj.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Mm(String str) {
        if (aq.isEmpty(str)) {
            if (this.aJn.getVisibility() != 8) {
                this.aJn.setVisibility(8);
                if (this.dVS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.dVS.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.dVS.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aJn.getVisibility() != 0) {
            this.aJn.setVisibility(0);
            if (this.dVS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.dVS.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.dVS.requestLayout();
            }
        }
        this.aJn.setText(str);
    }

    public void mo(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mi(R.color.cp_link_tip_a);
            this.gZj.setConfig(cVar);
            this.gZj.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mk(R.color.cp_cont_d);
            this.gZj.setConfig(cVar2);
            this.gZj.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.lia.setLike(z);
    }

    private void bQO() {
        if (this.lia != null) {
            String forumName = this.lia.getForumName();
            if (aq.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void bQP() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.lia != null && !StringUtils.isNull(this.lia.getForumName()) && this.lia.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.dYI == null) {
                    this.dYI = new LikeModel(this.mTbPageContext);
                    this.dYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.dYI.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.dYI.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.dYI.getErrorString());
                                } else {
                                    c.this.mo(true);
                                }
                            }
                        }
                    });
                }
                if (aq.isForumName(this.lia.getForumName())) {
                    this.isLoading = true;
                    this.dYI.dcN();
                    this.dYI.fq(this.lia.getForumName(), String.valueOf(this.lia.getForumId()));
                }
            }
        }
    }

    private void bQQ() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.lia != null && !StringUtils.isNull(this.lia.getForumName()) && this.lia.getForumId() > 0 && bc.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.gZl == null) {
                    this.gZl = new ac();
                    this.gZl.a(new ac.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                            c.this.mo(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.gZl.K(this.lia.getForumName(), this.lia.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.dVS, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hPw, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hPx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.aJn, (int) R.color.cp_cont_d);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        if (this.lia != null) {
            if (this.mRootView == view) {
                bQO();
                if (this.gBI != null) {
                    this.gBI.a(view, this.lia);
                }
            } else if (this.gZj == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        anVar = new an("c13653");
                        anVar.dh("resource_id", className);
                    } else {
                        anVar = new an("c13644");
                        anVar.ag("obj_locate", 3);
                    }
                    anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                    anVar.s("fid", this.lia.forumId);
                    anVar.ag(TiebaInitialize.Params.OBJ_TO, this.lia.isLike() ? 2 : 1);
                    TiebaStatic.log(anVar);
                }
                if (this.lia.isLike()) {
                    bQQ();
                } else {
                    bQP();
                }
            }
        }
    }
}
