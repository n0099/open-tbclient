package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.r0.p2.e.f;
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
/* loaded from: classes7.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView avatar;

    /* renamed from: e  reason: collision with root package name */
    public int f56116e;

    /* renamed from: f  reason: collision with root package name */
    public Context f56117f;
    public TextView forumName;

    /* renamed from: g  reason: collision with root package name */
    public f f56118g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56119h;
    public TextView postThread;
    public TextView threadNumber;
    public TextView threadStr;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonCommonForumItemView f56120e;

        public a(PersonCommonForumItemView personCommonForumItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCommonForumItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56120e = personCommonForumItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f56120e.f56118g == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "6"));
            TiebaStatic.log(new StatisticItem("c11594"));
            String str = this.f56120e.f56118g.f23404f;
            if (k.isForumName(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f56120e.f56117f).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56116e = 3;
        this.f56117f = context;
        LayoutInflater.from(getContext()).inflate(R.layout.person_info_common_forum_item, (ViewGroup) this, true);
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.avatar = (BarImageView) findViewById(R.id.forum_avatar);
            this.forumName = (TextView) findViewById(R.id.forum_name);
            this.postThread = (TextView) findViewById(R.id.forum_post_thread);
            this.threadNumber = (TextView) findViewById(R.id.forum_thread_num);
            this.threadStr = (TextView) findViewById(R.id.forum_thread_str);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f56119h = new a(this);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f56116e != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.forumName, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.postThread, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.threadStr, R.color.CAM_X0109);
                SkinManager.setViewTextColor(this.threadNumber, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this, R.drawable.person_common_forum_item_bg);
            }
            this.f56116e = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f56118g = fVar;
            this.avatar.startLoad(fVar.f23405g, 10, false);
            TextView textView = this.forumName;
            textView.setText(StringHelper.cutForumNameWithSuffix(fVar.f23404f, 7, "...") + this.f56117f.getString(R.string.forum));
            this.threadNumber.setText(StringHelper.numberUniformFormat((long) fVar.f23406h));
            this.postThread.setText(String.format(this.f56117f.getString(R.string.person_has_posted), StringHelper.getUserDescByGender(fVar.f23407i)));
            if (getRootView() != null) {
                getRootView().setOnClickListener(this.f56119h);
            }
            onChangeSkinType();
        }
    }
}
