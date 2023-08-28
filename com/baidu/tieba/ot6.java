package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.nt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ot6 implements nt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;
    public b b;
    public nt6.a c;
    public TbPageContext d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<List<String>, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> a;
        public zeb b;
        public final /* synthetic */ ot6 c;

        /* loaded from: classes7.dex */
        public class a implements zeb {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.zeb
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.baidu.tieba.zeb
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                }
            }

            @Override // com.baidu.tieba.zeb
            public void c(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
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

        public b(ot6 ot6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ot6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ot6Var;
            this.b = new a(this);
        }

        public /* synthetic */ b(ot6 ot6Var, a aVar) {
            this(ot6Var);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x010d, code lost:
            if (com.baidu.tieba.vgb.h(r6, r7[0], r1, r5.b) != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x011d A[LOOP:0: B:52:0x0117->B:54:0x011d, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x012f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0130 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String b(StringBuilder sb, List<String>[] listArr) {
            InterceptResult invokeLL;
            List<String> list;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sb, listArr)) == null) {
                if (listArr[0] != null && listArr[0].size() != 0) {
                    String str = mpa.f + "rec_tmp_" + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
                    if (!StringUtils.isNull(str)) {
                        File file = new File(str);
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                    }
                    boolean z2 = true;
                    try {
                        if (listArr[0].size() == 1) {
                            try {
                                z = woa.b(listArr[0].get(0), str, this.b);
                            } catch (IOException e) {
                                e.printStackTrace();
                                if (sb != null) {
                                    sb.append(e.toString());
                                }
                                if (FileHelper.CheckFile(listArr[0].get(0))) {
                                    list = listArr[0];
                                }
                                z = false;
                                if (!z) {
                                }
                                while (r6.hasNext()) {
                                }
                                if (z2) {
                                }
                            } catch (Exception e2) {
                                if (sb != null) {
                                    sb.append(e2.toString());
                                }
                                if (FileHelper.CheckFile(listArr[0].get(0))) {
                                    list = listArr[0];
                                }
                                z = false;
                                if (!z) {
                                }
                                while (r6.hasNext()) {
                                }
                                if (z2) {
                                }
                            }
                            if (!z && FileHelper.CheckFile(listArr[0].get(0))) {
                                list = listArr[0];
                                str = list.get(0);
                                z = true;
                            }
                            if (!z) {
                                boolean isExists = FileUtils.isExists(listArr[0].get(0));
                                if (sb != null) {
                                    sb.append(" 源文件存在 ： ");
                                    sb.append(isExists);
                                    sb.append(" , 拍摄视频页不需要拼接时复制失败 from ");
                                    sb.append(listArr[0].get(0));
                                    sb.append("to ");
                                    sb.append(str);
                                }
                                z2 = false;
                            }
                            for (String str2 : listArr[0]) {
                                this.c.a.add(str2);
                            }
                            if (z2) {
                                return str;
                            }
                            return "";
                        }
                    } catch (Throwable th) {
                        if (FileHelper.CheckFile(listArr[0].get(0))) {
                            listArr[0].get(0);
                        }
                        throw th;
                    }
                } else if (sb != null) {
                    sb.append("拍摄视频页需要拼接文件列表为空");
                    return null;
                } else {
                    return null;
                }
            } else {
                return (String) invokeLL.objValue;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                cancel(true);
                if (this.c.c != null) {
                    this.c.c.a();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (this.c.c != null) {
                    this.c.c.b();
                }
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(List<String>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, listArr)) == null) {
                if (ListUtils.isEmpty(listArr[0])) {
                    return "";
                }
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.clear();
                this.a.addAll(listArr[0]);
                Iterator<String> it = this.a.iterator();
                while (it.hasNext()) {
                    if (yeb.a(it.next()) <= 0) {
                        return "";
                    }
                }
                return b(new StringBuilder(), listArr);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                super.onPostExecute((b) str);
                zeb zebVar = this.b;
                if (zebVar != null) {
                    zebVar.a();
                }
                if (this.c.c != null) {
                    this.c.c.c(str);
                }
            }
        }
    }

    public ot6(TbPageContext tbPageContext, nt6.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.d = tbPageContext;
        this.c = aVar;
    }

    @Override // com.baidu.tieba.nt6
    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = this.b) != null) {
            bVar.cancel();
        }
    }

    @Override // com.baidu.tieba.nt6
    public boolean b(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (FileHelper.getAvailableSize() < 52428800) {
                BdToast.makeText(this.d.getPageActivity(), this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c2c)).show();
                return false;
            }
            b bVar = this.b;
            if (bVar != null) {
                bVar.cancel();
            }
            if (e(list)) {
                b bVar2 = new b(this, null);
                this.b = bVar2;
                bVar2.execute(list);
            } else {
                BdToast.makeText(this.d.getPageActivity(), this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d)).show();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean e(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            float f = 0.0f;
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    f += lgb.f(str);
                }
            }
            if (f < 3000.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
