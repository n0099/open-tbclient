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
    private long cmJ;
    private e fdD;
    private long fdE;
    private View fdF;
    private ImageView fdH;
    private int fdI;
    private View fdJ;
    private View.OnClickListener mClickListener;
    private boolean fdG = false;
    private Runnable fdK = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fdG && !d.this.fdD.asZ()) {
                Rect rect = new Rect();
                d.this.fdF.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fdD.getGlobalVisibleRect(rect2);
                int f = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.e.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fdD.getLayoutParams();
                layoutParams.setMargins(0, f + layoutParams.topMargin, 0, 0);
                d.this.fdD.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fdD.getWidth(), d.this.fdD.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fdJ.setX(0.0f);
                d.this.fdJ.setY(0.0f);
                d.this.fdJ.setLayoutParams(layoutParams2);
                d.this.fdJ.invalidate();
                d.this.fdD.setVisibility(0);
                d.this.fdD.aXB();
                d.this.fdE = System.currentTimeMillis();
            }
        }
    };
    private Runnable fdL = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aXA();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fdM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fdI == 2 && !d.this.fdD.asZ()) {
                d.this.mHandler.removeCallbacks(d.this.fdL);
                d.this.mHandler.postDelayed(d.this.fdL, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fdD = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fdD, layoutParams);
        this.fdD.setClickable(true);
        this.fdH = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fdH.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fdH, layoutParams2);
        this.fdH.setBackgroundResource(d.C0080d.black_alpha60);
        this.fdH.setVisibility(8);
        this.fdJ = new View(context);
        frameLayout.addView(this.fdJ, new FrameLayout.LayoutParams(l.f(context, d.e.ds112), l.f(context, d.e.ds112)));
        this.fdJ.setVisibility(8);
        this.fdJ.setClickable(true);
    }

    public void pC(int i) {
        this.fdI = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fdD != null && d.this.fdD.getVisibility() == 0) {
                        d.this.fdD.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fdJ.setOnTouchListener(onTouchListener);
        this.fdH.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.fdF = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.fdF == null) {
            return false;
        }
        if (this.fdH.getVisibility() != 0) {
            this.fdF.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cmJ = System.currentTimeMillis();
                    if (view == this.fdJ) {
                        this.fdG = true;
                    } else {
                        this.fdD.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fdF.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fdG = true;
                        } else {
                            this.fdG = false;
                        }
                    }
                    if (this.fdG) {
                        this.mHandler.postDelayed(this.fdK, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cmJ <= 300 && motionEvent.getRawY() < iArr[1] + this.fdF.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.fdK);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.fdF);
                            return true;
                        }
                        return true;
                    } else if (this.fdG || this.fdD.asZ()) {
                        if (this.fdD.asZ()) {
                            this.fdD.getLocationOnScreen(new int[2]);
                            int bz = this.fdD.bz((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fdD.aXB();
                            if (bz != -1) {
                                if (bz == 1) {
                                    qj(1);
                                    i = 1;
                                } else if (bz != 3) {
                                    if (bz == 4) {
                                        i = 4;
                                        qj(4);
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
                                    d.this.aXA();
                                    d.this.fdD.aXD();
                                    d.this.fdD.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fdG = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fdG) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cmJ > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fdK);
                                return true;
                            }
                            if (!this.fdD.asZ()) {
                                this.fdK.run();
                            }
                            if (currentTimeMillis - this.fdE > 800) {
                                this.fdD.getLocationOnScreen(new int[2]);
                                this.fdD.by((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void qj(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.fdH.setVisibility(0);
                    if (i == 1) {
                        d.this.fdH.setPadding(0, 0, 0, l.f(d.this.fdH.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.fdH.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.fdH.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.fdH, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void un() {
                            d.this.fdH.setVisibility(8);
                            if (d.this.fdH.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.fdH.getTag()).stop();
                            }
                            d.this.fdH.setTag(null);
                        }
                    });
                    d.this.fdH.setTag(a);
                    a.b(d.this.fdH);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fdD != null && this.fdF != null) {
            if (z) {
                Rect rect = new Rect();
                this.fdF.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.fdF.getViewTreeObserver().addOnGlobalLayoutListener(this.fdM);
                    this.fdJ.setVisibility(0);
                    aXA();
                    return;
                }
                this.fdF.getViewTreeObserver().removeGlobalOnLayoutListener(this.fdM);
                this.fdJ.setVisibility(8);
                return;
            }
            this.fdF.getViewTreeObserver().removeGlobalOnLayoutListener(this.fdM);
            this.fdJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXA() {
        if (!this.fdD.asZ()) {
            int[] iArr = new int[2];
            this.fdF.getLocationOnScreen(iArr);
            this.fdJ.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.f(this.fdJ.getContext(), d.e.ds112), com.baidu.adp.lib.util.l.f(this.fdJ.getContext(), d.e.ds112)));
            this.fdJ.setX(iArr[0]);
            this.fdJ.setY(iArr[1]);
            this.fdJ.invalidate();
        }
    }
}
