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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    private View.OnClickListener aYH;
    private long cfo;
    private e faV;
    private long faW;
    private View faX;
    private ImageView faZ;
    private int fba;
    private View fbb;
    private boolean faY = false;
    private Runnable fbc = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.faY && !d.this.faV.arL()) {
                Rect rect = new Rect();
                d.this.faX.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.faV.getGlobalVisibleRect(rect2);
                int f = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - k.f(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.faV.getLayoutParams();
                layoutParams.setMargins(0, f + layoutParams.topMargin, 0, 0);
                d.this.faV.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.faV.getWidth(), d.this.faV.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fbb.setX(0.0f);
                d.this.fbb.setY(0.0f);
                d.this.fbb.setLayoutParams(layoutParams2);
                d.this.fbb.invalidate();
                d.this.faV.setVisibility(0);
                d.this.faV.aWn();
                d.this.faW = System.currentTimeMillis();
            }
        }
    };
    private Runnable fbd = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aWm();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fbe = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fba == 2 && !d.this.faV.arL()) {
                d.this.mHandler.removeCallbacks(d.this.fbd);
                d.this.mHandler.postDelayed(d.this.fbd, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.faV = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.faV, layoutParams);
        this.faV.setClickable(true);
        this.faZ = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.faZ.setLayoutParams(layoutParams2);
        frameLayout.addView(this.faZ, layoutParams2);
        this.faZ.setBackgroundResource(d.e.black_alpha60);
        this.faZ.setVisibility(8);
        this.fbb = new View(context);
        frameLayout.addView(this.fbb, new FrameLayout.LayoutParams(k.f(context, d.f.ds112), k.f(context, d.f.ds112)));
        this.fbb.setVisibility(8);
        this.fbb.setClickable(true);
    }

    public void po(int i) {
        this.fba = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.faV != null && d.this.faV.getVisibility() == 0) {
                        d.this.faV.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYH = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fbb.setOnTouchListener(onTouchListener);
        this.faZ.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.faX = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.faX == null) {
            return false;
        }
        if (this.faZ.getVisibility() != 0) {
            this.faX.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cfo = System.currentTimeMillis();
                    if (view == this.fbb) {
                        this.faY = true;
                    } else {
                        this.faV.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.faX.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.faY = true;
                        } else {
                            this.faY = false;
                        }
                    }
                    if (this.faY) {
                        this.mHandler.postDelayed(this.fbc, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cfo <= 300 && motionEvent.getRawY() < iArr[1] + this.faX.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.fbc);
                        if (this.aYH != null) {
                            this.aYH.onClick(this.faX);
                            return true;
                        }
                        return true;
                    } else if (this.faY || this.faV.arL()) {
                        if (this.faV.arL()) {
                            this.faV.getLocationOnScreen(new int[2]);
                            int br = this.faV.br((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.faV.aWn();
                            if (br != -1) {
                                if (br == 1) {
                                    pX(1);
                                    i = 1;
                                } else if (br != 3) {
                                    if (br == 4) {
                                        i = 4;
                                        pX(4);
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
                                    d.this.aWm();
                                    d.this.faV.aWp();
                                    d.this.faV.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.faY = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.faY) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cfo > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fbc);
                                return true;
                            }
                            if (!this.faV.arL()) {
                                this.fbc.run();
                            }
                            if (currentTimeMillis - this.faW > 800) {
                                this.faV.getLocationOnScreen(new int[2]);
                                this.faV.bq((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pX(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.faZ.setVisibility(0);
                    if (i == 1) {
                        d.this.faZ.setPadding(0, 0, 0, k.f(d.this.faZ.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.faZ.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.faZ.invalidate();
                    l a = l.a(d.this.faZ, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void uK() {
                            d.this.faZ.setVisibility(8);
                            if (d.this.faZ.getTag() != null) {
                                ((l) d.this.faZ.getTag()).stop();
                            }
                            d.this.faZ.setTag(null);
                        }
                    });
                    d.this.faZ.setTag(a);
                    a.b(d.this.faZ);
                }
            }, 200L);
        }
    }

    public void cg(boolean z) {
        if (this.faV != null && this.faX != null) {
            if (z) {
                Rect rect = new Rect();
                this.faX.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.faX.getViewTreeObserver().addOnGlobalLayoutListener(this.fbe);
                    this.fbb.setVisibility(0);
                    return;
                }
                this.faX.getViewTreeObserver().removeGlobalOnLayoutListener(this.fbe);
                this.fbb.setVisibility(8);
                return;
            }
            this.faX.getViewTreeObserver().removeGlobalOnLayoutListener(this.fbe);
            this.fbb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWm() {
        if (!this.faV.arL()) {
            int[] iArr = new int[2];
            this.faX.getLocationOnScreen(iArr);
            this.fbb.setLayoutParams(new FrameLayout.LayoutParams(k.f(this.fbb.getContext(), d.f.ds112), k.f(this.fbb.getContext(), d.f.ds112)));
            this.fbb.setX(iArr[0]);
            this.fbb.setY(iArr[1]);
            this.fbb.invalidate();
        }
    }
}
