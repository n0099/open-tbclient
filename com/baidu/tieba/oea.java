package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class oea extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashSet<String> a;
    public ArrayList<mea> b;
    public CoverFlowView<mea> c;
    public t75<mea> d;
    public TbPageContext<?> e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a implements t75<mea> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oea a;

        public a(oea oeaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oeaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oeaVar;
        }

        @Override // com.baidu.tieba.t75
        public void b(int i, String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                String makeStatisticsParam = SingleSquareActivityConfig.makeStatisticsParam("carousel_recommend", String.valueOf(i));
                mea meaVar = (mea) ListUtils.getItem(this.a.b, i);
                if (meaVar != null) {
                    str2 = meaVar.a();
                } else {
                    str2 = null;
                }
                if (UrlManager.getInstance().dealOneLink(this.a.e, new String[]{str, null, makeStatisticsParam}) && i == 2 && !TextUtils.isEmpty(str2)) {
                    TiebaStatic.eventStat(this.a.e.getPageActivity(), "tbanner", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "CLICK", DownloadStatisticConstants.UBC_VALUE_TASK, "tbanner", "obj_id", String.valueOf(str2), "obj_name", String.valueOf(str2), "obj_cpid", 0, TiebaStatic.Params.OBJ_URL, str, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), TtsLogLoad.KEY_OS, "android", HttpConstants.OS_VERSION, DeviceInfoHelper.getOsVersion(), "log_ver", "1.1");
                }
                TiebaStatic.eventStat(this.a.e.getPageActivity(), "square_banner_picture", "click", 1, "loc", (i - 1) + "");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.t75
        /* renamed from: c */
        public void a(int i, mea meaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, meaVar) != null) || meaVar == null) {
                return;
            }
            String a = meaVar.a();
            if (i == 2 && !TextUtils.isEmpty(a) && this.a.a.add(a)) {
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getBaseContext(), "ad_tpoint", null, 1, "line", "PT", "page", "OT", "locate", "c0116", "action_type", "VIEW_TRUE", DownloadStatisticConstants.UBC_VALUE_TASK, "tbanner", "obj_id", String.valueOf(a), "obj_name", String.valueOf(a), "obj_cpid", 0, "obj_good_id", 0, "obj_throw_type", "BY_POST", "client_type", "MOBILE_APP", "user_timestamp", String.valueOf(System.currentTimeMillis()), TtsLogLoad.KEY_OS, "android", HttpConstants.OS_VERSION, DeviceInfoHelper.getOsVersion());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends r75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        public b(oea oeaVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oeaVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.r75, com.baidu.tieba.p75
        public s75 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s75 a = super.a();
                if (a != null) {
                    a.d(85);
                    a.e(R.dimen.obfuscated_res_0x7f0701d5);
                    a.f(R.dimen.obfuscated_res_0x7f070201);
                }
                return a;
            }
            return (s75) invokeV.objValue;
        }

        @Override // com.baidu.tieba.r75, com.baidu.tieba.p75
        public v75 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                v75 v75Var = new v75();
                v75Var.a(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c4));
                return v75Var;
            }
            return (v75) invokeV.objValue;
        }
    }

    public oea(TbPageContext<?> tbPageContext) {
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
        this.a = new HashSet<>();
        this.b = new ArrayList<>();
        this.c = null;
        this.d = new a(this);
        this.e = tbPageContext;
        this.c = new CoverFlowView<>(tbPageContext.getPageActivity());
        this.c.setCoverFlowFactory(new b(this, tbPageContext));
        this.c.setCallback(this.d);
    }

    public void e(int i) {
        CoverFlowView<mea> coverFlowView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (coverFlowView = this.c) != null) {
            coverFlowView.v();
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return Integer.valueOf(i);
        }
        return invokeI.objValue;
    }

    public CoverFlowView<mea> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (CoverFlowView) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<mea> arrayList = this.b;
            if (arrayList != null) {
                i = arrayList.size() + 0;
            } else {
                i = 0;
            }
            if (i <= 0) {
                return 0;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void f(ArrayList<e45> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            ArrayList<mea> arrayList2 = new ArrayList<>();
            Iterator<e45> it = arrayList.iterator();
            while (it.hasNext()) {
                e45 next = it.next();
                if (next != null) {
                    arrayList2.add(new mea(next));
                }
            }
            this.b = arrayList2;
            this.c.setData(arrayList2);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            return this.c;
        }
        return (View) invokeILL.objValue;
    }
}
