package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes6.dex */
public class yp5 extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<Integer> d;
    public static HashMap<b, Integer> e;
    public static HashMap<b, Integer> f;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFriendsActivity a;
    public List<h97> b;
    public c c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass() && this.a == ((b) obj).a;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 31 + (this.a ? 1231 : 1237);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(int i, int i2, View view2, h97 h97Var);
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public TextView d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(h97 h97Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h97Var) == null) {
                boolean z = false;
                this.a.K(h97Var.e(), 12, false);
                this.b.setText(h97Var.d());
                if (!TextUtils.isEmpty(h97Var.a())) {
                    this.c.setText(h97Var.a());
                } else {
                    this.c.setText("");
                }
                int f = h97Var.f();
                this.d.setText(((Integer) yp5.d.get(f)).intValue());
                this.d.setEnabled((f == 0 || f == 1) ? true : true);
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948337867, "Lcom/baidu/tieba/yp5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948337867, "Lcom/baidu/tieba/yp5;");
                return;
            }
        }
        d = new SparseArray<>();
        e = new HashMap<>();
        f = new HashMap<>();
        d.put(0, Integer.valueOf((int) R.string.obfuscated_res_0x7f0f00ba));
        d.put(4, Integer.valueOf((int) R.string.obfuscated_res_0x7f0f00d9));
        d.put(1, Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0d50));
        d.put(2, Integer.valueOf((int) R.string.obfuscated_res_0x7f0f0d7e));
        d.put(3, Integer.valueOf((int) R.string.obfuscated_res_0x7f0f15b5));
        e.put(new b(false), Integer.valueOf((int) R.drawable.btn_pass));
        e.put(new b(true), Integer.valueOf((int) R.drawable.btn_all_blue));
        f.put(new b(false), Integer.valueOf((int) R.color.btn_pass_text_color));
        f.put(new b(true), Integer.valueOf((int) R.color.btn_agree_text_color));
    }

    public yp5(NewFriendsActivity newFriendsActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = newFriendsActivity;
    }

    public final int b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            List<h97> list = this.b;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (j == this.b.get(i).b()) {
                        return i;
                    }
                }
                return -1;
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public h97 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.b.get(i) : (h97) invokeI.objValue;
    }

    public synchronized void d(h97 h97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h97Var) == null) {
            synchronized (this) {
                if (this.b != null) {
                    this.b.remove(h97Var);
                }
            }
        }
    }

    public void e(List<h97> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b = list;
        }
    }

    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.c = cVar;
        }
    }

    public void g(h97 h97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, h97Var) == null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (h97Var == null || h97Var.b() == 0) {
                return;
            }
            int b2 = b(h97Var.b());
            if (b2 != -1) {
                this.b.remove(b2);
                this.b.add(0, h97Var);
                return;
            }
            this.b.add(0, h97Var);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<h97> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof d)) {
                dVar = (d) view2.getTag();
            } else {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0078, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ad8);
                dVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ada);
                dVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ad9);
                dVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ad6);
                view2.setTag(dVar);
            }
            h97 item = getItem(i);
            dVar.a(item);
            dVar.d.setTag(Integer.valueOf(i));
            dVar.d.setOnClickListener(this);
            this.a.getLayoutMode().l(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().k(view2);
            Integer num = e.get(new b(item.f() == 1));
            if (num != null) {
                SkinManager.setBackgroundResource(dVar.d, num.intValue());
            }
            Integer num2 = f.get(new b(item.f() == 1));
            if (num2 != null) {
                SkinManager.setViewTextColor(dVar.d, num2.intValue(), 1);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<h97> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (list != null) {
                for (h97 h97Var : list) {
                    g(h97Var);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view2) == null) || this.c == null) {
            return;
        }
        int id = view2.getId();
        int intValue = ((Integer) view2.getTag()).intValue();
        this.c.a(id, intValue, view2, getItem(intValue));
    }
}
