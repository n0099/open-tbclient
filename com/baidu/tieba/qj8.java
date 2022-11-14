package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class qj8 implements wj8 {
    public static /* synthetic */ Interceptable $ic;
    public static String h;
    public static String i;
    public static String j;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public Context b;
    public String c;
    public String d;
    public ShareEntity e;
    public String f;
    public String g;

    public void o(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, intent) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948093866, "Lcom/baidu/tieba/qj8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948093866, "Lcom/baidu/tieba/qj8;");
                return;
            }
        }
        h = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share";
        i = "temp_video_thumb.png";
        j = "_temp_share_pic.png";
    }

    public qj8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            F(str, BdToast.ToastIcon.FAILURE);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            F(str, BdToast.ToastIcon.SUCCESS);
        }
    }

    public Bitmap f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            return BitmapHelper.getCashBitmap(i2);
        }
        return (Bitmap) invokeI.objValue;
    }

    public Bitmap h(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, uri)) == null) {
            return BitmapHelper.loadBitmap(uri.getPath());
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return BitmapHelper.loadBitmap(str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public boolean p(Uri uri) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                file = new File(new URI(uri.toString()));
            } catch (IllegalArgumentException | URISyntaxException unused) {
            }
            if (!file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.d = str;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.g = str;
        }
    }

    public void E(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str)) {
                    str = m(R.string.obfuscated_res_0x7f0f11b3, new Object[0]);
                }
                String n = n();
                if (n != null) {
                    G(m(R.string.obfuscated_res_0x7f0f11b4, new Object[0]), n);
                    w();
                    py4.k().u("key_person_growth_share_switch", true);
                    return;
                }
                D(str);
                x();
            } else if (i2 == 3) {
                if (TextUtils.isEmpty(str)) {
                    str = m(R.string.obfuscated_res_0x7f0f1183, new Object[0]);
                }
                C(str);
            } else if (i2 == 2) {
                if (TextUtils.isEmpty(str)) {
                    str = m(R.string.obfuscated_res_0x7f0f118b, new Object[0]);
                }
                C(str);
            }
        }
    }

    public void F(String str, BdToast.ToastIcon toastIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, toastIcon) == null) {
            BdToast b = BdToast.b(d(), str);
            b.f(toastIcon);
            b.i();
        }
    }

    public Bitmap k(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, bitmap, i2)) == null) {
            return BitmapHelper.resizeBitmap(bitmap, i2, i2, false);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public String m(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i2, objArr)) == null) {
            return d().getString(i2, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public void u(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            E(i2, null, i3);
            c(i2, i3);
        }
    }

    public void G(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            BdToastData bdToastData = new BdToastData();
            if (TbadkCoreApplication.getCurrentMemberType() > 0) {
                bdToastData.setIconType(5);
            } else {
                bdToastData.setIconType(4);
            }
            ArrayList arrayList = new ArrayList(1);
            BdToastData.ContentBean contentBean = new BdToastData.ContentBean();
            contentBean.setText(str);
            arrayList.add(contentBean);
            if (str2 != null) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX).append((CharSequence) str2);
                BdToastData.ContentBean contentBean2 = new BdToastData.ContentBean();
                contentBean2.setHasColor(1);
                contentBean2.setText(spannableStringBuilder.toString());
                arrayList.add(contentBean2);
            }
            bdToastData.setContent(arrayList);
            BdToastHelper.toast(bdToastData);
        }
    }

    public void b(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i2, i3, i4) == null) {
            ShareEvent shareEvent = new ShareEvent();
            shareEvent.status = i2;
            shareEvent.tid = this.c;
            shareEvent.channel = i3;
            shareEvent.extLiveInfo = this.d;
            shareEvent.from = i4;
            tb5.i(shareEvent);
        }
    }

    public Bitmap l(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048593, this, bitmap, i2, i3)) == null) {
            return BitmapHelper.resizeBitmap(bitmap, i2, i3, false);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            if (!TextUtils.isEmpty(this.c)) {
                b(i2, i3, 0);
            } else if (!StringUtils.isNull(this.d)) {
                b(i2, i3, 0);
            } else {
                ShareEntity shareEntity = this.e;
                if (shareEntity != null && shareEntity.isFromDuXiaoMan()) {
                    b(i2, i3, 1);
                }
            }
        }
    }

    public Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TbadkCoreApplication.getInst().getContext();
        }
        return (Context) invokeV.objValue;
    }

    public Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return BitmapHelper.getCashBitmap(R.drawable.obfuscated_res_0x7f081833);
        }
        return (Bitmap) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public BdUniqueId j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            w9 c = x9.c(this.b);
            if (c != null) {
                return c.getUniqueId();
            }
            return bdUniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SHARE_THREAD));
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && g() != null) {
            StatisticItem statisticItem = new StatisticItem("c14390");
            statisticItem.addParam("topic_id", g());
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public in r(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, shareEntity)) == null) {
            if (shareEntity == null || (bundle = shareEntity.diskPicOperate) == null) {
                return null;
            }
            String string = bundle.getString("path");
            String string2 = bundle.getString("name");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            boolean z = bundle.getBoolean("isSubDir", true);
            boolean z2 = bundle.getBoolean("isSdcard", false);
            boolean z3 = bundle.getBoolean("isSavedCache", true);
            boolean z4 = bundle.getBoolean("formatData", true);
            pc pcVar = new pc(string, string2, DiskFileOperate.Action.READ);
            pcVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            pcVar.setSubFolder(z);
            pcVar.setIsFormatData(z4);
            pcVar.setSdCard(z2);
            pcVar.setSavedCache(z3);
            if (!lc.f().call(pcVar) || !pcVar.isSuccess()) {
                return null;
            }
            pcVar.formatData(pcVar.getData());
            Bitmap bitmap = pcVar.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new in(bitmap, pcVar.isGif());
        }
        return (in) invokeL.objValue;
    }

    public Bitmap v(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048603, this, bitmap, shareEntity, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap k = k(bitmap, (yi.g(this.b, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
            Bitmap createBitmap = Bitmap.createBitmap(k.getWidth(), k.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(k, 0.0f, 0.0f, (Paint) null);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, k.getHeight(), this.b.getResources().getColor(R.color.CAM_X0601), this.b.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(linearGradient);
            canvas.drawRect(0.0f, 0.0f, k.getWidth(), k.getHeight(), paint);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080643, R.color.CAM_X0101, null, false);
            if (pureDrawable != null) {
                int min = (int) (Math.min(k.getWidth(), k.getHeight()) * 0.3f);
                int width = (k.getWidth() - min) / 2;
                int height = (k.getHeight() - min) / 2;
                pureDrawable.setBounds(width, height, width + min, min + height);
                pureDrawable.draw(canvas);
            }
            if (z) {
                String saveFileAsPNG = FileHelper.saveFileAsPNG(h, i, createBitmap, 100);
                if (!StringUtils.isNull(saveFileAsPNG)) {
                    shareEntity.setImageUri(Uri.parse(saveFileAsPNG));
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLZ.objValue;
    }
}
