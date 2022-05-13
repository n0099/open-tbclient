package com.baidu.tieba.write.write.work.classdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.SelectClassDialogActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
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
import com.repackage.bs4;
import com.repackage.di8;
import com.repackage.gs4;
import com.repackage.h19;
import com.repackage.ki;
import com.repackage.og5;
import com.repackage.wa;
import com.repackage.y95;
/* loaded from: classes4.dex */
public class SelectClassDialogActivity extends SuspendedActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canDone;
    public LinearLayout contentView;
    public int currentOption1;
    public int currentOption2;
    public String initFirstOption;
    public int initOption1;
    public int initOption2;
    public String initSecondOption;
    public boolean isSelectedTags;
    public TextView mDoneText;
    public wa mGetSelectClassListener;
    public h19 selectClassDialogModel;
    public SelectClassDialogView selectClassDialogView;

    /* loaded from: classes4.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        /* renamed from: com.baidu.tieba.write.write.work.classdialog.SelectClassDialogActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0240a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0240a(a aVar) {
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
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.selectClassDialogModel != null && ki.z()) {
                    this.a.a.selectClassDialogModel.e();
                    SelectClassDialogActivity selectClassDialogActivity = this.a.a;
                    selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.contentView);
                    SelectClassDialogActivity selectClassDialogActivity2 = this.a.a;
                    selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectClassDialogActivity selectClassDialogActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = selectClassDialogActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectClassDialogActivity selectClassDialogActivity = this.a;
                selectClassDialogActivity.showNetRefreshView(selectClassDialogActivity.contentView, null, this.a.getString(R.string.obfuscated_res_0x7f0f047c), null, true, new View$OnClickListenerC0240a(this));
                this.a.setNetRefreshViewEmotionMarginTop(UtilHelper.getDimenPixelSize(R.dimen.tbds0));
                return;
            }
            if (responsedMessage instanceof GetSelectClassHttpResMessage) {
                GetSelectClassHttpResMessage getSelectClassHttpResMessage = (GetSelectClassHttpResMessage) responsedMessage;
                this.a.selectClassDialogModel.g(getSelectClassHttpResMessage.getFirstClass());
                this.a.selectClassDialogModel.h(getSelectClassHttpResMessage.getSecondClass());
            } else if (responsedMessage instanceof GetSelectClassSocketResMessage) {
                GetSelectClassSocketResMessage getSelectClassSocketResMessage = (GetSelectClassSocketResMessage) responsedMessage;
                this.a.selectClassDialogModel.g(getSelectClassSocketResMessage.getFirstClass());
                this.a.selectClassDialogModel.h(getSelectClassSocketResMessage.getSecondClass());
            }
            this.a.updateClassData();
            SelectClassDialogActivity selectClassDialogActivity2 = this.a;
            selectClassDialogActivity2.hideLoadingView(selectClassDialogActivity2.contentView);
            SelectClassDialogActivity selectClassDialogActivity3 = this.a;
            selectClassDialogActivity3.initOption1 = selectClassDialogActivity3.selectClassDialogModel.b().indexOf(this.a.initFirstOption);
            if (this.a.initOption1 <= 0 || this.a.initOption1 >= this.a.selectClassDialogModel.c().size()) {
                this.a.initOption1 = 0;
                this.a.initOption2 = 0;
                return;
            }
            SelectClassDialogActivity selectClassDialogActivity4 = this.a;
            selectClassDialogActivity4.initOption2 = selectClassDialogActivity4.selectClassDialogModel.c().get(this.a.initOption1).indexOf(this.a.initSecondOption);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        public b(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.selectClassDialogModel == null) {
                return;
            }
            this.a.selectClassDialogModel.e();
            SelectClassDialogActivity selectClassDialogActivity = this.a;
            selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.contentView);
            SelectClassDialogActivity selectClassDialogActivity2 = this.a;
            selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements og5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        public c(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // com.repackage.og5
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                i = (i < 0 || i >= this.a.selectClassDialogModel.b().size()) ? 0 : 0;
                i2 = (i2 < 0 || i2 >= this.a.selectClassDialogModel.c().get(i).size()) ? 0 : 0;
                String str = this.a.selectClassDialogModel.b().get(i);
                String str2 = this.a.selectClassDialogModel.c().get(i).get(i2);
                if ((i != 0 || i2 != 0) && (!str.equals(this.a.initFirstOption) || !str2.equals(this.a.initSecondOption))) {
                    this.a.canDone = true;
                    gs4.d(this.a.mDoneText).x(R.color.CAM_X0302);
                } else {
                    this.a.canDone = false;
                    this.a.mDoneText.setTextColor(di8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                    if (str.equals(this.a.initFirstOption) && str2.equals(this.a.initSecondOption)) {
                        this.a.initFirstOption = "";
                        this.a.initSecondOption = "";
                        this.a.canDone = true;
                        gs4.d(this.a.mDoneText).x(R.color.CAM_X0302);
                    }
                }
                this.a.currentOption1 = i;
                this.a.currentOption2 = i2;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.a.a.selectClassDialogModel.a(this.a.a.currentOption1, this.a.a.currentOption2)));
                    this.a.a.close();
                }
            }
        }

        public d(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.canDone) {
                if (this.a.isSelectedTags && this.a.initOption1 > 0 && (this.a.initOption1 != this.a.currentOption1 || this.a.initOption2 != this.a.currentOption2)) {
                    bs4 bs4Var = new bs4(this.a.getPageContext().getPageActivity());
                    bs4Var.v(R.string.obfuscated_res_0x7f0f10de);
                    bs4Var.l(R.string.obfuscated_res_0x7f0f10dd);
                    bs4Var.n(true);
                    bs4Var.r(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04de, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0428, TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
                    bs4Var.g();
                    bs4Var.i(false);
                    bs4Var.y();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.a.selectClassDialogModel.a(this.a.currentOption1, this.a.currentOption2)));
                this.a.close();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        public e(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.close();
            }
        }
    }

    public SelectClassDialogActivity() {
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
        this.canDone = false;
        this.mGetSelectClassListener = new a(this, CmdConfigHttp.CMD_GET_SELECT_CLASS, 309713);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClassData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.selectClassDialogView.setPicker(this.selectClassDialogModel.b(), this.selectClassDialogModel.c());
            int indexOf = this.selectClassDialogModel.b().indexOf(this.initFirstOption);
            indexOf = (indexOf < 0 || indexOf >= this.selectClassDialogModel.b().size()) ? 0 : 0;
            int indexOf2 = this.selectClassDialogModel.c().get(indexOf).indexOf(this.initSecondOption);
            this.selectClassDialogView.setCurrentItems(indexOf, indexOf2 != -1 ? indexOf2 : 0);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public y95 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            this.contentView = linearLayout;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f10df));
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f04ed));
            this.mDoneText = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            SelectClassDialogView selectClassDialogView = new SelectClassDialogView(linearLayout, this);
            this.selectClassDialogView = selectClassDialogView;
            return selectClassDialogView;
        }
        return (y95) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public int getTranViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? UtilHelper.getScreenHeight(this) - UtilHelper.getDimenPixelSize(R.dimen.tbds999) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public View.OnClickListener getTranViewOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new e(this) : (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.canDone) {
                gs4.d(this.mDoneText).x(R.color.CAM_X0302);
            } else {
                this.mDoneText.setTextColor(di8.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.selectClassDialogModel = new h19(getUniqueId());
            this.mGetSelectClassListener.getHttpMessageListener().setSelfListener(true);
            this.mGetSelectClassListener.getSocketMessageListener().setSelfListener(true);
            registerListener(this.mGetSelectClassListener);
            if (ki.z()) {
                this.selectClassDialogModel.e();
                showLoadingView(this.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
            } else {
                showNetRefreshView(this.contentView, null, getString(R.string.obfuscated_res_0x7f0f047c), null, true, new b(this));
                setNetRefreshViewEmotionMarginTop(UtilHelper.getDimenPixelSize(R.dimen.tbds0));
            }
            this.initFirstOption = getIntent().getStringExtra(SelectClassDialogActivityConfig.SELECT_INIT_FIRST_OPTION);
            this.initSecondOption = getIntent().getStringExtra(SelectClassDialogActivityConfig.SELECT_INIT_SECOND_OPTION);
            this.isSelectedTags = getIntent().getBooleanExtra(SelectClassDialogActivityConfig.IS_SELECTED_TAGS, false);
            this.selectClassDialogView.setOnOptionsSelectChangeListener(new c(this));
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void requestData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }
}
