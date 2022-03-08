package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public class ThumbnailStreamOpener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FileService DEFAULT_SERVICE;
    public static final String TAG = "ThumbStreamOpener";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayPool byteArrayPool;
    public final ContentResolver contentResolver;
    public final List<ImageHeaderParser> parsers;
    public final ThumbnailQuery query;
    public final FileService service;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2130023227, "Lcom/bumptech/glide/load/data/mediastore/ThumbnailStreamOpener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2130023227, "Lcom/bumptech/glide/load/data/mediastore/ThumbnailStreamOpener;");
                return;
            }
        }
        DEFAULT_SERVICE = new FileService();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, thumbnailQuery, arrayPool, contentResolver};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (FileService) objArr2[1], (ThumbnailQuery) objArr2[2], (ArrayPool) objArr2[3], (ContentResolver) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Nullable
    private String getPath(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, uri)) == null) {
            Cursor query = this.query.query(uri);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(0);
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private boolean isValid(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, file)) == null) ? this.service.exists(file) && 0 < this.service.length(file) : invokeL.booleanValue;
    }

    public int getOrientation(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = this.contentResolver.openInputStream(uri);
                    int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return orientation;
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException | NullPointerException unused3) {
                if (Log.isLoggable(TAG, 3)) {
                    String str = "Failed to open uri: " + uri;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused4) {
                        return -1;
                    }
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            String path = getPath(uri);
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            File file = this.service.get(path);
            if (isValid(file)) {
                Uri fromFile = Uri.fromFile(file);
                try {
                    return this.contentResolver.openInputStream(fromFile);
                } catch (NullPointerException e2) {
                    throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + LoadErrorCode.TOKEN_NEXT + fromFile).initCause(e2));
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    public ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, fileService, thumbnailQuery, arrayPool, contentResolver};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }
}
