package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarFolderFirstDirActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.l8a;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class k8a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;
    public Activity b;
    public l8a c;
    public ArrayList<t35> d;
    public ArrayList<l8a.b> e;
    public ArrayList<l8a.a> f;
    public o8a g;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 5;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k8a a;

        public a(k8a k8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k8aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.a.a.getPageActivity(), "square_bottom_find_more", "click", 1, new Object[0]);
                this.a.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a.b a;
        public final /* synthetic */ k8a b;

        public b(k8a k8aVar, l8a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k8aVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.b.b, "square_category_more", "click", 1, "loc", Integer.valueOf(this.a.m));
                UrlManager.getInstance().dealOneLink(this.b.a, new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a.b a;
        public final /* synthetic */ k8a b;

        public c(k8a k8aVar, l8a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k8aVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.b.b, "square_module_menu", "click", 1, "loc", Integer.valueOf(this.a.n));
                UrlManager.getInstance().dealOneLink(this.b.a, new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a.b a;
        public final /* synthetic */ k8a b;

        public d(k8a k8aVar, l8a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k8aVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.b.b, "square_module_entry", "click", 1, "moduleloc", Integer.valueOf(this.a.m), "loc", Integer.valueOf(this.a.n));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.a.getPageActivity()).createNormalCfg(this.a.e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        public e(k8a k8aVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a.b a;
        public final /* synthetic */ k8a b;

        public f(k8a k8aVar, l8a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k8aVar;
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.b.b, "square_module_content", "click", 1, "moduleloc", Integer.valueOf(this.a.m), "loc", Integer.valueOf(this.a.n));
                if (TbadkCoreApplication.getInst().isRegistedIntent(ForumDetailActivityConfig.class)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.b.a.getPageActivity();
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, this.a.d + "", ForumDetailActivityConfig.FromType.BAR_SQUARE)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.a.getPageActivity()).createNormalCfg(this.a.e, FrsActivityConfig.FRS_FROM_SQUARE)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a.a a;
        public final /* synthetic */ k8a b;

        public g(k8a k8aVar, l8a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k8aVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k8aVar;
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.d) {
                    this.b.g();
                } else {
                    UrlManager.getInstance().dealOneLink(this.b.a, new String[]{this.a.b});
                }
                if (view2.getTag() instanceof Integer) {
                    int intValue = ((Integer) view2.getTag()).intValue();
                    Activity activity = this.b.b;
                    TiebaStatic.eventStat(activity, "square_entry_content", "click", 1, "loc", "" + intValue);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public TextView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
        public RelativeLayout i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    public k8a(TbPageContext<Object> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        if (tbPageContext != null && tbPageContext.getOrignalPage() != null) {
            this.a = tbPageContext;
            this.b = tbPageContext.getPageActivity();
            o8a o8aVar = new o8a(tbPageContext);
            this.g = o8aVar;
            CoverFlowView<m8a> d2 = o8aVar.d();
            if (tbPageContext.getOrignalPage() instanceof SquareActivity) {
                d2.setSwipeControlInterface((SquareActivity) tbPageContext.getOrignalPage());
            }
            d2.setDisableParentEvent(false);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != -1 && itemViewType != 4) {
                if (itemViewType == 0) {
                    return this.d;
                }
                int i2 = 1;
                if (itemViewType == 1) {
                    return this.f;
                }
                if (itemViewType != 2 && itemViewType != 3) {
                    return null;
                }
                ArrayList<t35> arrayList = this.d;
                i2 = (arrayList == null || arrayList.size() == 0) ? 0 : 0;
                ArrayList<l8a.a> arrayList2 = this.f;
                if (arrayList2 != null && arrayList2.size() != 0) {
                    i2++;
                }
                int i3 = i - i2;
                if (i3 >= 0 && i3 < this.e.size()) {
                    return this.e.get(i3);
                }
            }
            return null;
        }
        return invokeI.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            o8a o8aVar = this.g;
            if (o8aVar != null) {
                o8aVar.e(i);
            }
            notifyDataSetChanged();
        }
    }

    public void i(l8a l8aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, l8aVar) != null) || l8aVar == null) {
            return;
        }
        this.c = l8aVar;
        this.d = l8aVar.e();
        this.e = this.c.b();
        this.f = this.c.a();
        this.g.f(this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13 */
    public final View d(int i, ViewGroup viewGroup, int i2) {
        InterceptResult invokeCommon;
        View inflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), viewGroup, Integer.valueOf(i2)})) == null) {
            if (i2 == 1) {
                return LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08eb, (ViewGroup) null);
            }
            if (i2 == 2) {
                inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08ed, (ViewGroup) null);
                h hVar = new h(null);
                hVar.i = (RelativeLayout) inflate.findViewById(R.id.title_layout);
                hVar.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09258d);
                hVar.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091798);
                inflate.setTag(hVar);
            } else if (i2 == 3) {
                inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08e4, (ViewGroup) null);
                h hVar2 = new h(null);
                hVar2.b = (TextView) inflate.findViewById(R.id.forum_name);
                hVar2.a = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090be0);
                hVar2.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090bfe);
                hVar2.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090be4);
                hVar2.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091513);
                hVar2.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924fb);
                hVar2.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090658);
                hVar2.h = inflate.findViewById(R.id.obfuscated_res_0x7f09287d);
                hVar2.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090a18);
                hVar2.l = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090a1b);
                inflate.setTag(hVar2);
            } else if (i2 != 4) {
                return null;
            } else {
                View inflate2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08ec, (ViewGroup) null);
                inflate2.setOnClickListener(new a(this));
                return inflate2;
            }
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || view2 == null) {
            return;
        }
        ArrayList<l8a.a> arrayList = this.f;
        if (arrayList != null && arrayList.size() != 0) {
            view2.setVisibility(0);
            int size = this.f.size();
            if (size > 4) {
                size = 4;
            }
            View[] viewArr = {view2.findViewById(R.id.obfuscated_res_0x7f0909fb), view2.findViewById(R.id.obfuscated_res_0x7f0909fc), view2.findViewById(R.id.obfuscated_res_0x7f0909fd), view2.findViewById(R.id.obfuscated_res_0x7f0909fe), view2.findViewById(R.id.obfuscated_res_0x7f0909ff)};
            View[] viewArr2 = {view2.findViewById(R.id.obfuscated_res_0x7f090a3c), view2.findViewById(R.id.obfuscated_res_0x7f090a3d), view2.findViewById(R.id.obfuscated_res_0x7f090a3e), view2.findViewById(R.id.obfuscated_res_0x7f090a3f)};
            for (int i = 0; i < 4; i++) {
                if (i < size) {
                    l8a.a aVar = this.f.get(i);
                    if (aVar == null) {
                        viewArr2[i].setVisibility(8);
                    } else {
                        if (viewArr2[i] instanceof LinearLayout) {
                            LinearLayout linearLayout = (LinearLayout) viewArr2[i];
                            linearLayout.setTag(Integer.valueOf(i));
                            View childAt = linearLayout.getChildAt(0);
                            if (childAt instanceof TbImageView) {
                                TbImageView tbImageView = (TbImageView) childAt;
                                tbImageView.setTag(Integer.valueOf(i));
                                tbImageView.setDrawerType(1);
                                tbImageView.setIsRound(true);
                                tbImageView.startLoad(aVar.c, 10, false);
                            }
                            View childAt2 = linearLayout.getChildAt(1);
                            if (childAt2 instanceof TextView) {
                                ((TextView) childAt2).setText(UtilHelper.getFixedText(aVar.a, 5, false));
                            }
                            linearLayout.setOnClickListener(new g(this, aVar));
                        }
                        viewArr2[i].setVisibility(0);
                        viewArr[i].setVisibility(0);
                    }
                } else {
                    viewArr2[i].setVisibility(8);
                    viewArr[i].setVisibility(8);
                }
            }
            return;
        }
        view2.setVisibility(8);
    }

    public final void f(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) != null) || view2 == null) {
            return;
        }
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            e(view2);
        } else if (itemViewType == 2) {
            Object item = getItem(i);
            if (!(item instanceof l8a.b)) {
                return;
            }
            l8a.b bVar = (l8a.b) item;
            h hVar = (h) view2.getTag();
            if (bVar.m == 0) {
                hVar.i.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f0), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070359));
            } else {
                hVar.i.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070400), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5), this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070359));
            }
            hVar.j.setText(bVar.b);
            if (bVar.c) {
                hVar.k.setVisibility(8);
                return;
            }
            hVar.k.setVisibility(0);
            hVar.k.setOnClickListener(new b(this, bVar));
        } else if (itemViewType == 3) {
            Object item2 = getItem(i);
            if (!(item2 instanceof l8a.b)) {
                return;
            }
            l8a.b bVar2 = (l8a.b) item2;
            h hVar2 = (h) view2.getTag();
            if (hVar2 == null) {
                return;
            }
            hVar2.a.startLoad(bVar2.f, 10, false);
            hVar2.b.setText(bVar2.e);
            hVar2.c.setText(bVar2.h);
            hVar2.d.setText(bVar2.i);
            long j = bVar2.j;
            long j2 = 0;
            if (j < 0) {
                j = 0;
            }
            long j3 = bVar2.k;
            if (j3 >= 0) {
                j2 = j3;
            }
            hVar2.e.setText(this.a.getString(R.string.obfuscated_res_0x7f0f02e8) + StringHelper.numFormatOver10000wan(j));
            hVar2.f.setText(this.a.getString(R.string.text_post) + StringHelper.numFormatOver10000wan(j2));
            if (bVar2.c && !StringUtils.isNull(bVar2.g)) {
                hVar2.g.setText(UtilHelper.getFixedText(bVar2.g, 5));
                hVar2.g.setVisibility(0);
                hVar2.h.setVisibility(0);
            } else {
                hVar2.g.setVisibility(8);
                hVar2.h.setVisibility(8);
            }
            hVar2.g.setOnClickListener(new c(this, bVar2));
            hVar2.m.setOnClickListener(new d(this, bVar2));
            hVar2.l.setOnClickListener(new e(this, hVar2));
            view2.setOnClickListener(new f(this, bVar2));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902026, new BarFolderFirstDirActivityConfig(this.a.getPageActivity(), SingleSquareActivityConfig.makeStatisticsParam("forum_browse", "all"))));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<l8a.b> arrayList = this.e;
            int i = 0;
            if (arrayList != null && arrayList.size() != 0) {
                i = 0 + this.e.size();
            }
            ArrayList<t35> arrayList2 = this.d;
            if (arrayList2 != null && arrayList2.size() != 0) {
                i++;
            }
            if (i != 0) {
                i++;
            }
            ArrayList<l8a.a> arrayList3 = this.f;
            if (arrayList3 != null && arrayList3.size() > 0) {
                return i + 1;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        l8a.b bVar;
        ArrayList<t35> arrayList;
        ArrayList<l8a.a> arrayList2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int i2 = 0;
            if (i == 0) {
                ArrayList<t35> arrayList3 = this.d;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    return 0;
                }
                ArrayList<l8a.a> arrayList4 = this.f;
                if (arrayList4 != null && arrayList4.size() != 0) {
                    return 1;
                }
            }
            if (i == 1 && (arrayList = this.d) != null && arrayList.size() != 0 && (arrayList2 = this.f) != null && arrayList2.size() != 0) {
                return 1;
            }
            if (i == getCount() - 1) {
                return 4;
            }
            ArrayList<t35> arrayList5 = this.d;
            if (arrayList5 != null && arrayList5.size() != 0) {
                i2 = 1;
            }
            ArrayList<l8a.a> arrayList6 = this.f;
            if (arrayList6 != null && arrayList6.size() != 0) {
                i2++;
            }
            int i3 = i - i2;
            if (i3 < 0 || i3 >= this.e.size() || (bVar = this.e.get(i3)) == null) {
                return -1;
            }
            if (bVar.a) {
                return 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                return this.g.getView(i, view2, viewGroup);
            }
            if (view2 == null) {
                view2 = d(i, viewGroup, itemViewType);
            }
            f(view2, i);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
