package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.hz4;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class je9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ je9 a;

        public a(je9 je9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = je9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.sendMessage(new CustomMessage(2001277));
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ je9 b;

        public b(je9 je9Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je9Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = je9Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.linkUrl = ha5.t(shareItem.linkUrl, shareItem.tid, UtilHelper.isVideoThread(shareItem.obj_type));
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me9 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(me9 me9Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me9Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = me9Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            me9 me9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) && (me9Var = this.a) != null && me9Var.getThreadInfo() != null) {
                PbChosenActivity pbChosenActivity = this.b;
                if (pbChosenActivity != null && pbChosenActivity.getPageContext() != null && this.b.getPageContext().getPageActivity() != null) {
                    BdUtilHelper.hideSoftKeyPad(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
                    Activity pageActivity = this.b.getPageContext().getPageActivity();
                    long j = this.d;
                    String str = this.e;
                    String str2 = this.f;
                    String str3 = this.g;
                    String leaveMsg = this.c.getLeaveMsg();
                    me9 me9Var2 = this.a;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, je9.c(me9Var2, me9Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
                }
                hz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements hz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;
        public final /* synthetic */ ShareThreadView b;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
            this.b = shareThreadView;
        }

        @Override // com.baidu.tieba.hz4.e
        public void onClick(hz4 hz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz4Var) == null) {
                BdUtilHelper.hideSoftKeyPad(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                hz4Var.dismiss();
            }
        }
    }

    public je9(PbChosenActivity pbChosenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbChosenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(me9 me9Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{me9Var, Long.valueOf(j), str})) == null) {
            if (me9Var == null || me9Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(me9Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(me9Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(me9Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(me9Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, me9 me9Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, me9Var, Long.valueOf(j), str, str2, str3, str4}) == null) && me9Var != null && me9Var.getThreadInfo() != null) {
            hz4 hz4Var = new hz4(pbChosenActivity.getPageContext().getPageActivity());
            ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.setTitle(me9Var.getThreadInfo().title);
            shareThreadView.setDesc(me9Var.getThreadInfo()._abstract);
            shareThreadView.c(str4, false);
            hz4Var.setContentView(shareThreadView);
            hz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13b2, new c(me9Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
            hz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d2, new d(pbChosenActivity, shareThreadView));
            hz4Var.setCanceledOnTouchOutside(false);
            hz4Var.create(pbChosenActivity.getPageContext()).show();
        }
    }

    public void e(me9 me9Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, me9Var, str) == null) && me9Var != null && me9Var.getThreadInfo() != null && me9Var.getThreadInfo().excid != null) {
            String str2 = me9Var.getThreadInfo().forum.forum_name;
            String str3 = me9Var.getThreadInfo().title;
            String str4 = me9Var.getThreadInfo()._abstract;
            Resources resources = this.a.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
            String string = resources.getString(R.string.obfuscated_res_0x7f0f0459, str3);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            shareItem.linkUrl = TbConfig.TIEBA_ADDRESS + "mo/q/recommendpb?ftid=" + me9Var.getThreadInfo().excid;
            shareItem.prefferContent = string;
            shareItem.shareAbstract = str4;
            shareItem.ftid = Long.toString(me9Var.getThreadInfo().excid.longValue());
            shareItem.tid = Long.toString(me9Var.getThreadInfo().thread_id.longValue());
            shareItem.isFromChosenPb = true;
            if (!StringUtils.isNull(str)) {
                shareItem.imageUri = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new a(this));
            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
