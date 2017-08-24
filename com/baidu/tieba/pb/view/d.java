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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.b;
/* loaded from: classes.dex */
public class d {
    private View.OnClickListener aYY;
    private long cbF;
    private e fbt;
    private long fbu;
    private View fbv;
    private ImageView fbx;
    private int fby;
    private View fbz;
    private boolean fbw = false;
    private Runnable fbA = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fbw && !d.this.fbt.apQ()) {
                Rect rect = new Rect();
                d.this.fbv.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fbt.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - k.g(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fbt.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                d.this.fbt.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fbt.getWidth(), d.this.fbt.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fbz.setX(0.0f);
                d.this.fbz.setY(0.0f);
                d.this.fbz.setLayoutParams(layoutParams2);
                d.this.fbz.invalidate();
                d.this.fbt.setVisibility(0);
                d.this.fbt.aWQ();
                d.this.fbu = System.currentTimeMillis();
            }
        }
    };
    private Runnable fbB = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aWP();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fbC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fby == 2 && !d.this.fbt.apQ()) {
                d.this.mHandler.removeCallbacks(d.this.fbB);
                d.this.mHandler.postDelayed(d.this.fbB, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fbt = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fbt, layoutParams);
        this.fbt.setClickable(true);
        this.fbx = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fbx.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fbx, layoutParams2);
        this.fbx.setBackgroundResource(d.e.black_alpha60);
        this.fbx.setVisibility(8);
        this.fbz = new View(context);
        frameLayout.addView(this.fbz, new FrameLayout.LayoutParams(k.g(context, d.f.ds112), k.g(context, d.f.ds112)));
        this.fbz.setVisibility(8);
        this.fbz.setClickable(true);
    }

    public void pf(int i) {
        this.fby = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fbt != null && d.this.fbt.getVisibility() == 0) {
                        d.this.fbt.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYY = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fbz.setOnTouchListener(onTouchListener);
        this.fbx.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.fbv = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.fbv == null) {
            return false;
        }
        if (this.fbx.getVisibility() != 0) {
            this.fbv.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cbF = System.currentTimeMillis();
                    if (view == this.fbz) {
                        this.fbw = true;
                    } else {
                        this.fbt.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fbv.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fbw = true;
                        } else {
                            this.fbw = false;
                        }
                    }
                    if (this.fbw) {
                        this.mHandler.postDelayed(this.fbA, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cbF <= 300 && motionEvent.getRawY() < iArr[1] + this.fbv.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.fbA);
                        if (this.aYY != null) {
                            this.aYY.onClick(this.fbv);
                            return true;
                        }
                        return true;
                    } else if (this.fbw || this.fbt.apQ()) {
                        if (this.fbt.apQ()) {
                            this.fbt.getLocationOnScreen(new int[2]);
                            int bo = this.fbt.bo((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fbt.aWQ();
                            if (bo != -1) {
                                if (bo == 1) {
                                    pV(1);
                                    i = 1;
                                } else if (bo != 3) {
                                    if (bo == 4) {
                                        i = 4;
                                        pV(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                aj ajVar = new aj("c12182");
                                ajVar.r("obj_id", i);
                                TiebaStatic.log(ajVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.aWP();
                                    d.this.fbt.aWS();
                                    d.this.fbt.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fbw = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fbw) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cbF > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fbA);
                                return true;
                            }
                            if (!this.fbt.apQ()) {
                                this.fbA.run();
                            }
                            if (currentTimeMillis - this.fbu > 800) {
                                this.fbt.getLocationOnScreen(new int[2]);
                                this.fbt.bn((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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
                    d.this.fbx.setVisibility(0);
                    if (i == 1) {
                        d.this.fbx.setPadding(0, 0, 0, k.g(d.this.fbx.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.fbx.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.fbx.invalidate();
                    com.baidu.tieba.pb.pb.main.view.b b = com.baidu.tieba.pb.pb.main.view.b.b(d.this.fbx, i2, 20, 1);
                    b.a(new b.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tieba.pb.pb.main.view.b.a
                        public void aVe() {
                            d.this.fbx.setVisibility(8);
                            if (d.this.fbx.getTag() != null) {
                                ((com.baidu.tieba.pb.pb.main.view.b) d.this.fbx.getTag()).stop();
                            }
                            d.this.fbx.setTag(null);
                        }
                    });
                    d.this.fbx.setTag(b);
                    b.start();
                }
            }, 200L);
        }
    }

    public void cg(boolean z) {
        if (this.fbt != null && this.fbv != null) {
            if (z) {
                Rect rect = new Rect();
                this.fbv.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.fbv.getViewTreeObserver().addOnGlobalLayoutListener(this.fbC);
                    this.fbz.setVisibility(0);
                    return;
                }
                this.fbv.getViewTreeObserver().removeGlobalOnLayoutListener(this.fbC);
                this.fbz.setVisibility(8);
                return;
            }
            this.fbv.getViewTreeObserver().removeGlobalOnLayoutListener(this.fbC);
            this.fbz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWP() {
        if (!this.fbt.apQ()) {
            int[] iArr = new int[2];
            this.fbv.getLocationOnScreen(iArr);
            this.fbz.setLayoutParams(new FrameLayout.LayoutParams(k.g(this.fbz.getContext(), d.f.ds112), k.g(this.fbz.getContext(), d.f.ds112)));
            this.fbz.setX(iArr[0]);
            this.fbz.setY(iArr[1]);
            this.fbz.invalidate();
        }
    }
}
