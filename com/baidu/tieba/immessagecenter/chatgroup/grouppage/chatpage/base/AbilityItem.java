package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.jo8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem;", "Ljava/io/Serializable;", "type", "", "confMap", "", "", "styleConf", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$StyleConf;", "(Ljava/lang/String;Ljava/util/Map;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$StyleConf;)V", "getConfMap", "()Ljava/util/Map;", "getStyleConf", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$StyleConf;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "Extra", "Style", "StyleConf", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AbilityItem implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("ability_conf")
    public final Map<String, Object> confMap;
    @SerializedName("style_conf")
    public final StyleConf styleConf;
    @SerializedName("ability_type")
    public final String type;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AbilityItem copy$default(AbilityItem abilityItem, String str, Map map, StyleConf styleConf, int i, Object obj) {
        if ((i & 1) != 0) {
            str = abilityItem.type;
        }
        if ((i & 2) != 0) {
            map = abilityItem.confMap;
        }
        if ((i & 4) != 0) {
            styleConf = abilityItem.styleConf;
        }
        return abilityItem.copy(str, map, styleConf);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    public final Map<String, Object> component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.confMap : (Map) invokeV.objValue;
    }

    public final StyleConf component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.styleConf : (StyleConf) invokeV.objValue;
    }

    public final AbilityItem copy(String type, Map<String, ? extends Object> confMap, StyleConf styleConf) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, type, confMap, styleConf)) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(confMap, "confMap");
            return new AbilityItem(type, confMap, styleConf);
        }
        return (AbilityItem) invokeLLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AbilityItem) {
                AbilityItem abilityItem = (AbilityItem) obj;
                return Intrinsics.areEqual(this.type, abilityItem.type) && Intrinsics.areEqual(this.confMap, abilityItem.confMap) && Intrinsics.areEqual(this.styleConf, abilityItem.styleConf);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int hashCode = ((this.type.hashCode() * 31) + this.confMap.hashCode()) * 31;
            StyleConf styleConf = this.styleConf;
            return hashCode + (styleConf == null ? 0 : styleConf.hashCode());
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "AbilityItem(type=" + this.type + ", confMap=" + this.confMap + ", styleConf=" + this.styleConf + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Extra;", "Ljava/io/Serializable;", "startImage", "", "endImage", "mainStartImage", "mainEndImage", "waitingIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEndImage", "()Ljava/lang/String;", "getMainEndImage", "getMainStartImage", "getStartImage", "getWaitingIcon", "component1", "component2", "component3", "component4", "component5", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Extra implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("end_image")
        public final String endImage;
        @SerializedName("main_end_image")
        public final String mainEndImage;
        @SerializedName("main_start_image")
        public final String mainStartImage;
        @SerializedName("start_image")
        public final String startImage;
        @SerializedName("waiting_icon")
        public final String waitingIcon;

        public static /* synthetic */ Extra copy$default(Extra extra, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = extra.startImage;
            }
            if ((i & 2) != 0) {
                str2 = extra.endImage;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = extra.mainStartImage;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = extra.mainEndImage;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = extra.waitingIcon;
            }
            return extra.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.startImage : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.endImage : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mainStartImage : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mainEndImage : (String) invokeV.objValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.waitingIcon : (String) invokeV.objValue;
        }

        public final Extra copy(String str, String str2, String str3, String str4, String str5) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048581, this, str, str2, str3, str4, str5)) == null) ? new Extra(str, str2, str3, str4, str5) : (Extra) invokeLLLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Extra) {
                    Extra extra = (Extra) obj;
                    return Intrinsics.areEqual(this.startImage, extra.startImage) && Intrinsics.areEqual(this.endImage, extra.endImage) && Intrinsics.areEqual(this.mainStartImage, extra.mainStartImage) && Intrinsics.areEqual(this.mainEndImage, extra.mainEndImage) && Intrinsics.areEqual(this.waitingIcon, extra.waitingIcon);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                String str = this.startImage;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.endImage;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.mainStartImage;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.mainEndImage;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.waitingIcon;
                return hashCode4 + (str5 != null ? str5.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return "Extra(startImage=" + this.startImage + ", endImage=" + this.endImage + ", mainStartImage=" + this.mainStartImage + ", mainEndImage=" + this.mainEndImage + ", waitingIcon=" + this.waitingIcon + ')';
            }
            return (String) invokeV.objValue;
        }

        public Extra(String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.startImage = str;
            this.endImage = str2;
            this.mainStartImage = str3;
            this.mainEndImage = str4;
            this.waitingIcon = str5;
        }

        public final String getEndImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.endImage;
            }
            return (String) invokeV.objValue;
        }

        public final String getMainEndImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mainEndImage;
            }
            return (String) invokeV.objValue;
        }

        public final String getMainStartImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.mainStartImage;
            }
            return (String) invokeV.objValue;
        }

        public final String getStartImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.startImage;
            }
            return (String) invokeV.objValue;
        }

        public final String getWaitingIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.waitingIcon;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;", "Ljava/io/Serializable;", "contentColor", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getContentColor", "getIcon", "setIcon", "(Ljava/lang/String;)V", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Style implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("background_color")
        public final String backgroundColor;
        @SerializedName("content_color")
        public final String contentColor;
        public String icon;

        public static /* synthetic */ Style copy$default(Style style, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = style.contentColor;
            }
            if ((i & 2) != 0) {
                str2 = style.backgroundColor;
            }
            if ((i & 4) != 0) {
                str3 = style.icon;
            }
            return style.copy(str, str2, str3);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.contentColor : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.backgroundColor : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.icon : (String) invokeV.objValue;
        }

        public final Style copy(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, str2, str3)) == null) ? new Style(str, str2, str3) : (Style) invokeLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Style) {
                    Style style = (Style) obj;
                    return Intrinsics.areEqual(this.contentColor, style.contentColor) && Intrinsics.areEqual(this.backgroundColor, style.backgroundColor) && Intrinsics.areEqual(this.icon, style.icon);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                String str = this.contentColor;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.backgroundColor;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.icon;
                return hashCode2 + (str3 != null ? str3.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return "Style(contentColor=" + this.contentColor + ", backgroundColor=" + this.backgroundColor + ", icon=" + this.icon + ')';
            }
            return (String) invokeV.objValue;
        }

        public Style(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.contentColor = str;
            this.backgroundColor = str2;
            this.icon = str3;
        }

        public final String getBackgroundColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.backgroundColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getContentColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.contentColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getIcon() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.icon;
            }
            return (String) invokeV.objValue;
        }

        public final void setIcon(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.icon = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0088\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0006\u00103\u001a\u00020/J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u000e\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015¨\u00065"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$StyleConf;", "Ljava/io/Serializable;", "showType", "", "toUk", "", "scene", "content", "day", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;", "dark", "errorTips", "showMsgType", "", "isFilterBotMsg", "androidExtra", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Extra;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Extra;)V", "getAndroidExtra", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Extra;", "getContent", "()Ljava/lang/String;", "getDark", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;", "getDay", "getErrorTips", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScene", "getShowMsgType", "()Ljava/util/List;", "getShowType", "()I", "getToUk", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Style;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$Extra;)Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/base/AbilityItem$StyleConf;", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "shouldShow", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class StyleConf implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("android_extra")
        public final Extra androidExtra;
        public final String content;
        public final Style dark;
        public final Style day;
        @SerializedName("error_tips")
        public final String errorTips;
        @SerializedName("is_filter_bot_msg")
        public final Integer isFilterBotMsg;
        public final String scene;
        @SerializedName("show_msg_type")
        public final List<Integer> showMsgType;
        @SerializedName(RecordVideoActivityConfig.SHOW_TYPE)
        public final int showType;
        @SerializedName("to_uk")
        public final String toUk;

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.showType : invokeV.intValue;
        }

        public final Extra component10() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.androidExtra : (Extra) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.toUk : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.scene : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.content : (String) invokeV.objValue;
        }

        public final Style component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.day : (Style) invokeV.objValue;
        }

        public final Style component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.dark : (Style) invokeV.objValue;
        }

        public final String component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.errorTips : (String) invokeV.objValue;
        }

        public final List<Integer> component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.showMsgType : (List) invokeV.objValue;
        }

        public final Integer component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.isFilterBotMsg : (Integer) invokeV.objValue;
        }

        public final StyleConf copy(int i, String str, String scene, String str2, Style style, Style style2, String str3, List<Integer> list, Integer num, Extra extra) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, scene, str2, style, style2, str3, list, num, extra})) == null) {
                Intrinsics.checkNotNullParameter(scene, "scene");
                return new StyleConf(i, str, scene, str2, style, style2, str3, list, num, extra);
            }
            return (StyleConf) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof StyleConf) {
                    StyleConf styleConf = (StyleConf) obj;
                    return this.showType == styleConf.showType && Intrinsics.areEqual(this.toUk, styleConf.toUk) && Intrinsics.areEqual(this.scene, styleConf.scene) && Intrinsics.areEqual(this.content, styleConf.content) && Intrinsics.areEqual(this.day, styleConf.day) && Intrinsics.areEqual(this.dark, styleConf.dark) && Intrinsics.areEqual(this.errorTips, styleConf.errorTips) && Intrinsics.areEqual(this.showMsgType, styleConf.showMsgType) && Intrinsics.areEqual(this.isFilterBotMsg, styleConf.isFilterBotMsg) && Intrinsics.areEqual(this.androidExtra, styleConf.androidExtra);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                int i = this.showType * 31;
                String str = this.toUk;
                int hashCode = (((i + (str == null ? 0 : str.hashCode())) * 31) + this.scene.hashCode()) * 31;
                String str2 = this.content;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                Style style = this.day;
                int hashCode3 = (hashCode2 + (style == null ? 0 : style.hashCode())) * 31;
                Style style2 = this.dark;
                int hashCode4 = (hashCode3 + (style2 == null ? 0 : style2.hashCode())) * 31;
                String str3 = this.errorTips;
                int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
                List<Integer> list = this.showMsgType;
                int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
                Integer num = this.isFilterBotMsg;
                int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
                Extra extra = this.androidExtra;
                return hashCode7 + (extra != null ? extra.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return "StyleConf(showType=" + this.showType + ", toUk=" + this.toUk + ", scene=" + this.scene + ", content=" + this.content + ", day=" + this.day + ", dark=" + this.dark + ", errorTips=" + this.errorTips + ", showMsgType=" + this.showMsgType + ", isFilterBotMsg=" + this.isFilterBotMsg + ", androidExtra=" + this.androidExtra + ')';
            }
            return (String) invokeV.objValue;
        }

        public StyleConf(int i, String str, String scene, String str2, Style style, Style style2, String str3, List<Integer> list, Integer num, Extra extra) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, scene, str2, style, style2, str3, list, num, extra};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(scene, "scene");
            this.showType = i;
            this.toUk = str;
            this.scene = scene;
            this.content = str2;
            this.day = style;
            this.dark = style2;
            this.errorTips = str3;
            this.showMsgType = list;
            this.isFilterBotMsg = num;
            this.androidExtra = extra;
        }

        public final Extra getAndroidExtra() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.androidExtra;
            }
            return (Extra) invokeV.objValue;
        }

        public final String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.content;
            }
            return (String) invokeV.objValue;
        }

        public final Style getDark() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.dark;
            }
            return (Style) invokeV.objValue;
        }

        public final Style getDay() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.day;
            }
            return (Style) invokeV.objValue;
        }

        public final String getErrorTips() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.errorTips;
            }
            return (String) invokeV.objValue;
        }

        public final String getScene() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.scene;
            }
            return (String) invokeV.objValue;
        }

        public final List<Integer> getShowMsgType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.showMsgType;
            }
            return (List) invokeV.objValue;
        }

        public final int getShowType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.showType;
            }
            return invokeV.intValue;
        }

        public final String getToUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.toUk;
            }
            return (String) invokeV.objValue;
        }

        public final Integer isFilterBotMsg() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.isFilterBotMsg;
            }
            return (Integer) invokeV.objValue;
        }

        public final boolean shouldShow() {
            InterceptResult invokeV;
            boolean z;
            boolean e;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (this.showType == 2) {
                    return true;
                }
                String str = this.toUk;
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return false;
                }
                try {
                    e = jo8.e(this.toUk);
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
                if (this.showType == 0 && e) {
                    return true;
                }
                if (this.showType == 1 && !e) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public AbilityItem(String type, Map<String, ? extends Object> confMap, StyleConf styleConf) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type, confMap, styleConf};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(confMap, "confMap");
        this.type = type;
        this.confMap = confMap;
        this.styleConf = styleConf;
    }

    public final Map<String, Object> getConfMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.confMap;
        }
        return (Map) invokeV.objValue;
    }

    public final StyleConf getStyleConf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.styleConf;
        }
        return (StyleConf) invokeV.objValue;
    }

    public final String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.type;
        }
        return (String) invokeV.objValue;
    }
}
