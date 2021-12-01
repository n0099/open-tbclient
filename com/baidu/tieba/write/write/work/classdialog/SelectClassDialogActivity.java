package com.baidu.tieba.write.write.work.classdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.j;
import c.a.q0.s.s.l;
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
/* loaded from: classes11.dex */
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
    public c.a.d.c.g.a mGetSelectClassListener;
    public c.a.r0.l4.u.p.v.a selectClassDialogModel;
    public SelectClassDialogView selectClassDialogView;

    /* loaded from: classes11.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectClassDialogActivity a;

        /* renamed from: com.baidu.tieba.write.write.work.classdialog.SelectClassDialogActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class View$OnClickListenerC1884a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f51138e;

            public View$OnClickListenerC1884a(a aVar) {
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
                this.f51138e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f51138e.a.selectClassDialogModel != null && j.z()) {
                    this.f51138e.a.selectClassDialogModel.e();
                    SelectClassDialogActivity selectClassDialogActivity = this.f51138e.a;
                    selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.contentView);
                    SelectClassDialogActivity selectClassDialogActivity2 = this.f51138e.a;
                    selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectClassDialogActivity selectClassDialogActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = selectClassDialogActivity;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectClassDialogActivity selectClassDialogActivity = this.a;
                selectClassDialogActivity.showNetRefreshView(selectClassDialogActivity.contentView, null, this.a.getString(R.string.data_load_fail), null, true, new View$OnClickListenerC1884a(this));
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

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f51139e;

        public b(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51139e = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f51139e.selectClassDialogModel == null) {
                return;
            }
            this.f51139e.selectClassDialogModel.e();
            SelectClassDialogActivity selectClassDialogActivity = this.f51139e;
            selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.contentView);
            SelectClassDialogActivity selectClassDialogActivity2 = this.f51139e;
            selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
        }
    }

    /* loaded from: classes11.dex */
    public class c implements c.a.q0.f1.q.a.d.d {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectClassDialogActivity;
        }

        @Override // c.a.q0.f1.q.a.d.d
        public void a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                i2 = (i2 < 0 || i2 >= this.a.selectClassDialogModel.b().size()) ? 0 : 0;
                i3 = (i3 < 0 || i3 >= this.a.selectClassDialogModel.c().get(i2).size()) ? 0 : 0;
                String str = this.a.selectClassDialogModel.b().get(i2);
                String str2 = this.a.selectClassDialogModel.c().get(i2).get(i3);
                if ((i2 != 0 || i3 != 0) && (!str.equals(this.a.initFirstOption) || !str2.equals(this.a.initSecondOption))) {
                    this.a.canDone = true;
                    c.a.q0.s.u.c.d(this.a.mDoneText).x(R.color.CAM_X0302);
                } else {
                    this.a.canDone = false;
                    this.a.mDoneText.setTextColor(c.a.r0.t3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                    if (str.equals(this.a.initFirstOption) && str2.equals(this.a.initSecondOption)) {
                        this.a.initFirstOption = "";
                        this.a.initSecondOption = "";
                        this.a.canDone = true;
                        c.a.q0.s.u.c.d(this.a.mDoneText).x(R.color.CAM_X0302);
                    }
                }
                this.a.currentOption1 = i2;
                this.a.currentOption2 = i3;
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f51140e;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f51141e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51141e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.f51141e.f51140e.selectClassDialogModel.a(this.f51141e.f51140e.currentOption1, this.f51141e.f51140e.currentOption2)));
                    this.f51141e.f51140e.close();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51140e = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f51140e.canDone) {
                if (this.f51140e.isSelectedTags && this.f51140e.initOption1 > 0 && (this.f51140e.initOption1 != this.f51140e.currentOption1 || this.f51140e.initOption2 != this.f51140e.currentOption2)) {
                    l lVar = new l(this.f51140e.getPageContext().getPageActivity());
                    lVar.q(R.string.select_class_dialog_alert_title);
                    lVar.j(R.string.select_class_dialog_alert_content);
                    lVar.l(true);
                    lVar.p(new TBAlertConfig.a(R.string.dialog_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a(R.string.confirm, TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
                    lVar.f();
                    lVar.g(false);
                    lVar.t();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.f51140e.selectClassDialogModel.a(this.f51140e.currentOption1, this.f51140e.currentOption2)));
                this.f51140e.close();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f51142e;

        public e(SelectClassDialogActivity selectClassDialogActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectClassDialogActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51142e = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51142e.close();
            }
        }
    }

    public SelectClassDialogActivity() {
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
    public c.a.q0.x0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, linearLayout, navigationBar)) == null) {
            this.contentView = linearLayout;
            navigationBar.setCenterTextTitle(getString(R.string.select_class_dialog_title));
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.done));
            this.mDoneText = addTextButton;
            addTextButton.setOnClickListener(new d(this));
            SelectClassDialogView selectClassDialogView = new SelectClassDialogView(linearLayout, this);
            this.selectClassDialogView = selectClassDialogView;
            return selectClassDialogView;
        }
        return (c.a.q0.x0.a) invokeLL.objValue;
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.canDone) {
                c.a.q0.s.u.c.d(this.mDoneText).x(R.color.CAM_X0302);
            } else {
                this.mDoneText.setTextColor(c.a.r0.t3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.selectClassDialogModel = new c.a.r0.l4.u.p.v.a(getUniqueId());
            this.mGetSelectClassListener.getHttpMessageListener().setSelfListener(true);
            this.mGetSelectClassListener.getSocketMessageListener().setSelfListener(true);
            registerListener(this.mGetSelectClassListener);
            if (j.z()) {
                this.selectClassDialogModel.e();
                showLoadingView(this.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
            } else {
                showNetRefreshView(this.contentView, null, getString(R.string.data_load_fail), null, true, new b(this));
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
