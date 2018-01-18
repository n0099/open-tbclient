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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d {
    private long doG;
    private e gac;
    private long gad;
    private View gae;
    private ImageView gag;
    private int gah;
    private View gai;
    private View.OnClickListener mClickListener;
    private View oa;
    private boolean gaf = false;
    private Runnable gaj = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gaf && !d.this.gac.asC()) {
                Rect rect = new Rect();
                d.this.oa.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.gac.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.s(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gac.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.gac.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.gac.getWidth(), d.this.gac.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.gai.setX(0.0f);
                d.this.gai.setY(0.0f);
                d.this.gai.setLayoutParams(layoutParams2);
                d.this.gai.invalidate();
                d.this.gac.setVisibility(0);
                d.this.gac.bfZ();
                d.this.gad = System.currentTimeMillis();
            }
        }
    };
    private Runnable gak = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bfY();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener gal = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.gah == 2 && !d.this.gac.asC()) {
                d.this.mHandler.removeCallbacks(d.this.gak);
                d.this.mHandler.postDelayed(d.this.gak, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.gac = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.gac, layoutParams);
        this.gac.setClickable(true);
        this.gag = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.gag.setLayoutParams(layoutParams2);
        frameLayout.addView(this.gag, layoutParams2);
        this.gag.setBackgroundResource(d.C0107d.black_alpha60);
        this.gag.setVisibility(8);
        this.gai = new View(context);
        frameLayout.addView(this.gai, new FrameLayout.LayoutParams(l.s(context, d.e.ds112), l.s(context, d.e.ds112)));
        this.gai.setVisibility(8);
        this.gai.setClickable(true);
    }

    public void sJ(int i) {
        this.gah = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gac != null && d.this.gac.getVisibility() == 0) {
                        d.this.gac.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gai.setOnTouchListener(onTouchListener);
        this.gag.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void cG(View view) {
        this.gae = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.oa == null || this.gae == null) {
            return false;
        }
        if (this.gag.getVisibility() != 0) {
            this.gae.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.doG = System.currentTimeMillis();
                    if (view == this.gai) {
                        this.gaf = true;
                    } else {
                        this.gac.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.gae.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.gaf = true;
                        } else {
                            this.gaf = false;
                        }
                    }
                    if (this.gaf) {
                        this.mHandler.postDelayed(this.gaj, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.doG <= 300 && motionEvent.getRawY() < iArr[1] + this.oa.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.gaj);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.oa);
                            return true;
                        }
                        return true;
                    } else if (this.gaf || this.gac.asC()) {
                        if (this.gac.asC()) {
                            this.gac.getLocationOnScreen(new int[2]);
                            int cw = this.gac.cw((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.gac.bfZ();
                            if (cw != -1) {
                                if (cw == 1) {
                                    tn(1);
                                    i = 1;
                                } else if (cw != 3) {
                                    if (cw == 4) {
                                        i = 4;
                                        tn(4);
                                    } else {
                                        i = 2;
                                    }
                                }
                                ak akVar = new ak("c12182");
                                akVar.s("obj_id", i);
                                TiebaStatic.log(akVar);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_FIRST_FLOOR_PRAISE, Integer.valueOf(i * 11)));
                            }
                            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.bfY();
                                    d.this.gac.bgb();
                                    d.this.gac.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.gaf = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.gaf) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.doG > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.gaj);
                                return true;
                            }
                            if (!this.gac.asC()) {
                                this.gaj.run();
                            }
                            if (currentTimeMillis - this.gad > 800) {
                                this.gac.getLocationOnScreen(new int[2]);
                                this.gac.cv((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void tn(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.gag.setVisibility(0);
                    if (i == 1) {
                        d.this.gag.setPadding(0, 0, 0, l.s(d.this.gag.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.gag.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.gag.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.gag, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void BF() {
                            d.this.gag.setVisibility(8);
                            if (d.this.gag.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.gag.getTag()).stop();
                            }
                            d.this.gag.setTag(null);
                        }
                    });
                    d.this.gag.setTag(a);
                    a.b(d.this.gag);
                }
            }, 200L);
        }
    }

    public void n(boolean z, int i) {
        if (this.gac != null && this.oa != null) {
            if (z) {
                Rect rect = new Rect();
                this.oa.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.oa.getViewTreeObserver().addOnGlobalLayoutListener(this.gal);
                    this.gai.setVisibility(0);
                    bfY();
                    return;
                }
                this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gal);
                this.gai.setVisibility(8);
                return;
            }
            this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gal);
            this.gai.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfY() {
        if (!this.gac.asC()) {
            int[] iArr = new int[2];
            this.gae.getLocationOnScreen(iArr);
            this.gai.setLayoutParams(new FrameLayout.LayoutParams(this.gae.getWidth(), this.gae.getHeight()));
            this.gai.setX(iArr[0]);
            this.gai.setY(iArr[1]);
            this.gai.invalidate();
        }
    }
}
