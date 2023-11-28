package com.baidu.tieba.pb.pb.main.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d6a;
import com.baidu.tieba.nwa;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.adapter.PbChatGuideFloorAdapter;
import com.baidu.tieba.tz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AichatBotCommentCard;
import tbclient.ChatContent;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0014¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbChatGuideFloorAdapter;", "Lcom/baidu/tieba/pb/pb/main/PbCommenFloorItemAdapter;", "activity", "Lcom/baidu/tieba/pb/videopb/PbCompatible;", "mType", "Lcom/baidu/adp/BdUniqueId;", "(Lcom/baidu/tieba/pb/videopb/PbCompatible;Lcom/baidu/adp/BdUniqueId;)V", "fillTopRightButton", "", "holder", "Lcom/baidu/tieba/pb/pb/main/PbCommenFloorItemViewHolder;", "postData", "Lcom/baidu/tieba/tbadkCore/data/PostData;", "initRightTopButtonBackground", "initRightTopButtonText", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onFillViewHolder", "Landroid/view/View;", CriusAttrConstants.POSITION, "", "convertView", "data", "viewHolder", "Companion", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbChatGuideFloorAdapter extends tz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final a C;
    public static final Lazy<Integer> D;
    public static final Lazy<Integer> E;
    public static final Lazy<Integer> F;
    public static final Lazy<Integer> G;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static final void L0(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            C.e(i, str, i2);
        }
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return ((Number) PbChatGuideFloorAdapter.D.getValue()).intValue();
            }
            return invokeV.intValue;
        }

        public final int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ((Number) PbChatGuideFloorAdapter.F.getValue()).intValue();
            }
            return invokeV.intValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ((Number) PbChatGuideFloorAdapter.G.getValue()).intValue();
            }
            return invokeV.intValue;
        }

        public final int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return ((Number) PbChatGuideFloorAdapter.E.getValue()).intValue();
            }
            return invokeV.intValue;
        }

        public static /* synthetic */ void f(a aVar, int i, String str, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            aVar.e(i, str, i2);
        }

        @JvmStatic
        public final void e(int i, String uk, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), uk, Integer.valueOf(i2)}) == null) {
                Intrinsics.checkNotNullParameter(uk, "uk");
                new StatisticItem("c15567").param("obj_type", i).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", uk).param("obj_source", i2).eventStat();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1802950034, "Lcom/baidu/tieba/pb/pb/main/adapter/PbChatGuideFloorAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1802950034, "Lcom/baidu/tieba/pb/pb/main/adapter/PbChatGuideFloorAdapter;");
                return;
            }
        }
        C = new a(null);
        D = LazyKt__LazyJVMKt.lazy(PbChatGuideFloorAdapter$Companion$BOTTOM_LINE_TOP_MARGIN$2.INSTANCE);
        E = LazyKt__LazyJVMKt.lazy(PbChatGuideFloorAdapter$Companion$RIGHT_TOP_BUTTON_MIN_WIDTH$2.INSTANCE);
        F = LazyKt__LazyJVMKt.lazy(PbChatGuideFloorAdapter$Companion$RIGHT_TOP_BUTTON_HEIGHT$2.INSTANCE);
        G = LazyKt__LazyJVMKt.lazy(PbChatGuideFloorAdapter$Companion$RIGHT_TOP_BUTTON_HORIZONTAL_MARGIN$2.INSTANCE);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbChatGuideFloorAdapter(d6a d6aVar, BdUniqueId bdUniqueId) {
        super(d6aVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d6aVar, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d6a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static final void I0(nwa nwaVar, String uk, View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, nwaVar, uk, view2) == null) {
            Intrinsics.checkNotNullParameter(uk, "$uk");
            ChatContent B = nwaVar.B();
            if (B != null) {
                String str = B.scheme;
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    C.e(2, uk, 2);
                    UrlManager.getInstance().dealOneLink(B.scheme);
                }
            }
        }
    }

    public final void H0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final nwa nwaVar) {
        String str;
        boolean z;
        final String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, nwaVar) == null) && pbCommenFloorItemViewHolder != null && nwaVar != null && nwaVar.D0()) {
            pbCommenFloorItemViewHolder.c0.setVisibility(0);
            pbCommenFloorItemViewHolder.d0.setVisibility(8);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.D0.setVisibility(8);
            ChatContent B = nwaVar.B();
            String str4 = null;
            if (B != null) {
                str = B.btn_text;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AichatBotCommentCard s = nwaVar.s();
                if (s != null) {
                    str2 = s.uk;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                }
                EMManager.from(pbCommenFloorItemViewHolder.A0).setTextColor(R.color.CAM_X0304);
                pbCommenFloorItemViewHolder.A0.setText(StringHelper.cutChineseAndEnglishWithEmoji(str, 12, ""));
                pbCommenFloorItemViewHolder.z0.setVisibility(0);
                pbCommenFloorItemViewHolder.z0.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.s1a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            PbChatGuideFloorAdapter.I0(nwa.this, str2, view2);
                        }
                    }
                });
                a aVar = C;
                AichatBotCommentCard s2 = nwaVar.s();
                if (s2 != null) {
                    str4 = s2.uk;
                }
                if (str4 == null) {
                    str3 = str2;
                } else {
                    str3 = str4;
                }
                a.f(aVar, 1, str3, 0, 4, null);
            } else {
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
            }
            ViewGroup.LayoutParams layoutParams = pbCommenFloorItemViewHolder.J.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = C.a();
            }
        }
    }

    public final void J0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder) == null) {
            ViewGroup.LayoutParams layoutParams = pbCommenFloorItemViewHolder.z0.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = C.b();
            pbCommenFloorItemViewHolder.z0.setMinimumWidth(C.d());
            EMManager.from(pbCommenFloorItemViewHolder.z0).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0905);
        }
    }

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder) == null) {
            EMManager.from(pbCommenFloorItemViewHolder.A0).setTextSize(R.dimen.T_X08);
            ViewGroup.LayoutParams layoutParams = pbCommenFloorItemViewHolder.A0.getLayoutParams();
            if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                return;
            }
            int c = C.c();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.leftMargin = c;
            layoutParams2.rightMargin = c;
            pbCommenFloorItemViewHolder.A0.setLayoutParams(layoutParams);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tz9, com.baidu.tieba.ci
    /* renamed from: p0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            PbCommenFloorItemViewHolder holder = super.onCreateViewHolder(viewGroup);
            Intrinsics.checkNotNullExpressionValue(holder, "holder");
            J0(holder);
            K0(holder);
            return holder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tz9, com.baidu.tieba.vz9, com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i, view2, viewGroup, (nwa) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.tz9
    public View q0(int i, View view2, ViewGroup parent, nwa data, PbCommenFloorItemViewHolder viewHolder) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, parent, data, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(view2, "convertView");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.onFillViewHolder(i, view2, parent, data, viewHolder);
            H0(viewHolder, data);
            HeadImageView headImageView = viewHolder.q;
            String str2 = "";
            String str3 = null;
            if (headImageView != null) {
                AichatBotCommentCard s = data.s();
                if (s != null) {
                    str = s.uk;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                headImageView.setTag(R.id.obfuscated_res_0x7f0924cc, str);
            }
            TextView textView = viewHolder.g;
            if (textView != null) {
                AichatBotCommentCard s2 = data.s();
                if (s2 != null) {
                    str3 = s2.uk;
                }
                if (str3 != null) {
                    str2 = str3;
                }
                textView.setTag(R.id.obfuscated_res_0x7f0924cc, str2);
            }
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
