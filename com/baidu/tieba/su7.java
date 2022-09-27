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
import com.baidu.tieba.nu4;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes5.dex */
public class su7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ su7 a;

        public a(su7 su7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = su7Var;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ su7 b;

        public b(su7 su7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {su7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = su7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.x = e35.u(shareItem.x, shareItem.O, UtilHelper.isVideoThread(shareItem.Q));
                ui.a(this.a.x);
                ej.N(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0455));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(vu7 vu7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            vu7 vu7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) || (vu7Var = this.a) == null || vu7Var.getThreadInfo() == null) {
                return;
            }
            ej.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            String str2 = this.f;
            String str3 = this.g;
            String leaveMsg = this.c.getLeaveMsg();
            vu7 vu7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, su7.c(vu7Var2, vu7Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
            nu4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                ej.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;
        public final /* synthetic */ String g;

        public e(vu7 vu7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vu7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = j2;
            this.g = str2;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            vu7 vu7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) || (vu7Var = this.a) == null || vu7Var.getThreadInfo() == null) {
                return;
            }
            ej.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
            Activity pageActivity = this.b.getPageContext().getPageActivity();
            long j = this.d;
            String str = this.e;
            long j2 = this.f;
            String leaveMsg = this.c.getLeaveMsg();
            vu7 vu7Var2 = this.a;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, su7.c(vu7Var2, vu7Var2.getThreadInfo().excid.longValue(), this.g).toChatMessageContent())));
            nu4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                ej.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                nu4Var.dismiss();
            }
        }
    }

    public su7(PbChosenActivity pbChosenActivity) {
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

    public static ShareFromPBMsgData c(vu7 vu7Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{vu7Var, Long.valueOf(j), str})) == null) {
            if (vu7Var == null || vu7Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(vu7Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(vu7Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(vu7Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(vu7Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, vu7 vu7Var, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, vu7Var, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) || vu7Var == null || vu7Var.getThreadInfo() == null) {
            return;
        }
        nu4 nu4Var = new nu4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.c(str2, false);
        shareThreadView.setTitle(vu7Var.getThreadInfo().title);
        shareThreadView.setDesc(vu7Var.getThreadInfo()._abstract);
        nu4Var.setContentView(shareThreadView);
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1146, new e(vu7Var, pbChosenActivity, shareThreadView, j, str, j2, str2));
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new f(pbChosenActivity, shareThreadView));
        nu4Var.setCanceledOnTouchOutside(false);
        nu4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public static void e(PbChosenActivity pbChosenActivity, vu7 vu7Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, vu7Var, Long.valueOf(j), str, str2, str3, str4}) == null) || vu7Var == null || vu7Var.getThreadInfo() == null) {
            return;
        }
        nu4 nu4Var = new nu4(pbChosenActivity.getPageContext().getPageActivity());
        ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
        shareThreadView.setTitle(vu7Var.getThreadInfo().title);
        shareThreadView.setDesc(vu7Var.getThreadInfo()._abstract);
        shareThreadView.c(str4, false);
        nu4Var.setContentView(shareThreadView);
        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1146, new c(vu7Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(pbChosenActivity, shareThreadView));
        nu4Var.setCanceledOnTouchOutside(false);
        nu4Var.create(pbChosenActivity.getPageContext()).show();
    }

    public void f(vu7 vu7Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, vu7Var, str) == null) || vu7Var == null || vu7Var.getThreadInfo() == null || vu7Var.getThreadInfo().excid == null) {
            return;
        }
        String str2 = vu7Var.getThreadInfo().forum.forum_name;
        String str3 = vu7Var.getThreadInfo().title;
        String str4 = vu7Var.getThreadInfo()._abstract;
        Resources resources = this.a.getPageContext().getPageActivity().getResources();
        String format = MessageFormat.format(resources.getString(R.string.obfuscated_res_0x7f0f114e), str3, str4);
        resources.getString(R.string.obfuscated_res_0x7f0f03de, str3);
        ShareItem shareItem = new ShareItem();
        shareItem.v = str3;
        shareItem.w = format;
        shareItem.x = TbConfig.TIEBA_ADDRESS + "mo/q/recommendpb?ftid=" + vu7Var.getThreadInfo().excid;
        shareItem.H = str4;
        shareItem.G = Long.toString(vu7Var.getThreadInfo().excid.longValue());
        shareItem.O = Long.toString(vu7Var.getThreadInfo().thread_id.longValue());
        shareItem.a = true;
        if (!StringUtils.isNull(str)) {
            shareItem.z = Uri.parse(str);
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
        shareDialogConfig.setIsCopyLink(true);
        shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f068c, R.drawable.icon_share_friends_n, new a(this));
        shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
        this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
