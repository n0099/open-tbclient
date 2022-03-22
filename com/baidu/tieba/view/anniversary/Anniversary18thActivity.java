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
import c.a.d.f.p.n;
import c.a.o0.r.t.o;
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
/* loaded from: classes6.dex */
public class Anniversary18thActivity extends BaseActivity<Anniversary18thActivity> implements c.a.p0.q4.j.b {
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
    public c.a.p0.q4.j.d.b resultData;
    public EMTextView shareVideoBtn;
    public LinearLayout shareVideoOuder;

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.curProgressNumber > 0 && this.a.curProgressNumber < 100) {
                    this.a.popupMaxureDialog();
                } else {
                    this.a.finish();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.curProgressNumber == 100 && !TextUtils.isEmpty(this.a.mVideoPath)) {
                    c.a.p0.q4.j.a.n(this.a.getPageContext(), this.a.mVideoPath, this.a.mCoverPath, this.a.mTopicName, this.a.mTopicId);
                } else {
                    n.N(TbadkCoreApplication.getInst(), this.a.getString(R.string.obfuscated_res_0x7f0f11d5));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.resultData == null) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<Anniversary18thActivity> pageContext = this.a.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + this.a.resultData.a()});
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f37010b;

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
            this.f37010b = anniversary18thActivity;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
            this.f37010b.model.cancel();
            this.f37010b.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f37011b;

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
            this.f37011b = anniversary18thActivity;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.a) == null) {
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
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091519);
            this.navigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            this.maxureMain = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0913b8);
            this.backImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091efd);
            this.maxureTip = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091494);
            this.shareVideoBtn = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091ce1);
            this.shareVideoOuder = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ce2);
            this.activitive = (EMTextView) findViewById(R.id.obfuscated_res_0x7f091493);
            MaxureLayerView maxureLayerView = (MaxureLayerView) findViewById(R.id.obfuscated_res_0x7f0913bd);
            this.layerView = maxureLayerView;
            maxureLayerView.c(true);
            this.layerView.d(c.a.p0.a4.c.a(SkinManager.getColor(0, (int) R.color.CAM_X0611), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.layerView.g(getResources().getColor(R.color.CAM_X0101));
            this.layerView.f(c.a.p0.a4.c.a(SkinManager.getColor(0, (int) R.color.CAM_X0611), c.a.o0.r.v.a.a(R.string.A_X05)));
            this.layerView.e(c.a.p0.a4.c.a(SkinManager.getColor(0, (int) R.color.CAM_X0101), SkinManager.RESOURCE_ALPHA_PRESS));
            this.layerView.h(UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            this.mRightArrow = (ImageView) findViewById(R.id.obfuscated_res_0x7f091aa5);
            this.activityMain = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090074);
            this.backImageView.setAutoChangeStyle(false);
            this.backImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.backImageView.setDrawCorner(true);
            this.backImageView.setConrers(15);
            this.backImageView.setRadiusById(R.string.J_X06);
            this.backImageView.setPlaceHolderAutoChangeSkinType(2);
            this.backImageView.setDrawBorder(false);
            c.a.o0.r.v.c.d(this.shareVideoBtn).A(R.string.F_X02);
            this.shareVideoOuder.setBackgroundDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080822, WebPManager.ResourceStateType.NORMAL));
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
            TBAlertConfig.a aVar = new TBAlertConfig.a(getString(R.string.obfuscated_res_0x7f0f0e45), TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036c, TBAlertConfig.OperateBtnStyle.SECONDARY);
            o oVar = new o(TbadkCoreApplication.getInst().getCurrentActivity());
            oVar.w(getString(R.string.obfuscated_res_0x7f0f11d4));
            oVar.p(getString(R.string.obfuscated_res_0x7f0f11d3));
            oVar.n(true);
            oVar.r(aVar2, aVar);
            oVar.i(false);
            AlertDialog y = oVar.y();
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
                this.navigationBar.getBackImageView().setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.obfuscated_res_0x7f080624, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS, false));
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

    @Override // c.a.p0.q4.j.b
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            n.N(TbadkCoreApplication.getInst(), str);
        }
    }

    @Override // c.a.p0.q4.j.b
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

    @Override // c.a.p0.q4.j.b
    public void onMuxerSucess(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            this.mVideoPath = c.a.p0.q4.j.a.m(getPageContext(), str);
            this.mCoverPath = str2;
            this.mTopicName = str3;
            this.mTopicId = str4;
            this.layerView.setVisibility(8);
            this.maxureTip.setText(getString(R.string.obfuscated_res_0x7f0f11d7));
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

    @Override // c.a.p0.q4.j.b
    public void onResponeSucess(c.a.p0.q4.j.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.resultData = bVar;
            TbImageView tbImageView = this.backImageView;
            if (tbImageView != null) {
                tbImageView.J(bVar.b(), 10, false);
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

    @Override // c.a.p0.q4.j.b
    public void onUpdateProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.curProgressNumber = i;
            this.layerView.setProgress(i);
        }
    }
}
