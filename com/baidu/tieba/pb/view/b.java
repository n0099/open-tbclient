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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private long cUM;
    private PbMainFloorPraiseFloatingView fKt;
    private long fKu;
    private View fKv;
    private ImageView fKx;
    private int fKy;
    private View fKz;
    private View mAnchorView;
    private View.OnClickListener mClickListener;
    private boolean fKw = false;
    private Runnable fKA = new Runnable() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fKw && !b.this.fKt.arQ()) {
                Rect rect = new Rect();
                b.this.mAnchorView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                b.this.fKt.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.e(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.fKt.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                b.this.fKt.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.fKt.getWidth(), b.this.fKt.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                b.this.fKz.setX(0.0f);
                b.this.fKz.setY(0.0f);
                b.this.fKz.setLayoutParams(layoutParams2);
                b.this.fKz.invalidate();
                b.this.fKt.setVisibility(0);
                b.this.fKt.bhE();
                b.this.fKu = System.currentTimeMillis();
            }
        }
    };
    private Runnable fKB = new Runnable() { // from class: com.baidu.tieba.pb.view.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bhD();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fKC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.b.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.fKy == 2 && !b.this.fKt.arQ()) {
                b.this.mHandler.removeCallbacks(b.this.fKB);
                b.this.mHandler.postDelayed(b.this.fKB, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public b(Context context, FrameLayout frameLayout) {
        this.fKt = new PbMainFloorPraiseFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fKt, layoutParams);
        this.fKt.setClickable(true);
        this.fKx = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fKx.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fKx, layoutParams2);
        this.fKx.setBackgroundResource(d.C0141d.black_alpha60);
        this.fKx.setVisibility(8);
        this.fKz = new View(context);
        frameLayout.addView(this.fKz, new FrameLayout.LayoutParams(l.e(context, d.e.ds112), l.e(context, d.e.ds112)));
        this.fKz.setVisibility(8);
        this.fKz.setClickable(true);
    }

    public void qu(int i) {
        this.fKy = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fKt != null && b.this.fKt.getVisibility() == 0) {
                        b.this.fKt.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fKz.setOnTouchListener(onTouchListener);
        this.fKx.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void bo(View view) {
        this.fKv = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.mAnchorView == null || this.fKv == null) {
            return false;
        }
        if (this.fKx.getVisibility() != 0) {
            this.fKv.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cUM = System.currentTimeMillis();
                    if (view == this.fKz) {
                        this.fKw = true;
                    } else {
                        this.fKt.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fKv.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fKw = true;
                        } else {
                            this.fKw = false;
                        }
                    }
                    if (this.fKw) {
                        this.mHandler.postDelayed(this.fKA, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cUM <= 300 && motionEvent.getRawY() < iArr[1] + this.mAnchorView.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fKA);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.mAnchorView);
                            return true;
                        }
                        return true;
                    } else if (this.fKw || this.fKt.arQ()) {
                        if (this.fKt.arQ()) {
                            this.fKt.getLocationOnScreen(new int[2]);
                            int bu = this.fKt.bu((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fKt.bhE();
                            if (bu != -1) {
                                if (bu == 1) {
                                    qZ(1);
                                    i = 1;
                                } else if (bu != 3) {
                                    if (bu == 4) {
                                        i = 4;
                                        qZ(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                am amVar = new am("c12182");
                                amVar.r(VideoPlayActivityConfig.OBJ_ID, i);
                                TiebaStatic.log(amVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.bhD();
                                    b.this.fKt.bhG();
                                    b.this.fKt.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fKw = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fKw) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cUM > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fKA);
                                return true;
                            }
                            if (!this.fKt.arQ()) {
                                this.fKA.run();
                            }
                            if (currentTimeMillis - this.fKu > 800) {
                                this.fKt.getLocationOnScreen(new int[2]);
                                this.fKt.bt((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void qZ(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    b.this.fKx.setVisibility(0);
                    if (i == 1) {
                        b.this.fKx.setPadding(0, 0, 0, l.e(b.this.fKx.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        b.this.fKx.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    b.this.fKx.invalidate();
                    m a = m.a(b.this.fKx, i2, 20, 1);
                    a.a(new m.a() { // from class: com.baidu.tieba.pb.view.b.6.1
                        @Override // com.baidu.tbadk.core.util.m.a
                        public void yj() {
                            b.this.fKx.setVisibility(8);
                            if (b.this.fKx.getTag() != null) {
                                ((m) b.this.fKx.getTag()).stop();
                            }
                            b.this.fKx.setTag(null);
                        }
                    });
                    b.this.fKx.setTag(a);
                    a.b(b.this.fKx);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fKt != null && this.mAnchorView != null) {
            if (z) {
                Rect rect = new Rect();
                this.mAnchorView.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(this.fKC);
                    this.fKz.setVisibility(0);
                    bhD();
                    return;
                }
                this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fKC);
                this.fKz.setVisibility(8);
                return;
            }
            this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fKC);
            this.fKz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
        if (!this.fKt.arQ()) {
            int[] iArr = new int[2];
            this.fKv.getLocationOnScreen(iArr);
            this.fKz.setLayoutParams(new FrameLayout.LayoutParams(this.fKv.getWidth(), this.fKv.getHeight()));
            this.fKz.setX(iArr[0]);
            this.fKz.setY(iArr[1]);
            this.fKz.invalidate();
        }
    }
}
