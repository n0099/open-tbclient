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
import com.baidu.tieba.m45;
import com.baidu.tieba.xba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class pu7 extends BaseAdapter implements tq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ym> a;
    public Context b;
    public TbPageContext c;
    public String d;
    public String e;
    public UserData f;
    public in g;
    public int h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public rq7 l;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu7 a;

        public a(pu7 pu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.b == null || ViewHelper.checkUpIsLogin(this.a.b)) && view2 != null) {
                    if ((view2.getTag() instanceof faa) || (view2.getTag() instanceof e)) {
                        faa faaVar = null;
                        if (view2.getTag() instanceof faa) {
                            faaVar = (faa) view2.getTag();
                        } else if ((view2.getTag() instanceof e) && (textView = (eVar = (e) view2.getTag()).c) != null && (textView.getTag() instanceof faa)) {
                            faaVar = (faa) eVar.c.getTag();
                        }
                        if (faaVar != null && faaVar.g() == 2) {
                            if (!StringUtils.isNull(faaVar.f())) {
                                String f = faaVar.f();
                                if ((f.contains("nohead:url") || f.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                    BdUtilHelper.showToast(this.a.b, (int) R.string.book_plugin_not_install_tip);
                                    return;
                                }
                                UrlManager.getInstance().dealOneLink(this.a.c, new String[]{f});
                                xba.b b = xba.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", faaVar.b(), this.a.d, this.a.e, null);
                                b.d(TiebaStatic.Params.OBJ_URL, faaVar.f());
                                b.e();
                            }
                        } else if (faaVar != null && faaVar.g() == 3) {
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

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu7 a;

        public b(pu7 pu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu7Var;
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
                ym ymVar = (ym) ListUtils.getItem(this.a.a, eVar.a);
                if (ymVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ymVar;
                    in inVar = this.a.g;
                    BdUniqueId gen = BdUniqueId.gen();
                    if (this.a.k) {
                        i = eVar.a + 1;
                    } else {
                        i = eVar.a;
                    }
                    inVar.b(view2, threadData, gen, null, i, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (ymVar instanceof maa) {
                    this.a.g.b(view2, (maa) ymVar, BdUniqueId.gen(), null, eVar.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ pu7 d;

        public c(pu7 pu7Var, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pu7Var;
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

    /* loaded from: classes7.dex */
    public class d implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;

        public d(pu7 pu7Var, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, m45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;

        public e(pu7 pu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
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

    /* loaded from: classes7.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(pu7 pu7Var) {
            super(pu7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((pu7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView e;
        public TextView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(pu7 pu7Var) {
            super(pu7Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((pu7) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public pu7(Context context) {
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
        this.l = new rq7();
        this.m = new a(this);
        this.n = new b(this);
        this.b = context;
        this.c = p();
    }

    public final String o(faa faaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, faaVar)) == null) {
            if (!TextUtils.isEmpty(faaVar.e()) && faaVar.e().trim().length() != 0) {
                return faaVar.e();
            }
            if (faaVar.a() == 1) {
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

    public void r(List<ym> list) {
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

    public void v(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, inVar) == null) {
            this.g = inVar;
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

    @Override // com.baidu.tieba.tq7
    public rq7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (rq7) invokeV.objValue;
    }

    public List<ym> n() {
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
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d036e, (ViewGroup) null, false);
                    gVar.b = view2;
                    gVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ccb);
                    gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ccc);
                    gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fd);
                    gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fb);
                    view2.setTag(gVar);
                }
                m(gVar, (ym) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    fVar = new f(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d036d, (ViewGroup) null, false);
                    fVar.b = view2;
                    fVar.f = view2.findViewById(R.id.obfuscated_res_0x7f0925fe);
                    fVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fd);
                    fVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fc);
                    fVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925fb);
                    view2.setTag(fVar);
                }
                ym ymVar = (ym) ListUtils.getItem(this.a, i);
                if (ymVar instanceof ThreadData) {
                    j(fVar, (ThreadData) ymVar, i);
                    fVar.a = i;
                } else if (ymVar instanceof faa) {
                    k(fVar, (faa) ymVar);
                } else if (ymVar instanceof laa) {
                    y((laa) ymVar, fVar, i);
                } else if (ymVar instanceof maa) {
                    fVar.a = i;
                    l(fVar, (maa) ymVar, i);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void l(f fVar, maa maaVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048585, this, fVar, maaVar, i) == null) && fVar != null && maaVar != null && maaVar.a() != null && this.f != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            kq7.b(fVar.d, this.h);
            if (this.f.getIs_manager() == 1) {
                if (maaVar.a().audit_status.intValue() == 0 && maaVar.a().has_forum_rule.intValue() == 0) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (maaVar.a().audit_status.intValue() == 0) {
                    fVar.c.setText(maaVar.a().title);
                } else if (maaVar.a().audit_status.intValue() == 1) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (maaVar.a().audit_status.intValue() == 2) {
                    fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                fVar.c.setText(maaVar.a().title);
            }
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void j(f fVar, ThreadData threadData, int i) {
        CharSequence abstractText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048583, this, fVar, threadData, i) == null) && fVar != null && threadData != null) {
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16b4));
            kq7.b(fVar.d, this.h);
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if (ListUtils.isNotEmpty(threadData.getItemStar())) {
                abstractText = threadData.getAbstract();
            } else {
                abstractText = threadData.getAbstractText();
            }
            if ((span_str == null || bi.isEmptyStringAfterTrim(span_str.toString())) && abstractText != null) {
                span_str = new SpannableStringBuilder(abstractText);
                TiePlusEventController.s(threadData.getTiePlusLinkOriginData());
            }
            fVar.c.setOnTouchListener(new opa(span_str));
            fVar.c.setText(span_str);
            fVar.b.setOnClickListener(this.n);
            h(fVar);
        }
    }

    public final void k(f fVar, faa faaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, faaVar) == null) {
            String o = o(faaVar);
            fVar.c.setText(faaVar.d());
            fVar.d.setText(o);
            kq7.b(fVar.d, this.h);
            if (faaVar.c() != 0) {
                fVar.e.setVisibility(0);
                if (faaVar.c() == -1) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e6b));
                } else if (faaVar.c() > 999) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11c0));
                } else {
                    TextView textView = fVar.e;
                    textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11bf) + faaVar.c());
                }
                if (!StringUtils.isNull(faaVar.d())) {
                    fVar.c.setText(faaVar.d());
                }
            } else {
                fVar.e.setVisibility(8);
            }
            h(fVar);
            fVar.c.setTag(faaVar);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet != null && hashSet.add(faaVar.b())) {
                xba.b b2 = xba.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", faaVar.b(), this.d, this.e, null);
                b2.d(TiebaStatic.Params.OBJ_URL, faaVar.f());
                b2.e();
            }
        }
    }

    public final void m(g gVar, ym ymVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, gVar, ymVar) == null) && gVar != null && ymVar != null) {
            if (ymVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) ymVar;
                threadData.parserTitleFrsForTop();
                SpannableStringBuilder span_str = threadData.getSpan_str();
                if ((span_str == null || bi.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                    span_str = new SpannableStringBuilder(threadData.getAbstractText());
                    TiePlusEventController.s(threadData.getTiePlusLinkOriginData());
                }
                gVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f16b4));
                gVar.c.setOnTouchListener(new opa(span_str));
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
            } else if (ymVar instanceof faa) {
                faa faaVar = (faa) ymVar;
                String o = o(faaVar);
                if (StringUtils.isNull(this.i)) {
                    gVar.d.setText(o);
                    gVar.d.setVisibility(0);
                    gVar.c.setText(faaVar.d());
                    gVar.e.setVisibility(8);
                } else {
                    gVar.d.setVisibility(8);
                    gVar.e.setVisibility(0);
                    TextView textView = gVar.c;
                    textView.setText(o + "：" + faaVar.d());
                    gVar.e.startLoad(this.i, 10, false);
                }
                if (faaVar.c() != 0) {
                    gVar.f.setVisibility(0);
                    if (faaVar.c() == -1) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0e6b));
                    } else if (faaVar.c() > 999) {
                        gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11c0));
                    } else {
                        TextView textView2 = gVar.f;
                        textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f11bf) + faaVar.c());
                    }
                    if (!StringUtils.isNull(faaVar.d())) {
                        gVar.c.setText(faaVar.d());
                    }
                } else {
                    gVar.f.setVisibility(8);
                }
                gVar.d.setTextColor(this.h);
                h(gVar);
                gVar.c.setTag(faaVar);
                View.OnClickListener onClickListener = this.m;
                if (onClickListener != null) {
                    gVar.b.setOnClickListener(onClickListener);
                }
                HashSet<String> hashSet = this.j;
                if (hashSet != null && hashSet.add(faaVar.b())) {
                    xba.b b2 = xba.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", faaVar.b(), this.d, this.e, null);
                    b2.d(TiebaStatic.Params.OBJ_URL, faaVar.f());
                    b2.e();
                }
            }
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) && !bi.isEmpty(str) && !bi.isEmpty(str2)) {
            m45 m45Var = new m45((BaseFragmentActivity) this.b);
            m45Var.setTitle(str2);
            m45Var.setTitleShowCenter(true);
            m45Var.setMessage(str);
            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0868, new d(this, m45Var));
            m45Var.create(p()).show();
        }
    }

    public final boolean y(laa laaVar, f fVar, int i) {
        InterceptResult invokeLLI;
        boolean z;
        String riskTipNotice;
        String riskTipPopTitle;
        String riskTipPop;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, laaVar, fVar, i)) == null) {
            if (i != 0 || laaVar == null || laaVar.a() == null) {
                return false;
            }
            ForumData a2 = laaVar.a();
            if (laaVar.b() && !ListUtils.isEmpty(a2.getTipInfos())) {
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
            kq7.b(fVar.d, this.h);
            fVar.c.setText(riskTipNotice);
            fVar.c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
