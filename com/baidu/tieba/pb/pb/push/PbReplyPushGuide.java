package com.baidu.tieba.pb.pb.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.cga;
import com.baidu.tieba.ia5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Service
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/pb/pb/push/PbReplyPushGuide;", "Lcom/baidu/tieba/push/guide/BasePushGuide;", "()V", "areSettingSwitchEnabled", "", "provideForumIcon", "", "provideForumId", "provideForumName", "provideForumSlogan", "provideScene", "provideThreadAbstract", "provideThreadId", "provideThreadTitle", "Extra", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbReplyPushGuide extends cga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.cga
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "reply_pb" : (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/pb/pb/push/PbReplyPushGuide$Extra;", "Ljava/io/Serializable;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "forumData", "Lcom/baidu/tbadk/core/data/ForumData;", "(Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tbadk/core/data/ForumData;)V", "getForumData", "()Lcom/baidu/tbadk/core/data/ForumData;", "getWriteData", "()Lcom/baidu/tbadk/coreExtra/data/WriteData;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Extra implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ForumData forumData;
        public final WriteData writeData;

        public static /* synthetic */ Extra copy$default(Extra extra, WriteData writeData, ForumData forumData, int i, Object obj) {
            if ((i & 1) != 0) {
                writeData = extra.writeData;
            }
            if ((i & 2) != 0) {
                forumData = extra.forumData;
            }
            return extra.copy(writeData, forumData);
        }

        public final WriteData component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.writeData : (WriteData) invokeV.objValue;
        }

        public final ForumData component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumData : (ForumData) invokeV.objValue;
        }

        public final Extra copy(WriteData writeData, ForumData forumData) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, writeData, forumData)) == null) ? new Extra(writeData, forumData) : (Extra) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Extra) {
                    Extra extra = (Extra) obj;
                    return Intrinsics.areEqual(this.writeData, extra.writeData) && Intrinsics.areEqual(this.forumData, extra.forumData);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                WriteData writeData = this.writeData;
                int hashCode = (writeData == null ? 0 : writeData.hashCode()) * 31;
                ForumData forumData = this.forumData;
                return hashCode + (forumData != null ? forumData.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "Extra(writeData=" + this.writeData + ", forumData=" + this.forumData + ')';
            }
            return (String) invokeV.objValue;
        }

        public Extra(WriteData writeData, ForumData forumData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, forumData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.writeData = writeData;
            this.forumData = forumData;
        }

        public final ForumData getForumData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.forumData;
            }
            return (ForumData) invokeV.objValue;
        }

        public final WriteData getWriteData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.writeData;
            }
            return (WriteData) invokeV.objValue;
        }
    }

    public PbReplyPushGuide() {
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

    @Override // com.baidu.tieba.cga
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ia5.e().B();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumIcon() {
        InterceptResult invokeV;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (forumData = extra.getForumData()) != null) {
                str = forumData.getImage_url();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumId() {
        InterceptResult invokeV;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (forumData = extra.getForumData()) != null) {
                str = forumData.getId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumName() {
        InterceptResult invokeV;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (forumData = extra.getForumData()) != null) {
                str = forumData.getName();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideForumSlogan() {
        InterceptResult invokeV;
        ForumData forumData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (forumData = extra.getForumData()) != null) {
                str = forumData.getSlogan();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideThreadAbstract() {
        InterceptResult invokeV;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (writeData = extra.getWriteData()) != null) {
                str = writeData.getContent();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideThreadId() {
        InterceptResult invokeV;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (writeData = extra.getWriteData()) != null) {
                str = writeData.getThreadId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cga, com.baidu.tieba.push.guide.DialogParamProvider
    public String provideThreadTitle() {
        InterceptResult invokeV;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object d = d();
            String str = null;
            if (!(d instanceof Extra)) {
                d = null;
            }
            Extra extra = (Extra) d;
            if (extra != null && (writeData = extra.getWriteData()) != null) {
                str = writeData.getTitle();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
