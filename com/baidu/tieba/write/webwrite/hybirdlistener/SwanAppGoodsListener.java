package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.ResponsedEventListener;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.a0b;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.hza;
import com.baidu.tieba.iza;
import com.baidu.tieba.jg;
import com.baidu.tieba.lza;
import com.baidu.tieba.s45;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.SwanAppGoodsListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0011\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014H\u0016J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0002J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018H\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\"\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020$H\u0002J\u0015\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010(R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006)"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/SwanAppGoodsListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Clean;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "count", "", "mOnProtocolStateListener", "Lcom/baidu/tieba/view/EBusinessProtocolView$OnProtocolStateListener;", "mSwanAppReturnProductDateListener", "com/baidu/tieba/write/webwrite/hybirdlistener/SwanAppGoodsListener$mSwanAppReturnProductDateListener$1", "Lcom/baidu/tieba/write/webwrite/hybirdlistener/SwanAppGoodsListener$mSwanAppReturnProductDateListener$1;", "addDraftData", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "jumpAiApps", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", MissionEvent.MESSAGE_DESTROY, "openGoodsPage", "id", "data", "", "", "openGoodsProtocol", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SwanAppGoodsListener extends BizBase implements lza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public final a h;
    public final EBusinessProtocolView.f i;

    @Override // com.baidu.tieba.write.webwrite.data.BizBase, com.baidu.tieba.kza
    public Function1<JSONObject, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (Function1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kza
    public iza[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (iza[]) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a extends ResponsedEventListener<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppGoodsListener a;

        public a(SwanAppGoodsListener swanAppGoodsListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppGoodsListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppGoodsListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.ResponsedEventListener, com.baidu.tieba.lp5
        /* renamed from: g */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                goodsEvent.setDispost(true);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dispose", goodsEvent.getDispose());
                JSONArray jSONArray = new JSONArray(goodsEvent.getGoodsList());
                this.a.g = jSONArray.length();
                jSONObject.put("goodsList", jSONArray);
                this.a.g().invoke("writePageNa.addGoodsResult", jSONObject);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppGoodsListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, a0b writePageState) {
        super(context, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView, writeData, writePageState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (a0b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        this.h = new a(this);
        this.i = new EBusinessProtocolView.f() { // from class: com.baidu.tieba.i0b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.view.EBusinessProtocolView.f
            public final void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    SwanAppGoodsListener.w(SwanAppGoodsListener.this, z);
                }
            }
        };
        this.h.setPriority(1);
        MutiProcessManager.getInstance().registerResponsedEventListener(GoodsEvent.class, this.h, i());
    }

    public static final void A(s45 dialog, SwanAppGoodsListener this$0, int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, dialog, this$0, i, view2) == null) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dialog.dismiss();
            SharedPrefHelper.getInstance().putBoolean("commodity_goods_show_first_dialog", true);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2).param("fid", this$0.k().getForumId()).param("fname", this$0.k().getForumName()));
            this$0.v(i);
        }
    }

    public static final void w(SwanAppGoodsListener this$0, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, null, this$0, z) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isAgreed", z);
            this$0.g().invoke("writePageNa.openGoodsProtocol", jSONObject);
        }
    }

    public final void y(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, obj) == null) {
            x(this.g);
        }
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(i().getPageActivity(), EBusinessProtocolView.WindowType.PROTOCOL);
            eBusinessProtocolView.n(i().getPageActivity().getString(R.string.obfuscated_res_0x7f0f116f));
            eBusinessProtocolView.i("file:///android_asset/protocol.html");
            eBusinessProtocolView.l(this.i);
            jg.i(eBusinessProtocolView, i().getPageActivity());
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + (10 - i)));
        }
    }

    @Override // com.baidu.tieba.kza
    public hza[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new hza[]{n(59, new SwanAppGoodsListener$editorActionHandlers$1(this))} : (hza[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lza
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MutiProcessManager.getInstance().unRegisterResponsedEventListener(this.h);
        }
    }

    @Override // com.baidu.tieba.kza
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new WrapListener[]{h().invoke("writePage.openGoodsPage", new SwanAppGoodsListener$keyListeners$1(this)), h().invoke("writePage.openGoodsProtocol", new SwanAppGoodsListener$keyListeners$2(this)), h().invoke("writePage.updateGoodsProtocol", SwanAppGoodsListener$keyListeners$3.INSTANCE)} : (WrapListener[]) invokeV.objValue;
    }

    public final void x(final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (!k().isCanGoods()) {
                BdToast.makeText(i().getPageActivity(), i().getString(R.string.post_goods_tip)).setIcon(BdToast.ToastIcon.FAILURE).show();
                return;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", k().getForumId()).param("fname", k().getForumName()));
            if (!SharedPrefHelper.getInstance().getBoolean("commodity_goods_show_first_dialog", false)) {
                final s45 s45Var = new s45(i().getPageActivity());
                s45Var.setContentViewSize(2);
                s45Var.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(i().getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.g0b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            SwanAppGoodsListener.A(s45.this, this, i, view2);
                        }
                    }
                });
                s45Var.setContentView(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2).param("fid", k().getForumId()).param("fname", k().getForumName()));
                s45Var.create(i()).show();
                return;
            }
            v(i);
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            x(new JSONObject(str).optInt("count", 0));
        }
    }
}
