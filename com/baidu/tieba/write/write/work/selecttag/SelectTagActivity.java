package com.baidu.tieba.write.write.work.selecttag;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import c.a.s0.s.u.c;
import c.a.t0.o4.d;
import c.a.t0.o4.e;
import c.a.t0.o4.g;
import c.a.t0.o4.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectTagActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassHttpResMessage;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class SelectTagActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout contentView;
    public boolean isKeybordVisible;
    public c.a.d.c.g.a mGetSelectTagListener;
    public int mMaxSelectTagNum;
    public c.a.t0.o4.e0.p.v.a mSelectClassTagsModel;
    public List<String> mShowSelectTagData;
    public VideoCategoryClassData mVideoCategoryClassData;
    public SelectTagListView selectTagListView;

    /* loaded from: classes13.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagActivity a;

        /* renamed from: com.baidu.tieba.write.write.work.selecttag.SelectTagActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class View$OnClickListenerC1951a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f51959e;

            public View$OnClickListenerC1951a(a aVar) {
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
                this.f51959e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51959e.a.mSelectClassTagsModel == null) {
                    return;
                }
                this.f51959e.a.mSelectClassTagsModel.f();
                SelectTagActivity selectTagActivity = this.f51959e.a;
                selectTagActivity.hideNetRefreshView(selectTagActivity.contentView);
                SelectTagActivity selectTagActivity2 = this.f51959e.a;
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
            this.a = selectTagActivity;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectTagActivity selectTagActivity = this.a;
                selectTagActivity.showNetRefreshView(selectTagActivity.contentView, null, this.a.getString(j.data_load_fail), null, false, new View$OnClickListenerC1951a(this));
                return;
            }
            if (responsedMessage instanceof GetSelectClassHttpResMessage) {
                this.a.mSelectClassTagsModel.i(((GetSelectClassHttpResMessage) responsedMessage).getTags().get(0));
            } else if (responsedMessage instanceof GetSelectClassSocketResMessage) {
                this.a.mSelectClassTagsModel.i(((GetSelectClassSocketResMessage) responsedMessage).getTags().get(0));
            }
            this.a.updateTagData();
            SelectTagActivity selectTagActivity2 = this.a;
            selectTagActivity2.hideLoadingView(selectTagActivity2.contentView);
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectTagActivity f51960e;

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
            this.f51960e = selectTagActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f51960e.selectTagListView.isCanSelectFinish()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921604, this.f51960e.selectTagListView.getHadSelectTagList()));
                this.f51960e.close();
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
        this.mVideoCategoryClassData = new VideoCategoryClassData();
        this.mGetSelectTagListener = new a(this, CmdConfigHttp.CMD_GET_SELECT_CLASS, 309713);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTagData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.mSelectClassTagsModel.d() == null) {
            return;
        }
        this.selectTagListView.setRecommendTagList(this.mSelectClassTagsModel.d());
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public c.a.s0.y0.b getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
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
        return (c.a.s0.y0.b) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public int getTranViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getDimenPixelSize(e.tbds153) : invokeV.intValue;
    }

    public boolean isKeybordVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isKeybordVisible : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.selectTagListView.isCanSelectFinish()) {
                c.d(this.selectTagListView.mFinishSelectTag).x(d.CAM_X0302);
            } else {
                this.selectTagListView.mFinishSelectTag.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(d.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mSelectClassTagsModel = new c.a.t0.o4.e0.p.v.a(getUniqueId());
            this.selectTagListView.mRootView = findViewById(g.suspend_root_view);
            this.selectTagListView.hideSoftKeyAndCursor();
            this.mGetSelectTagListener.getHttpMessageListener().setSelfListener(true);
            this.mGetSelectTagListener.getSocketMessageListener().setSelfListener(true);
            registerListener(this.mGetSelectTagListener);
            this.mShowSelectTagData = getIntent().getStringArrayListExtra(SelectTagActivityConfig.SELECT_INIT_TAG);
            this.mVideoCategoryClassData.setFirstClass(getIntent().getStringExtra(SelectTagActivityConfig.SELECT_INIT_FIRST_CLASS));
            this.mVideoCategoryClassData.setSecondClass(getIntent().getStringExtra(SelectTagActivityConfig.SELECT_INIT_SECOND_CLASS));
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.isKeybordVisible = z;
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }
}
