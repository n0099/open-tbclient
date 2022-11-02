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
import com.baidu.tieba.iv4;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class zu6 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).param("fid", this.a.u).param("obj_type", 18).param("obj_source", 10));
                FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(this.b.getPageActivity());
                iv4 iv4Var = new iv4(this.b.getPageActivity());
                if (frsPrivateShareDialogView.d(this.c, this.b, iv4Var)) {
                    iv4Var.setContentViewSize(2);
                    iv4Var.setContentView(frsPrivateShareDialogView);
                    iv4Var.create(this.b).show();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
                statisticItem.param("obj_param1", this.d.experimentId);
                statisticItem.param("obj_type", 7);
                statisticItem.param("obj_source", 6);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.a.u);
                statisticItem.param("fname", this.a.t);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                ni.a(this.a);
                xi.P(this.b.getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f045e));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.b.getChatMsgView());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.o().getPageActivity(), this.c, this.d, this.e, "from_share", this.b.getLeaveMsg(), this.f.toChatMessageContent())));
                iv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements iv4.e {
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

        @Override // com.baidu.tieba.iv4.e
        public void onClick(iv4 iv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                this.a.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), this.b.getChatMsgView());
                iv4Var.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948372494, "Lcom/baidu/tieba/zu6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948372494, "Lcom/baidu/tieba/zu6;");
                return;
            }
        }
        a = TbConfig.HTTPS_FRS_PREFIX;
    }

    public static ShareItem a(TbPageContext tbPageContext, FrsViewData frsViewData, String str, String str2, Uri uri, String str3) {
        InterceptResult invokeCommon;
        String str4;
        String str5;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, frsViewData, str, str2, uri, str3})) == null) {
            if (frsViewData != null && frsViewData.getForum() != null) {
                str4 = frsViewData.getForum().getName();
                str5 = frsViewData.getForum().getfShareImage();
            } else {
                str4 = "";
                str5 = null;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.v = str4 + tbPageContext.getString(R.string.obfuscated_res_0x7f0f067a);
            shareItem.w = str3;
            shareItem.x = str2;
            shareItem.b = true;
            shareItem.I = 10;
            shareItem.u = str;
            shareItem.t = str4;
            if (StringUtils.isNull(str5)) {
                shareItem.C = 4;
                shareItem.N = frsViewData.getForum().getId();
                parse = uri;
            } else {
                parse = Uri.parse(str5);
                shareItem.C = 2;
            }
            if (parse != null) {
                shareItem.z = parse;
            }
            b(shareItem, tbPageContext, frsViewData, uri);
            return shareItem;
        }
        return (ShareItem) invokeCommon.objValue;
    }

    public static void b(ShareItem shareItem, TbPageContext tbPageContext, FrsViewData frsViewData, Uri uri) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65538, null, shareItem, tbPageContext, frsViewData, uri) == null) && shareItem != null && tbPageContext != null && frsViewData != null) {
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            if (frsViewData.getForum() == null) {
                str = "";
            } else {
                str2 = frsViewData.getForum().getName();
                str = frsViewData.getForum().getSlogan();
            }
            sb.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0791));
            sb.append(str2);
            sb.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f067a));
            shareItem.G0 = sb.toString();
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
                sb2.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0699));
                sb2.append(" ");
                sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getMember_num()));
                sb2.append(" ");
                sb2.append(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0f26));
                sb2.append(" ");
                sb2.append(StringHelper.numFormatOver10000(frsViewData.getForum().getPost_num()));
            }
            shareItem.H0 = sb2.toString();
            if (uri == null) {
                uri = Uri.parse("https://tb5.bdstatic.com/yunying/tieba_logo.jpg");
            }
            shareItem.I0 = uri;
        }
    }

    public static String c(ForumData forumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, forumData)) == null) {
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
            return a + str + "&fr=sharewise";
        }
        return (String) invokeL.objValue;
    }

    public static ShareFromFrsMsgData d(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, frsViewData)) == null) {
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
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{frsFragment, frsViewData, Long.valueOf(j), str, Long.valueOf(j2)}) == null) && frsViewData != null && frsViewData.getForum() != null) {
            ShareFromFrsMsgData d2 = d(frsViewData);
            iv4 iv4Var = new iv4(frsFragment.getPageContext().getPageActivity());
            FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
            frsShareCardView.setPageId(frsFragment.getUniqueId());
            frsShareCardView.setData(d2);
            iv4Var.setContentViewSize(1);
            iv4Var.setContentView(frsShareCardView);
            iv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1179, new c(frsFragment, frsShareCardView, j, str, j2, d2));
            iv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(frsFragment, frsShareCardView));
            iv4Var.setCanceledOnTouchOutside(true);
            iv4Var.create(frsFragment.getPageContext()).show();
            if (!wi.isEmpty(d2.getImageUrl())) {
                frsShareCardView.d(d2.getImageUrl(), false);
            }
        }
    }

    public static void f(TbPageContext tbPageContext, FrsViewData frsViewData, String str, int i, boolean z, View.OnClickListener onClickListener) {
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{tbPageContext, frsViewData, str, Integer.valueOf(i), Boolean.valueOf(z), onClickListener}) == null) && tbPageContext != null && frsViewData != null && frsViewData.getForum() != null) {
            if (frsViewData.getForum().getName() != null && frsViewData.getForum().getId() != null) {
                TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
                String name = frsViewData.getForum().getName();
                ForumData forum = frsViewData.getForum();
                String c2 = c(forum);
                if (frsViewData.getForum().getImage_url() == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(frsViewData.getForum().getImage_url());
                }
                Uri uri = parse;
                String slogan = frsViewData.getForum().getSlogan();
                ShareItem shareItem = new ShareItem();
                shareItem.v = name + tbPageContext.getString(R.string.obfuscated_res_0x7f0f067a);
                shareItem.w = slogan;
                shareItem.x = c2;
                shareItem.b = true;
                shareItem.I = 10;
                shareItem.u = str;
                shareItem.t = name;
                if (uri != null) {
                    shareItem.z = uri;
                }
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), shareItem, true);
                shareDialogConfig.setHasSpecialItem(true);
                shareDialogConfig.shareItem.g0 = forum;
                shareDialogConfig.setSpecialShareItems(3, a(tbPageContext, frsViewData, str, c2, uri, slogan));
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCustomCopyTitle(R.string.obfuscated_res_0x7f0f045d);
                shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f0f30, R.drawable.obfuscated_res_0x7f080a08, new a(shareItem, tbPageContext, frsViewData, shareDialogConfig));
                shareDialogConfig.setCopyLinkListener(new b(c2, tbPageContext));
                shareDialogConfig.experimentId = ws6.c();
                tbPageContext.sendMessage(new CustomMessage(2001276, shareDialogConfig));
                return;
            }
            tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f0ca6));
        }
    }

    public static void g(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, tbPageContext, frsViewData) == null) {
            FrsPrivateShareDialogView frsPrivateShareDialogView = new FrsPrivateShareDialogView(tbPageContext.getPageActivity());
            iv4 iv4Var = new iv4(tbPageContext.getPageActivity());
            if (frsPrivateShareDialogView.d(frsViewData, tbPageContext, iv4Var)) {
                iv4Var.setContentViewSize(2);
                iv4Var.setContentView(frsPrivateShareDialogView);
                iv4Var.create(tbPageContext).show();
            }
        }
    }
}
