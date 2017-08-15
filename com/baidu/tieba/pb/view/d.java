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
    private View.OnClickListener aYX;
    private long cbE;
    private e fbr;
    private long fbs;
    private View fbt;
    private ImageView fbv;
    private int fbw;
    private View fbx;
    private boolean fbu = false;
    private Runnable fby = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.fbu && !d.this.fbr.apW()) {
                Rect rect = new Rect();
                d.this.fbt.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.fbr.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - k.g(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.fbr.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                d.this.fbr.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.fbr.getWidth(), d.this.fbr.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.fbx.setX(0.0f);
                d.this.fbx.setY(0.0f);
                d.this.fbx.setLayoutParams(layoutParams2);
                d.this.fbx.invalidate();
                d.this.fbr.setVisibility(0);
                d.this.fbr.aWV();
                d.this.fbs = System.currentTimeMillis();
            }
        }
    };
    private Runnable fbz = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aWU();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener fbA = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.fbw == 2 && !d.this.fbr.apW()) {
                d.this.mHandler.removeCallbacks(d.this.fbz);
                d.this.mHandler.postDelayed(d.this.fbz, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.fbr = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.fbr, layoutParams);
        this.fbr.setClickable(true);
        this.fbv = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.fbv.setLayoutParams(layoutParams2);
        frameLayout.addView(this.fbv, layoutParams2);
        this.fbv.setBackgroundResource(d.e.black_alpha60);
        this.fbv.setVisibility(8);
        this.fbx = new View(context);
        frameLayout.addView(this.fbx, new FrameLayout.LayoutParams(k.g(context, d.f.ds112), k.g(context, d.f.ds112)));
        this.fbx.setVisibility(8);
        this.fbx.setClickable(true);
    }

    public void pf(int i) {
        this.fbw = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.fbr != null && d.this.fbr.getVisibility() == 0) {
                        d.this.fbr.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYX = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fbx.setOnTouchListener(onTouchListener);
        this.fbv.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.fbt = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.fbt == null) {
            return false;
        }
        if (this.fbv.getVisibility() != 0) {
            this.fbt.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.cbE = System.currentTimeMillis();
                    if (view == this.fbx) {
                        this.fbu = true;
                    } else {
                        this.fbr.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.fbt.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.fbu = true;
                        } else {
                            this.fbu = false;
                        }
                    }
                    if (this.fbu) {
                        this.mHandler.postDelayed(this.fby, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.cbE <= 300 && motionEvent.getRawY() < iArr[1] + this.fbt.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.fby);
                        if (this.aYX != null) {
                            this.aYX.onClick(this.fbt);
                            return true;
                        }
                        return true;
                    } else if (this.fbu || this.fbr.apW()) {
                        if (this.fbr.apW()) {
                            this.fbr.getLocationOnScreen(new int[2]);
                            int bo = this.fbr.bo((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.fbr.aWV();
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
                                    d.this.aWU();
                                    d.this.fbr.aWX();
                                    d.this.fbr.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.fbu = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.fbu) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.cbE > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.fby);
                                return true;
                            }
                            if (!this.fbr.apW()) {
                                this.fby.run();
                            }
                            if (currentTimeMillis - this.fbs > 800) {
                                this.fbr.getLocationOnScreen(new int[2]);
                                this.fbr.bn((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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
                    d.this.fbv.setVisibility(0);
                    if (i == 1) {
                        d.this.fbv.setPadding(0, 0, 0, k.g(d.this.fbv.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.fbv.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.fbv.invalidate();
                    com.baidu.tieba.pb.pb.main.view.b b = com.baidu.tieba.pb.pb.main.view.b.b(d.this.fbv, i2, 20, 1);
                    b.a(new b.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tieba.pb.pb.main.view.b.a
                        public void aVj() {
                            d.this.fbv.setVisibility(8);
                            if (d.this.fbv.getTag() != null) {
                                ((com.baidu.tieba.pb.pb.main.view.b) d.this.fbv.getTag()).stop();
                            }
                            d.this.fbv.setTag(null);
                        }
                    });
                    d.this.fbv.setTag(b);
                    b.start();
                }
            }, 200L);
        }
    }

    public void cg(boolean z) {
        if (this.fbr != null && this.fbt != null) {
            if (z) {
                Rect rect = new Rect();
                this.fbt.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.fbt.getViewTreeObserver().addOnGlobalLayoutListener(this.fbA);
                    this.fbx.setVisibility(0);
                    return;
                }
                this.fbt.getViewTreeObserver().removeGlobalOnLayoutListener(this.fbA);
                this.fbx.setVisibility(8);
                return;
            }
            this.fbt.getViewTreeObserver().removeGlobalOnLayoutListener(this.fbA);
            this.fbx.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWU() {
        if (!this.fbr.apW()) {
            int[] iArr = new int[2];
            this.fbt.getLocationOnScreen(iArr);
            this.fbx.setLayoutParams(new FrameLayout.LayoutParams(k.g(this.fbx.getContext(), d.f.ds112), k.g(this.fbx.getContext(), d.f.ds112)));
            this.fbx.setX(iArr[0]);
            this.fbx.setY(iArr[1]);
            this.fbx.invalidate();
        }
    }
}
