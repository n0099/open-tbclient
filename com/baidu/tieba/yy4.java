package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes9.dex */
public class yy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final View b;
    public final ThreadAchievementShareInfo.ParamBean c;
    public TbRichTextView d;
    public z16 e;
    public TbImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;

    public yy4(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
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
        this.b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.getContent() != null && this.c.getContent().size() != 0) {
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
                ((LinearLayout.LayoutParams) this.d.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.a, R.dimen.tbds20);
                this.d.setMaxLines(8);
            }
            this.d.setTextEllipsize(TextUtils.TruncateAt.END);
            this.d.setMinimumHeight(BdUtilHelper.getDimens(this.a, R.dimen.tbds516));
            if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.c.getThread_type().contains("pic")) {
                this.f.setVisibility(0);
                this.f.setDefaultBgResource(R.color.transparent);
                this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f.setPlaceHolder(2);
                this.f.startLoad(contentBean.getSrc(), 10, false);
                if (!TextUtils.isEmpty(this.c.getThread_title())) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setMaxLines(2);
                    this.d.setTextEllipsize(TextUtils.TruncateAt.END);
                    this.d.setLayoutStrategy(this.e);
                    this.d.setMinimumHeight(BdUtilHelper.getDimens(this.a, R.dimen.tbds0));
                }
            }
            this.d.setText(TbRichTextView.Z(jSONArray, false));
            this.k.setText(StringHelper.numFormatOverWanWithNegative(this.c.getAgree_num()));
            this.h.setText(StringHelper.numFormatOverWanWithNegative(this.c.getPost_num()));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h = (TextView) this.b.findViewById(R.id.comment_num);
            this.i = (TextView) this.b.findViewById(R.id.comment_desc);
            this.j = (TextView) this.b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.b.findViewById(R.id.praise_num);
            this.g = (TextView) this.b.findViewById(R.id.thread_title);
            this.f = (TbImageView) this.b.findViewById(R.id.main_img);
            this.d = (TbRichTextView) this.b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            z16 z16Var = new z16();
            this.e = z16Var;
            z16Var.u(BdUtilHelper.getDimens(this.a, R.dimen.tbds38));
            this.e.x(BdUtilHelper.getDimens(this.a, R.dimen.tbds42));
            this.e.k(BdUtilHelper.getDimens(this.a, R.dimen.tbds23));
            this.e.p(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.e.j(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.d.setLayoutStrategy(this.e);
            this.d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
