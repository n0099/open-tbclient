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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b {
    private long cVx;
    private ImageView fOB;
    private int fOC;
    private View fOD;
    private PbMainFloorPraiseFloatingView fOx;
    private long fOy;
    private View fOz;
    private View mAnchorView;
    private View.OnClickListener mClickListener;
    private boolean fOA = false;
    private Runnable fOE = new Runnable() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fOA && !b.this.fOx.arL()) {
                Rect rect = new Rect();
                b.this.mAnchorView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                b.this.fOx.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), f.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.fOx.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                b.this.fOx.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.fOx.getWidth(), b.this.fOx.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                b.this.fOD.setX(0.0f);
                b.this.fOD.setY(0.0f);
                b.this.fOD.setLayoutParams(layoutParams2);
                b.this.fOD.invalidate();
                b.this.fOx.setVisibility(0);
                b.this.fOx.bgy();
                b.this.fOy = System.currentTimeMillis();
            }
        }
    };
    private Runnable fOF = new Runnable() { // from class: com.baidu.tieba.pb.view.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bgx();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fOG = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.b.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.fOC == 2 && !b.this.fOx.arL()) {
                b.this.mHandler.removeCallbacks(b.this.fOF);
                b.this.mHandler.postDelayed(b.this.fOF, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public b(Context context, FrameLayout frameLayout) {
        this.fOx = new PbMainFloorPraiseFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fOx, layoutParams);
        this.fOx.setClickable(true);
        this.fOB = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fOB.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fOB, layoutParams2);
        this.fOB.setBackgroundResource(f.d.black_alpha60);
        this.fOB.setVisibility(8);
        this.fOD = new View(context);
        frameLayout.addView(this.fOD, new FrameLayout.LayoutParams(l.f(context, f.e.ds112), l.f(context, f.e.ds112)));
        this.fOD.setVisibility(8);
        this.fOD.setClickable(true);
    }

    public void qy(int i) {
        this.fOC = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fOx != null && b.this.fOx.getVisibility() == 0) {
                        b.this.fOx.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fOD.setOnTouchListener(onTouchListener);
        this.fOB.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void bs(View view) {
        this.fOz = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.mAnchorView == null || this.fOz == null) {
            return false;
        }
        if (this.fOB.getVisibility() != 0) {
            this.fOz.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cVx = System.currentTimeMillis();
                    if (view == this.fOD) {
                        this.fOA = true;
                    } else {
                        this.fOx.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fOz.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fOA = true;
                        } else {
                            this.fOA = false;
                        }
                    }
                    if (this.fOA) {
                        this.mHandler.postDelayed(this.fOE, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cVx <= 300 && motionEvent.getRawY() < iArr[1] + this.mAnchorView.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fOE);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.mAnchorView);
                            return true;
                        }
                        return true;
                    } else if (this.fOA || this.fOx.arL()) {
                        if (this.fOx.arL()) {
                            this.fOx.getLocationOnScreen(new int[2]);
                            int bu = this.fOx.bu((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fOx.bgy();
                            if (bu != -1) {
                                if (bu == 1) {
                                    re(1);
                                    i = 1;
                                } else if (bu != 3) {
                                    if (bu == 4) {
                                        i = 4;
                                        re(4);
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
                                    b.this.bgx();
                                    b.this.fOx.bgA();
                                    b.this.fOx.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fOA = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fOA) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cVx > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fOE);
                                return true;
                            }
                            if (!this.fOx.arL()) {
                                this.fOE.run();
                            }
                            if (currentTimeMillis - this.fOy > 800) {
                                this.fOx.getLocationOnScreen(new int[2]);
                                this.fOx.bt((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void re(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    b.this.fOB.setVisibility(0);
                    if (i == 1) {
                        b.this.fOB.setPadding(0, 0, 0, l.f(b.this.fOB.getContext(), f.e.ds70));
                        i2 = f.b.full_screen_big_praise;
                    } else if (i == 4) {
                        b.this.fOB.setPadding(0, 0, 0, 0);
                        i2 = f.b.full_screen_big_trample;
                    }
                    b.this.fOB.invalidate();
                    m a = m.a(b.this.fOB, i2, 20, 1);
                    a.a(new m.a() { // from class: com.baidu.tieba.pb.view.b.6.1
                        @Override // com.baidu.tbadk.core.util.m.a
                        public void ym() {
                            b.this.fOB.setVisibility(8);
                            if (b.this.fOB.getTag() != null) {
                                ((m) b.this.fOB.getTag()).stop();
                            }
                            b.this.fOB.setTag(null);
                        }
                    });
                    b.this.fOB.setTag(a);
                    a.b(b.this.fOB);
                }
            }, 200L);
        }
    }

    public void j(boolean z, int i) {
        if (this.fOx != null && this.mAnchorView != null) {
            if (z) {
                Rect rect = new Rect();
                this.mAnchorView.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(this.fOG);
                    this.fOD.setVisibility(0);
                    bgx();
                    return;
                }
                this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fOG);
                this.fOD.setVisibility(8);
                return;
            }
            this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fOG);
            this.fOD.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgx() {
        if (!this.fOx.arL()) {
            int[] iArr = new int[2];
            this.fOz.getLocationOnScreen(iArr);
            this.fOD.setLayoutParams(new FrameLayout.LayoutParams(this.fOz.getWidth(), this.fOz.getHeight()));
            this.fOD.setX(iArr[0]);
            this.fOD.setY(iArr[1]);
            this.fOD.invalidate();
        }
    }
}
