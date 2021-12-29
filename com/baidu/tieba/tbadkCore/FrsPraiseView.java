package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.s0.e1.a0;
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
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class FrsPraiseView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49984e;

    /* renamed from: f  reason: collision with root package name */
    public View f49985f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49986g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49987h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49988i;

    /* renamed from: j  reason: collision with root package name */
    public PraiseData f49989j;

    /* renamed from: k  reason: collision with root package name */
    public String f49990k;
    public String l;
    public boolean m;
    public boolean n;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPraiseView f49991e;

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
            this.f49991e = frsPraiseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a0.b(new PraiseListActivityConfig(this.f49991e.f49984e, this.f49991e.f49990k, this.f49991e.l, this.f49991e.f49989j != null ? this.f49991e.f49989j.getTitle() : "", this.f49991e.m));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPraiseView f49992e;

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
            this.f49992e = frsPraiseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f49992e.f49989j.getUser().get(1)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f49992e.f49984e).createNormalConfig(c.a.d.f.m.b.g(metaData.getUserId(), 0L), false, metaData.isBigV())));
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FrsPraiseView f49993e;

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
            this.f49993e = frsPraiseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (metaData = this.f49993e.f49989j.getUser().get(0)) == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f49993e.f49984e).createNormalConfig(c.a.d.f.m.b.g(metaData.getUserId(), 0L), false, metaData.isBigV())));
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
            long num = this.f49989j.getNum();
            this.f49988i.setVisibility(8);
            this.f49987h.setVisibility(8);
            if (num > 0) {
                ArrayList<MetaData> user = this.f49989j.getUser();
                if (user != null && user.size() > 0) {
                    if (user.size() == 1) {
                        if (user.get(0) != null) {
                            this.f49987h.setVisibility(0);
                            this.f49987h.setText(g(user.get(0).getName_show()));
                        }
                    } else {
                        if (user.get(0) != null) {
                            this.f49987h.setVisibility(0);
                            this.f49987h.setText(g(user.get(0).getName_show()));
                        }
                        if (user.get(1) != null) {
                            this.f49988i.setVisibility(0);
                            TextView textView = this.f49988i;
                            textView.setText("、" + g(user.get(1).getName_show()));
                        }
                    }
                }
                if (num <= 2) {
                    this.f49986g.setText(this.f49984e.getString(R.string.common_praise_view_text));
                } else if (num <= 999999) {
                    TextView textView2 = this.f49986g;
                    textView2.setText(this.f49984e.getString(R.string.etc) + num + this.f49984e.getString(R.string.common_praise_view_text2));
                } else {
                    TextView textView3 = this.f49986g;
                    textView3.setText(this.f49984e.getString(R.string.etc) + "999999+" + this.f49984e.getString(R.string.common_praise_view_text2));
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
            View inflate = View.inflate(this.f49984e, R.layout.frs_item_praise, this);
            this.f49985f = inflate;
            this.f49986g = (TextView) inflate.findViewById(R.id.frs_go_praise_list_num);
            this.f49987h = (TextView) this.f49985f.findViewById(R.id.frs_praise_user_name_text1);
            this.f49988i = (TextView) this.f49985f.findViewById(R.id.frs_praise_user_name_text2);
            setOnClickListener(new a(this));
            this.f49988i.setOnClickListener(new b(this));
            this.f49987h.setOnClickListener(new c(this));
        }
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.m) {
                if (this.n) {
                    SkinManager.setBackgroundResource(this.f49985f, R.drawable.praise_video_selector);
                    SkinManager.setViewTextColor(this.f49986g, R.color.CAM_X0108, 1);
                    SkinManager.setViewTextColor(this.f49987h, R.color.CAM_X0304, 1);
                    SkinManager.setViewTextColor(this.f49988i, R.color.CAM_X0304, 1);
                    return;
                }
                SkinManager.setBackgroundResource(this.f49985f, R.drawable.praise_head_selector);
                SkinManager.setViewTextColor(this.f49986g, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.f49987h, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(this.f49988i, R.color.CAM_X0304, 1);
                return;
            }
            SkinManager.setBackgroundResource(this.f49985f, R.drawable.praise_view_btn_color);
            SkinManager.setViewTextColor(this.f49986g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.f49987h, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(this.f49988i, R.color.CAM_X0108, 1);
        }
    }

    public void setData(PraiseData praiseData, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{praiseData, str, str2, Boolean.valueOf(z)}) == null) || praiseData == null) {
            return;
        }
        this.f49990k = str;
        this.l = str2;
        this.f49989j = praiseData;
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
        this.f49984e = context;
        h();
    }
}
