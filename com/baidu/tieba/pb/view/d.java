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
/* loaded from: classes2.dex */
public class d {
    private long dkf;
    private e fYB;
    private long fYC;
    private View fYD;
    private ImageView fYF;
    private int fYG;
    private View fYH;
    private View.OnClickListener mClickListener;
    private View oa;
    private boolean fYE = false;
    private Runnable fYI = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fYE && !d.this.fYB.arz()) {
                Rect rect = new Rect();
                d.this.oa.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fYB.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.s(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fYB.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.fYB.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fYB.getWidth(), d.this.fYB.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fYH.setX(0.0f);
                d.this.fYH.setY(0.0f);
                d.this.fYH.setLayoutParams(layoutParams2);
                d.this.fYH.invalidate();
                d.this.fYB.setVisibility(0);
                d.this.fYB.bfY();
                d.this.fYC = System.currentTimeMillis();
            }
        }
    };
    private Runnable fYJ = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bfX();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fYK = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fYG == 2 && !d.this.fYB.arz()) {
                d.this.mHandler.removeCallbacks(d.this.fYJ);
                d.this.mHandler.postDelayed(d.this.fYJ, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fYB = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fYB, layoutParams);
        this.fYB.setClickable(true);
        this.fYF = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fYF.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fYF, layoutParams2);
        this.fYF.setBackgroundResource(d.C0108d.black_alpha60);
        this.fYF.setVisibility(8);
        this.fYH = new View(context);
        frameLayout.addView(this.fYH, new FrameLayout.LayoutParams(l.s(context, d.e.ds112), l.s(context, d.e.ds112)));
        this.fYH.setVisibility(8);
        this.fYH.setClickable(true);
    }

    public void sQ(int i) {
        this.fYG = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fYB != null && d.this.fYB.getVisibility() == 0) {
                        d.this.fYB.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fYH.setOnTouchListener(onTouchListener);
        this.fYF.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void cE(View view) {
        this.fYD = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.oa == null || this.fYD == null) {
            return false;
        }
        if (this.fYF.getVisibility() != 0) {
            this.fYD.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.dkf = System.currentTimeMillis();
                    if (view == this.fYH) {
                        this.fYE = true;
                    } else {
                        this.fYB.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fYD.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fYE = true;
                        } else {
                            this.fYE = false;
                        }
                    }
                    if (this.fYE) {
                        this.mHandler.postDelayed(this.fYI, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.dkf <= 300 && motionEvent.getRawY() < iArr[1] + this.oa.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fYI);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.oa);
                            return true;
                        }
                        return true;
                    } else if (this.fYE || this.fYB.arz()) {
                        if (this.fYB.arz()) {
                            this.fYB.getLocationOnScreen(new int[2]);
                            int cw = this.fYB.cw((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fYB.bfY();
                            if (cw != -1) {
                                if (cw == 1) {
                                    tv(1);
                                    i = 1;
                                } else if (cw != 3) {
                                    if (cw == 4) {
                                        i = 4;
                                        tv(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                ak akVar = new ak("c12182");
                                akVar.s("obj_id", i);
                                TiebaStatic.log(akVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.bfX();
                                    d.this.fYB.bga();
                                    d.this.fYB.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fYE = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fYE) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.dkf > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fYI);
                                return true;
                            }
                            if (!this.fYB.arz()) {
                                this.fYI.run();
                            }
                            if (currentTimeMillis - this.fYC > 800) {
                                this.fYB.getLocationOnScreen(new int[2]);
                                this.fYB.cv((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void tv(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.fYF.setVisibility(0);
                    if (i == 1) {
                        d.this.fYF.setPadding(0, 0, 0, l.s(d.this.fYF.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.fYF.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.fYF.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.fYF, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void BN() {
                            d.this.fYF.setVisibility(8);
                            if (d.this.fYF.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.fYF.getTag()).stop();
                            }
                            d.this.fYF.setTag(null);
                        }
                    });
                    d.this.fYF.setTag(a);
                    a.b(d.this.fYF);
                }
            }, 200L);
        }
    }

    public void n(boolean z, int i) {
        if (this.fYB != null && this.oa != null) {
            if (z) {
                Rect rect = new Rect();
                this.oa.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.oa.getViewTreeObserver().addOnGlobalLayoutListener(this.fYK);
                    this.fYH.setVisibility(0);
                    bfX();
                    return;
                }
                this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.fYK);
                this.fYH.setVisibility(8);
                return;
            }
            this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.fYK);
            this.fYH.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfX() {
        if (!this.fYB.arz()) {
            int[] iArr = new int[2];
            this.fYD.getLocationOnScreen(iArr);
            this.fYH.setLayoutParams(new FrameLayout.LayoutParams(this.fYD.getWidth(), this.fYD.getHeight()));
            this.fYH.setX(iArr[0]);
            this.fYH.setY(iArr[1]);
            this.fYH.invalidate();
        }
    }
}
