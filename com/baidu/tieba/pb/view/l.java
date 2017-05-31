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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l {
    private View.OnClickListener bhc;
    private long eCn;
    private t eCo;
    private long eCp;
    private View eCq;
    private ImageView eCs;
    private int eCt;
    private View eCu;
    private boolean eCr = false;
    private Runnable eCv = new m(this);
    private Runnable eCw = new n(this);
    private ViewTreeObserver.OnGlobalLayoutListener eCx = new o(this);
    private Handler mHandler = new Handler();

    public l(Context context, FrameLayout frameLayout) {
        this.eCo = new t(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.eCo, layoutParams);
        this.eCo.setClickable(true);
        this.eCs = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.eCs.setLayoutParams(layoutParams2);
        frameLayout.addView(this.eCs, layoutParams2);
        this.eCs.setBackgroundResource(w.e.black_alpha60);
        this.eCs.setVisibility(8);
        this.eCu = new View(context);
        frameLayout.addView(this.eCu, new FrameLayout.LayoutParams(com.baidu.adp.lib.util.k.g(context, w.f.ds112), com.baidu.adp.lib.util.k.g(context, w.f.ds112)));
        this.eCu.setVisibility(8);
        this.eCu.setClickable(true);
    }

    public void ov(int i) {
        this.eCt = i;
        if (i == 2) {
            this.mHandler.postDelayed(new p(this), 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bhc = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eCu.setOnTouchListener(onTouchListener);
        this.eCs.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.eCq = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.eCq == null) {
            return false;
        }
        if (this.eCs.getVisibility() != 0) {
            this.eCq.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.eCn = System.currentTimeMillis();
                    if (view == this.eCu) {
                        this.eCr = true;
                    } else {
                        this.eCo.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.eCq.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.eCr = true;
                        } else {
                            this.eCr = false;
                        }
                    }
                    if (this.eCr) {
                        this.mHandler.postDelayed(this.eCv, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.eCn <= 300 && motionEvent.getRawY() < iArr[1] + this.eCq.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.eCv);
                        if (this.bhc != null) {
                            this.bhc.onClick(this.eCq);
                            return true;
                        }
                        return true;
                    } else if (this.eCr || this.eCo.ajM()) {
                        if (this.eCo.ajM()) {
                            this.eCo.getLocationOnScreen(new int[2]);
                            int aW = this.eCo.aW((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.eCo.aPh();
                            if (aW != -1) {
                                if (aW == 1) {
                                    pd(1);
                                    i = 1;
                                } else if (aW != 3) {
                                    if (aW == 4) {
                                        i = 4;
                                        pd(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                as asVar = new as("c12182");
                                asVar.r("obj_id", i);
                                TiebaStatic.log(asVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new q(this), 700L);
                        }
                        this.eCr = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.eCr) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.eCn > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.eCv);
                                return true;
                            }
                            if (!this.eCo.ajM()) {
                                this.eCv.run();
                            }
                            if (currentTimeMillis - this.eCp > 800) {
                                this.eCo.getLocationOnScreen(new int[2]);
                                this.eCo.aV((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pd(int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new r(this, i), 200L);
        }
    }

    public void cb(boolean z) {
        if (this.eCo != null && this.eCq != null) {
            if (z) {
                Rect rect = new Rect();
                this.eCq.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.eCq.getViewTreeObserver().addOnGlobalLayoutListener(this.eCx);
                    this.eCu.setVisibility(0);
                    return;
                }
                this.eCq.getViewTreeObserver().removeGlobalOnLayoutListener(this.eCx);
                this.eCu.setVisibility(8);
                return;
            }
            this.eCq.getViewTreeObserver().removeGlobalOnLayoutListener(this.eCx);
            this.eCu.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPg() {
        if (!this.eCo.ajM()) {
            int[] iArr = new int[2];
            this.eCq.getLocationOnScreen(iArr);
            this.eCu.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.k.g(this.eCu.getContext(), w.f.ds112), com.baidu.adp.lib.util.k.g(this.eCu.getContext(), w.f.ds112)));
            this.eCu.setX(iArr[0]);
            this.eCu.setY(iArr[1]);
            this.eCu.invalidate();
        }
    }
}
