package com.baidu.tieba.write.write.work.selecttag;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import c.a.o0.s.u.c;
import c.a.o0.u.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.SelectTagActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassHttpResMessage;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class SelectTagActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout contentView;
    public c.a.e.c.g.a mGetSelectTagListener;
    public int mMaxSelectTagNum;
    public c.a.p0.b4.u.q.a.a mSelectClassTagsModel;
    public List<String> mShowSelectTagData;
    public n mVideoCategoryClassData;
    public SelectTagListView selectTagListView;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectTagActivity f58826a;

        /* renamed from: com.baidu.tieba.write.write.work.selecttag.SelectTagActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1804a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f58827e;

            public View$OnClickListenerC1804a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58827e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58827e.f58826a.mSelectClassTagsModel == null) {
                    return;
                }
                this.f58827e.f58826a.mSelectClassTagsModel.f();
                SelectTagActivity selectTagActivity = this.f58827e.f58826a;
                selectTagActivity.hideNetRefreshView(selectTagActivity.contentView);
                SelectTagActivity selectTagActivity2 = this.f58827e.f58826a;
                selectTagActivity2.showLoadingView(selectTagActivity2.contentView);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectTagActivity selectTagActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58826a = selectTagActivity;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectTagActivity selectTagActivity = this.f58826a;
                selectTagActivity.showNetRefreshView(selectTagActivity.contentView, null, this.f58826a.getString(R.string.data_load_fail), null, false, new View$OnClickListenerC1804a(this));
                return;
            }
            if (responsedMessage instanceof GetSelectClassHttpResMessage) {
                this.f58826a.mSelectClassTagsModel.i(((GetSelectClassHttpResMessage) responsedMessage).getTags().get(0));
            } else if (responsedMessage instanceof GetSelectClassSocketResMessage) {
                this.f58826a.mSelectClassTagsModel.i(((GetSelectClassSocketResMessage) responsedMessage).getTags().get(0));
            }
            this.f58826a.updateTagData();
            SelectTagActivity selectTagActivity2 = this.f58826a;
            selectTagActivity2.hideLoadingView(selectTagActivity2.contentView);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagActivity f58828e;

        public b(SelectTagActivity selectTagActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58828e = selectTagActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f58828e.selectTagListView.isCanSelectFinish()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921604, this.f58828e.selectTagListView.getHadSelectTagList()));
                this.f58828e.close();
            }
        }
    }

    public SelectTagActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMaxSelectTagNum = 6;
        this.mVideoCategoryClassData = new n();
        this.mGetSelectTagListener = new a(this, CmdConfigHttp.CMD_GET_SELECT_CLASS, 309713);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTagData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.mSelectClassTagsModel.d() == null) {
            return;
        }
        this.selectTagListView.setRecommendTagList(this.mSelectClassTagsModel.d());
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public c.a.o0.v0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            this.contentView = linearLayout;
            if (this.selectTagListView == null) {
                this.selectTagListView = new SelectTagListView(getPageContext(), linearLayout, navigationBar);
            }
            this.selectTagListView.mFinishSelectTag.setOnClickListener(new b(this));
            return this.selectTagListView;
        }
        return (c.a.o0.v0.a) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public int getTranViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds153) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.selectTagListView.isCanSelectFinish()) {
                c.d(this.selectTagListView.mFinishSelectTag).v(R.color.CAM_X0302);
            } else {
                this.selectTagListView.mFinishSelectTag.setTextColor(c.a.p0.i3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.mSelectClassTagsModel = new c.a.p0.b4.u.q.a.a(getUniqueId());
            this.selectTagListView.mRootView = findViewById(R.id.suspend_root_view);
            this.selectTagListView.hideSoftKeyAndCursor();
            this.mGetSelectTagListener.getHttpMessageListener().setSelfListener(true);
            this.mGetSelectTagListener.getSocketMessageListener().setSelfListener(true);
            registerListener(this.mGetSelectTagListener);
            this.mShowSelectTagData = getIntent().getStringArrayListExtra(SelectTagActivityConfig.SELECT_INIT_TAG);
            this.mVideoCategoryClassData.d(getIntent().getStringExtra(SelectTagActivityConfig.SELECT_INIT_FIRST_CLASS));
            this.mVideoCategoryClassData.e(getIntent().getStringExtra(SelectTagActivityConfig.SELECT_INIT_SECOND_CLASS));
            this.mSelectClassTagsModel.i(this.mVideoCategoryClassData);
            this.mSelectClassTagsModel.f();
            List<String> list = this.mShowSelectTagData;
            if (list == null) {
                return;
            }
            int size = list.size();
            int i2 = this.mMaxSelectTagNum;
            if (size > i2) {
                this.mShowSelectTagData = this.mShowSelectTagData.subList(0, i2);
            }
            this.selectTagListView.setHadSelectTagList(this.mShowSelectTagData);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }
}
