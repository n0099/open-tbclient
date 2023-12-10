package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.widget.ad.AbsDownloadGuide;
import com.baidu.tieba.nu;
import com.baidu.tieba.os;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class ku extends os<fw4> implements qda {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static int w;
    public static int x;
    public static int y;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public fw4 h;
    public RoundCornerFrameLayout i;
    public RoundRelativeLayout j;
    public AbsDownloadGuide k;
    public mea l;
    public String m;
    public String n;
    public BdUniqueId o;
    public int p;
    public boolean q;
    public View.OnClickListener r;
    public final View.OnClickListener s;
    public final View.OnClickListener t;
    public nu.b u;

    public abstract mea t();

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ku b;

        public a(ku kuVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kuVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kuVar;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fw4 fw4Var = this.b.h;
                if (fw4Var != null && fw4Var.getThreadData().getThreadVideoInfo().is_vertical.intValue() != 1) {
                    this.a.width = this.b.f.getWidth();
                    this.a.height = (this.b.f.getWidth() / 16) * 9;
                }
                this.b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;

        public b(ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kuVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            fw4 fw4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (fw4Var = this.a.h) != null && fw4Var.getThreadData() != null) {
                ku kuVar = this.a;
                if (!s36.a(kuVar.b, kuVar.h.getThreadData())) {
                    Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.i);
                    ku kuVar2 = this.a;
                    Context context = kuVar2.b;
                    ThreadData threadData = kuVar2.h.getThreadData();
                    ku kuVar3 = this.a;
                    String str = kuVar3.m;
                    yt5.c(false, context, threadData, 0, computeViewArea, "from_nani_video", "personalize_page", "", str, str, kuVar3.h.getThreadData().isJumpToFrsVideoTabPlay);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;

        public c(ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kuVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ku kuVar;
            os.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (kuVar = this.a).e) != null) {
                aVar.a(kuVar.h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;

        public d(ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kuVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d() != null) {
                this.a.d().a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nu.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;

        public e(ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kuVar;
        }

        @Override // com.baidu.tieba.nu.b
        public boolean a(nu.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.b() == 1) {
                    ku kuVar = this.a;
                    xl6.l(kuVar.g, kuVar.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (aVar.b() == 2) {
                    mea meaVar = this.a.l;
                    if (meaVar != null) {
                        meaVar.onScroll();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 3) {
                    mea meaVar2 = this.a.l;
                    if (meaVar2 != null) {
                        meaVar2.onVolumeUp();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 6) {
                    mea meaVar3 = this.a.l;
                    if (meaVar3 != null) {
                        return meaVar3.onBackPress();
                    }
                    return false;
                } else if (aVar.b() == 7) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.a.i;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.d(((Boolean) aVar.c()).booleanValue());
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 8 && this.a.l != null && (aVar.c() instanceof Boolean)) {
                    return this.a.l.onBackground(((Boolean) aVar.c()).booleanValue());
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448309635, "Lcom/baidu/tieba/ku;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448309635, "Lcom/baidu/tieba/ku;");
                return;
            }
        }
        v = (BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
        w = equipmentWidth;
        int i = equipmentWidth - v;
        x = i;
        y = (i / 2) * 3;
        z = i / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ku(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = 0;
        this.q = false;
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
        this.u = new e(this);
    }

    public void A(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) {
            this.q = z2;
        }
    }

    public void B(hea heaVar) {
        mea meaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, heaVar) == null) && (meaVar = this.l) != null) {
            meaVar.setStatistic(heaVar);
        }
    }

    @Override // com.baidu.tieba.os
    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.o = bdUniqueId;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.m = str;
            mea meaVar = this.l;
            if (meaVar != null) {
                meaVar.setFrom(str);
            }
        }
    }

    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.n = str;
            mea meaVar = this.l;
            if (meaVar != null) {
                meaVar.setStageType(str);
            }
        }
    }

    public void z(os.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.e = aVar;
        }
    }

    @Override // com.baidu.tieba.os
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f == null) {
                if (TbadkCoreApplication.getInst().getPersonalizeViewData().k != null && TbadkCoreApplication.getInst().getPersonalizeViewData().k.getParent() == null) {
                    this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().k;
                } else {
                    this.f = LayoutInflater.from(this.b).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                }
                this.g = (TextView) this.f.findViewById(R.id.video_seg_title);
                this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.frame_video);
                this.j = (RoundRelativeLayout) this.f.findViewById(R.id.download_guide_layout);
                mea t = t();
                this.l = t;
                t.setUniqueId(this.o);
                this.l.setFrom(this.m);
                this.l.setStageType(this.n);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qda
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.l.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qda
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            fw4 fw4Var = this.h;
            if (fw4Var != null && fw4Var.getThreadData() != null) {
                return this.h.getThreadData().getVideoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qda
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qda
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            mea meaVar = this.l;
            if (meaVar == null) {
                return false;
            }
            return meaVar.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qda
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qda
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public mea s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.l;
        }
        return (mea) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qda
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Context context = this.b;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.l.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.qda
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l.stopPlay();
        }
    }

    @Override // com.baidu.tieba.os
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i(1, this.u);
            i(2, this.u);
            i(3, this.u);
            i(6, this.u);
            i(7, this.u);
            i(8, this.u);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        fw4 fw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, tbPageContext, i) == null) && (fw4Var = this.h) != null && fw4Var.getThreadData() != null) {
            xl6.l(this.g, this.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.c(i);
            this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
            AbsDownloadGuide absDownloadGuide = this.k;
            if (absDownloadGuide != null) {
                absDownloadGuide.r();
            }
        }
    }

    public final void r(ThreadData threadData) {
        RoundRelativeLayout roundRelativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, threadData) == null) && threadData != null && this.i != null && (roundRelativeLayout = this.j) != null) {
            AbsDownloadGuide c2 = oxa.c(this.b, threadData, roundRelativeLayout, this.k);
            this.k = c2;
            if (c2 == null) {
                this.i.setCornerId(R.string.J_X05);
            } else {
                this.i.setCornerId(R.string.J_X13);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bc, code lost:
        if (r1 != r2) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c1, code lost:
        if (r1 != r2) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c4, code lost:
        r0 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleVerticalVideoSize(r11, r8, r10.l, r0, r1);
     */
    @Override // com.baidu.tieba.it
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(fw4 fw4Var) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fw4Var) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (equipmentWidth != this.p) {
                int equipmentWidth2 = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                w = equipmentWidth2;
                int i = equipmentWidth2 - v;
                x = i;
                y = i / 2;
                z = i / 3;
                this.p = equipmentWidth;
            }
            this.h = fw4Var;
            if (fw4Var != null && fw4Var.getThreadData() != null && this.h.getThreadData().getThreadVideoInfo() != null) {
                this.l.setData(fw4Var.getThreadData());
                r(fw4Var.getThreadData());
                ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
                int i2 = layoutParams.width;
                int i3 = layoutParams.height;
                boolean z4 = false;
                if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                    int i4 = (y / 9) * 16;
                    int i5 = z;
                    int intValue = this.h.getThreadData().getThreadVideoInfo().video_width.intValue();
                    int intValue2 = this.h.getThreadData().getThreadVideoInfo().video_height.intValue();
                    int i6 = y;
                    layoutParams.width = i6;
                    if (i2 != i6) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (intValue != 0 && intValue2 != 0) {
                        int i7 = (int) (((intValue2 * 1.0f) / intValue) * y);
                        if (i7 < i5) {
                            i4 = i5;
                        } else if (i7 <= i4) {
                            i4 = i7;
                        }
                        layoutParams.height = i4;
                    } else {
                        layoutParams.height = i4;
                    }
                } else {
                    int i8 = x;
                    layoutParams.width = i8;
                    int i9 = (i8 / 16) * 9;
                    layoutParams.height = i9;
                    if (i3 == i9 && i2 == i8) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
                if (z2) {
                    if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                        this.i.setLayoutParams(layoutParams);
                    } else {
                        this.i.post(new a(this, layoutParams));
                    }
                }
                RoundRelativeLayout roundRelativeLayout = this.j;
                if (roundRelativeLayout != null) {
                    roundRelativeLayout.getLayoutParams().width = layoutParams.width;
                }
                if (this.h.getThreadData().isBJHVideoDynamicThreadType()) {
                    this.g.setMaxLines(5);
                    ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), x, this.q);
                } else {
                    this.g.setMaxLines(2);
                    ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), x, 2, this.q);
                }
                TextView textView = this.g;
                ThreadCardUtils.dealMainViewTopMargin(this.i, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
                if (this.e != null) {
                    this.l.setJumpToPbClickListener(this.s);
                }
                if (d() != null) {
                    this.l.setAfterClickListener(this.t);
                }
                TextView textView2 = this.g;
                if (textView2 != null && this.f != null) {
                    textView2.setOnClickListener(this.r);
                    this.g.setMovementMethod(LinkMovementMethod.getInstance());
                    this.f.setOnClickListener(this.r);
                }
            }
        }
    }
}
