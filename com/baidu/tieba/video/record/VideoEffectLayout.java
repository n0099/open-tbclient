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
import com.repackage.as8;
import com.repackage.qg;
import com.repackage.rr8;
import com.repackage.sr8;
import com.repackage.wp8;
import com.repackage.yr8;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoEffectLayout extends LinearLayout implements VideoEffectButtonLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;
    public HListView b;
    public rr8 c;
    public yr8 d;
    public List<sr8> e;
    public List<sr8> f;
    public List<sr8> g;
    public List<StickerItem> h;
    public String i;
    public String j;
    public String k;
    public sr8<wp8> l;
    public sr8<String> m;
    public sr8<MusicData> n;
    public StickerItem o;
    public AnimatorSet p;
    public AnimatorSet q;
    public AnimatorSet r;
    public Handler s;
    public int t;

    /* loaded from: classes4.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ VideoEffectLayout b;

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
        public void j1(sr8 sr8Var, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, sr8Var, obj) == null) || sr8Var == null) {
                return;
            }
            h hVar = this.a;
            if (hVar != null) {
                hVar.j1(sr8Var, obj);
            }
            int type = sr8Var.getType();
            if (type == 1) {
                this.b.i = sr8Var.b();
                this.b.l = sr8Var;
            } else if (type == 2) {
                this.b.j = sr8Var.b();
                this.b.m = sr8Var;
            } else if (type != 3) {
            } else {
                this.b.k = sr8Var.b();
                this.b.n = sr8Var;
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void x1(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;
        public final /* synthetic */ VideoEffectLayout b;

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
        public void j1(sr8 sr8Var, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, sr8Var, obj) == null) {
            }
        }

        @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
        public void x1(StickerItem stickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stickerItem) == null) || stickerItem == null) {
                return;
            }
            this.b.x(stickerItem);
            h hVar = this.a;
            if (hVar != null) {
                hVar.x1(stickerItem);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class e extends as8 {
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

        @Override // com.repackage.as8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a || this.b.a == null) {
                return;
            }
            this.b.a.setVisibility(8);
        }

        @Override // com.repackage.as8, android.animation.Animator.AnimatorListener
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class g extends as8 {
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

        @Override // com.repackage.as8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a || this.b.b == null) {
                return;
            }
            this.b.b.setVisibility(8);
        }

        @Override // com.repackage.as8, android.animation.Animator.AnimatorListener
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

    /* loaded from: classes4.dex */
    public interface h {
        void j1(sr8 sr8Var, Object obj);

        void x1(StickerItem stickerItem);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            this.s.post(new d(this, i));
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.t = 3;
            m(this.g, this.k);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.t = 2;
            p();
            m(this.f, this.j);
        }
    }

    public sr8<wp8> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : (sr8) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : invokeV.intValue;
    }

    public sr8<String> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (sr8) invokeV.objValue;
    }

    public StickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : (StickerItem) invokeV.objValue;
    }

    public final void k(String str, wp8 wp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, wp8Var) == null) {
            this.e.add(n(0, 1, str, wp8Var));
        }
    }

    public final void l(int i, String str, String str2) {
        List<sr8> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i, str, str2) == null) || (list = this.f) == null) {
            return;
        }
        list.add(n(i, 2, str, str2));
    }

    public final void m(List<sr8> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) || list == null) {
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

    public final <T> sr8<T> n(int i, int i2, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, t})) == null) {
            sr8<T> sr8Var = new sr8<>();
            sr8Var.f(i2);
            sr8Var.d(i);
            sr8Var.e(str);
            sr8Var.g(t);
            return sr8Var;
        }
        return (sr8) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.t = 1;
            o();
            m(this.e, this.i);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e == null) {
            this.e = new ArrayList();
            k("No", wp8.b(0));
            k("1", wp8.b(1));
            k("2", wp8.b(2));
            k("3", wp8.b(3));
            k("4", wp8.b(4));
            k("5", wp8.b(5));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f == null) {
            this.f = new ArrayList();
            l(R.drawable.obfuscated_res_0x7f080559, q(R.string.obfuscated_res_0x7f0f0618), "origin");
            l(R.drawable.obfuscated_res_0x7f08055d, q(R.string.obfuscated_res_0x7f0f0615), "hongkong");
            l(R.drawable.obfuscated_res_0x7f080560, q(R.string.obfuscated_res_0x7f0f0619), "refreshing");
            l(R.drawable.obfuscated_res_0x7f08055c, q(R.string.obfuscated_res_0x7f0f0613), "girly");
            l(R.drawable.obfuscated_res_0x7f080557, q(R.string.obfuscated_res_0x7f0f0610), "concrete");
            l(R.drawable.obfuscated_res_0x7f080564, q(R.string.obfuscated_res_0x7f0f061d), "warm");
            l(R.drawable.obfuscated_res_0x7f080556, q(R.string.obfuscated_res_0x7f0f060f), "cold");
            l(R.drawable.obfuscated_res_0x7f08055e, q(R.string.obfuscated_res_0x7f0f0616), "Japanese");
            l(R.drawable.obfuscated_res_0x7f080558, q(R.string.obfuscated_res_0x7f0f0614), "cruz");
            l(R.drawable.obfuscated_res_0x7f080553, q(R.string.obfuscated_res_0x7f0f060c), "abao");
            l(R.drawable.obfuscated_res_0x7f08055a, q(R.string.obfuscated_res_0x7f0f0611), "dew");
            l(R.drawable.obfuscated_res_0x7f080562, q(R.string.obfuscated_res_0x7f0f061b), "slowlived");
            l(R.drawable.obfuscated_res_0x7f080563, q(R.string.obfuscated_res_0x7f0f061c), "sweet");
            l(R.drawable.obfuscated_res_0x7f080555, q(R.string.obfuscated_res_0x7f0f060e), "boardwalk");
            l(R.drawable.obfuscated_res_0x7f08055f, q(R.string.obfuscated_res_0x7f0f0617), "keylime");
            l(R.drawable.obfuscated_res_0x7f08055b, q(R.string.obfuscated_res_0x7f0f0612), "electric");
            l(R.drawable.obfuscated_res_0x7f080561, q(R.string.obfuscated_res_0x7f0f061a), "silver");
            l(R.drawable.obfuscated_res_0x7f080554, q(R.string.obfuscated_res_0x7f0f060d), "blackwhite");
        }
    }

    public final String q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) ? getResources().getText(i).toString() : (String) invokeI.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = "2";
            this.l = n(R.drawable.obfuscated_res_0x7f08022f, 1, "2", wp8.b(2));
            this.j = q(R.string.obfuscated_res_0x7f0f0618);
            this.m = n(R.drawable.obfuscated_res_0x7f080559, 2, q(R.string.obfuscated_res_0x7f0f0618), "origin");
            StickerItem stickerItem = new StickerItem();
            stickerItem.id = -1;
            stickerItem.name = "nosticker";
            this.o = stickerItem;
            this.k = getResources().getString(R.string.obfuscated_res_0x7f0f0b06);
            getResources().getString(R.string.obfuscated_res_0x7f0f0b06);
            new MusicData(com.baidu.tieba.external.music.data.MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0b06));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.s = new Handler();
            r();
            LinearLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d048c, this);
            HListView hListView = (HListView) findViewById(R.id.obfuscated_res_0x7f09083e);
            this.a = hListView;
            hListView.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9));
            this.a.setSelector(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811a8));
            HListView hListView2 = (HListView) findViewById(R.id.obfuscated_res_0x7f091e41);
            this.b = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0811a8));
            rr8 rr8Var = new rr8();
            this.c = rr8Var;
            this.a.setAdapter((ListAdapter) rr8Var);
            yr8 yr8Var = new yr8();
            this.d = yr8Var;
            this.b.setAdapter((ListAdapter) yr8Var);
        }
    }

    public void setDownLoadStrick(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, stickerItem) == null) || ListUtils.isEmpty(this.h)) {
            return;
        }
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
        yr8 yr8Var = this.d;
        if (yr8Var != null) {
            yr8Var.notifyDataSetChanged();
        }
    }

    public void setListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, hVar) == null) {
            rr8 rr8Var = this.c;
            if (rr8Var != null) {
                rr8Var.f(new a(this, hVar));
            }
            yr8 yr8Var = this.d;
            if (yr8Var != null) {
                yr8Var.e(new b(this, hVar));
            }
        }
    }

    public void setMusicList(List<sr8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            List<sr8> list2 = this.g;
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
            yr8 yr8Var = this.d;
            if (yr8Var != null) {
                yr8Var.d(list);
                this.d.notifyDataSetChanged();
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
            return this.h.size() == 1 && this.h.get(0).id == -1;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        rr8 rr8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (rr8Var = this.c) == null) {
            return;
        }
        rr8Var.c();
        this.k = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b06);
    }

    public void v() {
        rr8 rr8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (rr8Var = this.c) == null) {
            return;
        }
        rr8Var.d();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
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

    public void x(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, stickerItem) == null) {
            this.o = stickerItem;
            if (ListUtils.isEmpty(this.h) || stickerItem == null) {
                return;
            }
            for (StickerItem stickerItem2 : this.h) {
                if (stickerItem2.id != stickerItem.id) {
                    stickerItem2.isSelect = false;
                } else {
                    stickerItem2.isSelect = true;
                }
            }
            yr8 yr8Var = this.d;
            if (yr8Var != null) {
                yr8Var.notifyDataSetChanged();
            }
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.a, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(200L);
                this.p.playSequentially(ofFloat, ofPropertyValuesHolder);
            }
            this.a.setVisibility(0);
            this.p.start();
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
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", 1.0f, 0.0f);
                    ofFloat.setDuration(300L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(200L);
                    ofPropertyValuesHolder.addListener(new e(this));
                    this.q.playSequentially(ofFloat, ofPropertyValuesHolder);
                }
                qg.a().postDelayed(new f(this), 300L);
                this.q.start();
                return;
            }
            AnimatorSet animatorSet3 = this.q;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.q.cancel();
            }
            if (this.r == null) {
                this.r = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "alpha", 1.0f, 0.0f);
                ofFloat2.setDuration(300L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.a, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder2.setDuration(200L);
                ofPropertyValuesHolder2.addListener(new g(this));
                this.r.playSequentially(ofFloat2, ofPropertyValuesHolder2);
            }
            this.r.start();
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
}
