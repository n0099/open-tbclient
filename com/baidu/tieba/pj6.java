package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class pj6 extends r75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> e;
    public Set<String> f;

    @Override // com.baidu.tieba.r75
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户收藏表情" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r75
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.r75
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r75
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public pj6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ArrayList<>();
        this.f = new HashSet();
        w();
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            t(2);
            q(4);
            jn jnVar = new jn(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
            super.s(jnVar);
            super.r(jnVar);
            x();
        }
    }

    @Override // com.baidu.tieba.r75
    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= this.e.size()) {
                return null;
            }
            return this.e.get(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.r75
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.f.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.r75
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<String> arrayList = this.e;
            if (arrayList != null && arrayList.size() != 0) {
                return this.e.size();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.r75
    public jn e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.d();
        }
        return (jn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r75
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ca5.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r75
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return EmotionGroupType.USER_COLLECT;
        }
        return (EmotionGroupType) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0052 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x006e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.InputStream] */
    @Override // com.baidu.tieba.r75
    public jn n(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            File u = u(str);
            if (u == null) {
                return null;
            }
            ?? file = new File(u.getAbsolutePath().replace("_s.jpg", "_b.gif"));
            ?? exists = file.exists();
            try {
                if (exists == 0) {
                    return null;
                }
                try {
                    exists = new FileInputStream((File) file);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = exists.read(bArr, 0, 1024);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    jn jnVar = new jn(NSGif.f(byteArray, 0, byteArray.length));
                                    xg.c(exists);
                                    xg.d(byteArrayOutputStream);
                                    return jnVar;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            xg.c(exists);
                            xg.d(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th) {
                        file = 0;
                        th = th;
                        xg.c(exists);
                        xg.d(file);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    exists = 0;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    file = 0;
                    th = th2;
                    exists = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            return (jn) invokeL.objValue;
        }
    }

    public File u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
            String replace2 = replace.substring(0, replace.indexOf(",")).replace("collect_", "");
            if (replace2.contains("_")) {
                replace2 = replace2.substring(replace2.indexOf("_") + 1);
            }
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + ca5.d() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    @Override // com.baidu.tieba.r75
    public jn o(String str) {
        InterceptResult invokeL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (ca5.f.equals(str)) {
                return new jn(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
            }
            File u = u(str);
            if (u != null) {
                bitmap = FileHelper.getImage(u.getAbsolutePath());
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                return null;
            }
            return new jn(bitmap, false, str);
        }
        return (jn) invokeL.objValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (this.e != null && !TextUtils.isEmpty(str)) {
                Iterator<String> it = this.e.iterator();
                while (it.hasNext()) {
                    if (it.next().contains(str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            List<CollectEmotionData> q = gj6.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.e.clear();
            this.f.clear();
            for (CollectEmotionData collectEmotionData : q) {
                this.e.add(collectEmotionData.getSharpText());
                this.f.add(collectEmotionData.getSharpText());
            }
        }
    }
}
