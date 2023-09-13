package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.content.Intent;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.k2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0016¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u001fH\u0002J,\u0010 \u001a\u00020\u00102\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020#\u0018\u00010\"j\n\u0012\u0004\u0012\u00020#\u0018\u0001`$2\u0006\u0010%\u001a\u00020\u001fH\u0002J\"\u0010&\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0016H\u0016¢\u0006\u0002\u0010+R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006,"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/AtSelectListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "editor", "Lcom/baidu/tbadk/editortools/EditorTools;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;Lcom/baidu/tbadk/editortools/EditorTools;)V", "getEditor", "()Lcom/baidu/tbadk/editortools/EditorTools;", "doAtSelect", "", "id", "", "data", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "onResult", "Landroid/content/Intent;", "onTriggerAt", "", "openSelectAtActivity", "atSelectList", "Ljava/util/ArrayList;", "Lcom/baidu/tbadk/data/AtSelectData;", "Lkotlin/collections/ArrayList;", "refer", "paresAtList", "atSelectArray", "Lorg/json/JSONArray;", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AtSelectListener extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtSelectListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, k2b writePageState, EditorTools editor) {
        super(context, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, webView, writeData, writePageState, editor};
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
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.g = editor;
    }

    public final void u(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, obj) == null) {
            if (m()) {
                i().showToast((int) R.string.over_limit_tip);
            } else {
                g().invoke("writePageNa.clickEditorAt", new JSONObject());
            }
        }
    }

    @Override // com.baidu.tieba.s1b
    public p1b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new p1b[]{n(16, new AtSelectListener$editorActionHandlers$1(this))} : (p1b[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WrapListener[]{h().invoke("writePage.addAt", new AtSelectListener$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s1b
    public q1b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new q1b[]{o(12004, new AtSelectListener$requestCodeHandlers$1(this))} : (q1b[]) invokeV.objValue;
    }

    public final void v(Intent intent) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            String str = null;
            if (intent != null) {
                arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
            } else {
                arrayList = null;
            }
            if (intent != null) {
                str = intent.getStringExtra(AtListActivityConfig.AT_SELECT_REFER_STRING);
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((AtSelectData) it.next()).toJson());
                }
            }
            jSONObject.put("at_select_list", jSONArray);
            jSONObject.put("refer", str);
            g().invoke("writePageNa.addAtResult", jSONObject);
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("at_select_list");
            String refer = jSONObject.optString("refer");
            ArrayList<AtSelectData> y = y(optJSONArray);
            Intrinsics.checkNotNullExpressionValue(refer, "refer");
            x(y, refer);
        }
    }

    public final void x(ArrayList<AtSelectData> arrayList, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, str) == null) {
            this.g.t();
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(i().getPageActivity(), 12004, true);
            atListActivityConfig.setSelectedAtList(arrayList);
            atListActivityConfig.addRefer(str);
            i().sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final ArrayList<AtSelectData> y(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONArray)) == null) {
            ArrayList<AtSelectData> arrayList = new ArrayList<>();
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "atSelectArray.getJSONObject(i)");
                    AtSelectData atSelectData = new AtSelectData();
                    atSelectData.parseJson(jSONObject);
                    arrayList.add(atSelectData);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }
}
