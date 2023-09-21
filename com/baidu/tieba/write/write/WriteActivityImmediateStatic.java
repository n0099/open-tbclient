package com.baidu.tieba.write.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.controller.CustomRule;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m9;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.write.webwrite.WebWriteActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class WriteActivityImmediateStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends CustomRule {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, customMessage, customMessageTask)) == null) {
                if (customMessage != null) {
                    Object data = customMessage.getData();
                    if ((data instanceof IntentConfig) && ((IntentConfig) data).getContext() != null) {
                        try {
                            Class<?> cls = data.getClass();
                            boolean z2 = false;
                            if (WriteActivityConfig.class == cls || WorkPublishActivityConfig.class == cls || WriteVoteActivityConfig.class == cls || AlbumFloatActivityConfig.class == cls) {
                                if (data instanceof WriteActivityConfig) {
                                    z = ((WriteActivityConfig) data).getIntent().getBooleanExtra(WriteActivityConfig.KEY_NOT_SHOW_VIDEO_WORK_LIST_PAGE, false);
                                } else {
                                    z = false;
                                }
                                String simpleName = ((IntentConfig) data).getContext().getClass().getSimpleName();
                                if ("FrsActivity".equals(simpleName) || "MainTabActivity".equals(simpleName) || z) {
                                    WriteMsgHolder.setCurrentWriteActivityFromTag(m9.a(((IntentConfig) data).getContext()).getUniqueId());
                                    WriteMsgHolder.setFromPersonCenter(false);
                                }
                            }
                            if (WorkPublishManager.isWorkPublishLocateMyTab()) {
                                WriteMsgHolder.setCurrentWriteActivityFromTag(null);
                            }
                            IntentConfig intentConfig = (IntentConfig) data;
                            if (intentConfig instanceof WriteActivityConfig) {
                                boolean booleanExtra = intentConfig.getIntent().getBooleanExtra(WriteActivityConfig.KEY_IS_WRITE_TEST, false);
                                if ((intentConfig.getIntent().getFlags() & 603979776) != 0) {
                                    z2 = true;
                                }
                                TbLog hybridLog = HybridLog.getInstance();
                                hybridLog.i("WebWriteActivity", "尝试打开新发布器 isWriteTest:" + booleanExtra + " isH5PageShowing:" + WriteMsgHolder.isH5PageShowing + " flag:" + intentConfig.getIntent().getFlags());
                                if (booleanExtra || (WriteMsgHolder.isH5PageShowing && z2)) {
                                    ((WriteActivityConfig) intentConfig).setActivityClass(WebWriteActivity.class);
                                }
                            }
                        } catch (Exception e) {
                            TbLog hybridLog2 = HybridLog.getInstance();
                            hybridLog2.i("WebWriteActivity", "发布器rule执行异常:" + e);
                        }
                    }
                }
                return customMessage;
            }
            return (CustomMessage) invokeLL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // com.baidu.adp.framework.controller.MessageRule
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1727489084, "Lcom/baidu/tieba/write/write/WriteActivityImmediateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1727489084, "Lcom/baidu/tieba/write/write/WriteActivityImmediateStatic;");
                return;
            }
        }
        a();
    }

    public WriteActivityImmediateStatic() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager.getInstance().addMessageRule(new a(2002001));
        }
    }
}
