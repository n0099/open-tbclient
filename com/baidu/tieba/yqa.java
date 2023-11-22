package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class yqa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface h {
        void d(WriteData writeData);
    }

    /* loaded from: classes9.dex */
    public interface i {
        void a(String str);
    }

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ String b;

        public a(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                WriteData writeData = this.a;
                if (writeData != null && writeData.hasContentToSave()) {
                    m.e(yqa.g(this.b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                m.remove(yqa.g(this.b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public b(WriteData writeData, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = z;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                WriteData writeData3 = this.a;
                if (writeData3 != null && writeData3.hasContentToSave() && !this.b) {
                    String draftString = this.a.toDraftString();
                    m.e(yqa.c(this.c), draftString, 604800000L);
                    if (!UbsABTestHelper.isNewWrite() && !"0".equals(this.c) && (writeData2 = this.a) != null && writeData2.getStatisticFrom() == 1) {
                        m.e(yqa.c("0"), draftString, 604800000L);
                        return null;
                    }
                    return null;
                }
                m.remove(yqa.c(this.c));
                if (!UbsABTestHelper.isNewWrite() && !"0".equals(this.c) && (writeData = this.a) != null && writeData.getStatisticFrom() == 1) {
                    m.remove(yqa.c("0"));
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public c(WriteData writeData, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = z;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                if (m == null) {
                    return null;
                }
                WriteData writeData2 = this.a;
                if (writeData2 != null && writeData2.hasContentToSave() && !this.b) {
                    String draftString = this.a.toDraftString();
                    m.e(yqa.h(this.c), draftString, 604800000L);
                    if (!UbsABTestHelper.isNewWrite() && !"0".equals(this.c) && this.a.getStatisticFrom() == 1) {
                        m.e(yqa.h("0"), draftString, 604800000L);
                    }
                } else {
                    m.remove(yqa.h(this.c));
                    if (!UbsABTestHelper.isNewWrite() && !"0".equals(this.c) && (writeData = this.a) != null && writeData.getStatisticFrom() == 1) {
                        m.remove(yqa.h("0"));
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                if (!TextUtils.isEmpty(this.a)) {
                    m.e(yqa.e(this.b), this.a, 604800000L);
                    return null;
                }
                m.remove(yqa.e(this.b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ String b;

        public e(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                WriteData writeData = this.a;
                if (writeData != null && writeData.hasContentToSave()) {
                    m.e(yqa.i(this.b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                m.remove(yqa.i(this.b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                if (!TextUtils.isEmpty(this.a)) {
                    m.e(yqa.f(), this.a, 604800000L);
                    return null;
                }
                m.remove(yqa.f());
                FileHelper.deleteFileOrDir(new File(k1b.e));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;
        public final /* synthetic */ String b;

        public g(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                yz4.l();
                ca<String> m = yz4.m("tb.pb_editor");
                WriteData writeData = this.a;
                if (writeData != null && writeData.hasContentToSave()) {
                    m.e(yqa.a(this.b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                m.remove(yqa.a(this.b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class j extends BdAsyncTask<String, String, WriteData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h a;
        public final String b;

        public j(String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setPriority(3);
            this.a = hVar;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public WriteData doInBackground(String... strArr) {
            String str;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    yz4.l();
                    str = yz4.m("tb.pb_editor").get(this.b);
                } catch (Exception unused) {
                    str = null;
                }
                return WriteData.fromDraftString(str);
            }
            return (WriteData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
                super.onPostExecute(writeData);
                h hVar = this.a;
                if (hVar != null) {
                    hVar.d(writeData);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class k extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final i a;
        public final String b;

        public k(String str, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setPriority(3);
            this.a = iVar;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    yz4.l();
                    return yz4.m("tb.pb_editor").get(this.b);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((k) str);
                if (this.a != null && !TextUtils.isEmpty(str)) {
                    this.a.a(str);
                }
            }
        }
    }

    public static void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, str, str2) != null) || qd.isEmpty(str)) {
            return;
        }
        new d(str2, str).execute(new Void[0]);
    }

    public static void C(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, str, writeData) != null) || qd.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void E(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, writeData) != null) || qd.isEmpty(str)) {
            return;
        }
        new e(writeData, str).execute(new Void[0]);
    }

    public static void l(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, hVar) == null) {
            if (qd.isEmpty(str)) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(a(str), hVar).execute(new String[0]);
        }
    }

    public static void m(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, hVar) == null) {
            if (str == null) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(b(str), hVar).execute(new String[0]);
        }
    }

    public static void n(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, hVar) == null) {
            if (qd.isEmpty(str)) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(c(str), hVar).execute(new String[0]);
        }
    }

    public static void p(String str, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, iVar) == null) {
            if (qd.isEmpty(str)) {
                if (iVar != null) {
                    iVar.a(null);
                    return;
                }
                return;
            }
            new k(e(str), iVar).execute(new String[0]);
        }
    }

    public static void r(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, str, hVar) == null) {
            if (qd.isEmpty(str)) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(g(str), hVar).execute(new String[0]);
        }
    }

    public static void s(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, str, hVar) == null) {
            if (qd.isEmpty(str)) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(h(str), hVar).execute(new String[0]);
        }
    }

    public static void t(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, str, hVar) == null) {
            if (qd.isEmpty(str)) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(i(str), hVar).execute(new String[0]);
        }
    }

    public static void u(String str, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, str, hVar) == null) {
            if (qd.isEmpty(str)) {
                if (hVar != null) {
                    hVar.d(null);
                    return;
                }
                return;
            }
            new j(j(str), hVar).execute(new String[0]);
        }
    }

    public static void v(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65564, null, str, writeData) != null) || qd.isEmpty(str)) {
            return;
        }
        new g(writeData, str).execute(new Void[0]);
    }

    public static void x(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, str, writeData) == null) {
            y(str, writeData, false);
        }
    }

    public static void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            new f(str).execute(new Void[0]);
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@article@fid" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@localchannelhi" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@questionthread@fid" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void o(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, hVar) == null) {
            new j(d(), hVar).execute(new String[0]);
        }
    }

    public static void q(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, iVar) == null) {
            new k(f(), iVar).execute(new String[0]);
        }
    }

    public static void D(String str, WriteData writeData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65539, null, str, writeData, z) != null) || qd.isEmpty(str)) {
            return;
        }
        new c(writeData, z, str).execute(new Void[0]);
    }

    public static void y(String str, WriteData writeData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65567, null, str, writeData, z) != null) || qd.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void F(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, str, writeData) != null) || qd.isEmpty(str)) {
            return;
        }
        yz4.l();
        ca<String> m = yz4.m("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            m.i(j(str), writeData.toDraftString(), 604800000L);
        } else {
            m.d(j(str));
        }
    }

    public static String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String f2 = f();
            yz4.l();
            return yz4.m("tb.pb_editor").get(f2);
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@localchannel";
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@newvideo";
        }
        return (String) invokeV.objValue;
    }

    public static void k(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65553, null, writeData) != null) || writeData == null) {
            return;
        }
        if (writeData.isAddThread()) {
            if (writeData.isLocalChannelDynamic()) {
                z(null);
            } else if (writeData.isQuestionThread()) {
                if (UbsABTestHelper.isNewWrite() && "main_tab".equals(writeData.getFrom())) {
                    D("0", writeData, true);
                }
                D(writeData.getForumId(), writeData, true);
            } else if (writeData.isEvaluate()) {
                w(writeData.getItem_id(), null);
            } else if (TextUtils.isEmpty(writeData.getTopicId())) {
                if (UbsABTestHelper.isNewWrite()) {
                    if (writeData.getType() == 11) {
                        if ("main_tab".equals(writeData.getFrom())) {
                            v("0", null);
                        }
                        v(writeData.getForumId(), null);
                        return;
                    }
                    if ("main_tab".equals(writeData.getFrom())) {
                        y("0", writeData, true);
                    }
                    y(writeData.getForumId(), writeData, true);
                    return;
                }
                y(writeData.getForumId(), writeData, true);
            } else {
                F(writeData.getTopicId(), null);
            }
        } else if (writeData.getType() == 1) {
            C(writeData.getThreadId(), null);
        }
    }

    public static void w(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65565, null, str, writeData) != null) || str == null) {
            return;
        }
        yz4.l();
        ca<String> m = yz4.m("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            m.e(b(str), writeData.toDraftString(), 604800000L);
            m.e(b(""), writeData.toDraftString(), 604800000L);
            return;
        }
        m.remove(b(str));
        m.remove(b(""));
    }

    public static void z(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, writeData) == null) {
            yz4.l();
            ca<String> m = yz4.m("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                m.e(d(), writeData.toDraftString(), 604800000L);
            } else {
                m.remove(d());
            }
        }
    }
}
