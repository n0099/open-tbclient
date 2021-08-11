package com.baidu.tieba.view.widget.recordeffect;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.R;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class RecordEffectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EFFECT_BEAUTY = 1;
    public static final int EFFECT_FILTER = 2;
    public static final int EFFECT_MUSIC = 3;
    public static final int EFFECT_STICKER = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58296e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f58297f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f58298g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.a4.l.e.b.a f58299h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.p0.a4.l.e.b.b f58300i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.p0.a4.l.e.c.b> f58301j;
    public List<c.a.p0.a4.l.e.c.b> k;
    public List<c.a.p0.a4.l.e.c.b> l;
    public List<QmStickerItem> m;
    public String n;
    public String o;
    public String p;
    public c.a.p0.a4.l.e.c.b<c.a.p0.a4.l.e.c.a> q;
    public c.a.p0.a4.l.e.c.b<QmFilterItem> r;
    public c.a.p0.a4.l.e.c.b<MusicData> s;
    public QmStickerItem t;
    public AnimatorSet u;
    public AnimatorSet v;
    public AnimatorSet w;
    public Handler x;
    public int y;
    public i z;

    /* loaded from: classes7.dex */
    public class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f58302a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58303b;

        public a(RecordEffectLayout recordEffectLayout, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58303b = recordEffectLayout;
            this.f58302a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(c.a.p0.a4.l.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) || bVar == null) {
                return;
            }
            i iVar = this.f58302a;
            if (iVar != null) {
                iVar.b(bVar, obj);
            }
            int c2 = bVar.c();
            if (c2 == 1) {
                this.f58303b.n = bVar.b();
                this.f58303b.q = bVar;
            } else if (c2 == 2) {
                this.f58303b.o = ((QmFilterItem) bVar.d()).id;
                this.f58303b.r = bVar;
            } else if (c2 != 3) {
            } else {
                this.f58303b.p = bVar.b();
                this.f58303b.s = bVar;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f58304a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58305b;

        public b(RecordEffectLayout recordEffectLayout, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58305b = recordEffectLayout;
            this.f58304a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) || qmStickerItem == null) {
                return;
            }
            this.f58305b.selectStrick(qmStickerItem);
            i iVar = this.f58304a;
            if (iVar != null) {
                iVar.a(qmStickerItem);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(c.a.p0.a4.l.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f58306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58307f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58308g;

        public c(RecordEffectLayout recordEffectLayout, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58308g = recordEffectLayout;
            this.f58306e = list;
            this.f58307f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58308g.f58299h.h(this.f58306e, this.f58307f);
                this.f58308g.f58299h.notifyDataSetChanged();
                RecordEffectLayout recordEffectLayout = this.f58308g;
                recordEffectLayout.setListViewSelection(recordEffectLayout.p());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58310f;

        public d(RecordEffectLayout recordEffectLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58310f = recordEffectLayout;
            this.f58309e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58310f.f58297f.setSelection(this.f58309e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f58311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58312f;

        public e(RecordEffectLayout recordEffectLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58312f = recordEffectLayout;
            this.f58311e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58312f.f58298g.setSelection(this.f58311e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends c.a.p0.a4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58313f;

        public f(RecordEffectLayout recordEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58313f = recordEffectLayout;
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f15565e || this.f58313f.f58297f == null) {
                return;
            }
            this.f58313f.f58297f.setVisibility(8);
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f58313f.f58298g != null) {
                    this.f58313f.f58298g.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58314e;

        public g(RecordEffectLayout recordEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58314e = recordEffectLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58314e.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends c.a.p0.a4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f58315f;

        public h(RecordEffectLayout recordEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58315f = recordEffectLayout;
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f15565e || this.f58315f.f58298g == null) {
                return;
            }
            this.f58315f.f58298g.setVisibility(8);
        }

        @Override // c.a.p0.a4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f58315f.f58297f != null) {
                    this.f58315f.f58297f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface i {
        void a(QmStickerItem qmStickerItem);

        void b(c.a.p0.a4.l.e.c.b bVar, Object obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordEffectLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i2) == null) {
            this.x.post(new d(this, i2));
        }
    }

    private void setMusicStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            ((RelativeLayout.LayoutParams) this.f58297f.getLayoutParams()).topMargin = UtilHelper.getDimenPixelSize(z ? R.dimen.M_H_X013 : R.dimen.M_H_X008);
            this.f58296e.setVisibility(z ? 0 : 8);
        }
    }

    private void setStickerListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            this.x.post(new e(this, i2));
        }
    }

    public c.a.p0.a4.l.e.c.b<c.a.p0.a4.l.e.c.a> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (c.a.p0.a4.l.e.c.b) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.y : invokeV.intValue;
    }

    public c.a.p0.a4.l.e.c.b<QmFilterItem> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (c.a.p0.a4.l.e.c.b) invokeV.objValue;
    }

    public QmStickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.t : (QmStickerItem) invokeV.objValue;
    }

    public boolean isNeedLoadFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.k)) {
                return true;
            }
            return this.k.size() == 1 && "-1".equals(((QmFilterItem) this.k.get(0).d()).id);
        }
        return invokeV.booleanValue;
    }

    public boolean isNeedLoadSticker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (ListUtils.isEmpty(this.m)) {
                return true;
            }
            return this.m.size() == 1 && this.m.get(0).id == -1;
        }
        return invokeV.booleanValue;
    }

    public final void l(String str, c.a.p0.a4.l.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.f58301j.add(n(0, 1, str, aVar));
        }
    }

    public final void m(List<c.a.p0.a4.l.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, str) == null) || list == null) {
            return;
        }
        if (ListUtils.getCount(list) > 0 && ((c.a.p0.a4.l.e.c.b) ListUtils.getItem(list, 0)).c() == 3) {
            setMusicStyle(true);
        } else {
            setMusicStyle(false);
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.f58298g.getVisibility() == 0) {
            cVar.run();
            v(false);
        } else {
            u();
            this.x.postDelayed(cVar, 260L);
        }
    }

    public final <T> c.a.p0.a4.l.e.c.b<T> n(int i2, int i3, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, t})) == null) {
            c.a.p0.a4.l.e.c.b<T> bVar = new c.a.p0.a4.l.e.c.b<>();
            bVar.g(i3);
            bVar.e(i2);
            bVar.f(str);
            bVar.h(t);
            return bVar;
        }
        return (c.a.p0.a4.l.e.c.b) invokeCommon.objValue;
    }

    public void notifyStickerDataChanged() {
        c.a.p0.a4.l.e.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f58300i) == null) {
            return;
        }
        bVar.notifyDataSetChanged();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f58301j == null) {
            this.f58301j = new ArrayList();
            l("No", c.a.p0.a4.l.e.c.a.b(0));
            l("1", c.a.p0.a4.l.e.c.a.b(1));
            l("2", c.a.p0.a4.l.e.c.a.b(2));
            l("3", c.a.p0.a4.l.e.c.a.b(3));
            l("4", c.a.p0.a4.l.e.c.a.b(4));
            l("5", c.a.p0.a4.l.e.c.a.b(5));
        }
    }

    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.y = 1;
            o();
            m(this.f58301j, this.n);
        }
    }

    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.y = 2;
            m(this.k, this.o);
        }
    }

    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.y = 3;
            m(this.l, this.p);
        }
    }

    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.y = 0;
            this.f58298g.setAdapter((ListAdapter) this.f58300i);
            this.f58300i.notifyDataSetChanged();
            setStickerListViewSelection(p());
            if (getVisibility() == 0) {
                v(true);
                return;
            }
            this.f58298g.setVisibility(0);
            this.f58297f.setVisibility(8);
        }
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.y;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3 && !StringUtils.isNull(this.p)) {
                        for (int i3 = 0; i3 < this.l.size(); i3++) {
                            c.a.p0.a4.l.e.c.b bVar = this.l.get(i3);
                            if (bVar != null && this.o.equals(bVar.b())) {
                                return i3;
                            }
                        }
                    }
                } else if (!StringUtils.isNull(this.o)) {
                    for (int i4 = 0; i4 < this.k.size(); i4++) {
                        c.a.p0.a4.l.e.c.b bVar2 = this.k.get(i4);
                        if (bVar2 != null && (bVar2.d() instanceof QmFilterItem) && this.o.equals(((QmFilterItem) bVar2.d()).id)) {
                            int i5 = i4 - 2;
                            return (i5 < 0 || i4 + 2 > this.k.size()) ? i4 : i5;
                        }
                    }
                }
            } else if (this.t != null) {
                for (int i6 = 0; i6 < this.m.size(); i6++) {
                    QmStickerItem qmStickerItem = this.m.get(i6);
                    if (qmStickerItem != null && this.t.id == qmStickerItem.id) {
                        int i7 = i6 / 2;
                        int i8 = i7 - 2;
                        return (i8 < 0 || i7 + 2 > this.m.size() / 2) ? i7 : i8;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int q(List<c.a.p0.a4.l.e.c.b> list, QmFilterItem qmFilterItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, list, qmFilterItem)) == null) {
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.id) || ListUtils.isEmpty(list)) {
                return -1;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.a.p0.a4.l.e.c.b bVar = list.get(i2);
                if (bVar.d() != null && qmFilterItem.id.equals(((QmFilterItem) bVar.d()).id)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final String r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? getResources().getText(i2).toString() : (String) invokeI.objValue;
    }

    public void resetEffect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            s();
            c.a.p0.a4.l.e.b.a aVar = this.f58299h;
            if (aVar != null) {
                aVar.c();
                this.f58299h.d();
                this.f58299h.e();
            }
            c.a.p0.a4.l.e.b.b bVar = this.f58300i;
            if (bVar != null) {
                bVar.d();
            }
            setMusicName(TbadkCoreApplication.getInst().getString(R.string.music_normal), "");
        }
    }

    public void resetMusicPos() {
        c.a.p0.a4.l.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (aVar = this.f58299h) == null) {
            return;
        }
        aVar.e();
        this.p = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.n = "2";
            this.q = n(R.drawable.beauty_icon_avatar_2, 1, "2", c.a.p0.a4.l.e.c.a.b(2));
            this.o = "-1";
            QmFilterItem qmFilterItem = new QmFilterItem();
            qmFilterItem.id = "-1";
            qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
            qmFilterItem.name = getResources().getString(R.string.filter_nature);
            qmFilterItem.isSelect = true;
            qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
            this.r = n(R.drawable.icon_pure_video_lvjing_on, 2, r(R.string.filter_nature), qmFilterItem);
            this.k = new ArrayList();
            QmStickerItem qmStickerItem = new QmStickerItem();
            qmStickerItem.id = -1;
            qmStickerItem.isLocalSource = true;
            qmStickerItem.localPath = "nosticker";
            this.t = qmStickerItem;
            this.p = getResources().getString(R.string.music_normal);
            getResources().getString(R.string.music_normal);
            new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal));
        }
    }

    public void selectAfterFilter() {
        int q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (q = q(this.k, this.r.d())) < 0) {
            return;
        }
        int i2 = q + 1;
        if (i2 > this.k.size() - 1) {
            i2 = 0;
        }
        c.a.p0.a4.l.e.c.b<QmFilterItem> bVar = this.k.get(i2);
        if (bVar == null) {
            return;
        }
        if (bVar.c() == 2) {
            i iVar = this.z;
            if (iVar != null) {
                iVar.b(bVar, null);
            }
            this.o = bVar.d().id;
            this.r = bVar;
        }
        if (this.f58299h == null || getCurrentEffectLayout() != 2) {
            return;
        }
        this.f58299h.g(bVar.d().id);
        this.f58299h.notifyDataSetChanged();
    }

    public void selectBeforeFilter() {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (indexOf = this.k.indexOf(this.r)) < 0) {
            return;
        }
        c.a.p0.a4.l.e.c.b<QmFilterItem> bVar = this.k.get(indexOf + (-1) < 0 ? 0 : indexOf - 1);
        if (bVar == null) {
            return;
        }
        if (bVar.c() == 2) {
            i iVar = this.z;
            if (iVar != null) {
                iVar.b(bVar, null);
            }
            this.o = bVar.d().id;
            this.r = bVar;
        }
        if (this.f58299h == null || getCurrentEffectLayout() != 2) {
            return;
        }
        this.f58299h.g(bVar.d().id);
        this.f58299h.notifyDataSetChanged();
    }

    public void selectCloudMusic(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, tbMusicData) == null) || this.f58299h == null) {
            return;
        }
        if (tbMusicData != null) {
            setMusicName(tbMusicData.title, tbMusicData.icon);
        }
        this.f58299h.f(tbMusicData);
    }

    public void selectFilter(c.a.p0.a4.l.e.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.r = bVar;
            if (ListUtils.isEmpty(this.k) || bVar == null || !(bVar.d() instanceof QmFilterItem)) {
                return;
            }
            QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
            if (!StringUtils.isNull(qmFilterItem.id)) {
                for (c.a.p0.a4.l.e.c.b bVar2 : this.k) {
                    if (bVar2 != null && (bVar2.d() instanceof QmFilterItem)) {
                        if (!qmFilterItem.id.equals(((QmFilterItem) bVar2.d()).id)) {
                            qmFilterItem.isSelect = false;
                        } else {
                            qmFilterItem.isSelect = true;
                        }
                    }
                }
            }
            c.a.p0.a4.l.e.b.a aVar = this.f58299h;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void selectStrick(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, qmStickerItem) == null) {
            this.t = qmStickerItem;
            if (ListUtils.isEmpty(this.m) || qmStickerItem == null) {
                return;
            }
            for (QmStickerItem qmStickerItem2 : this.m) {
                if (qmStickerItem2.id != qmStickerItem.id) {
                    qmStickerItem2.isSelect = false;
                } else {
                    qmStickerItem2.isSelect = true;
                }
            }
            c.a.p0.a4.l.e.b.b bVar = this.f58300i;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    public void setCurrentMusicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.p = str;
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, qmFilterItem) == null) || ListUtils.isEmpty(this.k)) {
            return;
        }
        if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.id)) {
            for (c.a.p0.a4.l.e.c.b bVar : this.k) {
                if (bVar.d() instanceof QmFilterItem) {
                    QmFilterItem qmFilterItem2 = (QmFilterItem) bVar.d();
                    if (!qmFilterItem.id.equals(qmFilterItem2.id)) {
                        qmFilterItem2.isDownLoading = false;
                    } else {
                        qmFilterItem2.isDownLoading = true;
                    }
                }
            }
        } else {
            for (c.a.p0.a4.l.e.c.b bVar2 : this.k) {
                if (bVar2.d() instanceof QmFilterItem) {
                    ((QmFilterItem) bVar2.d()).isDownLoading = false;
                }
            }
        }
        c.a.p0.a4.l.e.b.a aVar = this.f58299h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void setDownLoadStrick(QmStickerItem qmStickerItem, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048604, this, qmStickerItem, z) == null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        if (qmStickerItem != null) {
            for (QmStickerItem qmStickerItem2 : this.m) {
                if (qmStickerItem2.id != qmStickerItem.id) {
                    qmStickerItem2.isDownLoading = false;
                } else if (!z) {
                    qmStickerItem2.isDownLoading = true;
                } else {
                    qmStickerItem2.isDownLoading = false;
                    qmStickerItem2.isLocalSource = true;
                }
            }
        } else {
            for (QmStickerItem qmStickerItem3 : this.m) {
                qmStickerItem3.isDownLoading = false;
            }
        }
        c.a.p0.a4.l.e.b.b bVar = this.f58300i;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void setFilterList(List<c.a.p0.a4.l.e.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            List<c.a.p0.a4.l.e.c.b> list2 = this.k;
            if (list2 == null) {
                this.k = new ArrayList();
            } else {
                list2.clear();
            }
            this.k.addAll(list);
        }
    }

    public void setListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, iVar) == null) {
            this.z = iVar;
            c.a.p0.a4.l.e.b.a aVar = this.f58299h;
            if (aVar != null) {
                aVar.i(new a(this, iVar));
            }
            c.a.p0.a4.l.e.b.b bVar = this.f58300i;
            if (bVar != null) {
                bVar.f(new b(this, iVar));
            }
        }
    }

    public void setMusicList(List<c.a.p0.a4.l.e.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            List<c.a.p0.a4.l.e.c.b> list2 = this.l;
            if (list2 == null) {
                this.l = new ArrayList();
            } else {
                list2.clear();
            }
            this.l.addAll(list);
        }
    }

    public void setMusicName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                TextView textView = this.f58296e;
                textView.setText(getContext().getString(R.string.capture_selected_music) + str);
            }
            c.a.p0.a4.l.e.b.a aVar = this.f58299h;
            if (aVar != null) {
                aVar.j(str2);
            }
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            this.m = list;
            c.a.p0.a4.l.e.b.b bVar = this.f58300i;
            if (bVar != null) {
                bVar.e(list);
                this.f58300i.notifyDataSetChanged();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.x = new Handler();
            s();
            RelativeLayout.inflate(getContext(), R.layout.layout_capture_effect_container, this);
            TextView textView = (TextView) findViewById(R.id.music_name_view);
            this.f58296e = textView;
            textView.setText(getResources().getString(R.string.capture_selected_music) + getResources().getString(R.string.music_normal));
            HListView hListView = (HListView) findViewById(R.id.effect_list_view);
            this.f58297f = hListView;
            hListView.setDividerWidth(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.f58297f.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            this.f58297f.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.sticker_list_view);
            this.f58298g = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            c.a.p0.a4.l.e.b.a aVar = new c.a.p0.a4.l.e.b.a();
            this.f58299h = aVar;
            this.f58297f.setAdapter((ListAdapter) aVar);
            c.a.p0.a4.l.e.b.b bVar = new c.a.p0.a4.l.e.b.b();
            this.f58300i = bVar;
            this.f58298g.setAdapter((ListAdapter) bVar);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            AnimatorSet animatorSet = this.v;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.v.cancel();
            }
            if (this.u == null) {
                this.u = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58297f, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f58297f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(320L);
                this.u.playTogether(ofFloat, ofPropertyValuesHolder);
            }
            this.f58297f.setVisibility(0);
            this.u.start();
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            if (z) {
                setMusicStyle(false);
                AnimatorSet animatorSet = this.w;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.w.cancel();
                }
                AnimatorSet animatorSet2 = this.u;
                if (animatorSet2 != null && animatorSet2.isRunning()) {
                    this.u.cancel();
                }
                if (this.v == null) {
                    this.v = new AnimatorSet();
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58297f, "alpha", 1.0f, 0.0f);
                    ofFloat.setDuration(260L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f58298g, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(320L);
                    ofPropertyValuesHolder.addListener(new f(this));
                    this.v.playTogether(ofFloat, ofPropertyValuesHolder);
                }
                c.a.e.e.m.e.a().postDelayed(new g(this), 300L);
                this.v.start();
                return;
            }
            AnimatorSet animatorSet3 = this.v;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.v.cancel();
            }
            if (this.w == null) {
                this.w = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f58298g, "alpha", 1.0f, 0.0f);
                ofFloat2.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f58297f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder2.setDuration(320L);
                ofPropertyValuesHolder2.addListener(new h(this));
                this.w.playTogether(ofFloat2, ofPropertyValuesHolder2);
            }
            this.w.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordEffectLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordEffectLayout(Context context, AttributeSet attributeSet, int i2) {
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
        t();
    }
}
