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
import com.baidu.tieba.f17;
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class w27 extends ps5<w07, s07> implements n07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public LikeForumItemAdapter j;
    public f17 k;
    public EnterForumModel l;
    public ViewEventCenter m;

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w27 a;

        /* loaded from: classes8.dex */
        public class a implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, nd5.b()));
                    p55Var.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.w27$c$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0517c implements p55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0517c(c cVar) {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        public c(w27 w27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w27Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String V;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.X()) {
                    if (this.a.m != null) {
                        this.a.m.dispatchMvcEvent(new is5(14, null, null, null));
                    }
                } else if (this.a.b() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.l.Z().b();
                    if (b2 != null) {
                        int W = b2.W();
                        if (W != 220012) {
                            if (W == 2121002) {
                                vg5.b(this.a.b(), null, this.a.b().getString(R.string.obfuscated_res_0x7f0f0509), this.a.b().getString(R.string.obfuscated_res_0x7f0f16a1), this.a.b().getString(R.string.obfuscated_res_0x7f0f1626), new a(this), new b(this)).show();
                            }
                        } else {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (xi.isEmpty(b2.V())) {
                                V = this.a.b().getString(R.string.obfuscated_res_0x7f0f0505);
                            } else {
                                V = b2.V();
                            }
                            blockPopInfoData.block_info = V;
                            blockPopInfoData.ahead_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0507);
                            blockPopInfoData.ok_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0b3d);
                            blockPopInfoData.ahead_url = AntiHelper.a;
                            AntiHelper.s(this.a.b().getPageActivity(), blockPopInfoData);
                        }
                        z = true;
                    }
                    if (!z) {
                        String string = this.a.b().getString(R.string.obfuscated_res_0x7f0f0506);
                        if (b2 != null) {
                            if (xi.isEmpty(b2.V())) {
                                string = this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f0506);
                            } else {
                                string = b2.V();
                            }
                        }
                        vg5.b(this.a.b(), null, string, this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f0b3d), null, new C0517c(this), null).show();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements f17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(w27 w27Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w27Var, enterForumModel};
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

        @Override // com.baidu.tieba.f17.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.h0(true, i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a37 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ w27 c;

        public b(w27 w27Var, a37 a37Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w27Var, a37Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w27Var;
            this.a = a37Var;
            this.b = itemTouchHelper;
        }

        @Override // com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter.b
        public boolean a(Object obj, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, viewHolder)) == null) {
                if (this.a.p()) {
                    return false;
                }
                if (this.c.k.o() == 1) {
                    if (obj instanceof v07) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.h(false);
                        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f0b83));
                        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w27(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, a37 a37Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, a37Var, enterForumModel};
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
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f0914fc);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092542);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09221c);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_view);
        this.i = recyclerView;
        this.l = enterForumModel;
        this.m = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.j = likeForumItemAdapter;
        likeForumItemAdapter.n(m());
        this.i.setAdapter(this.j);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.j, this));
        itemTouchHelper.attachToRecyclerView(this.i);
        f17 f17Var = new f17(tbPageContext.getPageActivity(), Integer.valueOf(l07.a(1)).intValue(), 0, a37Var);
        this.k = f17Var;
        f17Var.u(new a(this, enterForumModel));
        this.j.o(new b(this, a37Var, itemTouchHelper));
    }

    @Override // com.baidu.tieba.n07
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && (enterForumModel = this.l) != null) {
            enterForumModel.s0(str, str2);
        }
    }

    @Override // com.baidu.tieba.vba
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            d85 d = d85.d(this.f);
            d.o(R.string.J_X06);
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
    @Override // com.baidu.tieba.ss5
    /* renamed from: n */
    public void f(w07 w07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, w07Var) == null) {
            super.f(w07Var);
            o(w07Var.d);
            List<v07> list = w07Var.e;
            int i = 1;
            if (list != null) {
                i = 1 + list.size();
            }
            int ceil = (int) Math.ceil((i * 1.0f) / 2.0f);
            this.i.getLayoutParams().height = yi.g(getContext(), R.dimen.tbds156) * ceil;
            this.i.getRecycledViewPool().setMaxRecycledViews(0, i);
            this.j.update(w07Var.e);
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void o(u07 u07Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, u07Var) != null) || u07Var == null) {
            return;
        }
        this.k.v(this.h);
        this.k.r();
        this.k.q(TbadkCoreApplication.getInst().getSkinType());
        this.g.setText(u07Var.d);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        TextView textView = this.h;
        if (textView != null) {
            if (u07Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.h, R.color.transparent);
        }
    }
}
