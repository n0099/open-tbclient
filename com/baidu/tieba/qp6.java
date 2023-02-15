package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.forumMember.bawu.BawuManagerApplyInfoView;
import com.baidu.tieba.forumMember.bawu.BawuMemberInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class qp6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ArrayList<rp6> b;
    public hq6 c;
    public int d;
    public int e;
    public d f;

    /* loaded from: classes6.dex */
    public interface d {
        void a(String str);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qp6 a;

        public a(qp6 qp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null) {
                this.a.f.a(this.a.c.a());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qp6 a;

        public b(qp6 qp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null) {
                this.a.f.a(this.a.c.a());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public c(qp6 qp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp6Var};
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

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public BawuMemberInfoView b;
        public BawuMemberInfoView c;
        public BawuManagerApplyInfoView d;
        public BawuManagerApplyInfoView e;

        public e(qp6 qp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp6Var};
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

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public f(qp6 qp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp6Var};
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

    public qp6(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
        this.e = 0;
        this.a = tbPageContext;
        this.b = new ArrayList<>();
        this.d = ej.g(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.e = ej.g(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public rp6 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<rp6> arrayList = this.b;
            if (arrayList != null && i < arrayList.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return (rp6) invokeI.objValue;
    }

    public void d(ArrayList<rp6> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.b = arrayList;
        }
    }

    public void e(hq6 hq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hq6Var) == null) {
            this.c = hq6Var;
        }
    }

    public void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.f = dVar;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return getItem(i).a();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<rp6> arrayList = this.b;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        e eVar;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 0) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0147, viewGroup, false);
                    fVar = new f(this);
                    fVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09229f);
                    view2.setTag(fVar);
                }
                fVar.a.setText(((lp6) getItem(i)).b());
                p15.d(view2).f(R.color.CAM_X0204);
                this.a.getLayoutMode().k(view2);
            } else if (getItemViewType(i) == 1) {
                if (view2 != null && (view2.getTag() instanceof e)) {
                    eVar = (e) view2.getTag();
                    eVar.b.setVisibility(0);
                    eVar.c.setVisibility(8);
                    eVar.d.setVisibility(8);
                    eVar.e.setVisibility(8);
                } else {
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0146, viewGroup, false);
                    eVar = new e(this);
                    eVar.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090358);
                    eVar.b = (BawuMemberInfoView) view2.findViewById(R.id.obfuscated_res_0x7f0913cb);
                    eVar.c = (BawuMemberInfoView) view2.findViewById(R.id.obfuscated_res_0x7f091d60);
                    eVar.d = (BawuManagerApplyInfoView) view2.findViewById(R.id.obfuscated_res_0x7f0913ca);
                    eVar.e = (BawuManagerApplyInfoView) view2.findViewById(R.id.obfuscated_res_0x7f091d5f);
                    view2.setTag(eVar);
                }
                kp6 kp6Var = (kp6) getItem(i);
                if (kp6Var != null && kp6Var.c() != null && kp6Var.c().size() > 0) {
                    if (kp6Var.e() && kp6Var.b()) {
                        RelativeLayout relativeLayout = eVar.a;
                        int i2 = this.d;
                        relativeLayout.setPadding(i2, 0, i2, this.e);
                        hq6 hq6Var = this.c;
                        if (hq6Var != null && !hq6Var.c()) {
                            if (kp6Var.c().size() == 2) {
                                if (kp6Var.d().equals(this.a.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                    eVar.e.setVisibility(8);
                                    eVar.d.setVisibility(8);
                                } else if (kp6Var.d().equals(this.a.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                    eVar.e.setVisibility(8);
                                    eVar.d.setVisibility(0);
                                    eVar.d.a(this.a.getResources().getString(R.string.tip_assist_apply), this.c.b());
                                    eVar.d.setOnClickListener(new a(this));
                                }
                            } else if (kp6Var.d().equals(this.a.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                eVar.c.setVisibility(8);
                                eVar.e.setVisibility(8);
                                eVar.d.setVisibility(8);
                            } else if (kp6Var.d().equals(this.a.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                eVar.c.setVisibility(8);
                                eVar.e.setVisibility(0);
                                eVar.d.setVisibility(8);
                                eVar.e.a(this.a.getResources().getString(R.string.tip_assist_apply), this.c.b());
                                eVar.e.setOnClickListener(new b(this));
                            }
                        }
                    } else {
                        RelativeLayout relativeLayout2 = eVar.a;
                        int i3 = this.d;
                        relativeLayout2.setPadding(i3, 0, i3, 0);
                        eVar.d.setVisibility(8);
                        eVar.e.setVisibility(8);
                    }
                    eVar.b.c(kp6Var.c().get(0));
                    if (kp6Var.c().size() >= 2) {
                        eVar.c.c(kp6Var.c().get(1));
                        eVar.c.setVisibility(0);
                    } else {
                        eVar.c.setVisibility(8);
                    }
                    p15.d(view2).f(R.color.CAM_X0201);
                    this.a.getLayoutMode().k(view2);
                }
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof c)) {
                    c cVar = (c) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0145, viewGroup, false);
                    c cVar2 = new c(this);
                    cVar2.a = view2.findViewById(R.id.obfuscated_res_0x7f090878);
                    view2.setTag(cVar2);
                }
                p15.d(view2).f(R.color.CAM_X0204);
                this.a.getLayoutMode().k(view2);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
