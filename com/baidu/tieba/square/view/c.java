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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView aiS;
    private TextView aiU;
    private TextView aiV;
    private LikeModel eYI;
    private boolean isLoading;
    private ad itB;
    private TBSpecificationBtn itz;
    private TextView jnf;
    private TextView jng;
    private View mRootView;
    private String mVa;
    private String mVb;
    private com.baidu.tieba.square.data.b mVc;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.mVa = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.mVb = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.aiS = (BarImageView) view.findViewById(R.id.bar_image);
        this.aiU = (TextView) view.findViewById(R.id.bar_name);
        this.aiV = (TextView) view.findViewById(R.id.desc);
        this.jnf = (TextView) view.findViewById(R.id.member_text);
        this.jng = (TextView) view.findViewById(R.id.post_text);
        this.itz = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.mVc = bVar;
            this.aiS.setShowOval(true);
            this.aiS.setShowOuterBorder(false);
            this.aiS.setShowInnerBorder(true);
            this.aiS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.aiS.setStrokeColorResId(R.color.CAM_X0401);
            this.aiS.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (au.isEmpty(forumName)) {
                forumName = "";
            }
            this.aiU.setText(forumName);
            this.jnf.setText(this.mVa + " " + au.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jng.setText(this.mVb + " " + au.numberUniformFormatExtra(bVar.dIc()));
            Sd(bVar.bje());
            oZ(this.mVc.isLike());
            this.mRootView.setOnClickListener(this);
            this.itz.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void Sd(String str) {
        if (au.isEmpty(str)) {
            if (this.aiV.getVisibility() != 8) {
                this.aiV.setVisibility(8);
                if (this.aiU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.aiU.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.aiU.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.aiV.getVisibility() != 0) {
            this.aiV.setVisibility(0);
            if (this.aiU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.aiU.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.aiU.requestLayout();
            }
        }
        this.aiV.setText(str);
    }

    public void oZ(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qG(R.color.CAM_X0302);
            this.itz.setConfig(bVar);
            this.itz.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qI(R.color.CAM_X0109);
            this.itz.setConfig(bVar2);
            this.itz.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.mVc.setLike(z);
    }

    private void ctq() {
        if (this.mVc != null) {
            String forumName = this.mVc.getForumName();
            if (au.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void ctr() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mVc != null && !StringUtils.isNull(this.mVc.getForumName()) && this.mVc.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.eYI == null) {
                    this.eYI = new LikeModel(this.mTbPageContext);
                    this.eYI.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.d
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.eYI.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.eYI.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.eYI.getErrorString());
                                } else {
                                    c.this.oZ(true);
                                }
                            }
                        }
                    });
                }
                if (au.isForumName(this.mVc.getForumName())) {
                    this.isLoading = true;
                    this.eYI.dJj();
                    this.eYI.gp(this.mVc.getForumName(), String.valueOf(this.mVc.getForumId()));
                }
            }
        }
    }

    private void cts() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.mVc != null && !StringUtils.isNull(this.mVc.getForumName()) && this.mVc.getForumId() > 0 && bh.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.itB == null) {
                    this.itB = new ad();
                    this.itB.a(new ad.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                            c.this.oZ(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void D(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.itB.O(this.mVc.getForumName(), this.mVc.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.aiU, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jnf, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.jng, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.aiV, (int) R.color.CAM_X0109);
        this.itz.brT();
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar;
        if (this.mVc != null) {
            if (this.mRootView == view) {
                ctq();
                if (this.hWc != null) {
                    this.hWc.a(view, this.mVc);
                }
            } else if (this.itz == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dHL().getClassName();
                    if (!"推荐".equals(className)) {
                        arVar = new ar("c13653");
                        arVar.dR("resource_id", className);
                    } else {
                        arVar = new ar("c13644");
                        arVar.ak("obj_locate", 3);
                    }
                    arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    arVar.w("fid", this.mVc.forumId);
                    arVar.ak(TiebaInitialize.Params.OBJ_TO, this.mVc.isLike() ? 2 : 1);
                    TiebaStatic.log(arVar);
                }
                if (this.mVc.isLike()) {
                    cts();
                } else {
                    ctr();
                }
            }
        }
    }
}
