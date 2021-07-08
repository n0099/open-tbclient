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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import d.a.p0.v3.j.k;
import d.a.p0.v3.j.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f21716e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f21717f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.v3.j.d f21718g;

    /* renamed from: h  reason: collision with root package name */
    public k f21719h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.p0.v3.j.e> f21720i;
    public List<d.a.p0.v3.j.e> j;
    public List<d.a.p0.v3.j.e> k;
    public List<StickerItem> l;
    public String m;
    public String n;
    public String o;
    public d.a.p0.v3.j.e<d.a.p0.v3.a> p;
    public d.a.p0.v3.j.e<String> q;
    public d.a.p0.v3.j.e<MusicData> r;
    public StickerItem s;
    public AnimatorSet t;
    public AnimatorSet u;
    public AnimatorSet v;
    public Handler w;
    public int x;

    /* loaded from: classes4.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21721e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21722f;

        public a(VideoEffectLayout videoEffectLayout, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21722f = videoEffectLayout;
            this.f21721e = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onEffectChoosed(d.a.p0.v3.j.e eVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, eVar, obj) == null) || eVar == null) {
                return;
            }
            h hVar = this.f21721e;
            if (hVar != null) {
                hVar.onEffectChoosed(eVar, obj);
            }
            int c2 = eVar.c();
            if (c2 == 1) {
                this.f21722f.m = eVar.b();
                this.f21722f.p = eVar;
            } else if (c2 == 2) {
                this.f21722f.n = eVar.b();
                this.f21722f.q = eVar;
            } else if (c2 != 3) {
            } else {
                this.f21722f.o = eVar.b();
                this.f21722f.r = eVar;
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onStickerChoosed(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21724f;

        public b(VideoEffectLayout videoEffectLayout, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21724f = videoEffectLayout;
            this.f21723e = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onEffectChoosed(d.a.p0.v3.j.e eVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, eVar, obj) == null) {
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onStickerChoosed(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) || stickerItem == null) {
                return;
            }
            this.f21724f.w(stickerItem);
            h hVar = this.f21723e;
            if (hVar != null) {
                hVar.onStickerChoosed(stickerItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f21725e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f21726f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21727g;

        public c(VideoEffectLayout videoEffectLayout, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21727g = videoEffectLayout;
            this.f21725e = list;
            this.f21726f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21727g.f21718g.e(this.f21725e, this.f21726f);
                this.f21727g.f21718g.notifyDataSetChanged();
                this.f21727g.setListViewSelection(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21729f;

        public d(VideoEffectLayout videoEffectLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21729f = videoEffectLayout;
            this.f21728e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21729f.f21716e.setSelection(this.f21728e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21730f;

        public e(VideoEffectLayout videoEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21730f = videoEffectLayout;
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f65667e || this.f21730f.f21716e == null) {
                return;
            }
            this.f21730f.f21716e.setVisibility(8);
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f21730f.f21717f != null) {
                    this.f21730f.f21717f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21731e;

        public f(VideoEffectLayout videoEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21731e = videoEffectLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21731e.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f21732f;

        public g(VideoEffectLayout videoEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21732f = videoEffectLayout;
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f65667e || this.f21732f.f21717f == null) {
                return;
            }
            this.f21732f.f21717f.setVisibility(8);
        }

        @Override // d.a.p0.v3.j.m, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f21732f.f21716e != null) {
                    this.f21732f.f21716e.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface h {
        void onEffectChoosed(d.a.p0.v3.j.e eVar, Object obj);

        void onStickerChoosed(StickerItem stickerItem);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i2) == null) {
            this.w.post(new d(this, i2));
        }
    }

    public d.a.p0.v3.j.e<d.a.p0.v3.a> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : (d.a.p0.v3.j.e) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x : invokeV.intValue;
    }

    public d.a.p0.v3.j.e<String> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : (d.a.p0.v3.j.e) invokeV.objValue;
    }

    public StickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : (StickerItem) invokeV.objValue;
    }

    public final void k(String str, d.a.p0.v3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, aVar) == null) {
            this.f21720i.add(n(0, 1, str, aVar));
        }
    }

    public final void l(int i2, String str, String str2) {
        List<d.a.p0.v3.j.e> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048581, this, i2, str, str2) == null) || (list = this.j) == null) {
            return;
        }
        list.add(n(i2, 2, str, str2));
    }

    public final void m(List<d.a.p0.v3.j.e> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, list, str) == null) || list == null) {
            return;
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.f21717f.getVisibility() == 0) {
            cVar.run();
            y(false);
        } else {
            x();
            this.w.postDelayed(cVar, 250L);
        }
    }

    public final <T> d.a.p0.v3.j.e<T> n(int i2, int i3, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, t})) == null) {
            d.a.p0.v3.j.e<T> eVar = new d.a.p0.v3.j.e<>();
            eVar.g(i3);
            eVar.e(i2);
            eVar.f(str);
            eVar.h(t);
            return eVar;
        }
        return (d.a.p0.v3.j.e) invokeCommon.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.f21720i == null) {
            this.f21720i = new ArrayList();
            k("No", d.a.p0.v3.a.b(0));
            k("1", d.a.p0.v3.a.b(1));
            k("2", d.a.p0.v3.a.b(2));
            k("3", d.a.p0.v3.a.b(3));
            k("4", d.a.p0.v3.a.b(4));
            k("5", d.a.p0.v3.a.b(5));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.x = 1;
            o();
            m(this.f21720i, this.m);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.x = 2;
            p();
            m(this.j, this.n);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x = 3;
            m(this.k, this.o);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.x = 0;
            this.f21717f.setAdapter((ListAdapter) this.f21719h);
            this.f21719h.notifyDataSetChanged();
            setListViewSelection(0);
            if (getVisibility() == 0) {
                y(true);
                return;
            }
            this.f21717f.setVisibility(0);
            this.f21716e.setVisibility(8);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.j == null) {
            this.j = new ArrayList();
            l(R.drawable.filter_icon_avatar_default, q(R.string.filter_nature), FilterValue.DEFAULT_FILTER_VALUE);
            l(R.drawable.filter_icon_avatar_hongkong, q(R.string.filter_hongkong), "hongkong");
            l(R.drawable.filter_icon_avatar_refreshing, q(R.string.filter_refreshing), "refreshing");
            l(R.drawable.filter_icon_avatar_girly, q(R.string.filter_girly), "girly");
            l(R.drawable.filter_icon_avatar_concrete, q(R.string.filter_concrete), "concrete");
            l(R.drawable.filter_icon_avatar_warm, q(R.string.filter_warm), "warm");
            l(R.drawable.filter_icon_avatar_cold, q(R.string.filter_cold), "cold");
            l(R.drawable.filter_icon_avatar_japanese, q(R.string.filter_japanese), "Japanese");
            l(R.drawable.filter_icon_avatar_cruz, q(R.string.filter_hdr), "cruz");
            l(R.drawable.filter_icon_avatar_abao, q(R.string.filter_abao), "abao");
            l(R.drawable.filter_icon_avatar_dew, q(R.string.filter_dew), "dew");
            l(R.drawable.filter_icon_avatar_slowlived, q(R.string.filter_slowlived), "slowlived");
            l(R.drawable.filter_icon_avatar_sweet, q(R.string.filter_sweet), "sweet");
            l(R.drawable.filter_icon_avatar_boardwalk, q(R.string.filter_boardwalk), "boardwalk");
            l(R.drawable.filter_icon_avatar_keylime, q(R.string.filter_keylime), "keylime");
            l(R.drawable.filter_icon_avatar_electric, q(R.string.filter_electric), "electric");
            l(R.drawable.filter_icon_avatar_silver, q(R.string.filter_silver), "silver");
            l(R.drawable.filter_icon_avatar_blackwhite, q(R.string.filter_blackwhite), "blackwhite");
        }
    }

    public final String q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? getResources().getText(i2).toString() : (String) invokeI.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m = "2";
            this.p = n(R.drawable.beauty_icon_avatar_2, 1, "2", d.a.p0.v3.a.b(2));
            this.n = q(R.string.filter_nature);
            this.q = n(R.drawable.filter_icon_avatar_default, 2, q(R.string.filter_nature), FilterValue.DEFAULT_FILTER_VALUE);
            StickerItem stickerItem = new StickerItem();
            stickerItem.id = -1;
            stickerItem.name = "nosticker";
            this.s = stickerItem;
            this.o = getResources().getString(R.string.music_normal);
            getResources().getString(R.string.music_normal);
            new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.w = new Handler();
            r();
            LinearLayout.inflate(getContext(), R.layout.layout_effect_container, this);
            HListView hListView = (HListView) findViewById(R.id.effect_list_view);
            this.f21716e = hListView;
            hListView.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
            this.f21716e.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.sticker_list_view);
            this.f21717f = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            d.a.p0.v3.j.d dVar = new d.a.p0.v3.j.d();
            this.f21718g = dVar;
            this.f21716e.setAdapter((ListAdapter) dVar);
            k kVar = new k();
            this.f21719h = kVar;
            this.f21717f.setAdapter((ListAdapter) kVar);
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, stickerItem) == null) || ListUtils.isEmpty(this.l)) {
            return;
        }
        if (stickerItem != null) {
            for (StickerItem stickerItem2 : this.l) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isDownLoading = false;
                } else {
                    stickerItem2.isDownLoading = true;
                }
            }
        } else {
            for (StickerItem stickerItem3 : this.l) {
                stickerItem3.isDownLoading = false;
            }
        }
        k kVar = this.f21719h;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hVar) == null) {
            d.a.p0.v3.j.d dVar = this.f21718g;
            if (dVar != null) {
                dVar.f(new a(this, hVar));
            }
            k kVar = this.f21719h;
            if (kVar != null) {
                kVar.e(new b(this, hVar));
            }
        }
    }

    public void setMusicList(List<d.a.p0.v3.j.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            List<d.a.p0.v3.j.e> list2 = this.k;
            if (list2 == null) {
                this.k = new ArrayList();
            } else {
                list2.clear();
            }
            this.k.addAll(list);
        }
    }

    public void setStickerItems(List<StickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            this.l = list;
            k kVar = this.f21719h;
            if (kVar != null) {
                kVar.d(list);
                this.f21719h.notifyDataSetChanged();
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (ListUtils.isEmpty(this.l)) {
                return true;
            }
            return this.l.size() == 1 && this.l.get(0).id == -1;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        d.a.p0.v3.j.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (dVar = this.f21718g) == null) {
            return;
        }
        dVar.c();
        this.o = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public void v() {
        d.a.p0.v3.j.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (dVar = this.f21718g) == null) {
            return;
        }
        dVar.d();
    }

    public void w(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) {
            this.s = stickerItem;
            if (ListUtils.isEmpty(this.l) || stickerItem == null) {
                return;
            }
            for (StickerItem stickerItem2 : this.l) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            k kVar = this.f21719h;
            if (kVar != null) {
                kVar.notifyDataSetChanged();
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            AnimatorSet animatorSet = this.u;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.u.cancel();
            }
            if (this.t == null) {
                this.t = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21716e, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21716e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                this.t.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.f21716e.setVisibility(0);
            this.t.start();
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                AnimatorSet animatorSet = this.v;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.v.cancel();
                }
                AnimatorSet animatorSet2 = this.t;
                if (animatorSet2 != null && animatorSet2.isRunning()) {
                    this.t.cancel();
                }
                if (this.u == null) {
                    this.u = new AnimatorSet();
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21716e, "alpha", 1.0f, 0.0f);
                    ofFloat.setDuration(300L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21717f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(200L);
                    ofPropertyValuesHolder.addListener(new e(this));
                    this.u.playSequentially(ofFloat, ofPropertyValuesHolder);
                }
                d.a.c.e.m.e.a().postDelayed(new f(this), 300L);
                this.u.start();
                return;
            }
            AnimatorSet animatorSet3 = this.u;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.u.cancel();
            }
            if (this.v == null) {
                this.v = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21717f, "alpha", 1.0f, 0.0f);
                ofFloat2.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f21716e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder2.setDuration(200L);
                ofPropertyValuesHolder2.addListener(new g(this));
                this.v.playSequentially(ofFloat2, ofPropertyValuesHolder2);
            }
            this.v.start();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        s();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEffectLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        s();
    }
}
