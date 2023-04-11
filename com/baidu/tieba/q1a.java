package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class q1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final a9 b;
    public WriteImagesInfo c;
    public VideoFileInfo d;
    public String e;
    public ImageFileInfo f;
    public List<ImageFileInfo> g;
    public final List<os4> h;

    public q1a(a9 a9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 9;
        this.h = new ArrayList();
        this.b = a9Var;
    }

    public List<MediaFileInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.h != null && !StringUtils.isNull(str)) {
                for (os4 os4Var : this.h) {
                    if (os4Var != null && TextUtils.equals(str, os4Var.b())) {
                        return os4Var.d();
                    }
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.c == null) {
                this.c = new WriteImagesInfo(this.a);
            }
            this.c.setLastAlbumId(str);
        }
    }

    public void B(boolean z) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (writeImagesInfo = this.c) != null) {
            writeImagesInfo.setOriginalImg(z);
        }
    }

    public void C(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeImagesInfo) == null) {
            this.c = writeImagesInfo;
        }
    }

    public void a(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, imageFileInfo) == null) {
            if (this.c == null) {
                this.c = new WriteImagesInfo(this.a);
            }
            this.c.addChooseFile(imageFileInfo);
        }
    }

    public void c(ImageFileInfo imageFileInfo) {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, imageFileInfo) != null) || (writeImagesInfo = this.c) == null) {
            return;
        }
        writeImagesInfo.delChooseFile(imageFileInfo);
    }

    public boolean n(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, imageFileInfo)) == null) {
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo == null) {
                return false;
            }
            return writeImagesInfo.isAdded(imageFileInfo);
        }
        return invokeL.booleanValue;
    }

    public boolean q(VideoFileInfo videoFileInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, videoFileInfo)) == null) {
            VideoFileInfo videoFileInfo2 = this.d;
            if (videoFileInfo2 == null || videoFileInfo == null || videoFileInfo2.videoId != videoFileInfo.videoId) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void w(VideoFileInfo videoFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, videoFileInfo) == null) {
            this.d = videoFileInfo;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.e = str;
            v(str);
        }
    }

    public void y(ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, imageFileInfo) == null) {
            this.f = imageFileInfo;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo == null) {
                return 0;
            }
            return writeImagesInfo.size();
        }
        return invokeV.intValue;
    }

    public void b() {
        WriteImagesInfo writeImagesInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (writeImagesInfo = this.c) == null) {
            return;
        }
        writeImagesInfo.clear();
    }

    public List<os4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public VideoFileInfo f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (VideoFileInfo) invokeV.objValue;
    }

    public List<ImageFileInfo> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.getChosedFiles();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public List<ImageFileInfo> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.getLastAlbumId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.getMaxImagesAllowed();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public WriteImagesInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (WriteImagesInfo) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return !ListUtils.isEmpty(g());
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return ListUtils.isEmpty(d(os4.f));
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            WriteImagesInfo writeImagesInfo = this.c;
            if (writeImagesInfo != null) {
                return writeImagesInfo.isOriginalImg();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int j() {
        InterceptResult invokeV;
        List<ImageFileInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ImageFileInfo imageFileInfo = this.f;
            if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && (list = this.g) != null && list.size() != 0) {
                int size = this.g.size();
                for (int i = 0; i < size; i++) {
                    ImageFileInfo imageFileInfo2 = this.g.get(i);
                    if (imageFileInfo2 != null && this.f.getFilePath().equals(imageFileInfo2.getFilePath())) {
                        return i;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public os4 t(List<MediaFileInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, list)) == null) {
            os4 os4Var = new os4();
            os4Var.h(os4.f);
            os4Var.l(this.b.getString(R.string.obfuscated_res_0x7f0f0258));
            int count = ListUtils.getCount(list);
            os4Var.j(list);
            os4Var.i(String.valueOf(count));
            MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(list, count - 1);
            if (mediaFileInfo instanceof ImageFileInfo) {
                os4Var.k((ImageFileInfo) mediaFileInfo);
            } else if (mediaFileInfo instanceof VideoFileInfo) {
                os4Var.k((VideoFileInfo) mediaFileInfo);
            }
            return os4Var;
        }
        return (os4) invokeL.objValue;
    }

    public os4 u(List<VideoFileInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, list)) == null) {
            os4 os4Var = new os4();
            os4Var.h(os4.g);
            os4Var.l(this.b.getString(R.string.obfuscated_res_0x7f0f025a));
            int count = ListUtils.getCount(list);
            os4Var.i(String.valueOf(count));
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(list)) {
                arrayList.addAll(list);
            }
            os4Var.j(arrayList);
            VideoFileInfo videoFileInfo = (VideoFileInfo) ListUtils.getItem(list, count - 1);
            if (videoFileInfo != null) {
                os4Var.k(videoFileInfo);
            }
            return os4Var;
        }
        return (os4) invokeL.objValue;
    }

    public void z(us4 us4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, us4Var) != null) || us4Var == null) {
            return;
        }
        List<MediaFileInfo> list = us4Var.b;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t(list));
        if (!ListUtils.isEmpty(us4Var.c)) {
            arrayList.add(u(us4Var.c));
        }
        if (!ListUtils.isEmpty(us4Var.a)) {
            arrayList.addAll(us4Var.a);
        }
        this.h.clear();
        this.h.addAll(arrayList);
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && this.h != null && !StringUtils.isNull(str)) {
            for (os4 os4Var : this.h) {
                if (os4Var != null && TextUtils.equals(str, os4Var.b())) {
                    ArrayList arrayList = new ArrayList();
                    if (os4Var.d() != null) {
                        for (MediaFileInfo mediaFileInfo : os4Var.d()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.g = arrayList;
                }
            }
        }
    }
}
