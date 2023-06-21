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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MeasureTextLength;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TBAlertBuilderHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.an5;
import com.baidu.tieba.be8;
import com.baidu.tieba.bz9;
import com.baidu.tieba.gd8;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.jd8;
import com.baidu.tieba.kd8;
import com.baidu.tieba.ks6;
import com.baidu.tieba.ld8;
import com.baidu.tieba.p75;
import com.baidu.tieba.qd8;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.tieba.wi;
import com.baidu.tieba.xg;
import com.baidu.tieba.yd8;
import com.baidu.tieba.zd8;
import com.baidu.tieba.zm5;
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
    public static final int m0;
    public static final int n0;
    public static final int o0;
    public static final int p0;
    public static String q0;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> A;
    public int B;
    public int C;
    public int D;
    public TextView E;
    public zd8 F;
    public yd8 G;
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
    public String f1122T;
    public boolean U;
    public BaManagerState V;
    public TbImageAutoSwitch.b W;
    public NoDataView X;
    public RelativeLayout Y;
    public RelativeLayout Z;
    public final Context a;
    public an5 a0;
    public final TbPageContext b;
    @Nullable
    public gd8 b0;
    public RelativeLayout c;
    public zm5 c0;
    public TbImageAutoSwitch d;
    public View.OnClickListener d0;
    public HeadImageView e;
    @NonNull
    public gd8.c e0;
    public BottomSheetDialog f;
    public CustomMessageListener f0;
    public FrameLayout g;
    public RecyclerView.OnScrollListener g0;
    public RelativeLayout h;
    public CustomMessageListener h0;
    public RelativeLayout i;
    public CustomMessageListener i0;
    public LinearLayout j;
    public View.OnClickListener j0;
    public TextView k;
    public View.OnClickListener k0;
    public TextView l;
    public Runnable l0;
    public ImageView m;
    public RecyclerView n;
    public LinearLayoutManager o;
    public jd8 p;
    public ChatRoomRecycleAdapter q;
    public kd8 r;
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
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.S != null) {
                UrlManager.getInstance().dealOneLink(this.a.b, new String[]{this.a.S});
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public c(GroupChatBottomSheetController groupChatBottomSheetController) {
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
    public class d extends BottomSheetDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(GroupChatBottomSheetController groupChatBottomSheetController, Context context, int i) {
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
                this.a.i0();
            }
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onDetachedFromWindow();
                this.a.f0();
                this.a.V = BaManagerState.NONE;
                this.a.U = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GroupChatBottomSheetController groupChatBottomSheetController, Context context) {
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
    public class f implements qd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public f(GroupChatBottomSheetController groupChatBottomSheetController) {
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

        @Override // com.baidu.tieba.qd8
        public void a(long j, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && this.a.b0 != null) {
                this.a.b0.p(j, i);
                this.a.b0.n(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends SimpleTarget<Drawable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public g(GroupChatBottomSheetController groupChatBottomSheetController, View view2) {
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
    public class h implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

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
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(GroupChatBottomSheetController.m0, GroupChatBottomSheetController.m0));
                headImageView.setBorderWidth(GroupChatBottomSheetController.n0);
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
    public class i implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.a0 != null) {
                    this.a.a0.dettachView(this.a.Z);
                    this.a.a0 = null;
                }
                if (this.a.b0 != null) {
                    this.a.n0();
                    this.a.j0();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements gd8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public j(GroupChatBottomSheetController groupChatBottomSheetController) {
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

        @Override // com.baidu.tieba.gd8.c
        public void a(List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i != 0) {
                    this.a.o0();
                    this.a.j.setVisibility(8);
                    return;
                }
                this.a.Y();
                this.a.X();
                this.a.j.setVisibility(0);
                if (!ListUtils.isEmpty(list)) {
                    this.a.Z();
                    if (this.a.n != null) {
                        this.a.n.setVisibility(0);
                    }
                    if (list.get(0) instanceof be8) {
                        be8 be8Var = (be8) list.remove(0);
                        if (be8Var != null && be8Var.b() != null) {
                            this.a.J = be8Var.b();
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
                            this.a.q0();
                        }
                        if (be8Var != null && be8Var.c() != null) {
                            this.a.l.setText(be8Var.c());
                        }
                        if (be8Var != null && be8Var.a() != null) {
                            this.a.O = be8Var.a();
                        }
                        if (be8Var != null && be8Var.e() != null) {
                            this.a.S = be8Var.e();
                        }
                        if (be8Var != null && !StringUtils.isNull(be8Var.d())) {
                            this.a.f1122T = be8Var.d();
                            if (this.a.z && this.a.f1122T.equals(GroupChatBottomSheetController.q0)) {
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
                        this.a.l0();
                    }
                } else {
                    this.a.p0();
                }
                this.a.V = BaManagerState.NONE;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(GroupChatBottomSheetController groupChatBottomSheetController, int i) {
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
    public class l extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public l(GroupChatBottomSheetController groupChatBottomSheetController) {
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
            this.a.n.scrollBy(0, (this.a.W() - this.a.U()) + this.a.D);
            this.a.D = 0;
            this.a.a0();
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(GroupChatBottomSheetController groupChatBottomSheetController, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001266 && (customResponsedMessage.getData() instanceof bz9)) {
                GroupChatBottomSheetController groupChatBottomSheetController = this.a;
                boolean z = true;
                if (((bz9) customResponsedMessage.getData()).n() != 1) {
                    z = false;
                }
                groupChatBottomSheetController.y = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(GroupChatBottomSheetController groupChatBottomSheetController, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921811 && (customResponsedMessage.getData() instanceof String) && StringHelper.equals((String) customResponsedMessage.getData(), TBAlertBuilderHelper.ACTION_RETURN) && this.a.f.isShowing() && this.a.f != null) {
                this.a.f.dismiss();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.O != null) {
                UrlManager.getInstance().dealOneLink(this.a.b, new String[]{this.a.O});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GroupChatBottomSheetController a;

        public p(GroupChatBottomSheetController groupChatBottomSheetController) {
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
        m0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        n0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        o0 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        p0 = wi.g(TbadkApplication.getInst(), R.dimen.tbds600);
        q0 = "1";
    }

    public final int W() {
        InterceptResult invokeV;
        RecyclerView recyclerView;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.p.getItemsCount() <= 0 || this.B <= 0 || (recyclerView = this.n) == null || (viewGroup = (ViewGroup) recyclerView.getChildAt(0)) == null || viewGroup.findViewById(R.id.obfuscated_res_0x7f090e84) == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f090e84)) == null || viewGroup2.getChildAt(0) == null) {
                return 0;
            }
            return viewGroup2.getChildAt(0).getHeight() * (this.B + 1);
        }
        return invokeV.intValue;
    }

    public final void a0() {
        ViewGroup viewGroup;
        zd8 zd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (viewGroup = (ViewGroup) this.o.findViewByPosition(this.C)) != null) {
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090e84);
            this.H = recyclerView;
            if (recyclerView != null && recyclerView.getChildAt(this.B) != null && (zd8Var = this.F) != null && zd8Var.a() != null) {
                this.F.a().setLocationScrolled(true);
                this.H.getAdapter().notifyItemChanged(this.B);
                this.H.postDelayed(this.l0, 3000L);
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003023, "show_ok"));
            xg.a().post(new p(this));
            jd8 jd8Var = this.p;
            if (jd8Var != null) {
                jd8Var.o();
            }
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                if (recyclerView.getRecycledViewPool() != null) {
                    this.n.getRecycledViewPool().clear();
                }
                this.n.removeAllViews();
            }
            S();
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.b0 != null && this.V != BaManagerState.REQUESTING) {
            if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST) instanceof TbHttpMessageTask) {
                ((TbHttpMessageTask) MessageManager.getInstance().findTask(CmdConfigHttp.CMD_HTTP_CHAT_GROUP_ROOM_LIST)).setIsNeedDialog(true);
            }
            this.b0.x(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.v));
            this.V = BaManagerState.REQUESTING;
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            X();
            if (this.a0 == null) {
                this.a0 = new an5(this.a, this.d0);
            }
            this.a0.k(wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds300));
            this.a0.attachView(this.Z, true);
            this.a0.p();
            this.a0.onChangeSkinType();
            this.a0.f(R.color.transparent);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.X == null) {
                this.X = NoDataViewFactory.b(this.a, this.Y, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, 400), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0947)), null, true);
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
        this.W = new h(this);
        this.d0 = new i(this);
        this.e0 = new j(this);
        this.f0 = new k(this, 2921778);
        this.g0 = new l(this);
        this.h0 = new m(this, 2001266);
        this.i0 = new n(this, 2921811);
        this.j0 = new o(this);
        this.k0 = new a(this);
        this.l0 = new c(this);
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
        MessageManager.getInstance().registerListener(this.i0);
        MessageManager.getInstance().registerListener(this.h0);
        MessageManager.getInstance().registerListener(this.f0);
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = -1L;
            this.K = false;
        }
    }

    public final String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public final int U() {
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

    public void X() {
        zm5 zm5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (zm5Var = this.c0) != null) {
            zm5Var.dettachView(this.Z);
        }
    }

    public void Y() {
        an5 an5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (an5Var = this.a0) != null) {
            an5Var.dettachView(this.Z);
            this.a0 = null;
        }
    }

    public void Z() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (noDataView = this.X) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final boolean c0() {
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

    public void g0() {
        gd8 gd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && c0() && (gd8Var = this.b0) != null) {
            gd8Var.f();
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.b0 != null) {
                n0();
                j0();
                Z();
            } else {
                p0();
            }
            R();
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f == null) {
                b0();
            }
            this.f.show();
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.c0 == null) {
                zm5 zm5Var = new zm5(this.a);
                this.c0 = zm5Var;
                zm5Var.onChangeSkinType();
            }
            this.c0.attachView(this.Z);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.v);
            statisticItem.param("fname", this.w);
            statisticItem.param("obj_source", T());
            TiebaStatic.log(statisticItem);
        }
    }

    public void e0() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            gd8 gd8Var = this.b0;
            if (gd8Var != null) {
                gd8Var.j();
            }
            this.V = BaManagerState.NONE;
            this.U = false;
            Runnable runnable = this.l0;
            if (runnable != null && (recyclerView = this.H) != null) {
                recyclerView.removeCallbacks(runnable);
            }
            MessageManager.getInstance().unRegisterListener(this.i0);
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.f0);
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !c0()) {
            return;
        }
        gd8 gd8Var = this.b0;
        if (gd8Var != null) {
            gd8Var.k();
        }
        if (this.U) {
            j0();
        }
        if (this.V != BaManagerState.REQUESTING && this.p != null) {
            xg.a().post(new b(this));
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090e79);
            layoutParams.leftMargin = wi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
            layoutParams.topMargin = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            this.j.setLayoutParams(layoutParams);
        }
    }

    public final int V() {
        InterceptResult invokeV;
        jd8 jd8Var;
        zd8 zd8Var;
        ChatRoomInfo a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.x > 0 && (jd8Var = this.p) != null && !ListUtils.isEmpty(jd8Var.d())) {
                List<ld8> d2 = this.p.d();
                for (ld8 ld8Var : d2) {
                    if (ld8Var != null && (ld8Var instanceof yd8)) {
                        yd8 yd8Var = (yd8) ld8Var;
                        List<ld8> subItems = yd8Var.getSubItems();
                        if (ListUtils.isEmpty(subItems)) {
                            continue;
                        } else {
                            for (ld8 ld8Var2 : subItems) {
                                if (ld8Var2 != null && (ld8Var2 instanceof zd8) && (a2 = (zd8Var = (zd8) ld8Var2).a()) != null && this.x == a2.getRoomId()) {
                                    this.B = subItems.indexOf(ld8Var2);
                                    this.C = d2.indexOf(ld8Var);
                                    this.F = zd8Var;
                                    this.G = yd8Var;
                                    yd8Var.g(false);
                                    return d2.indexOf(ld8Var);
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

    public void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || !(this.a instanceof TbPageContextSupport)) {
            return;
        }
        this.f = new d(this, this.a, R.style.obfuscated_res_0x7f1000fe);
        this.g = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03cc, (ViewGroup) null);
        GreyUtil.grey(this.f);
        this.h = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090e88);
        this.i = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090e6c);
        this.E = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090e6e);
        this.Y = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0918db);
        this.Z = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0918e4);
        this.s = this.g.findViewById(R.id.obfuscated_res_0x7f090e89);
        this.m = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090e85);
        this.t = this.g.findViewById(R.id.obfuscated_res_0x7f09115f);
        this.u = this.g.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.n = (RecyclerView) this.g.findViewById(R.id.obfuscated_res_0x7f090e6b);
        e eVar = new e(this, this.a);
        this.o = eVar;
        this.n.setLayoutManager(eVar);
        jd8 jd8Var = new jd8(this.b, this.v, this.y);
        this.p = jd8Var;
        jd8Var.p(new f(this));
        kd8 kd8Var = new kd8(null);
        this.r = kd8Var;
        ChatRoomRecycleAdapter chatRoomRecycleAdapter = new ChatRoomRecycleAdapter(kd8Var, this.p, this.b);
        this.q = chatRoomRecycleAdapter;
        this.n.setAdapter(chatRoomRecycleAdapter);
        this.n.removeOnScrollListener(this.g0);
        this.n.addOnScrollListener(this.g0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090e77);
        this.k = textView;
        this.k.setText(MeasureTextLength.fitTextLabel(this.w, "...吧", MeasureTextLength.spaceLength(p0), textView.getPaint(), "吧"));
        this.j = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090e61);
        this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091b71);
        this.L = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0907fe);
        this.M = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090800);
        this.N = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f0907ff);
        this.L.setOnClickListener(this.j0);
        this.P = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091682);
        this.Q = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091684);
        this.R = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f091683);
        this.P.setOnClickListener(this.k0);
        this.L.setVisibility(8);
        this.P.setVisibility(8);
        this.c = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090775);
        this.d = (TbImageAutoSwitch) this.g.findViewById(R.id.obfuscated_res_0x7f090776);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f09077a);
        this.e = headImageView;
        headImageView.setPlaceHolder(1);
        this.e.setIsRound(true);
        this.e.setBorderWidth(SelectorHelper.getResources().getDimensionPixelSize(R.dimen.L_X02));
        this.e.setBorderColor(R.color.CAM_X0101);
        this.e.setDrawBorder(true);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        TbImageAutoSwitch tbImageAutoSwitch = this.d;
        int i2 = m0;
        tbImageAutoSwitch.l(4, i2, i2, o0);
        this.d.setAnimationDuration(500);
        this.d.setCarouselDelayPeriod(2000);
        this.d.setCarouselPeriod(2000);
        this.d.setAdapter(this.W);
        this.f.setContentView(this.g);
        if (this.f.getWindow() != null && this.f.getWindow().getAttributes() != null) {
            int i3 = this.f.getWindow().getAttributes().windowAnimations;
        }
        d0(TbadkCoreApplication.getInst().getSkinType());
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
        this.b0 = new gd8(this.a, this.e0);
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f090ec2);
        if (findViewById != null) {
            Glide.with(findViewById).load(ks6.b("group_list_head_bcg_pic.webp", "group_list_head_bcg_pic")).into((RequestBuilder<Drawable>) new g(this, findViewById));
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i2) != null) || this.f == null) {
            return;
        }
        p75.d(this.g).o(R.string.deprecated_J_X18);
        p75 d2 = p75.d(this.s);
        d2.n(0);
        d2.o(R.string.J_X03);
        d2.f(R.color.CAM_X0618);
        p75 d3 = p75.d(this.k);
        d3.x(R.color.CAM_X0101);
        d3.C(R.dimen.T_X04);
        d3.D(R.string.F_X02);
        p75 d4 = p75.d(this.l);
        d4.x(R.color.CAM_X0102);
        d4.C(R.dimen.T_X12);
        d4.D(R.string.F_X01);
        p75.d(this.h).o(R.string.deprecated_J_X18);
        p75 d5 = p75.d(this.t);
        d5.o(R.string.deprecated_J_X18);
        d5.f(R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.m, R.drawable.obfuscated_res_0x7f08070c);
        p75.d(this.i).o(R.string.deprecated_J_X18);
        p75 d6 = p75.d(this.E);
        d6.C(R.dimen.T_X07);
        d6.D(R.string.F_X02);
        d6.x(R.color.CAM_X0105);
        p75 d7 = p75.d(this.N);
        d7.C(R.dimen.T_X12);
        d7.D(R.string.F_X01);
        d7.x(R.color.CAM_X0105);
        p75 d8 = p75.d(this.R);
        d8.C(R.dimen.T_X12);
        d8.D(R.string.F_X01);
        d8.x(R.color.CAM_X0105);
        WebPManager.setPureDrawable(this.M, R.drawable.obfuscated_res_0x7f080554, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        WebPManager.setPureDrawable(this.Q, R.drawable.obfuscated_res_0x7f080f44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
    }

    public void k0(long j2, String str, long j3, List<Long> list, boolean z, boolean z2) {
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

    public void l0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int V = V();
            if (V >= 0 && this.n != null) {
                int findFirstVisibleItemPosition = this.o.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = this.o.findLastVisibleItemPosition();
                if (V >= findFirstVisibleItemPosition && V <= findLastVisibleItemPosition) {
                    this.K = false;
                    if (this.o.findViewByPosition(V) != null) {
                        i2 = this.o.findViewByPosition(V).getTop();
                    } else {
                        i2 = 0;
                    }
                    this.n.scrollBy(0, (i2 - U()) + W());
                    a0();
                    return;
                }
                this.K = true;
                this.o.scrollToPosition(V);
                return;
            }
            LinearLayoutManager linearLayoutManager = this.o;
            if (linearLayoutManager != null && this.n != null) {
                linearLayoutManager.scrollToPosition(0);
            }
        }
    }
}
