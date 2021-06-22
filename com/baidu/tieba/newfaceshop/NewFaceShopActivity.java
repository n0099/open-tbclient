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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
import d.a.n0.r.s.a;
import d.a.o0.e3.w;
import d.a.o0.m0.u;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NewFaceShopActivity extends BaseActivity {
    public NewFaceGroupDownloadModel mFaceGroupDownloadModel;
    public NewFaceGroupShareModel mFaceGroupShareModel;
    public boolean mLoadSuccess;
    public d.a.n0.d0.g mLoadingView;
    public TbPageContext<NewFaceShopActivity> mPageContext;
    public d.a.n0.d0.h mRefreshView;
    public View mRootView;
    public String mTempShareUrl;
    public Handler mUIHandler;
    public String mUrl;
    public BaseWebView mWebView;
    public RelativeLayout mWebViewContainer;
    public final String FACE_SHOP_URL = CommonEmotionManagerActivity.FACE_SHOP_URL;
    public CustomMessageListener mRefreshCurrentPageListener = new i(2921054);
    public CustomMessageListener mLikeListener = new j(2001266);
    public CustomMessageListener mVoteListener = new k(2921062);
    public CustomMessageListener mFaceGroupUploadFinishListener = new h(2921040);

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List<MyEmotionGroupData> f2 = d.a.o0.z1.c.i().f();
            if (f2 == null || f2.isEmpty()) {
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_has_action()");
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (MyEmotionGroupData myEmotionGroupData : f2) {
                if (myEmotionGroupData != null) {
                    sb.append(myEmotionGroupData.getGroupId());
                    sb.append(",");
                }
            }
            NewFaceShopActivity newFaceShopActivity = NewFaceShopActivity.this;
            newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f18684e;

        public c(String str) {
            this.f18684e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NewFaceShopActivity.this.mWebView != null) {
                NewFaceShopActivity.this.mWebView.loadUrl(this.f18684e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f18686e;

        public d(JSONObject jSONObject) {
            this.f18686e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.o0.z1.c.i().j(new ArrayList(Arrays.asList(this.f18686e.optString("id").split(","))), true);
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_sort_action()");
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d.a.o0.z1.e.b {
        public e() {
        }

        @Override // d.a.o0.z1.e.b
        public void onFail(String str) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
        }

        @Override // d.a.o0.z1.e.b
        public void onProgress(int i2) {
            if (i2 <= 0 || i2 >= 100) {
                return;
            }
            NewFaceShopActivity newFaceShopActivity = NewFaceShopActivity.this;
            newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_down_process_action(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }

        @Override // d.a.o0.z1.e.b
        public void onSuccess(String str) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(100)");
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f18689e;

        public f(JSONObject jSONObject) {
            this.f18689e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList = new ArrayList(Arrays.asList(this.f18689e.optString("id").split(",")));
            boolean c2 = d.a.o0.z1.c.i().c(arrayList, true);
            for (String str : arrayList) {
                d.a.o0.m0.g.k().h(str);
            }
            if (c2) {
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_del_action(1)");
            } else {
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f18691e;

        public g(ShareItem shareItem) {
            this.f18691e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.p.a.a(this.f18691e.t);
            d.a.c.e.p.l.M(NewFaceShopActivity.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof HashMap)) {
                return;
            }
            HashMap hashMap = (HashMap) customResponsedMessage.getData();
            String str = null;
            if (hashMap == null || hashMap.isEmpty()) {
                NewFaceShopActivity.this.loadUploadFinishUrl(0, null);
            } else if (!hashMap.containsKey("upload_result")) {
                NewFaceShopActivity.this.loadUploadFinishUrl(0, null);
            } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                NewFaceShopActivity.this.loadUploadFinishUrl(0, null);
            } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                NewFaceShopActivity.this.loadUploadFinishUrl(1, null);
            } else {
                if (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) {
                    str = (String) hashMap.get("upload_msg");
                }
                NewFaceShopActivity.this.loadUploadFinishUrl(0, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && ((w) customResponsedMessage.getData()).l() == 1) {
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof EmotionPackageData)) {
                return;
            }
            EmotionPackageData emotionPackageData = (EmotionPackageData) customResponsedMessage.getData();
            if (emotionPackageData.has_vote != 0 || emotionPackageData.id <= 0) {
                return;
            }
            NewFaceShopActivity newFaceShopActivity = NewFaceShopActivity.this;
            newFaceShopActivity.loadUrl("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NewFaceShopActivity.this.reloadPage();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements d.a.o0.m0.y.d.c {
        public m() {
        }

        @Override // d.a.o0.m0.y.d.c
        public void a() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(NewFaceShopActivity.this.getPageContext().getPageActivity(), 25021)));
        }

        @Override // d.a.o0.m0.y.d.c
        public void b() {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(NewFaceShopActivity.this.getPageContext().getPageActivity(), true, 25021)));
        }
    }

    /* loaded from: classes5.dex */
    public class n extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LikeModel f18699a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18700b;

        public n(LikeModel likeModel, String str) {
            this.f18699a = likeModel;
            this.f18700b = str;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (this.f18699a.getErrorCode() == 22) {
                NewFaceShopActivity.this.showToast(R.string.unfollow_title);
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
            } else if (AntiHelper.m(this.f18699a.getErrorCode(), this.f18699a.getErrorString())) {
                AntiHelper.u(NewFaceShopActivity.this.getPageContext().getPageActivity(), this.f18699a.getErrorString());
            } else if (this.f18699a.getErrorCode() != 0) {
                NewFaceShopActivity.this.showToast(this.f18699a.getErrorString());
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
            } else {
                w wVar = (w) obj;
                if (wVar != null) {
                    NewFaceShopActivity.this.showToast(R.string.attention_success);
                    TbadkApplication.getInst().addLikeForum(this.f18700b);
                    wVar.v(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
                    return;
                }
                NewFaceShopActivity newFaceShopActivity = NewFaceShopActivity.this;
                newFaceShopActivity.showToast(newFaceShopActivity.getPageContext().getString(R.string.neterror));
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements d.a.o0.z1.e.b {
        public o() {
        }

        @Override // d.a.o0.z1.e.b
        public void onFail(String str) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_save_action(0)");
        }

        @Override // d.a.o0.z1.e.b
        public void onProgress(int i2) {
        }

        @Override // d.a.o0.z1.e.b
        public void onSuccess(String str) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_save_action(1)");
        }
    }

    /* loaded from: classes5.dex */
    public class p implements a.e {
        public p() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(1)");
        }
    }

    /* loaded from: classes5.dex */
    public class q implements a.e {
        public q() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
    }

    /* loaded from: classes5.dex */
    public class r extends WebViewClient {
        public r() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            NewFaceShopActivity.this.hideLoadingView();
            if (d.a.c.e.p.j.z()) {
                NewFaceShopActivity.this.showNormalView();
                NewFaceShopActivity.this.mLoadSuccess = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            NewFaceShopActivity.this.showLoadingView();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            NewFaceShopActivity.this.showNetRefreshView();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            if (!StringUtils.isNull(str)) {
                if (!NewFaceShopActivity.this.nativeCall(str)) {
                    int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(NewFaceShopActivity.this.getPageContext(), new String[]{str});
                    if (dealOneLinkWithOutJumpWebView == 1) {
                        NewFaceShopActivity.this.finish();
                        return true;
                    } else if (dealOneLinkWithOutJumpWebView == 0) {
                    }
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public /* synthetic */ r(NewFaceShopActivity newFaceShopActivity, i iVar) {
            this();
        }
    }

    private void attentionForum(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("forum_id");
        String optString2 = jSONObject.optString("forum_name");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return;
        }
        LikeModel likeModel = new LikeModel(getPageContext());
        likeModel.setFrom("emotion_center_follow");
        likeModel.setLoadDataCallBack(new n(likeModel, optString2));
        likeModel.L(optString2, String.valueOf(optString));
    }

    private void checkIsUploadingFaceGroup() {
        if (d.a.o0.z1.g.e.l().r()) {
            loadCheckUploadStatusUrl(1, null);
        } else if (d.a.o0.z1.g.e.l().k() == null) {
            loadCheckUploadStatusUrl(0, null);
        } else {
            FaceGroupDraft k2 = d.a.o0.z1.g.e.l().k();
            if (!TextUtils.isEmpty(k2.getFailMsg())) {
                loadCheckUploadStatusUrl(2, k2.getFailMsg());
            } else {
                loadCheckUploadStatusUrl(2, null);
            }
        }
    }

    private void collectEmotion(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        int optInt = jSONObject.optInt("pck_id");
        u s = u.s();
        String str = "";
        if (optInt != -1) {
            str = "" + optInt;
        }
        s.g(optString, str);
        loadUrl("javascript:__js_bridge_emoticon_coll_action(2)");
    }

    private void deleteEmotion(JSONObject jSONObject) {
        if (d.a.o0.z1.d.m().o()) {
            loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
            d.a.c.e.p.l.L(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
        d.a.o0.z1.a.b().a(new f(jSONObject));
    }

    private void downloadEmotion(JSONObject jSONObject) {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (d.a.o0.z1.d.m().o()) {
                loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                d.a.c.e.p.l.L(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.mFaceGroupDownloadModel == null) {
                this.mFaceGroupDownloadModel = new NewFaceGroupDownloadModel();
            }
            this.mFaceGroupDownloadModel.w(optString, Boolean.TRUE, new e());
        }
    }

    private void getHasDownedEmotionGroupIds() {
        d.a.o0.z1.a.b().a(new b());
    }

    private JSONObject getJSData(String str) {
        if (str.contains("data=")) {
            try {
                return new JSONObject(str.substring(str.indexOf("data=") + 5).replaceAll("\\\\", ""));
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    private void gotoPackageDetail(JSONObject jSONObject) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EmotionPackageDetailActivityConfig(getActivity(), jSONObject.optInt("id"), 25024)));
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.mWebViewContainer = (RelativeLayout) findViewById(R.id.webview_container);
        BaseWebView baseWebView = new BaseWebView(getPageContext().getPageActivity());
        this.mWebView = baseWebView;
        baseWebView.setWebViewClient(new r(this, null));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (isUseStyleImmersiveSticky()) {
            layoutParams.topMargin = d.a.c.e.p.l.r(getPageContext().getPageActivity());
        }
        this.mWebViewContainer.addView(this.mWebView, layoutParams);
    }

    private void jumpToFaceGroupMakeAct() {
        if (ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), 25021)));
        }
    }

    private void loadCheckUploadStatusUrl(int i2, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "','" + str + "')");
            return;
        }
        loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i2 + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUploadFinishUrl(int i2, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "','" + str + "')");
            return;
        }
        loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i2 + "')");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl(String str) {
        if (this.mWebView != null) {
            this.mUIHandler.post(new c(str));
        }
    }

    private void makeDailogForCreateEmotion() {
        d.a.o0.m0.y.d.a aVar = new d.a.o0.m0.y.d.a(getPageContext().getPageActivity(), 1);
        aVar.d(new m());
        aVar.showAtLocation(this.mRootView, 81, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nativeCall(String str) {
        JSONObject jSData;
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

    private void onShareSuccess() {
        String[] split;
        if (!TextUtils.isEmpty(this.mTempShareUrl) && this.mTempShareUrl.contains("emoticonpackage") && (split = this.mTempShareUrl.split("/")) != null && split.length > 0) {
            String str = split[split.length - 1];
            if (this.mFaceGroupShareModel == null) {
                this.mFaceGroupShareModel = new NewFaceGroupShareModel();
            }
            this.mFaceGroupShareModel.w(str);
        }
    }

    private void reOrderGroup(JSONObject jSONObject) {
        if (d.a.o0.z1.d.m().o()) {
            loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            d.a.c.e.p.l.L(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
        d.a.o0.z1.a.b().a(new d(jSONObject));
    }

    private void saveEmotion(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        d.a.o0.z1.c.i().d(optString, new o());
    }

    private void shareEmotion(JSONObject jSONObject) {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        ShareItem shareItem = new ShareItem();
        shareItem.r = jSONObject.optString("title");
        shareItem.s = jSONObject.optString("content");
        shareItem.t = jSONObject.optString("linkUrl");
        shareItem.v = Uri.parse(jSONObject.optString("imageUri"));
        this.mTempShareUrl = shareItem.t;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new g(shareItem));
        sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }

    private void showDialog(JSONObject jSONObject) {
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString(IAdRequestParam.POS);
        String optString3 = jSONObject.optString("neg");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(getPageContext().getPageActivity());
        aVar.setMessage(optString);
        aVar.setPositiveButton(optString2, new p());
        aVar.setNegativeButton(optString3, new q());
        aVar.setOnCalcelListener(new a());
        aVar.create(getPageContext()).show();
    }

    private void showToast(JSONObject jSONObject) {
        String optString = jSONObject.optString("content");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        showToast(optString);
    }

    public void hideLoadingView() {
        d.a.n0.d0.g gVar = this.mLoadingView;
        if (gVar != null) {
            gVar.dettachView(this.mRootView);
            this.mLoadingView = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
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

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        webViewGoBack();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
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
        d.a.n0.l.a.f(getApplicationContext());
        loadUrl(this.mUrl);
        registerListener(this.mRefreshCurrentPageListener);
        registerListener(this.mLikeListener);
        registerListener(this.mVoteListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && webViewGoBack()) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.mFaceGroupUploadFinishListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.mFaceGroupUploadFinishListener);
        checkIsUploadingFaceGroup();
    }

    public void reloadPage() {
        if (this.mWebView == null) {
            return;
        }
        if (this.mLoadSuccess) {
            loadUrl("javascript:window.reload_page()");
        } else {
            loadUrl(this.mUrl);
        }
    }

    public void showLoadingView() {
        TbPageContext<NewFaceShopActivity> tbPageContext = this.mPageContext;
        if (tbPageContext == null || this.mRootView == null) {
            return;
        }
        d.a.n0.d0.g gVar = new d.a.n0.d0.g(tbPageContext.getPageActivity());
        this.mLoadingView = gVar;
        gVar.attachView(this.mRootView, false);
        this.mLoadingView.onChangeSkinType();
    }

    public void showNetRefreshView() {
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.mRefreshView == null) {
            d.a.n0.d0.h hVar = new d.a.n0.d0.h(this.mPageContext.getPageActivity(), new l());
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

    public void showNormalView() {
        d.a.n0.d0.h hVar = this.mRefreshView;
        if (hVar != null) {
            hVar.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null) {
            baseWebView.setVisibility(0);
        }
    }

    public boolean webViewGoBack() {
        BaseWebView baseWebView = this.mWebView;
        if (baseWebView != null && baseWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return false;
    }
}
