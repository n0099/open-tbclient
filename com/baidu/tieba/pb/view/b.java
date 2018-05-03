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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b {
    private long cKz;
    private PbMainFloorPraiseFloatingView fxS;
    private long fxT;
    private View fxU;
    private ImageView fxW;
    private int fxX;
    private View fxY;
    private View mAnchorView;
    private View.OnClickListener mClickListener;
    private boolean fxV = false;
    private Runnable fxZ = new Runnable() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fxV && !b.this.fxS.anM()) {
                Rect rect = new Rect();
                b.this.mAnchorView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                b.this.fxS.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.e(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.fxS.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                b.this.fxS.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.fxS.getWidth(), b.this.fxS.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                b.this.fxY.setX(0.0f);
                b.this.fxY.setY(0.0f);
                b.this.fxY.setLayoutParams(layoutParams2);
                b.this.fxY.invalidate();
                b.this.fxS.setVisibility(0);
                b.this.fxS.bcE();
                b.this.fxT = System.currentTimeMillis();
            }
        }
    };
    private Runnable fya = new Runnable() { // from class: com.baidu.tieba.pb.view.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bcD();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fyb = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.b.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.fxX == 2 && !b.this.fxS.anM()) {
                b.this.mHandler.removeCallbacks(b.this.fya);
                b.this.mHandler.postDelayed(b.this.fya, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public b(Context context, FrameLayout frameLayout) {
        this.fxS = new PbMainFloorPraiseFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fxS, layoutParams);
        this.fxS.setClickable(true);
        this.fxW = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fxW.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fxW, layoutParams2);
        this.fxW.setBackgroundResource(d.C0126d.black_alpha60);
        this.fxW.setVisibility(8);
        this.fxY = new View(context);
        frameLayout.addView(this.fxY, new FrameLayout.LayoutParams(l.e(context, d.e.ds112), l.e(context, d.e.ds112)));
        this.fxY.setVisibility(8);
        this.fxY.setClickable(true);
    }

    public void qj(int i) {
        this.fxX = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fxS != null && b.this.fxS.getVisibility() == 0) {
                        b.this.fxS.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fxY.setOnTouchListener(onTouchListener);
        this.fxW.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view2) {
        this.mAnchorView = view2;
    }

    public void bl(View view2) {
        this.fxU = view2;
    }

    public boolean onTouch(View view2, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.mAnchorView == null || this.fxU == null) {
            return false;
        }
        if (this.fxW.getVisibility() != 0) {
            this.fxU.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cKz = System.currentTimeMillis();
                    if (view2 == this.fxY) {
                        this.fxV = true;
                    } else {
                        this.fxS.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fxU.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fxV = true;
                        } else {
                            this.fxV = false;
                        }
                    }
                    if (this.fxV) {
                        this.mHandler.postDelayed(this.fxZ, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cKz <= 300 && motionEvent.getRawY() < iArr[1] + this.mAnchorView.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fxZ);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.mAnchorView);
                            return true;
                        }
                        return true;
                    } else if (this.fxV || this.fxS.anM()) {
                        if (this.fxS.anM()) {
                            this.fxS.getLocationOnScreen(new int[2]);
                            int bs = this.fxS.bs((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fxS.bcE();
                            if (bs != -1) {
                                if (bs == 1) {
                                    qO(1);
                                    i = 1;
                                } else if (bs != 3) {
                                    if (bs == 4) {
                                        i = 4;
                                        qO(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                al alVar = new al("c12182");
                                alVar.r(VideoPlayActivityConfig.OBJ_ID, i);
                                TiebaStatic.log(alVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.bcD();
                                    b.this.fxS.bcG();
                                    b.this.fxS.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fxV = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fxV) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cKz > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fxZ);
                                return true;
                            }
                            if (!this.fxS.anM()) {
                                this.fxZ.run();
                            }
                            if (currentTimeMillis - this.fxT > 800) {
                                this.fxS.getLocationOnScreen(new int[2]);
                                this.fxS.br((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void qO(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    b.this.fxW.setVisibility(0);
                    if (i == 1) {
                        b.this.fxW.setPadding(0, 0, 0, l.e(b.this.fxW.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        b.this.fxW.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    b.this.fxW.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(b.this.fxW, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.b.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void uJ() {
                            b.this.fxW.setVisibility(8);
                            if (b.this.fxW.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) b.this.fxW.getTag()).stop();
                            }
                            b.this.fxW.setTag(null);
                        }
                    });
                    b.this.fxW.setTag(a);
                    a.b(b.this.fxW);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fxS != null && this.mAnchorView != null) {
            if (z) {
                Rect rect = new Rect();
                this.mAnchorView.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(this.fyb);
                    this.fxY.setVisibility(0);
                    bcD();
                    return;
                }
                this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fyb);
                this.fxY.setVisibility(8);
                return;
            }
            this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fyb);
            this.fxY.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcD() {
        if (!this.fxS.anM()) {
            int[] iArr = new int[2];
            this.fxU.getLocationOnScreen(iArr);
            this.fxY.setLayoutParams(new FrameLayout.LayoutParams(this.fxU.getWidth(), this.fxU.getHeight()));
            this.fxY.setX(iArr[0]);
            this.fxY.setY(iArr[1]);
            this.fxY.invalidate();
        }
    }
}
