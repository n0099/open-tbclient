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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d {
    private long drL;
    private e gdJ;
    private long gdK;
    private View gdL;
    private ImageView gdN;
    private int gdO;
    private View gdP;
    private View.OnClickListener mClickListener;
    private View oa;
    private boolean gdM = false;
    private Runnable gdQ = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gdM && !d.this.gdJ.atx()) {
                Rect rect = new Rect();
                d.this.oa.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.gdJ.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.t(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gdJ.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.gdJ.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.gdJ.getWidth(), d.this.gdJ.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.gdP.setX(0.0f);
                d.this.gdP.setY(0.0f);
                d.this.gdP.setLayoutParams(layoutParams2);
                d.this.gdP.invalidate();
                d.this.gdJ.setVisibility(0);
                d.this.gdJ.bhE();
                d.this.gdK = System.currentTimeMillis();
            }
        }
    };
    private Runnable gdR = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bhD();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener gdS = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.gdO == 2 && !d.this.gdJ.atx()) {
                d.this.mHandler.removeCallbacks(d.this.gdR);
                d.this.mHandler.postDelayed(d.this.gdR, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.gdJ = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.gdJ, layoutParams);
        this.gdJ.setClickable(true);
        this.gdN = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.gdN.setLayoutParams(layoutParams2);
        frameLayout.addView(this.gdN, layoutParams2);
        this.gdN.setBackgroundResource(d.C0141d.black_alpha60);
        this.gdN.setVisibility(8);
        this.gdP = new View(context);
        frameLayout.addView(this.gdP, new FrameLayout.LayoutParams(l.t(context, d.e.ds112), l.t(context, d.e.ds112)));
        this.gdP.setVisibility(8);
        this.gdP.setClickable(true);
    }

    public void sN(int i) {
        this.gdO = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gdJ != null && d.this.gdJ.getVisibility() == 0) {
                        d.this.gdJ.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gdP.setOnTouchListener(onTouchListener);
        this.gdN.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void cF(View view) {
        this.gdL = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.oa == null || this.gdL == null) {
            return false;
        }
        if (this.gdN.getVisibility() != 0) {
            this.gdL.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.drL = System.currentTimeMillis();
                    if (view == this.gdP) {
                        this.gdM = true;
                    } else {
                        this.gdJ.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.gdL.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.gdM = true;
                        } else {
                            this.gdM = false;
                        }
                    }
                    if (this.gdM) {
                        this.mHandler.postDelayed(this.gdQ, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.drL <= 300 && motionEvent.getRawY() < iArr[1] + this.oa.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.gdQ);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.oa);
                            return true;
                        }
                        return true;
                    } else if (this.gdM || this.gdJ.atx()) {
                        if (this.gdJ.atx()) {
                            this.gdJ.getLocationOnScreen(new int[2]);
                            int cs = this.gdJ.cs((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.gdJ.bhE();
                            if (cs != -1) {
                                if (cs == 1) {
                                    ts(1);
                                    i = 1;
                                } else if (cs != 3) {
                                    if (cs == 4) {
                                        i = 4;
                                        ts(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                ak akVar = new ak("c12182");
                                akVar.s("obj_id", i);
                                TiebaStatic.log(akVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.bhD();
                                    d.this.gdJ.bhG();
                                    d.this.gdJ.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.gdM = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.gdM) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.drL > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.gdQ);
                                return true;
                            }
                            if (!this.gdJ.atx()) {
                                this.gdQ.run();
                            }
                            if (currentTimeMillis - this.gdK > 800) {
                                this.gdJ.getLocationOnScreen(new int[2]);
                                this.gdJ.cr((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void ts(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.gdN.setVisibility(0);
                    if (i == 1) {
                        d.this.gdN.setPadding(0, 0, 0, l.t(d.this.gdN.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.gdN.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.gdN.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.gdN, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void BZ() {
                            d.this.gdN.setVisibility(8);
                            if (d.this.gdN.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.gdN.getTag()).stop();
                            }
                            d.this.gdN.setTag(null);
                        }
                    });
                    d.this.gdN.setTag(a);
                    a.b(d.this.gdN);
                }
            }, 200L);
        }
    }

    public void o(boolean z, int i) {
        if (this.gdJ != null && this.oa != null) {
            if (z) {
                Rect rect = new Rect();
                this.oa.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.oa.getViewTreeObserver().addOnGlobalLayoutListener(this.gdS);
                    this.gdP.setVisibility(0);
                    bhD();
                    return;
                }
                this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gdS);
                this.gdP.setVisibility(8);
                return;
            }
            this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gdS);
            this.gdP.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
        if (!this.gdJ.atx()) {
            int[] iArr = new int[2];
            this.gdL.getLocationOnScreen(iArr);
            this.gdP.setLayoutParams(new FrameLayout.LayoutParams(this.gdL.getWidth(), this.gdL.getHeight()));
            this.gdP.setX(iArr[0]);
            this.gdP.setY(iArr[1]);
            this.gdP.invalidate();
        }
    }
}
