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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private long cvF;
    private e flA;
    private long flB;
    private View flC;
    private View flD;
    private ImageView flF;
    private int flG;
    private View flH;
    private View.OnClickListener mClickListener;
    private boolean flE = false;
    private Runnable flI = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.flE && !d.this.flA.auL()) {
                Rect rect = new Rect();
                d.this.flC.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.flA.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.flA.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.flA.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.flA.getWidth(), d.this.flA.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.flH.setX(0.0f);
                d.this.flH.setY(0.0f);
                d.this.flH.setLayoutParams(layoutParams2);
                d.this.flH.invalidate();
                d.this.flA.setVisibility(0);
                d.this.flA.aYI();
                d.this.flB = System.currentTimeMillis();
            }
        }
    };
    private Runnable flJ = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aYH();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener flK = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.flG == 2 && !d.this.flA.auL()) {
                d.this.mHandler.removeCallbacks(d.this.flJ);
                d.this.mHandler.postDelayed(d.this.flJ, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.flA = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.flA, layoutParams);
        this.flA.setClickable(true);
        this.flF = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.flF.setLayoutParams(layoutParams2);
        frameLayout.addView(this.flF, layoutParams2);
        this.flF.setBackgroundResource(d.C0096d.black_alpha60);
        this.flF.setVisibility(8);
        this.flH = new View(context);
        frameLayout.addView(this.flH, new FrameLayout.LayoutParams(l.f(context, d.e.ds112), l.f(context, d.e.ds112)));
        this.flH.setVisibility(8);
        this.flH.setClickable(true);
    }

    public void pW(int i) {
        this.flG = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.flA != null && d.this.flA.getVisibility() == 0) {
                        d.this.flA.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.flH.setOnTouchListener(onTouchListener);
        this.flF.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.flC = view;
    }

    public void bs(View view) {
        this.flD = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.flC == null || this.flD == null) {
            return false;
        }
        if (this.flF.getVisibility() != 0) {
            this.flD.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cvF = System.currentTimeMillis();
                    if (view == this.flH) {
                        this.flE = true;
                    } else {
                        this.flA.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.flD.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.flE = true;
                        } else {
                            this.flE = false;
                        }
                    }
                    if (this.flE) {
                        this.mHandler.postDelayed(this.flI, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cvF <= 300 && motionEvent.getRawY() < iArr[1] + this.flC.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.flI);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.flC);
                            return true;
                        }
                        return true;
                    } else if (this.flE || this.flA.auL()) {
                        if (this.flA.auL()) {
                            this.flA.getLocationOnScreen(new int[2]);
                            int by = this.flA.by((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.flA.aYI();
                            if (by != -1) {
                                if (by == 1) {
                                    qB(1);
                                    i = 1;
                                } else if (by != 3) {
                                    if (by == 4) {
                                        i = 4;
                                        qB(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                ak akVar = new ak("c12182");
                                akVar.r("obj_id", i);
                                TiebaStatic.log(akVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.aYH();
                                    d.this.flA.aYK();
                                    d.this.flA.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.flE = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.flE) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cvF > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.flI);
                                return true;
                            }
                            if (!this.flA.auL()) {
                                this.flI.run();
                            }
                            if (currentTimeMillis - this.flB > 800) {
                                this.flA.getLocationOnScreen(new int[2]);
                                this.flA.bx((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void qB(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.flF.setVisibility(0);
                    if (i == 1) {
                        d.this.flF.setPadding(0, 0, 0, l.f(d.this.flF.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.flF.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.flF.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.flF, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void un() {
                            d.this.flF.setVisibility(8);
                            if (d.this.flF.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.flF.getTag()).stop();
                            }
                            d.this.flF.setTag(null);
                        }
                    });
                    d.this.flF.setTag(a);
                    a.b(d.this.flF);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.flA != null && this.flC != null) {
            if (z) {
                Rect rect = new Rect();
                this.flC.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.flC.getViewTreeObserver().addOnGlobalLayoutListener(this.flK);
                    this.flH.setVisibility(0);
                    aYH();
                    return;
                }
                this.flC.getViewTreeObserver().removeGlobalOnLayoutListener(this.flK);
                this.flH.setVisibility(8);
                return;
            }
            this.flC.getViewTreeObserver().removeGlobalOnLayoutListener(this.flK);
            this.flH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYH() {
        if (!this.flA.auL()) {
            int[] iArr = new int[2];
            this.flD.getLocationOnScreen(iArr);
            this.flH.setLayoutParams(new FrameLayout.LayoutParams(this.flD.getWidth(), this.flD.getHeight()));
            this.flH.setX(iArr[0]);
            this.flH.setY(iArr[1]);
            this.flH.invalidate();
        }
    }
}
