package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.mutiprocess.urlmanager.UrlDealEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class li5 implements fh5<UrlDealEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public li5() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fh5
    /* renamed from: a */
    public boolean onEvent(UrlDealEvent urlDealEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, urlDealEvent)) == null) {
            if (urlDealEvent != null && !TextUtils.isEmpty(urlDealEvent.url) && urlDealEvent.getType() == 3) {
                Activity mainActivity = TbadkCoreApplication.getInst().getMainActivity();
                if (mainActivity instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) mainActivity).getPageContext(), new String[]{urlDealEvent.url});
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
