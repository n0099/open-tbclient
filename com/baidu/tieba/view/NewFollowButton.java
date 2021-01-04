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
    private TBSpecificationButtonConfig nTC;
    private TBSpecificationButtonConfig nTD;
    private com.baidu.adp.base.e nTE;
    private ae.a nTF;
    private boolean nTG;
    private int nTH;
    private boolean nTI;
    private final int nTJ;
    private boolean nTK;
    private boolean nTL;
    private com.baidu.tbadk.core.view.commonBtn.b nTM;
    private com.baidu.tbadk.core.view.commonBtn.b nTN;
    private a nTO;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nTG = true;
        this.nTH = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.iconSize = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.nTI = true;
        this.nTJ = R.drawable.icon_pure_add12_svg;
        this.nTK = false;
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
            if (this.nTD == null) {
                if (this.nTN == null) {
                    this.nTN = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nTN.ru(R.color.CAM_X0109);
                    this.nTN.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.nTN);
            } else {
                setConfig(this.nTD);
            }
            setClickable(this.nTG);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.nTC == null) {
                if (this.nTM == null) {
                    this.nTM = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.nTM.rs(R.color.CAM_X0302);
                    if (this.nTI) {
                        this.nTM.setIconSize(this.iconSize);
                        this.nTM.a(this.nTJ, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.nTM.rr(this.nTH);
                    }
                }
                setConfig(this.nTM);
            } else {
                setConfig(this.nTC);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bxO();
        this.nTL = z;
    }

    private void cAA() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nTO == null) {
                    this.nTO = new a();
                }
                if (this.jYX == null) {
                    this.jYX = new LikeModel(this.pageContext);
                    this.jYX.setLoadDataCallBack(this.nTO);
                }
                if (at.isForumName(this.forumName)) {
                    this.loading = true;
                    this.jYX.dOt();
                    this.jYX.gr(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cAB() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bg.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.nTO == null) {
                    this.nTO = new a();
                }
                if (this.jYY == null) {
                    this.jYY = new ae();
                    this.jYY.a(this.nTO);
                }
                this.loading = true;
                this.jYY.P(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nTL) {
            cAA();
        } else {
            cAB();
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
                NewFollowButton.this.aC(true, NewFollowButton.this.nTK);
                if (NewFollowButton.this.nTE != null) {
                    NewFollowButton.this.nTE.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            NewFollowButton.this.aC(false, NewFollowButton.this.nTK);
            if (NewFollowButton.this.nTF != null) {
                NewFollowButton.this.nTF.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void D(String str, long j) {
            if (NewFollowButton.this.nTF != null) {
                NewFollowButton.this.nTF.D(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
