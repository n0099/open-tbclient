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
import com.baidu.tieba.fp8;
import com.baidu.tieba.iv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class yv6 extends BaseAdapter implements st6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wn> a;
    public Context b;
    public TbPageContext c;
    public String d;
    public String e;
    public UserData f;
    public go g;
    public int h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public qt6 l;
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
        public final /* synthetic */ yv6 a;

        public a(yv6 yv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.b == null || ViewHelper.checkUpIsLogin(this.a.b)) && view2 != null) {
                    if ((view2.getTag() instanceof mn8) || (view2.getTag() instanceof e)) {
                        mn8 mn8Var = null;
                        if (view2.getTag() instanceof mn8) {
                            mn8Var = (mn8) view2.getTag();
                        } else if ((view2.getTag() instanceof e) && (textView = (eVar = (e) view2.getTag()).c) != null && (textView.getTag() instanceof mn8)) {
                            mn8Var = (mn8) eVar.c.getTag();
                        }
                        if (mn8Var != null && mn8Var.j() == 2) {
                            if (!StringUtils.isNull(mn8Var.h())) {
                                String h = mn8Var.h();
                                if ((h.contains("nohead:url") || h.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                    xi.O(this.a.b, R.string.obfuscated_res_0x7f0f032e);
                                    return;
                                }
                                UrlManager.getInstance().dealOneLink(this.a.c, new String[]{h});
                                fp8.b b = fp8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", mn8Var.b(), this.a.d, this.a.e, null);
                                b.d(TiebaStatic.Params.OBJ_URL, mn8Var.h());
                                b.e();
                            }
                        } else if (mn8Var != null && mn8Var.j() == 3) {
                            new StatisticItem("c13442").param("forum_id", this.a.d).eventStat();
                            if (this.a.c != null && !TextUtils.isEmpty(this.a.d)) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.c.getPageActivity()).createNormalConfig(wg.g(this.a.d, 0L), 1)));
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
        public final /* synthetic */ yv6 a;

        public b(yv6 yv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yv6Var;
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
                wn wnVar = (wn) ListUtils.getItem(this.a.a, eVar.a);
                if (wnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) wnVar;
                    go goVar = this.a.g;
                    BdUniqueId gen = BdUniqueId.gen();
                    if (this.a.k) {
                        i = eVar.a + 1;
                    } else {
                        i = eVar.a;
                    }
                    goVar.b(view2, threadData, gen, null, i, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (wnVar instanceof tn8) {
                    this.a.g.b(view2, (tn8) wnVar, BdUniqueId.gen(), null, eVar.a, 0L);
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
        public final /* synthetic */ yv6 d;

        public c(yv6 yv6Var, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yv6Var;
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
    public class d implements iv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iv4 a;

        public d(yv6 yv6Var, iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var, iv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iv4Var;
        }

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
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

        public e(yv6 yv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var};
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
        public f(yv6 yv6Var) {
            super(yv6Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((yv6) newInitContext.callArgs[0]);
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
        public g(yv6 yv6Var) {
            super(yv6Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((yv6) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public yv6(Context context) {
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
        this.l = new qt6();
        this.m = new a(this);
        this.n = new b(this);
        this.b = context;
        this.c = p();
    }

    public final String o(mn8 mn8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, mn8Var)) == null) {
            if (!TextUtils.isEmpty(mn8Var.g()) && mn8Var.g().trim().length() != 0) {
                return mn8Var.g();
            }
            if (mn8Var.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1424);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1490);
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

    public void r(List<wn> list) {
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

    public void v(go goVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, goVar) == null) {
            this.g = goVar;
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

    @Override // com.baidu.tieba.st6
    public qt6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (qt6) invokeV.objValue;
    }

    public List<wn> n() {
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
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0320, (ViewGroup) null, false);
                    gVar.b = view2;
                    gVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b75);
                    gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b76);
                    gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e6);
                    gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e4);
                    view2.setTag(gVar);
                }
                m(gVar, (wn) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    fVar = new f(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d031f, (ViewGroup) null, false);
                    fVar.b = view2;
                    fVar.f = view2.findViewById(R.id.obfuscated_res_0x7f0922e7);
                    fVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e6);
                    fVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e5);
                    fVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922e4);
                    view2.setTag(fVar);
                }
                wn wnVar = (wn) ListUtils.getItem(this.a, i);
                if (wnVar instanceof ThreadData) {
                    j(fVar, (ThreadData) wnVar, i);
                    fVar.a = i;
                } else if (wnVar instanceof mn8) {
                    k(fVar, (mn8) wnVar);
                } else if (wnVar instanceof sn8) {
                    y((sn8) wnVar, fVar, i);
                } else if (wnVar instanceof tn8) {
                    fVar.a = i;
                    l(fVar, (tn8) wnVar, i);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void l(f fVar, tn8 tn8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048585, this, fVar, tn8Var, i) == null) && fVar != null && tn8Var != null && tn8Var.a() != null && this.f != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f077c));
            jt6.b(fVar.d, this.h);
            if (this.f.getIs_manager() == 1) {
                if (tn8Var.a().audit_status.intValue() == 0 && tn8Var.a().has_forum_rule.intValue() == 0) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f077f));
                } else if (tn8Var.a().audit_status.intValue() == 0) {
                    fVar.c.setText(tn8Var.a().title);
                } else if (tn8Var.a().audit_status.intValue() == 1) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f077d));
                } else if (tn8Var.a().audit_status.intValue() == 2) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0780));
                }
            } else {
                fVar.c.setText(tn8Var.a().title);
            }
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void j(f fVar, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048583, this, fVar, threadData, i) == null) && fVar != null && threadData != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f148f));
            jt6.b(fVar.d, this.h);
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if ((span_str == null || wi.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                span_str = new SpannableStringBuilder(threadData.getAbstractText());
                TiePlusEventController.o(threadData.getTiePlusLinkOriginData());
            }
            fVar.c.setOnTouchListener(new y09(span_str));
            fVar.c.setText(span_str);
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void k(f fVar, mn8 mn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, mn8Var) == null) {
            String o = o(mn8Var);
            fVar.c.setText(mn8Var.f());
            fVar.d.setText(o);
            jt6.b(fVar.d, this.h);
            if (mn8Var.c() != 0) {
                fVar.e.setVisibility(0);
                if (mn8Var.c() == -1) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0cc3));
                } else if (mn8Var.c() > 999) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0fc7));
                } else {
                    TextView textView = fVar.e;
                    textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0fc6) + mn8Var.c());
                }
                if (!StringUtils.isNull(mn8Var.f())) {
                    fVar.c.setText(mn8Var.f());
                }
            } else {
                fVar.e.setVisibility(8);
            }
            h(fVar);
            fVar.c.setTag(mn8Var);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet != null && hashSet.add(mn8Var.b())) {
                fp8.b b2 = fp8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", mn8Var.b(), this.d, this.e, null);
                b2.d(TiebaStatic.Params.OBJ_URL, mn8Var.h());
                b2.e();
            }
        }
    }

    public final void m(g gVar, wn wnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, gVar, wnVar) == null) && gVar != null && wnVar != null) {
            if (wnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) wnVar;
                threadData.parserTitleFrsForTop();
                SpannableStringBuilder span_str = threadData.getSpan_str();
                if ((span_str == null || wi.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                    span_str = new SpannableStringBuilder(threadData.getAbstractText());
                    TiePlusEventController.o(threadData.getTiePlusLinkOriginData());
                }
                gVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f148f));
                gVar.c.setOnTouchListener(new y09(span_str));
                gVar.c.setText(span_str);
                if (StringUtils.isNull(this.i)) {
                    gVar.e.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                    layoutParams.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    gVar.e.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                    layoutParams2.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    gVar.e.K(this.i, 10, false);
                }
                gVar.d.setTextColor(this.h);
                gVar.b.setOnClickListener(this.n);
                h(gVar);
            } else if (wnVar instanceof mn8) {
                mn8 mn8Var = (mn8) wnVar;
                String o = o(mn8Var);
                if (StringUtils.isNull(this.i)) {
                    gVar.d.setText(o);
                    gVar.d.setVisibility(0);
                    gVar.c.setText(mn8Var.f());
                    gVar.e.setVisibility(8);
                } else {
                    gVar.d.setVisibility(8);
                    gVar.e.setVisibility(0);
                    TextView textView = gVar.c;
                    textView.setText(o + "：" + mn8Var.f());
                    gVar.e.K(this.i, 10, false);
                }
                if (mn8Var.c() != 0) {
                    gVar.f.setVisibility(0);
                    if (mn8Var.c() == -1) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0cc3));
                    } else if (mn8Var.c() > 999) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0fc7));
                    } else {
                        TextView textView2 = gVar.f;
                        textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0fc6) + mn8Var.c());
                    }
                    if (!StringUtils.isNull(mn8Var.f())) {
                        gVar.c.setText(mn8Var.f());
                    }
                } else {
                    gVar.f.setVisibility(8);
                }
                gVar.d.setTextColor(this.h);
                h(gVar);
                gVar.c.setTag(mn8Var);
                View.OnClickListener onClickListener = this.m;
                if (onClickListener != null) {
                    gVar.b.setOnClickListener(onClickListener);
                }
                HashSet<String> hashSet = this.j;
                if (hashSet != null && hashSet.add(mn8Var.b())) {
                    fp8.b b2 = fp8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", mn8Var.b(), this.d, this.e, null);
                    b2.d(TiebaStatic.Params.OBJ_URL, mn8Var.h());
                    b2.e();
                }
            }
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) && !wi.isEmpty(str) && !wi.isEmpty(str2)) {
            iv4 iv4Var = new iv4((BaseFragmentActivity) this.b);
            iv4Var.setTitle(str2);
            iv4Var.setTitleShowCenter(true);
            iv4Var.setMessage(str);
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f076b, new d(this, iv4Var));
            iv4Var.create(p()).show();
        }
    }

    public final boolean y(sn8 sn8Var, f fVar, int i) {
        InterceptResult invokeLLI;
        boolean z;
        String riskTipNotice;
        String riskTipPopTitle;
        String riskTipPop;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, sn8Var, fVar, i)) == null) {
            if (i != 0 || sn8Var == null || sn8Var.a() == null) {
                return false;
            }
            ForumData a2 = sn8Var.a();
            if (sn8Var.b() && !ListUtils.isEmpty(a2.getTipInfos())) {
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
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f105e));
            jt6.b(fVar.d, this.h);
            fVar.c.setText(riskTipNotice);
            fVar.c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
