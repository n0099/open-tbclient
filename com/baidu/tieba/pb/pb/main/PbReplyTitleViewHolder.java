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
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.ha8;
import com.baidu.tieba.i19;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.rd8;
import com.baidu.tieba.view.SortSwitchButton;
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
    public TextLineView b;
    public TextLineView c;
    public SortSwitchButton d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public TextLineView i;
    public View j;
    public View k;
    public TextView l;
    public List<TextLineView> m;
    public View.OnClickListener n;
    public SortSwitchButton.f o;
    public ha8 p;
    public BdUniqueId q;
    public boolean r;
    public BdUniqueId s;
    public TbPageContext t;
    public boolean u;
    public SortSwitchButton.f v;
    public View.OnClickListener w;
    public CustomMessageListener x;
    public CustomMessageListener y;

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
                if (this.a.o != null) {
                    return this.a.o.a(i);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.r) {
                return;
            }
            if (this.a.n != null) {
                this.a.n.onClick(view2);
            }
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                if (view2 != null && (view2.getTag() instanceof Boolean) && !((Boolean) view2.getTag()).booleanValue()) {
                    return;
                }
                for (TextLineView textLineView : this.a.m) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.p != null && this.a.p.a == ha8.g && customResponsedMessage != null && getTag() == this.a.q && (customResponsedMessage.getData() instanceof rd8.z0)) {
                ((rd8.z0) customResponsedMessage.getData()).a = this.a;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.p == null || this.a.p.a != ha8.h || customResponsedMessage == null || getTag() != this.a.s || !(customResponsedMessage.getData() instanceof rd8.z0)) {
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
        this.u = true;
        this.v = new a(this);
        this.w = new c(this);
        this.x = new d(this, 2004013);
        this.y = new e(this, 2004013);
        if (view2 == null) {
            return;
        }
        this.t = tbPageContext;
        view2.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091cda);
        this.b = textLineView;
        textLineView.setOnClickListener(this.w);
        this.h = view2.findViewById(R.id.obfuscated_res_0x7f091cce);
        TextLineView textLineView2 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f091ccd);
        this.i = textLineView2;
        textLineView2.setSelected(false);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091cc0);
        this.j = view2.findViewById(R.id.obfuscated_res_0x7f091cbf);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cdb);
        TextLineView textLineView3 = (TextLineView) view2.findViewById(R.id.obfuscated_res_0x7f090a95);
        this.c = textLineView3;
        textLineView3.setOnClickListener(this.w);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view2.findViewById(R.id.obfuscated_res_0x7f091964);
        this.d = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.v);
        this.d.setVisibility(0);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091907);
        this.b.setSelected(true);
        this.c.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.m = arrayList;
        arrayList.add(this.b);
        this.m.add(this.c);
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f09086c);
        this.g = view2.findViewById(R.id.divider_bottom);
        this.d.w(2);
        k(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.c.setSelected(true);
                this.b.setSelected(false);
                return;
            }
            this.c.setSelected(false);
            this.b.setSelected(true);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.s = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.q = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.x.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.r = z;
            SortSwitchButton sortSwitchButton = this.d;
            if (sortSwitchButton != null) {
                sortSwitchButton.setCanChange(!z);
            }
        }
    }

    public void o(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void p(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) && (sortSwitchButton = this.d) != null) {
            sortSwitchButton.setListenerTag(bdUniqueId);
            this.d.setCommenId(bdUniqueId);
        }
    }

    public void h(ha8 ha8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ha8Var) == null) {
            this.p = ha8Var;
            if (ha8Var == null) {
                return;
            }
            BdUniqueId bdUniqueId = ha8Var.a;
            if (bdUniqueId == ha8.h) {
                this.k.setVisibility(0);
                this.h.setVisibility(8);
                this.b.setVisibility(0);
                this.b.setSelected(false);
                this.b.setClickable(false);
                this.b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0843));
                this.d.setVisibility(8);
                this.c.setVisibility(8);
                this.g.setVisibility(8);
            } else if (bdUniqueId == ha8.g) {
                this.h.setVisibility(8);
                this.k.setVisibility(0);
                if (this.p.f) {
                    this.c.setVisibility(8);
                    this.b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0273));
                    this.b.setClickable(false);
                    i(false);
                } else {
                    this.c.setVisibility(0);
                    this.b.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f027c));
                    this.b.setClickable(true);
                    i(ha8Var.c);
                }
                if (ha8Var.e != null) {
                    this.d.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i < ha8Var.e.size()) {
                            if (ha8Var.e.get(i) != null && ha8Var.b == ha8Var.e.get(i).sort_type.intValue()) {
                                break;
                            }
                            i++;
                        } else {
                            i = 0;
                            break;
                        }
                    }
                    j(ha8Var.e, i);
                }
                this.g.setVisibility(0);
            }
            if (this.u) {
                this.g.getLayoutParams().height = ej.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0207);
            } else {
                this.g.getLayoutParams().height = 0;
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            }
            if (ha8Var.d) {
                this.l.setVisibility(0);
                this.j.setVisibility(8);
            } else {
                this.l.setVisibility(8);
                this.j.setVisibility(0);
            }
            k(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void j(List<PbSortType> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                this.d.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                i19 i19Var = new i19();
                i19Var.c(pbSortType.sort_type.intValue());
                i19Var.d(pbSortType.sort_name);
                arrayList.add(i19Var);
            }
            this.d.setVisibility(0);
            this.d.setData(arrayList, i);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
                this.b.b();
                this.c.b();
                SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
                ha8 ha8Var = this.p;
                if (ha8Var != null && ha8Var.a == ha8.h) {
                    SkinManager.setViewTextColor(this.b, R.color.CAM_X0107, 1);
                }
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0107);
                this.e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
                this.d.H();
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                if (this.u) {
                    SkinManager.setBackgroundColor(this.g, R.color.CAM_X0203);
                    SkinManager.setBackgroundColor(this.k, R.color.CAM_X0207);
                } else {
                    SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
                }
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
            }
            this.a = i;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.l.setText(R.string.hot_recommendation);
                this.l.setTypeface(Typeface.defaultFromStyle(1));
                this.l.setTextSize(0, ej.g(this.t.getPageActivity(), R.dimen.T_X07));
                this.l.setVisibility(0);
                this.j.setVisibility(8);
                return;
            }
            this.l.setVisibility(8);
            this.j.setVisibility(0);
            this.l.setTypeface(Typeface.defaultFromStyle(0));
            this.l.setTextSize(0, ej.g(this.t.getPageActivity(), R.dimen.tbfontsize42));
        }
    }
}
