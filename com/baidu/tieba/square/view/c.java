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
    private BarImageView aiN;
    private TextView aiP;
    private TextView aiQ;
    private LikeModel eZA;
    private TBSpecificationBtn isL;
    private boolean isLoading;
    private ad isN;
    private TextView jmv;
    private TextView jmw;
    private View mRootView;
    private String mUf;
    private String mUg;
    private com.baidu.tieba.square.data.b mUh;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mUf = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mUg = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.aiN = (BarImageView) view.findViewById(R.id.bar_image);
        this.aiP = (TextView) view.findViewById(R.id.bar_name);
        this.aiQ = (TextView) view.findViewById(R.id.desc);
        this.jmv = (TextView) view.findViewById(R.id.member_text);
        this.jmw = (TextView) view.findViewById(R.id.post_text);
        this.isL = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mUh = bVar;
            this.aiN.setShowOval(true);
            this.aiN.setShowOuterBorder(false);
            this.aiN.setShowInnerBorder(true);
            this.aiN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiN.setStrokeColorResId(R.color.cp_border_a);
            this.aiN.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiP.setText(forumName);
            this.jmv.setText(this.mUf + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jmw.setText(this.mUg + " " + at.numberUniformFormatExtra(bVar.dIl()));
            SC(bVar.bka());
            oW(this.mUh.isLike());
            this.mRootView.setOnClickListener(this);
            this.isL.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void SC(String str) {
        if (at.isEmpty(str)) {
            if (this.aiQ.getVisibility() != 8) {
                this.aiQ.setVisibility(8);
                if (this.aiP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.aiP.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.aiP.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aiQ.getVisibility() != 0) {
            this.aiQ.setVisibility(0);
            if (this.aiP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiP.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.aiP.requestLayout();
            }
        }
        this.aiQ.setText(str);
    }

    public void oW(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qi(R.color.cp_link_tip_a);
            this.isL.setConfig(bVar);
            this.isL.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qk(R.color.cp_cont_d);
            this.isL.setConfig(bVar2);
            this.isL.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mUh.setLike(z);
    }

    private void ctN() {
        if (this.mUh != null) {
            String forumName = this.mUh.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void ctO() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mUh != null && !StringUtils.isNull(this.mUh.getForumName()) && this.mUh.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.eZA == null) {
                    this.eZA = new LikeModel(this.mTbPageContext);
                    this.eZA.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.eZA.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.eZA.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.eZA.getErrorString());
                                } else {
                                    c.this.oW(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.mUh.getForumName())) {
                    this.isLoading = true;
                    this.eZA.dJs();
                    this.eZA.gp(this.mUh.getForumName(), String.valueOf(this.mUh.getForumId()));
                }
            }
        }
    }

    private void ctP() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mUh != null && !StringUtils.isNull(this.mUh.getForumName()) && this.mUh.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.isN == null) {
                    this.isN = new ad();
                    this.isN.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                            c.this.oW(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void D(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.isN.O(this.mUh.getForumName(), this.mUh.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.aiP, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.jmv, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.jmw, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.aiQ, (int) R.color.cp_cont_d);
        this.isL.bsD();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.mUh != null) {
            if (this.mRootView == view) {
                ctN();
                if (this.hVC != null) {
                    this.hVC.a(view, this.mUh);
                }
            } else if (this.isL == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dHU().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dR("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.al("obj_locate", 3);
                    }
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.w("fid", this.mUh.forumId);
                    aqVar.al(TiebaInitialize.Params.OBJ_TO, this.mUh.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.mUh.isLike()) {
                    ctP();
                } else {
                    ctO();
                }
            }
        }
    }
}
