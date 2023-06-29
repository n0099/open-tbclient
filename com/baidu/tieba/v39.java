package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.nearby.viewholder.NearbyForumFriendItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class v39 extends kn<hh5, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public boolean c;

    public final int y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i != 1) {
                return i != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v39 a;

        public a(v39 v39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v39Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(xnVar instanceof hh5)) {
                return;
            }
            hh5 hh5Var = (hh5) xnVar;
            String str = hh5Var.a;
            if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str)) {
                z = true;
            } else {
                z = false;
            }
            u28.i(i + 1, this.a.b, 2, hh5Var.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.a).createNormalConfig(vg.g(str, 0L), z, false)));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ hh5 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ v39 d;

        public b(v39 v39Var, ViewGroup viewGroup, hh5 hh5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v39Var, viewGroup, hh5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v39Var;
            this.a = viewGroup;
            this.b = hh5Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.d.c) {
                    PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.a.getContext());
                    personChangeActivityConfig.setIsCompleteLocalInfo(true);
                    personChangeActivityConfig.start();
                } else {
                    hh5 hh5Var = this.b;
                    v39 v39Var = this.d;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921654, new ij5(hh5Var, v39Var.y(v39Var.b))));
                }
                u28.i(this.c + 1, this.d.b, 1, this.b.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v39(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = i;
        setOnAdapterItemClickListener(new a(this));
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.c = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: z */
    public NearbyForumFriendItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06ce, viewGroup, false), this.a);
        }
        return (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public View A(int i, View view2, ViewGroup viewGroup, hh5 hh5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hh5Var, nearbyForumFriendItemViewHolder})) == null) {
            if (hh5Var != null && nearbyForumFriendItemViewHolder != null) {
                E(hh5Var, nearbyForumFriendItemViewHolder);
                C(hh5Var, nearbyForumFriendItemViewHolder);
                u28.p(i + 1, this.b);
                nearbyForumFriendItemViewHolder.k.setOnClickListener(new b(this, viewGroup, hh5Var, i));
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void B(NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nearbyForumFriendItemViewHolder, i) == null) {
            nearbyForumFriendItemViewHolder.p.setVisibility(0);
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        nearbyForumFriendItemViewHolder.p.setVisibility(8);
                        nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
                        return;
                    }
                    nearbyForumFriendItemViewHolder.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e03));
                    nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
                    return;
                }
                nearbyForumFriendItemViewHolder.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e02));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
                return;
            }
            nearbyForumFriendItemViewHolder.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e04));
            nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
        }
    }

    public final void C(hh5 hh5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hh5Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.N(hh5Var.c, 25, false);
            nearbyForumFriendItemViewHolder.d.setText(hh5Var.b);
            int i = hh5Var.d;
            boolean z2 = true;
            if ((i != 1 && i != 2) || hh5Var.e <= 0) {
                nearbyForumFriendItemViewHolder.e.setVisibility(8);
                z = false;
            } else {
                nearbyForumFriendItemViewHolder.e.setVisibility(0);
                nearbyForumFriendItemViewHolder.g.setText(String.valueOf(hh5Var.e));
                z = true;
            }
            if (StringUtils.isNull(hh5Var.f)) {
                nearbyForumFriendItemViewHolder.h.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.h.setVisibility(0);
                nearbyForumFriendItemViewHolder.h.setText(hh5Var.f);
                z = true;
            }
            if (StringUtils.isNull(hh5Var.g)) {
                nearbyForumFriendItemViewHolder.i.setVisibility(8);
                z2 = z;
            } else {
                nearbyForumFriendItemViewHolder.i.setVisibility(0);
                nearbyForumFriendItemViewHolder.i.setText(hh5Var.g);
            }
            B(nearbyForumFriendItemViewHolder, hh5Var.k);
            if (z2 && nearbyForumFriendItemViewHolder.p.getVisibility() == 0) {
                nearbyForumFriendItemViewHolder.o.setVisibility(0);
            } else {
                nearbyForumFriendItemViewHolder.o.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f078a));
            if (!ListUtils.isEmpty(hh5Var.h)) {
                List<gh5> list = hh5Var.h;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i2).a);
                    sb.append(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f076a));
                }
            }
            nearbyForumFriendItemViewHolder.j.setText(sb);
            nearbyForumFriendItemViewHolder.n.setText(hh5Var.i);
        }
    }

    public final void E(hh5 hh5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, hh5Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            s75.d(nearbyForumFriendItemViewHolder.d).x(R.color.CAM_X0105);
            int i = hh5Var.d;
            if (i == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f080999, R.color.CAM_X0330, null);
                s75.d(nearbyForumFriendItemViewHolder.g).x(R.color.CAM_X0330);
                s75 d = s75.d(nearbyForumFriendItemViewHolder.e);
                d.e(R.string.A_X11);
                d.o(R.string.J_X01);
                d.f(R.color.CAM_X0330);
            } else if (i == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0809b9, R.color.CAM_X0308, null);
                s75.d(nearbyForumFriendItemViewHolder.g).x(R.color.CAM_X0308);
                s75 d2 = s75.d(nearbyForumFriendItemViewHolder.e);
                d2.e(R.string.A_X11);
                d2.o(R.string.J_X01);
                d2.f(R.color.CAM_X0308);
            }
            s75 d3 = s75.d(nearbyForumFriendItemViewHolder.h);
            d3.o(R.string.J_X01);
            d3.x(R.color.CAM_X0107);
            d3.f(R.color.CAM_X0202);
            s75.d(nearbyForumFriendItemViewHolder.i).x(R.color.CAM_X0109);
            s75.d(nearbyForumFriendItemViewHolder.o).x(R.color.CAM_X0109);
            s75.d(nearbyForumFriendItemViewHolder.p).x(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.l, R.drawable.obfuscated_res_0x7f080bc3, R.color.CAM_X0302, null);
            s75.d(nearbyForumFriendItemViewHolder.m).x(R.color.CAM_X0302);
            s75 d4 = s75.d(nearbyForumFriendItemViewHolder.k);
            d4.o(R.string.J_X01);
            d4.f(R.color.CAM_X0905);
            s75.d(nearbyForumFriendItemViewHolder.j).x(R.color.CAM_X0109);
            s75.d(nearbyForumFriendItemViewHolder.n).x(R.color.CAM_X0107);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hh5 hh5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        A(i, view2, viewGroup, hh5Var, nearbyForumFriendItemViewHolder);
        return view2;
    }
}
