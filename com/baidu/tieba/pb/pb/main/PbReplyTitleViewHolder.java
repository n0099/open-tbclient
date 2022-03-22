package com.baidu.tieba.pb.pb.main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.p0.w2.i.r;
import c.a.p0.w2.m.f.a1;
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
import java.util.ArrayList;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes5.dex */
public class PbReplyTitleViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public View f34994b;

    /* renamed from: c  reason: collision with root package name */
    public TextLineView f34995c;

    /* renamed from: d  reason: collision with root package name */
    public TextLineView f34996d;

    /* renamed from: e  reason: collision with root package name */
    public SortSwitchButton f34997e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34998f;

    /* renamed from: g  reason: collision with root package name */
    public View f34999g;

    /* renamed from: h  reason: collision with root package name */
    public View f35000h;
    public View i;
    public TextLineView j;
    public View k;
    public View l;
    public TextView m;
    public List<TextLineView> n;
    public View.OnClickListener o;
    public SortSwitchButton.f p;
    public r q;
    public BdUniqueId r;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.o == null) {
                return;
            }
            this.a.o.onClick(this.a.i);
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.o != null) {
                    this.a.o.onClick(view);
                }
                if (l.z()) {
                    if (view == null || !(view.getTag() instanceof Boolean) || ((Boolean) view.getTag()).booleanValue()) {
                        for (TextLineView textLineView : this.a.n) {
                            if (textLineView != null) {
                                if (textLineView != view) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.q != null && this.a.q.f19848b == r.f19847h && customResponsedMessage != null && getTag() == this.a.r && (customResponsedMessage.getData() instanceof a1.p0)) {
                ((a1.p0) customResponsedMessage.getData()).f20017c = this.a;
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.q == null || this.a.q.f19848b != r.i || customResponsedMessage == null || getTag() != this.a.s || !(customResponsedMessage.getData() instanceof a1.p0)) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbReplyTitleViewHolder(TbPageContext tbPageContext, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
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
        this.w = new d(this);
        this.x = new e(this, 2004013);
        this.y = new f(this, 2004013);
        if (view == null) {
            return;
        }
        this.f34994b = view;
        this.t = tbPageContext;
        view.setOnClickListener(new b(this));
        TextLineView textLineView = (TextLineView) view.findViewById(R.id.obfuscated_res_0x7f091a6d);
        this.f34995c = textLineView;
        textLineView.setOnClickListener(this.w);
        this.i = view.findViewById(R.id.obfuscated_res_0x7f091a5f);
        TextLineView textLineView2 = (TextLineView) view.findViewById(R.id.obfuscated_res_0x7f091a5e);
        this.j = textLineView2;
        textLineView2.setSelected(false);
        this.l = view.findViewById(R.id.obfuscated_res_0x7f091a51);
        this.k = view.findViewById(R.id.obfuscated_res_0x7f091a50);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091a6e);
        TextLineView textLineView3 = (TextLineView) view.findViewById(R.id.obfuscated_res_0x7f0909e0);
        this.f34996d = textLineView3;
        textLineView3.setOnClickListener(this.w);
        SortSwitchButton sortSwitchButton = (SortSwitchButton) view.findViewById(R.id.obfuscated_res_0x7f091724);
        this.f34997e = sortSwitchButton;
        sortSwitchButton.setOnSwitchChangeListener(this.v);
        this.f34997e.setVisibility(0);
        this.f34998f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0916c5);
        this.f34995c.setSelected(true);
        this.f34996d.setSelected(false);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(this.f34995c);
        this.n.add(this.f34996d);
        this.f34999g = view.findViewById(R.id.obfuscated_res_0x7f09080b);
        this.f35000h = view.findViewById(R.id.obfuscated_res_0x7f0907eb);
        this.f34997e.v(2);
        m(TbadkCoreApplication.getInst().getSkinType());
    }

    public void i(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rVar) == null) {
            this.q = rVar;
            if (rVar == null) {
                return;
            }
            BdUniqueId bdUniqueId = rVar.f19848b;
            if (bdUniqueId == r.i) {
                this.i.getContext();
                if (TextUtils.isEmpty(rVar.a)) {
                    this.l.setVisibility(0);
                    this.i.setVisibility(8);
                    this.f34995c.setVisibility(0);
                    this.f34995c.setSelected(false);
                    this.f34995c.setClickable(false);
                    this.f34995c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07bf));
                } else {
                    this.l.setVisibility(8);
                    this.f34995c.setVisibility(8);
                    this.i.setVisibility(0);
                    this.i.setOnClickListener(new c(this));
                }
                this.f34997e.setVisibility(8);
                this.f34996d.setVisibility(8);
                this.f35000h.setVisibility(8);
            } else if (bdUniqueId == r.f19847h) {
                this.i.setVisibility(8);
                this.l.setVisibility(0);
                this.f34995c.setClickable(true);
                this.f34995c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0268));
                this.f34996d.setVisibility(0);
                j(rVar.f19850d);
                if (rVar.f19853g != null) {
                    this.f34997e.setVisibility(0);
                    int i = 0;
                    while (true) {
                        if (i >= rVar.f19853g.size()) {
                            i = 0;
                            break;
                        } else if (rVar.f19853g.get(i) != null && rVar.f19849c == rVar.f19853g.get(i).sort_type.intValue()) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    l(rVar.f19853g, i);
                }
                this.f35000h.setVisibility(0);
            }
            if (this.u) {
                this.f35000h.getLayoutParams().height = n.f(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
            } else {
                this.f35000h.getLayoutParams().height = 0;
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            }
            if (rVar.f19851e) {
                this.m.setVisibility(0);
                this.k.setVisibility(8);
            } else {
                this.m.setVisibility(8);
                this.k.setVisibility(0);
            }
            m(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f34996d.setSelected(true);
                this.f34995c.setSelected(false);
                return;
            }
            this.f34996d.setSelected(false);
            this.f34995c.setSelected(true);
        }
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34994b : (View) invokeV.objValue;
    }

    public void l(List<PbSortType> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i) == null) {
            if (ListUtils.isEmpty(list)) {
                this.f34997e.setVisibility(8);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (PbSortType pbSortType : list) {
                c.a.p0.a4.k0.r rVar = new c.a.p0.a4.k0.r();
                rVar.c(pbSortType.sort_type.intValue());
                rVar.d(pbSortType.sort_name);
                arrayList.add(rVar);
            }
            this.f34997e.setVisibility(0);
            this.f34997e.setData(arrayList, i);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
                SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
                this.f34995c.b(i);
                this.f34996d.b(i);
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
                r rVar = this.q;
                if (rVar != null && rVar.f19848b == r.i) {
                    SkinManager.setViewTextColor(this.f34995c, R.color.CAM_X0107, 1);
                }
                SkinManager.setViewTextColor(this.f34998f, (int) R.color.CAM_X0107);
                this.f34998f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gob_reply_jump), (Drawable) null);
                this.f34997e.H();
                SkinManager.setBackgroundColor(this.f34999g, R.color.CAM_X0204);
                if (this.u) {
                    SkinManager.setBackgroundColor(this.f35000h, R.color.CAM_X0203);
                    SkinManager.setBackgroundColor(this.l, R.color.CAM_X0207);
                } else {
                    SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
                }
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
            }
            this.a = i;
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.s = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            MessageManager.getInstance().unRegisterListener(bdUniqueId);
            this.x.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    public void p(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.p = fVar;
        }
    }

    public void q(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void r(BdUniqueId bdUniqueId) {
        SortSwitchButton sortSwitchButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) || (sortSwitchButton = this.f34997e) == null) {
            return;
        }
        sortSwitchButton.setListenerTag(bdUniqueId);
        this.f34997e.setCommenId(bdUniqueId);
    }

    public void s(int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (view = this.f34994b) == null) {
            return;
        }
        view.setVisibility(i);
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.m.setText(R.string.obfuscated_res_0x7f0f085d);
                this.m.setTypeface(Typeface.defaultFromStyle(1));
                this.m.setTextSize(0, n.f(this.t.getPageActivity(), R.dimen.T_X07));
                this.m.setVisibility(0);
                this.k.setVisibility(8);
                return;
            }
            this.m.setVisibility(8);
            this.k.setVisibility(0);
            this.m.setTypeface(Typeface.defaultFromStyle(0));
            this.m.setTextSize(0, n.f(this.t.getPageActivity(), R.dimen.tbfontsize42));
        }
    }
}
