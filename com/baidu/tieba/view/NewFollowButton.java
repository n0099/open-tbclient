package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
/* loaded from: classes20.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    private Animation animation;
    private int eYr;
    private long forumId;
    private String forumName;
    private LikeModel jyf;
    private ad jyg;
    private boolean loading;
    private TBSpecificationButtonConfig nCc;
    private TBSpecificationButtonConfig nCd;
    private com.baidu.adp.base.d nCe;
    private ad.a nCf;
    private boolean nCg;
    private int nCh;
    private boolean nCi;
    private final int nCj;
    private boolean nCk;
    private int nCl;
    private boolean nCm;
    private com.baidu.tbadk.core.view.commonBtn.b nCn;
    private com.baidu.tbadk.core.view.commonBtn.b nCo;
    private a nCp;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCg = true;
        this.nCh = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.eYr = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nCi = true;
        this.nCj = R.drawable.icon_pure_add12_svg;
        this.nCk = false;
        this.loading = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(final boolean z, boolean z2) {
        if (z2 && this.nCl != 0 && this.animation == null) {
            this.animation = AnimationUtils.loadAnimation(this.pageContext.getPageActivity(), this.nCl);
            this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NewFollowButton.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    NewFollowButton.this.aP(z);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (z2 && this.animation != null) {
            startAnimation(this.animation);
        } else {
            aP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        if (z) {
            if (this.nCd == null) {
                if (this.nCo == null) {
                    this.nCo = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nCo.qI(R.color.CAM_X0109);
                    this.nCo.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nCo);
            } else {
                setConfig(this.nCd);
            }
            setClickable(this.nCg);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nCc == null) {
                if (this.nCn == null) {
                    this.nCn = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nCn.qG(R.color.CAM_X0302);
                    if (this.nCi) {
                        this.nCn.qB(this.eYr);
                        this.nCn.a(this.nCj, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nCn.qF(this.nCh);
                    }
                }
                setConfig(this.nCn);
            } else {
                setConfig(this.nCc);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        brT();
        this.nCm = z;
    }

    private void ctr() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nCp == null) {
                    this.nCp = new a();
                }
                if (this.jyf == null) {
                    this.jyf = new LikeModel(this.pageContext);
                    this.jyf.setLoadDataCallBack(this.nCp);
                }
                if (au.isForumName(this.forumName)) {
                    this.loading = true;
                    this.jyf.dJj();
                    this.jyf.gp(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cts() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nCp == null) {
                    this.nCp = new a();
                }
                if (this.jyg == null) {
                    this.jyg = new ad();
                    this.jyg.a(this.nCp);
                }
                this.loading = true;
                this.jyg.O(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nCm) {
            ctr();
        } else {
            cts();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends com.baidu.adp.base.d implements ad.a {
        private a() {
        }

        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (NewFollowButton.this.jyf.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.jyf.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.jyf.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aA(true, NewFollowButton.this.nCk);
                if (NewFollowButton.this.nCe != null) {
                    NewFollowButton.this.nCe.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void C(String str, long j) {
            NewFollowButton.this.aA(false, NewFollowButton.this.nCk);
            if (NewFollowButton.this.nCf != null) {
                NewFollowButton.this.nCf.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ad.a
        public void D(String str, long j) {
            if (NewFollowButton.this.nCf != null) {
                NewFollowButton.this.nCf.D(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
