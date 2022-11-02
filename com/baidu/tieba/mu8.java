package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tieba.lu8;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class mu8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public AvatarPendantActivity a;
    public List<ju8> b;
    public ku8 c;
    public lu8.a d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947985273, "Lcom/baidu/tieba/mu8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947985273, "Lcom/baidu/tieba/mu8;");
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public WholeDisplayGridView b;
        public View c;

        public b(mu8 mu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(mu8 mu8Var, a aVar) {
            this(mu8Var);
        }
    }

    public mu8(AvatarPendantActivity avatarPendantActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ju8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<ju8> list = this.b;
            if (list != null && list.size() > 0 && i >= 0 && i < getCount()) {
                return this.b.get(i);
            }
            return null;
        }
        return (ju8) invokeI.objValue;
    }

    public void b(lu8.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.d = aVar;
        }
    }

    public void c(List<ju8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<ju8> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.obfuscated_res_0x7f0d012c, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905c5);
                bVar.b = (WholeDisplayGridView) view2.findViewById(R.id.obfuscated_res_0x7f09031c);
                bVar.c = view2.findViewById(R.id.obfuscated_res_0x7f09133f);
                view2.setTag(bVar);
            }
            ju8 item = getItem(i);
            if (StringUtils.isNull(item.a())) {
                bVar.a.setVisibility(8);
            } else {
                bVar.a.setVisibility(0);
                bVar.a.setText(wi.cutString(item.a(), e));
            }
            if (item != null && !ListUtils.isEmpty(item.b())) {
                ku8 ku8Var = new ku8(this.a);
                this.c = ku8Var;
                ku8Var.d(item.b());
                bVar.b.setAdapter((ListAdapter) this.c);
                this.c.c(this.d);
            }
            if (i == getCount() - 1) {
                bVar.c.setVisibility(8);
            } else {
                bVar.c.setVisibility(0);
            }
            SkinManager.setBackgroundColor(bVar.c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(bVar.a, (int) R.color.CAM_X0109);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
