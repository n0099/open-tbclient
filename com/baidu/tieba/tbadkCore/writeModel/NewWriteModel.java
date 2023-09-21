package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.AccessState;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.IconStampData;
import com.baidu.tbadk.data.VideoEasterEggData;
import com.baidu.tieba.R;
import com.baidu.tieba.cma;
import com.baidu.tieba.cn5;
import com.baidu.tieba.di;
import com.baidu.tieba.dka;
import com.baidu.tieba.dma;
import com.baidu.tieba.ee5;
import com.baidu.tieba.eka;
import com.baidu.tieba.gla;
import com.baidu.tieba.jm9;
import com.baidu.tieba.lg;
import com.baidu.tieba.mm9;
import com.baidu.tieba.n05;
import com.baidu.tieba.ni9;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.pra;
import com.baidu.tieba.psa;
import com.baidu.tieba.sd9;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.wd9;
import com.baidu.tieba.wla;
import com.baidu.tieba.x35;
import com.baidu.tieba.xla;
import com.baidu.tieba.yla;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class NewWriteModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MAX_IMG_NUM = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public PostThreadTask a;
    public WriteData b;
    public d c;
    public boolean d;
    public BdPageContext<?> e;
    public boolean f;
    public boolean g;
    public eka h;
    public gla.c i;

    /* loaded from: classes8.dex */
    public interface d {
        void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ee5 ee5Var, WriteData writeData, AntiData antiData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-484724078, "Lcom/baidu/tieba/tbadkCore/writeModel/NewWriteModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-484724078, "Lcom/baidu/tieba/tbadkCore/writeModel/NewWriteModel;");
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class PostThreadTask extends BdAsyncTask<Integer, Integer, dma> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public dka a;
        public String b;
        public JSONObject c;
        public boolean d;
        public wd9 e;
        public sd9 f;
        public final /* synthetic */ NewWriteModel g;

        /* loaded from: classes8.dex */
        public class a implements eka.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostThreadTask a;

            /* renamed from: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel$PostThreadTask$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC0463a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ dma a;
                public final /* synthetic */ a b;

                public RunnableC0463a(a aVar, dma dmaVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, dmaVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = aVar;
                    this.a = dmaVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onPostExecute(this.a);
                    }
                }
            }

            public a(PostThreadTask postThreadTask) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {postThreadTask};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = postThreadTask;
            }

            @Override // com.baidu.tieba.eka.e
            public void a(dma dmaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dmaVar) == null) {
                    lg.g(new RunnableC0463a(this, dmaVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements eka.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostThreadTask a;

            /* loaded from: classes8.dex */
            public class a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ dma a;
                public final /* synthetic */ b b;

                public a(b bVar, dma dmaVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, dmaVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = bVar;
                    this.a = dmaVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.b.a.onPostExecute(this.a);
                    }
                }
            }

            public b(PostThreadTask postThreadTask) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {postThreadTask};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = postThreadTask;
            }

            @Override // com.baidu.tieba.eka.e
            public void a(dma dmaVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dmaVar) == null) {
                    lg.g(new a(this, dmaVar));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomDialogData a;
            public final /* synthetic */ PostThreadTask b;

            public c(PostThreadTask postThreadTask, CustomDialogData customDialogData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {postThreadTask, customDialogData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = postThreadTask;
                this.a = customDialogData;
            }

            @Override // java.lang.Runnable
            public void run() {
                mm9 a;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (a = jm9.a((TbPageContext) this.b.g.e, this.a)) != null) {
                    a.show();
                }
            }
        }

        public PostThreadTask(NewWriteModel newWriteModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = newWriteModel;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = false;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, wd9.class);
            if (runTask != null) {
                this.e = (wd9) runTask.getData();
            }
            wd9 wd9Var = this.e;
            if (wd9Var != null) {
                this.f = wd9Var.get();
            }
            setPriority(3);
            yla.a("发帖：任务创建：PostThreadTask");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public dma doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                n05.b("write", DownloadStatisticConstants.UBC_VALUE_TASK);
                if (this.d) {
                    return null;
                }
                cn5.e(this.g.b.getContent());
                if (this.g.b.getType() != 1 && this.g.b.getType() != 2) {
                    str = "thread_send";
                } else {
                    str = "thread_reply";
                }
                Monitor.a.b(new pra(String.valueOf((this.g.b.getTitle() + this.g.b.getContent()).hashCode()), str, this.g.b.getFrom())).e();
                yla.a("doInBackground() start");
                yla.a("发帖：任务后台执行 开始 doInBackground");
                dka dkaVar = new dka();
                this.a = dkaVar;
                dkaVar.l(this.f);
                if (this.a.n(this.g.b)) {
                    this.b = this.a.b(this.g.h, this.g.b, this.g.d, new a(this));
                    return null;
                } else if (this.a.m(this.g.b)) {
                    this.b = this.a.a(this.g.h, this.g.b, this.g.d, new b(this));
                    return null;
                } else {
                    this.b = this.a.j(this.g.b, this.g.d);
                    n05.b("write", "jsonRES");
                    try {
                        if (this.b != null) {
                            this.c = new JSONObject(this.b);
                        }
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    dma dmaVar = new dma();
                    if (this.a.i()) {
                        dmaVar.i(false);
                        ErrorData errorData = new ErrorData();
                        errorData.parserJson(this.c);
                        dmaVar.f(errorData.getError_code());
                        dmaVar.h(errorData.getError_msg());
                        dmaVar.g(errorData.getError_data());
                    } else {
                        dmaVar.i(true);
                        dmaVar.f(this.a.f());
                        dmaVar.h(this.a.h());
                    }
                    dmaVar.j(this.c);
                    return dmaVar;
                }
            }
            return (dma) invokeL.objValue;
        }

        public final void c(cma cmaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cmaVar) != null) || gla.a(cmaVar.f(), AuthTokenData.parse(this.c), this.g.i)) {
                return;
            }
            if (!cmaVar.y()) {
                if (!cmaVar.B()) {
                    if (!psa.d(cmaVar.f())) {
                        if (cmaVar.z()) {
                            ee5 ee5Var = new ee5();
                            ee5Var.f(this.c);
                            if (ee5Var.c() != null && this.g.b != null) {
                                this.g.b.setVcodeMD5(ee5Var.b());
                                this.g.b.setVcodeUrl(ee5Var.c());
                                NewWriteModel newWriteModel = this.g;
                                newWriteModel.g0(cmaVar, null, ee5Var, newWriteModel.b);
                                return;
                            }
                            return;
                        } else if (cmaVar.x()) {
                            AccessState accessState = new AccessState();
                            accessState.parserJson(this.c);
                            NewWriteModel newWriteModel2 = this.g;
                            newWriteModel2.g0(cmaVar, accessState, null, newWriteModel2.b);
                            return;
                        } else if (cmaVar.A()) {
                            this.g.f0(cmaVar);
                            return;
                        } else {
                            this.g.f0(cmaVar);
                            return;
                        }
                    }
                    this.g.d0(cmaVar);
                    this.g.f0(cmaVar);
                    return;
                }
                this.g.e0(cmaVar);
                this.g.f0(cmaVar);
                return;
            }
            this.g.f0(cmaVar);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                dka dkaVar = this.a;
                if (dkaVar != null) {
                    dkaVar.d();
                }
                if (this.g.c != null) {
                    this.g.c.callback(false, null, null, this.g.b, null);
                }
                super.cancel(true);
                this.g.a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:159:0x05a1  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x06b4  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(dma dmaVar) {
            String str;
            int i;
            int i2;
            int i3;
            int i4;
            cma cmaVar;
            JSONObject optJSONObject;
            JSONArray jSONArray;
            Object obj;
            Object obj2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            String i5;
            String h;
            String str2;
            String str3;
            PostWriteCallBackData postWriteCallBackData;
            CustomDialogData activityDialog;
            VideoEasterEggData videoEasterEggData;
            String str4;
            String str5;
            String str6;
            int i6;
            String str7;
            String str8;
            String str9;
            String str10;
            CustomDialogData customDialogData;
            String str11;
            String str12;
            String str13;
            String str14;
            AdverSegmentData adverSegmentData;
            IconStampData iconStampData;
            VideoEasterEggData videoEasterEggData2;
            String str15;
            String str16;
            String str17;
            VideoEasterEggData videoEasterEggData3;
            AdverSegmentData adverSegmentData2;
            IconStampData iconStampData2;
            IconStampData iconStampData3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dmaVar) == null) {
                super.onPostExecute(dmaVar);
                if (dmaVar == null) {
                    return;
                }
                this.c = dmaVar.d();
                this.a.k(this.g.b, dmaVar);
                if (this.g.b != null) {
                    str = String.valueOf((this.g.b.getTitle() + this.g.b.getContent()).hashCode());
                } else {
                    str = "";
                }
                String str18 = str;
                yla.a("发帖：任务后台执行 开始 doInBackground 结束");
                ErrorData g = this.a.g();
                wla.c(this.g.b, g);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3);
                if (this.g.b != null && this.g.b.isWriteTest()) {
                    i = 2;
                } else {
                    i = 1;
                }
                StatisticItem param2 = param.param(TiebaStatic.Params.OBJ_TO, i).param(TiebaStatic.Params.OBJ_PARAM2, g.getError_code());
                if (!dmaVar.e() && this.c != null) {
                    i2 = 18;
                } else {
                    i2 = 19;
                }
                StatisticItem param3 = param2.param("obj_locate", i2);
                if (this.g.b != null) {
                    i3 = this.g.b.getType();
                } else {
                    i3 = -1;
                }
                StatisticItem param4 = param3.param("obj_type", i3);
                if (this.g.b != null && this.g.b.isNewWritePage()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                TiebaStatic.log(param4.param(TiebaStatic.Params.OBJ_PARAM3, i4).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!dmaVar.e() && this.c != null) {
                    yla.a("发帖：任务后台执行 开始 doInBackground 成功");
                    AntiData e = this.a.e();
                    String error_msg = g.getError_msg();
                    if (di.isEmpty(error_msg)) {
                        error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.send_success);
                    }
                    cmaVar = new cma(g.getError_code(), error_msg, e);
                    if (this.g.b != null && this.g.b.isHasImages() && !cmaVar.w()) {
                        this.g.b.deleteUploadedTempImages();
                    }
                    Monitor.a.b(new pra(str18)).g(new HashMap<String, String>(this) { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.PostThreadTask.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PostThreadTask this$1;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i7 = newInitContext.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            put("thread_type", String.valueOf(this.this$1.g.b.getType()));
                        }
                    });
                    yla.a("发帖：任务后台执行 开始 doInBackground 删除临时的图片");
                } else if (g != null && g.error_code == 220015) {
                    cmaVar = new cma(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        try {
                            JSONObject optJSONObject2 = jSONObject.optJSONObject("info");
                            if (optJSONObject2 != null && (jSONArray = optJSONObject2.getJSONArray("confilter_hitwords")) != null && jSONArray.length() > 0) {
                                int length = jSONArray.length();
                                ArrayList<String> arrayList = new ArrayList<>();
                                for (int i7 = 0; i7 < length; i7++) {
                                    arrayList.add(jSONArray.optString(i7));
                                }
                                cmaVar.R(arrayList);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    Monitor.a.b(new pra(str18)).b(new HashMap<String, String>(this, cmaVar) { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.PostThreadTask.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PostThreadTask this$1;
                        public final /* synthetic */ cma val$result;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cmaVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i8 = newInitContext.flag;
                                if ((i8 & 1) != 0) {
                                    int i9 = i8 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$result = cmaVar;
                            put("error_code", String.valueOf(this.val$result.f()));
                            put("error_info", String.valueOf(this.val$result.g()));
                            if (this.this$1.g.b != null) {
                                put("thread_type", String.valueOf(this.this$1.g.b.getType()));
                            }
                        }
                    });
                    yla.a("发帖：任务后台执行 开始 doInBackground 失败 1");
                } else if (g != null && g.error_code == 238010) {
                    cmaVar = new cma(g.getError_code(), g.getError_msg(), null);
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null && (optJSONObject = jSONObject2.optJSONObject("info")) != null) {
                        x35 x35Var = new x35();
                        x35Var.a = optJSONObject.optString("block_content");
                        x35Var.b = optJSONObject.optString("block_cancel");
                        x35Var.c = optJSONObject.optString("block_confirm");
                        cmaVar.Q(x35Var);
                    }
                    Monitor.a.b(new pra(str18)).b(new HashMap<String, String>(this, cmaVar) { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.PostThreadTask.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PostThreadTask this$1;
                        public final /* synthetic */ cma val$result;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cmaVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i8 = newInitContext.flag;
                                if ((i8 & 1) != 0) {
                                    int i9 = i8 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$result = cmaVar;
                            put("error_code", String.valueOf(this.val$result.f()));
                            put("error_info", String.valueOf(this.val$result.g()));
                            if (this.this$1.g.b != null) {
                                put("thread_type", String.valueOf(this.this$1.g.b.getType()));
                            }
                        }
                    });
                    yla.a("发帖：任务后台执行 开始 doInBackground 失败 2");
                } else if (g != null && g.error_code != 0) {
                    String error_msg2 = g.getError_msg();
                    if (StringUtils.isNull(error_msg2)) {
                        if (g.error_code == 3250013) {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.anti_account_exception_appealing);
                        } else {
                            error_msg2 = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f137a);
                        }
                    }
                    cmaVar = new cma(g.getError_code(), error_msg2, this.a.e());
                    Monitor.a.b(new pra(str18)).b(new HashMap<String, String>(this, cmaVar) { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.PostThreadTask.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PostThreadTask this$1;
                        public final /* synthetic */ cma val$result;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cmaVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i8 = newInitContext.flag;
                                if ((i8 & 1) != 0) {
                                    int i9 = i8 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$result = cmaVar;
                            put("error_code", String.valueOf(this.val$result.f()));
                            put("error_info", String.valueOf(this.val$result.g()));
                            if (this.this$1.g.b != null) {
                                put("thread_type", String.valueOf(this.this$1.g.b.getType()));
                            }
                        }
                    });
                    yla.a("发帖：任务后台执行 开始 doInBackground 失败 3");
                } else {
                    cmaVar = new cma(-17, TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0e42), null);
                    Monitor.a.b(new pra(str18)).b(new HashMap<String, String>(this, cmaVar) { // from class: com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.PostThreadTask.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PostThreadTask this$1;
                        public final /* synthetic */ cma val$result;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cmaVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i8 = newInitContext.flag;
                                if ((i8 & 1) != 0) {
                                    int i9 = i8 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$result = cmaVar;
                            put("error_code", String.valueOf(this.val$result.f()));
                            put("error_info", String.valueOf(this.val$result.g()));
                            if (this.this$1.g.b != null) {
                                put("thread_type", String.valueOf(this.this$1.g.b.getType()));
                            }
                        }
                    });
                    yla.a("发帖：任务后台执行 开始 doInBackground 失败 4");
                }
                if (cmaVar.w()) {
                    obj = "pid";
                    obj2 = "tid";
                } else {
                    ContriInfo contriInfo = new ContriInfo();
                    JSONObject jSONObject3 = this.c;
                    if (jSONObject3 == null) {
                        obj = "pid";
                        obj2 = "tid";
                        videoEasterEggData = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        i6 = 0;
                        str7 = null;
                        str8 = null;
                        str9 = null;
                        str10 = null;
                        customDialogData = null;
                        str11 = null;
                        str12 = null;
                        str13 = null;
                        str14 = null;
                        adverSegmentData = null;
                        iconStampData = null;
                    } else {
                        str12 = jSONObject3.optString("msg");
                        str14 = jSONObject3.optString("pre_msg");
                        String optString = jSONObject3.optString("color_msg");
                        String optString2 = jSONObject3.optString("tid");
                        String optString3 = jSONObject3.optString("pid");
                        str8 = jSONObject3.optString("video_id");
                        str9 = jSONObject3.optString("invitees_number");
                        CustomDialogData a2 = ni9.a(jSONObject3);
                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("twzhibo_info");
                        if (optJSONObject3 != null) {
                            i6 = optJSONObject3.optInt("is_copytwzhibo", 0);
                        } else {
                            i6 = 0;
                        }
                        JSONObject optJSONObject4 = jSONObject3.optJSONObject("exp");
                        if (optJSONObject4 != null) {
                            str13 = optJSONObject4.optString("pre_msg");
                            str16 = optJSONObject4.optString("color_msg");
                            str17 = optJSONObject4.optString("question_msg");
                            str15 = optJSONObject4.optString("question_exp");
                        } else {
                            str15 = null;
                            str16 = null;
                            str17 = null;
                            str13 = null;
                        }
                        contriInfo.parseJson(jSONObject3.optJSONObject("contri_info"));
                        JSONObject optJSONObject5 = jSONObject3.optJSONObject("star_info");
                        String str19 = str15;
                        if (optJSONObject5 != null) {
                            videoEasterEggData3 = new VideoEasterEggData();
                            videoEasterEggData3.parseJson(optJSONObject5);
                        } else {
                            videoEasterEggData3 = null;
                        }
                        JSONObject optJSONObject6 = jSONObject3.optJSONObject("advertisement");
                        VideoEasterEggData videoEasterEggData4 = videoEasterEggData3;
                        if (optJSONObject6 != null) {
                            adverSegmentData2 = new AdverSegmentData();
                            adverSegmentData2.parseJSONObject(optJSONObject6);
                        } else {
                            adverSegmentData2 = null;
                        }
                        JSONObject optJSONObject7 = jSONObject3.optJSONObject("icon_stamp_info");
                        AdverSegmentData adverSegmentData3 = adverSegmentData2;
                        if (optJSONObject7 != null) {
                            iconStampData2 = new IconStampData();
                            iconStampData2.parseJson(optJSONObject7);
                        } else {
                            iconStampData2 = null;
                        }
                        if (jSONObject3.has("toast")) {
                            iconStampData3 = iconStampData2;
                            BdToastData bdToastData = new BdToastData();
                            bdToastData.parserJson(jSONObject3.optJSONObject("toast"));
                            cmaVar.T(bdToastData);
                        } else {
                            iconStampData3 = iconStampData2;
                        }
                        str11 = str16;
                        str4 = optString;
                        str7 = optString2;
                        customDialogData = a2;
                        videoEasterEggData = videoEasterEggData4;
                        adverSegmentData = adverSegmentData3;
                        iconStampData = iconStampData3;
                        obj = "pid";
                        obj2 = "tid";
                        str5 = str17;
                        str10 = optString3;
                        str6 = str19;
                    }
                    if (StringUtils.isNull(str12)) {
                        videoEasterEggData2 = videoEasterEggData;
                        str12 = TbadkCoreApplication.getInst().getString(R.string.send_success);
                    } else {
                        videoEasterEggData2 = videoEasterEggData;
                    }
                    cmaVar.G(str12);
                    cmaVar.N(str14);
                    cmaVar.E(str4);
                    cmaVar.P(str5);
                    cmaVar.O(str6);
                    cmaVar.S(str7);
                    cmaVar.M(str10);
                    cmaVar.L(i6);
                    cmaVar.I(str13);
                    cmaVar.H(str11);
                    cmaVar.C(customDialogData);
                    cmaVar.V(str8);
                    cmaVar.K(str9);
                    cmaVar.F(contriInfo);
                    cmaVar.U(videoEasterEggData2);
                    cmaVar.D(adverSegmentData);
                    cmaVar.J(iconStampData);
                }
                n05.b("write", "result*" + dmaVar.e());
                n05.b("write", "code*" + cmaVar.f() + " " + cmaVar.g());
                n05.e("write");
                yla.a("doInBackground end");
                yla.a("发帖：任务后台执行 开始 doInBackground 完全结束");
                yla.a("onPostExecute start");
                yla.a("发帖： onPostExecute");
                this.g.a = null;
                if (cmaVar.f() != 0) {
                    Logger.addLog("write", 0L, 0, "write_result", cmaVar.f(), cmaVar.g(), obj2, cmaVar.s(), obj, cmaVar.m());
                }
                if (!this.d) {
                    if (this.g.b != null) {
                        z = this.g.b.isReplyResultNotificationH5;
                    } else {
                        z = false;
                    }
                    if (cmaVar.w()) {
                        yla.a("onPostExecute error");
                        c(cmaVar);
                        sd9 sd9Var = this.f;
                        if (sd9Var != null) {
                            sd9Var.h(cmaVar.a, cmaVar.g());
                        }
                    } else {
                        if (this.g.b != null) {
                            this.g.b.getType();
                            z2 = this.g.b.isNotificationH5();
                            z3 = this.g.b.isNotFakePost();
                        } else {
                            z2 = false;
                            z3 = false;
                        }
                        yla.a("onPostExecute success");
                        if (this.g.c != null) {
                            if (!StringUtils.isNull(cmaVar.n()) && !StringUtils.isNull(cmaVar.d())) {
                                i5 = cmaVar.n();
                                h = cmaVar.d();
                            } else if (StringUtils.isNull(cmaVar.h()) && StringUtils.isNull(cmaVar.i())) {
                                str2 = null;
                                str3 = null;
                                postWriteCallBackData = new PostWriteCallBackData(cmaVar.f(), cmaVar.g(), str2, str3, cmaVar.p(), cmaVar.o());
                                postWriteCallBackData.setThreadId(cmaVar.s());
                                postWriteCallBackData.setPostId(cmaVar.m());
                                postWriteCallBackData.setIsCopyTWZhibo(cmaVar.l());
                                postWriteCallBackData.setErrorString(cmaVar.g());
                                postWriteCallBackData.setActivityDialog(cmaVar.a());
                                postWriteCallBackData.setVideoid(cmaVar.v());
                                postWriteCallBackData.setInviteesNumber(cmaVar.k());
                                postWriteCallBackData.setContriInfo(cmaVar.e());
                                if (this.g.b != null) {
                                    postWriteCallBackData.setGeneralTabId(this.g.b.getTabId());
                                }
                                postWriteCallBackData.setVideoEasterEggData(cmaVar.u());
                                postWriteCallBackData.setmAdverSegmentData(cmaVar.b());
                                postWriteCallBackData.setIconStampData(cmaVar.j());
                                postWriteCallBackData.setToast(cmaVar.t());
                                ee5 ee5Var = new ee5();
                                ee5Var.f(this.c);
                                if (this.g.b == null && WriteMsgHolder.getCurrentWriteActivityFromTag() != null && !z3) {
                                    WriteMsgHolder.setLastForumId(this.g.b.getForumId());
                                    WriteMsgHolder.setLastForumName(this.g.b.getForumName());
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001383, postWriteCallBackData);
                                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001383, WriteMsgHolder.getCurrentWriteActivityFromTag()));
                                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                                    WriteMsgHolder.setFromPersonCenter(false);
                                } else if (this.g.b == null && this.g.f) {
                                    if (this.g.b.getVideoInfo() != null) {
                                        postWriteCallBackData.writeDataForVideo = this.g.b;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921650, postWriteCallBackData));
                                } else if (this.g.b != null && this.g.g) {
                                    WriteMsgHolder.setLastForumId(this.g.b.getForumId());
                                    WriteMsgHolder.setLastForumName(this.g.b.getForumName());
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                                }
                                activityDialog = postWriteCallBackData.getActivityDialog();
                                if (activityDialog != null && cmaVar.j() == null) {
                                    if (this.g.b != null) {
                                        int type = this.g.b.getType();
                                        if (type != 1 && type != 2) {
                                            if (type != 9) {
                                                switch (type) {
                                                }
                                            }
                                            activityDialog.type = 2;
                                        } else {
                                            activityDialog.type = 1;
                                        }
                                    }
                                    SafeHandler.getInst().postDelayed(new c(this, activityDialog), 1000L);
                                }
                                this.g.c.callback(true, postWriteCallBackData, ee5Var, this.g.b, cmaVar.c());
                            } else {
                                i5 = cmaVar.i();
                                h = cmaVar.h();
                            }
                            str2 = i5;
                            str3 = h;
                            postWriteCallBackData = new PostWriteCallBackData(cmaVar.f(), cmaVar.g(), str2, str3, cmaVar.p(), cmaVar.o());
                            postWriteCallBackData.setThreadId(cmaVar.s());
                            postWriteCallBackData.setPostId(cmaVar.m());
                            postWriteCallBackData.setIsCopyTWZhibo(cmaVar.l());
                            postWriteCallBackData.setErrorString(cmaVar.g());
                            postWriteCallBackData.setActivityDialog(cmaVar.a());
                            postWriteCallBackData.setVideoid(cmaVar.v());
                            postWriteCallBackData.setInviteesNumber(cmaVar.k());
                            postWriteCallBackData.setContriInfo(cmaVar.e());
                            if (this.g.b != null) {
                            }
                            postWriteCallBackData.setVideoEasterEggData(cmaVar.u());
                            postWriteCallBackData.setmAdverSegmentData(cmaVar.b());
                            postWriteCallBackData.setIconStampData(cmaVar.j());
                            postWriteCallBackData.setToast(cmaVar.t());
                            ee5 ee5Var2 = new ee5();
                            ee5Var2.f(this.c);
                            if (this.g.b == null) {
                            }
                            if (this.g.b == null) {
                            }
                            if (this.g.b != null) {
                                WriteMsgHolder.setLastForumId(this.g.b.getForumId());
                                WriteMsgHolder.setLastForumName(this.g.b.getForumName());
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921655, postWriteCallBackData));
                            }
                            activityDialog = postWriteCallBackData.getActivityDialog();
                            if (activityDialog != null) {
                                if (this.g.b != null) {
                                }
                                SafeHandler.getInst().postDelayed(new c(this, activityDialog), 1000L);
                            }
                            this.g.c.callback(true, postWriteCallBackData, ee5Var2, this.g.b, cmaVar.c());
                        }
                        if (this.g.b != null && !this.g.b.isWork()) {
                            MessageManager messageManager = MessageManager.getInstance();
                            if (cmaVar.j() == null) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            messageManager.dispatchResponsedMessage(new CustomResponsedMessage(2001375, Boolean.valueOf(z4)));
                        }
                        sd9 sd9Var2 = this.f;
                        if (sd9Var2 != null) {
                            sd9Var2.c();
                        }
                        if (z2) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921786, null));
                        }
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921805, 1));
                        }
                    }
                    yla.a("发帖： onPostExecute 完全结束");
                    return;
                }
                yla.a("发帖： onPostExecute isCanceled");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z45 a;
        public final /* synthetic */ NewWriteModel b;

        public a(NewWriteModel newWriteModel, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, z45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newWriteModel;
            this.a = z45Var;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                this.a.dismiss();
                this.b.b0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z45 a;
        public final /* synthetic */ NewWriteModel b;

        public b(NewWriteModel newWriteModel, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel, z45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newWriteModel;
            this.a = z45Var;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                this.a.dismiss();
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 16);
                if (this.b.b != null) {
                    i = this.b.b.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.b.cancel();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends gla.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewWriteModel a;

        public c(NewWriteModel newWriteModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newWriteModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newWriteModel;
        }

        @Override // com.baidu.tieba.gla.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b == null || TextUtils.isEmpty(str)) {
                    if (this.a.c != null) {
                        this.a.c.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(str);
                this.a.n0();
            }
        }

        @Override // com.baidu.tieba.gla.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a.b == null || TextUtils.isEmpty(str)) {
                    if (this.a.c != null) {
                        this.a.c.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(str);
                this.a.n0();
            }
        }

        @Override // com.baidu.tieba.gla.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.b != null) {
                    this.a.b.setAuthSid(null);
                }
                if (this.a.c != null) {
                    this.a.c.callback(false, null, null, this.a.b, null);
                }
            }
        }

        @Override // com.baidu.tieba.gla.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.b == null) {
                    if (this.a.c != null) {
                        this.a.c.callback(false, null, null, this.a.b, null);
                        return;
                    }
                    return;
                }
                this.a.a = null;
                this.a.b.setAuthSid(null);
                this.a.n0();
            }
        }
    }

    public NewWriteModel() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.i = new c(this);
        this.e = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewWriteModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.i = new c(this);
        this.e = baseActivity.getPageContext();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewWriteModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = false;
        this.i = new c(this);
        this.e = tbPageContext;
    }

    public final void d0(cma cmaVar) {
        BdPageContext<?> bdPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, cmaVar) == null) && (bdPageContext = this.e) != null && cmaVar != null && !(this.c instanceof xla)) {
            psa.e(bdPageContext.getPageActivity(), cmaVar.g());
            cmaVar.G(null);
        }
    }

    public final void f0(cma cmaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cmaVar) == null) {
            g0(cmaVar, null, null, this.b);
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.g = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.d = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
        }
    }

    public void k0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.c = dVar;
        }
    }

    public void l0(@Nullable BdPageContext<?> bdPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bdPageContext) == null) {
            if (bdPageContext != null) {
                this.e = bdPageContext;
                this.unique_id = bdPageContext.getUniqueId();
                return;
            }
            this.e = null;
            this.unique_id = null;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, writeData) == null) {
            this.b = writeData;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.b;
            if (writeData == null) {
                return true;
            }
            if (writeData.getWriteImagesInfo() != null) {
                i = this.b.getWriteImagesInfo().size() + 0;
            } else {
                i = 0;
            }
            if (i <= MAX_IMG_NUM) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public WriteData c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (WriteData) invokeV.objValue;
    }

    public final void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PostThreadTask postThreadTask = this.a;
            if (postThreadTask != null && !postThreadTask.isCancelled()) {
                this.a.cancel();
                return;
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.callback(false, null, null, this.b, null);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PostThreadTask postThreadTask = this.a;
            if (postThreadTask != null && !postThreadTask.isCancelled()) {
                this.a.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.b == null) {
                return false;
            }
            yla.a("发帖：开始上传");
            this.b.startPublish();
            PublishProgressData.valueOf(this.b, 0).send(true);
            b0();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b0() {
        int i;
        int i2;
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 14);
            WriteData writeData2 = this.b;
            if (writeData2 != null) {
                i = writeData2.getType();
            } else {
                i = -1;
            }
            StatisticItem param2 = param.param("obj_type", i);
            WriteData writeData3 = this.b;
            int i3 = 1;
            if (writeData3 != null && writeData3.isNewWritePage()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            StatisticItem param3 = param2.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            WriteData writeData4 = this.b;
            if (writeData4 != null && writeData4.isWriteTest()) {
                i3 = 2;
            }
            TiebaStatic.log(param3.param(TiebaStatic.Params.OBJ_TO, i3).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            n05.d("write");
            n05.b("write", "start");
            if (this.a == null) {
                if (WriteMsgHolder.getCurrentWriteActivityFromTag() != null && (writeData = this.b) != null && !writeData.isNotFakePost()) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001378, c0());
                    customResponsedMessage.setOrginalMessage(new CustomMessage(2001378, WriteMsgHolder.getCurrentWriteActivityFromTag()));
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.h == null) {
                    this.h = new eka(this.e);
                }
                this.a = new PostThreadTask(this);
                yla.a("dealPost()");
                wla.l(this.b);
                this.a.execute(new Integer[0]);
            }
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.b == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return false;
            }
            if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && this.b.getWriteImagesInfo() != null && this.b.getWriteImagesInfo().size() != 0 && this.b.getWriteImagesInfo().isOriginalImg() && !SharedPrefHelper.getInstance().getBoolean("original_img_up_tip", false)) {
                SharedPrefHelper.getInstance().putBoolean("original_img_up_tip", true);
                StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 15);
                WriteData writeData = this.b;
                if (writeData != null) {
                    i = writeData.getType();
                } else {
                    i = -1;
                }
                TiebaStatic.log(param.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                BdPageContext<?> bdPageContext = this.e;
                if (bdPageContext == null) {
                    b0();
                    return true;
                }
                z45 z45Var = new z45(bdPageContext.getPageActivity());
                z45Var.setMessageId(R.string.original_img_up_no_wifi_tip);
                z45Var.setPositiveButton(R.string.alert_yes_button, new a(this, z45Var));
                z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new b(this, z45Var));
                z45Var.create(this.e);
                z45Var.show();
            } else {
                b0();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e0(cma cmaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cmaVar) == null) && this.e != null && cmaVar != null && cmaVar.c() != null && cmaVar.c().mFrsForbidenDialogInfo != null) {
            AntiHelper.p(this.e.getPageActivity(), cmaVar.c().mFrsForbidenDialogInfo.ahead_url);
        }
    }

    public final void g0(cma cmaVar, AccessState accessState, ee5 ee5Var, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cmaVar, accessState, ee5Var, writeData) == null) && cmaVar != null && this.c != null) {
            PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(cmaVar.f(), cmaVar.g(), null, null);
            postWriteCallBackData.setAccessState(accessState);
            postWriteCallBackData.setSensitiveWords(cmaVar.r());
            postWriteCallBackData.setReplyPrivacyTip(cmaVar.q());
            this.c.callback(false, postWriteCallBackData, ee5Var, writeData, cmaVar.c());
        }
    }
}
