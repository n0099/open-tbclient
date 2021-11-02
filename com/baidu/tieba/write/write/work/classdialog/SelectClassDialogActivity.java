package com.baidu.tieba.write.write.work.classdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.e.p.j;
import b.a.q0.s.s.l;
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
/* loaded from: classes10.dex */
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
    public b.a.e.c.g.a mGetSelectClassListener;
    public b.a.r0.d4.u.p.a.a selectClassDialogModel;
    public SelectClassDialogView selectClassDialogView;

    /* loaded from: classes10.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f56213a;

        /* renamed from: com.baidu.tieba.write.write.work.classdialog.SelectClassDialogActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class View$OnClickListenerC1771a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f56214e;

            public View$OnClickListenerC1771a(a aVar) {
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
                this.f56214e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f56214e.f56213a.selectClassDialogModel != null && j.z()) {
                    this.f56214e.f56213a.selectClassDialogModel.e();
                    SelectClassDialogActivity selectClassDialogActivity = this.f56214e.f56213a;
                    selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.contentView);
                    SelectClassDialogActivity selectClassDialogActivity2 = this.f56214e.f56213a;
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
            this.f56213a = selectClassDialogActivity;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.hasError()) {
                SelectClassDialogActivity selectClassDialogActivity = this.f56213a;
                selectClassDialogActivity.showNetRefreshView(selectClassDialogActivity.contentView, null, this.f56213a.getString(R.string.data_load_fail), null, true, new View$OnClickListenerC1771a(this));
                this.f56213a.setNetRefreshViewEmotionMarginTop(UtilHelper.getDimenPixelSize(R.dimen.tbds0));
                return;
            }
            if (responsedMessage instanceof GetSelectClassHttpResMessage) {
                GetSelectClassHttpResMessage getSelectClassHttpResMessage = (GetSelectClassHttpResMessage) responsedMessage;
                this.f56213a.selectClassDialogModel.g(getSelectClassHttpResMessage.getFirstClass());
                this.f56213a.selectClassDialogModel.h(getSelectClassHttpResMessage.getSecondClass());
            } else if (responsedMessage instanceof GetSelectClassSocketResMessage) {
                GetSelectClassSocketResMessage getSelectClassSocketResMessage = (GetSelectClassSocketResMessage) responsedMessage;
                this.f56213a.selectClassDialogModel.g(getSelectClassSocketResMessage.getFirstClass());
                this.f56213a.selectClassDialogModel.h(getSelectClassSocketResMessage.getSecondClass());
            }
            this.f56213a.updateClassData();
            SelectClassDialogActivity selectClassDialogActivity2 = this.f56213a;
            selectClassDialogActivity2.hideLoadingView(selectClassDialogActivity2.contentView);
            SelectClassDialogActivity selectClassDialogActivity3 = this.f56213a;
            selectClassDialogActivity3.initOption1 = selectClassDialogActivity3.selectClassDialogModel.b().indexOf(this.f56213a.initFirstOption);
            if (this.f56213a.initOption1 <= 0 || this.f56213a.initOption1 >= this.f56213a.selectClassDialogModel.c().size()) {
                this.f56213a.initOption1 = 0;
                this.f56213a.initOption2 = 0;
                return;
            }
            SelectClassDialogActivity selectClassDialogActivity4 = this.f56213a;
            selectClassDialogActivity4.initOption2 = selectClassDialogActivity4.selectClassDialogModel.c().get(this.f56213a.initOption1).indexOf(this.f56213a.initSecondOption);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f56215e;

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
            this.f56215e = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56215e.selectClassDialogModel == null) {
                return;
            }
            this.f56215e.selectClassDialogModel.e();
            SelectClassDialogActivity selectClassDialogActivity = this.f56215e;
            selectClassDialogActivity.hideNetRefreshView(selectClassDialogActivity.contentView);
            SelectClassDialogActivity selectClassDialogActivity2 = this.f56215e;
            selectClassDialogActivity2.showLoadingView(selectClassDialogActivity2.contentView, true, UtilHelper.getDimenPixelSize(R.dimen.tbds232));
        }
    }

    /* loaded from: classes10.dex */
    public class c implements b.a.q0.f1.q.a.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f56216a;

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
            this.f56216a = selectClassDialogActivity;
        }

        @Override // b.a.q0.f1.q.a.d.d
        public void a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                i2 = (i2 < 0 || i2 >= this.f56216a.selectClassDialogModel.b().size()) ? 0 : 0;
                i3 = (i3 < 0 || i3 >= this.f56216a.selectClassDialogModel.c().get(i2).size()) ? 0 : 0;
                String str = this.f56216a.selectClassDialogModel.b().get(i2);
                String str2 = this.f56216a.selectClassDialogModel.c().get(i2).get(i3);
                if ((i2 != 0 || i3 != 0) && (!str.equals(this.f56216a.initFirstOption) || !str2.equals(this.f56216a.initSecondOption))) {
                    this.f56216a.canDone = true;
                    b.a.q0.s.u.c.d(this.f56216a.mDoneText).x(R.color.CAM_X0302);
                } else {
                    this.f56216a.canDone = false;
                    this.f56216a.mDoneText.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                    if (str.equals(this.f56216a.initFirstOption) && str2.equals(this.f56216a.initSecondOption)) {
                        this.f56216a.initFirstOption = "";
                        this.f56216a.initSecondOption = "";
                        this.f56216a.canDone = true;
                        b.a.q0.s.u.c.d(this.f56216a.mDoneText).x(R.color.CAM_X0302);
                    }
                }
                this.f56216a.currentOption1 = i2;
                this.f56216a.currentOption2 = i3;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f56217e;

        /* loaded from: classes10.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f56218e;

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
                this.f56218e = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.f56218e.f56217e.selectClassDialogModel.a(this.f56218e.f56217e.currentOption1, this.f56218e.f56217e.currentOption2)));
                    this.f56218e.f56217e.close();
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
            this.f56217e = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f56217e.canDone) {
                if (this.f56217e.isSelectedTags && this.f56217e.initOption1 > 0 && (this.f56217e.initOption1 != this.f56217e.currentOption1 || this.f56217e.initOption2 != this.f56217e.currentOption2)) {
                    l lVar = new l(this.f56217e.getPageContext().getPageActivity());
                    lVar.q(R.string.select_class_dialog_alert_title);
                    lVar.j(R.string.select_class_dialog_alert_content);
                    lVar.l(true);
                    lVar.p(new TBAlertConfig.a(R.string.dialog_cancel, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a(R.string.confirm, TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
                    lVar.f();
                    lVar.g(false);
                    lVar.t();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921601, this.f56217e.selectClassDialogModel.a(this.f56217e.currentOption1, this.f56217e.currentOption2)));
                this.f56217e.close();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectClassDialogActivity f56219e;

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
            this.f56219e = selectClassDialogActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56219e.close();
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
    public b.a.q0.x0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar) {
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
        return (b.a.q0.x0.a) invokeLL.objValue;
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
                b.a.q0.s.u.c.d(this.mDoneText).x(R.color.CAM_X0302);
            } else {
                this.mDoneText.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            }
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            this.selectClassDialogModel = new b.a.r0.d4.u.p.a.a(getUniqueId());
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
