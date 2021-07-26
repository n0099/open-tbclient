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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.base.widget.banner.FocusImageCellLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class BannerFocusImageViewGroup extends ViewGroup implements FocusImageCellLayout.FocusImageEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FOCUS_IMAGE_MAX = 10;
    public static ArrayList<FoucsImageItem> H = null;
    public static final float N = 1.0E-7f;
    public static final int TOKEN_IS_EXPIRED = 112;

    /* renamed from: a  reason: collision with root package name */
    public static final int f24584a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f24585b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f24586c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f24587d = 200;

    /* renamed from: e  reason: collision with root package name */
    public static final int f24588e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f24589f = -999;

    /* renamed from: g  reason: collision with root package name */
    public static final int f24590g = 3000;

    /* renamed from: h  reason: collision with root package name */
    public static final int f24591h = 100;

    /* renamed from: i  reason: collision with root package name */
    public static final int f24592i = 5;
    public static final float j = 0.23f;
    public static final float k = 1.0E9f;
    public static final float l = 0.75f;
    public static final float m = 2500.0f;
    public static final float n;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes5.dex */
    public interface CurrFocusImagePos {
        void setCurrPos(int i2, int i3);
    }

    /* loaded from: classes5.dex */
    public interface FoucsImageEvent {
        void submitPage(Bundle bundle);
    }

    /* loaded from: classes5.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f24600a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f24601b = 2;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<BannerFocusImageViewGroup> f24602c;

        /* renamed from: d  reason: collision with root package name */
        public int f24603d;

        public a(BannerFocusImageViewGroup bannerFocusImageViewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bannerFocusImageViewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24603d = 0;
            this.f24602c = new WeakReference<>(bannerFocusImageViewGroup);
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f24603d = i2;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                BannerFocusImageViewGroup bannerFocusImageViewGroup = this.f24602c.get();
                if (message == null || bannerFocusImageViewGroup == null) {
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    Rect rect = new Rect();
                    bannerFocusImageViewGroup.getGlobalVisibleRect(rect);
                    if (this.f24603d == rect.left) {
                        bannerFocusImageViewGroup.moveToNext();
                    }
                    sendMessageDelayed(obtainMessage(1), 3000L);
                } else if (i2 != 2) {
                } else {
                    boolean z = false;
                    if (BannerFocusImageViewGroup.a(bannerFocusImageViewGroup) <= 5) {
                        boolean z2 = bannerFocusImageViewGroup.u >= 1;
                        Iterator it = BannerFocusImageViewGroup.H.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = z2;
                                break;
                            } else if (TextUtils.isEmpty(((FoucsImageItem) it.next()).f24599c)) {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(309091198, "Lcom/baidu/wallet/base/widget/banner/BannerFocusImageViewGroup;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(309091198, "Lcom/baidu/wallet/base/widget/banner/BannerFocusImageViewGroup;");
                return;
            }
        }
        n = (float) (0.016d / Math.log(0.75d));
        H = new ArrayList<>(15);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerFocusImageViewGroup(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ int a(BannerFocusImageViewGroup bannerFocusImageViewGroup) {
        int i2 = bannerFocusImageViewGroup.v;
        bannerFocusImageViewGroup.v = i2 + 1;
        return i2;
    }

    private void e() {
        BannerBaseItemInfo[] bannerBaseItemInfoArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (bannerBaseItemInfoArr = this.J) == null) {
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
            this.F[i2].setOnClickListener(new View.OnClickListener(this, this.J[i2]) { // from class: com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BannerBaseItemInfo f24593a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BannerFocusImageViewGroup f24594b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f24594b = this;
                    this.f24593a = r7;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BannerBaseItemInfo bannerBaseItemInfo;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        view.setClickable(false);
                        this.f24594b.G.postDelayed(new Runnable(this, view) { // from class: com.baidu.wallet.base.widget.banner.BannerFocusImageViewGroup.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ View f24595a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f24596b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, view};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f24596b = this;
                                this.f24595a = view;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f24595a.setClickable(true);
                                }
                            }
                        }, 600L);
                        if (this.f24594b.B != null && (bannerBaseItemInfo = this.f24593a) != null && !TextUtils.isEmpty(bannerBaseItemInfo.getName())) {
                            this.f24594b.triggerOnEvent(this.f24593a.getName());
                        }
                        this.f24594b.jump(this.f24593a);
                    }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
                this.r = f24589f;
            } else if (this.t != 1 || this.M <= 1) {
            } else {
                super.scrollTo(getScrollX() + ((int) ((this.z - getScrollX()) * ((float) Math.exp(((((float) System.nanoTime()) / 1.0E9f) - this.A) / n)))), getScrollY());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
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
    }

    public int getCurrentScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.s;
            if (i2 < 0) {
                this.s = 0;
            } else if (i2 >= 1) {
                this.s = 0;
            }
            return this.s;
        }
        return invokeV.intValue;
    }

    public void jump(BannerBaseItemInfo bannerBaseItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bannerBaseItemInfo) == null) {
            SDKJumpManager.getInstance().doSDKJump(getContext(), bannerBaseItemInfo.getName(), bannerBaseItemInfo.getType(), bannerBaseItemInfo.getLinkAddr(), bannerBaseItemInfo.getPrevlogin(), null);
        }
    }

    public void moveToNext() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.E.isFinished()) {
            d();
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            this.G.removeMessages(1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0 != 3) goto L11;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // android.view.View
    @TargetApi(8)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float xVelocity;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setChildLeft(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.a(i2);
    }

    public void setCurrFocusImagePos(CurrFocusImagePos currFocusImagePos) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, currFocusImagePos) == null) {
            this.D = currFocusImagePos;
            if (currFocusImagePos != null) {
                currFocusImagePos.setCurrPos(this.s, this.M);
            }
        }
    }

    public void setFocusConfigInfo(BannerBaseItemInfo[] bannerBaseItemInfoArr, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bannerBaseItemInfoArr, str) == null) {
            this.J = bannerBaseItemInfoArr;
            this.I = str;
            e();
        }
    }

    public void setMaiDianDataKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.O = str;
        }
    }

    public void setPotDot(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
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
    }

    @Override // com.baidu.wallet.base.widget.banner.FocusImageCellLayout.FocusImageEvent
    public void submitPage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    public void triggerOnEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || TextUtils.isEmpty(this.O)) {
            return;
        }
        DXMSdkSAUtils.onEventWithValues(this.O, Arrays.asList(str));
        PayStatisticsUtil.onEvent(this.O, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerFocusImageViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || this.L >= 1) {
            return;
        }
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

    private void c() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (velocityTracker = this.C) == null) {
            return;
        }
        velocityTracker.recycle();
        this.C = null;
    }

    private void d() {
        int width;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || (width = getWidth()) == 0) {
            return;
        }
        a(Math.max((int) Math.floor((getScrollX() + (width >> 1)) / width), this.s + 1), 100, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerFocusImageViewGroup(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.p = -1;
        this.r = f24589f;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, motionEvent) == null) {
            if (this.C == null) {
                this.C = VelocityTracker.obtain();
            }
            this.C.addMovement(motionEvent);
        }
    }

    /* loaded from: classes5.dex */
    public static class FoucsImageItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f24597a;

        /* renamed from: b  reason: collision with root package name */
        public String f24598b;

        /* renamed from: c  reason: collision with root package name */
        public String f24599c;

        public FoucsImageItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24597a = 0;
            this.f24598b = "";
            this.f24599c = "";
            this.f24597a = 0;
            this.f24598b = "";
            this.f24599c = "";
        }

        public String getImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24599c : (String) invokeV.objValue;
        }

        public String getPageID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24598b : (String) invokeV.objValue;
        }

        public int getPageType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24597a : invokeV.intValue;
        }

        public void setImageUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f24599c = str;
            }
        }

        public void setPageID(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f24598b = str;
            }
        }

        public void setPageTpye(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.f24597a = i2;
            }
        }

        public FoucsImageItem(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f24597a = 0;
            this.f24598b = "";
            this.f24599c = "";
            this.f24598b = str;
            this.f24597a = i2;
            this.f24599c = str2;
        }
    }

    private boolean a(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? Math.abs(f2 - ((float) i2)) < 1.0E-7f : invokeCommon.booleanValue;
    }

    private void a(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, attributeSet) == null) {
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
    }

    private boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) ? i2 >= 0 && i2 < getChildCount() : invokeI.booleanValue;
    }

    private void a(int i2, int i3, boolean z) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
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
}
