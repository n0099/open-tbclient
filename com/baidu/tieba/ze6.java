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
/* loaded from: classes6.dex */
public class ze6 extends w65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> e;
    public Set<String> f;

    @Override // com.baidu.tieba.w65
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户收藏表情" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w65
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.w65
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w65
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ze6() {
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
            hn hnVar = new hn(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
            super.s(hnVar);
            super.r(hnVar);
            x();
        }
    }

    @Override // com.baidu.tieba.w65
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

    @Override // com.baidu.tieba.w65
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.f.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.w65
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

    @Override // com.baidu.tieba.w65
    public hn e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.d();
        }
        return (hn) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w65
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return f95.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w65
    public EmotionGroupType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return EmotionGroupType.USER_COLLECT;
        }
        return (EmotionGroupType) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w65
    public hn n(String str) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            File file = new File(u(str).getAbsolutePath().replace("_s.jpg", "_b.gif"));
            if (!file.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                e = e;
                fileInputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
                fileInputStream = null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(1024);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                hn hnVar = new hn(NSGif.f(byteArray, 0, byteArray.length));
                                vg.c(fileInputStream);
                                vg.d(byteArrayOutputStream);
                                return hnVar;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        vg.c(fileInputStream);
                        vg.d(byteArrayOutputStream);
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    vg.c(fileInputStream);
                    vg.d(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                vg.c(fileInputStream);
                vg.d(byteArrayOutputStream);
                throw th;
            }
        } else {
            return (hn) invokeL.objValue;
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
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + f95.d() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    @Override // com.baidu.tieba.w65
    public hn o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (f95.f.equals(str)) {
                return new hn(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
            }
            Bitmap image = FileHelper.getImage(u(str).getAbsolutePath());
            if (image == null) {
                return null;
            }
            return new hn(image, false, str);
        }
        return (hn) invokeL.objValue;
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
            List<CollectEmotionData> q = qe6.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.e.clear();
            this.f.clear();
            for (CollectEmotionData collectEmotionData : q) {
                this.e.add(collectEmotionData.getSharpText());
                this.f.add(collectEmotionData.getSharpText());
            }
        }
    }
}
