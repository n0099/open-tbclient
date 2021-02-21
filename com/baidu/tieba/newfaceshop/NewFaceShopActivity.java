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
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EmotionPackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import com.baidu.tieba.faceshop.ab;
import com.baidu.tieba.faceshop.i;
import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class NewFaceShopActivity extends BaseActivity {
    private g gJB;
    private NewFaceGroupDownloadModel iUr;
    private NewFaceGroupShareModel iUs;
    private String iUt;
    private RelativeLayout lAy;
    private boolean mLoadSuccess;
    private TbPageContext<NewFaceShopActivity> mPageContext;
    private h mRefreshView;
    private View mRootView;
    private Handler mUIHandler;
    private String mUrl;
    private BaseWebView mWebView;
    private final String lAx = "http://tieba.baidu.com/n/interact/emoticoncenter";
    private CustomMessageListener iXQ = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_MY_EMOTION_PACKAGE) { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
        }
    };
    private CustomMessageListener iXR = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && ((w) customResponsedMessage.getData()).isLike() == 1) {
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
            }
        }
    };
    private CustomMessageListener iXS = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_VOTE_EMOTION_PACKAGE_SUCCESS) { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof EmotionPackageData)) {
                EmotionPackageData emotionPackageData = (EmotionPackageData) customResponsedMessage.getData();
                if (emotionPackageData.has_vote == 0 && emotionPackageData.id > 0) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_vote_action(" + emotionPackageData.id + ")");
                }
            }
        }
    };
    CustomMessageListener iXT = new CustomMessageListener(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH) { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (hashMap == null || hashMap.isEmpty()) {
                    NewFaceShopActivity.this.by(0, null);
                } else if (!hashMap.containsKey("upload_result")) {
                    NewFaceShopActivity.this.by(0, null);
                } else if (hashMap.get("upload_result") == null || !(hashMap.get("upload_result") instanceof Boolean)) {
                    NewFaceShopActivity.this.by(0, null);
                } else if (((Boolean) hashMap.get("upload_result")).booleanValue()) {
                    NewFaceShopActivity.this.by(1, null);
                } else {
                    NewFaceShopActivity.this.by(0, (hashMap.containsKey("upload_msg") && hashMap.get("upload_msg") != null && (hashMap.get("upload_msg") instanceof String)) ? (String) hashMap.get("upload_msg") : null);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mPageContext = getPageContext();
        this.mUrl = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(this.mUrl)) {
            this.mUrl = "http://tieba.baidu.com/n/interact/emoticoncenter";
        }
        setContentView(R.layout.new_faceshop_activity);
        initView();
        com.baidu.tbadk.browser.a.initCookie(getApplicationContext());
        loadUrl(this.mUrl);
        registerListener(this.iXQ);
        registerListener(this.iXR);
        registerListener(this.iXS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.iXT);
        czT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.iXT);
    }

    private void initView() {
        this.mRootView = findViewById(R.id.root_layout);
        this.lAy = (RelativeLayout) findViewById(R.id.webview_container);
        this.mWebView = new BaseWebView(getPageContext().getPageActivity());
        this.mWebView.setWebViewClient(new a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (isUseStyleImmersiveSticky()) {
            layoutParams.topMargin = l.getStatusBarHeight(getPageContext().getPageActivity());
        }
        this.lAy.addView(this.mWebView, layoutParams);
    }

    public void showLoadingView() {
        if (this.mPageContext != null && this.mRootView != null) {
            this.gJB = new g(this.mPageContext.getPageActivity());
            this.gJB.attachView(this.mRootView, false);
            this.gJB.onChangeSkinType();
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this.mRootView);
            this.gJB = null;
        }
    }

    public void bRB() {
        String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NewFaceShopActivity.this.bVv();
                }
            });
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mWebView != null) {
            this.mWebView.setVisibility(8);
        }
        this.mRefreshView.setSubText(string);
        this.mRefreshView.attachView(this.mRootView, false);
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds280));
    }

    public void bTZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
        if (this.mWebView != null) {
            this.mWebView.setVisibility(0);
        }
    }

    public void bVv() {
        if (this.mWebView != null) {
            if (this.mLoadSuccess) {
                loadUrl("javascript:window.reload_page()");
            } else {
                loadUrl(this.mUrl);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && webViewGoBack()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends WebViewClient {
        private a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.newfaceshop.NewFaceShopActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (!StringUtils.isNull(str)) {
                if (NewFaceShopActivity.this.JS(str)) {
                    return true;
                }
                int a2 = bf.bsV().a(NewFaceShopActivity.this.getPageContext(), new String[]{str});
                if (a2 == 1) {
                    NewFaceShopActivity.this.finish();
                    return true;
                }
                if (a2 == 0) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            NewFaceShopActivity.this.showLoadingView();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            NewFaceShopActivity.this.hideLoadingView();
            if (j.isNetWorkAvailable()) {
                NewFaceShopActivity.this.bTZ();
                NewFaceShopActivity.this.mLoadSuccess = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            NewFaceShopActivity.this.bRB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JS(String str) {
        JSONObject JT;
        if ((str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) && (JT = JT(str)) != null) {
            if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DOWNLOAD_EMOTION)) {
                ej(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DELETE_EMOTION)) {
                el(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SHARE_EMOTION)) {
                em(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_HAS_EMOTION)) {
                czV();
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_DIALOG_EMOTION)) {
                en(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_TOAST_EMOTION)) {
                showToast(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_ORDER_EMOTION)) {
                eo(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_COLLECT_EMOTION)) {
                ep(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_SAVE_EMOTION)) {
                eq(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_TO_PACKAGE_DETAIL)) {
                er(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_EMOTION)) {
                czW();
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CREATE_SINGLE_EMOTION)) {
                czU();
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CERCON_FORUM)) {
                ek(JT);
            } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_CHECK_EMOTION_UPLOADING)) {
                czT();
            }
            return true;
        }
        return false;
    }

    private void czU() {
        com.baidu.tieba.faceshop.emotioncenter.a.a aVar = new com.baidu.tieba.faceshop.emotioncenter.a.a(getPageContext().getPageActivity(), 1);
        aVar.a(new com.baidu.tieba.faceshop.emotioncenter.a.c() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.13
            @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
            public void czX() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(NewFaceShopActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
            }

            @Override // com.baidu.tieba.faceshop.emotioncenter.a.c
            public void czY() {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(NewFaceShopActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
            }
        });
        aVar.showAtLocation(this.mRootView, 81, 0, 0);
    }

    private void ek(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("forum_id");
            final String optString2 = jSONObject.optString("forum_name");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                final LikeModel likeModel = new LikeModel(getPageContext());
                likeModel.setFrom("emotion_center_follow");
                likeModel.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.14
                    @Override // com.baidu.adp.base.e
                    public void callback(Object obj) {
                        if (likeModel.getErrorCode() == 22) {
                            NewFaceShopActivity.this.showToast(R.string.unfollow_title);
                            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                        } else if (AntiHelper.bX(likeModel.getErrorCode(), likeModel.getErrorString())) {
                            AntiHelper.bq(NewFaceShopActivity.this.getPageContext().getPageActivity(), likeModel.getErrorString());
                        } else if (likeModel.getErrorCode() != 0) {
                            NewFaceShopActivity.this.showToast(likeModel.getErrorString());
                            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                        } else {
                            w wVar = (w) obj;
                            if (wVar != null) {
                                NewFaceShopActivity.this.showToast(R.string.attention_success);
                                TbadkApplication.getInst().addLikeForum(optString2);
                                wVar.setLike(1);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(1)");
                                return;
                            }
                            NewFaceShopActivity.this.showToast(NewFaceShopActivity.this.getPageContext().getString(R.string.neterror));
                            NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_attend_action(0)");
                        }
                    }
                });
                likeModel.gy(optString2, String.valueOf(optString));
            }
        }
    }

    private void er(JSONObject jSONObject) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionPackageDetailActivityConfig(getActivity(), jSONObject.optInt("id"), RequestResponseCode.REQUEST_EMOTION_DETAIL)));
    }

    private void ep(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        int optInt = jSONObject.optInt("pck_id");
        ab.czN().eU(optString, optInt == -1 ? "" : "" + optInt);
        loadUrl("javascript:__js_bridge_emoticon_coll_action(2)");
    }

    private void eq(JSONObject jSONObject) {
        String optString = jSONObject.optString("url");
        if (!TextUtils.isEmpty(optString)) {
            c.dis().a(optString, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.15
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_save_action(1)");
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_save_action(0)");
                }
            });
        }
    }

    private void en(JSONObject jSONObject) {
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("pos");
        String optString3 = jSONObject.optString("neg");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Au(optString);
        aVar.a(optString2, new a.b() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.16
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(1)");
            }
        });
        aVar.b(optString3, new a.b() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.17
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        });
        aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_show_dialog(0)");
            }
        });
        aVar.b(getPageContext()).bqx();
    }

    private void czV() {
        com.baidu.tieba.newfaceshop.a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.3
            @Override // java.lang.Runnable
            public void run() {
                List<MyEmotionGroupData> dit = c.dis().dit();
                if (dit == null || dit.isEmpty()) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_has_action()");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (MyEmotionGroupData myEmotionGroupData : dit) {
                    if (myEmotionGroupData != null) {
                        sb.append(myEmotionGroupData.getGroupId());
                        sb.append(",");
                    }
                }
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_has_action('" + sb.toString() + "')");
            }
        });
    }

    private JSONObject JT(String str) {
        if (str.contains("data=")) {
            try {
                return new JSONObject(str.substring("data=".length() + str.indexOf("data=")).replaceAll("\\\\", ""));
            } catch (JSONException e) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl(final String str) {
        if (this.mWebView != null) {
            this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (NewFaceShopActivity.this.mWebView != null) {
                        NewFaceShopActivity.this.mWebView.loadUrl(str);
                    }
                }
            });
        }
    }

    private void eo(final JSONObject jSONObject) {
        if (d.diw().diz()) {
            loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_ORDER);
        com.baidu.tieba.newfaceshop.a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.5
            @Override // java.lang.Runnable
            public void run() {
                c.dis().w(new ArrayList(Arrays.asList(jSONObject.optString("id").split(","))), true);
                NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_sort_action()");
            }
        });
    }

    private void ej(JSONObject jSONObject) {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (d.diw().diz()) {
                loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
                return;
            }
            TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DOWNLOAD);
            String optString = jSONObject.optString("id");
            if (this.iUr == null) {
                this.iUr = new NewFaceGroupDownloadModel();
            }
            this.iUr.a(optString, true, new com.baidu.tieba.newfaceshop.a.b() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.6
                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onSuccess(String str) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(100)");
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onProgress(int i) {
                    if (i > 0 && i < 100) {
                        NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(" + i + ")");
                    }
                }

                @Override // com.baidu.tieba.newfaceshop.a.b
                public void onFail(String str) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_down_process_action(-1)");
                }
            });
        }
    }

    private void showToast(JSONObject jSONObject) {
        String optString = jSONObject.optString("content");
        if (!TextUtils.isEmpty(optString)) {
            showToast(optString);
        }
    }

    private void el(final JSONObject jSONObject) {
        if (d.diw().diz()) {
            loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
            l.showToast(this.mPageContext.getPageActivity(), R.string.face_group_is_syncing);
            return;
        }
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_DELETE);
        com.baidu.tieba.newfaceshop.a.diq().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.7
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<String> arrayList = new ArrayList(Arrays.asList(jSONObject.optString("id").split(",")));
                boolean v = c.dis().v(arrayList, true);
                for (String str : arrayList) {
                    i.cyL().JE(str);
                }
                if (v) {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_del_action(1)");
                } else {
                    NewFaceShopActivity.this.loadUrl("javascript:__js_bridge_emoticon_del_action(0)");
                }
            }
        });
    }

    private void em(JSONObject jSONObject) {
        TiebaStatic.log(TbadkCoreStatisticKey.FACESHOP_SHARE);
        final ShareItem shareItem = new ShareItem();
        shareItem.title = jSONObject.optString("title");
        shareItem.content = jSONObject.optString("content");
        shareItem.linkUrl = jSONObject.optString("linkUrl");
        shareItem.imageUri = Uri.parse(jSONObject.optString("imageUri"));
        this.iUt = shareItem.linkUrl;
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.NewFaceShopActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                l.showToast(NewFaceShopActivity.this.getPageContext().getPageActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        });
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
    }

    public boolean webViewGoBack() {
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        webViewGoBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iUr != null) {
            this.iUr.cancelLoadData();
        }
        if (this.iUs != null) {
            this.iUs.cancelLoadData();
        }
        this.mWebView.destroy();
        this.mWebView = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                    ayB();
                    return;
                case RequestResponseCode.REQUEST_FACE_GROUP_MAKE /* 25021 */:
                    if (intent != null && intent.getBooleanExtra("uploading", false)) {
                        bz(1, null);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_EMOTION_DETAIL /* 25024 */:
                    loadUrl("javascript:__js_bridge_emoticon_refresh_has_action()");
                    return;
                default:
                    return;
            }
        }
    }

    private void czW() {
        if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceGroupMakeActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_FACE_GROUP_MAKE)));
        }
    }

    private void czT() {
        if (com.baidu.tieba.newfaceshop.facemake.e.diK().diM()) {
            bz(1, null);
        } else if (com.baidu.tieba.newfaceshop.facemake.e.diK().diL() == null) {
            bz(0, null);
        } else {
            FaceGroupDraft diL = com.baidu.tieba.newfaceshop.facemake.e.diK().diL();
            if (!TextUtils.isEmpty(diL.getFailMsg())) {
                bz(2, diL.getFailMsg());
            } else {
                bz(2, null);
            }
        }
    }

    private void ayB() {
        String[] split;
        if (!TextUtils.isEmpty(this.iUt) && this.iUt.contains("emoticonpackage") && (split = this.iUt.split("/")) != null && split.length > 0) {
            String str = split[split.length - 1];
            if (this.iUs == null) {
                this.iUs = new NewFaceGroupShareModel();
            }
            this.iUs.OP(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i + "','" + str + "')");
        } else {
            loadUrl("javascript:__js_bridge_emoticon_uploading_finish_action('" + i + "')");
        }
    }

    private void bz(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i + "','" + str + "')");
        } else {
            loadUrl("javascript:__js_bridge_emoticon_uploading_status_action('" + i + "')");
        }
    }
}
