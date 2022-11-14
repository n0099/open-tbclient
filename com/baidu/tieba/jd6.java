package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.tieba.enterForum.callback.LikeForumDragCallBack;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.jv4;
import com.baidu.tieba.qb6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class jd6 extends ld5<hb6, db6> implements ya6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public LikeForumItemAdapter j;
    public qb6 k;
    public EnterForumModel l;
    public ViewEventCenter m;

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd6 a;

        /* loaded from: classes4.dex */
        public class a implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, u15.b()));
                    jv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.jd6$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0316c implements jv4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0316c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        public c(jd6 jd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.B()) {
                    if (this.a.m != null) {
                        this.a.m.dispatchMvcEvent(new ed5(14, null, null, null));
                    }
                } else if (this.a.b() == null) {
                } else {
                    boolean z2 = false;
                    ForumCreateInfoData b2 = this.a.l.D().b();
                    if (b2 != null) {
                        int A = b2.A();
                        if (A != 220012) {
                            if (A == 2121002) {
                                i45.b(this.a.b(), null, this.a.b().getString(R.string.obfuscated_res_0x7f0f0484), this.a.b().getString(R.string.obfuscated_res_0x7f0f1487), this.a.b().getString(R.string.obfuscated_res_0x7f0f1418), new a(this), new b(this)).show();
                            }
                        } else {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (xi.isEmpty(b2.z())) {
                                z = this.a.b().getString(R.string.obfuscated_res_0x7f0f0480);
                            } else {
                                z = b2.z();
                            }
                            blockPopInfoData.block_info = z;
                            blockPopInfoData.ahead_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0482);
                            blockPopInfoData.ok_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f09d4);
                            blockPopInfoData.ahead_url = AntiHelper.a;
                            AntiHelper.s(this.a.b().getPageActivity(), blockPopInfoData);
                        }
                        z2 = true;
                    }
                    if (!z2) {
                        String string = this.a.b().getString(R.string.obfuscated_res_0x7f0f0481);
                        if (b2 != null) {
                            if (xi.isEmpty(b2.z())) {
                                string = this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f0481);
                            } else {
                                string = b2.z();
                            }
                        }
                        i45.b(this.a.b(), null, string, this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f09d4), null, new C0316c(this), null).show();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements qb6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(jd6 jd6Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd6Var, enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        @Override // com.baidu.tieba.qb6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.L(true, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nd6 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ jd6 c;

        public b(jd6 jd6Var, nd6 nd6Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd6Var, nd6Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jd6Var;
            this.a = nd6Var;
            this.b = itemTouchHelper;
        }

        @Override // com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter.b
        public boolean a(Object obj, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, viewHolder)) == null) {
                if (this.a.r()) {
                    return false;
                }
                if (this.c.k.o() == 1) {
                    if (obj instanceof gb6) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.h(false);
                        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f0a13));
                        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, nd6 nd6Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, nd6Var, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f091338);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092263);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f6f);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091c08);
        this.i = recyclerView;
        this.l = enterForumModel;
        this.m = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.j = likeForumItemAdapter;
        likeForumItemAdapter.f(m());
        this.i.setAdapter(this.j);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.j, this));
        itemTouchHelper.attachToRecyclerView(this.i);
        qb6 qb6Var = new qb6(tbPageContext.getPageActivity(), Integer.valueOf(wa6.a(1)).intValue(), 0, nd6Var);
        this.k = qb6Var;
        qb6Var.u(new a(this, enterForumModel));
        this.j.g(new b(this, nd6Var, itemTouchHelper));
    }

    @Override // com.baidu.tieba.ya6
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && (enterForumModel = this.l) != null) {
            enterForumModel.X(str, str2);
        }
    }

    @Override // com.baidu.tieba.io8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            pw4 d = pw4.d(this.f);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final View.OnClickListener m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.od5
    /* renamed from: n */
    public void f(hb6 hb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hb6Var) == null) {
            super.f(hb6Var);
            o(hb6Var.d);
            List<gb6> list = hb6Var.e;
            int i = 1;
            if (list != null) {
                i = 1 + list.size();
            }
            int ceil = (int) Math.ceil((i * 1.0f) / 2.0f);
            this.i.getLayoutParams().height = yi.g(getContext(), R.dimen.tbds156) * ceil;
            this.i.getRecycledViewPool().setMaxRecycledViews(0, i);
            this.j.update(hb6Var.e);
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void o(fb6 fb6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, fb6Var) != null) || fb6Var == null) {
            return;
        }
        this.k.v(this.h);
        this.k.r();
        this.k.q(TbadkCoreApplication.getInst().getSkinType());
        this.g.setText(fb6Var.d);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        TextView textView = this.h;
        if (textView != null) {
            if (fb6Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.h, R.color.transparent);
        }
    }
}
