package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.controller.TransmitShareController;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes7.dex */
public class p6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;
        public final /* synthetic */ AbsPbActivity b;
        public final /* synthetic */ View c;

        public a(PbModel pbModel, AbsPbActivity absPbActivity, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, absPbActivity, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
            this.b = absPbActivity;
            this.c = view2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PbModel pbModel;
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && (pbModel = this.a) != null && pbModel.s1() != null && this.a.s1().y0() && !TbSingleton.getInstance().isNotchScreen(this.b) && !TbSingleton.getInstance().isCutoutScreen(this.b) && (view2 = this.c) != null) {
                view2.setSystemUiVisibility(4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(AbsPbActivity absPbActivity, int i, int i2) {
        boolean z;
        ThreadData R;
        String M1;
        String str;
        String str2;
        Uri parse;
        String str3;
        ShareItem shareItem;
        char c;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65536, null, absPbActivity, i, i2) == null) && absPbActivity != null && absPbActivity.B1() != null) {
            PbModel B1 = absPbActivity.B1();
            View rootView = absPbActivity.getRootView();
            if (!B1.d()) {
                return;
            }
            TiebaStatic.eventStat(absPbActivity, CheckRealNameModel.TYPE_PB_SHARE, "pbclick", 1, new Object[0]);
            zv9 s1 = B1.s1();
            String title = s1.R().getTitle();
            boolean V0 = B1.V0();
            if (s1.n() != null) {
                if (s1.n().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && AddExperiencedModel.T(s1.o())) {
                    z = true;
                    R = B1.s1().R();
                    if (!R.isUgcThreadType()) {
                        M1 = R.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&see_lz=" + (V0 ? 1 : 0) + "&dtype=" + R.getBaijiahaoData().oriUgcType + "&dvid=" + R.getBaijiahaoData().oriUgcVid + "&nid=" + R.getBaijiahaoData().oriUgcNid;
                    } else {
                        M1 = B1.M1();
                        str = "?share=9105&fr=sharewise&see_lz=" + (V0 ? 1 : 0);
                    }
                    String str4 = TbConfig.HTTPS_PB_PREFIX + M1 + (str + "&share_from=post");
                    String[] O = s1.O();
                    str2 = O[0];
                    if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                        str2 = str2.substring(37);
                    }
                    if (str2 != null) {
                        parse = null;
                    } else {
                        parse = Uri.parse(str2);
                    }
                    str3 = O[1];
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    if (i == 1) {
                        b6a.D("c10399", s1.o(), s1.T(), currentAccount);
                    }
                    String string = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                    if (!s1.a() && R.getAuthor() != null) {
                        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(str3) || R.isBJHVideoDynamicThreadType() || R.isBJHVideoThreadType()) {
                            if (TextUtils.isEmpty(title)) {
                                c = 1;
                                title = O[1];
                            } else {
                                c = 1;
                            }
                            Object[] objArr = new Object[2];
                            objArr[0] = R.getAuthor().getName_show();
                            objArr[c] = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix);
                            str3 = MessageFormat.format(string, objArr);
                        }
                    } else if (rd.isEmpty(str3)) {
                        str3 = title;
                    }
                    String cutString = rd.cutString(title, 100);
                    String cutString2 = rd.cutString(str3, 100);
                    shareItem = new ShareItem();
                    shareItem.title = cutString;
                    shareItem.content = cutString2;
                    if (!s1.a()) {
                        shareItem.shareAbstract = cutString2;
                        shareItem.readCount = -1L;
                    } else if (s1.R() != null && s1.R().getThreadVideoInfo() != null && !s1.R().isUgcThreadType()) {
                        shareItem.readCount = s1.R().getThreadVideoInfo().play_count.intValue();
                    }
                    shareItem.linkUrl = str4;
                    shareItem.isFromSharePb = true;
                    shareItem.isShowAddExperienceTip = z;
                    shareItem.extData = B1.M1();
                    shareItem.objParam1 = 3;
                    shareItem.objSource = i2;
                    shareItem.fid = B1.getForumId();
                    shareItem.tid = B1.M1();
                    shareItem.obj_type = s4a.e(s1);
                    shareItem.uid = TbadkCoreApplication.getCurrentAccount();
                    if (parse != null) {
                        shareItem.imageUri = parse;
                    }
                    if (i2 == 2) {
                        shareItem.objParam1 = B1.W0();
                    }
                    if (s1.a()) {
                        shareItem.canShareBySmartApp = false;
                    }
                    shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(R);
                    if (s1 == null && s1.I() != null && s1.I().size() > 0) {
                        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, s1.I().get(0));
                    } else {
                        shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, null);
                    }
                    TbadkCoreApplication.getInst().setShareItem(shareItem);
                    if (R != null) {
                        shareItem.smartAppShareImageUrl = R.getShareImageUrl();
                    }
                    shareItem.objParam2 = s4a.d(R);
                    Bundle bundle = new Bundle();
                    bundle.putInt("obj_param1", shareItem.objParam1);
                    bundle.putInt("obj_type", shareItem.obj_type);
                    bundle.putString("fid", shareItem.fid);
                    bundle.putString("tid", shareItem.tid);
                    bundle.putString("uid", shareItem.uid);
                    shareItem.setStats(bundle);
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
                    shareDialogConfig.setOnDismissListener(new a(B1, absPbActivity, rootView));
                    shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                    TransmitShareController.getInstance().showShareDialog(shareDialogConfig);
                }
            }
            z = false;
            R = B1.s1().R();
            if (!R.isUgcThreadType()) {
            }
            String str42 = TbConfig.HTTPS_PB_PREFIX + M1 + (str + "&share_from=post");
            String[] O2 = s1.O();
            str2 = O2[0];
            if (!StringUtils.isNull(str2)) {
                str2 = str2.substring(37);
            }
            if (str2 != null) {
            }
            str3 = O2[1];
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (i == 1) {
            }
            String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!s1.a()) {
            }
            if (rd.isEmpty(str3)) {
            }
            String cutString3 = rd.cutString(title, 100);
            String cutString22 = rd.cutString(str3, 100);
            shareItem = new ShareItem();
            shareItem.title = cutString3;
            shareItem.content = cutString22;
            if (!s1.a()) {
            }
            shareItem.linkUrl = str42;
            shareItem.isFromSharePb = true;
            shareItem.isShowAddExperienceTip = z;
            shareItem.extData = B1.M1();
            shareItem.objParam1 = 3;
            shareItem.objSource = i2;
            shareItem.fid = B1.getForumId();
            shareItem.tid = B1.M1();
            shareItem.obj_type = s4a.e(s1);
            shareItem.uid = TbadkCoreApplication.getCurrentAccount();
            if (parse != null) {
            }
            if (i2 == 2) {
            }
            if (s1.a()) {
            }
            shareItem.originalThreadInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(R);
            if (s1 == null) {
            }
            shareItem.forwardInfo = ShareItem.ForwardInfo.generateForwardInfo(R, 1, null);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            if (R != null) {
            }
            shareItem.objParam2 = s4a.d(R);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.objParam1);
            bundle2.putInt("obj_type", shareItem.obj_type);
            bundle2.putString("fid", shareItem.fid);
            bundle2.putString("tid", shareItem.tid);
            bundle2.putString("uid", shareItem.uid);
            shareItem.setStats(bundle2);
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig((Context) absPbActivity, shareItem, true, true);
            shareDialogConfig2.setOnDismissListener(new a(B1, absPbActivity, rootView));
            shareDialogConfig2.setFrom(ShareDialogConfig.From.PB);
            TransmitShareController.getInstance().showShareDialog(shareDialogConfig2);
        }
    }
}
