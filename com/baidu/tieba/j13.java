package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.publisher.ReplyEditorParams;
import com.baidu.swan.apps.publisher.emoji.EmojiEditText;
import com.baidu.swan.apps.publisher.view.SPSwitchPanelLinearLayout;
import com.baidu.swan.apps.res.ui.BdBaseImageView;
import com.baidu.tieba.a23;
import com.baidu.tieba.d23;
import com.baidu.tieba.i33;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j13 extends wh4 implements View.OnClickListener, zr2<MediaModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SPSwitchPanelLinearLayout A0;
    public View B0;
    public boolean C0;
    public ImageView D0;
    public boolean E0;
    public boolean F0;
    public ReplyEditorParams G0;
    public boolean H0;
    public g13 I0;
    public String J0;
    public MediaModel K0;
    public LinearLayout q0;
    public Context r0;
    public EmojiEditText s0;
    public LinearLayout t0;
    public TextView u0;
    public TextView v0;
    public FrameLayout w0;
    public SimpleDraweeView x0;
    public BdBaseImageView y0;
    public ImageView z0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947830397, "Lcom/baidu/tieba/j13;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947830397, "Lcom/baidu/tieba/j13;");
        }
    }

    @Override // com.baidu.tieba.zr2
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements d23.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ j13 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.q0.setVisibility(0);
                }
            }
        }

        public g(j13 j13Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j13Var;
            this.a = viewGroup;
        }

        @Override // com.baidu.tieba.d23.b
        public void onSoftInputShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.b.F0 = z;
                if (z) {
                    this.b.D0.setImageResource(R.drawable.obfuscated_res_0x7f08121a);
                    this.a.post(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        public a(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.n1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        public b(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (keyEvent.getAction() == 0 && i == 4) {
                    this.a.F1();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        public c(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.F1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public d(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.O1(editable);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public e(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.F1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public f(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.F1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a23.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        public h(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // com.baidu.tieba.a23.c
        public void onClickSwitch(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.E0 = z;
                if (z) {
                    this.a.D0.setImageResource(R.drawable.obfuscated_res_0x7f08121c);
                } else {
                    this.a.D0.setImageResource(R.drawable.obfuscated_res_0x7f08121a);
                }
                c23.onEvent("emoji_clk");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        public i(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j13 a;

        public j(j13 j13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j13Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((InputMethodManager) this.a.s0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.s0.getWindowToken(), 0);
            }
        }
    }

    public j13() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.C0 = false;
        this.E0 = false;
        this.F0 = false;
        this.H0 = false;
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int childCount = this.t0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.t0.getChildAt(i2);
                if (!(childAt instanceof EmojiEditText)) {
                    this.t0.removeView(childAt);
                }
            }
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s0.setText("");
            F1();
        }
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrameLayout frameLayout = this.w0;
            if (frameLayout == null || frameLayout.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void J1() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (frameLayout = this.w0) != null) {
            this.K0 = null;
            frameLayout.setVisibility(8);
            A1(false);
        }
    }

    @Override // com.baidu.tieba.wh4
    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = this.q0;
            if (linearLayout != null) {
                linearLayout.setOnKeyListener(null);
            }
            super.n1();
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            if (!this.E0 || this.F0) {
                d23.n(this.s0, 160L);
                LinearLayout linearLayout = this.q0;
                if (linearLayout != null) {
                    linearLayout.postDelayed(new i(this), 280L);
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            if (this.H0) {
                Q1();
                return;
            }
            N1();
            E1();
            K1();
            D1();
            c23.onEvent("show");
        }
    }

    public void P1(g13 g13Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, g13Var) == null) {
            this.I0 = g13Var;
        }
    }

    @Override // com.baidu.tieba.zr2
    public void g(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, list) == null) && list != null && list.size() != 0) {
            MediaModel mediaModel = list.get(0);
            this.K0 = mediaModel;
            R1(mediaModel);
        }
    }

    @Override // com.baidu.tieba.wh4
    public Dialog r1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bundle)) == null) {
            Dialog r1 = super.r1(bundle);
            r1.getWindow().requestFeature(1);
            return r1;
        }
        return (Dialog) invokeL.objValue;
    }

    public final void A1(boolean z) {
        EmojiEditText emojiEditText;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (emojiEditText = this.s0) == null) {
            return;
        }
        if (z) {
            emojiEditText.setPadding(vh3.g(8.0f), this.s0.getPaddingTop(), 0, this.s0.getPaddingBottom());
        } else {
            emojiEditText.setPadding(vh3.g(8.0f), this.s0.getPaddingTop(), vh3.g(8.0f), this.s0.getPaddingBottom());
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.J0 != null) {
                SpannableString g2 = r13.c().g(this.r0, this.J0, this.s0);
                this.s0.setText(g2);
                this.s0.setSelection(g2.length());
                O1(g2);
            }
            if (this.K0 != null) {
                A1(true);
                R1(this.K0);
                return;
            }
            A1(false);
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.J0) && this.K0 == null) {
                k13.c().a();
            } else {
                k13.c().d(this.J0, this.K0);
            }
            H1(MediaTrackConfig.AE_IMPORT_DRAFT);
            n1();
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i33.a aVar = new i33.a(getContext());
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f1373);
            aVar.v(R.string.obfuscated_res_0x7f0f1377);
            aVar.O(R.string.obfuscated_res_0x7f0f011d, new a(this));
            aVar.X();
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.s0.setHint(this.G0.contentHint);
            this.v0.setText(this.G0.sendText);
            this.v0.setTextColor(this.G0.sendTextColor);
            this.v0.setBackground(G1(this.G0.sendTextBgColor));
            if (this.G0.supportNoModule()) {
                this.q0.findViewById(R.id.obfuscated_res_0x7f0915e2).setVisibility(8);
            }
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p1().setCanceledOnTouchOutside(true);
            Window window = p1().getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.width = -1;
                attributes.height = -1;
                attributes.softInputMode = 16;
                attributes.dimAmount = 0.0f;
                window.setAttributes(attributes);
            }
        }
    }

    public final StateListDrawable G1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            float g2 = vh3.g(4.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(g2);
            gradientDrawable.setColor(i2);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(g2);
            gradientDrawable2.setColor((i2 & 16777215) + 855638016);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
            stateListDrawable.addState(new int[]{16842910}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeI.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        yo1 C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            if (view2 == this.v0) {
                H1("reply");
                c23.onEvent("pub_clk");
            } else if (view2 == this.y0) {
                J1();
                O1(this.s0.getText());
                c23.onEvent("pic_clk_del");
            } else if (view2 == this.z0) {
                f23.j(1, true, this);
                c23.onEvent("pic_clk_bar");
            } else if (view2 == this.x0 && (C = ln2.C()) != null) {
                C.d(getContext(), new String[]{this.K0.getPath()}, 0);
            }
        }
    }

    @Override // com.baidu.tieba.wh4, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dialogInterface) == null) {
            EmojiEditText emojiEditText = this.s0;
            if (emojiEditText != null) {
                editable = emojiEditText.getText();
            } else {
                editable = null;
            }
            if (this.C0 || editable == null || TextUtils.isEmpty(editable.toString())) {
                if (!this.C0 && this.s0 != null && I1()) {
                    return;
                }
                EmojiEditText emojiEditText2 = this.s0;
                if (emojiEditText2 != null) {
                    emojiEditText2.postDelayed(new j(this), 400L);
                }
                super.onDismiss(dialogInterface);
            }
        }
    }

    @Override // com.baidu.tieba.wh4, com.baidu.swan.support.v4.app.Fragment
    public void u0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.u0(bundle);
            this.r0 = getActivity();
            Bundle p = p();
            if (p != null) {
                this.G0 = (ReplyEditorParams) p.getParcelable("params");
                if (p.getBoolean(MediaTrackConfig.AE_IMPORT_DRAFT)) {
                    this.J0 = p.getString("content");
                    this.K0 = (MediaModel) p.getParcelable("image");
                }
                if (this.G0 == null) {
                    this.H0 = true;
                    return;
                }
                return;
            }
            this.H0 = true;
        }
    }

    public final void H1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || this.I0 == null) {
            return;
        }
        if (!SwanAppNetworkUtils.i(getContext())) {
            f23.h(getContext(), R.string.obfuscated_res_0x7f0f1376);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.G0.supportPicture()) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.K0 != null) {
                    jSONObject2.put("path", rp2.U().G().h(this.K0.getTempPath()));
                    jSONObject2.put("size", this.K0.getSize());
                }
                jSONObject.put("tempFile", jSONObject2);
            }
            if (this.J0 == null) {
                this.J0 = "";
            }
            jSONObject.put("content", this.J0);
            jSONObject.put("status", str);
            this.I0.a(jSONObject);
            this.C0 = true;
            if (TextUtils.equals("reply", str)) {
                J1();
                k13.c().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void K1() {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (window = p1().getWindow()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290);
        d23.c(getActivity(), viewGroup, this.A0, new g(this, viewGroup));
        a23.b(this.A0, this.D0, this.s0, new h(this));
        t13.b().c(getActivity(), this.A0, this.s0, this.G0.emojiPath, e43.g0(), e43.M().k0());
        this.q0.setVisibility(4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            B1();
            this.w0 = new FrameLayout(this.r0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(vh3.g(60.0f), vh3.g(60.0f));
            layoutParams.topMargin = vh3.g(8.0f);
            layoutParams.bottomMargin = vh3.g(8.0f);
            layoutParams.leftMargin = vh3.g(19.0f);
            layoutParams.rightMargin = vh3.g(9.0f);
            this.t0.addView(this.w0, layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.r0);
            frameLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f08121e);
            frameLayout.setPadding(1, 1, 1, 1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.r0);
            this.x0 = simpleDraweeView;
            simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
            frameLayout.addView(this.x0, layoutParams2);
            this.w0.addView(frameLayout, layoutParams2);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setBorderColor(LaunchTaskConstants.OTHER_PROCESS);
            roundingParams.setBorderWidth(1.0f);
            roundingParams.setCornersRadius(vh3.g(3.0f));
            roundingParams.setOverlayColor(-1);
            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.r0.getResources()).build();
            build.setRoundingParams(roundingParams);
            this.x0.setHierarchy(build);
            this.y0 = new BdBaseImageView(this.r0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(vh3.g(20.0f), vh3.g(20.0f));
            layoutParams3.gravity = 8388613;
            this.w0.addView(this.y0, layoutParams3);
            this.y0.setImageResource(R.drawable.obfuscated_res_0x7f08121f);
            this.x0.setOnClickListener(this);
            this.y0.setOnTouchListener(new uh3());
            this.y0.setOnClickListener(this);
        }
    }

    public final void M1(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            this.t0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090fbb);
            this.s0 = (EmojiEditText) view2.findViewById(R.id.obfuscated_res_0x7f09070d);
            this.u0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091377);
            this.v0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f1c);
            this.z0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fbd);
            this.D0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908c6);
            this.A0 = (SPSwitchPanelLinearLayout) view2.findViewById(R.id.panel_root);
            this.B0 = view2.findViewById(R.id.obfuscated_res_0x7f091a9d);
        }
    }

    public final void R1(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaModel) == null) {
            String tempPath = mediaModel.getTempPath();
            if (TextUtils.isEmpty(tempPath)) {
                FrameLayout frameLayout = this.w0;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.w0;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            this.x0.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setOldController(this.x0.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(ch3.m(tempPath)).setResizeOptions(new ResizeOptions(vh3.o(this.r0), vh3.n(this.r0))).build()).build());
            String str = this.J0;
            if (str == null) {
                str = "";
            }
            O1(str);
        }
    }

    public final void O1(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, charSequence) == null) {
            this.J0 = charSequence.toString();
            int a2 = e23.a(charSequence.toString());
            if (a2 < 0) {
                return;
            }
            if (a2 == 0) {
                if (I1()) {
                    this.v0.setEnabled(true);
                    this.u0.setVisibility(8);
                    return;
                }
                this.v0.setEnabled(false);
                this.u0.setVisibility(8);
            } else if (a2 <= 200) {
                this.v0.setEnabled(true);
                if (a2 < 180) {
                    this.u0.setVisibility(8);
                    return;
                }
                this.u0.setVisibility(0);
                this.u0.setText(String.format(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f1383), Integer.valueOf(200 - a2)));
                this.u0.setTextColor(ContextCompat.getColor(this.r0, R.color.obfuscated_res_0x7f060ac5));
            } else {
                this.v0.setEnabled(false);
                this.u0.setVisibility(0);
                this.u0.setTextColor(ContextCompat.getColor(this.r0, R.color.obfuscated_res_0x7f060ac6));
                if (a2 < 1200) {
                    this.u0.setText(String.format(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f1382), Integer.valueOf(a2 - 200)));
                } else {
                    this.u0.setText(this.r0.getResources().getString(R.string.obfuscated_res_0x7f0f1381));
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View x0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d085f, viewGroup, false);
            this.q0 = linearLayout;
            M1(linearLayout);
            this.q0.setFocusableInTouchMode(true);
            this.q0.setOnKeyListener(new b(this));
            this.v0.setOnClickListener(this);
            if (this.G0.supportPicture()) {
                this.z0.setVisibility(0);
                this.z0.setOnClickListener(this);
                this.z0.setOnTouchListener(new uh3());
            } else {
                this.z0.setVisibility(8);
            }
            if (this.G0.supportEmoji()) {
                this.D0.setVisibility(0);
                this.D0.setOnTouchListener(new uh3());
            } else {
                this.D0.setVisibility(8);
            }
            this.B0.setOnTouchListener(new c(this));
            this.s0.addTextChangedListener(new d(this));
            this.s0.setListener(new e(this));
            this.s0.setListener(new f(this));
            L1();
            if (this.K0 == null) {
                J1();
            }
            this.s0.requestFocus();
            return this.q0;
        }
        return (View) invokeLLL.objValue;
    }
}
