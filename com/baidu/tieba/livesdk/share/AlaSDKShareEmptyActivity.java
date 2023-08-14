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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.abtest.UsbAbTestConst;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.qz8;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class AlaSDKShareEmptyActivity extends BaseActivity<AlaSDKShareEmptyActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public long j;
    public String k;
    public ShareItem l;
    public qz8 m;

    /* loaded from: classes6.dex */
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
                if (this.a.l == null || !this.a.l.getIsShowShare()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, 3));
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.B1();
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.A1();
                if (this.a.l != null) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE);
                    statisticItem.addParam("obj_type", this.a.l.voiceRoomShareType);
                    statisticItem.addParam(TiebaStatic.Params.TIEBA_PARAMS, "copylink");
                    statisticItem.addParam("room_id", this.a.l.voiceRoomId);
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
        this.e = 0;
        this.f = 0;
    }

    public final void A1() {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (shareItem = this.l) == null) {
            return;
        }
        AndroidUtils.copyToClipboard(x1(shareItem.linkUrl));
        BdUtilHelper.showToast(getApplicationContext(), getResources().getString(R.string.copy_pb_url_success));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            qz8 qz8Var = this.m;
            if (qz8Var != null) {
                qz8Var.d();
            }
        }
    }

    public final void z1() {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (shareItem = this.l) == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this, this.e, shareItem, true));
    }

    public static String x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && str.length() != 0) {
                if (str.contains("source=")) {
                    return str;
                }
                if (str.contains("shareVoiceRoom")) {
                    String str2 = "?";
                    if (str.contains("?")) {
                        str2 = "&";
                    }
                    return str + str2 + "source=" + UsbAbTestConst.KEY_SHARE_H5_CARD_OPTIMIZE;
                }
                return str;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("title", this.a);
            bundle.putString("content", this.b);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY, this.c);
            bundle.putString("linkurl", this.d);
            bundle.putInt("channel", this.e);
            bundle.putInt("action", this.f);
            bundle.putString("liveid", this.g);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO, this.h);
            bundle.putString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID, this.i);
        }
    }

    public final void B1() {
        qz8 qz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity()) && (qz8Var = this.m) != null) {
            if (ListUtils.isEmpty(qz8Var.b())) {
                this.m.c();
            }
            this.m.e(JavaTypesHelper.toLong(this.g, 0L), this.i, this.l);
        }
    }

    public final void D1() {
        ShareItem shareItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (shareItem = this.l) == null) {
            return;
        }
        shareItem.setShowShare(false);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this, this.l, true);
        shareDialogConfig.setAlaLiveRoomShare(true);
        shareDialogConfig.setIsSupportNightMode(false);
        shareDialogConfig.setIsLandscape(false);
        shareDialogConfig.setOnDismissListener(new a(this));
        if (TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.i)) {
            if (this.j > 0) {
                shareDialogConfig.addOutsideTextView(R.string.share_copy, R.drawable.icon_pure_share_copy40, new c(this));
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_VOICE_ROOM_SHARE_PANEL);
                statisticItem.addParam("room_id", this.j);
                statisticItem.addParam("obj_type", this.k);
                statisticItem.eventStat();
            }
        } else {
            shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f027a, R.drawable.obfuscated_res_0x7f080b04, new b(this));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        qz8 qz8Var = this.m;
        if (qz8Var != null) {
            qz8Var.c();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 24007) {
                if (intent == null) {
                    intExtra = 1;
                } else {
                    intExtra = intent.getIntExtra("extra_share_status", 2);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921550, Integer.valueOf(intExtra)));
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            this.m = new qz8(getPageContext());
            if (bundle != null) {
                this.a = bundle.getString("title");
                this.b = bundle.getString("content");
                this.c = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
                this.d = bundle.getString("linkurl");
                this.e = bundle.getInt("channel");
                this.f = bundle.getInt("action");
                this.g = bundle.getString("liveid");
                this.j = bundle.getLong("room_id");
                this.k = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_VOICE_ROOM_TYPE);
                this.h = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
                this.i = bundle.getString(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
            } else if (getIntent() == null) {
                finish();
                return;
            } else {
                this.a = getIntent().getStringExtra("title");
                this.b = getIntent().getStringExtra("content");
                this.c = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_IMAGEURI_KEY);
                this.d = getIntent().getStringExtra("linkurl");
                this.e = getIntent().getIntExtra("channel", 0);
                this.f = getIntent().getIntExtra("action", 0);
                this.g = getIntent().getStringExtra("liveid");
                this.j = getIntent().getLongExtra("room_id", 0L);
                this.k = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_VOICE_ROOM_TYPE);
                this.h = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_EXT_INFO);
                this.i = getIntent().getStringExtra(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_YY_ANCHOR_BDUID);
            }
            this.l = y1();
            int i = this.f;
            if (i == 1) {
                D1();
            } else if (i == 2) {
                z1();
            } else {
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }

    public final ShareItem y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.title = this.a;
            shareItem.content = this.b;
            if (!StringUtils.isNull(this.c)) {
                if (this.c.startsWith("file://")) {
                    shareItem.localFile = this.c.substring(7);
                } else {
                    shareItem.imageUri = Uri.parse(this.c);
                }
            }
            shareItem.linkUrl = this.d;
            shareItem.extData = this.g;
            shareItem.extLiveInfo = this.h;
            shareItem.mYyAnchorBdUid = this.i;
            shareItem.voiceRoomId = this.j;
            shareItem.voiceRoomShareType = this.k;
            return shareItem;
        }
        return (ShareItem) invokeV.objValue;
    }
}
