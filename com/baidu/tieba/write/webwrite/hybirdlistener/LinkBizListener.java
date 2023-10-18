package com.baidu.tieba.write.webwrite.hybirdlistener;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.spanGroup.RequestUrlParserNetMessage;
import com.baidu.tbadk.core.view.spanGroup.UrlParserHttpResponseMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.cya;
import com.baidu.tieba.dya;
import com.baidu.tieba.gl6;
import com.baidu.tieba.gya;
import com.baidu.tieba.k0b;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.xya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.CardLinkInfo;
import tbclient.UrlParser.DataRes;
import tbclient.UrlParser.UrlParserResIdl;
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0013H\u0016¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020 H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/LinkBizListener;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Clean;", "context", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "mUrlParserListener", "Lcom/baidu/adp/framework/listener/NetMessageListener;", "addLink", "", "data", "Landroid/content/Intent;", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", MissionEvent.MESSAGE_DESTROY, "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "startAddLink", "id", "", "", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class LinkBizListener extends BizBase implements gya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NetMessageListener g;

    /* loaded from: classes8.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinkBizListener a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LinkBizListener linkBizListener) {
            super(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, 309686);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linkBizListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linkBizListener;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UrlParserResIdl urlParserResIdl;
            Object obj;
            Integer num;
            DataRes dataRes;
            Message<?> orginalMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                String str = null;
                if (responsedMessage instanceof UrlParserHttpResponseMessage) {
                    urlParserResIdl = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData();
                } else {
                    urlParserResIdl = null;
                }
                if (responsedMessage != null && (orginalMessage = responsedMessage.getOrginalMessage()) != null) {
                    obj = orginalMessage.getExtra();
                } else {
                    obj = null;
                }
                if (obj instanceof RequestUrlParserNetMessage) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra != null) {
                        RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) extra;
                        str = requestUrlParserNetMessage.getUrl();
                        num = Integer.valueOf(requestUrlParserNetMessage.getLinkNum());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.view.spanGroup.RequestUrlParserNetMessage");
                    }
                } else {
                    num = null;
                }
                if (urlParserResIdl != null && (dataRes = urlParserResIdl.data) != null) {
                    LinkBizListener linkBizListener = this.a;
                    JSONObject jSONObject = new JSONObject();
                    gl6.a(jSONObject, "originUrl", str);
                    gl6.a(jSONObject, "linkNum", num);
                    gl6.a(jSONObject, "url_type", dataRes.url_type);
                    gl6.a(jSONObject, "status", dataRes.status);
                    gl6.a(jSONObject, "image", dataRes.image);
                    gl6.a(jSONObject, "link_from", dataRes.link_from);
                    gl6.a(jSONObject, "title", dataRes.title);
                    gl6.a(jSONObject, "price_txt", dataRes.price_txt);
                    gl6.a(jSONObject, "is_recognize", dataRes.is_recognize);
                    gl6.a(jSONObject, "description", dataRes.description);
                    CardLinkInfo card_link_info = dataRes.card_link_info;
                    if (card_link_info != null) {
                        Intrinsics.checkNotNullExpressionValue(card_link_info, "card_link_info");
                        JSONObject jSONObject2 = new JSONObject();
                        gl6.a(jSONObject2, "type", card_link_info.type);
                        gl6.a(jSONObject2, "image_url", card_link_info.image_url);
                        gl6.a(jSONObject2, "tag_text", card_link_info.tag_text);
                        gl6.a(jSONObject2, "tag_color", card_link_info.tag_color);
                        gl6.a(jSONObject2, "title", card_link_info.title);
                        gl6.a(jSONObject2, GameGuideConfigInfo.KEY_CONTENT1, card_link_info.content1);
                        gl6.a(jSONObject2, GameGuideConfigInfo.KEY_CONTENT2, card_link_info.content2);
                        gl6.a(jSONObject2, "btn_style", card_link_info.btn_style);
                        gl6.a(jSONObject2, "btn_text", card_link_info.btn_text);
                        gl6.a(jSONObject2, "text_btn_status", card_link_info.text_btn_status);
                        gl6.a(jSONObject2, "url", card_link_info.url);
                        gl6.a(jSONObject, "card_link_info", jSONObject2);
                    }
                    linkBizListener.g().invoke("writePageNa.parseLinkResult", jSONObject);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkBizListener(TbPageContext<?> context, TbWebView webView, WriteData writeData, xya writePageState) {
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
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (xya) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        this.g = new a(this);
        MessageManager.getInstance().registerListener(this.g);
    }

    @Override // com.baidu.tieba.fya
    public cya[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new cya[]{n(21, new LinkBizListener$editorActionHandlers$1(this))} : (cya[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WrapListener[]{h().invoke("writePage.parseLink", new Function1<String, Unit>(this) { // from class: com.baidu.tieba.write.webwrite.hybirdlistener.LinkBizListener$keyListeners$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LinkBizListener this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String data) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    try {
                        JSONObject jSONObject = new JSONObject(data);
                        RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
                        requestUrlParserNetMessage.setTag(this.this$0.i().getUniqueId());
                        requestUrlParserNetMessage.setParams(jSONObject.optLong("forum_id"), jSONObject.optInt("link_num"), jSONObject.optString("url"), 0);
                        MessageManager.getInstance().sendMessage(requestUrlParserNetMessage);
                    } catch (Exception unused) {
                        this.this$0.g().invoke("writePageNa.parseLinkResult", new JSONObject());
                    }
                }
            }
        })} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public dya[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new dya[]{o(25049, new LinkBizListener$requestCodeHandlers$1(this))} : (dya[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gya
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public final void t(Intent intent) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, intent) != null) || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT);
        if (stringExtra != null && stringExtra.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        String newLink = stringExtra + WebvttCueParser.CHAR_SPACE;
        JSONObject jSONObject = new JSONObject();
        Intrinsics.checkNotNullExpressionValue(newLink, "newLink");
        gl6.a(jSONObject, "link", newLink);
        g().invoke("writePageNa.addLinkResult", jSONObject);
    }

    public final void u(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, obj) == null) {
            l().o();
            k0b.b(i().getPageActivity(), 5);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(i().getPageActivity(), 25049, "", true, null)));
        }
    }
}
