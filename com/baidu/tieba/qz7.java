package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.lv4;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes6.dex */
public class qz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz7 a;

        public a(qz7 qz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qz7Var;
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
        public final /* synthetic */ qz7 b;

        public b(qz7 qz7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qz7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qz7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.x = j45.u(shareItem.x, shareItem.O, UtilHelper.isVideoThread(shareItem.Q));
                oi.a(this.a.x);
                yi.Q(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(tz7 tz7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            tz7 tz7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) && (tz7Var = this.a) != null && tz7Var.getThreadInfo() != null) {
                yi.z(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
                Activity pageActivity = this.b.getPageContext().getPageActivity();
                long j = this.d;
                String str = this.e;
                String str2 = this.f;
                String str3 = this.g;
                String leaveMsg = this.c.getLeaveMsg();
                tz7 tz7Var2 = this.a;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, qz7.c(tz7Var2, tz7Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                yi.z(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;
        public final /* synthetic */ String g;

        public e(tz7 tz7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tz7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = j2;
            this.g = str2;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            tz7 tz7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) && (tz7Var = this.a) != null && tz7Var.getThreadInfo() != null) {
                yi.z(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
                Activity pageActivity = this.b.getPageContext().getPageActivity();
                long j = this.d;
                String str = this.e;
                long j2 = this.f;
                String leaveMsg = this.c.getLeaveMsg();
                tz7 tz7Var2 = this.a;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, qz7.c(tz7Var2, tz7Var2.getThreadInfo().excid.longValue(), this.g).toChatMessageContent())));
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;
        public final /* synthetic */ ShareThreadView b;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                yi.z(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                lv4Var.dismiss();
            }
        }
    }

    public qz7(PbChosenActivity pbChosenActivity) {
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

    public static ShareFromPBMsgData c(tz7 tz7Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{tz7Var, Long.valueOf(j), str})) == null) {
            if (tz7Var == null || tz7Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(tz7Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(tz7Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(tz7Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(tz7Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, tz7 tz7Var, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, tz7Var, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) && tz7Var != null && tz7Var.getThreadInfo() != null) {
            lv4 lv4Var = new lv4(pbChosenActivity.getPageContext().getPageActivity());
            ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.c(str2, false);
            shareThreadView.setTitle(tz7Var.getThreadInfo().title);
            shareThreadView.setDesc(tz7Var.getThreadInfo()._abstract);
            lv4Var.setContentView(shareThreadView);
            lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f11b7, new e(tz7Var, pbChosenActivity, shareThreadView, j, str, j2, str2));
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new f(pbChosenActivity, shareThreadView));
            lv4Var.setCanceledOnTouchOutside(false);
            lv4Var.create(pbChosenActivity.getPageContext()).show();
        }
    }

    public static void e(PbChosenActivity pbChosenActivity, tz7 tz7Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, tz7Var, Long.valueOf(j), str, str2, str3, str4}) == null) && tz7Var != null && tz7Var.getThreadInfo() != null) {
            lv4 lv4Var = new lv4(pbChosenActivity.getPageContext().getPageActivity());
            ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.setTitle(tz7Var.getThreadInfo().title);
            shareThreadView.setDesc(tz7Var.getThreadInfo()._abstract);
            shareThreadView.c(str4, false);
            lv4Var.setContentView(shareThreadView);
            lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f11b7, new c(tz7Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new d(pbChosenActivity, shareThreadView));
            lv4Var.setCanceledOnTouchOutside(false);
            lv4Var.create(pbChosenActivity.getPageContext()).show();
        }
    }

    public void f(tz7 tz7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, tz7Var, str) == null) && tz7Var != null && tz7Var.getThreadInfo() != null && tz7Var.getThreadInfo().excid != null) {
            String str2 = tz7Var.getThreadInfo().forum.forum_name;
            String str3 = tz7Var.getThreadInfo().title;
            String str4 = tz7Var.getThreadInfo()._abstract;
            Resources resources = this.a.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(R.string.share_content_tpl), str3, str4);
            resources.getString(R.string.obfuscated_res_0x7f0f03ee, str3);
            ShareItem shareItem = new ShareItem();
            shareItem.v = str3;
            shareItem.w = format;
            shareItem.x = TbConfig.TIEBA_ADDRESS + "mo/q/recommendpb?ftid=" + tz7Var.getThreadInfo().excid;
            shareItem.H = str4;
            shareItem.G = Long.toString(tz7Var.getThreadInfo().excid.longValue());
            shareItem.O = Long.toString(tz7Var.getThreadInfo().thread_id.longValue());
            shareItem.a = true;
            if (!StringUtils.isNull(str)) {
                shareItem.z = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(R.string.forum_friend, R.drawable.icon_share_friends_n, new a(this));
            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
