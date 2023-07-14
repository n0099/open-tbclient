package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.UserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wu4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile wu4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public du4 a;
    public DialogInterface.OnDismissListener b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ wu4 c;

        public a(wu4 wu4Var, UserData userData, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu4Var, userData, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wu4Var;
            this.a = userData;
            this.b = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.a != null) {
                    this.c.a.a();
                }
                if (!TextUtils.isEmpty(this.a.getName_show()) && !TextUtils.isEmpty(this.a.getUserId())) {
                    String name_show = this.a.getName_show();
                    String userId = this.a.getUserId();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_CLICK);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.addParam("obj_param1", userId);
                    TiebaStatic.log(statisticItem);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.getPageActivity(), userId, name_show)));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu4 a;

        public b(wu4 wu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu4Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.b != null) {
                    this.a.b.onDismiss(dialogInterface);
                }
                this.a.a = null;
            }
        }
    }

    public wu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
    }

    public static wu4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                synchronized (wu4.class) {
                    if (c == null) {
                        c = new wu4();
                    }
                }
            }
            return c;
        }
        return (wu4) invokeV.objValue;
    }

    public void d() {
        du4 du4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (du4Var = this.a) != null && du4Var.isShowing()) {
            this.a.a();
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onDismissListener) == null) {
            this.b = onDismissListener;
        }
    }

    public void g(@NonNull TbPageContext tbPageContext, @NonNull Context context, @NonNull UserData userData, @NonNull BdTokenController.m mVar) {
        boolean z;
        boolean z2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, context, userData, mVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_param1", userData.getUserId());
            TiebaStatic.log(statisticItem);
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.content_tieba_uid_info, (ViewGroup) null, false);
            TextView textView = (TextView) viewGroup.findViewById(R.id.who_share_info);
            boolean z3 = true;
            textView.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.tieba_uid_share_info), mVar.a()));
            textView.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
            View findViewById = viewGroup.findViewById(R.id.left_divider);
            View findViewById2 = viewGroup.findViewById(R.id.right_divider);
            findViewById.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
            findViewById2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
            HeadImageView headImageView = (HeadImageView) viewGroup.findViewById(R.id.user_averter);
            headImageView.setDefaultResource(R.drawable.transparent_bg);
            headImageView.setGodIconWidth(R.dimen.tbds68);
            headImageView.setAutoChangeStyle(false);
            UtilHelper.showHeadImageViewBigV(headImageView, userData);
            headImageView.setIsRound(true);
            headImageView.N(userData.getAvater(), 25, false);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.user_name);
            textView2.setText(userData.getName_show());
            textView2.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0105));
            TextView textView3 = (TextView) viewGroup.findViewById(R.id.user_tieba_uid);
            textView3.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.tieba_uid_info), mVar.b()));
            textView3.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0109));
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.container_authentication);
            if (ListUtils.isEmpty(userData.getManagerForum()) && !userData.isNewGod()) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.M_H_X001);
                if (userData.isNewGod() && !ListUtils.isEmpty(userData.getManagerForum())) {
                    z = true;
                } else {
                    z = false;
                }
                if (userData.isNewGod()) {
                    TextView textView4 = new TextView(context);
                    textView4.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
                    textView4.setText(userData.getNewGodData().getFieldName() + jz5.a(userData.getNewGodData()));
                    textView4.setTextSize(0, (float) UtilHelper.getDimenPixelSize(R.dimen.T_X09));
                    linearLayout.addView(textView4);
                    textView4.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
                    SkinManager.setBackgroundShapeDrawable(textView4, R.dimen.tbds26, R.color.CAM_X0623, R.color.CAM_X0623, 0);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!ListUtils.isEmpty(userData.getManagerForum())) {
                    TextView textView5 = new TextView(context);
                    textView5.setPadding(dimenPixelSize, dimenPixelSize2, dimenPixelSize, dimenPixelSize2);
                    String desc = userData.getManagerForum().get(0).getDesc();
                    if (userData.getManagerForum().size() > 1) {
                        if (z) {
                            desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 6, "...");
                        }
                        format = String.format(TbadkCoreApplication.getInst().getString(R.string.multi_bazhu_sign), desc, Integer.valueOf(userData.getManagerForum().size()));
                    } else {
                        if (z) {
                            desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 8, "...");
                        }
                        format = String.format(TbadkCoreApplication.getInst().getString(R.string.single_bazhu_sign), desc);
                    }
                    textView5.setText(format);
                    textView5.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X09));
                    if (z2) {
                        View view2 = new View(context);
                        view2.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.M_W_X006), 1));
                        linearLayout.addView(view2);
                    }
                    linearLayout.addView(textView5);
                    textView5.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
                    SkinManager.setBackgroundShapeDrawable(textView5, R.dimen.tbds26, R.color.CAM_X0623, R.color.CAM_X0623, 0);
                }
                z3 = false;
            }
            TextView textView6 = (TextView) viewGroup.findViewById(R.id.user_simple_intro);
            String intro = userData.getIntro();
            if (TextUtils.isEmpty(userData.getIntro()) && z3) {
                intro = StringHelper.getBaAgeAutoYearAndMonth(userData.getTb_age());
            }
            textView6.setText(intro);
            if (linearLayout.getVisibility() == 0) {
                textView6.setMaxLines(1);
            } else {
                textView6.setMaxLines(2);
            }
            textView6.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0107));
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) viewGroup.findViewById(R.id.jump_user_detail_btn);
            hb5 hb5Var = new hb5();
            hb5Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
            tBSpecificationBtn.setTextSize(R.dimen.T_X05);
            tBSpecificationBtn.setConfig(hb5Var);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.browse_user_detail));
            tBSpecificationBtn.setOnClickListener(new a(this, userData, tbPageContext));
            this.a = new du4(tbPageContext);
            this.a.b(WebPManager.getMaskDrawable((int) R.drawable.mask_popup_background, false));
            this.a.c(viewGroup);
            this.a.setOnDismissListener(new b(this));
            this.a.d();
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
    }
}
