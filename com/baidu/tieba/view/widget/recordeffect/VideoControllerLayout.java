package com.baidu.tieba.view.widget.recordeffect;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.R;
import com.baidu.tieba.bsa;
import com.baidu.tieba.d85;
import com.baidu.tieba.dta;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.ez5;
import com.baidu.tieba.hu6;
import com.baidu.tieba.nj6;
import com.baidu.tieba.view.widget.CaptureRecordButton;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.w37;
import com.baidu.tieba.x37;
import com.baidu.tieba.xu6;
import com.baidu.tieba.zsa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoControllerLayout extends RelativeLayout implements View.OnTouchListener, x37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public CaptureRecordButton b;
    public TextView c;
    public xu6 d;
    public w37 e;
    public nj6 f;
    public long g;
    public boolean h;
    public List<ObjectAnimator> i;
    public e j;
    public boolean k;
    public boolean l;
    public List<dta> m;
    public List<dta> n;
    public List<QmStickerItem> o;
    public List<dta> p;
    public RecordEffectLayout q;
    public Handler r;
    public int s;

    /* loaded from: classes8.dex */
    public interface e {
        void a(boolean z);

        void j();

        void k();

        void m();

        void n();

        void p();
    }

    public void setEditManager(hu6 hu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, hu6Var) == null) {
        }
    }

    public void setHasLocalVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a extends zsa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerLayout b;

        public a(VideoControllerLayout videoControllerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoControllerLayout;
        }

        @Override // com.baidu.tieba.zsa, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                if ((this.b.d == null || !this.b.d.c()) && this.b.j != null) {
                    this.b.j.p();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ VideoControllerLayout b;

        public b(VideoControllerLayout videoControllerLayout, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoControllerLayout;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.b.h || this.b.g != this.a) {
                return;
            }
            this.b.l = true;
            this.b.C();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends zsa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoControllerLayout b;

        public c(VideoControllerLayout videoControllerLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoControllerLayout;
        }

        @Override // com.baidu.tieba.zsa, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && this.b.j != null) {
                this.b.j.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends zsa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ zsa c;
        public final /* synthetic */ VideoControllerLayout d;

        public d(VideoControllerLayout videoControllerLayout, boolean z, zsa zsaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoControllerLayout, Boolean.valueOf(z), zsaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = videoControllerLayout;
            this.b = z;
            this.c = zsaVar;
        }

        @Override // com.baidu.tieba.zsa, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, animator) != null) || this.a) {
                return;
            }
            this.d.q.setVisibility(8);
            if (this.d.f != null && this.d.f.getProgress() > 0.0f) {
                this.d.c.setVisibility(0);
            } else {
                this.d.c.setVisibility(8);
            }
            if (this.d.j != null) {
                this.d.j.a(this.b);
            }
            zsa zsaVar = this.c;
            if (zsaVar != null) {
                zsaVar.onAnimationEnd(animator);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds648);
                        return;
                    }
                    return;
                }
                layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds580);
                return;
            }
            layoutParams.height = UtilHelper.getDimenPixelSize(R.dimen.tbds528);
        }
    }

    public void setFilterData(List<QmFilterItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (QmFilterItem qmFilterItem : list) {
                    arrayList.add(new dta(2, qmFilterItem.name, qmFilterItem, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                recordEffectLayout.setFilterList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.x37
    public void setMusicData(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            if (list != null && list.size() > 0) {
                for (MusicData musicData : list) {
                    this.p.add(new dta(3, musicData.name, musicData, -1));
                }
            }
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                recordEffectLayout.setMusicList(this.p);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoControllerLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.g = 0L;
        this.h = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new Handler();
        this.s = 2;
        n();
    }

    public void A(QmStickerItem qmStickerItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.A(qmStickerItem);
        }
    }

    public void setCurrentFilterWithQmFilterItem(@NonNull QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, qmFilterItem) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setCurrentFilterWithQmFilterItem(qmFilterItem);
        }
    }

    public void setCurrentType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.s = i;
        }
    }

    public void setDownLoadFilter(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, qmFilterItem) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setDownLoadFilter(qmFilterItem);
        }
    }

    public void setDurationManager(nj6 nj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, nj6Var) == null) {
            this.f = nj6Var;
        }
    }

    public void setEffectChoosedListener(RecordEffectLayout.i iVar) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, iVar) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setListener(iVar);
        }
    }

    public void setEffectLayoutCurrentMusicName(String str) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, str) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setCurrentMusicName(str);
        }
    }

    public void setMusicManager(w37 w37Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, w37Var) == null) {
            this.e = w37Var;
        }
    }

    public void setRecordControlListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, eVar) == null) {
            this.j = eVar;
        }
    }

    public void setRecordManager(xu6 xu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, xu6Var) == null) {
            this.d = xu6Var;
        }
    }

    public void setStickerItems(List<QmStickerItem> list) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, list) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setStickerItems(list);
        }
    }

    public void y(TbMusicData tbMusicData) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, tbMusicData) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.y(tbMusicData);
        }
    }

    public void z(QmFilterItem qmFilterItem) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, qmFilterItem) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.z(new dta(2, qmFilterItem.name, qmFilterItem, -1));
        }
    }

    public final void k(View view2, MotionEvent motionEvent) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, view2, motionEvent) == null) && motionEvent.getAction() == 0 && (eVar = this.j) != null) {
            eVar.n();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
        if (r0 != 2) goto L8;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view2, motionEvent)) == null) {
            int i = this.s;
            if (i != 0) {
                if (i == 1) {
                    k(view2, motionEvent);
                }
                return true;
            }
            l(view2, motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void setDownLoadSticker(QmStickerItem qmStickerItem, boolean z) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, qmStickerItem, z) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setDownLoadStrick(qmStickerItem, z);
        }
    }

    public void setMusicName(String str, String str2) {
        RecordEffectLayout recordEffectLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048610, this, str, str2) == null) && (recordEffectLayout = this.q) != null) {
            recordEffectLayout.setMusicName(str, str2);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.q.getVisibility() == 0) {
            return;
        }
        this.q.setVisibility(0);
        this.c.setVisibility(8);
        o();
        for (int i = 0; i < this.i.size(); i++) {
            ObjectAnimator objectAnimator = this.i.get(i);
            if (objectAnimator != null) {
                objectAnimator.cancel();
                objectAnimator.setDuration(320L);
                objectAnimator.removeAllListeners();
                if (i == this.i.size() - 1) {
                    objectAnimator.addListener(new c(this));
                }
                objectAnimator.start();
            }
        }
        nj6 nj6Var = this.f;
        if (nj6Var != null && nj6Var.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b.getLayer2(), Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.start();
            ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_X, 0.388f, 0.276f).setDuration(320L).start();
            ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_Y, 0.388f, 0.276f).setDuration(320L).start();
            return;
        }
        ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_X, 1.0f, 0.681f).setDuration(320L).start();
        ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_Y, 1.0f, 0.681f).setDuration(320L).start();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && ListUtils.isEmpty(this.i)) {
            ArrayList arrayList = new ArrayList();
            this.i = arrayList;
            arrayList.add(ObjectAnimator.ofFloat(this.q, Key.TRANSLATION_Y, UtilHelper.getDimenPixelSize(R.dimen.tbds656), 0.0f));
            this.i.add(ObjectAnimator.ofFloat(this.a, Key.TRANSLATION_Y, 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds207)));
            this.i.add(ObjectAnimator.ofFloat(this.b.getPause(), Key.SCALE_X, 1.0f, 0.681f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getPause(), Key.SCALE_Y, 1.0f, 0.681f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer2(), Key.SCALE_X, 0.8f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer2(), Key.SCALE_Y, 0.8f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer3(), Key.SCALE_X, 1.0f, 0.57f));
            this.i.add(ObjectAnimator.ofFloat(this.b.getLayer3(), Key.SCALE_Y, 1.0f, 0.57f));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.q, Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setStartDelay(120L);
            this.i.add(ofFloat);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xu6 xu6Var = this.d;
            if (xu6Var != null && xu6Var.c()) {
                return;
            }
            nj6 nj6Var = this.f;
            if (nj6Var != null && nj6Var.getProgress() > 0.0f) {
                this.b.g();
            }
            if (this.q.getCurrentBeautyItem() != null) {
                this.m.add(this.q.getCurrentBeautyItem());
            }
            if (this.q.getCurrentFilterItem() != null) {
                this.n.add(this.q.getCurrentFilterItem());
            }
            if (this.q.getCurrentStickItem() != null) {
                this.o.add(this.q.getCurrentStickItem());
            }
            if (this.q.getVisibility() == 0) {
                m(new a(this), true);
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.p();
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setVisibility(0);
            this.b.h(this.l);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.i();
            this.c.setVisibility(8);
        }
    }

    public List<dta> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public List<dta> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public List<QmStickerItem> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return (List) invokeV.objValue;
    }

    public String getCurrentFilterName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null && recordEffectLayout.getCurrentFilterItem() != null) {
                return this.q.getCurrentFilterItem().b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public TextView getRecordTimeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    public bsa getRecrodButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (bsa) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.q.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.q.getCurrentEffectLayout() == 2 && this.q.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.q.getCurrentEffectLayout() == 3 && this.q.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSelectedToLeftIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.q.x();
        }
    }

    public void setSelectedToRightIndex() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.q.w();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                return recordEffectLayout.r();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            RecordEffectLayout recordEffectLayout = this.q;
            if (recordEffectLayout != null) {
                return recordEffectLayout.s();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xu6 xu6Var = this.d;
            if (xu6Var != null && !xu6Var.c()) {
                nj6 nj6Var = this.f;
                if (nj6Var != null && nj6Var.getProgress() >= this.f.getMaxDuration()) {
                    this.b.f();
                    return;
                }
                return;
            }
            nj6 nj6Var2 = this.f;
            if (nj6Var2 != null && nj6Var2.getProgress() > 0.0f) {
                this.b.f();
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.k();
            }
        }
    }

    public final void l(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, view2, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action != 1 && action != 3) || ez5.a()) {
                    return;
                }
                if (this.k) {
                    this.k = false;
                    return;
                }
                this.h = false;
                if (this.d.c()) {
                    E();
                    return;
                }
                this.l = false;
                C();
                return;
            }
            e eVar = this.j;
            if (eVar != null) {
                eVar.m();
            }
            w37 w37Var = this.e;
            if (w37Var != null && w37Var.h()) {
                this.k = true;
                CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f0cf1);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.g = currentTimeMillis;
            this.h = true;
            this.r.postDelayed(new b(this, currentTimeMillis), 200L);
        }
    }

    public void m(zsa zsaVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048591, this, zsaVar, z) != null) || this.q.getVisibility() == 8) {
            return;
        }
        o();
        for (int i = 0; i < this.i.size(); i++) {
            ObjectAnimator objectAnimator = this.i.get(i);
            if (objectAnimator != null) {
                objectAnimator.setDuration(320L);
                objectAnimator.cancel();
                objectAnimator.removeAllListeners();
                if (i == this.i.size() - 1) {
                    objectAnimator.addListener(new d(this, z, zsaVar));
                }
                objectAnimator.reverse();
            }
        }
        nj6 nj6Var = this.f;
        if (nj6Var != null && nj6Var.getProgress() > 0.0f) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b.getLayer2(), Key.ALPHA, 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.reverse();
            ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_X, 0.388f, 0.276f).setDuration(320L).reverse();
            ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_Y, 0.388f, 0.276f).setDuration(320L).reverse();
            return;
        }
        ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_X, 1.0f, 0.681f).setDuration(320L).reverse();
        ObjectAnimator.ofFloat(this.b.getLayer1(), Key.SCALE_Y, 1.0f, 0.681f).setDuration(320L).reverse();
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0857, this);
            RecordEffectLayout recordEffectLayout = (RecordEffectLayout) findViewById(R.id.obfuscated_res_0x7f09147e);
            this.q = recordEffectLayout;
            d85 d2 = d85.d(recordEffectLayout);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0214);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091499);
            CaptureRecordButton captureRecordButton = (CaptureRecordButton) findViewById(R.id.obfuscated_res_0x7f09149a);
            this.b = captureRecordButton;
            captureRecordButton.setOnTouchListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09149b);
            this.c = textView;
            d85 d3 = d85.d(textView);
            d3.D(R.string.F_X02);
            d3.B(R.array.S_O_X001);
            this.p.add(0, new dta(3, getResources().getString(R.string.obfuscated_res_0x7f0f0cf2), new MusicData(MusicData.MUSIC_NORMAL_ID, 1, getResources().getString(R.string.obfuscated_res_0x7f0f0cf2)), R.drawable.obfuscated_res_0x7f080d30));
            this.p.add(1, new dta(3, getResources().getString(R.string.obfuscated_res_0x7f0f0cf0), new MusicData(MusicData.MUSIC_CLOUD_ID, 2, getResources().getString(R.string.obfuscated_res_0x7f0f0cf0)), R.drawable.obfuscated_res_0x7f080d1a));
            return true;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            j(1);
            if (p() && this.q.getCurrentEffectLayout() == 2) {
                m(null, false);
                return;
            }
            if (!p()) {
                B();
            }
            this.q.t();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            j(2);
            if (p() && this.q.getCurrentEffectLayout() == 3) {
                m(null, false);
                return;
            }
            if (!p()) {
                B();
            }
            this.q.u();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            j(3);
            if (p() && this.q.getCurrentEffectLayout() == 0) {
                m(null, false);
                return;
            }
            if (!p()) {
                B();
            }
            this.q.v();
        }
    }
}
