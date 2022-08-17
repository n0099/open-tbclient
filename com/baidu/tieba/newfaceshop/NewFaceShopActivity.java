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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab6;
import com.repackage.bk8;
import com.repackage.c9;
import com.repackage.dp7;
import com.repackage.fi;
import com.repackage.g65;
import com.repackage.gp7;
import com.repackage.h65;
import com.repackage.hp7;
import com.repackage.jm4;
import com.repackage.jp7;
import com.repackage.lb6;
import com.repackage.nb6;
import com.repackage.oi;
import com.repackage.qa6;
import com.repackage.qi;
import com.repackage.qp7;
import com.repackage.rm4;
import com.repackage.ur4;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NewFaceShopActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BaseWebView b;
    public RelativeLayout c;
    public View d;
    public TbPageContext<NewFaceShopActivity> e;
    public g65 f;
    public h65 g;
    public boolean h;
    public String i;
    public NewFaceGroupDownloadModel j;
    public NewFaceGroupShareModel k;
    public Handler l;
    public CustomMessageListener m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                List<MyEmotionGroupData> f = gp7.i().f();
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.b == null) {
                return;
            }
            this.b.b.loadUrl(this.a);
        }
    }

    /* loaded from: classes3.dex */
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
                gp7.i().j(new ArrayList(Arrays.asList(this.a.optString("id").split(","))), true);
                this.b.loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements jp7 {
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

        @Override // com.repackage.jp7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
            }
        }

        @Override // com.repackage.jp7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || i <= 0 || i >= 100) {
                return;
            }
            NewFaceShopActivity newFaceShopActivity = this.a;
            newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_down_process_action(" + i + SmallTailInfo.EMOTION_SUFFIX);
        }

        @Override // com.repackage.jp7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_down_process_action(100)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                boolean c = gp7.i().c(arrayList, true);
                for (String str : arrayList) {
                    qa6.o().k(str);
                }
                if (c) {
                    this.b.loadUrl("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    this.b.loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                fi.a(this.a.w);
                qi.N(this.b.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0450));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (hashMap == null || hashMap.isEmpty()) {
                    this.a.Q1(0, null);
                } else if (!hashMap.containsKey("upload_result")) {
                    this.a.Q1(0, null);
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    this.a.Q1(0, null);
                } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    this.a.Q1(1, null);
                } else {
                    if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                        str = (String) hashMap.get("upload_msg");
                    }
                    this.a.Q1(0, str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bk8) && ((bk8) customResponsedMessage.getData()).m() == 1) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (emotionPackageData.has_vote != 0 || emotionPackageData.id <= 0) {
                    return;
                }
                NewFaceShopActivity newFaceShopActivity = this.a;
                newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.V1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements nb6 {
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

        @Override // com.repackage.nb6
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), 25021)));
            }
        }

        @Override // com.repackage.nb6
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.a.getPageContext().getPageActivity(), true, 25021)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.getErrorCode() == 22) {
                    this.c.showToast(R.string.obfuscated_res_0x7f0f14a0);
                    this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                } else if (AntiHelper.m(this.a.getErrorCode(), this.a.getErrorString())) {
                    AntiHelper.u(this.c.getPageContext().getPageActivity(), this.a.getErrorString());
                } else if (this.a.getErrorCode() != 0) {
                    this.c.showToast(this.a.getErrorString());
                    this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                } else {
                    bk8 bk8Var = (bk8) obj;
                    if (bk8Var != null) {
                        TbadkApplication.getInst().addLikeForum(this.b);
                        bk8Var.x(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, bk8Var));
                        this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
                        return;
                    }
                    NewFaceShopActivity newFaceShopActivity = this.c;
                    newFaceShopActivity.showToast(newFaceShopActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c3d));
                    this.c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements jp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewFaceShopActivity a;

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

        @Override // com.repackage.jp7
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_save_action(0)");
            }
        }

        @Override // com.repackage.jp7
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        @Override // com.repackage.jp7
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.loadUrl("javascript:__js_bridge_emoticon_save_action(1)");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                this.a.loadUrl("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                this.a.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.M1();
                if (oi.z()) {
                    this.a.b2();
                    this.a.h = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.Z1();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                this.a.a2();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                rm4.a("NewFaceShopActivity", webView);
                return true;
            }
            return invokeLL.booleanValue;
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
                    if (!this.a.S1(str)) {
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

        public /* synthetic */ r(NewFaceShopActivity newFaceShopActivity, i iVar) {
            this(newFaceShopActivity);
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
        this.m = new i(this, 2921054);
        this.n = new j(this, 2001266);
        this.o = new k(this, 2921062);
        this.p = new h(this, 2921040);
    }

    public final void E1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return;
        }
        LikeModel likeModel = new LikeModel(getPageContext());
        likeModel.setFrom("emotion_center_follow");
        likeModel.setLoadDataCallBack(new n(this, likeModel, optString2));
        likeModel.Q(optString2, String.valueOf(optString));
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (qp7.l().r()) {
                P1(1, null);
            } else if (qp7.l().k() == null) {
                P1(0, null);
            } else {
                FaceGroupDraft k2 = qp7.l().k();
                if (!TextUtils.isEmpty(k2.getFailMsg())) {
                    P1(2, k2.getFailMsg());
                } else {
                    P1(2, null);
                }
            }
        }
    }

    public final void G1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("pck_id");
            ab6 t = ab6.t();
            String str = "";
            if (optInt != -1) {
                str = "" + optInt;
            }
            t.g(optString, str);
            loadUrl("javascript:__js_bridge_emoticon_coll_action(2)");
        }
    }

    public final void H1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            if (hp7.o().q()) {
                loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                qi.M(this.e.getPageActivity(), R.string.obfuscated_res_0x7f0f05ea);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
            dp7.b().a(new f(this, jSONObject));
        }
    }

    public final void I1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (hp7.o().q()) {
                loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                qi.M(this.e.getPageActivity(), R.string.obfuscated_res_0x7f0f05ea);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.j == null) {
                this.j = new NewFaceGroupDownloadModel();
            }
            this.j.z(optString, Boolean.TRUE, new e(this));
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            dp7.b().a(new b(this));
        }
    }

    public final JSONObject K1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str.contains("data=")) {
                try {
                    return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
                } catch (JSONException unused) {
                    return null;
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void L1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jSONObject) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getActivity(), jSONObject.optInt("id"), 25024)));
        }
    }

    public void M1() {
        g65 g65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (g65Var = this.f) == null) {
            return;
        }
        g65Var.dettachView(this.d);
        this.f = null;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d = findViewById(R.id.obfuscated_res_0x7f091c29);
            this.c = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0925f2);
            BaseWebView baseWebView = new BaseWebView(getPageContext().getPageActivity());
            this.b = baseWebView;
            baseWebView.setWebViewClient(new r(this, null));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (isUseStyleImmersiveSticky()) {
                layoutParams.topMargin = qi.s(getPageContext().getPageActivity());
            }
            this.c.addView(this.b, layoutParams);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.e.getPageActivity(), 25021)));
        }
    }

    public final void P1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
                return;
            }
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
        }
    }

    public final void Q1(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
                return;
            }
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            lb6 lb6Var = new lb6(getPageContext().getPageActivity(), 1);
            lb6Var.d(new m(this));
            lb6Var.showAtLocation(this.d, 81, 0, 0);
        }
    }

    public final boolean S1(String str) {
        InterceptResult invokeL;
        JSONObject K1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if ((str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) && (K1 = K1(str)) != null) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                    I1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                    H1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                    X1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                    J1();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                    Y1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                    c2(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                    U1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                    G1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                    W1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                    L1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                    O1();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                    R1();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                    E1(K1);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                    F1();
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void T1() {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.i) || !this.i.contains("emoticonpackage") || (split = this.i.split("/")) == null || split.length <= 0) {
            return;
        }
        String str = split[split.length - 1];
        if (this.k == null) {
            this.k = new NewFaceGroupShareModel();
        }
        this.k.z(str);
    }

    public final void U1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jSONObject) == null) {
            if (hp7.o().q()) {
                loadUrl("javascript:__js_bridge_emoticon_sort_action()");
                qi.M(this.e.getPageActivity(), R.string.obfuscated_res_0x7f0f05ea);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
            dp7.b().a(new d(this, jSONObject));
        }
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.b == null) {
            return;
        }
        if (this.h) {
            loadUrl("javascript:window.reload_page()");
        } else {
            loadUrl(this.a);
        }
    }

    public final void W1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            gp7.i().d(optString, new o(this));
        }
    }

    public final void X1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jSONObject) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            ShareItem shareItem = new ShareItem();
            shareItem.u = jSONObject.optString("title");
            shareItem.v = jSONObject.optString("content");
            shareItem.w = jSONObject.optString("linkUrl");
            shareItem.y = Uri.parse(jSONObject.optString("imageUri"));
            this.i = shareItem.w;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new g(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public final void Y1(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jSONObject) == null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("pos");
            String optString3 = jSONObject.optString("neg");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
            ur4 ur4Var = new ur4(getPageContext().getPageActivity());
            ur4Var.setMessage(optString);
            ur4Var.setPositiveButton(optString2, new p(this));
            ur4Var.setNegativeButton(optString3, new q(this));
            ur4Var.setOnCalcelListener(new a(this));
            ur4Var.create(getPageContext()).show();
        }
    }

    public void Z1() {
        TbPageContext<NewFaceShopActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tbPageContext = this.e) == null || this.d == null) {
            return;
        }
        g65 g65Var = new g65(tbPageContext.getPageActivity());
        this.f = g65Var;
        g65Var.attachView(this.d, false);
        this.f.onChangeSkinType();
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c3d);
            if (this.g == null) {
                h65 h65Var = new h65(this.e.getPageActivity(), new l(this));
                this.g = h65Var;
                h65Var.onChangeSkinType();
            }
            BaseWebView baseWebView = this.b;
            if (baseWebView != null) {
                baseWebView.setVisibility(8);
            }
            this.g.m(string);
            this.g.attachView(this.d, false);
            this.g.p();
            this.g.k(this.e.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            h65 h65Var = this.g;
            if (h65Var != null) {
                h65Var.dettachView(this.d);
                this.g = null;
            }
            BaseWebView baseWebView = this.b;
            if (baseWebView != null) {
                baseWebView.setVisibility(0);
            }
        }
    }

    public final void c2(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jSONObject) == null) {
            String optString = jSONObject.optString("content");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            showToast(optString);
        }
    }

    public final void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, str) == null) || this.b == null) {
            return;
        }
        this.l.post(new c(this, str));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048602, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 24007) {
                    T1();
                } else if (i2 != 25021) {
                    if (i2 != 25024) {
                        return;
                    }
                    loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
                } else if (intent == null || !intent.getBooleanExtra("uploading", false)) {
                } else {
                    P1(1, null);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onBackPressed();
            webViewGoBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.l = new Handler(Looper.getMainLooper());
            this.e = getPageContext();
            String stringExtra = getIntent().getStringExtra("url");
            this.a = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.a = "https://tieba.baidu.com/n/interact/emoticoncenter";
            }
            setContentView(R.layout.obfuscated_res_0x7f0d0621);
            N1();
            jm4.g(getApplicationContext());
            loadUrl(this.a);
            registerListener(this.m);
            registerListener(this.n);
            registerListener(this.o);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onDestroy();
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.j;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
            NewFaceGroupShareModel newFaceGroupShareModel = this.k;
            if (newFaceGroupShareModel != null) {
                newFaceGroupShareModel.cancelLoadData();
            }
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (i2 == 4 && webViewGoBack()) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onResume();
            registerListener(this.p);
            F1();
        }
    }

    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            BaseWebView baseWebView = this.b;
            if (baseWebView != null && baseWebView.canGoBack()) {
                this.b.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
