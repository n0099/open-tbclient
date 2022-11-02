package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InternalRewinder rewinder;

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @RequiresApi(21)
    /* loaded from: classes7.dex */
    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<ParcelFileDescriptor> getDataClass() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ParcelFileDescriptor.class;
            }
            return (Class) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public DataRewinder<ParcelFileDescriptor> build(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcelFileDescriptor)) == null) {
                return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
            }
            return (DataRewinder) invokeL.objValue;
        }
    }

    @RequiresApi(21)
    /* loaded from: classes7.dex */
    public static final class InternalRewinder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ParcelFileDescriptor parcelFileDescriptor;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelFileDescriptor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parcelFileDescriptor = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    Os.lseek(this.parcelFileDescriptor.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                    return this.parcelFileDescriptor;
                } catch (ErrnoException e) {
                    throw new IOException(e);
                }
            }
            return (ParcelFileDescriptor) invokeV.objValue;
        }
    }

    @RequiresApi(21)
    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcelFileDescriptor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rewinder = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    @RequiresApi(21)
    public ParcelFileDescriptor rewindAndGet() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.rewinder.rewind();
        }
        return (ParcelFileDescriptor) invokeV.objValue;
    }
}
