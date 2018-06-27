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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private long cSO;
    private View fOA;
    private PbMainFloorPraiseFloatingView fOu;
    private long fOv;
    private View fOw;
    private ImageView fOy;
    private int fOz;
    private View mAnchorView;
    private View.OnClickListener mClickListener;
    private boolean fOx = false;
    private Runnable fOB = new Runnable() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fOx && !b.this.fOu.arl()) {
                Rect rect = new Rect();
                b.this.mAnchorView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                b.this.fOu.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.e(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.fOu.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                b.this.fOu.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.fOu.getWidth(), b.this.fOu.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                b.this.fOA.setX(0.0f);
                b.this.fOA.setY(0.0f);
                b.this.fOA.setLayoutParams(layoutParams2);
                b.this.fOA.invalidate();
                b.this.fOu.setVisibility(0);
                b.this.fOu.bik();
                b.this.fOv = System.currentTimeMillis();
            }
        }
    };
    private Runnable fOC = new Runnable() { // from class: com.baidu.tieba.pb.view.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bij();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fOD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.b.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.fOz == 2 && !b.this.fOu.arl()) {
                b.this.mHandler.removeCallbacks(b.this.fOC);
                b.this.mHandler.postDelayed(b.this.fOC, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public b(Context context, FrameLayout frameLayout) {
        this.fOu = new PbMainFloorPraiseFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fOu, layoutParams);
        this.fOu.setClickable(true);
        this.fOy = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fOy.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fOy, layoutParams2);
        this.fOy.setBackgroundResource(d.C0142d.black_alpha60);
        this.fOy.setVisibility(8);
        this.fOA = new View(context);
        frameLayout.addView(this.fOA, new FrameLayout.LayoutParams(l.e(context, d.e.ds112), l.e(context, d.e.ds112)));
        this.fOA.setVisibility(8);
        this.fOA.setClickable(true);
    }

    public void qB(int i) {
        this.fOz = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fOu != null && b.this.fOu.getVisibility() == 0) {
                        b.this.fOu.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fOA.setOnTouchListener(onTouchListener);
        this.fOy.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void bp(View view) {
        this.fOw = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.mAnchorView == null || this.fOw == null) {
            return false;
        }
        if (this.fOy.getVisibility() != 0) {
            this.fOw.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cSO = System.currentTimeMillis();
                    if (view == this.fOA) {
                        this.fOx = true;
                    } else {
                        this.fOu.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fOw.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fOx = true;
                        } else {
                            this.fOx = false;
                        }
                    }
                    if (this.fOx) {
                        this.mHandler.postDelayed(this.fOB, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cSO <= 300 && motionEvent.getRawY() < iArr[1] + this.mAnchorView.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fOB);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.mAnchorView);
                            return true;
                        }
                        return true;
                    } else if (this.fOx || this.fOu.arl()) {
                        if (this.fOu.arl()) {
                            this.fOu.getLocationOnScreen(new int[2]);
                            int bt = this.fOu.bt((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fOu.bik();
                            if (bt != -1) {
                                if (bt == 1) {
                                    rh(1);
                                    i = 1;
                                } else if (bt != 3) {
                                    if (bt == 4) {
                                        i = 4;
                                        rh(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                an anVar = new an("c12182");
                                anVar.r(VideoPlayActivityConfig.OBJ_ID, i);
                                TiebaStatic.log(anVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.bij();
                                    b.this.fOu.bim();
                                    b.this.fOu.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fOx = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fOx) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cSO > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fOB);
                                return true;
                            }
                            if (!this.fOu.arl()) {
                                this.fOB.run();
                            }
                            if (currentTimeMillis - this.fOv > 800) {
                                this.fOu.getLocationOnScreen(new int[2]);
                                this.fOu.bs((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void rh(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    b.this.fOy.setVisibility(0);
                    if (i == 1) {
                        b.this.fOy.setPadding(0, 0, 0, l.e(b.this.fOy.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        b.this.fOy.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    b.this.fOy.invalidate();
                    m a = m.a(b.this.fOy, i2, 20, 1);
                    a.a(new m.a() { // from class: com.baidu.tieba.pb.view.b.6.1
                        @Override // com.baidu.tbadk.core.util.m.a
                        public void yx() {
                            b.this.fOy.setVisibility(8);
                            if (b.this.fOy.getTag() != null) {
                                ((m) b.this.fOy.getTag()).stop();
                            }
                            b.this.fOy.setTag(null);
                        }
                    });
                    b.this.fOy.setTag(a);
                    a.b(b.this.fOy);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fOu != null && this.mAnchorView != null) {
            if (z) {
                Rect rect = new Rect();
                this.mAnchorView.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(this.fOD);
                    this.fOA.setVisibility(0);
                    bij();
                    return;
                }
                this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fOD);
                this.fOA.setVisibility(8);
                return;
            }
            this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fOD);
            this.fOA.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bij() {
        if (!this.fOu.arl()) {
            int[] iArr = new int[2];
            this.fOw.getLocationOnScreen(iArr);
            this.fOA.setLayoutParams(new FrameLayout.LayoutParams(this.fOw.getWidth(), this.fOw.getHeight()));
            this.fOA.setX(iArr[0]);
            this.fOA.setY(iArr[1]);
            this.fOA.invalidate();
        }
    }
}
