package com.baidu.wallet.base.widget.banner;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Scroller;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.base.widget.banner.FocusImageCellLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class BannerFocusImageViewGroup extends ViewGroup implements FocusImageCellLayout.FocusImageEvent {
    public static final int FOCUS_IMAGE_MAX = 10;
    public static final float N = 1.0E-7f;
    public static final int TOKEN_IS_EXPIRED = 112;

    /* renamed from: a  reason: collision with root package name */
    public static final int f23984a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f23985b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f23986c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f23987d = 200;

    /* renamed from: e  reason: collision with root package name */
    public static final int f23988e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f23989f = -999;

    /* renamed from: g  reason: collision with root package name */
    public static final int f23990g = 3000;

    /* renamed from: h  reason: collision with root package name */
    public static final int f23991h = 100;
    public static final int i = 5;
    public static final float j = 0.23f;
    public static final float k = 1.0E9f;
    public static final float l = 0.75f;
    public static final float m = 2500.0f;
    public float A;
    public Context B;
    public VelocityTracker C;
    public CurrFocusImagePos D;
    public Scroller E;
    public FocusImageCellLayout[] F;
    public a G;
    public String I;
    public BannerBaseItemInfo[] J;
    public AttributeSet K;
    public int L;
    public int M;
    public String O;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public float y;
    public float z;
    public static final float n = (float) (0.016d / Math.log(0.75d));
    public static ArrayList<FoucsImageItem> H = new ArrayList<>(15);

    /* loaded from: classes5.dex */
    public interface CurrFocusImagePos {
        void setCurrPos(int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface FoucsImageEvent {
        void submitPage(Bundle bundle);
    }

    /* loaded from: classes5.dex */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public static final int f23999a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f24000b = 2;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<BannerFocusImageViewGroup> f24001c;

        /* renamed from: d  reason: collision with root package name */
        public int f24002d = 0;

        public a(BannerFocusImageViewGroup bannerFocusImageViewGroup) {
            this.f24001c = new WeakReference<>(bannerFocusImageViewGroup);
        }

        public void a(int i) {
            this.f24002d = i;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BannerFocusImageViewGroup bannerFocusImageViewGroup = this.f24001c.get();
            if (message == null || bannerFocusImageViewGroup == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                Rect rect = new Rect();
                bannerFocusImageViewGroup.getGlobalVisibleRect(rect);
                if (this.f24002d == rect.left) {
                    bannerFocusImageViewGroup.moveToNext();
                }
                sendMessageDelayed(obtainMessage(1), 3000L);
            } else if (i != 2) {
            } else {
                boolean z = false;
                if (BannerFocusImageViewGroup.a(bannerFocusImageViewGroup) <= 5) {
                    boolean z2 = bannerFocusImageViewGroup.u >= 1;
                    Iterator it = BannerFocusImageViewGroup.H.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        } else if (TextUtils.isEmpty(((FoucsImageItem) it.next()).f23998c)) {
                            break;
                        }
                    }
                    if (z) {
                        removeMessages(2);
                        return;
                    } else {
                        sendMessageDelayed(obtainMessage(2), 3000L);
                        return;
                    }
                }
                bannerFocusImageViewGroup.v = 0;
                removeMessages(2);
            }
        }
    }

    public BannerFocusImageViewGroup(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int a(BannerFocusImageViewGroup bannerFocusImageViewGroup) {
        int i2 = bannerFocusImageViewGroup.v;
        bannerFocusImageViewGroup.v = i2 + 1;
        return i2;
    }

    private void e() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr = this.J;
        if (bannerBaseItemInfoArr == null) {
            return;
        }
        this.M = bannerBaseItemInfoArr.length;
        for (int i2 = 0; i2 < Math.min(this.J.length, 10); i2++) {
            FocusImageCellLayout[] focusImageCellLayoutArr = this.F;
            if (focusImageCellLayoutArr[i2] == null) {
                focusImageCellLayoutArr[i2] = new FocusImageCellLayout(this.B, this.K);
                addView(this.F[i2], new ViewGroup.LayoutParams(-1, -1));
                this.F[i2].getFocusView().setImageResource(ResUtils.color(this.B, "wallet_base_pressedColor"));
                this.F[i2].getFocusView().setScaleType(ImageView.ScaleType.FIT_XY);
            }
            NetImageView focusView = this.F[i2].getFocusView();
            focusView.setImageUrl(this.I + this.J[i2].getPicAddr());
            this.F[i2].setTag(ResUtils.id(this.B, "tag_pos"), Integer.valueOf(i2));
            final BannerBaseItemInfo bannerBaseItemInfo = this.J[i2];
            this.F[i2].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.1
                @Override // android.view.View.OnClickListener
                public void onClick(final View view) {
                    BannerBaseItemInfo bannerBaseItemInfo2;
                    view.setClickable(false);
                    BannerFocusImageViewGroup.this.G.postDelayed(new Runnable() { // from class: com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setClickable(true);
                        }
                    }, 600L);
                    if (BannerFocusImageViewGroup.this.B != null && (bannerBaseItemInfo2 = bannerBaseItemInfo) != null && !TextUtils.isEmpty(bannerBaseItemInfo2.getName())) {
                        BannerFocusImageViewGroup.this.triggerOnEvent(bannerBaseItemInfo.getName());
                    }
                    BannerFocusImageViewGroup.this.jump(bannerBaseItemInfo);
                }
            });
        }
        if (this.G.hasMessages(1)) {
            return;
        }
        a aVar = this.G;
        aVar.sendMessageDelayed(aVar.obtainMessage(1), 3000L);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.E.computeScrollOffset() && this.M > 1) {
            this.z = this.E.getCurrX();
            scrollTo(this.E.getCurrX(), this.E.getCurrY());
            postInvalidate();
            return;
        }
        int i2 = this.r;
        if (i2 != -999 && this.M > 1) {
            if (i2 == -1) {
                int childCount = getChildCount() - 1;
                this.s = childCount;
                scrollTo(childCount * getWidth(), getScrollY());
            } else if (i2 == getChildCount()) {
                this.s = 0;
                scrollTo(0, getScrollY());
            } else {
                this.s = Math.max(0, Math.min(this.r, getChildCount() - 1));
            }
            this.r = -999;
        } else if (this.t != 1 || this.M <= 1) {
        } else {
            super.scrollTo(getScrollX() + ((int) ((this.z - getScrollX()) * ((float) Math.exp(((((float) System.nanoTime()) / 1.0E9f) - this.A) / n)))), getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        boolean z = true;
        if (this.t != 1 && this.r == -999) {
            drawChild(canvas, getChildAt(this.s), getDrawingTime());
            return;
        }
        long drawingTime = getDrawingTime();
        int width = getWidth();
        float scrollX = getScrollX() / width;
        int childCount = getChildCount();
        if (scrollX < 0.0f) {
            i2 = childCount - 1;
            z = false;
        } else {
            int min = Math.min((int) scrollX, childCount - 1);
            i2 = min;
            i5 = (min + 1) % childCount;
        }
        if (a(i2)) {
            if (i5 == 0 && !z) {
                canvas.translate(-i4, 0.0f);
                drawChild(canvas, getChildAt(i2), drawingTime);
                canvas.translate(childCount * width, 0.0f);
            } else {
                drawChild(canvas, getChildAt(i2), drawingTime);
            }
        }
        if (a(scrollX, i2) || !a(i5)) {
            return;
        }
        if (i5 == 0 && z) {
            canvas.translate(childCount * width, 0.0f);
            drawChild(canvas, getChildAt(i5), drawingTime);
            canvas.translate(-i3, 0.0f);
            return;
        }
        drawChild(canvas, getChildAt(i5), drawingTime);
    }

    public int getCurrentScreen() {
        int i2 = this.s;
        if (i2 < 0) {
            this.s = 0;
        } else if (i2 >= 1) {
            this.s = 0;
        }
        return this.s;
    }

    public void jump(BannerBaseItemInfo bannerBaseItemInfo) {
        SDKJumpManager.getInstance().doSDKJump(getContext(), bannerBaseItemInfo.getName(), bannerBaseItemInfo.getType(), bannerBaseItemInfo.getLinkAddr(), bannerBaseItemInfo.getPrevlogin(), null);
    }

    public void moveToNext() {
        if (this.E.isFinished()) {
            d();
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G.removeMessages(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.p);
                    if (findPointerIndex != -1) {
                        float x = motionEvent.getX(findPointerIndex);
                        if (((int) Math.abs(x - this.y)) >= (this.o >> 2)) {
                            requestDisallowInterceptTouchEvent(true);
                            this.t = 1;
                            this.y = x;
                            this.z = getScrollX();
                            this.A = ((float) System.nanoTime()) / 1.0E9f;
                        }
                    }
                }
            }
            this.t = 0;
            this.p = -1;
            c();
            a aVar = this.G;
            aVar.sendMessageDelayed(aVar.obtainMessage(1), 3000L);
        } else {
            this.y = motionEvent.getX();
            this.p = motionEvent.getPointerId(0);
            if (this.M == 1) {
                this.t = 0;
            } else {
                this.t = !this.E.isFinished();
            }
            if (this.G.hasMessages(1)) {
                this.G.removeMessages(1);
            }
        }
        return this.t != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth() + i6;
                childAt.layout(i6, 0, measuredWidth, childAt.getMeasuredHeight());
                i6 = measuredWidth;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i5 = layoutParams.width;
            if (i5 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else if (i5 == -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            } else {
                makeMeasureSpec = i5 == -2 ? View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE) : 0;
            }
            int i6 = layoutParams.height;
            if (i6 > 0) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else if (i6 == -1) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            } else {
                makeMeasureSpec2 = i6 == -2 ? View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE) : 0;
            }
            childAt.measure(makeMeasureSpec, makeMeasureSpec2);
        }
        if (this.x) {
            scrollTo(this.s * size, 0);
            this.x = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
        if (r0 != 3) goto L13;
     */
    @Override // android.view.View
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float xVelocity;
        int i2;
        if (this.M == 1) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        a(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.t = 1;
                    this.z = getScrollX();
                    if (motionEvent.findPointerIndex(this.p) != -1) {
                        float x = motionEvent.getX();
                        float f2 = this.y - x;
                        this.y = x;
                        if (f2 < 0.0f) {
                            float f3 = this.z;
                            if (f3 > 0.0f) {
                                this.z = f3 + Math.max(-f3, f2);
                                this.A = ((float) System.nanoTime()) / 1.0E9f;
                                invalidate();
                            } else {
                                this.z = f3 + f2;
                                this.A = ((float) System.nanoTime()) / 1.0E9f;
                                invalidate();
                            }
                        } else if (f2 > 0.0f) {
                            float f4 = this.z;
                            float right = getChildAt(getChildCount() - 1).getRight() - f4;
                            if (right > 0.0f) {
                                this.z = f4 + Math.min(right, f2);
                                this.A = ((float) System.nanoTime()) / 1.0E9f;
                                invalidate();
                            }
                        }
                    }
                }
            }
            if (this.t == 1) {
                this.C.computeCurrentVelocity(1000, this.q);
                if (Build.VERSION.SDK_INT > 7) {
                    xVelocity = this.C.getXVelocity(this.p);
                } else {
                    xVelocity = this.C.getXVelocity();
                }
                int i3 = (int) xVelocity;
                int width = getWidth();
                int floor = (int) Math.floor((getScrollX() + (width >> 1)) / width);
                float scrollX = getScrollX() / width;
                if (i3 > 200 && (i2 = this.s) > -1) {
                    if (scrollX < floor) {
                        i2--;
                    }
                    a(Math.min(floor, i2), i3, true);
                } else if (i3 < -200 && this.s < getChildCount()) {
                    a(Math.max(floor, scrollX > ((float) floor) ? this.s + 1 : this.s), i3, true);
                } else {
                    a(floor, 0, true);
                }
            }
            this.t = 0;
            this.p = -1;
            c();
            if (!this.G.hasMessages(1) && this.M > 1) {
                a aVar = this.G;
                aVar.sendMessageDelayed(aVar.obtainMessage(1), 3000L);
            }
        } else {
            if (!this.E.isFinished()) {
                this.E.abortAnimation();
            }
            this.y = motionEvent.getX();
            this.p = motionEvent.getPointerId(0);
        }
        return true;
    }

    public void setChildLeft(int i2) {
        a aVar = this.G;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setCurrFocusImagePos(CurrFocusImagePos currFocusImagePos) {
        this.D = currFocusImagePos;
        if (currFocusImagePos != null) {
            currFocusImagePos.setCurrPos(this.s, this.M);
        }
    }

    public void setFocusConfigInfo(BannerBaseItemInfo[] bannerBaseItemInfoArr, String str) {
        this.J = bannerBaseItemInfoArr;
        this.I = str;
        e();
    }

    public void setMaiDianDataKey(String str) {
        this.O = str;
    }

    public void setPotDot(int i2) {
        int i3 = this.r;
        if (i3 == -1) {
            this.w = getChildCount() - 1;
        } else if (i3 == getChildCount()) {
            this.w = 0;
        } else {
            this.w = Math.max(0, Math.min(this.r, getChildCount() - 1));
        }
        if (this.D == null || getChildAt(this.w) == null || ((Integer) getChildAt(this.w).getTag(ResUtils.id(this.B, "tag_pos"))) == null) {
            return;
        }
        this.D.setCurrPos(((Integer) getChildAt(this.w).getTag(ResUtils.id(this.B, "tag_pos"))).intValue(), i2);
    }

    @Override // com.baidu.wallet.base.widget.banner.FocusImageCellLayout.FocusImageEvent
    public void submitPage(int i2) {
    }

    public void triggerOnEvent(String str) {
        if (TextUtils.isEmpty(this.O)) {
            return;
        }
        DXMSdkSAUtils.onEventWithValues(this.O, Arrays.asList(str));
        PayStatisticsUtil.onEvent(this.O, str);
    }

    public BannerFocusImageViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        if (this.L < 1) {
            CurrFocusImagePos currFocusImagePos = this.D;
            if (currFocusImagePos != null) {
                currFocusImagePos.setCurrPos(0, this.M);
            }
            removeAllViews();
            for (int i2 = 0; i2 < 1; i2++) {
                FocusImageCellLayout[] focusImageCellLayoutArr = this.F;
                if (focusImageCellLayoutArr[i2] == null) {
                    focusImageCellLayoutArr[i2] = new FocusImageCellLayout(this.B, this.K);
                    this.F[i2].getFocusView().setImageResource(ResUtils.color(this.B, "wallet_base_pressedColor"));
                    this.F[i2].getFocusView().setScaleType(ImageView.ScaleType.FIT_XY);
                    addView(this.F[i2], new ViewGroup.LayoutParams(-1, -1));
                    this.F[i2].setTag(ResUtils.id(this.B, "tag_pos"), Integer.valueOf(i2));
                }
            }
        }
    }

    private void c() {
        VelocityTracker velocityTracker = this.C;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.C = null;
        }
    }

    private void d() {
        int width = getWidth();
        if (width == 0) {
            return;
        }
        a(Math.max((int) Math.floor((getScrollX() + (width >> 1)) / width), this.s + 1), 100, true);
    }

    public BannerFocusImageViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = -1;
        this.r = -999;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = true;
        this.L = 0;
        this.M = 1;
        a(context, attributeSet);
        this.K = attributeSet;
    }

    private void a(MotionEvent motionEvent) {
        if (this.C == null) {
            this.C = VelocityTracker.obtain();
        }
        this.C.addMovement(motionEvent);
    }

    /* loaded from: classes5.dex */
    public static class FoucsImageItem {

        /* renamed from: a  reason: collision with root package name */
        public int f23996a;

        /* renamed from: b  reason: collision with root package name */
        public String f23997b;

        /* renamed from: c  reason: collision with root package name */
        public String f23998c;

        public FoucsImageItem() {
            this.f23996a = 0;
            this.f23997b = "";
            this.f23998c = "";
            this.f23996a = 0;
            this.f23997b = "";
            this.f23998c = "";
        }

        public String getImageUrl() {
            return this.f23998c;
        }

        public String getPageID() {
            return this.f23997b;
        }

        public int getPageType() {
            return this.f23996a;
        }

        public void setImageUrl(String str) {
            this.f23998c = str;
        }

        public void setPageID(String str) {
            this.f23997b = str;
        }

        public void setPageTpye(int i) {
            this.f23996a = i;
        }

        public FoucsImageItem(String str, int i, String str2) {
            this.f23996a = 0;
            this.f23997b = "";
            this.f23998c = "";
            this.f23997b = str;
            this.f23996a = i;
            this.f23998c = str2;
        }
    }

    private boolean a(float f2, int i2) {
        return Math.abs(f2 - ((float) i2)) < 1.0E-7f;
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.B = context;
        this.s = 0;
        this.F = new FocusImageCellLayout[10];
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.o = viewConfiguration.getScaledTouchSlop();
        this.q = viewConfiguration.getScaledMaximumFlingVelocity();
        Scroller scroller = new Scroller(getContext());
        this.E = scroller;
        scroller.abortAnimation();
        this.G = new a(this);
        b();
    }

    private boolean a(int i2) {
        return i2 >= 0 && i2 < getChildCount();
    }

    private void a(int i2, int i3, boolean z) {
        int i4;
        int i5;
        int max = Math.max(-1, Math.min(i2, getChildCount()));
        this.r = max;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && max != (i5 = this.s) && focusedChild == getChildAt(i5)) {
            focusedChild.clearFocus();
        }
        int max2 = Math.max(1, Math.abs(max - this.s));
        int width = (max * getWidth()) - getScrollX();
        int i6 = (max2 + 1) * 60;
        if (!this.E.isFinished()) {
            this.E.abortAnimation();
        }
        int abs = Math.abs(i3);
        if (abs > 0) {
            float f2 = i6;
            i4 = (int) (f2 + ((f2 / (abs / 2500.0f)) * 0.23f));
        } else {
            i4 = i6 + 100;
        }
        this.E.startScroll(getScrollX(), 0, width, 0, i4);
        invalidate();
        setPotDot(this.M);
    }
}
