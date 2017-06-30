package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l {
    private View.OnClickListener bkk;
    private long eLK;
    private t eLL;
    private long eLM;
    private View eLN;
    private ImageView eLP;
    private int eLQ;
    private View eLR;
    private boolean eLO = false;
    private Runnable eLS = new m(this);
    private Runnable eLT = new n(this);
    private ViewTreeObserver.OnGlobalLayoutListener eLU = new o(this);
    private Handler mHandler = new Handler();

    public l(Context context, FrameLayout frameLayout) {
        this.eLL = new t(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.eLL, layoutParams);
        this.eLL.setClickable(true);
        this.eLP = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.eLP.setLayoutParams(layoutParams2);
        frameLayout.addView(this.eLP, layoutParams2);
        this.eLP.setBackgroundResource(w.e.black_alpha60);
        this.eLP.setVisibility(8);
        this.eLR = new View(context);
        frameLayout.addView(this.eLR, new FrameLayout.LayoutParams(com.baidu.adp.lib.util.k.g(context, w.f.ds112), com.baidu.adp.lib.util.k.g(context, w.f.ds112)));
        this.eLR.setVisibility(8);
        this.eLR.setClickable(true);
    }

    public void oM(int i) {
        this.eLQ = i;
        if (i == 2) {
            this.mHandler.postDelayed(new p(this), 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bkk = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eLR.setOnTouchListener(onTouchListener);
        this.eLP.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.eLN = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.eLN == null) {
            return false;
        }
        if (this.eLP.getVisibility() != 0) {
            this.eLN.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.eLK = System.currentTimeMillis();
                    if (view == this.eLR) {
                        this.eLO = true;
                    } else {
                        this.eLL.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.eLN.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.eLO = true;
                        } else {
                            this.eLO = false;
                        }
                    }
                    if (this.eLO) {
                        this.mHandler.postDelayed(this.eLS, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.eLK <= 300 && motionEvent.getRawY() < iArr[1] + this.eLN.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.eLS);
                        if (this.bkk != null) {
                            this.bkk.onClick(this.eLN);
                            return true;
                        }
                        return true;
                    } else if (this.eLO || this.eLL.anx()) {
                        if (this.eLL.anx()) {
                            this.eLL.getLocationOnScreen(new int[2]);
                            int bf = this.eLL.bf((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.eLL.aTg();
                            if (bf != -1) {
                                if (bf == 1) {
                                    pw(1);
                                    i = 1;
                                } else if (bf != 3) {
                                    if (bf == 4) {
                                        i = 4;
                                        pw(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                au auVar = new au("c12182");
                                auVar.r("obj_id", i);
                                TiebaStatic.log(auVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new q(this), 700L);
                        }
                        this.eLO = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.eLO) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.eLK > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.eLS);
                                return true;
                            }
                            if (!this.eLL.anx()) {
                                this.eLS.run();
                            }
                            if (currentTimeMillis - this.eLM > 800) {
                                this.eLL.getLocationOnScreen(new int[2]);
                                this.eLL.be((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return false;
                default:
                    return true;
            }
        }
        return true;
    }

    private void pw(int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new r(this, i), 200L);
        }
    }

    public void cd(boolean z) {
        if (this.eLL != null && this.eLN != null) {
            if (z) {
                Rect rect = new Rect();
                this.eLN.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.eLN.getViewTreeObserver().addOnGlobalLayoutListener(this.eLU);
                    this.eLR.setVisibility(0);
                    return;
                }
                this.eLN.getViewTreeObserver().removeGlobalOnLayoutListener(this.eLU);
                this.eLR.setVisibility(8);
                return;
            }
            this.eLN.getViewTreeObserver().removeGlobalOnLayoutListener(this.eLU);
            this.eLR.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTf() {
        if (!this.eLL.anx()) {
            int[] iArr = new int[2];
            this.eLN.getLocationOnScreen(iArr);
            this.eLR.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.k.g(this.eLR.getContext(), w.f.ds112), com.baidu.adp.lib.util.k.g(this.eLR.getContext(), w.f.ds112)));
            this.eLR.setX(iArr[0]);
            this.eLR.setY(iArr[1]);
            this.eLR.invalidate();
        }
    }
}
