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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.b;
/* loaded from: classes.dex */
public class d {
    private View.OnClickListener aYW;
    private long caS;
    private View eZA;
    private ImageView eZC;
    private int eZD;
    private View eZE;
    private e eZy;
    private long eZz;
    private boolean eZB = false;
    private Runnable eZF = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eZB && !d.this.eZy.app()) {
                Rect rect = new Rect();
                d.this.eZA.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.eZy.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - k.g(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.eZy.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                d.this.eZy.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.eZy.getWidth(), d.this.eZy.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.eZE.setX(0.0f);
                d.this.eZE.setY(0.0f);
                d.this.eZE.setLayoutParams(layoutParams2);
                d.this.eZE.invalidate();
                d.this.eZy.setVisibility(0);
                d.this.eZy.aWo();
                d.this.eZz = System.currentTimeMillis();
            }
        }
    };
    private Runnable eZG = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aWn();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener eZH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.eZD == 2 && !d.this.eZy.app()) {
                d.this.mHandler.removeCallbacks(d.this.eZG);
                d.this.mHandler.postDelayed(d.this.eZG, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.eZy = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.eZy, layoutParams);
        this.eZy.setClickable(true);
        this.eZC = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.eZC.setLayoutParams(layoutParams2);
        frameLayout.addView(this.eZC, layoutParams2);
        this.eZC.setBackgroundResource(d.e.black_alpha60);
        this.eZC.setVisibility(8);
        this.eZE = new View(context);
        frameLayout.addView(this.eZE, new FrameLayout.LayoutParams(k.g(context, d.f.ds112), k.g(context, d.f.ds112)));
        this.eZE.setVisibility(8);
        this.eZE.setClickable(true);
    }

    public void oV(int i) {
        this.eZD = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eZy != null && d.this.eZy.getVisibility() == 0) {
                        d.this.eZy.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYW = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eZE.setOnTouchListener(onTouchListener);
        this.eZC.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.eZA = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.eZA == null) {
            return false;
        }
        if (this.eZC.getVisibility() != 0) {
            this.eZA.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.caS = System.currentTimeMillis();
                    if (view == this.eZE) {
                        this.eZB = true;
                    } else {
                        this.eZy.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.eZA.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.eZB = true;
                        } else {
                            this.eZB = false;
                        }
                    }
                    if (this.eZB) {
                        this.mHandler.postDelayed(this.eZF, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.caS <= 300 && motionEvent.getRawY() < iArr[1] + this.eZA.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.eZF);
                        if (this.aYW != null) {
                            this.aYW.onClick(this.eZA);
                            return true;
                        }
                        return true;
                    } else if (this.eZB || this.eZy.app()) {
                        if (this.eZy.app()) {
                            this.eZy.getLocationOnScreen(new int[2]);
                            int bg = this.eZy.bg((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.eZy.aWo();
                            if (bg != -1) {
                                if (bg == 1) {
                                    pL(1);
                                    i = 1;
                                } else if (bg != 3) {
                                    if (bg == 4) {
                                        i = 4;
                                        pL(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                aj ajVar = new aj("c12182");
                                ajVar.r("obj_id", i);
                                TiebaStatic.log(ajVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.aWn();
                                    d.this.eZy.aWq();
                                    d.this.eZy.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.eZB = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.eZB) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.caS > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.eZF);
                                return true;
                            }
                            if (!this.eZy.app()) {
                                this.eZF.run();
                            }
                            if (currentTimeMillis - this.eZz > 800) {
                                this.eZy.getLocationOnScreen(new int[2]);
                                this.eZy.bf((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pL(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.eZC.setVisibility(0);
                    if (i == 1) {
                        d.this.eZC.setPadding(0, 0, 0, k.g(d.this.eZC.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.eZC.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.eZC.invalidate();
                    com.baidu.tieba.pb.pb.main.view.b b = com.baidu.tieba.pb.pb.main.view.b.b(d.this.eZC, i2, 20, 1);
                    b.a(new b.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tieba.pb.pb.main.view.b.a
                        public void aUC() {
                            d.this.eZC.setVisibility(8);
                            if (d.this.eZC.getTag() != null) {
                                ((com.baidu.tieba.pb.pb.main.view.b) d.this.eZC.getTag()).stop();
                            }
                            d.this.eZC.setTag(null);
                        }
                    });
                    d.this.eZC.setTag(b);
                    b.start();
                }
            }, 200L);
        }
    }

    public void cg(boolean z) {
        if (this.eZy != null && this.eZA != null) {
            if (z) {
                Rect rect = new Rect();
                this.eZA.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.eZA.getViewTreeObserver().addOnGlobalLayoutListener(this.eZH);
                    this.eZE.setVisibility(0);
                    return;
                }
                this.eZA.getViewTreeObserver().removeGlobalOnLayoutListener(this.eZH);
                this.eZE.setVisibility(8);
                return;
            }
            this.eZA.getViewTreeObserver().removeGlobalOnLayoutListener(this.eZH);
            this.eZE.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWn() {
        if (!this.eZy.app()) {
            int[] iArr = new int[2];
            this.eZA.getLocationOnScreen(iArr);
            this.eZE.setLayoutParams(new FrameLayout.LayoutParams(k.g(this.eZE.getContext(), d.f.ds112), k.g(this.eZE.getContext(), d.f.ds112)));
            this.eZE.setX(iArr[0]);
            this.eZE.setY(iArr[1]);
            this.eZE.invalidate();
        }
    }
}
