package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes11.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ComponentName componentName;
    public final Context context;
    public final RemoteViews remoteViews;
    public final int viewId;
    public final int[] widgetIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetTarget(Context context, int i2, int i3, int i4, RemoteViews remoteViews, int... iArr) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), remoteViews, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (iArr.length != 0) {
            this.context = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
            this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
            this.widgetIds = (int[]) Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
            this.viewId = i4;
            this.componentName = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    private void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
            ComponentName componentName = this.componentName;
            if (componentName != null) {
                appWidgetManager.updateAppWidget(componentName, this.remoteViews);
            } else {
                appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
            }
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bitmap, transition) == null) {
            this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
            update();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppWidgetTarget(Context context, int i2, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, iArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), remoteViews, iArr};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (RemoteViews) objArr2[4], (int[]) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetTarget(Context context, int i2, int i3, int i4, RemoteViews remoteViews, ComponentName componentName) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), remoteViews, componentName};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.context = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
        this.remoteViews = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.componentName = (ComponentName) Preconditions.checkNotNull(componentName, "ComponentName can not be null!");
        this.viewId = i4;
        this.widgetIds = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppWidgetTarget(Context context, int i2, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, componentName);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), remoteViews, componentName};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (RemoteViews) objArr2[4], (ComponentName) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
