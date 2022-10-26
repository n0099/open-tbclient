package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bj5;
import com.baidu.tieba.c29;
import com.baidu.tieba.cy4;
import com.baidu.tieba.e25;
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.g65;
import com.baidu.tieba.j15;
import com.baidu.tieba.jh;
import com.baidu.tieba.jz8;
import com.baidu.tieba.l55;
import com.baidu.tieba.m55;
import com.baidu.tieba.nh5;
import com.baidu.tieba.pn;
import com.baidu.tieba.pu4;
import com.baidu.tieba.s39;
import com.baidu.tieba.s55;
import com.baidu.tieba.t29;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tc6;
import com.baidu.tieba.tp8;
import com.baidu.tieba.uc6;
import com.baidu.tieba.ux4;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.w39;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.yx4;
import com.baidu.tieba.zp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public abstract class AbsBaseWriteActivity extends BaseActivity implements c29.a, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText A;
    public LinearLayout B;
    public ConstraintLayout C;
    public LinearLayout D;
    public SpanGroupEditText E;
    public View F;
    public ArrayList G;
    public RelativeLayout H;
    public Toast I;
    public TextView J;
    public c29 K;
    public ImageView L;
    public View M;
    public PostCategoryView N;
    public ScrollView O;
    public yx4 P;
    public ForumTabSelectedView Q;
    public GestureDetector R;
    public EditorTools S;
    public InputMethodManager T;
    public t29 U;
    public w39 V;
    public TextWatcher W;
    public TextWatcher X;
    public TbFaceManager.a Y;
    public final AntiHelper.k Z;
    public final s39 a;
    public final NewWriteModel.d a0;
    public final KeyEvent b;
    public final CustomMessageListener b0;
    public final Handler c;
    public final View.OnClickListener c0;
    public PostPrefixData d;
    public final View.OnFocusChangeListener d0;
    public String e;
    public final m55 e0;
    public String f;
    public jz8 f0;
    public String g;
    public String h;
    public int i;
    public int j;
    public String k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public WriteData p;
    public WriteImagesInfo q;
    public FrsTabInfoData r;
    public String s;
    public String t;
    public FeedBackModel u;
    public View v;
    public NavigationBar w;
    public View x;
    public TextView y;
    public TextView z;

    public void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void D1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, editable) == null) {
        }
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editable) == null) {
        }
    }

    public void G1(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048587, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public abstract boolean G2();

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void J1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
        }
    }

    public boolean K1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, writeData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L2(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, view2, z) == null) {
        }
    }

    public boolean Q1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, postWriteCallBackData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void R1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, atListActivityConfig) == null) {
        }
    }

    public abstract int T1();

    public abstract int U1();

    public abstract EditText V1();

    public abstract EditText W1();

    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    public abstract void i2();

    public abstract void k2();

    public abstract void l2();

    public abstract void n2();

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048639, this, i2, dialog) == null) {
        }
    }

    public void p2(l55 l55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, l55Var) == null) {
        }
    }

    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
        }
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract void v2();

    /* loaded from: classes6.dex */
    public class j implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* loaded from: classes6.dex */
        public class a implements pu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements pu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public b(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 1)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 1));
                }
            }
        }

        public j(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, e25 e25Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, e25Var, writeData, antiData}) == null) {
                this.a.I1();
                this.a.closeLoadingDialog();
                if (postWriteCallBackData != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.p != null) {
                        absBaseWriteActivity.a.m(null);
                        if (z) {
                            this.a.A2(postWriteCallBackData);
                            this.a.s2(postWriteCallBackData, writeData);
                        } else if (postWriteCallBackData.isSensitiveError()) {
                            this.a.showToast(postWriteCallBackData.getErrorString());
                            this.a.a.n(postWriteCallBackData.getErrorString());
                            this.a.a.m(postWriteCallBackData.getSensitiveWords());
                            AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                            absBaseWriteActivity2.a.h(absBaseWriteActivity2.A, absBaseWriteActivity2.E);
                        } else if (postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                            if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                                DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0488), null).v();
                            } else {
                                DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            }
                        } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                            pu4 pu4Var = new pu4(this.a.getActivity());
                            if (ej.isEmpty(postWriteCallBackData.getErrorString())) {
                                pu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d22));
                            } else {
                                pu4Var.setMessage(postWriteCallBackData.getErrorString());
                            }
                            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d24, new b(this));
                            pu4Var.create(this.a.getPageContext()).show();
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                        } else if ((e25Var == null || writeData == null || e25Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && this.a.Q1(postWriteCallBackData)) {
                            this.a.H2(false, postWriteCallBackData);
                        } else if (e25Var != null && writeData != null && e25Var.c() != null) {
                            if (writeData.isCanNoForum()) {
                                writeData.setForumName("");
                                writeData.setForumId("0");
                            }
                            writeData.setVcodeMD5(e25Var.b());
                            writeData.setVcodeUrl(e25Var.c());
                            writeData.setVcodeExtra(e25Var.a());
                            if (bj5.b(e25Var.d())) {
                                this.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, e25Var.d())));
                            } else {
                                this.a.sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getPageContext().getPageActivity(), writeData, 12006)));
                            }
                        } else if (postWriteCallBackData.getErrorCode() == 227001) {
                            this.a.sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements m55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public a(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.m55
        public void B(l55 l55Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l55Var) != null) || l55Var == null) {
                return;
            }
            this.a.p2(l55Var);
            int i = l55Var.a;
            if (i == 16) {
                if (this.a.o2()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d48);
                } else {
                    this.a.F2();
                }
            } else if (i == 3) {
                this.a.O1();
            } else if (i == 29) {
                this.a.S.A(new l55(2, 19, null));
                this.a.S.A(new l55(1, 2, null));
                this.a.v2();
                SpanGroupEditText spanGroupEditText = this.a.E;
                if (spanGroupEditText != null) {
                    spanGroupEditText.requestFocus();
                }
                this.a.S.q();
                this.a.S.A(new l55(5, -1, null));
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.ShowSoftKeyPad(absBaseWriteActivity.T, absBaseWriteActivity.E);
            } else if (i == 55) {
                Object obj = l55Var.c;
                if (obj instanceof Boolean) {
                    this.a.m = ((Boolean) obj).booleanValue();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public b(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 2) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.E != null) {
                        fj.x(absBaseWriteActivity.getPageContext().getContext(), this.a.E);
                    }
                    EditorTools editorTools = this.a.S;
                    if (editorTools != null) {
                        editorTools.q();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public c(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.requestFocus();
                this.a.S.A(new l55(5, -1, null));
                this.a.E.requestFocus();
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.ShowSoftKeyPadDelay(absBaseWriteActivity.E);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public d(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TimePickerDialog.OnTimeSetListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
        }

        public e(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public final /* synthetic */ AbsBaseWriteActivity c;

        public f(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absBaseWriteActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.c.v2();
                EditText V1 = this.c.V1();
                if (editable != null && V1 != null && V1.getText() != null) {
                    int selectionEnd = V1.getSelectionEnd();
                    String str = this.a;
                    if (str != null && str.equals(editable.toString())) {
                        V1.setSelection(selectionEnd);
                        return;
                    }
                    if (this.c.a != null) {
                        this.a = V1.getText().toString();
                        this.c.a.i(V1, false);
                    }
                    this.c.D1(editable);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null) {
                    str = charSequence.toString();
                } else {
                    str = "";
                }
                this.b = str;
                this.c.G1(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                int i5 = 0;
                if (str != null) {
                    i4 = str.toString().length();
                } else {
                    i4 = 0;
                }
                if (charSequence != null) {
                    i5 = charSequence.toString().length();
                }
                if (i5 > i4) {
                    this.c.Y1(charSequence, i, i3, "from_content");
                    this.c.X1(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public g(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.v2();
                this.a.F1(editable);
                this.a.K2();
                EditText W1 = this.a.W1();
                if (editable != null && W1 != null && W1.getText() != null) {
                    String str = this.a.s;
                    if (str != null && str.equals(editable.toString())) {
                        W1.setSelection(W1.getSelectionEnd());
                        return;
                    }
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.a != null) {
                        absBaseWriteActivity.s = W1.getText().toString();
                        this.a.a.i(W1, true);
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                if (charSequence != null) {
                    str = charSequence.toString();
                } else {
                    str = "";
                }
                absBaseWriteActivity.t = str;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.a.t;
                int i5 = 0;
                if (str != null) {
                    i4 = str.length();
                } else {
                    i4 = 0;
                }
                if (charSequence != null) {
                    i5 = charSequence.toString().length();
                }
                if (i5 > i4) {
                    this.a.Y1(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements TbFaceManager.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public h(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan a(String str) {
            InterceptResult invokeL;
            pn pnVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), pn.class);
                if (runTask != null) {
                    pnVar = (pn) runTask.getData();
                } else {
                    pnVar = null;
                }
                if (pnVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(pnVar.p());
                int r = pnVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, pnVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new cy4(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public i(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(AbsBaseWriteActivity absBaseWriteActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public l(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S.A(new l55(5, -1, null));
                int P1 = this.a.P1();
                if (P1 >= 0 && P1 < this.a.E.getText().length()) {
                    this.a.E.setSelection(P1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public m(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                if (view2 == absBaseWriteActivity.A || view2 == absBaseWriteActivity.x || view2 == absBaseWriteActivity.y) {
                    if (z) {
                        AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                        absBaseWriteActivity2.l = true;
                        absBaseWriteActivity2.L1();
                        EditorTools editorTools = this.a.S;
                        if (editorTools != null) {
                            editorTools.q();
                        }
                        fj.L(this.a.getActivity(), this.a.A);
                    } else {
                        AbsBaseWriteActivity absBaseWriteActivity3 = this.a;
                        if (view2 == absBaseWriteActivity3.A) {
                            absBaseWriteActivity3.J.setVisibility(0);
                        }
                    }
                }
                AbsBaseWriteActivity absBaseWriteActivity4 = this.a;
                if (view2 == absBaseWriteActivity4.E && z) {
                    absBaseWriteActivity4.l = false;
                    absBaseWriteActivity4.L1();
                    EditorTools editorTools2 = this.a.S;
                    if (editorTools2 != null) {
                        editorTools2.q();
                    }
                    fj.L(this.a.getActivity(), this.a.E);
                }
                this.a.L2(view2, z);
                this.a.J2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public n(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.showToast(absBaseWriteActivity.e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        public o(AbsBaseWriteActivity absBaseWriteActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absBaseWriteActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absBaseWriteActivity;
        }

        public /* synthetic */ o(AbsBaseWriteActivity absBaseWriteActivity, f fVar) {
            this(absBaseWriteActivity);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                fj.x(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    public AbsBaseWriteActivity() {
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
        this.a = new s39();
        this.b = new KeyEvent(0, 67);
        this.c = new Handler();
        this.e = null;
        this.f = AlbumActivityConfig.FROM_WRITE;
        this.g = "";
        this.k = "2";
        this.l = true;
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = new WriteImagesInfo();
        this.s = "";
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = null;
        this.E = null;
        this.G = new ArrayList();
        this.H = null;
        this.O = null;
        this.P = null;
        this.T = null;
        this.W = new f(this);
        this.X = new g(this);
        this.Y = new h(this);
        this.Z = new i(this);
        this.a0 = new j(this);
        this.b0 = new k(this, 2016554);
        this.c0 = new l(this);
        this.d0 = new m(this);
        this.e0 = new a(this);
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.S.setActionListener(16, this.e0);
            this.S.setActionListener(14, this.e0);
            this.S.setActionListener(24, this.e0);
            this.S.setActionListener(3, this.e0);
            this.S.setActionListener(10, this.e0);
            this.S.setActionListener(11, this.e0);
            this.S.setActionListener(12, this.e0);
            this.S.setActionListener(13, this.e0);
            this.S.setActionListener(15, this.e0);
            this.S.setActionListener(25, this.e0);
            this.S.setActionListener(27, this.e0);
            this.S.setActionListener(29, this.e0);
            this.S.setActionListener(43, this.e0);
            this.S.setActionListener(48, this.e0);
            this.S.setActionListener(46, this.e0);
            this.S.setActionListener(49, this.e0);
            this.S.setActionListener(47, this.e0);
            this.S.setActionListener(55, this.e0);
        }
    }

    public void X1(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048611, this, charSequence, i2, i3) == null) && this.o && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            F2();
        }
    }

    public void A2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void B2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postWriteCallBackData) == null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, motionEvent)) == null) {
            if (this.R.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.o = z;
            t29 t29Var = this.U;
            if (t29Var != null && !z) {
                t29Var.g();
            }
            if (this.V != null && !z) {
                Z1();
            }
        }
    }

    public void B1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.g)) {
            this.g = "";
            V1().requestFocus();
            if (V1().getText() != null && V1().getText().length() + str.length() > 5000) {
                showToast(R.string.obfuscated_res_0x7f0f0d48);
                return;
            } else {
                i2 = V1().getSelectionStart();
                editable = V1().getText();
            }
        } else if ("from_title".equals(this.g)) {
            this.g = "";
            W1().requestFocus();
            if (W1().getText() != null && W1().getText().length() + str.length() > 31) {
                showToast(R.string.obfuscated_res_0x7f0f0d48);
                return;
            } else {
                i2 = W1().getSelectionStart();
                editable = W1().getText();
            }
        }
        if (editable != null && i2 >= 0 && i2 <= editable.length()) {
            editable.insert(i2, str);
        }
    }

    public void C1() {
        WriteData writeData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (writeData = this.p) != null && this.Q != null) {
            FrsTabInfoData frsTabInfoData = this.r;
            if (frsTabInfoData != null && frsTabInfoData.isForumBusinessAccount) {
                z = true;
            } else {
                z = false;
            }
            writeData.setIsForumBusinessAccount(z);
            FrsTabItemData selectedTabItemData = this.Q.getSelectedTabItemData();
            if (selectedTabItemData == null) {
                return;
            }
            this.p.setTabId(selectedTabItemData.tabId);
            this.p.setTabName(selectedTabItemData.name);
            this.p.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            R1(atListActivityConfig);
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.S.setBarMaxLauCount(U1());
            this.S.setMoreButtonAtEnd(true);
            this.S.setBarLauncherType(1);
            this.S.C(true);
            this.S.D(G2());
            this.S.setBackgroundColorId(T1());
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.M = findViewById(R.id.obfuscated_res_0x7f091a46);
            this.J = (TextView) findViewById(R.id.obfuscated_res_0x7f091a45);
            this.F = findViewById(R.id.obfuscated_res_0x7f091a65);
            this.L = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a66);
            h2();
        }
    }

    public final boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            c29 c29Var = this.K;
            if (c29Var != null && c29Var.isShowing()) {
                jh.d(this.K, getPageContext().getPageActivity());
                return true;
            } else if (this.S.u()) {
                this.S.q();
                return true;
            } else {
                return u2();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            EditorTools editorTools = this.S;
            if (editorTools != null) {
                editorTools.A(new l55(12, -1, new g65(this.q, true)));
                this.S.A(new l55(12, 11, new g65(this.q, true)));
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H2(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048590, this, z, postWriteCallBackData) == null) && postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.w(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.Z) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                if (postWriteCallBackData.getErrorCode() == 230278) {
                    return;
                }
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1077);
                }
                showToast(errorString);
            } else if (!M1(postWriteCallBackData)) {
                tp8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.A.hasFocus()) {
                this.A.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.A.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            if (this.E.hasFocus()) {
                this.E.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            } else {
                this.E.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
        }
    }

    public final void K2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (editText = this.A) != null && editText.getText() != null && this.A.getText().toString() != null && this.A.getPaint() != null) {
            if (this.A.getText().toString().length() == 0) {
                this.A.getPaint().setFakeBoldText(true);
            } else if (this.A.getText().toString().length() > 0) {
                this.A.getPaint().setFakeBoldText(true);
            }
        }
    }

    public int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            int selectionEnd = V1().getSelectionEnd();
            ImageSpan[] imageSpanArr = (ImageSpan[]) V1().getText().getSpans(0, V1().getText().length(), ImageSpan.class);
            for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
                int spanStart = V1().getText().getSpanStart(imageSpanArr[i2]);
                int spanEnd = V1().getText().getSpanEnd(imageSpanArr[i2]);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || !D2()) {
            return;
        }
        ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090c13);
        this.Q = forumTabSelectedView;
        forumTabSelectedView.setBgColor(R.color.CAM_X0205);
        S1(this.r, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06e0));
        this.Q.setData(this.r);
        this.Q.setActivity(getPageContext());
        d2();
    }

    public void h2() {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (postPrefixData = this.d) != null && postPrefixData.getPrefixs().size() > 1) {
            c29 c29Var = new c29(getPageContext().getPageActivity());
            this.K = c29Var;
            c29Var.e(this);
            this.K.d(fj.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d6));
            this.K.setOutsideTouchable(true);
            this.K.setFocusable(true);
            this.K.setOnDismissListener(this);
            this.K.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
        }
    }

    public void L1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (editorTools = this.S) != null) {
            editorTools.setBarLauncherEnabled(!this.l);
            this.S.setToolEnabled(true, 26);
        }
    }

    public void Z1() {
        w39 w39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (w39Var = this.V) != null) {
            w39Var.b();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        yx4 yx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (yx4Var = this.P) != null) {
            yx4Var.h(false);
        }
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            registerListener(this.b0);
        }
    }

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (V1().getText() != null && V1().getText().length() >= 5000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            Z1();
            TiebaPrepareImageService.StopService();
            super.onDestroy();
            this.c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.M.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            HidenSoftKeyPad(this.T, W1());
            HidenSoftKeyPad(this.T, V1());
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    public void w2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (editorTools = this.S) != null) {
            editorTools.A(new l55(54, 15, null));
        }
    }

    public void y2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048653, this) == null) && (editorTools = this.S) != null) {
            editorTools.A(new l55(9, -1, Boolean.TRUE));
        }
    }

    public boolean M1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData != null && postWriteCallBackData.getVideoEasterEggData() != null && !ej.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            J1(bundle);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.R = new GestureDetector(getPageContext().getPageActivity(), new o(this, null));
            this.T = (InputMethodManager) getSystemService("input_method");
            a2(bundle);
            f2();
            H1();
            j2();
            E1();
            b2();
            i2();
            z2();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = V1().getEditableText().toString();
            if (obj != null) {
                V1().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.Y));
                V1().setSelection(V1().getText().length());
            }
        }
    }

    public void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            WriteData writeData = this.p;
            if (writeData != null) {
                hotSelectActivityConfig.setForumExtra(eh.g(writeData.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && V1().getSelectionStart() > 0) {
            String substring = V1().getText().toString().substring(0, V1().getSelectionStart());
            Matcher matcher = tc6.b.matcher(substring);
            if (matcher.find()) {
                V1().getText().delete(V1().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), V1().getSelectionStart());
                return;
            }
            V1().onKeyDown(67, this.b);
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.S = new EditorTools(getActivity());
            N1();
            this.S.f();
            LinearLayout linearLayout = this.B;
            if (linearLayout != null) {
                linearLayout.addView(this.S);
            }
            c2();
            this.S.j();
            s55 m2 = this.S.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.e)) {
                ((View) m2).setOnClickListener(new n(this));
            }
            this.S.A(new l55(34, 5, 1));
            this.S.q();
            if (!ux4.k().h("hot_topic_has_click", false)) {
                this.S.A(new l55(2, 26, " "));
            }
        }
    }

    @Override // com.baidu.tieba.c29.a
    public void S0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.i = i2;
            this.K.c(i2);
            x2(i2);
            this.J.setText(this.d.getPrefixs().get(i2));
            v2();
            jh.d(this.K, getPageContext().getPageActivity());
        }
    }

    public void x2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048652, this, i2) != null) || i2 >= this.G.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            ((WritePrefixItemLayout) this.G.get(i3)).b(false);
        }
        ((WritePrefixItemLayout) this.G.get(i2)).b(true);
    }

    public final boolean S1(FrsTabInfoData frsTabInfoData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, frsTabInfoData, str)) == null) {
            if (frsTabInfoData == null || ListUtils.isEmpty(frsTabInfoData.tabList)) {
                return false;
            }
            int i2 = 0;
            while (true) {
                if (i2 < frsTabInfoData.tabList.size()) {
                    if (str.equals(frsTabInfoData.tabList.get(i2).name)) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 != -1) {
                frsTabInfoData.tabList.remove(i2);
            }
            if (i2 == -1) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048636, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                return q2();
            }
            if (i2 == 67 && (text = V1().getText()) != null && V1().getSelectionStart() - 1 > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
                V1().onKeyDown(67, this.b);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void Y1(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && E2() && this.o && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0) {
            this.n = false;
            this.g = "";
            if ("from_content".equals(str)) {
                this.g = "from_content";
            } else if ("from_title".equals(str)) {
                this.g = "from_title";
            }
            if (nh5.f(String.valueOf(charSequence.charAt(i2)))) {
                t2(false);
            }
        }
    }

    public void a2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            WriteData writeData = new WriteData();
            this.p = writeData;
            if (bundle != null) {
                writeData.setType(bundle.getInt("type", 9));
                this.p.setForumId(bundle.getString("forum_id"));
                this.p.setForumName(bundle.getString("forum_name"));
                this.p.setFirstDir(bundle.getString(IntentConfig.FORUM_FIRST_DIR));
                this.p.setSecondDir(bundle.getString(IntentConfig.FORUM_SECOND_DIR));
                this.p.setThreadId(bundle.getString("thread_id"));
                this.h = bundle.getString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                String string = bundle.getString(BaseWriteConfig.PREFIX_DATA);
                if (!StringUtils.isNull(string)) {
                    this.d = (PostPrefixData) OrmObject.objectWithJsonStr(string, PostPrefixData.class);
                }
                this.f = bundle.getString("from");
                this.j = bundle.getInt(BaseWriteConfig.PRIVATE_THREAD);
                this.p.setTitle(bundle.getString(BaseWriteConfig.TITLE));
                this.p.setContent(bundle.getString(BaseWriteConfig.CONTENT));
                this.k = bundle.getString(BaseWriteConfig.KEY_CALL_FROM);
                this.r = (FrsTabInfoData) bundle.getSerializable("tab_list");
            } else {
                Intent intent = getIntent();
                this.p.setType(intent.getIntExtra("type", 9));
                this.p.setForumId(intent.getStringExtra("forum_id"));
                this.p.setForumName(intent.getStringExtra("forum_name"));
                this.p.setFirstDir(intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR));
                this.p.setSecondDir(intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR));
                this.p.setThreadId(intent.getStringExtra("thread_id"));
                this.p.setTitle(intent.getStringExtra(BaseWriteConfig.TITLE));
                this.p.setContent(intent.getStringExtra(BaseWriteConfig.CONTENT));
                this.d = (PostPrefixData) intent.getSerializableExtra(BaseWriteConfig.PREFIX_DATA);
                this.f = intent.getStringExtra("from");
                this.j = intent.getIntExtra(BaseWriteConfig.PRIVATE_THREAD, 0);
                this.k = intent.getStringExtra(BaseWriteConfig.KEY_CALL_FROM);
                this.h = intent.getStringExtra(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING);
                this.r = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            }
            if (this.q == null) {
                this.q = new WriteImagesInfo();
            }
            String str = this.h;
            if (str != null) {
                this.q.parseJson(str);
                this.q.updateQuality();
            }
            this.q.setMaxImagesAllowed(9);
            this.p.setWriteImagesInfo(this.q);
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.P = new yx4(getPageContext());
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0938, (ViewGroup) null);
            this.v = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925ad);
            this.w = navigationBar;
            navigationBar.showBottomLine();
            this.x = this.w.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.w.setCenterTextTitle("");
            this.z = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            C2();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f0926a8);
            this.O = scrollView;
            scrollView.setOnTouchListener(new b(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.H = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091784);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092270);
            this.B = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.C = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f092235);
            l2();
            k2();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a3b);
            this.D = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.D.setOnClickListener(new c(this));
            this.x.setOnFocusChangeListener(this.d0);
            this.x.setOnClickListener(new d(this));
            n2();
            I2();
            L1();
            g2();
            e2();
            v2();
        }
    }

    public void m2(j15 j15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, j15Var) == null) {
            if (((ImageSpan[]) V1().getText().getSpans(0, V1().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.I == null) {
                    this.I = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1470, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.I.getView().isShown()) {
                    this.I.cancel();
                }
                this.I.show();
                return;
            }
            uc6.b(this, j15Var, V1());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            super.onChangeSkinType(i2);
            zp4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.H);
            this.w.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0105);
            this.y.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            L1();
            v2();
            this.S.w(i2);
            PostCategoryView postCategoryView = this.N;
            if (postCategoryView != null) {
                postCategoryView.a();
            }
            J2();
            K2();
            s39 s39Var = this.a;
            if (s39Var != null) {
                s39Var.l(W1(), V1());
            }
            ForumTabSelectedView forumTabSelectedView = this.Q;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.o(i2);
            }
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            jz8 jz8Var = new jz8(getPageContext().getPageActivity(), new e(this), new Date().getHours(), new Date().getMinutes(), false);
            this.f0 = jz8Var;
            jz8Var.setTitle(R.string.obfuscated_res_0x7f0f0c88);
            this.f0.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f026a), this.f0);
            this.f0.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0375), this.f0);
            return this.f0;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, bundle) == null) {
            bundle.putInt("type", this.p.getType());
            bundle.putString("forum_id", this.p.getForumId());
            bundle.putString("forum_name", this.p.getForumName());
            bundle.putString(IntentConfig.FORUM_FIRST_DIR, this.p.getFirstDir());
            bundle.putString(IntentConfig.FORUM_SECOND_DIR, this.p.getSecondDir());
            bundle.putString("thread_id", this.p.getThreadId());
            bundle.putInt(BaseWriteConfig.PRIVATE_THREAD, this.j);
            bundle.putString("from", this.f);
            bundle.putString(BaseWriteConfig.KEY_CALL_FROM, this.k);
            bundle.putSerializable("tab_list", this.r);
            WriteImagesInfo writeImagesInfo = this.q;
            if (writeImagesInfo != null) {
                bundle.putString(BaseWriteConfig.KEY_WRITE_IMAGES_INFO_STRING, writeImagesInfo.toJsonString());
            }
            PostPrefixData postPrefixData = this.d;
            if (postPrefixData != null) {
                bundle.putString(BaseWriteConfig.PREFIX_DATA, OrmObject.jsonStrWithObject(postPrefixData));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void s2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, postWriteCallBackData, writeData) == null) {
            y2();
            if (K1(writeData)) {
                H2(true, postWriteCallBackData);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        yx4 yx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048647, this, str, onCancelListener) != null) || (yx4Var = this.P) == null) {
            return;
        }
        yx4Var.e(null);
        this.P.i(R.string.obfuscated_res_0x7f0f1146);
        this.P.h(true);
    }
}
