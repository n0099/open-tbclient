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
    private long cKC;
    private PbMainFloorPraiseFloatingView fxV;
    private long fxW;
    private View fxX;
    private ImageView fxZ;
    private int fya;
    private View fyb;
    private View mAnchorView;
    private View.OnClickListener mClickListener;
    private boolean fxY = false;
    private Runnable fyc = new Runnable() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fxY && !b.this.fxV.anM()) {
                Rect rect = new Rect();
                b.this.mAnchorView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                b.this.fxV.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.e(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.fxV.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                b.this.fxV.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.fxV.getWidth(), b.this.fxV.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                b.this.fyb.setX(0.0f);
                b.this.fyb.setY(0.0f);
                b.this.fyb.setLayoutParams(layoutParams2);
                b.this.fyb.invalidate();
                b.this.fxV.setVisibility(0);
                b.this.fxV.bcE();
                b.this.fxW = System.currentTimeMillis();
            }
        }
    };
    private Runnable fyd = new Runnable() { // from class: com.baidu.tieba.pb.view.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bcD();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fye = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.b.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.fya == 2 && !b.this.fxV.anM()) {
                b.this.mHandler.removeCallbacks(b.this.fyd);
                b.this.mHandler.postDelayed(b.this.fyd, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public b(Context context, FrameLayout frameLayout) {
        this.fxV = new PbMainFloorPraiseFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fxV, layoutParams);
        this.fxV.setClickable(true);
        this.fxZ = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fxZ.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fxZ, layoutParams2);
        this.fxZ.setBackgroundResource(d.C0126d.black_alpha60);
        this.fxZ.setVisibility(8);
        this.fyb = new View(context);
        frameLayout.addView(this.fyb, new FrameLayout.LayoutParams(l.e(context, d.e.ds112), l.e(context, d.e.ds112)));
        this.fyb.setVisibility(8);
        this.fyb.setClickable(true);
    }

    public void qj(int i) {
        this.fya = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fxV != null && b.this.fxV.getVisibility() == 0) {
                        b.this.fxV.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fyb.setOnTouchListener(onTouchListener);
        this.fxZ.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view2) {
        this.mAnchorView = view2;
    }

    public void bl(View view2) {
        this.fxX = view2;
    }

    public boolean onTouch(View view2, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.mAnchorView == null || this.fxX == null) {
            return false;
        }
        if (this.fxZ.getVisibility() != 0) {
            this.fxX.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cKC = System.currentTimeMillis();
                    if (view2 == this.fyb) {
                        this.fxY = true;
                    } else {
                        this.fxV.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fxX.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fxY = true;
                        } else {
                            this.fxY = false;
                        }
                    }
                    if (this.fxY) {
                        this.mHandler.postDelayed(this.fyc, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cKC <= 300 && motionEvent.getRawY() < iArr[1] + this.mAnchorView.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fyc);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.mAnchorView);
                            return true;
                        }
                        return true;
                    } else if (this.fxY || this.fxV.anM()) {
                        if (this.fxV.anM()) {
                            this.fxV.getLocationOnScreen(new int[2]);
                            int bt = this.fxV.bt((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fxV.bcE();
                            if (bt != -1) {
                                if (bt == 1) {
                                    qO(1);
                                    i = 1;
                                } else if (bt != 3) {
                                    if (bt == 4) {
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
                                    b.this.fxV.bcG();
                                    b.this.fxV.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fxY = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fxY) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cKC > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fyc);
                                return true;
                            }
                            if (!this.fxV.anM()) {
                                this.fyc.run();
                            }
                            if (currentTimeMillis - this.fxW > 800) {
                                this.fxV.getLocationOnScreen(new int[2]);
                                this.fxV.bs((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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
                    b.this.fxZ.setVisibility(0);
                    if (i == 1) {
                        b.this.fxZ.setPadding(0, 0, 0, l.e(b.this.fxZ.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        b.this.fxZ.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    b.this.fxZ.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(b.this.fxZ, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.b.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void uJ() {
                            b.this.fxZ.setVisibility(8);
                            if (b.this.fxZ.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) b.this.fxZ.getTag()).stop();
                            }
                            b.this.fxZ.setTag(null);
                        }
                    });
                    b.this.fxZ.setTag(a);
                    a.b(b.this.fxZ);
                }
            }, 200L);
        }
    }

    public void k(boolean z, int i) {
        if (this.fxV != null && this.mAnchorView != null) {
            if (z) {
                Rect rect = new Rect();
                this.mAnchorView.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(this.fye);
                    this.fyb.setVisibility(0);
                    bcD();
                    return;
                }
                this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fye);
                this.fyb.setVisibility(8);
                return;
            }
            this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fye);
            this.fyb.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcD() {
        if (!this.fxV.anM()) {
            int[] iArr = new int[2];
            this.fxX.getLocationOnScreen(iArr);
            this.fyb.setLayoutParams(new FrameLayout.LayoutParams(this.fxX.getWidth(), this.fxX.getHeight()));
            this.fyb.setX(iArr[0]);
            this.fyb.setY(iArr[1]);
            this.fyb.invalidate();
        }
    }
}
