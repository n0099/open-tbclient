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
import c.a.s0.s.s.m;
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
/* loaded from: classes12.dex */
public class Anniversary18thActivity extends BaseActivity<Anniversary18thActivity> implements c.a.t0.n4.i.b {
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
    public c.a.t0.n4.i.d.b resultData;
    public EMTextView shareVideoBtn;
    public LinearLayout shareVideoOuder;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f49244e;

        public a(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49244e = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49244e.curProgressNumber > 0 && this.f49244e.curProgressNumber < 100) {
                    this.f49244e.popupMaxureDialog();
                } else {
                    this.f49244e.finish();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f49245e;

        public b(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49245e = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49245e.curProgressNumber == 100 && !TextUtils.isEmpty(this.f49245e.mVideoPath)) {
                    c.a.t0.n4.i.a.n(this.f49245e.getPageContext(), this.f49245e.mVideoPath, this.f49245e.mCoverPath, this.f49245e.mTopicName, this.f49245e.mTopicId);
                } else {
                    n.N(TbadkCoreApplication.getInst(), this.f49245e.getString(R.string.sticker_maxure_video_download));
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f49246e;

        public c(Anniversary18thActivity anniversary18thActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49246e = anniversary18thActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49246e.resultData == null) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<Anniversary18thActivity> pageContext = this.f49246e.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + this.f49246e.resultData.a()});
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.a.model.z(this.a.resultData);
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f49248f;

        public f(Anniversary18thActivity anniversary18thActivity, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49248f = anniversary18thActivity;
            this.f49247e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f49247e) == null) {
                return;
            }
            alertDialog.dismiss();
            this.f49248f.model.cancel();
            this.f49248f.finish();
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlertDialog f49249e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Anniversary18thActivity f49250f;

        public g(Anniversary18thActivity anniversary18thActivity, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {anniversary18thActivity, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49250f = anniversary18thActivity;
            this.f49249e = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (alertDialog = this.f49249e) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.navigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a(this));
            this.maxureMain = (RelativeLayout) findViewById(R.id.masure_main);
            this.backImageView = (TbImageView) findViewById(R.id.tb_background);
            this.maxureTip = (EMTextView) findViewById(R.id.mxsure_tip);
            this.shareVideoBtn = (EMTextView) findViewById(R.id.share_video);
            this.shareVideoOuder = (LinearLayout) findViewById(R.id.share_video_ouder);
            this.activitive = (EMTextView) findViewById(R.id.mxsure_activitive);
            MaxureLayerView maxureLayerView = (MaxureLayerView) findViewById(R.id.maxure_layer);
            this.layerView = maxureLayerView;
            maxureLayerView.setHasText(true);
            this.layerView.setLayerColor(c.a.t0.w3.c.a(SkinManager.getColor(0, R.color.CAM_X0611), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.layerView.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.layerView.setTextBackColor(c.a.t0.w3.c.a(SkinManager.getColor(0, R.color.CAM_X0611), c.a.s0.s.u.a.a(R.string.A_X05)));
            this.layerView.setLayerLineColor(c.a.t0.w3.c.a(SkinManager.getColor(0, R.color.CAM_X0101), SkinManager.RESOURCE_ALPHA_PRESS));
            this.layerView.setTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            this.mRightArrow = (ImageView) findViewById(R.id.right_arrow);
            this.activityMain = (LinearLayout) findViewById(R.id.activity_main);
            this.backImageView.setAutoChangeStyle(false);
            this.backImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.backImageView.setDrawCorner(true);
            this.backImageView.setConrers(15);
            this.backImageView.setRadiusById(R.string.J_X06);
            this.backImageView.setPlaceHolderAutoChangeSkinType(2);
            this.backImageView.setDrawBorder(false);
            c.a.s0.s.u.c.d(this.shareVideoBtn).A(R.string.F_X02);
            this.shareVideoOuder.setBackgroundDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_share_video, WebPManager.ResourceStateType.NORMAL));
            this.shareVideoBtn.setOnClickListener(new b(this));
            this.activityMain.setOnClickListener(new c(this));
            onUpdateProgress(0);
            this.model.y(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void popupMaxureDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            TBAlertConfig.a aVar = new TBAlertConfig.a(getString(R.string.pickerview_submit), TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            m mVar = new m(TbadkCoreApplication.getInst().getCurrentActivity());
            mVar.s(getString(R.string.sticker_maxure_video_dialog_title));
            mVar.n(getString(R.string.sticker_maxure_video_dialog_content));
            mVar.l(true);
            mVar.p(aVar2, aVar);
            mVar.g(false);
            AlertDialog u = mVar.u();
            aVar.a(new f(this, u));
            aVar2.a(new g(this, u));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.navigationBar.onChangeSkinType(getPageContext(), 0);
            if (this.navigationBar.getBackImageView() != null) {
                this.navigationBar.getBackImageView().setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS, false));
            }
            this.mRightArrow.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(0, R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_anniversary18th);
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

    @Override // c.a.t0.n4.i.b
    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            n.N(TbadkCoreApplication.getInst(), str);
        }
    }

    @Override // c.a.t0.n4.i.b
    public void onFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (i3 = this.curProgressNumber) > 0 && i3 < 100) {
                popupMaxureDialog();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // c.a.t0.n4.i.b
    public void onMuxerSucess(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, str4) == null) {
            this.mVideoPath = c.a.t0.n4.i.a.m(getPageContext(), str);
            this.mCoverPath = str2;
            this.mTopicName = str3;
            this.mTopicId = str4;
            this.layerView.setVisibility(8);
            this.maxureTip.setText(getString(R.string.sticker_maxure_video_end));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionJudgePolicy permissionJudgePolicy;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (iArr == null || iArr.length <= 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            boolean checkPermissionForbidden = (iArr[0] == 0 || (permissionJudgePolicy = this.mCurrentPermissionJudgePolicy) == null) ? false : permissionJudgePolicy.checkPermissionForbidden(this, strArr[0]);
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (iArr[i3] != 0) {
                    if (checkPermissionForbidden) {
                        finish();
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // c.a.t0.n4.i.b
    public void onResponeSucess(c.a.t0.n4.i.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.resultData = bVar;
            TbImageView tbImageView = this.backImageView;
            if (tbImageView != null) {
                tbImageView.startLoad(bVar.b(), 10, false);
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

    @Override // c.a.t0.n4.i.b
    public void onUpdateProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.curProgressNumber = i2;
            this.layerView.setProgress(i2);
        }
    }
}
