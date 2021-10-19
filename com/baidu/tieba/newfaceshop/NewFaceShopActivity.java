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
import c.a.q0.s.s.a;
import c.a.r0.k3.x;
import c.a.r0.s0.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
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
    public final String FACE_SHOP_URL;
    public NewFaceGroupDownloadModel mFaceGroupDownloadModel;
    public NewFaceGroupShareModel mFaceGroupShareModel;
    public CustomMessageListener mFaceGroupUploadFinishListener;
    public CustomMessageListener mLikeListener;
    public boolean mLoadSuccess;
    public c.a.q0.g0.g mLoadingView;
    public TbPageContext<NewFaceShopActivity> mPageContext;
    public CustomMessageListener mRefreshCurrentPageListener;
    public c.a.q0.g0.h mRefreshView;
    public View mRootView;
    public String mTempShareUrl;
    public Handler mUIHandler;
    public String mUrl;
    public CustomMessageListener mVoteListener;
    public BaseWebView mWebView;
    public RelativeLayout mWebViewContainer;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54635e;

        public a(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54635e = newFaceShopActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f54635e.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54636e;

        public b(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54636e = newFaceShopActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<MyEmotionGroupData> f2 = c.a.r0.f2.c.i().f();
                if (f2 == null || f2.isEmpty()) {
                    this.f54636e.loadUrl("javascript:__js_bridge_emoticon_has_action()");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (MyEmotionGroupData myEmotionGroupData : f2) {
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        sb.append(",");
                    }
                }
                NewFaceShopActivity newFaceShopActivity = this.f54636e;
                newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54638f;

        public c(NewFaceShopActivity newFaceShopActivity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54638f = newFaceShopActivity;
            this.f54637e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54638f.mWebView == null) {
                return;
            }
            this.f54638f.mWebView.loadUrl(this.f54637e);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f54639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54640f;

        public d(NewFaceShopActivity newFaceShopActivity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54640f = newFaceShopActivity;
            this.f54639e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.f2.c.i().j(new ArrayList(Arrays.asList(this.f54639e.optString("id").split(","))), true);
                this.f54640f.loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.a.r0.f2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54641a;

        public e(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54641a = newFaceShopActivity;
        }

        @Override // c.a.r0.f2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f54641a.loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
            }
        }

        @Override // c.a.r0.f2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 <= 0 || i2 >= 100) {
                return;
            }
            NewFaceShopActivity newFaceShopActivity = this.f54641a;
            newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_down_process_action(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }

        @Override // c.a.r0.f2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f54641a.loadUrl("javascript:__js_bridge_emoticon_down_process_action(100)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f54642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54643f;

        public f(NewFaceShopActivity newFaceShopActivity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54643f = newFaceShopActivity;
            this.f54642e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.f54642e.optString("id").split(",")));
                boolean c2 = c.a.r0.f2.c.i().c(arrayList, true);
                for (String str : arrayList) {
                    c.a.r0.s0.g.k().h(str);
                }
                if (c2) {
                    this.f54643f.loadUrl("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    this.f54643f.loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f54644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54645f;

        public g(NewFaceShopActivity newFaceShopActivity, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54645f = newFaceShopActivity;
            this.f54644e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.e.e.p.a.a(this.f54644e.t);
                c.a.e.e.p.l.M(this.f54645f.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54646a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(NewFaceShopActivity newFaceShopActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54646a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                String str = null;
                if (hashMap == null || hashMap.isEmpty()) {
                    this.f54646a.loadUploadFinishUrl(0, null);
                } else if (!hashMap.containsKey("upload_result")) {
                    this.f54646a.loadUploadFinishUrl(0, null);
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    this.f54646a.loadUploadFinishUrl(0, null);
                } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    this.f54646a.loadUploadFinishUrl(1, null);
                } else {
                    if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                        str = (String) hashMap.get("upload_msg");
                    }
                    this.f54646a.loadUploadFinishUrl(0, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54647a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(NewFaceShopActivity newFaceShopActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54647a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54647a.loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54648a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(NewFaceShopActivity newFaceShopActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54648a = newFaceShopActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x) && ((x) customResponsedMessage.getData()).l() == 1) {
                this.f54648a.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54649a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(NewFaceShopActivity newFaceShopActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54649a = newFaceShopActivity;
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
                NewFaceShopActivity newFaceShopActivity = this.f54649a;
                newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54650e;

        public l(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54650e = newFaceShopActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54650e.reloadPage();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements c.a.r0.s0.x.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54651e;

        public m(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54651e = newFaceShopActivity;
        }

        @Override // c.a.r0.s0.x.d.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f54651e.getPageContext().getPageActivity(), 25021)));
            }
        }

        @Override // c.a.r0.s0.x.d.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.f54651e.getPageContext().getPageActivity(), true, 25021)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f54652a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54653b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54654c;

        public n(NewFaceShopActivity newFaceShopActivity, LikeModel likeModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity, likeModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54654c = newFaceShopActivity;
            this.f54652a = likeModel;
            this.f54653b = str;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f54652a.getErrorCode() == 22) {
                    this.f54654c.showToast(R.string.unfollow_title);
                    this.f54654c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                } else if (AntiHelper.m(this.f54652a.getErrorCode(), this.f54652a.getErrorString())) {
                    AntiHelper.u(this.f54654c.getPageContext().getPageActivity(), this.f54652a.getErrorString());
                } else if (this.f54652a.getErrorCode() != 0) {
                    this.f54654c.showToast(this.f54652a.getErrorString());
                    this.f54654c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                } else {
                    x xVar = (x) obj;
                    if (xVar != null) {
                        this.f54654c.showToast(R.string.attention_success);
                        TbadkApplication.getInst().addLikeForum(this.f54653b);
                        xVar.v(1);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, xVar));
                        this.f54654c.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
                        return;
                    }
                    NewFaceShopActivity newFaceShopActivity = this.f54654c;
                    newFaceShopActivity.showToast(newFaceShopActivity.getPageContext().getString(R.string.neterror));
                    this.f54654c.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements c.a.r0.f2.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54655a;

        public o(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54655a = newFaceShopActivity;
        }

        @Override // c.a.r0.f2.e.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f54655a.loadUrl("javascript:__js_bridge_emoticon_save_action(0)");
            }
        }

        @Override // c.a.r0.f2.e.b
        public void onProgress(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            }
        }

        @Override // c.a.r0.f2.e.b
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f54655a.loadUrl("javascript:__js_bridge_emoticon_save_action(1)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54656e;

        public p(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54656e = newFaceShopActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f54656e.loadUrl("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54657e;

        public q(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54657e = newFaceShopActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f54657e.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewFaceShopActivity f54658a;

        public r(NewFaceShopActivity newFaceShopActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newFaceShopActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54658a = newFaceShopActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f54658a.hideLoadingView();
                if (c.a.e.e.p.j.z()) {
                    this.f54658a.showNormalView();
                    this.f54658a.mLoadSuccess = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.f54658a.showLoadingView();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                this.f54658a.showNetRefreshView();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, renderProcessGoneDetail)) == null) {
                c.a.q0.m.f.a("NewFaceShopActivity", webView);
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
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (!StringUtils.isNull(str)) {
                    if (!this.f54658a.nativeCall(str)) {
                        int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(this.f54658a.getPageContext(), new String[]{str});
                        if (dealOneLinkWithOutJumpWebView == 1) {
                            this.f54658a.finish();
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
        this.FACE_SHOP_URL = CommonEmotionManagerActivity.FACE_SHOP_URL;
        this.mRefreshCurrentPageListener = new i(this, 2921054);
        this.mLikeListener = new j(this, 2001266);
        this.mVoteListener = new k(this, 2921062);
        this.mFaceGroupUploadFinishListener = new h(this, 2921040);
    }

    private void attentionForum(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, jSONObject) == null) || jSONObject == null) {
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
        likeModel.L(optString2, String.valueOf(optString));
    }

    private void checkIsUploadingFaceGroup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (c.a.r0.f2.g.e.l().r()) {
                loadCheckUploadStatusUrl(1, null);
            } else if (c.a.r0.f2.g.e.l().k() == null) {
                loadCheckUploadStatusUrl(0, null);
            } else {
                FaceGroupDraft k2 = c.a.r0.f2.g.e.l().k();
                if (!TextUtils.isEmpty(k2.getFailMsg())) {
                    loadCheckUploadStatusUrl(2, k2.getFailMsg());
                } else {
                    loadCheckUploadStatusUrl(2, null);
                }
            }
        }
    }

    private void collectEmotion(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("pck_id");
            t s = t.s();
            String str = "";
            if (optInt != -1) {
                str = "" + optInt;
            }
            s.g(optString, str);
            loadUrl("javascript:__js_bridge_emoticon_coll_action(2)");
        }
    }

    private void deleteEmotion(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, jSONObject) == null) {
            if (c.a.r0.f2.d.m().o()) {
                loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                c.a.e.e.p.l.L(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
            c.a.r0.f2.a.b().a(new f(this, jSONObject));
        }
    }

    private void downloadEmotion(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, this, jSONObject) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (c.a.r0.f2.d.m().o()) {
                loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                c.a.e.e.p.l.L(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.mFaceGroupDownloadModel == null) {
                this.mFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            }
            this.mFaceGroupDownloadModel.w(optString, Boolean.TRUE, new e(this));
        }
    }

    private void getHasDownedEmotionGroupIds() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            c.a.r0.f2.a.b().a(new b(this));
        }
    }

    private JSONObject getJSData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) {
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

    private void gotoPackageDetail(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, jSONObject) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getActivity(), jSONObject.optInt("id"), 25024)));
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mRootView = findViewById(R.id.root_layout);
            this.mWebViewContainer = (RelativeLayout) findViewById(R.id.webview_container);
            BaseWebView baseWebView = new BaseWebView(getPageContext().getPageActivity());
            this.mWebView = baseWebView;
            baseWebView.setWebViewClient(new r(this, null));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (isUseStyleImmersiveSticky()) {
                layoutParams.topMargin = c.a.e.e.p.l.r(getPageContext().getPageActivity());
            }
            this.mWebViewContainer.addView(this.mWebView, layoutParams);
        }
    }

    private void jumpToFaceGroupMakeAct() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), 25021)));
        }
    }

    private void loadCheckUploadStatusUrl(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65552, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
                return;
            }
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUploadFinishUrl(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65553, this, i2, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
                return;
            }
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, str) == null) || this.mWebView == null) {
            return;
        }
        this.mUIHandler.post(new c(this, str));
    }

    private void makeDailogForCreateEmotion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            c.a.r0.s0.x.d.a aVar = new c.a.r0.s0.x.d.a(getPageContext().getPageActivity(), 1);
            aVar.d(new m(this));
            aVar.showAtLocation(this.mRootView, 81, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nativeCall(String str) {
        InterceptResult invokeL;
        JSONObject jSData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, str)) == null) {
            if ((str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) && (jSData = getJSData(str)) != null) {
                if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                    downloadEmotion(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                    deleteEmotion(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                    shareEmotion(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                    getHasDownedEmotionGroupIds();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                    showDialog(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                    showToast(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                    reOrderGroup(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                    collectEmotion(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                    saveEmotion(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                    gotoPackageDetail(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                    jumpToFaceGroupMakeAct();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                    makeDailogForCreateEmotion();
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                    attentionForum(jSData);
                    return true;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                    checkIsUploadingFaceGroup();
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void onShareSuccess() {
        String[] split;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65557, this) == null) || TextUtils.isEmpty(this.mTempShareUrl) || !this.mTempShareUrl.contains("emoticonpackage") || (split = this.mTempShareUrl.split("/")) == null || split.length <= 0) {
            return;
        }
        String str = split[split.length - 1];
        if (this.mFaceGroupShareModel == null) {
            this.mFaceGroupShareModel = new NewFaceGroupShareModel();
        }
        this.mFaceGroupShareModel.w(str);
    }

    private void reOrderGroup(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, jSONObject) == null) {
            if (c.a.r0.f2.d.m().o()) {
                loadUrl("javascript:__js_bridge_emoticon_sort_action()");
                c.a.e.e.p.l.L(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
            c.a.r0.f2.a.b().a(new d(this, jSONObject));
        }
    }

    private void saveEmotion(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, jSONObject) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            c.a.r0.f2.c.i().d(optString, new o(this));
        }
    }

    private void shareEmotion(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, jSONObject) == null) {
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
            ShareItem shareItem = new ShareItem();
            shareItem.r = jSONObject.optString("title");
            shareItem.s = jSONObject.optString("content");
            shareItem.t = jSONObject.optString("linkUrl");
            shareItem.v = Uri.parse(jSONObject.optString("imageUri"));
            this.mTempShareUrl = shareItem.t;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new g(this, shareItem));
            sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    private void showDialog(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, jSONObject) == null) {
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString(IAdRequestParam.POS);
            String optString3 = jSONObject.optString("neg");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(optString);
            aVar.setPositiveButton(optString2, new p(this));
            aVar.setNegativeButton(optString3, new q(this));
            aVar.setOnCalcelListener(new a(this));
            aVar.create(getPageContext()).show();
        }
    }

    private void showToast(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, jSONObject) == null) {
            String optString = jSONObject.optString("content");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            showToast(optString);
        }
    }

    public void hideLoadingView() {
        c.a.q0.g0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.mLoadingView) == null) {
            return;
        }
        gVar.dettachView(this.mRootView);
        this.mLoadingView = null;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 24007) {
                    onShareSuccess();
                } else if (i2 != 25021) {
                    if (i2 != 25024) {
                        return;
                    }
                    loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
                } else if (intent == null || !intent.getBooleanExtra("uploading", false)) {
                } else {
                    loadCheckUploadStatusUrl(1, null);
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onBackPressed();
            webViewGoBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.mUIHandler = new Handler(Looper.getMainLooper());
            this.mPageContext = getPageContext();
            String stringExtra = getIntent().getStringExtra("url");
            this.mUrl = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mUrl = CommonEmotionManagerActivity.FACE_SHOP_URL;
            }
            setContentView(R.layout.new_faceshop_activity);
            initView();
            c.a.q0.m.a.f(getApplicationContext());
            loadUrl(this.mUrl);
            registerListener(this.mRefreshCurrentPageListener);
            registerListener(this.mLikeListener);
            registerListener(this.mVoteListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            NewFaceGroupDownloadModel newFaceGroupDownloadModel = this.mFaceGroupDownloadModel;
            if (newFaceGroupDownloadModel != null) {
                newFaceGroupDownloadModel.cancelLoadData();
            }
            NewFaceGroupShareModel newFaceGroupShareModel = this.mFaceGroupShareModel;
            if (newFaceGroupShareModel != null) {
                newFaceGroupShareModel.cancelLoadData();
            }
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.mFaceGroupUploadFinishListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            registerListener(this.mFaceGroupUploadFinishListener);
            checkIsUploadingFaceGroup();
        }
    }

    public void reloadPage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.mWebView == null) {
            return;
        }
        if (this.mLoadSuccess) {
            loadUrl("javascript:window.reload_page()");
        } else {
            loadUrl(this.mUrl);
        }
    }

    public void showLoadingView() {
        TbPageContext<NewFaceShopActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.mPageContext) == null || this.mRootView == null) {
            return;
        }
        c.a.q0.g0.g gVar = new c.a.q0.g0.g(tbPageContext.getPageActivity());
        this.mLoadingView = gVar;
        gVar.attachView(this.mRootView, false);
        this.mLoadingView.onChangeSkinType();
    }

    public void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
            if (this.mRefreshView == null) {
                c.a.q0.g0.h hVar = new c.a.q0.g0.h(this.mPageContext.getPageActivity(), new l(this));
                this.mRefreshView = hVar;
                hVar.onChangeSkinType();
            }
            BaseWebView baseWebView = this.mWebView;
            if (baseWebView != null) {
                baseWebView.setVisibility(8);
            }
            this.mRefreshView.l(string);
            this.mRefreshView.attachView(this.mRootView, false);
            this.mRefreshView.o();
            this.mRefreshView.j(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds280));
        }
    }

    public void showNormalView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.q0.g0.h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.mRootView);
                this.mRefreshView = null;
            }
            BaseWebView baseWebView = this.mWebView;
            if (baseWebView != null) {
                baseWebView.setVisibility(0);
            }
        }
    }

    public boolean webViewGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            BaseWebView baseWebView = this.mWebView;
            if (baseWebView != null && baseWebView.canGoBack()) {
                this.mWebView.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
