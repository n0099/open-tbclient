package com.baidu.tieba.impersonal;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.bd8;
import com.baidu.tieba.fe8;
import com.baidu.tieba.ii;
import com.baidu.tieba.impersonal.PersonalChatFragment;
import com.baidu.tieba.impersonal.databinding.FragmentPersonalChatBinding;
import com.baidu.tieba.impersonal.slices.AutoReleaseSliceFragment;
import com.baidu.tieba.impersonal.slices.ChatInputSlice;
import com.baidu.tieba.impersonal.slices.ChatListSlice;
import com.baidu.tieba.impersonal.slices.ChatNavSlice;
import com.baidu.tieba.impersonal.slices.ChatReplySlice;
import com.baidu.tieba.impersonal.slices.ChatSpriteSlice;
import com.baidu.tieba.un9;
import com.baidu.tieba.vl6;
import com.baidu.tieba.wl6;
import com.baidu.tieba.x85;
import com.baidu.tieba.yl6;
import com.baidu.tieba.zl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\u0012\u0010.\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020\u0016H\u0016J\u001a\u00103\u001a\u00020*2\u0006\u00104\u001a\u0002052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00106\u001a\u00020*H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0013\u0010\u0007R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007¨\u00067"}, d2 = {"Lcom/baidu/tieba/impersonal/PersonalChatFragment;", "Lcom/baidu/tieba/impersonal/slices/AutoReleaseSliceFragment;", "Lcom/baidu/tieba/impersonal/databinding/FragmentPersonalChatBinding;", "()V", "baseboardRes", "", "getBaseboardRes", "()Ljava/lang/String;", "baseboardRes$delegate", "Lkotlin/Lazy;", "chatInputSlice", "Lcom/baidu/tieba/impersonal/slices/ChatInputSlice;", "getChatInputSlice", "()Lcom/baidu/tieba/impersonal/slices/ChatInputSlice;", "chatInputSlice$delegate", "floorbgKeyboardShow", "", "", "lightRes", "getLightRes", "lightRes$delegate", "mKeyBoardShowing", "", "replyPaddingLeftKeyboardShow", "replyPaddingTopKeyboardHide", "replyPaddingTopKeyboardShow", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "getRepo", "()Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "repo$delegate", "wallRes", "getWallRes", "wallRes$delegate", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "dealSoftKey", "", "initListener", "layoutOnKeyboardHide", "layoutOnKeyboardShown", "onActivityCreated", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onKeyboardVisibilityChanged", "isVisible", "onViewCreated", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "registerChatListLoadEvent", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalChatFragment extends AutoReleaseSliceFragment<FragmentPersonalChatBinding> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final int l;
    public final int m;
    public final int n;
    public final List<Integer> o;

    /* loaded from: classes5.dex */
    public static final class a extends zl6<bd8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalChatFragment personalChatFragment, Class<bd8> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatFragment, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalChatFragment;
        }

        public static final void b(PersonalChatFragment this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.T1().l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zl6
        public void onEvent(bd8 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                int a = event.a();
                if (a != 0) {
                    if (a != 1) {
                        if (a == 2) {
                            PersonalChatFragment personalChatFragment = this.b;
                            personalChatFragment.hideLoadingView(PersonalChatFragment.K1(personalChatFragment).g);
                            PersonalChatFragment personalChatFragment2 = this.b;
                            FrameLayout frameLayout = PersonalChatFragment.K1(personalChatFragment2).g;
                            String string = this.b.getString(R.string.refresh_view_button_text);
                            final PersonalChatFragment personalChatFragment3 = this.b;
                            personalChatFragment2.showNetRefreshView(frameLayout, null, null, string, false, new View.OnClickListener() { // from class: com.baidu.tieba.fc8
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                        PersonalChatFragment.a.b(PersonalChatFragment.this, view2);
                                    }
                                }
                            });
                            PersonalChatFragment.K1(this.b).h.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    PersonalChatFragment personalChatFragment4 = this.b;
                    personalChatFragment4.hideLoadingView(PersonalChatFragment.K1(personalChatFragment4).g);
                    PersonalChatFragment personalChatFragment5 = this.b;
                    personalChatFragment5.hideNetRefreshView(PersonalChatFragment.K1(personalChatFragment5).g);
                    PersonalChatFragment.K1(this.b).h.setVisibility(0);
                    return;
                }
                PersonalChatFragment personalChatFragment6 = this.b;
                personalChatFragment6.showLoadingView(PersonalChatFragment.K1(personalChatFragment6).g);
                PersonalChatFragment personalChatFragment7 = this.b;
                personalChatFragment7.hideNetRefreshView(PersonalChatFragment.K1(personalChatFragment7).g);
                PersonalChatFragment.K1(this.b).h.setVisibility(8);
            }
        }
    }

    public PersonalChatFragment() {
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
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<fe8>(this) { // from class: com.baidu.tieba.impersonal.PersonalChatFragment$repo$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final fe8 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    return new fe8(requireContext);
                }
                return (fe8) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$wallRes$2.INSTANCE);
        this.i = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$baseboardRes$2.INSTANCE);
        this.j = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$lightRes$2.INSTANCE);
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<ChatInputSlice>(this) { // from class: com.baidu.tieba.impersonal.PersonalChatFragment$chatInputSlice$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonalChatFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChatInputSlice invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new ChatInputSlice(this.this$0.T1());
                }
                return (ChatInputSlice) invokeV.objValue;
            }
        });
        this.l = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X010);
        this.m = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        this.n = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(un9.a(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0338), 0.0f)));
        arrayList.add(Integer.valueOf(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0338)));
        this.o = arrayList;
    }

    public static final /* synthetic */ FragmentPersonalChatBinding K1(PersonalChatFragment personalChatFragment) {
        return personalChatFragment.J1();
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.f = z;
            if (z) {
                Y1();
            } else {
                X1();
            }
        }
    }

    public static final void W1(PersonalChatFragment this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.P1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            Z1();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.impersonal.slices.AutoReleaseSliceFragment
    /* renamed from: O1 */
    public FragmentPersonalChatBinding I1(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentPersonalChatBinding c = FragmentPersonalChatBinding.c(inflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(inflater, container, false)");
            return c;
        }
        return (FragmentPersonalChatBinding) invokeLLL.objValue;
    }

    public final void P1() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f) {
            Context context = getContext();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                view2 = activity.getCurrentFocus();
            } else {
                view2 = null;
            }
            ii.z(context, view2);
        }
    }

    public final String Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (String) this.i.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final ChatInputSlice R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (ChatInputSlice) this.k.getValue();
        }
        return (ChatInputSlice) invokeV.objValue;
    }

    public final String S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (String) this.j.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final fe8 T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (fe8) this.g.getValue();
        }
        return (fe8) invokeV.objValue;
    }

    public final String U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (String) this.h.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            J1().n.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.gc8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PersonalChatFragment.W1(PersonalChatFragment.this, view2);
                    }
                }
            });
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            yl6 b = wl6.b();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            b.a(new vl6(pageContext, this), new a(this, bd8.class));
        }
    }

    public final void X1() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || J1().e.getVisibility() != 0) {
            return;
        }
        TextView textView = J1().c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.copyright");
        if (textView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            J1().c.animate().alpha(1.0f).start();
        }
        J1().m.animate().alpha(1.0f).start();
        J1().e.setBackground(null);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(J1().getRoot());
        constraintSet.connect(R.id.obfuscated_res_0x7f090b0d, 4, 0, 4, 0);
        constraintSet.applyTo(J1().getRoot());
        String Q1 = Q1();
        if (Q1 != null) {
            J1().d.setImageURI(Uri.fromFile(new File(Q1)), (Object) null);
            J1().d.setBackgroundColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.transparent));
        }
        J1().i.setPadding(0, this.m, 0, 0);
        R1().X(UtilHelper.getDimenPixelSize(R.dimen.tbds60));
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(J1().getRoot());
        constraintSet2.connect(R.id.obfuscated_res_0x7f090687, 4, R.id.obfuscated_res_0x7f0920f3, 3, 0);
        constraintSet2.applyTo(J1().getRoot());
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(J1().getRoot());
        constraintSet3.connect(R.id.obfuscated_res_0x7f09211e, 4, R.id.obfuscated_res_0x7f09211f, 4);
        constraintSet3.applyTo(J1().getRoot());
        J1().l.setVisibility(0);
    }

    public final void Y1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TextView textView = J1().c;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.copyright");
            if (textView.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                J1().c.animate().alpha(0.0f).start();
            }
            J1().m.animate().alpha(0.0f).start();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(J1().getRoot());
            constraintSet.connect(R.id.obfuscated_res_0x7f090b0d, 4, R.id.obfuscated_res_0x7f0910a5, 3, 0);
            constraintSet.applyTo(J1().getRoot());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(CollectionsKt___CollectionsKt.toIntArray(this.o));
            J1().d.setBackground(gradientDrawable);
            J1().d.setImageURI(Uri.EMPTY, (Object) null);
            J1().i.setPadding(this.n, this.l, 0, 0);
            J1().e.setBackgroundColor(getResources().getColor(R.color.CAM_X0338));
            J1().e.setPadding(0, 0, 0, 0);
            R1().X(0);
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.clone(J1().getRoot());
            constraintSet2.connect(R.id.obfuscated_res_0x7f090687, 4, R.id.obfuscated_res_0x7f091d92, 3, 0);
            constraintSet2.applyTo(J1().getRoot());
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.clone(J1().getRoot());
            constraintSet3.connect(R.id.obfuscated_res_0x7f09211e, 4, R.id.obfuscated_res_0x7f0920f4, 4);
            constraintSet3.applyTo(J1().getRoot());
            J1().l.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Object obj;
        Object obj2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Bundle arguments = getArguments();
            String str2 = null;
            if (arguments != null) {
                obj = arguments.get("key_sprite_talk_type");
            } else {
                obj = null;
            }
            String valueOf = String.valueOf(obj);
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                obj2 = arguments2.get("key_sprite_talk_prologue");
            } else {
                obj2 = null;
            }
            String valueOf2 = String.valueOf(obj2);
            FrameLayout frameLayout = J1().f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.navigationContainer");
            F1(frameLayout, new ChatNavSlice());
            FrameLayout frameLayout2 = J1().b;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.chatContainer");
            F1(frameLayout2, new ChatListSlice(T1(), valueOf, valueOf2));
            FrameLayout frameLayout3 = J1().l;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.spriteContainer");
            F1(frameLayout3, new ChatSpriteSlice());
            FrameLayout frameLayout4 = J1().e;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.inputContainer");
            F1(frameLayout4, R1());
            FrameLayout frameLayout5 = J1().i;
            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.replyContainer");
            F1(frameLayout5, new ChatReplySlice(T1(), valueOf, valueOf2));
            V1();
            TbImage tbImage = J1().d;
            ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
            tbImage.setScaleType(FIT_XY);
            TbImage tbImage2 = J1().n;
            ScalingUtils.ScaleType FIT_XY2 = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY2, "FIT_XY");
            tbImage2.setScaleType(FIT_XY2);
            TbImage tbImage3 = J1().m;
            ScalingUtils.ScaleType FIT_XY3 = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY3, "FIT_XY");
            tbImage3.setScaleType(FIT_XY3);
            J1().b.setPadding(J1().b.getPaddingLeft(), UtilHelper.getStatusBarHeight() + ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004), J1().b.getPaddingRight(), J1().b.getPaddingBottom());
            x85 funnySpriteConfig = TbSingleton.getInstance().getFunnySpriteConfig();
            if (funnySpriteConfig != null) {
                str = funnySpriteConfig.c();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                J1().c.setVisibility(0);
                TextView textView = J1().c;
                x85 funnySpriteConfig2 = TbSingleton.getInstance().getFunnySpriteConfig();
                if (funnySpriteConfig2 != null) {
                    str2 = funnySpriteConfig2.c();
                }
                textView.setText(str2);
                return;
            }
            J1().c.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            String U1 = U1();
            if (U1 != null) {
                TbImage tbImage = J1().n;
                String uri = Uri.fromFile(new File(U1)).toString();
                Intrinsics.checkNotNullExpressionValue(uri, "fromFile(File(this)).toString()");
                tbImage.k(uri);
            }
            String Q1 = Q1();
            if (Q1 != null) {
                TbImage tbImage2 = J1().d;
                String uri2 = Uri.fromFile(new File(Q1)).toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "fromFile(File(this)).toString()");
                tbImage2.k(uri2);
            }
            String S1 = S1();
            if (S1 != null) {
                TbImage tbImage3 = J1().m;
                String uri3 = Uri.fromFile(new File(S1)).toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "fromFile(File(this)).toString()");
                tbImage3.k(uri3);
            }
        }
    }
}
