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
    private View.OnClickListener aYK;
    private long cew;
    private e fab;
    private long fac;
    private View fad;
    private ImageView faf;
    private int fag;
    private View fah;
    private boolean fae = false;
    private Runnable fai = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fae && !d.this.fab.arA()) {
                Rect rect = new Rect();
                d.this.fad.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fab.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - k.g(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fab.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                d.this.fab.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fab.getWidth(), d.this.fab.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fah.setX(0.0f);
                d.this.fah.setY(0.0f);
                d.this.fah.setLayoutParams(layoutParams2);
                d.this.fah.invalidate();
                d.this.fab.setVisibility(0);
                d.this.fab.aWc();
                d.this.fac = System.currentTimeMillis();
            }
        }
    };
    private Runnable faj = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aWb();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fak = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fag == 2 && !d.this.fab.arA()) {
                d.this.mHandler.removeCallbacks(d.this.faj);
                d.this.mHandler.postDelayed(d.this.faj, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fab = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fab, layoutParams);
        this.fab.setClickable(true);
        this.faf = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.faf.setLayoutParams(layoutParams2);
        frameLayout.addView(this.faf, layoutParams2);
        this.faf.setBackgroundResource(d.e.black_alpha60);
        this.faf.setVisibility(8);
        this.fah = new View(context);
        frameLayout.addView(this.fah, new FrameLayout.LayoutParams(k.g(context, d.f.ds112), k.g(context, d.f.ds112)));
        this.fah.setVisibility(8);
        this.fah.setClickable(true);
    }

    public void pm(int i) {
        this.fag = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fab != null && d.this.fab.getVisibility() == 0) {
                        d.this.fab.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYK = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fah.setOnTouchListener(onTouchListener);
        this.faf.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.fad = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.fad == null) {
            return false;
        }
        if (this.faf.getVisibility() != 0) {
            this.fad.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cew = System.currentTimeMillis();
                    if (view == this.fah) {
                        this.fae = true;
                    } else {
                        this.fab.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fad.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fae = true;
                        } else {
                            this.fae = false;
                        }
                    }
                    if (this.fae) {
                        this.mHandler.postDelayed(this.fai, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cew <= 300 && motionEvent.getRawY() < iArr[1] + this.fad.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.fai);
                        if (this.aYK != null) {
                            this.aYK.onClick(this.fad);
                            return true;
                        }
                        return true;
                    } else if (this.fae || this.fab.arA()) {
                        if (this.fab.arA()) {
                            this.fab.getLocationOnScreen(new int[2]);
                            int bn = this.fab.bn((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fab.aWc();
                            if (bn != -1) {
                                if (bn == 1) {
                                    pV(1);
                                    i = 1;
                                } else if (bn != 3) {
                                    if (bn == 4) {
                                        i = 4;
                                        pV(4);
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
                                    d.this.aWb();
                                    d.this.fab.aWe();
                                    d.this.fab.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fae = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fae) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cew > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fai);
                                return true;
                            }
                            if (!this.fab.arA()) {
                                this.fai.run();
                            }
                            if (currentTimeMillis - this.fac > 800) {
                                this.fab.getLocationOnScreen(new int[2]);
                                this.fab.bm((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pV(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.faf.setVisibility(0);
                    if (i == 1) {
                        d.this.faf.setPadding(0, 0, 0, k.g(d.this.faf.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.faf.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.faf.invalidate();
                    l a = l.a(d.this.faf, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void uK() {
                            d.this.faf.setVisibility(8);
                            if (d.this.faf.getTag() != null) {
                                ((l) d.this.faf.getTag()).stop();
                            }
                            d.this.faf.setTag(null);
                        }
                    });
                    d.this.faf.setTag(a);
                    a.b(d.this.faf);
                }
            }, 200L);
        }
    }

    public void cg(boolean z) {
        if (this.fab != null && this.fad != null) {
            if (z) {
                Rect rect = new Rect();
                this.fad.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.fad.getViewTreeObserver().addOnGlobalLayoutListener(this.fak);
                    this.fah.setVisibility(0);
                    return;
                }
                this.fad.getViewTreeObserver().removeGlobalOnLayoutListener(this.fak);
                this.fah.setVisibility(8);
                return;
            }
            this.fad.getViewTreeObserver().removeGlobalOnLayoutListener(this.fak);
            this.fah.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        if (!this.fab.arA()) {
            int[] iArr = new int[2];
            this.fad.getLocationOnScreen(iArr);
            this.fah.setLayoutParams(new FrameLayout.LayoutParams(k.g(this.fah.getContext(), d.f.ds112), k.g(this.fah.getContext(), d.f.ds112)));
            this.fah.setX(iArr[0]);
            this.fah.setY(iArr[1]);
            this.fah.invalidate();
        }
    }
}
