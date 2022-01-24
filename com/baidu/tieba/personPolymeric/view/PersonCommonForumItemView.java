package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.t0.y2.e.f;
import c.a.t0.z2.c;
import c.a.t0.z2.d;
import c.a.t0.z2.e;
import c.a.t0.z2.g;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PersonCommonForumItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BarImageView avatar;

    /* renamed from: e  reason: collision with root package name */
    public int f47306e;

    /* renamed from: f  reason: collision with root package name */
    public Context f47307f;
    public TextView forumName;

    /* renamed from: g  reason: collision with root package name */
    public f f47308g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f47309h;
    public TextView postThread;
    public TextView threadNumber;
    public TextView threadStr;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonCommonForumItemView f47310e;

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
            this.f47310e = personCommonForumItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f47310e.f47308g == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "6"));
            TiebaStatic.log(new StatisticItem("c11594"));
            String str = this.f47310e.f47308g.f25703f;
            if (m.isForumName(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f47310e.f47307f).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(8)));
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
        this.f47306e = 3;
        this.f47307f = context;
        LayoutInflater.from(getContext()).inflate(e.person_info_common_forum_item, (ViewGroup) this, true);
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.avatar = (BarImageView) findViewById(d.forum_avatar);
            this.forumName = (TextView) findViewById(d.forum_name);
            this.postThread = (TextView) findViewById(d.forum_post_thread);
            this.threadNumber = (TextView) findViewById(d.forum_thread_num);
            this.threadStr = (TextView) findViewById(d.forum_thread_str);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47309h = new a(this);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f47306e != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setViewTextColor(this.forumName, c.a.t0.z2.a.CAM_X0105);
                SkinManager.setViewTextColor(this.postThread, c.a.t0.z2.a.CAM_X0109);
                SkinManager.setViewTextColor(this.threadStr, c.a.t0.z2.a.CAM_X0109);
                SkinManager.setViewTextColor(this.threadNumber, c.a.t0.z2.a.CAM_X0302);
                SkinManager.setBackgroundResource(this, c.person_common_forum_item_bg);
            }
            this.f47306e = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f47308g = fVar;
            this.avatar.startLoad(fVar.f25704g, 10, false);
            TextView textView = this.forumName;
            textView.setText(StringHelper.cutForumNameWithSuffix(fVar.f25703f, 7, "...") + this.f47307f.getString(g.forum));
            this.threadNumber.setText(StringHelper.numberUniformFormat((long) fVar.f25705h));
            this.postThread.setText(String.format(this.f47307f.getString(g.person_has_posted), StringHelper.getUserDescByGender(fVar.f25706i)));
            if (getRootView() != null) {
                getRootView().setOnClickListener(this.f47309h);
            }
            onChangeSkinType();
        }
    }
}
