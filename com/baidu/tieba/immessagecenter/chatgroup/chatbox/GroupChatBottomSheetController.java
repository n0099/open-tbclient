package com.baidu.tieba.immessagecenter.chatgroup.chatbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.ds6;
import com.baidu.tieba.ex9;
import com.baidu.tieba.gd8;
import com.baidu.tieba.hd8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jd8;
import com.baidu.tieba.m75;
import com.baidu.tieba.oc8;
import com.baidu.tieba.rc8;
import com.baidu.tieba.sc8;
import com.baidu.tieba.tc8;
import com.baidu.tieba.tm5;
import com.baidu.tieba.um5;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.tieba.wg;
import com.baidu.tieba.yc8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GroupChatBottomSheetController {
    public static /* synthetic */ Interceptable $ic;
    public static final int l0;
    public static final int m0;
    public static final int n0;
    public static final int o0;
    public static String p0;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> A;
    public int B;
    public int C;
    public int D;
    public TextView E;
    public hd8 F;
    public gd8 G;
    public RecyclerView H;
    public String I;
    public List<String> J;
    public boolean K;
    public LinearLayout L;
    public ImageView M;
    public EMTextView N;
    public String O;
    public LinearLayout P;
    public ImageView Q;
    public EMTextView R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public String f1126T;
    public boolean U;
    public BaManagerState V;
    public TbImageAutoSwitch.b W;
    public NoDataView X;
    public RelativeLayout Y;
    public RelativeLayout Z;
    public final Context a;
    public um5 a0;
    public final TbPageContext b;
    @Nullable
    public oc8 b0;
    public RelativeLayout c;
    public tm5 c0;
    public TbImageAutoSwitch d;
    public View.OnClickListener d0;
    public HeadImageView e;
    @NonNull
    public oc8.c e0;
    public BottomSheetDialog f;
    public CustomMessageListener f0;
    public FrameLayout g;
    public RecyclerView.OnScrollListener g0;
    public RelativeLayout h;
    public CustomMessageListener h0;
    public RelativeLayout i;
    public View.OnClickListener i0;
    public LinearLayout j;
    public View.OnClickListener j0;
    public TextView k;
    public Runnable k0;
    public TextView l;
    public ImageView m;
    public RecyclerView n;
    public LinearLayoutManager o;
    public rc8 p;
    public ChatRoomRecycleAdapter q;
    public sc8 r;
    public View s;
    public View t;
    public View u;
    public long v;
    public String w;
    public long x;
    public boolean y;
    public boolean z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class BaManagerState {
        public static final /* synthetic */ BaManagerState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BaManagerState NONE;
        public static final BaManagerState REQUESTING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1695417034, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/GroupChatBottomSheetController$BaManagerState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1695417034, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/GroupChatBottomSheetController$BaManagerState;");
                    return;
                }
            }
            REQUESTING = new BaManagerState("REQUESTING", 0);
            BaManagerState baManagerState = new BaManagerState(HlsPlaylistParser.METHOD_NONE, 1);
            NONE = baManagerState;
            $VALUES = new BaManagerState[]{REQUESTING, baManagerState};
        }

        public BaManagerState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static BaManagerState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (BaManagerState) Enum.valueOf(BaManagerState.class, str);
            }
            return (BaManagerState) invokeL.objValue;
        }

        public static BaManagerState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (BaManagerState[]) $VALUES.clone();
            }
            return (BaManagerState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public a(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public b(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.H != null && this.a.F != null && this.a.F.a() != null) {
                this.a.F.a().setLocationScrolled(false);
                this.a.H.getAdapter().notifyItemChanged(this.a.B);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BottomSheetDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(GroupChatBottomSheetController groupChatBottomSheetController, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onAttachedToWindow();
                this.a.h0();
            }
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onDetachedFromWindow();
                this.a.e0();
                this.a.V = BaManagerState.NONE;
                this.a.U = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupChatBottomSheetController groupChatBottomSheetController, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController, context};
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
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public e(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // com.baidu.tieba.yc8
        public void a(long j, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && this.a.b0 != null) {
                this.a.b0.p(j, i);
                this.a.b0.n(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends SimpleTarget<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public f(GroupChatBottomSheetController groupChatBottomSheetController, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.request.target.Target
        /* renamed from: a */
        public void onResourceReady(@NonNull Drawable drawable, @Nullable Transition<? super Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, drawable, transition) == null) {
                this.a.setBackground(drawable);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public g(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                ((HeadImageView) view2).N(this.a.J.get(i), 10, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.a);
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(GroupChatBottomSheetController.l0, GroupChatBottomSheetController.l0));
                headImageView.setBorderWidth(GroupChatBottomSheetController.m0);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0101));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.J.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public h(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.a0 != null) {
                    this.a.a0.dettachView(this.a.Z);
                    this.a.a0 = null;
                }
                if (this.a.b0 != null) {
                    this.a.m0();
                    this.a.i0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements oc8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public i(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // com.baidu.tieba.oc8.c
        public void a(List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i != 0) {
                    this.a.n0();
                    this.a.j.setVisibility(8);
                    return;
                }
                this.a.X();
                this.a.W();
                this.a.j.setVisibility(0);
                if (!ListUtils.isEmpty(list)) {
                    this.a.Y();
                    if (this.a.n != null) {
                        this.a.n.setVisibility(0);
                    }
                    if (list.get(0) instanceof jd8) {
                        jd8 jd8Var = (jd8) list.remove(0);
                        if (jd8Var != null && jd8Var.b() != null) {
                            this.a.J = jd8Var.b();
                            if (this.a.J.size() == 1) {
                                this.a.e.setVisibility(0);
                                this.a.d.setVisibility(8);
                                GroupChatBottomSheetController groupChatBottomSheetController = this.a;
                                groupChatBottomSheetController.e.N(groupChatBottomSheetController.J.get(0), 10, false);
                            } else {
                                this.a.d.setVisibility(0);
                                this.a.e.setVisibility(8);
                                this.a.d.p();
                            }
                        } else {
                            this.a.d.setVisibility(8);
                            this.a.e.setVisibility(8);
                            this.a.p0();
                        }
                        if (jd8Var != null && jd8Var.c() != null) {
                            this.a.l.setText(jd8Var.c());
                        }
                        if (jd8Var != null && jd8Var.a() != null) {
                            this.a.O = jd8Var.a();
                        }
                        if (jd8Var != null && jd8Var.e() != null) {
                            this.a.S = jd8Var.e();
                        }
                        if (jd8Var != null && !StringUtils.isNull(jd8Var.d())) {
                            this.a.f1126T = jd8Var.d();
                            if (this.a.z && this.a.f1126T.equals(GroupChatBottomSheetController.p0)) {
                                this.a.L.setVisibility(0);
                                this.a.P.setVisibility(0);
                            } else {
                                this.a.L.setVisibility(8);
                                this.a.P.setVisibility(8);
                            }
                        }
                    }
                    if (this.a.p != null) {
                        if (!this.a.U) {
                            this.a.p.j(list, this.a.y);
                        } else {
                            this.a.U = false;
                            this.a.p.k(list, this.a.y);
                        }
                        this.a.k0();
                    }
                } else {
                    this.a.o0();
                }
                this.a.V = BaManagerState.NONE;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(GroupChatBottomSheetController groupChatBottomSheetController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.U = true;
        }
    }

    /* loaded from: classes6.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public k(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLII(1048576, this, recyclerView, i, i2) != null) || !this.a.K) {
                return;
            }
            this.a.K = false;
            if (this.a.o.findViewByPosition(this.a.C) != null) {
                GroupChatBottomSheetController groupChatBottomSheetController = this.a;
                groupChatBottomSheetController.D = groupChatBottomSheetController.o.findViewByPosition(this.a.C).getTop();
            }
            this.a.n.scrollBy(0, (this.a.V() - this.a.T()) + this.a.D);
            this.a.D = 0;
            this.a.Z();
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(GroupChatBottomSheetController groupChatBottomSheetController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001266 && (customResponsedMessage.getData() instanceof ex9)) {
                GroupChatBottomSheetController groupChatBottomSheetController = this.a;
                boolean z = true;
                if (((ex9) customResponsedMessage.getData()).n() != 1) {
                    z = false;
                }
                groupChatBottomSheetController.y = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public m(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.O != null) {
                UrlManager.getInstance().dealOneLink(this.a.b, new String[]{this.a.O});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public n(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b0 != null) {
                this.a.b0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public o(GroupChatBottomSheetController groupChatBottomSheetController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {groupChatBottomSheetController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = groupChatBottomSheetController;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.S != null) {
                UrlManager.getInstance().dealOneLink(this.a.b, new String[]{this.a.S});
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(964510809, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/GroupChatBottomSheetController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(964510809, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/GroupChatBottomSheetController;");
                return;
            }
        }
        l0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        m0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        n0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        o0 = vi.g(TbadkApplication.getInst(), R.dimen.tbds600);
        p0 = "1";
    }

    public final int V() {
        InterceptResult invokeV;
        RecyclerView recyclerView;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.p.getItemsCount() <= 0 || this.B <= 0 || (recyclerView = this.n) == null || (viewGroup = (ViewGroup) recyclerView.getChildAt(0)) == null || viewGroup.findViewById(R.id.obfuscated_res_0x7f090e86) == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f090e86)) == null || viewGroup2.getChildAt(0) == null) {
                return 0;
            }
            return viewGroup2.getChildAt(0).getHeight() * (this.B + 1);
        }
        return invokeV.intValue;
    }

    public final void Z() {
        ViewGroup viewGroup;
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (viewGroup = (ViewGroup) this.o.findViewByPosition(this.C)) != null) {
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090e86);
            this.H = recyclerView;
            if (recyclerView != null && recyclerView.getChildAt(this.B) != null && (hd8Var = this.F) != null && hd8Var.a() != null) {
                this.F.a().setLocationScrolled(true);
                this.H.getAdapter().notifyItemChanged(this.B);
                this.H.postDelayed(this.k0, 3000L);
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003023, "show_ok"));
            wg.a().post(new n(this));
            rc8 rc8Var = this.p;
            if (rc8Var != null) {
                rc8Var.o();
            }
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                if (recyclerView.getRecycledViewPool() != null) {
                    this.n.getRecycledViewPool().clear();
                }
                this.n.removeAllViews();
            }
            R();
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            W();
            if (this.a0 == null) {
                this.a0 = new um5(this.a, this.d0);
            }
            this.a0.k(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds300));
            this.a0.attachView(this.Z, true);
            this.a0.p();
            this.a0.onChangeSkinType();
            this.a0.f(R.color.transparent);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.X == null) {
                this.X = NoDataViewFactory.b(this.a, this.Y, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, 400), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0943)), null, true);
            }
            this.X.f(this.b, TbadkApplication.getInst().getSkinType());
            this.X.setVisibility(0);
        }
    }

    public GroupChatBottomSheetController(TbPageContext tbPageContext, long j2, String str, long j3, List<Long> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j2), str, Long.valueOf(j3), list, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.A = new ArrayList();
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.H = null;
        this.I = "1";
        this.K = false;
        this.U = false;
        this.V = BaManagerState.NONE;
        this.W = new g(this);
        this.d0 = new h(this);
        this.e0 = new i(this);
        this.f0 = new j(this, 2921778);
        this.g0 = new k(this);
        this.h0 = new l(this, 2001266);
        this.i0 = new m(this);
        this.j0 = new o(this);
        this.k0 = new b(this);
        this.a = tbPageContext.getContext();
        this.b = tbPageContext;
        this.v = j2;
        this.w = str;
        this.x = j3;
        this.z = z2;
        if (list != null) {
            this.A.addAll(list);
        }
        this.y = z;
        MessageManager.getInstance().registerListener(this.h0);
        MessageManager.getInstance().registerListener(this.f0);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = -1L;
            this.K = false;
        }
    }

    public final String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public final int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = this.Y;
            if (relativeLayout != null && this.n != null) {
                return (relativeLayout.getHeight() / 2) - this.n.getTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void W() {
        tm5 tm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (tm5Var = this.c0) != null) {
            tm5Var.dettachView(this.Z);
        }
    }

    public void X() {
        um5 um5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (um5Var = this.a0) != null) {
            um5Var.dettachView(this.Z);
            this.a0 = null;
        }
    }

    public void Y() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (noDataView = this.X) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BottomSheetDialog bottomSheetDialog = this.f;
            if (bottomSheetDialog != null && bottomSheetDialog.isShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void f0() {
        oc8 oc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && b0() && (oc8Var = this.b0) != null) {
            oc8Var.f();
        }
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.b0 != null) {
                m0();
                i0();
                Y();
            } else {
                o0();
            }
            Q();
        }
    }

    public final void i0() {
        oc8 oc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (oc8Var = this.b0) != null && this.V != BaManagerState.REQUESTING) {
            oc8Var.x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.v));
            this.V = BaManagerState.REQUESTING;
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f == null) {
                a0();
            }
            this.f.show();
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.c0 == null) {
                tm5 tm5Var = new tm5(this.a);
                this.c0 = tm5Var;
                tm5Var.onChangeSkinType();
            }
            this.c0.attachView(this.Z);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.v);
            statisticItem.param("fname", this.w);
            statisticItem.param("obj_source", S());
            TiebaStatic.log(statisticItem);
        }
    }

    public void d0() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            oc8 oc8Var = this.b0;
            if (oc8Var != null) {
                oc8Var.j();
            }
            this.V = BaManagerState.NONE;
            this.U = false;
            Runnable runnable = this.k0;
            if (runnable != null && (recyclerView = this.H) != null) {
                recyclerView.removeCallbacks(runnable);
            }
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.f0);
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !b0()) {
            return;
        }
        oc8 oc8Var = this.b0;
        if (oc8Var != null) {
            oc8Var.k();
        }
        if (this.U) {
            i0();
        }
        if (this.V != BaManagerState.REQUESTING && this.p != null) {
            wg.a().post(new a(this));
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090e7b);
            layoutParams.leftMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
            layoutParams.topMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            this.j.setLayoutParams(layoutParams);
        }
    }

    public final int U() {
        InterceptResult invokeV;
        rc8 rc8Var;
        hd8 hd8Var;
        ChatRoomInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.x > 0 && (rc8Var = this.p) != null && !ListUtils.isEmpty(rc8Var.d())) {
                List<tc8> d2 = this.p.d();
                for (tc8 tc8Var : d2) {
                    if (tc8Var != null && (tc8Var instanceof gd8)) {
                        gd8 gd8Var = (gd8) tc8Var;
                        List<tc8> subItems = gd8Var.getSubItems();
                        if (ListUtils.isEmpty(subItems)) {
                            continue;
                        } else {
                            for (tc8 tc8Var2 : subItems) {
                                if (tc8Var2 != null && (tc8Var2 instanceof hd8) && (a2 = (hd8Var = (hd8) tc8Var2).a()) != null && this.x == a2.getRoomId()) {
                                    this.B = subItems.indexOf(tc8Var2);
                                    this.C = d2.indexOf(tc8Var);
                                    this.F = hd8Var;
                                    this.G = gd8Var;
                                    gd8Var.g(false);
                                    return d2.indexOf(tc8Var);
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !(this.a instanceof TbPageContextSupport)) {
            return;
        }
        this.f = new c(this, this.a, R.style.obfuscated_res_0x7f1000fe);
        this.g = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03cc, (ViewGroup) null);
        GreyUtil.grey(this.f);
        this.h = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090e8a);
        this.i = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090e6e);
        this.E = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090e70);
        this.Y = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0918d5);
        this.Z = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0918de);
        this.s = this.g.findViewById(R.id.obfuscated_res_0x7f090e8b);
        this.m = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090e87);
        this.t = this.g.findViewById(R.id.obfuscated_res_0x7f09115a);
        this.u = this.g.findViewById(R.id.obfuscated_res_0x7f0914f9);
        this.n = (RecyclerView) this.g.findViewById(R.id.obfuscated_res_0x7f090e6d);
        d dVar = new d(this, this.a);
        this.o = dVar;
        this.n.setLayoutManager(dVar);
        rc8 rc8Var = new rc8(this.b, this.v, this.y);
        this.p = rc8Var;
        rc8Var.p(new e(this));
        sc8 sc8Var = new sc8(null);
        this.r = sc8Var;
        ChatRoomRecycleAdapter chatRoomRecycleAdapter = new ChatRoomRecycleAdapter(sc8Var, this.p, this.b);
        this.q = chatRoomRecycleAdapter;
        this.n.setAdapter(chatRoomRecycleAdapter);
        this.n.removeOnScrollListener(this.g0);
        this.n.addOnScrollListener(this.g0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090e79);
        this.k = textView;
        this.k.setText(MeasureTextLength.fitTextLabel(this.w, "...吧", MeasureTextLength.spaceLength(o0), textView.getPaint(), "吧"));
        this.j = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090e63);
        this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091b67);
        this.L = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090800);
        this.M = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090802);
        this.N = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f090801);
        this.L.setOnClickListener(this.i0);
        this.P = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09167c);
        this.Q = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09167e);
        this.R = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f09167d);
        this.P.setOnClickListener(this.j0);
        this.L.setVisibility(8);
        this.P.setVisibility(8);
        this.c = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090777);
        this.d = (TbImageAutoSwitch) this.g.findViewById(R.id.obfuscated_res_0x7f090778);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09077c);
        this.e = headImageView;
        headImageView.setPlaceHolder(1);
        this.e.setIsRound(true);
        this.e.setBorderWidth(SelectorHelper.getResources().getDimensionPixelSize(R.dimen.L_X02));
        this.e.setBorderColor(R.color.CAM_X0101);
        this.e.setDrawBorder(true);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        TbImageAutoSwitch tbImageAutoSwitch = this.d;
        int i2 = l0;
        tbImageAutoSwitch.l(4, i2, i2, n0);
        this.d.setAnimationDuration(500);
        this.d.setCarouselDelayPeriod(2000);
        this.d.setCarouselPeriod(2000);
        this.d.setAdapter(this.W);
        this.f.setContentView(this.g);
        if (this.f.getWindow() != null && this.f.getWindow().getAttributes() != null) {
            int i3 = this.f.getWindow().getAttributes().windowAnimations;
        }
        c0(TbadkCoreApplication.getInst().getSkinType());
        int height = ((WindowManager) this.a.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getHeight();
        int i4 = (height * 9) / 10;
        if (UtilHelper.isFoldScreen()) {
            i4 = (height * 10) / 8;
        }
        this.f.getBehavior().setPeekHeight(i4);
        int dimenPixelSize = i4 - UtilHelper.getDimenPixelSize(R.dimen.tbds318);
        this.i.getLayoutParams().height = dimenPixelSize;
        this.t.getLayoutParams().height = dimenPixelSize;
        this.u.getLayoutParams().height = dimenPixelSize;
        this.Z.getLayoutParams().height = dimenPixelSize;
        this.Y.getLayoutParams().height = dimenPixelSize;
        this.b0 = new oc8(this.a, this.e0);
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f090ec4);
        if (findViewById != null) {
            Glide.with(findViewById).load(ds6.b("group_list_head_bcg_pic.webp", "group_list_head_bcg_pic")).into((RequestBuilder<Drawable>) new f(this, findViewById));
        }
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i2) != null) || this.f == null) {
            return;
        }
        m75.d(this.g).o(R.string.deprecated_J_X18);
        m75 d2 = m75.d(this.s);
        d2.n(0);
        d2.o(R.string.J_X03);
        d2.f(R.color.CAM_X0618);
        m75 d3 = m75.d(this.k);
        d3.w(R.color.CAM_X0101);
        d3.B(R.dimen.T_X04);
        d3.C(R.string.F_X02);
        m75 d4 = m75.d(this.l);
        d4.w(R.color.CAM_X0102);
        d4.B(R.dimen.T_X12);
        d4.C(R.string.F_X01);
        m75.d(this.h).o(R.string.deprecated_J_X18);
        m75 d5 = m75.d(this.t);
        d5.o(R.string.deprecated_J_X18);
        d5.f(R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.m, R.drawable.obfuscated_res_0x7f08070a);
        m75.d(this.i).o(R.string.deprecated_J_X18);
        m75 d6 = m75.d(this.E);
        d6.B(R.dimen.T_X07);
        d6.C(R.string.F_X02);
        d6.w(R.color.CAM_X0105);
        m75 d7 = m75.d(this.N);
        d7.B(R.dimen.T_X12);
        d7.C(R.string.F_X01);
        d7.w(R.color.CAM_X0105);
        m75 d8 = m75.d(this.R);
        d8.B(R.dimen.T_X12);
        d8.C(R.string.F_X01);
        d8.w(R.color.CAM_X0105);
        WebPManager.setPureDrawable(this.M, R.drawable.obfuscated_res_0x7f080552, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.Q, R.drawable.obfuscated_res_0x7f080f40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
    }

    public void j0(long j2, String str, long j3, List<Long> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), str, Long.valueOf(j3), list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.x = j3;
            this.v = j2;
            this.w = str;
            this.y = z;
            this.z = z2;
            if (!ListUtils.isEmpty(list)) {
                this.A.clear();
                this.A.addAll(list);
            }
        }
    }

    public void k0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int U = U();
            if (U >= 0 && this.n != null) {
                int findFirstVisibleItemPosition = this.o.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = this.o.findLastVisibleItemPosition();
                if (U >= findFirstVisibleItemPosition && U <= findLastVisibleItemPosition) {
                    this.K = false;
                    if (this.o.findViewByPosition(U) != null) {
                        i2 = this.o.findViewByPosition(U).getTop();
                    } else {
                        i2 = 0;
                    }
                    this.n.scrollBy(0, (i2 - T()) + V());
                    Z();
                    return;
                }
                this.K = true;
                this.o.scrollToPosition(U);
                return;
            }
            LinearLayoutManager linearLayoutManager = this.o;
            if (linearLayoutManager != null && this.n != null) {
                linearLayoutManager.scrollToPosition(0);
            }
        }
    }
}
