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
    private long cvw;
    private e fkC;
    private long fkD;
    private View fkE;
    private View fkF;
    private ImageView fkH;
    private int fkI;
    private View fkJ;
    private View.OnClickListener mClickListener;
    private boolean fkG = false;
    private Runnable fkK = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fkG && !d.this.fkC.auC()) {
                Rect rect = new Rect();
                d.this.fkE.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fkC.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fkC.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.fkC.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fkC.getWidth(), d.this.fkC.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fkJ.setX(0.0f);
                d.this.fkJ.setY(0.0f);
                d.this.fkJ.setLayoutParams(layoutParams2);
                d.this.fkJ.invalidate();
                d.this.fkC.setVisibility(0);
                d.this.fkC.aYA();
                d.this.fkD = System.currentTimeMillis();
            }
        }
    };
    private Runnable fkL = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aYz();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fkM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fkI == 2 && !d.this.fkC.auC()) {
                d.this.mHandler.removeCallbacks(d.this.fkL);
                d.this.mHandler.postDelayed(d.this.fkL, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fkC = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fkC, layoutParams);
        this.fkC.setClickable(true);
        this.fkH = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fkH.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fkH, layoutParams2);
        this.fkH.setBackgroundResource(d.C0082d.black_alpha60);
        this.fkH.setVisibility(8);
        this.fkJ = new View(context);
        frameLayout.addView(this.fkJ, new FrameLayout.LayoutParams(l.f(context, d.e.ds112), l.f(context, d.e.ds112)));
        this.fkJ.setVisibility(8);
        this.fkJ.setClickable(true);
    }

    public void pP(int i) {
        this.fkI = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fkC != null && d.this.fkC.getVisibility() == 0) {
                        d.this.fkC.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fkJ.setOnTouchListener(onTouchListener);
        this.fkH.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.fkE = view;
    }

    public void bp(View view) {
        this.fkF = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.fkE == null || this.fkF == null) {
            return false;
        }
        if (this.fkH.getVisibility() != 0) {
            this.fkF.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cvw = System.currentTimeMillis();
                    if (view == this.fkJ) {
                        this.fkG = true;
                    } else {
                        this.fkC.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fkF.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fkG = true;
                        } else {
                            this.fkG = false;
                        }
                    }
                    if (this.fkG) {
                        this.mHandler.postDelayed(this.fkK, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cvw <= 300 && motionEvent.getRawY() < iArr[1] + this.fkE.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fkK);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.fkE);
                            return true;
                        }
                        return true;
                    } else if (this.fkG || this.fkC.auC()) {
                        if (this.fkC.auC()) {
                            this.fkC.getLocationOnScreen(new int[2]);
                            int bx = this.fkC.bx((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fkC.aYA();
                            if (bx != -1) {
                                if (bx == 1) {
                                    qu(1);
                                    i = 1;
                                } else if (bx != 3) {
                                    if (bx == 4) {
                                        i = 4;
                                        qu(4);
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
                                    d.this.aYz();
                                    d.this.fkC.aYC();
                                    d.this.fkC.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fkG = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fkG) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cvw > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fkK);
                                return true;
                            }
                            if (!this.fkC.auC()) {
                                this.fkK.run();
                            }
                            if (currentTimeMillis - this.fkD > 800) {
                                this.fkC.getLocationOnScreen(new int[2]);
                                this.fkC.bw((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void qu(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.fkH.setVisibility(0);
                    if (i == 1) {
                        d.this.fkH.setPadding(0, 0, 0, l.f(d.this.fkH.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.fkH.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.fkH.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.fkH, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void uq() {
                            d.this.fkH.setVisibility(8);
                            if (d.this.fkH.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.fkH.getTag()).stop();
                            }
                            d.this.fkH.setTag(null);
                        }
                    });
                    d.this.fkH.setTag(a);
                    a.b(d.this.fkH);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fkC != null && this.fkE != null) {
            if (z) {
                Rect rect = new Rect();
                this.fkE.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.fkE.getViewTreeObserver().addOnGlobalLayoutListener(this.fkM);
                    this.fkJ.setVisibility(0);
                    aYz();
                    return;
                }
                this.fkE.getViewTreeObserver().removeGlobalOnLayoutListener(this.fkM);
                this.fkJ.setVisibility(8);
                return;
            }
            this.fkE.getViewTreeObserver().removeGlobalOnLayoutListener(this.fkM);
            this.fkJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYz() {
        if (!this.fkC.auC()) {
            int[] iArr = new int[2];
            this.fkF.getLocationOnScreen(iArr);
            this.fkJ.setLayoutParams(new FrameLayout.LayoutParams(this.fkF.getWidth(), this.fkF.getHeight()));
            this.fkJ.setX(iArr[0]);
            this.fkJ.setY(iArr[1]);
            this.fkJ.invalidate();
        }
    }
}
