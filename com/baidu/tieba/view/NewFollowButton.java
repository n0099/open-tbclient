package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.tbadkCore.ae;
/* loaded from: classes.dex */
public class NewFollowButton extends TBSpecificationBtn implements View.OnClickListener {
    private Animation animation;
    private int animationId;
    private long forumId;
    private String forumName;
    private int iconSize;
    private LikeModel kch;
    private ae kci;
    private boolean loading;
    private TBSpecificationButtonConfig nZB;
    private TBSpecificationButtonConfig nZC;
    private com.baidu.adp.base.e nZD;
    private ae.a nZE;
    private boolean nZF;
    private int nZG;
    private boolean nZH;
    private final int nZI;
    private boolean nZJ;
    private boolean nZK;
    private com.baidu.tbadk.core.view.commonBtn.b nZL;
    private com.baidu.tbadk.core.view.commonBtn.b nZM;
    private a nZN;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZF = true;
        this.nZG = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.iconSize = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nZH = true;
        this.nZI = R.drawable.icon_pure_add12_svg;
        this.nZJ = false;
        this.loading = false;
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(final boolean z, boolean z2) {
        if (z2 && this.animationId != 0 && this.animation == null) {
            this.animation = AnimationUtils.loadAnimation(this.pageContext.getPageActivity(), this.animationId);
            this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.view.NewFollowButton.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    NewFollowButton.this.aM(z);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        if (z2 && this.animation != null) {
            startAnimation(this.animation);
        } else {
            aM(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(boolean z) {
        if (z) {
            if (this.nZC == null) {
                if (this.nZM == null) {
                    this.nZM = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nZM.pT(R.color.CAM_X0109);
                    this.nZM.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nZM);
            } else {
                setConfig(this.nZC);
            }
            setClickable(this.nZF);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nZB == null) {
                if (this.nZL == null) {
                    this.nZL = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nZL.pR(R.color.CAM_X0302);
                    if (this.nZH) {
                        this.nZL.setIconSize(this.iconSize);
                        this.nZL.a(this.nZI, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nZL.pQ(this.nZG);
                    }
                }
                setConfig(this.nZL);
            } else {
                setConfig(this.nZB);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bup();
        this.nZK = z;
    }

    private void cyc() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nZN == null) {
                    this.nZN = new a();
                }
                if (this.kch == null) {
                    this.kch = new LikeModel(this.pageContext);
                    this.kch.setLoadDataCallBack(this.nZN);
                }
                if (au.isForumName(this.forumName)) {
                    this.loading = true;
                    this.kch.dMV();
                    this.kch.gy(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cyd() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nZN == null) {
                    this.nZN = new a();
                }
                if (this.kci == null) {
                    this.kci = new ae();
                    this.kci.a(this.nZN);
                }
                this.loading = true;
                this.kci.O(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nZK) {
            cyc();
        } else {
            cyd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.base.e implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (NewFollowButton.this.kch.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.kch.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.kch.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aC(true, NewFollowButton.this.nZJ);
                if (NewFollowButton.this.nZD != null) {
                    NewFollowButton.this.nZD.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            NewFollowButton.this.aC(false, NewFollowButton.this.nZJ);
            if (NewFollowButton.this.nZE != null) {
                NewFollowButton.this.nZE.B(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            if (NewFollowButton.this.nZE != null) {
                NewFollowButton.this.nZE.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
