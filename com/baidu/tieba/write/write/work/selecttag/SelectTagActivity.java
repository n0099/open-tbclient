package com.baidu.tieba.write.write.work.selecttag;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
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
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassHttpResMessage;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ef8;
import com.repackage.ky8;
import com.repackage.s85;
import com.repackage.wa;
import com.repackage.wq4;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectTagActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout contentView;
    public boolean isKeybordVisible;
    public wa mGetSelectTagListener;
    public int mMaxSelectTagNum;
    public ky8 mSelectClassTagsModel;
    public List<String> mShowSelectTagData;
    public VideoCategoryClassData mVideoCategoryClassData;
    public SelectTagListView selectTagListView;

    /* loaded from: classes4.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagActivity a;

        /* renamed from: com.baidu.tieba.write.write.work.selecttag.SelectTagActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0242a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0242a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.mSelectClassTagsModel == null) {
                    return;
                }
                this.a.a.mSelectClassTagsModel.f();
                SelectTagActivity selectTagActivity = this.a.a;
                selectTagActivity.hideNetRefreshView(selectTagActivity.contentView);
                SelectTagActivity selectTagActivity2 = this.a.a;
                selectTagActivity2.showLoadingView(selectTagActivity2.contentView);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectTagActivity selectTagActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectTagActivity selectTagActivity = this.a;
                selectTagActivity.showNetRefreshView(selectTagActivity.contentView, null, this.a.getString(R.string.obfuscated_res_0x7f0f0483), null, false, new View$OnClickListenerC0242a(this));
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

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectTagActivity a;

        public b(SelectTagActivity selectTagActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectTagActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectTagActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.selectTagListView.w()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921604, this.a.selectTagListView.getHadSelectTagList()));
                this.a.close();
            }
        }
    }

    public SelectTagActivity() {
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
    public s85 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            this.contentView = linearLayout;
            if (this.selectTagListView == null) {
                this.selectTagListView = new SelectTagListView(getPageContext(), linearLayout, navigationBar);
            }
            this.selectTagListView.c.setOnClickListener(new b(this));
            return this.selectTagListView;
        }
        return (s85) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public int getTranViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getDimenPixelSize(R.dimen.tbds153) : invokeV.intValue;
    }

    public boolean isKeybordVisible() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isKeybordVisible : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.selectTagListView.w()) {
                wq4.d(this.selectTagListView.c).x(R.color.CAM_X0302);
            } else {
                this.selectTagListView.c.setTextColor(ef8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
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
            this.mSelectClassTagsModel = new ky8(getUniqueId());
            this.selectTagListView.d = findViewById(R.id.obfuscated_res_0x7f091dd1);
            this.selectTagListView.l();
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
            int i = this.mMaxSelectTagNum;
            if (size > i) {
                this.mShowSelectTagData = this.mShowSelectTagData.subList(0, i);
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
