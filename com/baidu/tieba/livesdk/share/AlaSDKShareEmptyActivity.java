package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
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
    public c.a.r0.c2.e.a.a mSelectBarController;
    public ShareItem mShareItem;
    public String mTitle;
    public long mVoiceRoomId;
    public String mVoiceRoomShareType;
    public String mYyAnchorBdUid;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSDKShareEmptyActivity f44277e;

        public a(AlaSDKShareEmptyActivity alaSDKShareEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSDKShareEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44277e = alaSDKShareEmptyActivity;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f44277e.mShareItem == null || !this.f44277e.mShareItem.d()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, 3));
                    this.f44277e.finish();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSDKShareEmptyActivity f44278e;

        public b(AlaSDKShareEmptyActivity alaSDKShareEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSDKShareEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44278e = alaSDKShareEmptyActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44278e.shareInBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSDKShareEmptyActivity f44279e;

        public c(AlaSDKShareEmptyActivity alaSDKShareEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSDKShareEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44279e = alaSDKShareEmptyActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44279e.shareByCopyLink();
                if (this.f44279e.mShareItem != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
                    statisticItem.addParam("obj_type", this.f44279e.mShareItem.V);
                    statisticItem.addParam(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                    statisticItem.addParam("room_id", this.f44279e.mShareItem.U);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        c.a.d.f.p.c.a(shareItem.t);
        n.N(getApplicationContext(), getResources().getString(R.string.copy_pb_url_success));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareInBar() {
        c.a.r0.c2.e.a.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && (aVar = this.mSelectBarController) != null) {
            if (ListUtils.isEmpty(aVar.b())) {
                this.mSelectBarController.c();
            }
            this.mSelectBarController.e(c.a.d.f.m.b.g(this.mLiveId, 0L), this.mYyAnchorBdUid, this.mShareItem);
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
                shareDialogConfig.addOutsideTextView(R.string.share_copy, R.drawable.icon_pure_share_copy40, new c(this));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE_PANEL);
                statisticItem.addParam("room_id", this.mVoiceRoomId);
                statisticItem.addParam("obj_type", this.mVoiceRoomShareType);
                statisticItem.eventStat();
            }
        } else {
            shareDialogConfig.addOutsideTextView(R.string.ala_share_to_tieba_frs_title, R.drawable.icon_pure_ala_share_morebar40_svg, new b(this));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        c.a.r0.c2.e.a.a aVar = this.mSelectBarController;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 24007 && intent != null) {
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
            this.mSelectBarController = new c.a.r0.c2.e.a.a(getPageContext());
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
            int i2 = this.mAction;
            if (i2 == 1) {
                showSharePanel();
            } else if (i2 == 2) {
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
            c.a.r0.c2.e.a.a aVar = this.mSelectBarController;
            if (aVar != null) {
                aVar.d();
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
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
