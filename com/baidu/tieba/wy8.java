package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class wy8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<yy8> a;
    public TbPageContext<?> b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public View c;
        public View d;

        public a() {
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
    }

    public wy8(TbPageContext<?> tbPageContext) {
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
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public yy8 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<yy8> list = this.a;
            if (list != null && list.size() > 0 && i >= 0 && i < this.a.size()) {
                return this.a.get(i);
            }
            return null;
        }
        return (yy8) invokeI.objValue;
    }

    public void b(List<yy8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<yy8> list = this.a;
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
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            yy8 item = getItem(i);
            if (view2 != null) {
                aVar = (a) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0244, viewGroup, false);
                aVar = new a();
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09088e);
                aVar.a = headImageView;
                headImageView.setDefaultResource(R.drawable.img_default_100);
                aVar.a.setDefaultBgResource(R.color.CAM_X0204);
                aVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09088d);
                aVar.c = view2.findViewById(R.id.obfuscated_res_0x7f0922d0);
                aVar.d = view2.findViewById(R.id.obfuscated_res_0x7f090840);
                view2.setTag(aVar);
            }
            if (item != null) {
                aVar.a.K(item.a(), 10, false);
                aVar.b.setText(item.b());
                ry4 l = ry4.l();
                if (item.c() - l.n("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.getType(), 0L) > 0) {
                    aVar.c.setVisibility(0);
                } else {
                    aVar.c.setVisibility(4);
                }
                if (i == getCount() - 1) {
                    aVar.d.setVisibility(8);
                } else {
                    aVar.d.setVisibility(0);
                }
            }
            this.b.getLayoutMode().k(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
