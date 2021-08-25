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
    public int f58617e;

    /* renamed from: f  reason: collision with root package name */
    public View f58618f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58619g;

    /* renamed from: h  reason: collision with root package name */
    public View f58620h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f58621i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f58622j;
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
        public final /* synthetic */ ShareSdkView f58623e;

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
            this.f58623e = shareSdkView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > this.f58623e.r * 2) {
                    if (this.f58623e.s != 0) {
                        this.f58623e.s = 0;
                        ShareSdkView shareSdkView = this.f58623e;
                        shareSdkView.t = shareSdkView.v;
                        this.f58623e.m.setPadding(this.f58623e.w, this.f58623e.s, this.f58623e.w, this.f58623e.t);
                    }
                } else if (editable.length() > this.f58623e.r) {
                    if (this.f58623e.s != this.f58623e.v) {
                        ShareSdkView shareSdkView2 = this.f58623e;
                        shareSdkView2.s = shareSdkView2.v;
                        ShareSdkView shareSdkView3 = this.f58623e;
                        shareSdkView3.t = shareSdkView3.v;
                        this.f58623e.m.setPadding(this.f58623e.w, this.f58623e.s, this.f58623e.w, this.f58623e.t);
                    }
                } else if (this.f58623e.s != this.f58623e.u) {
                    ShareSdkView shareSdkView4 = this.f58623e;
                    shareSdkView4.s = shareSdkView4.u;
                    ShareSdkView shareSdkView5 = this.f58623e;
                    shareSdkView5.t = shareSdkView5.u;
                    this.f58623e.m.setPadding(this.f58623e.w, this.f58623e.s, this.f58623e.w, this.f58623e.t);
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
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ShareSdkView f58624a;

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
            this.f58624a = shareSdkView;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                ViewGroup.LayoutParams layoutParams = this.f58624a.l.getLayoutParams();
                layoutParams.height = ((l.k(this.f58624a.getContext()) - l.g(this.f58624a.getContext(), R.dimen.tbds408)) * 9) / 16;
                this.f58624a.l.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
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
        this.f58617e = 3;
        k(context);
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setOrientation(1);
            setGravity(16);
            LayoutInflater.from(context).inflate(R.layout.share_sdk_view, (ViewGroup) this, true);
            this.f58618f = findViewById(R.id.share_sdk_content_root);
            this.f58619g = (TextView) findViewById(R.id.share_sdk_forum);
            this.f58620h = findViewById(R.id.share_sdk_content_container);
            this.f58621i = (HeadImageView) findViewById(R.id.share_sdk_appicon);
            this.f58622j = (TextView) findViewById(R.id.share_sdk_appname);
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
            this.f58621i.setIsRound(true);
            this.f58621i.setIsPreDrawBorder(true);
            this.f58621i.setDrawBorder(true);
            this.f58621i.setBorderWidth(l.g(context, R.dimen.tbds1));
            this.f58621i.setDefaultResource(R.color.CAM_X0205);
            this.f58621i.setRadius(l.g(context, R.dimen.ds70));
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f58617e) {
            return;
        }
        this.f58617e = skinType;
        SkinManager.setBackgroundColor(this, R.color.black_alpha30);
        SkinManager.setBackgroundResource(this.f58618f, R.drawable.share_sdk_bg);
        SkinManager.setViewTextColor(this.f58619g, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.f58620h, R.color.CAM_X0205);
        this.f58621i.setBorderColor(SkinManager.getColor(R.color.CAM_X0111));
        this.f58621i.setIsNight(this.f58617e == 1);
        SkinManager.setViewTextColor(this.f58622j, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        this.l.setIsNight(this.f58617e == 1);
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

    public void setData(c.a.q0.b4.p.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar == null && getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
                return;
            }
            this.f58619g.setText(String.format(getResources().getString(R.string.share_sdk_forum), cVar.f16292f));
            this.f58621i.startLoad(cVar.f16290d, 10, false);
            this.f58622j.setText(cVar.f16289c);
            if (StringUtils.isNull(cVar.f16294h)) {
                this.k.setVisibility(8);
            } else {
                this.k.setText(cVar.f16294h);
            }
            this.l.setEvent(new b(this));
            this.l.startLoad(cVar.f16295i, 42, false);
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
        this.f58617e = 3;
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
        this.f58617e = 3;
        k(context);
    }
}
