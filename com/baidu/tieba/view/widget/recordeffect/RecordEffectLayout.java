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
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class RecordEffectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EFFECT_BEAUTY = 1;
    public static final int EFFECT_FILTER = 2;
    public static final int EFFECT_MUSIC = 3;
    public static final int EFFECT_STICKER = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55717e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f55718f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f55719g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.c4.l.e.b.a f55720h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.c4.l.e.b.b f55721i;
    public List<b.a.r0.c4.l.e.c.b> j;
    public List<b.a.r0.c4.l.e.c.b> k;
    public List<b.a.r0.c4.l.e.c.b> l;
    public List<QmStickerItem> m;
    public String n;
    public String o;
    public String p;
    public b.a.r0.c4.l.e.c.b<b.a.r0.c4.l.e.c.a> q;
    public b.a.r0.c4.l.e.c.b<QmFilterItem> r;
    public b.a.r0.c4.l.e.c.b<MusicData> s;
    public QmStickerItem t;
    public AnimatorSet u;
    public AnimatorSet v;
    public AnimatorSet w;
    public Handler x;
    public int y;
    public i z;

    /* loaded from: classes9.dex */
    public class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f55722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55723b;

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
            this.f55723b = recordEffectLayout;
            this.f55722a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(b.a.r0.c4.l.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) || bVar == null) {
                return;
            }
            i iVar = this.f55722a;
            if (iVar != null) {
                iVar.b(bVar, obj);
            }
            int type = bVar.getType();
            if (type == 1) {
                this.f55723b.n = bVar.b();
                this.f55723b.q = bVar;
            } else if (type == 2) {
                this.f55723b.o = ((QmFilterItem) bVar.c()).id;
                this.f55723b.r = bVar;
            } else if (type != 3) {
            } else {
                this.f55723b.p = bVar.b();
                this.f55723b.s = bVar;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f55724a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55725b;

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
            this.f55725b = recordEffectLayout;
            this.f55724a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) || qmStickerItem == null) {
                return;
            }
            this.f55725b.selectStrick(qmStickerItem);
            i iVar = this.f55724a;
            if (iVar != null) {
                iVar.a(qmStickerItem);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(b.a.r0.c4.l.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f55726e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55727f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55728g;

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
            this.f55728g = recordEffectLayout;
            this.f55726e = list;
            this.f55727f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55728g.f55720h.h(this.f55726e, this.f55727f);
                this.f55728g.f55720h.notifyDataSetChanged();
                RecordEffectLayout recordEffectLayout = this.f55728g;
                recordEffectLayout.setListViewSelection(recordEffectLayout.p());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55730f;

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
            this.f55730f = recordEffectLayout;
            this.f55729e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55730f.f55718f.setSelection(this.f55729e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f55731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55732f;

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
            this.f55732f = recordEffectLayout;
            this.f55731e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55732f.f55719g.setSelection(this.f55731e);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends b.a.r0.c4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55733f;

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
            this.f55733f = recordEffectLayout;
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f15566e || this.f55733f.f55718f == null) {
                return;
            }
            this.f55733f.f55718f.setVisibility(8);
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f55733f.f55719g != null) {
                    this.f55733f.f55719g.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55734e;

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
            this.f55734e = recordEffectLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55734e.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends b.a.r0.c4.l.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f55735f;

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
            this.f55735f = recordEffectLayout;
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f15566e || this.f55735f.f55719g == null) {
                return;
            }
            this.f55735f.f55719g.setVisibility(8);
        }

        @Override // b.a.r0.c4.l.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f55735f.f55718f != null) {
                    this.f55735f.f55718f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface i {
        void a(QmStickerItem qmStickerItem);

        void b(b.a.r0.c4.l.e.c.b bVar, Object obj);
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
            ((RelativeLayout.LayoutParams) this.f55718f.getLayoutParams()).topMargin = UtilHelper.getDimenPixelSize(z ? R.dimen.M_H_X013 : R.dimen.M_H_X008);
            this.f55717e.setVisibility(z ? 0 : 8);
        }
    }

    private void setStickerListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            this.x.post(new e(this, i2));
        }
    }

    public b.a.r0.c4.l.e.c.b<b.a.r0.c4.l.e.c.a> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q : (b.a.r0.c4.l.e.c.b) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.y : invokeV.intValue;
    }

    public b.a.r0.c4.l.e.c.b<QmFilterItem> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.r : (b.a.r0.c4.l.e.c.b) invokeV.objValue;
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
            return this.k.size() == 1 && "-1".equals(((QmFilterItem) this.k.get(0).c()).id);
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

    public final void l(String str, b.a.r0.c4.l.e.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) {
            this.j.add(n(0, 1, str, aVar));
        }
    }

    public final void m(List<b.a.r0.c4.l.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, list, str) == null) || list == null) {
            return;
        }
        if (ListUtils.getCount(list) > 0 && ((b.a.r0.c4.l.e.c.b) ListUtils.getItem(list, 0)).getType() == 3) {
            setMusicStyle(true);
        } else {
            setMusicStyle(false);
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.f55719g.getVisibility() == 0) {
            cVar.run();
            v(false);
        } else {
            u();
            this.x.postDelayed(cVar, 260L);
        }
    }

    public final <T> b.a.r0.c4.l.e.c.b<T> n(int i2, int i3, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, t})) == null) {
            b.a.r0.c4.l.e.c.b<T> bVar = new b.a.r0.c4.l.e.c.b<>();
            bVar.f(i3);
            bVar.d(i2);
            bVar.e(str);
            bVar.g(t);
            return bVar;
        }
        return (b.a.r0.c4.l.e.c.b) invokeCommon.objValue;
    }

    public void notifyStickerDataChanged() {
        b.a.r0.c4.l.e.b.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f55721i) == null) {
            return;
        }
        bVar.notifyDataSetChanged();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.j == null) {
            this.j = new ArrayList();
            l("No", b.a.r0.c4.l.e.c.a.b(0));
            l("1", b.a.r0.c4.l.e.c.a.b(1));
            l("2", b.a.r0.c4.l.e.c.a.b(2));
            l("3", b.a.r0.c4.l.e.c.a.b(3));
            l("4", b.a.r0.c4.l.e.c.a.b(4));
            l("5", b.a.r0.c4.l.e.c.a.b(5));
        }
    }

    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.y = 1;
            o();
            m(this.j, this.n);
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
            this.f55719g.setAdapter((ListAdapter) this.f55721i);
            this.f55721i.notifyDataSetChanged();
            setStickerListViewSelection(p());
            if (getVisibility() == 0) {
                v(true);
                return;
            }
            this.f55719g.setVisibility(0);
            this.f55718f.setVisibility(8);
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
                            b.a.r0.c4.l.e.c.b bVar = this.l.get(i3);
                            if (bVar != null && TextUtils.equals(this.o, bVar.b())) {
                                return i3;
                            }
                        }
                    }
                } else if (!StringUtils.isNull(this.o)) {
                    for (int i4 = 0; i4 < this.k.size(); i4++) {
                        b.a.r0.c4.l.e.c.b bVar2 = this.k.get(i4);
                        if (bVar2 != null && (bVar2.c() instanceof QmFilterItem) && this.o.equals(((QmFilterItem) bVar2.c()).id)) {
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

    public final int q(List<b.a.r0.c4.l.e.c.b> list, QmFilterItem qmFilterItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, list, qmFilterItem)) == null) {
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.id) || ListUtils.isEmpty(list)) {
                return -1;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b.a.r0.c4.l.e.c.b bVar = list.get(i2);
                if (bVar.c() != null && qmFilterItem.id.equals(((QmFilterItem) bVar.c()).id)) {
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
            b.a.r0.c4.l.e.b.a aVar = this.f55720h;
            if (aVar != null) {
                aVar.c();
                this.f55720h.d();
                this.f55720h.e();
            }
            b.a.r0.c4.l.e.b.b bVar = this.f55721i;
            if (bVar != null) {
                bVar.d();
            }
            setMusicName(TbadkCoreApplication.getInst().getString(R.string.music_normal), "");
        }
    }

    public void resetMusicPos() {
        b.a.r0.c4.l.e.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (aVar = this.f55720h) == null) {
            return;
        }
        aVar.e();
        this.p = TbadkCoreApplication.getInst().getString(R.string.music_normal);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.n = "2";
            this.q = n(R.drawable.beauty_icon_avatar_2, 1, "2", b.a.r0.c4.l.e.c.a.b(2));
            this.o = "-1";
            QmFilterItem qmFilterItem = new QmFilterItem();
            qmFilterItem.id = "-1";
            qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
            qmFilterItem.name = getResources().getString(R.string.filter_nature);
            qmFilterItem.isSelect = true;
            qmFilterItem.localPath = "origin";
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
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (q = q(this.k, this.r.c())) < 0) {
            return;
        }
        int i2 = q + 1;
        if (i2 > this.k.size() - 1) {
            i2 = 0;
        }
        b.a.r0.c4.l.e.c.b<QmFilterItem> bVar = this.k.get(i2);
        if (bVar == null) {
            return;
        }
        if (bVar.getType() == 2) {
            i iVar = this.z;
            if (iVar != null) {
                iVar.b(bVar, null);
            }
            this.o = bVar.c().id;
            this.r = bVar;
        }
        if (this.f55720h == null || getCurrentEffectLayout() != 2) {
            return;
        }
        this.f55720h.g(bVar.c().id);
        this.f55720h.notifyDataSetChanged();
    }

    public void selectBeforeFilter() {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (indexOf = this.k.indexOf(this.r)) < 0) {
            return;
        }
        b.a.r0.c4.l.e.c.b<QmFilterItem> bVar = this.k.get(indexOf + (-1) < 0 ? 0 : indexOf - 1);
        if (bVar == null) {
            return;
        }
        if (bVar.getType() == 2) {
            i iVar = this.z;
            if (iVar != null) {
                iVar.b(bVar, null);
            }
            this.o = bVar.c().id;
            this.r = bVar;
        }
        if (this.f55720h == null || getCurrentEffectLayout() != 2) {
            return;
        }
        this.f55720h.g(bVar.c().id);
        this.f55720h.notifyDataSetChanged();
    }

    public void selectCloudMusic(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, tbMusicData) == null) || this.f55720h == null) {
            return;
        }
        if (tbMusicData != null) {
            setMusicName(tbMusicData.title, tbMusicData.icon);
        }
        this.f55720h.f(tbMusicData);
    }

    public void selectFilter(b.a.r0.c4.l.e.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.r = bVar;
            if (ListUtils.isEmpty(this.k) || bVar == null || !(bVar.c() instanceof QmFilterItem)) {
                return;
            }
            QmFilterItem qmFilterItem = (QmFilterItem) bVar.c();
            if (!StringUtils.isNull(qmFilterItem.id)) {
                for (b.a.r0.c4.l.e.c.b bVar2 : this.k) {
                    if (bVar2 != null && (bVar2.c() instanceof QmFilterItem)) {
                        if (!qmFilterItem.id.equals(((QmFilterItem) bVar2.c()).id)) {
                            qmFilterItem.isSelect = false;
                        } else {
                            qmFilterItem.isSelect = true;
                        }
                    }
                }
            }
            b.a.r0.c4.l.e.b.a aVar = this.f55720h;
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
            b.a.r0.c4.l.e.b.b bVar = this.f55721i;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    public void setCurrentFilterWithQmFilterItem(@NonNull QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, qmFilterItem) == null) {
            this.o = qmFilterItem.id;
            this.r = n(b.a.e.e.m.b.e(qmFilterItem.bgurl, 0), 2, qmFilterItem.name, qmFilterItem);
        }
    }

    public void setCurrentMusicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.p = str;
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, qmFilterItem) == null) || ListUtils.isEmpty(this.k)) {
            return;
        }
        if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.id)) {
            for (b.a.r0.c4.l.e.c.b bVar : this.k) {
                if (bVar.c() instanceof QmFilterItem) {
                    QmFilterItem qmFilterItem2 = (QmFilterItem) bVar.c();
                    if (!qmFilterItem.id.equals(qmFilterItem2.id)) {
                        qmFilterItem2.isDownLoading = false;
                    } else {
                        qmFilterItem2.isDownLoading = true;
                    }
                }
            }
        } else {
            for (b.a.r0.c4.l.e.c.b bVar2 : this.k) {
                if (bVar2.c() instanceof QmFilterItem) {
                    ((QmFilterItem) bVar2.c()).isDownLoading = false;
                }
            }
        }
        b.a.r0.c4.l.e.b.a aVar = this.f55720h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void setDownLoadStrick(QmStickerItem qmStickerItem, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048605, this, qmStickerItem, z) == null) || ListUtils.isEmpty(this.m)) {
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
        b.a.r0.c4.l.e.b.b bVar = this.f55721i;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void setFilterList(List<b.a.r0.c4.l.e.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            List<b.a.r0.c4.l.e.c.b> list2 = this.k;
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
        if (interceptable == null || interceptable.invokeL(1048607, this, iVar) == null) {
            this.z = iVar;
            b.a.r0.c4.l.e.b.a aVar = this.f55720h;
            if (aVar != null) {
                aVar.i(new a(this, iVar));
            }
            b.a.r0.c4.l.e.b.b bVar = this.f55721i;
            if (bVar != null) {
                bVar.f(new b(this, iVar));
            }
        }
    }

    public void setMusicList(List<b.a.r0.c4.l.e.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            List<b.a.r0.c4.l.e.c.b> list2 = this.l;
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
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                TextView textView = this.f55717e;
                textView.setText(getContext().getString(R.string.capture_selected_music) + str);
            }
            b.a.r0.c4.l.e.b.a aVar = this.f55720h;
            if (aVar != null) {
                aVar.j(str2);
            }
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, list) == null) {
            this.m = list;
            b.a.r0.c4.l.e.b.b bVar = this.f55721i;
            if (bVar != null) {
                bVar.e(list);
                this.f55721i.notifyDataSetChanged();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.x = new Handler();
            s();
            RelativeLayout.inflate(getContext(), R.layout.layout_capture_effect_container, this);
            TextView textView = (TextView) findViewById(R.id.music_name_view);
            this.f55717e = textView;
            textView.setText(getResources().getString(R.string.capture_selected_music) + getResources().getString(R.string.music_normal));
            HListView hListView = (HListView) findViewById(R.id.effect_list_view);
            this.f55718f = hListView;
            hListView.setDividerWidth(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.f55718f.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            this.f55718f.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.sticker_list_view);
            this.f55719g = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            b.a.r0.c4.l.e.b.a aVar = new b.a.r0.c4.l.e.b.a();
            this.f55720h = aVar;
            this.f55718f.setAdapter((ListAdapter) aVar);
            b.a.r0.c4.l.e.b.b bVar = new b.a.r0.c4.l.e.b.b();
            this.f55721i = bVar;
            this.f55719g.setAdapter((ListAdapter) bVar);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            AnimatorSet animatorSet = this.v;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.v.cancel();
            }
            if (this.u == null) {
                this.u = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55718f, Key.ALPHA, 1.0f, 0.0f);
                ofFloat.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f55718f, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(320L);
                this.u.playTogether(ofFloat, ofPropertyValuesHolder);
            }
            this.f55718f.setVisibility(0);
            this.u.start();
        }
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
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
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f55718f, Key.ALPHA, 1.0f, 0.0f);
                    ofFloat.setDuration(260L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f55719g, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(320L);
                    ofPropertyValuesHolder.addListener(new f(this));
                    this.v.playTogether(ofFloat, ofPropertyValuesHolder);
                }
                b.a.e.e.m.e.a().postDelayed(new g(this), 300L);
                this.v.start();
                return;
            }
            AnimatorSet animatorSet3 = this.v;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.v.cancel();
            }
            if (this.w == null) {
                this.w = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f55719g, Key.ALPHA, 1.0f, 0.0f);
                ofFloat2.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f55718f, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
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
