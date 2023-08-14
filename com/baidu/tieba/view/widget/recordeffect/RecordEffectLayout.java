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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.R;
import com.baidu.tieba.esa;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.fsa;
import com.baidu.tieba.gsa;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.tieba.hsa;
import com.baidu.tieba.isa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class RecordEffectLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public HListView b;
    public HListView c;
    public fsa d;
    public gsa e;
    public List<isa> f;
    public List<isa> g;
    public List<QmStickerItem> h;
    public String i;
    public String j;
    public String k;
    public isa<hsa> l;
    public isa<QmFilterItem> m;
    public QmStickerItem n;
    public AnimatorSet o;
    public AnimatorSet p;
    public AnimatorSet q;
    public Handler r;
    public int s;
    public i t;

    /* loaded from: classes8.dex */
    public interface i {
        void a(QmStickerItem qmStickerItem);

        void b(isa isaVar, Object obj);
    }

    /* loaded from: classes8.dex */
    public class a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ RecordEffectLayout b;

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        public a(RecordEffectLayout recordEffectLayout, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordEffectLayout;
            this.a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(isa isaVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, isaVar, obj) != null) || isaVar == null) {
                return;
            }
            i iVar = this.a;
            if (iVar != null) {
                iVar.b(isaVar, obj);
            }
            int type = isaVar.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type == 3) {
                        this.b.k = isaVar.b();
                        return;
                    }
                    return;
                }
                this.b.j = ((QmFilterItem) isaVar.c()).id;
                this.b.m = isaVar;
                return;
            }
            this.b.i = isaVar.b();
            this.b.l = isaVar;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;
        public final /* synthetic */ RecordEffectLayout b;

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(isa isaVar, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, isaVar, obj) == null) {
            }
        }

        public b(RecordEffectLayout recordEffectLayout, i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordEffectLayout;
            this.a = iVar;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, qmStickerItem) != null) || qmStickerItem == null) {
                return;
            }
            this.b.B(qmStickerItem);
            i iVar = this.a;
            if (iVar != null) {
                iVar.a(qmStickerItem);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ RecordEffectLayout c;

        public c(RecordEffectLayout recordEffectLayout, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = recordEffectLayout;
            this.a = list;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d.h(this.a, this.b);
                this.c.d.notifyDataSetChanged();
                RecordEffectLayout recordEffectLayout = this.c;
                recordEffectLayout.setListViewSelection(recordEffectLayout.m());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ RecordEffectLayout b;

        public d(RecordEffectLayout recordEffectLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordEffectLayout;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelection(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ RecordEffectLayout b;

        public e(RecordEffectLayout recordEffectLayout, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordEffectLayout;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.c.setSelection(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends esa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordEffectLayout b;

        public f(RecordEffectLayout recordEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordEffectLayout;
        }

        @Override // com.baidu.tieba.esa, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a && this.b.b != null) {
                this.b.b.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.esa, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                super.onAnimationStart(animator);
                if (this.b.c != null) {
                    this.b.c.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordEffectLayout a;

        public g(RecordEffectLayout recordEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordEffectLayout;
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
    public class h extends esa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordEffectLayout b;

        public h(RecordEffectLayout recordEffectLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordEffectLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordEffectLayout;
        }

        @Override // com.baidu.tieba.esa, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a && this.b.c != null) {
                this.b.c.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.esa, android.animation.Animator.AnimatorListener
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

    public void B(QmStickerItem qmStickerItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem) == null) {
            this.n = qmStickerItem;
            if (!ListUtils.isEmpty(this.h) && qmStickerItem != null) {
                for (QmStickerItem qmStickerItem2 : this.h) {
                    if (qmStickerItem2.id != qmStickerItem.id) {
                        qmStickerItem2.isSelect = false;
                    } else {
                        qmStickerItem2.isSelect = true;
                    }
                }
                gsa gsaVar = this.e;
                if (gsaVar != null) {
                    gsaVar.notifyDataSetChanged();
                }
            }
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

    public final void k(List<isa> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) != null) || list == null) {
            return;
        }
        if (ListUtils.getCount(list) > 0 && ((isa) ListUtils.getItem(list, 0)).getType() == 3) {
            setMusicStyle(true);
        } else {
            setMusicStyle(false);
        }
        c cVar = new c(this, list, str);
        if (getVisibility() != 0) {
            cVar.run();
        } else if (this.c.getVisibility() == 0) {
            cVar.run();
            D(false);
        } else {
            C();
            this.r.postDelayed(cVar, 260L);
        }
    }

    public final int n(List<isa> list, QmFilterItem qmFilterItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, list, qmFilterItem)) == null) {
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.id) || ListUtils.isEmpty(list)) {
                return -1;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                isa isaVar = list.get(i2);
                if (isaVar.c() != null && qmFilterItem.id.equals(((QmFilterItem) isaVar.c()).id)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void setDownLoadStrick(QmStickerItem qmStickerItem, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048596, this, qmStickerItem, z) == null) && !ListUtils.isEmpty(this.h)) {
            if (qmStickerItem != null) {
                for (QmStickerItem qmStickerItem2 : this.h) {
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
                for (QmStickerItem qmStickerItem3 : this.h) {
                    qmStickerItem3.isDownLoading = false;
                }
            }
            gsa gsaVar = this.e;
            if (gsaVar != null) {
                gsaVar.notifyDataSetChanged();
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
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i2) == null) {
            this.r.post(new d(this, i2));
        }
    }

    private void setMusicStyle(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, this, z) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
            if (z) {
                i2 = R.dimen.M_H_X013;
            } else {
                i2 = R.dimen.M_H_X008;
            }
            layoutParams.topMargin = UtilHelper.getDimenPixelSize(i2);
            TextView textView = this.a;
            if (z) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    private void setStickerListViewSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i2) == null) {
            this.r.post(new e(this, i2));
        }
    }

    public final String o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return getResources().getText(i2).toString();
        }
        return (String) invokeI.objValue;
    }

    public void setCurrentFilterWithQmFilterItem(@NonNull QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, qmFilterItem) == null) {
            this.j = qmFilterItem.id;
            this.m = l(JavaTypesHelper.toInt(qmFilterItem.bgurl, 0), 2, qmFilterItem.name, qmFilterItem);
        }
    }

    public void setCurrentMusicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.k = str;
        }
    }

    public void setFilterList(List<isa> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            List<isa> list2 = this.f;
            if (list2 == null) {
                this.f = new ArrayList();
            } else {
                list2.clear();
            }
            this.f.addAll(list);
        }
    }

    public void setListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, iVar) == null) {
            this.t = iVar;
            fsa fsaVar = this.d;
            if (fsaVar != null) {
                fsaVar.i(new a(this, iVar));
            }
            gsa gsaVar = this.e;
            if (gsaVar != null) {
                gsaVar.f(new b(this, iVar));
            }
        }
    }

    public void setMusicList(List<isa> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            List<isa> list2 = this.g;
            if (list2 == null) {
                this.g = new ArrayList();
            } else {
                list2.clear();
            }
            this.g.addAll(list);
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.h = list;
            gsa gsaVar = this.e;
            if (gsaVar != null) {
                gsaVar.e(list);
                this.e.notifyDataSetChanged();
            }
        }
    }

    public void z(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, tbMusicData) == null) && this.d != null) {
            if (tbMusicData != null) {
                setMusicName(tbMusicData.title, tbMusicData.icon);
            }
            this.d.f(tbMusicData);
        }
    }

    public void A(isa isaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, isaVar) == null) {
            this.m = isaVar;
            if (!ListUtils.isEmpty(this.f) && isaVar != null && (isaVar.c() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) isaVar.c();
                if (!StringUtils.isNull(qmFilterItem.id)) {
                    for (isa isaVar2 : this.f) {
                        if (isaVar2 != null && (isaVar2.c() instanceof QmFilterItem)) {
                            if (!qmFilterItem.id.equals(((QmFilterItem) isaVar2.c()).id)) {
                                qmFilterItem.isSelect = false;
                            } else {
                                qmFilterItem.isSelect = true;
                            }
                        }
                    }
                }
                fsa fsaVar = this.d;
                if (fsaVar != null) {
                    fsaVar.notifyDataSetChanged();
                }
            }
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, qmFilterItem) == null) && !ListUtils.isEmpty(this.f)) {
            if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.id)) {
                for (isa isaVar : this.f) {
                    if (isaVar.c() instanceof QmFilterItem) {
                        QmFilterItem qmFilterItem2 = (QmFilterItem) isaVar.c();
                        if (!qmFilterItem.id.equals(qmFilterItem2.id)) {
                            qmFilterItem2.isDownLoading = false;
                        } else {
                            qmFilterItem2.isDownLoading = true;
                        }
                    }
                }
            } else {
                for (isa isaVar2 : this.f) {
                    if (isaVar2.c() instanceof QmFilterItem) {
                        ((QmFilterItem) isaVar2.c()).isDownLoading = false;
                    }
                }
            }
            fsa fsaVar = this.d;
            if (fsaVar != null) {
                fsaVar.notifyDataSetChanged();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AnimatorSet animatorSet = this.p;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.p.cancel();
            }
            if (this.o == null) {
                this.o = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 1.0f, 0.0f);
                ofFloat.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                ofPropertyValuesHolder.setDuration(320L);
                this.o.playTogether(ofFloat, ofPropertyValuesHolder);
            }
            this.b.setVisibility(0);
            this.o.start();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l = l(R.drawable.obfuscated_res_0x7f080294, 1, "2", hsa.b(2));
            this.j = "-1";
            QmFilterItem qmFilterItem = new QmFilterItem();
            qmFilterItem.id = "-1";
            qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c32 + "";
            qmFilterItem.name = getResources().getString(R.string.obfuscated_res_0x7f0f073f);
            qmFilterItem.isSelect = true;
            qmFilterItem.localPath = "origin";
            this.m = l(R.drawable.obfuscated_res_0x7f080c32, 2, o(R.string.obfuscated_res_0x7f0f073f), qmFilterItem);
            this.f = new ArrayList();
            QmStickerItem qmStickerItem = new QmStickerItem();
            qmStickerItem.id = -1;
            qmStickerItem.isLocalSource = true;
            qmStickerItem.localPath = "nosticker";
            this.n = qmStickerItem;
            this.k = getResources().getString(R.string.obfuscated_res_0x7f0f0cf4);
        }
    }

    public void x() {
        int n;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (n = n(this.f, this.m.c())) < 0) {
            return;
        }
        int i2 = n + 1;
        if (i2 > this.f.size() - 1) {
            i2 = 0;
        }
        isa<QmFilterItem> isaVar = this.f.get(i2);
        if (isaVar == null) {
            return;
        }
        if (isaVar.getType() == 2) {
            i iVar = this.t;
            if (iVar != null) {
                iVar.b(isaVar, null);
            }
            this.j = isaVar.c().id;
            this.m = isaVar;
        }
        if (this.d != null && getCurrentEffectLayout() == 2) {
            this.d.g(isaVar.c().id);
            this.d.notifyDataSetChanged();
        }
    }

    public void y() {
        int indexOf;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || (indexOf = this.f.indexOf(this.m)) < 0) {
            return;
        }
        if (indexOf - 1 < 0) {
            i2 = 0;
        } else {
            i2 = indexOf - 1;
        }
        isa<QmFilterItem> isaVar = this.f.get(i2);
        if (isaVar == null) {
            return;
        }
        if (isaVar.getType() == 2) {
            i iVar = this.t;
            if (iVar != null) {
                iVar.b(isaVar, null);
            }
            this.j = isaVar.c().id;
            this.m = isaVar;
        }
        if (this.d != null && getCurrentEffectLayout() == 2) {
            this.d.g(isaVar.c().id);
            this.d.notifyDataSetChanged();
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                setMusicStyle(false);
                AnimatorSet animatorSet = this.q;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.q.cancel();
                }
                AnimatorSet animatorSet2 = this.o;
                if (animatorSet2 != null && animatorSet2.isRunning()) {
                    this.o.cancel();
                }
                if (this.p == null) {
                    this.p = new AnimatorSet();
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, Key.ALPHA, 1.0f, 0.0f);
                    ofFloat.setDuration(260L);
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.c, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                    ofPropertyValuesHolder.setDuration(320L);
                    ofPropertyValuesHolder.addListener(new f(this));
                    this.p.playTogether(ofFloat, ofPropertyValuesHolder);
                }
                SafeHandler.getInst().postDelayed(new g(this), 300L);
                this.p.start();
                return;
            }
            AnimatorSet animatorSet3 = this.p;
            if (animatorSet3 != null && animatorSet3.isRunning()) {
                this.p.cancel();
            }
            if (this.q == null) {
                this.q = new AnimatorSet();
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, Key.ALPHA, 1.0f, 0.0f);
                ofFloat2.setDuration(260L);
                ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.b, PropertyValuesHolder.ofFloat(Key.ALPHA, 0.0f, 1.0f), PropertyValuesHolder.ofFloat(Key.TRANSLATION_Y, 1000.0f, 0.0f));
                ofPropertyValuesHolder2.setDuration(320L);
                ofPropertyValuesHolder2.addListener(new h(this));
                this.q.playTogether(ofFloat2, ofPropertyValuesHolder2);
            }
            this.q.start();
        }
    }

    public isa<hsa> getCurrentBeautyItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return (isa) invokeV.objValue;
    }

    public int getCurrentEffectLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public isa<QmFilterItem> getCurrentFilterItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return (isa) invokeV.objValue;
    }

    public QmStickerItem getCurrentStickItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (QmStickerItem) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.s = 2;
            k(this.f, this.j);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.s = 3;
            k(this.g, this.k);
        }
    }

    public final <T> isa<T> l(int i2, int i3, String str, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, t})) == null) {
            isa<T> isaVar = new isa<>();
            isaVar.f(i3);
            isaVar.d(i2);
            isaVar.e(str);
            isaVar.g(t);
            return isaVar;
        }
        return (isa) invokeCommon.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.s;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3 && !StringUtils.isNull(this.k) && this.g != null) {
                        for (int i3 = 0; i3 < this.g.size(); i3++) {
                            isa isaVar = this.g.get(i3);
                            if (isaVar != null && TextUtils.equals(this.j, isaVar.b())) {
                                return i3;
                            }
                        }
                    }
                } else if (!StringUtils.isNull(this.j) && this.f != null) {
                    for (int i4 = 0; i4 < this.f.size(); i4++) {
                        isa isaVar2 = this.f.get(i4);
                        if (isaVar2 != null && (isaVar2.c() instanceof QmFilterItem) && this.j.equals(((QmFilterItem) isaVar2.c()).id)) {
                            int i5 = i4 - 2;
                            if (i5 >= 0 && i4 + 2 <= this.f.size()) {
                                return i5;
                            }
                            return i4;
                        }
                    }
                }
            } else if (this.n != null && this.h != null) {
                for (int i6 = 0; i6 < this.h.size(); i6++) {
                    QmStickerItem qmStickerItem = this.h.get(i6);
                    if (qmStickerItem != null && this.n.id == qmStickerItem.id) {
                        int i7 = i6 / 2;
                        int size = this.h.size() / 2;
                        int i8 = i7 - 2;
                        if (i8 >= 0 && i7 + 2 <= size) {
                            return i8;
                        }
                        return i7;
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.r = new Handler();
            p();
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0509, this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09181f);
            this.a = textView;
            textView.setText(getResources().getString(R.string.obfuscated_res_0x7f0f03df) + getResources().getString(R.string.obfuscated_res_0x7f0f0cf4));
            HListView hListView = (HListView) findViewById(R.id.obfuscated_res_0x7f090991);
            this.b = hListView;
            hListView.setDividerWidth(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006));
            this.b.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X007), 0);
            this.b.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            HListView hListView2 = (HListView) findViewById(R.id.obfuscated_res_0x7f0922bc);
            this.c = hListView2;
            hListView2.setSelector(getResources().getDrawable(R.drawable.transparent_bg));
            fsa fsaVar = new fsa();
            this.d = fsaVar;
            this.b.setAdapter((ListAdapter) fsaVar);
            gsa gsaVar = new gsa();
            this.e = gsaVar;
            this.c.setAdapter((ListAdapter) gsaVar);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (ListUtils.isEmpty(this.f)) {
                return true;
            }
            if (this.f.size() == 1 && "-1".equals(((QmFilterItem) this.f.get(0).c()).id)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.s = 0;
            this.c.setAdapter((ListAdapter) this.e);
            this.e.notifyDataSetChanged();
            setStickerListViewSelection(m());
            if (getVisibility() == 0) {
                D(true);
                return;
            }
            this.c.setVisibility(0);
            this.b.setVisibility(8);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            p();
            fsa fsaVar = this.d;
            if (fsaVar != null) {
                fsaVar.c();
                this.d.d();
                this.d.e();
            }
            gsa gsaVar = this.e;
            if (gsaVar != null) {
                gsaVar.d();
            }
            setMusicName(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cf4), "");
        }
    }

    public void setMusicName(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                TextView textView = this.a;
                textView.setText(getContext().getString(R.string.obfuscated_res_0x7f0f03df) + str);
            }
            fsa fsaVar = this.d;
            if (fsaVar != null) {
                fsaVar.j(str2);
            }
        }
    }
}
