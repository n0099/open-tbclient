package com.baidu.tieba;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class lt8 extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lt8(@NonNull MainTabActivity mainTabActivity) {
        super(2921752);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        TbPageContext<BaseFragmentActivity> pageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof YyLiveRoomConfig) && ProcessUtils.isMainProcess() && (pageContext = this.a.getPageContext()) != null) {
            Intent intent = ((YyLiveRoomConfig) customResponsedMessage.getData()).getIntent();
            YYLiveUtil.jumpToYYLiveRoom(pageContext, intent.getStringExtra("sid"), intent.getStringExtra(YyLiveRoomConfig.KEY_SSID), intent.getStringExtra(YyLiveRoomConfig.KEY_TEMPLATE_ID), intent.getStringExtra("room_id"), intent.getStringExtra(YyLiveRoomConfig.KEY_STREAMINFO), intent.getStringExtra("source"));
        }
    }
}
