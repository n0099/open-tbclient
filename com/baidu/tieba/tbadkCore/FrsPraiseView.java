package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.z0.v;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class FrsPraiseView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21054e;

    /* renamed from: f  reason: collision with root package name */
    public View f21055f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21056g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21057h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21058i;
    public PraiseData j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPraiseView f21059e;

        public a(FrsPraiseView frsPraiseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPraiseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21059e = frsPraiseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                v.b(new PraiseListActivityConfig(this.f21059e.f21054e, this.f21059e.k, this.f21059e.l, this.f21059e.j != null ? this.f21059e.j.getTitle() : "", this.f21059e.m));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPraiseView f21060e;

        public b(FrsPraiseView frsPraiseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPraiseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21060e = frsPraiseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f21060e.j.getUser().get(1)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f21060e.f21054e).createNormalConfig(d.a.c.e.m.b.f(metaData.getUserId(), 0L), false, metaData.isBigV())));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPraiseView f21061e;

        public c(FrsPraiseView frsPraiseView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsPraiseView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21061e = frsPraiseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f21061e.j.getUser().get(0)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f21061e.f21054e).createNormalConfig(d.a.c.e.m.b.f(metaData.getUserId(), 0L), false, metaData.isBigV())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPraiseView(Context context) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.n = false;
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            long num = this.j.getNum();
            this.f21058i.setVisibility(8);
            this.f21057h.setVisibility(8);
            if (num > 0) {
                ArrayList<MetaData> user = this.j.getUser();
                if (user != null && user.size() > 0) {
                    if (user.size() == 1) {
                        if (user.get(0) != null) {
                            this.f21057h.setVisibility(0);
                            this.f21057h.setText(g(user.get(0).getName_show()));
                        }
                    } else {
                        if (user.get(0) != null) {
                            this.f21057h.setVisibility(0);
                            this.f21057h.setText(g(user.get(0).getName_show()));
                        }
                        if (user.get(1) != null) {
                            this.f21058i.setVisibility(0);
                            TextView textView = this.f21058i;
                            textView.setText("、" + g(user.get(1).getName_show()));
                        }
                    }
                }
                if (num <= 2) {
                    this.f21056g.setText(this.f21054e.getString(R.string.common_praise_view_text));
                } else if (num <= 999999) {
                    TextView textView2 = this.f21056g;
                    textView2.setText(this.f21054e.getString(R.string.etc) + num + this.f21054e.getString(R.string.common_praise_view_text2));
                } else {
                    TextView textView3 = this.f21056g;
                    textView3.setText(this.f21054e.getString(R.string.etc) + "999999+" + this.f21054e.getString(R.string.common_praise_view_text2));
                }
            }
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? (TextUtils.isEmpty(str) || str.length() <= 14) ? str : str.substring(0, 14) : (String) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = View.inflate(this.f21054e, R.layout.frs_item_praise, this);
            this.f21055f = inflate;
            this.f21056g = (TextView) inflate.findViewById(R.id.frs_go_praise_list_num);
            this.f21057h = (TextView) this.f21055f.findViewById(R.id.frs_praise_user_name_text1);
            this.f21058i = (TextView) this.f21055f.findViewById(R.id.frs_praise_user_name_text2);
            setOnClickListener(new a(this));
            this.f21058i.setOnClickListener(new b(this));
            this.f21057h.setOnClickListener(new c(this));
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.m) {
                if (this.n) {
                    SkinManager.setBackgroundResource(this.f21055f, R.drawable.praise_video_selector);
                    SkinManager.setViewTextColor(this.f21056g, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(this.f21057h, R.color.CAM_X0304, 1);
                    SkinManager.setViewTextColor(this.f21058i, R.color.CAM_X0304, 1);
                    return;
                }
                SkinManager.setBackgroundResource(this.f21055f, R.drawable.praise_head_selector);
                SkinManager.setViewTextColor(this.f21056g, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.f21057h, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(this.f21058i, R.color.CAM_X0304, 1);
                return;
            }
            SkinManager.setBackgroundResource(this.f21055f, R.drawable.praise_view_btn_color);
            SkinManager.setViewTextColor(this.f21056g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.f21057h, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(this.f21058i, R.color.CAM_X0108, 1);
        }
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{praiseData, str, str2, Boolean.valueOf(z)}) == null) || praiseData == null) {
            return;
        }
        this.k = str;
        this.l = str2;
        this.j = praiseData;
        f(z);
    }

    public void setIsFromPb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsFromPbVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPraiseView(Context context, AttributeSet attributeSet) {
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
        this.m = false;
        this.n = false;
        setOrientation(0);
        this.f21054e = context;
        h();
    }
}
