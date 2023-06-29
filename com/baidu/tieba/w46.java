package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.r46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public String B;
    public u95 C;
    public CompoundButton.OnCheckedChangeListener D;
    public CustomMessageListener E;
    public PopupWindow.OnDismissListener F;
    public CustomMessageListener G;
    public Context a;
    public TbPageContext b;
    public PopupWindow c;
    public ViewGroup d;
    public k35 e;
    public SparseArray<String> f;
    public List<r46.b> g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public NEGFeedBackView.b l;
    public PopupWindow m;
    public View n;
    public r46 o;
    public boolean p;
    public int q;
    public int r;
    public LinearLayout s;
    public g t;
    public h u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public View z;

    /* loaded from: classes8.dex */
    public interface g {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface h {
        void a(JSONArray jSONArray);
    }

    /* loaded from: classes8.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w46 a;

        public a(w46 w46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w46Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.l != null) {
                    this.a.l.b(this.a.e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof r46.b) {
                    r46.b bVar = (r46.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.g.contains(bVar)) {
                            this.a.g.add(bVar);
                            return;
                        }
                        return;
                    }
                    this.a.g.remove(bVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w46 w46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w46Var, Integer.valueOf(i)};
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
            this.a = w46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921745) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w46 a;

        public c(w46 w46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w46Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.m != null) {
                this.a.m.dismiss();
                this.a.m = null;
                MessageManager.getInstance().unRegisterListener(this.a.G);
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                MessageManager.getInstance().unRegisterListener(this.a.E);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(w46 w46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w46Var, Integer.valueOf(i)};
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
            this.a = w46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.r();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w46 a;

        public e(w46 w46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m != null) {
                    this.a.m.dismiss();
                    this.a.m = null;
                }
                if (this.a.c != null) {
                    this.a.c.dismiss();
                    this.a.c = null;
                }
                if (this.a.h) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.a.B));
                }
                if (this.a.t != null) {
                    this.a.t.onClick();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.a.B).param("obj_type", "9"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w46 a;

        public f(w46 w46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                JSONObject t = this.a.t();
                if (this.a.B != "3" && this.a.B != "4" && this.a.B != "1") {
                    if (t != null) {
                        this.a.E();
                        CustomMessage customMessage = new CustomMessage(2016489, this.a.b.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, t);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        return;
                    }
                    return;
                }
                this.a.s();
            }
        }
    }

    public w46(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.l = null;
        this.q = 3;
        this.C = null;
        this.D = new a(this);
        this.E = new b(this, 2921745);
        this.F = new c(this);
        this.G = new d(this, 2001304);
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        this.n = view2;
        w();
    }

    public void B(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            this.o.k(strArr);
        }
    }

    public void C(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.u = hVar;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.h = z;
        }
    }

    public void A(k35 k35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, k35Var) != null) || k35Var == null) {
            return;
        }
        this.e = k35Var;
        SparseArray<String> b2 = k35Var.b();
        this.f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f.size() - 1; size >= 8; size--) {
                this.f.removeAt(size);
            }
        }
        this.o.j(k35Var);
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || this.a == null) {
            return;
        }
        this.B = str;
        View u = u();
        if (u != null && u.getParent() != null) {
            ((ViewGroup) u.getParent()).removeView(u);
        }
        r();
        this.i = v() - xi.g(this.a, R.dimen.obfuscated_res_0x7f07035d);
        PopupWindow popupWindow = new PopupWindow(u, this.j, this.i);
        this.c = popupWindow;
        GreyUtil.grey(popupWindow);
        this.c.setFocusable(true);
        this.c.setTouchable(true);
        this.c.setOnDismissListener(this.F);
        y();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.m = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.m.setAttachedInDecor(false);
        }
        this.m.showAtLocation(this.n, 0, 0, 0);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
        SkinManager.setBackgroundDrawable(this.c, R.drawable.bg_dailog);
        this.c.showAtLocation(this.n, 17, 0, 0);
        NEGFeedBackView.b bVar = this.l;
        if (bVar != null) {
            bVar.c(this.e);
        }
        this.p = true;
        this.b.registerListener(this.E);
        this.b.registerListener(this.G);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.C == null) {
                this.C = new u95(this.b);
            }
            this.C.i(R.string.obfuscated_res_0x7f0f0bd7);
            this.C.h(true);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PopupWindow popupWindow = this.c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.c = null;
            }
            PopupWindow popupWindow2 = this.m;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.m = null;
            }
        }
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ViewGroup viewGroup = this.d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.d.getMeasuredHeight() + xi.g(this.a, R.dimen.obfuscated_res_0x7f07035d);
            this.k = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !this.p || this.g.size() == 0) {
            return;
        }
        this.g.clear();
    }

    public final void r() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.q) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.A, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0109, 1);
            this.q = skinType;
        }
    }

    public final JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            if (!ListUtils.isEmpty(this.g)) {
                int i2 = 0;
                while (i < this.g.size()) {
                    r46.b bVar = this.g.get(i);
                    if (bVar != null) {
                        jSONArray.put(String.valueOf(bVar.b));
                        i2 = bVar.a + 1;
                    }
                    i++;
                }
                i = i2;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.B).param("obj_type", i));
            if (this.h) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.B).param("obj_type", i));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.B).param("obj_type", i));
            }
            h hVar = this.u;
            if (hVar != null) {
                hVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.e.g());
                jSONObject.put("type", this.e.a());
                jSONObject.put("forum_id", this.e.c());
                jSONObject.put("is_frs_masks", this.e.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.d = viewGroup;
                TextView textView = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = textView;
                if (this.h) {
                    textView.setText(R.string.shield_reason);
                }
                this.y = (TextView) this.d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.o.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = xi.g(this.a, R.dimen.obfuscated_res_0x7f070225);
                g2.setPadding(g3, 0, g3, 0);
                this.d.addView(g2);
            }
            if (this.s == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.s = linearLayout;
                this.w = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.v = (TextView) this.s.findViewById(R.id.dialog_bottom_certain_button);
                this.z = this.s.findViewById(R.id.top_line);
                this.A = this.s.findViewById(R.id.middle_line);
                this.d.addView(this.s);
                this.w.setOnClickListener(new e(this));
                TextView textView2 = this.v;
                if (textView2 != null) {
                    textView2.setOnClickListener(new f(this));
                }
                r();
            }
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.r = xi.g(this.a, R.dimen.tbds32);
            this.j = xi.l(this.a) - (this.r * 2);
            r46 r46Var = new r46(this.b.getPageActivity());
            this.o = r46Var;
            r46Var.o(this.D);
            this.o.n(true);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.c != null && this.b != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.b.getPageActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            PopupWindow popupWindow = this.c;
            popupWindow.update(displayMetrics.widthPixels - (this.r * 2), popupWindow.getHeight());
        }
    }
}
