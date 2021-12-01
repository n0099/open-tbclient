package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;
/* loaded from: classes12.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExternalPreferredCacheDiskCacheFactory(Context context, long j2) {
        this(context, "image_manager_disk_cache", j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j2) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter(context, str) { // from class: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Context val$context;
            public final /* synthetic */ String val$diskCacheName;

            {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$context = context;
                this.val$diskCacheName = str;
            }

            @Nullable
            private File getInternalCacheDirectory() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                    File cacheDir = this.val$context.getCacheDir();
                    if (cacheDir == null) {
                        return null;
                    }
                    return this.val$diskCacheName != null ? new File(cacheDir, this.val$diskCacheName) : cacheDir;
                }
                return (File) invokeV.objValue;
            }

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                InterceptResult invokeV;
                File externalCacheDir;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    File internalCacheDirectory = getInternalCacheDirectory();
                    return ((internalCacheDirectory == null || !internalCacheDirectory.exists()) && (externalCacheDir = this.val$context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.val$diskCacheName != null ? new File(externalCacheDir, this.val$diskCacheName) : externalCacheDir : internalCacheDirectory;
                }
                return (File) invokeV.objValue;
            }
        }, j2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DiskLruCacheFactory.CacheDirectoryGetter) objArr2[0], ((Long) objArr2[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }
}
