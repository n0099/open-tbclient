package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.p0.b3.e.f;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35520b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35521c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35522d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35523e;

    /* renamed from: f  reason: collision with root package name */
    public int f35524f;

    /* renamed from: g  reason: collision with root package name */
    public Context f35525g;

    /* renamed from: h  reason: collision with root package name */
    public f f35526h;
    public View.OnClickListener i;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.a.f35526h == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "6"));
            TiebaStatic.log(new StatisticItem("c11594"));
            String str = this.a.f35526h.f12714b;
            if (m.isForumName(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.f35525g).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
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
        this.f35524f = 3;
        this.f35525g = context;
        LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d06c2, (ViewGroup) this, true);
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = (BarImageView) findViewById(R.id.obfuscated_res_0x7f090a1e);
            this.f35520b = (TextView) findViewById(R.id.obfuscated_res_0x7f090a67);
            this.f35521c = (TextView) findViewById(R.id.obfuscated_res_0x7f090a6a);
            this.f35522d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a91);
            this.f35523e = (TextView) findViewById(R.id.obfuscated_res_0x7f090a92);
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
            if (this.f35524f != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.f35520b, (int) R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f35521c, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f35523e, (int) R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.f35522d, (int) R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
            }
            this.f35524f = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f35526h = fVar;
            this.a.J(fVar.f12715c, 10, false);
            TextView textView = this.f35520b;
            textView.setText(StringHelper.cutForumNameWithSuffix(fVar.f12714b, 7, StringHelper.STRING_MORE) + this.f35525g.getString(R.string.obfuscated_res_0x7f0f063c));
            this.f35522d.setText(StringHelper.numberUniformFormat((long) fVar.f12716d));
            this.f35521c.setText(String.format(this.f35525g.getString(R.string.obfuscated_res_0x7f0f0e13), StringHelper.getUserDescByGender(fVar.f12717e)));
            if (getRootView() != null) {
                getRootView().setOnClickListener(this.i);
            }
            e();
        }
    }
}
