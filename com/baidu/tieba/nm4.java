package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.coreExtra.data.BazhuGradeData;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.tl4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class nm4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nm4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public vl4 a;
    public DialogInterface.OnDismissListener b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ nm4 c;

        public a(nm4 nm4Var, UserData userData, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nm4Var, userData, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = nm4Var;
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

    public nm4() {
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

    public static nm4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (nm4.class) {
                    if (c == null) {
                        c = new nm4();
                    }
                }
            }
            return c;
        }
        return (nm4) invokeV.objValue;
    }

    public void b() {
        vl4 vl4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (vl4Var = this.a) != null && vl4Var.isShowing()) {
            this.a.a();
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onDismissListener) == null) {
            this.b = onDismissListener;
        }
    }

    public void e(TbPageContext tbPageContext, Context context, UserData userData, tl4.m mVar) {
        boolean z;
        boolean z2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, context, userData, mVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_TIEBA_UID_SHARE_DIALOG_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.addParam("obj_param1", userData.getUserId());
            TiebaStatic.log(statisticItem);
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01f9, (ViewGroup) null, false);
            TextView textView = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092660);
            boolean z3 = true;
            textView.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f142b), mVar.a()));
            textView.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
            View findViewById = viewGroup.findViewById(R.id.obfuscated_res_0x7f0912c1);
            View findViewById2 = viewGroup.findViewById(R.id.obfuscated_res_0x7f091c36);
            findViewById.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
            findViewById2.setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0108));
            HeadImageView headImageView = (HeadImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f092476);
            headImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081252);
            headImageView.setGodIconWidth(R.dimen.tbds68);
            headImageView.setAutoChangeStyle(false);
            UtilHelper.showHeadImageViewBigV(headImageView, userData);
            headImageView.setIsRound(true);
            headImageView.L(userData.getAvater(), 25, false);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0924a1);
            textView2.setText(userData.getName_show());
            textView2.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0105));
            TextView textView3 = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0924c1);
            textView3.setText(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f142a), mVar.b()));
            textView3.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0109));
            LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0906dd);
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
                    textView4.setText(userData.getNewGodData().getFieldName() + ti5.a(userData.getNewGodData()));
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
                    String desc = ((BazhuGradeData) userData.getManagerForum().get(0)).getDesc();
                    if (userData.getManagerForum().size() > 1) {
                        if (z) {
                            desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 6, StringHelper.STRING_MORE);
                        }
                        format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0b4b), desc, Integer.valueOf(userData.getManagerForum().size()));
                    } else {
                        if (z) {
                            desc = StringHelper.cutChineseAndEnglishWithSuffix(desc, 8, StringHelper.STRING_MORE);
                        }
                        format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11d3), desc);
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
            TextView textView6 = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0924bb);
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
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) viewGroup.findViewById(R.id.obfuscated_res_0x7f09102b);
            ty4 ty4Var = new ty4();
            ty4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
            tBSpecificationBtn.setTextSize(R.dimen.T_X05);
            tBSpecificationBtn.setConfig(ty4Var);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f034a));
            tBSpecificationBtn.setOnClickListener(new a(this, userData, tbPageContext));
            this.a = new vl4(tbPageContext);
            this.a.b(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080d65, false));
            this.a.c(viewGroup);
            this.a.setOnDismissListener(this.b);
            this.a.d();
            TbSingleton.getInstance();
            TbSingleton.setExceptInsertAdDiaShow(true);
        }
    }
}
