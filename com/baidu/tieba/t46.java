package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class t46 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public boolean b;
    public List<AccountData> c;
    public View.OnClickListener d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public ImageView c;
        public TextView d;

        public b(t46 t46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(t46 t46Var, a aVar) {
            this(t46Var);
        }
    }

    public t46(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseActivity;
        this.c = null;
        this.b = false;
        this.d = onClickListener;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<AccountData> list = this.c;
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            return i + 1;
        }
        return invokeV.intValue;
    }

    public void b(List<AccountData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.c = list;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.b = z;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<AccountData> list = this.c;
            if (list != null && i >= 0 && i < list.size()) {
                return this.c.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (getItem(i) != null) {
                return i;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (getItemId(i) >= 0) {
                return 0;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            try {
                try {
                    if (view2 == null) {
                        if (getItemViewType(i) == 0) {
                            view2 = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0022, viewGroup, false);
                            bVar = new b(this, null);
                            bVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090062);
                            bVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090082);
                            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090877);
                            bVar.d = textView;
                            EMManager.from(textView).setTextColor(R.color.CAM_X0105);
                            bVar.d.setOnClickListener(this.d);
                            view2.setTag(bVar);
                            EMManager.from(bVar.a).setTextColor(R.color.CAM_X0105);
                            SkinManager.setBackgroundResource(bVar.c, R.drawable.icon_set_list_ok_s);
                        } else {
                            view2 = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0020, viewGroup, false);
                            bVar = new b(this, null);
                            bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09013f);
                            view2.setTag(bVar);
                            EMManager.from(bVar.b).setTextColor(R.color.CAM_X0302);
                        }
                    } else {
                        bVar = (b) view2.getTag();
                    }
                    if (getItemViewType(i) == 0) {
                        AccountData accountData = (AccountData) getItem(i);
                        bVar.c.setVisibility(8);
                        bVar.d.setVisibility(8);
                        bVar.d.setTag(accountData);
                        if (accountData != null) {
                            bVar.a.setText(accountData.getAccountNameShow());
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                bVar.c.setVisibility(0);
                            }
                            if (this.b) {
                                bVar.d.setVisibility(0);
                            }
                        }
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
                return view2;
            } finally {
                EMManager.from(view2).setBackGroundColor(R.color.CAM_X0205);
            }
        }
        return (View) invokeILL.objValue;
    }
}
