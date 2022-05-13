package com.baidu.tieba.view.anniversary;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.anniversary.model.AnniversaryEtModel;
import com.baidu.tieba.view.anniversary.view.MaxureLayerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs4;
import com.repackage.di8;
import com.repackage.es4;
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.vv8;
import com.repackage.wv8;
import com.repackage.zv8;
/* loaded from: classes4.dex */
public class Anniversary18thActivity extends BaseActivity<Anniversary18thActivity> implements wv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EMTextView activitive;
    public LinearLayout activityMain;
    public TbImageView backImageView;
    public int curProgressNumber;
    public MaxureLayerView layerView;
    public String mCoverPath;
    public PermissionJudgePolicy mPermissionJudgePolicy;
    public ImageView mRightArrow;
    public String mTopicId;
    public String mTopicName;
    public String mVideoPath;
    public RelativeLayout maxureMain;
    public EMTextView maxureTip;
    public AnniversaryEtModel model;
    public NavigationBar navigationBar;
    public zv8 resultData;
    public EMTextView shareVideoBtn;
    public LinearLayout shareVideoOuder;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public a(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.curProgressNumber > 0 && this.a.curProgressNumber < 100) {
                    this.a.popupMaxureDialog();
                } else {
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public b(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.curProgressNumber == 100 && !TextUtils.isEmpty(this.a.mVideoPath)) {
                    vv8.n(this.a.getPageContext(), this.a.mVideoPath, this.a.mCoverPath, this.a.mTopicName, this.a.mTopicId);
                } else {
                    mi.N(TbadkCoreApplication.getInst(), this.a.getString(R.string.obfuscated_res_0x7f0f11f9));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public c(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.resultData == null) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<Anniversary18thActivity> pageContext = this.a.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + this.a.resultData.a()});
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PermissionJudgePolicy.PermissionDialogClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public d(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
        public void onDialogCaneled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.finish();
            }
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
        public void onDialogComfirmed(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Anniversary18thActivity a;

        public e(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = anniversary18thActivity;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.model == null) {
                return;
            }
            this.a.model.B(this.a.resultData);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Anniversary18thActivity b;

        public f(Anniversary18thActivity anniversary18thActivity, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = anniversary18thActivity;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
            this.b.model.cancel();
            this.b.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ Anniversary18thActivity b;

        public g(Anniversary18thActivity anniversary18thActivity, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = anniversary18thActivity;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    public Anniversary18thActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091534);
            this.navigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            this.maxureMain = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0913c2);
            this.backImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091f42);
            this.maxureTip = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0914a8);
            this.shareVideoBtn = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091d26);
            this.shareVideoOuder = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d27);
            this.activitive = (EMTextView) findViewById(R.id.obfuscated_res_0x7f0914a7);
            MaxureLayerView maxureLayerView = (MaxureLayerView) findViewById(R.id.obfuscated_res_0x7f0913cb);
            this.layerView = maxureLayerView;
            maxureLayerView.c(true);
            this.layerView.d(di8.a(SkinManager.getColor(0, (int) R.color.CAM_X0611), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.layerView.g(getResources().getColor(R.color.CAM_X0101));
            this.layerView.f(di8.a(SkinManager.getColor(0, (int) R.color.CAM_X0611), es4.a(R.string.A_X05)));
            this.layerView.e(di8.a(SkinManager.getColor(0, (int) R.color.CAM_X0101), SkinManager.RESOURCE_ALPHA_PRESS));
            this.layerView.h(UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            this.mRightArrow = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ae3);
            this.activityMain = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090073);
            this.backImageView.setAutoChangeStyle(false);
            this.backImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.backImageView.setDrawCorner(true);
            this.backImageView.setConrers(15);
            this.backImageView.setRadiusById(R.string.J_X06);
            this.backImageView.setPlaceHolderAutoChangeSkinType(2);
            this.backImageView.setDrawBorder(false);
            gs4.d(this.shareVideoBtn).A(R.string.F_X02);
            this.shareVideoOuder.setBackgroundDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080815, WebPManager.ResourceStateType.NORMAL));
            this.shareVideoBtn.setOnClickListener(new b(this));
            this.activityMain.setOnClickListener(new c(this));
            onUpdateProgress(0);
            this.model.A(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupMaxureDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            TBAlertConfig.a aVar = new TBAlertConfig.a(getString(R.string.obfuscated_res_0x7f0f0e66), TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0374, TBAlertConfig.OperateBtnStyle.SECONDARY);
            bs4 bs4Var = new bs4(TbadkCoreApplication.getInst().getCurrentActivity());
            bs4Var.w(getString(R.string.obfuscated_res_0x7f0f11f8));
            bs4Var.p(getString(R.string.obfuscated_res_0x7f0f11f7));
            bs4Var.n(true);
            bs4Var.r(aVar2, aVar);
            bs4Var.i(false);
            AlertDialog y = bs4Var.y();
            aVar.a(new f(this, y));
            aVar2.a(new g(this, y));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.navigationBar.onChangeSkinType(getPageContext(), 0);
            if (this.navigationBar.getBackImageView() != null) {
                this.navigationBar.getBackImageView().setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS, false));
            }
            this.mRightArrow.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(0, (int) R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002a);
            setSwipeBackEnabled(false);
            this.model = new AnniversaryEtModel(getPageContext(), this);
            init();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            AnniversaryEtModel anniversaryEtModel = this.model;
            if (anniversaryEtModel != null) {
                anniversaryEtModel.cancel();
            }
        }
    }

    @Override // com.repackage.wv8
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            mi.N(TbadkCoreApplication.getInst(), str);
        }
    }

    @Override // com.repackage.wv8
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (i == 4 && (i2 = this.curProgressNumber) > 0 && i2 < 100) {
                popupMaxureDialog();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.repackage.wv8
    public void onMuxerSucess(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            this.mVideoPath = vv8.m(getPageContext(), str);
            this.mCoverPath = str2;
            this.mTopicName = str3;
            this.mTopicId = str4;
            this.layerView.setVisibility(8);
            this.maxureTip.setText(getString(R.string.obfuscated_res_0x7f0f11fb));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            boolean checkPermissionForbidden = (iArr[0] == 0 || (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) == null) ? false : permissionJudgePolicy.checkPermissionForbidden(this, strArr[0]);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr[i2] != 0) {
                    if (checkPermissionForbidden) {
                        finish();
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.repackage.wv8
    public void onResponeSucess(zv8 zv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zv8Var) == null) {
            this.resultData = zv8Var;
            TbImageView tbImageView = this.backImageView;
            if (tbImageView != null) {
                tbImageView.K(zv8Var.b(), 10, false);
            }
            if (this.mPermissionJudgePolicy == null) {
                this.mPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mPermissionJudgePolicy.clearRequestPermissionList();
            this.mPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            this.mPermissionJudgePolicy.setDialogClickListener(new d(this));
            this.mPermissionJudgePolicy.setOnPermissionsGrantedListener(new e(this));
            if (this.mPermissionJudgePolicy.startRequestPermission(this)) {
            }
        }
    }

    @Override // com.repackage.wv8
    public void onUpdateProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.curProgressNumber = i;
            this.layerView.setProgress(i);
        }
    }
}
