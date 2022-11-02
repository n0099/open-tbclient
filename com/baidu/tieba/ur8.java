package com.baidu.tieba;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ur8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public SeekBar b;
    public View c;
    public int d;
    public ViewTreeObserver.OnGlobalLayoutListener e;

    /* loaded from: classes6.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ur8 ur8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0812b7));
                qc8 qc8Var = new qc8();
                qc8Var.a = 2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, qc8Var));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                seekBar.setProgressDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0812b8));
                qc8 qc8Var = new qc8();
                qc8Var.a = 3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, qc8Var));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                qc8 qc8Var = new qc8();
                qc8Var.a = 1;
                qc8Var.b = i;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921635, qc8Var));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur8 a;

        public b(ur8 ur8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur8Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.a.b.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.b.getLayoutParams();
                if (layoutParams.bottomMargin != this.a.d) {
                    layoutParams.bottomMargin = this.a.c.getHeight() - xi.g(this.a.a, R.dimen.tbds16);
                    this.a.b.setLayoutParams(layoutParams);
                    this.a.d = layoutParams.bottomMargin;
                }
            }
        }
    }

    public ur8(BaseFragmentActivity baseFragmentActivity, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -1;
        this.e = new b(this);
        this.a = baseFragmentActivity;
        this.c = view2;
        SeekBar seekBar = (SeekBar) baseFragmentActivity.findViewById(R.id.obfuscated_res_0x7f0925a8);
        this.b = seekBar;
        seekBar.setOnSeekBarChangeListener(new a(this));
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.e);
    }

    public void f(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            SeekBar seekBar = this.b;
            if (z) {
                i = 0;
            } else {
                i = 4;
            }
            seekBar.setVisibility(i);
        }
    }
}
