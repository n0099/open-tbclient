package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ax;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class vy extends hx {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public Context k;
    public b15 l;
    public VideoImageNoPlayerLayout m;
    public int n;
    public String o;
    public int p;
    public ez q;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;

        public a(vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vyVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            vy vyVar;
            ax.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = (vyVar = this.a).e) != null) {
                aVar.a(vyVar.l);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ez {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;

        public b(vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.ez
        public void a(b15 b15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) && this.a.q != null) {
                this.a.q.a(this.a.l);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320330, "Lcom/baidu/tieba/vy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320330, "Lcom/baidu/tieba/vy;");
                return;
            }
        }
        r = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
        s = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vy(Context context) {
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
        int i3 = s;
        this.h = i3;
        this.i = i3 / 2;
        this.j = i3 / 3;
        this.n = 0;
        this.p = 3;
        this.k = context;
        this.m = new VideoImageNoPlayerLayout(context);
        r(Boolean.TRUE);
    }

    public void C(ax.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void D(ez ezVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ezVar) == null) {
            this.q = ezVar;
            if (ezVar != null) {
                E();
            }
        }
    }

    @Override // com.baidu.tieba.ax
    public void o(mp6<b15> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, mp6Var) == null) {
            super.o(mp6Var);
            this.m.setOnCardSubClickListener(mp6Var);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.o = str;
        }
    }

    public Rect A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ThreadCardUtils.computeViewArea(this.m.c);
        }
        return (Rect) invokeV.objValue;
    }

    public final void E() {
        VideoImageNoPlayerLayout videoImageNoPlayerLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (videoImageNoPlayerLayout = this.m) != null) {
            videoImageNoPlayerLayout.setVideoAreaClickListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
        if (r3 != r11.height) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
        if (r3 != r11.height) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f4, code lost:
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
        r1 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleTransmitVerticalVideoSize(r11, r0, r2, r3, r5);
     */
    @Override // com.baidu.tieba.ux
    /* renamed from: B */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b15Var) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            if (equipmentWidth != this.n) {
                s = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                if (!"pb".equals(this.o)) {
                    this.h = s - r;
                } else {
                    this.h = s;
                }
                int i = this.h;
                this.i = i / 2;
                this.j = i / 3;
                this.n = equipmentWidth;
            }
            this.l = b15Var;
            if (b15Var != null && b15Var.getThreadData() != null && this.l.getThreadData().originalThreadData != null && !this.l.getThreadData().originalThreadData.m && !this.l.getThreadData().shouldShowBlockedState()) {
                boolean z = false;
                this.m.setVisibility(0);
                this.m.onBindDataToView(b15Var);
                ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.m.j.getLayoutParams();
                int i2 = layoutParams.width;
                int i3 = layoutParams.height;
                boolean z2 = true;
                if (this.l.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                    VideoInfo videoInfo = this.l.getThreadData().originalThreadData.r;
                    if (videoInfo == null) {
                        return;
                    }
                    int i4 = (this.i / 9) * 16;
                    int i5 = this.j;
                    int intValue = videoInfo.video_width.intValue();
                    int intValue2 = videoInfo.video_height.intValue();
                    layoutParams.width = this.h;
                    layoutParams2.width = this.i;
                    if (i2 != layoutParams.width) {
                        z = true;
                    }
                    if (intValue != 0 && intValue2 != 0) {
                        int i6 = (int) (((intValue2 * 1.0f) / intValue) * this.i);
                        if (i6 < i5) {
                            i4 = i5;
                        } else if (i6 <= i4) {
                            i4 = i6;
                        }
                        layoutParams.height = i4;
                        layoutParams2.height = i4;
                    } else {
                        layoutParams.height = i4;
                        layoutParams2.height = i4;
                    }
                } else {
                    int i7 = this.h;
                    layoutParams.width = i7;
                    layoutParams2.width = i7;
                    layoutParams.height = ((i7 / 16) * 9) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                    layoutParams2.height = ((this.h / 16) * 9) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                    if (i3 != layoutParams.height || i2 != layoutParams.width) {
                        z = true;
                    }
                }
                if (z) {
                    this.m.setLayoutParams(layoutParams);
                    this.m.j.setLayoutParams(layoutParams2);
                }
                this.m.setJumpToPbListener(new a(this));
                this.m.setData(this.l);
                g();
                return;
            }
            this.m.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbPageContext, i) == null) {
            if (this.p != i) {
                this.m.g(tbPageContext, i);
            }
            this.p = i;
        }
    }
}
