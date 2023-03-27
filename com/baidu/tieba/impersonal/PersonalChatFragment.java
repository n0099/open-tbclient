package com.baidu.tieba.impersonal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.impersonal.PersonalChatFragment;
import com.baidu.tieba.impersonal.databinding.FragmentPersonalChatBinding;
import com.baidu.tieba.impersonal.slices.AutoReleaseSliceFragment;
import com.baidu.tieba.impersonal.slices.ChatInputSlice;
import com.baidu.tieba.impersonal.slices.ChatListSlice;
import com.baidu.tieba.impersonal.slices.ChatNavSlice;
import com.baidu.tieba.impersonal.slices.ChatReplySlice;
import com.baidu.tieba.impersonal.slices.ChatSpriteSlice;
import com.baidu.tieba.jh6;
import com.baidu.tieba.kh6;
import com.baidu.tieba.m08;
import com.baidu.tieba.mh6;
import com.baidu.tieba.nh6;
import com.baidu.tieba.o18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0012\u0010&\u001a\u00020\"2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\"H\u0016J\u001a\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010/\u001a\u00020\"H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0018\u0010\u0007¨\u00060"}, d2 = {"Lcom/baidu/tieba/impersonal/PersonalChatFragment;", "Lcom/baidu/tieba/impersonal/slices/AutoReleaseSliceFragment;", "Lcom/baidu/tieba/impersonal/databinding/FragmentPersonalChatBinding;", "()V", "baseboardRes", "", "getBaseboardRes", "()Ljava/lang/String;", "baseboardRes$delegate", "Lkotlin/Lazy;", "lightRes", "getLightRes", "lightRes$delegate", "mKeyBoardShowing", "", "replyPaddingTopKeyboardHide", "", "replyPaddingTopKeyboardShow", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "getRepo", "()Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "repo$delegate", "wallRes", "getWallRes", "wallRes$delegate", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "dealSoftKey", "", "initListener", "layoutOnKeyboardHide", "layoutOnKeyboardShown", "onActivityCreated", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onKeyboardVisibilityChanged", "isVisible", MissionEvent.MESSAGE_PAUSE, "onViewCreated", NativeConstants.TYPE_VIEW, "Landroid/view/View;", "registerChatListLoadEvent", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PersonalChatFragment extends AutoReleaseSliceFragment<FragmentPersonalChatBinding> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final int k;
    public final int l;

    /* loaded from: classes4.dex */
    public static final class a extends nh6<m08> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalChatFragment personalChatFragment, Class<m08> cls) {
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
                this$0.R1().l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nh6
        public void onEvent(m08 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                int a = event.a();
                if (a != 0) {
                    if (a != 1) {
                        if (a == 2) {
                            PersonalChatFragment personalChatFragment = this.b;
                            personalChatFragment.hideLoadingView(PersonalChatFragment.J1(personalChatFragment).g);
                            PersonalChatFragment personalChatFragment2 = this.b;
                            FrameLayout frameLayout = PersonalChatFragment.J1(personalChatFragment2).g;
                            String string = this.b.getString(R.string.refresh_view_button_text);
                            final PersonalChatFragment personalChatFragment3 = this.b;
                            personalChatFragment2.showNetRefreshView(frameLayout, null, null, string, false, new View.OnClickListener() { // from class: com.baidu.tieba.vz7
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
                            PersonalChatFragment.J1(this.b).h.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    PersonalChatFragment personalChatFragment4 = this.b;
                    personalChatFragment4.hideLoadingView(PersonalChatFragment.J1(personalChatFragment4).g);
                    PersonalChatFragment personalChatFragment5 = this.b;
                    personalChatFragment5.hideNetRefreshView(PersonalChatFragment.J1(personalChatFragment5).g);
                    PersonalChatFragment.J1(this.b).h.setVisibility(0);
                    return;
                }
                PersonalChatFragment personalChatFragment6 = this.b;
                personalChatFragment6.showLoadingView(PersonalChatFragment.J1(personalChatFragment6).g);
                PersonalChatFragment personalChatFragment7 = this.b;
                personalChatFragment7.hideNetRefreshView(PersonalChatFragment.J1(personalChatFragment7).g);
                PersonalChatFragment.J1(this.b).h.setVisibility(8);
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
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<o18>(this) { // from class: com.baidu.tieba.impersonal.PersonalChatFragment$repo$2
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
            public final o18 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    return new o18(requireContext);
                }
                return (o18) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$wallRes$2.INSTANCE);
        this.i = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$baseboardRes$2.INSTANCE);
        this.j = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$lightRes$2.INSTANCE);
        this.k = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
        this.l = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
    }

    public static final /* synthetic */ FragmentPersonalChatBinding J1(PersonalChatFragment personalChatFragment) {
        return personalChatFragment.I1();
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.f = z;
            if (z) {
                W1();
            } else {
                V1();
            }
        }
    }

    public static final void U1(PersonalChatFragment this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.O1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            X1();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.impersonal.slices.AutoReleaseSliceFragment
    /* renamed from: N1 */
    public FragmentPersonalChatBinding H1(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
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

    public final void O1() {
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
            hi.z(context, view2);
        }
    }

    public final String P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (String) this.i.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final String Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (String) this.j.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final o18 R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (o18) this.g.getValue();
        }
        return (o18) invokeV.objValue;
    }

    public final String S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (String) this.h.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I1().n.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wz7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PersonalChatFragment.U1(PersonalChatFragment.this, view2);
                    }
                }
            });
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            mh6 b = kh6.b();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            b.a(new jh6(pageContext, this), new a(this, m08.class));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            V1();
            super.onPause();
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || I1().e.getVisibility() != 0) {
            return;
        }
        I1().m.animate().alpha(1.0f).start();
        String P1 = P1();
        if (P1 != null) {
            I1().d.setImageURI(Uri.fromFile(new File(P1)), (Object) null);
            I1().d.setBackgroundColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.transparent));
        }
        I1().i.setPadding(0, this.l, 0, 0);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(I1().getRoot());
        constraintSet.connect(R.id.obfuscated_res_0x7f090681, 4, R.id.obfuscated_res_0x7f09211b, 3, 0);
        constraintSet.applyTo(I1().getRoot());
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(I1().getRoot());
        constraintSet2.connect(R.id.obfuscated_res_0x7f09211b, 4, R.id.obfuscated_res_0x7f09211c, 4);
        constraintSet2.applyTo(I1().getRoot());
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I1().m.animate().alpha(0.0f).start();
            I1().d.setBackgroundColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0338));
            I1().d.setImageURI(Uri.EMPTY, (Object) null);
            I1().i.setPadding(0, this.k, 0, 0);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(I1().getRoot());
            constraintSet.connect(R.id.obfuscated_res_0x7f090681, 4, R.id.obfuscated_res_0x7f091d93, 3, hi.g(getContext(), R.dimen.M_H_X005));
            constraintSet.applyTo(I1().getRoot());
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.clone(I1().getRoot());
            constraintSet2.connect(R.id.obfuscated_res_0x7f09211b, 4, R.id.obfuscated_res_0x7f0920f1, 4);
            constraintSet2.applyTo(I1().getRoot());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            Bundle arguments = getArguments();
            Object obj2 = null;
            if (arguments != null) {
                obj = arguments.get("key_sprite_talk_type");
            } else {
                obj = null;
            }
            String valueOf = String.valueOf(obj);
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                obj2 = arguments2.get("key_sprite_talk_prologue");
            }
            String valueOf2 = String.valueOf(obj2);
            FrameLayout frameLayout = I1().f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.navigationContainer");
            E1(frameLayout, new ChatNavSlice());
            FrameLayout frameLayout2 = I1().b;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.chatContainer");
            E1(frameLayout2, new ChatListSlice(R1(), valueOf, valueOf2));
            FrameLayout frameLayout3 = I1().l;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.spriteContainer");
            E1(frameLayout3, new ChatSpriteSlice());
            FrameLayout frameLayout4 = I1().e;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.inputContainer");
            E1(frameLayout4, new ChatInputSlice(R1()));
            FrameLayout frameLayout5 = I1().i;
            Intrinsics.checkNotNullExpressionValue(frameLayout5, "binding.replyContainer");
            E1(frameLayout5, new ChatReplySlice(R1(), valueOf, valueOf2));
            T1();
            TbImage tbImage = I1().d;
            ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
            tbImage.setScaleType(FIT_XY);
            TbImage tbImage2 = I1().n;
            ScalingUtils.ScaleType FIT_XY2 = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY2, "FIT_XY");
            tbImage2.setScaleType(FIT_XY2);
            TbImage tbImage3 = I1().m;
            ScalingUtils.ScaleType FIT_XY3 = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY3, "FIT_XY");
            tbImage3.setScaleType(FIT_XY3);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            String S1 = S1();
            if (S1 != null) {
                TbImage tbImage = I1().n;
                String uri = Uri.fromFile(new File(S1)).toString();
                Intrinsics.checkNotNullExpressionValue(uri, "fromFile(File(this)).toString()");
                tbImage.i(uri);
            }
            String P1 = P1();
            if (P1 != null) {
                TbImage tbImage2 = I1().d;
                String uri2 = Uri.fromFile(new File(P1)).toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "fromFile(File(this)).toString()");
                tbImage2.i(uri2);
            }
            String Q1 = Q1();
            if (Q1 != null) {
                TbImage tbImage3 = I1().m;
                String uri3 = Uri.fromFile(new File(Q1)).toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "fromFile(File(this)).toString()");
                tbImage3.i(uri3);
            }
        }
    }
}
