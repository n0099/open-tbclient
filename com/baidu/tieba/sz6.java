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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.by6;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.tieba.enterForum.callback.LikeForumDragCallBack;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.f05;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class sz6 extends lo5<sx6, ox6> implements jx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public LikeForumItemAdapter j;
    public by6 k;
    public EnterForumModel l;
    public ViewEventCenter m;

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz6 a;

        /* loaded from: classes8.dex */
        public class a implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921372, j85.b()));
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* renamed from: com.baidu.tieba.sz6$c$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0479c implements f05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0479c(c cVar) {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        public c(sz6 sz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.Q()) {
                    if (this.a.m != null) {
                        this.a.m.dispatchMvcEvent(new eo5(14, null, null, null));
                    }
                } else if (this.a.c() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.l.S().b();
                    if (b2 != null) {
                        int P = b2.P();
                        if (P != 220012) {
                            if (P == 2121002) {
                                DialogUtil.createAlertDialog(this.a.c(), (String) null, this.a.c().getString(R.string.obfuscated_res_0x7f0f051d), this.a.c().getString(R.string.obfuscated_res_0x7f0f170a), this.a.c().getString(R.string.think_more), new a(this), new b(this)).show();
                            }
                        } else {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (rd.isEmpty(b2.O())) {
                                O = this.a.c().getString(R.string.obfuscated_res_0x7f0f0519);
                            } else {
                                O = b2.O();
                            }
                            blockPopInfoData.block_info = O;
                            blockPopInfoData.ahead_info = this.a.c().getString(R.string.obfuscated_res_0x7f0f051b);
                            blockPopInfoData.ok_info = this.a.c().getString(R.string.obfuscated_res_0x7f0f0b86);
                            blockPopInfoData.ahead_url = AntiHelper.a;
                            AntiHelper.s(this.a.c().getPageActivity(), blockPopInfoData);
                        }
                        z = true;
                    }
                    if (!z) {
                        String string = this.a.c().getString(R.string.obfuscated_res_0x7f0f051a);
                        if (b2 != null) {
                            if (rd.isEmpty(b2.O())) {
                                string = this.a.c().getResources().getString(R.string.obfuscated_res_0x7f0f051a);
                            } else {
                                string = b2.O();
                            }
                        }
                        DialogUtil.createAlertDialog(this.a.c(), (String) null, string, this.a.c().getResources().getString(R.string.obfuscated_res_0x7f0f0b86), (String) null, new C0479c(this), (f05.e) null).show();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements by6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(sz6 sz6Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var, enterForumModel};
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

        @Override // com.baidu.tieba.by6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.a0(true, i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wz6 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ sz6 c;

        public b(sz6 sz6Var, wz6 wz6Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sz6Var, wz6Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sz6Var;
            this.a = wz6Var;
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
                    if (obj instanceof rx6) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        new BdTopToast(currentActivity, 2000).setIcon(false).setContent(currentActivity.getString(R.string.obfuscated_res_0x7f0f0bcf)).show((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz6(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, wz6 wz6Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, wz6Var, enterForumModel};
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
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f0915e4);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092685);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092340);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.recycler_view);
        this.i = recyclerView;
        this.l = enterForumModel;
        this.m = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(b(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.j = likeForumItemAdapter;
        likeForumItemAdapter.o(o());
        this.i.setAdapter(this.j);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.j, this));
        itemTouchHelper.attachToRecyclerView(this.i);
        by6 by6Var = new by6(tbPageContext.getPageActivity(), Integer.valueOf(hx6.a(1)).intValue(), 0, wz6Var);
        this.k = by6Var;
        by6Var.u(new a(this, enterForumModel));
        this.j.p(new b(this, wz6Var, itemTouchHelper));
    }

    @Override // com.baidu.tieba.jx6
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && (enterForumModel = this.l) != null) {
            enterForumModel.j0(str, str2);
        }
    }

    @Override // com.baidu.tieba.mva
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            EMManager.from(this.f).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final View.OnClickListener o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new c(this);
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.oo5
    /* renamed from: p */
    public void h(sx6 sx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sx6Var) == null) {
            super.h(sx6Var);
            q(sx6Var.d);
            List<rx6> list = sx6Var.e;
            int i = 1;
            if (list != null) {
                i = 1 + list.size();
            }
            int ceil = (int) Math.ceil((i * 1.0f) / 2.0f);
            this.i.getLayoutParams().height = BdUtilHelper.getDimens(b(), R.dimen.tbds156) * ceil;
            this.i.getRecycledViewPool().setMaxRecycledViews(0, i);
            this.j.q(sx6Var.e);
            onChangeSkinType(c(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void q(qx6 qx6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, qx6Var) != null) || qx6Var == null) {
            return;
        }
        this.k.v(this.h);
        this.k.r();
        this.k.q(TbadkCoreApplication.getInst().getSkinType());
        this.g.setText(qx6Var.d);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        TextView textView = this.h;
        if (textView != null) {
            if (qx6Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.h, R.color.transparent);
        }
    }
}
