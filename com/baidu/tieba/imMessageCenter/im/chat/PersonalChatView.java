package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes5.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalChatActivity f33948b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f33949c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f33950d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33951e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33952f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33953g;

    /* renamed from: h  reason: collision with root package name */
    public Button f33954h;
    public EMTextView i;
    public LinearLayout j;
    public NoDataView k;
    public ArrayList<ReportPrivateMsgData> l;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public a(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f33948b.showToast(R.string.obfuscated_res_0x7f0f00bb);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsMsglistView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public b(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatView;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.g
        public void a(ArrayList<ReportPrivateMsgData> arrayList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, arrayList, z) == null) {
                this.a.l = arrayList;
                EMTextView eMTextView = this.a.i;
                eMTextView.setText(ListUtils.getCount(arrayList) + "/20");
                if (this.a.mBtnGroupInfo == null || !z) {
                    return;
                }
                this.a.mBtnGroupInfo.setEnabled(true);
                this.a.a.setEnabled(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f33955b;

        public c(PersonalChatView personalChatView, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33955b = personalChatView;
            this.a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f33955b.f33953g.startAnimation(this.a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f33956b;

        public d(PersonalChatView personalChatView, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33956b = personalChatView;
            this.a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f33956b.f33953g.setVisibility(0);
                this.f33956b.f33953g.setAnimation(this.a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f33957b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animation f33958c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f33959d;

        public e(PersonalChatView personalChatView, String str, String str2, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, str, str2, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33959d = personalChatView;
            this.a = str;
            this.f33957b = str2;
            this.f33958c = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f33959d.f33950d.clearAnimation();
                this.f33959d.f33951e.setText(this.f33959d.f33948b.getResources().getString(R.string.obfuscated_res_0x7f0f00b9, this.a));
                this.f33959d.f33952f.setText(this.f33957b);
                this.f33959d.f33950d.setAnimation(this.f33958c);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public f(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f33949c.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Comparator<ReportPrivateMsgData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ReportPrivateMsgData reportPrivateMsgData, ReportPrivateMsgData reportPrivateMsgData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, reportPrivateMsgData, reportPrivateMsgData2)) == null) ? c.a.d.f.m.b.g(reportPrivateMsgData.getTime(), -1L) >= c.a.d.f.m.b.g(reportPrivateMsgData2.getTime(), -1L) ? 1 : -1 : invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-958944279, "Lcom/baidu/tieba/imMessageCenter/im/chat/PersonalChatView$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-958944279, "Lcom/baidu/tieba/imMessageCenter/im/chat/PersonalChatView$h;");
                    return;
                }
            }
            int[] iArr = new int[PersonalMsglistModel.CardStatus.values().length];
            a = iArr;
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        if (this.f33948b.isFriend() || (editorTools = this.mTool) == null) {
            return;
        }
        p(editorTools.m(6));
        p(this.mTool.m(2));
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, talkableActivity, z) == null) {
            super.initPersonalHeader(talkableActivity, z);
            PersonalChatActivity personalChatActivity = (PersonalChatActivity) talkableActivity;
            this.f33948b = personalChatActivity;
            String string = personalChatActivity.isReportSelect() ? talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f041a) : talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0aca);
            if (string != null) {
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06e1, talkableActivity);
                this.mBtnGroupInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090cf6);
                this.a = textView;
                textView.setText(string);
            }
            if (!this.f33948b.isFriend()) {
                LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091db5)).inflate();
                this.f33949c = linearLayout;
                this.f33950d = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09010e);
                this.f33951e = (TextView) this.f33949c.findViewById(R.id.obfuscated_res_0x7f09010f);
                this.f33952f = (TextView) this.f33949c.findViewById(R.id.obfuscated_res_0x7f09010d);
                this.f33953g = (TextView) this.f33949c.findViewById(R.id.obfuscated_res_0x7f09010c);
                Button button = (Button) this.f33949c.findViewById(R.id.obfuscated_res_0x7f09010b);
                this.f33954h = button;
                button.setOnClickListener(talkableActivity);
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                    this.f33949c.setVisibility(8);
                }
            }
            if (this.f33948b.isReportSelect()) {
                if (this.mBtnGroupInfo != null) {
                    this.a.setEnabled(false);
                    this.mBtnGroupInfo.setEnabled(false);
                }
                this.mNavigationBar.setCenterTextTitle(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0ece));
                if (!this.f33948b.checkUid()) {
                    KeyboardLayout keyboardLayout = this.mRootView;
                    NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                    aVar.i(NoDataViewFactory.ImgType.LOCAL);
                    aVar.h(R.drawable.new_pic_emotion_01);
                    aVar.j(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0702b6));
                    NoDataView a2 = NoDataViewFactory.a(talkableActivity, keyboardLayout, aVar.f(), NoDataViewFactory.e.d(null, talkableActivity.getString(R.string.obfuscated_res_0x7f0f0c2c)), null);
                    this.k = a2;
                    a2.setVisibility(0);
                    this.k.f(talkableActivity.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f0917a2)).inflate();
                    this.j = linearLayout2;
                    linearLayout2.setVisibility(0);
                    EMTextView eMTextView = (EMTextView) this.j.findViewById(R.id.obfuscated_res_0x7f091c82);
                    this.i = eMTextView;
                    eMTextView.setVisibility(0);
                    EMTextView eMTextView2 = this.i;
                    eMTextView2.setText(ListUtils.getCount(this.f33948b.selectList()) + "/20");
                    setUpdateListener(new b(this));
                }
                closeNotNotify();
                closeReceiver();
                closeTitleView();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isFromReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33948b.isReportSelect() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            TextView textView = this.a;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0304, i));
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            LinearLayout linearLayout = this.j;
            if (linearLayout != null) {
                c.a.o0.r.v.c.d(linearLayout).f(R.color.CAM_X0201);
            }
            EMTextView eMTextView = this.i;
            if (eMTextView != null) {
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(eMTextView);
                d2.v(R.color.CAM_X0107);
                d2.z(R.dimen.T_X05);
            }
            NoDataView noDataView = this.k;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
        }
    }

    public final void p(c.a.o0.w.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) || hVar == null || hVar == null || !(hVar instanceof View)) {
            return;
        }
        ((View) hVar).setOnClickListener(this.m);
    }

    public Button q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33954h : (Button) invokeV.objValue;
    }

    public ArrayList<ReportPrivateMsgData> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!ListUtils.isEmpty(this.l)) {
                Collections.sort(this.l, new g(this));
            }
            return this.l;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ViewGroup s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRootView : (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33948b.selectList() : (ArrayList) invokeV.objValue;
    }

    public final void t() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (editorTools = this.mTool) == null) {
            return;
        }
        editorTools.z();
    }

    public void u(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{cardStatus, Boolean.valueOf(z), strArr}) == null) {
            this.f33949c.setVisibility(0);
            int i = h.a[cardStatus.ordinal()];
            if (i == 1) {
                w();
            } else if (i == 2) {
                y(z);
            } else if (i == 3) {
                v(z, (strArr == null || strArr.length <= 0) ? "" : strArr[0]);
            } else if (i != 4) {
            } else {
                x(z);
            }
        }
    }

    public final void v(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            String name_show = this.f33948b.getCurrentModel().getUser().getName_show();
            this.f33953g.setVisibility(8);
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new e(this, name_show, str, translateAnimation));
                this.f33950d.setVisibility(0);
                this.f33950d.startAnimation(translateAnimation2);
            } else {
                this.f33950d.setVisibility(0);
                this.f33951e.setText(this.f33948b.getResources().getString(R.string.obfuscated_res_0x7f0f00b9, name_show));
                this.f33952f.setText(str);
            }
            this.f33954h.setText(R.string.obfuscated_res_0x7f0f00b8);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f33949c.setVisibility(8);
            this.f33950d.setVisibility(0);
            this.f33953g.setVisibility(8);
            this.f33951e.setText(R.string.obfuscated_res_0x7f0f00c3);
            this.f33952f.setText(R.string.obfuscated_res_0x7f0f00c0);
            this.f33954h.setText(R.string.obfuscated_res_0x7f0f00ba);
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            t();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new f(this));
                this.f33949c.startAnimation(translateAnimation);
                return;
            }
            this.f33949c.setVisibility(8);
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.f33948b.getCurrentModel().H() == PersonalMsglistModel.CardStatus.WAIT && z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new c(this, translateAnimation));
                this.f33953g.startAnimation(translateAnimation2);
                return;
            }
            if (z) {
                TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation3.setDuration(400L);
                translateAnimation3.setFillAfter(true);
                TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation4.setDuration(400L);
                translateAnimation4.setFillAfter(true);
                translateAnimation4.setAnimationListener(new d(this, translateAnimation3));
                this.f33950d.setVisibility(8);
                this.f33950d.startAnimation(translateAnimation4);
            } else {
                this.f33950d.setVisibility(8);
                this.f33953g.setVisibility(0);
            }
            this.f33953g.setText(R.string.obfuscated_res_0x7f0f00c4);
            this.f33954h.setText(R.string.obfuscated_res_0x7f0f00ba);
        }
    }
}
