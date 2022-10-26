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
public class tc implements uc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public tc() {
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

    private boolean fillByDataSource(pd pdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, pdVar)) == null) {
            boolean a = ue.a(pdVar, this);
            onFinishSourceToObject(a);
            return a;
        }
        return invokeL.booleanValue;
    }

    private boolean fillInDataSource(pd pdVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, pdVar)) == null) {
            onPreObjectToSource();
            return te.a(this, pdVar);
        }
        return invokeL.booleanValue;
    }

    public boolean fillByBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
            return fillByDataSource(new nd(bundle));
        }
        return invokeL.booleanValue;
    }

    public boolean fillByCursorObject(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor)) == null) {
            return fillByDataSource(new od(cursor));
        }
        return invokeL.booleanValue;
    }

    public boolean fillByIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent)) == null) {
            return fillByDataSource(new qd(intent));
        }
        return invokeL.booleanValue;
    }

    public boolean fillByJsonObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            return fillByDataSource(new rd(jSONObject));
        }
        return invokeL.booleanValue;
    }

    public boolean fillByMap(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            return fillByDataSource(new sd(map));
        }
        return invokeL.booleanValue;
    }

    public boolean fillByProtobufObject(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, message)) == null) {
            return fillByDataSource(new td(message));
        }
        return invokeL.booleanValue;
    }

    public boolean fillByXmlObject(Element element) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, element)) == null) {
            return fillByDataSource(new ud(element));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
            return fillInDataSource(new nd(bundle));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInCursorObject(ContentValues contentValues) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, contentValues)) == null) {
            return fillInDataSource(new od(contentValues));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInIntent(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, intent)) == null) {
            return fillInDataSource(new qd(intent));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInJsonObject(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, jSONObject)) == null) {
            return fillInDataSource(new rd(jSONObject));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInMap(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, map)) == null) {
            return fillInDataSource(new sd(map));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInProtobufObject(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, message)) == null) {
            return fillInDataSource(new td(message));
        }
        return invokeL.booleanValue;
    }

    public boolean fillInXmlObject(Element element) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, element)) == null) {
            return fillInDataSource(new ud(element));
        }
        return invokeL.booleanValue;
    }
}
