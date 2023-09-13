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
import com.baidu.tieba.d93;
import com.baidu.tieba.g93;
import com.baidu.tieba.la3;
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
/* loaded from: classes7.dex */
public class m83 extends zo4 implements View.OnClickListener, cz2<MediaModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A0;
    public SPSwitchPanelLinearLayout B0;
    public View C0;
    public boolean D0;
    public ImageView E0;
    public boolean F0;
    public boolean G0;
    public ReplyEditorParams H0;
    public boolean I0;
    public j83 J0;
    public String K0;
    public MediaModel L0;
    public LinearLayout r0;
    public Context s0;
    public EmojiEditText t0;
    public LinearLayout u0;
    public TextView v0;
    public TextView w0;
    public FrameLayout x0;
    public SimpleDraweeView y0;
    public BdBaseImageView z0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947926497, "Lcom/baidu/tieba/m83;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947926497, "Lcom/baidu/tieba/m83;");
        }
    }

    @Override // com.baidu.tieba.cz2
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class g implements g93.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ m83 b;

        /* loaded from: classes7.dex */
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
                    this.a.b.r0.setVisibility(0);
                }
            }
        }

        public g(m83 m83Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m83Var;
            this.a = viewGroup;
        }

        @Override // com.baidu.tieba.g93.b
        public void onSoftInputShowing(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.b.G0 = z;
            if (z) {
                this.b.E0.setImageResource(R.drawable.obfuscated_res_0x7f0814a2);
                this.a.post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

        public a(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                this.a.n1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

        public b(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (keyEvent.getAction() == 0 && i == 4) {
                    this.a.G1();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

        public c(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.G1();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

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

        public d(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.P1(editable);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

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

        public e(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.G1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements EmojiEditText.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

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

        public f(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // com.baidu.swan.apps.publisher.emoji.EmojiEditText.e
        public void onBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.G1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements d93.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

        public h(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // com.baidu.tieba.d93.c
        public void onClickSwitch(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, view2, z) != null) {
                return;
            }
            this.a.F0 = z;
            if (z) {
                this.a.E0.setImageResource(R.drawable.obfuscated_res_0x7f0814a4);
            } else {
                this.a.E0.setImageResource(R.drawable.obfuscated_res_0x7f0814a2);
            }
            f93.onEvent("emoji_clk");
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

        public i(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m83 a;

        public j(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m83Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((InputMethodManager) this.a.t0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.t0.getWindowToken(), 0);
            }
        }
    }

    public m83() {
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
        this.D0 = false;
        this.F0 = false;
        this.G0 = false;
        this.I0 = false;
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int childCount = this.u0.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.u0.getChildAt(i2);
                if (!(childAt instanceof EmojiEditText)) {
                    this.u0.removeView(childAt);
                }
            }
        }
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.t0.setText("");
            G1();
        }
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            FrameLayout frameLayout = this.x0;
            if (frameLayout == null || frameLayout.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void K1() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (frameLayout = this.x0) != null) {
            this.L0 = null;
            frameLayout.setVisibility(8);
            B1(false);
        }
    }

    @Override // com.baidu.tieba.zo4
    public void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = this.r0;
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
            if (!this.F0 || this.G0) {
                g93.n(this.t0, 160L);
                LinearLayout linearLayout = this.r0;
                if (linearLayout != null) {
                    linearLayout.postDelayed(new i(this), 280L);
                }
            }
        }
    }

    public void R1(j83 j83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, j83Var) == null) {
            this.J0 = j83Var;
        }
    }

    @Override // com.baidu.tieba.cz2
    public void f(List<MediaModel> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, list) == null) && list != null && list.size() != 0) {
            MediaModel mediaModel = list.get(0);
            this.L0 = mediaModel;
            T1(mediaModel);
        }
    }

    @Override // com.baidu.tieba.zo4
    public Dialog s1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bundle)) == null) {
            Dialog s1 = super.s1(bundle);
            s1.getWindow().requestFeature(1);
            return s1;
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void N0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, view2, bundle) == null) {
            super.N0(view2, bundle);
            if (this.I0) {
                S1();
                return;
            }
            O1();
            F1();
            L1();
            E1();
            f93.onEvent("show");
        }
    }

    public final void B1(boolean z) {
        EmojiEditText emojiEditText;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (emojiEditText = this.t0) == null) {
            return;
        }
        if (z) {
            emojiEditText.setPadding(yo3.g(8.0f), this.t0.getPaddingTop(), 0, this.t0.getPaddingBottom());
        } else {
            emojiEditText.setPadding(yo3.g(8.0f), this.t0.getPaddingTop(), yo3.g(8.0f), this.t0.getPaddingBottom());
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.K0 != null) {
                SpannableString g2 = u83.c().g(this.s0, this.K0, this.t0);
                this.t0.setText(g2);
                this.t0.setSelection(g2.length());
                P1(g2);
            }
            if (this.L0 != null) {
                B1(true);
                T1(this.L0);
                return;
            }
            B1(false);
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TextUtils.isEmpty(this.K0) && this.L0 == null) {
                n83.c().a();
            } else {
                n83.c().d(this.K0, this.L0);
            }
            I1(MediaTrackConfig.AE_IMPORT_DRAFT);
            n1();
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            la3.a aVar = new la3.a(getContext());
            aVar.m(false);
            aVar.U(R.string.obfuscated_res_0x7f0f156d);
            aVar.v(R.string.obfuscated_res_0x7f0f1571);
            aVar.O(R.string.obfuscated_res_0x7f0f0147, new a(this));
            aVar.X();
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.t0.setHint(this.H0.contentHint);
            this.w0.setText(this.H0.sendText);
            this.w0.setTextColor(this.H0.sendTextColor);
            this.w0.setBackground(H1(this.H0.sendTextBgColor));
            if (this.H0.supportNoModule()) {
                this.r0.findViewById(R.id.obfuscated_res_0x7f091795).setVisibility(8);
            }
        }
    }

    public final void O1() {
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

    public final StateListDrawable H1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            float g2 = yo3.g(4.0f);
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
        bw1 C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            if (view2 == this.w0) {
                I1("reply");
                f93.onEvent("pub_clk");
            } else if (view2 == this.z0) {
                K1();
                P1(this.t0.getText());
                f93.onEvent("pic_clk_del");
            } else if (view2 == this.A0) {
                i93.j(1, true, this);
                f93.onEvent("pic_clk_bar");
            } else if (view2 == this.y0 && (C = ou2.C()) != null) {
                C.d(getContext(), new String[]{this.L0.getPath()}, 0);
            }
        }
    }

    @Override // com.baidu.tieba.zo4, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Editable editable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dialogInterface) == null) {
            EmojiEditText emojiEditText = this.t0;
            if (emojiEditText != null) {
                editable = emojiEditText.getText();
            } else {
                editable = null;
            }
            if (this.D0 || editable == null || TextUtils.isEmpty(editable.toString())) {
                if (!this.D0 && this.t0 != null && J1()) {
                    return;
                }
                EmojiEditText emojiEditText2 = this.t0;
                if (emojiEditText2 != null) {
                    emojiEditText2.postDelayed(new j(this), 400L);
                }
                super.onDismiss(dialogInterface);
            }
        }
    }

    @Override // com.baidu.tieba.zo4, com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.v0(bundle);
            this.s0 = getActivity();
            Bundle o = o();
            if (o != null) {
                this.H0 = (ReplyEditorParams) o.getParcelable("params");
                if (o.getBoolean(MediaTrackConfig.AE_IMPORT_DRAFT)) {
                    this.K0 = o.getString("content");
                    this.L0 = (MediaModel) o.getParcelable("image");
                }
                if (this.H0 == null) {
                    this.I0 = true;
                    return;
                }
                return;
            }
            this.I0 = true;
        }
    }

    public final void I1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || this.J0 == null) {
            return;
        }
        if (!SwanAppNetworkUtils.i(getContext())) {
            i93.h(getContext(), R.string.obfuscated_res_0x7f0f1570);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.H0.supportPicture()) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.L0 != null) {
                    jSONObject2.put("path", uw2.T().G().h(this.L0.getTempPath()));
                    jSONObject2.put("size", this.L0.getSize());
                }
                jSONObject.put("tempFile", jSONObject2);
            }
            if (this.K0 == null) {
                this.K0 = "";
            }
            jSONObject.put("content", this.K0);
            jSONObject.put("status", str);
            this.J0.a(jSONObject);
            this.D0 = true;
            if (TextUtils.equals("reply", str)) {
                K1();
                n83.c().a();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void L1() {
        Window window;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (window = p1().getWindow()) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290);
        g93.c(getActivity(), viewGroup, this.B0, new g(this, viewGroup));
        d93.b(this.B0, this.E0, this.t0, new h(this));
        w83.b().c(getActivity(), this.B0, this.t0, this.H0.emojiPath, hb3.g0(), hb3.M().k0());
        this.r0.setVisibility(4);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            C1();
            this.x0 = new FrameLayout(this.s0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yo3.g(60.0f), yo3.g(60.0f));
            layoutParams.topMargin = yo3.g(8.0f);
            layoutParams.bottomMargin = yo3.g(8.0f);
            layoutParams.leftMargin = yo3.g(19.0f);
            layoutParams.rightMargin = yo3.g(9.0f);
            this.u0.addView(this.x0, layoutParams);
            FrameLayout frameLayout = new FrameLayout(this.s0);
            frameLayout.setBackgroundResource(R.drawable.obfuscated_res_0x7f0814a6);
            frameLayout.setPadding(1, 1, 1, 1);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this.s0);
            this.y0 = simpleDraweeView;
            simpleDraweeView.setScaleType(ImageView.ScaleType.CENTER);
            frameLayout.addView(this.y0, layoutParams2);
            this.x0.addView(frameLayout, layoutParams2);
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setBorderColor(LaunchTaskConstants.OTHER_PROCESS);
            roundingParams.setBorderWidth(1.0f);
            roundingParams.setCornersRadius(yo3.g(3.0f));
            roundingParams.setOverlayColor(-1);
            GenericDraweeHierarchy build = new GenericDraweeHierarchyBuilder(this.s0.getResources()).build();
            build.setRoundingParams(roundingParams);
            this.y0.setHierarchy(build);
            this.z0 = new BdBaseImageView(this.s0);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(yo3.g(20.0f), yo3.g(20.0f));
            layoutParams3.gravity = 8388613;
            this.x0.addView(this.z0, layoutParams3);
            this.z0.setImageResource(R.drawable.obfuscated_res_0x7f0814a7);
            this.y0.setOnClickListener(this);
            this.z0.setOnTouchListener(new xo3());
            this.z0.setOnClickListener(this);
        }
    }

    public final void N1(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            this.u0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091140);
            this.t0 = (EmojiEditText) view2.findViewById(R.id.obfuscated_res_0x7f0907ba);
            this.v0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09150d);
            this.w0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921ce);
            this.A0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091142);
            this.E0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0909a6);
            this.B0 = (SPSwitchPanelLinearLayout) view2.findViewById(R.id.panel_root);
            this.C0 = view2.findViewById(R.id.obfuscated_res_0x7f091cd6);
        }
    }

    public final void T1(MediaModel mediaModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, mediaModel) == null) {
            String tempPath = mediaModel.getTempPath();
            if (TextUtils.isEmpty(tempPath)) {
                FrameLayout frameLayout = this.x0;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                    return;
                }
                return;
            }
            FrameLayout frameLayout2 = this.x0;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
            this.y0.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setOldController(this.y0.getController()).setImageRequest(ImageRequestBuilder.newBuilderWithSource(fo3.m(tempPath)).setResizeOptions(new ResizeOptions(yo3.o(this.s0), yo3.n(this.s0))).build()).build());
            String str = this.K0;
            if (str == null) {
                str = "";
            }
            P1(str);
        }
    }

    public final void P1(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, charSequence) == null) {
            this.K0 = charSequence.toString();
            int a2 = h93.a(charSequence.toString());
            if (a2 < 0) {
                return;
            }
            if (a2 == 0) {
                if (J1()) {
                    this.w0.setEnabled(true);
                    this.v0.setVisibility(8);
                    return;
                }
                this.w0.setEnabled(false);
                this.v0.setVisibility(8);
            } else if (a2 <= 200) {
                this.w0.setEnabled(true);
                if (a2 < 180) {
                    this.v0.setVisibility(8);
                    return;
                }
                this.v0.setVisibility(0);
                this.v0.setText(String.format(this.s0.getResources().getString(R.string.obfuscated_res_0x7f0f157d), Integer.valueOf(200 - a2)));
                this.v0.setTextColor(ContextCompat.getColor(this.s0, R.color.obfuscated_res_0x7f060b18));
            } else {
                this.w0.setEnabled(false);
                this.v0.setVisibility(0);
                this.v0.setTextColor(ContextCompat.getColor(this.s0, R.color.obfuscated_res_0x7f060b19));
                if (a2 < 1200) {
                    this.v0.setText(String.format(this.s0.getResources().getString(R.string.obfuscated_res_0x7f0f157c), Integer.valueOf(a2 - 200)));
                } else {
                    this.v0.setText(this.s0.getResources().getString(R.string.obfuscated_res_0x7f0f157b));
                }
            }
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, layoutInflater, viewGroup, bundle)) == null) {
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d094b, viewGroup, false);
            this.r0 = linearLayout;
            N1(linearLayout);
            this.r0.setFocusableInTouchMode(true);
            this.r0.setOnKeyListener(new b(this));
            this.w0.setOnClickListener(this);
            if (this.H0.supportPicture()) {
                this.A0.setVisibility(0);
                this.A0.setOnClickListener(this);
                this.A0.setOnTouchListener(new xo3());
            } else {
                this.A0.setVisibility(8);
            }
            if (this.H0.supportEmoji()) {
                this.E0.setVisibility(0);
                this.E0.setOnTouchListener(new xo3());
            } else {
                this.E0.setVisibility(8);
            }
            this.C0.setOnTouchListener(new c(this));
            this.t0.addTextChangedListener(new d(this));
            this.t0.setListener(new e(this));
            this.t0.setListener(new f(this));
            M1();
            if (this.L0 == null) {
                K1();
            }
            this.t0.requestFocus();
            return this.r0;
        }
        return (View) invokeLLL.objValue;
    }
}
