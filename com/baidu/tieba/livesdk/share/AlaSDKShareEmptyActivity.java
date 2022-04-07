package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di;
import com.repackage.mg;
import com.repackage.oi;
import com.repackage.te7;
/* loaded from: classes3.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAction;
    public int mChannel;
    public String mContent;
    public String mImageUri;
    public String mLinkUrl;
    public String mLiveExtInfo;
    public String mLiveId;
    public te7 mSelectBarController;
    public ShareItem mShareItem;
    public String mTitle;
    public long mVoiceRoomId;
    public String mVoiceRoomShareType;
    public String mYyAnchorBdUid;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSDKShareEmptyActivity a;

        public a(AlaSDKShareEmptyActivity alaSDKShareEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSDKShareEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSDKShareEmptyActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.mShareItem == null || !this.a.mShareItem.d()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, 3));
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSDKShareEmptyActivity a;

        public b(AlaSDKShareEmptyActivity alaSDKShareEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSDKShareEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSDKShareEmptyActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.shareInBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSDKShareEmptyActivity a;

        public c(AlaSDKShareEmptyActivity alaSDKShareEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSDKShareEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSDKShareEmptyActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.shareByCopyLink();
                if (this.a.mShareItem != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
                    statisticItem.addParam("obj_type", this.a.mShareItem.V);
                    statisticItem.addParam(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                    statisticItem.addParam("room_id", this.a.mShareItem.U);
                    statisticItem.eventStat();
                }
            }
        }
    }

    public AlaSDKShareEmptyActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mChannel = 0;
        this.mAction = 0;
    }

    private ShareItem dealShareEntity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.mTitle;
            shareItem.s = this.mContent;
            if (!StringUtils.isNull(this.mImageUri)) {
                if (this.mImageUri.startsWith("file://")) {
                    shareItem.x = this.mImageUri.substring(7);
                } else {
                    shareItem.v = Uri.parse(this.mImageUri);
                }
            }
            shareItem.t = this.mLinkUrl;
            shareItem.q = this.mLiveId;
            shareItem.r0 = this.mLiveExtInfo;
            shareItem.z = this.mYyAnchorBdUid;
            shareItem.U = this.mVoiceRoomId;
            shareItem.V = this.mVoiceRoomShareType;
            return shareItem;
        }
        return (ShareItem) invokeV.objValue;
    }

    private void sendChannelShareReq() {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (shareItem = this.mShareItem) == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this, this.mChannel, shareItem, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareByCopyLink() {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || (shareItem = this.mShareItem) == null) {
            return;
        }
        di.a(shareItem.t);
        oi.N(getApplicationContext(), getResources().getString(R.string.obfuscated_res_0x7f0f043f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareInBar() {
        te7 te7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && (te7Var = this.mSelectBarController) != null) {
            if (ListUtils.isEmpty(te7Var.b())) {
                this.mSelectBarController.c();
            }
            this.mSelectBarController.e(mg.g(this.mLiveId, 0L), this.mYyAnchorBdUid, this.mShareItem);
        }
    }

    private void showSharePanel() {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (shareItem = this.mShareItem) == null) {
            return;
        }
        shareItem.j(false);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this, this.mShareItem, true);
        shareDialogConfig.setAlaLiveRoomShare(true);
        shareDialogConfig.setIsSupportNightMode(false);
        shareDialogConfig.setIsLandscape(false);
        shareDialogConfig.setOnDismissListener(new a(this));
        if (TextUtils.isEmpty(this.mLiveId) && TextUtils.isEmpty(this.mYyAnchorBdUid)) {
            if (this.mVoiceRoomId > 0) {
                shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f1118, R.drawable.obfuscated_res_0x7f08098b, new c(this));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE_PANEL);
                statisticItem.addParam("room_id", this.mVoiceRoomId);
                statisticItem.addParam("obj_type", this.mVoiceRoomShareType);
                statisticItem.eventStat();
            }
        } else {
            shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f0241, R.drawable.obfuscated_res_0x7f0808da, new b(this));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        te7 te7Var = this.mSelectBarController;
        if (te7Var != null) {
            te7Var.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 24007 && intent != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, Integer.valueOf(intent.getIntExtra("extra_share_status", 2))));
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.mSelectBarController = new te7(getPageContext());
            if (bundle != null) {
                this.mTitle = bundle.getString("title");
                this.mContent = bundle.getString("content");
                this.mImageUri = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
                this.mLinkUrl = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
                this.mChannel = bundle.getInt("channel");
                this.mAction = bundle.getInt("action");
                this.mLiveId = bundle.getString("liveid");
                this.mVoiceRoomId = bundle.getLong("room_id");
                this.mVoiceRoomShareType = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_VOICE_ROOM_TYPE);
                this.mLiveExtInfo = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
                this.mYyAnchorBdUid = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
            } else if (getIntent() == null) {
                finish();
                return;
            } else {
                this.mTitle = getIntent().getStringExtra("title");
                this.mContent = getIntent().getStringExtra("content");
                this.mImageUri = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
                this.mLinkUrl = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY);
                this.mChannel = getIntent().getIntExtra("channel", 0);
                this.mAction = getIntent().getIntExtra("action", 0);
                this.mLiveId = getIntent().getStringExtra("liveid");
                this.mVoiceRoomId = getIntent().getLongExtra("room_id", 0L);
                this.mVoiceRoomShareType = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_VOICE_ROOM_TYPE);
                this.mLiveExtInfo = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
                this.mYyAnchorBdUid = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
            }
            this.mShareItem = dealShareEntity();
            int i = this.mAction;
            if (i == 1) {
                showSharePanel();
            } else if (i == 2) {
                sendChannelShareReq();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            te7 te7Var = this.mSelectBarController;
            if (te7Var != null) {
                te7Var.d();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("title", this.mTitle);
            bundle.putString("content", this.mContent);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY, this.mImageUri);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LINKURL_KEY, this.mLinkUrl);
            bundle.putInt("channel", this.mChannel);
            bundle.putInt("action", this.mAction);
            bundle.putString("liveid", this.mLiveId);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO, this.mLiveExtInfo);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID, this.mYyAnchorBdUid);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
