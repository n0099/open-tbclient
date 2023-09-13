package com.baidu.tieba.write.webwrite.hybirdlistener;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.k2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.si5;
import com.baidu.tieba.t1b;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.x1b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\r\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0012H\u0002J\u0015\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006("}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/ItemSelectListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Clean;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "mItemSelectedListener", "com/baidu/tieba/write/webwrite/hybirdlistener/ItemSelectListener$mItemSelectedListener$1", "Lcom/baidu/tieba/write/webwrite/hybirdlistener/ItemSelectListener$mItemSelectedListener$1;", "addDraftData", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "", "deleteItem", "data", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", MissionEvent.MESSAGE_DESTROY, "onEditorAction", "action", "Lcom/baidu/tbadk/editortools/Action;", "openItemSelectPage", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "sendItemDataToH5", "msg", "Lcom/baidu/tbadk/core/message/EvaluateRelevanceItemSelectedMessage;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ItemSelectListener extends BizBase implements t1b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> g;
    public final a h;

    @Override // com.baidu.tieba.write.webwrite.data.BizBase, com.baidu.tieba.s1b
    public Function1<JSONObject, Unit> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (Function1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public q1b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (q1b[]) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ItemSelectListener a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ItemSelectListener itemSelectListener) {
            super(2921516);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemSelectListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itemSelectListener;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg instanceof EvaluateRelevanceItemSelectedMessage) {
                    this.a.w((EvaluateRelevanceItemSelectedMessage) msg);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemSelectListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, k2b writePageState) {
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
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (k2b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        this.g = context;
        this.h = new a(this);
        MessageManager.getInstance().registerListener(this.h);
    }

    @Override // com.baidu.tieba.s1b
    public p1b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new p1b[]{new x1b(new Integer[]{61}, new ItemSelectListener$editorActionHandlers$1(this))} : (p1b[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new WrapListener[]{h().invoke("writePage.deleteItemData", new ItemSelectListener$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t1b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public final void t(String str) {
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            long optLong = new JSONObject(str).optLong("id", 0L);
            if (!ListUtils.isEmpty(k().getItemDatas())) {
                Iterator<ItemData> it = k().getItemDatas().iterator();
                while (true) {
                    if (it.hasNext()) {
                        itemData = it.next();
                        if (itemData.itemId == optLong) {
                            break;
                        }
                    } else {
                        itemData = null;
                        break;
                    }
                }
                if (itemData != null) {
                    k().removeItemData(itemData);
                }
            }
        }
    }

    public final void u(si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, si5Var) == null) {
            if (si5Var.a == 61) {
                v();
                return;
            }
            throw new IllegalStateException("ItemSelectListener有没处理的action code:" + si5Var.a);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            DefaultLog.getInstance().i("write", "收到H5通知，打开关联item选择页");
            if (!k().canAddItem()) {
                BdUtilHelper.showToast(this.g.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f190d);
                return;
            }
            RelevanceItemSearchActivityConfig relevanceItemSearchActivityConfig = new RelevanceItemSearchActivityConfig(this.g.getPageActivity(), 0);
            relevanceItemSearchActivityConfig.setSelectedIds(k().getItemDataIds());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, relevanceItemSearchActivityConfig));
        }
    }

    public final void w(EvaluateRelevanceItemSelectedMessage msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msg) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("item_id", msg.item_id);
            jSONObject.put("item_name", msg.item_name);
            jSONObject.put("icon_url", msg.icon_url);
            jSONObject.put("score", msg.score);
            jSONObject.put("icon_size", msg.icon_size);
            jSONObject.put("star", msg.star);
            jSONObject.put(TaskProcess.keyTags, new JSONArray((Collection) msg.tags));
            g().invoke("writePageNa.addItemResult", jSONObject);
            ItemData itemData = new ItemData();
            itemData.itemId = JavaTypesHelper.toLong(msg.item_id, 0L);
            itemData.mTags = msg.tags;
            itemData.mScore = msg.score;
            itemData.mStar = msg.star;
            itemData.mIconUrl = msg.icon_url;
            itemData.mIconSize = msg.icon_size;
            itemData.mTitle = msg.item_name;
            k().addItemData(itemData);
        }
    }
}
