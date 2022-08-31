package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsPrivateShareDialogView;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.vr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class kr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ FrsViewData c;
        public final /* synthetic */ ShareDialogConfig d;

        public a(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData, ShareDialogConfig shareDialogConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareItem, tbPageContext, frsViewData, shareDialogConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareItem;
            this.b = tbPageContext;
            this.c = frsViewData;
            this.d = shareDialogConfig;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.a.t).param("obj_type", 18).param("obj_source", 10));
                FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.b.getPageActivity());
                vr4 vr4Var = new vr4(this.b.getPageActivity());
                if (frsPrivateShareDialogView.d(this.c, this.b, vr4Var)) {
                    vr4Var.setContentViewSize(2);
                    vr4Var.setContentView(frsPrivateShareDialogView);
                    vr4Var.create(this.b).show();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem.param("obj_param1", this.d.experimentId);
                statisticItem.param("obj_type", 7);
                statisticItem.param("obj_source", 6);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.a.t);
                statisticItem.param("fname", this.a.s);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ TbPageContext b;

        public b(String str, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gi.a(this.a);
                ri.N(this.b.getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f0451));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ FrsShareCardView b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ ShareFromFrsMsgData f;

        public c(FrsFragment frsFragment, FrsShareCardView frsShareCardView, long j, String str, long j2, ShareFromFrsMsgData shareFromFrsMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsShareCardView, Long.valueOf(j), str, Long.valueOf(j2), shareFromFrsMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
            this.b = frsShareCardView;
            this.c = j;
            this.d = str;
            this.e = j2;
            this.f = shareFromFrsMsgData;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.b.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.o().getPageActivity(), this.c, this.d, this.e, "from_share", this.b.getLeaveMsg(), this.f.toChatMessageContent())));
                vr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements vr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsFragment a;
        public final /* synthetic */ FrsShareCardView b;

        public d(FrsFragment frsFragment, FrsShareCardView frsShareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsFragment, frsShareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsFragment;
            this.b = frsShareCardView;
        }

        @Override // com.baidu.tieba.vr4.e
        public void onClick(vr4 vr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vr4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.b.getChatMsgView());
                vr4Var.dismiss();
            }
        }
    }

    public static ShareItem a(TbPageContext tbPageContext, FrsViewData frsViewData, String str, String str2, Uri uri, String str3) {
        InterceptResult invokeCommon;
        String str4;
        String str5;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{tbPageContext, frsViewData, str, str2, uri, str3})) == null) {
            if (frsViewData == null || frsViewData.getForum() == null) {
                str4 = "";
                str5 = null;
            } else {
                str4 = frsViewData.getForum().getName();
                str5 = frsViewData.getForum().getfShareImage();
            }
            ShareItem shareItem = new ShareItem();
            shareItem.u = str4 + tbPageContext.getString(R.string.obfuscated_res_0x7f0f065b);
            shareItem.v = str3;
            shareItem.w = str2;
            shareItem.b = true;
            shareItem.H = 10;
            shareItem.t = str;
            shareItem.s = str4;
            if (StringUtils.isNull(str5)) {
                shareItem.B = 4;
                shareItem.M = frsViewData.getForum().getId();
                parse = uri;
            } else {
                parse = Uri.parse(str5);
                shareItem.B = 2;
            }
            if (parse != null) {
                shareItem.y = parse;
            }
            b(shareItem, tbPageContext, frsViewData, uri);
            return shareItem;
        }
        return (ShareItem) invokeCommon.objValue;
    }

    public static void b(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData, Uri uri) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65537, null, shareItem, tbPageContext, frsViewData, uri) == null) || shareItem == null || tbPageContext == null || frsViewData == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (frsViewData.getForum() != null) {
            str2 = frsViewData.getForum().getName();
            str = frsViewData.getForum().getSlogan();
        } else {
            str = "";
        }
        sb.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f076f));
        sb.append(str2);
        sb.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f065b));
        shareItem.E0 = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (sb2.length() > 0) {
            if (sb2.length() > 20) {
                sb2.append(sb2.substring(0, 20));
                sb2.append(StringHelper.STRING_MORE);
            }
            sb2.append(StringUtils.lineSeparator);
        }
        if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 0) {
            sb2.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f067a));
            sb2.append(" ");
            sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getMember_num()));
            sb2.append(" ");
            sb2.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0edf));
            sb2.append(" ");
            sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getPost_num()));
        }
        shareItem.F0 = sb2.toString();
        if (uri == null) {
            uri = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
        }
        shareItem.G0 = uri;
    }

    public static String c(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, forumData)) == null) {
            String str = null;
            if (forumData == null || TextUtils.isEmpty(forumData.getName())) {
                return null;
            }
            try {
                str = URLEncoder.encode(forumData.getName(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(forumData.forum_share_link)) {
                return forumData.forum_share_link + "?kw=" + str + "&fr=sharewise";
            }
            return TbConfig.HTTPS_FRS_PREFIX + str + "&fr=sharewise";
        }
        return (String) invokeL.objValue;
    }

    public static ShareFromFrsMsgData d(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, frsViewData)) == null) {
            ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
            shareFromFrsMsgData.setImageUrl(frsViewData.getForum().getImage_url());
            shareFromFrsMsgData.setName(frsViewData.getForum().getName());
            shareFromFrsMsgData.setMemberNum(frsViewData.getForum().getMember_num());
            shareFromFrsMsgData.setPostNum(frsViewData.getForum().getPost_num());
            shareFromFrsMsgData.setContent(frsViewData.getForum().getSlogan());
            return shareFromFrsMsgData;
        }
        return (ShareFromFrsMsgData) invokeL.objValue;
    }

    public static void e(FrsFragment frsFragment, FrsViewData frsViewData, long j, String str, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{frsFragment, frsViewData, Long.valueOf(j), str, Long.valueOf(j2)}) == null) || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        ShareFromFrsMsgData d2 = d(frsViewData);
        vr4 vr4Var = new vr4(frsFragment.getPageContext().getPageActivity());
        FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
        frsShareCardView.setPageId(frsFragment.getUniqueId());
        frsShareCardView.setData(d2);
        vr4Var.setContentViewSize(1);
        vr4Var.setContentView(frsShareCardView);
        vr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1129, new c(frsFragment, frsShareCardView, j, str, j2, d2));
        vr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new d(frsFragment, frsShareCardView));
        vr4Var.setCanceledOnTouchOutside(true);
        vr4Var.create(frsFragment.getPageContext()).show();
        if (qi.isEmpty(d2.getImageUrl())) {
            return;
        }
        frsShareCardView.d(d2.getImageUrl(), false);
    }

    public static void f(TbPageContext tbPageContext, FrsViewData frsViewData, String str, int i, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{tbPageContext, frsViewData, str, Integer.valueOf(i), Boolean.valueOf(z), onClickListener}) == null) || tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        if (frsViewData.getForum().getName() != null && frsViewData.getForum().getId() != null) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = frsViewData.getForum().getName();
            ForumData forum = frsViewData.getForum();
            String c2 = c(forum);
            Uri parse = frsViewData.getForum().getImage_url() == null ? null : Uri.parse(frsViewData.getForum().getImage_url());
            String slogan = frsViewData.getForum().getSlogan();
            ShareItem shareItem = new ShareItem();
            shareItem.u = name + tbPageContext.getString(R.string.obfuscated_res_0x7f0f065b);
            shareItem.v = slogan;
            shareItem.w = c2;
            shareItem.b = true;
            shareItem.H = 10;
            shareItem.t = str;
            shareItem.s = name;
            if (parse != null) {
                shareItem.y = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), shareItem, true);
            shareDialogConfig.setHasSpecialItem(true);
            shareDialogConfig.shareItem.f0 = forum;
            shareDialogConfig.setSpecialShareItems(3, a(tbPageContext, frsViewData, str, c2, parse, slogan));
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCustomCopyTitle(R.string.obfuscated_res_0x7f0f0450);
            shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f0ee9, R.drawable.obfuscated_res_0x7f0809d1, new a(shareItem, tbPageContext, frsViewData, shareDialogConfig));
            shareDialogConfig.setCopyLinkListener(new b(c2, tbPageContext));
            shareDialogConfig.experimentId = jp6.c();
            tbPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
            return;
        }
        tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0c65));
    }

    public static void g(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, tbPageContext, frsViewData) == null) {
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
            vr4 vr4Var = new vr4(tbPageContext.getPageActivity());
            if (frsPrivateShareDialogView.d(frsViewData, tbPageContext, vr4Var)) {
                vr4Var.setContentViewSize(2);
                vr4Var.setContentView(frsPrivateShareDialogView);
                vr4Var.create(tbPageContext).show();
            }
        }
    }
}
