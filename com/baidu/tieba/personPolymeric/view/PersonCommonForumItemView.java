package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.pt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public int f;
    public Context g;
    public pt9 h;
    public View.OnClickListener i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCommonForumItemView a;

        public a(PersonCommonForumItemView personCommonForumItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCommonForumItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCommonForumItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.h != null) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "6"));
                TiebaStatic.log(new StatisticItem("c11594"));
                String str = this.a.h.b;
                if (ad.isForumName(str)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.g).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonCommonForumItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 3;
        this.g = context;
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e6, (ViewGroup) this, true);
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = (BarImageView) findViewById(R.id.forum_avatar);
            this.b = (TextView) findViewById(R.id.forum_name);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090c15);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090c39);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090c3a);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = new a(this);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
            }
            this.f = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void setData(pt9 pt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pt9Var) == null) {
            this.h = pt9Var;
            this.a.startLoad(pt9Var.c, 10, false);
            TextView textView = this.b;
            textView.setText(StringHelper.cutForumNameWithSuffix(pt9Var.b, 7, "...") + this.g.getString(R.string.obfuscated_res_0x7f0f0785));
            this.d.setText(StringHelper.numberUniformFormat((long) pt9Var.d));
            this.c.setText(String.format(this.g.getString(R.string.obfuscated_res_0x7f0f10a2), StringHelper.getUserDescByGender(pt9Var.e)));
            if (getRootView() != null) {
                getRootView().setOnClickListener(this.i);
            }
            e();
        }
    }
}
