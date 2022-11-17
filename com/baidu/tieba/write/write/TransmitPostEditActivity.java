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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
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
import com.baidu.tieba.ch;
import com.baidu.tieba.f25;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.l65;
import com.baidu.tieba.o49;
import com.baidu.tieba.qy4;
import com.baidu.tieba.r59;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vj5;
import com.baidu.tieba.w65;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.xi;
import com.baidu.tieba.y65;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class TransmitPostEditActivity extends AbsBaseWriteActivity<TransmitPostEditActivity> implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final int x0;
    public static final int y0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaijiahaoData g0;
    public OriginalThreadInfo.ShareInfo h0;
    public OriginalThreadCardView i0;
    public String j0;
    public String q0;
    public String r0;
    public String s0;
    public DialogInterface.OnCancelListener t0;
    public NewWriteModel u0;
    public String v0;
    public boolean w0;

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? R.color.CAM_X0207 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.de5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
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
                ch.l(transmitPostEditActivity.K, view2, 0, yi.d(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.S.q();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.T, transmitPostEditActivity2.A);
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.T, transmitPostEditActivity3.E);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                ch.l(transmitPostEditActivity.K, view2, 0, yi.d(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.S.q();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.T, transmitPostEditActivity2.V1());
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.T, transmitPostEditActivity3.U1());
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                }
                if (vj5.a() || this.a.U2()) {
                    return;
                }
                if (this.a.V2()) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getActivity());
                    bdTopToast.h(false);
                    bdTopToast.g(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f119d), this.a.Q.getSelectedTabItemData().name));
                    bdTopToast.i((ViewGroup) this.a.v);
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                if (transmitPostEditActivity.a.b(transmitPostEditActivity.A, transmitPostEditActivity.E)) {
                    TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                    transmitPostEditActivity2.showToast(transmitPostEditActivity2.a.e());
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.T, transmitPostEditActivity3.V1());
                TransmitPostEditActivity transmitPostEditActivity4 = this.a;
                transmitPostEditActivity4.HidenSoftKeyPad(transmitPostEditActivity4.T, transmitPostEditActivity4.U1());
                this.a.S.q();
                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                if (this.a.w0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 8));
                }
                this.a.Y2();
                if (!TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD)) {
                    MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SHARE_THREAD));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.S.A(new l65(5, -1, null));
                    this.a.E.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.c3();
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
        x0 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        y0 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.obfuscated_res_0x7f09270c);
            this.i0 = originalThreadCardView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
            layoutParams.topMargin -= x0;
            int i = y0;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.i0.setLayoutParams(layoutParams);
            this.i0.setVisibility(0);
            this.i0.h(this.h0);
            this.i0.setEnabled(false);
        }
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            WriteData writeData = this.p;
            if (writeData == null) {
                finish();
                return;
            }
            writeData.setTitle(V1().getText().toString());
            this.p.setContent(U1().getText().toString());
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
        this.t0 = null;
        this.w0 = false;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.D1();
            this.E.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.M1();
            R2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.E;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.A;
        }
        return (EditText) invokeV.objValue;
    }

    public final boolean V2() {
        InterceptResult invokeV;
        FrsTabItemData selectedTabItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ForumTabSelectedView forumTabSelectedView = this.Q;
            if (forumTabSelectedView == null || (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) == null || selectedTabItemData.tabType != 102 || selectedTabItemData.isGeneralTab != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && !StringUtils.isNull(this.v0)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921634, this.v0));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.a2();
            b3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.b2();
            this.S.setActionListener(31, this.e0);
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.V == null) {
                this.V = new r59(getPageContext());
            }
            this.V.c(this.S);
        }
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            NewWriteModel newWriteModel = this.u0;
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
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.f2();
            T2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.C.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.y.setOnClickListener(new c(this));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            c3();
            this.u0.b0(null);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.q2();
            c3();
            W2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            c3();
            W2();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void Q1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, atListActivityConfig) == null) && (U1() instanceof SpanGroupEditText)) {
            atListActivityConfig.setSelectedAtList(((SpanGroupEditText) U1()).getAtDataInText());
        }
    }

    public final void a3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            SkinManager.setNavbarTitleColor(this.y, R.color.CAM_X0302, R.color.s_navbar_title_color);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(V1(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(U1(), R.color.CAM_X0201);
            OriginalThreadCardView originalThreadCardView = this.i0;
            if (originalThreadCardView != null) {
                originalThreadCardView.s();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            super.onCreate(bundle);
            this.E.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null) {
                bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(shareInfo));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TextView addTextButton = this.w.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f117f));
            this.y = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = yi.g(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.y.setLayoutParams(layoutParams);
            this.y.setOnFocusChangeListener(this.d0);
        }
    }

    public final String P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (U1() != null && U1().getText() != null) {
                String obj = U1().getText().toString();
                if (StringUtils.isNull(obj)) {
                    OriginalThreadInfo.ShareInfo shareInfo = this.h0;
                    if (shareInfo != null && shareInfo.showType == 3) {
                        return getString(R.string.obfuscated_res_0x7f0f11bf);
                    }
                    return getString(R.string.obfuscated_res_0x7f0f11be);
                }
                return obj;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.i2();
            if (this.w.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.w.getBackImageView(), R.drawable.obfuscated_res_0x7f080a32, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.h0 != null) {
                S2();
            } else {
                this.E.setText(this.s0 + " " + this.r0);
            }
            ShowSoftKeyPad(this.T, this.A);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void H2() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (writeData = this.p) == null) {
            return;
        }
        if (writeData.getType() != 9) {
            this.z.setText(R.string.obfuscated_res_0x7f0f1163);
            this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.A.setVisibility(8);
            return;
        }
        String str3 = this.k;
        if (str3 != null && str3.equals("1")) {
            this.z.setText(R.string.obfuscated_res_0x7f0f11bb);
        } else {
            String str4 = this.k;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.share_to) + this.p.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02df);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02df);
                }
                this.z.setText(str2);
            } else {
                this.z.setText("");
            }
        }
        this.A.setVisibility(0);
        this.E.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    public final String Q2() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.p != null && V1() != null && V1().getVisibility() == 0 && V1().getText() != null) {
                String obj = V1().getText().toString();
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
                        return getString(R.string.obfuscated_res_0x7f0f11be);
                    }
                    if (getString(R.string.obfuscated_res_0x7f0f11be).equals(this.p.getContent())) {
                        return getString(R.string.obfuscated_res_0x7f0f11be);
                    }
                    if (getString(R.string.obfuscated_res_0x7f0f11bf).equals(this.p.getContent())) {
                        return getString(R.string.obfuscated_res_0x7f0f11bf);
                    }
                    return obj;
                }
                return obj;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.M.setVisibility(0);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.i = 1;
                this.M.setOnClickListener(new a(this));
                ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091ab4);
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
                w2(1);
                return;
            }
            this.M.setVisibility(8);
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.S.d(new y65(getActivity(), 2));
            if (this.U == null) {
                o49 o49Var = new o49(getActivity(), this.k);
                this.U = o49Var;
                o49Var.h();
                this.U.i();
                this.U.m("from_share_write");
                this.U.j(this.p.getForumId(), this.j);
            }
            this.S.d(this.U);
            this.S.h(arrayList);
            w65 n = this.S.n(5);
            if (n != null) {
                n.l = 1;
            }
        }
    }

    public final boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (((ImageSpan[]) U1().getText().getSpans(0, U1().getText().length(), ImageSpan.class)).length <= 10) {
                return false;
            }
            if (this.I == null) {
                this.I = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1495, 0);
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

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ("1".equals(this.k)) {
                this.p.setCanNoForum(true);
                this.p.setTransmitForumData("[]");
            } else if ("2".equals(this.k)) {
                this.p.setCanNoForum(false);
            }
            v2();
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
            X2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091aa5);
            this.A = editText;
            editText.setOnClickListener(this.c0);
            this.A.setOnFocusChangeListener(this.d0);
            if (this.p.getType() == 9 && this.p.getTitle() != null) {
                this.A.setText(this.p.getTitle());
                this.A.setSelection(this.p.getTitle().length());
            }
            this.A.addTextChangedListener(this.X);
            this.A.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0f2f));
        }
    }

    public final void X2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            c3();
            this.p.setContent(P2());
            this.p.setTitle(Q2());
            this.p.setWriteImagesInfo(this.q);
            NewWriteModel newWriteModel = this.u0;
            if (this.q.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            newWriteModel.Z(z);
            B1();
            this.u0.setWriteData(this.p);
            WriteData writeData = this.p;
            writeData.setContent(writeData.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData2 = this.p;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000", ""));
            this.p.setVcode(null);
            this.u0.S().setVoice(null);
            this.u0.S().setVoiceDuringTime(-1);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c81);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f1168), this.t0);
            this.u0.e0();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f091a87);
            this.E = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.E.setOnClickListener(this.c0);
            NewWriteModel newWriteModel = this.u0;
            if (newWriteModel != null) {
                newWriteModel.setSpanGroupManager(this.E.getSpanGroupManager());
            }
            WriteData writeData = this.p;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.E.getSpanGroupManager());
            }
            if (this.p.getContent() != null && this.p.getContent().length() > 0) {
                this.E.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.p.getContent()));
                SpanGroupEditText spanGroupEditText2 = this.E;
                spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
            }
            if (!xi.isEmpty(this.j0)) {
                this.E.setSelection(0);
            }
            this.E.setOnFocusChangeListener(this.d0);
            this.E.setOnTouchListener(new d(this));
            this.E.addTextChangedListener(this.W);
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.E.setHint(R.string.obfuscated_res_0x7f0f11bf);
            } else {
                this.E.setHint(R.string.obfuscated_res_0x7f0f11be);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void u2() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.p == null) {
            return;
        }
        String str2 = "";
        if (V1() == null) {
            str = "";
        } else {
            str = V1().getText().toString();
        }
        if (U1() != null) {
            str2 = U1().getText().toString().trim();
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
                        a3(true);
                        return;
                    }
                } else {
                    this.p.setIsNoTitle(false);
                    a3(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.p.setIsNoTitle(true);
            } else {
                this.p.setIsNoTitle(false);
                a3(true);
                return;
            }
        }
        if (this.q.getChosedFiles() != null && this.q.size() > 0) {
            a3(true);
        } else if (!TextUtils.isEmpty(str2)) {
            a3(true);
        } else if (this.p.getVideoInfo() != null) {
            a3(true);
        } else {
            a3(false);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void Z1(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.u0 = newWriteModel;
            newWriteModel.b0(this.a0);
            this.t0 = new e(this);
            super.Z1(bundle);
            if (bundle != null) {
                String string = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                if (!StringUtils.isNull(string)) {
                    this.h0 = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string, OriginalThreadInfo.ShareInfo.class);
                }
                this.g0 = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.j0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.q0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.v0 = bundle.getString("topic_id");
                this.s0 = bundle.getString("more_forum_title");
                this.r0 = bundle.getString("more_forum_url");
            } else {
                Intent intent = getIntent();
                this.g0 = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.h0 = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                this.j0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.q0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.w0 = intent.getBooleanExtra("from_share", false);
                this.v0 = intent.getStringExtra("topic_id");
                this.s0 = intent.getStringExtra("more_forum_title");
                this.r0 = intent.getStringExtra("more_forum_url");
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(0, getPageContext().getString(R.string.obfuscated_res_0x7f0f1638));
            }
            OriginalThreadInfo.ShareInfo shareInfo = this.h0;
            if (shareInfo != null && (str = shareInfo.videoId) != null) {
                this.p.setVideoId(str);
                this.p.setOriginalVideoCover(this.h0.showPicUrl);
                this.p.setOriginalVideoTitle(this.h0.showText);
            }
            if (!xi.isEmpty(this.j0)) {
                if (!xi.isEmpty(this.q0)) {
                    WriteData writeData = this.p;
                    writeData.setContent("//@" + this.q0 + " :" + this.j0);
                    return;
                }
                this.p.setContent(this.j0);
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void o2(@NonNull l65 l65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, l65Var) == null) {
            if (l65Var.a == 31) {
                Object obj = l65Var.c;
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
            int i2 = l65Var.a;
            if (i2 == 29) {
                this.p.setVideoInfo(null);
            } else if (i2 == 24) {
                if (n2()) {
                    showToast(R.string.obfuscated_res_0x7f0f0d61);
                    return;
                }
                Object obj2 = l65Var.c;
                if (!(obj2 instanceof f25)) {
                    return;
                }
                f25 f25Var = (f25) obj2;
                if (EmotionGroupType.isSendAsPic(f25Var.getType())) {
                    this.S.q();
                }
                l2(f25Var);
            } else if (i2 != 12 && i2 != 13 && i2 != 46 && i2 != 49) {
                if (i2 == 43) {
                    qy4.k().u("hot_topic_has_click", true);
                    this.S.A(new l65(2, 26, null));
                    this.n = true;
                    s2(true);
                    if (V1().isFocused()) {
                        this.g = "from_title";
                    } else if (U1().isFocused()) {
                        this.g = "from_content";
                    }
                }
            } else {
                u2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048611, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                ArrayList arrayList = null;
                postWriteCallBackData2 = null;
                postWriteCallBackData2 = null;
                if (i == 12004) {
                    EditorTools editorTools = this.S;
                    if (editorTools != null && !editorTools.u()) {
                        U1().requestFocus();
                        this.T.toggleSoftInput(0, 2);
                    }
                    if (intent != null) {
                        arrayList = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                    }
                    int selectionStart = U1().getSelectionStart();
                    if (selectionStart > 0) {
                        int i3 = selectionStart - 1;
                        if (U1().getText().toString().charAt(i3) == '@') {
                            U1().getEditableText().delete(i3, selectionStart);
                        }
                    }
                    if (U1() instanceof SpanGroupEditText) {
                        ((SpanGroupEditText) U1()).e(arrayList);
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        U1().getText().delete(U1().getSelectionStart(), U1().getSelectionEnd());
                        if (U1() instanceof SpanGroupEditText) {
                            ((SpanGroupEditText) U1()).b(arrayList);
                        }
                    }
                } else if (i == 12006) {
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                        postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                    }
                    z2(postWriteCallBackData2);
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
                    A1(sb.toString());
                }
            } else if (i2 == 0) {
                EditorTools editorTools2 = this.S;
                if (editorTools2 != null && !editorTools2.u()) {
                    this.E.requestFocus();
                    this.T.toggleSoftInput(0, 2);
                }
                if (i != 12002) {
                    if (i != 12006) {
                        if (i == 25004) {
                            if ("from_title".equals(this.g)) {
                                V1().requestFocus();
                            } else if ("from_content".equals(this.g)) {
                                U1().requestFocus();
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
        if (interceptable == null || interceptable.invokeII(1048616, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void r2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, postWriteCallBackData, writeData) == null) {
            super.r2(postWriteCallBackData, writeData);
            Z2();
            A2(postWriteCallBackData);
            finish();
        }
    }
}
