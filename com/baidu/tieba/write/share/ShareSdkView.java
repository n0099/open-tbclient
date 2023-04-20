package com.baidu.tieba.write.share;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.tieba.m2a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public View b;
    public TextView c;
    public View d;
    public HeadImageView e;
    public TextView f;
    public TextView g;
    public TbImageView h;
    public EditText i;
    public View j;
    public TextView k;
    public View l;
    public TextView m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public c t;

    /* loaded from: classes6.dex */
    public interface c {
        void a(String str);
    }

    /* loaded from: classes6.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareSdkView a;

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

        public a(ShareSdkView shareSdkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareSdkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareSdkView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > this.a.n * 2) {
                    if (this.a.o == 0) {
                        return;
                    }
                    this.a.o = 0;
                    ShareSdkView shareSdkView = this.a;
                    shareSdkView.p = shareSdkView.r;
                    this.a.i.setPadding(this.a.s, this.a.o, this.a.s, this.a.p);
                } else if (editable.length() > this.a.n) {
                    if (this.a.o != this.a.r) {
                        ShareSdkView shareSdkView2 = this.a;
                        shareSdkView2.o = shareSdkView2.r;
                        ShareSdkView shareSdkView3 = this.a;
                        shareSdkView3.p = shareSdkView3.r;
                        this.a.i.setPadding(this.a.s, this.a.o, this.a.s, this.a.p);
                    }
                } else if (this.a.o != this.a.q) {
                    ShareSdkView shareSdkView4 = this.a;
                    shareSdkView4.o = shareSdkView4.q;
                    ShareSdkView shareSdkView5 = this.a;
                    shareSdkView5.p = shareSdkView5.q;
                    this.a.i.setPadding(this.a.s, this.a.o, this.a.s, this.a.p);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareSdkView a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(ShareSdkView shareSdkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareSdkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareSdkView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.h.getLayoutParams();
                layoutParams.height = ((ii.l(this.a.getContext()) - ii.g(this.a.getContext(), R.dimen.tbds408)) * 9) / 16;
                this.a.h.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareSdkView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareSdkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareSdkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        k(context);
    }

    public void setOnShareListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            setGravity(16);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0822, (ViewGroup) this, true);
            this.b = findViewById(R.id.obfuscated_res_0x7f092062);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f092064);
            this.d = findViewById(R.id.obfuscated_res_0x7f092060);
            this.e = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f09205c);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f09205d);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09205f);
            this.h = (TbImageView) findViewById(R.id.obfuscated_res_0x7f092065);
            this.i = (EditText) findViewById(R.id.obfuscated_res_0x7f092063);
            this.j = findViewById(R.id.obfuscated_res_0x7f092061);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09205e);
            this.l = findViewById(R.id.obfuscated_res_0x7f09205b);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f092066);
            setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.e.setIsRound(true);
            this.e.setIsPreDrawBorder(true);
            this.e.setDrawBorder(true);
            this.e.setBorderWidth(ii.g(context, R.dimen.tbds1));
            this.e.setDefaultResource(R.color.CAM_X0205);
            this.e.setRadius(ii.g(context, R.dimen.obfuscated_res_0x7f070266));
            this.h.setDefaultBgResource(R.drawable.pic_share_default_applets);
            this.n = (ii.l(getContext()) - ii.g(getContext(), R.dimen.tbds516)) / ii.g(getContext(), R.dimen.tbds45);
            this.q = ii.g(getContext(), R.dimen.tbds27);
            this.r = ii.g(getContext(), R.dimen.tbds11);
            this.s = ii.g(getContext(), R.dimen.tbds36);
            int i = this.q;
            this.o = i;
            this.p = i;
            this.i.addTextChangedListener(new a(this));
            l();
        }
    }

    public void l() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setBackgroundColor(this, R.color.black_alpha30);
        SkinManager.setBackgroundResource(this.b, R.drawable.share_sdk_bg);
        SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
        this.e.setBorderColor(SkinManager.getColor(R.color.CAM_X0111));
        this.e.setSkinType(this.a);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        this.h.setSkinType(this.a);
        this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundResource(this.i, R.drawable.share_sdk_input_shape_bg);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2 == this.k) {
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
            } else if (view2 == this.m && ViewHelper.checkUpIsLogin(getContext())) {
                String obj = this.i.getText().toString();
                c cVar = this.t;
                if (cVar != null) {
                    cVar.a(obj);
                }
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.t = null;
            super.onDetachedFromWindow();
        }
    }

    public void setData(m2a m2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, m2aVar) == null) {
            if (m2aVar == null && getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
                return;
            }
            this.c.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f1237), m2aVar.f));
            this.e.N(m2aVar.d, 10, false);
            this.f.setText(m2aVar.c);
            if (StringUtils.isNull(m2aVar.h)) {
                this.g.setVisibility(8);
            } else {
                this.g.setText(m2aVar.h);
            }
            this.h.setEvent(new b(this));
            this.h.N(m2aVar.i, 42, false);
        }
    }
}
