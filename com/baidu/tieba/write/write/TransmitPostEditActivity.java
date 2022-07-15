package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.id5;
import com.repackage.j15;
import com.repackage.jx8;
import com.repackage.ke5;
import com.repackage.lx4;
import com.repackage.ly8;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.sg;
import com.repackage.u15;
import com.repackage.w15;
import com.repackage.xt4;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TransmitPostEditActivity extends AbsBaseWriteActivity<TransmitPostEditActivity> implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final int Q0;
    public static final int R0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaijiahaoData H0;
    public OriginalThreadInfo.ShareInfo I0;
    public OriginalThreadCardView J0;
    public String K0;
    public String L0;
    public DialogInterface.OnCancelListener M0;
    public NewWriteModel N0;
    public String O0;
    public boolean P0;

    /* loaded from: classes4.dex */
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
                this.a.h0.setVisibility(0);
                this.a.k0.setSelected(true);
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                sg.l(transmitPostEditActivity.i0, view2, 0, pi.d(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.r0.q();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.s0, transmitPostEditActivity2.N);
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.s0, transmitPostEditActivity3.S);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.h0.setSelected(true);
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                sg.l(transmitPostEditActivity.i0, view2, 0, pi.d(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.r0.q();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.s0, transmitPostEditActivity2.W1());
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.s0, transmitPostEditActivity3.V1());
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c2b);
                }
                if (ke5.b() || this.a.i3()) {
                    return;
                }
                if (this.a.j3()) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getActivity());
                    bdTopToast.i(false);
                    bdTopToast.h(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f115a), this.a.p0.getSelectedTabItemData().name));
                    bdTopToast.j((ViewGroup) this.a.I);
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                if (transmitPostEditActivity.a.b(transmitPostEditActivity.N, transmitPostEditActivity.S)) {
                    TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                    transmitPostEditActivity2.showToast(transmitPostEditActivity2.a.e());
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.s0, transmitPostEditActivity3.W1());
                TransmitPostEditActivity transmitPostEditActivity4 = this.a;
                transmitPostEditActivity4.HidenSoftKeyPad(transmitPostEditActivity4.s0, transmitPostEditActivity4.V1());
                this.a.r0.q();
                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                if (this.a.P0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 8));
                }
                this.a.m3();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.r0.A(new j15(5, -1, null));
                    this.a.S.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.q3();
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
        Q0 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        R0 = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
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
        this.M0 = null;
        this.P0 = false;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void A2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
            E2();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q3();
            k3();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void D2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.v == null) {
            return;
        }
        String obj = W1() != null ? W1().getText().toString() : "";
        String trim = V1() != null ? V1().getText().toString().trim() : "";
        String trim2 = obj.trim();
        if (this.v.getType() == 0 || this.v.getType() == 9 || this.v.getType() == 7) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs();
                if (this.l == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.v.setIsNoTitle(true);
                    } else {
                        this.v.setIsNoTitle(false);
                        o3(true);
                        return;
                    }
                } else {
                    this.v.setIsNoTitle(false);
                    o3(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.v.setIsNoTitle(true);
            } else {
                this.v.setIsNoTitle(false);
                o3(true);
                return;
            }
        }
        if (this.y.getChosedFiles() != null && this.y.size() > 0) {
            if (!this.t) {
                o3(true);
                return;
            } else if (this.y.size() >= 1) {
                o3(true);
            }
        }
        if (!TextUtils.isEmpty(trim)) {
            o3(true);
        } else if (this.v.getVideoInfo() != null) {
            o3(true);
        } else {
            o3(false);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.G1();
            this.S.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TextView addTextButton = this.J.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f113c));
            this.L = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = pi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.L.setLayoutParams(layoutParams);
            this.L.setOnFocusChangeListener(this.E0);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.O1();
            f3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void S1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, atListActivityConfig) == null) && (V1() instanceof SpanGroupEditText)) {
            atListActivityConfig.setSelectedAtList(((SpanGroupEditText) V1()).getAtDataInText());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? R.color.CAM_X0207 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void U2() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (writeData = this.v) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0) {
            if (type == 4) {
                this.M.setText(R.string.obfuscated_res_0x7f0f0f20);
                this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                return;
            } else if (type != 9) {
                this.M.setText(R.string.obfuscated_res_0x7f0f1117);
                this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                this.N.setVisibility(8);
                return;
            }
        }
        String str3 = this.o;
        if (str3 != null && str3.equals("1")) {
            this.M.setText(R.string.obfuscated_res_0x7f0f1177);
        } else {
            String str4 = this.o;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f1174) + this.v.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02d5);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02d5);
                }
                this.M.setText(str2);
            } else {
                this.M.setText("");
            }
        }
        this.N.setVisibility(0);
        this.S.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.S : (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.N : (EditText) invokeV.objValue;
    }

    public final void c3(HotTopicBussinessData hotTopicBussinessData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null) {
            return;
        }
        SpannableString i = id5.i(id5.a(hotTopicBussinessData.mTopicName));
        if (i != null) {
            this.N.setText(i);
        }
        this.o0.setText(hotTopicBussinessData.mForumName);
    }

    public final String d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (V1() == null || V1().getText() == null) {
                return "";
            }
            String obj = V1().getText().toString();
            if (StringUtils.isNull(obj)) {
                OriginalThreadInfo.ShareInfo shareInfo = this.I0;
                if (shareInfo != null && shareInfo.showType == 3) {
                    return getString(R.string.obfuscated_res_0x7f0f117b);
                }
                return getString(R.string.obfuscated_res_0x7f0f117a);
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void e2(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.N0 = newWriteModel;
            newWriteModel.e0(this.z0);
            this.M0 = new e(this);
            super.e2(bundle);
            if (bundle != null) {
                String string = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                if (!StringUtils.isNull(string)) {
                    this.I0 = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string, OriginalThreadInfo.ShareInfo.class);
                }
                this.H0 = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.K0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.L0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.O0 = bundle.getString("topic_id");
            } else {
                Intent intent = getIntent();
                this.H0 = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.I0 = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                this.K0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.L0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.P0 = intent.getBooleanExtra("from_share", false);
                this.O0 = intent.getStringExtra("topic_id");
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(0, getPageContext().getString(R.string.obfuscated_res_0x7f0f15db));
            }
            OriginalThreadInfo.ShareInfo shareInfo = this.I0;
            if (shareInfo != null && (str = shareInfo.videoId) != null) {
                this.v.setVideoId(str);
                this.v.setOriginalVideoCover(this.I0.showPicUrl);
                this.v.setOriginalVideoTitle(this.I0.showText);
            }
            if (!oi.isEmpty(this.K0)) {
                if (!oi.isEmpty(this.L0)) {
                    WriteData writeData = this.v;
                    writeData.setContent("//@" + this.L0 + " :" + this.K0);
                } else {
                    this.v.setContent(this.K0);
                }
            }
            c2();
        }
    }

    public final String e3() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.v == null || W1() == null || W1().getVisibility() != 0 || W1().getText() == null) {
                return "";
            }
            String obj = W1().getText().toString();
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.l != 0 && this.v.getType() != 4 && (textView = this.h0) != null && textView.getText() != null) {
                obj = this.h0.getText().toString() + obj;
            }
            PostPrefixData postPrefixData2 = this.d;
            if (postPrefixData2 != null && !StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                obj = this.d.getImplicitTitle() + this.v.getTitle();
            }
            if (TextUtils.isEmpty(obj)) {
                if (TextUtils.isEmpty(this.v.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f117a);
                }
                if (getString(R.string.obfuscated_res_0x7f0f117a).equals(this.v.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f117a);
                }
                return getString(R.string.obfuscated_res_0x7f0f117b).equals(this.v.getContent()) ? getString(R.string.obfuscated_res_0x7f0f117b) : obj;
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.f2();
            if (this.v.getType() == 0) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.y.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", this.v.getForumId());
                albumActivityConfig.getIntent().putExtra("from", this.f);
                albumActivityConfig.setCanEditImage(false);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
            p3();
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.r0.d(new w15(getActivity(), 2));
            if (this.w == null) {
                if (this.t0 == null) {
                    jx8 jx8Var = new jx8(getActivity(), this.o);
                    this.t0 = jx8Var;
                    jx8Var.j();
                    this.t0.i();
                    this.t0.k();
                    this.t0.o("from_share_write");
                    this.t0.l(this.v.getForumId(), this.m);
                }
                this.r0.d(this.t0);
            }
            this.r0.h(arrayList);
            u15 n = this.r0.n(5);
            if (n != null) {
                n.l = 1;
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.g2();
            this.r0.setActionListener(31, this.F0);
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.obfuscated_res_0x7f09252c);
            this.J0 = originalThreadCardView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
            layoutParams.topMargin -= Q0;
            int i = R0;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.J0.setLayoutParams(layoutParams);
            this.J0.setVisibility(0);
            this.J0.h(this.I0);
            this.J0.setEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            WriteData writeData = this.v;
            if (writeData != null) {
                if (writeData.getType() == 4) {
                    return "a015";
                }
                if (this.v.getType() == 5) {
                    return "a016";
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.k0.setVisibility(0);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.l = 1;
                this.k0.setOnClickListener(new a(this));
                ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091979);
                this.j0 = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.h0.setOnClickListener(new b(this));
                }
                int color = SkinManager.getColor(R.color.CAM_X0105);
                int color2 = SkinManager.getColor(R.color.CAM_X0108);
                SkinManager.setBackgroundResource(this.h0, R.color.CAM_X0201);
                SkinManager.setImageResource(this.j0, R.drawable.icon_frs_arrow_n);
                this.h0.setTextColor(color);
                this.U.clear();
                for (int i = 0; i < size; i++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.U.add(writePrefixItemLayout);
                    writePrefixItemLayout.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        writePrefixItemLayout.setPrefixTextColor(color2);
                    } else {
                        writePrefixItemLayout.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        writePrefixItemLayout.setDividerStyle(false);
                    }
                    this.i0.a(writePrefixItemLayout);
                }
                this.i0.c(0);
                this.h0.setText(prefixs.get(1));
                G2(1);
                return;
            }
            this.k0.setVisibility(8);
        }
    }

    public final boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (((ImageSpan[]) V1().getText().getSpans(0, V1().getText().length(), ImageSpan.class)).length > 10) {
                if (this.W == null) {
                    this.W = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1444, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.W.getView().isShown()) {
                    this.W.cancel();
                }
                this.W.show();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean j3() {
        InterceptResult invokeV;
        FrsTabItemData selectedTabItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ForumTabSelectedView forumTabSelectedView = this.p0;
            return forumTabSelectedView != null && (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) != null && selectedTabItemData.tabType == 102 && selectedTabItemData.isGeneralTab == 1;
        }
        return invokeV.booleanValue;
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            WriteData writeData = this.v;
            if (writeData == null) {
                finish();
                return;
            }
            writeData.setTitle(W1().getText().toString());
            this.v.setContent(V1().getText().toString());
            finish();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.l2();
            h3();
        }
    }

    public final void l3() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            q3();
            this.v.setContent(d3());
            this.v.setTitle(e3());
            int i = this.j;
            if (i >= 0) {
                this.v.setCategoryFrom(i);
            }
            int i2 = this.k;
            if (i2 >= 0) {
                this.v.setCategoryTo(i2);
            }
            this.v.setWriteImagesInfo(this.y);
            WriteData writeData = this.v;
            LocationModel locationModel = this.G;
            writeData.setHasLocationData(locationModel != null && locationModel.D());
            this.N0.c0(this.y.size() > 0);
            if (!ListUtils.isEmpty(this.B) && (hotTopicBussinessData = this.C) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.v.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.v.setForumName(this.C.mForumName);
            }
            E1();
            this.N0.setWriteData(this.v);
            WriteData writeData2 = this.v;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.v;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.v.setVcode(null);
            this.N0.V().setVoice(null);
            this.N0.V().setVoiceDuringTime(-1);
            if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c2b);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f111c), this.M0);
            this.N0.h0();
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if ("1".equals(this.o)) {
                this.v.setCanNoForum(true);
                this.v.setTransmitForumData("[]");
            } else if ("2".equals(this.o)) {
                this.v.setCanNoForum(false);
            }
            F2();
            this.v.setPrivacy(this.q);
            this.v.setIsShareThread(true);
            OriginalThreadInfo.ShareInfo shareInfo = this.I0;
            if (shareInfo != null && !StringUtils.isNull(shareInfo.threadId)) {
                this.v.setOriginalThreadId(this.I0.threadId);
            }
            this.v.setBaijiahaoData(this.H0);
            OriginalThreadInfo.ShareInfo shareInfo2 = this.I0;
            if (shareInfo2 != null) {
                this.v.setOriBaijiahaoData(shareInfo2.oriUgcInfo);
            }
            this.v.setCallFrom(this.o);
            l3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (!ListUtils.isEmpty(this.B)) {
                this.Q.setVisibility(0);
                this.Q.requestFocus();
                return;
            }
            this.Q.setVisibility(8);
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || StringUtils.isNull(this.O0)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921634, this.O0));
    }

    public final void o3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            SkinManager.setNavbarTitleColor(this.L, R.color.CAM_X0302, R.color.s_navbar_title_color);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    @SuppressLint({"ResourceAsColor"})
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048608, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                if (i2 == 0) {
                    EditorTools editorTools = this.r0;
                    if (editorTools != null && !editorTools.u()) {
                        this.S.requestFocus();
                        this.s0.toggleSoftInput(0, 2);
                    }
                    if (i == 12002) {
                        if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                            return;
                        }
                        this.y.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    } else if (i != 12006) {
                        if (i != 25004) {
                            return;
                        }
                        if ("from_title".equals(this.g)) {
                            W1().requestFocus();
                            return;
                        } else if ("from_content".equals(this.g)) {
                            V1().requestFocus();
                            return;
                        } else {
                            return;
                        }
                    } else if (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) || (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) == null || !postWriteCallBackData.isSensitiveError()) {
                        return;
                    } else {
                        showToast(postWriteCallBackData.getErrorString());
                        this.a.n(postWriteCallBackData.getErrorString());
                        this.a.m(postWriteCallBackData.getSensitiveWords());
                        this.a.h(this.N, this.S);
                        return;
                    }
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData2 = null;
            postWriteCallBackData2 = null;
            postWriteCallBackData2 = null;
            if (i == 12004) {
                EditorTools editorTools2 = this.r0;
                if (editorTools2 != null && !editorTools2.u()) {
                    V1().requestFocus();
                    this.s0.toggleSoftInput(0, 2);
                }
                ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                int selectionStart = V1().getSelectionStart();
                if (selectionStart > 0) {
                    int i3 = selectionStart - 1;
                    if (V1().getText().toString().charAt(i3) == '@') {
                        V1().getEditableText().delete(i3, selectionStart);
                    }
                }
                if (V1() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) V1()).e(parcelableArrayListExtra);
                }
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
                    return;
                }
                V1().getText().delete(V1().getSelectionStart(), V1().getSelectionEnd());
                if (V1() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) V1()).b(parcelableArrayListExtra);
                }
            } else if (i == 12006) {
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                K2(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 25004) {
                if (i != 25005 || intent == null || ListUtils.isEmpty(this.B) || ListUtils.isEmpty(this.B) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.B.size()) {
                    return;
                }
                HotTopicBussinessData hotTopicBussinessData = this.B.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                this.C = hotTopicBussinessData;
                c3(hotTopicBussinessData);
            } else if (intent == null) {
            } else {
                String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                if (StringUtils.isNull(stringExtra)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (this.r) {
                    sb.append("#");
                    this.r = false;
                }
                sb.append(stringExtra);
                D1(sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(W1(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(V1(), R.color.CAM_X0201);
            OriginalThreadCardView originalThreadCardView = this.J0;
            if (originalThreadCardView != null) {
                originalThreadCardView.s();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onCreate(bundle);
            this.S.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            q3();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            OriginalThreadInfo.ShareInfo shareInfo = this.I0;
            if (shareInfo != null) {
                bundle.putString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD, OrmObject.jsonStrWithObject(shareInfo));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i, i2) == null) {
            super.overridePendingTransition(R.anim.obfuscated_res_0x7f01000d, R.anim.obfuscated_res_0x7f01000c);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.p2();
            if (this.J.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.J.getBackImageView(), R.drawable.obfuscated_res_0x7f0809d1, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.t) {
                this.m0.setVisibility(8);
                this.y.setMaxImagesAllowed(6);
            }
            g3();
            ShowSoftKeyPad(this.s0, this.N);
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.u0 == null) {
                this.u0 = new ly8(getPageContext());
            }
            this.u0.c(this.r0);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f09194d);
            this.S = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.S.setOnClickListener(this.D0);
            NewWriteModel newWriteModel = this.N0;
            if (newWriteModel != null) {
                newWriteModel.setSpanGroupManager(this.S.getSpanGroupManager());
            }
            WriteData writeData = this.v;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.S.getSpanGroupManager());
            }
            if (this.v.getContent() != null && this.v.getContent().length() > 0) {
                this.S.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.v.getContent()));
                SpanGroupEditText spanGroupEditText2 = this.S;
                spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
            }
            if (!oi.isEmpty(this.K0)) {
                this.S.setSelection(0);
            }
            this.S.setOnFocusChangeListener(this.E0);
            this.S.setOnTouchListener(new d(this));
            this.S.addTextChangedListener(this.v0);
            OriginalThreadInfo.ShareInfo shareInfo = this.I0;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.S.setHint(R.string.obfuscated_res_0x7f0f117b);
            } else {
                this.S.setHint(R.string.obfuscated_res_0x7f0f117a);
            }
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            NewWriteModel newWriteModel = this.N0;
            if (newWriteModel != null) {
                newWriteModel.cancelLoadData();
            }
            FeedBackModel feedBackModel = this.H;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.G;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f09196a);
            this.N = editText;
            editText.setOnClickListener(this.D0);
            this.N.setOnFocusChangeListener(this.E0);
            if ((this.v.getType() == 0 || this.v.getType() == 9 || this.v.getType() == 7) && this.v.getTitle() != null) {
                this.N.setText(this.v.getTitle());
                this.N.setSelection(this.v.getTitle().length());
            }
            this.N.addTextChangedListener(this.w0);
            if (!this.v.getHaveDraft()) {
                k2();
            }
            this.N.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0ec9));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.L.setOnClickListener(new c(this));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void v2(@NonNull j15 j15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, j15Var) == null) {
            if (j15Var.a == 31) {
                Object obj = j15Var.c;
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
            int i2 = j15Var.a;
            if (i2 == 29) {
                this.v.setVideoInfo(null);
            } else if (i2 == 24) {
                if (u2()) {
                    showToast(R.string.obfuscated_res_0x7f0f0d07);
                    return;
                }
                Object obj2 = j15Var.c;
                if (obj2 instanceof lx4) {
                    s2((lx4) obj2);
                }
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                D2();
            } else if (i2 == 43) {
                xt4.k().u("hot_topic_has_click", true);
                this.r0.A(new j15(2, 26, null));
                this.r = true;
                B2(true);
                if (W1().isFocused()) {
                    this.g = "from_title";
                } else if (V1().isFocused()) {
                    this.g = "from_content";
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.y2();
            q3();
            k3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void z2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, postWriteCallBackData, writeData) == null) {
            super.z2(postWriteCallBackData, writeData);
            n3();
            L2(postWriteCallBackData);
            finish();
        }
    }
}
