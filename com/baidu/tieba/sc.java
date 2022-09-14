package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.Map;
import org.json.JSONObject;
import org.w3c.dom.Element;
/* loaded from: classes5.dex */
public class sc implements tc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sc() {
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

    private boolean fillByDataSource(od odVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, odVar)) == null) {
            boolean a = te.a(odVar, this);
            onFinishSourceToObject(a);
            return a;
        }
        return invokeL.booleanValue;
    }

    private boolean fillInDataSource(od odVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, odVar)) == null) {
            onPreObjectToSource();
            return se.a(this, odVar);
        }
        return invokeL.booleanValue;
    }

    public boolean fillByBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) ? fillByDataSource(new md(bundle)) : invokeL.booleanValue;
    }

    public boolean fillByCursorObject(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) ? fillByDataSource(new nd(cursor)) : invokeL.booleanValue;
    }

    public boolean fillByIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) ? fillByDataSource(new pd(intent)) : invokeL.booleanValue;
    }

    public boolean fillByJsonObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) ? fillByDataSource(new qd(jSONObject)) : invokeL.booleanValue;
    }

    public boolean fillByMap(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) ? fillByDataSource(new rd(map)) : invokeL.booleanValue;
    }

    public boolean fillByProtobufObject(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, message)) == null) ? fillByDataSource(new sd(message)) : invokeL.booleanValue;
    }

    public boolean fillByXmlObject(Element element) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, element)) == null) ? fillByDataSource(new td(element)) : invokeL.booleanValue;
    }

    public boolean fillInBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) ? fillInDataSource(new md(bundle)) : invokeL.booleanValue;
    }

    public boolean fillInCursorObject(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, contentValues)) == null) ? fillInDataSource(new nd(contentValues)) : invokeL.booleanValue;
    }

    public boolean fillInIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, intent)) == null) ? fillInDataSource(new pd(intent)) : invokeL.booleanValue;
    }

    public boolean fillInJsonObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) ? fillInDataSource(new qd(jSONObject)) : invokeL.booleanValue;
    }

    public boolean fillInMap(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, map)) == null) ? fillInDataSource(new rd(map)) : invokeL.booleanValue;
    }

    public boolean fillInProtobufObject(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, message)) == null) ? fillInDataSource(new sd(message)) : invokeL.booleanValue;
    }

    public boolean fillInXmlObject(Element element) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, element)) == null) ? fillInDataSource(new td(element)) : invokeL.booleanValue;
    }

    public void onFinishSourceToObject(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    public void onPreObjectToSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }
}
