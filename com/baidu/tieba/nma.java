package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.searchbox.wordscommand.data.CommandContent;
import com.baidu.searchbox.wordscommand.listener.PictureCommandInvokeCallBack;
import com.baidu.searchbox.wordscommand.runtime.IWordCommandApp;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Singleton
@Service
/* loaded from: classes7.dex */
public class nma implements IWordCommandApp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public boolean canPreloadSwanApp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public void getPictureCommandContent(String str, PictureCommandInvokeCallBack pictureCommandInvokeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, pictureCommandInvokeCallBack) == null) {
        }
    }

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public void handlePreloadSwanApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public nma() {
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

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public boolean isMainProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(false);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public boolean isNewInstall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return TbadkCoreApplication.getInst().getIsFirstUse();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public void doOnShowParseCommandDialogWithPopupExclusion(Context context, CommandContent commandContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, commandContent) == null) {
            WordCommandManager.getInstance().doOnShowParseCommandDialog(context, commandContent, null, null);
        }
    }

    @Override // com.baidu.searchbox.wordscommand.runtime.IWordCommandApp
    public void schemeInvoke(String str) {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || !PermissionUtil.isAgreePrivacyPolicy() || (parse = Uri.parse(str)) == null) {
            return;
        }
        if (str.startsWith("com.baidu.tieba://unidispatch/tbwebview")) {
            if (!str.contains("tbwebview?url=https%3A") && !str.contains("tbwebview?url=http%3A")) {
                str = str.replace("com.baidu.tieba://unidispatch/tbwebview?url=", "");
            } else {
                str = parse.getQueryParameter("url");
            }
        }
        Activity currentActivity = BdActivityStack.getInst().currentActivity();
        if (currentActivity != null && (a5.a(currentActivity) instanceof TbPageContext)) {
            UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(currentActivity), new String[]{str});
            fp4.c(Uri.parse(str));
            GrowthStatsUtil.statisticClipBoard(str);
        }
    }
}
