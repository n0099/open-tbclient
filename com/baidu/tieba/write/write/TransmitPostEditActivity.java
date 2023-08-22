package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.di;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.i1b;
import com.baidu.tieba.jg;
import com.baidu.tieba.jx5;
import com.baidu.tieba.li5;
import com.baidu.tieba.mt4;
import com.baidu.tieba.ni5;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.uc5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.wxa;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class TransmitPostEditActivity extends AbsBaseWriteActivity<TransmitPostEditActivity> implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final int y0;
    public static final int z0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaijiahaoData g0;
    public OriginalThreadInfo.ShareInfo h0;
    public OriginalThreadCardView i0;
    public String j0;
    public String r0;
    public String s0;
    public String t0;
    public DialogInterface.OnCancelListener u0;
    public NewWriteModel v0;
    public String w0;
    public boolean x0;

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.color.CAM_X0207 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.IPageStayDuration
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public a(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.J.setVisibility(0);
                this.a.M.setSelected(true);
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                jg.l(transmitPostEditActivity.K, view2, 0, BdUtilHelper.dip2px(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.S.t();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.f1184T, transmitPostEditActivity2.A);
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.f1184T, transmitPostEditActivity3.E);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public b(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.J.setSelected(true);
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                jg.l(transmitPostEditActivity.K, view2, 0, BdUtilHelper.dip2px(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.S.t();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.f1184T, transmitPostEditActivity2.U1());
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.f1184T, transmitPostEditActivity3.S1());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public c(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"StringFormatInvalid"})
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e29);
                }
                if (jx5.a() || this.a.T2()) {
                    return;
                }
                if (this.a.U2()) {
                    new BdTopToast(this.a.getActivity()).setIcon(false).setContent(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f13a9), this.a.Q.getSelectedTabItemData().name)).show((ViewGroup) this.a.v);
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                if (transmitPostEditActivity.a.b(transmitPostEditActivity.A, transmitPostEditActivity.E)) {
                    TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                    transmitPostEditActivity2.showToast(transmitPostEditActivity2.a.e());
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.f1184T, transmitPostEditActivity3.U1());
                TransmitPostEditActivity transmitPostEditActivity4 = this.a;
                transmitPostEditActivity4.HidenSoftKeyPad(transmitPostEditActivity4.f1184T, transmitPostEditActivity4.S1());
                this.a.S.t();
                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                if (this.a.x0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 8));
                }
                this.a.X2();
                mt4.d().b("share_thread");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public d(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    this.a.S.D(new zh5(5, -1, null));
                    this.a.E.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TransmitPostEditActivity a;

        public e(TransmitPostEditActivity transmitPostEditActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {transmitPostEditActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = transmitPostEditActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
                this.a.b3();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-255645436, "Lcom/baidu/tieba/write/write/TransmitPostEditActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-255645436, "Lcom/baidu/tieba/write/write/TransmitPostEditActivity;");
                return;
            }
        }
        y0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        z0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.obfuscated_res_0x7f092a88);
            this.i0 = originalThreadCardView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
            layoutParams.topMargin -= y0;
            int i = z0;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.i0.setLayoutParams(layoutParams);
            this.i0.setVisibility(0);
            this.i0.h(this.h0);
            this.i0.setEnabled(false);
        }
    }

    public final void V2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            WriteData writeData = this.p;
            if (writeData == null) {
                finish();
                return;
            }
            writeData.setTitle(U1().getText().toString());
            this.p.setContent(S1().getText().toString());
            finish();
        }
    }

    public TransmitPostEditActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u0 = null;
        this.x0 = false;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.J1();
            Q2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.E;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.A;
        }
        return (EditText) invokeV.objValue;
    }

    public final boolean U2() {
        InterceptResult invokeV;
        FrsTabItemData selectedTabItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ForumTabSelectedView forumTabSelectedView = this.Q;
            if (forumTabSelectedView == null || (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) == null || selectedTabItemData.tabType != 102 || selectedTabItemData.isGeneralTab != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && !StringUtils.isNull(this.w0)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921634, this.w0));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.Z1();
            a3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.a2();
            this.S.setActionListener(31, this.e0);
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.V == null) {
                this.V = new i1b(getPageContext());
            }
            this.V.c(this.S);
        }
    }

    public void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            NewWriteModel newWriteModel = this.v0;
            if (newWriteModel != null) {
                newWriteModel.cancelLoadData();
            }
            FeedBackModel feedBackModel = this.u;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.e2();
            S2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.C.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.y.setOnClickListener(new c(this));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            b3();
            this.v0.l0(null);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.p2();
            b3();
            V2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            b3();
            V2();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.z1();
            this.E.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void N1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, atListActivityConfig) == null) && (S1() instanceof SpanGroupEditText)) {
            atListActivityConfig.setSelectedAtList(((SpanGroupEditText) S1()).getAtDataInText());
        }
    }

    public final void Z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            SkinManager.setNavbarTitleColor(this.y, R.color.CAM_X0302, R.color.s_navbar_title_color);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(U1(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(S1(), R.color.CAM_X0201);
            OriginalThreadCardView originalThreadCardView = this.i0;
            if (originalThreadCardView != null) {
                originalThreadCardView.s();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            super.onCreate(bundle);
            this.E.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null) {
                bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(shareInfo));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView addTextButton = this.w.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f1387));
            this.y = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = BdUtilHelper.getDimens(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.y.setLayoutParams(layoutParams);
            this.y.setOnFocusChangeListener(this.d0);
        }
    }

    public final String O2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (S1() != null && S1().getText() != null) {
                String obj = S1().getText().toString();
                if (StringUtils.isNull(obj)) {
                    OriginalThreadInfo.ShareInfo shareInfo = this.h0;
                    if (shareInfo != null && shareInfo.showType == 3) {
                        return getString(R.string.obfuscated_res_0x7f0f13ca);
                    }
                    return getString(R.string.obfuscated_res_0x7f0f13c9);
                }
                return obj;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.h2();
            if (this.w.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.w.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.h0 != null) {
                R2();
            } else {
                this.E.setText(this.t0 + " " + this.s0);
            }
            ShowSoftKeyPad(this.f1184T, this.A);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void G2() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (writeData = this.p) == null) {
            return;
        }
        if (writeData.getType() != 9) {
            this.z.setText(R.string.send_reply);
            this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.A.setVisibility(8);
            return;
        }
        String str3 = this.k;
        if (str3 != null && str3.equals("1")) {
            this.z.setText(R.string.obfuscated_res_0x7f0f13c6);
        } else {
            String str4 = this.k;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f13c3) + this.p.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f0319);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f0319);
                }
                this.z.setText(str2);
            } else {
                this.z.setText("");
            }
        }
        this.A.setVisibility(0);
        this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    public final String P2() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.p != null && U1() != null && U1().getVisibility() == 0 && U1().getText() != null) {
                String obj = U1().getText().toString();
                PostPrefixData postPrefixData = this.d;
                if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.i != 0 && (textView = this.J) != null && textView.getText() != null) {
                    obj = this.J.getText().toString() + obj;
                }
                PostPrefixData postPrefixData2 = this.d;
                if (postPrefixData2 != null && !StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                    obj = this.d.getImplicitTitle() + this.p.getTitle();
                }
                if (TextUtils.isEmpty(obj)) {
                    if (TextUtils.isEmpty(this.p.getContent())) {
                        return getString(R.string.obfuscated_res_0x7f0f13c9);
                    }
                    if (getString(R.string.obfuscated_res_0x7f0f13c9).equals(this.p.getContent())) {
                        return getString(R.string.obfuscated_res_0x7f0f13c9);
                    }
                    if (getString(R.string.obfuscated_res_0x7f0f13ca).equals(this.p.getContent())) {
                        return getString(R.string.obfuscated_res_0x7f0f13ca);
                    }
                    return obj;
                }
                return obj;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.M.setVisibility(0);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.i = 1;
                this.M.setOnClickListener(new a(this));
                ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d43);
                this.L = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.J.setOnClickListener(new b(this));
                }
                int color = SkinManager.getColor(R.color.CAM_X0105);
                int color2 = SkinManager.getColor(R.color.CAM_X0108);
                SkinManager.setBackgroundResource(this.J, R.color.CAM_X0201);
                SkinManager.setImageResource(this.L, R.drawable.icon_frs_arrow_n);
                this.J.setTextColor(color);
                this.G.clear();
                for (int i = 0; i < size; i++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.G.add(writePrefixItemLayout);
                    writePrefixItemLayout.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        writePrefixItemLayout.setPrefixTextColor(color2);
                    } else {
                        writePrefixItemLayout.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        writePrefixItemLayout.setDividerStyle(false);
                    }
                    this.K.a(writePrefixItemLayout);
                }
                this.K.c(0);
                this.J.setText(prefixs.get(1));
                v2(1);
                return;
            }
            this.M.setVisibility(8);
        }
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.S.d(new ni5(getActivity(), 2));
            if (this.U == null) {
                wxa wxaVar = new wxa(getActivity(), this.k);
                this.U = wxaVar;
                wxaVar.i();
                this.U.j();
                this.U.n("from_share_write");
                this.U.k(this.p.getForumId(), this.j);
            }
            this.S.d(this.U);
            this.S.h(arrayList);
            li5 p = this.S.p(5);
            if (p != null) {
                p.l = 1;
            }
        }
    }

    public final boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (((ImageSpan[]) S1().getText().getSpans(0, S1().getText().length(), ImageSpan.class)).length <= 10) {
                return false;
            }
            if (this.I == null) {
                this.I = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            if (Build.VERSION.SDK_INT >= 28 && this.I.getView().isShown()) {
                this.I.cancel();
            }
            GreyUtil.grey(this.I);
            this.I.show();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if ("1".equals(this.k)) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.k)) {
                this.p.setCanNoForum(false);
            }
            u2();
            this.p.setPrivacy(this.m);
            this.p.setIsShareThread(true);
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null && !StringUtils.isNull(shareInfo.threadId)) {
                this.p.setOriginalThreadId(this.h0.threadId);
            }
            this.p.setBaijiahaoData(this.g0);
            OriginalThreadInfo.ShareInfo shareInfo2 = this.h0;
            if (shareInfo2 != null) {
                this.p.setOriBaijiahaoData(shareInfo2.oriUgcInfo);
            }
            this.p.setCallFrom(this.k);
            W2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091d33);
            this.A = editText;
            editText.setOnClickListener(this.c0);
            this.A.setOnFocusChangeListener(this.d0);
            if (this.p.getType() == 9 && this.p.getTitle() != null) {
                this.A.setText(this.p.getTitle());
                this.A.setSelection(this.p.getTitle().length());
            }
            this.A.addTextChangedListener(this.X);
            this.A.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    public final void W2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b3();
            this.p.setContent(O2());
            this.p.setTitle(P2());
            this.p.setWriteImagesInfo(this.q);
            this.p.onPostDataParse(this.E.getSpanGroupManager());
            NewWriteModel newWriteModel = this.v0;
            if (this.q.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            newWriteModel.j0(z);
            x1();
            this.v0.setWriteData(this.p);
            WriteData writeData = this.p;
            writeData.setContent(writeData.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData2 = this.p;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000", ""));
            this.p.setVcode(null);
            this.v0.d0().setVoice(null);
            this.v0.d0().setVoiceDuringTime(-1);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0e29);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f1370), this.u0);
            this.v0.o0();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f091d15);
            this.E = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.E.setOnClickListener(this.c0);
            if (this.p.getContent() != null && this.p.getContent().length() > 0) {
                this.E.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.p.getContent()));
                SpanGroupEditText spanGroupEditText2 = this.E;
                spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
            }
            if (!di.isEmpty(this.j0)) {
                this.E.setSelection(0);
            }
            this.E.setOnFocusChangeListener(this.d0);
            this.E.setOnTouchListener(new d(this));
            this.E.addTextChangedListener(this.W);
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.E.setHint(R.string.obfuscated_res_0x7f0f13ca);
            } else {
                this.E.setHint(R.string.obfuscated_res_0x7f0f13c9);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void t2() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048619, this) != null) || this.p == null) {
            return;
        }
        String str2 = "";
        if (U1() == null) {
            str = "";
        } else {
            str = U1().getText().toString();
        }
        if (S1() != null) {
            str2 = S1().getText().toString().trim();
        }
        String trim = str.trim();
        if (this.p.getType() == 9) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs();
                if (this.i == 0) {
                    if (TextUtils.isEmpty(trim)) {
                        this.p.setIsNoTitle(true);
                    } else {
                        this.p.setIsNoTitle(false);
                        Z2(true);
                        return;
                    }
                } else {
                    this.p.setIsNoTitle(false);
                    Z2(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.p.setIsNoTitle(true);
            } else {
                this.p.setIsNoTitle(false);
                Z2(true);
                return;
            }
        }
        if (this.q.getChosedFiles() != null && this.q.size() > 0) {
            Z2(true);
        } else if (!TextUtils.isEmpty(str2)) {
            Z2(true);
        } else if (this.p.getVideoInfo() != null) {
            Z2(true);
        } else {
            Z2(false);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void Y1(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.v0 = newWriteModel;
            newWriteModel.l0(this.a0);
            this.u0 = new e(this);
            super.Y1(bundle);
            if (bundle != null) {
                String string = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                if (!StringUtils.isNull(string)) {
                    this.h0 = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string, OriginalThreadInfo.ShareInfo.class);
                }
                this.g0 = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.j0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.r0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.w0 = bundle.getString("topic_id");
                this.t0 = bundle.getString("more_forum_title");
                this.s0 = bundle.getString("more_forum_url");
            } else {
                Intent intent = getIntent();
                this.g0 = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.h0 = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                this.j0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.r0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.x0 = intent.getBooleanExtra("from_share", false);
                this.w0 = intent.getStringExtra("topic_id");
                this.t0 = intent.getStringExtra("more_forum_title");
                this.s0 = intent.getStringExtra("more_forum_url");
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(0, getPageContext().getString(R.string.write_no_prefix));
            }
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null && (str = shareInfo.videoId) != null) {
                this.p.setVideoId(str);
                this.p.setOriginalVideoCover(this.h0.showPicUrl);
                this.p.setOriginalVideoTitle(this.h0.showText);
            }
            if (!di.isEmpty(this.j0)) {
                if (!di.isEmpty(this.r0)) {
                    WriteData writeData = this.p;
                    writeData.setContent("//@" + this.r0 + " :" + this.j0);
                    return;
                }
                this.p.setContent(this.j0);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void n2(@NonNull zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, zh5Var) == null) {
            if (zh5Var.a == 31) {
                Object obj = zh5Var.c;
                if (obj instanceof Integer) {
                    int i = 0;
                    int intValue = ((Integer) obj).intValue();
                    if (intValue == 5) {
                        i = 4;
                    } else if (intValue == 9) {
                        i = 3;
                    } else if (intValue == 26) {
                        i = 1;
                    } else if (intValue == 7) {
                        i = 2;
                    }
                    if (i > 0) {
                        TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", i));
                    }
                }
            }
            int i2 = zh5Var.a;
            if (i2 == 29) {
                this.p.setVideoInfo(null);
            } else if (i2 == 24) {
                if (m2()) {
                    showToast(R.string.over_limit_tip);
                    return;
                }
                Object obj2 = zh5Var.c;
                if (!(obj2 instanceof uc5)) {
                    return;
                }
                uc5 uc5Var = (uc5) obj2;
                if (EmotionGroupType.isSendAsPic(uc5Var.getType())) {
                    this.S.t();
                }
                k2(uc5Var);
            } else if (i2 != 12 && i2 != 13 && i2 != 46 && i2 != 49) {
                if (i2 == 43) {
                    SharedPrefHelper.getInstance().putBoolean("hot_topic_has_click", true);
                    this.S.D(new zh5(2, 26, null));
                    this.n = true;
                    r2(true);
                    if (U1().isFocused()) {
                        this.g = "from_title";
                    } else if (S1().isFocused()) {
                        this.g = "from_content";
                    }
                }
            } else {
                t2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048610, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                ArrayList arrayList = null;
                postWriteCallBackData2 = null;
                postWriteCallBackData2 = null;
                if (i == 12004) {
                    EditorTools editorTools = this.S;
                    if (editorTools != null && !editorTools.x()) {
                        S1().requestFocus();
                        this.f1184T.toggleSoftInput(0, 2);
                    }
                    if (intent != null) {
                        arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    }
                    int selectionStart = S1().getSelectionStart();
                    if (selectionStart > 0) {
                        int i3 = selectionStart - 1;
                        if (S1().getText().toString().charAt(i3) == '@') {
                            S1().getEditableText().delete(i3, selectionStart);
                        }
                    }
                    if (S1() instanceof SpanGroupEditText) {
                        ((SpanGroupEditText) S1()).e(arrayList);
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        S1().getText().delete(S1().getSelectionStart(), S1().getSelectionEnd());
                        if (S1() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) S1()).b(arrayList);
                        }
                    }
                } else if (i == 12006) {
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    }
                    y2(postWriteCallBackData2);
                    setResult(-1, intent);
                    finish();
                } else if (i != 25004 || intent == null) {
                } else {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (StringUtils.isNull(stringExtra)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (this.n) {
                        sb.append("#");
                        this.n = false;
                    }
                    sb.append(stringExtra);
                    w1(sb.toString());
                }
            } else if (i2 == 0) {
                EditorTools editorTools2 = this.S;
                if (editorTools2 != null && !editorTools2.x()) {
                    this.E.requestFocus();
                    this.f1184T.toggleSoftInput(0, 2);
                }
                if (i != 12002) {
                    if (i != 12006) {
                        if (i == 25004) {
                            if ("from_title".equals(this.g)) {
                                U1().requestFocus();
                            } else if ("from_content".equals(this.g)) {
                                S1().requestFocus();
                            }
                        }
                    } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.a.n(postWriteCallBackData.getErrorString());
                        this.a.m(postWriteCallBackData.getSensitiveWords());
                        this.a.h(this.A, this.E);
                    }
                } else if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                    this.q.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                }
            }
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048615, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.activity_open_from_bottom, R.anim.activity_close_from_top);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void q2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, postWriteCallBackData, writeData) == null) {
            super.q2(postWriteCallBackData, writeData);
            Y2();
            z2(postWriteCallBackData);
            finish();
        }
    }
}
