package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ShareFriendTitleData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.write.transmit.ShareFriendActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class tta extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public ShareFriendActivity c;
    public List<MetaData> d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948194120, "Lcom/baidu/tieba/tta;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948194120, "Lcom/baidu/tieba/tta;");
        }
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

    /* loaded from: classes8.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public a(tta ttaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ttaVar};
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

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public HeadImageView b;
        public TextView c;

        public b(tta ttaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ttaVar};
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

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public c(tta ttaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ttaVar};
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

    public tta(ShareFriendActivity shareFriendActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shareFriendActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.d = new ArrayList();
        this.c = shareFriendActivity;
        this.a = shareFriendActivity.getPageContext().getContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public MetaData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<MetaData> list = this.d;
            if (list == null || i >= list.size()) {
                return null;
            }
            return this.d.get(i);
        }
        return (MetaData) invokeI.objValue;
    }

    public void b(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.d.clear();
            this.d.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (e != i) {
                notifyDataSetChanged();
            }
            e = i;
        }
    }

    public void d(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.d = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return getItem(i).getItemType();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<MetaData> list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        String avater;
        String name_show;
        a aVar;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (this.b == null) {
                this.b = viewGroup;
            }
            if (getItemViewType(i) == 0) {
                if (view2 != null && (view2.getTag() instanceof c)) {
                    cVar = (c) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08a8, (ViewGroup) null);
                    cVar = new c(this);
                    cVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09219a);
                    cVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090322);
                    view2.setTag(cVar);
                }
                cVar.a.setText(((ShareFriendTitleData) getItem(i)).getTitle());
                EMManager.from(cVar.a).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107);
                EMManager.from(cVar.b).setBackGroundColor(R.color.CAM_X0201);
            } else if (getItemViewType(i) != 3 && getItemViewType(i) != 1) {
                if (view2 != null && (view2.getTag() instanceof a)) {
                    aVar = (a) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08a6, (ViewGroup) null);
                    aVar = new a(this);
                    aVar.a = view2.findViewById(R.id.obfuscated_res_0x7f090edc);
                    view2.setTag(aVar);
                }
                EMManager.from(aVar.a).setBackGroundColor(R.color.CAM_X0204);
            } else {
                MetaData item = getItem(i);
                if (view2 != null && (view2.getTag() instanceof b)) {
                    bVar = (b) view2.getTag();
                } else {
                    view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08a5, (ViewGroup) null);
                    b bVar2 = new b(this);
                    bVar2.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0921a4);
                    bVar2.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0921b5);
                    bVar2.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09219a);
                    view2.setTag(bVar2);
                    bVar = bVar2;
                }
                bVar.b.setIsRound(true);
                if (getItemViewType(i) == 1) {
                    UtilHelper.showHeadImageViewBigVForStranger(bVar.b, item);
                } else {
                    UtilHelper.showHeadImageViewFocusBigV(bVar.b, item);
                }
                GroupInfoData groupInfoData = item.groupData;
                if (groupInfoData != null) {
                    avater = groupInfoData.getPortrait();
                } else {
                    avater = item.getAvater();
                }
                bVar.b.setTag(avater);
                bVar.b.startLoad(avater, 12, false);
                TextView textView = bVar.c;
                GroupInfoData groupInfoData2 = item.groupData;
                if (groupInfoData2 != null) {
                    name_show = groupInfoData2.getName();
                } else {
                    name_show = item.getName_show();
                }
                textView.setText(name_show);
                EMManager.from(bVar.a).setCorner(R.string.J_X02).setBackGroundColor(R.color.CAM_X0201);
                EMManager.from(bVar.c).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            }
            notifyDataSetChanged();
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
