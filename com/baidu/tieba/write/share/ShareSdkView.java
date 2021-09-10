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
import c.a.e.e.p.l;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f58798e;

    /* renamed from: f  reason: collision with root package name */
    public View f58799f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58800g;

    /* renamed from: h  reason: collision with root package name */
    public View f58801h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f58802i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f58803j;
    public TextView k;
    public TbImageView l;
    public EditText m;
    public View n;
    public TextView o;
    public View p;
    public TextView q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public c x;

    /* loaded from: classes7.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareSdkView f58804e;

        public a(ShareSdkView shareSdkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareSdkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58804e = shareSdkView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > this.f58804e.r * 2) {
                    if (this.f58804e.s != 0) {
                        this.f58804e.s = 0;
                        ShareSdkView shareSdkView = this.f58804e;
                        shareSdkView.t = shareSdkView.v;
                        this.f58804e.m.setPadding(this.f58804e.w, this.f58804e.s, this.f58804e.w, this.f58804e.t);
                    }
                } else if (editable.length() > this.f58804e.r) {
                    if (this.f58804e.s != this.f58804e.v) {
                        ShareSdkView shareSdkView2 = this.f58804e;
                        shareSdkView2.s = shareSdkView2.v;
                        ShareSdkView shareSdkView3 = this.f58804e;
                        shareSdkView3.t = shareSdkView3.v;
                        this.f58804e.m.setPadding(this.f58804e.w, this.f58804e.s, this.f58804e.w, this.f58804e.t);
                    }
                } else if (this.f58804e.s != this.f58804e.u) {
                    ShareSdkView shareSdkView4 = this.f58804e;
                    shareSdkView4.s = shareSdkView4.u;
                    ShareSdkView shareSdkView5 = this.f58804e;
                    shareSdkView5.t = shareSdkView5.u;
                    this.f58804e.m.setPadding(this.f58804e.w, this.f58804e.s, this.f58804e.w, this.f58804e.t);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShareSdkView f58805a;

        public b(ShareSdkView shareSdkView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareSdkView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58805a = shareSdkView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                ViewGroup.LayoutParams layoutParams = this.f58805a.l.getLayoutParams();
                layoutParams.height = ((l.k(this.f58805a.getContext()) - l.g(this.f58805a.getContext(), R.dimen.tbds408)) * 9) / 16;
                this.f58805a.l.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(String str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58798e = 3;
        k(context);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            setGravity(16);
            LayoutInflater.from(context).inflate(R.layout.share_sdk_view, (ViewGroup) this, true);
            this.f58799f = findViewById(R.id.share_sdk_content_root);
            this.f58800g = (TextView) findViewById(R.id.share_sdk_forum);
            this.f58801h = findViewById(R.id.share_sdk_content_container);
            this.f58802i = (HeadImageView) findViewById(R.id.share_sdk_appicon);
            this.f58803j = (TextView) findViewById(R.id.share_sdk_appname);
            this.k = (TextView) findViewById(R.id.share_sdk_content);
            this.l = (TbImageView) findViewById(R.id.share_sdk_img);
            this.m = (EditText) findViewById(R.id.share_sdk_edit);
            this.n = findViewById(R.id.share_sdk_content_line);
            this.o = (TextView) findViewById(R.id.share_sdk_cancel);
            this.p = findViewById(R.id.share_sdk_action_line);
            this.q = (TextView) findViewById(R.id.share_sdk_share);
            setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.f58802i.setIsRound(true);
            this.f58802i.setIsPreDrawBorder(true);
            this.f58802i.setDrawBorder(true);
            this.f58802i.setBorderWidth(l.g(context, R.dimen.tbds1));
            this.f58802i.setDefaultResource(R.color.CAM_X0205);
            this.f58802i.setRadius(l.g(context, R.dimen.ds70));
            this.l.setDefaultBgResource(R.drawable.pic_share_default_applets);
            this.r = (l.k(getContext()) - l.g(getContext(), R.dimen.tbds516)) / l.g(getContext(), R.dimen.tbds45);
            this.u = l.g(getContext(), R.dimen.tbds27);
            this.v = l.g(getContext(), R.dimen.tbds11);
            this.w = l.g(getContext(), R.dimen.tbds36);
            int i2 = this.u;
            this.s = i2;
            this.t = i2;
            this.m.addTextChangedListener(new a(this));
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f58798e) {
            return;
        }
        this.f58798e = skinType;
        SkinManager.setBackgroundColor(this, R.color.black_alpha30);
        SkinManager.setBackgroundResource(this.f58799f, R.drawable.share_sdk_bg);
        SkinManager.setViewTextColor(this.f58800g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f58801h, R.color.CAM_X0205);
        this.f58802i.setBorderColor(SkinManager.getColor(R.color.CAM_X0111));
        this.f58802i.setSkinType(this.f58798e);
        SkinManager.setViewTextColor(this.f58803j, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        this.l.setSkinType(this.f58798e);
        this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setBackgroundResource(this.m, R.drawable.share_sdk_input_shape_bg);
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0302);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            if (view == this.o) {
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
            } else if (view == this.q && ViewHelper.checkUpIsLogin(getContext())) {
                String obj = this.m.getText().toString();
                c cVar = this.x;
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
            this.x = null;
            super.onDetachedFromWindow();
        }
    }

    public void setData(c.a.r0.c4.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar == null && getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
                return;
            }
            this.f58800g.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.f16811f));
            this.f58802i.startLoad(cVar.f16809d, 10, false);
            this.f58803j.setText(cVar.f16808c);
            if (StringUtils.isNull(cVar.f16813h)) {
                this.k.setVisibility(8);
            } else {
                this.k.setText(cVar.f16813h);
            }
            this.l.setEvent(new b(this));
            this.l.startLoad(cVar.f16814i, 42, false);
        }
    }

    public void setOnShareListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.x = cVar;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58798e = 3;
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareSdkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f58798e = 3;
        k(context);
    }
}
