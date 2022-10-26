package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class q39 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public AtListActivity b;
    public ArrayList c;
    public TbCheckBox.b d;
    public c e;
    public ViewGroup f;
    public boolean g;

    /* loaded from: classes5.dex */
    public interface c {
        void r0(View view2, MetaData metaData);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ q39 b;

        public a(q39 q39Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q39Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q39Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.b.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.b.getPageContext().getPageActivity(), this.a.getUserId(), this.a.getUserName())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public LinearLayout b;
        public HeadImageView c;
        public TextView d;
        public TbCheckBox e;
        public TextView f;

        public b(q39 q39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(q39 q39Var, a aVar) {
            this(q39Var);
        }
    }

    public q39(AtListActivity atListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = null;
        this.g = true;
        this.b = atListActivity;
        this.a = atListActivity.getPageContext().getContext();
        this.g = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public MetaData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ArrayList arrayList = this.c;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return (MetaData) this.c.get(i);
        }
        return (MetaData) invokeI.objValue;
    }

    public void e(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void f(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public final b b(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = c(metaData);
            } else {
                bVar = (b) obj;
            }
            bVar.b.setOnClickListener(new a(this, metaData));
            c cVar = this.e;
            if (cVar != null) {
                cVar.r0(bVar.a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.d.setText(metaData.getName_show());
            boolean z = true;
            if (metaData.getIsNearlyAt() == 1) {
                bVar.f.setVisibility(0);
                bVar.f.setText("最近@过");
            } else if (metaData.getIsFollower() == 1) {
                bVar.f.setVisibility(0);
                bVar.f.setText("互相关注");
            } else if (metaData.getIsMyFollower() == 1) {
                bVar.f.setVisibility(0);
                bVar.f.setText("我的关注");
            } else {
                bVar.f.setVisibility(8);
            }
            bVar.e.setTagData(metaData);
            bVar.c.setTag(avater);
            if (this.g) {
                bVar.e.setVisibility(0);
            } else {
                bVar.e.setVisibility(8);
            }
            bVar.c.L(avater, 12, false);
            UtilHelper.showHeadImageViewBigV(bVar.c, metaData);
            zp4 layoutMode = this.b.getPageContext().getLayoutMode();
            if (skinType != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.b.getPageContext().getLayoutMode().k(bVar.a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b c(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03e3, (ViewGroup) null);
            bVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0919ba);
            bVar.c = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.c, metaData);
            bVar.b = (LinearLayout) bVar.a.findViewById(R.id.obfuscated_res_0x7f0919bb);
            bVar.d = (TextView) bVar.a.findViewById(R.id.obfuscated_res_0x7f092430);
            TextView textView = (TextView) bVar.a.findViewById(R.id.obfuscated_res_0x7f091246);
            bVar.f = textView;
            nv4 d = nv4.d(textView);
            d.v(R.color.CAM_X0108);
            d.z(R.dimen.T_X10);
            d.n(R.string.J_X04);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0111);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.a.findViewById(R.id.obfuscated_res_0x7f09064a);
            bVar.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.e.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f0809f9, R.drawable.obfuscated_res_0x7f0809f8);
            TbCheckBox.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar.e.setStatedChangedListener(bVar2);
            }
            bVar.a.setTag(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            if (this.f == null) {
                this.f = viewGroup;
            }
            MetaData item = getItem(i);
            if (item != null) {
                if (view2 != null) {
                    obj = view2.getTag();
                } else {
                    obj = null;
                }
                bVar = b(obj, item);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return null;
            }
            return bVar.a;
        }
        return (View) invokeILL.objValue;
    }
}
