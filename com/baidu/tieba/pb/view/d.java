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
    private long drI;
    private e gdt;
    private long gdu;
    private View gdv;
    private ImageView gdx;
    private int gdy;
    private View gdz;
    private View.OnClickListener mClickListener;
    private View oa;
    private boolean gdw = false;
    private Runnable gdA = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.gdw && !d.this.gdt.atw()) {
                Rect rect = new Rect();
                d.this.oa.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                d.this.gdt.getGlobalVisibleRect(rect2);
                int height = (rect.bottom - (rect.height() / 2)) - (rect2.bottom - l.t(TbadkCoreApplication.getInst(), d.e.ds112));
                int width = ((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.gdt.getLayoutParams();
                layoutParams.setMargins(width + layoutParams.leftMargin, height + layoutParams.topMargin, 0, 0);
                d.this.gdt.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(d.this.gdt.getWidth(), d.this.gdt.getHeight());
                layoutParams2.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, 0);
                layoutParams2.gravity = 1;
                d.this.gdz.setX(0.0f);
                d.this.gdz.setY(0.0f);
                d.this.gdz.setLayoutParams(layoutParams2);
                d.this.gdz.invalidate();
                d.this.gdt.setVisibility(0);
                d.this.gdt.bhD();
                d.this.gdu = System.currentTimeMillis();
            }
        }
    };
    private Runnable gdB = new Runnable() { // from class: com.baidu.tieba.pb.view.d.2
        @Override // java.lang.Runnable
        public void run() {
            d.this.bhC();
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener gdC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.pb.view.d.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.gdy == 2 && !d.this.gdt.atw()) {
                d.this.mHandler.removeCallbacks(d.this.gdB);
                d.this.mHandler.postDelayed(d.this.gdB, 200L);
            }
        }
    };
    private Handler mHandler = new Handler();

    public d(Context context, FrameLayout frameLayout) {
        this.gdt = new e(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        frameLayout.addView(this.gdt, layoutParams);
        this.gdt.setClickable(true);
        this.gdx = new ImageView(context);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.gdx.setLayoutParams(layoutParams2);
        frameLayout.addView(this.gdx, layoutParams2);
        this.gdx.setBackgroundResource(d.C0141d.black_alpha60);
        this.gdx.setVisibility(8);
        this.gdz = new View(context);
        frameLayout.addView(this.gdz, new FrameLayout.LayoutParams(l.t(context, d.e.ds112), l.t(context, d.e.ds112)));
        this.gdz.setVisibility(8);
        this.gdz.setClickable(true);
    }

    public void sN(int i) {
        this.gdy = i;
        if (i == 2) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.gdt != null && d.this.gdt.getVisibility() == 0) {
                        d.this.gdt.setVisibility(8);
                    }
                }
            }, 200L);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gdz.setOnTouchListener(onTouchListener);
        this.gdx.setOnTouchListener(onTouchListener);
    }

    public void setAnchorView(View view) {
        this.oa = view;
    }

    public void cF(View view) {
        this.gdv = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int i = 3;
        if (this.oa == null || this.gdv == null) {
            return false;
        }
        if (this.gdx.getVisibility() != 0) {
            this.gdv.getLocationOnScreen(new int[2]);
            switch (motionEvent.getAction()) {
                case 0:
                    this.drI = System.currentTimeMillis();
                    if (view == this.gdz) {
                        this.gdw = true;
                    } else {
                        this.gdt.getLocationOnScreen(new int[2]);
                        Rect rect = new Rect();
                        this.gdv.getGlobalVisibleRect(rect);
                        if (rect.contains((int) (motionEvent.getX() + iArr4[0]), (int) (iArr4[1] + motionEvent.getY()))) {
                            this.gdw = true;
                        } else {
                            this.gdw = false;
                        }
                    }
                    if (this.gdw) {
                        this.mHandler.postDelayed(this.gdA, 300L);
                        return true;
                    }
                    return false;
                case 1:
                case 3:
                    if (System.currentTimeMillis() - this.drI <= 300 && motionEvent.getRawY() < iArr[1] + this.oa.getHeight() + 30 && motionEvent.getRawY() > iArr[1] - 30) {
                        this.mHandler.removeCallbacks(this.gdA);
                        if (this.mClickListener != null) {
                            this.mClickListener.onClick(this.oa);
                            return true;
                        }
                        return true;
                    } else if (this.gdw || this.gdt.atw()) {
                        if (this.gdt.atw()) {
                            this.gdt.getLocationOnScreen(new int[2]);
                            int cs = this.gdt.cs((int) (motionEvent.getX() + iArr2[0]), (int) (iArr2[1] + motionEvent.getY()));
                            this.gdt.bhD();
                            if (cs != -1) {
                                if (cs == 1) {
                                    ts(1);
                                    i = 1;
                                } else if (cs != 3) {
                                    if (cs == 4) {
                                        i = 4;
                                        ts(4);
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
                                    d.this.bhC();
                                    d.this.gdt.bhF();
                                    d.this.gdt.setVisibility(8);
                                }
                            }, 700L);
                        }
                        this.gdw = false;
                        return true;
                    } else {
                        return false;
                    }
                case 2:
                    if (this.gdw) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.drI > 300) {
                            if (motionEvent.getY() > iArr[1] + 30) {
                                this.mHandler.removeCallbacks(this.gdA);
                                return true;
                            }
                            if (!this.gdt.atw()) {
                                this.gdA.run();
                            }
                            if (currentTimeMillis - this.gdu > 800) {
                                this.gdt.getLocationOnScreen(new int[2]);
                                this.gdt.cr((int) (iArr3[0] + motionEvent.getX()), (int) (iArr3[1] + motionEvent.getY()));
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

    private void ts(final int i) {
        if (TbadkCoreApplication.isLogin()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.d.6
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    d.this.gdx.setVisibility(0);
                    if (i == 1) {
                        d.this.gdx.setPadding(0, 0, 0, l.t(d.this.gdx.getContext(), d.e.ds70));
                        i2 = d.b.full_screen_big_praise;
                    } else if (i == 4) {
                        d.this.gdx.setPadding(0, 0, 0, 0);
                        i2 = d.b.full_screen_big_trample;
                    }
                    d.this.gdx.invalidate();
                    com.baidu.tbadk.core.util.l a = com.baidu.tbadk.core.util.l.a(d.this.gdx, i2, 20, 1);
                    a.a(new l.a() { // from class: com.baidu.tieba.pb.view.d.6.1
                        @Override // com.baidu.tbadk.core.util.l.a
                        public void BY() {
                            d.this.gdx.setVisibility(8);
                            if (d.this.gdx.getTag() != null) {
                                ((com.baidu.tbadk.core.util.l) d.this.gdx.getTag()).stop();
                            }
                            d.this.gdx.setTag(null);
                        }
                    });
                    d.this.gdx.setTag(a);
                    a.b(d.this.gdx);
                }
            }, 200L);
        }
    }

    public void o(boolean z, int i) {
        if (this.gdt != null && this.oa != null) {
            if (z) {
                Rect rect = new Rect();
                this.oa.getGlobalVisibleRect(rect);
                if (rect.top > 0 && rect.bottom > i) {
                    this.oa.getViewTreeObserver().addOnGlobalLayoutListener(this.gdC);
                    this.gdz.setVisibility(0);
                    bhC();
                    return;
                }
                this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gdC);
                this.gdz.setVisibility(8);
                return;
            }
            this.oa.getViewTreeObserver().removeGlobalOnLayoutListener(this.gdC);
            this.gdz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhC() {
        if (!this.gdt.atw()) {
            int[] iArr = new int[2];
            this.gdv.getLocationOnScreen(iArr);
            this.gdz.setLayoutParams(new FrameLayout.LayoutParams(this.gdv.getWidth(), this.gdv.getHeight()));
            this.gdz.setX(iArr[0]);
            this.gdz.setY(iArr[1]);
            this.gdz.invalidate();
        }
    }
}
