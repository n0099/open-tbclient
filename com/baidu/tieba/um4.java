package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class um4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public final ThreadAchievementShareInfo.ParamBean c;
    public TbRichTextView d;
    public ii5 e;
    public TbImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;

    public um4(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d064f, (ViewGroup) null);
        this.c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c.getContent() == null || this.c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.c.getContent()) {
            if (contentBean2.getType() == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", contentBean2.getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } else if (contentBean2.getType() == 3) {
                contentBean = contentBean2;
            }
        }
        if (!TextUtils.isEmpty(this.c.getThread_title())) {
            this.g.setText(this.c.getThread_title());
            this.g.setVisibility(0);
            this.d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.d.getLayoutParams()).topMargin = ri.f(this.a, R.dimen.tbds20);
            this.d.setMaxLines(8);
        }
        this.d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.d.setMinimumHeight(ri.f(this.a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.c.getThread_type().contains("pic")) {
            this.f.setVisibility(0);
            this.f.setDefaultBgResource(R.color.transparent);
            this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f.setPlaceHolder(2);
            this.f.K(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.c.getThread_title())) {
                this.d.setVisibility(8);
            } else {
                this.d.setMaxLines(2);
                this.d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.d.setLayoutStrategy(this.e);
                this.d.setMinimumHeight(ri.f(this.a, R.dimen.tbds0));
            }
        }
        this.d.setText(TbRichTextView.U(jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.c.getAgree_num()));
        this.h.setText(StringHelper.numFormatOverWanWithNegative(this.c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090675);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09066b);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a20);
            this.k = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a21);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092166);
            this.f = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091461);
            this.d = (TbRichTextView) this.b.findViewById(R.id.obfuscated_res_0x7f091bd7);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            ii5 ii5Var = new ii5();
            this.e = ii5Var;
            ii5Var.s(ri.f(this.a, R.dimen.tbds38));
            this.e.v(ri.f(this.a, R.dimen.tbds42));
            this.e.j(ri.f(this.a, R.dimen.tbds23));
            this.e.o(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.e.i(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.d.setLayoutStrategy(this.e);
            this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
