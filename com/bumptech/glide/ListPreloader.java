package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;
/* loaded from: classes6.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isIncreasing;
    public int lastEnd;
    public int lastFirstVisible;
    public int lastStart;
    public final int maxPreload;
    public final PreloadSizeProvider<T> preloadDimensionProvider;
    public final PreloadModelProvider<T> preloadModelProvider;
    public final PreloadTargetQueue preloadTargetQueue;
    public final RequestManager requestManager;
    public int totalItemCount;

    /* loaded from: classes6.dex */
    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i2);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u);
    }

    /* loaded from: classes6.dex */
    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t, int i2, int i3);
    }

    /* loaded from: classes6.dex */
    public static final class PreloadTarget extends BaseTarget<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int photoHeight;
        public int photoWidth;

        public PreloadTarget() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sizeReadyCallback) == null) {
                sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, transition) == null) {
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sizeReadyCallback) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class PreloadTargetQueue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.queue = Util.createQueue(i2);
            for (int i5 = 0; i5 < i2; i5++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                PreloadTarget poll = this.queue.poll();
                this.queue.offer(poll);
                poll.photoWidth = i2;
                poll.photoHeight = i3;
                return poll;
            }
            return (PreloadTarget) invokeII.objValue;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {requestManager, preloadModelProvider, preloadSizeProvider, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lastFirstVisible = -1;
        this.isIncreasing = true;
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i2;
        this.preloadTargetQueue = new PreloadTargetQueue(i2 + 1);
    }

    private void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            for (int i2 = 0; i2 < this.maxPreload; i2++) {
                this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
            }
        }
    }

    private void preload(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (this.isIncreasing != z) {
                this.isIncreasing = z;
                cancelAll();
            }
            preload(i2, (z ? this.maxPreload : -this.maxPreload) + i2);
        }
    }

    private void preloadAdapterPosition(List<T> list, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{list, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            int size = list.size();
            if (z) {
                for (int i3 = 0; i3 < size; i3++) {
                    preloadItem(list.get(i3), i2, i3);
                }
                return;
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                preloadItem(list.get(i4), i2, i4);
            }
        }
    }

    private void preloadItem(@Nullable T t, int i2, int i3) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, this, t, i2, i3) == null) || t == null || (preloadSize = this.preloadDimensionProvider.getPreloadSize(t, i2, i3)) == null || (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t)) == null) {
            return;
        }
        preloadRequestBuilder.into((RequestBuilder<?>) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            this.totalItemCount = i4;
            int i5 = this.lastFirstVisible;
            if (i2 > i5) {
                preload(i3 + i2, true);
            } else if (i2 < i5) {
                preload(i2, false);
            }
            this.lastFirstVisible = i2;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
        }
    }

    private void preload(int i2, int i3) {
        int min;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65538, this, i2, i3) == null) {
            if (i2 < i3) {
                i4 = Math.max(this.lastEnd, i2);
                min = i3;
            } else {
                min = Math.min(this.lastStart, i2);
                i4 = i3;
            }
            int min2 = Math.min(this.totalItemCount, min);
            int min3 = Math.min(this.totalItemCount, Math.max(0, i4));
            if (i2 < i3) {
                for (int i5 = min3; i5 < min2; i5++) {
                    preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i5), i5, true);
                }
            } else {
                for (int i6 = min2 - 1; i6 >= min3; i6--) {
                    preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i6), i6, false);
                }
            }
            this.lastStart = min3;
            this.lastEnd = min2;
        }
    }
}
