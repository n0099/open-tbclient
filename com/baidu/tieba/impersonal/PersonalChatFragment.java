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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.ab9;
import com.baidu.tieba.ar6;
import com.baidu.tieba.br6;
import com.baidu.tieba.dr6;
import com.baidu.tieba.er6;
import com.baidu.tieba.fd9;
import com.baidu.tieba.id9;
import com.baidu.tieba.impersonal.PersonalChatFragment;
import com.baidu.tieba.impersonal.ability.SpriteSendMsgHandler;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.databinding.FragmentPersonalChatBinding;
import com.baidu.tieba.impersonal.slices.AutoReleaseSliceFragment;
import com.baidu.tieba.impersonal.slices.ChatInputSlice;
import com.baidu.tieba.impersonal.slices.ChatListSlice;
import com.baidu.tieba.impersonal.slices.ChatNavSlice;
import com.baidu.tieba.impersonal.slices.ChatReplySlice;
import com.baidu.tieba.impersonal.slices.ChatSpriteSlice;
import com.baidu.tieba.kq8;
import com.baidu.tieba.tua;
import com.baidu.tieba.wb9;
import com.baidu.tieba.x85;
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
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J$\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\u0012\u00102\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020.2\u0006\u00106\u001a\u00020\u0015H\u0016J\u001a\u00107\u001a\u00020.2\u0006\u00108\u001a\u0002092\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010:\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020.H\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u0007R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b$\u0010\u0007¨\u0006<"}, d2 = {"Lcom/baidu/tieba/impersonal/PersonalChatFragment;", "Lcom/baidu/tieba/impersonal/slices/AutoReleaseSliceFragment;", "Lcom/baidu/tieba/impersonal/databinding/FragmentPersonalChatBinding;", "()V", "baseboardRes", "", "getBaseboardRes", "()Ljava/lang/String;", "baseboardRes$delegate", "Lkotlin/Lazy;", "chatInputSlice", "Lcom/baidu/tieba/impersonal/slices/ChatInputSlice;", "detailManager", "Lcom/baidu/tieba/impersonal/sprite/SpriteDetailManager;", "floorbgKeyboardShow", "", "", "lightRes", "getLightRes", "lightRes$delegate", "mKeyBoardShowing", "", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "getProcessor", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "processor$delegate", "replyPaddingLeftKeyboardShow", "replyPaddingTopKeyboardHide", "replyPaddingTopKeyboardShow", "repo", "Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "getRepo", "()Lcom/baidu/tieba/impersonal/sprite/ChatSpriteRepo;", "repo$delegate", "wallRes", "getWallRes", "wallRes$delegate", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "dealSoftKey", "", "initListener", "layoutOnKeyboardHide", "layoutOnKeyboardShown", "onActivityCreated", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onKeyboardVisibilityChanged", "isVisible", "onViewCreated", "view", "Landroid/view/View;", "registerChatListLoadEvent", "registerProcessorHandler", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PersonalChatFragment extends AutoReleaseSliceFragment<FragmentPersonalChatBinding> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public ChatInputSlice k;
    public final int l;
    public final int m;
    public final int n;
    public final Lazy o;
    public id9 p;
    public final List<Integer> q;

    /* loaded from: classes6.dex */
    public static final class a extends er6<wb9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalChatFragment personalChatFragment, Class<wb9> cls) {
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
                this$0.U2().m();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.er6
        public void onEvent(wb9 event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                int a = event.a();
                if (a != 0) {
                    if (a != 1) {
                        if (a == 2) {
                            PersonalChatFragment personalChatFragment = this.b;
                            personalChatFragment.hideLoadingView(PersonalChatFragment.L2(personalChatFragment).g);
                            PersonalChatFragment personalChatFragment2 = this.b;
                            FrameLayout frameLayout = PersonalChatFragment.L2(personalChatFragment2).g;
                            String string = this.b.getString(R.string.refresh_view_button_text);
                            final PersonalChatFragment personalChatFragment3 = this.b;
                            personalChatFragment2.showNetRefreshView(frameLayout, null, null, string, false, new View.OnClickListener() { // from class: com.baidu.tieba.xa9
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
                            PersonalChatFragment.L2(this.b).h.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    PersonalChatFragment personalChatFragment4 = this.b;
                    personalChatFragment4.hideLoadingView(PersonalChatFragment.L2(personalChatFragment4).g);
                    PersonalChatFragment personalChatFragment5 = this.b;
                    personalChatFragment5.hideNetRefreshView(PersonalChatFragment.L2(personalChatFragment5).g);
                    PersonalChatFragment.L2(this.b).h.setVisibility(0);
                    return;
                }
                PersonalChatFragment personalChatFragment6 = this.b;
                personalChatFragment6.showLoadingView(PersonalChatFragment.L2(personalChatFragment6).g);
                PersonalChatFragment personalChatFragment7 = this.b;
                personalChatFragment7.hideNetRefreshView(PersonalChatFragment.L2(personalChatFragment7).g);
                PersonalChatFragment.L2(this.b).h.setVisibility(8);
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
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<fd9>(this) { // from class: com.baidu.tieba.impersonal.PersonalChatFragment$repo$2
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
            public final fd9 invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    Context requireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    return new fd9(requireContext);
                }
                return (fd9) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$wallRes$2.INSTANCE);
        this.i = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$baseboardRes$2.INSTANCE);
        this.j = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$lightRes$2.INSTANCE);
        this.l = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X010);
        this.m = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        this.n = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        this.o = LazyKt__LazyJVMKt.lazy(PersonalChatFragment$processor$2.INSTANCE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(tua.a(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0338), 0.0f)));
        arrayList.add(Integer.valueOf(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0338)));
        this.q = arrayList;
    }

    public static final /* synthetic */ FragmentPersonalChatBinding L2(PersonalChatFragment personalChatFragment) {
        return personalChatFragment.K2();
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            super.onKeyboardVisibilityChanged(z);
            this.f = z;
            if (z) {
                Z2();
            } else {
                Y2();
            }
        }
    }

    public static final void X2(PersonalChatFragment this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, view2, bundle) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            super.onViewCreated(view2, bundle);
            a3();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.impersonal.slices.AutoReleaseSliceFragment
    /* renamed from: P2 */
    public FragmentPersonalChatBinding J2(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
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

    public final void Q2() {
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
            BdUtilHelper.hideSoftKeyPad(context, view2);
        }
    }

    public final String R2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (String) this.i.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final String S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (String) this.j.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final kq8 T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (kq8) this.o.getValue();
        }
        return (kq8) invokeV.objValue;
    }

    public final fd9 U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (fd9) this.g.getValue();
        }
        return (fd9) invokeV.objValue;
    }

    public final String V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (String) this.h.getValue();
        }
        return (String) invokeV.objValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            K2().n.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ya9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PersonalChatFragment.X2(PersonalChatFragment.this, view2);
                    }
                }
            });
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            dr6 b = br6.b();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            b.b(new ar6(pageContext, this), new a(this, wb9.class));
        }
    }

    public final void Y2() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || K2().e.getVisibility() != 0) {
            return;
        }
        TextView textView = K2().c;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.copyright");
        if (textView.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            K2().c.animate().alpha(1.0f).start();
        }
        K2().m.animate().alpha(1.0f).start();
        K2().e.setBackground(null);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(K2().getRoot());
        constraintSet.connect(R.id.obfuscated_res_0x7f090bc4, 4, 0, 4, 0);
        constraintSet.applyTo(K2().getRoot());
        String R2 = R2();
        if (R2 != null) {
            K2().d.setImageURI(Uri.fromFile(new File(R2)), (Object) null);
            K2().d.setBackgroundColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.transparent));
        }
        K2().i.setPadding(0, this.m, 0, 0);
        ChatInputSlice chatInputSlice = this.k;
        if (chatInputSlice != null) {
            chatInputSlice.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds60));
        }
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(K2().getRoot());
        constraintSet2.connect(R.id.obfuscated_res_0x7f090702, 4, R.id.obfuscated_res_0x7f092349, 3, 0);
        constraintSet2.applyTo(K2().getRoot());
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(K2().getRoot());
        constraintSet3.connect(R.id.obfuscated_res_0x7f092379, 4, R.id.obfuscated_res_0x7f09237c, 4);
        constraintSet3.applyTo(K2().getRoot());
        K2().l.setVisibility(0);
    }

    public final void Z2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TextView textView = K2().c;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.copyright");
            if (textView.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                K2().c.animate().alpha(0.0f).start();
            }
            K2().m.animate().alpha(0.0f).start();
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(K2().getRoot());
            constraintSet.connect(R.id.obfuscated_res_0x7f090bc4, 4, R.id.obfuscated_res_0x7f0911ad, 3, 0);
            constraintSet.applyTo(K2().getRoot());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(CollectionsKt___CollectionsKt.toIntArray(this.q));
            K2().d.setBackground(gradientDrawable);
            K2().d.setImageURI(Uri.EMPTY, (Object) null);
            K2().i.setPadding(this.n, this.l, 0, 0);
            K2().e.setBackgroundColor(getResources().getColor(R.color.CAM_X0338));
            K2().e.setPadding(0, 0, 0, 0);
            ChatInputSlice chatInputSlice = this.k;
            if (chatInputSlice != null) {
                chatInputSlice.d0(0);
            }
            ConstraintSet constraintSet2 = new ConstraintSet();
            constraintSet2.clone(K2().getRoot());
            constraintSet2.connect(R.id.obfuscated_res_0x7f090702, 4, R.id.obfuscated_res_0x7f091fc5, 3, 0);
            constraintSet2.applyTo(K2().getRoot());
            ConstraintSet constraintSet3 = new ConstraintSet();
            constraintSet3.clone(K2().getRoot());
            constraintSet3.connect(R.id.obfuscated_res_0x7f092379, 4, R.id.obfuscated_res_0x7f09234a, 4);
            constraintSet3.applyTo(K2().getRoot());
            K2().l.setVisibility(8);
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            T2().a(new SpriteSendMsgHandler(U2()));
            kq8 T2 = T2();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            T2.a(new ab9(pageContext));
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
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
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                obj3 = arguments3.get("key_sprite_params_forumId");
            } else {
                obj3 = null;
            }
            String valueOf3 = String.valueOf(obj3);
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                obj4 = arguments4.get("key_sprite_params_from");
            } else {
                obj4 = null;
            }
            String valueOf4 = String.valueOf(obj4);
            Bundle arguments5 = getArguments();
            if (arguments5 != null) {
                obj5 = arguments5.get("key_sprite_params_query");
            } else {
                obj5 = null;
            }
            String valueOf5 = String.valueOf(obj5);
            BehaviorExt behaviorExt = new BehaviorExt(valueOf, valueOf2, valueOf3, valueOf4, valueOf5);
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            this.p = new id9(pageContext, valueOf4, valueOf5, U2());
            ViewGroup viewGroup = ((FragmentPersonalChatBinding) K2()).f;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "binding.navigationContainer");
            G2(viewGroup, new ChatNavSlice());
            ViewGroup viewGroup2 = ((FragmentPersonalChatBinding) K2()).b;
            Intrinsics.checkNotNullExpressionValue(viewGroup2, "binding.chatContainer");
            G2(viewGroup2, new ChatListSlice(U2(), behaviorExt, T2(), this.p));
            ViewGroup viewGroup3 = ((FragmentPersonalChatBinding) K2()).l;
            Intrinsics.checkNotNullExpressionValue(viewGroup3, "binding.spriteContainer");
            G2(viewGroup3, new ChatSpriteSlice());
            ViewGroup viewGroup4 = ((FragmentPersonalChatBinding) K2()).i;
            Intrinsics.checkNotNullExpressionValue(viewGroup4, "binding.replyContainer");
            G2(viewGroup4, new ChatReplySlice(U2(), behaviorExt));
            ChatInputSlice chatInputSlice = new ChatInputSlice(U2(), behaviorExt);
            ViewGroup viewGroup5 = ((FragmentPersonalChatBinding) K2()).e;
            Intrinsics.checkNotNullExpressionValue(viewGroup5, "binding.inputContainer");
            G2(viewGroup5, chatInputSlice);
            this.k = chatInputSlice;
            W2();
            b3();
            TbImage tbImage = ((FragmentPersonalChatBinding) K2()).d;
            ScalingUtils.ScaleType FIT_XY = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY, "FIT_XY");
            tbImage.setScaleType(FIT_XY);
            TbImage tbImage2 = ((FragmentPersonalChatBinding) K2()).n;
            ScalingUtils.ScaleType FIT_XY2 = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY2, "FIT_XY");
            tbImage2.setScaleType(FIT_XY2);
            TbImage tbImage3 = ((FragmentPersonalChatBinding) K2()).m;
            ScalingUtils.ScaleType FIT_XY3 = ScalingUtils.ScaleType.FIT_XY;
            Intrinsics.checkNotNullExpressionValue(FIT_XY3, "FIT_XY");
            tbImage3.setScaleType(FIT_XY3);
            ((FragmentPersonalChatBinding) K2()).b.setPadding(((FragmentPersonalChatBinding) K2()).b.getPaddingLeft(), UtilHelper.getStatusBarHeight() + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X004), ((FragmentPersonalChatBinding) K2()).b.getPaddingRight(), ((FragmentPersonalChatBinding) K2()).b.getPaddingBottom());
            x85 funnySpriteConfig = TbSingleton.getInstance().getFunnySpriteConfig();
            if (funnySpriteConfig != null) {
                str = funnySpriteConfig.c();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                ((FragmentPersonalChatBinding) K2()).c.setVisibility(0);
                TextView textView = ((FragmentPersonalChatBinding) K2()).c;
                x85 funnySpriteConfig2 = TbSingleton.getInstance().getFunnySpriteConfig();
                if (funnySpriteConfig2 != null) {
                    str2 = funnySpriteConfig2.c();
                }
                textView.setText(str2);
                return;
            }
            ((FragmentPersonalChatBinding) K2()).c.setVisibility(4);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.onChangeSkinType(i);
            String V2 = V2();
            if (V2 != null) {
                TbImage tbImage = K2().n;
                String uri = Uri.fromFile(new File(V2)).toString();
                Intrinsics.checkNotNullExpressionValue(uri, "fromFile(File(this)).toString()");
                tbImage.l(uri);
            }
            String R2 = R2();
            if (R2 != null) {
                TbImage tbImage2 = K2().d;
                String uri2 = Uri.fromFile(new File(R2)).toString();
                Intrinsics.checkNotNullExpressionValue(uri2, "fromFile(File(this)).toString()");
                tbImage2.l(uri2);
            }
            String S2 = S2();
            if (S2 != null) {
                TbImage tbImage3 = K2().m;
                String uri3 = Uri.fromFile(new File(S2)).toString();
                Intrinsics.checkNotNullExpressionValue(uri3, "fromFile(File(this)).toString()");
                tbImage3.l(uri3);
            }
        }
    }
}
