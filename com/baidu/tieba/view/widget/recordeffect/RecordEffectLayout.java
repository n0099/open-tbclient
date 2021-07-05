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
/* loaded from: classes5.dex */
public class RecordEffectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f22444e;

    /* renamed from: f  reason: collision with root package name */
    public HListView f22445f;

    /* renamed from: g  reason: collision with root package name */
    public HListView f22446g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.s0.z3.m.e.b.a f22447h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.z3.m.e.b.b f22448i;
    public List<d.a.s0.z3.m.e.c.b> j;
    public List<d.a.s0.z3.m.e.c.b> k;
    public List<QmStickerItem> l;
    public String m;
    public String n;
    public String o;
    public d.a.s0.z3.m.e.c.b<d.a.s0.z3.m.e.c.a> p;
    public d.a.s0.z3.m.e.c.b<QmFilterItem> q;
    public d.a.s0.z3.m.e.c.b<MusicData> r;
    public QmStickerItem s;
    public AnimatorSet t;
    public AnimatorSet u;
    public AnimatorSet v;
    public Handler w;
    public int x;
    public i y;

    /* loaded from: classes5.dex */
    public class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22449a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22450b;

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
            this.f22450b = recordEffectLayout;
            this.f22449a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(d.a.s0.z3.m.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) || bVar == null) {
                return;
            }
            i iVar = this.f22449a;
            if (iVar != null) {
                iVar.b(bVar, obj);
            }
            int c2 = bVar.c();
            if (c2 == 1) {
                this.f22450b.m = bVar.b();
                this.f22450b.p = bVar;
            } else if (c2 == 2) {
                this.f22450b.n = ((QmFilterItem) bVar.d()).id;
                this.f22450b.q = bVar;
            } else if (c2 != 3) {
            } else {
                this.f22450b.o = bVar.b();
                this.f22450b.r = bVar;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f22451a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22452b;

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
            this.f22452b = recordEffectLayout;
            this.f22451a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) || qmStickerItem == null) {
                return;
            }
            this.f22452b.B(qmStickerItem);
            i iVar = this.f22451a;
            if (iVar != null) {
                iVar.a(qmStickerItem);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(d.a.s0.z3.m.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f22453e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f22454f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22455g;

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
            this.f22455g = recordEffectLayout;
            this.f22453e = list;
            this.f22454f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22455g.f22447h.e(this.f22453e, this.f22454f);
                this.f22455g.f22447h.notifyDataSetChanged();
                RecordEffectLayout recordEffectLayout = this.f22455g;
                recordEffectLayout.setListViewSelection(recordEffectLayout.n());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22456e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22457f;

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
            this.f22457f = recordEffectLayout;
            this.f22456e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22457f.f22445f.setSelection(this.f22456e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22458e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22459f;

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
            this.f22459f = recordEffectLayout;
            this.f22458e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22459f.f22446g.setSelection(this.f22458e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends d.a.s0.z3.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22460f;

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
            this.f22460f = recordEffectLayout;
        }

        @Override // d.a.s0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f70139e || this.f22460f.f22445f == null) {
                return;
            }
            this.f22460f.f22445f.setVisibility(8);
        }

        @Override // d.a.s0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f22460f.f22446g != null) {
                    this.f22460f.f22446g.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22461e;

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
            this.f22461e = recordEffectLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22461e.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends d.a.s0.z3.m.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RecordEffectLayout f22462f;

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
            this.f22462f = recordEffectLayout;
        }

        @Override // d.a.s0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f70139e || this.f22462f.f22446g == null) {
                return;
            }
            this.f22462f.f22446g.setVisibility(8);
        }

        @Override // d.a.s0.z3.m.e.a, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.f22462f.f22445f != null) {
                    this.f22462f.f22445f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface i {
        void a(QmStickerItem qmStickerItem);

        void b(d.a.s0.z3.m.e.c.b bVar, Object obj);
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
            this.w.post(new d(this, i2));
        }
    }

    private void setMusicStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            ((RelativeLayout.LayoutParams) this.f22445f.getLayoutParams()).topMargin = UtilHelper.getDimenPixelSize(z ? R.dimen.M_H_X013 : R.dimen.M_H_X008);
            this.f22444e.setVisibility(z ? 0 : 8);
        }
    }

    private void setStickerListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            this.w.post(new e(this, i2));
        }
    }

    public void A(d.a.s0.z3.m.e.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.q = bVar;
            if (ListUtils.isEmpty(this.j) || bVar == null || !(bVar.d() instanceof QmFilterItem)) {
                return;
            }
            QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
            if (!StringUtils.isNull(qmFilterItem.id)) {
                for (d.a.s0.z3.m.e.c.b bVar2 : this.j) {
                    if (bVar2 != null && (bVar2.d() instanceof QmFilterItem)) {
                        if (!qmFilterItem.id.equals(((QmFilterItem) bVar2.d()).id)) {
                            qmFilterItem.isSelect = false;
                        } else {
                            qmFilterItem.isSelect = true;
                        }
                    }
                }
            }
            d.a.s0.z3.m.e.b.a aVar = this.f22447h;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }
    }

    public void B(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem) == null) {
            this.s = qmStickerItem;
            if (ListUtils.isEmpty(this.l) || qmStickerItem == null) {
                return;
            }
            for (QmStickerItem qmStickerItem2 : this.l) {
                if (qmStickerItem2.id != qmStickerItem.id) {
                    qmStickerItem2.isSelect = false;
                } else {
                    qmStickerItem2.isSelect = true;
                }
            }
            d.a.s0.z3.m.e.b.b bVar = this.f22448i;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AnimatorSet animatorSet = this.u;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.u.cancel();
            }
            if (this.t == null) {
                this.t = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22445f, "alpha", 1.0f, 0.0f);
                ofFloat.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f22445f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(320L);
                this.t.playTogether(ofFloat, ofPropertyValuesHolder);
            }
            this.f22445f.setVisibility(0);
            this.t.start();
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                setMusicStyle(false);
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
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22445f, "alpha", 1.0f, 0.0f);
                    ofFloat.setDuration(260L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f22446g, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(320L);
                    ofPropertyValuesHolder.addListener(new f(this));
                    this.u.playTogether(ofFloat, ofPropertyValuesHolder);
                }
                d.a.c.e.m.e.a().postDelayed(new g(this), 300L);
                this.u.start();
                return;
            }
            AnimatorSet animatorSet3 = this.u;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.u.cancel();
            }
            if (this.v == null) {
                this.v = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f22446g, "alpha", 1.0f, 0.0f);
                ofFloat2.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f22445f, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationY", 1000.0f, 0.0f));
                ofPropertyValuesHolder2.setDuration(320L);
                ofPropertyValuesHolder2.addListener(new h(this));
                this.v.playTogether(ofFloat2, ofPropertyValuesHolder2);
            }
            this.v.start();
        }
    }

    public d.a.s0.z3.m.e.c.b<d.a.s0.z3.m.e.c.a> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : (d.a.s0.z3.m.e.c.b) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.x : invokeV.intValue;
    }

    public d.a.s0.z3.m.e.c.b<QmFilterItem> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (d.a.s0.z3.m.e.c.b) invokeV.objValue;
    }

    public QmStickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.s : (QmStickerItem) invokeV.objValue;
    }

    public final void l(List<d.a.s0.z3.m.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) || list == null) {
            return;
        }
        if (ListUtils.getCount(list) > 0 && ((d.a.s0.z3.m.e.c.b) ListUtils.getItem(list, 0)).c() == 3) {
            setMusicStyle(true);
        } else {
            setMusicStyle(false);
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.f22446g.getVisibility() == 0) {
            cVar.run();
            D(false);
        } else {
            C();
            this.w.postDelayed(cVar, 260L);
        }
    }

    public final <T> d.a.s0.z3.m.e.c.b<T> m(int i2, int i3, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, t})) == null) {
            d.a.s0.z3.m.e.c.b<T> bVar = new d.a.s0.z3.m.e.c.b<>();
            bVar.g(i3);
            bVar.e(i2);
            bVar.f(str);
            bVar.h(t);
            return bVar;
        }
        return (d.a.s0.z3.m.e.c.b) invokeCommon.objValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.x;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3 && !StringUtils.isNull(this.o)) {
                        for (int i3 = 0; i3 < this.k.size(); i3++) {
                            d.a.s0.z3.m.e.c.b bVar = this.k.get(i3);
                            if (bVar != null && this.n.equals(bVar.b())) {
                                return i3;
                            }
                        }
                    }
                } else if (!StringUtils.isNull(this.n)) {
                    for (int i4 = 0; i4 < this.j.size(); i4++) {
                        d.a.s0.z3.m.e.c.b bVar2 = this.j.get(i4);
                        if (bVar2 != null && (bVar2.d() instanceof QmFilterItem) && this.n.equals(((QmFilterItem) bVar2.d()).id)) {
                            int i5 = i4 - 2;
                            return (i5 < 0 || i4 + 2 > this.j.size()) ? i4 : i5;
                        }
                    }
                }
            } else if (this.s != null) {
                for (int i6 = 0; i6 < this.l.size(); i6++) {
                    QmStickerItem qmStickerItem = this.l.get(i6);
                    if (qmStickerItem != null && this.s.id == qmStickerItem.id) {
                        int i7 = i6 / 2;
                        int i8 = i7 - 2;
                        return (i8 < 0 || i7 + 2 > this.l.size() / 2) ? i7 : i8;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int o(List<d.a.s0.z3.m.e.c.b> list, QmFilterItem qmFilterItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, list, qmFilterItem)) == null) {
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.id) || ListUtils.isEmpty(list)) {
                return -1;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.s0.z3.m.e.c.b bVar = list.get(i2);
                if (bVar.d() != null && qmFilterItem.id.equals(((QmFilterItem) bVar.d()).id)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public final String p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) ? getResources().getText(i2).toString() : (String) invokeI.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.p = m(R.drawable.beauty_icon_avatar_2, 1, "2", d.a.s0.z3.m.e.c.a.b(2));
            this.n = "-1";
            QmFilterItem qmFilterItem = new QmFilterItem();
            qmFilterItem.id = "-1";
            qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
            qmFilterItem.name = getResources().getString(R.string.filter_nature);
            qmFilterItem.isSelect = true;
            qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
            this.q = m(R.drawable.icon_pure_video_lvjing_on, 2, p(R.string.filter_nature), qmFilterItem);
            this.j = new ArrayList();
            QmStickerItem qmStickerItem = new QmStickerItem();
            qmStickerItem.id = -1;
            qmStickerItem.isLocalSource = true;
            qmStickerItem.localPath = "nosticker";
            this.s = qmStickerItem;
            this.o = getResources().getString(R.string.music_normal);
            getResources().getString(R.string.music_normal);
            new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.music_normal));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.w = new Handler();
            q();
            RelativeLayout.inflate(getContext(), R.layout.layout_capture_effect_container, this);
            TextView textView = (TextView) findViewById(R.id.music_name_view);
            this.f22444e = textView;
            textView.setText(getResources().getString(R.string.capture_selected_music) + getResources().getString(R.string.music_normal));
            HListView hListView = (HListView) findViewById(R.id.effect_list_view);
            this.f22445f = hListView;
            hListView.setDividerWidth(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.f22445f.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            this.f22445f.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.sticker_list_view);
            this.f22446g = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            d.a.s0.z3.m.e.b.a aVar = new d.a.s0.z3.m.e.b.a();
            this.f22447h = aVar;
            this.f22445f.setAdapter((ListAdapter) aVar);
            d.a.s0.z3.m.e.b.b bVar = new d.a.s0.z3.m.e.b.b();
            this.f22448i = bVar;
            this.f22446g.setAdapter((ListAdapter) bVar);
        }
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (ListUtils.isEmpty(this.j)) {
                return true;
            }
            return this.j.size() == 1 && "-1".equals(((QmFilterItem) this.j.get(0).d()).id);
        }
        return invokeV.booleanValue;
    }

    public void setCurrentMusicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.o = str;
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, qmFilterItem) == null) || ListUtils.isEmpty(this.j)) {
            return;
        }
        if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.id)) {
            for (d.a.s0.z3.m.e.c.b bVar : this.j) {
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
            for (d.a.s0.z3.m.e.c.b bVar2 : this.j) {
                if (bVar2.d() instanceof QmFilterItem) {
                    ((QmFilterItem) bVar2.d()).isDownLoading = false;
                }
            }
        }
        d.a.s0.z3.m.e.b.a aVar = this.f22447h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void setDownLoadStrick(QmStickerItem qmStickerItem, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048594, this, qmStickerItem, z) == null) || ListUtils.isEmpty(this.l)) {
            return;
        }
        if (qmStickerItem != null) {
            for (QmStickerItem qmStickerItem2 : this.l) {
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
            for (QmStickerItem qmStickerItem3 : this.l) {
                qmStickerItem3.isDownLoading = false;
            }
        }
        d.a.s0.z3.m.e.b.b bVar = this.f22448i;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
    }

    public void setFilterList(List<d.a.s0.z3.m.e.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            List<d.a.s0.z3.m.e.c.b> list2 = this.j;
            if (list2 == null) {
                this.j = new ArrayList();
            } else {
                list2.clear();
            }
            this.j.addAll(list);
        }
    }

    public void setListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, iVar) == null) {
            this.y = iVar;
            d.a.s0.z3.m.e.b.a aVar = this.f22447h;
            if (aVar != null) {
                aVar.f(new a(this, iVar));
            }
            d.a.s0.z3.m.e.b.b bVar = this.f22448i;
            if (bVar != null) {
                bVar.e(new b(this, iVar));
            }
        }
    }

    public void setMusicList(List<d.a.s0.z3.m.e.c.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            List<d.a.s0.z3.m.e.c.b> list2 = this.k;
            if (list2 == null) {
                this.k = new ArrayList();
            } else {
                list2.clear();
            }
            this.k.addAll(list);
        }
    }

    public void setMusicName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                TextView textView = this.f22444e;
                textView.setText(getContext().getString(R.string.capture_selected_music) + str);
            }
            d.a.s0.z3.m.e.b.a aVar = this.f22447h;
            if (aVar != null) {
                aVar.g(str2);
            }
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            this.l = list;
            d.a.s0.z3.m.e.b.b bVar = this.f22448i;
            if (bVar != null) {
                bVar.d(list);
                this.f22448i.notifyDataSetChanged();
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (ListUtils.isEmpty(this.l)) {
                return true;
            }
            return this.l.size() == 1 && this.l.get(0).id == -1;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.x = 2;
            l(this.j, this.n);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.x = 3;
            l(this.k, this.o);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.x = 0;
            this.f22446g.setAdapter((ListAdapter) this.f22448i);
            this.f22448i.notifyDataSetChanged();
            setStickerListViewSelection(n());
            if (getVisibility() == 0) {
                D(true);
                return;
            }
            this.f22446g.setVisibility(0);
            this.f22445f.setVisibility(8);
        }
    }

    public void x() {
        int o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (o = o(this.j, this.q.d())) < 0) {
            return;
        }
        int i2 = o + 1;
        if (i2 > this.j.size() - 1) {
            i2 = 0;
        }
        d.a.s0.z3.m.e.c.b<QmFilterItem> bVar = this.j.get(i2);
        if (bVar == null) {
            return;
        }
        if (bVar.c() == 2) {
            i iVar = this.y;
            if (iVar != null) {
                iVar.b(bVar, null);
            }
            this.n = bVar.d().id;
            this.q = bVar;
        }
        if (this.f22447h == null || getCurrentEffectLayout() != 2) {
            return;
        }
        this.f22447h.d(bVar.d().id);
        this.f22447h.notifyDataSetChanged();
    }

    public void y() {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (indexOf = this.j.indexOf(this.q)) < 0) {
            return;
        }
        d.a.s0.z3.m.e.c.b<QmFilterItem> bVar = this.j.get(indexOf + (-1) < 0 ? 0 : indexOf - 1);
        if (bVar == null) {
            return;
        }
        if (bVar.c() == 2) {
            i iVar = this.y;
            if (iVar != null) {
                iVar.b(bVar, null);
            }
            this.n = bVar.d().id;
            this.q = bVar;
        }
        if (this.f22447h == null || getCurrentEffectLayout() != 2) {
            return;
        }
        this.f22447h.d(bVar.d().id);
        this.f22447h.notifyDataSetChanged();
    }

    public void z(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, tbMusicData) == null) || this.f22447h == null) {
            return;
        }
        if (tbMusicData != null) {
            setMusicName(tbMusicData.title, tbMusicData.icon);
        }
        this.f22447h.c(tbMusicData);
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
        r();
    }
}
