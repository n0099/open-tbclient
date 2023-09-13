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
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class li9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li9 a;

        public a(li9 li9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li9Var;
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
        public final /* synthetic */ li9 b;

        public b(li9 li9Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li9Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li9Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.linkUrl = wf5.t(shareItem.linkUrl, shareItem.tid, UtilHelper.isVideoThread(shareItem.obj_type));
                AndroidUtils.copyToClipboard(this.a.linkUrl);
                BdUtilHelper.showToast(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oi9 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(oi9 oi9Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oi9Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oi9Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            oi9 oi9Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) && (oi9Var = this.a) != null && oi9Var.getThreadInfo() != null) {
                PbChosenActivity pbChosenActivity = this.b;
                if (pbChosenActivity != null && pbChosenActivity.getPageContext() != null && this.b.getPageContext().getPageActivity() != null) {
                    BdUtilHelper.hideSoftKeyPad(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
                    Activity pageActivity = this.b.getPageContext().getPageActivity();
                    long j = this.d;
                    String str = this.e;
                    String str2 = this.f;
                    String str3 = this.g;
                    String leaveMsg = this.c.getLeaveMsg();
                    oi9 oi9Var2 = this.a;
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, li9.c(oi9Var2, oi9Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
                }
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements y45.e {
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

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                BdUtilHelper.hideSoftKeyPad(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                y45Var.dismiss();
            }
        }
    }

    public li9(PbChosenActivity pbChosenActivity) {
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

    public static ShareFromPBMsgData c(oi9 oi9Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{oi9Var, Long.valueOf(j), str})) == null) {
            if (oi9Var == null || oi9Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(oi9Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(oi9Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(oi9Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(oi9Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, oi9 oi9Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, oi9Var, Long.valueOf(j), str, str2, str3, str4}) == null) && oi9Var != null && oi9Var.getThreadInfo() != null) {
            y45 y45Var = new y45(pbChosenActivity.getPageContext().getPageActivity());
            ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.setTitle(oi9Var.getThreadInfo().title);
            shareThreadView.setDesc(oi9Var.getThreadInfo()._abstract);
            shareThreadView.c(str4, false);
            y45Var.setContentView(shareThreadView);
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f13a0, new c(oi9Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new d(pbChosenActivity, shareThreadView));
            y45Var.setCanceledOnTouchOutside(false);
            y45Var.create(pbChosenActivity.getPageContext()).show();
        }
    }

    public void e(oi9 oi9Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, oi9Var, str) == null) && oi9Var != null && oi9Var.getThreadInfo() != null && oi9Var.getThreadInfo().excid != null) {
            String str2 = oi9Var.getThreadInfo().forum.forum_name;
            String str3 = oi9Var.getThreadInfo().title;
            String str4 = oi9Var.getThreadInfo()._abstract;
            Resources resources = this.a.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
            String string = resources.getString(R.string.obfuscated_res_0x7f0f0457, str3);
            ShareItem shareItem = new ShareItem();
            shareItem.title = str3;
            shareItem.content = format;
            shareItem.linkUrl = TbConfig.TIEBA_ADDRESS + "mo/q/recommendpb?ftid=" + oi9Var.getThreadInfo().excid;
            shareItem.prefferContent = string;
            shareItem.shareAbstract = str4;
            shareItem.ftid = Long.toString(oi9Var.getThreadInfo().excid.longValue());
            shareItem.tid = Long.toString(oi9Var.getThreadInfo().thread_id.longValue());
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
