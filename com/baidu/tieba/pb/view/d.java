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
    private View.OnClickListener aOR;
    private long ceW;
    private e eUR;
    private long eUS;
    private View eUT;
    private ImageView eUV;
    private int eUW;
    private View eUX;
    private boolean eUU = false;
    private Runnable eUY = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eUU && !d.this.eUR.aqm()) {
                Rect rect = new Rect();
                d.this.eUT.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.eUR.getGlobalVisibleRect(rect2);
                int f = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.eUR.getLayoutParams();
                layoutParams.setMargins(0, f + layoutParams.topMargin, 0, 0);
                d.this.eUR.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.eUR.getWidth(), d.this.eUR.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.eUX.setX(0.0f);
                d.this.eUX.setY(0.0f);
                d.this.eUX.setLayoutParams(layoutParams2);
                d.this.eUX.invalidate();
                d.this.eUR.setVisibility(0);
                d.this.eUR.aUr();
                d.this.eUS = System.currentTimeMillis();
            }
        }
    };
    private Runnable eUZ = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aUq();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener eVa = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.eUW == 2 && !d.this.eUR.aqm()) {
                d.this.mHandler.removeCallbacks(d.this.eUZ);
                d.this.mHandler.postDelayed(d.this.eUZ, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.eUR = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.eUR, layoutParams);
        this.eUR.setClickable(true);
        this.eUV = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.eUV.setLayoutParams(layoutParams2);
        frameLayout.addView(this.eUV, layoutParams2);
        this.eUV.setBackgroundResource(d.e.black_alpha60);
        this.eUV.setVisibility(8);
        this.eUX = new View(context);
        frameLayout.addView(this.eUX, new FrameLayout.LayoutParams(l.f(context, d.f.ds112), l.f(context, d.f.ds112)));
        this.eUX.setVisibility(8);
        this.eUX.setClickable(true);
    }

    public void pg(int i) {
        this.eUW = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eUR != null && d.this.eUR.getVisibility() == 0) {
                        d.this.eUR.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aOR = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eUX.setOnTouchListener(onTouchListener);
        this.eUV.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.eUT = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.eUT == null) {
            return false;
        }
        if (this.eUV.getVisibility() != 0) {
            this.eUT.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.ceW = System.currentTimeMillis();
                    if (view == this.eUX) {
                        this.eUU = true;
                    } else {
                        this.eUR.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.eUT.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.eUU = true;
                        } else {
                            this.eUU = false;
                        }
                    }
                    if (this.eUU) {
                        this.mHandler.postDelayed(this.eUY, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.ceW <= 300 && motionEvent.getRawY() < iArr[1] + this.eUT.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.eUY);
                        if (this.aOR != null) {
                            this.aOR.onClick(this.eUT);
                            return true;
                        }
                        return true;
                    } else if (this.eUU || this.eUR.aqm()) {
                        if (this.eUR.aqm()) {
                            this.eUR.getLocationOnScreen(new int[2]);
                            int by = this.eUR.by((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.eUR.aUr();
                            if (by != -1) {
                                if (by == 1) {
                                    pR(1);
                                    i = 1;
                                } else if (by != 3) {
                                    if (by == 4) {
                                        i = 4;
                                        pR(4);
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
                                    d.this.aUq();
                                    d.this.eUR.aUt();
                                    d.this.eUR.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.eUU = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.eUU) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.ceW > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.eUY);
                                return true;
                            }
                            if (!this.eUR.aqm()) {
                                this.eUY.run();
                            }
                            if (currentTimeMillis - this.eUS > 800) {
                                this.eUR.getLocationOnScreen(new int[2]);
                                this.eUR.bx((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pR(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.eUV.setVisibility(0);
                    if (i == 1) {
                        d.this.eUV.setPadding(0, 0, 0, l.f(d.this.eUV.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.eUV.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.eUV.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.eUV, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void ug() {
                            d.this.eUV.setVisibility(8);
                            if (d.this.eUV.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.eUV.getTag()).stop();
                            }
                            d.this.eUV.setTag(null);
                        }
                    });
                    d.this.eUV.setTag(a);
                    a.b(d.this.eUV);
                }
            }, 200L);
        }
    }

    public void ce(boolean z) {
        if (this.eUR != null && this.eUT != null) {
            if (z) {
                Rect rect = new Rect();
                this.eUT.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.eUT.getViewTreeObserver().addOnGlobalLayoutListener(this.eVa);
                    this.eUX.setVisibility(0);
                    return;
                }
                this.eUT.getViewTreeObserver().removeGlobalOnLayoutListener(this.eVa);
                this.eUX.setVisibility(8);
                return;
            }
            this.eUT.getViewTreeObserver().removeGlobalOnLayoutListener(this.eVa);
            this.eUX.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUq() {
        if (!this.eUR.aqm()) {
            int[] iArr = new int[2];
            this.eUT.getLocationOnScreen(iArr);
            this.eUX.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.f(this.eUX.getContext(), d.f.ds112), com.baidu.adp.lib.util.l.f(this.eUX.getContext(), d.f.ds112)));
            this.eUX.setX(iArr[0]);
            this.eUX.setY(iArr[1]);
            this.eUX.invalidate();
        }
    }
}
