package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class kz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public final List<VideoItemModel> b;
    public final List<VideoAttentionPersonListData> c;
    public String d;
    public final int e;
    public final int f;
    public String g;
    public int h;
    public boolean i;
    public jz8 j;

    public kz8() {
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
        this.h = -1;
        this.i = true;
        this.b = new LinkedList();
        this.e = h15.m() - 1;
        this.f = h15.l() + 1;
        this.c = new LinkedList();
    }

    @Nullable
    public Long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int size = this.b.size();
            while (true) {
                size--;
                if (size < 0) {
                    return null;
                }
                VideoItemData t = t(size);
                if (t != null) {
                    long g = wg.g(t.getThreadId(), 0L);
                    if (g == 0) {
                        return null;
                    }
                    return Long.valueOf(g);
                }
            }
        } else {
            return (Long) invokeV.objValue;
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.b.size() != 0 && (this.b.size() != 1 || !this.b.get(0).isLoadingType())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void A(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, list, str) == null) {
            this.b.clear();
            this.b.add(new VideoItemModel(null, 4));
            this.c.clear();
            this.c.addAll(list);
            this.d = str;
            this.i = false;
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.clear();
            this.b.add(new VideoItemModel(null, 3));
            this.i = false;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b.size() == 0) {
            this.b.add(new VideoItemModel(null, VideoItemModel.TYPE_LOADING));
        }
    }

    public final void d() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.b.size() > 1 && (videoItemModel = this.b.get(0)) != null && videoItemModel.isLoadingType()) {
            this.b.remove(0);
        }
    }

    public List<VideoItemModel> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public List<VideoItemModel> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public BdUniqueId n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return ListUtils.isEmpty(this.b);
        }
        return invokeV.booleanValue;
    }

    public void C(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.g = str;
        }
    }

    public void E(jz8 jz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jz8Var) == null) {
            this.j = jz8Var;
        }
    }

    @Nullable
    public UserItemData i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            VideoItemData t = t(i);
            if (t != null) {
                return t.author_info;
            }
            return null;
        }
        return (UserItemData) invokeI.objValue;
    }

    public VideoItemModel m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            return (VideoItemModel) ListUtils.getItem(this.b, i);
        }
        return (VideoItemModel) invokeI.objValue;
    }

    @Nullable
    public String r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            VideoItemData t = t(i);
            if (t != null) {
                return t.getThreadId();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Nullable
    public VideoItemData s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.b, i);
            if (videoItemModel == null) {
                return null;
            }
            return videoItemModel.getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    @Nullable
    public final VideoItemData t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            return this.b.get(i).getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    public boolean y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            int i2 = this.e;
            while (i2 < this.b.size()) {
                if (i2 == i) {
                    return true;
                }
                i2 += this.f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void a(int i) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || !VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() || !this.i) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.b);
        if (this.h < 0) {
            int i2 = this.e;
            this.h = i2;
            if (i2 <= i) {
                return;
            }
            if (i2 >= arrayList.size() + 1) {
                this.h = -1;
                return;
            }
            VideoItemModel videoItemModel2 = (VideoItemModel) ListUtils.getItem(arrayList, this.h);
            if (videoItemModel2 == null || !videoItemModel2.isFunAdType()) {
                arrayList.add(this.h, new VideoItemModel(null, 2));
            }
        }
        int i3 = this.h;
        while (true) {
            i3 += this.f;
            if (i3 >= arrayList.size() + 1) {
                break;
            } else if (i3 > i && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i3)) == null || !videoItemModel.isFunAdType())) {
                this.h = i3;
                arrayList.add(i3, new VideoItemModel(null, 2));
            }
        }
        this.b.clear();
        this.b.addAll(arrayList);
        jz8 jz8Var = this.j;
        if (jz8Var != null) {
            jz8Var.f();
        }
    }

    public void z(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, list) != null) || list == null) {
            return;
        }
        this.h = -1;
        List arrayList = new ArrayList(this.b);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i)).isFunAdType()) {
                this.h = i;
            } else {
                int i3 = i2 + 1;
                VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(list, i2);
                if (videoItemData == null) {
                    arrayList = arrayList.subList(0, i);
                    i2 = i3;
                    break;
                }
                arrayList.set(i, new VideoItemModel(videoItemData, 1));
                i2 = i3;
            }
            i++;
        }
        if (i2 < list.size()) {
            for (VideoItemData videoItemData2 : list.subList(i2, list.size())) {
                arrayList.add(new VideoItemModel(videoItemData2, 1));
            }
        }
        this.b.clear();
        this.b.addAll(arrayList);
        d();
        this.i = true;
        jz8 jz8Var = this.j;
        if (jz8Var != null) {
            jz8Var.b();
        }
    }

    public synchronized void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (VideoItemData videoItemData : list) {
                    if (this.b.size() == 0 || w(videoItemData)) {
                        arrayList.add(new VideoItemModel(videoItemData, 1));
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.b.addAll(arrayList);
                }
                if (this.j != null) {
                    this.j.f();
                }
            }
        }
    }

    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (i < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next.getHashCode() == i) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel == null || !videoItemModel.isFunAdType()) {
                return false;
            }
            int indexOf = this.b.indexOf(videoItemModel);
            int i2 = this.h;
            if (indexOf < i2) {
                this.h = i2 - 1;
            }
            this.b.remove(videoItemModel);
            jz8 jz8Var = this.j;
            if (jz8Var != null) {
                jz8Var.e();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next != null && next.getVideoItemData() != null && str.equalsIgnoreCase(next.getVideoItemData().thread_id)) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel == null) {
                return false;
            }
            this.b.remove(videoItemModel);
            jz8 jz8Var = this.j;
            if (jz8Var != null) {
                jz8Var.e();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            for (int i2 = i + 1; i2 < this.b.size(); i2++) {
                VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.b, i2);
                if (videoItemModel != null && videoItemModel.isFunAdType()) {
                    this.b.remove(videoItemModel);
                    return true;
                }
            }
            if (this.h + this.f > this.b.size() - 1) {
                this.h += this.f;
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean w(VideoItemData videoItemData) {
        InterceptResult invokeL;
        VideoItemData videoItemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, videoItemData)) == null) {
            if (videoItemData == null || videoItemData.getThreadId() == null) {
                return false;
            }
            if (this.b.size() < 1) {
                return true;
            }
            int i = 0;
            for (int size = this.b.size() - 1; size >= 0 && i < 30; size--) {
                VideoItemModel videoItemModel = this.b.get(size);
                if (videoItemModel != null && (videoItemData2 = videoItemModel.getVideoItemData()) != null && videoItemData2.getThreadId() != null) {
                    if (videoItemData2.getThreadId().equals(videoItemData.getThreadId())) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean u(VideoItemModel videoItemModel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, videoItemModel, i)) == null) {
            if (i == 0 && this.b.size() > 0 && this.b.get(0).isLoadingType()) {
                this.b.set(0, videoItemModel);
                jz8 jz8Var = this.j;
                if (jz8Var != null) {
                    jz8Var.f();
                }
                return true;
            }
            if (i < this.b.size()) {
                this.b.add(i, videoItemModel);
            } else {
                this.b.add(videoItemModel);
            }
            d();
            jz8 jz8Var2 = this.j;
            if (jz8Var2 != null) {
                jz8Var2.f();
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
