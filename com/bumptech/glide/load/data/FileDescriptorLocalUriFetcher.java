package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes9.dex */
public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDescriptorLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {contentResolver, uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ContentResolver) objArr2[0], (Uri) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<ParcelFileDescriptor> getDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ParcelFileDescriptor.class : (Class) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, parcelFileDescriptor) == null) {
            parcelFileDescriptor.close();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public ParcelFileDescriptor loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uri, contentResolver)) == null) {
            AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, r.f42346a);
            if (openAssetFileDescriptor != null) {
                return openAssetFileDescriptor.getParcelFileDescriptor();
            }
            throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
        return (ParcelFileDescriptor) invokeLL.objValue;
    }
}
