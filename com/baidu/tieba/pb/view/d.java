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
    private long dpb;
    private ImageView gaB;
    private int gaC;
    private View gaD;
    private e gax;
    private long gay;
    private View gaz;
    private View.OnClickListener mClickListener;
    private View oa;
    private boolean gaA = false;
    private Runnable gaE = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gaA && !d.this.gax.asH()) {
                Rect rect = new Rect();
                d.this.oa.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.gax.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.s(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gax.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.gax.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.gax.getWidth(), d.this.gax.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.gaD.setX(0.0f);
                d.this.gaD.setY(0.0f);
                d.this.gaD.setLayoutParams(layoutParams2);
                d.this.gaD.invalidate();
                d.this.gax.setVisibility(0);
                d.this.gax.bge();
                d.this.gay = System.currentTimeMillis();
            }
        }
    };
    private Runnable gaF = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bgd();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener gaG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.gaC == 2 && !d.this.gax.asH()) {
                d.this.mHandler.removeCallbacks(d.this.gaF);
                d.this.mHandler.postDelayed(d.this.gaF, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.gax = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.gax, layoutParams);
        this.gax.setClickable(true);
        this.gaB = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.gaB.setLayoutParams(layoutParams2);
        frameLayout.addView(this.gaB, layoutParams2);
        this.gaB.setBackgroundResource(d.C0108d.black_alpha60);
        this.gaB.setVisibility(8);
        this.gaD = new View(context);
        frameLayout.addView(this.gaD, new FrameLayout.LayoutParams(l.s(context, d.e.ds112), l.s(context, d.e.ds112)));
        this.gaD.setVisibility(8);
        this.gaD.setClickable(true);
    }

    public void sJ(int i) {
        this.gaC = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gax != null && d.this.gax.getVisibility() == 0) {
                        d.this.gax.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gaD.setOnTouchListener(onTouchListener);
        this.gaB.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void cG(View view) {
        this.gaz = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.oa == null || this.gaz == null) {
            return false;
        }
        if (this.gaB.getVisibility() != 0) {
            this.gaz.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.dpb = System.currentTimeMillis();
                    if (view == this.gaD) {
                        this.gaA = true;
                    } else {
                        this.gax.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.gaz.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.gaA = true;
                        } else {
                            this.gaA = false;
                        }
                    }
                    if (this.gaA) {
                        this.mHandler.postDelayed(this.gaE, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.dpb <= 300 && motionEvent.getRawY() < iArr[1] + this.oa.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.gaE);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.oa);
                            return true;
                        }
                        return true;
                    } else if (this.gaA || this.gax.asH()) {
                        if (this.gax.asH()) {
                            this.gax.getLocationOnScreen(new int[2]);
                            int cw = this.gax.cw((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.gax.bge();
                            if (cw != -1) {
                                if (cw == 1) {
                                    tn(1);
                                    i = 1;
                                } else if (cw != 3) {
                                    if (cw == 4) {
                                        i = 4;
                                        tn(4);
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
                                    d.this.bgd();
                                    d.this.gax.bgg();
                                    d.this.gax.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.gaA = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.gaA) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.dpb > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.gaE);
                                return true;
                            }
                            if (!this.gax.asH()) {
                                this.gaE.run();
                            }
                            if (currentTimeMillis - this.gay > 800) {
                                this.gax.getLocationOnScreen(new int[2]);
                                this.gax.cv((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void tn(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.gaB.setVisibility(0);
                    if (i == 1) {
                        d.this.gaB.setPadding(0, 0, 0, l.s(d.this.gaB.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.gaB.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.gaB.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.gaB, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void BG() {
                            d.this.gaB.setVisibility(8);
                            if (d.this.gaB.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.gaB.getTag()).stop();
                            }
                            d.this.gaB.setTag(null);
                        }
                    });
                    d.this.gaB.setTag(a);
                    a.b(d.this.gaB);
                }
            }, 200L);
        }
    }

    public void n(boolean z, int i) {
        if (this.gax != null && this.oa != null) {
            if (z) {
                Rect rect = new Rect();
                this.oa.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.oa.getViewTreeObserver().addOnGlobalLayoutListener(this.gaG);
                    this.gaD.setVisibility(0);
                    bgd();
                    return;
                }
                this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gaG);
                this.gaD.setVisibility(8);
                return;
            }
            this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gaG);
            this.gaD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgd() {
        if (!this.gax.asH()) {
            int[] iArr = new int[2];
            this.gaz.getLocationOnScreen(iArr);
            this.gaD.setLayoutParams(new FrameLayout.LayoutParams(this.gaz.getWidth(), this.gaz.getHeight()));
            this.gaD.setX(iArr[0]);
            this.gaD.setY(iArr[1]);
            this.gaD.invalidate();
        }
    }
}
