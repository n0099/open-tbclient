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
    private View.OnClickListener aPe;
    private long cfi;
    private e eVf;
    private long eVg;
    private View eVh;
    private ImageView eVj;
    private int eVk;
    private View eVl;
    private boolean eVi = false;
    private Runnable eVm = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eVi && !d.this.eVf.aqr()) {
                Rect rect = new Rect();
                d.this.eVh.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.eVf.getGlobalVisibleRect(rect2);
                int f = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.eVf.getLayoutParams();
                layoutParams.setMargins(0, f + layoutParams.topMargin, 0, 0);
                d.this.eVf.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.eVf.getWidth(), d.this.eVf.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.eVl.setX(0.0f);
                d.this.eVl.setY(0.0f);
                d.this.eVl.setLayoutParams(layoutParams2);
                d.this.eVl.invalidate();
                d.this.eVf.setVisibility(0);
                d.this.eVf.aUw();
                d.this.eVg = System.currentTimeMillis();
            }
        }
    };
    private Runnable eVn = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aUv();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener eVo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.eVk == 2 && !d.this.eVf.aqr()) {
                d.this.mHandler.removeCallbacks(d.this.eVn);
                d.this.mHandler.postDelayed(d.this.eVn, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.eVf = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.eVf, layoutParams);
        this.eVf.setClickable(true);
        this.eVj = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.eVj.setLayoutParams(layoutParams2);
        frameLayout.addView(this.eVj, layoutParams2);
        this.eVj.setBackgroundResource(d.e.black_alpha60);
        this.eVj.setVisibility(8);
        this.eVl = new View(context);
        frameLayout.addView(this.eVl, new FrameLayout.LayoutParams(l.f(context, d.f.ds112), l.f(context, d.f.ds112)));
        this.eVl.setVisibility(8);
        this.eVl.setClickable(true);
    }

    public void ph(int i) {
        this.eVk = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eVf != null && d.this.eVf.getVisibility() == 0) {
                        d.this.eVf.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aPe = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eVl.setOnTouchListener(onTouchListener);
        this.eVj.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.eVh = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.eVh == null) {
            return false;
        }
        if (this.eVj.getVisibility() != 0) {
            this.eVh.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cfi = System.currentTimeMillis();
                    if (view == this.eVl) {
                        this.eVi = true;
                    } else {
                        this.eVf.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.eVh.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.eVi = true;
                        } else {
                            this.eVi = false;
                        }
                    }
                    if (this.eVi) {
                        this.mHandler.postDelayed(this.eVm, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cfi <= 300 && motionEvent.getRawY() < iArr[1] + this.eVh.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.eVm);
                        if (this.aPe != null) {
                            this.aPe.onClick(this.eVh);
                            return true;
                        }
                        return true;
                    } else if (this.eVi || this.eVf.aqr()) {
                        if (this.eVf.aqr()) {
                            this.eVf.getLocationOnScreen(new int[2]);
                            int by = this.eVf.by((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.eVf.aUw();
                            if (by != -1) {
                                if (by == 1) {
                                    pS(1);
                                    i = 1;
                                } else if (by != 3) {
                                    if (by == 4) {
                                        i = 4;
                                        pS(4);
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
                                    d.this.aUv();
                                    d.this.eVf.aUy();
                                    d.this.eVf.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.eVi = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.eVi) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cfi > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.eVm);
                                return true;
                            }
                            if (!this.eVf.aqr()) {
                                this.eVm.run();
                            }
                            if (currentTimeMillis - this.eVg > 800) {
                                this.eVf.getLocationOnScreen(new int[2]);
                                this.eVf.bx((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pS(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.eVj.setVisibility(0);
                    if (i == 1) {
                        d.this.eVj.setPadding(0, 0, 0, l.f(d.this.eVj.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.eVj.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.eVj.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.eVj, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void un() {
                            d.this.eVj.setVisibility(8);
                            if (d.this.eVj.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.eVj.getTag()).stop();
                            }
                            d.this.eVj.setTag(null);
                        }
                    });
                    d.this.eVj.setTag(a);
                    a.b(d.this.eVj);
                }
            }, 200L);
        }
    }

    public void cf(boolean z) {
        if (this.eVf != null && this.eVh != null) {
            if (z) {
                Rect rect = new Rect();
                this.eVh.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.eVh.getViewTreeObserver().addOnGlobalLayoutListener(this.eVo);
                    this.eVl.setVisibility(0);
                    return;
                }
                this.eVh.getViewTreeObserver().removeGlobalOnLayoutListener(this.eVo);
                this.eVl.setVisibility(8);
                return;
            }
            this.eVh.getViewTreeObserver().removeGlobalOnLayoutListener(this.eVo);
            this.eVl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUv() {
        if (!this.eVf.aqr()) {
            int[] iArr = new int[2];
            this.eVh.getLocationOnScreen(iArr);
            this.eVl.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.f(this.eVl.getContext(), d.f.ds112), com.baidu.adp.lib.util.l.f(this.eVl.getContext(), d.f.ds112)));
            this.eVl.setX(iArr[0]);
            this.eVl.setY(iArr[1]);
            this.eVl.invalidate();
        }
    }
}
