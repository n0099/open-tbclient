package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.f08;
import com.baidu.tieba.livesdk.share.model.AlaShareInBarModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class AlaShareInBarEmptyActivity extends BaseActivity<AlaShareInBarEmptyActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ArrayList<TransmitForumData> c;
    public AlaShareInBarModel d;
    public final AlaShareInBarModel.b e;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaShareInBarEmptyActivity a;

        public a(AlaShareInBarEmptyActivity alaShareInBarEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaShareInBarEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaShareInBarEmptyActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.d.cancelLoadData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AlaShareInBarModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaShareInBarEmptyActivity a;

        public b(AlaShareInBarEmptyActivity alaShareInBarEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaShareInBarEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaShareInBarEmptyActivity;
        }

        @Override // com.baidu.tieba.livesdk.share.model.AlaShareInBarModel.b
        public void a(int i, String str, f08 f08Var) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, f08Var) == null) {
                this.a.closeLoadingDialog();
                if (i == 0 && f08Var != null) {
                    BdToast b = BdToast.b(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getPageActivity().getString(R.string.share_alert_success));
                    b.g(BdToast.ToastIcon.SUCCESS);
                    b.d(3000);
                    b.k();
                    i2 = 1;
                } else {
                    this.a.showToast(str);
                    i2 = 2;
                }
                Intent intent = new Intent();
                intent.putExtra("extra_share_status", i2);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    public AlaShareInBarEmptyActivity() {
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
        this.a = "";
        this.e = new b(this);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            AlaShareInBarModel alaShareInBarModel = this.d;
            if (alaShareInBarModel != null) {
                alaShareInBarModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            x1(bundle);
            y1();
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }

    public final void x1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            AlaShareInBarModel alaShareInBarModel = new AlaShareInBarModel();
            this.d = alaShareInBarModel;
            alaShareInBarModel.Q(this.e);
            Intent intent = getIntent();
            if (intent != null) {
                this.a = intent.getStringExtra("extra_key_live_id");
                this.b = intent.getStringExtra("extra_key_yy_anchor_bduid");
                this.c = intent.getParcelableArrayListExtra(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
            } else if (bundle != null) {
                this.a = bundle.getString("extra_key_live_id");
                this.b = bundle.getString("extra_key_yy_anchor_bduid");
                this.c = bundle.getParcelableArrayList(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
            }
        }
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0d11);
                finish();
            } else if ((StringUtils.isNull(this.a) && TextUtils.isEmpty(this.b)) || ListUtils.isEmpty(this.c)) {
                finish();
            } else {
                showLoadingDialog((String) null, new a(this));
                TransmitForumData transmitForumData = this.c.get(0);
                if (transmitForumData != null) {
                    this.d.P(this.a, this.b, String.valueOf(transmitForumData.forumId), "");
                }
            }
        }
    }
}
