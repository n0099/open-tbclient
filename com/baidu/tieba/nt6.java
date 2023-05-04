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
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.u05;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class nt6 extends ol5<nr6, jr6> implements er6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public LikeForumItemAdapter j;
    public wr6 k;
    public EnterForumModel l;
    public ViewEventCenter m;

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nt6 a;

        /* loaded from: classes5.dex */
        public class a implements u05.e {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, k85.b()));
                    u05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements u05.e {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    u05Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.nt6$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0374c implements u05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0374c(c cVar) {
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

            @Override // com.baidu.tieba.u05.e
            public void onClick(u05 u05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, u05Var) == null) {
                    u05Var.dismiss();
                }
            }
        }

        public c(nt6 nt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nt6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String V;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.X()) {
                    if (this.a.m != null) {
                        this.a.m.dispatchMvcEvent(new hl5(14, null, null, null));
                    }
                } else if (this.a.b() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.l.Z().b();
                    if (b2 != null) {
                        int W = b2.W();
                        if (W != 220012) {
                            if (W == 2121002) {
                                cb5.b(this.a.b(), null, this.a.b().getString(R.string.obfuscated_res_0x7f0f04a9), this.a.b().getString(R.string.obfuscated_res_0x7f0f1539), this.a.b().getString(R.string.obfuscated_res_0x7f0f14c9), new a(this), new b(this)).show();
                            }
                        } else {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (hi.isEmpty(b2.V())) {
                                V = this.a.b().getString(R.string.obfuscated_res_0x7f0f04a5);
                            } else {
                                V = b2.V();
                            }
                            blockPopInfoData.block_info = V;
                            blockPopInfoData.ahead_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f04a7);
                            blockPopInfoData.ok_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0a77);
                            blockPopInfoData.ahead_url = AntiHelper.a;
                            AntiHelper.s(this.a.b().getPageActivity(), blockPopInfoData);
                        }
                        z = true;
                    }
                    if (!z) {
                        String string = this.a.b().getString(R.string.obfuscated_res_0x7f0f04a6);
                        if (b2 != null) {
                            if (hi.isEmpty(b2.V())) {
                                string = this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f04a6);
                            } else {
                                string = b2.V();
                            }
                        }
                        cb5.b(this.a.b(), null, string, this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f0a77), null, new C0374c(this), null).show();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements wr6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(nt6 nt6Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var, enterForumModel};
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

        @Override // com.baidu.tieba.wr6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.h0(true, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rt6 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ nt6 c;

        public b(nt6 nt6Var, rt6 rt6Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nt6Var, rt6Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nt6Var;
            this.a = rt6Var;
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
                    if (obj instanceof mr6) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.h(false);
                        bdTopToast.g(currentActivity.getString(R.string.obfuscated_res_0x7f0f0ab9));
                        bdTopToast.i((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nt6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, rt6 rt6Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, rt6Var, enterForumModel};
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
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f09147e);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09240b);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920ea);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_view);
        this.i = recyclerView;
        this.l = enterForumModel;
        this.m = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.j = likeForumItemAdapter;
        likeForumItemAdapter.m(m());
        this.i.setAdapter(this.j);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.j, this));
        itemTouchHelper.attachToRecyclerView(this.i);
        wr6 wr6Var = new wr6(tbPageContext.getPageActivity(), Integer.valueOf(cr6.a(1)).intValue(), 0, rt6Var);
        this.k = wr6Var;
        wr6Var.u(new a(this, enterForumModel));
        this.j.n(new b(this, rt6Var, itemTouchHelper));
    }

    @Override // com.baidu.tieba.er6
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && (enterForumModel = this.l) != null) {
            enterForumModel.s0(str, str2);
        }
    }

    @Override // com.baidu.tieba.mo9
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            g35 d = g35.d(this.f);
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
    @Override // com.baidu.tieba.rl5
    /* renamed from: n */
    public void f(nr6 nr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nr6Var) == null) {
            super.f(nr6Var);
            o(nr6Var.d);
            List<mr6> list = nr6Var.e;
            int i = 1;
            if (list != null) {
                i = 1 + list.size();
            }
            int ceil = (int) Math.ceil((i * 1.0f) / 2.0f);
            this.i.getLayoutParams().height = ii.g(getContext(), R.dimen.tbds156) * ceil;
            this.i.getRecycledViewPool().setMaxRecycledViews(0, i);
            this.j.update(nr6Var.e);
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void o(lr6 lr6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, lr6Var) != null) || lr6Var == null) {
            return;
        }
        this.k.v(this.h);
        this.k.r();
        this.k.q(TbadkCoreApplication.getInst().getSkinType());
        this.g.setText(lr6Var.d);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        TextView textView = this.h;
        if (textView != null) {
            if (lr6Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.h, R.color.transparent);
        }
    }
}
