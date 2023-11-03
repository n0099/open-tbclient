package com.baidu.tieba.personCenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SmartAppBrowseHistoryActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.tieba.b4a;
import com.baidu.tieba.c4a;
import com.baidu.tieba.q3a;
import com.baidu.tieba.qd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCenterSmartAppItemView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public TextView b;
    public ImageView c;
    public q3a d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonCenterSmartAppItemView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCenterSmartAppItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07eb, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.obfuscated_res_0x7f091284);
        this.a = headImageView;
        headImageView.setIsRound(true);
        this.a.setDefaultResource(R.color.CAM_X0204);
        this.a.setPlaceHolder(1);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0927d9);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0916f2);
        c();
    }

    public void a(q3a q3aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, q3aVar) != null) || q3aVar == null) {
            return;
        }
        this.d = q3aVar;
        this.c.setVisibility(8);
        if (q3aVar instanceof c4a) {
            c4a c4aVar = (c4a) q3aVar;
            this.a.startLoad(c4aVar.c(), 10, false, false);
            String g = c4aVar.g();
            if (!qd.isEmpty(g)) {
                this.b.setText(UtilHelper.getFixedText(g, 5));
            } else {
                this.b.setText(R.string.intelligent_smart_app);
            }
            if (q3aVar.getType() == 1) {
                SkinManager.setImageResource(this.c, R.drawable.icon_personal_recommend);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            setOnClickListener(this);
        } else if (q3aVar instanceof b4a) {
            SkinManager.setImageResource(this.a, R.drawable.icon_personal_more);
            this.b.setText(R.string.obfuscated_res_0x7f0f0cd1);
            setOnClickListener(this);
        }
    }

    public final TbPageContext b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context instanceof BaseActivity) {
                return ((BaseActivity) context).getPageContext();
            }
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            q3a q3aVar = this.d;
            if (q3aVar instanceof c4a) {
                c4a c4aVar = (c4a) q3aVar;
                if (!TbAiappsLaunchUtil.launch(c4aVar.b(), c4aVar.f(), "1191000600000000", c4aVar.e())) {
                    if (qd.isEmpty(c4aVar.d())) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{c4aVar.d()});
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("obj_source", "personal_center");
                statisticItem.param("obj_id", c4aVar.a().longValue());
                statisticItem.param("obj_name", c4aVar.g());
                statisticItem.param("obj_param1", c4aVar.e().intValue());
                TiebaStatic.log(statisticItem);
            } else if (q3aVar instanceof b4a) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SmartAppBrowseHistoryActivityConfig(getContext())));
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_MORE_HISTORY_RECORD_CLICK);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
                        SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                    }
                } else {
                    SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
                    SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                }
            } else {
                SkinManager.setBackgroundColor(this, R.color.cp_bg_line_d_alpha50);
                SkinManager.setViewTextColor(this.b, (int) R.color.cp_cont_b_alpha50);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }
}
