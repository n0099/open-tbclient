package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Item;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes7.dex */
public class sc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i == 1) {
                return 5;
            }
            if (i == 3) {
                return 3;
            }
            if (i == 4) {
                return 4;
            }
            if (i == 6) {
                return 8;
            }
            if (i == 10) {
                return 16;
            }
            if (i == 11) {
                return 24;
            }
            if (i == 12) {
                return 20;
            }
            if (i == 13) {
                return 30;
            }
            return i == 15 ? 33 : 0;
        }
        return invokeI.intValue;
    }

    public static void a(ShareDialogConfig shareDialogConfig, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, shareDialogConfig, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        if (i != 16) {
                            if (i != 7) {
                                if (i != 8) {
                                    if (i != 9) {
                                        if (i != 12) {
                                            if (i != 13) {
                                                shareDialogConfig.setFrom(ShareDialogConfig.From.Default);
                                                return;
                                            } else {
                                                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                                                return;
                                            }
                                        }
                                        shareDialogConfig.setFrom(ShareDialogConfig.From.HomeGameTab);
                                        return;
                                    }
                                    shareDialogConfig.setFrom(ShareDialogConfig.From.Concern);
                                    return;
                                }
                                shareDialogConfig.setFrom(ShareDialogConfig.From.PersonPolymeric);
                                return;
                            }
                            shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
                            return;
                        }
                        shareDialogConfig.setFrom(ShareDialogConfig.From.HomeVideoTab);
                        return;
                    }
                    shareDialogConfig.setFrom(ShareDialogConfig.From.PB);
                    return;
                }
                shareDialogConfig.setFrom(ShareDialogConfig.From.FRS);
                return;
            }
            shareDialogConfig.setFrom(ShareDialogConfig.From.Recommend);
        }
    }

    public static void b(Context context, ThreadData threadData) {
        ItemInfo C0;
        List<ItemPoint> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, context, threadData) == null) && (context instanceof g97)) {
            g97 g97Var = (g97) context;
            if (!g97Var.M() || threadData == null || threadData.getItem() != null || (C0 = g97Var.C0()) == null) {
                return;
            }
            Item.Builder builder = new Item.Builder();
            builder.item_id = Long.valueOf(C0.id.longValue());
            builder.item_name = C0.name;
            builder.icon_size = C0.icon_size;
            builder.icon_url = C0.icon_url;
            builder.tags = C0.tags;
            ItemTable itemTable = C0.score;
            if (itemTable != null && (list = itemTable.item_point) != null) {
                Iterator<ItemPoint> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ItemPoint next = it.next();
                    if (next.time_intval.equals("all")) {
                        Double d = next.point;
                        builder.score = d;
                        builder.star = Integer.valueOf((int) (d.doubleValue() / 2.0d));
                        break;
                    }
                }
            }
            Item build = builder.build(false);
            ItemData itemData = new ItemData();
            itemData.parseProto(build);
            threadData.setItemData(itemData);
        }
    }

    public static String c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
            String str = null;
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !TextUtils.isEmpty(threadData.getThreadAlaInfo().cover)) {
                return threadData.getThreadAlaInfo().cover;
            }
            if (threadData.getVoiceRoomData() != null && threadData.getVoiceRoomData().room_id.longValue() > 0) {
                if (threadData.getForumData() == null) {
                    return null;
                }
                return threadData.getForumData().c;
            } else if (threadData.getMedias() == null) {
                return null;
            } else {
                ArrayList<MediaData> medias = threadData.getMedias();
                int size = medias.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    MediaData mediaData = medias.get(i);
                    if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                        if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                            str = mediaData.getThumbnails_url();
                            break;
                        } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                            str = mediaData.getPicUrl();
                            break;
                        }
                    }
                    i++;
                }
                if (str == null && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) {
                    return threadData.getThreadVideoInfo().thumbnail_url;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, threadData)) == null) {
            if (threadData == null) {
                return 0;
            }
            if (threadData.isVideoWorksInfo()) {
                return 11;
            }
            if (threadData.isBJHArticleThreadType()) {
                return 10;
            }
            if (threadData.isBJHVideoThreadType()) {
                return 9;
            }
            if (threadData.isBJHVideoDynamicThreadType()) {
                return 8;
            }
            if (threadData.isBJHNormalThreadType()) {
                return 7;
            }
            if (threadData.isShareThread) {
                return 6;
            }
            int i = threadData.threadType;
            if (i == 0) {
                return 1;
            }
            if (i == 40) {
                return 2;
            }
            if (i != 49 && i != 69) {
                if (i == 54) {
                    return 4;
                }
                return 5;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x030e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(Context context, ThreadData threadData, int i, int i2) {
        String tid;
        String str;
        String str2;
        boolean z;
        boolean z2;
        String c;
        Uri parse;
        boolean z3;
        String format;
        ShareItem shareItem;
        boolean z4;
        boolean z5;
        OriginalThreadInfo.ShareInfo generateShareInfo;
        ThreadData threadData2;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLII(65541, null, context, threadData, i, i2) == null) && threadData != null && context != null) {
            String valueOf = String.valueOf(threadData.getFid());
            String forum_name = threadData.getForum_name();
            OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
            if (originalForumInfo != null) {
                valueOf = originalForumInfo.id;
                forum_name = originalForumInfo.ori_fname;
            }
            String str3 = forum_name;
            String str4 = valueOf;
            String title = threadData.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = threadData.getAbstract();
            }
            String str5 = title;
            if (threadData.isUgcThreadType()) {
                tid = threadData.getBaijiahaoData().oriUgcTid;
                str = "?share=9105&fr=dshare&dtype=" + threadData.getBaijiahaoData().oriUgcType + "&dvid=" + threadData.getBaijiahaoData().oriUgcVid + "&nid=" + threadData.getBaijiahaoData().oriUgcNid;
            } else {
                tid = threadData.getTid();
                str = "?share=9105&fr=sharewise";
            }
            String str6 = str;
            String str7 = tid;
            String str8 = str6 + "&share_from=post";
            if (threadData.getVoiceRoomData() != null && threadData.getVoiceRoomData().room_id.longValue() > 0) {
                str2 = String.format(TbConfig.TIEBA_ADDRESS + "mo/q/wise-main-share/shareVoiceRoom?room_id=%s", String.valueOf(threadData.getVoiceRoomData().room_id));
                z = true;
            } else {
                str2 = TbConfig.HTTPS_PB_PREFIX + str7 + str8;
                z = false;
            }
            if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null) {
                try {
                    str2 = "https://tieba.baidu.com/ala/share?uname=" + URLEncoder.encode(threadData.getThreadAlaInfo().user_info.user_name, IMAudioTransRequest.CHARSET);
                    z2 = false;
                } catch (Exception e) {
                    BdLog.e(e);
                }
                if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().isLegalYYLiveData()) {
                    str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + threadData.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + threadData.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + threadData.getThreadAlaInfo().mYyExtData.mYyUid;
                    z2 = false;
                }
                c = c(threadData);
                if (c != null) {
                    parse = null;
                } else {
                    parse = Uri.parse(c);
                }
                String str9 = threadData.getAbstract();
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.share_content_tpl);
                String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
                if (!threadData.isUgcThreadType() && threadData.getAuthor() != null) {
                    if (!TextUtils.isEmpty(threadData.getTitle()) && !TextUtils.isEmpty(str9)) {
                        format = str9;
                    } else {
                        format = MessageFormat.format(string2, threadData.getAuthor().getName_show(), TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
                    }
                    z3 = z;
                } else if (!z) {
                    StringBuilder sb = new StringBuilder(TbadkCoreApplication.getInst().getString(R.string.voice_room_all_together));
                    if (threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().b)) {
                        z3 = z;
                        sb.insert(0, String.format(TbadkCoreApplication.getInst().getString(R.string.voice_room_forum), threadData.getForumData().b));
                    } else {
                        z3 = z;
                    }
                    format = sb.toString();
                } else {
                    z3 = z;
                    format = MessageFormat.format(string, str5, str9);
                }
                int j = jc5.j(threadData);
                String cutString = qi.cutString(str5, 100);
                String cutString2 = qi.cutString(format, 100);
                shareItem = new ShareItem();
                shareItem.v = cutString;
                shareItem.w = cutString2;
                if (!threadData.isUgcThreadType()) {
                    z4 = z2;
                    shareItem.W = -1L;
                    shareItem.H = cutString2;
                } else {
                    z4 = z2;
                    if (j == 2 && threadData.getThreadVideoInfo() != null) {
                        shareItem.W = threadData.getThreadVideoInfo().play_count.intValue();
                    } else if (j == 1) {
                        shareItem.W = threadData.getView_num();
                    }
                    shareItem.H = str9;
                }
                shareItem.x = str2;
                shareItem.u = str7;
                shareItem.N = str4;
                shareItem.t = str3;
                shareItem.O = str7;
                shareItem.f = true;
                shareItem.s = i;
                shareItem.I = e(i);
                shareItem.R = j;
                shareItem.J = 3;
                shareItem.K = d(threadData);
                if (parse != null) {
                    shareItem.z = parse;
                }
                if (!threadData.isUgcThreadType()) {
                    z5 = false;
                } else {
                    z5 = z4;
                }
                shareItem.v0 = z5;
                if (z5) {
                    shareItem.t0 = threadData.getShareImageUrl();
                }
                b(context, threadData);
                generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
                shareItem.a0 = generateShareInfo;
                if (StringUtils.isNull(generateShareInfo.showText, true)) {
                    if (StringUtils.isNull(threadData.getTitle(), true)) {
                        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                        if (originalThreadInfo != null) {
                            shareItem.a0.showText = originalThreadInfo.g;
                        }
                    } else {
                        shareItem.a0.showText = threadData.getTitle();
                    }
                }
                if (StringUtils.isNull(shareItem.a0.showText, true)) {
                    shareItem.a0.showText = TbadkCoreApplication.getInst().getString(R.string.original_thread_default_txt);
                }
                if (i2 != 13) {
                    shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(threadData, 2);
                } else {
                    shareItem.d0 = ShareItem.ForwardInfo.generateForwardInfo(threadData);
                }
                threadData2 = shareItem.a0.threadData;
                if (threadData2 != null && threadData2.getForumData() == null) {
                    k15 k15Var = new k15();
                    k15Var.j(threadData.getForum_name());
                    k15Var.a = String.valueOf(threadData.getFid());
                    k15Var.c = threadData.getForumAvatar();
                    shareItem.a0.threadData.setForumData(k15Var);
                }
                TbadkCoreApplication.getInst().setShareItem(shareItem);
                Bundle bundle = new Bundle();
                bundle.putInt("obj_param1", shareItem.J);
                bundle.putInt("obj_type", shareItem.R);
                bundle.putString("fid", shareItem.N);
                bundle.putString("tid", shareItem.O);
                bundle.putInt("obj_source", shareItem.s);
                if (shareItem.s == 11) {
                    bundle.putInt("source", 14);
                }
                if (shareItem.s == 12) {
                    bundle.putInt("source", 15);
                }
                shareItem.r(bundle);
                shareItem.I0 = jc5.i(threadData, j);
                shareItem.J0 = jc5.h(threadData, j, str3, shareItem.W, "", "");
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, shareItem, true, true);
                if (threadData.getThreadType() == 49 && threadData.getThreadType() != 60 && threadData.getThreadType() != 69) {
                    z6 = z3;
                    z7 = false;
                } else {
                    z6 = z3;
                    z7 = true;
                }
                shareDialogConfig.mIsVoiceRoom = z6;
                shareDialogConfig.setIsAlaLive(z7);
                a(shareDialogConfig, i2);
                bn6.c().l(shareDialogConfig);
            }
            z2 = true;
            if (threadData.getThreadAlaInfo() != null) {
                str2 = TbConfig.HTTPS_YY_LIVE_SHARE_PREFIX + threadData.getThreadAlaInfo().mYyExtData.mSid + "&livessid=" + threadData.getThreadAlaInfo().mYyExtData.mSsid + "&uid=" + threadData.getThreadAlaInfo().mYyExtData.mYyUid;
                z2 = false;
            }
            c = c(threadData);
            if (c != null) {
            }
            String str92 = threadData.getAbstract();
            String string3 = TbadkCoreApplication.getInst().getResources().getString(R.string.share_content_tpl);
            String string22 = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
            if (!threadData.isUgcThreadType()) {
            }
            if (!z) {
            }
            int j2 = jc5.j(threadData);
            String cutString3 = qi.cutString(str5, 100);
            String cutString22 = qi.cutString(format, 100);
            shareItem = new ShareItem();
            shareItem.v = cutString3;
            shareItem.w = cutString22;
            if (!threadData.isUgcThreadType()) {
            }
            shareItem.x = str2;
            shareItem.u = str7;
            shareItem.N = str4;
            shareItem.t = str3;
            shareItem.O = str7;
            shareItem.f = true;
            shareItem.s = i;
            shareItem.I = e(i);
            shareItem.R = j2;
            shareItem.J = 3;
            shareItem.K = d(threadData);
            if (parse != null) {
            }
            if (!threadData.isUgcThreadType()) {
            }
            shareItem.v0 = z5;
            if (z5) {
            }
            b(context, threadData);
            generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(threadData);
            shareItem.a0 = generateShareInfo;
            if (StringUtils.isNull(generateShareInfo.showText, true)) {
            }
            if (StringUtils.isNull(shareItem.a0.showText, true)) {
            }
            if (i2 != 13) {
            }
            threadData2 = shareItem.a0.threadData;
            if (threadData2 != null) {
                k15 k15Var2 = new k15();
                k15Var2.j(threadData.getForum_name());
                k15Var2.a = String.valueOf(threadData.getFid());
                k15Var2.c = threadData.getForumAvatar();
                shareItem.a0.threadData.setForumData(k15Var2);
            }
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("obj_param1", shareItem.J);
            bundle2.putInt("obj_type", shareItem.R);
            bundle2.putString("fid", shareItem.N);
            bundle2.putString("tid", shareItem.O);
            bundle2.putInt("obj_source", shareItem.s);
            if (shareItem.s == 11) {
            }
            if (shareItem.s == 12) {
            }
            shareItem.r(bundle2);
            shareItem.I0 = jc5.i(threadData, j2);
            shareItem.J0 = jc5.h(threadData, j2, str3, shareItem.W, "", "");
            ShareDialogConfig shareDialogConfig2 = new ShareDialogConfig(context, shareItem, true, true);
            if (threadData.getThreadType() == 49) {
            }
            z6 = z3;
            z7 = true;
            shareDialogConfig2.mIsVoiceRoom = z6;
            shareDialogConfig2.setIsAlaLive(z7);
            a(shareDialogConfig2, i2);
            bn6.c().l(shareDialogConfig2);
        }
    }
}
