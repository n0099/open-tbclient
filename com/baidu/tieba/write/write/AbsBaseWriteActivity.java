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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.ac6;
import com.baidu.tieba.au4;
import com.baidu.tieba.b39;
import com.baidu.tieba.b55;
import com.baidu.tieba.bx4;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.fx4;
import com.baidu.tieba.h19;
import com.baidu.tieba.ih;
import com.baidu.tieba.ii5;
import com.baidu.tieba.jx4;
import com.baidu.tieba.ky8;
import com.baidu.tieba.l15;
import com.baidu.tieba.on;
import com.baidu.tieba.p55;
import com.baidu.tieba.r05;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u45;
import com.baidu.tieba.ug5;
import com.baidu.tieba.v45;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.x29;
import com.baidu.tieba.xo8;
import com.baidu.tieba.y19;
import com.baidu.tieba.zb6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public abstract class AbsBaseWriteActivity<T> extends BaseActivity<T> implements h19.a, PopupWindow.OnDismissListener {
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
    public h19 K;
    public ImageView L;
    public View M;
    public PostCategoryView N;
    public ScrollView O;
    public fx4 P;
    public ForumTabSelectedView Q;
    public GestureDetector R;
    public EditorTools S;
    public InputMethodManager T;
    public y19 U;
    public b39 V;
    public TextWatcher W;
    public TextWatcher X;
    public TbFaceManager.a Y;
    public final AntiHelper.k Z;
    public final x29 a;
    public final NewWriteModel.d a0;
    public final KeyEvent b;
    public final CustomMessageListener b0;
    public final Handler c;
    public final View.OnClickListener c0;
    public PostPrefixData d;
    public final View.OnFocusChangeListener d0;
    public String e;
    public final v45 e0;
    public String f;
    public ky8 f0;
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

    /* loaded from: classes6.dex */
    public class a implements v45 {
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

        @Override // com.baidu.tieba.v45
        public void B(u45 u45Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, u45Var) == null) || u45Var == null) {
                return;
            }
            this.a.p2(u45Var);
            int i = u45Var.a;
            if (i == 16) {
                if (!this.a.o2()) {
                    this.a.F2();
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0d37);
                }
            } else if (i == 3) {
                this.a.P1();
            } else if (i != 29) {
                if (i == 55) {
                    Object obj = u45Var.c;
                    if (obj instanceof Boolean) {
                        this.a.m = ((Boolean) obj).booleanValue();
                    }
                }
            } else {
                this.a.S.A(new u45(2, 19, null));
                this.a.S.A(new u45(1, 2, null));
                this.a.v2();
                SpanGroupEditText spanGroupEditText = this.a.E;
                if (spanGroupEditText != null) {
                    spanGroupEditText.requestFocus();
                }
                this.a.S.q();
                this.a.S.A(new u45(5, -1, null));
                AbsBaseWriteActivity absBaseWriteActivity = this.a;
                absBaseWriteActivity.ShowSoftKeyPad(absBaseWriteActivity.T, absBaseWriteActivity.E);
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
                        ej.x(absBaseWriteActivity.getPageContext().getContext(), this.a.E);
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
                this.a.S.A(new u45(5, -1, null));
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

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, timePicker, i, i2) == null) {
            }
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
                if (editable == null || V1 == null || V1.getText() == null) {
                    return;
                }
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
                this.c.E1(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.b = charSequence != null ? charSequence.toString() : "";
                this.c.H1(charSequence, i, i2, i3);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.b;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.toString().length() : 0)) {
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
                this.a.G1(editable);
                this.a.K2();
                EditText W1 = this.a.W1();
                if (editable == null || W1 == null || W1.getText() == null) {
                    return;
                }
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

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.t = charSequence != null ? charSequence.toString() : "";
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.a.t;
                if ((charSequence != null ? charSequence.toString().length() : 0) > (str != null ? str.length() : 0)) {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                CustomResponsedMessage<T> runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), on.class);
                on onVar = runTask != null ? (on) runTask.getData() : null;
                if (onVar == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(onVar.p());
                int r = onVar.r();
                if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    bitmapDrawable.setBounds(0, 0, r, onVar.m());
                } else {
                    bitmapDrawable.setBounds(0, 0, r, r);
                }
                bitmapDrawable.setGravity(119);
                return new jx4(bitmapDrawable, 0);
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
        public void onNavigationButtonClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_WRITE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsBaseWriteActivity a;

        /* loaded from: classes6.dex */
        public class a implements au4.e {
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

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements au4.e {
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

            @Override // com.baidu.tieba.au4.e
            public void onClick(au4 au4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                    au4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l15 l15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l15Var, writeData, antiData}) == null) {
                this.a.J1();
                this.a.closeLoadingDialog();
                if (postWriteCallBackData != null) {
                    AbsBaseWriteActivity absBaseWriteActivity = this.a;
                    if (absBaseWriteActivity.p == null) {
                        return;
                    }
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
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                        }
                    } else if (postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        au4 au4Var = new au4(this.a.getActivity());
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            au4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                        } else {
                            au4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new a(this));
                        au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new b(this));
                        au4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 1));
                    } else if ((l15Var == null || writeData == null || l15Var.c() == null || AntiHelper.h(antiData)) && postWriteCallBackData.getErrorCode() != 227001 && this.a.R1(postWriteCallBackData)) {
                        this.a.H2(false, postWriteCallBackData);
                    } else if (l15Var != null && writeData != null && l15Var.c() != null) {
                        if (writeData.isCanNoForum()) {
                            writeData.setForumName("");
                            writeData.setForumId("0");
                        }
                        writeData.setVcodeMD5(l15Var.b());
                        writeData.setVcodeUrl(l15Var.c());
                        writeData.setVcodeExtra(l15Var.a());
                        if (ii5.b(l15Var.d())) {
                            this.a.sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getPageContext().getPageActivity(), 12006, writeData, false, l15Var.d())));
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
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
                this.a.S.A(new u45(5, -1, null));
                int Q1 = this.a.Q1();
                if (Q1 < 0 || Q1 >= this.a.E.getText().length()) {
                    return;
                }
                this.a.E.setSelection(Q1);
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
                        absBaseWriteActivity2.M1();
                        EditorTools editorTools = this.a.S;
                        if (editorTools != null) {
                            editorTools.q();
                        }
                        ej.L(this.a.getActivity(), this.a.A);
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
                    absBaseWriteActivity4.M1();
                    EditorTools editorTools2 = this.a.S;
                    if (editorTools2 != null) {
                        editorTools2.q();
                    }
                    ej.L(this.a.getActivity(), this.a.E);
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

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                ej.x(this.a.getActivity(), this.a.getCurrentFocus());
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ o(AbsBaseWriteActivity absBaseWriteActivity, f fVar) {
            this(absBaseWriteActivity);
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
        this.a = new x29();
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
        this.G = new ArrayList<>();
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

    public void A2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void B2(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postWriteCallBackData) == null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
    }

    public void C1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        int i2 = -1;
        Editable editable = null;
        if ("from_content".equals(this.g)) {
            this.g = "";
            V1().requestFocus();
            if (V1().getText() != null && V1().getText().length() + str.length() > 5000) {
                showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                return;
            } else {
                i2 = V1().getSelectionStart();
                editable = V1().getText();
            }
        } else if ("from_title".equals(this.g)) {
            this.g = "";
            W1().requestFocus();
            if (W1().getText() != null && W1().getText().length() + str.length() > 31) {
                showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                return;
            } else {
                i2 = W1().getSelectionStart();
                editable = W1().getText();
            }
        }
        if (editable == null || i2 < 0 || i2 > editable.length()) {
            return;
        }
        editable.insert(i2, str);
    }

    public void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void D1() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (writeData = this.p) == null || this.Q == null) {
            return;
        }
        FrsTabInfoData frsTabInfoData = this.r;
        writeData.setIsForumBusinessAccount(frsTabInfoData != null && frsTabInfoData.isForumBusinessAccount);
        FrsTabItemData selectedTabItemData = this.Q.getSelectedTabItemData();
        if (selectedTabItemData == null) {
            return;
        }
        this.p.setTabId(selectedTabItemData.tabId);
        this.p.setTabName(selectedTabItemData.name);
        this.p.setIsGeneralTab(selectedTabItemData.isGeneralTab);
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editable) == null) {
        }
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AtListActivityConfig atListActivityConfig = new AtListActivityConfig(getPageContext().getPageActivity(), 12004, true);
            S1(atListActivityConfig);
            sendMessage(new CustomMessage(2002001, atListActivityConfig));
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public void G1(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editable) == null) {
        }
    }

    public abstract boolean G2();

    public void H1(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048588, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public void H2(boolean z, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, postWriteCallBackData) == null) || postWriteCallBackData == null) {
            return;
        }
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
                errorString = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1064);
            }
            showToast(errorString);
        } else if (N1(postWriteCallBackData)) {
        } else {
            xo8.b(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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

    public void K1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
        }
    }

    public final void K2() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (editText = this.A) == null || editText.getText() == null || this.A.getText().toString() == null || this.A.getPaint() == null) {
            return;
        }
        if (this.A.getText().toString().length() == 0) {
            this.A.getPaint().setFakeBoldText(true);
        } else if (this.A.getText().toString().length() > 0) {
            this.A.getPaint().setFakeBoldText(true);
        }
    }

    public boolean L1(WriteData writeData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, writeData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L2(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, view2, z) == null) {
        }
    }

    public void M1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.setBarLauncherEnabled(!this.l);
        this.S.setToolEnabled(true, 26);
    }

    public boolean N1(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || dj.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_frs", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void O1() {
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

    public void P1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || V1().getSelectionStart() <= 0) {
            return;
        }
        String substring = V1().getText().toString().substring(0, V1().getSelectionStart());
        Matcher matcher = zb6.b.matcher(substring);
        if (matcher.find()) {
            V1().getText().delete(V1().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), V1().getSelectionStart());
            return;
        }
        V1().onKeyDown(67, this.b);
    }

    public int Q1() {
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

    public boolean R1(@NonNull PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, postWriteCallBackData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public void S1(AtListActivityConfig atListActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, atListActivityConfig) == null) {
        }
    }

    @Override // com.baidu.tieba.h19.a
    public void T0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.i = i2;
            this.K.c(i2);
            x2(i2);
            this.J.setText(this.d.getPrefixs().get(i2));
            v2();
            ih.d(this.K, getPageContext().getPageActivity());
        }
    }

    public abstract int T1();

    public abstract int U1();

    public abstract EditText V1();

    public abstract EditText W1();

    public void X1(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048610, this, charSequence, i2, i3) == null) && this.o && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && charSequence.charAt(i2) == '@') {
            F2();
        }
    }

    public void Y1(CharSequence charSequence, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) && E2() && this.o && charSequence != null && i3 == 1 && i2 < charSequence.length() && i2 >= 0) {
            this.n = false;
            this.g = "";
            if ("from_content".equals(str)) {
                this.g = "from_content";
            } else if ("from_title".equals(str)) {
                this.g = "from_title";
            }
            if (ug5.f(String.valueOf(charSequence.charAt(i2)))) {
                t2(false);
            }
        }
    }

    public void Z1() {
        b39 b39Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (b39Var = this.V) == null) {
            return;
        }
        b39Var.b();
    }

    @CallSuper
    public void a2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
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
                String string = bundle.getString("prefix_data");
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
                this.d = (PostPrefixData) intent.getSerializableExtra("prefix_data");
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

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.S = new EditorTools(getActivity());
            O1();
            this.S.f();
            LinearLayout linearLayout = this.B;
            if (linearLayout != null) {
                linearLayout.addView(this.S);
            }
            c2();
            this.S.j();
            b55 m2 = this.S.m(6);
            if (m2 != null && !TextUtils.isEmpty(this.e)) {
                ((View) m2).setOnClickListener(new n(this));
            }
            this.S.A(new u45(34, 5, 1));
            this.S.q();
            if (bx4.k().h("hot_topic_has_click", false)) {
                return;
            }
            this.S.A(new u45(2, 26, " "));
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (fx4Var = this.P) == null) {
            return;
        }
        fx4Var.h(false);
    }

    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) {
            if (this.R.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && D2()) {
            ForumTabSelectedView forumTabSelectedView = (ForumTabSelectedView) findViewById(R.id.obfuscated_res_0x7f090c0a);
            this.Q = forumTabSelectedView;
            forumTabSelectedView.setBgColor(R.color.CAM_X0205);
            this.Q.setData(this.r);
            this.Q.setActivity(getPageContext());
            d2();
        }
    }

    @CallSuper
    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            registerListener(this.b0);
        }
    }

    public void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.M = findViewById(R.id.obfuscated_res_0x7f091a48);
            this.J = (TextView) findViewById(R.id.obfuscated_res_0x7f091a47);
            this.F = findViewById(R.id.obfuscated_res_0x7f091a67);
            this.L = (ImageView) findViewById(R.id.obfuscated_res_0x7f091a68);
            h2();
        }
    }

    public void h2() {
        PostPrefixData postPrefixData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (postPrefixData = this.d) == null || postPrefixData.getPrefixs().size() <= 1) {
            return;
        }
        h19 h19Var = new h19(getPageContext().getPageActivity());
        this.K = h19Var;
        h19Var.e(this);
        this.K.d(ej.f(getActivity(), R.dimen.obfuscated_res_0x7f0702d6));
        this.K.setOutsideTouchable(true);
        this.K.setFocusable(true);
        this.K.setOnDismissListener(this);
        this.K.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
    }

    public abstract void i2();

    @CallSuper
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.P = new fx4((TbPageContext<?>) getPageContext());
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d0937, (ViewGroup) null);
            this.v = inflate;
            setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925c2);
            this.w = navigationBar;
            navigationBar.showBottomLine();
            this.x = this.w.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            TextView centerTextTitle = this.w.setCenterTextTitle("");
            this.z = centerTextTitle;
            SkinManager.setViewTextColor(centerTextTitle, (int) R.color.CAM_X0105);
            C2();
            ScrollView scrollView = (ScrollView) findViewById(R.id.obfuscated_res_0x7f0926be);
            this.O = scrollView;
            scrollView.setOnTouchListener(new b(this));
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.H = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091792);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092283);
            this.B = linearLayout;
            linearLayout.setContentDescription(IStringUtil.TOP_PATH);
            this.C = (ConstraintLayout) findViewById(R.id.obfuscated_res_0x7f092248);
            l2();
            k2();
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091a3d);
            this.D = linearLayout2;
            linearLayout2.setDrawingCacheEnabled(false);
            this.D.setOnClickListener(new c(this));
            this.x.setOnFocusChangeListener(this.d0);
            this.x.setOnClickListener(new d(this));
            n2();
            I2();
            M1();
            g2();
            e2();
            v2();
        }
    }

    public abstract void k2();

    public abstract void l2();

    public void m2(r05 r05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, r05Var) == null) {
            if (((ImageSpan[]) V1().getText().getSpans(0, V1().getText().length(), ImageSpan.class)).length >= 10) {
                if (this.I == null) {
                    this.I = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.obfuscated_res_0x7f0f1456, 0);
                }
                if (Build.VERSION.SDK_INT >= 28 && this.I.getView().isShown()) {
                    this.I.cancel();
                }
                this.I.show();
                return;
            }
            ac6.b(this, r05Var, V1());
        }
    }

    public abstract void n2();

    public boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? V1().getText() != null && V1().getText().length() >= 5000 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().l(i2 == 1);
            getLayoutMode().k(this.H);
            this.w.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.z, (int) R.color.CAM_X0105);
            this.y.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, i2));
            M1();
            v2();
            this.S.w(i2);
            PostCategoryView postCategoryView = this.N;
            if (postCategoryView != null) {
                postCategoryView.a();
            }
            J2();
            K2();
            x29 x29Var = this.a;
            if (x29Var != null) {
                x29Var.l(W1(), V1());
            }
            ForumTabSelectedView forumTabSelectedView = this.Q;
            if (forumTabSelectedView != null) {
                forumTabSelectedView.o(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            K1(bundle);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            this.R = new GestureDetector(getPageContext().getPageActivity(), new o(this, null));
            this.T = (InputMethodManager) getSystemService("input_method");
            a2(bundle);
            f2();
            I1();
            j2();
            F1();
            b2();
            i2();
            z2();
        }
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            ky8 ky8Var = new ky8(getPageContext().getPageActivity(), new e(this), new Date().getHours(), new Date().getMinutes(), false);
            this.f0 = ky8Var;
            ky8Var.setTitle(R.string.obfuscated_res_0x7f0f0c77);
            this.f0.setButton(-1, getPageContext().getString(R.string.obfuscated_res_0x7f0f026a), this.f0);
            this.f0.setButton(-2, getPageContext().getString(R.string.obfuscated_res_0x7f0f0375), this.f0);
            return this.f0;
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            Z1();
            TiebaPrepareImageService.StopService();
            super.onDestroy();
            this.c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.M.setSelected(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Editable text;
        int selectionStart;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048635, this, i2, keyEvent)) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.o = z;
            y19 y19Var = this.U;
            if (y19Var != null && !z) {
                y19Var.g();
            }
            if (this.V == null || z) {
                return;
            }
            Z1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            HidenSoftKeyPad(this.T, W1());
            HidenSoftKeyPad(this.T, V1());
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048638, this, i2, dialog) == null) {
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            String obj = V1().getEditableText().toString();
            if (obj != null) {
                V1().setText(TbFaceManager.i().t(getPageContext().getPageActivity(), obj, this.Y));
                V1().setSelection(V1().getText().length());
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, bundle) == null) {
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
                bundle.putString("prefix_data", OrmObject.jsonStrWithObject(postPrefixData));
            }
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            super.onStop();
            getWindow().setSoftInputMode(18);
        }
    }

    public void p2(@NonNull u45 u45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, u45Var) == null) {
        }
    }

    public final boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            h19 h19Var = this.K;
            if (h19Var != null && h19Var.isShowing()) {
                ih.d(this.K, getPageContext().getPageActivity());
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

    public void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
        }
    }

    public void s2(PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, postWriteCallBackData, writeData) == null) {
            y2();
            if (L1(writeData)) {
                H2(true, postWriteCallBackData);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048646, this, str, onCancelListener) == null) || (fx4Var = this.P) == null) {
            return;
        }
        fx4Var.e(null);
        this.P.i(R.string.obfuscated_res_0x7f0f1133);
        this.P.h(true);
    }

    public void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            WriteData writeData = this.p;
            if (writeData != null) {
                hotSelectActivityConfig.setForumExtra(dh.g(writeData.getForumId(), 0L), this.p.getFirstDir(), this.p.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public abstract void v2();

    public void w2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new u45(54, 15, null));
    }

    public void x2(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048651, this, i2) == null) || i2 >= this.G.size()) {
            return;
        }
        for (int i3 = 0; i3 < this.G.size(); i3++) {
            this.G.get(i3).b(false);
        }
        this.G.get(i2).b(true);
    }

    public void y2() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048652, this) == null) || (editorTools = this.S) == null) {
            return;
        }
        editorTools.A(new u45(9, -1, Boolean.TRUE));
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            EditorTools editorTools = this.S;
            if (editorTools != null) {
                editorTools.A(new u45(12, -1, new p55(this.q, true)));
                this.S.A(new u45(12, 11, new p55(this.q, true)));
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
