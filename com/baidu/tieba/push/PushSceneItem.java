package com.baidu.tieba.push;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u0081\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\u0006\u00100\u001a\u00020,J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u001c¨\u00062"}, d2 = {"Lcom/baidu/tieba/push/PushSceneItem;", "Ljava/io/Serializable;", "sceneName", "", "style", "title", "text", "period", "", "threshold", "sceneClass", "", "h5DialogUrl", "dialogParams", "actionCommand", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getActionCommand", "()Ljava/util/List;", "getDialogParams", "getH5DialogUrl", "()Ljava/lang/String;", "getPeriod", "()I", "getSceneClass", "getSceneName", "getStyle", "getText", "setText", "(Ljava/lang/String;)V", "getThreshold", "getTitle", "setTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "isHitNewStyle", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PushSceneItem implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("action_cond")
    public final List<String> actionCommand;
    @SerializedName("pop_params")
    public final List<String> dialogParams;
    @SerializedName("pop_url")
    public final String h5DialogUrl;
    @SerializedName("freq")
    public final int period;
    @SerializedName("class")
    public final List<String> sceneClass;
    @SerializedName("scene_name")
    public final String sceneName;
    public final String style;
    public String text;
    public final int threshold;
    public String title;

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.sceneName : (String) invokeV.objValue;
    }

    public final List<String> component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.actionCommand : (List) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.style : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.title : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.text : (String) invokeV.objValue;
    }

    public final int component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.period : invokeV.intValue;
    }

    public final int component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.threshold : invokeV.intValue;
    }

    public final List<String> component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.sceneClass : (List) invokeV.objValue;
    }

    public final String component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h5DialogUrl : (String) invokeV.objValue;
    }

    public final List<String> component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.dialogParams : (List) invokeV.objValue;
    }

    public final PushSceneItem copy(String sceneName, String style, String title, String text, int i, int i2, List<String> sceneClass, String str, List<String> dialogParams, List<String> actionCommand) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{sceneName, style, title, text, Integer.valueOf(i), Integer.valueOf(i2), sceneClass, str, dialogParams, actionCommand})) == null) {
            Intrinsics.checkNotNullParameter(sceneName, "sceneName");
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(sceneClass, "sceneClass");
            Intrinsics.checkNotNullParameter(dialogParams, "dialogParams");
            Intrinsics.checkNotNullParameter(actionCommand, "actionCommand");
            return new PushSceneItem(sceneName, style, title, text, i, i2, sceneClass, str, dialogParams, actionCommand);
        }
        return (PushSceneItem) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PushSceneItem) {
                PushSceneItem pushSceneItem = (PushSceneItem) obj;
                return Intrinsics.areEqual(this.sceneName, pushSceneItem.sceneName) && Intrinsics.areEqual(this.style, pushSceneItem.style) && Intrinsics.areEqual(this.title, pushSceneItem.title) && Intrinsics.areEqual(this.text, pushSceneItem.text) && this.period == pushSceneItem.period && this.threshold == pushSceneItem.threshold && Intrinsics.areEqual(this.sceneClass, pushSceneItem.sceneClass) && Intrinsics.areEqual(this.h5DialogUrl, pushSceneItem.h5DialogUrl) && Intrinsics.areEqual(this.dialogParams, pushSceneItem.dialogParams) && Intrinsics.areEqual(this.actionCommand, pushSceneItem.actionCommand);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int hashCode = ((((((((((((this.sceneName.hashCode() * 31) + this.style.hashCode()) * 31) + this.title.hashCode()) * 31) + this.text.hashCode()) * 31) + this.period) * 31) + this.threshold) * 31) + this.sceneClass.hashCode()) * 31;
            String str = this.h5DialogUrl;
            return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.dialogParams.hashCode()) * 31) + this.actionCommand.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return "PushSceneItem(sceneName=" + this.sceneName + ", style=" + this.style + ", title=" + this.title + ", text=" + this.text + ", period=" + this.period + ", threshold=" + this.threshold + ", sceneClass=" + this.sceneClass + ", h5DialogUrl=" + this.h5DialogUrl + ", dialogParams=" + this.dialogParams + ", actionCommand=" + this.actionCommand + ')';
        }
        return (String) invokeV.objValue;
    }

    public PushSceneItem(String sceneName, String style, String title, String text, int i, int i2, List<String> sceneClass, String str, List<String> dialogParams, List<String> actionCommand) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneName, style, title, text, Integer.valueOf(i), Integer.valueOf(i2), sceneClass, str, dialogParams, actionCommand};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(sceneName, "sceneName");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(sceneClass, "sceneClass");
        Intrinsics.checkNotNullParameter(dialogParams, "dialogParams");
        Intrinsics.checkNotNullParameter(actionCommand, "actionCommand");
        this.sceneName = sceneName;
        this.style = style;
        this.title = title;
        this.text = text;
        this.period = i;
        this.threshold = i2;
        this.sceneClass = sceneClass;
        this.h5DialogUrl = str;
        this.dialogParams = dialogParams;
        this.actionCommand = actionCommand;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PushSceneItem(String str, String str2, String str3, String str4, int i, int i2, List list, String str5, List list2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, r7, list, str5, list2, list3);
        int i4;
        if ((i3 & 32) != 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
    }

    public final List<String> getActionCommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.actionCommand;
        }
        return (List) invokeV.objValue;
    }

    public final List<String> getDialogParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.dialogParams;
        }
        return (List) invokeV.objValue;
    }

    public final String getH5DialogUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h5DialogUrl;
        }
        return (String) invokeV.objValue;
    }

    public final int getPeriod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.period;
        }
        return invokeV.intValue;
    }

    public final List<String> getSceneClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.sceneClass;
        }
        return (List) invokeV.objValue;
    }

    public final String getSceneName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.sceneName;
        }
        return (String) invokeV.objValue;
    }

    public final String getStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.style;
        }
        return (String) invokeV.objValue;
    }

    public final String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public final int getThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.threshold;
        }
        return invokeV.intValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public final boolean isHitNewStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return TextUtils.equals(this.style, "99");
        }
        return invokeV.booleanValue;
    }

    public final void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }

    public final void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }
}
