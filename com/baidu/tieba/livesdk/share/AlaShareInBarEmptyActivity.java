package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.livesdk.share.model.AlaShareInBarModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ji;
import com.repackage.oc7;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaShareInBarEmptyActivity extends BaseActivity<AlaShareInBarEmptyActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mLiveId;
    public final AlaShareInBarModel.b mOnPostDataCallBack;
    public AlaShareInBarModel mPostModel;
    public ArrayList<TransmitForumData> mTransmitForumDataList;
    public String mYyAnchorBdUid;

    /* loaded from: classes3.dex */
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
                this.a.mPostModel.cancelLoadData();
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void a(int i, String str, oc7 oc7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, oc7Var) == null) {
                this.a.closeLoadingDialog();
                int i2 = 1;
                if (i == 0 && oc7Var != null) {
                    BdToast.h(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f113c), R.drawable.obfuscated_res_0x7f0809cc, 3000, true).n();
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
        this.mLiveId = "";
        this.mOnPostDataCallBack = new b(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bundle) == null) {
            AlaShareInBarModel alaShareInBarModel = new AlaShareInBarModel();
            this.mPostModel = alaShareInBarModel;
            alaShareInBarModel.B(this.mOnPostDataCallBack);
            Intent intent = getIntent();
            if (intent != null) {
                this.mLiveId = intent.getStringExtra("extra_key_live_id");
                this.mYyAnchorBdUid = intent.getStringExtra("extra_key_yy_anchor_bduid");
                this.mTransmitForumDataList = intent.getParcelableArrayListExtra(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
            } else if (bundle != null) {
                this.mLiveId = bundle.getString("extra_key_live_id");
                this.mYyAnchorBdUid = bundle.getString("extra_key_yy_anchor_bduid");
                this.mTransmitForumDataList = bundle.getParcelableArrayList(AlaWriteShareInBarActivityConfig.EXTRA_KEY_FORUM_LIST);
            }
        }
    }

    private void sendRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (!ji.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c33);
                finish();
            } else if ((StringUtils.isNull(this.mLiveId) && TextUtils.isEmpty(this.mYyAnchorBdUid)) || ListUtils.isEmpty(this.mTransmitForumDataList)) {
                finish();
            } else {
                showLoadingDialog((String) null, new a(this));
                TransmitForumData transmitForumData = this.mTransmitForumDataList.get(0);
                if (transmitForumData != null) {
                    this.mPostModel.A(this.mLiveId, this.mYyAnchorBdUid, String.valueOf(transmitForumData.forumId), "");
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            initData(bundle);
            sendRequest();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            AlaShareInBarModel alaShareInBarModel = this.mPostModel;
            if (alaShareInBarModel != null) {
                alaShareInBarModel.onDestroy();
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
