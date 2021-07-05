package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaStoreThumbFetcher";
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream inputStream;
    public final Uri mediaStoreImageUri;
    public final ThumbnailStreamOpener opener;

    /* loaded from: classes6.dex */
    public static class ImageThumbnailQuery implements ThumbnailQuery {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String[] PATH_PROJECTION;
        public static final String PATH_SELECTION = "kind = 1 AND image_id = ?";
        public transient /* synthetic */ FieldHolder $fh;
        public final ContentResolver contentResolver;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1517971636, "Lcom/bumptech/glide/load/data/mediastore/ThumbFetcher$ImageThumbnailQuery;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1517971636, "Lcom/bumptech/glide/load/data/mediastore/ThumbFetcher$ImageThumbnailQuery;");
                    return;
                }
            }
            PATH_PROJECTION = new String[]{"_data"};
        }

        public ImageThumbnailQuery(ContentResolver contentResolver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentResolver};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? this.contentResolver.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null) : (Cursor) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class VideoThumbnailQuery implements ThumbnailQuery {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String[] PATH_PROJECTION;
        public static final String PATH_SELECTION = "kind = 1 AND video_id = ?";
        public transient /* synthetic */ FieldHolder $fh;
        public final ContentResolver contentResolver;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1662867860, "Lcom/bumptech/glide/load/data/mediastore/ThumbFetcher$VideoThumbnailQuery;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1662867860, "Lcom/bumptech/glide/load/data/mediastore/ThumbFetcher$VideoThumbnailQuery;");
                    return;
                }
            }
            PATH_PROJECTION = new String[]{"_data"};
        }

        public VideoThumbnailQuery(ContentResolver contentResolver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {contentResolver};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.contentResolver = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor query(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? this.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null) : (Cursor) invokeL.objValue;
        }
    }

    @VisibleForTesting
    public ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, thumbnailStreamOpener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mediaStoreImageUri = uri;
        this.opener = thumbnailStreamOpener;
    }

    public static ThumbFetcher build(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, uri, thumbnailQuery)) == null) ? new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.get(context).getRegistry().getImageHeaderParsers(), thumbnailQuery, Glide.get(context).getArrayPool(), context.getContentResolver())) : (ThumbFetcher) invokeLLL.objValue;
    }

    public static ThumbFetcher buildImageFetcher(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, uri)) == null) ? build(context, uri, new ImageThumbnailQuery(context.getContentResolver())) : (ThumbFetcher) invokeLL.objValue;
    }

    public static ThumbFetcher buildVideoFetcher(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, uri)) == null) ? build(context, uri, new VideoThumbnailQuery(context.getContentResolver())) : (ThumbFetcher) invokeLL.objValue;
    }

    private InputStream openThumbInputStream() throws FileNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            InputStream open = this.opener.open(this.mediaStoreImageUri);
            int orientation = open != null ? this.opener.getOrientation(this.mediaStoreImageUri) : -1;
            return orientation != -1 ? new ExifOrientationStream(open, orientation) : open;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (inputStream = this.inputStream) == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DataSource.LOCAL : (DataSource) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
            try {
                InputStream openThumbInputStream = openThumbInputStream();
                this.inputStream = openThumbInputStream;
                dataCallback.onDataReady(openThumbInputStream);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to find thumbnail file", e2);
                }
                dataCallback.onLoadFailed(e2);
            }
        }
    }
}
