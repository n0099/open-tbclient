package com.baidu.tieba.pb.interactionpopupwindow;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CustomDialogData implements IBaseDialogData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String POS_LEFT = "left";
    public static final int TYPE_ADD_THREAD = 2;
    public static final int TYPE_AGREE = 0;
    public static final int TYPE_REPLY = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String body;
    public Head head;
    public Button leftButton;
    public Button rightButton;
    public int type;

    @Override // com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public static class Button implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String action;
        public String image;
        public String text;

        public Button() {
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
    }

    /* loaded from: classes5.dex */
    public static class Head implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String imageUrl;
        public String text;

        public Head() {
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
    }

    public CustomDialogData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = -1;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public static CustomDialogData praseJSON(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            CustomDialogData customDialogData = new CustomDialogData();
            JSONObject optJSONObject = jSONObject.optJSONObject("head");
            if (optJSONObject != null) {
                Head head = new Head();
                head.imageUrl = optJSONObject.optString("image");
                head.text = optJSONObject.optString("text");
                customDialogData.head = head;
            }
            customDialogData.body = jSONObject.optString("body");
            JSONArray optJSONArray = jSONObject.optJSONArray(NativeConstants.ID_BUTTON);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    Button button = new Button();
                    button.text = optJSONObject2.optString("text");
                    button.action = optJSONObject2.optString("action");
                    button.image = optJSONObject2.optString("image");
                    if (optJSONObject2.optString(CriusAttrConstants.POSITION).equals("left")) {
                        customDialogData.leftButton = button;
                    } else {
                        customDialogData.rightButton = button;
                    }
                }
            }
            return customDialogData;
        }
        return (CustomDialogData) invokeL.objValue;
    }
}
