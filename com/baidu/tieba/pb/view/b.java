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
    private long cVB;
    private PbMainFloorPraiseFloatingView fOE;
    private long fOF;
    private View fOG;
    private ImageView fOI;
    private int fOJ;
    private View fOK;
    private View mAnchorView;
    private View.OnClickListener mClickListener;
    private boolean fOH = false;
    private Runnable fOL = new Runnable() { // from class: com.baidu.tieba.pb.view.b.1
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.fOH && !b.this.fOE.arL()) {
                Rect rect = new Rect();
                b.this.mAnchorView.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                b.this.fOE.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.f(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.fOE.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                b.this.fOE.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.fOE.getWidth(), b.this.fOE.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                b.this.fOK.setX(0.0f);
                b.this.fOK.setY(0.0f);
                b.this.fOK.setLayoutParams(layoutParams2);
                b.this.fOK.invalidate();
                b.this.fOE.setVisibility(0);
                b.this.fOE.bgD();
                b.this.fOF = System.currentTimeMillis();
            }
        }
    };
    private Runnable fOM = new Runnable() { // from class: com.baidu.tieba.pb.view.b.2
        @Override // java.lang.Runnable
        public void run() {
            b.this.bgC();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fON = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.b.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.fOJ == 2 && !b.this.fOE.arL()) {
                b.this.mHandler.removeCallbacks(b.this.fOM);
                b.this.mHandler.postDelayed(b.this.fOM, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public b(Context context, FrameLayout frameLayout) {
        this.fOE = new PbMainFloorPraiseFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fOE, layoutParams);
        this.fOE.setClickable(true);
        this.fOI = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fOI.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fOI, layoutParams2);
        this.fOI.setBackgroundResource(d.C0140d.black_alpha60);
        this.fOI.setVisibility(8);
        this.fOK = new View(context);
        frameLayout.addView(this.fOK, new FrameLayout.LayoutParams(l.f(context, d.e.ds112), l.f(context, d.e.ds112)));
        this.fOK.setVisibility(8);
        this.fOK.setClickable(true);
    }

    public void qy(int i) {
        this.fOJ = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.fOE != null && b.this.fOE.getVisibility() == 0) {
                        b.this.fOE.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fOK.setOnTouchListener(onTouchListener);
        this.fOI.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void bs(View view) {
        this.fOG = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.mAnchorView == null || this.fOG == null) {
            return false;
        }
        if (this.fOI.getVisibility() != 0) {
            this.fOG.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cVB = System.currentTimeMillis();
                    if (view == this.fOK) {
                        this.fOH = true;
                    } else {
                        this.fOE.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fOG.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fOH = true;
                        } else {
                            this.fOH = false;
                        }
                    }
                    if (this.fOH) {
                        this.mHandler.postDelayed(this.fOL, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cVB <= 300 && motionEvent.getRawY() < iArr[1] + this.mAnchorView.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.fOL);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.mAnchorView);
                            return true;
                        }
                        return true;
                    } else if (this.fOH || this.fOE.arL()) {
                        if (this.fOE.arL()) {
                            this.fOE.getLocationOnScreen(new int[2]);
                            int bu = this.fOE.bu((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fOE.bgD();
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
                                    b.this.bgC();
                                    b.this.fOE.bgF();
                                    b.this.fOE.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fOH = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fOH) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cVB > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fOL);
                                return true;
                            }
                            if (!this.fOE.arL()) {
                                this.fOL.run();
                            }
                            if (currentTimeMillis - this.fOF > 800) {
                                this.fOE.getLocationOnScreen(new int[2]);
                                this.fOE.bt((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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
                    b.this.fOI.setVisibility(0);
                    if (i == 1) {
                        b.this.fOI.setPadding(0, 0, 0, l.f(b.this.fOI.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        b.this.fOI.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    b.this.fOI.invalidate();
                    m a = m.a(b.this.fOI, i2, 20, 1);
                    a.a(new m.a() { // from class: com.baidu.tieba.pb.view.b.6.1
                        @Override // com.baidu.tbadk.core.util.m.a
                        public void yo() {
                            b.this.fOI.setVisibility(8);
                            if (b.this.fOI.getTag() != null) {
                                ((m) b.this.fOI.getTag()).stop();
                            }
                            b.this.fOI.setTag(null);
                        }
                    });
                    b.this.fOI.setTag(a);
                    a.b(b.this.fOI);
                }
            }, 200L);
        }
    }

    public void j(boolean z, int i) {
        if (this.fOE != null && this.mAnchorView != null) {
            if (z) {
                Rect rect = new Rect();
                this.mAnchorView.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.mAnchorView.getViewTreeObserver().addOnGlobalLayoutListener(this.fON);
                    this.fOK.setVisibility(0);
                    bgC();
                    return;
                }
                this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fON);
                this.fOK.setVisibility(8);
                return;
            }
            this.mAnchorView.getViewTreeObserver().removeGlobalOnLayoutListener(this.fON);
            this.fOK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgC() {
        if (!this.fOE.arL()) {
            int[] iArr = new int[2];
            this.fOG.getLocationOnScreen(iArr);
            this.fOK.setLayoutParams(new FrameLayout.LayoutParams(this.fOG.getWidth(), this.fOG.getHeight()));
            this.fOK.setX(iArr[0]);
            this.fOK.setY(iArr[1]);
            this.fOK.invalidate();
        }
    }
}
