package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.AutoHeightListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tieba.aib;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oib extends fjb<pjb> implements hjb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String g;
    @Nullable
    public FrsTabItemData h;
    @Nullable
    public AutoHeightListView i;
    @Nullable
    public aib j;
    public final aib.f k;
    public final ResponsedEventListener<GoodsEvent> l;
    public CustomMessageListener m;

    @Override // com.baidu.tieba.kjb
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.kjb
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.kjb
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements aib.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oib a;

        public a(oib oibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oibVar;
        }

        @Override // com.baidu.tieba.aib.f
        public void a(List<fx4> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                ((pjb) this.a.d).a = 3;
                ((pjb) this.a.d).e = list;
                oib oibVar = this.a;
                oibVar.y(oibVar.d);
            }
        }

        @Override // com.baidu.tieba.aib.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ((pjb) this.a.d).a = 2;
                ((pjb) this.a.d).d = i;
                oib oibVar = this.a;
                oibVar.y(oibVar.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponsedEventListener<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oib a;

        public b(oib oibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oibVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.om5
        /* renamed from: g */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.a.j0(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                if (this.a.b != null) {
                    this.a.b.w();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oib a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(oib oibVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oibVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oibVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e != null && this.a.e.isCanGoods()) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.e.getForumId()).param("fname", this.a.e.getForumName()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oib a;

        public d(oib oibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oibVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.j != null && (this.a.j.getItem(i) instanceof fx4)) {
                fx4 fx4Var = (fx4) this.a.j.getItem(i);
                int i2 = fx4Var.b;
                if (i2 == 1) {
                    int i3 = fx4Var.o;
                    if (i3 != 1 && i3 != 5) {
                        UrlManager urlManager = UrlManager.getInstance();
                        TbPageContext<?> tbPageContext = this.a.a;
                        urlManager.dealOneLink(tbPageContext, new String[]{cs4.a + rd.getUrlEncode(fx4Var.g)});
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{fx4Var.g});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(fx4Var.j)) {
                        if (fx4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, fx4Var.j));
                            return;
                        }
                        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(fx4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent) && this.a.a.getPageActivity() != null) {
                            this.a.a.getPageActivity().startActivity(intent);
                        } else if (!TextUtils.isEmpty(fx4Var.k)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<?> tbPageContext2 = this.a.a;
                            urlManager2.dealOneLink(tbPageContext2, new String[]{cs4.a + rd.getUrlEncode(fx4Var.k)});
                        }
                    } else if (!TextUtils.isEmpty(fx4Var.k)) {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<?> tbPageContext3 = this.a.a;
                        urlManager3.dealOneLink(tbPageContext3, new String[]{cs4.a + rd.getUrlEncode(fx4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f05 a;
        public final /* synthetic */ oib b;

        public e(oib oibVar, f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oibVar, f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oibVar;
            this.a = f05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                SharedPrefHelper.getInstance().putBoolean("commodity_goods_show_first_dialog", true);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
                String str2 = "";
                if (this.b.e == null) {
                    str = "";
                } else {
                    str = this.b.e.getForumId();
                }
                StatisticItem param2 = param.param("fid", str);
                if (this.b.e != null) {
                    str2 = this.b.e.getForumName();
                }
                TiebaStatic.log(param2.param("fname", str2));
                this.b.g0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oib(TbPageContext<?> tbPageContext) {
        super(tbPageContext, pjb.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this, 2921494);
    }

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public void j(@NonNull mjb mjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, mjbVar) == null) {
            super.j(mjbVar);
            this.a.registerListener(this.m);
            this.l.setPriority(1);
            MutiProcessManager.getInstance().registerResponsedEventListener(GoodsEvent.class, this.l, this.a);
            j0(this.g);
        }
    }

    @Override // com.baidu.tieba.kjb
    public void onChangeSkinType(int i) {
        aib aibVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (aibVar = this.j) != null) {
            aibVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.hjb
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, obj) == null) && (obj instanceof ujb)) {
            this.h = ((ujb) obj).b;
        }
    }

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public void r(he5 he5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, he5Var) == null) {
            super.r(he5Var);
            if (he5Var.a == 59) {
                i0();
            }
        }
    }

    public final boolean b0() {
        InterceptResult invokeV;
        mjb mjbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.e;
            if ((writeData != null && writeData.isCanGoods()) || (mjbVar = this.b) == null || mjbVar.h() <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            mjb mjbVar = this.b;
            if (mjbVar == null) {
                return 0;
            }
            return 10 - mjbVar.h();
        }
        return invokeV.intValue;
    }

    public final void f0() {
        AutoHeightListView autoHeightListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (autoHeightListView = this.i) != null) {
            autoHeightListView.setAdapter((ListAdapter) this.j);
            this.i.setOnItemClickListener(new d(this));
        }
    }

    public void k0() {
        LinkedList<fx4> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h0();
            D d3 = this.d;
            ((pjb) d3).a = 3;
            pjb pjbVar = (pjb) d3;
            aib aibVar = this.j;
            if (aibVar == null) {
                d2 = null;
            } else {
                d2 = aibVar.d();
            }
            pjbVar.e = d2;
            y(this.d);
        }
    }

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            aib aibVar = this.j;
            if (aibVar != null && aibVar.getCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WriteData writeData = this.e;
            if (writeData != null && writeData.getFrsTabInfoData() != null && !ListUtils.isEmpty(this.e.getFrsTabInfoData().tabList)) {
                for (FrsTabItemData frsTabItemData : this.e.getFrsTabInfoData().tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0() {
        aib aibVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.i != null && (aibVar = this.j) != null && this.b != null) {
            if (aibVar.f() == null) {
                this.j.i(this.b.E());
            }
            this.j.h();
            if (this.j.getCount() == 0) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!b0()) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.toast_cant_but_commodity));
                return false;
            }
            if (c0()) {
                int d0 = d0();
                if (d0 == 1) {
                    TbPageContext<?> tbPageContext2 = this.a;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.toast_no_commodity));
                    return false;
                } else if (d0 == 2) {
                    TbPageContext<?> tbPageContext3 = this.a;
                    tbPageContext3.showToast(tbPageContext3.getString(R.string.toast_no_haowu_tab));
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int d0() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            aib aibVar = this.j;
            if (aibVar != null && !aibVar.e()) {
                z = false;
            } else {
                z = true;
            }
            FrsTabItemData frsTabItemData = this.h;
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                return 1;
            }
            if (z || z2) {
                return 0;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public final void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + e0()));
        }
    }

    public final void i0() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.e == null) {
            return;
        }
        if (!c0()) {
            BdToast.makeText(this.a.getPageActivity(), this.a.getString(R.string.post_goods_no_tab_tip)).setIcon(BdToast.ToastIcon.FAILURE).show();
        } else if (!this.e.isCanGoods()) {
            BdToast.makeText(this.a.getPageActivity(), this.a.getString(R.string.post_goods_tip)).setIcon(BdToast.ToastIcon.FAILURE).show();
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.e.getForumId()).param("fname", this.e.getForumName()));
            if (!SharedPrefHelper.getInstance().getBoolean("commodity_goods_show_first_dialog", false)) {
                f05 f05Var = new f05(this.a.getPageActivity());
                f05Var.setContentViewSize(2);
                f05Var.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new e(this, f05Var));
                f05Var.setContentView(frsPublishFineGoodsDialogView);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                WriteData writeData = this.e;
                String str2 = "";
                if (writeData == null) {
                    str = "";
                } else {
                    str = writeData.getForumId();
                }
                StatisticItem param2 = param.param("fid", str);
                WriteData writeData2 = this.e;
                if (writeData2 != null) {
                    str2 = writeData2.getForumName();
                }
                TiebaStatic.log(param2.param("fname", str2));
                f05Var.create(this.a).show();
                return;
            }
            g0();
        }
    }

    public final void j0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            ((pjb) this.d).b = new ArrayList();
            ((pjb) this.d).c = new ArrayList();
            if (!StringUtils.isNull(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        ((pjb) this.d).c.add(string);
                        ((pjb) this.d).b.add(da8.g(jSONObject));
                    }
                    if (((pjb) this.d).b.size() > 0) {
                        ((pjb) this.d).a = 1;
                        y(this.d);
                        h0();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            if (intent != null) {
                this.g = intent.getStringExtra(WriteActivityConfig.GOODS_LIST);
            }
        }
    }

    @Override // com.baidu.tieba.fjb, com.baidu.tieba.kjb
    public void q(@NonNull List<kjb<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.q(list);
            for (kjb<?> kjbVar : list) {
                if (kjbVar instanceof pib) {
                    w((pib) kjbVar);
                } else if (kjbVar instanceof wib) {
                    w((wib) kjbVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.kjb
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0542, viewGroup, false);
            this.c = inflate;
            this.i = (AutoHeightListView) inflate.findViewById(R.id.obfuscated_res_0x7f0907bb);
            aib aibVar = new aib(this.a);
            this.j = aibVar;
            aibVar.j(this.k);
            f0();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
