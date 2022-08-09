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
import com.baidu.tbadk.TbSingleton;
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
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
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
import com.repackage.b19;
import com.repackage.gy4;
import com.repackage.h25;
import com.repackage.ie5;
import com.repackage.jf5;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.qi;
import com.repackage.ru4;
import com.repackage.s25;
import com.repackage.tg;
import com.repackage.u25;
import com.repackage.zz8;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TransmitPostEditActivity extends AbsBaseWriteActivity<TransmitPostEditActivity> implements ActivityCompat.OnRequestPermissionsResultCallback {
    public static /* synthetic */ Interceptable $ic;
    public static final int J0;
    public static final int K0;
    public transient /* synthetic */ FieldHolder $fh;
    public BaijiahaoData A0;
    public OriginalThreadInfo.ShareInfo B0;
    public OriginalThreadCardView C0;
    public String D0;
    public String E0;
    public DialogInterface.OnCancelListener F0;
    public NewWriteModel G0;
    public String H0;
    public boolean I0;

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
                this.a.U.setVisibility(0);
                this.a.X.setSelected(true);
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                tg.l(transmitPostEditActivity.V, view2, 0, qi.d(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.e0.q();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.f0, transmitPostEditActivity2.H);
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.f0, transmitPostEditActivity3.L);
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
                this.a.U.setSelected(true);
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                tg.l(transmitPostEditActivity.V, view2, 0, qi.d(transmitPostEditActivity.getPageContext().getPageActivity(), 1.0f));
                this.a.e0.q();
                TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                transmitPostEditActivity2.HidenSoftKeyPad(transmitPostEditActivity2.f0, transmitPostEditActivity2.X1());
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.f0, transmitPostEditActivity3.W1());
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
                if (!oi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3c);
                }
                if (jf5.a() || this.a.i3()) {
                    return;
                }
                if (this.a.j3()) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getActivity());
                    bdTopToast.h(false);
                    bdTopToast.g(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f1143), this.a.c0.getSelectedTabItemData().name));
                    bdTopToast.i((ViewGroup) this.a.C);
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity = this.a;
                if (transmitPostEditActivity.a.b(transmitPostEditActivity.H, transmitPostEditActivity.L)) {
                    TransmitPostEditActivity transmitPostEditActivity2 = this.a;
                    transmitPostEditActivity2.showToast(transmitPostEditActivity2.a.e());
                    return;
                }
                TransmitPostEditActivity transmitPostEditActivity3 = this.a;
                transmitPostEditActivity3.HidenSoftKeyPad(transmitPostEditActivity3.f0, transmitPostEditActivity3.X1());
                TransmitPostEditActivity transmitPostEditActivity4 = this.a;
                transmitPostEditActivity4.HidenSoftKeyPad(transmitPostEditActivity4.f0, transmitPostEditActivity4.W1());
                this.a.e0.q();
                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 7));
                if (this.a.I0) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).param("obj_source", 8));
                }
                this.a.m3();
                if (TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD)) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SHARE_THREAD));
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
                    this.a.e0.A(new h25(5, -1, null));
                    this.a.L.requestFocus();
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
        J0 = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
        K0 = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds44);
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
        this.F0 = null;
        this.I0 = false;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q3();
            k3();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void C2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.r == null) {
            return;
        }
        String obj = X1() != null ? X1().getText().toString() : "";
        String trim = W1() != null ? W1().getText().toString().trim() : "";
        String trim2 = obj.trim();
        if (this.r.getType() == 0 || this.r.getType() == 9) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs();
                if (this.i == 0) {
                    if (TextUtils.isEmpty(trim2)) {
                        this.r.setIsNoTitle(true);
                    } else {
                        this.r.setIsNoTitle(false);
                        o3(true);
                        return;
                    }
                } else {
                    this.r.setIsNoTitle(false);
                    o3(true);
                    return;
                }
            } else if (TextUtils.isEmpty(trim2)) {
                this.r.setIsNoTitle(true);
            } else {
                this.r.setIsNoTitle(false);
                o3(true);
                return;
            }
        }
        if (this.u.getChosedFiles() != null && this.u.size() > 0) {
            o3(true);
        } else if (!TextUtils.isEmpty(trim)) {
            o3(true);
        } else if (this.r.getVideoInfo() != null) {
            o3(true);
        } else {
            o3(false);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F1();
            this.L.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TextView addTextButton = this.D.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f1125));
            this.F = addTextButton;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) addTextButton.getLayoutParams();
            layoutParams.rightMargin = qi.f(getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2);
            this.F.setLayoutParams(layoutParams);
            this.F.setOnFocusChangeListener(this.x0);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.P1();
            f3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public boolean R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void T1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, atListActivityConfig) == null) && (W1() instanceof SpanGroupEditText)) {
            atListActivityConfig.setSelectedAtList(((SpanGroupEditText) W1()).getAtDataInText());
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? R.color.CAM_X0207 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void U2() {
        WriteData writeData;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (writeData = this.r) == null) {
            return;
        }
        int type = writeData.getType();
        if (type != 0 && type != 9) {
            this.G.setText(R.string.obfuscated_res_0x7f0f110d);
            this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.H.setVisibility(8);
            return;
        }
        String str3 = this.l;
        if (str3 != null && str3.equals("1")) {
            this.G.setText(R.string.obfuscated_res_0x7f0f1160);
        } else {
            String str4 = this.l;
            if (str4 != null && str4.equals("2")) {
                String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.obfuscated_res_0x7f0f115d) + this.r.getForumName(), 9, true, false);
                if (fixedBarText.length() < 14) {
                    str2 = fixedBarText + getResources().getString(R.string.obfuscated_res_0x7f0f02d9);
                } else {
                    str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.obfuscated_res_0x7f0f02d9);
                }
                this.G.setText(str2);
            } else {
                this.G.setText("");
            }
        }
        this.H.setVisibility(0);
        this.L.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public int V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.L : (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public EditText X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.H : (EditText) invokeV.objValue;
    }

    public final void c3(HotTopicBussinessData hotTopicBussinessData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, hotTopicBussinessData) == null) || hotTopicBussinessData == null) {
            return;
        }
        SpannableString i = ie5.i(ie5.a(hotTopicBussinessData.mTopicName));
        if (i != null) {
            this.H.setText(i);
        }
        this.b0.setText(hotTopicBussinessData.mForumName);
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void d2(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            NewWriteModel newWriteModel = new NewWriteModel(this);
            this.G0 = newWriteModel;
            newWriteModel.d0(this.s0);
            this.F0 = new e(this);
            super.d2(bundle);
            if (bundle != null) {
                String string = bundle.getString(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                if (!StringUtils.isNull(string)) {
                    this.B0 = (OriginalThreadInfo.ShareInfo) OrmObject.objectWithJsonStr(string, OriginalThreadInfo.ShareInfo.class);
                }
                this.A0 = (BaijiahaoData) bundle.getSerializable(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.D0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.E0 = bundle.getString(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.H0 = bundle.getString("topic_id");
            } else {
                Intent intent = getIntent();
                this.A0 = (BaijiahaoData) intent.getSerializableExtra(TransmitPostEditActivityConfig.BAIJIAHAO_DATA);
                this.B0 = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(TransmitPostEditActivityConfig.KEY_ORIGINAL_THREAD);
                this.D0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_ORIGIN_THREAD_CONTENT);
                this.E0 = intent.getStringExtra(TransmitPostEditActivityConfig.TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
                this.I0 = intent.getBooleanExtra("from_share", false);
                this.H0 = intent.getStringExtra("topic_id");
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.d.getPrefixs().add(0, getPageContext().getString(R.string.obfuscated_res_0x7f0f15d1));
            }
            OriginalThreadInfo.ShareInfo shareInfo = this.B0;
            if (shareInfo != null && (str = shareInfo.videoId) != null) {
                this.r.setVideoId(str);
                this.r.setOriginalVideoCover(this.B0.showPicUrl);
                this.r.setOriginalVideoTitle(this.B0.showText);
            }
            if (pi.isEmpty(this.D0)) {
                return;
            }
            if (!pi.isEmpty(this.E0)) {
                WriteData writeData = this.r;
                writeData.setContent("//@" + this.E0 + " :" + this.D0);
                return;
            }
            this.r.setContent(this.D0);
        }
    }

    public final String d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (W1() == null || W1().getText() == null) {
                return "";
            }
            String obj = W1().getText().toString();
            if (StringUtils.isNull(obj)) {
                OriginalThreadInfo.ShareInfo shareInfo = this.B0;
                if (shareInfo != null && shareInfo.showType == 3) {
                    return getString(R.string.obfuscated_res_0x7f0f1164);
                }
                return getString(R.string.obfuscated_res_0x7f0f1163);
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    @SuppressLint({"ResourceAsColor"})
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.e2();
            if (this.r.getType() == 0) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.u.toJsonString(), true, true);
                albumActivityConfig.getIntent().putExtra("forum_id", this.r.getForumId());
                albumActivityConfig.getIntent().putExtra("from", this.f);
                albumActivityConfig.setCanEditImage(false);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
            p3();
        }
    }

    public final String e3() {
        InterceptResult invokeV;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.r == null || X1() == null || X1().getVisibility() != 0 || X1().getText() == null) {
                return "";
            }
            String obj = X1().getText().toString();
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && ListUtils.getCount(postPrefixData.getPrefixs()) > 0 && this.i != 0 && (textView = this.U) != null && textView.getText() != null) {
                obj = this.U.getText().toString() + obj;
            }
            PostPrefixData postPrefixData2 = this.d;
            if (postPrefixData2 != null && !StringUtils.isNull(postPrefixData2.getImplicitTitle())) {
                obj = this.d.getImplicitTitle() + this.r.getTitle();
            }
            if (TextUtils.isEmpty(obj)) {
                if (TextUtils.isEmpty(this.r.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f1163);
                }
                if (getString(R.string.obfuscated_res_0x7f0f1163).equals(this.r.getContent())) {
                    return getString(R.string.obfuscated_res_0x7f0f1163);
                }
                return getString(R.string.obfuscated_res_0x7f0f1164).equals(this.r.getContent()) ? getString(R.string.obfuscated_res_0x7f0f1164) : obj;
            }
            return obj;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.f2();
            this.e0.setActionListener(31, this.y0);
        }
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.e0.d(new u25(getActivity(), 2));
            if (this.s == null) {
                if (this.g0 == null) {
                    zz8 zz8Var = new zz8(getActivity(), this.l);
                    this.g0 = zz8Var;
                    zz8Var.j();
                    this.g0.i();
                    this.g0.k();
                    this.g0.o("from_share_write");
                    this.g0.l(this.r.getForumId(), this.j);
                }
                this.e0.d(this.g0);
            }
            this.e0.h(arrayList);
            s25 n = this.e0.n(5);
            if (n != null) {
                n.l = 1;
            }
        }
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) findViewById(R.id.obfuscated_res_0x7f092651);
            this.C0 = originalThreadCardView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) originalThreadCardView.getLayoutParams();
            layoutParams.topMargin -= J0;
            int i = K0;
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
            this.C0.setLayoutParams(layoutParams);
            this.C0.setVisibility(0);
            this.C0.h(this.B0);
            this.C0.setEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.u95
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 1) {
                this.X.setVisibility(0);
                ArrayList<String> prefixs = this.d.getPrefixs();
                int size = prefixs.size();
                this.i = 1;
                this.X.setOnClickListener(new a(this));
                ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a27);
                this.W = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.U.setOnClickListener(new b(this));
                }
                int color = SkinManager.getColor(R.color.CAM_X0105);
                int color2 = SkinManager.getColor(R.color.CAM_X0108);
                SkinManager.setBackgroundResource(this.U, R.color.CAM_X0201);
                SkinManager.setImageResource(this.W, R.drawable.icon_frs_arrow_n);
                this.U.setTextColor(color);
                this.N.clear();
                for (int i = 0; i < size; i++) {
                    WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                    this.N.add(writePrefixItemLayout);
                    writePrefixItemLayout.setPrefixText(prefixs.get(i));
                    if (i == 0) {
                        writePrefixItemLayout.setPrefixTextColor(color2);
                    } else {
                        writePrefixItemLayout.setPrefixTextColor(color);
                    }
                    if (i != size - 1) {
                        writePrefixItemLayout.setDividerStyle(false);
                    }
                    this.V.a(writePrefixItemLayout);
                }
                this.V.c(0);
                this.U.setText(prefixs.get(1));
                F2(1);
                return;
            }
            this.X.setVisibility(8);
        }
    }

    public final boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (((ImageSpan[]) W1().getText().getSpans(0, W1().getText().length(), ImageSpan.class)).length > 10) {
                if (this.P == null) {
                    this.P = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1431, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.P.getView().isShown()) {
                    this.P.cancel();
                }
                this.P.show();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ForumTabSelectedView forumTabSelectedView = this.c0;
            return forumTabSelectedView != null && (selectedTabItemData = forumTabSelectedView.getSelectedTabItemData()) != null && selectedTabItemData.tabType == 102 && selectedTabItemData.isGeneralTab == 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.k2();
            h3();
        }
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            WriteData writeData = this.r;
            if (writeData == null) {
                finish();
                return;
            }
            writeData.setTitle(X1().getText().toString());
            this.r.setContent(W1().getText().toString());
            finish();
        }
    }

    public final void l3() {
        HotTopicBussinessData hotTopicBussinessData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            q3();
            this.r.setContent(d3());
            this.r.setTitle(e3());
            this.r.setWriteImagesInfo(this.u);
            WriteData writeData = this.r;
            LocationModel locationModel = this.A;
            writeData.setHasLocationData(locationModel != null && locationModel.C());
            this.G0.b0(this.u.size() > 0);
            if (!ListUtils.isEmpty(this.v) && (hotTopicBussinessData = this.w) != null && hotTopicBussinessData.mIsGlobalBlock == 0) {
                this.r.setForumId(String.valueOf(hotTopicBussinessData.mForumId));
                this.r.setForumName(this.w.mForumName);
            }
            D1();
            this.G0.setWriteData(this.r);
            WriteData writeData2 = this.r;
            writeData2.setContent(writeData2.getContent().replaceAll("\u0000\n", ""));
            WriteData writeData3 = this.r;
            writeData3.setContent(writeData3.getContent().replaceAll("\u0000", ""));
            this.r.setVcode(null);
            this.G0.U().setVoice(null);
            this.G0.U().setVoiceDuringTime(-1);
            if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3c);
                return;
            }
            showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f1112), this.F0);
            this.G0.g0();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (!ListUtils.isEmpty(this.v)) {
                this.J.setVisibility(0);
                this.J.requestFocus();
                return;
            }
            this.J.setVisibility(8);
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if ("1".equals(this.l)) {
                this.r.setCanNoForum(true);
                this.r.setTransmitForumData("[]");
            } else if ("2".equals(this.l)) {
                this.r.setCanNoForum(false);
            }
            E2();
            this.r.setPrivacy(this.n);
            this.r.setIsShareThread(true);
            OriginalThreadInfo.ShareInfo shareInfo = this.B0;
            if (shareInfo != null && !StringUtils.isNull(shareInfo.threadId)) {
                this.r.setOriginalThreadId(this.B0.threadId);
            }
            this.r.setBaijiahaoData(this.A0);
            OriginalThreadInfo.ShareInfo shareInfo2 = this.B0;
            if (shareInfo2 != null) {
                this.r.setOriBaijiahaoData(shareInfo2.oriUgcInfo);
            }
            this.r.setCallFrom(this.l);
            l3();
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || StringUtils.isNull(this.H0)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921634, this.H0));
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.o2();
            if (this.D.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.D.getBackImageView(), R.drawable.obfuscated_res_0x7f0809f3, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            g3();
            ShowSoftKeyPad(this.f0, this.H);
        }
    }

    public final void o3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            SkinManager.setNavbarTitleColor(this.F, R.color.CAM_X0302, R.color.s_navbar_title_color);
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
                    EditorTools editorTools = this.e0;
                    if (editorTools != null && !editorTools.u()) {
                        this.L.requestFocus();
                        this.f0.toggleSoftInput(0, 2);
                    }
                    if (i == 12002) {
                        if (intent == null || !intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                            return;
                        }
                        this.u.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    } else if (i != 12006) {
                        if (i != 25004) {
                            return;
                        }
                        if ("from_title".equals(this.g)) {
                            X1().requestFocus();
                            return;
                        } else if ("from_content".equals(this.g)) {
                            W1().requestFocus();
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
                        this.a.h(this.H, this.L);
                        return;
                    }
                }
                return;
            }
            PostWriteCallBackData postWriteCallBackData2 = null;
            postWriteCallBackData2 = null;
            postWriteCallBackData2 = null;
            if (i == 12004) {
                EditorTools editorTools2 = this.e0;
                if (editorTools2 != null && !editorTools2.u()) {
                    W1().requestFocus();
                    this.f0.toggleSoftInput(0, 2);
                }
                ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA) : null;
                int selectionStart = W1().getSelectionStart();
                if (selectionStart > 0) {
                    int i3 = selectionStart - 1;
                    if (W1().getText().toString().charAt(i3) == '@') {
                        W1().getEditableText().delete(i3, selectionStart);
                    }
                }
                if (W1() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) W1()).e(parcelableArrayListExtra);
                }
                if (parcelableArrayListExtra == null || parcelableArrayListExtra.size() <= 0) {
                    return;
                }
                W1().getText().delete(W1().getSelectionStart(), W1().getSelectionEnd());
                if (W1() instanceof SpanGroupEditText) {
                    ((SpanGroupEditText) W1()).b(parcelableArrayListExtra);
                }
            } else if (i == 12006) {
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                J2(postWriteCallBackData2);
                setResult(-1, intent);
                finish();
            } else if (i != 25004) {
                if (i != 25005 || intent == null || ListUtils.isEmpty(this.v) || ListUtils.isEmpty(this.v) || intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) >= this.v.size()) {
                    return;
                }
                HotTopicBussinessData hotTopicBussinessData = this.v.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                this.w = hotTopicBussinessData;
                c3(hotTopicBussinessData);
            } else if (intent == null) {
            } else {
                String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                if (StringUtils.isNull(stringExtra)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (this.o) {
                    sb.append("#");
                    this.o = false;
                }
                sb.append(stringExtra);
                C1(sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(X1(), R.color.CAM_X0201);
            SkinManager.setBackgroundColor(W1(), R.color.CAM_X0201);
            OriginalThreadCardView originalThreadCardView = this.C0;
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
            this.L.requestFocus();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            q3();
            this.G0.d0(null);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            OriginalThreadInfo.ShareInfo shareInfo = this.B0;
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
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById(R.id.obfuscated_res_0x7f0919fb);
            this.L = spanGroupEditText;
            spanGroupEditText.setDrawingCacheEnabled(false);
            this.L.setOnClickListener(this.w0);
            NewWriteModel newWriteModel = this.G0;
            if (newWriteModel != null) {
                newWriteModel.setSpanGroupManager(this.L.getSpanGroupManager());
            }
            WriteData writeData = this.r;
            if (writeData != null) {
                writeData.setSpanGroupManager(this.L.getSpanGroupManager());
            }
            if (this.r.getContent() != null && this.r.getContent().length() > 0) {
                this.L.setText(TbFaceManager.i().r(getPageContext().getPageActivity(), this.r.getContent()));
                SpanGroupEditText spanGroupEditText2 = this.L;
                spanGroupEditText2.setSelection(spanGroupEditText2.getText().length());
            }
            if (!pi.isEmpty(this.D0)) {
                this.L.setSelection(0);
            }
            this.L.setOnFocusChangeListener(this.x0);
            this.L.setOnTouchListener(new d(this));
            this.L.addTextChangedListener(this.i0);
            OriginalThreadInfo.ShareInfo shareInfo = this.B0;
            if (shareInfo != null && shareInfo.showType == 3) {
                this.L.setHint(R.string.obfuscated_res_0x7f0f1164);
            } else {
                this.L.setHint(R.string.obfuscated_res_0x7f0f1163);
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.h0 == null) {
                this.h0 = new b19(getPageContext());
            }
            this.h0.c(this.e0);
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f091a18);
            this.H = editText;
            editText.setOnClickListener(this.w0);
            this.H.setOnFocusChangeListener(this.x0);
            if ((this.r.getType() == 0 || this.r.getType() == 9) && this.r.getTitle() != null) {
                this.H.setText(this.r.getTitle());
                this.H.setSelection(this.r.getTitle().length());
            }
            this.H.addTextChangedListener(this.j0);
            if (!this.r.getHaveDraft()) {
                j2();
            }
            this.H.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0edf));
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            NewWriteModel newWriteModel = this.G0;
            if (newWriteModel != null) {
                newWriteModel.cancelLoadData();
            }
            FeedBackModel feedBackModel = this.B;
            if (feedBackModel != null) {
                feedBackModel.cancelLoadData();
            }
            LocationModel locationModel = this.A;
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.F.setOnClickListener(new c(this));
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void u2(@NonNull h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, h25Var) == null) {
            if (h25Var.a == 31) {
                Object obj = h25Var.c;
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
            int i2 = h25Var.a;
            if (i2 == 29) {
                this.r.setVideoInfo(null);
            } else if (i2 == 24) {
                if (t2()) {
                    showToast(R.string.obfuscated_res_0x7f0f0d19);
                    return;
                }
                Object obj2 = h25Var.c;
                if (obj2 instanceof gy4) {
                    r2((gy4) obj2);
                }
            } else if (i2 == 12 || i2 == 13 || i2 == 46 || i2 == 49) {
                C2();
            } else if (i2 == 43) {
                ru4.k().u("hot_topic_has_click", true);
                this.e0.A(new h25(2, 26, null));
                this.o = true;
                A2(true);
                if (X1().isFocused()) {
                    this.g = "from_title";
                } else if (W1().isFocused()) {
                    this.g = "from_content";
                }
            }
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.x2();
            q3();
            k3();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void y2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, postWriteCallBackData, writeData) == null) {
            super.y2(postWriteCallBackData, writeData);
            n3();
            K2(postWriteCallBackData);
            finish();
        }
    }

    @Override // com.baidu.tieba.write.write.AbsBaseWriteActivity
    public void z2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048622, this, z) == null) && z) {
            D2();
        }
    }
}
