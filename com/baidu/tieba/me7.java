package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.forumMember.bawu.BawuManagerApplyInfoView;
import com.baidu.tieba.forumMember.bawu.BawuMemberInfoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class me7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ArrayList<ne7> b;
    public df7 c;
    public int d;
    public int e;
    public d f;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me7 a;

        public a(me7 me7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = me7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null) {
                this.a.f.a(this.a.c.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me7 a;

        public b(me7 me7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = me7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f != null) {
                this.a.f.a(this.a.c.a());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public c(me7 me7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me7Var};
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
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RelativeLayout a;
        public BawuMemberInfoView b;
        public BawuMemberInfoView c;
        public BawuManagerApplyInfoView d;
        public BawuManagerApplyInfoView e;

        public e(me7 me7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me7Var};
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
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public f(me7 me7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me7Var};
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

    public me7(TbPageContext<?> tbPageContext) {
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
        this.d = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds31);
        this.e = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public ne7 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            ArrayList<ne7> arrayList = this.b;
            if (arrayList != null && i < arrayList.size()) {
                return this.b.get(i);
            }
            return null;
        }
        return (ne7) invokeI.objValue;
    }

    public void d(ArrayList<ne7> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.b = arrayList;
        }
    }

    public void e(df7 df7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, df7Var) == null) {
            this.c = df7Var;
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
            ArrayList<ne7> arrayList = this.b;
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
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0152, viewGroup, false);
                    fVar = new f(this);
                    fVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924d0);
                    view2.setTag(fVar);
                }
                fVar.a.setText(((he7) getItem(i)).b());
                EMManager.from(view2).setBackGroundColor(R.color.CAM_X0204);
                this.a.getLayoutMode().onModeChanged(view2);
            } else if (getItemViewType(i) == 1) {
                if (view2 != null && (view2.getTag() instanceof e)) {
                    eVar = (e) view2.getTag();
                    eVar.b.setVisibility(0);
                    eVar.c.setVisibility(8);
                    eVar.d.setVisibility(8);
                    eVar.e.setVisibility(8);
                } else {
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0151, viewGroup, false);
                    eVar = new e(this);
                    eVar.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090368);
                    eVar.b = (BawuMemberInfoView) view2.findViewById(R.id.obfuscated_res_0x7f0914f7);
                    eVar.c = (BawuMemberInfoView) view2.findViewById(R.id.obfuscated_res_0x7f091f4d);
                    eVar.d = (BawuManagerApplyInfoView) view2.findViewById(R.id.obfuscated_res_0x7f0914f6);
                    eVar.e = (BawuManagerApplyInfoView) view2.findViewById(R.id.obfuscated_res_0x7f091f4c);
                    view2.setTag(eVar);
                }
                ge7 ge7Var = (ge7) getItem(i);
                if (ge7Var != null && ge7Var.c() != null && ge7Var.c().size() > 0) {
                    if (ge7Var.e() && ge7Var.b()) {
                        RelativeLayout relativeLayout = eVar.a;
                        int i2 = this.d;
                        relativeLayout.setPadding(i2, 0, i2, this.e);
                        df7 df7Var = this.c;
                        if (df7Var != null && !df7Var.c()) {
                            if (ge7Var.c().size() == 2) {
                                if (ge7Var.d().equals(this.a.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                    eVar.e.setVisibility(8);
                                    eVar.d.setVisibility(8);
                                } else if (ge7Var.d().equals(this.a.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
                                    eVar.e.setVisibility(8);
                                    eVar.d.setVisibility(0);
                                    eVar.d.a(this.a.getResources().getString(R.string.tip_assist_apply), this.c.b());
                                    eVar.d.setOnClickListener(new a(this));
                                }
                            } else if (ge7Var.d().equals(this.a.getResources().getString(R.string.bawu_member_bazhu_tip))) {
                                eVar.c.setVisibility(8);
                                eVar.e.setVisibility(8);
                                eVar.d.setVisibility(8);
                            } else if (ge7Var.d().equals(this.a.getResources().getString(R.string.bawu_member_xbazhu_tip))) {
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
                    eVar.b.c(ge7Var.c().get(0));
                    if (ge7Var.c().size() >= 2) {
                        eVar.c.c(ge7Var.c().get(1));
                        eVar.c.setVisibility(0);
                    } else {
                        eVar.c.setVisibility(8);
                    }
                    EMManager.from(view2).setBackGroundColor(R.color.CAM_X0201);
                    this.a.getLayoutMode().onModeChanged(view2);
                }
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof c)) {
                    c cVar = (c) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0150, viewGroup, false);
                    c cVar2 = new c(this);
                    cVar2.a = view2.findViewById(R.id.obfuscated_res_0x7f090923);
                    view2.setTag(cVar2);
                }
                EMManager.from(view2).setBackGroundColor(R.color.CAM_X0204);
                this.a.getLayoutMode().onModeChanged(view2);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
