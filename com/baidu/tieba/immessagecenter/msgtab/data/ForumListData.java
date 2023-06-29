package com.baidu.tieba.immessagecenter.msgtab.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "Ljava/io/Serializable;", "isRecom", "", "forumData", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabForumData;", "extFunctionData", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabFunctionData;", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getExtFunctionData", "()Ljava/util/List;", "setExtFunctionData", "(Ljava/util/List;)V", "getForumData", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumListData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("ext_fun_list")
    public List<MsgTabFunctionData> extFunctionData;
    @SerializedName("channel_list")
    public final List<MsgTabForumData> forumData;
    @SerializedName("is_recom")
    public final Integer isRecom;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.msgtab.data.ForumListData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForumListData copy$default(ForumListData forumListData, Integer num, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = forumListData.isRecom;
        }
        if ((i & 2) != 0) {
            list = forumListData.forumData;
        }
        if ((i & 4) != 0) {
            list2 = forumListData.extFunctionData;
        }
        return forumListData.copy(num, list, list2);
    }

    public final Integer component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isRecom : (Integer) invokeV.objValue;
    }

    public final List<MsgTabForumData> component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumData : (List) invokeV.objValue;
    }

    public final List<MsgTabFunctionData> component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extFunctionData : (List) invokeV.objValue;
    }

    public final ForumListData copy(Integer num, List<MsgTabForumData> list, List<MsgTabFunctionData> list2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, num, list, list2)) == null) ? new ForumListData(num, list, list2) : (ForumListData) invokeLLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "ForumListData(isRecom=" + this.isRecom + ", forumData=" + this.forumData + ", extFunctionData=" + this.extFunctionData + ')';
        }
        return (String) invokeV.objValue;
    }

    public ForumListData(Integer num, List<MsgTabForumData> list, List<MsgTabFunctionData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isRecom = num;
        this.forumData = list;
        this.extFunctionData = list2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (!(obj instanceof ForumListData)) {
                return false;
            }
            ForumListData forumListData = (ForumListData) obj;
            if (!Intrinsics.areEqual(this.isRecom, forumListData.isRecom) || !Intrinsics.areEqual(this.forumData, forumListData.forumData) || !Intrinsics.areEqual(this.extFunctionData, forumListData.extFunctionData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final List<MsgTabFunctionData> getExtFunctionData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.extFunctionData;
        }
        return (List) invokeV.objValue;
    }

    public final List<MsgTabForumData> getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.forumData;
        }
        return (List) invokeV.objValue;
    }

    public final Integer isRecom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isRecom;
        }
        return (Integer) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Integer num = this.isRecom;
            int i3 = 0;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            int i4 = i * 31;
            List<MsgTabForumData> list = this.forumData;
            if (list != null) {
                i2 = list.hashCode();
            } else {
                i2 = 0;
            }
            int i5 = (i4 + i2) * 31;
            List<MsgTabFunctionData> list2 = this.extFunctionData;
            if (list2 != null) {
                i3 = list2.hashCode();
            }
            return i5 + i3;
        }
        return invokeV.intValue;
    }

    public final void setExtFunctionData(List<MsgTabFunctionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.extFunctionData = list;
        }
    }
}
