package com.baidu.ugc.editvideo.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wb9;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MultiMediaDataTrack implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MultiMediaDataTrack> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MultiMediaData> multiMediaDataList;
    public MultiMediaData multiMediaDataSuperpositionFooter;
    public MultiMediaData multiMediaDataSuperpositionHeader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1126818016, "Lcom/baidu/ugc/editvideo/data/MultiMediaDataTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1126818016, "Lcom/baidu/ugc/editvideo/data/MultiMediaDataTrack;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MultiMediaDataTrack>() { // from class: com.baidu.ugc.editvideo.data.MultiMediaDataTrack.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MultiMediaDataTrack createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new MultiMediaDataTrack(parcel) : (MultiMediaDataTrack) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MultiMediaDataTrack[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new MultiMediaDataTrack[i] : (MultiMediaDataTrack[]) invokeI.objValue;
            }
        };
    }

    public MultiMediaDataTrack() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public MultiMediaDataTrack(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.multiMediaDataList = parcel.createTypedArrayList(MultiMediaData.CREATOR);
        this.multiMediaDataSuperpositionHeader = (MultiMediaData) parcel.readParcelable(MultiMediaData.class.getClassLoader());
        this.multiMediaDataSuperpositionFooter = (MultiMediaData) parcel.readParcelable(MultiMediaData.class.getClassLoader());
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MultiMediaDataTrack multiMediaDataTrack = (MultiMediaDataTrack) super.clone();
                if (this.multiMediaDataSuperpositionHeader != null) {
                    multiMediaDataTrack.multiMediaDataSuperpositionHeader = (MultiMediaData) this.multiMediaDataSuperpositionHeader.clone();
                }
                if (this.multiMediaDataSuperpositionFooter != null) {
                    multiMediaDataTrack.multiMediaDataSuperpositionFooter = (MultiMediaData) this.multiMediaDataSuperpositionFooter.clone();
                }
                ArrayList arrayList = new ArrayList();
                for (MultiMediaData multiMediaData : this.multiMediaDataList) {
                    arrayList.add((MultiMediaData) multiMediaData.clone());
                }
                multiMediaDataTrack.multiMediaDataList = arrayList;
                return multiMediaDataTrack;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return new MultiMediaDataTrack();
            }
        }
        return invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean hasFooter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (wb9.e(this.multiMediaDataList) || this.multiMediaDataList.size() < 1) {
                return false;
            }
            List<MultiMediaData> list = this.multiMediaDataList;
            return MediaSegment.SEG_TYPE_INPUT_FOOTER.equals(list.get(list.size() - 1).inputType);
        }
        return invokeV.booleanValue;
    }

    public boolean hasHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (wb9.e(this.multiMediaDataList) || this.multiMediaDataList.get(0) == null) {
                return false;
            }
            return MediaSegment.SEG_TYPE_INPUT_HEADER.equals(this.multiMediaDataList.get(0).inputType);
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i) == null) {
            parcel.writeTypedList(this.multiMediaDataList);
            parcel.writeParcelable(this.multiMediaDataSuperpositionHeader, i);
            parcel.writeParcelable(this.multiMediaDataSuperpositionFooter, i);
        }
    }
}
