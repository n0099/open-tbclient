package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.f05;
import com.baidu.tieba.g05;
import com.baidu.tieba.l16;
import com.baidu.tieba.o16;
import com.baidu.tieba.p05;
import com.baidu.tieba.p55;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.qva;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class j5a implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int o0;
    public static int p0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public BlueCircleProgressDialog B;
    public m5a C;
    public MorePopupWindow D;
    public g05 E;
    public View F;
    public BlankView G;
    public View H;
    public n05 I;
    public f05 J;
    public View.OnClickListener K;
    public g05 L;
    public boolean M;
    public ProgressBar N;
    public NewSubPbActivity.s0 O;
    public NewSubPbActivity.s0 P;
    public hh5 Q;
    public int R;
    public ArrayList<mwa> S;

    /* renamed from: T  reason: collision with root package name */
    public pw9 f1119T;
    public TextView U;
    public RelativeLayout V;
    public ImageView W;
    public ImageView X;
    public LinearLayout Y;
    public ImageView Z;
    public SubPbView a;
    public View a0;
    public LinearLayout b;
    public int b0;
    public View c;
    public int c0;
    public BdTypeListView d;
    public SubPbModel d0;
    public v6a e;
    public int e0;
    public NewSubPbActivity f;
    public boolean f0;
    public NoNetworkView g;
    public l16 g0;
    public NoDataView h;
    public o16 h0;
    public View.OnClickListener i;
    public l5a i0;
    public RelativeLayout j;
    public p55.g j0;
    public NavigationBar k;
    public MaskView k0;
    public ImageView l;
    public BdUniqueId l0;
    public View m;
    public final CustomMessageListener m0;
    public TextView n;
    public tx9 n0;
    public LinearLayout o;
    public HeadImageView p;
    public TextView q;
    public View r;
    public ImageView s;
    public TextView t;
    public TbImageView u;
    public TextView v;
    public EllipsizeRichTextView w;
    public TbImageView x;
    public PlayVoiceBntNew y;
    public TextView z;

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements qva.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public a(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // com.baidu.tieba.qva.h
        public void d(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.K();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public b(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G != null) {
                this.a.a.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ j5a b;

        public c(j5a j5aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j5aVar;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int headerViewsCount = this.a + this.b.d.getHeaderViewsCount();
                if (headerViewsCount >= 1) {
                    headerViewsCount--;
                }
                this.b.d.setSelection(headerViewsCount);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(j5a j5aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, Integer.valueOf(i)};
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
            this.a = j5aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2010045) {
                Object data = customResponsedMessage.getData();
                if (TbadkCoreApplication.getInst().getCurrentActivity() == this.a.f && (data instanceof Boolean)) {
                    this.a.a.setEnableDragExit(!((Boolean) data).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        public e(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d0 != null && (this.a.d0.b1() || this.a.d0.Y0())) {
                    this.a.f.finish();
                } else if (this.a.G != null) {
                    this.a.a.g();
                } else {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements tx9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j5a a;

        @Override // com.baidu.tieba.tx9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.tx9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public f(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j5aVar;
        }

        @Override // com.baidu.tieba.tx9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.p(false);
            this.a.p(true);
            return true;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements p05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ j5a b;

        public g(j5a j5aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j5aVar;
            this.a = z;
        }

        @Override // com.baidu.tieba.p05.f
        public void E0(p05 p05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, p05Var, i, view2) == null) {
                this.b.I.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.X(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                        return;
                    case 11:
                        if (this.b.O != null) {
                            this.b.O.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.f3(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.z0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ j5a b;

        public h(j5a j5aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j5aVar;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type)});
                }
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(j5a j5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements l16.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ j5a b;

        public j(j5a j5aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j5aVar;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.l16.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements o16.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ j5a b;

        public k(j5a j5aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j5aVar;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.o16.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ j5a b;

        public l(j5a j5aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j5aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j5aVar;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.d.setEnabled(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835667, "Lcom/baidu/tieba/j5a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835667, "Lcom/baidu/tieba/j5a;");
                return;
            }
        }
        o0 = TbadkCoreApplication.getInst().getListItemRule().c();
        p0 = 2;
    }

    public ListView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (ListView) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.F;
        }
        return (View) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public ImageView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.X;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.W;
        }
        return (ImageView) invokeV.objValue;
    }

    public TextView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.U;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return (TextView) invokeV.objValue;
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void I() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (blueCircleProgressDialog = this.B) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void J() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (noDataView = this.h) != null) {
            noDataView.setVisibility(8);
            this.d.setVisibility(0);
            this.V.setVisibility(0);
            this.a.setOnTouchListener(null);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m0.setTag(this.l0);
            MessageManager.getInstance().registerListener(this.m0);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    public void R() {
        l5a l5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (l5aVar = this.i0) != null) {
            l5aVar.c();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            hh5 hh5Var = this.Q;
            if (hh5Var != null) {
                hh5Var.G();
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || this.f.A3()) {
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.d.setVisibility(0);
            this.N.setVisibility(8);
            this.C.g();
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.d.setVisibility(0);
            this.N.setVisibility(8);
            this.C.V();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            l0(this.f);
            this.d.setNextPage(this.C);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.N.bringToFront();
            this.N.setVisibility(0);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", p0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.B == null) {
                this.B = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.B.setDialogVisiable(true);
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            BlankView blankView = this.G;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            hh5 hh5Var = this.Q;
            if (hh5Var != null && hh5Var.a() != null) {
                return this.Q.a().getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ImageView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.Z;
        }
        return (ImageView) invokeV.objValue;
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.d.setNextPage(this.C);
            this.C.U();
        }
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.x;
        }
        return (View) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.i0.a();
        }
        return invokeV.booleanValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void y0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (bdTypeListView = this.d) != null) {
            this.c0 = bdTypeListView.getLastVisiblePosition();
        }
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public j5a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.M = true;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = 0;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.b0 = 2;
        this.c0 = 0;
        this.e0 = 0;
        this.f0 = true;
        this.m0 = new d(this, 2010045);
        this.n0 = new tx9(new f(this));
        this.f = newSubPbActivity;
        this.K = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0748, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0747, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.navigation_bar_group);
        this.V = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0923f2);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0923f3);
        this.U = textView;
        textView.setOnClickListener(this.K);
        this.W = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0923f5);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0923f4);
        this.X = imageView;
        imageView.setOnClickListener(this.K);
        this.W.setOnClickListener(this.K);
        this.g = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        N();
        L();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0923e4);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f091a30);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d09c7, (ViewGroup) null);
        this.A = threadSkinView;
        this.d.addHeaderView(threadSkinView);
        this.d.addHeaderView(this.c);
        this.H = new TextView(newSubPbActivity.getActivity());
        this.H.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.d.w(this.H, 0);
        this.a.setTopView(this.H);
        this.a.setNavigationView(this.b);
        this.a.setListView(this.d);
        this.a.setContentView(this.j);
        m5a m5aVar = new m5a(this.f.getPageContext());
        this.C = m5aVar;
        m5aVar.B();
        this.F = this.C.c();
        this.d.setNextPage(this.C);
        this.C.G(this.K);
        this.d.setOnTouchListener(this.n0);
        v6a v6aVar = new v6a(newSubPbActivity.getPageContext());
        this.e = v6aVar;
        v6aVar.g();
        this.e.a(this.j0);
        this.e.D(TbadkCoreApplication.getInst().getSkinType());
        this.N = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091e5c);
        this.k0 = (MaskView) this.a.findViewById(R.id.mask_view);
        this.a0 = this.a.findViewById(R.id.obfuscated_res_0x7f092a43);
        this.Y = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091b9d);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909e3);
        this.Z = imageView2;
        imageView2.setVisibility(0);
        this.Z.setOnClickListener(this.K);
        ImageView imageView3 = this.Z;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_pure_post_expression24);
            o();
        }
        V(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = vq4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        l5a l5aVar = new l5a(this.f, this.d);
        this.i0 = l5aVar;
        l5aVar.f(this.M);
        this.i0.d(this.K);
        this.i0.b();
    }

    public void Z(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048601, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        Y(sparseArray, false);
    }

    public void a0(NewSubPbActivity.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, s0Var) == null) {
            this.P = s0Var;
        }
    }

    public void c0(NewSubPbActivity.s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, s0Var) == null) {
            this.O = s0Var;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f0 = z;
        }
    }

    public void e0(p55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) {
            this.j0 = gVar;
            v6a v6aVar = this.e;
            if (v6aVar != null) {
                v6aVar.a(gVar);
            }
        }
    }

    public void g0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, subPbModel) == null) {
            this.d0 = subPbModel;
        }
    }

    public void h0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zVar) == null) {
            this.i0.j(zVar);
        }
    }

    public void i0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onLongClickListener) == null) {
            this.i0.h(onLongClickListener);
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void k0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onScrollListener) == null) {
            this.d.setOnScrollListener(onScrollListener);
        }
    }

    public void l0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, pVar) == null) {
            this.d.setOnSrollToBottomListener(pVar);
        }
    }

    public void m0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bdUniqueId) == null) {
            this.l0 = bdUniqueId;
            M();
        }
    }

    public final void p(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (bdTypeListView = this.d) != null) {
            if (!z) {
                bdTypeListView.setEnabled(z);
            } else {
                bdTypeListView.postDelayed(new l(this, z), 10L);
            }
        }
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            O(NoDataViewFactory.e.d(null, this.f.getResources().getString(R.string.refresh_view_title_text)));
            this.V.setVisibility(8);
        }
    }

    public void K() {
        hh5 hh5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.U != null && (hh5Var = this.Q) != null) {
            if (hh5Var.z()) {
                this.U.setText(R.string.obfuscated_res_0x7f0f061a);
            } else {
                this.U.setText(this.f.Y2());
            }
        }
    }

    public void m() {
        SubPbModel subPbModel;
        boolean z;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || (subPbModel = this.d0) == null) {
            return;
        }
        if ((x0() || (view2 = this.F) == null || !view2.isShown()) && !ListUtils.isEmpty(this.S)) {
            z = true;
        } else {
            z = false;
        }
        subPbModel.p1(z);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            MorePopupWindow morePopupWindow = this.D;
            if (morePopupWindow != null) {
                yb.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            g05 g05Var = this.E;
            if (g05Var != null) {
                g05Var.e();
            }
            f05 f05Var = this.J;
            if (f05Var != null) {
                f05Var.dismiss();
            }
            n05 n05Var = this.I;
            if (n05Var != null) {
                yb.b(n05Var, this.f.getPageContext());
            }
            ProgressBar progressBar = this.N;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0923f6);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.K);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091d58);
            this.p = headImageView;
            headImageView.setRadius(BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09294d);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090bc9);
            this.u = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090bca);
            this.v = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09264e);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090820);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.K);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0923e5);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.K);
            this.z = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090166);
            this.y = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f092aa9);
            this.c.setOnTouchListener(this.n0);
            this.c.setOnClickListener(this.K);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070421);
            int dimens2 = BdUtilHelper.getDimens(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d4);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.k = navigationBar;
            this.m = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            ImageView backImageView = this.k.getBackImageView();
            this.l = backImageView;
            if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                layoutParams.leftMargin = dimens2;
                backImageView.setLayoutParams(layoutParams);
            }
            View view2 = this.m;
            if (view2 != null && (view2.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams2.width = dimens;
                layoutParams2.height = dimens;
                this.m.setLayoutParams(layoutParams2);
            }
            this.k.hideBottomLine();
            TextView textView = new TextView(this.f);
            this.n = textView;
            EMManager.from(textView).setTextColor(R.color.CAM_X0304).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01);
            this.k.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.n, (View.OnClickListener) null);
            ViewCommonUtil.setViewMarginByDimen(this.n, -1, -1, R.dimen.M_W_X007, -1);
            this.n.setOnClickListener(this.K);
        }
    }

    public final void O(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.refresh_view_button_text), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f0703a7)), eVar, a2);
            }
            this.d.setVisibility(8);
            this.N.setVisibility(8);
            this.Q.B();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.h.setClickable(true);
            this.h.setTextOption(eVar);
            this.h.f(this.f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(0);
        }
    }

    public void o0(mwa mwaVar) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, mwaVar) != null) || mwaVar == null) {
            return;
        }
        mwaVar.i1(true);
        mwa mwaVar2 = new mwa();
        mwaVar2.p1(52);
        if (!x0() && (view2 = this.F) != null && view2.isShown()) {
            i2 = (this.c0 - this.b0) - 1;
        } else {
            i2 = this.c0 - this.b0;
        }
        int count = ListUtils.getCount(this.S);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.S, 0, i2));
        ListUtils.add(arrayList, mwaVar2);
        ListUtils.add(arrayList, mwaVar);
        this.d.smoothScrollToPosition(this.c0 + 2);
        this.d.setNextPage(null);
    }

    public final void u0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, sparseArray) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.g0 == null) {
                this.g0 = new l16(newSubPbActivity.getPageContext(), this.c);
            }
            AntiData antiData = null;
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null) {
                antiData = subPbModel.x0();
            }
            NegativeFeedBackData h2 = f4a.h(antiData);
            this.g0.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.g0.A(h2);
            this.g0.D("4");
            this.g0.C(new j(this, sparseArray));
        }
    }

    public void P(hh5 hh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, hh5Var) == null) && hh5Var != null && hh5Var.a() != null) {
            this.Q = hh5Var;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.j.addView(hh5Var.a(), layoutParams);
            this.Q.V(new a(this));
        }
    }

    public void V(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            BDLayoutMode layoutMode = this.f.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.f.getLayoutMode().onModeChanged(this.a);
            this.f.getLayoutMode().onModeChanged(this.c);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0201);
            this.k.onChangeSkinType(this.f.getPageContext(), i2);
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null && (subPbModel.b1() || this.d0.Y0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            this.g.onChangeSkinType(this.f.getPageContext(), i2);
            this.f.getLayoutMode().onModeChanged(this.F);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            hh5 hh5Var = this.Q;
            if (hh5Var != null && hh5Var.a() != null) {
                this.Q.a().F(i2);
            }
            this.C.e(i2);
            this.y.b();
            SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            EMManager.from(this.q).setTextStyle(R.string.F_X01);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            this.U.setAlpha(0.95f);
            l5a l5aVar = this.i0;
            if (l5aVar != null) {
                l5aVar.c();
            }
            SkinManager.setBackgroundColor(this.a0, R.color.CAM_X0203);
            WebPManager.setPureDrawable(this.Z, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.Y.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            EMManager.from(this.V).setBackGroundColor(R.color.CAM_X0208);
        }
    }

    public void X(int i2, String str, int i3, boolean z, boolean z2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            if (i3 == 1002 && !z) {
                i4 = R.string.report_post_confirm;
            } else {
                i4 = R.string.del_all_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            f05 f05Var = new f05(this.f.getPageContext().getPageActivity());
            this.J = f05Var;
            f05Var.setMessageId(i4);
            this.J.setYesButtonTag(sparseArray);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f05ab, new h(this, sparseArray));
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f05a0, new i(this));
            this.J.setCancelable(true);
            this.J.create(this.f.getPageContext());
            if (z2) {
                this.J.show();
            } else if (z) {
                this.J.show();
            } else if (1 == this.d0.B0()) {
                n16 n16Var = new n16(this.d0.B0(), this.d0.A0(), this.d0.E0());
                n16Var.i(this.f1119T.f().getId(), this.f1119T.f().getName());
                n16Var.h(this.d0.C0());
                n16Var.j(this.d0.S0());
                UserData userData = new UserData();
                userData.setIsManager(this.d0.G0());
                q0(sparseArray, n16Var, userData);
            } else {
                u0(sparseArray);
            }
        }
    }

    public void Y(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        l05 l05Var;
        l05 l05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048600, this, sparseArray, z) == null) {
            p05 p05Var = new p05(this.f.getBaseContext());
            p05Var.u(this.f.getString(R.string.obfuscated_res_0x7f0f032e));
            p05Var.r(new g(this, z));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i2 != 2) {
                if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                }
                if (i3 == 0) {
                    l05Var2 = new l05(10, this.f.getString(R.string.obfuscated_res_0x7f0f056a), p05Var);
                } else {
                    l05Var2 = new l05(10, this.f.getString(R.string.obfuscated_res_0x7f0f055b), p05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                l05Var2.d.setTag(sparseArray2);
                arrayList.add(l05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                l05 l05Var3 = new l05(13, this.f.getString(R.string.multi_delete), p05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                l05Var3.d.setTag(sparseArray3);
                arrayList.add(l05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                l05 l05Var4 = new l05(11, this.f.getString(R.string.forbidden_person), p05Var);
                l05Var4.d.setTag(sparseArray4);
                arrayList.add(l05Var4);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray5.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
                if (z) {
                    l05Var = new l05(12, this.f.getString(R.string.un_mute), p05Var);
                } else {
                    l05Var = new l05(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d47), p05Var);
                }
                l05Var.d.setTag(sparseArray5);
                arrayList.add(l05Var);
            }
            i4a.d(arrayList);
            p05Var.n(arrayList, true);
            n05 n05Var = new n05(this.f.getPageContext(), p05Var);
            this.I = n05Var;
            n05Var.l();
        }
    }

    public void k(boolean z) {
        SubPbModel subPbModel;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048613, this, z) == null) && (subPbModel = this.d0) != null && subPbModel.a1() && !z) {
            this.k.setIsClose(true);
            this.k.setIsCorner(true);
            this.k.isShowBottomLine(true);
            this.k.setBottomLineHeight(3);
            this.k.setStatusBarVisibility(8);
            this.G = new BlankView(this.f.getPageContext().getPageActivity());
            if (this.d0.b1()) {
                boolean isNotchScreen = TbSingleton.getInstance().isNotchScreen(this.f);
                boolean isCutoutScreen = TbSingleton.getInstance().isCutoutScreen(this.f);
                if (!isNotchScreen && !isCutoutScreen) {
                    i2 = UtilHelper.getStatusBarHeight();
                } else {
                    i2 = 0;
                }
                this.e0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds562) + i2;
            } else {
                this.e0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07037b);
            }
            this.b.addView(this.G, 0, new LinearLayout.LayoutParams(-1, this.e0));
            this.G.setVisibility(0);
            this.G.setOnClickListener(new b(this));
            this.a.setBlankView(this.G);
        }
    }

    public void q(pw9 pw9Var, mwa mwaVar, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{pw9Var, mwaVar, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) && mwaVar != null && !this.f0) {
            if (!StringUtils.isNull(mwaVar.J())) {
                this.x.setVisibility(0);
                this.x.startLoad(mwaVar.J(), 10, true);
            } else {
                this.x.setVisibility(8);
            }
            fwa C = mwaVar.C();
            if (C != null && C.a) {
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
            SparseArray sparseArray = (SparseArray) this.c.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.c.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, mwaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            x3a.a(mwaVar, i2, sparseArray, this.f1119T);
            this.q.setText((CharSequence) null);
            if (!this.f0 && mwaVar.u() != null) {
                x3a.e(mwaVar.u(), z, this.q, this.p, this.r, this.o, this.t, this.u, this.f);
            }
            this.v.setText(StringHelper.getFormatTime(mwaVar.r0()));
            boolean d2 = x3a.d(this.w, mwaVar.f0());
            if (StringUtils.isNull(mwaVar.J()) && !d2 && mwaVar.y0() != null) {
                this.y.setVisibility(0);
                this.y.setTag(mwaVar.y0());
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final void q0(SparseArray<Object> sparseArray, n16 n16Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048626, this, sparseArray, n16Var, userData) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.h0 == null) {
                this.h0 = new o16(newSubPbActivity.getPageContext(), this.c, n16Var, userData);
            }
            AntiData antiData = null;
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null) {
                antiData = subPbModel.x0();
            }
            NegativeFeedBackData h2 = f4a.h(antiData);
            this.h0.I(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.h0.H(h2);
            this.h0.K("4");
            this.h0.J(new k(this, sparseArray));
        }
    }

    public void r(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            ProgressBar progressBar = this.N;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (z && z2) {
                NewSubPbActivity newSubPbActivity = this.f;
                newSubPbActivity.showToast(newSubPbActivity.getResources().getString(R.string.delete_success));
            } else if (str != null && z2) {
                this.f.showToast(str);
            }
        }
    }

    public void s0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048630, this, str, z) == null) {
            if (z) {
                O(NoDataViewFactory.e.d("", str));
            } else {
                O(NoDataViewFactory.e.d(str, this.f.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.V.setVisibility(8);
        }
    }

    public void t0(g05.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048632, this, cVar, z) == null) {
            g05 g05Var = this.L;
            if (g05Var != null) {
                g05Var.e();
                this.L = null;
            }
            g05 g05Var2 = new g05(this.f.getPageContext().getPageActivity());
            this.L = g05Var2;
            if (z) {
                g05Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
            } else {
                g05Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion), this.f.getPageContext().getString(R.string.save_to_local)}, cVar);
            }
            this.L.c(this.f.getPageContext());
            this.L.m();
        }
    }

    public void w0(pw9 pw9Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        NewSubPbActivity newSubPbActivity;
        int top;
        String str;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048638, this, new Object[]{pw9Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || pw9Var == null) {
            return;
        }
        int i6 = 8;
        if (this.f0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.b0 = 1;
        }
        this.f1119T = pw9Var;
        if (pw9Var.i() != null) {
            this.f1119T.i().s0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f1861);
        if (pw9Var.i() != null) {
            int L = pw9Var.i().L();
            this.R = L;
            if (L > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f14dd), Integer.valueOf(this.R)));
                NewSubPbActivity newSubPbActivity2 = this.f;
                if (newSubPbActivity2 != null) {
                    this.U.setText(newSubPbActivity2.Y2());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0c3e));
            }
            NewSubPbActivity newSubPbActivity3 = this.f;
            if (newSubPbActivity3 != null && newSubPbActivity3.x3()) {
                str = "PB";
            } else {
                str = null;
            }
            if (this.f != null && pw9Var.i().i0() != null) {
                this.A.setData(this.f.getPageContext(), pw9Var.i().i0(), swa.a("PB", "c0132", pw9Var.f().getId(), pw9Var.f().getName(), pw9Var.l().getId(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (pw9Var.o()) {
            this.C.U();
            this.i0.g(true);
        } else {
            this.C.g();
            this.i0.g(false);
        }
        ArrayList<mwa> k2 = pw9Var.k();
        this.S = k2;
        if (k2 != null && k2.size() > o0) {
            int size = this.S.size() - o0;
            x3a.c(size, this.S);
            int firstVisiblePosition = this.d.getFirstVisiblePosition() - size;
            View childAt = this.d.getChildAt(0);
            if (childAt == null) {
                top = 0;
            } else {
                top = childAt.getTop();
            }
            i3 = size;
            i4 = firstVisiblePosition;
            i5 = top;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.S);
        if (ListUtils.isEmpty(this.S)) {
            this.d.setNextPage(null);
            if (this.f0) {
                arrayList.add(0, new r5a());
            }
        } else {
            this.d.setNextPage(this.C);
        }
        s5a s5aVar = new s5a();
        s5aVar.b(pw9Var.m());
        arrayList.add(0, s5aVar);
        if (this.f0) {
            arrayList.add(0, pw9Var.i());
        }
        NewSubPbActivity newSubPbActivity4 = this.f;
        if (newSubPbActivity4 != null && newSubPbActivity4.a3() != null) {
            MaskView maskView = this.k0;
            if (this.f.a3().c1()) {
                i6 = 0;
            }
            maskView.setVisibility(i6);
        }
        this.i0.e(this.f1119T.l(), arrayList);
        q(pw9Var, pw9Var.i(), pw9Var.g(), false, i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && (newSubPbActivity = this.f) != null && !rd.isEmpty(newSubPbActivity.a3().F0())) {
            String F0 = this.f.a3().F0();
            int i7 = 0;
            while (true) {
                if (i7 < arrayList.size()) {
                    if ((arrayList.get(i7) instanceof mwa) && F0.equals(((mwa) arrayList.get(i7)).U())) {
                        this.d.post(new c(this, i7));
                        break;
                    }
                    i7++;
                } else {
                    break;
                }
            }
        }
        if (this.f1119T.j() > 1) {
            this.d.setPullRefresh(this.e);
            this.a.setEnableDragExit(false);
            return;
        }
        this.d.setPullRefresh(null);
        this.a.setEnableDragExit(true);
    }

    public void z0(boolean z) {
        String str;
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            l5a l5aVar = this.i0;
            if (l5aVar != null) {
                l5aVar.i(z);
                this.i0.c();
            }
            if (z && (newSubPbActivity = this.f) != null) {
                v4a.d(newSubPbActivity.getPageContext(), this.d0, this);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            pw9 pw9Var = this.f1119T;
            if (pw9Var != null && pw9Var.f() != null) {
                str = this.f1119T.f().getId();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "2"));
        }
    }
}
