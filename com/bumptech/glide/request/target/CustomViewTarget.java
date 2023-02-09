package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CustomViewTarget";
    @IdRes
    public static final int VIEW_TAG_ID = 2131299695;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View.OnAttachStateChangeListener attachStateListener;
    public boolean isAttachStateListenerAdded;
    public boolean isClearedByUs;
    public final SizeDeterminer sizeDeterminer;

    /* renamed from: view  reason: collision with root package name */
    public final T f1087view;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1272928265, "Lcom/bumptech/glide/request/target/CustomViewTarget;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1272928265, "Lcom/bumptech/glide/request/target/CustomViewTarget;");
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public abstract void onResourceCleared(@Nullable Drawable drawable);

    public void onResourceLoading(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, drawable) == null) {
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(@IdRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? this : (CustomViewTarget) invokeI.objValue;
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class SizeDeterminer {
        public static /* synthetic */ Interceptable $ic;
        public static final int PENDING_SIZE = 0;
        @Nullable
        @VisibleForTesting
        public static Integer maxDisplayLength;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<SizeReadyCallback> cbs;
        @Nullable
        public SizeDeterminerLayoutListener layoutListener;

        /* renamed from: view  reason: collision with root package name */
        public final View f1088view;
        public boolean waitForLayout;

        private boolean isDimensionValid(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) ? i > 0 || i == Integer.MIN_VALUE : invokeI.booleanValue;
        }

        /* loaded from: classes7.dex */
        public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sizeDeterminer};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.sizeDeterminerRef = new WeakReference<>(sizeDeterminer);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (Log.isLoggable(CustomViewTarget.TAG, 2)) {
                        Log.v(CustomViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                    }
                    SizeDeterminer sizeDeterminer = this.sizeDeterminerRef.get();
                    if (sizeDeterminer != null) {
                        sizeDeterminer.checkCurrentDimens();
                        return true;
                    }
                    return true;
                }
                return invokeV.booleanValue;
            }
        }

        public SizeDeterminer(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cbs = new ArrayList();
            this.f1088view = view2;
        }

        public static int getMaxDisplayLength(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                if (maxDisplayLength == null) {
                    Display defaultDisplay = ((WindowManager) Preconditions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                    Point point = new Point();
                    defaultDisplay.getSize(point);
                    maxDisplayLength = Integer.valueOf(Math.max(point.x, point.y));
                }
                return maxDisplayLength.intValue();
            }
            return invokeL.intValue;
        }

        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sizeReadyCallback) == null) {
                int targetWidth = getTargetWidth();
                int targetHeight = getTargetHeight();
                if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
                    sizeReadyCallback.onSizeReady(targetWidth, targetHeight);
                    return;
                }
                if (!this.cbs.contains(sizeReadyCallback)) {
                    this.cbs.add(sizeReadyCallback);
                }
                if (this.layoutListener == null) {
                    ViewTreeObserver viewTreeObserver = this.f1088view.getViewTreeObserver();
                    SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                    this.layoutListener = sizeDeterminerLayoutListener;
                    viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
                }
            }
        }

        private int getTargetDimen(int i, int i2, int i3) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, this, i, i2, i3)) == null) {
                int i4 = i2 - i3;
                if (i4 > 0) {
                    return i4;
                }
                if (this.waitForLayout && this.f1088view.isLayoutRequested()) {
                    return 0;
                }
                int i5 = i - i3;
                if (i5 > 0) {
                    return i5;
                }
                if (this.f1088view.isLayoutRequested() || i2 != -2) {
                    return 0;
                }
                if (Log.isLoggable(CustomViewTarget.TAG, 4)) {
                    Log.i(CustomViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return getMaxDisplayLength(this.f1088view.getContext());
            }
            return invokeIII.intValue;
        }

        private int getTargetHeight() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                int paddingTop = this.f1088view.getPaddingTop() + this.f1088view.getPaddingBottom();
                ViewGroup.LayoutParams layoutParams = this.f1088view.getLayoutParams();
                if (layoutParams != null) {
                    i = layoutParams.height;
                } else {
                    i = 0;
                }
                return getTargetDimen(this.f1088view.getHeight(), i, paddingTop);
            }
            return invokeV.intValue;
        }

        private int getTargetWidth() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                int paddingLeft = this.f1088view.getPaddingLeft() + this.f1088view.getPaddingRight();
                ViewGroup.LayoutParams layoutParams = this.f1088view.getLayoutParams();
                if (layoutParams != null) {
                    i = layoutParams.width;
                } else {
                    i = 0;
                }
                return getTargetDimen(this.f1088view.getWidth(), i, paddingLeft);
            }
            return invokeV.intValue;
        }

        private boolean isViewStateAndSizeValid(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i, i2)) == null) {
                if (isDimensionValid(i) && isDimensionValid(i2)) {
                    return true;
                }
                return false;
            }
            return invokeII.booleanValue;
        }

        private void notifyCbs(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65543, this, i, i2) == null) {
                Iterator it = new ArrayList(this.cbs).iterator();
                while (it.hasNext()) {
                    ((SizeReadyCallback) it.next()).onSizeReady(i, i2);
                }
            }
        }

        public void checkCurrentDimens() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.cbs.isEmpty()) {
                return;
            }
            int targetWidth = getTargetWidth();
            int targetHeight = getTargetHeight();
            if (!isViewStateAndSizeValid(targetWidth, targetHeight)) {
                return;
            }
            notifyCbs(targetWidth, targetHeight);
            clearCallbacksAndListener();
        }

        public void clearCallbacksAndListener() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ViewTreeObserver viewTreeObserver = this.f1088view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                }
                this.layoutListener = null;
                this.cbs.clear();
            }
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sizeReadyCallback) == null) {
                this.cbs.remove(sizeReadyCallback);
            }
        }
    }

    public CustomViewTarget(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1087view = (T) Preconditions.checkNotNull(t);
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    @Nullable
    private Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return this.f1087view.getTag(VIEW_TAG_ID);
        }
        return invokeV.objValue;
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && (onAttachStateChangeListener = this.attachStateListener) != null && !this.isAttachStateListenerAdded) {
            this.f1087view.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = true;
        }
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && (onAttachStateChangeListener = this.attachStateListener) != null && this.isAttachStateListenerAdded) {
            this.f1087view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = false;
        }
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.attachStateListener != null) {
                return this;
            }
            this.attachStateListener = new View.OnAttachStateChangeListener(this) { // from class: com.bumptech.glide.request.target.CustomViewTarget.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CustomViewTarget this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.resumeMyRequest();
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                        this.this$0.pauseMyRequest();
                    }
                }
            };
            maybeAddAttachStateListener();
            return this;
        }
        return (CustomViewTarget) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object tag = getTag();
            if (tag != null) {
                if (tag instanceof Request) {
                    return (Request) tag;
                }
                throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    @NonNull
    public final T getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f1087view;
        }
        return (T) invokeV.objValue;
    }

    public final void pauseMyRequest() {
        Request request;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (request = getRequest()) != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    public final void resumeMyRequest() {
        Request request;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (request = getRequest()) != null && request.isCleared()) {
            request.begin();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "Target for: " + this.f1087view;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            this.sizeDeterminer.waitForLayout = true;
            return this;
        }
        return (CustomViewTarget) invokeV.objValue;
    }

    private void setTag(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, obj) == null) {
            this.f1087view.setTag(VIEW_TAG_ID, obj);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sizeReadyCallback) == null) {
            this.sizeDeterminer.getSize(sizeReadyCallback);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            this.sizeDeterminer.clearCallbacksAndListener();
            onResourceCleared(drawable);
            if (!this.isClearedByUs) {
                maybeRemoveAttachStateListener();
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
            maybeAddAttachStateListener();
            onResourceLoading(drawable);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sizeReadyCallback) == null) {
            this.sizeDeterminer.removeCallback(sizeReadyCallback);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, request) == null) {
            setTag(request);
        }
    }
}
