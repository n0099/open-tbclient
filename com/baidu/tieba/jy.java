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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes6.dex */
public class jy extends yw implements qx<ThreadData> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public SimpleDraweeView b;
    public TextView c;
    public ImageView d;
    public FrameLayout e;
    public boolean f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ThemeCardInUserData a;
        public final /* synthetic */ jy b;

        public a(jy jyVar, ThemeCardInUserData themeCardInUserData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jyVar, themeCardInUserData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jyVar;
            this.a = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String jumpUrl = this.a.getJumpUrl();
                if (!StringUtils.isNull(jumpUrl)) {
                    UrlManager.getInstance().dealOneLink(this.b.a, new String[]{wca.a(jumpUrl, "0", "", String.valueOf(this.a.getCardId()))});
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(this.b.a.getPageActivity(), this.a.getCardId())));
            }
        }
    }

    public jy(TbPageContext tbPageContext) {
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
        this.f = true;
        this.a = tbPageContext;
        setInsertIndex(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070386), BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0703ec));
        layoutParams.addRule(11);
        layoutParams.rightMargin = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds30);
        setLayoutParams(layoutParams);
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(tbPageContext.getPageActivity());
        this.b = simpleDraweeView;
        simpleDraweeView.setContentDescription("个性卡片");
        FrameLayout frameLayout = new FrameLayout(tbPageContext.getContext());
        this.e = frameLayout;
        frameLayout.addView(this.b);
        ImageView imageView = new ImageView(tbPageContext.getPageActivity());
        this.d = imageView;
        imageView.setContentDescription("个性卡片ID前缀");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f070215), BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701b2));
        layoutParams2.gravity = 51;
        layoutParams2.topMargin = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds13);
        this.d.setLayoutParams(layoutParams2);
        this.e.addView(this.d);
        TextView textView = new TextView(tbPageContext.getContext());
        this.c = textView;
        textView.setContentDescription("个性卡片ID");
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 83;
        layoutParams3.leftMargin = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.M_W_X001);
        layoutParams3.bottomMargin = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds3);
        this.c.setLayoutParams(layoutParams3);
        this.e.addView(this.c);
        setDecorView(this.e);
    }

    public void b(ThreadData threadData) {
        MetaData author;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, threadData) != null) || threadData == null || this.b == null || (author = threadData.getAuthor()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = author.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !threadData.isHeadLinePost) {
            if (this.f && (this.b.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams.rightMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds106);
                this.b.setLayoutParams(layoutParams);
            }
            this.b.setVisibility(0);
            this.b.setImageDrawable(null);
            if (!StringUtils.isNull(themeCard.getDynamicUrl())) {
                this.b.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse(themeCard.getDynamicUrl())).setAutoPlayAnimations(true).build());
            } else {
                this.b.setImageURI(Uri.parse(themeCard.getCardImageUrlAndroid()));
            }
            if (!StringUtils.isNull(themeCard.getExclusiveNo()) && !StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.c.setText(themeCard.getExclusiveNo());
                WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_zb_no, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
                try {
                    this.c.setTypeface(ResourcesCompat.getFont(this.a.getPageActivity(), R.font.baidunumber_medium));
                } catch (Resources.NotFoundException e) {
                    BdLog.e(e);
                }
                EMManager.from(this.c).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0105);
                this.d.setAlpha(0.7f);
                this.c.setAlpha(0.7f);
            }
            this.b.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            this.b.setOnClickListener(new a(this, themeCard));
            return;
        }
        this.b.setVisibility(8);
        this.e.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qx
    /* renamed from: c */
    public void onBindDataToView(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            b(threadData);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f = z;
        }
    }
}
