package com.baidu.tieba;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class k29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;
        public int b;
        public String c;

        public a(int i, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = "[^a-zA-Z0-9一-龥]";
            this.b = i;
            this.a = cVar;
        }

        public final String a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str2.replaceAll(str, "") : (String) invokeLL.objValue;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (spanned == null || charSequence == null) {
                    return charSequence;
                }
                String a = a(this.c, charSequence.toString());
                int b = wh5.b(spanned.toString()) - (i4 - i3);
                int b2 = wh5.b(a);
                int i5 = this.b;
                int i6 = i5 - b;
                if (b + b2 > i5) {
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.a();
                    }
                    return StringHelper.cutChineseAndEnglishWithSuffix(a, i6, "");
                }
                return a;
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;
        public EditText b;
        public int c;

        public b(EditText editText, int i, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = editText;
            this.c = i;
            this.a = cVar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (spanned == null || charSequence == null || " ".equals(charSequence)) {
                    return charSequence;
                }
                int c = wh5.c(spanned.toString()) - (i4 - i3);
                int c2 = wh5.c(charSequence.toString());
                if (c == 0 && c2 > this.c && TextUtils.isEmpty(this.b.getText())) {
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.a();
                    }
                    return wh5.m(charSequence.toString(), this.c);
                } else if (TextUtils.isEmpty(this.b.getText()) || (c + c2) - wh5.j(this.b.getText().toString()) <= this.c) {
                    return charSequence;
                } else {
                    c cVar2 = this.a;
                    if (cVar2 != null) {
                        cVar2.a();
                    }
                    return c2 > this.c ? spanned.toString().substring(i3, i4) : "";
                }
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947861335, "Lcom/baidu/tieba/k29;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947861335, "Lcom/baidu/tieba/k29;");
        }
    }

    public static boolean a(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        String filePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFileInfo)) == null) {
            if (!LimitLowQualityPicUploadSwitch.isOff() && imageFileInfo != null && !imageFileInfo.isGif() && (filePath = imageFileInfo.getFilePath()) != null) {
                long fileSize = FileHelper.getFileSize(filePath);
                if (fileSize < 5120) {
                    d(1, "" + fileSize);
                    return true;
                }
                int[] imageFileWH = FileHelper.getImageFileWH(filePath);
                if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
                    d(2, imageFileWH[0] + "*" + imageFileWH[1]);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        String filePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, imageFileInfo)) == null) {
            int l = bx4.k().l("key_upload_pic_max_width", 0);
            int l2 = bx4.k().l("key_upload_pic_max_height", 0);
            if (l <= 0 || l2 <= 0 || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
                return false;
            }
            int[] imageFileWH = FileHelper.getImageFileWH(filePath);
            return imageFileWH[0] >= l || imageFileWH[1] >= l2;
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? bx4.k().l("show_write_title_tip_count", 0) : invokeV.intValue;
    }

    public static void d(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str) == null) {
            TiebaStatic.log(new StatisticItem("c14021").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i).param("obj_param1", str));
        }
    }

    public static void e(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, writeData) == null) || writeData == null || TextUtils.isEmpty(writeData.getTitle())) {
            return;
        }
        bx4.k().w("show_write_title_tip_count", c() + 1);
    }
}
