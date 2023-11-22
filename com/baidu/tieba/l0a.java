package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
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
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.a05;
import com.baidu.tieba.a16;
import com.baidu.tieba.d16;
import com.baidu.tieba.g55;
import com.baidu.tieba.j05;
import com.baidu.tieba.jl6;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.yqa;
import com.baidu.tieba.zt9;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class l0a implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int o0;
    public static int p0;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadSkinView A;
    public BlueCircleProgressDialog B;
    public o0a C;
    public MorePopupWindow D;
    public a05 E;
    public View F;
    public BlankView G;
    public View H;
    public h05 I;
    public zz4 J;
    public View.OnClickListener K;
    public a05 L;
    public boolean M;
    public ProgressBar N;
    public NewSubPbActivity.u0 O;
    public NewSubPbActivity.u0 P;
    public yg5 Q;
    public int R;
    public ArrayList<vra> S;

    /* renamed from: T  reason: collision with root package name */
    public vs9 f1129T;
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
    public v1a e;
    public int e0;
    public NewSubPbActivity f;
    public boolean f0;
    public NoNetworkView g;
    public a16 g0;
    public NoDataView h;
    public d16 h0;
    public View.OnClickListener i;
    public n0a i0;
    public RelativeLayout j;
    public g55.g j0;
    public NavigationBar k;
    public MaskView k0;
    public ImageView l;
    public BdUniqueId l0;
    public View m;
    public final CustomMessageListener m0;
    public TextView n;
    public zt9 n0;
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

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements yqa.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;

        public a(l0a l0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0aVar;
        }

        @Override // com.baidu.tieba.yqa.h
        public void d(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;

        public b(l0a l0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.G != null) {
                this.a.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ l0a b;

        public c(l0a l0aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l0aVar;
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l0a l0aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, Integer.valueOf(i)};
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
            this.a = l0aVar;
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

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;

        public e(l0a l0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0aVar;
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

    /* loaded from: classes7.dex */
    public class f implements zt9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l0a a;

        @Override // com.baidu.tieba.zt9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.zt9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public f(l0a l0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l0aVar;
        }

        @Override // com.baidu.tieba.zt9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) != null) {
                return invokeLL.booleanValue;
            }
            this.a.q(false);
            this.a.q(true);
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l0a b;

        public g(l0a l0aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l0aVar;
            this.a = z;
        }

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                this.b.I.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.Z(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                        return;
                    case 11:
                        if (this.b.O != null) {
                            this.b.O.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.p3(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.E0(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ l0a b;

        public h(l0a l0aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l0aVar;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                if (this.b.P != null) {
                    this.b.P.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type)});
                }
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(l0a l0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a16.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ l0a b;

        public j(l0a l0aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l0aVar;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.a16.h
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

    /* loaded from: classes7.dex */
    public class k implements d16.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ l0a b;

        public k(l0a l0aVar, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l0aVar;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.d16.i
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

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l0a b;

        public l(l0a l0aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l0aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l0aVar;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890444, "Lcom/baidu/tieba/l0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890444, "Lcom/baidu/tieba/l0a;");
                return;
            }
        }
        o0 = TbadkCoreApplication.getInst().getListItemRule().c();
        p0 = 2;
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public ListView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (ListView) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i0.a();
        }
        return invokeV.booleanValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.F;
        }
        return (View) invokeV.objValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            NavigationBar navigationBar = this.k;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void D0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeListView = this.d) != null) {
            this.c0 = bdTypeListView.getLastVisiblePosition();
        }
    }

    public ImageView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.X;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.W;
        }
        return (ImageView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.U;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return (TextView) invokeV.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void K() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (blueCircleProgressDialog = this.B) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void L() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (noDataView = this.h) != null) {
            noDataView.setVisibility(8);
            this.d.setVisibility(0);
            this.V.setVisibility(0);
            this.a.setOnTouchListener(null);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.m0.setTag(this.l0);
            MessageManager.getInstance().registerListener(this.m0);
        }
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.a.e();
        }
        return invokeV.booleanValue;
    }

    public void T() {
        n0a n0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (n0aVar = this.i0) != null) {
            n0aVar.c();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            yg5 yg5Var = this.Q;
            if (yg5Var != null) {
                yg5Var.G();
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || this.f.J3()) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.setVisibility(0);
            this.N.setVisibility(8);
            this.C.g();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d.setVisibility(0);
            this.N.setVisibility(8);
            this.C.V();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            o0(this.f);
            this.d.setNextPage(this.C);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", p0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.N.bringToFront();
            this.N.setVisibility(0);
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            BlankView blankView = this.G;
            if (blankView == null) {
                return 0;
            }
            return blankView.getHeight();
        }
        return invokeV.intValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (this.B == null) {
                this.B = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.B.setDialogVisiable(true);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            yg5 yg5Var = this.Q;
            if (yg5Var != null && yg5Var.a() != null) {
                return this.Q.a().getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ImageView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.Z;
        }
        return (ImageView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.x;
        }
        return (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.d.setNextPage(this.C);
            this.C.U();
        }
    }

    public l0a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
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
        this.n0 = new zt9(new f(this));
        this.f = newSubPbActivity;
        this.K = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d072e, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d072d, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.navigation_bar_group);
        this.V = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09236e);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09236f);
        this.U = textView;
        textView.setOnClickListener(this.K);
        this.W = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092371);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092370);
        this.X = imageView;
        imageView.setOnClickListener(this.K);
        this.W.setOnClickListener(this.K);
        this.g = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        P();
        N();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092360);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f0919bb);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d09ac, (ViewGroup) null);
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
        o0a o0aVar = new o0a(this.f.getPageContext());
        this.C = o0aVar;
        o0aVar.B();
        this.F = this.C.c();
        this.d.setNextPage(this.C);
        this.C.G(this.K);
        this.d.setOnTouchListener(this.n0);
        v1a v1aVar = new v1a(newSubPbActivity.getPageContext());
        this.e = v1aVar;
        v1aVar.f();
        this.e.a(this.j0);
        this.e.D(TbadkCoreApplication.getInst().getSkinType());
        this.N = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091de4);
        this.k0 = (MaskView) this.a.findViewById(R.id.mask_view);
        this.a0 = this.a.findViewById(R.id.obfuscated_res_0x7f0929ba);
        this.Y = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091b26);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0909c6);
        this.Z = imageView2;
        imageView2.setVisibility(0);
        this.Z.setOnClickListener(this.K);
        ImageView imageView3 = this.Z;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_pure_post_expression24);
            p();
        }
        X(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = rq4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        n0a n0aVar = new n0a(this.f, this.d);
        this.i0 = n0aVar;
        n0aVar.f(this.M);
        this.i0.d(this.K);
        this.i0.b();
    }

    public void b0(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        a0(sparseArray, false);
    }

    public void d0(NewSubPbActivity.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, u0Var) == null) {
            this.P = u0Var;
        }
    }

    public void f0(NewSubPbActivity.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, u0Var) == null) {
            this.O = u0Var;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f0 = z;
        }
    }

    public void h0(g55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gVar) == null) {
            this.j0 = gVar;
            v1a v1aVar = this.e;
            if (v1aVar != null) {
                v1aVar.a(gVar);
            }
        }
    }

    public void j0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, subPbModel) == null) {
            this.d0 = subPbModel;
        }
    }

    public void k0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, zVar) == null) {
            this.i0.j(zVar);
        }
    }

    public void l0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.i0.h(onLongClickListener);
        }
    }

    public void m0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }

    public void n0(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onScrollListener) == null) {
            this.d.setOnScrollListener(onScrollListener);
        }
    }

    public void o0(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, pVar) == null) {
            this.d.setOnSrollToBottomListener(pVar);
        }
    }

    public void p0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bdUniqueId) == null) {
            this.l0 = bdUniqueId;
            O();
        }
    }

    public final void q(boolean z) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048630, this, z) == null) && (bdTypeListView = this.d) != null) {
            if (!z) {
                bdTypeListView.setEnabled(z);
            } else {
                bdTypeListView.postDelayed(new l(this, z), 10L);
            }
        }
    }

    public void v0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i2) == null) {
            Q(NoDataViewFactory.e.d(null, this.f.getResources().getString(R.string.refresh_view_title_text)));
            this.V.setVisibility(8);
        }
    }

    public void A0(vs9 vs9Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        NewSubPbActivity newSubPbActivity;
        int top;
        String str;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{vs9Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || vs9Var == null) {
            return;
        }
        int i6 = 8;
        if (this.f0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.b0 = 1;
        }
        this.f1129T = vs9Var;
        if (vs9Var.g() != null) {
            this.f1129T.g().r0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f1850);
        if (vs9Var.g() != null) {
            int J = vs9Var.g().J();
            this.R = J;
            if (J > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f14cc), Integer.valueOf(this.R)));
                NewSubPbActivity newSubPbActivity2 = this.f;
                if (newSubPbActivity2 != null) {
                    this.U.setText(newSubPbActivity2.h3());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0c30));
            }
            NewSubPbActivity newSubPbActivity3 = this.f;
            if (newSubPbActivity3 != null && newSubPbActivity3.G3()) {
                str = "PB";
            } else {
                str = null;
            }
            if (this.f != null && vs9Var.g().h0() != null) {
                this.A.setData(this.f.getPageContext(), vs9Var.g().h0(), bsa.a("PB", "c0132", vs9Var.d().getId(), vs9Var.d().getName(), vs9Var.j().getId(), str));
            } else {
                this.A.setData(null, null, null);
            }
        }
        if (vs9Var.m()) {
            this.C.U();
            this.i0.g(true);
        } else {
            this.C.g();
            this.i0.g(false);
        }
        ArrayList<vra> i7 = vs9Var.i();
        this.S = i7;
        if (i7 != null && i7.size() > o0) {
            int size = this.S.size() - o0;
            c0(size);
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
                arrayList.add(0, new t0a());
            }
        } else {
            this.d.setNextPage(this.C);
        }
        u0a u0aVar = new u0a();
        u0aVar.b(vs9Var.k());
        arrayList.add(0, u0aVar);
        if (this.f0) {
            arrayList.add(0, vs9Var.g());
        }
        NewSubPbActivity newSubPbActivity4 = this.f;
        if (newSubPbActivity4 != null && newSubPbActivity4.k3() != null) {
            MaskView maskView = this.k0;
            if (this.f.k3().c1()) {
                i6 = 0;
            }
            maskView.setVisibility(i6);
        }
        this.i0.e(this.f1129T.j(), arrayList);
        r(vs9Var, vs9Var.g(), vs9Var.e(), false, i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && (newSubPbActivity = this.f) != null && !qd.isEmpty(newSubPbActivity.k3().F0())) {
            String F0 = this.f.k3().F0();
            int i8 = 0;
            while (true) {
                if (i8 < arrayList.size()) {
                    if ((arrayList.get(i8) instanceof vra) && F0.equals(((vra) arrayList.get(i8)).T())) {
                        this.d.post(new c(this, i8));
                        break;
                    }
                    i8++;
                } else {
                    break;
                }
            }
        }
        if (this.f1129T.h() > 1) {
            this.d.setPullRefresh(this.e);
            this.a.setEnableDragExit(false);
            return;
        }
        this.d.setPullRefresh(null);
        this.a.setEnableDragExit(true);
    }

    public final void C0(MetaData metaData, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, metaData, z) != null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        int c2 = iu5.c(name_show);
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            i2 = qd.byteLength(metaData.getSealPrefix()) + 2;
        } else {
            i2 = 0;
        }
        if (c2 + i2 > 14) {
            String k2 = iu5.k(name_show, 0, 14);
            if (k2.length() == name_show.length()) {
                name_show = k2;
            } else {
                name_show = k2 + "...";
            }
        }
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            this.q.setText(J(metaData.getSealPrefix(), name_show));
        } else {
            this.q.setText(name_show);
        }
        if (metaData.getAlaUserData() != null && this.r != null) {
            if (metaData.getAlaUserData().anchor_live == 0) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
                qq4 qq4Var = new qq4();
                qq4Var.a = metaData.getAlaUserData();
                qq4Var.b = 4;
                this.r.setTag(qq4Var);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, (int) R.color.cp_cont_r);
        } else {
            EMManager.from(this.q).setTextColor(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setTargetScheme(metaData.getTargetScheme());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        ju9.a(this.p, metaData.getAvatarUrl(), metaData.getAvater(), 28);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_target_scheme, metaData.getTargetScheme());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        if (z) {
            this.t.setVisibility(0);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            this.u.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
        if (ListUtils.isEmpty(metaData.getTags())) {
            this.u.setVisibility(8);
            return;
        }
        dy9.f(this.u, metaData.getTags().get(0).img_info);
    }

    public void E0(boolean z) {
        String str;
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            n0a n0aVar = this.i0;
            if (n0aVar != null) {
                n0aVar.i(z);
                this.i0.c();
            }
            if (z && (newSubPbActivity = this.f) != null) {
                vz9.d(newSubPbActivity.getPageContext(), this.d0, this);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            vs9 vs9Var = this.f1129T;
            if (vs9Var != null && vs9Var.d() != null) {
                str = this.f1129T.d().getId();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "2"));
        }
    }

    public final SpannableStringBuilder J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new jl6.a(str, R.drawable.pic_smalldot_title));
                return jl6.h(this.f.getActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public void w0(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, str, z) == null) {
            if (z) {
                Q(NoDataViewFactory.e.d("", str));
            } else {
                Q(NoDataViewFactory.e.d(str, this.f.getPageContext().getString(R.string.refresh_view_title_text)));
            }
            this.V.setVisibility(8);
        }
    }

    public void M() {
        yg5 yg5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.U != null && (yg5Var = this.Q) != null) {
            if (yg5Var.z()) {
                this.U.setText(R.string.obfuscated_res_0x7f0f0612);
            } else {
                this.U.setText(this.f.h3());
            }
        }
    }

    public void m() {
        SubPbModel subPbModel;
        boolean z;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || (subPbModel = this.d0) == null) {
            return;
        }
        if ((B0() || (view2 = this.F) == null || !view2.isShown()) && !ListUtils.isEmpty(this.S)) {
            z = true;
        } else {
            z = false;
        }
        subPbModel.p1(z);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            MorePopupWindow morePopupWindow = this.D;
            if (morePopupWindow != null) {
                xb.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            a05 a05Var = this.E;
            if (a05Var != null) {
                a05Var.e();
            }
            zz4 zz4Var = this.J;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            h05 h05Var = this.I;
            if (h05Var != null) {
                xb.b(h05Var, this.f.getPageContext());
            }
            ProgressBar progressBar = this.N;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092372);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.K);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ce0);
            this.p = headImageView;
            headImageView.setRadius(BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0928c5);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090ba9);
            this.u = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090baa);
            this.v = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0925c7);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090803);
            this.w = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.K);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0105);
            this.w.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.w.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092361);
            this.x = tbImageView;
            tbImageView.setOnClickListener(this.K);
            this.z = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090166);
            this.y = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f092a1e);
            this.c.setOnTouchListener(this.n0);
            this.c.setOnClickListener(this.K);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070420);
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

    public final void Q(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.refresh_view_button_text), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f0703a6)), eVar, a2);
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

    public void s0(vra vraVar) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, vraVar) != null) || vraVar == null) {
            return;
        }
        vraVar.g1(true);
        vra vraVar2 = new vra();
        vraVar2.n1(52);
        if (!B0() && (view2 = this.F) != null && view2.isShown()) {
            i2 = (this.c0 - this.b0) - 1;
        } else {
            i2 = this.c0 - this.b0;
        }
        int count = ListUtils.getCount(this.S);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.S, 0, i2));
        ListUtils.add(arrayList, vraVar2);
        ListUtils.add(arrayList, vraVar);
        this.d.smoothScrollToPosition(this.c0 + 2);
        this.d.setNextPage(null);
    }

    public void R(yg5 yg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, yg5Var) == null) && yg5Var != null && yg5Var.a() != null) {
            this.Q = yg5Var;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.j.addView(yg5Var.a(), layoutParams);
            this.Q.V(new a(this));
        }
    }

    public final void c0(int i2) {
        ArrayList<vra> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048610, this, i2) != null) || (arrayList = this.S) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.S.clear();
        }
        int i3 = 0;
        Iterator<vra> it = this.S.iterator();
        while (it.hasNext()) {
            it.next();
            i3++;
            it.remove();
            if (i3 >= i2) {
                return;
            }
        }
    }

    public void X(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
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
            yg5 yg5Var = this.Q;
            if (yg5Var != null && yg5Var.a() != null) {
                this.Q.a().F(i2);
            }
            this.C.e(i2);
            this.y.b();
            SkinManager.setViewTextColor(this.U, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            EMManager.from(this.q).setTextStyle(R.string.F_X01);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            this.U.setAlpha(0.95f);
            n0a n0aVar = this.i0;
            if (n0aVar != null) {
                n0aVar.c();
            }
            SkinManager.setBackgroundColor(this.a0, R.color.CAM_X0203);
            WebPManager.setPureDrawable(this.Z, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.Y.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            EMManager.from(this.V).setBackGroundColor(R.color.CAM_X0208);
        }
    }

    public void Z(int i2, String str, int i3, boolean z, boolean z2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
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
            zz4 zz4Var = new zz4(this.f.getPageContext().getPageActivity());
            this.J = zz4Var;
            zz4Var.setMessageId(i4);
            this.J.setYesButtonTag(sparseArray);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f05a3, new h(this, sparseArray));
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f0598, new i(this));
            this.J.setCancelable(true);
            this.J.create(this.f.getPageContext());
            if (z2) {
                this.J.show();
            } else if (z) {
                this.J.show();
            } else if (1 == this.d0.B0()) {
                c16 c16Var = new c16(this.d0.B0(), this.d0.A0(), this.d0.E0());
                c16Var.i(this.f1129T.d().getId(), this.f1129T.d().getName());
                c16Var.h(this.d0.C0());
                c16Var.j(this.d0.S0());
                UserData userData = new UserData();
                userData.setIsManager(this.d0.G0());
                u0(sparseArray, c16Var, userData);
            } else {
                y0(sparseArray);
            }
        }
    }

    public void a0(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        f05 f05Var;
        f05 f05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, sparseArray, z) == null) {
            j05 j05Var = new j05(this.f.getBaseContext());
            j05Var.u(this.f.getString(R.string.obfuscated_res_0x7f0f0326));
            j05Var.r(new g(this, z));
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
                    f05Var2 = new f05(10, this.f.getString(R.string.obfuscated_res_0x7f0f0562), j05Var);
                } else {
                    f05Var2 = new f05(10, this.f.getString(R.string.obfuscated_res_0x7f0f0553), j05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                f05Var2.d.setTag(sparseArray2);
                arrayList.add(f05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                f05 f05Var3 = new f05(13, this.f.getString(R.string.multi_delete), j05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                f05Var3.d.setTag(sparseArray3);
                arrayList.add(f05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                f05 f05Var4 = new f05(11, this.f.getString(R.string.forbidden_person), j05Var);
                f05Var4.d.setTag(sparseArray4);
                arrayList.add(f05Var4);
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
                    f05Var = new f05(12, this.f.getString(R.string.un_mute), j05Var);
                } else {
                    f05Var = new f05(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d39), j05Var);
                }
                f05Var.d.setTag(sparseArray5);
                arrayList.add(f05Var);
            }
            lz9.f(arrayList);
            j05Var.n(arrayList, true);
            h05 h05Var = new h05(this.f.getPageContext(), j05Var);
            this.I = h05Var;
            h05Var.l();
        }
    }

    public void k(boolean z) {
        SubPbModel subPbModel;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (subPbModel = this.d0) != null && subPbModel.a1() && !z) {
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
                this.e0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07037a);
            }
            this.b.addView(this.G, 0, new LinearLayout.LayoutParams(-1, this.e0));
            this.G.setVisibility(0);
            this.G.setOnClickListener(new b(this));
            this.a.setBlankView(this.G);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0250  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(vra vraVar, int i2, SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArray2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        int i3;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048624, this, vraVar, i2, sparseArray) != null) || vraVar == null) {
            return;
        }
        if (sparseArray == null) {
            sparseArray2 = new SparseArray<>();
        } else {
            sparseArray2 = sparseArray;
        }
        if (i2 != 0) {
            if (i2 != 3) {
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            String userId2 = vraVar.t().getUserId();
            if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        vs9 vs9Var = this.f1129T;
        if (vs9Var != null && vs9Var.j() != null && this.f1129T.j().getAuthor() != null && vraVar.t() != null) {
            String userId3 = this.f1129T.j().getAuthor().getUserId();
            String userId4 = vraVar.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                    userId = vraVar.t().getUserId();
                    if (userId != null) {
                        z2 = true;
                        z4 = true;
                    }
                    if (vraVar.J() == 1) {
                    }
                    if (z) {
                    }
                    if (z2) {
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, vraVar.T());
                    if (z) {
                    }
                    if (z3) {
                    }
                    if (z2) {
                    }
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                    userId = vraVar.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    if (vraVar.J() == 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (z) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_forbid_user_post_id, vraVar.T());
                        if (vraVar.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, vraVar.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, vraVar.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, vraVar.t().getPortrait());
                        }
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_forbid_user_name, "");
                        sparseArray2.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray2.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, vraVar.T());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray2.put(R.id.tag_del_post_type, 0);
                        sparseArray2.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, vraVar.T());
                    if (z) {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (vraVar.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, vraVar.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, vraVar.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, vraVar.t().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (vraVar.t() != null) {
                            sparseArray2.put(R.id.tag_user_mute_mute_userid, vraVar.t().getUserId());
                            sparseArray2.put(R.id.tag_user_mute_mute_username, vraVar.t().getUserName());
                            sparseArray2.put(R.id.tag_user_mute_mute_nameshow, vraVar.t().getName_show());
                        }
                        vs9 vs9Var2 = this.f1129T;
                        if (vs9Var2 != null && vs9Var2.j() != null) {
                            sparseArray2.put(R.id.tag_user_mute_thread_id, this.f1129T.j().getId());
                        }
                        sparseArray2.put(R.id.tag_user_mute_post_id, vraVar.T());
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, vraVar.T());
                        sparseArray2.put(R.id.tag_has_sub_post, Boolean.valueOf(vraVar.A0()));
                        return;
                    }
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = vraVar.t().getUserId();
        if (userId != null) {
        }
        if (vraVar.J() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
        sparseArray2.put(R.id.tag_forbid_user_post_id, vraVar.T());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void r(vs9 vs9Var, vra vraVar, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{vs9Var, vraVar, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) && vraVar != null && !this.f0) {
            if (!StringUtils.isNull(vraVar.I())) {
                this.x.setVisibility(0);
                this.x.startLoad(vraVar.I(), 10, true);
            } else {
                this.x.setVisibility(8);
            }
            ora A = vraVar.A();
            if (A != null && A.a) {
                this.z.setVisibility(0);
            } else {
                this.z.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.c.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.c.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, vraVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            n(vraVar, i2, sparseArray);
            this.q.setText((CharSequence) null);
            if (!this.f0) {
                C0(vraVar.t(), z);
            }
            this.v.setText(StringHelper.getFormatTime(vraVar.q0()));
            boolean r0 = r0(this.w, vraVar.e0());
            if (StringUtils.isNull(vraVar.I()) && !r0 && vraVar.x0() != null) {
                this.y.setVisibility(0);
                this.y.setTag(vraVar.x0());
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final boolean r0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.Q() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.Q().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null) {
                        int type = next.getType();
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 17) {
                                    if (type != 18 && type != 1282) {
                                    }
                                } else {
                                    String str = next.R().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.P(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                }
                            }
                            tbRichTextData.o0(true);
                            textView.setMovementMethod(z4b.a());
                        } else {
                            tbRichTextData.P(next.a0());
                        }
                    }
                }
                if (!tbRichTextData.h0()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.a0() == null || tbRichTextData.a0().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.a0());
                    return true;
                } catch (Exception unused) {
                    textView.setText("");
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void s(int i2, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
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

    public final void u0(SparseArray<Object> sparseArray, c16 c16Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData x0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048639, this, sparseArray, c16Var, userData) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.h0 == null) {
                this.h0 = new d16(newSubPbActivity.getPageContext(), this.c, c16Var, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null && (x0 = subPbModel.x0()) != null && x0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = x0.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            this.h0.I(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.h0.H(negativeFeedBackData);
            this.h0.K("4");
            this.h0.J(new k(this, sparseArray));
        }
    }

    public void x0(a05.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048645, this, cVar, z) == null) {
            a05 a05Var = this.L;
            if (a05Var != null) {
                a05Var.e();
                this.L = null;
            }
            a05 a05Var2 = new a05(this.f.getPageContext().getPageActivity());
            this.L = a05Var2;
            if (z) {
                a05Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
            } else {
                a05Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion), this.f.getPageContext().getString(R.string.save_to_local)}, cVar);
            }
            this.L.c(this.f.getPageContext());
            this.L.m();
        }
    }

    public final void y0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData x0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, sparseArray) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.g0 == null) {
                this.g0 = new a16(newSubPbActivity.getPageContext(), this.c);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            SubPbModel subPbModel = this.d0;
            if (subPbModel != null && (x0 = subPbModel.x0()) != null && x0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = x0.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            this.g0.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.g0.A(negativeFeedBackData);
            this.g0.D("4");
            this.g0.C(new j(this, sparseArray));
        }
    }
}
