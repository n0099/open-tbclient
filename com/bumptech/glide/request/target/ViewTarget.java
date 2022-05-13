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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
@Deprecated
/* loaded from: classes4.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ViewTarget";
    public static boolean isTagUsedAtLeastOnce;
    @Nullable
    public static Integer tagId;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View.OnAttachStateChangeListener attachStateListener;
    public boolean isAttachStateListenerAdded;
    public boolean isClearedByUs;
    public final SizeDeterminer sizeDeterminer;

    /* renamed from: view  reason: collision with root package name */
    public final T f1014view;

    @VisibleForTesting
    /* loaded from: classes4.dex */
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
        public final View f1015view;
        public boolean waitForLayout;

        /* loaded from: classes4.dex */
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
                    if (Log.isLoggable(ViewTarget.TAG, 2)) {
                        Log.v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
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
            this.f1015view = view2;
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

        private int getTargetDimen(int i, int i2, int i3) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, this, i, i2, i3)) == null) {
                int i4 = i2 - i3;
                if (i4 > 0) {
                    return i4;
                }
                if (this.waitForLayout && this.f1015view.isLayoutRequested()) {
                    return 0;
                }
                int i5 = i - i3;
                if (i5 > 0) {
                    return i5;
                }
                if (this.f1015view.isLayoutRequested() || i2 != -2) {
                    return 0;
                }
                if (Log.isLoggable(ViewTarget.TAG, 4)) {
                    Log.i(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
                }
                return getMaxDisplayLength(this.f1015view.getContext());
            }
            return invokeIII.intValue;
        }

        private int getTargetHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                int paddingTop = this.f1015view.getPaddingTop() + this.f1015view.getPaddingBottom();
                ViewGroup.LayoutParams layoutParams = this.f1015view.getLayoutParams();
                return getTargetDimen(this.f1015view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
            }
            return invokeV.intValue;
        }

        private int getTargetWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
                int paddingLeft = this.f1015view.getPaddingLeft() + this.f1015view.getPaddingRight();
                ViewGroup.LayoutParams layoutParams = this.f1015view.getLayoutParams();
                return getTargetDimen(this.f1015view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
            }
            return invokeV.intValue;
        }

        private boolean isDimensionValid(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) ? i > 0 || i == Integer.MIN_VALUE : invokeI.booleanValue;
        }

        private boolean isViewStateAndSizeValid(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65542, this, i, i2)) == null) ? isDimensionValid(i) && isDimensionValid(i2) : invokeII.booleanValue;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.cbs.isEmpty()) {
                return;
            }
            int targetWidth = getTargetWidth();
            int targetHeight = getTargetHeight();
            if (isViewStateAndSizeValid(targetWidth, targetHeight)) {
                notifyCbs(targetWidth, targetHeight);
                clearCallbacksAndListener();
            }
        }

        public void clearCallbacksAndListener() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ViewTreeObserver viewTreeObserver = this.f1015view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.layoutListener);
                }
                this.layoutListener = null;
                this.cbs.clear();
            }
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
                    ViewTreeObserver viewTreeObserver = this.f1015view.getViewTreeObserver();
                    SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                    this.layoutListener = sizeDeterminerLayoutListener;
                    viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
                }
            }
        }

        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sizeReadyCallback) == null) {
                this.cbs.remove(sizeReadyCallback);
            }
        }
    }

    public ViewTarget(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1014view = (T) Preconditions.checkNotNull(t);
        this.sizeDeterminer = new SizeDeterminer(t);
    }

    @Nullable
    private Object getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Integer num = tagId;
            if (num == null) {
                return this.f1014view.getTag();
            }
            return this.f1014view.getTag(num.intValue());
        }
        return invokeV.objValue;
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (onAttachStateChangeListener = this.attachStateListener) == null || this.isAttachStateListenerAdded) {
            return;
        }
        this.f1014view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = true;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && (onAttachStateChangeListener = this.attachStateListener) != null && this.isAttachStateListenerAdded) {
            this.f1014view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.isAttachStateListenerAdded = false;
        }
    }

    private void setTag(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, obj) == null) {
            Integer num = tagId;
            if (num == null) {
                isTagUsedAtLeastOnce = true;
                this.f1014view.setTag(obj);
                return;
            }
            this.f1014view.setTag(num.intValue(), obj);
        }
    }

    public static void setTagId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i) == null) {
            if (tagId == null && !isTagUsedAtLeastOnce) {
                tagId = Integer.valueOf(i);
                return;
            }
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
    }

    @NonNull
    public final ViewTarget<T, Z> clearOnDetach() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.attachStateListener != null) {
                return this;
            }
            this.attachStateListener = new View.OnAttachStateChangeListener(this) { // from class: com.bumptech.glide.request.target.ViewTarget.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ViewTarget this$0;

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
        return (ViewTarget) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object tag = getTag();
            if (tag != null) {
                if (tag instanceof Request) {
                    return (Request) tag;
                }
                throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
            }
            return null;
        }
        return (Request) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sizeReadyCallback) == null) {
            this.sizeDeterminer.getSize(sizeReadyCallback);
        }
    }

    @NonNull
    public T getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1014view : (T) invokeV.objValue;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, drawable) == null) {
            super.onLoadCleared(drawable);
            this.sizeDeterminer.clearCallbacksAndListener();
            if (this.isClearedByUs) {
                return;
            }
            maybeRemoveAttachStateListener();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            super.onLoadStarted(drawable);
            maybeAddAttachStateListener();
        }
    }

    public void pauseMyRequest() {
        Request request;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (request = getRequest()) == null) {
            return;
        }
        this.isClearedByUs = true;
        request.clear();
        this.isClearedByUs = false;
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sizeReadyCallback) == null) {
            this.sizeDeterminer.removeCallback(sizeReadyCallback);
        }
    }

    public void resumeMyRequest() {
        Request request;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (request = getRequest()) != null && request.isCleared()) {
            request.begin();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, request) == null) {
            setTag(request);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "Target for: " + this.f1014view;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public final ViewTarget<T, Z> waitForLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.sizeDeterminer.waitForLayout = true;
            return this;
        }
        return (ViewTarget) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            waitForLayout();
        }
    }
}
