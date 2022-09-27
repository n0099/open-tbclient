package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class yc6 {
    public static /* synthetic */ Interceptable $ic;
    public static yc6 f;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public List<String> b;
    public int c;
    public CustomMessageListener d;
    public CustomMessageListener e;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yc6 yc6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var, Integer.valueOf(i)};
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
            this.a = yc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001140 && (customResponsedMessage instanceof CancelDownloadMessage)) {
                this.a.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yc6 yc6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var, Integer.valueOf(i)};
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
            this.a = yc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001119 && (customResponsedMessage instanceof QueryDownloadMessage)) {
                this.a.b = ((QueryDownloadMessage) customResponsedMessage).getData();
                yc6 yc6Var = this.a;
                yc6Var.g(yc6Var.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<List<String>, List<DownloadData>, List<DownloadData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc6 a;

        public c(yc6 yc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<DownloadData> doInBackground(List<String>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                LinkedList linkedList = new LinkedList();
                if (listArr[0] == null) {
                    return linkedList;
                }
                for (int i = 0; i < listArr[0].size(); i++) {
                    MyEmotionGroupData d = rc6.c().d(TbadkCoreApplication.getCurrentAccount(), listArr[0].get(i));
                    if (d != null && sc6.d(d.getGroupId())) {
                        DownloadData downloadData = new DownloadData(d.getGroupId());
                        downloadData.setStatus(3);
                        linkedList.add(downloadData);
                    }
                }
                return linkedList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<DownloadData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (list == null) {
                    list = new LinkedList<>();
                }
                for (DownloadData downloadData : d55.k().j()) {
                    for (String str : this.a.b) {
                        if (downloadData.getType() == 11 && downloadData.getId().equals(str)) {
                            list.add(downloadData);
                        }
                    }
                }
                this.a.h(list);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325405, "Lcom/baidu/tieba/yc6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325405, "Lcom/baidu/tieba/yc6;");
                return;
            }
        }
        f = new yc6();
    }

    public yc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 5;
        this.d = new a(this, 2001140);
        this.e = new b(this, 2001119);
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.d);
    }

    public static yc6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f : (yc6) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d55.k().i(11);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d55.k().f(str, 11);
        }
    }

    public final void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            c cVar = new c(this);
            this.a = cVar;
            cVar.execute(list);
        }
    }

    public void h(List<DownloadData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
        }
    }

    public void i(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) || dj.isEmpty(str) || dj.isEmpty(str3)) {
            return;
        }
        DownloadData downloadData = new DownloadData(str, str2, str3, new xc6());
        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
        downloadData.setType(11);
        String[] split = str3.split("/");
        if (split.length > 1) {
            String[] split2 = split[split.length - 1].split("_");
            if (split2 != null) {
                if (split2.length == 5) {
                    downloadData.setDescription(split2[1]);
                    downloadData.setCheck(split2[2]);
                    downloadData.setWidth(dh.e(split2[3], 200));
                    downloadData.setHeight(dh.e(split2[4].split(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)[0], 200));
                } else if (split2.length == 3) {
                    downloadData.setDescription(split2[1]);
                    downloadData.setCheck(split2[2].split(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX)[0]);
                    downloadData.setWidth(200);
                    downloadData.setHeight(200);
                } else {
                    downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0510));
                    downloadData.setStatus(2);
                }
            } else {
                downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0510));
                downloadData.setStatus(2);
            }
        } else {
            downloadData.setStatusMsg(TbadkApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0510));
            downloadData.setStatus(2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath());
        sb.append(FileHelper.getPrefixByType(2));
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        downloadData.setPath(sb.toString());
        BdLog.d("download:path:" + downloadData.getPath());
        d55.k().m(downloadData, this.c);
    }
}
