package com.baidu.tieba.location;

import android.content.Context;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.p0.x.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class LocationProvidersStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
                int indexOf = editorTools.getCollectTools().indexOf(7);
                if (indexOf != -1) {
                    editorTools.addTool(new c.a.q0.s1.d.b(editorTools.getContext(), indexOf + 1));
                }
                if (editorTools.getCollectTools().indexOf(8) != -1) {
                    if (editorTools.isIsFromPb()) {
                        editorTools.addTool(new c.a.q0.s1.d.a(editorTools.getContext(), true));
                    } else {
                        editorTools.addTool(new c.a.q0.s1.d.a(editorTools.getContext()));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Context> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<m> run(CustomMessage<Context> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2016556, new c.a.q0.s1.d.b(customMessage.getData(), 0)) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements CustomMessageTask.CustomRunnable<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Bundle> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    Bundle data = customMessage.getData();
                    Address address = (Address) data.getParcelable("location");
                    String string = data.getString("coorType");
                    if (address != null && !StringUtils.isNULL(string)) {
                        BDLocation bDLocation = new BDLocation();
                        bDLocation.setLatitude(address.getLatitude());
                        bDLocation.setLongitude(address.getLongitude());
                        if (TextUtils.equals(string, BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                            bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), BDLocation.BDLOCATION_GCJ02_TO_BD09);
                        } else if (TextUtils.equals(string, "gcj02")) {
                            bDLocation = LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                        } else if (TextUtils.equals(string, CoordinateType.WGS84)) {
                            bDLocation = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation, BDLocation.BDLOCATION_BD09LL_TO_GCJ02), "gcj2wgs");
                        }
                        address.setLatitude(bDLocation.getLatitude());
                        address.setLongitude(bDLocation.getLongitude());
                        return new CustomResponsedMessage<>(2921363, address);
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-186373236, "Lcom/baidu/tieba/location/LocationProvidersStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-186373236, "Lcom/baidu/tieba/location/LocationProvidersStatic;");
                return;
            }
        }
        c.a.e.e.i.a.l().p(c.a.q0.s1.b.t());
        boolean loadBoolean = TbadkSettings.getInst().loadBoolean("bd_loc_switcher", true);
        if (Build.VERSION.SDK_INT <= 4) {
            loadBoolean = false;
        }
        if (loadBoolean) {
            c.a.e.e.i.a.l().p(c.a.q0.s1.a.j());
        }
        MessageManager.getInstance().registerListener(new a(2010044));
        CustomMessageTask customMessageTask = new CustomMessageTask(2016556, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2921363, new c());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }

    public LocationProvidersStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
