package com.baidu.tieba.tbadkCore.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.RecommendTopicData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecomTopicList;
import tbclient.WorksInfo;
/* loaded from: classes6.dex */
public class WorksInfoData implements Serializable, Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<WorksInfoData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isWorks;
    public List<RecommendTopicData.RecommendTopicListData> topicListData;

    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<WorksInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WorksInfoData createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new WorksInfoData(parcel) : (WorksInfoData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WorksInfoData[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new WorksInfoData[i] : (WorksInfoData[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1108683170, "Lcom/baidu/tieba/tbadkCore/data/WorksInfoData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1108683170, "Lcom/baidu/tieba/tbadkCore/data/WorksInfoData;");
                return;
            }
        }
        CREATOR = new a();
    }

    public WorksInfoData() {
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

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.isWorks = jSONObject.optInt("is_works") == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("topic_list");
        if (optJSONArray != null) {
            this.topicListData = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                recommendTopicListData.parseJson(optJSONArray.optJSONObject(i));
                this.topicListData.add(recommendTopicListData);
            }
        }
    }

    public void parseProto(WorksInfo worksInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, worksInfo) == null) || worksInfo == null) {
            return;
        }
        this.isWorks = worksInfo.is_works.intValue() == 1;
        if (worksInfo.topic_list != null) {
            this.topicListData = new ArrayList();
            for (RecomTopicList recomTopicList : worksInfo.topic_list) {
                RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                recommendTopicListData.parserProtoBuf(recomTopicList);
                this.topicListData.add(recommendTopicListData);
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
            parcel.writeByte(this.isWorks ? (byte) 1 : (byte) 0);
            parcel.writeList(this.topicListData);
        }
    }

    public WorksInfoData(Parcel parcel) {
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
        this.isWorks = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        this.topicListData = arrayList;
        parcel.readList(arrayList, RecommendTopicData.RecommendTopicListData.class.getClassLoader());
    }
}
