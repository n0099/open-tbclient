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
    private long drU;
    private e gdE;
    private long gdF;
    private View gdG;
    private ImageView gdI;
    private int gdJ;
    private View gdK;
    private View.OnClickListener mClickListener;
    private View oa;
    private boolean gdH = false;
    private Runnable gdL = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gdH && !d.this.gdE.atx()) {
                Rect rect = new Rect();
                d.this.oa.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.gdE.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.t(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gdE.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.gdE.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.gdE.getWidth(), d.this.gdE.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.gdK.setX(0.0f);
                d.this.gdK.setY(0.0f);
                d.this.gdK.setLayoutParams(layoutParams2);
                d.this.gdK.invalidate();
                d.this.gdE.setVisibility(0);
                d.this.gdE.bhE();
                d.this.gdF = System.currentTimeMillis();
            }
        }
    };
    private Runnable gdM = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bhD();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener gdN = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.gdJ == 2 && !d.this.gdE.atx()) {
                d.this.mHandler.removeCallbacks(d.this.gdM);
                d.this.mHandler.postDelayed(d.this.gdM, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.gdE = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.gdE, layoutParams);
        this.gdE.setClickable(true);
        this.gdI = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.gdI.setLayoutParams(layoutParams2);
        frameLayout.addView(this.gdI, layoutParams2);
        this.gdI.setBackgroundResource(d.C0140d.black_alpha60);
        this.gdI.setVisibility(8);
        this.gdK = new View(context);
        frameLayout.addView(this.gdK, new FrameLayout.LayoutParams(l.t(context, d.e.ds112), l.t(context, d.e.ds112)));
        this.gdK.setVisibility(8);
        this.gdK.setClickable(true);
    }

    public void sM(int i) {
        this.gdJ = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gdE != null && d.this.gdE.getVisibility() == 0) {
                        d.this.gdE.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gdK.setOnTouchListener(onTouchListener);
        this.gdI.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void cF(View view) {
        this.gdG = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.oa == null || this.gdG == null) {
            return false;
        }
        if (this.gdI.getVisibility() != 0) {
            this.gdG.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.drU = System.currentTimeMillis();
                    if (view == this.gdK) {
                        this.gdH = true;
                    } else {
                        this.gdE.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.gdG.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.gdH = true;
                        } else {
                            this.gdH = false;
                        }
                    }
                    if (this.gdH) {
                        this.mHandler.postDelayed(this.gdL, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.drU <= 300 && motionEvent.getRawY() < iArr[1] + this.oa.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.gdL);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.oa);
                            return true;
                        }
                        return true;
                    } else if (this.gdH || this.gdE.atx()) {
                        if (this.gdE.atx()) {
                            this.gdE.getLocationOnScreen(new int[2]);
                            int cs = this.gdE.cs((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.gdE.bhE();
                            if (cs != -1) {
                                if (cs == 1) {
                                    tr(1);
                                    i = 1;
                                } else if (cs != 3) {
                                    if (cs == 4) {
                                        i = 4;
                                        tr(4);
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
                                    d.this.gdE.bhG();
                                    d.this.gdE.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.gdH = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.gdH) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.drU > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.gdL);
                                return true;
                            }
                            if (!this.gdE.atx()) {
                                this.gdL.run();
                            }
                            if (currentTimeMillis - this.gdF > 800) {
                                this.gdE.getLocationOnScreen(new int[2]);
                                this.gdE.cr((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void tr(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.gdI.setVisibility(0);
                    if (i == 1) {
                        d.this.gdI.setPadding(0, 0, 0, l.t(d.this.gdI.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.gdI.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.gdI.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.gdI, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void BZ() {
                            d.this.gdI.setVisibility(8);
                            if (d.this.gdI.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.gdI.getTag()).stop();
                            }
                            d.this.gdI.setTag(null);
                        }
                    });
                    d.this.gdI.setTag(a);
                    a.b(d.this.gdI);
                }
            }, 200L);
        }
    }

    public void o(boolean z, int i) {
        if (this.gdE != null && this.oa != null) {
            if (z) {
                Rect rect = new Rect();
                this.oa.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.oa.getViewTreeObserver().addOnGlobalLayoutListener(this.gdN);
                    this.gdK.setVisibility(0);
                    bhD();
                    return;
                }
                this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gdN);
                this.gdK.setVisibility(8);
                return;
            }
            this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gdN);
            this.gdK.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhD() {
        if (!this.gdE.atx()) {
            int[] iArr = new int[2];
            this.gdG.getLocationOnScreen(iArr);
            this.gdK.setLayoutParams(new FrameLayout.LayoutParams(this.gdG.getWidth(), this.gdG.getHeight()));
            this.gdK.setX(iArr[0]);
            this.gdK.setY(iArr[1]);
            this.gdK.invalidate();
        }
    }
}
