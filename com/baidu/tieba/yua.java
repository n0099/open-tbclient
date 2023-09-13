package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.VideoPlayView;
import com.baidu.tieba.videoplay.nad.AdVideoFlowFragment;
import com.baidu.tieba.w3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/* loaded from: classes8.dex */
public class yua implements IAdBaseAsyncController.a, u3a<VideoItemModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;
    public final List<VideoItemModel> b;
    public final w3a c;
    public final Queue<AdvertAppInfo> d;
    public final Map<VideoItemModel, AdvertAppInfo> e;
    public int f;
    public boolean g;
    public int h;
    public VideoPlayView i;
    public r3a j;
    public final boolean k;
    public w3a.a l;
    public int m;
    public VideoItemModel n;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u3a
    /* renamed from: l */
    public void d(int i, int i2, int i3, t3a t3aVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), t3aVar, videoItemModel}) == null) {
        }
    }

    public yua(@NonNull List list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.f = 0;
        this.g = true;
        this.b = list;
        this.a = tbPageContext;
        w3a w3aVar = (w3a) i3a.m().i(IAdBaseAsyncController.Type.VIDEO_FLOW, this);
        this.c = w3aVar;
        w3aVar.a(this.a);
        this.d = new LinkedList();
        this.e = new HashMap();
        int d = o36.a().d();
        int e = o36.a().e();
        if (d > 0 && e > 0) {
            z = true;
        }
        this.k = z;
        if (!z) {
            return;
        }
        r3a r3aVar = new r3a();
        this.j = r3aVar;
        r3aVar.d(d - 1);
        this.j.e(e);
    }

    @Override // com.baidu.tieba.u3a
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (i2 != 0) {
                this.h = i2;
            }
            if (this.h - 2 <= i && this.d.isEmpty() && this.g) {
                this.c.loadAd();
                this.g = false;
            }
        }
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || i39.e(list)) {
            return;
        }
        this.g = true;
        this.d.addAll(list);
        VideoItemModel videoItemModel = new VideoItemModel(new VideoItemData(), 5);
        this.n = videoItemModel;
        s3a.b(this.b, this.m, this.j, this.f, videoItemModel, this.d.peek(), this);
    }

    public List<VideoItemModel> h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<VideoItemModel, AdvertAppInfo> entry : this.e.entrySet()) {
                if (TextUtils.equals(entry.getValue().a, str)) {
                    arrayList.add(entry.getKey());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            VideoItemModel videoItemModel = this.b.get(i);
            if (this.e.containsKey(videoItemModel)) {
                this.c.m(this.e.get(videoItemModel));
            }
        }
    }

    public void n(w3a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void o(VideoPlayView videoPlayView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoPlayView) == null) {
            this.i = videoPlayView;
        }
    }

    public AdVideoFlowFragment g(int i) {
        InterceptResult invokeI;
        w2a i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            AdvertAppInfo advertAppInfo = this.e.get(this.b.get(i));
            if (advertAppInfo == null || (i2 = this.c.i(advertAppInfo)) == null) {
                return null;
            }
            if ((i2 instanceof View) && (this.a.getPageActivity() instanceof xi0)) {
                advertAppInfo.s = zi0.b(advertAppInfo.s, (xi0) this.a.getPageActivity(), (View) i2);
            }
            i2.setPageChangeHandler(this.l, i);
            AdVideoFlowFragment adVideoFlowFragment = new AdVideoFlowFragment();
            adVideoFlowFragment.W1(i2);
            return adVideoFlowFragment;
        }
        return (AdVideoFlowFragment) invokeI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !this.k) {
            return;
        }
        this.f = 0;
        this.h = o36.a().d() - 1;
        if (this.d.size() < 1 && this.g) {
            this.c.loadAd();
            this.g = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u3a
    /* renamed from: j */
    public void c(int i, int i2, t3a t3aVar, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), t3aVar, videoItemModel}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) t3aVar;
            this.d.remove(advertAppInfo);
            this.f = i2;
            this.e.put(videoItemModel, advertAppInfo);
            VideoPlayView videoPlayView = this.i;
            if (videoPlayView != null) {
                videoPlayView.notifyDataSetChanged();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u3a
    /* renamed from: k */
    public void e(int i, int i2, VideoItemModel videoItemModel, t3a t3aVar, VideoItemModel videoItemModel2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), videoItemModel, t3aVar, videoItemModel2}) == null) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) t3aVar;
            this.d.remove(advertAppInfo);
            this.f = i2;
            this.e.put(videoItemModel, advertAppInfo);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || !this.k) {
            return;
        }
        this.m = i;
        VideoItemModel videoItemModel = (VideoItemModel) i39.d(this.b, i);
        if (this.e.containsKey(videoItemModel)) {
            AdvertAppInfo advertAppInfo = this.e.get(videoItemModel);
            x4a.o(advertAppInfo);
            this.c.c(advertAppInfo, true);
            return;
        }
        this.c.c(null, false);
        if (i <= this.f) {
            return;
        }
        VideoItemModel videoItemModel2 = new VideoItemModel(new VideoItemData(), 5);
        this.n = videoItemModel2;
        s3a.b(this.b, i, this.j, this.f, videoItemModel2, this.d.peek(), this);
    }
}
