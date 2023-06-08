package com.baidu.tieba;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.ki5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class qx6 {
    public static /* synthetic */ Interceptable $ic;
    public static qx6 c;
    public static BdAsyncTaskParallel d;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ni5> a;
    public final List<ki5> b;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<ni5> a;
        public final ki5.a b;
        public final /* synthetic */ qx6 c;

        /* renamed from: com.baidu.tieba.qx6$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0443a implements ki5.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0443a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.ki5.a
            public void a(ni5 ni5Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ni5Var) == null) {
                    this.a.a.add(ni5Var);
                }
            }
        }

        public a(qx6 qx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qx6Var;
            this.a = new ArrayList<>();
            this.b = new C0443a(this);
            setPriority(4);
            setParallel(qx6.d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                this.c.a = this.a;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                for (int i = 0; i < this.c.b.size(); i++) {
                    ((ki5) this.c.b.get(i)).b(this.b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948107258, "Lcom/baidu/tieba/qx6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948107258, "Lcom/baidu/tieba/qx6;");
                return;
            }
        }
        c = new qx6();
        d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.isEmpty()) {
            try {
                Class.forName("com.baidu.tieba.faceshop.FaceshopStatic");
            } catch (Throwable th) {
                BdLog.e(th);
            }
            try {
                Class.forName("com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public qx6() {
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
        this.a = new ArrayList<>();
        this.b = new ArrayList();
    }

    public static qx6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return c;
        }
        return (qx6) invokeV.objValue;
    }

    public ArrayList<ni5> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e();
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            e();
            Iterator<ni5> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().m(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (p(str)) {
                return false;
            }
            return str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX);
        }
        return invokeL.booleanValue;
    }

    public boolean p(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!yl5.f.equals(str) && !"#(meme,diysetting)".equals(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (yl5.f.equals(str) || str.startsWith(yl5.g)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if ("#(meme,diysetting)".equals(str) || str.startsWith("#(meme,diy_")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u(ki5 ki5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ki5Var) == null) {
            synchronized (this.b) {
                if (!this.b.contains(ki5Var)) {
                    this.b.add(ki5Var);
                    Collections.sort(this.b);
                }
            }
        }
    }

    public Bitmap t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
            return FileHelper.getImage(".emotions/" + str, str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public void d(String str, gn gnVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048576, this, str, gnVar, z) != null) || gnVar == null) {
            return;
        }
        if (z) {
            TbImageMemoryCache.u().l(f(str, z), gnVar);
            return;
        }
        TbImageMemoryCache.u().l(str, gnVar);
    }

    public String f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (px6.e().g()) {
                return str;
            }
            e();
            if (!z) {
                return str;
            }
            if (px6.e().f(str)) {
                return str;
            }
            return "#@" + str;
        }
        return (String) invokeLZ.objValue;
    }

    public String g(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (str == null) {
                return null;
            }
            String str2 = "d_";
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                if (p(str)) {
                    return null;
                }
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("collect_")) {
                    if (substring.contains("_")) {
                        substring = substring.substring(substring.lastIndexOf("_") + 1);
                    }
                    String str3 = eo5.b.c() + "/" + yl5.d() + "/" + substring;
                    if (z) {
                        return str3 + "_b.gif";
                    }
                    return str3 + "_s.jpg";
                } else if (substring.contains("diy_")) {
                    if (substring.contains("_")) {
                        substring = substring.substring(substring.lastIndexOf("_") + 1);
                    }
                    String str4 = eo5.b.c() + "/" + yl5.c() + "/" + substring;
                    if (z) {
                        return str4 + "_b.gif";
                    }
                    return str4 + "_s.jpg";
                } else {
                    long hashCode = str.hashCode();
                    if (hashCode < 0) {
                        hashCode *= -1;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (!z) {
                        str2 = "s_";
                    }
                    sb.append(str2);
                    sb.append(hashCode);
                    String sb2 = sb.toString();
                    if (z) {
                        return sb2 + ".gif";
                    }
                    return sb2 + ".jpg";
                }
            }
            long hashCode2 = str.hashCode();
            if (hashCode2 < 0) {
                hashCode2 *= -1;
            }
            StringBuilder sb3 = new StringBuilder();
            if (!z) {
                str2 = "s_";
            }
            sb3.append(str2);
            sb3.append(hashCode2);
            return sb3.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_")) {
                    return substring.substring(0, substring.indexOf("_"));
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public String j(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_")) {
                    return substring.substring(substring.lastIndexOf("_") + 1);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str == null || !l(str)) {
                return false;
            }
            e();
            Iterator<ni5> it = this.a.iterator();
            while (it.hasNext()) {
                ni5 next = it.next();
                if (next.m(str)) {
                    if (next.h() != EmotionGroupType.LOCAL) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (!p(str) && str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_") && !substring.contains("collect_") && !substring.contains("diy_")) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public gn s(String str, String str2) {
        InterceptResult invokeLL;
        Bitmap t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            gn z = TbImageMemoryCache.u().z(str2);
            if (z != null) {
                return z;
            }
            e();
            Iterator<ni5> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ni5 next = it.next();
                if (next.m(str2)) {
                    z = next.o(str2);
                    break;
                }
            }
            if (z == null && str != null && (t = t(str, g(str2, false))) != null) {
                z = new gn(t, false, str2);
            }
            d(str2, z, false);
            return z;
        }
        return (gn) invokeLL.objValue;
    }
}
