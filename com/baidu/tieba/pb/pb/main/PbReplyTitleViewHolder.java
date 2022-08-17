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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dl8;
import com.repackage.mx7;
import com.repackage.oi;
import com.repackage.qi;
import com.repackage.rt7;
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes4.dex */
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
    public rt7 q;
    public BdUniqueId r;
    public boolean s;
    public BdUniqueId t;
    public TbPageContext u;
    public boolean v;
    public SortSwitchButton.f w;
    public View.OnClickListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.o == null) {
                return;
            }
            this.a.o.onClick(this.a.i);
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.s) {
                return;
            }
            if (this.a.o != null) {
                this.a.o.onClick(view2);
            }
            if (oi.z()) {
                if (view2 == null || !(view2.getTag() instanceof Boolean) || ((Boolean) view2.getTag()).booleanValue()) {
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
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.q != null && this.a.q.b == rt7.i && customResponsedMessage != null && getTag() == this.a.r && (customResponsedMessage.getData() instanceof mx7.w0)) {
                ((mx7.w0) customResponsedMessage.getData()).c = this.a;
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.q == null || this.a.q.b != rt7.j || customResponsedMessage == null || getTag() != this.a.t || !(customResponsedMessage.getData() instanceof mx7.w0)) {
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
        TextLineView textLineView = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091bb4);
        this.c = textLineView;
        textLineView.setOnClickListener(this.x);
        this.i = view2.findViewById(R.id.obfuscated_res_0x7f091ba7);
        TextLineView textLineView2 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091ba6);
        this.j = textLineView2;
        textLineView2.setSelected(false);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f091b99);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091b98);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bb5);
        TextLineView textLineView3 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f0909f4);
        this.d = textLineView3;
        textLineView3.setOnClickListener(this.x);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view2.findViewById(R.id.obfuscated_res_0x7f091844);
        this.e = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.w);
        this.e.setVisibility(0);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917e2);
        this.c.setSelected(true);
        this.d.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(this.c);
        this.n.add(this.d);
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f09080d);
        this.h = view2.findViewById(R.id.obfuscated_res_0x7f0907ed);
        this.e.w(2);
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void h(rt7 rt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rt7Var) == null) {
            this.q = rt7Var;
            if (rt7Var == null) {
                return;
            }
            BdUniqueId bdUniqueId = rt7Var.b;
            if (bdUniqueId == rt7.j) {
                this.i.getContext();
                if (TextUtils.isEmpty(rt7Var.a)) {
                    this.l.setVisibility(0);
                    this.i.setVisibility(8);
                    this.c.setVisibility(0);
                    this.c.setSelected(false);
                    this.c.setClickable(false);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e8));
                } else {
                    this.l.setVisibility(8);
                    this.c.setVisibility(8);
                    this.i.setVisibility(0);
                    this.i.setOnClickListener(new c(this));
                }
                this.e.setVisibility(8);
                this.d.setVisibility(8);
                this.h.setVisibility(8);
            } else if (bdUniqueId == rt7.i) {
                this.i.setVisibility(8);
                this.l.setVisibility(0);
                if (this.q.h) {
                    this.d.setVisibility(8);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0269));
                    this.c.setClickable(false);
                    i(false);
                } else {
                    this.d.setVisibility(0);
                    this.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0272));
                    this.c.setClickable(true);
                    i(rt7Var.d);
                }
                if (rt7Var.g != null) {
                    this.e.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= rt7Var.g.size()) {
                            i = 0;
                            break;
                        } else if (rt7Var.g.get(i) != null && rt7Var.c == rt7Var.g.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    k(rt7Var.g, i);
                }
                this.h.setVisibility(0);
            }
            if (this.v) {
                this.h.getLayoutParams().height = qi.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
            } else {
                this.h.getLayoutParams().height = 0;
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            }
            if (rt7Var.e) {
                this.m.setVisibility(0);
                this.k.setVisibility(8);
            } else {
                this.m.setVisibility(8);
                this.k.setVisibility(0);
            }
            l(TbadkCoreApplication.getInst().getSkinType());
        }
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

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (View) invokeV.objValue;
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
                dl8 dl8Var = new dl8();
                dl8Var.c(pbSortType.sort_type.intValue());
                dl8Var.d(pbSortType.sort_name);
                arrayList.add(dl8Var);
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
                rt7 rt7Var = this.q;
                if (rt7Var != null && rt7Var.b == rt7.j) {
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
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) || (sortSwitchButton = this.e) == null) {
            return;
        }
        sortSwitchButton.setListenerTag(bdUniqueId);
        this.e.setCommenId(bdUniqueId);
    }

    public void s(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (view2 = this.b) == null) {
            return;
        }
        view2.setVisibility(i);
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.m.setText(R.string.obfuscated_res_0x7f0f0870);
                this.m.setTypeface(Typeface.defaultFromStyle(1));
                this.m.setTextSize(0, qi.f(this.u.getPageActivity(), R.dimen.T_X07));
                this.m.setVisibility(0);
                this.k.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            this.m.setTypeface(Typeface.defaultFromStyle(0));
            this.m.setTextSize(0, qi.f(this.u.getPageActivity(), R.dimen.tbfontsize42));
        }
    }
}
