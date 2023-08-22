package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.fga;
import com.baidu.tieba.s45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class kw7 extends BaseAdapter implements os7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<bn> a;
    public Context b;
    public TbPageContext c;
    public String d;
    public String e;
    public UserData f;
    public ln g;
    public int h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public ms7 l;
    public final View.OnClickListener m;
    public View.OnClickListener n;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 2;
        }
        return invokeI.intValue;
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
        }
    }

    public void t(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumData) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw7 a;

        public a(kw7 kw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.b == null || ViewHelper.checkUpIsLogin(this.a.b)) && view2 != null) {
                    if ((view2.getTag() instanceof nea) || (view2.getTag() instanceof e)) {
                        nea neaVar = null;
                        if (view2.getTag() instanceof nea) {
                            neaVar = (nea) view2.getTag();
                        } else if ((view2.getTag() instanceof e) && (textView = (eVar = (e) view2.getTag()).c) != null && (textView.getTag() instanceof nea)) {
                            neaVar = (nea) eVar.c.getTag();
                        }
                        if (neaVar != null && neaVar.g() == 2) {
                            if (!StringUtils.isNull(neaVar.f())) {
                                String f = neaVar.f();
                                if ((f.contains("nohead:url") || f.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                    BdUtilHelper.showToast(this.a.b, (int) R.string.book_plugin_not_install_tip);
                                    return;
                                }
                                UrlManager.getInstance().dealOneLink(this.a.c, new String[]{f});
                                fga.b b = fga.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", neaVar.b(), this.a.d, this.a.e, null);
                                b.d(TiebaStatic.Params.OBJ_URL, neaVar.f());
                                b.e();
                            }
                        } else if (neaVar != null && neaVar.g() == 3) {
                            new StatisticItem("c13442").param("forum_id", this.a.d).eventStat();
                            if (this.a.c != null && !TextUtils.isEmpty(this.a.d)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.c.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.a.d, 0L), 1)));
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kw7 a;

        public b(kw7 kw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setPressed(false);
                if (this.a.g == null || !(view2.getTag() instanceof e) || (eVar = (e) view2.getTag()) == null) {
                    return;
                }
                bn bnVar = (bn) ListUtils.getItem(this.a.a, eVar.a);
                if (bnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) bnVar;
                    ln lnVar = this.a.g;
                    BdUniqueId gen = BdUniqueId.gen();
                    if (this.a.k) {
                        i = eVar.a + 1;
                    } else {
                        i = eVar.a;
                    }
                    lnVar.b(view2, threadData, gen, null, i, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (bnVar instanceof uea) {
                    this.a.g.b(view2, (uea) bnVar, BdUniqueId.gen(), null, eVar.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ kw7 d;

        public c(kw7 kw7Var, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kw7Var;
            this.a = fVar;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.c.getLayout().getEllipsisCount(this.a.c.getLineCount() - 1) <= 0) {
                return;
            }
            this.d.x(this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s45 a;

        public d(kw7 kw7Var, s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var, s45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s45Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;

        public e(kw7 kw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(kw7 kw7Var) {
            super(kw7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((kw7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView e;
        public TextView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(kw7 kw7Var) {
            super(kw7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((kw7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public kw7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.e = "";
        this.h = SkinManager.getColor(R.color.CAM_X0302);
        this.i = "";
        this.j = new HashSet<>();
        this.l = new ms7();
        this.m = new a(this);
        this.n = new b(this);
        this.b = context;
        this.c = p();
    }

    public final String o(nea neaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, neaVar)) == null) {
            if (!TextUtils.isEmpty(neaVar.e()) && neaVar.e().trim().length() != 0) {
                return neaVar.e();
            }
            if (neaVar.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return (String) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return ListUtils.getItem(this.a, i);
        }
        return invokeI.objValue;
    }

    public final void h(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, eVar) != null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.c, (int) R.color.CAM_X0105);
    }

    public void r(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.i = str;
        }
    }

    public void v(ln lnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, lnVar) == null) {
            this.g = lnVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.h = i;
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.d = str;
            this.e = str2;
            this.f = userData;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.os7
    public ms7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (ms7) invokeV.objValue;
    }

    public List<bn> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.b;
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 1) {
                if (view2 != null && (view2.getTag() instanceof g)) {
                    gVar = (g) view2.getTag();
                } else {
                    gVar = new g(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0373, (ViewGroup) null, false);
                    gVar.b = view2;
                    gVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090cd8);
                    gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090cd9);
                    gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09262c);
                    gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09262a);
                    view2.setTag(gVar);
                }
                m(gVar, (bn) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    fVar = new f(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0372, (ViewGroup) null, false);
                    fVar.b = view2;
                    fVar.f = view2.findViewById(R.id.obfuscated_res_0x7f09262d);
                    fVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09262c);
                    fVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09262b);
                    fVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09262a);
                    view2.setTag(fVar);
                }
                bn bnVar = (bn) ListUtils.getItem(this.a, i);
                if (bnVar instanceof ThreadData) {
                    j(fVar, (ThreadData) bnVar, i);
                    fVar.a = i;
                } else if (bnVar instanceof nea) {
                    k(fVar, (nea) bnVar);
                } else if (bnVar instanceof tea) {
                    y((tea) bnVar, fVar, i);
                } else if (bnVar instanceof uea) {
                    fVar.a = i;
                    l(fVar, (uea) bnVar, i);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void l(f fVar, uea ueaVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048585, this, fVar, ueaVar, i) == null) && fVar != null && ueaVar != null && ueaVar.a() != null && this.f != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            fs7.b(fVar.d, this.h);
            if (this.f.getIs_manager() == 1) {
                if (ueaVar.a().audit_status.intValue() == 0 && ueaVar.a().has_forum_rule.intValue() == 0) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (ueaVar.a().audit_status.intValue() == 0) {
                    fVar.c.setText(ueaVar.a().title);
                } else if (ueaVar.a().audit_status.intValue() == 1) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (ueaVar.a().audit_status.intValue() == 2) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                fVar.c.setText(ueaVar.a().title);
            }
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void j(f fVar, ThreadData threadData, int i) {
        CharSequence abstractText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048583, this, fVar, threadData, i) == null) && fVar != null && threadData != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16c2));
            fs7.b(fVar.d, this.h);
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if (ListUtils.isNotEmpty(threadData.getItemStar())) {
                abstractText = threadData.getAbstract();
            } else {
                abstractText = threadData.getAbstractText();
            }
            if ((span_str == null || di.isEmptyStringAfterTrim(span_str.toString())) && abstractText != null) {
                span_str = new SpannableStringBuilder(abstractText);
                TiePlusEventController.s(threadData.getTiePlusLinkOriginData());
            }
            fVar.c.setOnTouchListener(new xta(span_str));
            fVar.c.setText(span_str);
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void k(f fVar, nea neaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, neaVar) == null) {
            String o = o(neaVar);
            fVar.c.setText(neaVar.d());
            fVar.d.setText(o);
            fs7.b(fVar.d, this.h);
            if (neaVar.c() != 0) {
                fVar.e.setVisibility(0);
                if (neaVar.c() == -1) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e73));
                } else if (neaVar.c() > 999) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11cb));
                } else {
                    TextView textView = fVar.e;
                    textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11ca) + neaVar.c());
                }
                if (!StringUtils.isNull(neaVar.d())) {
                    fVar.c.setText(neaVar.d());
                }
            } else {
                fVar.e.setVisibility(8);
            }
            h(fVar);
            fVar.c.setTag(neaVar);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet != null && hashSet.add(neaVar.b())) {
                fga.b b2 = fga.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", neaVar.b(), this.d, this.e, null);
                b2.d(TiebaStatic.Params.OBJ_URL, neaVar.f());
                b2.e();
            }
        }
    }

    public final void m(g gVar, bn bnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, gVar, bnVar) == null) && gVar != null && bnVar != null) {
            if (bnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) bnVar;
                threadData.parserTitleFrsForTop();
                SpannableStringBuilder span_str = threadData.getSpan_str();
                if ((span_str == null || di.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                    span_str = new SpannableStringBuilder(threadData.getAbstractText());
                    TiePlusEventController.s(threadData.getTiePlusLinkOriginData());
                }
                gVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16c2));
                gVar.c.setOnTouchListener(new xta(span_str));
                gVar.c.setText(span_str);
                if (StringUtils.isNull(this.i)) {
                    gVar.e.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                    layoutParams.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    gVar.e.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                    layoutParams2.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    gVar.e.startLoad(this.i, 10, false);
                }
                gVar.d.setTextColor(this.h);
                gVar.b.setOnClickListener(this.n);
                h(gVar);
            } else if (bnVar instanceof nea) {
                nea neaVar = (nea) bnVar;
                String o = o(neaVar);
                if (StringUtils.isNull(this.i)) {
                    gVar.d.setText(o);
                    gVar.d.setVisibility(0);
                    gVar.c.setText(neaVar.d());
                    gVar.e.setVisibility(8);
                } else {
                    gVar.d.setVisibility(8);
                    gVar.e.setVisibility(0);
                    TextView textView = gVar.c;
                    textView.setText(o + "：" + neaVar.d());
                    gVar.e.startLoad(this.i, 10, false);
                }
                if (neaVar.c() != 0) {
                    gVar.f.setVisibility(0);
                    if (neaVar.c() == -1) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e73));
                    } else if (neaVar.c() > 999) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11cb));
                    } else {
                        TextView textView2 = gVar.f;
                        textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11ca) + neaVar.c());
                    }
                    if (!StringUtils.isNull(neaVar.d())) {
                        gVar.c.setText(neaVar.d());
                    }
                } else {
                    gVar.f.setVisibility(8);
                }
                gVar.d.setTextColor(this.h);
                h(gVar);
                gVar.c.setTag(neaVar);
                View.OnClickListener onClickListener = this.m;
                if (onClickListener != null) {
                    gVar.b.setOnClickListener(onClickListener);
                }
                HashSet<String> hashSet = this.j;
                if (hashSet != null && hashSet.add(neaVar.b())) {
                    fga.b b2 = fga.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", neaVar.b(), this.d, this.e, null);
                    b2.d(TiebaStatic.Params.OBJ_URL, neaVar.f());
                    b2.e();
                }
            }
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) && !di.isEmpty(str) && !di.isEmpty(str2)) {
            s45 s45Var = new s45((BaseFragmentActivity) this.b);
            s45Var.setTitle(str2);
            s45Var.setTitleShowCenter(true);
            s45Var.setMessage(str);
            s45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0870, new d(this, s45Var));
            s45Var.create(p()).show();
        }
    }

    public final boolean y(tea teaVar, f fVar, int i) {
        InterceptResult invokeLLI;
        boolean z;
        String riskTipNotice;
        String riskTipPopTitle;
        String riskTipPop;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, teaVar, fVar, i)) == null) {
            if (i != 0 || teaVar == null || teaVar.a() == null) {
                return false;
            }
            ForumData a2 = teaVar.a();
            if (teaVar.b() && !ListUtils.isEmpty(a2.getTipInfos())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                riskTipNotice = a2.getTipInfos().get(0).tip_notice;
            } else {
                riskTipNotice = a2.getRiskTipNotice();
            }
            if (z) {
                riskTipPopTitle = a2.getTipInfos().get(0).tip_pop_title;
            } else {
                riskTipPopTitle = a2.getRiskTipPopTitle();
            }
            if (z) {
                riskTipPop = a2.getTipInfos().get(0).tip_pop;
            } else {
                riskTipPop = a2.getRiskTipPop();
            }
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
            fs7.b(fVar.d, this.h);
            fVar.c.setText(riskTipNotice);
            fVar.c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
