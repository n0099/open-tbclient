package com.baidu.tieba;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class ny extends cx implements sx<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext e;
    public SimpleDraweeView f;
    public TextView g;
    public ImageView h;
    public FrameLayout i;
    public boolean j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;
        public final /* synthetic */ ny b;

        public a(ny nyVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nyVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nyVar;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String jumpUrl = this.a.getJumpUrl();
                if (!StringUtils.isNull(jumpUrl)) {
                    UrlManager.getInstance().dealOneLink(this.b.e, new String[]{ot8.a(jumpUrl, "0", "", String.valueOf(this.a.getCardId()))});
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.b.e.getPageActivity(), this.a.getCardId())));
            }
        }
    }

    public ny(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.e = tbPageContext;
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.g(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070260), yi.g(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d2));
        layoutParams.addRule(11);
        layoutParams.topMargin = yi.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = yi.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        i(layoutParams);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(tbPageContext.getPageActivity());
        this.f = simpleDraweeView;
        simpleDraweeView.setContentDescription("个性卡片");
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getContext());
        this.i = frameLayout;
        frameLayout.addView(this.f);
        ImageView imageView = new ImageView(tbPageContext.getPageActivity());
        this.h = imageView;
        imageView.setContentDescription("个性卡片ID前缀");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(yi.g(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070215), yi.g(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2));
        layoutParams2.gravity = 51;
        layoutParams2.topMargin = yi.g(tbPageContext.getPageActivity(), R.dimen.tbds13);
        this.h.setLayoutParams(layoutParams2);
        this.i.addView(this.h);
        TextView textView = new TextView(tbPageContext.getContext());
        this.g = textView;
        textView.setContentDescription("个性卡片ID");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 83;
        layoutParams3.leftMargin = yi.g(tbPageContext.getPageActivity(), R.dimen.M_W_X001);
        layoutParams3.bottomMargin = yi.g(tbPageContext.getPageActivity(), R.dimen.tbds3);
        this.g.setLayoutParams(layoutParams3);
        this.i.addView(this.g);
        g(this.i);
    }

    public void l(ThreadData threadData) {
        MetaData author;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null || this.f == null || (author = threadData.getAuthor()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = author.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !threadData.isHeadLinePost) {
            if (this.j && (this.f.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams.rightMargin = yi.g(this.e.getPageActivity(), R.dimen.tbds106);
                this.f.setLayoutParams(layoutParams);
            }
            this.f.setVisibility(0);
            this.f.setImageDrawable(null);
            if (!StringUtils.isNull(themeCard.getDynamicUrl())) {
                this.f.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(themeCard.getDynamicUrl())).setAutoPlayAnimations(true).build());
            } else {
                this.f.setImageURI(Uri.parse(themeCard.getCardImageUrlAndroid()));
            }
            if (!StringUtils.isNull(themeCard.getExclusiveNo()) && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.g.setText(themeCard.getExclusiveNo());
                WebPManager.setPureDrawable(this.h, R.drawable.icon_pure_zb_no, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                try {
                    this.g.setTypeface(ResourcesCompat.getFont(this.e.getPageActivity(), R.font.baidunumber_medium));
                } catch (Resources.NotFoundException e) {
                    BdLog.e(e);
                }
                rw4 d = rw4.d(this.g);
                d.z(R.dimen.T_X09);
                d.v(R.color.CAM_X0105);
                this.h.setAlpha(0.7f);
                this.g.setAlpha(0.7f);
            }
            this.f.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            this.f.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.f.setVisibility(8);
        this.i.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sx
    /* renamed from: m */
    public void a(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            l(threadData);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.j = z;
        }
    }
}
