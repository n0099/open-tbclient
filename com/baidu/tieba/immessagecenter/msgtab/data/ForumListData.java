package com.baidu.tieba.immessagecenter.msgtab.data;

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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0002\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "Ljava/io/Serializable;", "isRecom", "", "forumData", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabForumData;", "(Ljava/lang/Integer;Ljava/util/List;)V", "getForumData", "()Ljava/util/List;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/Integer;Ljava/util/List;)Lcom/baidu/tieba/immessagecenter/msgtab/data/ForumListData;", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumListData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("channel_list")
    public final List<MsgTabForumData> forumData;
    @SerializedName("is_recom")
    public final Integer isRecom;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.msgtab.data.ForumListData */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ForumListData copy$default(ForumListData forumListData, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = forumListData.isRecom;
        }
        if ((i & 2) != 0) {
            list = forumListData.forumData;
        }
        return forumListData.copy(num, list);
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

    public final ForumListData copy(Integer num, List<MsgTabForumData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, num, list)) == null) ? new ForumListData(num, list) : (ForumListData) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "ForumListData(isRecom=" + this.isRecom + ", forumData=" + this.forumData + ')';
        }
        return (String) invokeV.objValue;
    }

    public ForumListData(Integer num, List<MsgTabForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, list};
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
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (!(obj instanceof ForumListData)) {
                return false;
            }
            ForumListData forumListData = (ForumListData) obj;
            if (!Intrinsics.areEqual(this.isRecom, forumListData.isRecom) || !Intrinsics.areEqual(this.forumData, forumListData.forumData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final List<MsgTabForumData> getForumData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.forumData;
        }
        return (List) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Integer num = this.isRecom;
            int i2 = 0;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            int i3 = i * 31;
            List<MsgTabForumData> list = this.forumData;
            if (list != null) {
                i2 = list.hashCode();
            }
            return i3 + i2;
        }
        return invokeV.intValue;
    }

    public final Integer isRecom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.isRecom;
        }
        return (Integer) invokeV.objValue;
    }
}
