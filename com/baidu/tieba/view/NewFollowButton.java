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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
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
    private LikeModel jYX;
    private ae jYY;
    private boolean loading;
    private TBSpecificationButtonConfig nTB;
    private TBSpecificationButtonConfig nTC;
    private com.baidu.adp.base.e nTD;
    private ae.a nTE;
    private boolean nTF;
    private int nTG;
    private boolean nTH;
    private final int nTI;
    private boolean nTJ;
    private boolean nTK;
    private com.baidu.tbadk.core.view.commonBtn.b nTL;
    private com.baidu.tbadk.core.view.commonBtn.b nTM;
    private a nTN;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nTF = true;
        this.nTG = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.iconSize = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nTH = true;
        this.nTI = R.drawable.icon_pure_add12_svg;
        this.nTJ = false;
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
            if (this.nTC == null) {
                if (this.nTM == null) {
                    this.nTM = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nTM.ru(R.color.CAM_X0109);
                    this.nTM.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nTM);
            } else {
                setConfig(this.nTC);
            }
            setClickable(this.nTF);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nTB == null) {
                if (this.nTL == null) {
                    this.nTL = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nTL.rs(R.color.CAM_X0302);
                    if (this.nTH) {
                        this.nTL.setIconSize(this.iconSize);
                        this.nTL.a(this.nTI, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nTL.rr(this.nTG);
                    }
                }
                setConfig(this.nTL);
            } else {
                setConfig(this.nTB);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bxP();
        this.nTK = z;
    }

    private void cAB() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nTN == null) {
                    this.nTN = new a();
                }
                if (this.jYX == null) {
                    this.jYX = new LikeModel(this.pageContext);
                    this.jYX.setLoadDataCallBack(this.nTN);
                }
                if (at.isForumName(this.forumName)) {
                    this.loading = true;
                    this.jYX.dOu();
                    this.jYX.gr(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cAC() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nTN == null) {
                    this.nTN = new a();
                }
                if (this.jYY == null) {
                    this.jYY = new ae();
                    this.jYY.a(this.nTN);
                }
                this.loading = true;
                this.jYY.P(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nTK) {
            cAB();
        } else {
            cAC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.base.e implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (NewFollowButton.this.jYX.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.jYX.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.jYX.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aC(true, NewFollowButton.this.nTJ);
                if (NewFollowButton.this.nTD != null) {
                    NewFollowButton.this.nTD.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            NewFollowButton.this.aC(false, NewFollowButton.this.nTJ);
            if (NewFollowButton.this.nTE != null) {
                NewFollowButton.this.nTE.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            if (NewFollowButton.this.nTE != null) {
                NewFollowButton.this.nTE.D(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
