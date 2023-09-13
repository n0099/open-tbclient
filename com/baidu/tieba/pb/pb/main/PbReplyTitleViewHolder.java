package com.baidu.tieba.pb.pb.main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.pj9;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.wha;
import com.baidu.tieba.xn9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes7.dex */
public class PbReplyTitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public TextLineView c;
    public TextLineView d;
    public SortSwitchButton e;
    public TextView f;
    public View g;
    public View h;
    public View i;
    public TextLineView j;
    public View k;
    public View l;
    public TextView m;
    public List<TextLineView> n;
    public View.OnClickListener o;
    public SortSwitchButton.f p;
    public pj9 q;
    public BdUniqueId r;
    public boolean s;
    public BdUniqueId t;
    public TbPageContext u;
    public boolean v;
    public SortSwitchButton.f w;
    public View.OnClickListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes7.dex */
    public class a implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbReplyTitleViewHolder a;

        public a(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbReplyTitleViewHolder;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (this.a.p != null) {
                    return this.a.p.a(i);
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public b(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbReplyTitleViewHolder a;

        public c(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbReplyTitleViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.s) {
                return;
            }
            if (this.a.o != null) {
                this.a.o.onClick(view2);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (view2 != null && (view2.getTag() instanceof Boolean) && !((Boolean) view2.getTag()).booleanValue()) {
                    return;
                }
                for (TextLineView textLineView : this.a.n) {
                    if (textLineView != null) {
                        if (textLineView == view2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        textLineView.setSelected(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbReplyTitleViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbReplyTitleViewHolder pbReplyTitleViewHolder, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder, Integer.valueOf(i)};
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
            this.a = pbReplyTitleViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.q != null && this.a.q.a == pj9.g && customResponsedMessage != null && getTag() == this.a.r && (customResponsedMessage.getData() instanceof xn9.g1)) {
                xn9.g1 g1Var = (xn9.g1) customResponsedMessage.getData();
                if (this.a.u != null && this.a.u.getUniqueId() == g1Var.b) {
                    g1Var.a = this.a;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbReplyTitleViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbReplyTitleViewHolder pbReplyTitleViewHolder, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbReplyTitleViewHolder, Integer.valueOf(i)};
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
            this.a = pbReplyTitleViewHolder;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.q == null || this.a.q.a != pj9.h || customResponsedMessage == null || getTag() != this.a.t || !(customResponsedMessage.getData() instanceof xn9.g1)) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.v = true;
        this.w = new a(this);
        this.x = new c(this);
        this.y = new d(this, 2004013);
        this.z = new e(this, 2004013);
        if (view2 == null) {
            return;
        }
        this.b = view2;
        this.u = tbPageContext;
        view2.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091f2a);
        this.c = textLineView;
        textLineView.setOnClickListener(this.x);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f091f1d);
        TextLineView textLineView2 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091f1c);
        this.j = textLineView2;
        textLineView2.setSelected(false);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f091f0e);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091f0d);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f2b);
        TextLineView textLineView3 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f090b7b);
        this.d = textLineView3;
        textLineView3.setOnClickListener(this.x);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view2.findViewById(R.id.obfuscated_res_0x7f091b61);
        this.e = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.w);
        this.e.setVisibility(0);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091afa);
        this.c.setSelected(true);
        this.d.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(this.c);
        this.n.add(this.d);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f09091d);
        this.h = view2.findViewById(R.id.divider_bottom);
        this.e.x(2);
        m(TbadkCoreApplication.getInst().getSkinType());
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.d.setSelected(true);
                this.c.setSelected(false);
                return;
            }
            this.d.setSelected(false);
            this.c.setSelected(true);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.t = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.s = z;
            SortSwitchButton sortSwitchButton = this.e;
            if (sortSwitchButton != null) {
                sortSwitchButton.setCanChange(!z);
            }
        }
    }

    public void q(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void r(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void s(BdUniqueId bdUniqueId) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) && (sortSwitchButton = this.e) != null) {
            sortSwitchButton.setListenerTag(bdUniqueId);
            this.e.setCommenId(bdUniqueId);
        }
    }

    public void t(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (view2 = this.b) != null) {
            view2.setVisibility(i);
        }
    }

    public void i(pj9 pj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pj9Var) == null) {
            this.q = pj9Var;
            if (pj9Var == null) {
                return;
            }
            BdUniqueId bdUniqueId = pj9Var.a;
            if (bdUniqueId == pj9.h) {
                this.l.setVisibility(0);
                this.i.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setSelected(false);
                this.c.setClickable(false);
                this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091b));
                this.e.setVisibility(8);
                this.d.setVisibility(8);
                this.h.setVisibility(8);
            } else if (bdUniqueId == pj9.g) {
                this.i.setVisibility(8);
                this.l.setVisibility(0);
                if (this.q.f) {
                    this.d.setVisibility(8);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029f));
                    this.c.setClickable(false);
                    j(false);
                } else {
                    this.d.setVisibility(0);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02a8));
                    this.c.setClickable(true);
                    j(pj9Var.c);
                }
                if (pj9Var.e != null) {
                    this.e.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i < pj9Var.e.size()) {
                            if (pj9Var.e.get(i) != null && pj9Var.b == pj9Var.e.get(i).sort_type.intValue()) {
                                break;
                            }
                            i++;
                        } else {
                            i = 0;
                            break;
                        }
                    }
                    l(pj9Var.e, i);
                }
                this.h.setVisibility(0);
            }
            if (this.v) {
                this.h.getLayoutParams().height = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
            } else {
                this.h.getLayoutParams().height = 0;
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            }
            if (pj9Var.d) {
                this.m.setVisibility(0);
                this.k.setVisibility(8);
            } else {
                this.m.setVisibility(8);
                this.k.setVisibility(0);
            }
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void l(List<PbSortType> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                this.e.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                wha whaVar = new wha();
                whaVar.c(pbSortType.sort_type.intValue());
                whaVar.d(pbSortType.sort_name);
                arrayList.add(whaVar);
            }
            this.e.setVisibility(0);
            this.e.setData(arrayList, i);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
                this.c.b(i);
                this.d.b(i);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
                pj9 pj9Var = this.q;
                if (pj9Var != null && pj9Var.a == pj9.h) {
                    SkinManager.setViewTextColor(this.c, R.color.CAM_X0107, 1);
                }
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
                this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
                this.e.I();
                SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
                if (this.v) {
                    SkinManager.setBackgroundColor(this.h, R.color.CAM_X0203);
                    SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
                } else {
                    SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
                }
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
            }
            this.a = i;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.m.setText(R.string.hot_recommendation);
                this.m.setTypeface(Typeface.defaultFromStyle(1));
                this.m.setTextSize(0, BdUtilHelper.getDimens(this.u.getPageActivity(), R.dimen.T_X07));
                this.m.setVisibility(0);
                this.k.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            this.m.setTypeface(Typeface.defaultFromStyle(0));
            this.m.setTextSize(0, BdUtilHelper.getDimens(this.u.getPageActivity(), R.dimen.tbfontsize42));
        }
    }
}
