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
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.R;
import com.baidu.tieba.ae5;
import com.baidu.tieba.aj5;
import com.baidu.tieba.bx5;
import com.baidu.tieba.c0b;
import com.baidu.tieba.e47;
import com.baidu.tieba.ed5;
import com.baidu.tieba.ei;
import com.baidu.tieba.f47;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.kg;
import com.baidu.tieba.kza;
import com.baidu.tieba.mva;
import com.baidu.tieba.o3b;
import com.baidu.tieba.oj5;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.s3b;
import com.baidu.tieba.si5;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.ti5;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.x95;
import com.baidu.tieba.y45;
import com.baidu.tieba.yja;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
/* loaded from: classes8.dex */
public abstract class AbsBaseWriteActivity<T> extends BaseActivity<T> implements kza.a, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText A;
    public LinearLayout B;
    public ConstraintLayout C;
    public LinearLayout D;
    public SpanGroupEditText E;
    public View F;
    public ArrayList<WritePrefixItemLayout> G;
    public RelativeLayout H;
    public Toast I;
    public TextView J;
    public kza K;
    public ImageView L;
    public View M;
    public PostCategoryView N;
    public ScrollView O;
    public BlueCircleProgressDialog P;
    public ForumTabSelectedView Q;
    public GestureDetector R;
    public EditorTools S;

    /* renamed from: T  reason: collision with root package name */
    public InputMethodManager f1178T;
    public c0b U;
    public s3b V;
    public TextWatcher W;
    public TextWatcher X;
    public TbFaceManager.a Y;
    public final AntiHelper.k Z;
    public final o3b a;
    public final NewWriteModel.d a0;
    public final KeyEvent b;
    public final CustomMessageListener b0;
    public final Handler c;
    public final View.OnClickListener c0;
    public PostPrefixData d;
    public final View.OnFocusChangeListener d0;
    public String e;
    public final ti5 e0;
    public String f;
    public mva f0;
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

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void B1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
        }
    }

    public abstract boolean B2();

    public boolean C1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, writeData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void G2(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, view2, z) == null) {
        }
    }

    public boolean J1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, postWriteCallBackData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void K1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, atListActivityConfig) == null) {
        }
    }

    public abstract int M1();

    public abstract int N1();

    public abstract EditText O1();

    public abstract EditText P1();

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
        }
    }

    public abstract void d2();

    public abstract void f2();

    public abstract void g2();

    public abstract void i2();

    public void k2(@NonNull si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, si5Var) == null) {
        }
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048632, this, i2, dialog) == null) {
        }
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract void q2();

    public void v1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, editable) == null) {
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
        }
    }

    public void x1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, editable) == null) {
        }
    }

    public void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
        }
    }

    public void y1(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048651, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
        }
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class j implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* loaded from: classes8.dex */
        public class a implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                    PayPanelUtils.launchPayPanel(this.a.a.getPageContext(), IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING);
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ae5 ae5Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ae5Var, writeData, antiData}) == null) {
                this.a.A1();
                this.a.closeLoadingDialog();
                if (postWriteCallBackData != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.p != null) {
                        absBaseWriteActivity.a.m(null);
                        if (z) {
                            this.a.v2(postWriteCallBackData);
                            this.a.n2(postWriteCallBackData, writeData);
                        } else if (postWriteCallBackData.isSensitiveError()) {
                            this.a.showToast(postWriteCallBackData.getErrorString());
                            this.a.a.n(postWriteCallBackData.getErrorString());
                            this.a.a.m(postWriteCallBackData.getSensitiveWords());
                            AbsBaseWriteActivity absBaseWriteActivity2 = this.a;
                            absBaseWriteActivity2.a.h(absBaseWriteActivity2.A, absBaseWriteActivity2.E);
                        } else if (postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                            if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                                DefaultNavigationBarCoverTip.q(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).s();
                            } else {
                                DefaultNavigationBarCoverTip.q(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).s();
                            }
                        } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                            y45 y45Var = new y45(this.a.getActivity());
                            if (ei.isEmpty(postWriteCallBackData.getErrorString())) {
                                y45Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                            } else {
                                y45Var.setMessage(postWriteCallBackData.getErrorString());
                            }
                            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new a(this));
                            y45Var.setPositiveButton(R.string.open_now, new b(this));
                            y45Var.create(this.a.getPageContext()).show();
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                        } else if ((ae5Var == null || writeData == null || ae5Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && this.a.J1(postWriteCallBackData)) {
                            this.a.C2(false, postWriteCallBackData);
                        } else if (ae5Var != null && writeData != null && ae5Var.c() != null) {
                            if (writeData.isCanNoForum()) {
                                writeData.setForumName("");
                                writeData.setForumId("0");
                            }
                            writeData.setVcodeMD5(ae5Var.b());
                            writeData.setVcodeUrl(ae5Var.c());
                            writeData.setVcodeExtra(ae5Var.a());
                            if (VcodeTool.needVcode(ae5Var.d())) {
                                this.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, ae5Var.d())));
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

    /* loaded from: classes8.dex */
    public class a implements ti5 {
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

        @Override // com.baidu.tieba.ti5
        public void G(si5 si5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, si5Var) != null) || si5Var == null) {
                return;
            }
            this.a.k2(si5Var);
            int i = si5Var.a;
            if (i == 16) {
                if (!this.a.j2()) {
                    this.a.A2();
                } else {
                    this.a.showToast(R.string.over_limit_tip);
                }
            } else if (i == 3) {
                this.a.H1();
            } else if (i == 29) {
                this.a.S.D(new si5(2, 19, null));
                this.a.S.D(new si5(1, 2, null));
                this.a.q2();
                SpanGroupEditText spanGroupEditText = this.a.E;
                if (spanGroupEditText != null) {
                    spanGroupEditText.requestFocus();
                }
                this.a.S.t();
                this.a.S.D(new si5(5, -1, null));
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.ShowSoftKeyPad(absBaseWriteActivity.f1178T, absBaseWriteActivity.E);
            } else if (i == 55) {
                Object obj = si5Var.c;
                if (obj instanceof Boolean) {
                    this.a.m = ((Boolean) obj).booleanValue();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                        BdUtilHelper.hideSoftKeyPad(absBaseWriteActivity.getPageContext().getContext(), this.a.E);
                    }
                    EditorTools editorTools = this.a.S;
                    if (editorTools != null) {
                        editorTools.t();
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.S.D(new si5(5, -1, null));
                this.a.E.requestFocus();
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.ShowSoftKeyPadDelay(absBaseWriteActivity.E);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.m2();
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                this.c.q2();
                EditText O1 = this.c.O1();
                if (editable != null && O1 != null && O1.getText() != null) {
                    int selectionEnd = O1.getSelectionEnd();
                    String str = this.a;
                    if (str != null && str.equals(editable.toString())) {
                        O1.setSelection(selectionEnd);
                        return;
                    }
                    if (this.c.a != null) {
                        this.a = O1.getText().toString();
                        this.c.a.i(O1, false);
                    }
                    this.c.v1(editable);
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
                this.c.y1(charSequence, i, i2, i3);
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
                    this.c.S1(charSequence, i, i3, "from_content");
                    this.c.R1(charSequence, i, i3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.q2();
                this.a.x1(editable);
                this.a.F2();
                EditText P1 = this.a.P1();
                if (editable != null && P1 != null && P1.getText() != null) {
                    String str = this.a.s;
                    if (str != null && str.equals(editable.toString())) {
                        P1.setSelection(P1.getSelectionEnd());
                        return;
                    }
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.a != null) {
                        absBaseWriteActivity.s = P1.getText().toString();
                        this.a.a.i(P1, true);
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
                    this.a.S1(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            BdImage bdImage;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage<T> runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), BdImage.class);
                if (runTask != null) {
                    bdImage = (BdImage) runTask.getData();
                } else {
                    bdImage = null;
                }
                if (bdImage == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bdImage.getRawBitmap());
                int width = bdImage.getWidth();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, width, bdImage.getHeight());
                } else {
                    bitmapDrawable.setBounds(0, 0, width, width);
                }
                bitmapDrawable.setGravity(119);
                return new x95(bitmapDrawable, 0);
            }
            return (ImageSpan) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
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
        public void onNavigationButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y45Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes8.dex */
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.showToast((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.S.D(new si5(5, -1, null));
                int I1 = this.a.I1();
                if (I1 >= 0 && I1 < this.a.E.getText().length()) {
                    this.a.E.setSelection(I1);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                        absBaseWriteActivity2.D1();
                        EditorTools editorTools = this.a.S;
                        if (editorTools != null) {
                            editorTools.t();
                        }
                        BdUtilHelper.showSoftKeyPad(this.a.getActivity(), this.a.A);
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
                    absBaseWriteActivity4.D1();
                    EditorTools editorTools2 = this.a.S;
                    if (editorTools2 != null) {
                        editorTools2.t();
                    }
                    BdUtilHelper.showSoftKeyPad(this.a.getActivity(), this.a.E);
                }
                this.a.G2(view2, z);
                this.a.E2();
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                BdUtilHelper.hideSoftKeyPad(this.a.getActivity(), this.a.getCurrentFocus());
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
        this.a = new o3b();
        this.b = new KeyEvent(0, 67);
        this.c = new Handler();
        this.e = null;
        this.f = "write";
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
        this.G = new ArrayList<>();
        this.H = null;
        this.O = null;
        this.P = null;
        this.f1178T = null;
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

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.o = z;
            c0b c0bVar = this.U;
            if (c0bVar != null && !z) {
                c0bVar.h();
            }
            if (this.V != null && !z) {
                T1();
            }
        }
    }

    public void v2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void w2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, postWriteCallBackData) == null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
    }

    public void R1(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048599, this, charSequence, i2, i3) == null) && this.o && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            A2();
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            K1(atListActivityConfig);
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.S.setBarMaxLauCount(N1());
            this.S.setMoreButtonAtEnd(true);
            this.S.setBarLauncherType(1);
            this.S.F(true);
            this.S.G(B2());
            this.S.setBackgroundColorId(M1());
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.M = findViewById(R.id.obfuscated_res_0x7f091d42);
            this.J = (TextView) findViewById(R.id.obfuscated_res_0x7f091d41);
            this.F = findViewById(R.id.obfuscated_res_0x7f091d62);
            this.L = (ImageView) findViewById(R.id.obfuscated_res_0x7f091d63);
            c2();
        }
    }

    public final boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            kza kzaVar = this.K;
            if (kzaVar != null && kzaVar.isShowing()) {
                kg.d(this.K, getPageContext().getPageActivity());
                return true;
            } else if (this.S.x()) {
                this.S.t();
                return true;
            } else {
                return p2();
            }
        }
        return invokeV.booleanValue;
    }

    public void t1() {
        WriteData writeData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (writeData = this.p) != null && this.Q != null) {
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

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            EditorTools editorTools = this.S;
            if (editorTools != null) {
                editorTools.D(new si5(12, -1, new oj5(this.q, true)));
                this.S.D(new si5(12, 11, new oj5(this.q, true)));
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C2(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048581, this, z, postWriteCallBackData) == null) && postWriteCallBackData != null) {
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
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else if (!E1(postWriteCallBackData) && !BdToastHelper.canShowToast(postWriteCallBackData.getToast())) {
                yja.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void D1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (editorTools = this.S) != null) {
            editorTools.setBarLauncherEnabled(!this.l);
            this.S.setToolEnabled(true, 26);
        }
    }

    public void T1() {
        s3b s3bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (s3bVar = this.V) != null) {
            s3bVar.b();
        }
    }

    @CallSuper
    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            registerListener(this.b0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (blueCircleProgressDialog = this.P) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (O1().getText() != null && O1().getText().length() >= 5000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            T1();
            TiebaPrepareImageService.StopService();
            super.onDestroy();
            this.c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.M.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            HidenSoftKeyPad(this.f1178T, P1());
            HidenSoftKeyPad(this.f1178T, O1());
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    public void r2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (editorTools = this.S) != null) {
            editorTools.D(new si5(54, 15, null));
        }
    }

    public void t2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (editorTools = this.S) != null) {
            editorTools.D(new si5(9, -1, Boolean.TRUE));
        }
    }

    public boolean E1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData != null && postWriteCallBackData.getVideoEasterEggData() != null && !ei.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void o2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            WriteData writeData = this.p;
            if (writeData != null) {
                hotSelectActivityConfig.setForumExtra(JavaTypesHelper.toLong(writeData.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            B1(bundle);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.R = new GestureDetector(getPageContext().getPageActivity(), new o(this, null));
            this.f1178T = (InputMethodManager) getSystemService("input_method");
            U1(bundle);
            a2();
            z1();
            e2();
            w1();
            W1();
            d2();
            u2();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = O1().getEditableText().toString();
            if (obj != null) {
                O1().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.Y));
                O1().setSelection(O1().getText().length());
            }
        }
    }

    public void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

    public final void F2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (editText = this.A) != null && editText.getText() != null && this.A.getText().toString() != null && this.A.getPaint() != null) {
            if (this.A.getText().toString().length() == 0) {
                this.A.getPaint().setFakeBoldText(true);
            } else if (this.A.getText().toString().length() > 0) {
                this.A.getPaint().setFakeBoldText(true);
            }
        }
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int selectionEnd = O1().getSelectionEnd();
            ImageSpan[] imageSpanArr = (ImageSpan[]) O1().getText().getSpans(0, O1().getText().length(), ImageSpan.class);
            for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
                int spanStart = O1().getText().getSpanStart(imageSpanArr[i2]);
                int spanEnd = O1().getText().getSpanEnd(imageSpanArr[i2]);
                if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                    return spanEnd;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || !y2()) {
            return;
        }
        ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090d85);
        this.Q = forumTabSelectedView;
        forumTabSelectedView.setBgColor(R.color.CAM_X0205);
        L1(this.r, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e9));
        this.Q.setData(this.r);
        this.Q.setActivity(getPageContext());
        Y1();
    }

    public void c2() {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (postPrefixData = this.d) != null && postPrefixData.getPrefixs().size() > 1) {
            kza kzaVar = new kza(getPageContext().getPageActivity());
            this.K = kzaVar;
            kzaVar.e(this);
            this.K.d(BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f0703f4));
            this.K.setOutsideTouchable(true);
            this.K.setFocusable(true);
            this.K.setOnDismissListener(this);
            this.K.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
        }
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && O1().getSelectionStart() > 0) {
            String substring = O1().getText().toString().substring(0, O1().getSelectionStart());
            Matcher matcher = e47.b.matcher(substring);
            if (matcher.find()) {
                O1().getText().delete(O1().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), O1().getSelectionStart());
                return;
            }
            O1().onKeyDown(67, this.b);
        }
    }

    public void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.S = new EditorTools(getActivity());
            G1();
            this.S.f();
            LinearLayout linearLayout = this.B;
            if (linearLayout != null) {
                linearLayout.addView(this.S);
            }
            X1();
            this.S.j();
            aj5 o2 = this.S.o(6);
            if (o2 != null && !TextUtils.isEmpty(this.e)) {
                ((View) o2).setOnClickListener(new n(this));
            }
            this.S.D(new si5(34, 5, 1));
            this.S.t();
            if (!SharedPrefHelper.getInstance().getBoolean("hot_topic_has_click", false)) {
                this.S.D(new si5(2, 26, " "));
            }
        }
    }

    @Override // com.baidu.tieba.kza.a
    public void J0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.i = i2;
            this.K.c(i2);
            s2(i2);
            this.J.setText(this.d.getPrefixs().get(i2));
            q2();
            kg.d(this.K, getPageContext().getPageActivity());
        }
    }

    public void s2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048640, this, i2) != null) || i2 >= this.G.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            this.G.get(i3).b(false);
        }
        this.G.get(i2).b(true);
    }

    public final boolean L1(FrsTabInfoData frsTabInfoData, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, frsTabInfoData, str)) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048629, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                return l2();
            }
            if (i2 == 67 && (text = O1().getText()) != null && O1().getSelectionStart() - 1 > 0 && selectionStart < text.length() && text.charAt(selectionStart) == 0) {
                O1().onKeyDown(67, this.b);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void S1(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && z2() && this.o && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0) {
            this.n = false;
            this.g = "";
            if ("from_content".equals(str)) {
                this.g = "from_content";
            } else if ("from_title".equals(str)) {
                this.g = "from_title";
            }
            if (bx5.f(String.valueOf(charSequence.charAt(i2)))) {
                o2(false);
            }
        }
    }

    @CallSuper
    public void U1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
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

    @CallSuper
    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.P = new BlueCircleProgressDialog((TbPageContext<?>) getPageContext());
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0a59, (ViewGroup) null);
            this.v = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.w = navigationBar;
            navigationBar.showBottomLine();
            this.x = this.w.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.w.setCenterTextTitle("");
            this.z = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            x2();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f092ac1);
            this.O = scrollView;
            scrollView.setOnTouchListener(new b(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.H = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091a6f);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tool_view);
            this.B = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.C = (ConstraintLayout) findViewById(R.id.title_view);
            g2();
            f2();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091d37);
            this.D = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.D.setOnClickListener(new c(this));
            this.x.setOnFocusChangeListener(this.d0);
            this.x.setOnClickListener(new d(this));
            i2();
            D2();
            D1();
            b2();
            Z1();
            q2();
        }
    }

    public void h2(ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, ed5Var) == null) {
            if (((ImageSpan[]) O1().getText().getSpans(0, O1().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.I == null) {
                    this.I = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.I.getView().isShown()) {
                    this.I.cancel();
                }
                GreyUtil.grey(this.I);
                this.I.show();
                return;
            }
            f47.c(this, ed5Var, O1());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            super.onChangeSkinType(i2);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.H);
            this.w.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0105);
            this.y.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            D1();
            q2();
            this.S.z(i2);
            PostCategoryView postCategoryView = this.N;
            if (postCategoryView != null) {
                postCategoryView.a();
            }
            E2();
            F2();
            o3b o3bVar = this.a;
            if (o3bVar != null) {
                o3bVar.l(P1(), O1());
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            mva mvaVar = new mva(getPageContext().getPageActivity(), new e(this), new Date().getHours(), new Date().getMinutes(), false);
            this.f0 = mvaVar;
            mvaVar.setTitle(R.string.no_disturb_start_time);
            this.f0.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.f0);
            this.f0.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f03d0), this.f0);
            return this.f0;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
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

    public void n2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, postWriteCallBackData, writeData) == null) {
            t2();
            if (C1(writeData)) {
                C2(true, postWriteCallBackData);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048641, this, str, onCancelListener) != null) || (blueCircleProgressDialog = this.P) == null) {
            return;
        }
        blueCircleProgressDialog.setCancelListener(null);
        this.P.setTipString(R.string.obfuscated_res_0x7f0f1389);
        this.P.setDialogVisiable(true);
    }

    public void s1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048639, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.g)) {
            this.g = "";
            O1().requestFocus();
            if (O1().getText() != null && O1().getText().length() + str.length() > 5000) {
                showToast((int) R.string.over_limit_tip);
                return;
            } else {
                i2 = O1().getSelectionStart();
                editable = O1().getText();
            }
        } else if ("from_title".equals(this.g)) {
            this.g = "";
            P1().requestFocus();
            if (P1().getText() != null && P1().getText().length() + str.length() > 31) {
                showToast((int) R.string.over_limit_tip);
                return;
            } else {
                i2 = P1().getSelectionStart();
                editable = P1().getText();
            }
        }
        if (editable != null && i2 >= 0 && i2 <= editable.length()) {
            editable.insert(i2, str);
        }
    }
}
