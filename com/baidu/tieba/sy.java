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
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.widget.ad.DownloadGuideFull;
import com.baidu.tbadk.widget.ad.DownloadGuidePart;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.vy;
import com.baidu.tieba.ww;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class sy extends ww<q05> implements ct9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static int w;
    public static int x;
    public static int y;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public q05 h;
    public RoundCornerFrameLayout i;
    public RoundRelativeLayout j;
    public AbsDownloadGuide k;
    public yt9 l;
    public String m;
    public String n;
    public BdUniqueId o;
    public int p;
    public boolean q;
    public View.OnClickListener r;
    public final View.OnClickListener s;
    public final View.OnClickListener t;
    public vy.b u;

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public abstract yt9 x();

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ sy b;

        public a(sy syVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = syVar;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q05 q05Var = this.b.h;
                if (q05Var != null && q05Var.getThreadData().getThreadVideoInfo().is_vertical.intValue() != 1) {
                    this.a.width = this.b.f.getWidth();
                    this.a.height = (this.b.f.getWidth() / 16) * 9;
                }
                this.b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;

        public b(sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            q05 q05Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (q05Var = this.a.h) != null && q05Var.getThreadData() != null) {
                Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.i);
                sy syVar = this.a;
                Context context = syVar.b;
                ThreadData threadData = syVar.h.getThreadData();
                sy syVar2 = this.a;
                String str = syVar2.m;
                vv5.c(false, context, threadData, 0, computeViewArea, "from_nani_video", "personalize_page", "", str, str, syVar2.h.getThreadData().isJumpToFrsVideoTabPlay);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;

        public c(sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            sy syVar;
            ww.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (syVar = this.a).e) != null) {
                aVar.a(syVar.h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;

        public d(sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.h() != null) {
                this.a.h().a(view2, this.a.h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements vy.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy a;

        public e(sy syVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {syVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = syVar;
        }

        @Override // com.baidu.tieba.vy.b
        public boolean a(vy.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.b() == 1) {
                    sy syVar = this.a;
                    om6.l(syVar.g, syVar.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (aVar.b() == 2) {
                    yt9 yt9Var = this.a.l;
                    if (yt9Var != null) {
                        yt9Var.onScroll();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 3) {
                    yt9 yt9Var2 = this.a.l;
                    if (yt9Var2 != null) {
                        yt9Var2.onVolumeUp();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 6) {
                    yt9 yt9Var3 = this.a.l;
                    if (yt9Var3 != null) {
                        return yt9Var3.onBackPress();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317447, "Lcom/baidu/tieba/sy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317447, "Lcom/baidu/tieba/sy;");
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
    public sy(Context context) {
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

    public void B(ww.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void C(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.q = z2;
        }
    }

    public void D(tt9 tt9Var) {
        yt9 yt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, tt9Var) == null) && (yt9Var = this.l) != null) {
            yt9Var.setStatistic(tt9Var);
        }
    }

    @Override // com.baidu.tieba.ww
    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
            this.o = bdUniqueId;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.m = str;
            yt9 yt9Var = this.l;
            if (yt9Var != null) {
                yt9Var.setFrom(str);
            }
        }
    }

    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.n = str;
            yt9 yt9Var = this.l;
            if (yt9Var != null) {
                yt9Var.setStageType(str);
            }
        }
    }

    @Override // com.baidu.tieba.ct9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ct9
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            q05 q05Var = this.h;
            if (q05Var != null && q05Var.getThreadData() != null) {
                return this.h.getThreadData().getVideoUrl();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ct9
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ct9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            yt9 yt9Var = this.l;
            if (yt9Var == null) {
                return false;
            }
            return yt9Var.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ct9
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.l.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ct9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ct9
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Context context = this.b;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.l.startPlay();
            }
        }
    }

    @Override // com.baidu.tieba.ct9
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l.stopPlay();
        }
    }

    public yt9 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.l;
        }
        return (yt9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f == null) {
                if (TbadkCoreApplication.getInst().getPersonalizeViewData().k != null && TbadkCoreApplication.getInst().getPersonalizeViewData().k.getParent() == null) {
                    this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().k;
                } else {
                    this.f = LayoutInflater.from(this.b).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
                }
                this.g = (TextView) this.f.findViewById(R.id.video_seg_title);
                this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.frame_video);
                this.j = (RoundRelativeLayout) this.f.findViewById(R.id.download_guide_layout);
                yt9 x2 = x();
                this.l = x2;
                x2.setUniqueId(this.o);
                this.l.setFrom(this.m);
                this.l.setStageType(this.n);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ww
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            m(1, this.u);
            m(2, this.u);
            m(3, this.u);
            m(6, this.u);
            m(7, this.u);
            m(8, this.u);
        }
    }

    @Override // com.baidu.tieba.rx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        q05 q05Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048589, this, tbPageContext, i) == null) && (q05Var = this.h) != null && q05Var.getThreadData() != null) {
            om6.l(this.g, this.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
            this.i.c(i);
            this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
            AbsDownloadGuide absDownloadGuide = this.k;
            if (absDownloadGuide != null) {
                absDownloadGuide.q();
            }
        }
    }

    public final void t(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, threadData) == null) {
            String convertBtnType = threadData.getConvertBtnType();
            if (StringUtils.isNotNull(convertBtnType)) {
                if (this.k == null) {
                    if ("a".equals(convertBtnType)) {
                        this.k = new DownloadGuidePart(this.b);
                    } else if ("b".equals(convertBtnType)) {
                        this.k = new DownloadGuideFull(this.b);
                    }
                }
                if (this.k == null) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.i;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.setCornerId(R.string.J_X05);
                    }
                    RoundRelativeLayout roundRelativeLayout = this.j;
                    if (roundRelativeLayout != null) {
                        roundRelativeLayout.setVisibility(8);
                        return;
                    }
                    return;
                }
                RoundCornerFrameLayout roundCornerFrameLayout2 = this.i;
                if (roundCornerFrameLayout2 != null) {
                    roundCornerFrameLayout2.setCornerId(R.string.J_X13);
                }
                RoundRelativeLayout roundRelativeLayout2 = this.j;
                if (roundRelativeLayout2 != null) {
                    roundRelativeLayout2.setRoundLayoutRadius(w65.B(R.string.J_X16));
                    this.j.setVisibility(0);
                }
                AbsDownloadGuide absDownloadGuide = this.k;
                if (absDownloadGuide != null) {
                    if (absDownloadGuide.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.k.getParent()).removeAllViews();
                    }
                    this.k.setData(threadData);
                    RoundRelativeLayout roundRelativeLayout3 = this.j;
                    if (roundRelativeLayout3 != null) {
                        roundRelativeLayout3.addView(this.k);
                        return;
                    }
                    return;
                }
                return;
            }
            RoundCornerFrameLayout roundCornerFrameLayout3 = this.i;
            if (roundCornerFrameLayout3 != null) {
                roundCornerFrameLayout3.setCornerId(R.string.J_X05);
            }
            RoundRelativeLayout roundRelativeLayout4 = this.j;
            if (roundRelativeLayout4 != null) {
                roundRelativeLayout4.setVisibility(8);
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
    @Override // com.baidu.tieba.qx
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(q05 q05Var) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, q05Var) == null) {
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
            this.h = q05Var;
            if (q05Var != null && q05Var.getThreadData() != null && this.h.getThreadData().getThreadVideoInfo() != null) {
                this.l.setData(q05Var.getThreadData());
                t(q05Var.getThreadData());
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
                if (h() != null) {
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
