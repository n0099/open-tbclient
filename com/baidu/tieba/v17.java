package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.widget.ImageView.BdImage;
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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes8.dex */
public class v17 extends bf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> e;
    public Set<String> f;

    @Override // com.baidu.tieba.bf5
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "用户收藏表情" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bf5
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bf5
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bf5
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public v17() {
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
            BdImage bdImage = new BdImage(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
            super.s(bdImage);
            super.r(bdImage);
            x();
        }
    }

    @Override // com.baidu.tieba.bf5
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

    @Override // com.baidu.tieba.bf5
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.f.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bf5
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

    @Override // com.baidu.tieba.bf5
    public BdImage e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.d();
        }
        return (BdImage) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bf5
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return hj5.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bf5
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
    @Override // com.baidu.tieba.bf5
    public BdImage n(String str) {
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
                                    BdImage bdImage = new BdImage(NSGif.f(byteArray, 0, byteArray.length));
                                    BdCloseHelper.close((InputStream) exists);
                                    BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                                    return bdImage;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            BdCloseHelper.close((InputStream) exists);
                            BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                            return null;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th) {
                        file = 0;
                        th = th;
                        BdCloseHelper.close((InputStream) exists);
                        BdCloseHelper.close((OutputStream) file);
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
            return (BdImage) invokeL.objValue;
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
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + hj5.d() + "/" + replace2 + "_s.jpg");
        }
        return (File) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bf5
    public BdImage o(String str) {
        InterceptResult invokeL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (hj5.f.equals(str)) {
                return new BdImage(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
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
            return new BdImage(bitmap, false, str);
        }
        return (BdImage) invokeL.objValue;
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
            List<CollectEmotionData> q = m17.o().q(TbadkCoreApplication.getCurrentAccountForEmotion());
            this.e.clear();
            this.f.clear();
            for (CollectEmotionData collectEmotionData : q) {
                this.e.add(collectEmotionData.getSharpText());
                this.f.add(collectEmotionData.getSharpText());
            }
        }
    }
}
