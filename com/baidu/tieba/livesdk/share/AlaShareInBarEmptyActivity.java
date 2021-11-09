package com.baidu.tieba.livesdk.share;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.e.e.p.j;
import b.a.r0.t1.d;
import b.a.r0.t1.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.livesdk.share.model.AlaShareInBarModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class AlaShareInBarEmptyActivity extends BaseActivity<AlaShareInBarEmptyActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mLiveId;
    public final AlaShareInBarModel.b mOnPostDataCallBack;
    public AlaShareInBarModel mPostModel;
    public ArrayList<TransmitForumData> mTransmitForumDataList;
    public String mYyAnchorBdUid;

    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaShareInBarEmptyActivity f51282e;

        public a(AlaShareInBarEmptyActivity alaShareInBarEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaShareInBarEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51282e = alaShareInBarEmptyActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f51282e.mPostModel.cancelLoadData();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AlaShareInBarModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaShareInBarEmptyActivity f51283a;

        public b(AlaShareInBarEmptyActivity alaShareInBarEmptyActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaShareInBarEmptyActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51283a = alaShareInBarEmptyActivity;
        }

        @Override // com.baidu.tieba.livesdk.share.model.AlaShareInBarModel.b
        public void a(int i2, String str, b.a.r0.t1.l.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, aVar) == null) {
                this.f51283a.closeLoadingDialog();
                int i3 = 1;
                if (i2 == 0 && aVar != null) {
                    BdToast.h(this.f51283a.getPageContext().getPageActivity(), this.f51283a.getPageContext().getPageActivity().getString(g.share_alert_success), d.icon_pure_toast_succeed40_svg, 3000, true).q();
                } else {
                    this.f51283a.showToast(str);
                    i3 = 2;
                }
                Intent intent = new Intent();
                intent.putExtra("extra_share_status", i3);
                this.f51283a.setResult(-1, intent);
                this.f51283a.finish();
            }
        }
    }

    public AlaShareInBarEmptyActivity() {
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
        this.mLiveId = "";
        this.mOnPostDataCallBack = new b(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bundle) == null) {
            AlaShareInBarModel alaShareInBarModel = new AlaShareInBarModel();
            this.mPostModel = alaShareInBarModel;
            alaShareInBarModel.z(this.mOnPostDataCallBack);
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
            if (!j.z()) {
                showToast(g.neterror);
                finish();
            } else if ((StringUtils.isNull(this.mLiveId) && TextUtils.isEmpty(this.mYyAnchorBdUid)) || ListUtils.isEmpty(this.mTransmitForumDataList)) {
                finish();
            } else {
                showLoadingDialog((String) null, new a(this));
                TransmitForumData transmitForumData = this.mTransmitForumDataList.get(0);
                if (transmitForumData != null) {
                    this.mPostModel.y(this.mLiveId, this.mYyAnchorBdUid, String.valueOf(transmitForumData.forumId), "");
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
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            super.overridePendingTransition(0, 0);
        }
    }
}
