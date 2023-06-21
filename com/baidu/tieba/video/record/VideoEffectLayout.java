package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.oaa;
import com.baidu.tieba.paa;
import com.baidu.tieba.t8a;
import com.baidu.tieba.vaa;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.xaa;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;
    public HListView b;
    public oaa c;
    public vaa d;
    public List<paa> e;
    public List<paa> f;
    public List<paa> g;
    public List<StickerItem> h;
    public String i;
    public String j;
    public String k;
    public paa<t8a> l;
    public paa<String> m;
    public paa<MusicData> n;
    public StickerItem o;
    public AnimatorSet p;
    public AnimatorSet q;
    public AnimatorSet r;
    public Handler s;
    public int t;

    /* loaded from: classes8.dex */
    public interface h {
        void g1(paa paaVar, Object obj);

        void v1(StickerItem stickerItem);
    }

    /* loaded from: classes8.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ VideoEffectLayout b;

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void v1(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) {
            }
        }

        public a(VideoEffectLayout videoEffectLayout, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoEffectLayout;
            this.a = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void g1(paa paaVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, paaVar, obj) != null) || paaVar == null) {
                return;
            }
            h hVar = this.a;
            if (hVar != null) {
                hVar.g1(paaVar, obj);
            }
            int type = paaVar.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        this.b.k = paaVar.b();
                        this.b.n = paaVar;
                        return;
                    }
                    return;
                }
                this.b.j = paaVar.b();
                this.b.m = paaVar;
                return;
            }
            this.b.i = paaVar.b();
            this.b.l = paaVar;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ VideoEffectLayout b;

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void g1(paa paaVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, paaVar, obj) == null) {
            }
        }

        public b(VideoEffectLayout videoEffectLayout, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoEffectLayout;
            this.a = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void v1(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) != null) || stickerItem == null) {
                return;
            }
            this.b.x(stickerItem);
            h hVar = this.a;
            if (hVar != null) {
                hVar.v1(stickerItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ VideoEffectLayout c;

        public c(VideoEffectLayout videoEffectLayout, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoEffectLayout;
            this.a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.c.e(this.a, this.b);
                this.c.c.notifyDataSetChanged();
                this.c.setListViewSelection(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ VideoEffectLayout b;

        public d(VideoEffectLayout videoEffectLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoEffectLayout;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.a.setSelection(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends xaa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEffectLayout b;

        public e(VideoEffectLayout videoEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoEffectLayout;
        }

        @Override // com.baidu.tieba.xaa, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a && this.b.a != null) {
                this.b.a.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.xaa, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.b.b != null) {
                    this.b.b.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEffectLayout a;

        public f(VideoEffectLayout videoEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoEffectLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends xaa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoEffectLayout b;

        public g(VideoEffectLayout videoEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoEffectLayout;
        }

        @Override // com.baidu.tieba.xaa, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a && this.b.b != null) {
                this.b.b.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.xaa, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.b.a != null) {
                    this.b.a.setVisibility(0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s();
    }

    public void x(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) {
            this.o = stickerItem;
            if (!ListUtils.isEmpty(this.h) && stickerItem != null) {
                for (StickerItem stickerItem2 : this.h) {
                    if (stickerItem2.id != stickerItem.id) {
                        stickerItem2.isSelect = false;
                    } else {
                        stickerItem2.isSelect = true;
                    }
                }
                vaa vaaVar = this.d;
                if (vaaVar != null) {
                    vaaVar.notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        s();
    }

    public final void m(List<paa> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048585, this, list, str) != null) || list == null) {
            return;
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.b.getVisibility() == 0) {
            cVar.run();
            z(false);
        } else {
            y();
            this.s.postDelayed(cVar, 250L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        s();
    }

    public final void k(String str, t8a t8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, t8aVar) == null) {
            this.e.add(n(0, 1, str, t8aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            this.s.post(new d(this, i));
        }
    }

    public final String q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            return getResources().getText(i).toString();
        }
        return (String) invokeI.objValue;
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            oaa oaaVar = this.c;
            if (oaaVar != null) {
                oaaVar.f(new a(this, hVar));
            }
            vaa vaaVar = this.d;
            if (vaaVar != null) {
                vaaVar.e(new b(this, hVar));
            }
        }
    }

    public void setMusicList(List<paa> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            List<paa> list2 = this.g;
            if (list2 == null) {
                this.g = new ArrayList();
            } else {
                list2.clear();
            }
            this.g.addAll(list);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.h = list;
            vaa vaaVar = this.d;
            if (vaaVar != null) {
                vaaVar.d(list);
                this.d.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t = 3;
            m(this.g, this.k);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t = 2;
            p();
            m(this.f, this.j);
        }
    }

    public paa<t8a> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (paa) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public paa<String> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m;
        }
        return (paa) invokeV.objValue;
    }

    public StickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.o;
        }
        return (StickerItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.t = 1;
            o();
            m(this.e, this.i);
        }
    }

    public void v() {
        oaa oaaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (oaaVar = this.c) != null) {
            oaaVar.c();
            this.k = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ccb);
        }
    }

    public void w() {
        oaa oaaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (oaaVar = this.c) != null) {
            oaaVar.d();
        }
    }

    public final void l(int i, String str, String str2) {
        List<paa> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, str, str2) != null) || (list = this.f) == null) {
            return;
        }
        list.add(n(i, 2, str, str2));
    }

    public final <T> paa<T> n(int i, int i2, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, t})) == null) {
            paa<T> paaVar = new paa<>();
            paaVar.f(i2);
            paaVar.d(i);
            paaVar.e(str);
            paaVar.g(t);
            return paaVar;
        }
        return (paa) invokeCommon.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e == null) {
            this.e = new ArrayList();
            k("No", t8a.b(0));
            k("1", t8a.b(1));
            k("2", t8a.b(2));
            k("3", t8a.b(3));
            k("4", t8a.b(4));
            k("5", t8a.b(5));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f == null) {
            this.f = new ArrayList();
            l(R.drawable.obfuscated_res_0x7f0806a2, q(R.string.obfuscated_res_0x7f0f0732), "origin");
            l(R.drawable.obfuscated_res_0x7f0806a6, q(R.string.obfuscated_res_0x7f0f072f), "hongkong");
            l(R.drawable.obfuscated_res_0x7f0806a9, q(R.string.obfuscated_res_0x7f0f0733), "refreshing");
            l(R.drawable.obfuscated_res_0x7f0806a5, q(R.string.obfuscated_res_0x7f0f072d), "girly");
            l(R.drawable.obfuscated_res_0x7f0806a0, q(R.string.obfuscated_res_0x7f0f072a), "concrete");
            l(R.drawable.obfuscated_res_0x7f0806ad, q(R.string.obfuscated_res_0x7f0f0737), "warm");
            l(R.drawable.obfuscated_res_0x7f08069f, q(R.string.obfuscated_res_0x7f0f0729), "cold");
            l(R.drawable.obfuscated_res_0x7f0806a7, q(R.string.obfuscated_res_0x7f0f0730), "Japanese");
            l(R.drawable.obfuscated_res_0x7f0806a1, q(R.string.obfuscated_res_0x7f0f072e), "cruz");
            l(R.drawable.obfuscated_res_0x7f08069c, q(R.string.obfuscated_res_0x7f0f0726), "abao");
            l(R.drawable.obfuscated_res_0x7f0806a3, q(R.string.obfuscated_res_0x7f0f072b), "dew");
            l(R.drawable.obfuscated_res_0x7f0806ab, q(R.string.obfuscated_res_0x7f0f0735), "slowlived");
            l(R.drawable.obfuscated_res_0x7f0806ac, q(R.string.obfuscated_res_0x7f0f0736), "sweet");
            l(R.drawable.obfuscated_res_0x7f08069e, q(R.string.obfuscated_res_0x7f0f0728), "boardwalk");
            l(R.drawable.obfuscated_res_0x7f0806a8, q(R.string.obfuscated_res_0x7f0f0731), "keylime");
            l(R.drawable.obfuscated_res_0x7f0806a4, q(R.string.obfuscated_res_0x7f0f072c), "electric");
            l(R.drawable.obfuscated_res_0x7f0806aa, q(R.string.obfuscated_res_0x7f0f0734), "silver");
            l(R.drawable.obfuscated_res_0x7f08069d, q(R.string.obfuscated_res_0x7f0f0727), "blackwhite");
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = "2";
            this.l = n(R.drawable.obfuscated_res_0x7f080294, 1, "2", t8a.b(2));
            this.j = q(R.string.obfuscated_res_0x7f0f0732);
            this.m = n(R.drawable.obfuscated_res_0x7f0806a2, 2, q(R.string.obfuscated_res_0x7f0f0732), "origin");
            StickerItem stickerItem = new StickerItem();
            stickerItem.id = -1;
            stickerItem.name = "nosticker";
            this.o = stickerItem;
            this.k = getResources().getString(R.string.obfuscated_res_0x7f0f0ccb);
            getResources().getString(R.string.obfuscated_res_0x7f0f0ccb);
            new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0ccb));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.s = new Handler();
            r();
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0503, this);
            HListView hListView = (HListView) findViewById(R.id.obfuscated_res_0x7f09097b);
            this.a = hListView;
            hListView.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9));
            this.a.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.obfuscated_res_0x7f09220b);
            this.b = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            oaa oaaVar = new oaa();
            this.c = oaaVar;
            this.a.setAdapter((ListAdapter) oaaVar);
            vaa vaaVar = new vaa();
            this.d = vaaVar;
            this.b.setAdapter((ListAdapter) vaaVar);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            AnimatorSet animatorSet = this.q;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.q.cancel();
            }
            if (this.p == null) {
                this.p = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, Key.ALPHA, 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.a, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                this.p.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.a.setVisibility(0);
            this.p.start();
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, stickerItem) == null) && !ListUtils.isEmpty(this.h)) {
            if (stickerItem != null) {
                for (StickerItem stickerItem2 : this.h) {
                    if (stickerItem2.id != stickerItem.id) {
                        stickerItem2.isDownLoading = false;
                    } else {
                        stickerItem2.isDownLoading = true;
                    }
                }
            } else {
                for (StickerItem stickerItem3 : this.h) {
                    stickerItem3.isDownLoading = false;
                }
            }
            vaa vaaVar = this.d;
            if (vaaVar != null) {
                vaaVar.notifyDataSetChanged();
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (ListUtils.isEmpty(this.h)) {
                return true;
            }
            if (this.h.size() == 1 && this.h.get(0).id == -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.t = 0;
            this.b.setAdapter((ListAdapter) this.d);
            this.d.notifyDataSetChanged();
            setListViewSelection(0);
            if (getVisibility() == 0) {
                z(true);
                return;
            }
            this.b.setVisibility(0);
            this.a.setVisibility(8);
        }
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                AnimatorSet animatorSet = this.r;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.r.cancel();
                }
                AnimatorSet animatorSet2 = this.p;
                if (animatorSet2 != null && animatorSet2.isRunning()) {
                    this.p.cancel();
                }
                if (this.q == null) {
                    this.q = new AnimatorSet();
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, Key.ALPHA, 1.0f, 0.0f);
                    ofFloat.setDuration(300L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(200L);
                    ofPropertyValuesHolder.addListener(new e(this));
                    this.q.playSequentially(ofFloat, ofPropertyValuesHolder);
                }
                xg.a().postDelayed(new f(this), 300L);
                this.q.start();
                return;
            }
            AnimatorSet animatorSet3 = this.q;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.q.cancel();
            }
            if (this.r == null) {
                this.r = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 1.0f, 0.0f);
                ofFloat2.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.a, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                ofPropertyValuesHolder2.setDuration(200L);
                ofPropertyValuesHolder2.addListener(new g(this));
                this.r.playSequentially(ofFloat2, ofPropertyValuesHolder2);
            }
            this.r.start();
        }
    }
}
