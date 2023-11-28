package com.baidu.tieba.immessagecenter.im.chat;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/immessagecenter/im/chat/ForumGroupListActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "()V", "groupChatDialogFragment", "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/chatdialog/GroupChatDialogFragment;", "getGroupChatDialogFragment", "()Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/chatdialog/GroupChatDialogFragment;", "groupChatDialogFragment$delegate", "Lkotlin/Lazy;", "onChangeSkinType", "", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumGroupListActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    public ForumGroupListActivity() {
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
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<GroupChatDialogFragment>(this) { // from class: com.baidu.tieba.immessagecenter.im.chat.ForumGroupListActivity$groupChatDialogFragment$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ForumGroupListActivity this$0;

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
            public final GroupChatDialogFragment invoke() {
                InterceptResult invokeV;
                long j;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    GroupChatDialogFragment groupChatDialogFragment = new GroupChatDialogFragment();
                    ForumGroupListActivity forumGroupListActivity = this.this$0;
                    String stringExtra = forumGroupListActivity.getIntent().getStringExtra("forumId");
                    String str = "";
                    if (stringExtra == null) {
                        stringExtra = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(Sc…stant.KEY_FORUM_ID) ?: \"\"");
                    }
                    String stringExtra2 = forumGroupListActivity.getIntent().getStringExtra(ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME);
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(Sc…ant.KEY_FORUM_NAME) ?: \"\"");
                    }
                    String stringExtra3 = forumGroupListActivity.getIntent().getStringExtra("roomId");
                    if (stringExtra3 != null) {
                        Intrinsics.checkNotNullExpressionValue(stringExtra3, "intent.getStringExtra(Sc…nstant.KEY_ROOM_ID) ?: \"\"");
                        str = stringExtra3;
                    }
                    Bundle bundle = new Bundle();
                    Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(stringExtra);
                    long j2 = 0;
                    if (longOrNull != null) {
                        j = longOrNull.longValue();
                    } else {
                        j = 0;
                    }
                    bundle.putLong("key_group_chat_forum_id", j);
                    bundle.putString("key_group_chat_forum_name", stringExtra2);
                    Long longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
                    if (longOrNull2 != null) {
                        j2 = longOrNull2.longValue();
                    }
                    bundle.putLong("key_group_chat_room_id", j2);
                    bundle.putBoolean("key_is_dialog", false);
                    bundle.putString("key_group_chat_souce", "frs");
                    groupChatDialogFragment.setArguments(bundle);
                    return groupChatDialogFragment;
                }
                return (GroupChatDialogFragment) invokeV.objValue;
            }
        });
    }

    public final GroupChatDialogFragment l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (GroupChatDialogFragment) this.a.getValue();
        }
        return (GroupChatDialogFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            l1().W2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d003b);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
            beginTransaction.replace(R.id.obfuscated_res_0x7f090c35, l1());
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
