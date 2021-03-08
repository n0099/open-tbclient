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
    private LikeModel kej;
    private ae kek;
    private boolean loading;
    private TBSpecificationButtonConfig obH;
    private TBSpecificationButtonConfig obI;
    private com.baidu.adp.base.e obJ;
    private ae.a obK;
    private boolean obL;
    private int obM;
    private boolean obN;
    private final int obO;
    private boolean obP;
    private boolean obQ;
    private com.baidu.tbadk.core.view.commonBtn.b obR;
    private com.baidu.tbadk.core.view.commonBtn.b obS;
    private a obT;
    private TbPageContext<?> pageContext;

    public NewFollowButton(Context context) {
        this(context, null, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewFollowButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.obL = true;
        this.obM = UtilHelper.getDimenPixelSize(R.dimen.tbds4);
        this.iconSize = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
        this.obN = true;
        this.obO = R.drawable.icon_pure_add12_svg;
        this.obP = false;
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
            if (this.obI == null) {
                if (this.obS == null) {
                    this.obS = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.obS.pU(R.color.CAM_X0109);
                    this.obS.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                }
                setConfig(this.obS);
            } else {
                setConfig(this.obI);
            }
            setClickable(this.obL);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            if (this.obH == null) {
                if (this.obR == null) {
                    this.obR = new com.baidu.tbadk.core.view.commonBtn.b();
                    this.obR.pS(R.color.CAM_X0302);
                    if (this.obN) {
                        this.obR.setIconSize(this.iconSize);
                        this.obR.a(this.obO, 0, TBSpecificationButtonConfig.IconType.SVG);
                        this.obR.pR(this.obM);
                    }
                }
                setConfig(this.obR);
            } else {
                setConfig(this.obH);
            }
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        bus();
        this.obQ = z;
    }

    private void cyi() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.obT == null) {
                    this.obT = new a();
                }
                if (this.kej == null) {
                    this.kej = new LikeModel(this.pageContext);
                    this.kej.setLoadDataCallBack(this.obT);
                }
                if (au.isForumName(this.forumName)) {
                    this.loading = true;
                    this.kej.dNd();
                    this.kej.gy(this.forumName, String.valueOf(this.forumId));
                }
            }
        }
    }

    private void cyj() {
        if (!this.loading && this.pageContext != null) {
            if (!l.isNetOk()) {
                UtilHelper.showToast(this.pageContext.getPageActivity(), this.pageContext.getString(R.string.neterror));
            } else if (!StringUtils.isNull(this.forumName) && this.forumId > 0 && bh.checkUpIsLogin(this.pageContext.getPageActivity())) {
                if (this.obT == null) {
                    this.obT = new a();
                }
                if (this.kek == null) {
                    this.kek = new ae();
                    this.kek.a(this.obT);
                }
                this.loading = true;
                this.kek.O(this.forumName, this.forumId);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.obQ) {
            cyi();
        } else {
            cyj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends com.baidu.adp.base.e implements ae.a {
        private a() {
        }

        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (NewFollowButton.this.kej.getErrorCode() == 22) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.pageContext.getString(R.string.had_liked_forum));
                NewFollowButton.this.loading = false;
            } else if (obj == null) {
                NewFollowButton.this.loading = false;
            } else if (NewFollowButton.this.kej.getErrorCode() != 0) {
                l.showToast(NewFollowButton.this.pageContext.getPageActivity(), NewFollowButton.this.kej.getErrorString());
                NewFollowButton.this.loading = false;
            } else {
                NewFollowButton.this.aC(true, NewFollowButton.this.obP);
                if (NewFollowButton.this.obJ != null) {
                    NewFollowButton.this.obJ.callback(obj);
                }
                NewFollowButton.this.loading = false;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void B(String str, long j) {
            NewFollowButton.this.aC(false, NewFollowButton.this.obP);
            if (NewFollowButton.this.obK != null) {
                NewFollowButton.this.obK.B(str, j);
            }
            NewFollowButton.this.loading = false;
        }

        @Override // com.baidu.tieba.tbadkCore.ae.a
        public void C(String str, long j) {
            if (NewFollowButton.this.obK != null) {
                NewFollowButton.this.obK.C(str, j);
            }
            NewFollowButton.this.loading = false;
        }
    }
}
