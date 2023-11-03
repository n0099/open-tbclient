package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ForumTagInfo;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.data.ForumTabPic;
import com.baidu.tieba.forum.data.SortItem;
import com.baidu.tieba.forum.data.SubTabItem;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.FrsBottom;
import tbclient.FrsPage.NavTabInfo;
import tbclient.FrsPage.PrivateForumTotalInfo;
import tbclient.FrsPage.TagInfo;
import tbclient.FrsTabInfo;
import tbclient.ItemInfo;
import tbclient.RecomTagInfo;
import tbclient.SortButton;
import tbclient.TabMenu;
import tbclient.TabPic;
import tbclient.TabPicDesc;
import tbclient.ThemeColorInfo;
/* loaded from: classes8.dex */
public final class vh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final eh7 a(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            eh7 eh7Var = new eh7();
            eh7Var.r(dataRes);
            eh7Var.s(dataRes.forum);
            eh7Var.w(dataRes.hot_user_entry);
            eh7Var.B(dataRes.service_area);
            eh7Var.x(dataRes.live_fuse_forum);
            eh7Var.u(dataRes.frs_banner_header);
            eh7Var.A(dataRes.recreation_rank_info);
            eh7Var.C(dataRes.sign_activity_info);
            eh7Var.o(dataRes.activityhead);
            eh7Var.t(dataRes.frs_bottom);
            eh7Var.q(dataRes.business_promot);
            eh7Var.y(dataRes.private_forum_info);
            eh7Var.z(dataRes.bawutask_pop);
            eh7Var.E(dataRes.user);
            eh7Var.D(dataRes.sprite_bubble_guide);
            eh7Var.v(dataRes.frsmask_pop_info);
            eh7Var.p(dataRes.add_bawu_pop);
            return eh7Var;
        }
        return (eh7) invokeL.objValue;
    }

    public static final ForumTabPic c(TabPic tabPic) {
        InterceptResult invokeL;
        TabPicDesc tabPicDesc;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tabPic)) == null) {
            if (tabPic == null || (tabPicDesc = tabPic.dark) == null) {
                return null;
            }
            Integer num = tabPicDesc.pic_height;
            Intrinsics.checkNotNullExpressionValue(num, "dark.pic_height");
            if (num.intValue() <= 0) {
                return null;
            }
            Integer num2 = tabPic.dark.pic_width;
            Intrinsics.checkNotNullExpressionValue(num2, "dark.pic_width");
            if (num2.intValue() <= 0) {
                return null;
            }
            String str = tabPic.dark.selected_pic_url;
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            String str2 = tabPic.dark.unselected_pic_url;
            if ((str2 == null || str2.length() == 0) ? true : true) {
                return null;
            }
            String str3 = tabPic.dark.selected_pic_url;
            Intrinsics.checkNotNullExpressionValue(str3, "dark.selected_pic_url");
            String str4 = tabPic.dark.unselected_pic_url;
            Intrinsics.checkNotNullExpressionValue(str4, "dark.unselected_pic_url");
            Integer num3 = tabPic.dark.pic_height;
            Intrinsics.checkNotNullExpressionValue(num3, "dark.pic_height");
            int intValue = num3.intValue();
            Integer num4 = tabPic.dark.pic_width;
            Intrinsics.checkNotNullExpressionValue(num4, "dark.pic_width");
            return new ForumTabPic(str3, str4, intValue, num4.intValue());
        }
        return (ForumTabPic) invokeL.objValue;
    }

    public static final ForumTabPic e(TabPic tabPic) {
        InterceptResult invokeL;
        TabPicDesc tabPicDesc;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tabPic)) == null) {
            if (tabPic == null || (tabPicDesc = tabPic.normal) == null) {
                return null;
            }
            Integer num = tabPicDesc.pic_height;
            Intrinsics.checkNotNullExpressionValue(num, "normal.pic_height");
            if (num.intValue() <= 0) {
                return null;
            }
            Integer num2 = tabPic.normal.pic_width;
            Intrinsics.checkNotNullExpressionValue(num2, "normal.pic_width");
            if (num2.intValue() <= 0) {
                return null;
            }
            String str = tabPic.normal.selected_pic_url;
            boolean z2 = false;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            String str2 = tabPic.normal.unselected_pic_url;
            if ((str2 == null || str2.length() == 0) ? true : true) {
                return null;
            }
            String str3 = tabPic.normal.selected_pic_url;
            Intrinsics.checkNotNullExpressionValue(str3, "normal.selected_pic_url");
            String str4 = tabPic.normal.unselected_pic_url;
            Intrinsics.checkNotNullExpressionValue(str4, "normal.unselected_pic_url");
            Integer num3 = tabPic.normal.pic_height;
            Intrinsics.checkNotNullExpressionValue(num3, "normal.pic_height");
            int intValue = num3.intValue();
            Integer num4 = tabPic.normal.pic_width;
            Intrinsics.checkNotNullExpressionValue(num4, "normal.pic_width");
            return new ForumTabPic(str3, str4, intValue, num4.intValue());
        }
        return (ForumTabPic) invokeL.objValue;
    }

    public static final gh7 b(DataRes dataRes) {
        InterceptResult invokeL;
        Long l;
        long longValue;
        String str;
        String str2;
        Integer num;
        int intValue;
        Integer num2;
        int intValue2;
        Integer num3;
        int intValue3;
        String str3;
        TagInfo tagInfo;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            gh7 gh7Var = new gh7(0L, null, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, 0, 131071, null);
            ForumInfo forumInfo = dataRes.forum;
            ThemeColorInfo themeColorInfo = null;
            if (forumInfo != null) {
                l = forumInfo.id;
            } else {
                l = null;
            }
            if (l == null) {
                longValue = 0;
            } else {
                longValue = l.longValue();
            }
            gh7Var.t(longValue);
            ForumInfo forumInfo2 = dataRes.forum;
            if (forumInfo2 != null) {
                str = forumInfo2.name;
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            gh7Var.u(str);
            ForumInfo forumInfo3 = dataRes.forum;
            if (forumInfo3 != null) {
                str2 = forumInfo3.avatar;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            gh7Var.s(str2);
            gh7Var.k().clear();
            List<FrsTabInfo> list = dataRes.frs_main_tab_list;
            if (list != null) {
                for (FrsTabInfo it : list) {
                    List<ForumTabItem> k = gh7Var.k();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    k.add(d(it));
                }
            }
            Integer frs_tab_default = dataRes.frs_tab_default;
            Intrinsics.checkNotNullExpressionValue(frs_tab_default, "frs_tab_default");
            gh7Var.q(frs_tab_default.intValue());
            gh7Var.w(dataRes.frs_common_info);
            ForumInfo forumInfo4 = dataRes.forum;
            if (forumInfo4 != null) {
                num = forumInfo4.msg_bubble_guide_frequency;
            } else {
                num = null;
            }
            int i = 0;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            gh7Var.y(intValue);
            ForumInfo forumInfo5 = dataRes.forum;
            if (forumInfo5 != null) {
                num2 = forumInfo5.msg_bubble_guide_frequency_unread;
            } else {
                num2 = null;
            }
            if (num2 == null) {
                intValue2 = 0;
            } else {
                intValue2 = num2.intValue();
            }
            gh7Var.D(intValue2);
            ForumInfo forumInfo6 = dataRes.forum;
            if (forumInfo6 != null) {
                num3 = forumInfo6.msg_bubble_guide_frequency_special;
            } else {
                num3 = null;
            }
            if (num3 == null) {
                intValue3 = 0;
            } else {
                intValue3 = num3.intValue();
            }
            gh7Var.A(intValue3);
            FrsBottom frsBottom = dataRes.frs_bottom;
            if (frsBottom != null && (frsBottomSmartBgColor = frsBottom.frs_smart_bg_color) != null) {
                str3 = frsBottomSmartBgColor.theme_color;
            } else {
                str3 = null;
            }
            if (str3 != null) {
                str4 = str3;
            }
            gh7Var.B(str4);
            Integer num4 = dataRes.is_member_broadcast_forum;
            if (num4 != null) {
                i = num4.intValue();
            }
            gh7Var.x(i);
            gh7Var.z(f(dataRes));
            ForumInfo forumInfo7 = dataRes.forum;
            if (forumInfo7 != null) {
                themeColorInfo = forumInfo7.theme_color;
            }
            gh7Var.C(themeColorInfo);
            gh7Var.E(g(dataRes));
            ForumInfo forumInfo8 = dataRes.forum;
            if (forumInfo8 != null && (tagInfo = forumInfo8.tag_info) != null) {
                String str5 = tagInfo.first_category;
                Intrinsics.checkNotNullExpressionValue(str5, "it.first_category");
                gh7Var.r(str5);
                if (tagInfo.recom_tag != null) {
                    ForumTagInfo forumTagInfo = new ForumTagInfo();
                    forumTagInfo.id = String.valueOf(tagInfo.recom_tag.id);
                    RecomTagInfo recomTagInfo = tagInfo.recom_tag;
                    forumTagInfo.name = recomTagInfo.name;
                    forumTagInfo.pic = recomTagInfo.pic;
                    gh7Var.v(forumTagInfo);
                }
            }
            return gh7Var;
        }
        return (gh7) invokeL.objValue;
    }

    public static final oh7 h(DataRes dataRes) {
        InterceptResult invokeL;
        String str;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        RecomTagInfo recom_tag;
        Integer num;
        Integer num2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            ActivityConfig activityConfig = dataRes.activity_config;
            ItemInfo itemInfo = dataRes.item_info;
            ForumData forumData = new ForumData();
            forumData.parserProtobuf(dataRes.forum);
            UserData userData = new UserData();
            userData.parserProtobuf(dataRes.user);
            String id = forumData.getId();
            String name = forumData.getName();
            PostPrefixData prefixData = forumData.getPrefixData();
            AntiData antiData = new AntiData();
            antiData.parserProtobuf(dataRes.anti);
            Unit unit = Unit.INSTANCE;
            ForumWriteData forumWriteData = new ForumWriteData(id, name, prefixData, antiData);
            forumWriteData.avatar = forumData.getImage_url();
            forumWriteData.forumLevel = forumData.getUser_level();
            forumWriteData.specialForumType = forumData.special_forum_type;
            forumWriteData.firstDir = forumData.getFirst_class();
            forumWriteData.secondDir = forumData.getSecond_class();
            forumWriteData.privateThread = userData.getPrivateThread();
            mqa mqaVar = new mqa();
            NavTabInfo navTabInfo = dataRes.nav_tab_info;
            if (navTabInfo == null) {
                NavTabInfo.Builder builder = new NavTabInfo.Builder();
                builder.tab = dataRes.frs_tab_info;
                mqaVar.a(builder.build(true));
            } else {
                mqaVar.a(navTabInfo);
            }
            int i = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : mqaVar.a) {
                if (frsTabInfo != null && (num = frsTabInfo.is_general_tab) != null && num.intValue() == 1 && ((num2 = frsTabInfo.tab_type) == null || num2.intValue() != 100)) {
                    Integer num3 = frsTabInfo.tab_id;
                    if (num3 == null || num3.intValue() != 505 || !userData.isForumBusinessAccount()) {
                        arrayList.add(new FrsTabItemData(frsTabInfo));
                        Integer num4 = frsTabInfo.tab_id;
                        if (num4 != null && num4.intValue() == 0) {
                            i = 0;
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
                frsTabInfoData.tabList = arrayList;
                frsTabInfoData.selectedTabId = i;
                frsTabInfoData.isForumBusinessAccount = userData.isForumBusinessAccount();
                forumWriteData.frsTabInfo = frsTabInfoData;
            }
            ForumInfo forumInfo = dataRes.forum;
            if (forumInfo != null && (tagInfo2 = forumInfo.tag_info) != null && (recom_tag = tagInfo2.recom_tag) != null) {
                Intrinsics.checkNotNullExpressionValue(recom_tag, "recom_tag");
                ForumTagInfo forumTagInfo = new ForumTagInfo();
                forumWriteData.forumTagInfo = forumTagInfo;
                forumTagInfo.id = String.valueOf(recom_tag.id);
                ForumTagInfo forumTagInfo2 = forumWriteData.forumTagInfo;
                forumTagInfo2.name = recom_tag.name;
                forumTagInfo2.pic = recom_tag.pic;
            }
            ForumInfo forumInfo2 = dataRes.forum;
            if (forumInfo2 != null && (tagInfo = forumInfo2.tag_info) != null) {
                str = tagInfo.first_category;
            } else {
                str = null;
            }
            forumWriteData.firstCategory = str;
            return new oh7(forumWriteData, activityConfig, itemInfo);
        }
        return (oh7) invokeL.objValue;
    }

    public static final ForumTabItem d(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        ForumTabPic forumTabPic;
        ForumTabPic forumTabPic2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, frsTabInfo)) == null) {
            ArrayList arrayList = new ArrayList();
            List<SortButton> list = frsTabInfo.sort_menu;
            if (list != null) {
                for (SortButton sortButton : list) {
                    Integer num = sortButton.source_id;
                    Intrinsics.checkNotNullExpressionValue(num, "sortButton.source_id");
                    int intValue = num.intValue();
                    String str = sortButton.text;
                    Intrinsics.checkNotNullExpressionValue(str, "sortButton.text");
                    arrayList.add(new SortItem(intValue, str));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            List<TabMenu> list2 = frsTabInfo.sub_tab_list;
            if (list2 != null) {
                for (TabMenu tabMenu : list2) {
                    Integer num2 = tabMenu.class_id;
                    Intrinsics.checkNotNullExpressionValue(num2, "tabMenu.class_id");
                    int intValue2 = num2.intValue();
                    String str2 = tabMenu.class_name;
                    Intrinsics.checkNotNullExpressionValue(str2, "tabMenu.class_name");
                    arrayList2.add(new SubTabItem(intValue2, str2));
                }
            }
            Integer tab_id = frsTabInfo.tab_id;
            Intrinsics.checkNotNullExpressionValue(tab_id, "tab_id");
            int intValue3 = tab_id.intValue();
            String tab_name = frsTabInfo.tab_name;
            Intrinsics.checkNotNullExpressionValue(tab_name, "tab_name");
            Integer tab_type = frsTabInfo.tab_type;
            Intrinsics.checkNotNullExpressionValue(tab_type, "tab_type");
            int intValue4 = tab_type.intValue();
            String str3 = frsTabInfo.tab_url;
            Integer net_tab_type = frsTabInfo.net_tab_type;
            Intrinsics.checkNotNullExpressionValue(net_tab_type, "net_tab_type");
            int intValue5 = net_tab_type.intValue();
            Integer num3 = frsTabInfo.is_general_tab;
            boolean z = true;
            z = (num3 == null || num3.intValue() != 1) ? false : false;
            TabPic tabPic = frsTabInfo.head_pics;
            if (tabPic != null) {
                forumTabPic = e(tabPic);
            } else {
                forumTabPic = null;
            }
            TabPic tabPic2 = frsTabInfo.head_pics;
            if (tabPic2 != null) {
                forumTabPic2 = c(tabPic2);
            } else {
                forumTabPic2 = null;
            }
            return new ForumTabItem(intValue3, tab_name, intValue4, str3, intValue5, arrayList, arrayList2, z, forumTabPic, forumTabPic2);
        }
        return (ForumTabItem) invokeL.objValue;
    }

    public static final nh7 f(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            PrivateForumTotalInfo privateForumTotalInfo = dataRes.private_forum_info;
            if (privateForumTotalInfo != null) {
                return new nh7(privateForumTotalInfo.private_forum_shareinfo, privateForumTotalInfo.private_forum_popinfo, privateForumTotalInfo.private_forum_info, privateForumTotalInfo.private_forum_taskpercent);
            }
            return null;
        }
        return (nh7) invokeL.objValue;
    }

    public static final UserData g(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            if (dataRes.user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(dataRes.user);
                return userData;
            }
            return null;
        }
        return (UserData) invokeL.objValue;
    }
}
