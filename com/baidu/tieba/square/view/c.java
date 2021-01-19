package com.baidu.tieba.square.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.square.data.b> {
    private BarImageView ajC;
    private TextView ajE;
    private TextView ajF;
    private LikeModel fle;
    private TBSpecificationBtn iLY;
    private ae iMa;
    private boolean isLoading;
    private TextView jIC;
    private TextView jID;
    private View mRootView;
    private String nka;
    private String nkb;
    private com.baidu.tieba.square.data.b nkc;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isLoading = false;
        this.nka = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.nkb = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View view = getView();
        this.mRootView = view;
        this.ajC = (BarImageView) view.findViewById(R.id.bar_image);
        this.ajE = (TextView) view.findViewById(R.id.bar_name);
        this.ajF = (TextView) view.findViewById(R.id.desc);
        this.jIC = (TextView) view.findViewById(R.id.member_text);
        this.jID = (TextView) view.findViewById(R.id.post_text);
        this.iLY = (TBSpecificationBtn) view.findViewById(R.id.forum_like_button);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.square.data.b bVar) {
        if (bVar != null) {
            this.nkc = bVar;
            this.ajC.setShowOval(true);
            this.ajC.setShowOuterBorder(false);
            this.ajC.setShowInnerBorder(true);
            this.ajC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.ajC.setStrokeColorResId(R.color.CAM_X0401);
            this.ajC.startLoad(bVar.getAvatar(), 10, false);
            String forumName = bVar.getForumName();
            if (at.isEmpty(forumName)) {
                forumName = "";
            }
            this.ajE.setText(forumName);
            this.jIC.setText(this.nka + " " + at.numberUniformFormatExtra(bVar.getMemberCount()));
            this.jID.setText(this.nkb + " " + at.numberUniformFormatExtra(bVar.dJu()));
            RS(bVar.bkW());
            pO(this.nkc.isLike());
            this.mRootView.setOnClickListener(this);
            this.iLY.setOnClickListener(this);
            onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void RS(String str) {
        if (at.isEmpty(str)) {
            if (this.ajF.getVisibility() != 8) {
                this.ajF.setVisibility(8);
                if (this.ajE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.ajE.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds47);
                    this.ajE.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.ajF.getVisibility() != 0) {
            this.ajF.setVisibility(0);
            if (this.ajE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.ajE.getLayoutParams()).topMargin = l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds24);
                this.ajE.requestLayout();
            }
        }
        this.ajF.setText(str);
    }

    public void pO(boolean z) {
        if (!z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pM(R.color.CAM_X0302);
            this.iLY.setConfig(bVar);
            this.iLY.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pO(R.color.CAM_X0109);
            this.iLY.setConfig(bVar2);
            this.iLY.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.nkc.setLike(z);
    }

    private void cwI() {
        if (this.nkc != null) {
            String forumName = this.nkc.getForumName();
            if (at.isForumName(forumName)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    private void cwJ() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.nkc != null && !StringUtils.isNull(this.nkc.getForumName()) && this.nkc.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.fle == null) {
                    this.fle = new LikeModel(this.mTbPageContext);
                    this.fle.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.square.view.c.1
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            c.this.isLoading = false;
                            if (c.this.fle.getErrorCode() == 22) {
                                l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.mTbPageContext.getString(R.string.had_liked_forum));
                            } else if (obj != null) {
                                if (c.this.fle.getErrorCode() != 0) {
                                    l.showToast(c.this.mTbPageContext.getPageActivity(), c.this.fle.getErrorString());
                                } else {
                                    c.this.pO(true);
                                }
                            }
                        }
                    });
                }
                if (at.isForumName(this.nkc.getForumName())) {
                    this.isLoading = true;
                    this.fle.dKC();
                    this.fle.gq(this.nkc.getForumName(), String.valueOf(this.nkc.getForumId()));
                }
            }
        }
    }

    private void cwK() {
        if (!this.isLoading) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.mTbPageContext.getPageActivity(), this.mTbPageContext.getString(R.string.neterror));
            } else if (this.nkc != null && !StringUtils.isNull(this.nkc.getForumName()) && this.nkc.getForumId() > 0 && bg.checkUpIsLogin(this.mTbPageContext.getPageActivity())) {
                if (this.iMa == null) {
                    this.iMa = new ae();
                    this.iMa.a(new ae.a() { // from class: com.baidu.tieba.square.view.c.2
                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void C(String str, long j) {
                            c.this.isLoading = false;
                            c.this.pO(false);
                        }

                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void D(String str, long j) {
                            c.this.isLoading = false;
                        }
                    });
                }
                this.isLoading = true;
                this.iMa.P(this.nkc.getForumName(), this.nkc.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.ajE, R.color.CAM_X0105);
        ao.setViewTextColor(this.jIC, R.color.CAM_X0109);
        ao.setViewTextColor(this.jID, R.color.CAM_X0109);
        ao.setViewTextColor(this.ajF, R.color.CAM_X0109);
        this.iLY.btV();
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.square_forum_item_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq aqVar;
        if (this.nkc != null) {
            if (this.mRootView == view) {
                cwI();
                if (this.ioP != null) {
                    this.ioP.a(view, this.nkc);
                }
            } else if (this.iLY == view) {
                if (this.mTbPageContext.getPageActivity() instanceof ForumSquareActivity) {
                    String className = ((ForumSquareActivity) this.mTbPageContext.getPageActivity()).dJd().getClassName();
                    if (!"推荐".equals(className)) {
                        aqVar = new aq("c13653");
                        aqVar.dW("resource_id", className);
                    } else {
                        aqVar = new aq("c13644");
                        aqVar.an("obj_locate", 3);
                    }
                    aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                    aqVar.w("fid", this.nkc.forumId);
                    aqVar.an(TiebaInitialize.Params.OBJ_TO, this.nkc.isLike() ? 2 : 1);
                    TiebaStatic.log(aqVar);
                }
                if (this.nkc.isLike()) {
                    cwK();
                } else {
                    cwJ();
                }
            }
        }
    }
}
