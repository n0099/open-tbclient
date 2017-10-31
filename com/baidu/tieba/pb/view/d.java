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
    private long cmq;
    private e fdh;
    private long fdi;
    private View fdj;
    private ImageView fdl;
    private int fdm;
    private View fdn;
    private View.OnClickListener mClickListener;
    private boolean fdk = false;
    private Runnable fdo = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fdk && !d.this.fdh.asI()) {
                Rect rect = new Rect();
                d.this.fdj.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fdh.getGlobalVisibleRect(rect2);
                int f = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.e.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fdh.getLayoutParams();
                layoutParams.setMargins(0, f + layoutParams.topMargin, 0, 0);
                d.this.fdh.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fdh.getWidth(), d.this.fdh.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fdn.setX(0.0f);
                d.this.fdn.setY(0.0f);
                d.this.fdn.setLayoutParams(layoutParams2);
                d.this.fdn.invalidate();
                d.this.fdh.setVisibility(0);
                d.this.fdh.aXt();
                d.this.fdi = System.currentTimeMillis();
            }
        }
    };
    private Runnable fdp = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aXs();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fdq = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fdm == 2 && !d.this.fdh.asI()) {
                d.this.mHandler.removeCallbacks(d.this.fdp);
                d.this.mHandler.postDelayed(d.this.fdp, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fdh = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fdh, layoutParams);
        this.fdh.setClickable(true);
        this.fdl = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fdl.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fdl, layoutParams2);
        this.fdl.setBackgroundResource(d.C0080d.black_alpha60);
        this.fdl.setVisibility(8);
        this.fdn = new View(context);
        frameLayout.addView(this.fdn, new FrameLayout.LayoutParams(l.f(context, d.e.ds112), l.f(context, d.e.ds112)));
        this.fdn.setVisibility(8);
        this.fdn.setClickable(true);
    }

    public void pB(int i) {
        this.fdm = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fdh != null && d.this.fdh.getVisibility() == 0) {
                        d.this.fdh.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fdn.setOnTouchListener(onTouchListener);
        this.fdl.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.fdj = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.fdj == null) {
            return false;
        }
        if (this.fdl.getVisibility() != 0) {
            this.fdj.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cmq = System.currentTimeMillis();
                    if (view == this.fdn) {
                        this.fdk = true;
                    } else {
                        this.fdh.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fdj.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fdk = true;
                        } else {
                            this.fdk = false;
                        }
                    }
                    if (this.fdk) {
                        this.mHandler.postDelayed(this.fdo, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cmq <= 300 && motionEvent.getRawY() < iArr[1] + this.fdj.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.fdo);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.fdj);
                            return true;
                        }
                        return true;
                    } else if (this.fdk || this.fdh.asI()) {
                        if (this.fdh.asI()) {
                            this.fdh.getLocationOnScreen(new int[2]);
                            int bA = this.fdh.bA((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fdh.aXt();
                            if (bA != -1) {
                                if (bA == 1) {
                                    qi(1);
                                    i = 1;
                                } else if (bA != 3) {
                                    if (bA == 4) {
                                        i = 4;
                                        qi(4);
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
                                    d.this.aXs();
                                    d.this.fdh.aXv();
                                    d.this.fdh.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fdk = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fdk) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cmq > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fdo);
                                return true;
                            }
                            if (!this.fdh.asI()) {
                                this.fdo.run();
                            }
                            if (currentTimeMillis - this.fdi > 800) {
                                this.fdh.getLocationOnScreen(new int[2]);
                                this.fdh.bz((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void qi(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.fdl.setVisibility(0);
                    if (i == 1) {
                        d.this.fdl.setPadding(0, 0, 0, l.f(d.this.fdl.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.fdl.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.fdl.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.fdl, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void un() {
                            d.this.fdl.setVisibility(8);
                            if (d.this.fdl.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.fdl.getTag()).stop();
                            }
                            d.this.fdl.setTag(null);
                        }
                    });
                    d.this.fdl.setTag(a);
                    a.b(d.this.fdl);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fdh != null && this.fdj != null) {
            if (z) {
                Rect rect = new Rect();
                this.fdj.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.fdj.getViewTreeObserver().addOnGlobalLayoutListener(this.fdq);
                    this.fdn.setVisibility(0);
                    aXs();
                    return;
                }
                this.fdj.getViewTreeObserver().removeGlobalOnLayoutListener(this.fdq);
                this.fdn.setVisibility(8);
                return;
            }
            this.fdj.getViewTreeObserver().removeGlobalOnLayoutListener(this.fdq);
            this.fdn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXs() {
        if (!this.fdh.asI()) {
            int[] iArr = new int[2];
            this.fdj.getLocationOnScreen(iArr);
            this.fdn.setLayoutParams(new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.f(this.fdn.getContext(), d.e.ds112), com.baidu.adp.lib.util.l.f(this.fdn.getContext(), d.e.ds112)));
            this.fdn.setX(iArr[0]);
            this.fdn.setY(iArr[1]);
            this.fdn.invalidate();
        }
    }
}
