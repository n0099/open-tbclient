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
import c.a.d.f.p.n;
import c.a.t0.o4.d;
import c.a.t0.o4.e;
import c.a.t0.o4.f;
import c.a.t0.o4.g;
import c.a.t0.o4.h;
import c.a.t0.o4.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class ShareSdkView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f51637e;

    /* renamed from: f  reason: collision with root package name */
    public View f51638f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f51639g;

    /* renamed from: h  reason: collision with root package name */
    public View f51640h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f51641i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f51642j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f51643k;
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

    /* loaded from: classes13.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareSdkView f51644e;

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
            this.f51644e = shareSdkView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > this.f51644e.r * 2) {
                    if (this.f51644e.s != 0) {
                        this.f51644e.s = 0;
                        ShareSdkView shareSdkView = this.f51644e;
                        shareSdkView.t = shareSdkView.v;
                        this.f51644e.m.setPadding(this.f51644e.w, this.f51644e.s, this.f51644e.w, this.f51644e.t);
                    }
                } else if (editable.length() > this.f51644e.r) {
                    if (this.f51644e.s != this.f51644e.v) {
                        ShareSdkView shareSdkView2 = this.f51644e;
                        shareSdkView2.s = shareSdkView2.v;
                        ShareSdkView shareSdkView3 = this.f51644e;
                        shareSdkView3.t = shareSdkView3.v;
                        this.f51644e.m.setPadding(this.f51644e.w, this.f51644e.s, this.f51644e.w, this.f51644e.t);
                    }
                } else if (this.f51644e.s != this.f51644e.u) {
                    ShareSdkView shareSdkView4 = this.f51644e;
                    shareSdkView4.s = shareSdkView4.u;
                    ShareSdkView shareSdkView5 = this.f51644e;
                    shareSdkView5.t = shareSdkView5.u;
                    this.f51644e.m.setPadding(this.f51644e.w, this.f51644e.s, this.f51644e.w, this.f51644e.t);
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

    /* loaded from: classes13.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareSdkView a;

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
            this.a = shareSdkView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.l.getLayoutParams();
                layoutParams.height = ((n.k(this.a.getContext()) - n.f(this.a.getContext(), e.tbds408)) * 9) / 16;
                this.a.l.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
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
        this.f51637e = 3;
        k(context);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            setGravity(16);
            LayoutInflater.from(context).inflate(h.share_sdk_view, (ViewGroup) this, true);
            this.f51638f = findViewById(g.share_sdk_content_root);
            this.f51639g = (TextView) findViewById(g.share_sdk_forum);
            this.f51640h = findViewById(g.share_sdk_content_container);
            this.f51641i = (HeadImageView) findViewById(g.share_sdk_appicon);
            this.f51642j = (TextView) findViewById(g.share_sdk_appname);
            this.f51643k = (TextView) findViewById(g.share_sdk_content);
            this.l = (TbImageView) findViewById(g.share_sdk_img);
            this.m = (EditText) findViewById(g.share_sdk_edit);
            this.n = findViewById(g.share_sdk_content_line);
            this.o = (TextView) findViewById(g.share_sdk_cancel);
            this.p = findViewById(g.share_sdk_action_line);
            this.q = (TextView) findViewById(g.share_sdk_share);
            setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.f51641i.setIsRound(true);
            this.f51641i.setIsPreDrawBorder(true);
            this.f51641i.setDrawBorder(true);
            this.f51641i.setBorderWidth(n.f(context, e.tbds1));
            this.f51641i.setDefaultResource(d.CAM_X0205);
            this.f51641i.setRadius(n.f(context, e.ds70));
            this.l.setDefaultBgResource(f.pic_share_default_applets);
            this.r = (n.k(getContext()) - n.f(getContext(), e.tbds516)) / n.f(getContext(), e.tbds45);
            this.u = n.f(getContext(), e.tbds27);
            this.v = n.f(getContext(), e.tbds11);
            this.w = n.f(getContext(), e.tbds36);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f51637e) {
            return;
        }
        this.f51637e = skinType;
        SkinManager.setBackgroundColor(this, d.black_alpha30);
        SkinManager.setBackgroundResource(this.f51638f, f.share_sdk_bg);
        SkinManager.setViewTextColor(this.f51639g, d.CAM_X0105);
        SkinManager.setBackgroundColor(this.f51640h, d.CAM_X0205);
        this.f51641i.setBorderColor(SkinManager.getColor(d.CAM_X0111));
        this.f51641i.setSkinType(this.f51637e);
        SkinManager.setViewTextColor(this.f51642j, d.CAM_X0106);
        SkinManager.setViewTextColor(this.f51643k, d.CAM_X0105);
        this.l.setSkinType(this.f51637e);
        this.m.setHintTextColor(SkinManager.getColor(d.CAM_X0110));
        this.m.setTextColor(SkinManager.getColor(d.CAM_X0105));
        SkinManager.setBackgroundResource(this.m, f.share_sdk_input_shape_bg);
        SkinManager.setBackgroundColor(this.n, d.CAM_X0204);
        SkinManager.setViewTextColor(this.o, d.CAM_X0105);
        SkinManager.setBackgroundColor(this.p, d.CAM_X0204);
        SkinManager.setViewTextColor(this.q, d.CAM_X0302);
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

    public void setData(c.a.t0.o4.z.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar == null && getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
                return;
            }
            this.f51639g.setText(String.format(getResources().getString(j.share_sdk_forum), cVar.f21918f));
            this.f51641i.startLoad(cVar.f21916d, 10, false);
            this.f51642j.setText(cVar.f21915c);
            if (StringUtils.isNull(cVar.f21920h)) {
                this.f51643k.setVisibility(8);
            } else {
                this.f51643k.setText(cVar.f21920h);
            }
            this.l.setEvent(new b(this));
            this.l.startLoad(cVar.f21921i, 42, false);
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
        this.f51637e = 3;
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
        this.f51637e = 3;
        k(context);
    }
}
