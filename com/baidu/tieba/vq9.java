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
import com.baidu.tieba.i55;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.sub.BlankView;
import com.baidu.tieba.pb.pb.sub.EllipsizeRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.SubPbView;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.v46;
import com.baidu.tieba.vk9;
import com.baidu.tieba.wga;
import com.baidu.tieba.xo6;
import com.baidu.tieba.y45;
import com.baidu.tieba.y46;
import com.baidu.tieba.z45;
import com.baidu.tieba.z95;
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
/* loaded from: classes8.dex */
public class vq9 implements KeyboardEventLayout.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int n0;
    public static int o0;
    public transient /* synthetic */ FieldHolder $fh;
    public BlueCircleProgressDialog A;
    public yq9 B;
    public MorePopupWindow C;
    public z45 D;
    public View E;
    public BlankView F;
    public View G;
    public g55 H;
    public y45 I;
    public View.OnClickListener J;
    public z45 K;
    public boolean L;
    public ProgressBar M;
    public NewSubPbActivity.u0 N;
    public NewSubPbActivity.u0 O;
    public al5 P;
    public int Q;
    public ArrayList<tha> R;
    public rj9 S;

    /* renamed from: T  reason: collision with root package name */
    public TextView f1175T;
    public RelativeLayout U;
    public ImageView V;
    public ImageView W;
    public LinearLayout X;
    public ImageView Y;
    public View Z;
    public SubPbView a;
    public int a0;
    public LinearLayout b;
    public int b0;
    public View c;
    public SubPbModel c0;
    public BdTypeListView d;
    public int d0;
    public fs9 e;
    public boolean e0;
    public NewSubPbActivity f;
    public v46 f0;
    public NoNetworkView g;
    public y46 g0;
    public NoDataView h;
    public xq9 h0;
    public View.OnClickListener i;
    public z95.g i0;
    public RelativeLayout j;
    public MaskView j0;
    public NavigationBar k;
    public BdUniqueId k0;
    public ImageView l;
    public final CustomMessageListener l0;
    public View m;
    public vk9 m0;
    public TextView n;
    public LinearLayout o;
    public HeadImageView p;
    public TextView q;
    public View r;
    public ImageView s;
    public TextView t;
    public TextView u;
    public EllipsizeRichTextView v;
    public TbImageView w;
    public PlayVoiceBntNew x;
    public TextView y;
    public ThreadSkinView z;

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

    /* loaded from: classes8.dex */
    public class a implements wga.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;

        public a(vq9 vq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq9Var;
        }

        @Override // com.baidu.tieba.wga.h
        public void c(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                this.a.M();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;

        public b(vq9 vq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.F != null) {
                this.a.a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vq9 b;

        public c(vq9 vq9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vq9Var;
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

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vq9 vq9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, Integer.valueOf(i)};
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
            this.a = vq9Var;
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

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;

        public e(vq9 vq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.c0 != null && (this.a.c0.Z0() || this.a.c0.W0())) {
                    this.a.f.finish();
                } else if (this.a.F != null) {
                    this.a.a.g();
                } else {
                    this.a.f.finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements vk9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq9 a;

        @Override // com.baidu.tieba.vk9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.vk9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public f(vq9 vq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq9Var;
        }

        @Override // com.baidu.tieba.vk9.a
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

    /* loaded from: classes8.dex */
    public class g implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ vq9 b;

        public g(vq9 vq9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vq9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.b.H.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.Z(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue(), false);
                        return;
                    case 11:
                        if (this.b.N != null) {
                            this.b.N.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.K3(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
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

    /* loaded from: classes8.dex */
    public class h implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ vq9 b;

        public h(vq9 vq9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vq9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                if (this.b.O != null) {
                    this.b.O.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type)});
                }
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(vq9 vq9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements v46.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ vq9 b;

        public j(vq9 vq9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vq9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.v46.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.O != null) {
                    this.b.O.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements y46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ vq9 b;

        public k(vq9 vq9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vq9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.y46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.b.O != null) {
                    this.b.O.callback(new Object[]{this.a.get(R.id.tag_del_post_id), this.a.get(R.id.tag_manage_user_identity), this.a.get(R.id.tag_del_post_is_self), this.a.get(R.id.tag_del_post_type), JsonArrayToString});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ vq9 b;

        public l(vq9 vq9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vq9Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948249579, "Lcom/baidu/tieba/vq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948249579, "Lcom/baidu/tieba/vq9;");
                return;
            }
        }
        n0 = TbadkCoreApplication.getInst().getListItemRule().c();
        o0 = 2;
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
            return this.h0.a();
        }
        return invokeV.booleanValue;
    }

    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.E;
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
            this.b0 = bdTypeListView.getLastVisiblePosition();
        }
    }

    public ImageView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.W;
        }
        return (ImageView) invokeV.objValue;
    }

    public ImageView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.V;
        }
        return (ImageView) invokeV.objValue;
    }

    public TextView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f1175T;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.v;
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
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (blueCircleProgressDialog = this.A) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void L() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (noDataView = this.h) != null) {
            noDataView.setVisibility(8);
            this.d.setVisibility(0);
            this.U.setVisibility(0);
            this.a.setOnTouchListener(null);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.l0.setTag(this.k0);
            MessageManager.getInstance().registerListener(this.l0);
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
        xq9 xq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (xq9Var = this.h0) != null) {
            xq9Var.c();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SubPbView subPbView = this.a;
            if (subPbView != null) {
                subPbView.f();
            }
            al5 al5Var = this.P;
            if (al5Var != null) {
                al5Var.F();
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || this.f.e4()) {
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.setVisibility(0);
            this.M.setVisibility(8);
            this.B.g();
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d.setVisibility(0);
            this.M.setVisibility(8);
            this.B.V();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            o0(this.f);
            this.d.setNextPage(this.B);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o0);
            TiebaStatic.log(statisticItem);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.M.bringToFront();
            this.M.setVisibility(0);
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            BlankView blankView = this.F;
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
            if (this.A == null) {
                this.A = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.A.setDialogVisiable(true);
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
            al5 al5Var = this.P;
            if (al5Var != null && al5Var.a() != null) {
                return this.P.a().getHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public ImageView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.Y;
        }
        return (ImageView) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.w;
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
            this.d.setNextPage(this.B);
            this.B.U();
        }
    }

    public vq9(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
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
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.L = true;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = 0;
        this.f1175T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.a0 = 2;
        this.b0 = 0;
        this.d0 = 0;
        this.e0 = true;
        this.l0 = new d(this, 2010045);
        this.m0 = new vk9(new f(this));
        this.f = newSubPbActivity;
        this.J = onClickListener;
        this.a = (SubPbView) LayoutInflater.from(newSubPbActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0727, (ViewGroup) null);
        this.c = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0726, (ViewGroup) null);
        this.b = (LinearLayout) this.a.findViewById(R.id.navigation_bar_group);
        this.U = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092342);
        TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092343);
        this.f1175T = textView;
        textView.setOnClickListener(this.J);
        this.V = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092345);
        ImageView imageView = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f092344);
        this.W = imageView;
        imageView.setOnClickListener(this.J);
        this.V.setOnClickListener(this.J);
        this.g = (NoNetworkView) this.a.findViewById(R.id.view_no_network);
        P();
        N();
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092335);
        this.d = (BdTypeListView) this.a.findViewById(R.id.obfuscated_res_0x7f09195f);
        ThreadSkinView threadSkinView = (ThreadSkinView) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d09a5, (ViewGroup) null);
        this.z = threadSkinView;
        this.d.addHeaderView(threadSkinView);
        this.d.addHeaderView(this.c);
        this.G = new TextView(newSubPbActivity.getActivity());
        this.G.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.d.w(this.G, 0);
        this.a.setTopView(this.G);
        this.a.setNavigationView(this.b);
        this.a.setListView(this.d);
        this.a.setContentView(this.j);
        yq9 yq9Var = new yq9(this.f.getPageContext());
        this.B = yq9Var;
        yq9Var.B();
        this.E = this.B.c();
        this.d.setNextPage(this.B);
        this.B.G(this.J);
        this.d.setOnTouchListener(this.m0);
        fs9 fs9Var = new fs9(newSubPbActivity.getPageContext());
        this.e = fs9Var;
        fs9Var.f();
        this.e.a(this.i0);
        this.e.C(TbadkCoreApplication.getInst().getSkinType());
        this.M = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091dad);
        this.j0 = (MaskView) this.a.findViewById(R.id.mask_view);
        this.Z = this.a.findViewById(R.id.obfuscated_res_0x7f09299b);
        this.X = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091aca);
        ImageView imageView2 = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090992);
        this.Y = imageView2;
        imageView2.setVisibility(0);
        this.Y.setOnClickListener(this.J);
        ImageView imageView3 = this.Y;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.icon_pure_post_expression24);
            p();
        }
        X(TbadkCoreApplication.getInst().getSkinType());
        View view2 = this.c;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        View a2 = tv4.b().a(this.f.getActivity(), 4);
        this.r = a2;
        if (a2 != null) {
            a2.setVisibility(8);
            this.o.addView(this.r, 3);
        }
        xq9 xq9Var = new xq9(this.f, this.d);
        this.h0 = xq9Var;
        xq9Var.f(this.L);
        this.h0.d(this.J);
        this.h0.b();
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
            this.O = u0Var;
        }
    }

    public void f0(NewSubPbActivity.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, u0Var) == null) {
            this.N = u0Var;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.e0 = z;
        }
    }

    public void h0(z95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, gVar) == null) {
            this.i0 = gVar;
            fs9 fs9Var = this.e;
            if (fs9Var != null) {
                fs9Var.a(gVar);
            }
        }
    }

    public void j0(SubPbModel subPbModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, subPbModel) == null) {
            this.c0 = subPbModel;
        }
    }

    public void k0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, zVar) == null) {
            this.h0.j(zVar);
        }
    }

    public void l0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.h0.h(onLongClickListener);
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
            this.k0 = bdUniqueId;
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
            this.U.setVisibility(8);
        }
    }

    public void A0(rj9 rj9Var, int i2, boolean z, boolean z2) {
        int i3;
        int i4;
        int i5;
        int top;
        String str;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rj9Var, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || rj9Var == null) {
            return;
        }
        int i6 = 8;
        if (this.e0 && (view2 = this.c) != null) {
            view2.setVisibility(8);
            this.d.removeHeaderView(this.c);
            this.a0 = 1;
        }
        this.S = rj9Var;
        if (rj9Var.g() != null) {
            this.S.g().j0 = true;
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.n.setText(R.string.obfuscated_res_0x7f0f1855);
        if (rj9Var.g() != null) {
            int L = rj9Var.g().L();
            this.Q = L;
            if (L > 0) {
                this.k.setCenterTextTitle(String.format(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f14a1), Integer.valueOf(this.Q)));
                NewSubPbActivity newSubPbActivity = this.f;
                if (newSubPbActivity != null) {
                    this.f1175T.setText(newSubPbActivity.C3());
                }
            } else {
                this.k.setCenterTextTitle(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f0c0f));
            }
            if (this.f.b4()) {
                str = "PB";
            } else {
                str = null;
            }
            if (rj9Var.g().i0() != null) {
                this.z.setData(this.f.getPageContext(), rj9Var.g().i0(), zha.a("PB", "c0132", rj9Var.d().getId(), rj9Var.d().getName(), rj9Var.j().getId(), str));
            } else {
                this.z.setData(null, null, null);
            }
        }
        if (rj9Var.m()) {
            this.B.U();
            this.h0.g(true);
        } else {
            this.B.g();
            this.h0.g(false);
        }
        ArrayList<tha> i7 = rj9Var.i();
        this.R = i7;
        if (i7 != null && i7.size() > n0) {
            int size = this.R.size() - n0;
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
        arrayList.addAll(this.R);
        if (ListUtils.isEmpty(this.R)) {
            this.d.setNextPage(null);
            if (this.e0) {
                arrayList.add(0, new dr9());
            }
        } else {
            this.d.setNextPage(this.B);
        }
        er9 er9Var = new er9();
        er9Var.b(rj9Var.k());
        arrayList.add(0, er9Var);
        if (this.e0) {
            arrayList.add(0, rj9Var.g());
        }
        NewSubPbActivity newSubPbActivity2 = this.f;
        if (newSubPbActivity2 != null && newSubPbActivity2.F3() != null) {
            MaskView maskView = this.j0;
            if (this.f.F3().a1()) {
                i6 = 0;
            }
            maskView.setVisibility(i6);
        }
        this.h0.e(this.S.j(), arrayList);
        r(rj9Var, rj9Var.g(), rj9Var.e(), false, i2, z);
        if (i3 > 0) {
            this.d.setSelectionFromTop(i4, i5);
        } else if (z2 && !ei.isEmpty(this.f.F3().D0())) {
            String D0 = this.f.F3().D0();
            int i8 = 0;
            while (true) {
                if (i8 < arrayList.size()) {
                    if ((arrayList.get(i8) instanceof tha) && D0.equals(((tha) arrayList.get(i8)).U())) {
                        this.d.post(new c(this, i8));
                        break;
                    }
                    i8++;
                } else {
                    break;
                }
            }
        }
        if (this.S.h() > 1) {
            this.d.setPullRefresh(this.e);
            this.a.setEnableDragExit(false);
            return;
        }
        this.d.setPullRefresh(null);
        this.a.setEnableDragExit(true);
    }

    public final void C0(MetaData metaData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, metaData) != null) || metaData == null) {
            return;
        }
        String name_show = metaData.getName_show();
        int c2 = ey5.c(name_show);
        if (!StringUtils.isNull(metaData.getSealPrefix())) {
            i2 = ei.byteLength(metaData.getSealPrefix()) + 2;
        } else {
            i2 = 0;
        }
        if (c2 + i2 > 14) {
            String k2 = ey5.k(name_show, 0, 14);
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
                sv4 sv4Var = new sv4();
                sv4Var.a = metaData.getAlaUserData();
                sv4Var.b = 4;
                this.r.setTag(sv4Var);
            }
        }
        if (metaData.isBigV()) {
            SkinManager.setViewTextColor(this.q, (int) R.color.cp_cont_r);
        } else {
            EMManager.from(this.q).setTextColor(R.color.CAM_X0106);
        }
        this.p.setVisibility(0);
        this.p.setUserId(metaData.getUserId());
        this.p.setUserName(metaData.getUserName());
        this.p.setDefaultResource(R.drawable.transparent_bg);
        UtilHelper.showHeadImageViewBigV(this.p, metaData);
        this.p.startLoad(metaData.getAvater(), 28, false);
        this.o.setTag(R.id.tag_user_id, metaData.getUserId());
        this.o.setTag(R.id.tag_user_name, metaData.getUserName());
        this.o.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
    }

    public final void y0(SparseArray<Object> sparseArray) {
        NewSubPbActivity newSubPbActivity;
        AntiData v0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048647, this, sparseArray) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.f0 == null) {
                this.f0 = new v46(newSubPbActivity.getPageContext(), this.c);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            SubPbModel subPbModel = this.c0;
            if (subPbModel != null && (v0 = subPbModel.v0()) != null && v0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = v0.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            this.f0.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.f0.A(negativeFeedBackData);
            this.f0.D("4");
            this.f0.C(new j(this, sparseArray));
        }
    }

    public void E0(boolean z) {
        String str;
        NewSubPbActivity newSubPbActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            xq9 xq9Var = this.h0;
            if (xq9Var != null) {
                xq9Var.i(z);
                this.h0.c();
            }
            if (z && (newSubPbActivity = this.f) != null) {
                fq9.d(newSubPbActivity.getPageContext(), this.c0, this);
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            rj9 rj9Var = this.S;
            if (rj9Var != null && rj9Var.d() != null) {
                str = this.S.d().getId();
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
                arrayList.add(new xo6.a(str, R.drawable.pic_smalldot_title));
                return xo6.h(this.f.getActivity(), str2, arrayList, true);
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
            this.U.setVisibility(8);
        }
    }

    public void M() {
        al5 al5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f1175T != null && (al5Var = this.P) != null) {
            if (al5Var.y()) {
                this.f1175T.setText(R.string.obfuscated_res_0x7f0f060a);
            } else {
                this.f1175T.setText(this.f.C3());
            }
        }
    }

    public void m() {
        SubPbModel subPbModel;
        boolean z;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || (subPbModel = this.c0) == null) {
            return;
        }
        if ((B0() || (view2 = this.E) == null || !view2.isShown()) && !ListUtils.isEmpty(this.R)) {
            z = true;
        } else {
            z = false;
        }
        subPbModel.n1(z);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            MorePopupWindow morePopupWindow = this.C;
            if (morePopupWindow != null) {
                kg.d(morePopupWindow, this.f.getPageContext().getPageActivity());
            }
            z45 z45Var = this.D;
            if (z45Var != null) {
                z45Var.e();
            }
            y45 y45Var = this.I;
            if (y45Var != null) {
                y45Var.dismiss();
            }
            g55 g55Var = this.H;
            if (g55Var != null) {
                kg.b(g55Var, this.f.getPageContext());
            }
            ProgressBar progressBar = this.M;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092346);
            this.o = linearLayout;
            linearLayout.setOnClickListener(this.J);
            HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091ca3);
            this.p = headImageView;
            headImageView.setRadius(BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.tbds45));
            this.p.setClickable(false);
            this.q = (TextView) this.c.findViewById(R.id.user_name);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0928a5);
            this.s = imageView;
            imageView.setVisibility(8);
            this.t = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090b7a);
            this.u = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09259a);
            EllipsizeRichTextView ellipsizeRichTextView = (EllipsizeRichTextView) this.c.findViewById(R.id.obfuscated_res_0x7f0907d1);
            this.v = ellipsizeRichTextView;
            ellipsizeRichTextView.setOnClickListener(this.J);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            this.v.setLineSpacing(0.0f, 1.25f);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f092336);
            this.w = tbImageView;
            tbImageView.setOnClickListener(this.J);
            this.y = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090150);
            this.x = (PlayVoiceBntNew) this.c.findViewById(R.id.obfuscated_res_0x7f092a02);
            this.c.setOnTouchListener(this.m0);
            this.c.setOnClickListener(this.J);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.f.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070424);
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
            this.n.setOnClickListener(this.J);
        }
    }

    public final void Q(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f.getPageContext().getString(R.string.refresh_view_button_text), this.i));
            if (this.h == null) {
                Activity pageActivity = this.f.getPageContext().getPageActivity();
                this.h = NoDataViewFactory.a(pageActivity, this.j, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NETERROR, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f0703aa)), eVar, a2);
            }
            this.d.setVisibility(8);
            this.M.setVisibility(8);
            this.P.A();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            this.h.setClickable(true);
            this.h.setTextOption(eVar);
            this.h.f(this.f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(0);
        }
    }

    public void s0(tha thaVar) {
        int i2;
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048635, this, thaVar) != null) || thaVar == null) {
            return;
        }
        thaVar.f1(true);
        tha thaVar2 = new tha();
        thaVar2.m1(52);
        if (!B0() && (view2 = this.E) != null && view2.isShown()) {
            i2 = (this.b0 - this.a0) - 1;
        } else {
            i2 = this.b0 - this.a0;
        }
        int count = ListUtils.getCount(this.R);
        if (i2 > count) {
            i2 = count;
        }
        ArrayList arrayList = new ArrayList(ListUtils.subList(this.R, 0, i2));
        ListUtils.add(arrayList, thaVar2);
        ListUtils.add(arrayList, thaVar);
        this.d.smoothScrollToPosition(this.b0 + 2);
        this.d.setNextPage(null);
    }

    public void R(al5 al5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, al5Var) == null) && al5Var != null && al5Var.a() != null) {
            this.P = al5Var;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.j.addView(al5Var.a(), layoutParams);
            this.P.U(new a(this));
        }
    }

    public final void c0(int i2) {
        ArrayList<tha> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048610, this, i2) != null) || (arrayList = this.R) == null) {
            return;
        }
        if (arrayList.size() <= i2) {
            this.R.clear();
        }
        int i3 = 0;
        Iterator<tha> it = this.R.iterator();
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
            SubPbModel subPbModel = this.c0;
            if (subPbModel != null && (subPbModel.Z0() || this.c0.W0())) {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.n;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0304);
            }
            this.g.onChangeSkinType(this.f.getPageContext(), i2);
            this.f.getLayoutMode().onModeChanged(this.E);
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0105);
            this.v.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            al5 al5Var = this.P;
            if (al5Var != null && al5Var.a() != null) {
                this.P.a().z(i2);
            }
            this.B.e(i2);
            this.x.b();
            SkinManager.setViewTextColor(this.f1175T, (int) R.color.CAM_X0110);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
            EMManager.from(this.q).setTextStyle(R.string.F_X01);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0106);
            this.f1175T.setAlpha(0.95f);
            xq9 xq9Var = this.h0;
            if (xq9Var != null) {
                xq9Var.c();
            }
            SkinManager.setBackgroundColor(this.Z, R.color.CAM_X0203);
            WebPManager.setPureDrawable(this.Y, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            this.X.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f, R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            EMManager.from(this.U).setBackGroundColor(R.color.CAM_X0208);
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
            y45 y45Var = new y45(this.f.getPageContext().getPageActivity());
            this.I = y45Var;
            y45Var.setMessageId(i4);
            this.I.setYesButtonTag(sparseArray);
            this.I.setPositiveButton(R.string.obfuscated_res_0x7f0f059b, new h(this, sparseArray));
            this.I.setNegativeButton(R.string.obfuscated_res_0x7f0f0590, new i(this));
            this.I.setCancelable(true);
            this.I.create(this.f.getPageContext());
            if (z2) {
                this.I.show();
            } else if (z) {
                this.I.show();
            } else if (1 == this.c0.z0()) {
                x46 x46Var = new x46(this.c0.z0(), this.c0.y0(), this.c0.C0());
                x46Var.i(this.S.d().getId(), this.S.d().getName());
                x46Var.h(this.c0.A0());
                x46Var.j(this.c0.Q0());
                UserData userData = new UserData();
                userData.setIsManager(this.c0.E0());
                u0(sparseArray, x46Var, userData);
            } else {
                y0(sparseArray);
            }
        }
    }

    public void a0(SparseArray<Object> sparseArray, boolean z) {
        int i2;
        e55 e55Var;
        e55 e55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048608, this, sparseArray, z) == null) {
            i55 i55Var = new i55(this.f.getBaseContext());
            i55Var.t(this.f.getString(R.string.obfuscated_res_0x7f0f0324));
            i55Var.q(new g(this, z));
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
                    e55Var2 = new e55(10, this.f.getString(R.string.obfuscated_res_0x7f0f055a), i55Var);
                } else {
                    e55Var2 = new e55(10, this.f.getString(R.string.obfuscated_res_0x7f0f054b), i55Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                e55Var2.d.setTag(sparseArray2);
                arrayList.add(e55Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                e55 e55Var3 = new e55(13, this.f.getString(R.string.multi_delete), i55Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                e55Var3.d.setTag(sparseArray3);
                arrayList.add(e55Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                e55 e55Var4 = new e55(11, this.f.getString(R.string.forbidden_person), i55Var);
                e55Var4.d.setTag(sparseArray4);
                arrayList.add(e55Var4);
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
                    e55Var = new e55(12, this.f.getString(R.string.un_mute), i55Var);
                } else {
                    e55Var = new e55(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d18), i55Var);
                }
                e55Var.d.setTag(sparseArray5);
                arrayList.add(e55Var);
            }
            vp9.f(arrayList);
            i55Var.m(arrayList, true);
            g55 g55Var = new g55(this.f.getPageContext(), i55Var);
            this.H = g55Var;
            g55Var.l();
        }
    }

    public void k(boolean z) {
        SubPbModel subPbModel;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048618, this, z) == null) && (subPbModel = this.c0) != null && subPbModel.Y0() && !z) {
            this.k.setIsClose(true);
            this.k.setIsCorner(true);
            this.k.isShowBottomLine(true);
            this.k.setBottomLineHeight(3);
            this.k.setStatusBarVisibility(8);
            this.F = new BlankView(this.f.getPageContext().getPageActivity());
            if (this.c0.Z0()) {
                boolean isNotchScreen = TbSingleton.getInstance().isNotchScreen(this.f);
                boolean isCutoutScreen = TbSingleton.getInstance().isCutoutScreen(this.f);
                if (!isNotchScreen && !isCutoutScreen) {
                    i2 = UtilHelper.getStatusBarHeight();
                } else {
                    i2 = 0;
                }
                this.d0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds562) + i2;
            } else {
                this.d0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07037e);
            }
            this.b.addView(this.F, 0, new LinearLayout.LayoutParams(-1, this.d0));
            this.F.setVisibility(0);
            this.F.setOnClickListener(new b(this));
            this.a.setBlankView(this.F);
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
    /* JADX WARN: Removed duplicated region for block: B:83:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(tha thaVar, int i2, SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArray2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        int i3;
        boolean z5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048624, this, thaVar, i2, sparseArray) != null) || thaVar == null) {
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
            String userId2 = thaVar.t().getUserId();
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
        rj9 rj9Var = this.S;
        if (rj9Var != null && rj9Var.j() != null && this.S.j().getAuthor() != null && thaVar.t() != null) {
            String userId3 = this.S.j().getAuthor().getUserId();
            String userId4 = thaVar.t().getUserId();
            if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                if (!StringUtils.isNull(userId4) && userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                    userId = thaVar.t().getUserId();
                    if (userId != null) {
                        z2 = true;
                        z4 = true;
                    }
                    if (thaVar.L() == 1) {
                    }
                    if (z) {
                    }
                    if (z2) {
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, thaVar.U());
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
                    userId = thaVar.t().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z4 = true;
                    }
                    if (thaVar.L() == 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (z) {
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_forbid_user_post_id, thaVar.U());
                        if (thaVar.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, thaVar.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, thaVar.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, thaVar.t().getPortrait());
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
                        sparseArray2.put(R.id.tag_del_post_id, thaVar.U());
                        z5 = true;
                    } else {
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.FALSE);
                        sparseArray2.put(R.id.tag_del_post_type, 0);
                        sparseArray2.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray2.put(R.id.tag_forbid_user_post_id, thaVar.U());
                    if (z) {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        if (thaVar.t() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, thaVar.t().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, thaVar.t().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, thaVar.t().getPortrait());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    if (z3) {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (thaVar.t() != null) {
                            sparseArray2.put(R.id.tag_user_mute_mute_userid, thaVar.t().getUserId());
                            sparseArray2.put(R.id.tag_user_mute_mute_username, thaVar.t().getUserName());
                            sparseArray2.put(R.id.tag_user_mute_mute_nameshow, thaVar.t().getName_show());
                        }
                        if (this.S.j() != null) {
                            sparseArray2.put(R.id.tag_user_mute_thread_id, this.S.j().getId());
                        }
                        sparseArray2.put(R.id.tag_user_mute_post_id, thaVar.U());
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                        sparseArray2.put(R.id.tag_del_post_type, Integer.valueOf(i3));
                        sparseArray2.put(R.id.tag_del_post_id, thaVar.U());
                        sparseArray2.put(R.id.tag_has_sub_post, Boolean.valueOf(thaVar.A0()));
                        return;
                    }
                    sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    return;
                }
            }
        }
        z3 = false;
        z4 = false;
        userId = thaVar.t().getUserId();
        if (userId != null) {
        }
        if (thaVar.L() == 1) {
        }
        if (z) {
        }
        if (z2) {
        }
        sparseArray2.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
        sparseArray2.put(R.id.tag_forbid_user_post_id, thaVar.U());
        if (z) {
        }
        if (z3) {
        }
        if (z2) {
        }
    }

    public void r(rj9 rj9Var, tha thaVar, boolean z, boolean z2, int i2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{rj9Var, thaVar, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Boolean.valueOf(z3)}) == null) && thaVar != null && !this.e0) {
            if (!StringUtils.isNull(thaVar.K())) {
                this.w.setVisibility(0);
                this.w.startLoad(thaVar.K(), 10, true);
            } else {
                this.w.setVisibility(8);
            }
            mha C = thaVar.C();
            if (C != null && C.a) {
                this.y.setVisibility(0);
            } else {
                this.y.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.c.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.c.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, thaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            n(thaVar, i2, sparseArray);
            this.q.setText((CharSequence) null);
            this.t.setVisibility(8);
            if (!this.e0) {
                C0(thaVar.t());
                if (z) {
                    this.t.setVisibility(0);
                    SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0302);
                }
            }
            this.u.setText(StringHelper.getFormatTime(thaVar.q0()));
            boolean r0 = r0(this.v, thaVar.f0());
            if (StringUtils.isNull(thaVar.K()) && !r0 && thaVar.x0() != null) {
                this.x.setVisibility(0);
                this.x.setTag(thaVar.x0());
                return;
            }
            this.x.setVisibility(8);
        }
    }

    public final boolean r0(TextView textView, TbRichText tbRichText) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, textView, tbRichText)) == null) {
            if (textView != null && tbRichText != null && tbRichText.O() != null) {
                TbRichTextData tbRichTextData = new TbRichTextData(1);
                Iterator<TbRichTextData> it = tbRichText.O().iterator();
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
                                    String str = next.P().mGifInfo.mSharpText;
                                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                                        String substring = str.substring(2, str.length() - 1);
                                        tbRichTextData.N(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                                    }
                                }
                            }
                            tbRichTextData.m0(true);
                            textView.setMovementMethod(nva.a());
                        } else {
                            tbRichTextData.N(next.Y());
                        }
                    }
                }
                if (!tbRichTextData.f0()) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                try {
                    if (tbRichTextData.Y() == null || tbRichTextData.Y().length() <= 0) {
                        return false;
                    }
                    textView.setText(tbRichTextData.Y());
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
            ProgressBar progressBar = this.M;
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

    public final void u0(SparseArray<Object> sparseArray, x46 x46Var, UserData userData) {
        NewSubPbActivity newSubPbActivity;
        AntiData v0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048639, this, sparseArray, x46Var, userData) == null) && (newSubPbActivity = this.f) != null && sparseArray != null && this.c != null) {
            if (this.g0 == null) {
                this.g0 = new y46(newSubPbActivity.getPageContext(), this.c, x46Var, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            SubPbModel subPbModel = this.c0;
            if (subPbModel != null && (v0 = subPbModel.v0()) != null && v0.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = v0.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
            this.g0.H(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.g0.G(negativeFeedBackData);
            this.g0.J("4");
            this.g0.I(new k(this, sparseArray));
        }
    }

    public void x0(z45.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048645, this, cVar, z) == null) {
            z45 z45Var = this.K;
            if (z45Var != null) {
                z45Var.e();
                this.K = null;
            }
            z45 z45Var2 = new z45(this.f.getPageContext().getPageActivity());
            this.K = z45Var2;
            if (z) {
                z45Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion)}, cVar);
            } else {
                z45Var2.j(new String[]{this.f.getPageContext().getString(R.string.save_to_emotion), this.f.getPageContext().getString(R.string.save_to_local)}, cVar);
            }
            this.K.c(this.f.getPageContext());
            this.K.m();
        }
    }
}
