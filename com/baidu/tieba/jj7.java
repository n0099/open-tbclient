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
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AiChatBotInfo;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.ActivityConfig;
import tbclient.FrsPage.AiChatroomGuide;
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
/* loaded from: classes6.dex */
public final class jj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final mi7 a(AiChatBotInfo aiChatBotInfo) {
        InterceptResult invokeL;
        String str;
        long longValue;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aiChatBotInfo)) == null) {
            Intrinsics.checkNotNullParameter(aiChatBotInfo, "<this>");
            String str4 = aiChatBotInfo.uk;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            Long l = aiChatBotInfo.pa;
            if (l == null) {
                longValue = 0;
            } else {
                longValue = l.longValue();
            }
            String str5 = aiChatBotInfo.name;
            if (str5 == null) {
                str2 = "";
            } else {
                str2 = str5;
            }
            String str6 = aiChatBotInfo.portrait;
            if (str6 == null) {
                str3 = "";
            } else {
                str3 = str6;
            }
            String str7 = aiChatBotInfo.background_url;
            if (str7 == null) {
                str7 = "";
            }
            return new mi7(str, longValue, str2, str3, str7);
        }
        return (mi7) invokeL.objValue;
    }

    public static final ni7 b(DataRes dataRes) {
        InterceptResult invokeL;
        zi7 zi7Var;
        mi7 mi7Var;
        String l;
        String str;
        String str2;
        String str3;
        long longValue;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            AiChatroomGuide aiChatroomGuide = dataRes.ai_chatroom_guide;
            Long l2 = null;
            if (aiChatroomGuide == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<AiChatBotInfo> list = aiChatroomGuide.bot_list;
            Intrinsics.checkNotNullExpressionValue(list, "it.bot_list");
            List<AiChatBotInfo> take = CollectionsKt___CollectionsKt.take(list, 3);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10));
            for (AiChatBotInfo aiChatBotInfo : take) {
                arrayList2.add(aiChatBotInfo.portrait);
            }
            arrayList.addAll(arrayList2);
            String str6 = aiChatroomGuide.guide_text;
            String str7 = "";
            if (str6 == null) {
                str6 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str6, "it.guide_text ?: \"\"");
            }
            qi7 qi7Var = new qi7(arrayList, str6);
            AiChatBotInfo aiChatBotInfo2 = aiChatroomGuide.new_bot_info;
            if (aiChatBotInfo2 != null) {
                String str8 = aiChatBotInfo2.portrait;
                if (str8 == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str8, "it.new_bot_info.portrait ?: \"\"");
                    str = str8;
                }
                String str9 = aiChatroomGuide.new_bot_info.uk;
                if (str9 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str9, "it.new_bot_info.uk ?: \"\"");
                    str2 = str9;
                }
                String str10 = aiChatroomGuide.new_bot_info.name;
                if (str10 == null) {
                    str3 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str10, "it.new_bot_info.name ?: \"\"");
                    str3 = str10;
                }
                Long l3 = aiChatroomGuide.new_bot_info.pa;
                if (l3 == null) {
                    longValue = 0;
                } else {
                    Intrinsics.checkNotNullExpressionValue(l3, "it.new_bot_info.pa ?: 0");
                    longValue = l3.longValue();
                }
                String str11 = aiChatroomGuide.new_bot_info.background_url;
                if (str11 == null) {
                    str4 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str11, "it.new_bot_info.background_url ?: \"\"");
                    str4 = str11;
                }
                String str12 = aiChatroomGuide.new_bot_guide_text;
                if (str12 == null) {
                    str5 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str12, "it.new_bot_guide_text ?: \"\"");
                    str5 = str12;
                }
                zi7Var = new zi7(str, str2, str3, longValue, str4, str5);
            } else {
                zi7Var = null;
            }
            ArrayList arrayList3 = new ArrayList();
            List<AiChatBotInfo> bot_list = aiChatroomGuide.bot_list;
            if (bot_list != null) {
                Intrinsics.checkNotNullExpressionValue(bot_list, "bot_list");
                for (AiChatBotInfo bot : bot_list) {
                    Intrinsics.checkNotNullExpressionValue(bot, "bot");
                    arrayList3.add(a(bot));
                }
            }
            AiChatBotInfo default_bot_info = aiChatroomGuide.default_bot_info;
            if (default_bot_info != null) {
                Intrinsics.checkNotNullExpressionValue(default_bot_info, "default_bot_info");
                mi7Var = a(default_bot_info);
            } else {
                mi7Var = null;
            }
            ForumInfo forumInfo = dataRes.forum;
            if (forumInfo != null) {
                l2 = forumInfo.id;
            }
            String str13 = aiChatroomGuide.title_img;
            Intrinsics.checkNotNullExpressionValue(str13, "it.title_img");
            ni7 ni7Var = new ni7(qi7Var, zi7Var, arrayList3, mi7Var, str13, aiChatroomGuide.button_url, aiChatroomGuide.bg_top_animation_url, aiChatroomGuide.h5_url);
            if (l2 != null && (l = l2.toString()) != null) {
                str7 = l;
            }
            ni7Var.f(str7);
            return ni7Var;
        }
        return (ni7) invokeL.objValue;
    }

    public static final ForumTabItem f(FrsTabInfo frsTabInfo) {
        InterceptResult invokeL;
        ForumTabPic forumTabPic;
        ForumTabPic forumTabPic2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, frsTabInfo)) == null) {
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
                forumTabPic = g(tabPic);
            } else {
                forumTabPic = null;
            }
            TabPic tabPic2 = frsTabInfo.head_pics;
            if (tabPic2 != null) {
                forumTabPic2 = e(tabPic2);
            } else {
                forumTabPic2 = null;
            }
            return new ForumTabItem(intValue3, tab_name, intValue4, str3, intValue5, arrayList, arrayList2, z, forumTabPic, forumTabPic2);
        }
        return (ForumTabItem) invokeL.objValue;
    }

    public static final pi7 c(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            pi7 pi7Var = new pi7();
            pi7Var.n(dataRes);
            pi7Var.o(dataRes.forum);
            pi7Var.s(dataRes.hot_user_entry);
            pi7Var.x(dataRes.service_area);
            pi7Var.t(dataRes.live_fuse_forum);
            pi7Var.q(dataRes.frs_banner_header);
            pi7Var.w(dataRes.recreation_rank_info);
            pi7Var.y(dataRes.sign_activity_info);
            pi7Var.k(dataRes.activityhead);
            pi7Var.p(dataRes.frs_bottom);
            pi7Var.m(dataRes.business_promot);
            pi7Var.u(dataRes.private_forum_info);
            pi7Var.v(dataRes.bawutask_pop);
            pi7Var.A(dataRes.user);
            pi7Var.z(dataRes.sprite_bubble_guide);
            pi7Var.r(dataRes.frsmask_pop_info);
            pi7Var.l(dataRes.add_bawu_pop);
            return pi7Var;
        }
        return (pi7) invokeL.objValue;
    }

    public static final ForumTabPic e(TabPic tabPic) {
        InterceptResult invokeL;
        TabPicDesc tabPicDesc;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tabPic)) == null) {
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

    public static final ForumTabPic g(TabPic tabPic) {
        InterceptResult invokeL;
        TabPicDesc tabPicDesc;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, tabPic)) == null) {
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

    public static final si7 d(DataRes dataRes) {
        InterceptResult invokeL;
        Long l;
        long longValue;
        String str;
        String str2;
        String str3;
        Integer num;
        int intValue;
        Integer num2;
        int intValue2;
        Integer num3;
        int intValue3;
        String str4;
        TagInfo tagInfo;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            si7 si7Var = new si7(0L, null, null, null, null, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, 0, null, 524287, null);
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
            si7Var.z(longValue);
            ForumInfo forumInfo2 = dataRes.forum;
            if (forumInfo2 != null) {
                str = forumInfo2.name;
            } else {
                str = null;
            }
            String str5 = "";
            if (str == null) {
                str = "";
            }
            si7Var.A(str);
            ForumInfo forumInfo3 = dataRes.forum;
            if (forumInfo3 != null) {
                str2 = forumInfo3.avatar;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            si7Var.y(str2);
            ForumInfo forumInfo4 = dataRes.forum;
            if (forumInfo4 != null) {
                str3 = forumInfo4.slogan;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            si7Var.B(str3);
            si7Var.o().clear();
            List<FrsTabInfo> list = dataRes.frs_main_tab_list;
            if (list != null) {
                for (FrsTabInfo it : list) {
                    List<ForumTabItem> o = si7Var.o();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    o.add(f(it));
                }
            }
            Integer frs_tab_default = dataRes.frs_tab_default;
            Intrinsics.checkNotNullExpressionValue(frs_tab_default, "frs_tab_default");
            si7Var.v(frs_tab_default.intValue());
            si7Var.D(dataRes.frs_common_info);
            ForumInfo forumInfo5 = dataRes.forum;
            if (forumInfo5 != null) {
                num = forumInfo5.msg_bubble_guide_frequency;
            } else {
                num = null;
            }
            int i = 0;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            si7Var.F(intValue);
            ForumInfo forumInfo6 = dataRes.forum;
            if (forumInfo6 != null) {
                num2 = forumInfo6.msg_bubble_guide_frequency_unread;
            } else {
                num2 = null;
            }
            if (num2 == null) {
                intValue2 = 0;
            } else {
                intValue2 = num2.intValue();
            }
            si7Var.L(intValue2);
            ForumInfo forumInfo7 = dataRes.forum;
            if (forumInfo7 != null) {
                num3 = forumInfo7.msg_bubble_guide_frequency_special;
            } else {
                num3 = null;
            }
            if (num3 == null) {
                intValue3 = 0;
            } else {
                intValue3 = num3.intValue();
            }
            si7Var.I(intValue3);
            FrsBottom frsBottom = dataRes.frs_bottom;
            if (frsBottom != null && (frsBottomSmartBgColor = frsBottom.frs_smart_bg_color) != null) {
                str4 = frsBottomSmartBgColor.theme_color;
            } else {
                str4 = null;
            }
            if (str4 != null) {
                str5 = str4;
            }
            si7Var.J(str5);
            Integer num4 = dataRes.is_member_broadcast_forum;
            if (num4 != null) {
                i = num4.intValue();
            }
            si7Var.E(i);
            si7Var.G(h(dataRes));
            si7Var.u(b(dataRes));
            ForumInfo forumInfo8 = dataRes.forum;
            if (forumInfo8 != null) {
                themeColorInfo = forumInfo8.theme_color;
            }
            si7Var.K(themeColorInfo);
            si7Var.M(i(dataRes));
            ForumInfo forumInfo9 = dataRes.forum;
            if (forumInfo9 != null && (tagInfo = forumInfo9.tag_info) != null) {
                String str6 = tagInfo.first_category;
                Intrinsics.checkNotNullExpressionValue(str6, "it.first_category");
                si7Var.w(str6);
                if (tagInfo.recom_tag != null) {
                    ForumTagInfo forumTagInfo = new ForumTagInfo();
                    forumTagInfo.id = String.valueOf(tagInfo.recom_tag.id);
                    RecomTagInfo recomTagInfo = tagInfo.recom_tag;
                    forumTagInfo.name = recomTagInfo.name;
                    forumTagInfo.pic = recomTagInfo.pic;
                    si7Var.C(forumTagInfo);
                }
            }
            String str7 = dataRes.forum.first_class;
            Intrinsics.checkNotNullExpressionValue(str7, "forum.first_class");
            si7Var.x(str7);
            String str8 = dataRes.forum.second_class;
            Intrinsics.checkNotNullExpressionValue(str8, "forum.second_class");
            si7Var.H(str8);
            return si7Var;
        }
        return (si7) invokeL.objValue;
    }

    public static final cj7 j(DataRes dataRes) {
        InterceptResult invokeL;
        String str;
        TagInfo tagInfo;
        TagInfo tagInfo2;
        RecomTagInfo recom_tag;
        Integer num;
        Integer num2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, dataRes)) == null) {
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
            gva gvaVar = new gva();
            NavTabInfo navTabInfo = dataRes.nav_tab_info;
            if (navTabInfo == null) {
                NavTabInfo.Builder builder = new NavTabInfo.Builder();
                builder.tab = dataRes.frs_tab_info;
                gvaVar.a(builder.build(true));
            } else {
                gvaVar.a(navTabInfo);
            }
            int i = -1;
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : gvaVar.a) {
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
            return new cj7(forumWriteData, activityConfig, itemInfo);
        }
        return (cj7) invokeL.objValue;
    }

    public static final aj7 h(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, dataRes)) == null) {
            Intrinsics.checkNotNullParameter(dataRes, "<this>");
            PrivateForumTotalInfo privateForumTotalInfo = dataRes.private_forum_info;
            if (privateForumTotalInfo != null) {
                return new aj7(privateForumTotalInfo.private_forum_shareinfo, privateForumTotalInfo.private_forum_popinfo, privateForumTotalInfo.private_forum_info, privateForumTotalInfo.private_forum_taskpercent);
            }
            return null;
        }
        return (aj7) invokeL.objValue;
    }

    public static final UserData i(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, dataRes)) == null) {
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
