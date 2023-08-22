package com.baidu.tieba.newfaceshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.ax4;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.dn5;
import com.baidu.tieba.ed9;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.h9;
import com.baidu.tieba.hd9;
import com.baidu.tieba.i47;
import com.baidu.tieba.id9;
import com.baidu.tieba.k47;
import com.baidu.tieba.kd9;
import com.baidu.tieba.n37;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.rd9;
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.x37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NewFaceShopActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public String b;
    public TbWebView c;
    public RelativeLayout d;
    public View e;
    public TbPageContext<NewFaceShopActivity> f;
    public LoadingView g;
    public dn5 h;
    public boolean i;
    public String j;
    public NewFaceGroupDownloadModel k;
    public NewFaceGroupShareModel l;
    public Handler m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public CustomMessageListener q;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public a(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public b(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f = hd9.i().f();
                if (f == null || f.isEmpty()) {
                    this.a.loadUrl("javascript:__js_bridge_emoticon_has_action()");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (MyEmotionGroupData myEmotionGroupData : f) {
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        sb.append(",");
                    }
                }
                NewFaceShopActivity newFaceShopActivity = this.a;
                newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ NewFaceShopActivity b;

        public c(NewFaceShopActivity newFaceShopActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFaceShopActivity;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.c != null) {
                this.b.c.loadUrl(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ NewFaceShopActivity b;

        public d(NewFaceShopActivity newFaceShopActivity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFaceShopActivity;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hd9.i().j(new ArrayList(Arrays.asList(this.a.optString("id").split(","))), true);
                this.b.loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements kd9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public e(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // com.baidu.tieba.kd9
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
        }

        @Override // com.baidu.tieba.kd9
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i > 0 && i < 100) {
                NewFaceShopActivity newFaceShopActivity = this.a;
                newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_down_process_action(" + i + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        @Override // com.baidu.tieba.kd9
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.loadUrl("javascript:__js_bridge_emoticon_down_process_action(100)");
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ NewFaceShopActivity b;

        public f(NewFaceShopActivity newFaceShopActivity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFaceShopActivity;
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.a.optString("id").split(",")));
                boolean c = hd9.i().c(arrayList, true);
                for (String str : arrayList) {
                    n37.o().k(str);
                }
                if (c) {
                    this.b.loadUrl("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    this.b.loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ NewFaceShopActivity b;

        public g(NewFaceShopActivity newFaceShopActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newFaceShopActivity;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(NewFaceShopActivity newFaceShopActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i)};
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
            this.a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = null;
                if (hashMap != null && !hashMap.isEmpty()) {
                    if (hashMap.containsKey("upload_result")) {
                        if (hashMap.get("upload_result") != null && (hashMap.get("upload_result") instanceof Boolean)) {
                            if (!((Boolean) hashMap.get("upload_result")).booleanValue()) {
                                if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                                    str = (String) hashMap.get("upload_msg");
                                }
                                this.a.K1(0, str);
                                return;
                            }
                            this.a.K1(1, null);
                            return;
                        }
                        this.a.K1(0, null);
                        return;
                    }
                    this.a.K1(0, null);
                    return;
                }
                this.a.K1(0, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(NewFaceShopActivity newFaceShopActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i)};
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
            this.a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(NewFaceShopActivity newFaceShopActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i)};
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
            this.a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof LikeReturnData) && ((LikeReturnData) customResponsedMessage.getData()).isLike() == 1) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(NewFaceShopActivity newFaceShopActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i)};
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
            this.a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof EmotionPackageData)) {
                EmotionPackageData emotionPackageData = (EmotionPackageData) customResponsedMessage.getData();
                if (emotionPackageData.has_vote == 0 && emotionPackageData.id > 0) {
                    NewFaceShopActivity newFaceShopActivity = this.a;
                    newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public l(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements k47 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public m(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // com.baidu.tieba.k47
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), 25021)));
            }
        }

        @Override // com.baidu.tieba.k47
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), true, 25021)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends h9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LikeModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NewFaceShopActivity c;

        public n(NewFaceShopActivity newFaceShopActivity, LikeModel likeModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, likeModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = newFaceShopActivity;
            this.a = likeModel;
            this.b = str;
        }

        @Override // com.baidu.tieba.h9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    this.c.showToast(R.string.unfollow_title);
                    this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                    AntiHelper.u(this.c.getPageContext().getPageActivity(), this.a.getErrorString());
                } else if (this.a.getErrorCode() != 0) {
                    this.c.showToast(this.a.getErrorString());
                    this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                } else {
                    LikeReturnData likeReturnData = (LikeReturnData) obj;
                    if (likeReturnData != null) {
                        TbadkApplication.getInst().addLikeForum(this.b);
                        likeReturnData.setLike(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, likeReturnData));
                        this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
                        return;
                    }
                    NewFaceShopActivity newFaceShopActivity = this.c;
                    newFaceShopActivity.showToast(newFaceShopActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e29));
                    this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements kd9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        @Override // com.baidu.tieba.kd9
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public o(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // com.baidu.tieba.kd9
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.loadUrl("javascript:__js_bridge_emoticon_save_action(0)");
        }

        @Override // com.baidu.tieba.kd9
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.loadUrl("javascript:__js_bridge_emoticon_save_action(1)");
        }
    }

    /* loaded from: classes7.dex */
    public class p implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public p(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                this.a.loadUrl("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public q(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                this.a.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

        public r(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newFaceShopActivity;
        }

        public /* synthetic */ r(NewFaceShopActivity newFaceShopActivity, i iVar) {
            this(newFaceShopActivity);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.H1();
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.X1();
                    this.a.i = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                ax4.a("NewFaceShopActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.V1();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.W1();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isNull(str)) {
                    if (!this.a.M1(str)) {
                        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.a.getPageContext(), new String[]{str});
                        if (dealOneLinkWithOutJumpWebView == 1) {
                            this.a.finish();
                            return true;
                        } else if (dealOneLinkWithOutJumpWebView == 0) {
                        }
                    }
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    public NewFaceShopActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = TbConfig.TIEBA_ADDRESS + "n/interact/emoticoncenter";
        this.n = new i(this, 2921054);
        this.o = new j(this, 2001266);
        this.p = new k(this, 2921062);
        this.q = new h(this, 2921040);
    }

    public final void N1() {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && !TextUtils.isEmpty(this.j) && this.j.contains("emoticonpackage") && (split = this.j.split("/")) != null && split.length > 0) {
            String str = split[split.length - 1];
            if (this.l == null) {
                this.l = new NewFaceGroupShareModel();
            }
            this.l.N(str);
        }
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e29);
            if (this.h == null) {
                dn5 dn5Var = new dn5(this.f.getPageActivity(), new l(this));
                this.h = dn5Var;
                dn5Var.onChangeSkinType();
            }
            TbWebView tbWebView = this.c;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
            }
            this.h.l(string);
            this.h.attachView(this.e, false);
            this.h.o();
            this.h.j(this.f.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b0));
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.e = findViewById(R.id.root_layout);
            this.d = (RelativeLayout) findViewById(R.id.webview_container);
            TbWebView tbWebView = new TbWebView(getPageContext().getPageActivity());
            this.c = tbWebView;
            tbWebView.setWebViewClient(new r(this, null));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (isUseStyleImmersiveSticky()) {
                layoutParams.topMargin = BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
            }
            this.d.addView(this.c, layoutParams);
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (rd9.l().r()) {
                J1(1, null);
            } else if (rd9.l().k() == null) {
                J1(0, null);
            } else {
                FaceGroupDraft k2 = rd9.l().k();
                if (!TextUtils.isEmpty(k2.getFailMsg())) {
                    J1(2, k2.getFailMsg());
                } else {
                    J1(2, null);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i2, keyEvent)) == null) {
            if (i2 == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void G1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getActivity(), jSONObject.optInt("id"), 25024)));
        }
    }

    public final void R1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                hd9.i().d(optString, new o(this));
            }
        }
    }

    public final void Y1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) {
            String optString = jSONObject.optString("content");
            if (!TextUtils.isEmpty(optString)) {
                showToast(optString);
            }
        }
    }

    public final void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && this.c != null) {
            this.m.post(new c(this, str));
        }
    }

    public final void A1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("pck_id");
            x37 t = x37.t();
            String str = "";
            if (optInt != -1) {
                str = "" + optInt;
            }
            t.g(optString, str);
            loadUrl("javascript:__js_bridge_emoticon_coll_action(2)");
        }
    }

    public final void B1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (id9.o().q()) {
                loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                BdUtilHelper.showToast(this.f.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f06fd);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
            ed9.b().a(new f(this, jSONObject));
        }
    }

    public final JSONObject F1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!str.contains("data=")) {
                return null;
            }
            try {
                return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void P1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, jSONObject) == null) {
            if (id9.o().q()) {
                loadUrl("javascript:__js_bridge_emoticon_sort_action()");
                BdUtilHelper.showToast(this.f.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f06fd);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
            ed9.b().a(new d(this, jSONObject));
        }
    }

    public final void C1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        if (id9.o().q()) {
            loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
            BdUtilHelper.showToast(this.f.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f06fd);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
        String optString = jSONObject.optString("id");
        if (this.k == null) {
            this.k = new NewFaceGroupDownloadModel();
        }
        this.k.N(optString, Boolean.TRUE, new e(this));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.m = new Handler(Looper.getMainLooper());
            this.f = getPageContext();
            String stringExtra = getIntent().getStringExtra("url");
            this.b = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.b = this.a;
            }
            setContentView(R.layout.obfuscated_res_0x7f0d06fc);
            initView();
            BrowserHelper.initCookie(getApplicationContext());
            loadUrl(this.b);
            registerListener(this.n);
            registerListener(this.o);
            registerListener(this.p);
        }
    }

    public final void y1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            LikeModel likeModel = new LikeModel(getPageContext());
            likeModel.setFrom("emotion_center_follow");
            likeModel.setLoadDataCallBack(new n(this, likeModel, optString2));
            likeModel.f0(optString2, String.valueOf(optString));
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ed9.b().a(new b(this));
        }
    }

    public void H1() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (loadingView = this.g) != null) {
            loadingView.dettachView(this.e);
            this.g = null;
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i47 i47Var = new i47(getPageContext().getPageActivity(), 1);
            i47Var.d(new m(this));
            i47Var.showAtLocation(this.e, 81, 0, 0);
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.c == null) {
            return;
        }
        if (this.i) {
            loadUrl("javascript:window.reload_page()");
        } else {
            loadUrl(this.b);
        }
    }

    public void V1() {
        TbPageContext<NewFaceShopActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (tbPageContext = this.f) != null && this.e != null) {
            LoadingView loadingView = new LoadingView(tbPageContext.getPageActivity());
            this.g = loadingView;
            loadingView.attachView(this.e, false);
            this.g.onChangeSkinType();
        }
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            dn5 dn5Var = this.h;
            if (dn5Var != null) {
                dn5Var.dettachView(this.e);
                this.h = null;
            }
            TbWebView tbWebView = this.c;
            if (tbWebView != null) {
                tbWebView.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onBackPressed();
            webViewGoBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.k;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
            NewFaceGroupShareModel newFaceGroupShareModel = this.l;
            if (newFaceGroupShareModel != null) {
                newFaceGroupShareModel.cancelLoadData();
            }
            this.c.onDestroy();
            this.c = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.q);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onResume();
            registerListener(this.q);
            z1();
        }
    }

    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            TbWebView tbWebView = this.c;
            if (tbWebView == null || !tbWebView.q()) {
                return false;
            }
            this.c.C();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f.getPageActivity(), 25021)));
    }

    public final void J1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
                return;
            }
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
        }
    }

    public final void K1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
                return;
            }
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
        }
    }

    public final boolean M1(String str) {
        InterceptResult invokeL;
        JSONObject F1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if ((!str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) || (F1 = F1(str)) == null) {
                return false;
            }
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                C1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                B1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                S1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                E1();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                U1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                Y1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                P1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                A1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                R1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                G1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                I1();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                L1();
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                y1(F1);
                return true;
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                z1();
                return true;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void S1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            ShareItem shareItem = new ShareItem();
            shareItem.title = jSONObject.optString("title");
            shareItem.content = jSONObject.optString("content");
            shareItem.linkUrl = jSONObject.optString(GameAssistConstKt.KEY_LINKURL);
            shareItem.imageUri = Uri.parse(jSONObject.optString("imageUri"));
            this.j = shareItem.linkUrl;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new g(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public final void U1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("pos");
            String optString3 = jSONObject.optString("neg");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
            s45 s45Var = new s45(getPageContext().getPageActivity());
            s45Var.setMessage(optString);
            s45Var.setPositiveButton(optString2, new p(this));
            s45Var.setNegativeButton(optString3, new q(this));
            s45Var.setOnCalcelListener(new a(this));
            s45Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048600, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 != 24007) {
                    if (i2 != 25021) {
                        if (i2 == 25024) {
                            loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
                            return;
                        }
                        return;
                    } else if (intent != null && intent.getBooleanExtra(DownloadStatisticConstants.UBC_PAGE_UPLOADING, false)) {
                        J1(1, null);
                        return;
                    } else {
                        return;
                    }
                }
                N1();
            }
        }
    }
}
