package com.baidu.tieba.pb.pb.main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.c98;
import com.baidu.tieba.kx8;
import com.baidu.tieba.l58;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
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
    public l58 q;
    public BdUniqueId r;
    public boolean s;
    public BdUniqueId t;
    public TbPageContext u;
    public boolean v;
    public SortSwitchButton.f w;
    public View.OnClickListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.o != null) {
                this.a.o.onClick(this.a.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbReplyTitleViewHolder a;

        public d(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
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
                        if (textLineView != view2) {
                            textLineView.setSelected(false);
                        } else {
                            textLineView.setSelected(true);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.q != null && this.a.q.b == l58.i && customResponsedMessage != null && getTag() == this.a.r && (customResponsedMessage.getData() instanceof c98.a1)) {
                ((c98.a1) customResponsedMessage.getData()).c = this.a;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbReplyTitleViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(PbReplyTitleViewHolder pbReplyTitleViewHolder, int i) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.q == null || this.a.q.b != l58.j || customResponsedMessage == null || getTag() != this.a.t || !(customResponsedMessage.getData() instanceof c98.a1)) {
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
        this.x = new d(this);
        this.y = new e(this, 2004013);
        this.z = new f(this, 2004013);
        if (view2 == null) {
            return;
        }
        this.b = view2;
        this.u = tbPageContext;
        view2.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091cc5);
        this.c = textLineView;
        textLineView.setOnClickListener(this.x);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f091cb8);
        TextLineView textLineView2 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091cb7);
        this.j = textLineView2;
        textLineView2.setSelected(false);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f091caa);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091ca9);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cc6);
        TextLineView textLineView3 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f090a4f);
        this.d = textLineView3;
        textLineView3.setOnClickListener(this.x);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view2.findViewById(R.id.obfuscated_res_0x7f091935);
        this.e = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.w);
        this.e.setVisibility(0);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918d0);
        this.c.setSelected(true);
        this.d.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(this.c);
        this.n.add(this.d);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f090858);
        this.h = view2.findViewById(R.id.divider_bottom);
        this.e.w(2);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(boolean z) {
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

    public void m(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.t = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.s = z;
            SortSwitchButton sortSwitchButton = this.e;
            if (sortSwitchButton != null) {
                sortSwitchButton.setCanChange(!z);
            }
        }
    }

    public void p(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) && (sortSwitchButton = this.e) != null) {
            sortSwitchButton.setListenerTag(bdUniqueId);
            this.e.setCommenId(bdUniqueId);
        }
    }

    public void s(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (view2 = this.b) != null) {
            view2.setVisibility(i);
        }
    }

    public void h(l58 l58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, l58Var) == null) {
            this.q = l58Var;
            if (l58Var == null) {
                return;
            }
            BdUniqueId bdUniqueId = l58Var.b;
            if (bdUniqueId == l58.j) {
                this.i.getContext();
                if (TextUtils.isEmpty(l58Var.a)) {
                    this.l.setVisibility(0);
                    this.i.setVisibility(8);
                    this.c.setVisibility(0);
                    this.c.setSelected(false);
                    this.c.setClickable(false);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0821));
                } else {
                    this.l.setVisibility(8);
                    this.c.setVisibility(8);
                    this.i.setVisibility(0);
                    this.i.setOnClickListener(new c(this));
                }
                this.e.setVisibility(8);
                this.d.setVisibility(8);
                this.h.setVisibility(8);
            } else if (bdUniqueId == l58.i) {
                this.i.setVisibility(8);
                this.l.setVisibility(0);
                if (this.q.h) {
                    this.d.setVisibility(8);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0273));
                    this.c.setClickable(false);
                    i(false);
                } else {
                    this.d.setVisibility(0);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f027c));
                    this.c.setClickable(true);
                    i(l58Var.d);
                }
                if (l58Var.g != null) {
                    this.e.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i < l58Var.g.size()) {
                            if (l58Var.g.get(i) != null && l58Var.c == l58Var.g.get(i).sort_type.intValue()) {
                                break;
                            }
                            i++;
                        } else {
                            i = 0;
                            break;
                        }
                    }
                    k(l58Var.g, i);
                }
                this.h.setVisibility(0);
            }
            if (this.v) {
                this.h.getLayoutParams().height = zi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
            } else {
                this.h.getLayoutParams().height = 0;
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            }
            if (l58Var.e) {
                this.m.setVisibility(0);
                this.k.setVisibility(8);
            } else {
                this.m.setVisibility(8);
                this.k.setVisibility(0);
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void k(List<PbSortType> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                this.e.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                kx8 kx8Var = new kx8();
                kx8Var.c(pbSortType.sort_type.intValue());
                kx8Var.d(pbSortType.sort_name);
                arrayList.add(kx8Var);
            }
            this.e.setVisibility(0);
            this.e.setData(arrayList, i);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
                this.c.b(i);
                this.d.b(i);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
                l58 l58Var = this.q;
                if (l58Var != null && l58Var.b == l58.j) {
                    SkinManager.setViewTextColor(this.c, R.color.CAM_X0107, 1);
                }
                SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0107);
                this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
                this.e.H();
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

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.m.setText(R.string.hot_recommendation);
                this.m.setTypeface(Typeface.defaultFromStyle(1));
                this.m.setTextSize(0, zi.g(this.u.getPageActivity(), R.dimen.T_X07));
                this.m.setVisibility(0);
                this.k.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            this.m.setTypeface(Typeface.defaultFromStyle(0));
            this.m.setTextSize(0, zi.g(this.u.getPageActivity(), R.dimen.tbfontsize42));
        }
    }
}
