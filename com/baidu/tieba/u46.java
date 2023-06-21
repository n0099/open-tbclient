package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.m46;
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
public class u46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public t46 B;
    public UserData C;
    public boolean D;
    public boolean E;
    public int F;
    public ClickableSpan G;
    public boolean H;
    public CustomMessageListener I;
    public CompoundButton.OnCheckedChangeListener J;
    public PopupWindow.OnDismissListener K;
    public CustomMessageListener L;
    public Context a;
    public TbPageContext b;
    public h35 c;
    public SparseArray<String> d;
    public List<m46.b> e;
    public int f;
    public int g;
    public int h;
    public NEGFeedBackView.b i;
    public PopupWindow j;
    public View k;
    public m46 l;
    public boolean m;
    public int n;
    public PopupWindow o;
    public ViewGroup p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public LinearLayout v;
    public String w;
    public h x;
    public i y;
    public r95 z;

    /* loaded from: classes8.dex */
    public interface h {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface i {
        void a(JSONArray jSONArray);
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u46 u46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var, Integer.valueOf(i)};
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
            this.a = u46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921745) {
                this.a.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        public b(u46 u46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u46Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.a.i != null) {
                    this.a.i.b(this.a.c, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof m46.b) {
                    m46.b bVar = (m46.b) compoundButton.getTag();
                    if (z) {
                        if (!this.a.e.contains(bVar)) {
                            this.a.e.add(bVar);
                            if (this.a.D && this.a.r != null) {
                                this.a.r.setClickable(true);
                                p75.d(this.a.r).x(R.color.CAM_X0302);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.e.remove(bVar);
                    if (this.a.D && this.a.r != null) {
                        this.a.r.setClickable(false);
                        this.a.r.setTextColor(gy9.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        public c(u46 u46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u46Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                MessageManager.getInstance().unRegisterListener(this.a.L);
                MessageManager.getInstance().unRegisterListener(this.a.I);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(u46 u46Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var, Integer.valueOf(i)};
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
            this.a = u46Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        public e(u46 u46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                if (this.a.o != null) {
                    this.a.o.dismiss();
                    this.a.o = null;
                }
                if (this.a.H) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CANCEL_CLICK).param("obj_source", this.a.w));
                }
                if (this.a.x != null) {
                    this.a.x.onClick();
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.a.w).param("obj_type", "9"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        public f(u46 u46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                JSONObject y = this.a.y();
                if (this.a.w != "3" && this.a.w != "4" && this.a.w != "1") {
                    if (y != null) {
                        this.a.K();
                        CustomMessage customMessage = new CustomMessage(2016489, this.a.b.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, y);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        return;
                    }
                    return;
                }
                this.a.x();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u46 a;

        public g(u46 u46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u46Var;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.a.a, this.a.B.b(), this.a.B.c(), this.a.B.a(), this.a.B.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                if (this.a.j != null) {
                    this.a.j.dismiss();
                    this.a.j = null;
                }
                if (this.a.o != null) {
                    this.a.o.dismiss();
                    this.a.o = null;
                }
            }
        }
    }

    public u46(TbPageContext tbPageContext, View view2, t46 t46Var, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, t46Var, userData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = new ArrayList();
        this.i = null;
        this.o = null;
        this.z = null;
        this.A = 3;
        this.D = true;
        this.E = false;
        this.I = new a(this, 2921745);
        this.J = new b(this);
        this.K = new c(this);
        this.L = new d(this, 2001304);
        this.a = tbPageContext.getPageActivity();
        this.b = tbPageContext;
        this.k = view2;
        this.B = t46Var;
        this.C = userData;
        C();
        B();
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.H = z;
        }
    }

    public void H(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, strArr) == null) {
            this.l.k(strArr);
        }
    }

    public void I(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
            this.y = iVar;
        }
    }

    public final int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.p.getMeasuredHeight();
            this.h = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !this.m || this.e.size() == 0) {
            return;
        }
        this.e.clear();
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.z == null) {
                this.z = new r95(this.b);
            }
            this.z.i(R.string.obfuscated_res_0x7f0f0bd2);
            this.z.h(true);
        }
    }

    public void w() {
        r95 r95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (r95Var = this.z) != null) {
            r95Var.h(false);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            PopupWindow popupWindow = this.o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.o = null;
            }
            PopupWindow popupWindow2 = this.j;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.j = null;
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n = wi.g(this.a, R.dimen.M_W_X009);
            this.g = wi.l(this.a) - (this.n * 2);
            m46 m46Var = new m46(this.b.getPageActivity());
            this.l = m46Var;
            m46Var.o(this.J);
            this.l.n(true);
            if (this.E) {
                this.l.l(5);
            }
        }
    }

    public final void C() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            t46 t46Var = this.B;
            if (t46Var != null) {
                if (t46Var.e() == 1) {
                    this.D = false;
                } else {
                    this.D = true;
                }
                if (this.B.d() == 1) {
                    this.E = false;
                } else {
                    this.E = true;
                }
            }
            if (this.E && (userData = this.C) != null) {
                this.F = userData.getIs_manager();
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.o != null && this.b != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.b.getPageActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            PopupWindow popupWindow = this.o;
            popupWindow.update(displayMetrics.widthPixels - (this.n * 2), popupWindow.getHeight());
        }
    }

    public void G(h35 h35Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, h35Var) != null) || h35Var == null) {
            return;
        }
        this.c = h35Var;
        SparseArray<String> b2 = h35Var.b();
        this.d = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.d.size() - 1; size >= 8; size--) {
                this.d.removeAt(size);
            }
        }
        this.l.j(h35Var);
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || this.a == null) {
            return;
        }
        this.w = str;
        View z = z();
        if (z != null && z.getParent() != null) {
            ((ViewGroup) z.getParent()).removeView(z);
        }
        if (z == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(wi.g(this.a, R.dimen.tbds31));
        z.setBackgroundDrawable(gradientDrawable);
        v();
        this.f = A();
        PopupWindow popupWindow = new PopupWindow(z, this.g, this.f);
        this.o = popupWindow;
        GreyUtil.grey(popupWindow);
        this.o.setFocusable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(this.K);
        E();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.j = popupWindow2;
        GreyUtil.grey(popupWindow2);
        if (Build.VERSION.SDK_INT >= 22) {
            this.j.setAttachedInDecor(false);
        }
        this.j.showAtLocation(this.k, 0, 0, 0);
        this.o.showAtLocation(this.k, 17, 0, 0);
        NEGFeedBackView.b bVar = this.i;
        if (bVar != null) {
            bVar.c(this.c);
        }
        this.m = true;
        MessageManager.getInstance().registerListener(this.I);
        MessageManager.getInstance().registerListener(this.L);
    }

    public final void v() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (skinType = TbadkCoreApplication.getInst().getSkinType()) != this.A) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0105);
            if (this.D) {
                this.r.setTextColor(gy9.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                this.r.setClickable(false);
            } else {
                p75.d(this.r).x(R.color.CAM_X0302);
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
            gradientDrawable.setCornerRadius(wi.g(this.a, R.dimen.tbds31));
            this.p.setBackgroundDrawable(gradientDrawable);
            this.A = skinType;
        }
    }

    public final JSONObject y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.c == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.e)) {
                int i3 = 0;
                while (i2 < this.e.size()) {
                    m46.b bVar = this.e.get(i2);
                    if (bVar != null) {
                        jSONArray.put(String.valueOf(bVar.b));
                        i3 = bVar.a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.w).param("obj_type", i2));
            if (this.H) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_REASON_CLICK).param("obj_source", this.w).param("obj_type", i2));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_CONFIRM_CLICK).param("obj_source", this.w).param("obj_type", i2));
            }
            i iVar = this.y;
            if (iVar != null) {
                iVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.c.g());
                jSONObject.put("type", this.c.a());
                jSONObject.put("forum_id", this.c.c());
                jSONObject.put("is_frs_masks", this.c.d());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Context context = this.a;
            if (context == null) {
                return null;
            }
            if (this.p == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ueg_new_delete_thread_view, (ViewGroup) null);
                this.p = viewGroup;
                EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.ueg_new_delete_thread_title_view);
                this.s = eMTextView;
                if (this.H) {
                    eMTextView.setText(R.string.shield_reason);
                } else {
                    eMTextView.setText(R.string.delete_reason);
                }
                p75 d2 = p75.d(this.s);
                d2.D(R.string.F_X02);
                d2.x(R.color.CAM_X0105);
                EMTextView eMTextView2 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_describe_view);
                this.t = eMTextView2;
                p75.d(eMTextView2).C(R.dimen.T_X08);
                EMTextView eMTextView3 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_cancel_view);
                this.q = eMTextView3;
                eMTextView3.setOnClickListener(new e(this));
                EMTextView eMTextView4 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_certain_view);
                this.r = eMTextView4;
                if (this.H) {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f1394);
                } else {
                    eMTextView4.setText(R.string.obfuscated_res_0x7f0f04bc);
                }
                this.r.setOnClickListener(new f(this));
            }
            this.v = (LinearLayout) this.p.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
            View g2 = this.l.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = wi.g(this.a, R.dimen.M_W_X009);
                g2.setPadding(g3, 0, g3, 0);
                this.v.addView(g2);
            }
            EMTextView eMTextView5 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_tip_view);
            this.u = eMTextView5;
            eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
            if (this.E) {
                this.u.setVisibility(0);
                if (1 == this.F) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.a.getString(R.string.set_forum_rule_tip_manager));
                    g gVar = new g(this);
                    this.G = gVar;
                    spannableStringBuilder.setSpan(gVar, 13, 17, 18);
                    this.u.setText(spannableStringBuilder);
                    this.u.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    this.u.setText(this.a.getString(R.string.set_forum_rule_tip_assist));
                }
            } else {
                this.u.setVisibility(8);
            }
            this.u.setClickable(false);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            v();
            return this.p;
        }
        return (View) invokeV.objValue;
    }
}
