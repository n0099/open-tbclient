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
import b.a.r0.a4.l.j;
import b.a.r0.a4.l.l;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EFFECT_BEAUTY = 1;
    public static final int EFFECT_FILTER = 2;
    public static final int EFFECT_MUSIC = 3;
    public static final int EFFECT_STICKER = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HListView f55742e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f55743f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.a4.l.c f55744g;

    /* renamed from: h  reason: collision with root package name */
    public j f55745h;

    /* renamed from: i  reason: collision with root package name */
    public List<b.a.r0.a4.l.d> f55746i;
    public List<b.a.r0.a4.l.d> j;
    public List<b.a.r0.a4.l.d> k;
    public List<StickerItem> l;
    public String m;
    public String n;
    public String o;
    public b.a.r0.a4.l.d<b.a.r0.a4.a> p;
    public b.a.r0.a4.l.d<String> q;
    public b.a.r0.a4.l.d<MusicData> r;
    public StickerItem s;
    public AnimatorSet t;
    public AnimatorSet u;
    public AnimatorSet v;
    public Handler w;
    public int x;

    /* loaded from: classes9.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f55747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55748f;

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
            this.f55748f = videoEffectLayout;
            this.f55747e = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onEffectChoosed(b.a.r0.a4.l.d dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) || dVar == null) {
                return;
            }
            h hVar = this.f55747e;
            if (hVar != null) {
                hVar.onEffectChoosed(dVar, obj);
            }
            int type = dVar.getType();
            if (type == 1) {
                this.f55748f.m = dVar.b();
                this.f55748f.p = dVar;
            } else if (type == 2) {
                this.f55748f.n = dVar.b();
                this.f55748f.q = dVar;
            } else if (type != 3) {
            } else {
                this.f55748f.o = dVar.b();
                this.f55748f.r = dVar;
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onStickerChoosed(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f55749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55750f;

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
            this.f55750f = videoEffectLayout;
            this.f55749e = hVar;
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onEffectChoosed(b.a.r0.a4.l.d dVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, obj) == null) {
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void onStickerChoosed(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) || stickerItem == null) {
                return;
            }
            this.f55750f.selectStrick(stickerItem);
            h hVar = this.f55749e;
            if (hVar != null) {
                hVar.onStickerChoosed(stickerItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f55751e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55752f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55753g;

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
            this.f55753g = videoEffectLayout;
            this.f55751e = list;
            this.f55752f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55753g.f55744g.g(this.f55751e, this.f55752f);
                this.f55753g.f55744g.notifyDataSetChanged();
                this.f55753g.setListViewSelection(0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55754e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55755f;

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
            this.f55755f = videoEffectLayout;
            this.f55754e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55755f.f55742e.setSelection(this.f55754e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55756f;

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
            this.f55756f = videoEffectLayout;
        }

        @Override // b.a.r0.a4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f16222e || this.f55756f.f55742e == null) {
                return;
            }
            this.f55756f.f55742e.setVisibility(8);
        }

        @Override // b.a.r0.a4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f55756f.f55743f != null) {
                    this.f55756f.f55743f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55757e;

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
            this.f55757e = videoEffectLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55757e.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoEffectLayout f55758f;

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
            this.f55758f = videoEffectLayout;
        }

        @Override // b.a.r0.a4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f16222e || this.f55758f.f55743f == null) {
                return;
            }
            this.f55758f.f55743f.setVisibility(8);
        }

        @Override // b.a.r0.a4.l.l, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f55758f.f55742e != null) {
                    this.f55758f.f55742e.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface h {
        void onEffectChoosed(b.a.r0.a4.l.d dVar, Object obj);

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

    public b.a.r0.a4.l.d<b.a.r0.a4.a> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : (b.a.r0.a4.l.d) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x : invokeV.intValue;
    }

    public b.a.r0.a4.l.d<String> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : (b.a.r0.a4.l.d) invokeV.objValue;
    }

    public StickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : (StickerItem) invokeV.objValue;
    }

    public boolean isNeedLoadSticker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.l)) {
                return true;
            }
            return this.l.size() == 1 && this.l.get(0).id == -1;
        }
        return invokeV.booleanValue;
    }

    public final void k(String str, b.a.r0.a4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) {
            this.f55746i.add(n(0, 1, str, aVar));
        }
    }

    public final void l(int i2, String str, String str2) {
        List<b.a.r0.a4.l.d> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048582, this, i2, str, str2) == null) || (list = this.j) == null) {
            return;
        }
        list.add(n(i2, 2, str, str2));
    }

    public final void m(List<b.a.r0.a4.l.d> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, str) == null) || list == null) {
            return;
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.f55743f.getVisibility() == 0) {
            cVar.run();
            u(false);
        } else {
            t();
            this.w.postDelayed(cVar, 250L);
        }
    }

    public final <T> b.a.r0.a4.l.d<T> n(int i2, int i3, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, t})) == null) {
            b.a.r0.a4.l.d<T> dVar = new b.a.r0.a4.l.d<>();
            dVar.f(i3);
            dVar.d(i2);
            dVar.e(str);
            dVar.g(t);
            return dVar;
        }
        return (b.a.r0.a4.l.d) invokeCommon.objValue;
    }

    public void notifyStickerDataChanged() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (jVar = this.f55745h) == null) {
            return;
        }
        jVar.notifyDataSetChanged();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f55746i == null) {
            this.f55746i = new ArrayList();
            k("No", b.a.r0.a4.a.b(0));
            k("1", b.a.r0.a4.a.b(1));
            k("2", b.a.r0.a4.a.b(2));
            k("3", b.a.r0.a4.a.b(3));
            k("4", b.a.r0.a4.a.b(4));
            k("5", b.a.r0.a4.a.b(5));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.x = 1;
            o();
            m(this.f55746i, this.m);
        }
    }

    public void onClickCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.x = 2;
            p();
            m(this.j, this.n);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.x = 3;
            m(this.k, this.o);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.x = 0;
            this.f55743f.setAdapter((ListAdapter) this.f55745h);
            this.f55745h.notifyDataSetChanged();
            setListViewSelection(0);
            if (getVisibility() == 0) {
                u(true);
                return;
            }
            this.f55743f.setVisibility(0);
            this.f55742e.setVisibility(8);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.j == null) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? getResources().getText(i2).toString() : (String) invokeI.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.m = "2";
            this.p = n(R.drawable.beauty_icon_avatar_2, 1, "2", b.a.r0.a4.a.b(2));
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

    public void resetEffect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            r();
            b.a.r0.a4.l.c cVar = this.f55744g;
            if (cVar != null) {
                cVar.c();
                this.f55744g.d();
                this.f55744g.e();
            }
            j jVar = this.f55745h;
            if (jVar != null) {
                jVar.d();
            }
        }
    }

    public void resetMusicPos() {
        b.a.r0.a4.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (cVar = this.f55744g) == null) {
            return;
        }
        cVar.e();
        this.o = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.w = new Handler();
            r();
            LinearLayout.inflate(getContext(), R.layout.layout_effect_container, this);
            HListView hListView = (HListView) findViewById(R.id.effect_list_view);
            this.f55742e = hListView;
            hListView.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ds28));
            this.f55742e.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.sticker_list_view);
            this.f55743f = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            b.a.r0.a4.l.c cVar = new b.a.r0.a4.l.c();
            this.f55744g = cVar;
            this.f55742e.setAdapter((ListAdapter) cVar);
            j jVar = new j();
            this.f55745h = jVar;
            this.f55743f.setAdapter((ListAdapter) jVar);
        }
    }

    public void selectCloudMusic() {
        b.a.r0.a4.l.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (cVar = this.f55744g) == null) {
            return;
        }
        cVar.f();
    }

    public void selectStrick(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, stickerItem) == null) {
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
            j jVar = this.f55745h;
            if (jVar != null) {
                jVar.notifyDataSetChanged();
            }
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) || ListUtils.isEmpty(this.l)) {
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
        j jVar = this.f55745h;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, hVar) == null) {
            b.a.r0.a4.l.c cVar = this.f55744g;
            if (cVar != null) {
                cVar.h(new a(this, hVar));
            }
            j jVar = this.f55745h;
            if (jVar != null) {
                jVar.f(new b(this, hVar));
            }
        }
    }

    public void setMusicList(List<b.a.r0.a4.l.d> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            List<b.a.r0.a4.l.d> list2 = this.k;
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
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            this.l = list;
            j jVar = this.f55745h;
            if (jVar != null) {
                jVar.e(list);
                this.f55745h.notifyDataSetChanged();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            AnimatorSet animatorSet = this.u;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.u.cancel();
            }
            if (this.t == null) {
                this.t = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55742e, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f55742e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                this.t.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.f55742e.setVisibility(0);
            this.t.start();
        }
    }

    public final void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
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
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55742e, "alpha", 1.0f, 0.0f);
                    ofFloat.setDuration(300L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f55743f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(200L);
                    ofPropertyValuesHolder.addListener(new e(this));
                    this.u.playSequentially(ofFloat, ofPropertyValuesHolder);
                }
                b.a.e.f.m.e.a().postDelayed(new f(this), 300L);
                this.u.start();
                return;
            }
            AnimatorSet animatorSet3 = this.u;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.u.cancel();
            }
            if (this.v == null) {
                this.v = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f55743f, "alpha", 1.0f, 0.0f);
                ofFloat2.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f55742e, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
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
