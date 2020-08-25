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
    private BarImageView ahX;
    private TextView ahZ;
    private TextView aia;
    private LikeModel ewX;
    private TBSpecificationBtn hEj;
    private ad hEl;
    private boolean isLoading;
    private TextView ixI;
    private TextView ixJ;
    private View mRootView;
    private String mcc;
    private String mcd;
    private com.baidu.tieba.square.data.b mce;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mcc = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mcd = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.ahX = (BarImageView) view.findViewById(R.id.bar_image);
        this.ahZ = (TextView) view.findViewById(R.id.bar_name);
        this.aia = (TextView) view.findViewById(R.id.desc);
        this.ixI = (TextView) view.findViewById(R.id.member_text);
        this.ixJ = (TextView) view.findViewById(R.id.post_text);
        this.hEj = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mce = bVar;
            this.ahX.setShowOval(true);
            this.ahX.setShowOuterBorder(false);
            this.ahX.setShowInnerBorder(true);
            this.ahX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ahX.setStrokeColorResId(R.color.cp_border_a);
            this.ahX.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.ahZ.setText(forumName);
            this.ixI.setText(this.mcc + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.ixJ.setText(this.mcd + " " + at.numberUniformFormatExtra(bVar.duS()));
            Qy(bVar.bcf());
            nI(this.mce.isLike());
            this.mRootView.setOnClickListener(this);
            this.hEj.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Qy(String str) {
        if (at.isEmpty(str)) {
            if (this.aia.getVisibility() != 8) {
                this.aia.setVisibility(8);
                if (this.ahZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.ahZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.ahZ.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aia.getVisibility() != 0) {
            this.aia.setVisibility(0);
            if (this.ahZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ahZ.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.ahZ.requestLayout();
            }
        }
        this.aia.setText(str);
    }

    public void nI(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pb(R.color.cp_link_tip_a);
            this.hEj.setConfig(bVar);
            this.hEj.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pd(R.color.cp_cont_d);
            this.hEj.setConfig(bVar2);
            this.hEj.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mce.setLike(z);
    }

    private void cht() {
        if (this.mce != null) {
            String forumName = this.mce.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void chu() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mce != null && !StringUtils.isNull(this.mce.getForumName()) && this.mce.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.ewX == null) {
                    this.ewX = new LikeModel(this.mTbPageContext);
                    this.ewX.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.ewX.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.ewX.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.ewX.getErrorString());
                                } else {
                                    c.this.nI(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.mce.getForumName())) {
                    this.isLoading = true;
                    this.ewX.dvY();
                    this.ewX.fQ(this.mce.getForumName(), String.valueOf(this.mce.getForumId()));
                }
            }
        }
    }

    private void chv() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mce != null && !StringUtils.isNull(this.mce.getForumName()) && this.mce.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.hEl == null) {
                    this.hEl = new ad();
                    this.hEl.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void y(String str, long j) {
                            c.this.isLoading = false;
                            c.this.nI(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void z(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.hEl.K(this.mce.getForumName(), this.mce.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.ahZ, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.ixI, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.ixJ, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.aia, (int) R.color.cp_cont_d);
        this.hEj.bkF();
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.mce != null) {
            if (this.mRootView == view) {
                cht();
                if (this.hhh != null) {
                    this.hhh.a(view, this.mce);
                }
            } else if (this.hEj == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).duB().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dD("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.ai("obj_locate", 3);
                    }
                    aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.u("fid", this.mce.forumId);
                    aqVar.ai(TiebaInitialize.Params.OBJ_TO, this.mce.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.mce.isLike()) {
                    chv();
                } else {
                    chu();
                }
            }
        }
    }
}
