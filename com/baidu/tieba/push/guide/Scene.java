package com.baidu.tieba.push.guide;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/tieba/push/guide/Scene;", "", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes7.dex */
public @interface Scene {
    public static final Companion c = Companion.a;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/push/guide/Scene$Companion;", "", "()V", "BAR_ATTENTION", "", "BAR_ONE_KEY_SIGN_IN", "BAR_PB_COLLECT", "BAR_PB_REPLY", "BAR_SIGN_IN", "IM_AGREE", "IM_AT", "IM_FAN", "IM_MESSAGE_TAB", "IM_PERSONAL_MSG", "IM_REPLY", "USER_FOLLOW", "USER_NEW", "USER_PB_TO_MAIN_TAB", "USER_POST_QUESTION", "USER_POST_SUCCESS", "sceneToExtra", "", "Lcom/baidu/tieba/push/guide/Scene$Companion$Extra;", "getSettingSwitchId", "", "scene", "getSettingSwitchValue", "", "getSourceId", "Extra", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ Companion a;
        public static final Map<String, Extra> b;
        public transient /* synthetic */ FieldHolder $fh;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/push/guide/Scene$Companion$Extra;", "Ljava/io/Serializable;", "settingSwitchId", "", "settingSwitchTurnOnValue", "", "sourceId", "(IZI)V", "getSettingSwitchId", "()I", "getSettingSwitchTurnOnValue", "()Z", "getSourceId", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "", "hashCode", "toString", "", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes7.dex */
        public static final class Extra implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int settingSwitchId;
            public final boolean settingSwitchTurnOnValue;
            public final int sourceId;

            public static /* synthetic */ Extra copy$default(Extra extra, int i, boolean z, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = extra.settingSwitchId;
                }
                if ((i3 & 2) != 0) {
                    z = extra.settingSwitchTurnOnValue;
                }
                if ((i3 & 4) != 0) {
                    i2 = extra.sourceId;
                }
                return extra.copy(i, z, i2);
            }

            public final int component1() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.settingSwitchId : invokeV.intValue;
            }

            public final boolean component2() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.settingSwitchTurnOnValue : invokeV.booleanValue;
            }

            public final int component3() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sourceId : invokeV.intValue;
            }

            public final Extra copy(int i, boolean z, int i2) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) ? new Extra(i, z, i2) : (Extra) invokeCommon.objValue;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof Extra) {
                        Extra extra = (Extra) obj;
                        return this.settingSwitchId == extra.settingSwitchId && this.settingSwitchTurnOnValue == extra.settingSwitchTurnOnValue && this.sourceId == extra.sourceId;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: boolean */
            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    int i = this.settingSwitchId * 31;
                    boolean z = this.settingSwitchTurnOnValue;
                    int i2 = z;
                    if (z != 0) {
                        i2 = 1;
                    }
                    return ((i + i2) * 31) + this.sourceId;
                }
                return invokeV.intValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return "Extra(settingSwitchId=" + this.settingSwitchId + ", settingSwitchTurnOnValue=" + this.settingSwitchTurnOnValue + ", sourceId=" + this.sourceId + ')';
                }
                return (String) invokeV.objValue;
            }

            public Extra(int i, boolean z, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.settingSwitchId = i;
                this.settingSwitchTurnOnValue = z;
                this.sourceId = i2;
            }

            public final int getSettingSwitchId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.settingSwitchId;
                }
                return invokeV.intValue;
            }

            public final boolean getSettingSwitchTurnOnValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.settingSwitchTurnOnValue;
                }
                return invokeV.booleanValue;
            }

            public final int getSourceId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.sourceId;
                }
                return invokeV.intValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-60904255, "Lcom/baidu/tieba/push/guide/Scene$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-60904255, "Lcom/baidu/tieba/push/guide/Scene$Companion;");
                    return;
                }
            }
            a = new Companion();
            b = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("forum_follow", new Extra(6, false, 4)), TuplesKt.to("collect", new Extra(36, true, 6)), TuplesKt.to("forum_sign", new Extra(-1, true, 0)), TuplesKt.to("sign", new Extra(-1, true, 0)), TuplesKt.to("reply_pb", new Extra(1, true, 10)), TuplesKt.to("reply_message_bar", new Extra(1, true, 11)), TuplesKt.to("im", new Extra(10, true, 12)), TuplesKt.to("at_message_bar", new Extra(2, true, 15)), TuplesKt.to("agree_message_bar", new Extra(20, true, 14)), TuplesKt.to("fan_message_bar", new Extra(3, true, 16)), TuplesKt.to("message_tab", new Extra(-1, true, 0)), TuplesKt.to("user_follow", new Extra(34, true, 17)), TuplesKt.to("pb_to_personalize", new Extra(-1, true, 13)), TuplesKt.to("post_success", new Extra(-1, true, 13)), TuplesKt.to("post_question_success", new Extra(-1, true, 13)), TuplesKt.to("new_user", new Extra(-1, true, 7)));
        }

        public Companion() {
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

        @JvmStatic
        public final int a(String scene) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, scene)) == null) {
                Intrinsics.checkNotNullParameter(scene, "scene");
                Extra extra = b.get(scene);
                if (extra != null) {
                    return extra.getSettingSwitchId();
                }
                return -1;
            }
            return invokeL.intValue;
        }

        @JvmStatic
        public final boolean b(String scene) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scene)) == null) {
                Intrinsics.checkNotNullParameter(scene, "scene");
                Extra extra = b.get(scene);
                if (extra != null) {
                    return extra.getSettingSwitchTurnOnValue();
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return invokeL.booleanValue;
        }

        @JvmStatic
        public final int c(String scene) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, scene)) == null) {
                Intrinsics.checkNotNullParameter(scene, "scene");
                Extra extra = b.get(scene);
                if (extra != null) {
                    return extra.getSourceId();
                }
                return 0;
            }
            return invokeL.intValue;
        }
    }
}
