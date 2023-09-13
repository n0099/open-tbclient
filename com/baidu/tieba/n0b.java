package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class n0b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static int c = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<TransmitForumData> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947950057, "Lcom/baidu/tieba/n0b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947950057, "Lcom/baidu/tieba/n0b;");
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public BarImageView b;
        public View c;
        public int d;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = 3;
            if (view2 == null) {
                return;
            }
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926f0);
            BarImageView barImageView = (BarImageView) view2.findViewById(R.id.forum_avatar);
            this.b = barImageView;
            barImageView.setShowOval(true);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090905);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (n0b.c != this.d) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
                }
                this.d = n0b.c;
            }
        }

        public void b(TransmitForumData transmitForumData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transmitForumData) == null) && transmitForumData != null) {
                this.a.setText(transmitForumData.forumName);
                this.b.startLoad(transmitForumData.avatar, 10, false);
            }
        }
    }

    public n0b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public void b(List<TransmitForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (c != i) {
                notifyDataSetChanged();
            }
            c = i;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            a aVar = null;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d059f, (ViewGroup) null);
                aVar = new a(view2);
                view2.setTag(R.id.obfuscated_res_0x7f091264, aVar);
            } else {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091264);
                if (tag instanceof a) {
                    aVar = (a) tag;
                }
            }
            if (aVar != null) {
                aVar.a();
                aVar.b(this.b.get(i));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
