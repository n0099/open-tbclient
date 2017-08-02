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
    private View.OnClickListener aXL;
    private long bZM;
    private e eYm;
    private long eYn;
    private View eYo;
    private ImageView eYq;
    private int eYr;
    private View eYs;
    private boolean eYp = false;
    private Runnable eYt = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.eYp && !d.this.eYm.apd()) {
                Rect rect = new Rect();
                d.this.eYo.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.eYm.getGlobalVisibleRect(rect2);
                int g = (rect.bottom - ((rect.bottom - rect.top) / 2)) - (rect2.bottom - k.g(TbadkCoreApplication.getInst(), d.f.ds112));
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.eYm.getLayoutParams();
                layoutParams.setMargins(0, g + layoutParams.topMargin, 0, 0);
                d.this.eYm.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.eYm.getWidth(), d.this.eYm.getHeight());
                layoutParams2.setMargins(0, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.eYs.setX(0.0f);
                d.this.eYs.setY(0.0f);
                d.this.eYs.setLayoutParams(layoutParams2);
                d.this.eYs.invalidate();
                d.this.eYm.setVisibility(0);
                d.this.eYm.aWd();
                d.this.eYn = System.currentTimeMillis();
            }
        }
    };
    private Runnable eYu = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.aWc();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener eYv = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.eYr == 2 && !d.this.eYm.apd()) {
                d.this.mHandler.removeCallbacks(d.this.eYu);
                d.this.mHandler.postDelayed(d.this.eYu, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.eYm = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.eYm, layoutParams);
        this.eYm.setClickable(true);
        this.eYq = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.eYq.setLayoutParams(layoutParams2);
        frameLayout.addView(this.eYq, layoutParams2);
        this.eYq.setBackgroundResource(d.e.black_alpha60);
        this.eYq.setVisibility(8);
        this.eYs = new View(context);
        frameLayout.addView(this.eYs, new FrameLayout.LayoutParams(k.g(context, d.f.ds112), k.g(context, d.f.ds112)));
        this.eYs.setVisibility(8);
        this.eYs.setClickable(true);
    }

    public void oW(int i) {
        this.eYr = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.eYm != null && d.this.eYm.getVisibility() == 0) {
                        d.this.eYm.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aXL = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eYs.setOnTouchListener(onTouchListener);
        this.eYq.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.eYo = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.eYo == null) {
            return false;
        }
        if (this.eYq.getVisibility() != 0) {
            this.eYo.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bZM = System.currentTimeMillis();
                    if (view == this.eYs) {
                        this.eYp = true;
                    } else {
                        this.eYm.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.eYo.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.eYp = true;
                        } else {
                            this.eYp = false;
                        }
                    }
                    if (this.eYp) {
                        this.mHandler.postDelayed(this.eYt, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.bZM <= 300 && motionEvent.getRawY() < iArr[1] + this.eYo.getHeight() + 30 && motionEvent.getRawY() > iArr[1] + 30) {
                        this.mHandler.removeCallbacks(this.eYt);
                        if (this.aXL != null) {
                            this.aXL.onClick(this.eYo);
                            return true;
                        }
                        return true;
                    } else if (this.eYp || this.eYm.apd()) {
                        if (this.eYm.apd()) {
                            this.eYm.getLocationOnScreen(new int[2]);
                            int bf = this.eYm.bf((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.eYm.aWd();
                            if (bf != -1) {
                                if (bf == 1) {
                                    pM(1);
                                    i = 1;
                                } else if (bf != 3) {
                                    if (bf == 4) {
                                        i = 4;
                                        pM(4);
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
                                    d.this.aWc();
                                    d.this.eYm.aWf();
                                    d.this.eYm.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.eYp = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.eYp) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.bZM > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.eYt);
                                return true;
                            }
                            if (!this.eYm.apd()) {
                                this.eYt.run();
                            }
                            if (currentTimeMillis - this.eYn > 800) {
                                this.eYm.getLocationOnScreen(new int[2]);
                                this.eYm.be((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void pM(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.eYq.setVisibility(0);
                    if (i == 1) {
                        d.this.eYq.setPadding(0, 0, 0, k.g(d.this.eYq.getContext(), d.f.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.eYq.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.eYq.invalidate();
                    com.baidu.tieba.pb.pb.main.view.b b = com.baidu.tieba.pb.pb.main.view.b.b(d.this.eYq, i2, 20, 1);
                    b.a(new b.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tieba.pb.pb.main.view.b.a
                        public void aUr() {
                            d.this.eYq.setVisibility(8);
                            if (d.this.eYq.getTag() != null) {
                                ((com.baidu.tieba.pb.pb.main.view.b) d.this.eYq.getTag()).stop();
                            }
                            d.this.eYq.setTag(null);
                        }
                    });
                    d.this.eYq.setTag(b);
                    b.start();
                }
            }, 200L);
        }
    }

    public void cg(boolean z) {
        if (this.eYm != null && this.eYo != null) {
            if (z) {
                Rect rect = new Rect();
                this.eYo.getGlobalVisibleRect(rect);
                if (rect.top > 0) {
                    this.eYo.getViewTreeObserver().addOnGlobalLayoutListener(this.eYv);
                    this.eYs.setVisibility(0);
                    return;
                }
                this.eYo.getViewTreeObserver().removeGlobalOnLayoutListener(this.eYv);
                this.eYs.setVisibility(8);
                return;
            }
            this.eYo.getViewTreeObserver().removeGlobalOnLayoutListener(this.eYv);
            this.eYs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWc() {
        if (!this.eYm.apd()) {
            int[] iArr = new int[2];
            this.eYo.getLocationOnScreen(iArr);
            this.eYs.setLayoutParams(new FrameLayout.LayoutParams(k.g(this.eYs.getContext(), d.f.ds112), k.g(this.eYs.getContext(), d.f.ds112)));
            this.eYs.setX(iArr[0]);
            this.eYs.setY(iArr[1]);
            this.eYs.invalidate();
        }
    }
}
