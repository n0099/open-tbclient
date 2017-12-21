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
    private long cvJ;
    private e flF;
    private long flG;
    private View flH;
    private View flI;
    private ImageView flK;
    private int flL;
    private View flM;
    private View.OnClickListener mClickListener;
    private boolean flJ = false;
    private Runnable flN = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.flJ && !d.this.flF.auL()) {
                Rect rect = new Rect();
                d.this.flH.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.flF.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.flF.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.flF.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.flF.getWidth(), d.this.flF.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.flM.setX(0.0f);
                d.this.flM.setY(0.0f);
                d.this.flM.setLayoutParams(layoutParams2);
                d.this.flM.invalidate();
                d.this.flF.setVisibility(0);
                d.this.flF.aYI();
                d.this.flG = System.currentTimeMillis();
            }
        }
    };
    private Runnable flO = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aYH();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener flP = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.flL == 2 && !d.this.flF.auL()) {
                d.this.mHandler.removeCallbacks(d.this.flO);
                d.this.mHandler.postDelayed(d.this.flO, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.flF = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.flF, layoutParams);
        this.flF.setClickable(true);
        this.flK = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.flK.setLayoutParams(layoutParams2);
        frameLayout.addView(this.flK, layoutParams2);
        this.flK.setBackgroundResource(d.C0095d.black_alpha60);
        this.flK.setVisibility(8);
        this.flM = new View(context);
        frameLayout.addView(this.flM, new FrameLayout.LayoutParams(l.f(context, d.e.ds112), l.f(context, d.e.ds112)));
        this.flM.setVisibility(8);
        this.flM.setClickable(true);
    }

    public void pW(int i) {
        this.flL = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.flF != null && d.this.flF.getVisibility() == 0) {
                        d.this.flF.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.flM.setOnTouchListener(onTouchListener);
        this.flK.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.flH = view;
    }

    public void bt(View view) {
        this.flI = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.flH == null || this.flI == null) {
            return false;
        }
        if (this.flK.getVisibility() != 0) {
            this.flI.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cvJ = System.currentTimeMillis();
                    if (view == this.flM) {
                        this.flJ = true;
                    } else {
                        this.flF.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.flI.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.flJ = true;
                        } else {
                            this.flJ = false;
                        }
                    }
                    if (this.flJ) {
                        this.mHandler.postDelayed(this.flN, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cvJ <= 300 && motionEvent.getRawY() < iArr[1] + this.flH.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.flN);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.flH);
                            return true;
                        }
                        return true;
                    } else if (this.flJ || this.flF.auL()) {
                        if (this.flF.auL()) {
                            this.flF.getLocationOnScreen(new int[2]);
                            int by = this.flF.by((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.flF.aYI();
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
                                    d.this.flF.aYK();
                                    d.this.flF.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.flJ = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.flJ) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cvJ > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.flN);
                                return true;
                            }
                            if (!this.flF.auL()) {
                                this.flN.run();
                            }
                            if (currentTimeMillis - this.flG > 800) {
                                this.flF.getLocationOnScreen(new int[2]);
                                this.flF.bx((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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
                    d.this.flK.setVisibility(0);
                    if (i == 1) {
                        d.this.flK.setPadding(0, 0, 0, l.f(d.this.flK.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.flK.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.flK.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.flK, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void un() {
                            d.this.flK.setVisibility(8);
                            if (d.this.flK.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.flK.getTag()).stop();
                            }
                            d.this.flK.setTag(null);
                        }
                    });
                    d.this.flK.setTag(a);
                    a.b(d.this.flK);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.flF != null && this.flH != null) {
            if (z) {
                Rect rect = new Rect();
                this.flH.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.flH.getViewTreeObserver().addOnGlobalLayoutListener(this.flP);
                    this.flM.setVisibility(0);
                    aYH();
                    return;
                }
                this.flH.getViewTreeObserver().removeGlobalOnLayoutListener(this.flP);
                this.flM.setVisibility(8);
                return;
            }
            this.flH.getViewTreeObserver().removeGlobalOnLayoutListener(this.flP);
            this.flM.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYH() {
        if (!this.flF.auL()) {
            int[] iArr = new int[2];
            this.flI.getLocationOnScreen(iArr);
            this.flM.setLayoutParams(new FrameLayout.LayoutParams(this.flI.getWidth(), this.flI.getHeight()));
            this.flM.setX(iArr[0]);
            this.flM.setY(iArr[1]);
            this.flM.invalidate();
        }
    }
}
